package com.technologica.entity.passive.fish;

import java.util.function.Predicate;

import com.technologica.entity.ai.AttackIfSwimmingGoal;
import com.technologica.entity.ai.SwimGoal;
import com.technologica.item.TechnologicaItems;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.MobEntity;
import net.minecraft.entity.ai.attributes.AttributeModifierMap;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.ai.goal.FindWaterGoal;
import net.minecraft.entity.ai.goal.FollowSchoolLeaderGoal;
import net.minecraft.entity.ai.goal.NearestAttackableTargetGoal;
import net.minecraft.entity.passive.fish.AbstractGroupFishEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.SoundEvents;
import net.minecraft.world.World;

public class PiranhaEntity extends AbstractGroupFishEntity {

	public PiranhaEntity(EntityType<? extends PiranhaEntity> typeIn, World worldIn) {
		super(typeIn, worldIn);
	}

	@Override
	protected void registerGoals() {
		this.goalSelector.addGoal(0, new FindWaterGoal(this));
		this.goalSelector.addGoal(1, new AttackIfSwimmingGoal(this));
		this.goalSelector.addGoal(4, new SwimGoal(this));
		this.goalSelector.addGoal(3, new FollowSchoolLeaderGoal(this));
		this.targetSelector.addGoal(0, new NearestAttackableTargetGoal<>(this, PlayerEntity.class, 10, true, true, (Predicate<LivingEntity>) null));
	}

	
	public static AttributeModifierMap.MutableAttribute registerAttributes() {
		return MobEntity.createMobAttributes().add(Attributes.MAX_HEALTH, 3.0D).add(Attributes.ATTACK_DAMAGE, 1.0D);
	}
	
	@Override
	public int getMaxSchoolSize() {
		return 10;
	}

	@Override
	protected ItemStack getBucketItemStack() {
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
