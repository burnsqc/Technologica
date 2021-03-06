package com.technologica.entity.passive;

import java.util.Random;

import javax.annotation.Nullable;

import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.CreatureAttribute;
import net.minecraft.entity.EntitySize;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ILivingEntityData;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Pose;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.ai.attributes.AttributeModifierMap;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.ai.goal.HurtByTargetGoal;
import net.minecraft.entity.ai.goal.LeapAtTargetGoal;
import net.minecraft.entity.ai.goal.LookAtGoal;
import net.minecraft.entity.ai.goal.LookRandomlyGoal;
import net.minecraft.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.entity.ai.goal.NearestAttackableTargetGoal;
import net.minecraft.entity.ai.goal.SwimGoal;
import net.minecraft.entity.ai.goal.WaterAvoidingRandomWalkingGoal;
import net.minecraft.entity.monster.MonsterEntity;
import net.minecraft.entity.passive.IronGolemEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.potion.Effect;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.util.DamageSource;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.world.Difficulty;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.IServerWorld;
import net.minecraft.world.World;

public class ScorpionEntity extends MonsterEntity {

	public ScorpionEntity(EntityType<? extends ScorpionEntity> type, World worldIn) {
		super(type, worldIn);
	}

	protected void registerGoals() {
		this.goalSelector.addGoal(1, new SwimGoal(this));
		this.goalSelector.addGoal(3, new LeapAtTargetGoal(this, 0.4F));
		this.goalSelector.addGoal(4, new ScorpionEntity.AttackGoal(this));
		this.goalSelector.addGoal(5, new WaterAvoidingRandomWalkingGoal(this, 0.8D));
		this.goalSelector.addGoal(6, new LookAtGoal(this, PlayerEntity.class, 8.0F));
		this.goalSelector.addGoal(6, new LookRandomlyGoal(this));
		this.targetSelector.addGoal(1, new HurtByTargetGoal(this));
		this.targetSelector.addGoal(2, new ScorpionEntity.TargetGoal<>(this, PlayerEntity.class));
		this.targetSelector.addGoal(3, new ScorpionEntity.TargetGoal<>(this, IronGolemEntity.class));
	}

	/**
	 * Returns the Y offset from the entity's position for any entity riding this
	 * one.
	 */
	public double getMountedYOffset() {
		return (double) (this.getHeight() * 0.5F);
	}

	protected void registerData() {
		super.registerData();
	}

	/**
	 * Called to update the entity's position/logic.
	 */
	public void tick() {
		super.tick();
	}

	public static AttributeModifierMap.MutableAttribute func_234305_eI_() {
		return MonsterEntity.func_234295_eP_().createMutableAttribute(Attributes.MAX_HEALTH, 16.0D).createMutableAttribute(Attributes.MOVEMENT_SPEED, (double) 0.3F);
	}

	protected SoundEvent getAmbientSound() {
		return SoundEvents.ENTITY_SPIDER_AMBIENT;
	}

	protected SoundEvent getHurtSound(DamageSource damageSourceIn) {
		return SoundEvents.ENTITY_SPIDER_HURT;
	}

	protected SoundEvent getDeathSound() {
		return SoundEvents.ENTITY_SPIDER_DEATH;
	}

	protected void playStepSound(BlockPos pos, BlockState blockIn) {
		this.playSound(SoundEvents.ENTITY_SPIDER_STEP, 0.15F, 1.0F);
	}

	public void setMotionMultiplier(BlockState state, Vector3d motionMultiplierIn) {
		if (!state.matchesBlock(Blocks.COBWEB)) {
			super.setMotionMultiplier(state, motionMultiplierIn);
		}

	}

	public CreatureAttribute getCreatureAttribute() {
		return CreatureAttribute.ARTHROPOD;
	}

	public boolean isPotionApplicable(EffectInstance potioneffectIn) {
		if (potioneffectIn.getPotion() == Effects.POISON) {
			net.minecraftforge.event.entity.living.PotionEvent.PotionApplicableEvent event = new net.minecraftforge.event.entity.living.PotionEvent.PotionApplicableEvent(
					this, potioneffectIn);
			net.minecraftforge.common.MinecraftForge.EVENT_BUS.post(event);
			return event.getResult() == net.minecraftforge.eventbus.api.Event.Result.ALLOW;
		}
		return super.isPotionApplicable(potioneffectIn);
	}

	@Nullable
	public ILivingEntityData onInitialSpawn(IServerWorld worldIn, DifficultyInstance difficultyIn, SpawnReason reason,
			@Nullable ILivingEntityData spawnDataIn, @Nullable CompoundNBT dataTag) {
		spawnDataIn = super.onInitialSpawn(worldIn, difficultyIn, reason, spawnDataIn, dataTag);

		if (spawnDataIn == null) {
			spawnDataIn = new ScorpionEntity.GroupData();
			if (worldIn.getDifficulty() == Difficulty.HARD
					&& worldIn.getRandom().nextFloat() < 0.1F * difficultyIn.getClampedAdditionalDifficulty()) {
				((ScorpionEntity.GroupData) spawnDataIn).setRandomEffect(worldIn.getRandom());
			}
		}

		if (spawnDataIn instanceof ScorpionEntity.GroupData) {
			Effect effect = ((ScorpionEntity.GroupData) spawnDataIn).effect;
			if (effect != null) {
				this.addPotionEffect(new EffectInstance(effect, Integer.MAX_VALUE));
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

		/**
		 * Returns whether execution should begin. You can also read and cache any state
		 * necessary for execution in this method as well.
		 */
		public boolean shouldExecute() {
			return super.shouldExecute() && !this.attacker.isBeingRidden();
		}

		/**
		 * Returns whether an in-progress EntityAIBase should continue executing
		 */
		public boolean shouldContinueExecuting() {
			float f = this.attacker.getBrightness();
			if (f >= 0.5F && this.attacker.getRNG().nextInt(100) == 0) {
				this.attacker.setAttackTarget((LivingEntity) null);
				return false;
			} else {
				return super.shouldContinueExecuting();
			}
		}

		protected double getAttackReachSqr(LivingEntity attackTarget) {
			return (double) (4.0F + attackTarget.getWidth());
		}
	}

	public static class GroupData implements ILivingEntityData {
		public Effect effect;

		public void setRandomEffect(Random rand) {
			int i = rand.nextInt(5);
			if (i <= 1) {
				this.effect = Effects.SPEED;
			} else if (i <= 2) {
				this.effect = Effects.STRENGTH;
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
		public boolean shouldExecute() {
			float f = this.goalOwner.getBrightness();
			return f >= 0.5F ? false : super.shouldExecute();
		}
	}
}
