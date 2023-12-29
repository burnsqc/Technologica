package com.technologica.listeners.forgebus;

import com.technologica.setup.config.TechnologicaConfigCommon;

import net.minecraft.tags.BlockTags;
import net.minecraft.world.item.AxeItem;
import net.minecraftforge.event.entity.player.PlayerEvent.HarvestCheck;
import net.minecraftforge.eventbus.api.SubscribeEvent;

/**
 * <p>
 * This class listens for HarvestCheck which is fired on the Forge event bus.
 * When the event is intercepted, the Disable Vanilla Log Harvesting feature is invoked.
 * </p>
 * 
 * @tl.status GREEN
 */

public class HarvestCheckListener {

	/**
	 * <p>
	 * Effectively disabled log drops when using any item other than an axe by setting CanHarvest to false if this feature in enabled in the common config.
	 * </p>
	 * 
	 * @param event HarvestCheck
	 */
	@SubscribeEvent
	public void disableVanillaLogHarvesting(final HarvestCheck event) {
		if (TechnologicaConfigCommon.DISABLE_VANILLA_LOG_HARVESTING.get()) {
			if (event.getTargetBlock().is(BlockTags.LOGS) && !(event.getEntity().getMainHandItem().getItem() instanceof AxeItem)) {
				event.setCanHarvest(false);
			}
		}
	}
}