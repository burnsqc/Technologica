package com.technologica.world.entity.animal;

import java.util.function.Predicate;

import com.technologica.world.entity.ai.AttackIfSwimmingGoal;
import com.technologica.world.entity.ai.SwimGoal;
import com.technologica.world.item.TechnologicaItems;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.TryFindWaterGoal;
import net.minecraft.world.entity.ai.goal.FollowFlockLeaderGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.animal.AbstractSchoolingFish;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.level.Level;

public class Piranha extends AbstractSchoolingFish {

	public Piranha(EntityType<? extends Piranha> typeIn, Level worldIn) {
		super(typeIn, worldIn);
	}

	@Override
	protected void registerGoals() {
		this.goalSelector.addGoal(0, new TryFindWaterGoal(this));
		this.goalSelector.addGoal(1, new AttackIfSwimmingGoal(this));
		this.goalSelector.addGoal(4, new SwimGoal(this));
		this.goalSelector.addGoal(3, new FollowFlockLeaderGoal(this));
		this.targetSelector.addGoal(0, new NearestAttackableTargetGoal<>(this, Player.class, 10, true, true, (Predicate<LivingEntity>) null));
	}

	
	public static AttributeSupplier.Builder registerAttributes() {
		return Mob.createMobAttributes().add(Attributes.MAX_HEALTH, 3.0D).add(Attributes.ATTACK_DAMAGE, 1.0D);
	}
	
	@Override
	public int getMaxSchoolSize() {
		return 10;
	}

	@Override
	public ItemStack getBucketItemStack() {
		return new ItemStack(TechnologicaItems.PIRANHA_BUCKET.get());
	}

	@Override
	protected SoundEvent getAmbientSound() {
		return SoundEvents.SALMON_AMBIENT;
	}

	@Override
	protected SoundEvent getDeathSound() {
		return SoundEvents.SALMON_DEATH;
	}

	@Override
	protected SoundEvent getHurtSound(DamageSource damageSourceIn) {
		return SoundEvents.SALMON_HURT;
	}

	@Override
	protected SoundEvent getFlopSound() {
		return SoundEvents.SALMON_FLOP;
	}

}
