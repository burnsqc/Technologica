package com.technologica.listeners.forgebus;

import com.technologica.Technologica;
import com.technologica.client.multiplayer.TechnologicaClientLevel;
import com.technologica.client.multiplayer.TechnologicaClientLevel.TechnologicaClientLevelData;

import net.minecraftforge.client.event.ClientPlayerNetworkEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class ClientPlayerNetworkEventListener {

	@SubscribeEvent
	public void onClone(final ClientPlayerNetworkEvent.Clone event) {
		Technologica tl = Technologica.getInstance();
		TechnologicaClientLevelData data = new TechnologicaClientLevel.TechnologicaClientLevelData();
		TechnologicaClientLevel level = new TechnologicaClientLevel(event.getPlayer().clientLevel, data);
		tl.setClientLevel(level);
	}

	@SubscribeEvent
	public void onLoggingIn(final ClientPlayerNetworkEvent.LoggingIn event) {
		Technologica tl = Technologica.getInstance();
		TechnologicaClientLevelData data = new TechnologicaClientLevel.TechnologicaClientLevelData();
		TechnologicaClientLevel level = new TechnologicaClientLevel(event.getPlayer().clientLevel, data);
		tl.setClientLevel(level);
	}
}
