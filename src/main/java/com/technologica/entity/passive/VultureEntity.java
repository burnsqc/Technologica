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
	private static final DataParameter<Integer> SIZE = EntityDataManager.createKey(VultureEntity.class, DataSerializers.VARINT);
	private Vector3d orbitOffset = Vector3d.ZERO;
	private BlockPos orbitPosition = BlockPos.ZERO;
	private VultureEntity.AttackPhase attackPhase = VultureEntity.AttackPhase.CIRCLE;

	public VultureEntity(EntityType<? extends VultureEntity> type, World worldIn) {
		super(type, worldIn);
		this.experienceValue = 5;
		this.moveController = new VultureEntity.MoveHelperController(this);
		this.lookController = new VultureEntity.LookHelperController(this);
	}

	public static AttributeModifierMap.MutableAttribute registerAttributes() {
		return AttributeModifierMap.createMutableAttribute()
				.createMutableAttribute(Attributes.MAX_HEALTH, 10.0D)
				.createMutableAttribute(Attributes.MOVEMENT_SPEED, 0.25D)
				.createMutableAttribute(Attributes.FOLLOW_RANGE, 16.0D)
				.createMutableAttribute(Attributes.ATTACK_KNOCKBACK)
				.createMutableAttribute(Attributes.KNOCKBACK_RESISTANCE)
				.createMutableAttribute(Attributes.ARMOR)
				.createMutableAttribute(Attributes.ARMOR_TOUGHNESS)
				.createMutableAttribute(net.minecraftforge.common.ForgeMod.SWIM_SPEED.get())
				.createMutableAttribute(net.minecraftforge.common.ForgeMod.NAMETAG_DISTANCE.get())
				.createMutableAttribute(net.minecraftforge.common.ForgeMod.ENTITY_GRAVITY.get())
				.createMutableAttribute(Attributes.ATTACK_DAMAGE, 4.0D);
	}
	
	protected BodyController createBodyController() {
		return new VultureEntity.BodyHelperController(this);
	}

	protected void registerGoals() {
		this.goalSelector.addGoal(1, new VultureEntity.PickAttackGoal());
		this.goalSelector.addGoal(2, new VultureEntity.SweepAttackGoal());
		this.goalSelector.addGoal(3, new VultureEntity.OrbitPointGoal());
		this.targetSelector.addGoal(1, new VultureEntity.AttackPlayerGoal());
	}

	protected void registerData() {
		super.registerData();
		this.dataManager.register(SIZE, 0);
	}

	public void setVultureSize(int sizeIn) {
		this.dataManager.set(SIZE, MathHelper.clamp(sizeIn, 0, 64));
	}

	private void updateVultureSize() {
		this.recalculateSize();
		this.getAttribute(Attributes.ATTACK_DAMAGE).setBaseValue((double) (6 + this.getVultureSize()));
	}

	public int getVultureSize() {
		return this.dataManager.get(SIZE);
	}

	protected float getStandingEyeHeight(Pose poseIn, EntitySize sizeIn) {
		return sizeIn.height * 0.35F;
	}

	public void notifyDataManagerChange(DataParameter<?> key) {
		if (SIZE.equals(key)) {
			this.updateVultureSize();
		}

		super.notifyDataManagerChange(key);
	}

	protected boolean isDespawnPeaceful() {
		return false;
	}

	public void tick() {
		super.tick();
		if (this.world.isRemote) {
			float f = MathHelper.cos((float) (this.getEntityId() * 3 + this.ticksExisted) * 0.13F + (float) Math.PI);
			float f1 = MathHelper.cos((float) (this.getEntityId() * 3 + this.ticksExisted + 1) * 0.13F + (float) Math.PI);
			if (f > 0.0F && f1 <= 0.0F) {
				this.world.playSound(this.getPosX(), this.getPosY(), this.getPosZ(), SoundEvents.ENTITY_PHANTOM_FLAP, this.getSoundCategory(), 0.95F + this.rand.nextFloat() * 0.05F, 0.95F + this.rand.nextFloat() * 0.05F, false);
			}
		}
	}

	public void livingTick() {
		super.livingTick();
	}

	protected void updateAITasks() {
		super.updateAITasks();
	}

	public ILivingEntityData onInitialSpawn(IServerWorld worldIn, DifficultyInstance difficultyIn, SpawnReason reason, @Nullable ILivingEntityData spawnDataIn, @Nullable CompoundNBT dataTag) {
		this.orbitPosition = this.getPosition().up(5);
		this.setVultureSize(0);
		return super.onInitialSpawn(worldIn, difficultyIn, reason, spawnDataIn, dataTag);
	}

	/**
	 * (abstract) Protected helper method to read subclass entity data from NBT.
	 */
	public void readAdditional(CompoundNBT compound) {
		super.readAdditional(compound);
		if (compound.contains("AX")) {
			this.orbitPosition = new BlockPos(compound.getInt("AX"), compound.getInt("AY"), compound.getInt("AZ"));
		}

		this.setVultureSize(compound.getInt("Size"));
	}

	public void writeAdditional(CompoundNBT compound) {
		super.writeAdditional(compound);
		compound.putInt("AX", this.orbitPosition.getX());
		compound.putInt("AY", this.orbitPosition.getY());
		compound.putInt("AZ", this.orbitPosition.getZ());
		compound.putInt("Size", this.getVultureSize());
	}

	/**
	 * Checks if the entity is in range to render.
	 */
	@OnlyIn(Dist.CLIENT)
	public boolean isInRangeToRenderDist(double distance) {
		return true;
	}

	public SoundCategory getSoundCategory() {
		return SoundCategory.HOSTILE;
	}

	protected SoundEvent getAmbientSound() {
		return SoundEvents.ENTITY_PHANTOM_AMBIENT;
	}

	protected SoundEvent getHurtSound(DamageSource damageSourceIn) {
		return SoundEvents.ENTITY_PHANTOM_HURT;
	}

	protected SoundEvent getDeathSound() {
		return SoundEvents.ENTITY_PHANTOM_DEATH;
	}

	public CreatureAttribute getCreatureAttribute() {
		return CreatureAttribute.UNDEFINED;
	}

	/**
	 * Returns the volume for the sounds this mob makes.
	 */
	protected float getSoundVolume() {
		return 1.0F;
	}

	public boolean canAttack(EntityType<?> typeIn) {
		return true;
	}

	public EntitySize getSize(Pose poseIn) {
		int i = this.getVultureSize();
		EntitySize entitysize = super.getSize(poseIn);
		float f = (entitysize.width + 0.2F * (float) i) / entitysize.width;
		return entitysize.scale(f);
	}

	static enum AttackPhase {
		CIRCLE, SWOOP;
	}

	class AttackPlayerGoal extends Goal {
		private final EntityPredicate field_220842_b = (new EntityPredicate()).setDistance(64.0D);
		private int tickDelay = 20;

		private AttackPlayerGoal() {
		}

		/**
		 * Returns whether execution should begin. You can also read and cache any state
		 * necessary for execution in this method as well.
		 */
		public boolean shouldExecute() {
			if (this.tickDelay > 0) {
				--this.tickDelay;
				return false;
			} else {
				this.tickDelay = 60;
				List<PlayerEntity> list = VultureEntity.this.world.getTargettablePlayersWithinAABB(this.field_220842_b,
						VultureEntity.this, VultureEntity.this.getBoundingBox().grow(16.0D, 64.0D, 16.0D));
				if (!list.isEmpty()) {
					list.sort(Comparator.<Entity, Double>comparing(Entity::getPosY).reversed());

					for (PlayerEntity playerentity : list) {
						if (VultureEntity.this.canAttack(playerentity, EntityPredicate.DEFAULT)) {
							VultureEntity.this.setAttackTarget(playerentity);
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
		public boolean shouldContinueExecuting() {
			LivingEntity livingentity = VultureEntity.this.getAttackTarget();
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
		public void updateRenderAngles() {
			VultureEntity.this.rotationYawHead = VultureEntity.this.renderYawOffset;
			VultureEntity.this.renderYawOffset = VultureEntity.this.rotationYaw;
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
			this.setMutexFlags(EnumSet.of(Goal.Flag.MOVE));
		}

		protected boolean func_203146_f() {
			return VultureEntity.this.orbitOffset.squareDistanceTo(VultureEntity.this.getPosX(),
					VultureEntity.this.getPosY(), VultureEntity.this.getPosZ()) < 4.0D;
		}
	}

	class MoveHelperController extends MovementController {
		private float speedFactor = 0.1F;

		public MoveHelperController(MobEntity entityIn) {
			super(entityIn);
		}

		public void tick() {
			if (VultureEntity.this.collidedHorizontally) {
				VultureEntity.this.rotationYaw += 180.0F;
				this.speedFactor = 0.1F;
			}

			float f = (float) (VultureEntity.this.orbitOffset.x - VultureEntity.this.getPosX());
			float f1 = (float) (VultureEntity.this.orbitOffset.y - VultureEntity.this.getPosY());
			float f2 = (float) (VultureEntity.this.orbitOffset.z - VultureEntity.this.getPosZ());
			double d0 = (double) MathHelper.sqrt(f * f + f2 * f2);
			double d1 = 1.0D - (double) MathHelper.abs(f1 * 0.7F) / d0;
			f = (float) ((double) f * d1);
			f2 = (float) ((double) f2 * d1);
			d0 = (double) MathHelper.sqrt(f * f + f2 * f2);
			double d2 = (double) MathHelper.sqrt(f * f + f2 * f2 + f1 * f1);
			float f3 = VultureEntity.this.rotationYaw;
			float f4 = (float) MathHelper.atan2((double) f2, (double) f);
			float f5 = MathHelper.wrapDegrees(VultureEntity.this.rotationYaw + 90.0F);
			float f6 = MathHelper.wrapDegrees(f4 * (180F / (float) Math.PI));
			VultureEntity.this.rotationYaw = MathHelper.approachDegrees(f5, f6, 4.0F) - 90.0F;
			VultureEntity.this.renderYawOffset = VultureEntity.this.rotationYaw;
			if (MathHelper.degreesDifferenceAbs(f3, VultureEntity.this.rotationYaw) < 3.0F) {
				this.speedFactor = MathHelper.approach(this.speedFactor, 1.8F, 0.005F * (1.8F / this.speedFactor));
			} else {
				this.speedFactor = MathHelper.approach(this.speedFactor, 0.2F, 0.025F);
			}

			float f7 = (float) (-(MathHelper.atan2((double) (-f1), d0) * (double) (180F / (float) Math.PI)));
			VultureEntity.this.rotationPitch = f7;
			float f8 = VultureEntity.this.rotationYaw + 90.0F;
			double d3 = (double) (this.speedFactor * MathHelper.cos(f8 * ((float) Math.PI / 180F)))
					* Math.abs((double) f / d2);
			double d4 = (double) (this.speedFactor * MathHelper.sin(f8 * ((float) Math.PI / 180F)))
					* Math.abs((double) f2 / d2);
			double d5 = (double) (this.speedFactor * MathHelper.sin(f7 * ((float) Math.PI / 180F)))
					* Math.abs((double) f1 / d2);
			Vector3d vector3d = VultureEntity.this.getMotion();
			VultureEntity.this.setMotion(vector3d.add((new Vector3d(d3, d5, d4)).subtract(vector3d).scale(0.2D)));
		}
	}

	class OrbitPointGoal extends VultureEntity.MoveGoal {
		private float field_203150_c;
		private float field_203151_d;
		private float field_203152_e;
		private float field_203153_f;

		private OrbitPointGoal() {
		}

		/**
		 * Returns whether execution should begin. You can also read and cache any state
		 * necessary for execution in this method as well.
		 */
		public boolean shouldExecute() {
			return VultureEntity.this.getAttackTarget() == null
					|| VultureEntity.this.attackPhase == VultureEntity.AttackPhase.CIRCLE;
		}

		/**
		 * Execute a one shot task or start executing a continuous task
		 */
		public void startExecuting() {
			this.field_203151_d = 5.0F + VultureEntity.this.rand.nextFloat() * 10.0F;
			this.field_203152_e = -4.0F + VultureEntity.this.rand.nextFloat() * 9.0F;
			this.field_203153_f = VultureEntity.this.rand.nextBoolean() ? 1.0F : -1.0F;
			this.func_203148_i();
		}

		/**
		 * Keep ticking a continuous task that has already been started
		 */
		public void tick() {
			if (VultureEntity.this.rand.nextInt(350) == 0) {
				this.field_203152_e = -4.0F + VultureEntity.this.rand.nextFloat() * 9.0F;
			}

			if (VultureEntity.this.rand.nextInt(250) == 0) {
				++this.field_203151_d;
				if (this.field_203151_d > 15.0F) {
					this.field_203151_d = 5.0F;
					this.field_203153_f = -this.field_203153_f;
				}
			}

			if (VultureEntity.this.rand.nextInt(450) == 0) {
				this.field_203150_c = VultureEntity.this.rand.nextFloat() * 2.0F * (float) Math.PI;
				this.func_203148_i();
			}

			if (this.func_203146_f()) {
				this.func_203148_i();
			}

			if (VultureEntity.this.orbitOffset.y < VultureEntity.this.getPosY()
					&& !VultureEntity.this.world.isAirBlock(VultureEntity.this.getPosition().down(1))) {
				this.field_203152_e = Math.max(1.0F, this.field_203152_e);
				this.func_203148_i();
			}

			if (VultureEntity.this.orbitOffset.y > VultureEntity.this.getPosY()
					&& !VultureEntity.this.world.isAirBlock(VultureEntity.this.getPosition().up(1))) {
				this.field_203152_e = Math.min(-1.0F, this.field_203152_e);
				this.func_203148_i();
			}

		}

		private void func_203148_i() {
			if (BlockPos.ZERO.equals(VultureEntity.this.orbitPosition)) {
				VultureEntity.this.orbitPosition = VultureEntity.this.getPosition();
			}

			this.field_203150_c += this.field_203153_f * 15.0F * ((float) Math.PI / 180F);
			VultureEntity.this.orbitOffset = Vector3d.copy(VultureEntity.this.orbitPosition).add(
					(double) (this.field_203151_d * MathHelper.cos(this.field_203150_c)),
					(double) (-4.0F + this.field_203152_e),
					(double) (this.field_203151_d * MathHelper.sin(this.field_203150_c)));
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
		public boolean shouldExecute() {
			LivingEntity livingentity = VultureEntity.this.getAttackTarget();
			return livingentity != null
					? VultureEntity.this.canAttack(VultureEntity.this.getAttackTarget(), EntityPredicate.DEFAULT)
					: false;
		}

		/**
		 * Execute a one shot task or start executing a continuous task
		 */
		public void startExecuting() {
			this.tickDelay = 10;
			VultureEntity.this.attackPhase = VultureEntity.AttackPhase.CIRCLE;
			this.func_203143_f();
		}

		/**
		 * Reset the task's internal state. Called when this task is interrupted by
		 * another one
		 */
		public void resetTask() {
			VultureEntity.this.orbitPosition = VultureEntity.this.world
					.getHeight(Heightmap.Type.MOTION_BLOCKING, VultureEntity.this.orbitPosition)
					.up(10 + VultureEntity.this.rand.nextInt(20));
		}

		/**
		 * Keep ticking a continuous task that has already been started
		 */
		public void tick() {
			if (VultureEntity.this.attackPhase == VultureEntity.AttackPhase.CIRCLE) {
				--this.tickDelay;
				if (this.tickDelay <= 0) {
					VultureEntity.this.attackPhase = VultureEntity.AttackPhase.SWOOP;
					this.func_203143_f();
					this.tickDelay = (8 + VultureEntity.this.rand.nextInt(4)) * 20;
					VultureEntity.this.playSound(SoundEvents.ENTITY_PHANTOM_SWOOP, 10.0F,
							0.95F + VultureEntity.this.rand.nextFloat() * 0.1F);
				}
			}

		}

		private void func_203143_f() {
			VultureEntity.this.orbitPosition = VultureEntity.this.getAttackTarget().getPosition()
					.up(20 + VultureEntity.this.rand.nextInt(20));
			if (VultureEntity.this.orbitPosition.getY() < VultureEntity.this.world.getSeaLevel()) {
				VultureEntity.this.orbitPosition = new BlockPos(VultureEntity.this.orbitPosition.getX(),
						VultureEntity.this.world.getSeaLevel() + 1, VultureEntity.this.orbitPosition.getZ());
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
		public boolean shouldExecute() {
			return VultureEntity.this.getAttackTarget() != null
					&& VultureEntity.this.attackPhase == VultureEntity.AttackPhase.SWOOP;
		}

		/**
		 * Returns whether an in-progress EntityAIBase should continue executing
		 */
		public boolean shouldContinueExecuting() {
			LivingEntity livingentity = VultureEntity.this.getAttackTarget();
			if (livingentity == null) {
				return false;
			} else if (!livingentity.isAlive()) {
				return false;
			} else if (!(livingentity instanceof PlayerEntity)
					|| !((PlayerEntity) livingentity).isSpectator() && !((PlayerEntity) livingentity).isCreative()) {
				if (!this.shouldExecute()) {
					return false;
				} else {
					if (VultureEntity.this.ticksExisted % 20 == 0) {
						List<CatEntity> list = VultureEntity.this.world.getEntitiesWithinAABB(CatEntity.class,
								VultureEntity.this.getBoundingBox().grow(16.0D), EntityPredicates.IS_ALIVE);
						if (!list.isEmpty()) {
							for (CatEntity catentity : list) {
								catentity.func_213420_ej();
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
		public void startExecuting() {
		}

		/**
		 * Reset the task's internal state. Called when this task is interrupted by
		 * another one
		 */
		public void resetTask() {
			VultureEntity.this.setAttackTarget((LivingEntity) null);
			VultureEntity.this.attackPhase = VultureEntity.AttackPhase.CIRCLE;
		}

		/**
		 * Keep ticking a continuous task that has already been started
		 */
		public void tick() {
			LivingEntity livingentity = VultureEntity.this.getAttackTarget();
			VultureEntity.this.orbitOffset = new Vector3d(livingentity.getPosX(), livingentity.getPosYHeight(0.5D),
					livingentity.getPosZ());
			if (VultureEntity.this.getBoundingBox().grow((double) 0.2F).intersects(livingentity.getBoundingBox())) {
				VultureEntity.this.attackEntityAsMob(livingentity);
				VultureEntity.this.attackPhase = VultureEntity.AttackPhase.CIRCLE;
				if (!VultureEntity.this.isSilent()) {
					VultureEntity.this.world.playEvent(1039, VultureEntity.this.getPosition(), 0);
				}
			} else if (VultureEntity.this.collidedHorizontally || VultureEntity.this.hurtTime > 0) {
				VultureEntity.this.attackPhase = VultureEntity.AttackPhase.CIRCLE;
			}

		}
	}
}