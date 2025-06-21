package com.technologica.server.commands;

import com.mojang.brigadier.builder.LiteralArgumentBuilder;

import net.minecraft.client.Minecraft;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.Commands;

public class PanoramaCommand {
	static final LiteralArgumentBuilder<CommandSourceStack> COMMAND = Commands.literal("panorama").requires((commandSourceStack) -> commandSourceStack.hasPermission(2)).executes((commandContext) -> ping(commandContext.getSource()));

	private static int ping(CommandSourceStack stack) {
		Minecraft.getInstance().grabPanoramixScreenshot(Minecraft.getInstance().gameDirectory, 1000, 1000);
		return 0;
	}
}