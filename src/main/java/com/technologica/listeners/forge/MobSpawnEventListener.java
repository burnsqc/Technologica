package com.technologica.listeners.forge;

import com.technologica.registration.dynamic.TechnologicaDimensions;

import net.minecraft.world.entity.animal.Turtle;
import net.minecraftforge.event.entity.living.MobSpawnEvent;
import net.minecraftforge.eventbus.api.Event.Result;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;

@Mod.EventBusSubscriber(bus = EventBusSubscriber.Bus.FORGE)
public class MobSpawnEventListener {
	@SubscribeEvent
	public static void onMobSpawnEvent$PositionCheck(final MobSpawnEvent.PositionCheck event) {
		if (event.getEntity() instanceof Turtle) {
			if (event.getLevel().getLevel().dimension().equals(TechnologicaDimensions.ABYSS_STEM)) {
				if (event.getLevel().isUnobstructed(event.getEntity())) {
					event.setResult(Result.ALLOW);
				}
			}
		}
	}
}
