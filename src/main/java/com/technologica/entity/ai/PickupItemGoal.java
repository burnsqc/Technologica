package com.technologica.entity.ai;

import java.util.List;

import net.minecraft.entity.MobEntity;
import net.minecraft.entity.ai.goal.Goal;
import net.minecraft.entity.item.ItemEntity;
import net.minecraft.util.SoundEvents;

public class PickupItemGoal extends Goal {
	protected final MobEntity entity;
	private int pickupCooldown;

	public PickupItemGoal(MobEntity entityIn) {
		entity = entityIn;
		pickupCooldown = 0;
	}

	public boolean canUse() {
		List<ItemEntity> list = entity.level.getEntitiesOfClass(ItemEntity.class, entity.getBoundingBox().inflate(8.0D, 8.0D, 8.0D));
		return !list.isEmpty();
	}

	public void start() {
		List<ItemEntity> list = entity.level.getEntitiesOfClass(ItemEntity.class, entity.getBoundingBox().inflate(8.0D, 8.0D, 8.0D));
		if (!list.isEmpty()) {
			entity.getNavigation().moveTo(list.get(0), (double) 1.2F);
		}
	}

	public void tick() {
		List<ItemEntity> list = entity.level.getEntitiesOfClass(ItemEntity.class, entity.getBoundingBox().inflate(8.0D, 8.0D, 8.0D));
		if (!list.isEmpty()) {
			entity.playSound(SoundEvents.PLAYER_BREATH, 0.2F, 2.0F);
			entity.getNavigation().moveTo(list.get(0), (double) 1.2F);
			List<ItemEntity> list2 = entity.level.getEntitiesOfClass(ItemEntity.class, entity.getBoundingBox().inflate(1.5D, 0.0D, 1.5D));
			if (!list2.isEmpty()) {
				if (pickupCooldown > 0) {
					pickupCooldown--;
				} else {
					ItemEntity item = list2.get(0);
					item.remove();
					entity.playSound(SoundEvents.ITEM_PICKUP, 0.2F, 1.0F);
					pickupCooldown = 20;
				}
			}
		}
	}
}
