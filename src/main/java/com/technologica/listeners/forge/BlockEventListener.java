package com.technologica.listeners.forge;

import com.technologica.config.TechnologicaConfigCommon;
import com.technologica.resourcegen.data.advancements.TechnologicaCriterionTriggers;

import net.minecraft.server.level.ServerPlayer;
import net.minecraft.tags.BlockTags;
import net.minecraftforge.common.ForgeHooks;
import net.minecraftforge.event.level.BlockEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;

@Mod.EventBusSubscriber(bus = EventBusSubscriber.Bus.FORGE)
public class BlockEventListener {

	@SubscribeEvent
	public static final void onBlockEvent$BreakEvent(final BlockEvent.BreakEvent event) {
		if (TechnologicaConfigCommon.DISABLE_VANILLA_LOG_HARVESTING.get() && !ForgeHooks.isCorrectToolForDrops(event.getState(), event.getPlayer())) {
			if (event.getState().is(BlockTags.LOGS) && !event.getPlayer().level().isClientSide()) {
				TechnologicaCriterionTriggers.ATTEMPTED_HARVEST.trigger((ServerPlayer) event.getPlayer(), event.getState(), event.getPlayer().getMainHandItem());
			}
		}
	}
}
