package com.technologica.listeners.forgebus;

import static com.technologica.Technologica.LOGGER;

import com.technologica.capabilities.ILink;

import net.minecraftforge.common.capabilities.RegisterCapabilitiesEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class RegisterCapabilitiesEventListener {

	@SubscribeEvent
	public void init(RegisterCapabilitiesEvent event) { // NO_UCD (unused code)
		event.register(ILink.class);
		LOGGER.info("CAPABILITIES REGISTERED: 1 OF 1");
	}
}