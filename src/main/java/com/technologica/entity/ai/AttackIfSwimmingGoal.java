package com.technologica.entity.ai;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.entity.passive.fish.AbstractFishEntity;

public class AttackIfSwimmingGoal extends MeleeAttackGoal {

	public AttackIfSwimmingGoal(AbstractFishEntity fish) {
		super(fish, 2.0D, true);
	}

	@Override
	protected void checkAndPerformAttack(LivingEntity enemy, double distToEnemySqr) {
		if (enemy.isSwimming()) {
			double d0 = this.getAttackReachSqr(enemy);
			if (distToEnemySqr <= d0 && this.isSwingOnCooldown()) {
				this.resetSwingCooldown();
				this.attacker.attackEntityAsMob(enemy);
	
			} else if (distToEnemySqr <= d0 * 2.0D) {
				if (this.isSwingOnCooldown()) {
					this.resetSwingCooldown();
				}
	
			} else {
				this.resetSwingCooldown();
			}
		}
	}

	@Override
	protected double getAttackReachSqr(LivingEntity attackTarget) {
		return (double) (4.0F + attackTarget.getWidth());
	}
}
