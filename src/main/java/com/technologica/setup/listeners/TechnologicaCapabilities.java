package com.technologica.setup.listeners;

import com.technologica.Technologica;
import com.technologica.capabilities.entity.airMeter.AirMeter;
import com.technologica.capabilities.item.link.ILink;

import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.CapabilityManager;
import net.minecraftforge.common.capabilities.CapabilityToken;
import net.minecraftforge.common.capabilities.RegisterCapabilitiesEvent;

public final class TechnologicaCapabilities {
	public static final Capability<AirMeter> AIR_METER_INSTANCE = CapabilityManager.get(new CapabilityToken<>() {
	});
	public static final Capability<ILink> LINK_INSTANCE = CapabilityManager.get(new CapabilityToken<>() {
	});

	public static void onRegisterCapabilitiesEvent(final RegisterCapabilitiesEvent event) {
		event.register(AirMeter.class);
		event.register(ILink.class);

		Technologica.LOGGER.info("SETUP - CAPABILITIES - " + CapabilityManager.values() + " OF " + CapabilityManager.values().length);
		if (CapabilityManager.values().length != CapabilityManager.values().length) {
			Technologica.LOGGER.error("LAYER DEFINITION MAPPING FAILED: " + (CapabilityManager.values().length - CapabilityManager.values().length) + " MISSING");
		}
	}
}
