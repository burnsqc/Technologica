package com.technologica.world.entity.animal;

import javax.annotation.Nullable;

import com.technologica.world.entity.ai.goal.GoToWaterGoal;

import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.util.RandomSource;
import net.minecraft.world.Difficulty;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.AgeableMob;
import net.minecraft.world.entity.EntityDimensions;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.MobType;
import net.minecraft.world.entity.Pose;
import net.minecraft.world.entity.SpawnGroupData;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.LookAtPlayerGoal;
import net.minecraft.world.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.world.entity.ai.goal.RandomLookAroundGoal;
import net.minecraft.world.entity.ai.goal.RandomStrollGoal;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.Vec3;

public class KingCrab extends Animal {

	public KingCrab(EntityType<? extends KingCrab> type, Level worldIn) {
		super(type, worldIn);
	}

	@Override
	public AgeableMob getBreedOffspring(ServerLevel world, AgeableMob mate) {
		return null;
	}

	public static AttributeSupplier.Builder registerAttributes() {
		return AttributeSupplier.builder().add(Attributes.MAX_HEALTH, 10.0D).add(Attributes.MOVEMENT_SPEED, 0.25D).add(Attributes.FOLLOW_RANGE, 16.0D).add(Attributes.ATTACK_KNOCKBACK).add(Attributes.KNOCKBACK_RESISTANCE).add(Attributes.ARMOR).add(Attributes.ARMOR_TOUGHNESS).add(net.minecraftforge.common.ForgeMod.SWIM_SPEED.get()).add(net.minecraftforge.common.ForgeMod.NAMETAG_DISTANCE.get()).add(net.minecraftforge.common.ForgeMod.ENTITY_GRAVITY.get());
	}

	@Override
	protected void registerGoals() {
		this.goalSelector.addGoal(1, new GoToWaterGoal(this, 1.0D));
		this.goalSelector.addGoal(7, new RandomStrollGoal(this, 1.0D));
		this.goalSelector.addGoal(6, new LookAtPlayerGoal(this, Player.class, 8.0F));
		this.goalSelector.addGoal(6, new RandomLookAroundGoal(this));
		this.targetSelector.addGoal(1, new HurtByTargetGoal(this));
	}

	@Override
	public boolean canBreatheUnderwater() {
		return true;
	}

	@Override
	protected void defineSynchedData() {
		super.defineSynchedData();
	}

	@Override
	public void tick() {
		super.tick();
	}

	public static AttributeSupplier.Builder createAttributes() {
		return Monster.createMonsterAttributes().add(Attributes.MAX_HEALTH, 16.0D).add(Attributes.MOVEMENT_SPEED, 0.3F);
	}

	@Override
	protected SoundEvent getAmbientSound() {
		return SoundEvents.SPIDER_AMBIENT;
	}

	@Override
	protected SoundEvent getHurtSound(DamageSource damageSourceIn) {
		return SoundEvents.SPIDER_HURT;
	}

	@Override
	protected SoundEvent getDeathSound() {
		return SoundEvents.SPIDER_DEATH;
	}

	@Override
	protected void playStepSound(BlockPos pos, BlockState blockIn) {
		this.playSound(SoundEvents.SPIDER_STEP, 0.15F, 1.0F);
	}

	@Override
	public void makeStuckInBlock(BlockState state, Vec3 motionMultiplierIn) {
		if (!state.is(Blocks.COBWEB)) {
			super.makeStuckInBlock(state, motionMultiplierIn);
		}

	}

	@Override
	public MobType getMobType() {
		return MobType.ARTHROPOD;
	}

	@Override
	public boolean canBeAffected(MobEffectInstance potioneffectIn) {
		if (potioneffectIn.getEffect() == MobEffects.POISON) {
			net.minecraftforge.event.entity.living.MobEffectEvent.Applicable event = new net.minecraftforge.event.entity.living.MobEffectEvent.Applicable(this, potioneffectIn);
			net.minecraftforge.common.MinecraftForge.EVENT_BUS.post(event);
			return event.getResult() == net.minecraftforge.eventbus.api.Event.Result.ALLOW;
		}
		return super.canBeAffected(potioneffectIn);
	}

	@Override
	@Nullable
	public SpawnGroupData finalizeSpawn(ServerLevelAccessor worldIn, DifficultyInstance difficultyIn, MobSpawnType reason, @Nullable SpawnGroupData spawnDataIn, @Nullable CompoundTag dataTag) {
		spawnDataIn = super.finalizeSpawn(worldIn, difficultyIn, reason, spawnDataIn, dataTag);

		if (spawnDataIn == null) {
			spawnDataIn = new Scorpion.GroupData();
			if (worldIn.getDifficulty() == Difficulty.HARD && worldIn.getRandom().nextFloat() < 0.1F * difficultyIn.getSpecialMultiplier()) {
				((Scorpion.GroupData) spawnDataIn).setRandomEffect(worldIn.getRandom());
			}
		}

		if (spawnDataIn instanceof Scorpion.GroupData) {
			MobEffect effect = ((Scorpion.GroupData) spawnDataIn).effect;
			if (effect != null) {
				this.addEffect(new MobEffectInstance(effect, Integer.MAX_VALUE));
			}
		}

		return spawnDataIn;
	}

	@Override
	protected float getStandingEyeHeight(Pose poseIn, EntityDimensions sizeIn) {
		return 0.65F;
	}

	static class AttackGoal extends MeleeAttackGoal {
		public AttackGoal(Scorpion spider) {
			super(spider, 1.0D, true);
		}

		/**
		 * Returns whether execution should begin. You can also read and cache any state necessary for execution in this method as well.
		 */
		@Override
		public boolean canUse() {
			return super.canUse() && !this.mob.isVehicle();
		}

		/**
		 * Returns whether an in-progress EntityAIBase should continue executing
		 */
		@Override
		@SuppressWarnings("deprecation")
		public boolean canContinueToUse() {
			float f = this.mob.getLightLevelDependentMagicValue();
			if (f >= 0.5F && this.mob.getRandom().nextInt(100) == 0) {
				this.mob.setTarget((LivingEntity) null);
				return false;
			} else {
				return super.canContinueToUse();
			}
		}
	}

	public static class GroupData implements SpawnGroupData {
		public MobEffect effect;

		public void setRandomEffect(RandomSource rand) {
			int i = rand.nextInt(5);
			if (i <= 1) {
				this.effect = MobEffects.MOVEMENT_SPEED;
			} else if (i <= 2) {
				this.effect = MobEffects.DAMAGE_BOOST;
			} else if (i <= 3) {
				this.effect = MobEffects.REGENERATION;
			} else if (i <= 4) {
				this.effect = MobEffects.INVISIBILITY;
			}

		}
	}

	static class TargetGoal<T extends LivingEntity> extends NearestAttackableTargetGoal<T> {
		public TargetGoal(Scorpion spider, Class<T> classTarget) {
			super(spider, classTarget, true);
		}

		/**
		 * Returns whether execution should begin. You can also read and cache any state necessary for execution in this method as well.
		 */
		@SuppressWarnings("deprecation")
		@Override
		public boolean canUse() {
			float f = this.mob.getLightLevelDependentMagicValue();
			return f >= 0.5F ? false : super.canUse();
		}
	}
}
