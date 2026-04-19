package com.technologica.world.entity.ai.goal;

import com.technologica.world.entity.animal.Alligator;

import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.PathfinderMob;
import net.minecraft.world.entity.ai.goal.Goal;

public class GoToLandGoal extends Goal {
	private final PathfinderMob mob;
	private BlockPos targetPos;

	public GoToLandGoal(PathfinderMob mob) {
		this.mob = mob;
	}

	@Override
	public boolean canUse() {
		if (!mob.isInWater())
			return false;
		if (!((Alligator) mob).wantsLand())
			return false;

		targetPos = findNearbyLand();
		return targetPos != null;
	}

	@Override
	public void start() {
		mob.getNavigation().moveTo(targetPos.getX(), targetPos.getY(), targetPos.getZ(), 1.0);
	}

	private BlockPos findNearbyLand() {
		BlockPos mobPos = mob.blockPosition();

		for (BlockPos pos : BlockPos.betweenClosed(mobPos.offset(-10, -3, -10), mobPos.offset(10, 3, 10))) {
			if (!mob.level().getBlockState(pos).liquid() && mob.level().getBlockState(pos.above()).isAir()) {
				return pos.immutable();
			}
		}

		return null;
	}
}