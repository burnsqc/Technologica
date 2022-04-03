package com.technologica.world.entity.ai.goal;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.world.entity.animal.AbstractFish;

public class AttackIfSwimmingGoal extends MeleeAttackGoal {

	public AttackIfSwimmingGoal(AbstractFish fish) {
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
