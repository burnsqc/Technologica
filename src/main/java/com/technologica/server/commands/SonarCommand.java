package com.technologica.server.commands;

import com.mojang.brigadier.builder.LiteralArgumentBuilder;
import com.technologica.listeners.forge.RenderLevelStageEventListener;

import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.Commands;

public class SonarCommand {
	static final LiteralArgumentBuilder<CommandSourceStack> COMMAND = Commands.literal("sonar").requires((commandSourceStack) -> commandSourceStack.hasPermission(2)).then(Commands.literal("ping").executes((commandContext) -> setClear(commandContext.getSource(), -1)));

	private static int setClear(CommandSourceStack stack, int duration) {
		RenderLevelStageEventListener.setTime();
		return duration;
	}
}