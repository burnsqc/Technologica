package com.technologica.setup.listeners;

import com.technologica.Technologica;
import com.technologica.capabilities.item.link.Link;
import com.technologica.world.entity.player.TechnologicaAbilities;

import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.CapabilityManager;
import net.minecraftforge.common.capabilities.CapabilityToken;
import net.minecraftforge.common.capabilities.RegisterCapabilitiesEvent;

public final class TechnologicaCapabilities {
	public static final Capability<TechnologicaAbilities> DIVER_INSTANCE = CapabilityManager.get(new CapabilityToken<>() {
	});
	public static final Capability<Link> LINK_INSTANCE = CapabilityManager.get(new CapabilityToken<>() {
	});

	public static void onRegisterCapabilitiesEvent(final RegisterCapabilitiesEvent event) {
		event.register(TechnologicaAbilities.class);
		event.register(Link.class);

		Technologica.LOGGER.info("SETUP - CAPABILITIES - " + CapabilityManager.values() + " OF " + CapabilityManager.values().length);
		if (CapabilityManager.values().length != CapabilityManager.values().length) {
			Technologica.LOGGER.error("LAYER DEFINITION MAPPING FAILED: " + (CapabilityManager.values().length - CapabilityManager.values().length) + " MISSING");
		}
	}
}
