package com.technologica.world.entity.vehicle;

import java.util.List;

import javax.annotation.Nullable;

import com.google.common.collect.Lists;
import com.technologica.world.entity.TechnologicaEntityType;
import com.technologica.world.item.TechnologicaItems;
import com.technologica.world.level.block.TechnologicaBlocks;

import net.minecraft.BlockUtil;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.ClientGamePacketListener;
import net.minecraft.network.protocol.game.ServerboundPaddleBoatPacket;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.tags.FluidTags;
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
import net.minecraft.world.entity.vehicle.Boat;
import net.minecraft.world.entity.vehicle.DismountHelper;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.GameRules;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.WaterlilyBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.shapes.BooleanOp;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.minecraftforge.network.NetworkHooks;

public class Rocket extends Boat {
	private static final EntityDataAccessor<Integer> DATA_ID_HURT = SynchedEntityData.defineId(Rocket.class, EntityDataSerializers.INT);
	private static final EntityDataAccessor<Integer> DATA_ID_HURTDIR = SynchedEntityData.defineId(Rocket.class, EntityDataSerializers.INT);
	private static final EntityDataAccessor<Float> DATA_ID_DAMAGE = SynchedEntityData.defineId(Rocket.class, EntityDataSerializers.FLOAT);
	private static final EntityDataAccessor<Integer> DATA_ID_TYPE = SynchedEntityData.defineId(Rocket.class, EntityDataSerializers.INT);
	private static final EntityDataAccessor<Boolean> DATA_ID_PADDLE_LEFT = SynchedEntityData.defineId(Rocket.class, EntityDataSerializers.BOOLEAN);
	private static final EntityDataAccessor<Boolean> DATA_ID_PADDLE_RIGHT = SynchedEntityData.defineId(Rocket.class, EntityDataSerializers.BOOLEAN);
	private static final EntityDataAccessor<Integer> DATA_ID_BUBBLE_TIME = SynchedEntityData.defineId(Rocket.class, EntityDataSerializers.INT);
	public static final int PADDLE_LEFT = 0;
	public static final int PADDLE_RIGHT = 1;
	public static final double PADDLE_SOUND_TIME = (float) Math.PI / 4F;
	public static final int BUBBLE_TIME = 60;
	private final float[] paddlePositions = new float[2];
	private float invFriction;
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
	private Rocket.Status status;
	private Rocket.Status oldStatus;
	private double lastYd;
	private boolean isAboveBubbleColumn;
	private boolean bubbleColumnDirectionIsDown;
	private float bubbleMultiplier;
	private float bubbleAngle;
	private float bubbleAngleO;

	public Rocket(EntityType<? extends Rocket> type, Level world) {
		super(type, world);
		this.blocksBuilding = true;
	}

	public Rocket(Level worldIn, double x, double y, double z) {
		this(TechnologicaEntityType.ROCKET.get(), worldIn);
		this.setPos(x, y, z);
		this.setDeltaMovement(Vec3.ZERO);
		this.xo = x;
		this.yo = y;
		this.zo = z;
	}

	@Override
	protected float getEyeHeight(Pose p_38327_, EntityDimensions p_38328_) {
		return p_38328_.height;
	}

	@Override
	protected Entity.MovementEmission getMovementEmission() {
		return Entity.MovementEmission.NONE;
	}

	@Override
	protected void defineSynchedData() {
		this.entityData.define(DATA_ID_HURT, 0);
		this.entityData.define(DATA_ID_HURTDIR, 1);
		this.entityData.define(DATA_ID_DAMAGE, 0.0F);
		this.entityData.define(DATA_ID_TYPE, Rocket.Type.BANANA.ordinal());
		this.entityData.define(DATA_ID_PADDLE_LEFT, false);
		this.entityData.define(DATA_ID_PADDLE_RIGHT, false);
		this.entityData.define(DATA_ID_BUBBLE_TIME, 0);
	}

	@Override
	public boolean canCollideWith(Entity entity) {
		return canVehicleCollide(this, entity);
	}

	public static boolean canVehicleCollide(Entity p_242378_0_, Entity entity) {
		return (entity.canBeCollidedWith() || entity.isPushable()) && !p_242378_0_.isPassengerOfSameVehicle(entity);
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
	protected Vec3 getRelativePortalPosition(Direction.Axis axis, BlockUtil.FoundRectangle result) {
		return LivingEntity.resetForwardDirectionOfRelativePortalPosition(super.getRelativePortalPosition(axis, result));
	}

	@Override
	public double getPassengersRidingOffset() {
		return -0.1D;
	}

	@Override
	public boolean hurt(DamageSource source, float amount) {
		if (this.isInvulnerableTo(source)) {
			return false;
		} else if (!this.level.isClientSide && isAlive()) {
			this.setHurtDir(-this.getHurtDir());
			this.setHurtTime(10);
			this.setDamage(this.getDamage() + amount * 10.0F);
			this.markHurt();
			boolean flag = source.getEntity() instanceof Player && ((Player) source.getEntity()).getAbilities().instabuild;
			if (flag || this.getDamage() > 40.0F) {
				if (!flag && this.level.getGameRules().getBoolean(GameRules.RULE_DOENTITYDROPS)) {
					this.spawnAtLocation(this.getDropItem());
				}

				this.discard();
			}

			return true;
		} else {
			return true;
		}
	}

	@Override
	public void onAboveBubbleCol(boolean p_38381_) {
		if (!this.level.isClientSide) {
			this.isAboveBubbleColumn = true;
			this.bubbleColumnDirectionIsDown = p_38381_;
			if (this.getBubbleTime() == 0) {
				this.setBubbleTime(60);
			}
		}

		this.level.addParticle(ParticleTypes.SPLASH, this.getX() + this.random.nextFloat(), this.getY() + 0.7D, this.getZ() + this.random.nextFloat(), 0.0D, 0.0D, 0.0D);
		if (this.random.nextInt(20) == 0) {
			this.level.playLocalSound(this.getX(), this.getY(), this.getZ(), this.getSwimSplashSound(), this.getSoundSource(), 1.0F, 0.8F + 0.4F * this.random.nextFloat(), false);
		}

		this.gameEvent(GameEvent.SPLASH, this.getControllingPassenger());
	}

	@Override
	public void push(Entity entityIn) {
		if (entityIn instanceof Rocket) {
			if (entityIn.getBoundingBox().minY < this.getBoundingBox().maxY) {
				super.push(entityIn);
			}
		} else if (entityIn.getBoundingBox().minY <= this.getBoundingBox().minY) {
			super.push(entityIn);
		}

	}

	@Override
	public Item getDropItem() {
		switch (this.getVanillaBoatType()) {
		case ALCHEMICAL:
		default:
			return TechnologicaItems.ALCHEMICAL_BOAT.get();
		case APRICOT:
			return TechnologicaItems.APRICOT_BOAT.get();
		case ASPEN:
			return TechnologicaItems.ASPEN_BOAT.get();
		case AVOCADO:
			return TechnologicaItems.AVOCADO_BOAT.get();
		case BANANA:
			return TechnologicaItems.BANANA_BOAT.get();
		case BENEVOLENT:
			return TechnologicaItems.BENEVOLENT_BOAT.get();
		case CHERRY:
			return TechnologicaItems.CHERRY_BOAT.get();
		case CHESTNUT:
			return TechnologicaItems.CHESTNUT_BOAT.get();
		case CINNAMON:
			return TechnologicaItems.CINNAMON_BOAT.get();
		case COCONUT:
			return TechnologicaItems.COCONUT_BOAT.get();
		case CONDUCTIVE:
			return TechnologicaItems.CONDUCTIVE_BOAT.get();
		case EBONY:
			return TechnologicaItems.EBONY_BOAT.get();
		case FROSTBITTEN:
			return TechnologicaItems.FROSTBITTEN_BOAT.get();
		case FRUITFUL:
			return TechnologicaItems.FRUITFUL_BOAT.get();
		case INFERNAL:
			return TechnologicaItems.INFERNAL_BOAT.get();
		case KIWI:
			return TechnologicaItems.KIWI_BOAT.get();
		case LEMON:
			return TechnologicaItems.LEMON_BOAT.get();
		case LIME:
			return TechnologicaItems.LIME_BOAT.get();
		case MAHOGANY:
			return TechnologicaItems.MAHOGANY_BOAT.get();
		case MALEVOLENT:
			return TechnologicaItems.MALEVOLENT_BOAT.get();
		case MAPLE:
			return TechnologicaItems.MAPLE_BOAT.get();
		case OLIVE:
			return TechnologicaItems.OLIVE_BOAT.get();
		case ORANGE:
			return TechnologicaItems.ORANGE_BOAT.get();
		case PEACH:
			return TechnologicaItems.PEACH_BOAT.get();
		case PEAR:
			return TechnologicaItems.PEAR_BOAT.get();
		case PLUM:
			return TechnologicaItems.PLUM_BOAT.get();
		case REDWOOD:
			return TechnologicaItems.REDWOOD_BOAT.get();
		case ROSEWOOD:
			return TechnologicaItems.ROSEWOOD_BOAT.get();
		case RUBBER:
			return TechnologicaItems.RUBBER_BOAT.get();
		case TEAK:
			return TechnologicaItems.TEAK_BOAT.get();
		case WALNUT:
			return TechnologicaItems.WALNUT_BOAT.get();
		case ZEBRAWOOD:
			return TechnologicaItems.ZEBRAWOOD_BOAT.get();
		}
	}

	@Override
	public void animateHurt() {
		this.setHurtDir(-this.getHurtDir());
		this.setHurtTime(10);
		this.setDamage(this.getDamage() * 11.0F);
	}

	@Override
	public boolean isPickable() {
		return isAlive();
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
		if (this.status != Rocket.Status.UNDER_WATER && this.status != Rocket.Status.UNDER_FLOWING_WATER) {
			this.outOfControlTicks = 0.0F;
		} else {
			++this.outOfControlTicks;
		}

		if (!this.level.isClientSide && this.outOfControlTicks >= 60.0F) {
			this.ejectPassengers();
		}

		if (this.getHurtTime() > 0) {
			this.setHurtTime(this.getHurtTime() - 1);
		}

		if (this.getDamage() > 0.0F) {
			this.setDamage(this.getDamage() - 1.0F);
		}

		this.tickLerp();
		if (this.isControlledByLocalInstance()) {
			if (this.getPassengers().isEmpty() || !(this.getPassengers().get(0) instanceof Player)) {
				this.setPaddleState(false, false);
			}

			this.floatMotion();
			if (this.level.isClientSide) {
				this.controlBoat();
				this.level.sendPacketToServer(new ServerboundPaddleBoatPacket(this.getPaddleState(0), this.getPaddleState(1)));
			}

			this.move(MoverType.SELF, this.getDeltaMovement());
		} else {
			this.setDeltaMovement(Vec3.ZERO);
		}

		this.tickBubbleColumn();

		for (int i = 0; i <= 1; ++i) {
			if (this.getPaddleState(i)) {
				if (!this.isSilent() && (double) (this.paddlePositions[i] % ((float) Math.PI * 2F)) <= (double) ((float) Math.PI / 4F) && ((double) this.paddlePositions[i] + (double) ((float) Math.PI / 8F)) % ((float) Math.PI * 2F) >= (float) Math.PI / 4F) {
					SoundEvent soundevent = this.getPaddleSound();
					if (soundevent != null) {
						Vec3 vector3d = this.getViewVector(1.0F);
						double d0 = i == 1 ? -vector3d.z : vector3d.z;
						double d1 = i == 1 ? vector3d.x : -vector3d.x;
						this.level.playSound((Player) null, this.getX() + d0, this.getY(), this.getZ() + d1, soundevent, this.getSoundSource(), 1.0F, 0.8F + 0.4F * this.random.nextFloat());
					}
				}

				this.paddlePositions[i] = (float) ((double) this.paddlePositions[i] + (double) ((float) Math.PI / 8F));
			} else {
				this.paddlePositions[i] = 0.0F;
			}
		}

		this.checkInsideBlocks();
		List<Entity> list = this.level.getEntities(this, this.getBoundingBox().inflate(0.2F, -0.01F, 0.2F), EntitySelector.pushableBy(this));

		if (!list.isEmpty()) {
			boolean flag = !this.level.isClientSide && !(this.getControllingPassenger() instanceof Player);

			for (int j = 0; j < list.size(); ++j) {
				Entity entity = list.get(j);
				if (!entity.hasPassenger(this)) {
					if (flag && this.getPassengers().size() < 2 && !entity.isPassenger() && entity.getBbWidth() < this.getBbWidth() && entity instanceof LivingEntity && !(entity instanceof WaterAnimal) && !(entity instanceof Player)) {
						entity.startRiding(this);
					} else {
						this.push(entity);
					}
				}
			}
		}

	}

	private void tickBubbleColumn() {
		if (this.level.isClientSide) {
			int i = this.getBubbleTime();
			if (i > 0) {
				this.bubbleMultiplier += 0.05F;
			} else {
				this.bubbleMultiplier -= 0.1F;
			}

			this.bubbleMultiplier = Mth.clamp(this.bubbleMultiplier, 0.0F, 1.0F);
			this.bubbleAngleO = this.bubbleAngle;
			this.bubbleAngle = 10.0F * (float) Math.sin(0.5F * this.level.getGameTime()) * this.bubbleMultiplier;
		} else {
			if (!this.isAboveBubbleColumn) {
				this.setBubbleTime(0);
			}

			int k = this.getBubbleTime();
			if (k > 0) {
				--k;
				this.setBubbleTime(k);
				int j = 60 - k - 1;
				if (j > 0 && k == 0) {
					this.setBubbleTime(0);
					Vec3 vec3 = this.getDeltaMovement();
					if (this.bubbleColumnDirectionIsDown) {
						this.setDeltaMovement(vec3.add(0.0D, -0.7D, 0.0D));
						this.ejectPassengers();
					} else {
						this.setDeltaMovement(vec3.x, this.hasPassenger((p_150274_) -> {
							return p_150274_ instanceof Player;
						}) ? 2.7D : 0.6D, vec3.z);
					}
				}

				this.isAboveBubbleColumn = false;
			}
		}

	}

	@Override
	@Nullable
	protected SoundEvent getPaddleSound() {
		switch (this.getStatus()) {
		case IN_WATER:
		case UNDER_WATER:
		case UNDER_FLOWING_WATER:
			return SoundEvents.BOAT_PADDLE_WATER;
		case ON_LAND:
			return SoundEvents.BOAT_PADDLE_LAND;
		case IN_AIR:
		default:
			return null;
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

	@Override
	public void setPaddleState(boolean left, boolean right) {
		this.entityData.set(DATA_ID_PADDLE_LEFT, left);
		this.entityData.set(DATA_ID_PADDLE_RIGHT, right);
	}

	@Override
	public float getRowingTime(int side, float limbSwing) {
		return this.getPaddleState(side) ? (float) Mth.clampedLerp((double) this.paddlePositions[side] - (double) ((float) Math.PI / 8F), this.paddlePositions[side], limbSwing) : 0.0F;
	}

	private Rocket.Status getStatus() {
		Rocket.Status boatentity$status = this.isUnderwater();
		if (boatentity$status != null) {
			this.waterLevel = this.getBoundingBox().maxY;
			return boatentity$status;
		} else if (this.checkInWater()) {
			return Rocket.Status.IN_WATER;
		} else {
			float f = this.getGroundFriction();
			if (f > 0.0F) {
				this.landFriction = f;
				return Rocket.Status.ON_LAND;
			} else {
				return Rocket.Status.IN_AIR;
			}
		}
	}

	@Override
	public float getWaterLevelAbove() {
		AABB axisalignedbb = this.getBoundingBox();
		int i = Mth.floor(axisalignedbb.minX);
		int j = Mth.ceil(axisalignedbb.maxX);
		int k = Mth.floor(axisalignedbb.maxY);
		int l = Mth.ceil(axisalignedbb.maxY - this.lastYd);
		int i1 = Mth.floor(axisalignedbb.minZ);
		int j1 = Mth.ceil(axisalignedbb.maxZ);
		BlockPos.MutableBlockPos blockpos$mutable = new BlockPos.MutableBlockPos();

		label39: for (int k1 = k; k1 < l; ++k1) {
			float f = 0.0F;

			for (int l1 = i; l1 < j; ++l1) {
				for (int i2 = i1; i2 < j1; ++i2) {
					blockpos$mutable.set(l1, k1, i2);
					FluidState fluidstate = this.level.getFluidState(blockpos$mutable);
					if (fluidstate.is(FluidTags.WATER)) {
						f = Math.max(f, fluidstate.getHeight(this.level, blockpos$mutable));
					}

					if (f >= 1.0F) {
						continue label39;
					}
				}
			}

			if (f < 1.0F) {
				return blockpos$mutable.getY() + f;
			}
		}

		return l + 1;
	}

	@Override
	public float getGroundFriction() {
		AABB axisalignedbb = this.getBoundingBox();
		AABB axisalignedbb1 = new AABB(axisalignedbb.minX, axisalignedbb.minY - 0.001D, axisalignedbb.minZ, axisalignedbb.maxX, axisalignedbb.minY, axisalignedbb.maxZ);
		int i = Mth.floor(axisalignedbb1.minX) - 1;
		int j = Mth.ceil(axisalignedbb1.maxX) + 1;
		int k = Mth.floor(axisalignedbb1.minY) - 1;
		int l = Mth.ceil(axisalignedbb1.maxY) + 1;
		int i1 = Mth.floor(axisalignedbb1.minZ) - 1;
		int j1 = Mth.ceil(axisalignedbb1.maxZ) + 1;
		VoxelShape voxelshape = Shapes.create(axisalignedbb1);
		float f = 0.0F;
		int k1 = 0;
		BlockPos.MutableBlockPos blockpos$mutable = new BlockPos.MutableBlockPos();

		for (int l1 = i; l1 < j; ++l1) {
			for (int i2 = i1; i2 < j1; ++i2) {
				int j2 = (l1 != i && l1 != j - 1 ? 0 : 1) + (i2 != i1 && i2 != j1 - 1 ? 0 : 1);
				if (j2 != 2) {
					for (int k2 = k; k2 < l; ++k2) {
						if (j2 <= 0 || k2 != k && k2 != l - 1) {
							blockpos$mutable.set(l1, k2, i2);
							BlockState blockstate = this.level.getBlockState(blockpos$mutable);
							if (!(blockstate.getBlock() instanceof WaterlilyBlock) && Shapes.joinIsNotEmpty(blockstate.getCollisionShape(this.level, blockpos$mutable).move(l1, k2, i2), voxelshape, BooleanOp.AND)) {
								f += blockstate.getFriction(this.level, blockpos$mutable, this);
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
		AABB axisalignedbb = this.getBoundingBox();
		int i = Mth.floor(axisalignedbb.minX);
		int j = Mth.ceil(axisalignedbb.maxX);
		int k = Mth.floor(axisalignedbb.minY);
		int l = Mth.ceil(axisalignedbb.minY + 0.001D);
		int i1 = Mth.floor(axisalignedbb.minZ);
		int j1 = Mth.ceil(axisalignedbb.maxZ);
		boolean flag = false;
		this.waterLevel = Double.MIN_VALUE;
		BlockPos.MutableBlockPos blockpos$mutable = new BlockPos.MutableBlockPos();

		for (int k1 = i; k1 < j; ++k1) {
			for (int l1 = k; l1 < l; ++l1) {
				for (int i2 = i1; i2 < j1; ++i2) {
					blockpos$mutable.set(k1, l1, i2);
					FluidState fluidstate = this.level.getFluidState(blockpos$mutable);
					if (fluidstate.is(FluidTags.WATER)) {
						float f = l1 + fluidstate.getHeight(this.level, blockpos$mutable);
						this.waterLevel = Math.max(f, this.waterLevel);
						flag |= axisalignedbb.minY < f;
					}
				}
			}
		}

		return flag;
	}

	@Nullable
	private Rocket.Status isUnderwater() {
		AABB axisalignedbb = this.getBoundingBox();
		double d0 = axisalignedbb.maxY + 0.001D;
		int i = Mth.floor(axisalignedbb.minX);
		int j = Mth.ceil(axisalignedbb.maxX);
		int k = Mth.floor(axisalignedbb.maxY);
		int l = Mth.ceil(d0);
		int i1 = Mth.floor(axisalignedbb.minZ);
		int j1 = Mth.ceil(axisalignedbb.maxZ);
		boolean flag = false;
		BlockPos.MutableBlockPos blockpos$mutable = new BlockPos.MutableBlockPos();

		for (int k1 = i; k1 < j; ++k1) {
			for (int l1 = k; l1 < l; ++l1) {
				for (int i2 = i1; i2 < j1; ++i2) {
					blockpos$mutable.set(k1, l1, i2);
					FluidState fluidstate = this.level.getFluidState(blockpos$mutable);
					if (fluidstate.is(FluidTags.WATER) && d0 < blockpos$mutable.getY() + fluidstate.getHeight(this.level, blockpos$mutable)) {
						if (!fluidstate.isSource()) {
							return Rocket.Status.UNDER_FLOWING_WATER;
						}

						flag = true;
					}
				}
			}
		}

		return flag ? Rocket.Status.UNDER_WATER : null;
	}

	private void floatMotion() {
		double d1 = this.isNoGravity() ? 0.0D : (double) -0.04F;
		double d2 = 0.0D;
		this.invFriction = 0.05F;
		if (this.oldStatus == Rocket.Status.IN_AIR && this.status != Rocket.Status.IN_AIR && this.status != Rocket.Status.ON_LAND) {
			this.waterLevel = this.getY(1.0D);
			this.setPos(this.getX(), this.getWaterLevelAbove() - this.getBbHeight() + 0.101D, this.getZ());
			this.setDeltaMovement(this.getDeltaMovement().multiply(1.0D, 0.0D, 1.0D));
			this.lastYd = 0.0D;
			this.status = Rocket.Status.IN_WATER;
		} else {
			if (this.status == Rocket.Status.IN_WATER) {
				d2 = (this.waterLevel - this.getY()) / this.getBbHeight();
				this.invFriction = 0.9F;
			} else if (this.status == Rocket.Status.UNDER_FLOWING_WATER) {
				d1 = -7.0E-4D;
				this.invFriction = 0.9F;
			} else if (this.status == Rocket.Status.UNDER_WATER) {
				d2 = 0.01F;
				this.invFriction = 0.45F;
			} else if (this.status == Rocket.Status.IN_AIR) {
				this.invFriction = 0.9F;
			} else if (this.status == Rocket.Status.ON_LAND) {
				this.invFriction = this.landFriction;
				if (this.getControllingPassenger() instanceof Player) {
					this.landFriction /= 2.0F;
				}
			}

			Vec3 vector3d = this.getDeltaMovement();
			this.setDeltaMovement(vector3d.x * this.invFriction, vector3d.y + d1, vector3d.z * this.invFriction);
			this.deltaRotation *= this.invFriction;
			if (d2 > 0.0D) {
				Vec3 vector3d1 = this.getDeltaMovement();
				this.setDeltaMovement(vector3d1.x, (vector3d1.y + d2 * 0.06153846016296973D) * 0.75D, vector3d1.z);
			}
		}

	}

	private void controlBoat() {
		if (this.isVehicle()) {
			float f = 0.0F;
			if (this.inputLeft) {
				--this.deltaRotation;
			}

			if (this.inputRight) {
				++this.deltaRotation;
			}

			if (this.inputRight != this.inputLeft && !this.inputUp && !this.inputDown) {
				f += 0.005F;
			}

			this.setYRot(this.getYRot() + this.deltaRotation);
			if (this.inputUp) {
				f += 10.0F;
			}

			if (this.inputDown) {
				f -= 0.005F;
			}

			this.setDeltaMovement(this.getDeltaMovement().add(0.0D, f, 0.0D));
			this.setPaddleState(this.inputRight && !this.inputLeft || this.inputUp, this.inputLeft && !this.inputRight || this.inputUp);
		}
	}

	@Override
	public void positionRider(Entity p_38379_) {
		if (this.hasPassenger(p_38379_)) {
			float f = 0.0F;
			float f1 = (float) ((this.isRemoved() ? (double) 0.01F : this.getPassengersRidingOffset()) + p_38379_.getMyRidingOffset());
			if (this.getPassengers().size() > 1) {
				int i = this.getPassengers().indexOf(p_38379_);
				if (i == 0) {
					f = 0.2F;
				} else {
					f = -0.6F;
				}

				if (p_38379_ instanceof Animal) {
					f = (float) (f + 0.2D);
				}
			}

			Vec3 vec3 = (new Vec3(f, 0.0D, 0.0D)).yRot(-this.getYRot() * ((float) Math.PI / 180F) - ((float) Math.PI / 2F));
			p_38379_.setPos(this.getX() + vec3.x, this.getY() + f1, this.getZ() + vec3.z);
			p_38379_.setYRot(p_38379_.getYRot() + this.deltaRotation);
			p_38379_.setYHeadRot(p_38379_.getYHeadRot() + this.deltaRotation);
			this.clampRotation(p_38379_);
			if (p_38379_ instanceof Animal && this.getPassengers().size() > 1) {
				int j = p_38379_.getId() % 2 == 0 ? 90 : 270;
				p_38379_.setYBodyRot(((Animal) p_38379_).yBodyRot + j);
				p_38379_.setYHeadRot(p_38379_.getYHeadRot() + j);
			}

		}
	}

	@Override
	public Vec3 getDismountLocationForPassenger(LivingEntity p_38357_) {
		Vec3 vec3 = getCollisionHorizontalEscapeVector(this.getBbWidth() * Mth.SQRT_OF_TWO, p_38357_.getBbWidth(), p_38357_.getYRot());
		double d0 = this.getX() + vec3.x;
		double d1 = this.getZ() + vec3.z;
		BlockPos blockpos = new BlockPos(d0, this.getBoundingBox().maxY, d1);
		BlockPos blockpos1 = blockpos.below();
		if (!this.level.isWaterAt(blockpos1)) {
			List<Vec3> list = Lists.newArrayList();
			double d2 = this.level.getBlockFloorHeight(blockpos);
			if (DismountHelper.isBlockFloorValid(d2)) {
				list.add(new Vec3(d0, blockpos.getY() + d2, d1));
			}

			double d3 = this.level.getBlockFloorHeight(blockpos1);
			if (DismountHelper.isBlockFloorValid(d3)) {
				list.add(new Vec3(d0, blockpos1.getY() + d3, d1));
			}

			for (Pose pose : p_38357_.getDismountPoses()) {
				for (Vec3 vec31 : list) {
					if (DismountHelper.canDismountTo(this.level, vec31, p_38357_, pose)) {
						p_38357_.setPose(pose);
						return vec31;
					}
				}
			}
		}

		return super.getDismountLocationForPassenger(p_38357_);
	}

	@Override
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
	protected void addAdditionalSaveData(CompoundTag compound) {
		compound.putString("Type", this.getVanillaBoatType().getName());
	}

	@Override
	protected void readAdditionalSaveData(CompoundTag compound) {
		if (compound.contains("Type", 8)) {
			this.setType(Rocket.Type.getTypeFromString(compound.getString("Type")));
		}
	}

	@Override
	public InteractionResult interact(Player player, InteractionHand hand) {
		if (player.isSecondaryUseActive()) {
			return InteractionResult.PASS;
		} else if (this.outOfControlTicks < 60.0F) {
			if (!this.level.isClientSide) {
				return player.startRiding(this) ? InteractionResult.CONSUME : InteractionResult.PASS;
			} else {
				return InteractionResult.SUCCESS;
			}
		} else {
			return InteractionResult.PASS;
		}
	}

	@Override
	protected void checkFallDamage(double y, boolean onGroundIn, BlockState state, BlockPos pos) {
		this.lastYd = this.getDeltaMovement().y;
		if (!this.isPassenger()) {
			if (onGroundIn) {
				if (this.fallDistance > 3.0F) {
					if (this.status != Rocket.Status.ON_LAND) {
						this.fallDistance = 0.0F;
						return;
					}

					this.causeFallDamage(this.fallDistance, 1.0F, DamageSource.FALL);
					if (!this.level.isClientSide && !isAlive()) {
						this.kill();
						if (this.level.getGameRules().getBoolean(GameRules.RULE_DOENTITYDROPS)) {
							for (int i = 0; i < 3; ++i) {
								this.spawnAtLocation(this.getVariant().getPlanks());
							}

							for (int j = 0; j < 2; ++j) {
								this.spawnAtLocation(Items.STICK);
							}
						}
					}
				}

				this.resetFallDistance();
			} else if (!this.level.getFluidState(this.blockPosition().below()).is(FluidTags.WATER) && y < 0.0D) {
				this.fallDistance = (float) (this.fallDistance - y);
			}

		}
	}

	@Override
	public boolean getPaddleState(int side) {
		return this.entityData.<Boolean>get(side == 0 ? DATA_ID_PADDLE_LEFT : DATA_ID_PADDLE_RIGHT) && this.getControllingPassenger() != null;
	}

	@Override
	public void setDamage(float damageTaken) {
		this.entityData.set(DATA_ID_DAMAGE, damageTaken);
	}

	@Override
	public float getDamage() {
		return this.entityData.get(DATA_ID_DAMAGE);
	}

	@Override
	public void setHurtTime(int timeSinceHit) {
		this.entityData.set(DATA_ID_HURT, timeSinceHit);
	}

	@Override
	public int getHurtTime() {
		return this.entityData.get(DATA_ID_HURT);
	}

	private void setBubbleTime(int p_38367_) {
		this.entityData.set(DATA_ID_BUBBLE_TIME, p_38367_);
	}

	private int getBubbleTime() {
		return this.entityData.get(DATA_ID_BUBBLE_TIME);
	}

	@Override
	public float getBubbleAngle(float p_38353_) {
		return Mth.lerp(p_38353_, this.bubbleAngleO, this.bubbleAngle);
	}

	@Override
	public void setHurtDir(int forwardDirection) {
		this.entityData.set(DATA_ID_HURTDIR, forwardDirection);
	}

	@Override
	public int getHurtDir() {
		return this.entityData.get(DATA_ID_HURTDIR);
	}

	public void setType(Rocket.Type boatType) {
		this.entityData.set(DATA_ID_TYPE, boatType.ordinal());
	}

	public Rocket.Type getVanillaBoatType() {
		return Rocket.Type.byId(this.entityData.get(DATA_ID_TYPE));
	}

	@Override
	protected boolean canAddPassenger(Entity passenger) {
		return this.getPassengers().size() < this.getMaxPassengers() && !this.canBoatInFluid(this.getEyeInFluidType());
	}

	@Override
	@Nullable
	public Entity getControllingPassenger() {
		return this.getFirstPassenger();
	}

	@Override
	public void setInput(boolean p_38343_, boolean p_38344_, boolean p_38345_, boolean p_38346_) {
		this.inputLeft = p_38343_;
		this.inputRight = p_38344_;
		this.inputUp = p_38345_;
		this.inputDown = p_38346_;
	}

	@Override
	public Packet<ClientGamePacketListener> getAddEntityPacket() {
		return NetworkHooks.getEntitySpawningPacket(this);
	}

	@Override
	public boolean isUnderWater() {
		return this.status == Rocket.Status.UNDER_WATER || this.status == Rocket.Status.UNDER_FLOWING_WATER;
	}

	@Override
	protected void addPassenger(Entity passenger) {
		super.addPassenger(passenger);
		if (this.isControlledByLocalInstance() && this.lerpSteps > 0) {
			this.lerpSteps = 0;
			this.absMoveTo(this.lerpX, this.lerpY, this.lerpZ, (float) this.lerpYRot, (float) this.lerpXRot);
		}
	}

	@Override
	public ItemStack getPickResult() {
		return new ItemStack(this.getDropItem());
	}

	public static enum Status {
		IN_WATER, UNDER_WATER, UNDER_FLOWING_WATER, ON_LAND, IN_AIR;
	}

	public static enum Type {
		APRICOT(TechnologicaBlocks.APRICOT_PLANKS.get(), "apricot"), ASPEN(TechnologicaBlocks.ASPEN_PLANKS.get(), "aspen"), AVOCADO(TechnologicaBlocks.AVOCADO_PLANKS.get(), "avocado"), BANANA(TechnologicaBlocks.BANANA_PLANKS.get(), "banana"), CHERRY(TechnologicaBlocks.CHERRY_PLANKS.get(), "cherry"), CHESTNUT(TechnologicaBlocks.CHESTNUT_PLANKS.get(), "chestnut"), CINNAMON(TechnologicaBlocks.CINNAMON_PLANKS.get(), "cinnamon"), COCONUT(TechnologicaBlocks.COCONUT_PLANKS.get(), "coconut"), EBONY(TechnologicaBlocks.EBONY_PLANKS.get(), "ebony"), KIWI(TechnologicaBlocks.KIWI_PLANKS.get(), "kiwi"), LEMON(TechnologicaBlocks.LEMON_PLANKS.get(), "lemon"), LIME(TechnologicaBlocks.LIME_PLANKS.get(), "lime"), MAHOGANY(TechnologicaBlocks.MAHOGANY_PLANKS.get(), "mahogany"), MAPLE(TechnologicaBlocks.MAPLE_PLANKS.get(), "maple"), OLIVE(TechnologicaBlocks.OLIVE_PLANKS.get(), "olive"), ORANGE(TechnologicaBlocks.ORANGE_PLANKS.get(), "orange"), PEACH(TechnologicaBlocks.PEACH_PLANKS.get(), "peach"), PEAR(TechnologicaBlocks.PEAR_PLANKS.get(), "pear"), PLUM(TechnologicaBlocks.PLUM_PLANKS.get(), "plum"), REDWOOD(TechnologicaBlocks.REDWOOD_PLANKS.get(), "redwood"), ROSEWOOD(TechnologicaBlocks.ROSEWOOD_PLANKS.get(), "rosewood"), RUBBER(TechnologicaBlocks.RUBBER_PLANKS.get(), "rubber"), TEAK(TechnologicaBlocks.TEAK_PLANKS.get(), "teak"), WALNUT(TechnologicaBlocks.WALNUT_PLANKS.get(), "walnut"), ZEBRAWOOD(TechnologicaBlocks.ZEBRAWOOD_PLANKS.get(), "zebrawood"), ALCHEMICAL(TechnologicaBlocks.ALCHEMICAL_PLANKS.get(), "alchemical"), BENEVOLENT(TechnologicaBlocks.BENEVOLENT_PLANKS.get(), "benevolent"), CONDUCTIVE(TechnologicaBlocks.CONDUCTIVE_PLANKS.get(), "conductive"), FROSTBITTEN(TechnologicaBlocks.FROSTBITTEN_PLANKS.get(), "frostbitten"), FRUITFUL(TechnologicaBlocks.FRUITFUL_PLANKS.get(), "fruitful"), INFERNAL(TechnologicaBlocks.INFERNAL_PLANKS.get(), "infernal"), MALEVOLENT(TechnologicaBlocks.MALEVOLENT_PLANKS.get(), "malevolent");

		private final String name;
		private final Block planks;

		private Type(Block block, String name) {
			this.name = name;
			this.planks = block;
		}

		public String getName() {
			return this.name;
		}

		public Block asPlank() {
			return this.planks;
		}

		@Override
		public String toString() {
			return this.name;
		}

		public static Rocket.Type byId(int id) {
			Rocket.Type[] aboatentity$type = values();
			if (id < 0 || id >= aboatentity$type.length) {
				id = 0;
			}

			return aboatentity$type[id];
		}

		public static Rocket.Type getTypeFromString(String nameIn) {
			Rocket.Type[] aboatentity$type = values();

			for (int i = 0; i < aboatentity$type.length; ++i) {
				if (aboatentity$type[i].getName().equals(nameIn)) {
					return aboatentity$type[i];
				}
			}

			return aboatentity$type[0];
		}
	}
}
