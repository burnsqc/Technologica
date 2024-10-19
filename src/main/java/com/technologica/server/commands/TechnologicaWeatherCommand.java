package com.technologica.server.commands;

import com.mojang.brigadier.arguments.IntegerArgumentType;
import com.mojang.brigadier.builder.LiteralArgumentBuilder;
import com.technologica.Technologica;
import com.technologica.server.level.TechnologicaServerLevel;

import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.Commands;
import net.minecraft.commands.arguments.TimeArgument;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.valueproviders.IntProvider;

public class TechnologicaWeatherCommand {
	static final LiteralArgumentBuilder<CommandSourceStack> COMMAND = Commands.literal("weather").requires((stack) -> {
		return stack.hasPermission(2);
	}).then(Commands.literal("clear").executes((p_264806_) -> {
		return setClear(p_264806_.getSource(), -1);
	}).then(Commands.argument("duration", TimeArgument.time(1)).executes((p_264807_) -> {
		return setClear(p_264807_.getSource(), IntegerArgumentType.getInteger(p_264807_, "duration"));
	}))).then(Commands.literal("meteor_storm").executes((context) -> {
		return setMeteorStorm(context.getSource(), -1);
	}).then(Commands.argument("duration", TimeArgument.time(1)).executes((context) -> {
		return setMeteorStorm(context.getSource(), IntegerArgumentType.getInteger(context, "duration"));
	})));

	private static int getDuration(CommandSourceStack stack, int duration, IntProvider intProvider) {
		return duration == -1 ? intProvider.sample(stack.getLevel().getRandom()) : duration;
	}

	private static int setClear(CommandSourceStack stack, int duration) {
		stack.getLevel().setWeatherParameters(getDuration(stack, duration, ServerLevel.RAIN_DELAY), 0, false, false);
		Technologica tc = Technologica.getInstance();
		tc.serverLevel.setWeatherParameters(getDuration(stack, duration, TechnologicaServerLevel.METEOR_STORM_DELAY), 0, false);
		stack.sendSuccess(() -> {
			return Component.translatable("commands.weather.set.clear");
		}, true);
		return duration;
	}

	private static int setMeteorStorm(CommandSourceStack stack, int duration) {
		stack.getLevel().setWeatherParameters(0, 0, false, false);

		Technologica tc = Technologica.getInstance();
		tc.serverLevel.setWeatherParameters(0, getDuration(stack, duration, TechnologicaServerLevel.METEOR_STORM_DURATION), true);

		// ServerTickEventListener.setStormTime(getDuration(stack, duration, TechnologicaServerLevel.METEOR_STORM_DURATION));

		stack.sendSuccess(() -> {
			return Component.translatable("commands.weather.set.meteor_storm");
		}, true);
		return duration;
	}
}