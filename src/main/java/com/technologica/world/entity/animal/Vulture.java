package com.technologica.world.entity.animal;

import java.util.Comparator;
import java.util.EnumSet;
import java.util.List;

import javax.annotation.Nullable;

import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.Mth;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityDimensions;
import net.minecraft.world.entity.EntitySelector;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.FlyingMob;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.MobType;
import net.minecraft.world.entity.Pose;
import net.minecraft.world.entity.SpawnGroupData;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.control.BodyRotationControl;
import net.minecraft.world.entity.ai.control.LookControl;
import net.minecraft.world.entity.ai.control.MoveControl;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.entity.ai.targeting.TargetingConditions;
import net.minecraft.world.entity.animal.Cat;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class Vulture extends FlyingMob {
	private static final EntityDataAccessor<Integer> SIZE = SynchedEntityData.defineId(Vulture.class, EntityDataSerializers.INT);
	private Vec3 orbitOffset = Vec3.ZERO;
	private BlockPos orbitPosition = BlockPos.ZERO;
	private Vulture.AttackPhase attackPhase = Vulture.AttackPhase.CIRCLE;

	public Vulture(EntityType<? extends Vulture> type, Level worldIn) {
		super(type, worldIn);
		this.xpReward = 5;
		this.moveControl = new Vulture.MoveHelperController(this);
		this.lookControl = new Vulture.LookHelperController(this);
	}

	public static AttributeSupplier.Builder registerAttributes() {
		return AttributeSupplier.builder().add(Attributes.MAX_HEALTH, 10.0D).add(Attributes.MOVEMENT_SPEED, 0.25D).add(Attributes.FOLLOW_RANGE, 16.0D).add(Attributes.ATTACK_KNOCKBACK).add(Attributes.KNOCKBACK_RESISTANCE).add(Attributes.ARMOR).add(Attributes.ARMOR_TOUGHNESS).add(net.minecraftforge.common.ForgeMod.SWIM_SPEED.get()).add(net.minecraftforge.common.ForgeMod.NAMETAG_DISTANCE.get()).add(net.minecraftforge.common.ForgeMod.ENTITY_GRAVITY.get()).add(Attributes.ATTACK_DAMAGE, 4.0D);
	}

	@Override
	protected BodyRotationControl createBodyControl() {
		return new Vulture.BodyHelperController(this);
	}

	@Override
	protected void registerGoals() {
		this.goalSelector.addGoal(1, new Vulture.PickAttackGoal());
		this.goalSelector.addGoal(2, new Vulture.SweepAttackGoal());
		this.goalSelector.addGoal(3, new Vulture.OrbitPointGoal());
		this.targetSelector.addGoal(1, new Vulture.AttackPlayerGoal());
	}

	@Override
	protected void defineSynchedData() {
		super.defineSynchedData();
		this.entityData.define(SIZE, 0);
	}

	public void setVultureSize(int sizeIn) {
		this.entityData.set(SIZE, Mth.clamp(sizeIn, 0, 64));
	}

	private void updateVultureSize() {
		this.refreshDimensions();
		this.getAttribute(Attributes.ATTACK_DAMAGE).setBaseValue(6 + this.getVultureSize());
	}

	public int getVultureSize() {
		return this.entityData.get(SIZE);
	}

	@Override
	protected float getStandingEyeHeight(Pose poseIn, EntityDimensions sizeIn) {
		return sizeIn.height * 0.35F;
	}

	@Override
	public void onSyncedDataUpdated(EntityDataAccessor<?> key) {
		if (SIZE.equals(key)) {
			this.updateVultureSize();
		}

		super.onSyncedDataUpdated(key);
	}

	@Override
	protected boolean shouldDespawnInPeaceful() {
		return false;
	}

	@Override
	public void tick() {
		super.tick();
		if (this.level().isClientSide) {
			float f = Mth.cos((this.getId() * 3 + this.tickCount) * 0.13F + (float) Math.PI);
			float f1 = Mth.cos((this.getId() * 3 + this.tickCount + 1) * 0.13F + (float) Math.PI);
			if (f > 0.0F && f1 <= 0.0F) {
				this.level().playLocalSound(this.getX(), this.getY(), this.getZ(), SoundEvents.PHANTOM_FLAP, this.getSoundSource(), 0.95F + this.random.nextFloat() * 0.05F, 0.95F + this.random.nextFloat() * 0.05F, false);
			}
		}
	}

	@Override
	public void aiStep() {
		super.aiStep();
	}

	@Override
	protected void customServerAiStep() {
		super.customServerAiStep();
	}

	@Override
	public SpawnGroupData finalizeSpawn(ServerLevelAccessor worldIn, DifficultyInstance difficultyIn, MobSpawnType reason, @Nullable SpawnGroupData spawnDataIn, @Nullable CompoundTag dataTag) {
		this.orbitPosition = this.blockPosition().above(5);
		this.setVultureSize(0);
		return super.finalizeSpawn(worldIn, difficultyIn, reason, spawnDataIn, dataTag);
	}

	/**
	 * (abstract) Protected helper method to read subclass entity data from NBT.
	 */
	@Override
	public void readAdditionalSaveData(CompoundTag compound) {
		super.readAdditionalSaveData(compound);
		if (compound.contains("AX")) {
			this.orbitPosition = new BlockPos(compound.getInt("AX"), compound.getInt("AY"), compound.getInt("AZ"));
		}

		this.setVultureSize(compound.getInt("Size"));
	}

	@Override
	public void addAdditionalSaveData(CompoundTag compound) {
		super.addAdditionalSaveData(compound);
		compound.putInt("AX", this.orbitPosition.getX());
		compound.putInt("AY", this.orbitPosition.getY());
		compound.putInt("AZ", this.orbitPosition.getZ());
		compound.putInt("Size", this.getVultureSize());
	}

	/**
	 * Checks if the entity is in range to render.
	 */
	@Override
	@OnlyIn(Dist.CLIENT)
	public boolean shouldRenderAtSqrDistance(double distance) {
		return true;
	}

	@Override
	public SoundSource getSoundSource() {
		return SoundSource.HOSTILE;
	}

	@Override
	protected SoundEvent getAmbientSound() {
		return SoundEvents.PHANTOM_AMBIENT;
	}

	@Override
	protected SoundEvent getHurtSound(DamageSource damageSourceIn) {
		return SoundEvents.PHANTOM_HURT;
	}

	@Override
	protected SoundEvent getDeathSound() {
		return SoundEvents.PHANTOM_DEATH;
	}

	@Override
	public MobType getMobType() {
		return MobType.UNDEFINED;
	}

	/**
	 * Returns the volume for the sounds this mob makes.
	 */
	@Override
	protected float getSoundVolume() {
		return 1.0F;
	}

	@Override
	public boolean canAttackType(EntityType<?> typeIn) {
		return true;
	}

	@Override
	public EntityDimensions getDimensions(Pose poseIn) {
		int i = this.getVultureSize();
		EntityDimensions entitysize = super.getDimensions(poseIn);
		float f = (entitysize.width + 0.2F * i) / entitysize.width;
		return entitysize.scale(f);
	}

	static enum AttackPhase {
		CIRCLE, SWOOP;
	}

	class AttackPlayerGoal extends Goal {
		private final TargetingConditions attackTargeting = TargetingConditions.forCombat().range(64.0D);
		private int tickDelay = 20;

		@Override
		public boolean canUse() {
			if (this.tickDelay > 0) {
				--this.tickDelay;
				return false;
			} else {
				this.tickDelay = 60;
				List<Player> list = Vulture.this.level().getNearbyPlayers(this.attackTargeting, Vulture.this, Vulture.this.getBoundingBox().inflate(16.0D, 64.0D, 16.0D));
				if (!list.isEmpty()) {
					list.sort(Comparator.<Entity, Double>comparing(Entity::getY).reversed());

					for (Player playerentity : list) {
						if (Vulture.this.canAttack(playerentity, TargetingConditions.DEFAULT)) {
							Vulture.this.setTarget(playerentity);
							return true;
						}
					}
				}

				return false;
			}
		}

		@Override
		public boolean canContinueToUse() {
			LivingEntity livingentity = Vulture.this.getTarget();
			return livingentity != null ? Vulture.this.canAttack(livingentity, TargetingConditions.DEFAULT) : false;
		}
	}

	class BodyHelperController extends BodyRotationControl {
		public BodyHelperController(Mob mob) {
			super(mob);
		}

		@Override
		public void clientTick() {
			Vulture.this.yHeadRot = Vulture.this.yBodyRot;
			Vulture.this.yBodyRot = Vulture.this.getYRot();
		}
	}

	class LookHelperController extends LookControl {
		public LookHelperController(Mob entityIn) {
			super(entityIn);
		}

		/**
		 * Updates look
		 */
		@Override
		public void tick() {
		}
	}

	abstract class MoveGoal extends Goal {
		public MoveGoal() {
			this.setFlags(EnumSet.of(Goal.Flag.MOVE));
		}

		protected boolean touchingTarget() {
			return Vulture.this.orbitOffset.distanceToSqr(Vulture.this.getX(), Vulture.this.getY(), Vulture.this.getZ()) < 4.0D;
		}
	}

	class MoveHelperController extends MoveControl {
		private float speedFactor = 0.1F;

		public MoveHelperController(Mob entityIn) {
			super(entityIn);
		}

		@Override
		public void tick() {
			if (Vulture.this.horizontalCollision) {
				Vulture.this.setYRot(Vulture.this.getYRot() + 180.0F);
				this.speedFactor = 0.1F;
			}

			float f = (float) (Vulture.this.orbitOffset.x - Vulture.this.getX());
			float f1 = (float) (Vulture.this.orbitOffset.y - Vulture.this.getY());
			float f2 = (float) (Vulture.this.orbitOffset.z - Vulture.this.getZ());
			double d0 = Mth.sqrt(f * f + f2 * f2);
			double d1 = 1.0D - Mth.abs(f1 * 0.7F) / d0;
			f = (float) (f * d1);
			f2 = (float) (f2 * d1);
			d0 = Mth.sqrt(f * f + f2 * f2);
			double d2 = Mth.sqrt(f * f + f2 * f2 + f1 * f1);
			float f3 = Vulture.this.getYRot();
			float f4 = (float) Mth.atan2(f2, f);
			float f5 = Mth.wrapDegrees(Vulture.this.getYRot() + 90.0F);
			float f6 = Mth.wrapDegrees(f4 * (180F / (float) Math.PI));
			Vulture.this.setYRot(Mth.approachDegrees(f5, f6, 4.0F) - 90.0F);
			Vulture.this.yBodyRot = Vulture.this.getYRot();
			if (Mth.degreesDifferenceAbs(f3, Vulture.this.getYRot()) < 3.0F) {
				this.speedFactor = Mth.approach(this.speedFactor, 1.8F, 0.005F * (1.8F / this.speedFactor));
			} else {
				this.speedFactor = Mth.approach(this.speedFactor, 0.2F, 0.025F);
			}

			float f7 = (float) (-(Mth.atan2((-f1), d0) * (180F / (float) Math.PI)));
			Vulture.this.setXRot(f7);
			float f8 = Vulture.this.getYRot() + 90.0F;
			double d3 = this.speedFactor * Mth.cos(f8 * ((float) Math.PI / 180F)) * Math.abs(f / d2);
			double d4 = this.speedFactor * Mth.sin(f8 * ((float) Math.PI / 180F)) * Math.abs(f2 / d2);
			double d5 = this.speedFactor * Mth.sin(f7 * ((float) Math.PI / 180F)) * Math.abs(f1 / d2);
			Vec3 vector3d = Vulture.this.getDeltaMovement();
			Vulture.this.setDeltaMovement(vector3d.add((new Vec3(d3, d5, d4)).subtract(vector3d).scale(0.2D)));
		}
	}

	class OrbitPointGoal extends Vulture.MoveGoal {
		private float angle;
		private float distance;
		private float height;
		private float clockwise;

		private OrbitPointGoal() {
		}

		/**
		 * Returns whether execution should begin. You can also read and cache any state
		 * necessary for execution in this method as well.
		 */
		@Override
		public boolean canUse() {
			return Vulture.this.getTarget() == null || Vulture.this.attackPhase == Vulture.AttackPhase.CIRCLE;
		}

		/**
		 * Execute a one shot task or start executing a continuous task
		 */
		@Override
		public void start() {
			this.distance = 5.0F + Vulture.this.random.nextFloat() * 10.0F;
			this.height = -4.0F + Vulture.this.random.nextFloat() * 9.0F;
			this.clockwise = Vulture.this.random.nextBoolean() ? 1.0F : -1.0F;
			this.selectNext();
		}

		/**
		 * Keep ticking a continuous task that has already been started
		 */
		@Override
		public void tick() {
			if (Vulture.this.random.nextInt(350) == 0) {
				this.height = -4.0F + Vulture.this.random.nextFloat() * 9.0F;
			}

			if (Vulture.this.random.nextInt(250) == 0) {
				++this.distance;
				if (this.distance > 15.0F) {
					this.distance = 5.0F;
					this.clockwise = -this.clockwise;
				}
			}

			if (Vulture.this.random.nextInt(450) == 0) {
				this.angle = Vulture.this.random.nextFloat() * 2.0F * (float) Math.PI;
				this.selectNext();
			}

			if (this.touchingTarget()) {
				this.selectNext();
			}

			if (Vulture.this.orbitOffset.y < Vulture.this.getY() && !Vulture.this.level().isEmptyBlock(Vulture.this.blockPosition().below(1))) {
				this.height = Math.max(1.0F, this.height);
				this.selectNext();
			}

			if (Vulture.this.orbitOffset.y > Vulture.this.getY() && !Vulture.this.level().isEmptyBlock(Vulture.this.blockPosition().above(1))) {
				this.height = Math.min(-1.0F, this.height);
				this.selectNext();
			}

		}

		private void selectNext() {
			if (BlockPos.ZERO.equals(Vulture.this.orbitPosition)) {
				Vulture.this.orbitPosition = Vulture.this.blockPosition();
			}

			this.angle += this.clockwise * 15.0F * ((float) Math.PI / 180F);
			Vulture.this.orbitOffset = Vec3.atLowerCornerOf(Vulture.this.orbitPosition).add(this.distance * Mth.cos(this.angle), -4.0F + this.height, this.distance * Mth.sin(this.angle));
		}
	}

	class PickAttackGoal extends Goal {
		private int tickDelay;

		private PickAttackGoal() {
		}

		/**
		 * Returns whether execution should begin. You can also read and cache any state
		 * necessary for execution in this method as well.
		 */
		@Override
		public boolean canUse() {
			LivingEntity livingentity = Vulture.this.getTarget();
			return livingentity != null ? Vulture.this.canAttack(Vulture.this.getTarget(), TargetingConditions.DEFAULT) : false;
		}

		/**
		 * Execute a one shot task or start executing a continuous task
		 */
		@Override
		public void start() {
			this.tickDelay = 10;
			Vulture.this.attackPhase = Vulture.AttackPhase.CIRCLE;
			this.setAnchorAboveTarget();
		}

		/**
		 * Reset the task's internal state. Called when this task is interrupted by
		 * another one
		 */
		@Override
		public void stop() {
			Vulture.this.orbitPosition = Vulture.this.level().getHeightmapPos(Heightmap.Types.MOTION_BLOCKING, Vulture.this.orbitPosition).above(10 + Vulture.this.random.nextInt(20));
		}

		/**
		 * Keep ticking a continuous task that has already been started
		 */
		@Override
		public void tick() {
			if (Vulture.this.attackPhase == Vulture.AttackPhase.CIRCLE) {
				--this.tickDelay;
				if (this.tickDelay <= 0) {
					Vulture.this.attackPhase = Vulture.AttackPhase.SWOOP;
					this.setAnchorAboveTarget();
					this.tickDelay = (8 + Vulture.this.random.nextInt(4)) * 20;
					Vulture.this.playSound(SoundEvents.PHANTOM_SWOOP, 10.0F, 0.95F + Vulture.this.random.nextFloat() * 0.1F);
				}
			}

		}

		private void setAnchorAboveTarget() {
			Vulture.this.orbitPosition = Vulture.this.getTarget().blockPosition().above(20 + Vulture.this.random.nextInt(20));
			if (Vulture.this.orbitPosition.getY() < Vulture.this.level().getSeaLevel()) {
				Vulture.this.orbitPosition = new BlockPos(Vulture.this.orbitPosition.getX(), Vulture.this.level().getSeaLevel() + 1, Vulture.this.orbitPosition.getZ());
			}

		}
	}

	class SweepAttackGoal extends Vulture.MoveGoal {
		private SweepAttackGoal() {
		}

		/**
		 * Returns whether execution should begin. You can also read and cache any state
		 * necessary for execution in this method as well.
		 */
		@Override
		public boolean canUse() {
			return Vulture.this.getTarget() != null && Vulture.this.attackPhase == Vulture.AttackPhase.SWOOP;
		}

		/**
		 * Returns whether an in-progress EntityAIBase should continue executing
		 */
		@Override
		public boolean canContinueToUse() {
			LivingEntity livingentity = Vulture.this.getTarget();
			if (livingentity == null) {
				return false;
			} else if (!livingentity.isAlive()) {
				return false;
			} else if (!(livingentity instanceof Player) || !((Player) livingentity).isSpectator() && !((Player) livingentity).isCreative()) {
				if (!this.canUse()) {
					return false;
				} else {
					if (Vulture.this.tickCount % 20 == 0) {
						List<Cat> list = Vulture.this.level().getEntitiesOfClass(Cat.class, Vulture.this.getBoundingBox().inflate(16.0D), EntitySelector.ENTITY_STILL_ALIVE);
						if (!list.isEmpty()) {
							for (Cat catentity : list) {
								catentity.hiss();
							}

							return false;
						}
					}

					return true;
				}
			} else {
				return false;
			}
		}

		/**
		 * Execute a one shot task or start executing a continuous task
		 */
		@Override
		public void start() {
		}

		/**
		 * Reset the task's internal state. Called when this task is interrupted by
		 * another one
		 */
		@Override
		public void stop() {
			Vulture.this.setTarget((LivingEntity) null);
			Vulture.this.attackPhase = Vulture.AttackPhase.CIRCLE;
		}

		/**
		 * Keep ticking a continuous task that has already been started
		 */
		@Override
		public void tick() {
			LivingEntity livingentity = Vulture.this.getTarget();
			Vulture.this.orbitOffset = new Vec3(livingentity.getX(), livingentity.getY(0.5D), livingentity.getZ());
			if (Vulture.this.getBoundingBox().inflate(0.2F).intersects(livingentity.getBoundingBox())) {
				Vulture.this.doHurtTarget(livingentity);
				Vulture.this.attackPhase = Vulture.AttackPhase.CIRCLE;
				if (!Vulture.this.isSilent()) {
					Vulture.this.level().levelEvent(1039, Vulture.this.blockPosition(), 0);
				}
			} else if (Vulture.this.horizontalCollision || Vulture.this.hurtTime > 0) {
				Vulture.this.attackPhase = Vulture.AttackPhase.CIRCLE;
			}

		}
	}
}