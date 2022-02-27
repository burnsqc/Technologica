package com.technologica.world.entity.animal;

import java.util.Objects;
import java.util.Optional;
import java.util.Random;
import java.util.UUID;
import java.util.function.Predicate;

import javax.annotation.Nullable;

import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.resources.ResourceKey;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.tags.FluidTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.util.Mth;
import net.minecraft.util.TimeUtil;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityDimensions;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.MoverType;
import net.minecraft.world.entity.NeutralMob;
import net.minecraft.world.entity.Pose;
import net.minecraft.world.entity.SpawnGroupData;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.control.SmoothSwimmingLookControl;
import net.minecraft.world.entity.ai.control.SmoothSwimmingMoveControl;
import net.minecraft.world.entity.ai.goal.FollowBoatGoal;
import net.minecraft.world.entity.ai.goal.LookAtPlayerGoal;
import net.minecraft.world.entity.ai.goal.RandomLookAroundGoal;
import net.minecraft.world.entity.ai.goal.RandomSwimmingGoal;
import net.minecraft.world.entity.ai.goal.TryFindWaterGoal;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.ai.navigation.PathNavigation;
import net.minecraft.world.entity.ai.navigation.WaterBoundPathNavigation;
import net.minecraft.world.entity.animal.TropicalFish;
import net.minecraft.world.entity.animal.WaterAnimal;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.monster.Guardian;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.Biomes;
import net.minecraft.world.phys.Vec3;

public class Shark extends WaterAnimal implements NeutralMob {
	private static final EntityDataAccessor<Integer> MOISTNESS = SynchedEntityData.defineId(Shark.class, EntityDataSerializers.INT);
	public static final Predicate<ItemEntity> ITEM_SELECTOR = p_205023_0_ -> !p_205023_0_.hasPickUpDelay() && p_205023_0_.isAlive() && p_205023_0_.isInWater();
	private static final UniformInt PERSISTENT_ANGER_TIME = TimeUtil.rangeOfSeconds(20, 39);
	private int angerTime;
	private UUID angerTarget;

	public Shark(EntityType<? extends Shark> type, Level worldIN) {
		super(type, worldIN);
		this.moveControl = new SmoothSwimmingMoveControl(this, 85, 10, 0.02F, 0.1F, true);
		this.lookControl = new SmoothSwimmingLookControl(this, 10);
		this.setCanPickUpLoot(true);
	}

	@Override
	@Nullable
	public SpawnGroupData finalizeSpawn(ServerLevelAccessor worldIn, DifficultyInstance difficultyIn, MobSpawnType reason, @Nullable SpawnGroupData spawnDataIn, @Nullable CompoundTag dataTag) {
		this.setXRot(0.0F);
		return super.finalizeSpawn(worldIn, difficultyIn, reason, spawnDataIn, dataTag);
	}

	@Override
	public boolean canBreatheUnderwater() {
		return true;
	}

	public int getMoistness() {
		return this.entityData.get(MOISTNESS);
	}

	public void setMoistness(int p_211137_1_) {
		this.entityData.set(MOISTNESS, p_211137_1_);
	}

	// Register Attributes, Goals, and Data
	public static AttributeSupplier.Builder registerAttributes() {
		return Mob.createMobAttributes().add(Attributes.MAX_HEALTH, 20.0D).add(Attributes.MOVEMENT_SPEED, (double) 1.0F).add(Attributes.ATTACK_DAMAGE, 10.0D);
	}

	@Override
	protected void registerGoals() {
		this.goalSelector.addGoal(0, new TryFindWaterGoal(this));
		this.goalSelector.addGoal(1, new Shark.AttackGoal());
		this.goalSelector.addGoal(4, new RandomSwimmingGoal(this, 1.0D, 10));
		this.goalSelector.addGoal(4, new RandomLookAroundGoal(this));
		this.goalSelector.addGoal(5, new LookAtPlayerGoal(this, Player.class, 6.0F));
		this.goalSelector.addGoal(8, new FollowBoatGoal(this));
		this.targetSelector.addGoal(1, (new HurtByTargetGoal(this, Guardian.class)).setAlertOthers());
		this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, TropicalFish.class, 10, true, true,
				(Predicate<LivingEntity>) null));
	}

	@Override
	protected void defineSynchedData() {
		super.defineSynchedData();
		this.entityData.define(MOISTNESS, 2400);
	}

	@Override
	protected PathNavigation createNavigation(Level worldIn) {
		return new WaterBoundPathNavigation(this, worldIn);
	}

	@Override
	public boolean doHurtTarget(Entity entityIn) {
		boolean flag = entityIn.hurt(DamageSource.mobAttack(this),
				(float) ((int) this.getAttributeValue(Attributes.ATTACK_DAMAGE)));
		if (flag) {
			this.doEnchantDamageEffects(this, entityIn);
			this.playSound(SoundEvents.DOLPHIN_ATTACK, 1.0F, 1.0F);
		}

		return flag;
	}

	@Override
	protected float getStandingEyeHeight(Pose poseIn, EntityDimensions sizeIn) {
		return 0.3F;
	}

	/**
	 * Tests if this entity should pickup a weapon or an armor. Entity drops current
	 * weapon or armor if the new one is better.
	 */
	@Override
	protected void pickUpItem(ItemEntity p_28357_) {
		if (this.getItemBySlot(EquipmentSlot.MAINHAND).isEmpty()) {
			ItemStack itemstack = p_28357_.getItem();
			if (this.canHoldItem(itemstack)) {
				this.onItemPickup(p_28357_);
				this.setItemSlot(EquipmentSlot.MAINHAND, itemstack);
				this.handDropChances[EquipmentSlot.MAINHAND.getIndex()] = 2.0F;
				this.take(p_28357_, itemstack.getCount());
				p_28357_.discard();
			}
		}

	}

	/**
	 * Called to update the entity's position/logic.
	 */
	@Override
	public void tick() {
		super.tick();
		if (this.isNoAi()) {
			this.setAirSupply(this.getMaxAirSupply());
		} else {
			if (this.isInWaterRainOrBubble()) {
				this.setMoistness(2400);
			} else {
				this.setMoistness(this.getMoistness() - 1);
				if (this.getMoistness() <= 0) {
					this.hurt(DamageSource.DRY_OUT, 1.0F);
				}

				if (this.onGround) {
					this.setDeltaMovement(this.getDeltaMovement().add((double) ((this.random.nextFloat() * 2.0F - 1.0F) * 0.2F), 0.5D, (double) ((this.random.nextFloat() * 2.0F - 1.0F) * 0.2F)));
					this.setYRot(this.random.nextFloat() * 360.0F);
					this.onGround = false;
					this.hasImpulse = true;
				}
			}

			if (this.level.isClientSide && this.isInWater() && this.getDeltaMovement().lengthSqr() > 0.03D) {
	            Vec3 vec3 = this.getViewVector(0.0F);
	            float f = Mth.cos(this.getYRot() * ((float)Math.PI / 180F)) * 0.3F;
	            float f1 = Mth.sin(this.getYRot() * ((float)Math.PI / 180F)) * 0.3F;
	            float f2 = 1.2F - this.random.nextFloat() * 0.7F;

	            for(int i = 0; i < 2; ++i) {
	               this.level.addParticle(ParticleTypes.DOLPHIN, this.getX() - vec3.x * (double)f2 + (double)f, this.getY() - vec3.y, this.getZ() - vec3.z * (double)f2 + (double)f1, 0.0D, 0.0D, 0.0D);
	               this.level.addParticle(ParticleTypes.DOLPHIN, this.getX() - vec3.x * (double)f2 - (double)f, this.getY() - vec3.y, this.getZ() - vec3.z * (double)f2 - (double)f1, 0.0D, 0.0D, 0.0D);
	            }
	         }
		}
	}

	@Override
	protected InteractionResult mobInteract(Player playerIn, InteractionHand hand) {
		ItemStack itemstack = playerIn.getItemInHand(hand);
		if (!itemstack.isEmpty() && itemstack.is(ItemTags.FISHES)) {
			if (!this.level.isClientSide) {
				this.playSound(SoundEvents.DOLPHIN_EAT, 1.0F, 1.0F);
			}
			if (!playerIn.getAbilities().instabuild) {
				itemstack.shrink(1);
			}

			return InteractionResult.sidedSuccess(this.level.isClientSide);
		} else {
			return super.mobInteract(playerIn, hand);
		}
	}

	public static boolean checkDolphinSpawnRules(EntityType<Shark> p_223364_0_, Level p_223364_1_,
			MobSpawnType reason, BlockPos p_223364_3_, Random p_223364_4_) {
		if (p_223364_3_.getY() > 45 && p_223364_3_.getY() < p_223364_1_.getSeaLevel()) {
			Optional<ResourceKey<Biome>> optional = p_223364_1_.getBiomeName(p_223364_3_);
			return (!Objects.equals(optional, Optional.of(Biomes.OCEAN))
					|| !Objects.equals(optional, Optional.of(Biomes.DEEP_OCEAN)))
					&& p_223364_1_.getFluidState(p_223364_3_).is(FluidTags.WATER);
		} else {
			return false;
		}
	}

	class AttackGoal extends net.minecraft.world.entity.ai.goal.MeleeAttackGoal {
		public AttackGoal() {
			super(Shark.this, 1.50D, true);
		}

		@Override
		protected void checkAndPerformAttack(LivingEntity enemy, double distToEnemySqr) {
			double d0 = this.getAttackReachSqr(enemy);
			if (distToEnemySqr <= d0 && this.isTimeToAttack()) {
				this.resetAttackCooldown();
				this.mob.doHurtTarget(enemy);

			} else if (distToEnemySqr <= d0 * 2.0D) {
				if (this.isTimeToAttack()) {

					this.resetAttackCooldown();
				}

				if (this.getTicksUntilNextAttack() <= 10) {
					// todo: what happens here?
				}
			} else {
				this.resetAttackCooldown();

			}

		}

		@Override
		protected double getAttackReachSqr(LivingEntity attackTarget) {
			return (double) (4.0F + attackTarget.getBbWidth());
		}
	}

	// Anger
	@Override
	public void startPersistentAngerTimer() {
	      this.setRemainingPersistentAngerTime(PERSISTENT_ANGER_TIME.sample(this.random));
	}

	@Override
	public void setRemainingPersistentAngerTime(int time) {
		this.angerTime = time;
	}

	@Override
	public int getRemainingPersistentAngerTime() {
		return this.angerTime;
	}

	@Override
	public void setPersistentAngerTarget(@Nullable UUID target) {
		this.angerTarget = target;
	}

	@Override
	public UUID getPersistentAngerTarget() {
		return this.angerTarget;
	}

	// Audio
	@Override
	protected SoundEvent getHurtSound(DamageSource damageSourceIn) {
		return SoundEvents.DOLPHIN_HURT;
	}

	@Override
	@Nullable
	protected SoundEvent getDeathSound() {
		return SoundEvents.DOLPHIN_DEATH;
	}

	@Override
	@Nullable
	protected SoundEvent getAmbientSound() {
		return this.isInWater() ? SoundEvents.DOLPHIN_AMBIENT_WATER : SoundEvents.DOLPHIN_AMBIENT;
	}

	@Override
	protected SoundEvent getSwimSplashSound() {
		return SoundEvents.DOLPHIN_SPLASH;
	}

	@Override
	protected SoundEvent getSwimSound() {
		return SoundEvents.DOLPHIN_SWIM;
	}

	protected boolean closeToTarget() {
		BlockPos blockpos = this.getNavigation().getTargetPos();
		return blockpos != null && blockpos.closerThan(this.position(), 12.0D);
	}

	@Override
	public void travel(Vec3 travelVector) {
		if (this.isEffectiveAi() && this.isInWater()) {
			this.moveRelative(this.getSpeed(), travelVector);
			this.move(MoverType.SELF, this.getDeltaMovement());
			this.setDeltaMovement(this.getDeltaMovement().scale(0.9D));
			if (this.getTarget() == null) {
				this.setDeltaMovement(this.getDeltaMovement().add(0.0D, -0.005D, 0.0D));
			}
		} else {
			super.travel(travelVector);
		}

	}

	// NBT
	@Override
	public void addAdditionalSaveData(CompoundTag compound) {
		super.addAdditionalSaveData(compound);
		compound.putInt("Moistness", this.getMoistness());
	}

	@Override
	public void readAdditionalSaveData(CompoundTag compound) {
		super.readAdditionalSaveData(compound);
		this.setMoistness(compound.getInt("Moistness"));
	}
}
