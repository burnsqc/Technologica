package com.technologica.world.entity.animal;

import java.util.UUID;

import com.technologica.registration.deferred.TechnologicaEntityTypes;
import com.technologica.registration.deferred.TechnologicaItems;
import com.technologica.registration.deferred.TechnologicaSoundEvents;
import com.technologica.world.entity.ai.goal.FloatSurfaceGoal;

import net.minecraft.core.BlockPos;
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
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.pathfinder.BlockPathTypes;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.common.ForgeMod;

/**
 * <p>
 * This class contains all of the behavior logic for flamingos.
 * <p>
 * Flamingos are very similar to chickens. Key differences are that flamingos eat raw crabs, spend more time in water, move faster in water, and do not lay eggs.
 * </p>
 * 
 * @tl.status GREEN
 */
public class Flamingo extends Animal {
	private static final UUID SURFACE_SWIM_ID = UUID.fromString("7ac11534-4fbe-443a-9ccc-7ab2295b2227");
	private static final AttributeModifier SURFACE_SWIM = new AttributeModifier(SURFACE_SWIM_ID, "Surface swim speed increase", 1.0F, AttributeModifier.Operation.ADDITION);
	private static final Ingredient FOOD_ITEMS = Ingredient.of(TechnologicaItems.RAW_CRAB.get());
	public float flap;
	public float flapSpeed;
	public float oFlapSpeed;
	public float oFlap;
	private float flapping = 1.0F;
	private float nextFlap = 1.0F;

	public Flamingo(EntityType<Flamingo> flamingo, Level level) {
		super(flamingo, level);
		this.setPathfindingMalus(BlockPathTypes.WATER, 0.0F);
	}

	@Override
	protected void registerGoals() {
		this.goalSelector.addGoal(0, new FloatSurfaceGoal(this, 0.87F));
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
			if (vector3d.y < 0.0D && this.getFluidTypeHeight(ForgeMod.WATER_TYPE.get()) > 0.85) {
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
		return TechnologicaSoundEvents.FLAMINGO_AMBIENT.get();
	}

	@Override
	protected SoundEvent getHurtSound(DamageSource damageSource) {
		return TechnologicaSoundEvents.FLAMINGO_HURT.get();
	}

	@Override
	protected SoundEvent getDeathSound() {
		return TechnologicaSoundEvents.FLAMINGO_DEATH.get();
	}

	@Override
	protected void playStepSound(BlockPos blockPos, BlockState blockState) {
		this.playSound(SoundEvents.CHICKEN_STEP, 0.15F, 1.0F);
	}

	@Override
	public Flamingo getBreedOffspring(ServerLevel serverLevel, AgeableMob ageableMob) {
		return TechnologicaEntityTypes.FLAMINGO.get().create(serverLevel);
	}

	@Override
	public boolean isFood(ItemStack itemStack) {
		return FOOD_ITEMS.test(itemStack);
	}

	@Override
	public boolean isFree(double p_20230_, double p_20231_, double p_20232_) {
		return this.isFree(this.getBoundingBox().move(p_20230_, p_20231_ + 0.5D, p_20232_));
	}

	private boolean isFree(AABB p_20132_) {
		return this.level().noCollision(this, p_20132_) && !this.level().containsAnyLiquid(p_20132_);
	}
}
