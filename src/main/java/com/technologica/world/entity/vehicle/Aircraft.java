package com.technologica.world.entity.vehicle;

import java.util.List;

import javax.annotation.Nullable;

import com.google.common.collect.Lists;
import com.technologica.registration.deferred.TechnologicaEntityTypes;

import net.minecraft.BlockUtil;
import net.minecraft.client.player.Input;
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
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.shapes.BooleanOp;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

public class Aircraft extends Entity {
	private static final EntityDataAccessor<Integer> DATA_ID_HURT = SynchedEntityData.defineId(Aircraft.class, EntityDataSerializers.INT);
	private static final EntityDataAccessor<Integer> DATA_ID_HURTDIR = SynchedEntityData.defineId(Aircraft.class, EntityDataSerializers.INT);
	private static final EntityDataAccessor<Float> DATA_ID_DAMAGE = SynchedEntityData.defineId(Aircraft.class, EntityDataSerializers.FLOAT);

	private float deltaRotation;
	private int lerpSteps;
	private double lerpX;
	private double lerpY;
	private double lerpZ;
	private double lerpRotY;
	private double lerpRotX;
	public Aircraft.Status status;

	public float roll;
	public float rollO;
	public float throttleRequested;
	public float throttleDelivered;
	public float horizontalSpeed;

	public Aircraft(EntityType<? extends Aircraft> aircraft, Level level) {
		super(aircraft, level);
		this.blocksBuilding = true;
	}

	public Aircraft(Level level, double p_38294_, double p_38295_, double p_38296_) {
		this(TechnologicaEntityTypes.SUBMERSIBLE.get(), level);
		this.setPos(p_38294_, p_38295_, p_38296_);
		this.xo = p_38294_;
		this.yo = p_38295_;
		this.zo = p_38296_;
	}

	@Override
	protected float getEyeHeight(Pose pose, EntityDimensions entityDimensions) {
		return entityDimensions.height;
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
	protected Vec3 getRelativePortalPosition(Direction.Axis p_38335_, BlockUtil.FoundRectangle p_38336_) {
		return LivingEntity.resetForwardDirectionOfRelativePortalPosition(super.getRelativePortalPosition(p_38335_, p_38336_));
	}

	@Override
	public double getPassengersRidingOffset() {
		return 0.0D;
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

	protected void destroy(DamageSource damageSource) {
		this.spawnAtLocation(this.getDropItem());
	}

	@Override
	public void push(Entity entity) {
		if (entity instanceof Aircraft) {
			if (entity.getBoundingBox().minY < this.getBoundingBox().maxY) {
				super.push(entity);
			}
		} else if (entity.getBoundingBox().minY <= this.getBoundingBox().minY) {
			super.push(entity);
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
		this.lerpRotY = p_38302_;
		this.lerpRotX = p_38303_;
		this.lerpSteps = 10;
	}

	@Override
	public void tick() {
		this.status = this.getStatus();

		super.tick();

		this.tickLerp();
		if (this.isControlledByLocalInstance()) {
			this.applyGravityWhenUnpiloted();
			if (this.level().isClientSide) {
				this.controlAircraft();
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

	private Status getStatus() {
		if (this.checkInWater()) {
			return Status.IN_WATER;
		} else {
			float f = this.getGroundFriction();
			if (f > 0.0F) {
				return Status.ON_LAND;
			} else {
				return Status.IN_AIR;
			}
		}
	}

	private boolean checkInWater() {
		AABB aabb = this.getBoundingBox();
		boolean flag = false;
		BlockPos.MutableBlockPos mutableBlockPos = new BlockPos.MutableBlockPos();

		for (int posX = Mth.floor(aabb.minX); posX < Mth.ceil(aabb.maxX); ++posX) {
			for (int posY = Mth.floor(aabb.minY); posY < Mth.ceil(aabb.minY + 0.001D); ++posY) {
				for (int posZ = Mth.floor(aabb.minZ); posZ < Mth.ceil(aabb.maxZ); ++posZ) {
					mutableBlockPos.set(posX, posY, posZ);
					FluidState fluidstate = this.level().getFluidState(mutableBlockPos);
					float f = posY + fluidstate.getHeight(this.level(), mutableBlockPos);
					flag |= aabb.minY < f;
				}
			}
		}
		return flag;
	}

	private void tickLerp() {
		if (this.isControlledByLocalInstance()) {
			this.lerpSteps = 0;
			this.syncPacketPositionCodec(this.getX(), this.getY(), this.getZ());
		}

		if (this.lerpSteps > 0) {
			double d3 = Mth.wrapDegrees(this.lerpRotY - this.getYRot());
			this.setYRot(this.getYRot() + (float) d3 / this.lerpSteps);
			this.setXRot(this.getXRot() + (float) (this.lerpRotX - this.getXRot()) / this.lerpSteps);
			--this.lerpSteps;
			double d0 = this.getX() + (this.lerpX - this.getX()) / this.lerpSteps;
			double d1 = this.getY() + (this.lerpY - this.getY()) / this.lerpSteps;
			double d2 = this.getZ() + (this.lerpZ - this.getZ()) / this.lerpSteps;
			this.setPos(d0, d1, d2);
			this.setRot(this.getYRot(), this.getXRot());
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
		BlockPos.MutableBlockPos mutableBlockPos = new BlockPos.MutableBlockPos();

		for (int l1 = i; l1 < j; ++l1) {
			for (int i2 = i1; i2 < j1; ++i2) {
				int j2 = (l1 != i && l1 != j - 1 ? 0 : 1) + (i2 != i1 && i2 != j1 - 1 ? 0 : 1);
				if (j2 != 2) {
					for (int k2 = k; k2 < l; ++k2) {
						if (j2 <= 0 || k2 != k && k2 != l - 1) {
							mutableBlockPos.set(l1, k2, i2);
							BlockState blockstate = this.level().getBlockState(mutableBlockPos);
							if (!(blockstate.getBlock() instanceof WaterlilyBlock) && Shapes.joinIsNotEmpty(blockstate.getCollisionShape(this.level(), mutableBlockPos).move(l1, k2, i2), voxelshape, BooleanOp.AND)) {
								f += blockstate.getFriction(this.level(), mutableBlockPos, this);
								++k1;
							}
						}
					}
				}
			}
		}

		return f / k1;
	}

	private void applyGravityWhenUnpiloted() {
		if (this.throttleDelivered < 0.5F) {
			this.setDeltaMovement(this.getDeltaMovement().add(0, -0.04F, 0));
		}
	}

	private void controlAircraft() {
		float lerpAmount = 0.01F;
		if (this.isVehicle() && this.getControllingPassenger() instanceof LocalPlayer localPlayer) {
			Input input = localPlayer.input;

			if (input.left) {
				this.roll = this.roll - 5.0F;
			}

			if (input.right) {
				this.roll = this.roll + 5.0F;
			}

			if (input.up) {
				this.throttleRequested = Mth.clamp(this.throttleRequested + 0.01F, 0.0F, 1.0F);
				if (throttleRequested == 1.0F && throttleDelivered > 0.9F) {
					lerpAmount = 0.1F;
				}
			}

			if (input.down) {
				this.throttleRequested = Mth.clamp(this.throttleRequested - 0.01F, 0.0F, 1.0F);
				if (throttleRequested == 0.0F && throttleDelivered < 0.1F) {
					lerpAmount = 0.1F;
				}
			}

			float lift = 0.0f;
			if (throttleDelivered > 0.5F) {
				lift = 0.1F;
			}

			float turn = 0.005F;
			if (this.status != Status.ON_LAND) {
				turn = 0.1F;
			}

			Vec3 dulledPlayerLookAngle = localPlayer.getLookAngle().multiply(turn, lift, turn);
			Vec3 steer = this.getDeltaMovement().add(dulledPlayerLookAngle).normalize().multiply(this.throttleDelivered, this.throttleDelivered, this.throttleDelivered);
			this.setDeltaMovement(steer);

			if (throttleDelivered > 0) {
				// this.setYRot((float) ((Math.atan2(this.getDeltaMovement().z, this.getDeltaMovement().x) + Math.PI) * 180F / Math.PI) + 90.0F);
				this.setYRot(Mth.lerp(0.1F, this.yRotO, localPlayer.yRotO));
			}

			if (this.status != Status.ON_LAND) {
				this.setXRot((float) (Mth.clamp(Math.atan2(Math.sqrt(this.getDeltaMovement().z * this.getDeltaMovement().z + this.getDeltaMovement().x * this.getDeltaMovement().x), this.getDeltaMovement().y) + Math.PI, 0, 2 * Math.PI) * 180F / Math.PI) + 90.0F);
			} else {
				this.setXRot(0.0F);
			}

		}
		throttleDelivered = Mth.lerp(lerpAmount, throttleDelivered, throttleRequested);
		horizontalSpeed = (float) this.getDeltaMovement().length();
	}

	protected float getSinglePassengerOffsetX() {
		return 0.0F;
	}

	public boolean hasEnoughSpaceFor(Entity entity) {
		return entity.getBbWidth() < this.getBbWidth();
	}

	@Override
	protected void positionRider(Entity entity, Entity.MoveFunction moveFunction) {
		if (this.hasPassenger(entity)) {
			float f = this.getSinglePassengerOffsetX();
			float f1 = (float) ((this.isRemoved() ? (double) 0.01F : this.getPassengersRidingOffset()) + entity.getMyRidingOffset());
			if (this.getPassengers().size() > 1) {
				int i = this.getPassengers().indexOf(entity);
				if (i == 0) {
					f = 0.2F;
				} else {
					f = -0.6F;
				}

				if (entity instanceof Animal) {
					f += 0.2F;
				}
			}

			Vec3 vec3 = (new Vec3(f, 0.0D, 0.0D)).yRot(-this.getYRot() * ((float) Math.PI / 180F) - ((float) Math.PI / 2F));
			moveFunction.accept(entity, this.getX() + vec3.x, this.getY() + f1, this.getZ() + vec3.z);
			entity.setYRot(entity.getYRot() + this.deltaRotation);
			entity.setYHeadRot(entity.getYHeadRot() + this.deltaRotation);
			this.clampRotation(entity);
			if (entity instanceof Animal && this.getPassengers().size() == this.getMaxPassengers()) {
				int j = entity.getId() % 2 == 0 ? 90 : 270;
				entity.setYBodyRot(((Animal) entity).yBodyRot + j);
				entity.setYHeadRot(entity.getYHeadRot() + j);
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

	private void clampRotation(Entity entity) {
		entity.setYBodyRot(this.getYRot());
		float f = Mth.wrapDegrees(entity.getYRot() - this.getYRot());
		float f1 = Mth.clamp(f, -105.0F, 105.0F);
		entity.yRotO += f1 - f;
		entity.setYRot(entity.getYRot() + f1 - f);
		entity.setYHeadRot(entity.getYRot());
	}

	@Override
	public void onPassengerTurned(Entity entity) {
		this.clampRotation(entity);
	}

	@SuppressWarnings("resource")
	@Override
	public InteractionResult interact(Player player, InteractionHand interactionHand) {
		if (player.isSecondaryUseActive()) {
			return InteractionResult.PASS;
		} else {
			if (!this.level().isClientSide) {
				return player.startRiding(this) ? InteractionResult.CONSUME : InteractionResult.PASS;
			} else {
				return InteractionResult.SUCCESS;
			}
		}
	}

	@Override
	protected void checkFallDamage(double p_38307_, boolean p_38308_, BlockState p_38309_, BlockPos p_38310_) {

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

	public void setHurtDir(int p_38363_) {
		this.entityData.set(DATA_ID_HURTDIR, p_38363_);
	}

	public int getHurtDir() {
		return this.entityData.get(DATA_ID_HURTDIR);
	}

	@Override
	protected boolean canAddPassenger(Entity passenger) {
		return this.getPassengers().size() < this.getMaxPassengers();
	}

	protected int getMaxPassengers() {
		return 2;
	}

	@Override
	@Nullable
	public LivingEntity getControllingPassenger() {
		return this.getFirstPassenger() instanceof LivingEntity ? (LivingEntity) this.getFirstPassenger() : null;
	}

	@Override
	protected void addPassenger(Entity passenger) {
		super.addPassenger(passenger);
		if (this.isControlledByLocalInstance() && this.lerpSteps > 0) {
			this.lerpSteps = 0;
			this.absMoveTo(this.lerpX, this.lerpY, this.lerpZ, (float) this.lerpRotY, (float) this.lerpRotX);
		}
	}

	public static enum Status {
		IN_WATER,
		ON_LAND,
		IN_AIR;
	}

	@Override
	protected void readAdditionalSaveData(CompoundTag compoundTag) {

	}

	@Override
	protected void addAdditionalSaveData(CompoundTag compoundTag) {

	}
}
