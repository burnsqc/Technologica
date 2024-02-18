package com.technologica.world.entity.animal;

import javax.annotation.Nullable;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.util.Mth;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.AgeableMob;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityDimensions;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.Pose;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.BreedGoal;
import net.minecraft.world.entity.ai.goal.FloatGoal;
import net.minecraft.world.entity.ai.goal.LeapAtTargetGoal;
import net.minecraft.world.entity.ai.goal.LookAtPlayerGoal;
import net.minecraft.world.entity.ai.goal.OcelotAttackGoal;
import net.minecraft.world.entity.ai.goal.PanicGoal;
import net.minecraft.world.entity.ai.goal.TemptGoal;
import net.minecraft.world.entity.ai.goal.WaterAvoidingRandomStrollGoal;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.animal.CatVariant;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.Level;

public class Jaguar extends Animal {
	public static final double TEMPT_SPEED_MOD = 0.6D;
	public static final double WALK_SPEED_MOD = 0.8D;
	public static final double SPRINT_SPEED_MOD = 1.33D;
	private static final Ingredient TEMPT_INGREDIENT = Ingredient.of(Items.COD, Items.SALMON);
	private static final EntityDataAccessor<CatVariant> DATA_VARIANT_ID = SynchedEntityData.defineId(Jaguar.class, EntityDataSerializers.CAT_VARIANT);
	private static final EntityDataAccessor<Boolean> IS_LYING = SynchedEntityData.defineId(Jaguar.class, EntityDataSerializers.BOOLEAN);
	private static final EntityDataAccessor<Boolean> RELAX_STATE_ONE = SynchedEntityData.defineId(Jaguar.class, EntityDataSerializers.BOOLEAN);
	private static final EntityDataAccessor<Integer> DATA_COLLAR_COLOR = SynchedEntityData.defineId(Jaguar.class, EntityDataSerializers.INT);
	public int earCounter;
	@Nullable
	private TemptGoal temptGoal;
	private float lieDownAmount;
	private float lieDownAmountO;
	private float lieDownAmountTail;
	private float lieDownAmountOTail;
	private float relaxStateOneAmount;
	private float relaxStateOneAmountO;

	public Jaguar(EntityType<? extends Jaguar> p_28114_, Level p_28115_) {
		super(p_28114_, p_28115_);
	}

	@Override
	protected void registerGoals() {
		this.goalSelector.addGoal(1, new FloatGoal(this));
		this.goalSelector.addGoal(1, new PanicGoal(this, 1.5D));
		this.goalSelector.addGoal(8, new LeapAtTargetGoal(this, 0.3F));
		this.goalSelector.addGoal(9, new OcelotAttackGoal(this));
		this.goalSelector.addGoal(10, new BreedGoal(this, 0.8D));
		this.goalSelector.addGoal(11, new WaterAvoidingRandomStrollGoal(this, 0.8D, 1.0000001E-5F));
		this.goalSelector.addGoal(12, new LookAtPlayerGoal(this, Player.class, 10.0F));
	}

	public void setLying(boolean p_28182_) {
		this.entityData.set(IS_LYING, p_28182_);
	}

	public boolean isLying() {
		return this.entityData.get(IS_LYING);
	}

	public void setRelaxStateOne(boolean p_28186_) {
		this.entityData.set(RELAX_STATE_ONE, p_28186_);
	}

	public boolean isRelaxStateOne() {
		return this.entityData.get(RELAX_STATE_ONE);
	}

	public DyeColor getCollarColor() {
		return DyeColor.byId(this.entityData.get(DATA_COLLAR_COLOR));
	}

	public void setCollarColor(DyeColor p_28132_) {
		this.entityData.set(DATA_COLLAR_COLOR, p_28132_.getId());
	}

	@Override
	protected void defineSynchedData() {
		super.defineSynchedData();
		this.entityData.define(DATA_VARIANT_ID, BuiltInRegistries.CAT_VARIANT.getOrThrow(CatVariant.BLACK));
		this.entityData.define(IS_LYING, false);
		this.entityData.define(RELAX_STATE_ONE, false);
		this.entityData.define(DATA_COLLAR_COLOR, DyeColor.RED.getId());
	}

	@Override
	public void customServerAiStep() {
		if (this.getMoveControl().hasWanted()) {
			double d0 = this.getMoveControl().getSpeedModifier();
			if (d0 == 0.6D) {
				this.setPose(Pose.CROUCHING);
				this.setSprinting(false);
			} else if (d0 == 1.33D) {
				this.setPose(Pose.STANDING);
				this.setSprinting(true);
			} else {
				this.setPose(Pose.STANDING);
				this.setSprinting(false);
			}
		} else {
			this.setPose(Pose.STANDING);
			this.setSprinting(false);
		}
	}

	@Override
	public void aiStep() {
		super.aiStep();
		if (this.random.nextInt(200) == 1) {
			this.moveEars();
		}
	}

	private void moveEars() {
		this.earCounter = 1;
	}

	@Override
	@Nullable
	protected SoundEvent getAmbientSound() {
		return SoundEvents.CAT_STRAY_AMBIENT;
	}

	@Override
	public int getAmbientSoundInterval() {
		return 120;
	}

	public void hiss() {
		this.playSound(SoundEvents.CAT_HISS, this.getSoundVolume(), this.getVoicePitch());
	}

	@Override
	protected SoundEvent getHurtSound(DamageSource p_28160_) {
		return SoundEvents.CAT_HURT;
	}

	@Override
	protected SoundEvent getDeathSound() {
		return SoundEvents.CAT_DEATH;
	}

	public static AttributeSupplier.Builder createAttributes() {
		return Mob.createMobAttributes().add(Attributes.MAX_HEALTH, 10.0D).add(Attributes.MOVEMENT_SPEED, 0.3F).add(Attributes.ATTACK_DAMAGE, 3.0D);
	}

	@Override
	protected void usePlayerItem(Player p_148866_, InteractionHand p_148867_, ItemStack p_148868_) {
		if (this.isFood(p_148868_)) {
			this.playSound(SoundEvents.CAT_EAT, 1.0F, 1.0F);
		}

		super.usePlayerItem(p_148866_, p_148867_, p_148868_);
	}

	private float getAttackDamage() {
		return (float) this.getAttributeValue(Attributes.ATTACK_DAMAGE);
	}

	@Override
	public boolean doHurtTarget(Entity p_28119_) {
		return p_28119_.hurt(this.damageSources().mobAttack(this), this.getAttackDamage());
	}

	@Override
	public void tick() {
		super.tick();
		if (this.temptGoal != null && this.temptGoal.isRunning() && this.tickCount % 100 == 0) {
			this.playSound(SoundEvents.CAT_BEG_FOR_FOOD, 1.0F, 1.0F);
		}
		if (this.earCounter > 0 && ++this.earCounter > 8) {
			this.earCounter = 0;
		}

		this.handleLieDown();
	}

	private void handleLieDown() {
		if ((this.isLying() || this.isRelaxStateOne()) && this.tickCount % 5 == 0) {
			this.playSound(SoundEvents.CAT_PURR, 0.6F + 0.4F * (this.random.nextFloat() - this.random.nextFloat()), 1.0F);
		}

		this.updateLieDownAmount();
		this.updateRelaxStateOneAmount();
	}

	private void updateLieDownAmount() {
		this.lieDownAmountO = this.lieDownAmount;
		this.lieDownAmountOTail = this.lieDownAmountTail;
		if (this.isLying()) {
			this.lieDownAmount = Math.min(1.0F, this.lieDownAmount + 0.15F);
			this.lieDownAmountTail = Math.min(1.0F, this.lieDownAmountTail + 0.08F);
		} else {
			this.lieDownAmount = Math.max(0.0F, this.lieDownAmount - 0.22F);
			this.lieDownAmountTail = Math.max(0.0F, this.lieDownAmountTail - 0.13F);
		}

	}

	private void updateRelaxStateOneAmount() {
		this.relaxStateOneAmountO = this.relaxStateOneAmount;
		if (this.isRelaxStateOne()) {
			this.relaxStateOneAmount = Math.min(1.0F, this.relaxStateOneAmount + 0.1F);
		} else {
			this.relaxStateOneAmount = Math.max(0.0F, this.relaxStateOneAmount - 0.13F);
		}

	}

	public float getLieDownAmount(float p_28184_) {
		return Mth.lerp(p_28184_, this.lieDownAmountO, this.lieDownAmount);
	}

	public float getLieDownAmountTail(float p_28188_) {
		return Mth.lerp(p_28188_, this.lieDownAmountOTail, this.lieDownAmountTail);
	}

	public float getRelaxStateOneAmount(float p_28117_) {
		return Mth.lerp(p_28117_, this.relaxStateOneAmountO, this.relaxStateOneAmount);
	}

	@Override
	public boolean isFood(ItemStack p_28177_) {
		return TEMPT_INGREDIENT.test(p_28177_);
	}

	@Override
	protected float getStandingEyeHeight(Pose p_28150_, EntityDimensions p_28151_) {
		return p_28151_.height * 0.5F;
	}

	@Override
	public boolean isSteppingCarefully() {
		return this.isCrouching() || super.isSteppingCarefully();
	}

	@Override
	public AgeableMob getBreedOffspring(ServerLevel p_146743_, AgeableMob p_146744_) {
		return null;
	}
}
