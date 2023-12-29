package com.technologica.listeners.forgebus;

import com.technologica.capabilities.entity.airMeter.AirMeterProvider;
import com.technologica.capabilities.entity.environmentTracker.EnvironmentTrackerProvider;
import com.technologica.util.text.TechnologicaLocation;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class AttachCapabilities {

	@SubscribeEvent
	public void onAttachCapabilitiesEvent(final AttachCapabilitiesEvent<Entity> event) {
		if (event.getObject() instanceof Player) {
			final AirMeterProvider provider = new AirMeterProvider();
			final EnvironmentTrackerProvider environmentTrackerProvider = new EnvironmentTrackerProvider();

			event.addCapability(new TechnologicaLocation("air_meter"), provider);
			if (!event.getCapabilities().containsKey(new TechnologicaLocation("environment_tracker"))) {
				event.addCapability(new TechnologicaLocation("environment_tracker"), environmentTrackerProvider);
			}
		}
	}
}