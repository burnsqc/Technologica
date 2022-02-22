package com.technologica.entity.passive;

import java.util.Random;

import javax.annotation.Nullable;

import net.minecraft.block.BlockState;
import net.minecraft.entity.CreatureAttribute;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntitySize;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ILivingEntityData;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Pose;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.ai.attributes.AttributeModifierMap;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.ai.goal.AvoidEntityGoal;
import net.minecraft.entity.ai.goal.HurtByTargetGoal;
import net.minecraft.entity.ai.goal.LeapAtTargetGoal;
import net.minecraft.entity.ai.goal.LookAtGoal;
import net.minecraft.entity.ai.goal.LookRandomlyGoal;
import net.minecraft.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.entity.ai.goal.NearestAttackableTargetGoal;
import net.minecraft.entity.ai.goal.SwimGoal;
import net.minecraft.entity.ai.goal.WaterAvoidingRandomWalkingGoal;
import net.minecraft.entity.monster.MonsterEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.potion.Effect;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.util.DamageSource;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.Difficulty;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.IServerWorld;
import net.minecraft.world.World;

public class ScorpionEntity extends MonsterEntity {
	public int clawCounter;

	public ScorpionEntity(EntityType<? extends ScorpionEntity> type, World worldIn) {
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
					((LivingEntity) entityIn).addEffect(new EffectInstance(Effects.POISON, i * 20, 0));
				}
			}
			return true;
		} else {
			return false;
		}
	}

	protected void registerGoals() {
		this.goalSelector.addGoal(1, new SwimGoal(this));
		this.goalSelector.addGoal(2, new AvoidEntityGoal<>(this, CoyoteEntity.class, 8.0F, 1.0D, 1.0D));
		this.goalSelector.addGoal(3, new LeapAtTargetGoal(this, 0.4F));
		this.goalSelector.addGoal(4, new ScorpionEntity.AttackGoal(this));
		this.goalSelector.addGoal(5, new WaterAvoidingRandomWalkingGoal(this, 0.8D));
		this.goalSelector.addGoal(6, new LookAtGoal(this, PlayerEntity.class, 8.0F));
		this.goalSelector.addGoal(6, new LookRandomlyGoal(this));
		this.targetSelector.addGoal(1, new HurtByTargetGoal(this));
		this.targetSelector.addGoal(2, new ScorpionEntity.TargetGoal<>(this, PlayerEntity.class));
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

	public static AttributeModifierMap.MutableAttribute createAttributes() {
		return MonsterEntity.createMonsterAttributes().add(Attributes.MAX_HEALTH, 16.0D)
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

	public CreatureAttribute getMobType() {
		return CreatureAttribute.ARTHROPOD;
	}

	public boolean canBeAffected(EffectInstance potioneffectIn) {
		if (potioneffectIn.getEffect() == Effects.POISON) {
			net.minecraftforge.event.entity.living.PotionEvent.PotionApplicableEvent event = new net.minecraftforge.event.entity.living.PotionEvent.PotionApplicableEvent(
					this, potioneffectIn);
			net.minecraftforge.common.MinecraftForge.EVENT_BUS.post(event);
			return event.getResult() == net.minecraftforge.eventbus.api.Event.Result.ALLOW;
		}
		return super.canBeAffected(potioneffectIn);
	}

	@Nullable
	public ILivingEntityData finalizeSpawn(IServerWorld worldIn, DifficultyInstance difficultyIn, SpawnReason reason,
			@Nullable ILivingEntityData spawnDataIn, @Nullable CompoundNBT dataTag) {
		spawnDataIn = super.finalizeSpawn(worldIn, difficultyIn, reason, spawnDataIn, dataTag);

		if (spawnDataIn == null) {
			spawnDataIn = new ScorpionEntity.GroupData();
			if (worldIn.getDifficulty() == Difficulty.HARD
					&& worldIn.getRandom().nextFloat() < 0.1F * difficultyIn.getSpecialMultiplier()) {
				((ScorpionEntity.GroupData) spawnDataIn).setRandomEffect(worldIn.getRandom());
			}
		}

		if (spawnDataIn instanceof ScorpionEntity.GroupData) {
			Effect effect = ((ScorpionEntity.GroupData) spawnDataIn).effect;
			if (effect != null) {
				this.addEffect(new EffectInstance(effect, Integer.MAX_VALUE));
			}
		}

		return spawnDataIn;
	}

	protected float getStandingEyeHeight(Pose poseIn, EntitySize sizeIn) {
		return 0.65F;
	}

	static class AttackGoal extends MeleeAttackGoal {
		public AttackGoal(ScorpionEntity spider) {
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

	public static class GroupData implements ILivingEntityData {
		public Effect effect;

		public void setRandomEffect(Random rand) {
			int i = rand.nextInt(5);
			if (i <= 1) {
				this.effect = Effects.MOVEMENT_SPEED;
			} else if (i <= 2) {
				this.effect = Effects.DAMAGE_BOOST;
			} else if (i <= 3) {
				this.effect = Effects.REGENERATION;
			} else if (i <= 4) {
				this.effect = Effects.INVISIBILITY;
			}

		}
	}

	static class TargetGoal<T extends LivingEntity> extends NearestAttackableTargetGoal<T> {
		public TargetGoal(ScorpionEntity spider, Class<T> classTarget) {
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
