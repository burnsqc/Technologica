package com.technologica.capabilities;

import static com.technologica.Technologica.LOGGER;

import net.minecraftforge.common.capabilities.RegisterCapabilitiesEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class TechnologicaCapabilities {

	@SubscribeEvent
	public void init(RegisterCapabilitiesEvent event) {
		LOGGER.info("INITIALIZING CAPABILITIES");
		event.register(ILink.class);
	}
}