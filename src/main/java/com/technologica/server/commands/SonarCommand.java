package com.technologica.server.commands;

import com.mojang.brigadier.CommandDispatcher;
import com.technologica.listeners.forge.RenderLevelStageEventListener;

import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.Commands;

public class SonarCommand {

	public static void register(CommandDispatcher<CommandSourceStack> command) {
		command.register(Commands.literal("sonar").requires((stack) -> {
			return stack.hasPermission(2);
		}).then(Commands.literal("ping").executes((p_264806_) -> {
			return setClear(p_264806_.getSource(), -1);
		})));
	}

	private static int setClear(CommandSourceStack stack, int duration) {
		RenderLevelStageEventListener.setTime();
		return duration;
	}
}