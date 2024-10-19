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
public class LevelEventListener {

	@SubscribeEvent
	public static void onLoad(final LevelEvent.Load event) {
		if (!event.getLevel().isClientSide()) {
			MinecraftServer mc = event.getLevel().getServer();
			TechnologicaServerLevelData data = TechnologicaServerLevelData.getData(mc);
			Technologica.getInstance().setServerLevel(new TechnologicaServerLevel(mc.getLevel(Registries.levelStemToLevel(TechnologicaDimensions.MOON_STEM)), data));
		}
	}
}
