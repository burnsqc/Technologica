package com.technologica.listeners.forgebus;

import com.technologica.Technologica;
import com.technologica.registration.key.TechnologicaDimensions;
import com.technologica.server.level.TechnologicaServerLevel;
import com.technologica.world.level.storage.TechnologicaServerLevelData;

import net.minecraft.server.MinecraftServer;
import net.minecraftforge.event.level.LevelEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class LevelEventListener {

	@SubscribeEvent
	public void onLoad(final LevelEvent.Load event) {
		if (!event.getLevel().isClientSide()) {
			MinecraftServer mc = event.getLevel().getServer();
			TechnologicaServerLevelData data = TechnologicaServerLevelData.getData(mc);
			Technologica.getInstance().setServerLevel(new TechnologicaServerLevel(mc.getLevel(TechnologicaDimensions.MOON), data));
		}
	}
}
