package com.technologica.listeners.forge;

import com.technologica.Technologica;
import com.technologica.registration.dynamic.TechnologicaDimensions;
import com.technologica.server.level.TechnologicaServerLevel;
import com.technologica.world.level.storage.TechnologicaServerLevelData;

import net.minecraft.core.registries.Registries;
import net.minecraft.server.MinecraftServer;
import net.minecraftforge.event.level.LevelEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;

@Mod.EventBusSubscriber(bus = EventBusSubscriber.Bus.FORGE)
public class SetTechnologicaServerLevel {

	@SubscribeEvent
	public static final void onLoad(final LevelEvent.Load event) {
		if (!event.getLevel().isClientSide()) {
			MinecraftServer minecraftServer = event.getLevel().getServer();
			Technologica.getInstance().setServerLevel(new TechnologicaServerLevel(minecraftServer.getLevel(Registries.levelStemToLevel(TechnologicaDimensions.MOON_STEM)), TechnologicaServerLevelData.getData(minecraftServer)));
		}
	}
}
