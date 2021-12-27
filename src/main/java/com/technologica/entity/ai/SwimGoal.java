package com.technologica.entity.ai;

import net.minecraft.entity.ai.goal.RandomSwimmingGoal;
import net.minecraft.entity.passive.fish.AbstractFishEntity;

public class SwimGoal extends RandomSwimmingGoal {

	public SwimGoal(AbstractFishEntity fish) {
		super(fish, 1.0D, 40);
	}

	public boolean shouldExecute() {
		return super.shouldExecute();
	}

}
