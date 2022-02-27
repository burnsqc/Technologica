package com.technologica.world.entity.animal;

import java.util.Random;

import javax.annotation.Nullable;

import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.entity.MobType;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityDimensions;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.SpawnGroupData;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Pose;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.AvoidEntityGoal;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.LeapAtTargetGoal;
import net.minecraft.world.entity.ai.goal.LookAtPlayerGoal;
import net.minecraft.world.entity.ai.goal.RandomLookAroundGoal;
import net.minecraft.world.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.ai.goal.FloatGoal;
import net.minecraft.world.entity.ai.goal.WaterAvoidingRandomStrollGoal;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.player.Player;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.core.BlockPos;
import net.minecraft.world.Difficulty;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.Level;

public class Scorpion extends Monster {
	public int clawCounter;

	public Scorpion(EntityType<? extends Scorpion> type, Level worldIn) {
		super(type, worldIn);
	}

	@Override
	public boolean doHurtTarget(Entity entityIn) {
		if (super.doHurtTarget(entityIn)) {
			if (entityIn instanceof LivingEntity) {
				int i = 0;
				if (this.level.getDifficulty() == Difficulty.NORMAL) {
					i = 7;
				} else if (this.level.getDifficulty() == Difficulty.HARD) {
					i = 15;
				}
				if (i > 0) {
					((LivingEntity) entityIn).addEffect(new MobEffectInstance(MobEffects.POISON, i * 20, 0));
				}
			}
			return true;
		} else {
			return false;
		}
	}

	protected void registerGoals() {
		this.goalSelector.addGoal(1, new FloatGoal(this));
		this.goalSelector.addGoal(2, new AvoidEntityGoal<>(this, Coyote.class, 8.0F, 1.0D, 1.0D));
		this.goalSelector.addGoal(3, new LeapAtTargetGoal(this, 0.4F));
		this.goalSelector.addGoal(4, new Scorpion.AttackGoal(this));
		this.goalSelector.addGoal(5, new WaterAvoidingRandomStrollGoal(this, 0.8D));
		this.goalSelector.addGoal(6, new LookAtPlayerGoal(this, Player.class, 8.0F));
		this.goalSelector.addGoal(6, new RandomLookAroundGoal(this));
		this.targetSelector.addGoal(1, new HurtByTargetGoal(this));
		this.targetSelector.addGoal(2, new Scorpion.TargetGoal<>(this, Player.class));
	}

	public double getPassengersRidingOffset() {
		return (double) (this.getBbHeight() * 0.5F);
	}

	protected void defineSynchedData() {
		super.defineSynchedData();
	}

	private void moveClaws() {
		this.clawCounter = 1;
	}

	public void tick() {
		if (this.clawCounter > 0 && ++this.clawCounter > 20) {
			this.clawCounter = 0;
		}
		super.tick();
	}

	@Override
	public void aiStep() {
		if (this.random.nextInt(100) == 0) {
			this.moveClaws();
		}

		super.aiStep();
	}

	public static AttributeSupplier.Builder createAttributes() {
		return Monster.createMonsterAttributes().add(Attributes.MAX_HEALTH, 16.0D)
				.add(Attributes.MOVEMENT_SPEED, (double) 0.3F);
	}

	protected SoundEvent getAmbientSound() {
		return SoundEvents.SPIDER_AMBIENT;
	}

	protected SoundEvent getHurtSound(DamageSource damageSourceIn) {
		return SoundEvents.SPIDER_HURT;
	}

	protected SoundEvent getDeathSound() {
		return SoundEvents.SPIDER_DEATH;
	}

	protected void playStepSound(BlockPos pos, BlockState blockIn) {
		this.playSound(SoundEvents.SPIDER_STEP, 0.15F, 1.0F);
	}

	public MobType getMobType() {
		return MobType.ARTHROPOD;
	}

	public boolean canBeAffected(MobEffectInstance potioneffectIn) {
		if (potioneffectIn.getEffect() == MobEffects.POISON) {
			net.minecraftforge.event.entity.living.PotionEvent.PotionApplicableEvent event = new net.minecraftforge.event.entity.living.PotionEvent.PotionApplicableEvent(
					this, potioneffectIn);
			net.minecraftforge.common.MinecraftForge.EVENT_BUS.post(event);
			return event.getResult() == net.minecraftforge.eventbus.api.Event.Result.ALLOW;
		}
		return super.canBeAffected(potioneffectIn);
	}

	@Nullable
	public SpawnGroupData finalizeSpawn(ServerLevelAccessor worldIn, DifficultyInstance difficultyIn, MobSpawnType reason,
			@Nullable SpawnGroupData spawnDataIn, @Nullable CompoundTag dataTag) {
		spawnDataIn = super.finalizeSpawn(worldIn, difficultyIn, reason, spawnDataIn, dataTag);

		if (spawnDataIn == null) {
			spawnDataIn = new Scorpion.GroupData();
			if (worldIn.getDifficulty() == Difficulty.HARD
					&& worldIn.getRandom().nextFloat() < 0.1F * difficultyIn.getSpecialMultiplier()) {
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

	protected float getStandingEyeHeight(Pose poseIn, EntityDimensions sizeIn) {
		return 0.65F;
	}

	static class AttackGoal extends MeleeAttackGoal {
		public AttackGoal(Scorpion spider) {
			super(spider, 1.0D, true);
		}

		public boolean canUse() {
			return super.canUse() && !this.mob.isVehicle();
		}

		public boolean canContinueToUse() {
			float f = this.mob.getBrightness();
			if (f >= 0.5F && this.mob.getRandom().nextInt(100) == 0) {
				this.mob.setTarget((LivingEntity) null);
				return false;
			} else {
				return super.canContinueToUse();
			}
		}

		protected double getAttackReachSqr(LivingEntity attackTarget) {
			return (double) (4.0F + attackTarget.getBbWidth());
		}
	}

	public static class GroupData implements SpawnGroupData {
		public MobEffect effect;

		public void setRandomEffect(Random rand) {
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
		 * Returns whether execution should begin. You can also read and cache any state
		 * necessary for execution in this method as well.
		 */
		public boolean canUse() {
			float f = this.mob.getBrightness();
			return f <= 0.5F ? false : super.canUse();
		}
	}
}
