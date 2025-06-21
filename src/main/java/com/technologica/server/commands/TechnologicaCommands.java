package com.technologica.server.commands;

import java.util.List;

import com.mojang.brigadier.builder.LiteralArgumentBuilder;

import net.minecraft.commands.CommandSourceStack;

public class TechnologicaCommands {
	public static final List<LiteralArgumentBuilder<CommandSourceStack>> COMMANDS = List.of(PanoramaCommand.COMMAND, SonarCommand.COMMAND, TechnologicaWeatherCommand.COMMAND);
}
