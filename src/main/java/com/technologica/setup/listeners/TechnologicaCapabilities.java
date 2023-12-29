package com.technologica.setup.listeners;

import com.technologica.Technologica;
import com.technologica.capabilities.entity.airMeter.AirMeter;
import com.technologica.capabilities.entity.environmentTracker.EnvironmentTracker;
import com.technologica.capabilities.item.link.ILink;

import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.CapabilityManager;
import net.minecraftforge.common.capabilities.CapabilityToken;
import net.minecraftforge.common.capabilities.RegisterCapabilitiesEvent;

public class TechnologicaCapabilities {
	public static final Capability<AirMeter> AIR_METER_INSTANCE = CapabilityManager.get(new CapabilityToken<>() {});
	public static final Capability<EnvironmentTracker> ENVIRONMENT_TRACKER_INSTANCE = CapabilityManager.get(new CapabilityToken<>() {});
	public static final Capability<ILink> LINK_INSTANCE = CapabilityManager.get(new CapabilityToken<>() {});

	public static void register(RegisterCapabilitiesEvent event) {
		event.register(AirMeter.class);
		event.register(EnvironmentTracker.class);
		event.register(ILink.class);
		Technologica.LOGGER.info("STEUP - CAPABILITIES - 3 OF 3");
	}
}