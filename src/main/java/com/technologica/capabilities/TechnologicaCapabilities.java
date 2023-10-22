package com.technologica.capabilities;

import com.technologica.capabilities.air.IAir;

import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.CapabilityManager;
import net.minecraftforge.common.capabilities.CapabilityToken;
import net.minecraftforge.common.capabilities.RegisterCapabilitiesEvent;

public class TechnologicaCapabilities {
	public static final Capability<IAir> INSTANCE = CapabilityManager.get(new CapabilityToken<>() {
	});

	public static void register(RegisterCapabilitiesEvent event) {
		event.register(IAir.class);
	}
}