package com.technologica.server.commands;

import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.arguments.IntegerArgumentType;
import com.technologica.listeners.forgebus.ServerTickEventListener;

import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.Commands;
import net.minecraft.commands.arguments.TimeArgument;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.valueproviders.IntProvider;

public class TechnologicaWeatherCommand {

	public static void register(CommandDispatcher<CommandSourceStack> command) {
		command.register(Commands.literal("weather").requires((stack) -> {
			return stack.hasPermission(2);
		}).then(Commands.literal("clear").executes((p_264806_) -> {
			return setClear(p_264806_.getSource(), -1);
		}).then(Commands.argument("duration", TimeArgument.time(1)).executes((p_264807_) -> {
			return setClear(p_264807_.getSource(), IntegerArgumentType.getInteger(p_264807_, "duration"));
		}))).then(Commands.literal("meteor_storm").executes((context) -> {
			return setMeteorStorm(context.getSource(), -1);
		}).then(Commands.argument("duration", TimeArgument.time(1)).executes((context) -> {
			return setMeteorStorm(context.getSource(), IntegerArgumentType.getInteger(context, "duration"));
		}))));
	}

	private static int getDuration(CommandSourceStack stack, int duration, IntProvider intProvider) {
		return duration == -1 ? intProvider.sample(stack.getLevel().getRandom()) : duration;
	}

	private static int setClear(CommandSourceStack p_139173_, int p_139174_) {
		p_139173_.getLevel().setWeatherParameters(getDuration(p_139173_, p_139174_, ServerLevel.RAIN_DELAY), 0, false, false);
		ServerTickEventListener.setStormTime(0);
		ServerTickEventListener.setStorming(false);
		p_139173_.sendSuccess(() -> {
			return Component.translatable("commands.weather.set.clear");
		}, true);
		return p_139174_;
	}

	private static int setMeteorStorm(CommandSourceStack stack, int duration) {
		stack.getLevel().setWeatherParameters(0, 0, true, false);

		ServerTickEventListener.setStormTime(getDuration(stack, duration, ServerTickEventListener.STORM_DURATION));
		ServerTickEventListener.setStorming(true);

		stack.sendSuccess(() -> {
			return Component.translatable("commands.weather.set.meteor_storm");
		}, true);
		return duration;
	}
}