package com.technologica.setup.listeners;

import com.technologica.Technologica;
import com.technologica.server.commands.TechnologicaWeatherCommand;

import net.minecraftforge.event.RegisterCommandsEvent;

public class TechnologicaCommands {

	public static void register(final RegisterCommandsEvent event) {
		TechnologicaWeatherCommand.register(event.getDispatcher());
		Technologica.LOGGER.info("SETUP - COMMANDS - 1 OF 1");
	}
}