package com.technologica.entity.ai;

import net.minecraft.entity.ai.goal.RandomSwimmingGoal;
import net.minecraft.entity.passive.fish.AbstractGroupFishEntity;

public class SwimGoal extends RandomSwimmingGoal {
	private final AbstractGroupFishEntity fish;

	public SwimGoal(AbstractGroupFishEntity fish) {
		super(fish, 1.0D, 40);
		this.fish = fish;
	}

	public boolean canUse() {
		return this.canRandomSwim() && super.canUse();
	}

	protected boolean canRandomSwim() {
		return fish.isFollower();
	}

	
}
