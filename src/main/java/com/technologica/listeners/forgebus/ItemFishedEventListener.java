package com.technologica.listeners.forgebus;

import com.technologica.registration.deferred.TechnologicaItems;
import com.technologica.setup.config.TechnologicaConfigCommon;
import com.technologica.util.InventoryUtil;

import net.minecraftforge.event.entity.player.ItemFishedEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

/**
 * <p>
 * This class listens for ItemFishedEvent which is fired on the Forge event bus.
 * When the event is intercepted, the Naughty Nautical Nanners feature is invoked.
 * </p>
 * 
 * @tl.status GREEN
 */

public class ItemFishedEventListener {

	/**
	 * <p>
	 * Effectively disabled fishing by canceling this event if the player has a banana in their inventory and this feature is enabled in the common config.
	 * </p>
	 * 
	 * @param event ItemFishedEvent
	 */
	@SubscribeEvent
	public void naughtyNauticalNanners(final ItemFishedEvent event) {
		if (TechnologicaConfigCommon.NAUGHTY_NAUTICAL_NANNERS.get()) {
			event.setCanceled(InventoryUtil.playerHas(event.getEntity(), TechnologicaItems.BANANA.get()));
		}
	}
}