package com.technologica.world.entity.animal;

import java.util.function.Predicate;

import com.technologica.registration.deferred.TechnologicaItems;
import com.technologica.world.entity.ai.goal.AttackIfSwimmingGoal;

import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.EntitySelector;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.AvoidEntityGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.animal.AbstractSchoolingFish;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

/**
 * <p>
 * This class contains all of the behavior logic for piranhas.
 * <p>
 * Piranhas are very similar to other schooling fish. Key differences are piranhas attack players and do not avoid players.
 * </p>
 * 
 * @tl.status GREEN
 */
public class Piranha extends AbstractSchoolingFish {

	public Piranha(EntityType<? extends Piranha> entity, Level level) {
		super(entity, level);
	}

	@Override
	protected void registerGoals() {
		super.registerGoals();
		this.goalSelector.removeGoal(new AvoidEntityGoal<>(this, Player.class, 8.0F, 1.6D, 1.4D, EntitySelector.NO_SPECTATORS::test));
		this.goalSelector.addGoal(0, new AttackIfSwimmingGoal(this));
		this.targetSelector.addGoal(0, new NearestAttackableTargetGoal<>(this, Player.class, 10, true, true, (Predicate<LivingEntity>) null));
	}

	public static AttributeSupplier.Builder createAttributes() {
		return Mob.createMobAttributes().add(Attributes.MAX_HEALTH, 3.0D).add(Attributes.ATTACK_DAMAGE, 1.0D);
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
	protected SoundEvent getHurtSound(DamageSource damageSource) {
		return SoundEvents.SALMON_HURT;
	}

	@Override
	protected SoundEvent getFlopSound() {
		return SoundEvents.SALMON_FLOP;
	}

	@Override
	public ItemStack getBucketItemStack() {
		return new ItemStack(TechnologicaItems.PIRANHA_BUCKET.get());
	}
}
