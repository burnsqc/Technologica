package com.technologica.listeners.forge;

import com.technologica.config.TechnologicaConfigCommon;
import com.technologica.registration.deferred.TechnologicaItems;
import com.technologica.util.InventoryUtil;

import net.minecraftforge.event.entity.player.ItemFishedEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;

@Mod.EventBusSubscriber(bus = EventBusSubscriber.Bus.FORGE)
public class DisableFishingWithBanana {

	/**
	 * <p>Effectively disable fishing by canceling this event if the player has a banana in their inventory and this feature is enabled in the common config.</p>
	 * 
	 * @param event ItemFishedEvent
	 */
	@SubscribeEvent
	public static final void onItemFishedEvent(final ItemFishedEvent event) {
		if (TechnologicaConfigCommon.NAUGHTY_NAUTICAL_NANNERS.get()) {
			event.setCanceled(InventoryUtil.playerHas(event.getEntity(), TechnologicaItems.BANANA.get()));
		}
	}
}
