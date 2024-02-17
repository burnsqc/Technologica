package com.technologica.world.entity.animal;

import java.util.List;
import java.util.stream.Stream;

import javax.annotation.Nullable;

import com.technologica.world.entity.ai.goal.FollowPackLeaderGoal;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.SpawnGroupData;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.ServerLevelAccessor;

public abstract class AbstractPackAnimal extends Animal {
	@Nullable
	private AbstractPackAnimal leader;
	private int packSize = 1;

	public AbstractPackAnimal(EntityType<? extends AbstractPackAnimal> abstractPackAnimal, Level level) {
		super(abstractPackAnimal, level);
	}

	@Override
	protected void registerGoals() {
		this.goalSelector.addGoal(5, new FollowPackLeaderGoal(this));
	}

	public int getMaxPackSize() {
		return 12;
	}

	public boolean isFollower() {
		return this.leader != null && this.leader.isAlive();
	}

	public AbstractPackAnimal startFollowing(AbstractPackAnimal abstractPackAnimal) {
		this.leader = abstractPackAnimal;
		abstractPackAnimal.addFollower();
		return abstractPackAnimal;
	}

	public void stopFollowing() {
		this.leader.removeFollower();
		this.leader = null;
	}

	private void addFollower() {
		++this.packSize;
	}

	private void removeFollower() {
		--this.packSize;
	}

	public boolean canBeFollowed() {
		return this.hasFollowers() && this.packSize < this.getMaxPackSize();
	}

	@Override
	public void tick() {
		super.tick();
		if (this.hasFollowers() && this.level().random.nextInt(200) == 1) {
			List<? extends AbstractPackAnimal> list = this.level().getEntitiesOfClass(this.getClass(), this.getBoundingBox().inflate(8.0D, 8.0D, 8.0D));
			if (list.size() <= 1) {
				this.packSize = 1;
			}
		}
	}

	public boolean hasFollowers() {
		return this.packSize > 1;
	}

	public boolean inRangeOfLeader() {
		return this.distanceToSqr(this.leader) <= 121.0D && this.distanceToSqr(this.leader) >= 16.0D;
	}

	public void pathToLeader() {
		if (this.isFollower()) {
			this.getNavigation().moveTo(this.leader, 0.5D);
		}
	}

	public void addFollowers(Stream<? extends AbstractPackAnimal> abstractPackAnimals) {
		abstractPackAnimals.limit(this.getMaxPackSize() - this.packSize).filter((abstractPackAnimal) -> {
			return abstractPackAnimal != this;
		}).forEach((abstractPackAnimal) -> {
			abstractPackAnimal.startFollowing(this);
		});
	}

	@Override
	@Nullable
	public SpawnGroupData finalizeSpawn(ServerLevelAccessor level, DifficultyInstance difficultyInstance, MobSpawnType p_27530_, @Nullable SpawnGroupData p_27531_, @Nullable CompoundTag p_27532_) {
		super.finalizeSpawn(level, difficultyInstance, p_27530_, p_27531_, p_27532_);
		if (p_27531_ == null) {
			p_27531_ = new AbstractPackAnimal.PackSpawnGroupData(this);
		} else {
			this.startFollowing(((AbstractPackAnimal.PackSpawnGroupData) p_27531_).leader);
		}

		return p_27531_;
	}

	public static class PackSpawnGroupData implements SpawnGroupData {
		public final AbstractPackAnimal leader;

		public PackSpawnGroupData(AbstractPackAnimal abstractPackAnimal) {
			this.leader = abstractPackAnimal;
		}
	}
}
