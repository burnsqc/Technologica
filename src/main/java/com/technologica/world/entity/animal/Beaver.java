package com.technologica.world.entity.animal;

import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.util.RandomSource;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.AgeableMob;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.MobSpawnType;
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
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.CarrotBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class Beaver extends Animal {
	private boolean wasOnGround;
	private int currentMoveTypeDuration;
	private int carrotTicks;

	public Beaver(EntityType<? extends Beaver> entityType, Level level) {
		super(entityType, level);
		this.moveControl = new Beaver.MoveHelperController(this);
		this.setMovementSpeed(0.0D);
	}

	@Override
	protected void registerGoals() {
		this.goalSelector.addGoal(1, new FloatGoal(this));
		this.goalSelector.addGoal(1, new Beaver.PanicGoal(this, 1.25D));
		this.goalSelector.addGoal(2, new BreedGoal(this, 0.8D));
		this.goalSelector.addGoal(3, new TemptGoal(this, 1.0D, Ingredient.of(Items.CARROT, Items.GOLDEN_CARROT, Blocks.DANDELION), false));
		this.goalSelector.addGoal(4, new Beaver.AvoidEntityGoal<>(this, Player.class, 8.0F, 2.2D, 2.2D));
		this.goalSelector.addGoal(4, new Beaver.AvoidEntityGoal<>(this, Monster.class, 4.0F, 2.2D, 2.2D));
		this.goalSelector.addGoal(5, new Beaver.RaidFarmGoal(this));
		this.goalSelector.addGoal(6, new WaterAvoidingRandomStrollGoal(this, 0.6D));
		this.goalSelector.addGoal(11, new LookAtPlayerGoal(this, Player.class, 10.0F));
	}

	public static AttributeSupplier.Builder createAttributes() {
		return AttributeSupplier.builder().add(Attributes.MAX_HEALTH, 10.0D).add(Attributes.MOVEMENT_SPEED, 0.25D).add(Attributes.FOLLOW_RANGE, 16.0D).add(Attributes.ATTACK_KNOCKBACK).add(Attributes.KNOCKBACK_RESISTANCE).add(Attributes.ARMOR).add(Attributes.ARMOR_TOUGHNESS).add(net.minecraftforge.common.ForgeMod.SWIM_SPEED.get()).add(net.minecraftforge.common.ForgeMod.NAMETAG_DISTANCE.get()).add(net.minecraftforge.common.ForgeMod.ENTITY_GRAVITY.get());
	}

	public void setMovementSpeed(double newSpeed) {
		this.getNavigation().setSpeedModifier(newSpeed);
		this.moveControl.setWantedPosition(this.moveControl.getWantedX(), this.moveControl.getWantedY(), this.moveControl.getWantedZ(), newSpeed);
	}

	@Override
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

		if (this.onGround()) {
			if (!this.wasOnGround) {
				this.setJumping(false);
				this.checkLandingDelay();
			}
		}

		this.wasOnGround = this.onGround();
	}

	@Override
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

	@Override
	public void aiStep() {
		super.aiStep();
	}

	@Override
	public void addAdditionalSaveData(CompoundTag compound) {
		super.addAdditionalSaveData(compound);

		compound.putInt("MoreCarrotTicks", this.carrotTicks);
	}

	@Override
	public void readAdditionalSaveData(CompoundTag compound) {
		super.readAdditionalSaveData(compound);

		this.carrotTicks = compound.getInt("MoreCarrotTicks");
	}

	protected SoundEvent getJumpSound() {
		return SoundEvents.RABBIT_JUMP;
	}

	@Override
	protected SoundEvent getAmbientSound() {
		return SoundEvents.RABBIT_AMBIENT;
	}

	@Override
	protected SoundEvent getHurtSound(DamageSource damageSourceIn) {
		return SoundEvents.RABBIT_HURT;
	}

	@Override
	protected SoundEvent getDeathSound() {
		return SoundEvents.RABBIT_DEATH;
	}





	@Override
	public boolean hurt(DamageSource source, float amount) {
		return this.isInvulnerableTo(source) ? false : super.hurt(source, amount);
	}

	private boolean isRabbitBreedingItem(Item itemIn) {
		return itemIn == Items.CARROT || itemIn == Items.GOLDEN_CARROT || itemIn == Blocks.DANDELION.asItem();
	}

	@Override
	public boolean isFood(ItemStack stack) {
		return this.isRabbitBreedingItem(stack.getItem());
	}

	public static boolean checkRabbitSpawnRules(EntityType<Beaver> p_223321_0_, LevelAccessor p_223321_1_, MobSpawnType reason, BlockPos p_223321_3_, RandomSource p_223321_4_) {
		BlockState blockstate = p_223321_1_.getBlockState(p_223321_3_.below());
		return (blockstate.is(Blocks.GRASS_BLOCK) || blockstate.is(Blocks.SNOW) || blockstate.is(Blocks.SAND)) && p_223321_1_.getRawBrightness(p_223321_3_, 0) > 8;
	}

	/**
	 * Returns true if {@link net.minecraft.entity.passive.EntityRabbit#carrotTicks carrotTicks} has reached zero
	 */
	private boolean isCarrotEaten() {
		return this.carrotTicks == 0;
	}

	/**
	 * Handler for {@link World#setEntityState}
	 */
	@Override
	@OnlyIn(Dist.CLIENT)
	public void handleEntityEvent(byte id) {
		if (id == 1) {
			this.spawnSprintParticle();
		} else {
			super.handleEntityEvent(id);
		}

	}

	@Override
	@OnlyIn(Dist.CLIENT)
	public Vec3 getLeashOffset() {
		return new Vec3(0.0D, 0.6F * this.getEyeHeight(), this.getBbWidth() * 0.4F);
	}

	static class AvoidEntityGoal<T extends LivingEntity> extends net.minecraft.world.entity.ai.goal.AvoidEntityGoal<T> {
		private final Beaver rabbit;

		public AvoidEntityGoal(Beaver rabbit, Class<T> p_i46403_2_, float p_i46403_3_, double p_i46403_4_, double p_i46403_6_) {
			super(rabbit, p_i46403_2_, p_i46403_3_, p_i46403_4_, p_i46403_6_);
			this.rabbit = rabbit;
		}
	}

	static class EvilAttackGoal extends MeleeAttackGoal {
		public EvilAttackGoal(Beaver rabbit) {
			super(rabbit, 1.4D, true);
		}
	}

	static class MoveHelperController extends MoveControl {
		private final Beaver rabbit;

		public MoveHelperController(Beaver rabbit) {
			super(rabbit);
			this.rabbit = rabbit;
		}

		@Override
		public void tick() {
			super.tick();
		}

		/**
		 * Sets the speed and location to move to
		 */
		@Override
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
		private final Beaver rabbit;

		public PanicGoal(Beaver rabbit, double speedIn) {
			super(rabbit, speedIn);
			this.rabbit = rabbit;
		}

		/**
		 * Keep ticking a continuous task that has already been started
		 */
		@Override
		public void tick() {
			super.tick();
			this.rabbit.setMovementSpeed(this.speedModifier);
		}
	}

	static class RaidFarmGoal extends MoveToBlockGoal {
		private final Beaver rabbit;
		private boolean wantsToRaid;
		private boolean canRaid;

		public RaidFarmGoal(Beaver rabbitIn) {
			super(rabbitIn, 0.7F, 16);
			this.rabbit = rabbitIn;
		}

		/**
		 * Returns whether execution should begin. You can also read and cache any state necessary for execution in this method as well.
		 */
		@Override
		public boolean canUse() {
			if (this.nextStartTick <= 0) {
				if (!net.minecraftforge.event.ForgeEventFactory.getMobGriefingEvent(this.rabbit.level(), this.rabbit)) {
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
		@Override
		public boolean canContinueToUse() {
			return this.canRaid && super.canContinueToUse();
		}

		/**
		 * Keep ticking a continuous task that has already been started
		 */
		@Override
		public void tick() {
			super.tick();
			this.rabbit.getLookControl().setLookAt(this.blockPos.getX() + 0.5D, this.blockPos.getY() + 1, this.blockPos.getZ() + 0.5D, 10.0F, this.rabbit.getMaxHeadXRot());
			if (this.isReachedTarget()) {
				Level world = this.rabbit.level();
				BlockPos blockpos = this.blockPos.above();
				BlockState blockstate = world.getBlockState(blockpos);
				Block block = blockstate.getBlock();
				if (this.canRaid && block instanceof CarrotBlock) {
					Integer integer = blockstate.getValue(CarrotBlock.AGE);
					if (integer == 0) {
						world.setBlock(blockpos, Blocks.AIR.defaultBlockState(), 2);
						world.destroyBlock(blockpos, true, this.rabbit);
					} else {
						world.setBlock(blockpos, blockstate.setValue(CarrotBlock.AGE, Integer.valueOf(integer - 1)), 2);
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
		@Override
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
