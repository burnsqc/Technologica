package com.technologica.setup;

import com.technologica.Technologica;
import com.technologica.client.model.geom.TechnologicaLayerDefinitions;
import com.technologica.listeners.forgebus.MovementInputUpdateEventListener;
import com.technologica.listeners.forgebus.RenderGuiOverlayEventListener;
import com.technologica.listeners.modbus.ClientSetup;
import com.technologica.listeners.modbus.RegisterColorHandlers;
import com.technologica.listeners.modbus.RegisterDimensionSpecialEffects;
import com.technologica.listeners.modbus.RegisterEntityRenderers;
import com.technologica.listeners.modbus.RegisterModels;
import com.technologica.listeners.modbus.RegisterParticleProviders;

public class ClientInit {
	public static void init() {
		addModEventBusListeners();
		addForgeEventBusListeners();
	}

	private static void addModEventBusListeners() {
		Technologica.MOD_EVENT_BUS.addListener(RegisterColorHandlers::onRegisterColorHandlersBlock);
		Technologica.MOD_EVENT_BUS.addListener(RegisterParticleProviders::onRegisterParticleProvidersEvent);
		Technologica.MOD_EVENT_BUS.addListener(RegisterEntityRenderers::onRegisterRenderers);
		Technologica.MOD_EVENT_BUS.addListener(RegisterDimensionSpecialEffects::onRegisterDimensionSpecialEffectsEvent);
		Technologica.MOD_EVENT_BUS.addListener(ClientSetup::onFMLClientSetupEvent);
		Technologica.MOD_EVENT_BUS.addListener(RegisterModels::onRegisterAdditional);
		Technologica.MOD_EVENT_BUS.addListener(TechnologicaLayerDefinitions::onRegisterLayerDefinitions);
	}

	private static void addForgeEventBusListeners() {
		Technologica.FORGE_EVENT_BUS.register(new MovementInputUpdateEventListener());
		Technologica.FORGE_EVENT_BUS.register(new RenderGuiOverlayEventListener());
	}
}