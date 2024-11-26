package com.technologica.listeners.forge;

import com.technologica.Technologica;
import com.technologica.client.multiplayer.TechnologicaClientLevel;

import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.ClientPlayerNetworkEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;

@Mod.EventBusSubscriber(bus = EventBusSubscriber.Bus.FORGE, value = Dist.CLIENT)
public class SetTechnologicaClientLevel {

	@SubscribeEvent
	public static final void onClone(final ClientPlayerNetworkEvent.Clone event) {
		Technologica.getInstance().setClientLevel(new TechnologicaClientLevel(event.getPlayer().clientLevel, new TechnologicaClientLevel.TechnologicaClientLevelData()));
	}

	@SubscribeEvent
	public static final void onLoggingIn(final ClientPlayerNetworkEvent.LoggingIn event) {
		Technologica.getInstance().setClientLevel(new TechnologicaClientLevel(event.getPlayer().clientLevel, new TechnologicaClientLevel.TechnologicaClientLevelData()));
	}
}
