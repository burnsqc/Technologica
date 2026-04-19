package com.technologica.world.entity.ai.goal;

import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.PathfinderMob;
import net.minecraft.world.entity.ai.goal.Goal;

public class LurkSurfaceGoal extends Goal {
	private final PathfinderMob mob;

	public LurkSurfaceGoal(PathfinderMob mob) {
		this.mob = mob;
	}

	@Override
	public boolean canUse() {
		return mob.isInWater() && mob.getTarget() == null;
	}

	@Override
	public void tick() {
		BlockPos pos = mob.blockPosition();

		int surfaceY = pos.getY();
		while (surfaceY < mob.level().getMaxBuildHeight() && mob.level().getFluidState(new BlockPos(pos.getX(), surfaceY, pos.getZ())).isSource()) {
			surfaceY++;
		}

		double dy = surfaceY - 0.54F - mob.getY();
		mob.setDeltaMovement(mob.getDeltaMovement().add(0, dy * 0.1, 0));
	}
}
