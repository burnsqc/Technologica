package com.technologica.entity.ai;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.entity.passive.fish.AbstractFishEntity;

public class AttackIfSwimmingGoal extends MeleeAttackGoal {

	public AttackIfSwimmingGoal(AbstractFishEntity fish) {
		super(fish, 2.0D, false);
	}

	@Override
	public boolean canUse() {
		LivingEntity target = this.mob.getTarget();
		if (target != null && target.isInWater()) {
			return super.canUse();
		} else {
			return false;
		}
	}

	@Override
	public boolean canContinueToUse() {
		LivingEntity target = this.mob.getTarget();
		if (target != null && target.isInWater()) {
			return super.canContinueToUse();
		} else {
			return false;
		}
	}
}
