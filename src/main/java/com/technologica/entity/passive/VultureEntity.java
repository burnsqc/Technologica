package com.technologica.entity.passive;

import java.util.Comparator;
import java.util.EnumSet;
import java.util.List;

import javax.annotation.Nullable;

import net.minecraft.entity.CreatureAttribute;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityPredicate;
import net.minecraft.entity.EntitySize;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.FlyingEntity;
import net.minecraft.entity.ILivingEntityData;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.MobEntity;
import net.minecraft.entity.Pose;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.ai.attributes.AttributeModifierMap;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.ai.controller.BodyController;
import net.minecraft.entity.ai.controller.LookController;
import net.minecraft.entity.ai.controller.MovementController;
import net.minecraft.entity.ai.goal.Goal;
import net.minecraft.entity.passive.CatEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EntityPredicates;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.IServerWorld;
import net.minecraft.world.World;
import net.minecraft.world.gen.Heightmap;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class VultureEntity extends FlyingEntity {
	private static final DataParameter<Integer> SIZE = EntityDataManager.defineId(VultureEntity.class, DataSerializers.INT);
	private Vector3d orbitOffset = Vector3d.ZERO;
	private BlockPos orbitPosition = BlockPos.ZERO;
	private VultureEntity.AttackPhase attackPhase = VultureEntity.AttackPhase.CIRCLE;

	public VultureEntity(EntityType<? extends VultureEntity> type, World worldIn) {
		super(type, worldIn);
		this.xpReward = 5;
		this.moveControl = new VultureEntity.MoveHelperController(this);
		this.lookControl = new VultureEntity.LookHelperController(this);
	}

	public static AttributeModifierMap.MutableAttribute registerAttributes() {
		return AttributeModifierMap.builder()
				.add(Attributes.MAX_HEALTH, 10.0D)
				.add(Attributes.MOVEMENT_SPEED, 0.25D)
				.add(Attributes.FOLLOW_RANGE, 16.0D)
				.add(Attributes.ATTACK_KNOCKBACK)
				.add(Attributes.KNOCKBACK_RESISTANCE)
				.add(Attributes.ARMOR)
				.add(Attributes.ARMOR_TOUGHNESS)
				.add(net.minecraftforge.common.ForgeMod.SWIM_SPEED.get())
				.add(net.minecraftforge.common.ForgeMod.NAMETAG_DISTANCE.get())
				.add(net.minecraftforge.common.ForgeMod.ENTITY_GRAVITY.get())
				.add(Attributes.ATTACK_DAMAGE, 4.0D);
	}
	
	protected BodyController createBodyControl() {
		return new VultureEntity.BodyHelperController(this);
	}

	protected void registerGoals() {
		this.goalSelector.addGoal(1, new VultureEntity.PickAttackGoal());
		this.goalSelector.addGoal(2, new VultureEntity.SweepAttackGoal());
		this.goalSelector.addGoal(3, new VultureEntity.OrbitPointGoal());
		this.targetSelector.addGoal(1, new VultureEntity.AttackPlayerGoal());
	}

	protected void defineSynchedData() {
		super.defineSynchedData();
		this.entityData.define(SIZE, 0);
	}

	public void setVultureSize(int sizeIn) {
		this.entityData.set(SIZE, MathHelper.clamp(sizeIn, 0, 64));
	}

	private void updateVultureSize() {
		this.refreshDimensions();
		this.getAttribute(Attributes.ATTACK_DAMAGE).setBaseValue((double) (6 + this.getVultureSize()));
	}

	public int getVultureSize() {
		return this.entityData.get(SIZE);
	}

	protected float getStandingEyeHeight(Pose poseIn, EntitySize sizeIn) {
		return sizeIn.height * 0.35F;
	}

	public void onSyncedDataUpdated(DataParameter<?> key) {
		if (SIZE.equals(key)) {
			this.updateVultureSize();
		}

		super.onSyncedDataUpdated(key);
	}

	protected boolean shouldDespawnInPeaceful() {
		return false;
	}

	public void tick() {
		super.tick();
		if (this.level.isClientSide) {
			float f = MathHelper.cos((float) (this.getId() * 3 + this.tickCount) * 0.13F + (float) Math.PI);
			float f1 = MathHelper.cos((float) (this.getId() * 3 + this.tickCount + 1) * 0.13F + (float) Math.PI);
			if (f > 0.0F && f1 <= 0.0F) {
				this.level.playLocalSound(this.getX(), this.getY(), this.getZ(), SoundEvents.PHANTOM_FLAP, this.getSoundSource(), 0.95F + this.random.nextFloat() * 0.05F, 0.95F + this.random.nextFloat() * 0.05F, false);
			}
		}
	}

	public void aiStep() {
		super.aiStep();
	}

	protected void customServerAiStep() {
		super.customServerAiStep();
	}

	public ILivingEntityData finalizeSpawn(IServerWorld worldIn, DifficultyInstance difficultyIn, SpawnReason reason, @Nullable ILivingEntityData spawnDataIn, @Nullable CompoundNBT dataTag) {
		this.orbitPosition = this.blockPosition().above(5);
		this.setVultureSize(0);
		return super.finalizeSpawn(worldIn, difficultyIn, reason, spawnDataIn, dataTag);
	}

	/**
	 * (abstract) Protected helper method to read subclass entity data from NBT.
	 */
	public void readAdditionalSaveData(CompoundNBT compound) {
		super.readAdditionalSaveData(compound);
		if (compound.contains("AX")) {
			this.orbitPosition = new BlockPos(compound.getInt("AX"), compound.getInt("AY"), compound.getInt("AZ"));
		}

		this.setVultureSize(compound.getInt("Size"));
	}

	public void addAdditionalSaveData(CompoundNBT compound) {
		super.addAdditionalSaveData(compound);
		compound.putInt("AX", this.orbitPosition.getX());
		compound.putInt("AY", this.orbitPosition.getY());
		compound.putInt("AZ", this.orbitPosition.getZ());
		compound.putInt("Size", this.getVultureSize());
	}

	/**
	 * Checks if the entity is in range to render.
	 */
	@OnlyIn(Dist.CLIENT)
	public boolean shouldRenderAtSqrDistance(double distance) {
		return true;
	}

	public SoundCategory getSoundSource() {
		return SoundCategory.HOSTILE;
	}

	protected SoundEvent getAmbientSound() {
		return SoundEvents.PHANTOM_AMBIENT;
	}

	protected SoundEvent getHurtSound(DamageSource damageSourceIn) {
		return SoundEvents.PHANTOM_HURT;
	}

	protected SoundEvent getDeathSound() {
		return SoundEvents.PHANTOM_DEATH;
	}

	public CreatureAttribute getMobType() {
		return CreatureAttribute.UNDEFINED;
	}

	/**
	 * Returns the volume for the sounds this mob makes.
	 */
	protected float getSoundVolume() {
		return 1.0F;
	}

	public boolean canAttackType(EntityType<?> typeIn) {
		return true;
	}

	public EntitySize getDimensions(Pose poseIn) {
		int i = this.getVultureSize();
		EntitySize entitysize = super.getDimensions(poseIn);
		float f = (entitysize.width + 0.2F * (float) i) / entitysize.width;
		return entitysize.scale(f);
	}

	static enum AttackPhase {
		CIRCLE, SWOOP;
	}

	class AttackPlayerGoal extends Goal {
		private final EntityPredicate attackTargeting = (new EntityPredicate()).range(64.0D);
		private int tickDelay = 20;

		private AttackPlayerGoal() {
		}

		/**
		 * Returns whether execution should begin. You can also read and cache any state
		 * necessary for execution in this method as well.
		 */
		public boolean canUse() {
			if (this.tickDelay > 0) {
				--this.tickDelay;
				return false;
			} else {
				this.tickDelay = 60;
				List<PlayerEntity> list = VultureEntity.this.level.getNearbyPlayers(this.attackTargeting,
						VultureEntity.this, VultureEntity.this.getBoundingBox().inflate(16.0D, 64.0D, 16.0D));
				if (!list.isEmpty()) {
					list.sort(Comparator.<Entity, Double>comparing(Entity::getY).reversed());

					for (PlayerEntity playerentity : list) {
						if (VultureEntity.this.canAttack(playerentity, EntityPredicate.DEFAULT)) {
							VultureEntity.this.setTarget(playerentity);
							return true;
						}
					}
				}

				return false;
			}
		}

		/**
		 * Returns whether an in-progress EntityAIBase should continue executing
		 */
		public boolean canContinueToUse() {
			LivingEntity livingentity = VultureEntity.this.getTarget();
			return livingentity != null ? VultureEntity.this.canAttack(livingentity, EntityPredicate.DEFAULT) : false;
		}
	}

	class BodyHelperController extends BodyController {
		public BodyHelperController(MobEntity mob) {
			super(mob);
		}

		/**
		 * Update the Head and Body rendenring angles
		 */
		public void clientTick() {
			VultureEntity.this.yHeadRot = VultureEntity.this.yBodyRot;
			VultureEntity.this.yBodyRot = VultureEntity.this.yRot;
		}
	}

	class LookHelperController extends LookController {
		public LookHelperController(MobEntity entityIn) {
			super(entityIn);
		}

		/**
		 * Updates look
		 */
		public void tick() {
		}
	}

	abstract class MoveGoal extends Goal {
		public MoveGoal() {
			this.setFlags(EnumSet.of(Goal.Flag.MOVE));
		}

		protected boolean touchingTarget() {
			return VultureEntity.this.orbitOffset.distanceToSqr(VultureEntity.this.getX(),
					VultureEntity.this.getY(), VultureEntity.this.getZ()) < 4.0D;
		}
	}

	class MoveHelperController extends MovementController {
		private float speedFactor = 0.1F;

		public MoveHelperController(MobEntity entityIn) {
			super(entityIn);
		}

		public void tick() {
			if (VultureEntity.this.horizontalCollision) {
				VultureEntity.this.yRot += 180.0F;
				this.speedFactor = 0.1F;
			}

			float f = (float) (VultureEntity.this.orbitOffset.x - VultureEntity.this.getX());
			float f1 = (float) (VultureEntity.this.orbitOffset.y - VultureEntity.this.getY());
			float f2 = (float) (VultureEntity.this.orbitOffset.z - VultureEntity.this.getZ());
			double d0 = (double) MathHelper.sqrt(f * f + f2 * f2);
			double d1 = 1.0D - (double) MathHelper.abs(f1 * 0.7F) / d0;
			f = (float) ((double) f * d1);
			f2 = (float) ((double) f2 * d1);
			d0 = (double) MathHelper.sqrt(f * f + f2 * f2);
			double d2 = (double) MathHelper.sqrt(f * f + f2 * f2 + f1 * f1);
			float f3 = VultureEntity.this.yRot;
			float f4 = (float) MathHelper.atan2((double) f2, (double) f);
			float f5 = MathHelper.wrapDegrees(VultureEntity.this.yRot + 90.0F);
			float f6 = MathHelper.wrapDegrees(f4 * (180F / (float) Math.PI));
			VultureEntity.this.yRot = MathHelper.approachDegrees(f5, f6, 4.0F) - 90.0F;
			VultureEntity.this.yBodyRot = VultureEntity.this.yRot;
			if (MathHelper.degreesDifferenceAbs(f3, VultureEntity.this.yRot) < 3.0F) {
				this.speedFactor = MathHelper.approach(this.speedFactor, 1.8F, 0.005F * (1.8F / this.speedFactor));
			} else {
				this.speedFactor = MathHelper.approach(this.speedFactor, 0.2F, 0.025F);
			}

			float f7 = (float) (-(MathHelper.atan2((double) (-f1), d0) * (double) (180F / (float) Math.PI)));
			VultureEntity.this.xRot = f7;
			float f8 = VultureEntity.this.yRot + 90.0F;
			double d3 = (double) (this.speedFactor * MathHelper.cos(f8 * ((float) Math.PI / 180F)))
					* Math.abs((double) f / d2);
			double d4 = (double) (this.speedFactor * MathHelper.sin(f8 * ((float) Math.PI / 180F)))
					* Math.abs((double) f2 / d2);
			double d5 = (double) (this.speedFactor * MathHelper.sin(f7 * ((float) Math.PI / 180F)))
					* Math.abs((double) f1 / d2);
			Vector3d vector3d = VultureEntity.this.getDeltaMovement();
			VultureEntity.this.setDeltaMovement(vector3d.add((new Vector3d(d3, d5, d4)).subtract(vector3d).scale(0.2D)));
		}
	}

	class OrbitPointGoal extends VultureEntity.MoveGoal {
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
		public boolean canUse() {
			return VultureEntity.this.getTarget() == null
					|| VultureEntity.this.attackPhase == VultureEntity.AttackPhase.CIRCLE;
		}

		/**
		 * Execute a one shot task or start executing a continuous task
		 */
		public void start() {
			this.distance = 5.0F + VultureEntity.this.random.nextFloat() * 10.0F;
			this.height = -4.0F + VultureEntity.this.random.nextFloat() * 9.0F;
			this.clockwise = VultureEntity.this.random.nextBoolean() ? 1.0F : -1.0F;
			this.selectNext();
		}

		/**
		 * Keep ticking a continuous task that has already been started
		 */
		public void tick() {
			if (VultureEntity.this.random.nextInt(350) == 0) {
				this.height = -4.0F + VultureEntity.this.random.nextFloat() * 9.0F;
			}

			if (VultureEntity.this.random.nextInt(250) == 0) {
				++this.distance;
				if (this.distance > 15.0F) {
					this.distance = 5.0F;
					this.clockwise = -this.clockwise;
				}
			}

			if (VultureEntity.this.random.nextInt(450) == 0) {
				this.angle = VultureEntity.this.random.nextFloat() * 2.0F * (float) Math.PI;
				this.selectNext();
			}

			if (this.touchingTarget()) {
				this.selectNext();
			}

			if (VultureEntity.this.orbitOffset.y < VultureEntity.this.getY()
					&& !VultureEntity.this.level.isEmptyBlock(VultureEntity.this.blockPosition().below(1))) {
				this.height = Math.max(1.0F, this.height);
				this.selectNext();
			}

			if (VultureEntity.this.orbitOffset.y > VultureEntity.this.getY()
					&& !VultureEntity.this.level.isEmptyBlock(VultureEntity.this.blockPosition().above(1))) {
				this.height = Math.min(-1.0F, this.height);
				this.selectNext();
			}

		}

		private void selectNext() {
			if (BlockPos.ZERO.equals(VultureEntity.this.orbitPosition)) {
				VultureEntity.this.orbitPosition = VultureEntity.this.blockPosition();
			}

			this.angle += this.clockwise * 15.0F * ((float) Math.PI / 180F);
			VultureEntity.this.orbitOffset = Vector3d.atLowerCornerOf(VultureEntity.this.orbitPosition).add(
					(double) (this.distance * MathHelper.cos(this.angle)),
					(double) (-4.0F + this.height),
					(double) (this.distance * MathHelper.sin(this.angle)));
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
		public boolean canUse() {
			LivingEntity livingentity = VultureEntity.this.getTarget();
			return livingentity != null
					? VultureEntity.this.canAttack(VultureEntity.this.getTarget(), EntityPredicate.DEFAULT)
					: false;
		}

		/**
		 * Execute a one shot task or start executing a continuous task
		 */
		public void start() {
			this.tickDelay = 10;
			VultureEntity.this.attackPhase = VultureEntity.AttackPhase.CIRCLE;
			this.setAnchorAboveTarget();
		}

		/**
		 * Reset the task's internal state. Called when this task is interrupted by
		 * another one
		 */
		public void stop() {
			VultureEntity.this.orbitPosition = VultureEntity.this.level
					.getHeightmapPos(Heightmap.Type.MOTION_BLOCKING, VultureEntity.this.orbitPosition)
					.above(10 + VultureEntity.this.random.nextInt(20));
		}

		/**
		 * Keep ticking a continuous task that has already been started
		 */
		public void tick() {
			if (VultureEntity.this.attackPhase == VultureEntity.AttackPhase.CIRCLE) {
				--this.tickDelay;
				if (this.tickDelay <= 0) {
					VultureEntity.this.attackPhase = VultureEntity.AttackPhase.SWOOP;
					this.setAnchorAboveTarget();
					this.tickDelay = (8 + VultureEntity.this.random.nextInt(4)) * 20;
					VultureEntity.this.playSound(SoundEvents.PHANTOM_SWOOP, 10.0F,
							0.95F + VultureEntity.this.random.nextFloat() * 0.1F);
				}
			}

		}

		private void setAnchorAboveTarget() {
			VultureEntity.this.orbitPosition = VultureEntity.this.getTarget().blockPosition()
					.above(20 + VultureEntity.this.random.nextInt(20));
			if (VultureEntity.this.orbitPosition.getY() < VultureEntity.this.level.getSeaLevel()) {
				VultureEntity.this.orbitPosition = new BlockPos(VultureEntity.this.orbitPosition.getX(),
						VultureEntity.this.level.getSeaLevel() + 1, VultureEntity.this.orbitPosition.getZ());
			}

		}
	}

	class SweepAttackGoal extends VultureEntity.MoveGoal {
		private SweepAttackGoal() {
		}

		/**
		 * Returns whether execution should begin. You can also read and cache any state
		 * necessary for execution in this method as well.
		 */
		public boolean canUse() {
			return VultureEntity.this.getTarget() != null
					&& VultureEntity.this.attackPhase == VultureEntity.AttackPhase.SWOOP;
		}

		/**
		 * Returns whether an in-progress EntityAIBase should continue executing
		 */
		public boolean canContinueToUse() {
			LivingEntity livingentity = VultureEntity.this.getTarget();
			if (livingentity == null) {
				return false;
			} else if (!livingentity.isAlive()) {
				return false;
			} else if (!(livingentity instanceof PlayerEntity)
					|| !((PlayerEntity) livingentity).isSpectator() && !((PlayerEntity) livingentity).isCreative()) {
				if (!this.canUse()) {
					return false;
				} else {
					if (VultureEntity.this.tickCount % 20 == 0) {
						List<CatEntity> list = VultureEntity.this.level.getEntitiesOfClass(CatEntity.class,
								VultureEntity.this.getBoundingBox().inflate(16.0D), EntityPredicates.ENTITY_STILL_ALIVE);
						if (!list.isEmpty()) {
							for (CatEntity catentity : list) {
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
		public void start() {
		}

		/**
		 * Reset the task's internal state. Called when this task is interrupted by
		 * another one
		 */
		public void stop() {
			VultureEntity.this.setTarget((LivingEntity) null);
			VultureEntity.this.attackPhase = VultureEntity.AttackPhase.CIRCLE;
		}

		/**
		 * Keep ticking a continuous task that has already been started
		 */
		public void tick() {
			LivingEntity livingentity = VultureEntity.this.getTarget();
			VultureEntity.this.orbitOffset = new Vector3d(livingentity.getX(), livingentity.getY(0.5D),
					livingentity.getZ());
			if (VultureEntity.this.getBoundingBox().inflate((double) 0.2F).intersects(livingentity.getBoundingBox())) {
				VultureEntity.this.doHurtTarget(livingentity);
				VultureEntity.this.attackPhase = VultureEntity.AttackPhase.CIRCLE;
				if (!VultureEntity.this.isSilent()) {
					VultureEntity.this.level.levelEvent(1039, VultureEntity.this.blockPosition(), 0);
				}
			} else if (VultureEntity.this.horizontalCollision || VultureEntity.this.hurtTime > 0) {
				VultureEntity.this.attackPhase = VultureEntity.AttackPhase.CIRCLE;
			}

		}
	}
}