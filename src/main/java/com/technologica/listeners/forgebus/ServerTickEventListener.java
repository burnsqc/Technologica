package com.technologica.listeners.forgebus;

import com.technologica.Technologica;
import com.technologica.registration.key.TechnologicaDimensionTypes;

import net.minecraft.network.protocol.game.ClientboundGameEventPacket;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.Mth;
import net.minecraft.util.valueproviders.IntProvider;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.level.GameRules;
import net.minecraftforge.event.TickEvent.LevelTickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.LogicalSide;

public class ServerTickEventListener {
	public static float oStormLevel;
	public static float stormLevel;
	public static ServerLevel level;
	public static final IntProvider STORM_DELAY = UniformInt.of(1200, 1800);
	public static final IntProvider STORM_DURATION = UniformInt.of(1200, 2400);
	private static int clearWeatherTime;
	private static int stormTime;
	private static boolean isStorming;

	@SubscribeEvent
	public static void onServerTickEvent(final LevelTickEvent event) {
		if (event.level instanceof ServerLevel) {
			level = (ServerLevel) event.level;
			if (event.side == LogicalSide.SERVER) {
				advanceWeatherCycle();
			}
		}
	}

	private static void advanceWeatherCycle() {
		boolean flag = isStorming();
		if (level.dimensionTypeId() == TechnologicaDimensionTypes.MOON) {
			if (level.getGameRules().getBoolean(GameRules.RULE_WEATHER_CYCLE)) {
				int i = clearWeatherTime;
				int k = stormTime;
				boolean flag2 = isStorming;
				if (i > 0) {
					--i;
					k = flag2 ? 0 : 1;
					flag2 = false;
				} else {
					if (k > 0) {
						--k;
						if (k == 0) {
							flag2 = !flag2;
						}
					} else if (flag2) {
						k = STORM_DURATION.sample(level.getRandom());
					} else {
						k = STORM_DELAY.sample(level.getRandom());
					}
				}

				stormTime = k;
				clearWeatherTime = i;
				isStorming = flag2;
			}

			oStormLevel = stormLevel;
			if (isStorming) {
				stormLevel += 0.01F;
			} else {
				stormLevel -= 0.01F;
			}
			stormLevel = Mth.clamp(stormLevel, 0.0F, 1.0F);
		}

		if (oStormLevel != stormLevel) {
			level.getServer().getPlayerList().broadcastAll(new ClientboundGameEventPacket(ClientboundGameEventPacket.RAIN_LEVEL_CHANGE, stormLevel), level.dimension());
		}

		if (flag != isStorming()) {
			if (flag) {
				Technologica.LOGGER.debug("STOPPING RAIN");
				level.getServer().getPlayerList().broadcastAll(new ClientboundGameEventPacket(ClientboundGameEventPacket.STOP_RAINING, 0.0F), level.dimension());
			} else {
				Technologica.LOGGER.debug("STARTING RAIN");
				level.getServer().getPlayerList().broadcastAll(new ClientboundGameEventPacket(ClientboundGameEventPacket.START_RAINING, 0.0F), level.dimension());
			}

			level.getServer().getPlayerList().broadcastAll(new ClientboundGameEventPacket(ClientboundGameEventPacket.RAIN_LEVEL_CHANGE, stormLevel), level.dimension());
		}
	}

	public static boolean isStorming() {
		return getStormLevel(1.0F) > 0.2D;
	}

	public static float getStormLevel(float p_46723_) {
		return Mth.lerp(p_46723_, oStormLevel, stormLevel);
	}
}