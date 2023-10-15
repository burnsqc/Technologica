package com.technologica.listeners.forgebus;

import com.technologica.world.item.TechnologicaItems;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.event.entity.player.ItemFishedEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class ItemFishedEventListener {

	@SubscribeEvent
	public void onItemFishedEvent(ItemFishedEvent event) {
		Player player = event.getEntity();
		boolean cancel = false;
		for (int i = 0; i < player.getInventory().getContainerSize(); ++i) {
			ItemStack testStack = player.getInventory().getItem(i);
			if (testStack.getItem() == TechnologicaItems.BANANA.get()) {
				cancel = true;
			}
		}
		event.setCanceled(cancel);
	}
}
