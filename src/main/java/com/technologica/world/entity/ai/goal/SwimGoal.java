package com.technologica.world.entity.ai.goal;

import net.minecraft.world.entity.ai.goal.RandomSwimmingGoal;
import net.minecraft.world.entity.animal.AbstractSchoolingFish;

public class SwimGoal extends RandomSwimmingGoal {
	private final AbstractSchoolingFish fish;

	public SwimGoal(AbstractSchoolingFish fish) {
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
