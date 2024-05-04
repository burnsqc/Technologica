package com.technologica.setup.listeners;

import com.technologica.Technologica;
import com.technologica.server.commands.SonarCommand;
import com.technologica.server.commands.TechnologicaWeatherCommand;

import net.minecraftforge.event.RegisterCommandsEvent;

public class RegisterCommands {
	public static void onRegisterCommandsEvent(final RegisterCommandsEvent event) {
		TechnologicaWeatherCommand.register(event.getDispatcher());
		SonarCommand.register(event.getDispatcher());
		Technologica.LOGGER.info("SETUP - COMMANDS - 1 OF 1");
	}
}
