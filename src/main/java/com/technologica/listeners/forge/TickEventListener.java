package com.technologica.listeners.forge;

import com.technologica.Technologica;

import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.LogicalSide;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;

@Mod.EventBusSubscriber(bus = EventBusSubscriber.Bus.FORGE)
public class TickEventListener {

	@SubscribeEvent
	public static void onLevelTick(final TickEvent.LevelTickEvent event) {
		if (event.side == LogicalSide.SERVER) {
			Technologica.getInstance().serverLevel.tick();
		}
	}
}
