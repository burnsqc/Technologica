package com.technologica.world.entity.animal;

import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.AgeableMob;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.BreedGoal;
import net.minecraft.world.entity.ai.goal.FloatGoal;
import net.minecraft.world.entity.ai.goal.FollowParentGoal;
import net.minecraft.world.entity.ai.goal.LookAtPlayerGoal;
import net.minecraft.world.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.world.entity.ai.goal.PanicGoal;
import net.minecraft.world.entity.ai.goal.RandomLookAroundGoal;
import net.minecraft.world.entity.ai.goal.TemptGoal;
import net.minecraft.world.entity.ai.goal.WaterAvoidingRandomStrollGoal;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;

public class Buffalo extends AbstractPackAnimal {
	public int tailCounter;

	public Buffalo(EntityType<? extends Buffalo> entity, Level level) {
		super(entity, level);
	}

	@Override
	protected void registerGoals() {
		super.registerGoals();
		this.goalSelector.addGoal(0, new FloatGoal(this));
		this.goalSelector.addGoal(1, new MeleeAttackGoal(this, 1.0D, true));
		this.goalSelector.addGoal(2, new BreedGoal(this, 1.0D));
		this.goalSelector.addGoal(2, new PanicGoal(this, 1.5D));
		this.goalSelector.addGoal(3, new TemptGoal(this, 1.25D, Ingredient.of(Items.WHEAT), false));
		this.goalSelector.addGoal(4, new FollowParentGoal(this, 1.25D));
		this.goalSelector.addGoal(5, new WaterAvoidingRandomStrollGoal(this, 0.75D));
		this.goalSelector.addGoal(6, new LookAtPlayerGoal(this, Player.class, 6.0F));
		this.goalSelector.addGoal(7, new RandomLookAroundGoal(this));
		this.targetSelector.addGoal(1, new Buffalo.BuffaloHurtByTargetGoal());
	}

	public static AttributeSupplier.Builder createAttributes() {
		return AttributeSupplier.builder().add(Attributes.MAX_HEALTH, 15.0D).add(Attributes.MOVEMENT_SPEED, 0.2D).add(Attributes.ATTACK_DAMAGE, 6.0D).add(Attributes.FOLLOW_RANGE, 16.0D).add(Attributes.ATTACK_KNOCKBACK).add(Attributes.KNOCKBACK_RESISTANCE).add(Attributes.ARMOR).add(Attributes.ARMOR_TOUGHNESS).add(net.minecraftforge.common.ForgeMod.SWIM_SPEED.get()).add(net.minecraftforge.common.ForgeMod.NAMETAG_DISTANCE.get()).add(net.minecraftforge.common.ForgeMod.ENTITY_GRAVITY.get());
	}

	@Override
	protected SoundEvent getAmbientSound() {
		return SoundEvents.COW_AMBIENT;
	}

	@Override
	protected SoundEvent getHurtSound(DamageSource damageSource) {
		return SoundEvents.COW_HURT;
	}

	@Override
	protected SoundEvent getDeathSound() {
		return SoundEvents.COW_DEATH;
	}

	@Override
	protected void playStepSound(BlockPos blockPos, BlockState blockState) {
		this.playSound(SoundEvents.COW_STEP, 0.15F, 1.0F);
	}

	@Override
	protected float getSoundVolume() {
		return 0.4F;
	}

	@Override
	public AgeableMob getBreedOffspring(ServerLevel level, AgeableMob mate) {
		return null;
	}

	@Override
	public void tick() {
		super.tick();
		if (this.tailCounter > 0 && ++this.tailCounter > 8) {
			this.tailCounter = 0;
		}
	}

	@Override
	public void aiStep() {
		if (this.random.nextInt(200) == 0) {
			this.moveTail();
		}
		super.aiStep();
	}

	private void moveTail() {
		this.tailCounter = 1;
	}

	class BuffaloHurtByTargetGoal extends HurtByTargetGoal {
		public BuffaloHurtByTargetGoal() {
			super(Buffalo.this);
		}

		@Override
		public void start() {
			super.start();
			if (Buffalo.this.isBaby()) {
				this.alertOthers();
				this.stop();
			}
		}

		@Override
		protected void alertOther(Mob mob, LivingEntity p_29581_) {
			if (mob instanceof Buffalo && !mob.isBaby()) {
				super.alertOther(mob, p_29581_);
			}
		}
	}
}
