package com.technologica.world.entity.animal;

import java.util.UUID;

import com.technologica.registration.deferred.TechnologicaEntityTypes;
import com.technologica.registration.deferred.TechnologicaItems;
import com.technologica.world.entity.ai.goal.FloatSurfaceGoal;

import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.util.Mth;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.AgeableMob;
import net.minecraft.world.entity.EntityDimensions;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.Pose;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.BreedGoal;
import net.minecraft.world.entity.ai.goal.FollowParentGoal;
import net.minecraft.world.entity.ai.goal.LookAtPlayerGoal;
import net.minecraft.world.entity.ai.goal.PanicGoal;
import net.minecraft.world.entity.ai.goal.RandomLookAroundGoal;
import net.minecraft.world.entity.ai.goal.RandomStrollGoal;
import net.minecraft.world.entity.ai.goal.TemptGoal;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.level.pathfinder.BlockPathTypes;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.common.ForgeMod;

/**
 * <p>
 * This class contains all of the behavior logic for ducks.
 * <p>
 * Ducks are very similar to chickens. Key differences are that ducks eat bread, spend more time in water, move faster in water, and lay duck eggs.
 * </p>
 * 
 * @tl.status GREEN
 */
public class Duck extends Animal {
	private static final UUID SURFACE_SWIM_ID = UUID.fromString("1499d0b0-5e13-424b-bc7e-427267e520c0");
	private static final AttributeModifier SURFACE_SWIM = new AttributeModifier(SURFACE_SWIM_ID, "Surface swim speed increase", 1.0F, AttributeModifier.Operation.ADDITION);
	private static final Ingredient FOOD_ITEMS = Ingredient.of(Items.BREAD);
	public float flap;
	public float flapSpeed;
	public float oFlapSpeed;
	public float oFlap;
	private float flapping = 1.0F;
	private float nextFlap = 1.0F;
	private int eggTime = this.random.nextInt(6000) + 6000;

	public Duck(EntityType<Duck> duck, Level level) {
		super(duck, level);
		this.setPathfindingMalus(BlockPathTypes.WATER, 0.0F);
	}

	@Override
	protected void registerGoals() {
		this.goalSelector.addGoal(0, new FloatSurfaceGoal(this, 0.5F));
		this.goalSelector.addGoal(1, new PanicGoal(this, 1.4D));
		this.goalSelector.addGoal(2, new BreedGoal(this, 1.0D));
		this.goalSelector.addGoal(3, new TemptGoal(this, 1.0D, FOOD_ITEMS, false));
		this.goalSelector.addGoal(4, new FollowParentGoal(this, 1.1D));
		this.goalSelector.addGoal(5, new RandomStrollGoal(this, 1.0D));
		this.goalSelector.addGoal(6, new LookAtPlayerGoal(this, Player.class, 6.0F));
		this.goalSelector.addGoal(7, new RandomLookAroundGoal(this));
	}

	@Override
	protected float getStandingEyeHeight(Pose pose, EntityDimensions size) {
		return this.isBaby() ? size.height * 0.85F : size.height * 0.92F;
	}

	public static AttributeSupplier.Builder createAttributes() {
		return Mob.createMobAttributes().add(Attributes.MAX_HEALTH, 4.0D).add(Attributes.MOVEMENT_SPEED, 0.25D);
	}

	@Override
	public void aiStep() {
		super.aiStep();
		this.oFlap = this.flap;
		this.oFlapSpeed = this.flapSpeed;
		this.flapSpeed += (this.onGround() || this.isInWater() ? -1.0F : 4.0F) * 0.3F;
		this.flapSpeed = Mth.clamp(this.flapSpeed, 0.0F, 1.0F);
		if (!this.onGround() && this.flapping < 1.0F && !this.isInWater()) {
			this.flapping = 1.0F;
		}
		this.flapping *= 0.9F;
		Vec3 vector3d = this.getDeltaMovement();
		if (!this.onGround() && vector3d.y < 0.0D) {
			this.setDeltaMovement(vector3d.multiply(1.0D, 0.6D, 1.0D));
		}
		if (this.isInWater()) {
			if (vector3d.y < 0.0D && this.getFluidTypeHeight(ForgeMod.WATER_TYPE.get()) + 0.2 > this.getEyeHeight()) {
				this.setDeltaMovement(vector3d.multiply(1.0D, 0.0D, 1.0D));
			}
			if (!this.getAttribute(Attributes.MOVEMENT_SPEED).hasModifier(SURFACE_SWIM)) {
				this.getAttribute(Attributes.MOVEMENT_SPEED).addTransientModifier(SURFACE_SWIM);
			}
		} else {
			if (this.getAttribute(Attributes.MOVEMENT_SPEED).hasModifier(SURFACE_SWIM)) {
				this.getAttribute(Attributes.MOVEMENT_SPEED).removeModifier(SURFACE_SWIM);
			}
		}
		this.flap += this.flapping * 2.0F;
		if (!this.level().isClientSide && this.isAlive() && !this.isBaby() && --this.eggTime <= 0) {
			this.playSound(SoundEvents.CHICKEN_EGG, 1.0F, (this.random.nextFloat() - this.random.nextFloat()) * 0.2F + 1.0F);
			this.spawnAtLocation(TechnologicaItems.DUCK_EGG.get());
			this.gameEvent(GameEvent.ENTITY_PLACE);
			this.eggTime = this.random.nextInt(6000) + 6000;
		}
	}

	@Override
	protected boolean isFlapping() {
		return this.flyDist > this.nextFlap;
	}

	@Override
	protected void onFlap() {
		this.nextFlap = this.flyDist + this.flapSpeed / 2.0F;
	}

	@Override
	protected SoundEvent getAmbientSound() {
		return SoundEvents.CHICKEN_AMBIENT;
	}

	@Override
	protected SoundEvent getHurtSound(DamageSource damageSource) {
		return SoundEvents.CHICKEN_HURT;
	}

	@Override
	protected SoundEvent getDeathSound() {
		return SoundEvents.CHICKEN_DEATH;
	}

	@Override
	protected void playStepSound(BlockPos blockPos, BlockState blockState) {
		this.playSound(SoundEvents.CHICKEN_STEP, 0.15F, 1.0F);
	}

	@Override
	public Duck getBreedOffspring(ServerLevel serverLevel, AgeableMob ageableMob) {
		return TechnologicaEntityTypes.DUCK.get().create(serverLevel);
	}

	@Override
	public boolean isFood(ItemStack itemStack) {
		return FOOD_ITEMS.test(itemStack);
	}

	@Override
	public void readAdditionalSaveData(CompoundTag compoundTag) {
		super.readAdditionalSaveData(compoundTag);
		if (compoundTag.contains("EggLayTime")) {
			this.eggTime = compoundTag.getInt("EggLayTime");
		}
	}

	@Override
	public void addAdditionalSaveData(CompoundTag compoundTag) {
		super.addAdditionalSaveData(compoundTag);
		compoundTag.putInt("EggLayTime", this.eggTime);
	}
}
