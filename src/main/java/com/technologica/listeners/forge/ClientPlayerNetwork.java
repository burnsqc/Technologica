package com.technologica.listeners.forge;

import com.technologica.Technologica;
import com.technologica.client.multiplayer.TechnologicaClientLevel;
import com.technologica.client.multiplayer.TechnologicaClientLevel.TechnologicaClientLevelData;

import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.ClientPlayerNetworkEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;

@Mod.EventBusSubscriber(bus = EventBusSubscriber.Bus.FORGE, value = Dist.CLIENT)
public class ClientPlayerNetwork {

	@SubscribeEvent
	public static void onClone(final ClientPlayerNetworkEvent.Clone event) {
		Technologica tl = Technologica.getInstance();
		TechnologicaClientLevelData data = new TechnologicaClientLevel.TechnologicaClientLevelData();
		TechnologicaClientLevel level = new TechnologicaClientLevel(event.getPlayer().clientLevel, data);
		tl.setClientLevel(level);
	}

	@SubscribeEvent
	public static void onLoggingIn(final ClientPlayerNetworkEvent.LoggingIn event) {
		Technologica tl = Technologica.getInstance();
		TechnologicaClientLevelData data = new TechnologicaClientLevel.TechnologicaClientLevelData();
		TechnologicaClientLevel level = new TechnologicaClientLevel(event.getPlayer().clientLevel, data);
		tl.setClientLevel(level);
	}
}
