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

	public boolean shouldExecute() {
		List<ItemEntity> list = entity.world.getEntitiesWithinAABB(ItemEntity.class, entity.getBoundingBox().grow(8.0D, 8.0D, 8.0D));
		return !list.isEmpty();
	}

	public void startExecuting() {
		List<ItemEntity> list = entity.world.getEntitiesWithinAABB(ItemEntity.class, entity.getBoundingBox().grow(8.0D, 8.0D, 8.0D));
		if (!list.isEmpty()) {
			entity.getNavigator().tryMoveToEntityLiving(list.get(0), (double) 1.2F);
		}
	}

	public void tick() {
		List<ItemEntity> list = entity.world.getEntitiesWithinAABB(ItemEntity.class, entity.getBoundingBox().grow(8.0D, 8.0D, 8.0D));
		if (!list.isEmpty()) {
			entity.playSound(SoundEvents.ENTITY_PLAYER_BREATH, 0.2F, 2.0F);
			entity.getNavigator().tryMoveToEntityLiving(list.get(0), (double) 1.2F);
			List<ItemEntity> list2 = entity.world.getEntitiesWithinAABB(ItemEntity.class, entity.getBoundingBox().grow(1.5D, 0.0D, 1.5D));
			if (!list2.isEmpty()) {
				if (pickupCooldown > 0) {
					pickupCooldown--;
				} else {
					ItemEntity item = list2.get(0);
					item.remove();
					entity.playSound(SoundEvents.ENTITY_ITEM_PICKUP, 0.2F, 1.0F);
					pickupCooldown = 20;
				}
			}
		}
	}
}
