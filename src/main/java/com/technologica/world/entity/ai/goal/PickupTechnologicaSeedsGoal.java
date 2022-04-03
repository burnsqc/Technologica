package com.technologica.world.entity.ai.goal;

import com.google.common.collect.ImmutableSet;
import com.technologica.world.item.TechnologicaItems;

import net.minecraft.world.SimpleContainer;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.npc.Villager;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;

public class PickupTechnologicaSeedsGoal extends Goal {
	protected final Villager villager;
	private final ImmutableSet<Item> requestedItems = ImmutableSet.of(TechnologicaItems.BARLEY_SEEDS.get(), TechnologicaItems.OATS_SEEDS.get(), TechnologicaItems.RYE_SEEDS.get(), TechnologicaItems.BARLEY.get(), TechnologicaItems.OATS.get(), TechnologicaItems.RYE.get(), TechnologicaItems.SWEET_POTATO.get());
	public PickupTechnologicaSeedsGoal(Villager villagerIn) {
		villager = villagerIn;
	}

	public boolean canUse() {
		return true;
	}

	public void start() {
	}

	public void tick() {
		if (!villager.level.isClientSide && villager.canPickUpLoot() && villager.isAlive() && net.minecraftforge.event.ForgeEventFactory.getMobGriefingEvent(villager.level, villager)) {
			for (ItemEntity itementity : villager.level.getEntitiesOfClass(ItemEntity.class, villager.getBoundingBox().inflate(1.0D, 0.0D, 1.0D))) {
				if (!itementity.isRemoved() && !itementity.getItem().isEmpty() && !itementity.hasPickUpDelay() && this.wantsToPickUp(itementity.getItem())) {
					this.pickUpItem(itementity);
				}
			}
		}
	}

	protected void pickUpItem(ItemEntity p_35467_) {
		ItemStack itemstack = p_35467_.getItem();
		if (this.wantsToPickUp(itemstack)) {
			SimpleContainer simplecontainer = villager.getInventory();
			boolean flag = simplecontainer.canAddItem(itemstack);
			if (!flag) {
				return;
			}

			villager.onItemPickup(p_35467_);
			villager.take(p_35467_, itemstack.getCount());
			ItemStack itemstack1 = simplecontainer.addItem(itemstack);
			if (itemstack1.isEmpty()) {
				p_35467_.discard();
			} else {
				itemstack.setCount(itemstack1.getCount());
			}
		}
	}

	public boolean wantsToPickUp(ItemStack p_35543_) {
		Item item = p_35543_.getItem();
		return (requestedItems.contains(item)) && villager.getInventory().canAddItem(p_35543_);
	}
}