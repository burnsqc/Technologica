package com.technologica.world.entity.animal;

import java.util.Random;

import javax.annotation.Nullable;

import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.AgeableMob;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.SpawnGroupData;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.control.MoveControl;
import net.minecraft.world.entity.ai.goal.BreedGoal;
import net.minecraft.world.entity.ai.goal.FloatGoal;
import net.minecraft.world.entity.ai.goal.LookAtPlayerGoal;
import net.minecraft.world.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.world.entity.ai.goal.MoveToBlockGoal;
import net.minecraft.world.entity.ai.goal.TemptGoal;
import net.minecraft.world.entity.ai.goal.WaterAvoidingRandomStrollGoal;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.CarrotBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.pathfinder.Path;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class BeaverEntity extends Animal {
	private static final EntityDataAccessor<Integer> RABBIT_TYPE = SynchedEntityData.defineId(BeaverEntity.class, EntityDataSerializers.INT);
	private boolean wasOnGround;
	private int currentMoveTypeDuration;
	private int carrotTicks;

	public BeaverEntity(EntityType<? extends BeaverEntity> p_i50247_1_, Level p_i50247_2_) {
		super(p_i50247_1_, p_i50247_2_);
		this.moveControl = new BeaverEntity.MoveHelperController(this);
		this.setMovementSpeed(0.0D);
	}

	protected void registerGoals() {
		this.goalSelector.addGoal(1, new FloatGoal(this));
		this.goalSelector.addGoal(1, new BeaverEntity.PanicGoal(this, 2.2D));
		this.goalSelector.addGoal(2, new BreedGoal(this, 0.8D));
		this.goalSelector.addGoal(3, new TemptGoal(this, 1.0D, Ingredient.of(Items.CARROT, Items.GOLDEN_CARROT, Blocks.DANDELION), false));
		this.goalSelector.addGoal(4, new BeaverEntity.AvoidEntityGoal<>(this, Player.class, 8.0F, 2.2D, 2.2D));
		this.goalSelector.addGoal(4, new BeaverEntity.AvoidEntityGoal<>(this, Monster.class, 4.0F, 2.2D, 2.2D));
		this.goalSelector.addGoal(5, new BeaverEntity.RaidFarmGoal(this));
		this.goalSelector.addGoal(6, new WaterAvoidingRandomStrollGoal(this, 0.6D));
		this.goalSelector.addGoal(11, new LookAtPlayerGoal(this, Player.class, 10.0F));
	}

	public static AttributeSupplier.Builder registerAttributes() {
		return AttributeSupplier.builder()
				.add(Attributes.MAX_HEALTH, 10.0D)
				.add(Attributes.MOVEMENT_SPEED, 0.25D)
				.add(Attributes.FOLLOW_RANGE, 16.0D)
				.add(Attributes.ATTACK_KNOCKBACK)
				.add(Attributes.KNOCKBACK_RESISTANCE)
				.add(Attributes.ARMOR)
				.add(Attributes.ARMOR_TOUGHNESS)
				.add(net.minecraftforge.common.ForgeMod.SWIM_SPEED.get())
				.add(net.minecraftforge.common.ForgeMod.NAMETAG_DISTANCE.get())
				.add(net.minecraftforge.common.ForgeMod.ENTITY_GRAVITY.get());
	}

	protected float getJumpPower() {
		if (!this.horizontalCollision
				&& (!this.moveControl.hasWanted() || !(this.moveControl.getWantedY() > this.getY() + 0.5D))) {
			Path path = this.navigation.getPath();
			if (path != null && !path.isDone()) {
				Vec3 vector3d = path.getNextEntityPos(this);
				if (vector3d.y > this.getY() + 0.5D) {
					return 0.5F;
				}
			}

			return this.moveControl.getSpeedModifier() <= 0.6D ? 0.2F : 0.3F;
		} else {
			return 0.5F;
		}
	}

	/**
	 * Causes this entity to do an upwards motion (jumping).
	 */
	
	public void setMovementSpeed(double newSpeed) {
		this.getNavigation().setSpeedModifier(newSpeed);
		this.moveControl.setWantedPosition(this.moveControl.getWantedX(), this.moveControl.getWantedY(),
				this.moveControl.getWantedZ(), newSpeed);
	}

	public void setJumping(boolean jumping) {
		super.setJumping(jumping);
		if (jumping) {
			this.playSound(this.getJumpSound(), this.getSoundVolume(),
					((this.random.nextFloat() - this.random.nextFloat()) * 0.2F + 1.0F) * 0.8F);
		}

	}

	protected void defineSynchedData() {
		super.defineSynchedData();
		this.entityData.define(RABBIT_TYPE, 0);
	}

	public void customServerAiStep() {
		if (this.currentMoveTypeDuration > 0) {
			--this.currentMoveTypeDuration;
		}

		if (this.carrotTicks > 0) {
			this.carrotTicks -= this.random.nextInt(3);
			if (this.carrotTicks < 0) {
				this.carrotTicks = 0;
			}
		}

		if (this.onGround) {
			if (!this.wasOnGround) {
				this.setJumping(false);
				this.checkLandingDelay();
			}
		}

		this.wasOnGround = this.onGround;
	}

	public boolean canSpawnSprintParticle() {
		return false;
	}

	private void updateMoveTypeDuration() {
		if (this.moveControl.getSpeedModifier() < 2.2D) {
			this.currentMoveTypeDuration = 10;
		} else {
			this.currentMoveTypeDuration = 1;
		}

	}

	private void checkLandingDelay() {
		this.updateMoveTypeDuration();
	}

	/**
	 * Called frequently so the entity can update its state every tick as required.
	 * For example, zombies and skeletons use this to react to sunlight and start to
	 * burn.
	 */
	public void aiStep() {
		super.aiStep();
	}

	public void addAdditionalSaveData(CompoundTag compound) {
		super.addAdditionalSaveData(compound);
		compound.putInt("RabbitType", this.getRabbitType());
		compound.putInt("MoreCarrotTicks", this.carrotTicks);
	}

	/**
	 * (abstract) Protected helper method to read subclass entity data from NBT.
	 */
	public void readAdditionalSaveData(CompoundTag compound) {
		super.readAdditionalSaveData(compound);
		this.setRabbitType(compound.getInt("RabbitType"));
		this.carrotTicks = compound.getInt("MoreCarrotTicks");
	}

	protected SoundEvent getJumpSound() {
		return SoundEvents.RABBIT_JUMP;
	}

	protected SoundEvent getAmbientSound() {
		return SoundEvents.RABBIT_AMBIENT;
	}

	protected SoundEvent getHurtSound(DamageSource damageSourceIn) {
		return SoundEvents.RABBIT_HURT;
	}

	protected SoundEvent getDeathSound() {
		return SoundEvents.RABBIT_DEATH;
	}

	public boolean doHurtTarget(Entity entityIn) {
		if (this.getRabbitType() == 99) {
			this.playSound(SoundEvents.RABBIT_ATTACK, 1.0F,
					(this.random.nextFloat() - this.random.nextFloat()) * 0.2F + 1.0F);
			return entityIn.hurt(DamageSource.mobAttack(this), 8.0F);
		} else {
			return entityIn.hurt(DamageSource.mobAttack(this), 3.0F);
		}
	}

	public SoundSource getSoundSource() {
		return this.getRabbitType() == 99 ? SoundSource.HOSTILE : SoundSource.NEUTRAL;
	}

	/**
	 * Called when the entity is attacked.
	 */
	public boolean hurt(DamageSource source, float amount) {
		return this.isInvulnerableTo(source) ? false : super.hurt(source, amount);
	}

	private boolean isRabbitBreedingItem(Item itemIn) {
		return itemIn == Items.CARROT || itemIn == Items.GOLDEN_CARROT || itemIn == Blocks.DANDELION.asItem();
	}

	/**
	 * Checks if the parameter is an item which this animal can be fed to breed it
	 * (wheat, carrots or seeds depending on the animal type)
	 */
	public boolean isFood(ItemStack stack) {
		return this.isRabbitBreedingItem(stack.getItem());
	}

	public int getRabbitType() {
		return this.entityData.get(RABBIT_TYPE);
	}

	public void setRabbitType(int rabbitTypeId) {
		if (rabbitTypeId == 99) {
			this.getAttribute(Attributes.ARMOR).setBaseValue(8.0D);
			this.goalSelector.addGoal(4, new BeaverEntity.EvilAttackGoal(this));
			this.targetSelector.addGoal(1, (new HurtByTargetGoal(this)).setAlertOthers());
			this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, Player.class, true));
		}

		this.entityData.set(RABBIT_TYPE, rabbitTypeId);
	}

	@Nullable
	public SpawnGroupData finalizeSpawn(ServerLevelAccessor worldIn, DifficultyInstance difficultyIn, MobSpawnType reason,
			@Nullable SpawnGroupData spawnDataIn, @Nullable CompoundTag dataTag) {
		int i = this.getRandomRabbitType(worldIn);
		if (spawnDataIn instanceof BeaverEntity.RabbitData) {
			i = ((BeaverEntity.RabbitData) spawnDataIn).typeData;
		} else {
			spawnDataIn = new BeaverEntity.RabbitData(i);
		}

		this.setRabbitType(i);
		return super.finalizeSpawn(worldIn, difficultyIn, reason, spawnDataIn, dataTag);
	}

	private int getRandomRabbitType(LevelAccessor p_213610_1_) {
		Biome biome = p_213610_1_.getBiome(this.blockPosition());
		int i = this.random.nextInt(100);
		if (biome.getPrecipitation() == Biome.Precipitation.SNOW) {
			return i < 80 ? 1 : 3;
		} else if (biome.getBiomeCategory() == Biome.BiomeCategory.DESERT) {
			return 4;
		} else {
			return i < 50 ? 0 : (i < 90 ? 5 : 2);
		}
	}

	public static boolean checkRabbitSpawnRules(EntityType<BeaverEntity> p_223321_0_, LevelAccessor p_223321_1_, MobSpawnType reason,
			BlockPos p_223321_3_, Random p_223321_4_) {
		BlockState blockstate = p_223321_1_.getBlockState(p_223321_3_.below());
		return (blockstate.is(Blocks.GRASS_BLOCK) || blockstate.is(Blocks.SNOW)
				|| blockstate.is(Blocks.SAND)) && p_223321_1_.getRawBrightness(p_223321_3_, 0) > 8;
	}

	/**
	 * Returns true if {@link net.minecraft.entity.passive.EntityRabbit#carrotTicks
	 * carrotTicks} has reached zero
	 */
	private boolean isCarrotEaten() {
		return this.carrotTicks == 0;
	}

	/**
	 * Handler for {@link World#setEntityState}
	 */
	@OnlyIn(Dist.CLIENT)
	public void handleEntityEvent(byte id) {
		if (id == 1) {
			this.spawnSprintParticle();
		} else {
			super.handleEntityEvent(id);
		}

	}

	@OnlyIn(Dist.CLIENT)
	public Vec3 getLeashOffset() {
		return new Vec3(0.0D, (double) (0.6F * this.getEyeHeight()), (double) (this.getBbWidth() * 0.4F));
	}

	static class AvoidEntityGoal<T extends LivingEntity> extends net.minecraft.world.entity.ai.goal.AvoidEntityGoal<T> {
		private final BeaverEntity rabbit;

		public AvoidEntityGoal(BeaverEntity rabbit, Class<T> p_i46403_2_, float p_i46403_3_, double p_i46403_4_,
				double p_i46403_6_) {
			super(rabbit, p_i46403_2_, p_i46403_3_, p_i46403_4_, p_i46403_6_);
			this.rabbit = rabbit;
		}

		/**
		 * Returns whether execution should begin. You can also read and cache any state
		 * necessary for execution in this method as well.
		 */
		public boolean canUse() {
			return this.rabbit.getRabbitType() != 99 && super.canUse();
		}
	}

	static class EvilAttackGoal extends MeleeAttackGoal {
		public EvilAttackGoal(BeaverEntity rabbit) {
			super(rabbit, 1.4D, true);
		}

		protected double getAttackReachSqr(LivingEntity attackTarget) {
			return (double) (4.0F + attackTarget.getBbWidth());
		}
	}

	static class MoveHelperController extends MoveControl {
		private final BeaverEntity rabbit;
		

		public MoveHelperController(BeaverEntity rabbit) {
			super(rabbit);
			this.rabbit = rabbit;
		}

		public void tick() {
			super.tick();
		}

		/**
		 * Sets the speed and location to move to
		 */
		public void setWantedPosition(double x, double y, double z, double speedIn) {
			if (this.rabbit.isInWater()) {
				speedIn = 1.5D;
			}

			super.setWantedPosition(x, y, z, speedIn);
			if (speedIn > 0.0D) {
				
			}

		}
	}

	static class PanicGoal extends net.minecraft.world.entity.ai.goal.PanicGoal {
		private final BeaverEntity rabbit;

		public PanicGoal(BeaverEntity rabbit, double speedIn) {
			super(rabbit, speedIn);
			this.rabbit = rabbit;
		}

		/**
		 * Keep ticking a continuous task that has already been started
		 */
		public void tick() {
			super.tick();
			this.rabbit.setMovementSpeed(this.speedModifier);
		}
	}

	public static class RabbitData extends AgeableMob.AgeableMobGroupData {
		public final int typeData;

		public RabbitData(int type) {
			super(1.0F);
			this.typeData = type;
		}
	}

	static class RaidFarmGoal extends MoveToBlockGoal {
		private final BeaverEntity rabbit;
		private boolean wantsToRaid;
		private boolean canRaid;

		public RaidFarmGoal(BeaverEntity rabbitIn) {
			super(rabbitIn, (double) 0.7F, 16);
			this.rabbit = rabbitIn;
		}

		/**
		 * Returns whether execution should begin. You can also read and cache any state
		 * necessary for execution in this method as well.
		 */
		public boolean canUse() {
			if (this.nextStartTick <= 0) {
				if (!net.minecraftforge.event.ForgeEventFactory.getMobGriefingEvent(this.rabbit.level, this.rabbit)) {
					return false;
				}

				this.canRaid = false;
				this.wantsToRaid = this.rabbit.isCarrotEaten();
				this.wantsToRaid = true;
			}

			return super.canUse();
		}

		/**
		 * Returns whether an in-progress EntityAIBase should continue executing
		 */
		public boolean canContinueToUse() {
			return this.canRaid && super.canContinueToUse();
		}

		/**
		 * Keep ticking a continuous task that has already been started
		 */
		public void tick() {
			super.tick();
			this.rabbit.getLookControl().setLookAt((double) this.blockPos.getX() + 0.5D,
					(double) (this.blockPos.getY() + 1), (double) this.blockPos.getZ() + 0.5D, 10.0F,
					(float) this.rabbit.getMaxHeadXRot());
			if (this.isReachedTarget()) {
				Level world = this.rabbit.level;
				BlockPos blockpos = this.blockPos.above();
				BlockState blockstate = world.getBlockState(blockpos);
				Block block = blockstate.getBlock();
				if (this.canRaid && block instanceof CarrotBlock) {
					Integer integer = blockstate.getValue(CarrotBlock.AGE);
					if (integer == 0) {
						world.setBlock(blockpos, Blocks.AIR.defaultBlockState(), 2);
						world.destroyBlock(blockpos, true, this.rabbit);
					} else {
						world.setBlock(blockpos, blockstate.setValue(CarrotBlock.AGE, Integer.valueOf(integer - 1)),
								2);
						world.levelEvent(2001, blockpos, Block.getId(blockstate));
					}

					this.rabbit.carrotTicks = 40;
				}

				this.canRaid = false;
				this.nextStartTick = 10;
			}

		}

		/**
		 * Return true to set given position as destination
		 */
		protected boolean isValidTarget(LevelReader worldIn, BlockPos pos) {
			Block block = worldIn.getBlockState(pos).getBlock();
			if (block == Blocks.FARMLAND && this.wantsToRaid && !this.canRaid) {
				pos = pos.above();
				BlockState blockstate = worldIn.getBlockState(pos);
				block = blockstate.getBlock();
				if (block instanceof CarrotBlock && ((CarrotBlock) block).isMaxAge(blockstate)) {
					this.canRaid = true;
					return true;
				}
			}

			return false;
		}
	}

	@Override
	public AgeableMob getBreedOffspring(ServerLevel world, AgeableMob mate) {
		return null;
	}
}
