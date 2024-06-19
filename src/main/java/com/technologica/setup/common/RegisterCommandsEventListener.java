package com.technologica.setup.common;

import com.technologica.server.commands.SonarCommand;
import com.technologica.server.commands.TechnologicaWeatherCommand;

import net.minecraftforge.event.RegisterCommandsEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;

@Mod.EventBusSubscriber(bus = EventBusSubscriber.Bus.FORGE)
public class RegisterCommandsEventListener {

	@SubscribeEvent
	public static void onRegisterCommandsEvent(final RegisterCommandsEvent event) {
		TechnologicaWeatherCommand.register(event.getDispatcher());
		SonarCommand.register(event.getDispatcher());
	}
}
