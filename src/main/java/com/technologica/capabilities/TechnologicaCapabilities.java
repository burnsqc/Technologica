package com.technologica.capabilities;

import static com.technologica.Technologica.LOGGER;

import net.minecraftforge.common.capabilities.CapabilityManager;

public class TechnologicaCapabilities {

	public static void init() {
		LOGGER.info("INITIALIZING CAPABILITIES");
		CapabilityManager.INSTANCE.register(ILink.class, new Link.LinkStorage(), new Link.Factory());
	}
}
