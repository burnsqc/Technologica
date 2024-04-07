package com.technologica.world.entity.vehicle;

import java.util.List;

import javax.annotation.Nullable;

import com.google.common.collect.Lists;
import com.technologica.registration.deferred.TechnologicaEntityTypes;

import net.minecraft.BlockUtil;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.util.Mth;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityDimensions;
import net.minecraft.world.entity.EntitySelector;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.MoverType;
import net.minecraft.world.entity.Pose;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.animal.WaterAnimal;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.vehicle.DismountHelper;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.GameRules;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.WaterlilyBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.shapes.BooleanOp;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

public class Submersible extends Entity {
	private static final EntityDataAccessor<Integer> DATA_ID_HURT = SynchedEntityData.defineId(Submersible.class, EntityDataSerializers.INT);
	private static final EntityDataAccessor<Integer> DATA_ID_HURTDIR = SynchedEntityData.defineId(Submersible.class, EntityDataSerializers.INT);
	private static final EntityDataAccessor<Float> DATA_ID_DAMAGE = SynchedEntityData.defineId(Submersible.class, EntityDataSerializers.FLOAT);
	private static final EntityDataAccessor<Integer> DATA_ID_TYPE = SynchedEntityData.defineId(Submersible.class, EntityDataSerializers.INT);
	private static final EntityDataAccessor<Boolean> DATA_ID_PADDLE_LEFT = SynchedEntityData.defineId(Submersible.class, EntityDataSerializers.BOOLEAN);
	private static final EntityDataAccessor<Boolean> DATA_ID_PADDLE_RIGHT = SynchedEntityData.defineId(Submersible.class, EntityDataSerializers.BOOLEAN);
	private static final EntityDataAccessor<Integer> DATA_ID_BUBBLE_TIME = SynchedEntityData.defineId(Submersible.class, EntityDataSerializers.INT);
	public static final int PADDLE_LEFT = 0;
	public static final int PADDLE_RIGHT = 1;
	public static final double PADDLE_SOUND_TIME = (float) Math.PI / 4F;
	public static final int BUBBLE_TIME = 60;
	private final float[] paddlePositions = new float[2];

	private float outOfControlTicks;
	private float deltaRotation;
	private int lerpSteps;
	private double lerpX;
	private double lerpY;
	private double lerpZ;
	private double lerpYRot;
	private double lerpXRot;
	private boolean inputLeft;
	private boolean inputRight;
	private boolean inputUp;
	private boolean inputDown;
	private double waterLevel;
	private float landFriction;
	private Submersible.Status status;
	private Submersible.Status oldStatus;
	private double lastYd;
	private boolean isAboveBubbleColumn;
	private boolean bubbleColumnDirectionIsDown;
	private float bubbleMultiplier;
	private float bubbleAngle;
	private float bubbleAngleO;
	public float roll;
	public float throttle;

	public Submersible(EntityType<? extends Submersible> p_38290_, Level p_38291_) {
		super(p_38290_, p_38291_);
		this.blocksBuilding = true;
	}

	public Submersible(Level p_38293_, double p_38294_, double p_38295_, double p_38296_) {
		this(TechnologicaEntityTypes.SUBMERSIBLE.get(), p_38293_);
		this.setPos(p_38294_, p_38295_, p_38296_);
		this.xo = p_38294_;
		this.yo = p_38295_;
		this.zo = p_38296_;
	}

	@Override
	protected float getEyeHeight(Pose p_38327_, EntityDimensions p_38328_) {
		return p_38328_.height;
	}

	@Override
	protected Entity.MovementEmission getMovementEmission() {
		return Entity.MovementEmission.EVENTS;
	}

	@Override
	protected void defineSynchedData() {
		this.entityData.define(DATA_ID_HURT, 0);
		this.entityData.define(DATA_ID_HURTDIR, 1);
		this.entityData.define(DATA_ID_DAMAGE, 0.0F);
	}

	@Override
	public boolean canCollideWith(Entity p_38376_) {
		return canVehicleCollide(this, p_38376_);
	}

	public static boolean canVehicleCollide(Entity p_38324_, Entity p_38325_) {
		return (p_38325_.canBeCollidedWith() || p_38325_.isPushable()) && !p_38324_.isPassengerOfSameVehicle(p_38325_);
	}

	@Override
	public boolean canBeCollidedWith() {
		return true;
	}

	@Override
	public boolean isPushable() {
		return true;
	}

	@Override
	protected Vec3 getRelativePortalPosition(Direction.Axis p_38335_, BlockUtil.FoundRectangle p_38336_) {
		return LivingEntity.resetForwardDirectionOfRelativePortalPosition(super.getRelativePortalPosition(p_38335_, p_38336_));
	}

	@Override
	public double getPassengersRidingOffset() {
		return -0.9D;
	}

	@Override
	public boolean hurt(DamageSource p_38319_, float p_38320_) {
		if (this.isInvulnerableTo(p_38319_)) {
			return false;
		} else if (!this.level().isClientSide && !this.isRemoved()) {
			this.setHurtDir(-this.getHurtDir());
			this.setHurtTime(10);
			this.setDamage(this.getDamage() + p_38320_ * 10.0F);
			this.markHurt();
			this.gameEvent(GameEvent.ENTITY_DAMAGE, p_38319_.getEntity());
			boolean flag = p_38319_.getEntity() instanceof Player && ((Player) p_38319_.getEntity()).getAbilities().instabuild;
			if (flag || this.getDamage() > 40.0F) {
				if (!flag && this.level().getGameRules().getBoolean(GameRules.RULE_DOENTITYDROPS)) {
					this.destroy(p_38319_);
				}

				this.discard();
			}

			return true;
		} else {
			return true;
		}
	}

	protected void destroy(DamageSource p_219862_) {
		this.spawnAtLocation(this.getDropItem());
	}

	@Override
	public void onAboveBubbleCol(boolean p_38381_) {
	}

	@Override
	public void push(Entity p_38373_) {
		if (p_38373_ instanceof Submersible) {
			if (p_38373_.getBoundingBox().minY < this.getBoundingBox().maxY) {
				super.push(p_38373_);
			}
		} else if (p_38373_.getBoundingBox().minY <= this.getBoundingBox().minY) {
			super.push(p_38373_);
		}

	}

	public Item getDropItem() {
		return Items.OAK_BOAT;
	}

	@Override
	public void animateHurt(float p_265761_) {
		this.setHurtDir(-this.getHurtDir());
		this.setHurtTime(10);
		this.setDamage(this.getDamage() * 11.0F);
	}

	@Override
	public boolean isPickable() {
		return !this.isRemoved();
	}

	@Override
	public void lerpTo(double p_38299_, double p_38300_, double p_38301_, float p_38302_, float p_38303_, int p_38304_, boolean p_38305_) {
		this.lerpX = p_38299_;
		this.lerpY = p_38300_;
		this.lerpZ = p_38301_;
		this.lerpYRot = p_38302_;
		this.lerpXRot = p_38303_;
		this.lerpSteps = 10;
	}

	@Override
	public Direction getMotionDirection() {
		return this.getDirection().getClockWise();
	}

	@Override
	public void tick() {
		this.oldStatus = this.status;
		this.status = this.getStatus();
		if (this.status != Submersible.Status.UNDER_WATER && this.status != Submersible.Status.UNDER_FLOWING_WATER) {
			this.outOfControlTicks = 0.0F;
		} else {
			++this.outOfControlTicks;
		}

		if (!this.level().isClientSide && this.outOfControlTicks >= 60.0F) {
			this.ejectPassengers();
		}

		if (this.getHurtTime() > 0) {
			this.setHurtTime(this.getHurtTime() - 1);
		}

		if (this.getDamage() > 0.0F) {
			this.setDamage(this.getDamage() - 1.0F);
		}

		super.tick();
		this.tickLerp();
		if (this.isControlledByLocalInstance()) {
			if (this.level().isClientSide) {
				this.controlBoat();
			}

			this.move(MoverType.SELF, this.getDeltaMovement());
		} else {
			this.setDeltaMovement(Vec3.ZERO);
		}

		this.checkInsideBlocks();
		List<Entity> list = this.level().getEntities(this, this.getBoundingBox().inflate(0.2F, -0.01F, 0.2F), EntitySelector.pushableBy(this));
		if (!list.isEmpty()) {
			boolean flag = !this.level().isClientSide && !(this.getControllingPassenger() instanceof Player);

			for (int j = 0; j < list.size(); ++j) {
				Entity entity = list.get(j);
				if (!entity.hasPassenger(this)) {
					if (flag && this.getPassengers().size() < this.getMaxPassengers() && !entity.isPassenger() && this.hasEnoughSpaceFor(entity) && entity instanceof LivingEntity && !(entity instanceof WaterAnimal) && !(entity instanceof Player)) {
						entity.startRiding(this);
					} else {
						this.push(entity);
					}
				}
			}
		}

	}

	private void tickLerp() {
		if (this.isControlledByLocalInstance()) {
			this.lerpSteps = 0;
			this.syncPacketPositionCodec(this.getX(), this.getY(), this.getZ());
		}

		if (this.lerpSteps > 0) {
			double d0 = this.getX() + (this.lerpX - this.getX()) / this.lerpSteps;
			double d1 = this.getY() + (this.lerpY - this.getY()) / this.lerpSteps;
			double d2 = this.getZ() + (this.lerpZ - this.getZ()) / this.lerpSteps;
			double d3 = Mth.wrapDegrees(this.lerpYRot - this.getYRot());
			this.setYRot(this.getYRot() + (float) d3 / this.lerpSteps);
			this.setXRot(this.getXRot() + (float) (this.lerpXRot - this.getXRot()) / this.lerpSteps);
			--this.lerpSteps;
			this.setPos(d0, d1, d2);
			this.setRot(this.getYRot(), this.getXRot());
		}
	}

	public void setPaddleState(boolean p_38340_, boolean p_38341_) {
	}

	public float getRowingTime(int p_38316_, float p_38317_) {
		return this.getPaddleState(p_38316_) ? Mth.clampedLerp(this.paddlePositions[p_38316_] - ((float) Math.PI / 8F), this.paddlePositions[p_38316_], p_38317_) : 0.0F;
	}

	private Submersible.Status getStatus() {
		Submersible.Status boat$status = this.isUnderwater();
		if (boat$status != null) {
			this.waterLevel = this.getBoundingBox().maxY;
			return boat$status;
		} else if (this.checkInWater()) {
			return Submersible.Status.IN_WATER;
		} else {
			float f = this.getGroundFriction();
			if (f > 0.0F) {
				this.landFriction = f;
				return Submersible.Status.ON_LAND;
			} else {
				return Submersible.Status.IN_AIR;
			}
		}
	}

	public float getGroundFriction() {
		AABB aabb = this.getBoundingBox();
		AABB aabb1 = new AABB(aabb.minX, aabb.minY - 0.001D, aabb.minZ, aabb.maxX, aabb.minY, aabb.maxZ);
		int i = Mth.floor(aabb1.minX) - 1;
		int j = Mth.ceil(aabb1.maxX) + 1;
		int k = Mth.floor(aabb1.minY) - 1;
		int l = Mth.ceil(aabb1.maxY) + 1;
		int i1 = Mth.floor(aabb1.minZ) - 1;
		int j1 = Mth.ceil(aabb1.maxZ) + 1;
		VoxelShape voxelshape = Shapes.create(aabb1);
		float f = 0.0F;
		int k1 = 0;
		BlockPos.MutableBlockPos blockpos$mutableblockpos = new BlockPos.MutableBlockPos();

		for (int l1 = i; l1 < j; ++l1) {
			for (int i2 = i1; i2 < j1; ++i2) {
				int j2 = (l1 != i && l1 != j - 1 ? 0 : 1) + (i2 != i1 && i2 != j1 - 1 ? 0 : 1);
				if (j2 != 2) {
					for (int k2 = k; k2 < l; ++k2) {
						if (j2 <= 0 || k2 != k && k2 != l - 1) {
							blockpos$mutableblockpos.set(l1, k2, i2);
							BlockState blockstate = this.level().getBlockState(blockpos$mutableblockpos);
							if (!(blockstate.getBlock() instanceof WaterlilyBlock) && Shapes.joinIsNotEmpty(blockstate.getCollisionShape(this.level(), blockpos$mutableblockpos).move(l1, k2, i2), voxelshape, BooleanOp.AND)) {
								f += blockstate.getFriction(this.level(), blockpos$mutableblockpos, this);
								++k1;
							}
						}
					}
				}
			}
		}

		return f / k1;
	}

	private boolean checkInWater() {
		return true;
	}

	@Nullable
	private Submersible.Status isUnderwater() {
		return Submersible.Status.IN_WATER;
	}

	private void controlBoat() {
		if (this.isVehicle()) {
			if (this.getControllingPassenger() instanceof LocalPlayer lp) {
				if (lp.input.left) {
					this.roll = Mth.lerp(0.1F, this.roll, this.roll - 50.0F);
				}

				if (lp.input.right) {
					this.roll = Mth.lerp(0.1F, this.roll, this.roll + 50.0F);
				}

				if (lp.input.up) {
					this.throttle = Mth.clamp(this.throttle + 0.01F, 0.0F, 1.0F);
				}

				if (lp.input.down) {
					this.throttle = Mth.clamp(this.throttle - 0.01F, 0.0F, 1.0F);
				}

				Vec3 steer = (this.getDeltaMovement().add(lp.getLookAngle().multiply(0.25F, 0.25F, 0.25F))).normalize().multiply(this.throttle, this.throttle, this.throttle);
				this.setDeltaMovement(steer);

				float rotation = (float) Mth.clamp(Math.atan2(this.getDeltaMovement().z, this.getDeltaMovement().x) + Math.PI, 0, 2 * Math.PI);
				float rotation2 = (float) Mth.clamp(Math.atan2(Math.sqrt(this.getDeltaMovement().z * this.getDeltaMovement().z + this.getDeltaMovement().x * this.getDeltaMovement().x), this.getDeltaMovement().y) + Math.PI, 0, 2 * Math.PI);

				if (throttle > 0) {
					this.setYRot((float) (rotation * 180F / Math.PI) + 90.0F);
					this.setXRot((float) (rotation2 * 180F / Math.PI) + 90.0F);
				}
			}
		}
	}

	protected float getSinglePassengerXOffset() {
		return 0.0F;
	}

	public boolean hasEnoughSpaceFor(Entity p_273171_) {
		return p_273171_.getBbWidth() < this.getBbWidth();
	}

	@Override
	protected void positionRider(Entity p_289552_, Entity.MoveFunction p_289571_) {
		if (this.hasPassenger(p_289552_)) {
			float f = this.getSinglePassengerXOffset();
			float f1 = (float) ((this.isRemoved() ? (double) 0.01F : this.getPassengersRidingOffset()) + p_289552_.getMyRidingOffset());
			if (this.getPassengers().size() > 1) {
				int i = this.getPassengers().indexOf(p_289552_);
				if (i == 0) {
					f = 0.2F;
				} else {
					f = -0.6F;
				}

				if (p_289552_ instanceof Animal) {
					f += 0.2F;
				}
			}

			Vec3 vec3 = (new Vec3(f, 0.0D, 0.0D)).yRot(-this.getYRot() * ((float) Math.PI / 180F) - ((float) Math.PI / 2F));
			p_289571_.accept(p_289552_, this.getX() + vec3.x, this.getY() + f1, this.getZ() + vec3.z);
			p_289552_.setYRot(p_289552_.getYRot() + this.deltaRotation);
			p_289552_.setYHeadRot(p_289552_.getYHeadRot() + this.deltaRotation);
			this.clampRotation(p_289552_);
			if (p_289552_ instanceof Animal && this.getPassengers().size() == this.getMaxPassengers()) {
				int j = p_289552_.getId() % 2 == 0 ? 90 : 270;
				p_289552_.setYBodyRot(((Animal) p_289552_).yBodyRot + j);
				p_289552_.setYHeadRot(p_289552_.getYHeadRot() + j);
			}

		}
	}

	@Override
	public Vec3 getDismountLocationForPassenger(LivingEntity p_38357_) {
		Vec3 vec3 = getCollisionHorizontalEscapeVector(this.getBbWidth() * Mth.SQRT_OF_TWO, p_38357_.getBbWidth(), p_38357_.getYRot());
		double d0 = this.getX() + vec3.x;
		double d1 = this.getZ() + vec3.z;
		BlockPos blockpos = BlockPos.containing(d0, this.getBoundingBox().maxY, d1);
		BlockPos blockpos1 = blockpos.below();
		if (!this.level().isWaterAt(blockpos1)) {
			List<Vec3> list = Lists.newArrayList();
			double d2 = this.level().getBlockFloorHeight(blockpos);
			if (DismountHelper.isBlockFloorValid(d2)) {
				list.add(new Vec3(d0, blockpos.getY() + d2, d1));
			}

			double d3 = this.level().getBlockFloorHeight(blockpos1);
			if (DismountHelper.isBlockFloorValid(d3)) {
				list.add(new Vec3(d0, blockpos1.getY() + d3, d1));
			}

			for (Pose pose : p_38357_.getDismountPoses()) {
				for (Vec3 vec31 : list) {
					if (DismountHelper.canDismountTo(this.level(), vec31, p_38357_, pose)) {
						p_38357_.setPose(pose);
						return vec31;
					}
				}
			}
		}

		return super.getDismountLocationForPassenger(p_38357_);
	}

	protected void clampRotation(Entity p_38322_) {
		p_38322_.setYBodyRot(this.getYRot());
		float f = Mth.wrapDegrees(p_38322_.getYRot() - this.getYRot());
		float f1 = Mth.clamp(f, -105.0F, 105.0F);
		p_38322_.yRotO += f1 - f;
		p_38322_.setYRot(p_38322_.getYRot() + f1 - f);
		p_38322_.setYHeadRot(p_38322_.getYRot());
	}

	@Override
	public void onPassengerTurned(Entity p_38383_) {
		this.clampRotation(p_38383_);
	}

	@Override
	public InteractionResult interact(Player p_38330_, InteractionHand p_38331_) {
		if (p_38330_.isSecondaryUseActive()) {
			return InteractionResult.PASS;
		} else if (this.outOfControlTicks < 60.0F) {
			if (!this.level().isClientSide) {
				return p_38330_.startRiding(this) ? InteractionResult.CONSUME : InteractionResult.PASS;
			} else {
				return InteractionResult.SUCCESS;
			}
		} else {
			return InteractionResult.PASS;
		}
	}

	@Override
	protected void checkFallDamage(double p_38307_, boolean p_38308_, BlockState p_38309_, BlockPos p_38310_) {
	}

	public boolean getPaddleState(int p_38314_) {
		return this.entityData.<Boolean>get(p_38314_ == 0 ? DATA_ID_PADDLE_LEFT : DATA_ID_PADDLE_RIGHT) && this.getControllingPassenger() != null;
	}

	public void setDamage(float p_38312_) {
		this.entityData.set(DATA_ID_DAMAGE, p_38312_);
	}

	public float getDamage() {
		return this.entityData.get(DATA_ID_DAMAGE);
	}

	public void setHurtTime(int p_38355_) {
		this.entityData.set(DATA_ID_HURT, p_38355_);
	}

	public int getHurtTime() {
		return this.entityData.get(DATA_ID_HURT);
	}

	private void setBubbleTime(int p_38367_) {
		this.entityData.set(DATA_ID_BUBBLE_TIME, p_38367_);
	}

	private int getBubbleTime() {
		return this.entityData.get(DATA_ID_BUBBLE_TIME);
	}

	public float getBubbleAngle(float p_38353_) {
		return Mth.lerp(p_38353_, this.bubbleAngleO, this.bubbleAngle);
	}

	public void setHurtDir(int p_38363_) {
		this.entityData.set(DATA_ID_HURTDIR, p_38363_);
	}

	public int getHurtDir() {
		return this.entityData.get(DATA_ID_HURTDIR);
	}

	@Override
	protected boolean canAddPassenger(Entity p_38390_) {
		return this.getPassengers().size() < this.getMaxPassengers();
	}

	protected int getMaxPassengers() {
		return 2;
	}

	@Override
	@Nullable
	public LivingEntity getControllingPassenger() {
		Entity entity = this.getFirstPassenger();
		LivingEntity livingentity1;
		if (entity instanceof LivingEntity livingentity) {
			livingentity1 = livingentity;
		} else {
			livingentity1 = null;
		}

		return livingentity1;
	}

	@Override
	public boolean isUnderWater() {
		return this.status == Submersible.Status.UNDER_WATER || this.status == Submersible.Status.UNDER_FLOWING_WATER;
	}

	@Override
	protected void addPassenger(Entity passenger) {
		super.addPassenger(passenger);
		if (this.isControlledByLocalInstance() && this.lerpSteps > 0) {
			this.lerpSteps = 0;
			this.absMoveTo(this.lerpX, this.lerpY, this.lerpZ, (float) this.lerpYRot, (float) this.lerpXRot);
		}
	}

	public static enum Status {
		IN_WATER,
		UNDER_WATER,
		UNDER_FLOWING_WATER,
		ON_LAND,
		IN_AIR;
	}

	@Override
	protected void readAdditionalSaveData(CompoundTag p_20052_) {
		// TODO Auto-generated method stub

	}

	@Override
	protected void addAdditionalSaveData(CompoundTag p_20139_) {
		// TODO Auto-generated method stub

	}
}
