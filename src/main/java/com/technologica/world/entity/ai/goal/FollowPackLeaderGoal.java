package com.technologica.world.entity.ai.goal;

import java.util.List;
import java.util.function.Predicate;

import com.mojang.datafixers.DataFixUtils;
import com.technologica.world.entity.animal.AbstractPackAnimal;

import net.minecraft.world.entity.ai.goal.Goal;

public class FollowPackLeaderGoal extends Goal {
	private final AbstractPackAnimal mob;
	private int timeToRecalcPath;
	private int nextStartTick;

	public FollowPackLeaderGoal(AbstractPackAnimal p_25249_) {
		this.mob = p_25249_;
		this.nextStartTick = this.nextStartTick(p_25249_);
	}

	protected int nextStartTick(AbstractPackAnimal p_25252_) {
		return reducedTickDelay(200 + p_25252_.getRandom().nextInt(200) % 20);
	}

	@Override
	public boolean canUse() {
		if (this.mob.hasFollowers()) {
			return false;
		} else if (this.mob.isFollower()) {
			return true;
		} else if (this.nextStartTick > 0) {
			--this.nextStartTick;
			return false;
		} else {
			this.nextStartTick = this.nextStartTick(this.mob);
			Predicate<AbstractPackAnimal> predicate = (p_25258_) -> {
				return p_25258_.canBeFollowed() || !p_25258_.isFollower();
			};
			List<? extends AbstractPackAnimal> list = this.mob.level().getEntitiesOfClass(this.mob.getClass(), this.mob.getBoundingBox().inflate(8.0D, 8.0D, 8.0D), predicate);
			AbstractPackAnimal abstractPackAnimal = DataFixUtils.orElse(list.stream().filter(AbstractPackAnimal::canBeFollowed).findAny(), this.mob);
			abstractPackAnimal.addFollowers(list.stream().filter((p_25255_) -> {
				return !p_25255_.isFollower();
			}));
			return this.mob.isFollower();
		}
	}

	@Override
	public boolean canContinueToUse() {
		return this.mob.isFollower() && this.mob.inRangeOfLeader();
	}

	@Override
	public void start() {
		this.timeToRecalcPath = 0;
	}

	@Override
	public void stop() {
		this.mob.stopFollowing();
	}

	@Override
	public void tick() {
		if (--this.timeToRecalcPath <= 0) {
			this.timeToRecalcPath = this.adjustedTickDelay(10);
			this.mob.pathToLeader();
		}
	}
}