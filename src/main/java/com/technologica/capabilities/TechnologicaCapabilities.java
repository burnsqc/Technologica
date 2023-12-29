package com.technologica.capabilities;

import com.technologica.capabilities.air.Air;
import com.technologica.capabilities.environmentTracker.EnvironmentTracker;

import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.CapabilityManager;
import net.minecraftforge.common.capabilities.CapabilityToken;
import net.minecraftforge.common.capabilities.RegisterCapabilitiesEvent;

public class TechnologicaCapabilities {
	public static final Capability<Air> INSTANCE = CapabilityManager.get(new CapabilityToken<>() {
	});

	public static final Capability<EnvironmentTracker> ENVIRONMENT_TRACKER_INSTANCE = CapabilityManager.get(new CapabilityToken<>() {
	});

	public static void register(RegisterCapabilitiesEvent event) {
		event.register(Air.class);
		event.register(EnvironmentTracker.class);
	}
}