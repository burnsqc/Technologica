package com.technologica.listeners.forge;

import com.technologica.config.TechnologicaConfigCommon;

import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.item.DiggerItem;
import net.minecraft.world.item.Tiers;
import net.minecraftforge.event.entity.player.PlayerDestroyItemEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;

@Mod.EventBusSubscriber(bus = EventBusSubscriber.Bus.FORGE)
public class PlayerDestroyItemEventListener {

	@SubscribeEvent
	public static final void onPlayerDestroyItemEvent(final PlayerDestroyItemEvent event) {
		if (TechnologicaConfigCommon.ADJUST_TOOL_DURABILITY.get() && event.getOriginal().getItem() instanceof DiggerItem) {
			if (((DiggerItem) event.getOriginal().getItem()).getTier().equals(Tiers.WOOD)) {
				CriteriaTriggers.CONSUME_ITEM.trigger((ServerPlayer) event.getEntity(), event.getOriginal());
			}
		}
	}
}
