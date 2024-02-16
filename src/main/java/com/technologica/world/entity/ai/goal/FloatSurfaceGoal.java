package com.technologica.world.entity.ai.goal;

import java.util.EnumSet;

import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraftforge.common.ForgeMod;

public class FloatSurfaceGoal extends Goal {
	private final Mob mob;
	private final float height;

	public FloatSurfaceGoal(Mob mob, float height) {
		this.mob = mob;
		this.height = height;
		this.setFlags(EnumSet.of(Goal.Flag.JUMP));
		mob.getNavigation().setCanFloat(true);
	}

	@Override
	public boolean canUse() {
		return this.mob.getFluidTypeHeight(ForgeMod.WATER_TYPE.get()) > this.height + 0.1 || this.mob.isInLava();
	}

	@Override
	public boolean requiresUpdateEveryTick() {
		return true;
	}

	@Override
	public void tick() {
		this.mob.getJumpControl().jump();
	}
}
