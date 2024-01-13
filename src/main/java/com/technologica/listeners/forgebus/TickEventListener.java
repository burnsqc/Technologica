package com.technologica.listeners.forgebus;

import com.technologica.Technologica;

import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.LogicalSide;

public class TickEventListener {

	@SubscribeEvent
	public void onLevelTick(final TickEvent.LevelTickEvent event) {
		if (event.side == LogicalSide.SERVER) {
			Technologica.getInstance().serverLevel.tick();
		}
	}
}
