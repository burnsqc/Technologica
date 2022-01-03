package com.technologica.entity.ai;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.entity.passive.fish.AbstractFishEntity;

public class AttackIfSwimmingGoal extends MeleeAttackGoal {

	public AttackIfSwimmingGoal(AbstractFishEntity fish) {
		super(fish, 2.0D, false);
	}

	@Override
	public boolean shouldExecute() {
		LivingEntity target = this.attacker.getAttackTarget();
		if (target != null && target.isInWater()) {
			return super.shouldExecute();
		} else {
			return false;
		}
	}

	@Override
	public boolean shouldContinueExecuting() {
		LivingEntity target = this.attacker.getAttackTarget();
		if (target != null && target.isInWater()) {
			return super.shouldContinueExecuting();
		} else {
			return false;
		}
	}
}
