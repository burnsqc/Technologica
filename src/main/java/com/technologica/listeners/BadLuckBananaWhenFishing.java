package com.technologica.listeners;

import com.technologica.item.TechnologicaItems;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraftforge.event.entity.player.ItemFishedEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class BadLuckBananaWhenFishing {

	@SubscribeEvent
	public void onItemFishedEvent(ItemFishedEvent event) {
		PlayerEntity player = event.getPlayer();
		boolean cancel = false;
		for(int i = 0; i < player.inventory.getContainerSize(); ++i) {
        	ItemStack testStack = player.inventory.getItem(i);
        	if (testStack.getItem() == TechnologicaItems.BANANA.get()) {
        		cancel = true;
        	}
        }
		
		event.setCanceled(cancel);
	}
}
