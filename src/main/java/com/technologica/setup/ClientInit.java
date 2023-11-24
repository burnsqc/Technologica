package com.technologica.setup;

import com.technologica.Technologica;
import com.technologica.client.model.geom.TechnologicaLayerDefinitions;
import com.technologica.listeners.forgebus.MovementInputUpdateEventListener;
import com.technologica.listeners.forgebus.RenderGuiOverlayEventListener;
import com.technologica.listeners.modbus.ClientSetup;
import com.technologica.registration.listener.TechnologicaDimensionSpecialEffects;
import com.technologica.registration.listener.TechnologicaEntityRenderers;
import com.technologica.registration.listener.TechnologicaModels;
import com.technologica.registration.listener.TechnologicaColorHandlers;
import com.technologica.registration.listener.TechnologicaParticleProviders;

public class ClientInit {
	public static void init() {
		addModEventBusListeners();
		addForgeEventBusListeners();
	}

	private static void addModEventBusListeners() {
		Technologica.MOD_EVENT_BUS.addListener(TechnologicaColorHandlers::onRegisterColorHandlersBlock);
		Technologica.MOD_EVENT_BUS.addListener(TechnologicaParticleProviders::onRegisterParticleProvidersEvent);
		Technologica.MOD_EVENT_BUS.addListener(TechnologicaEntityRenderers::onRegisterRenderers);
		Technologica.MOD_EVENT_BUS.addListener(TechnologicaDimensionSpecialEffects::onRegisterDimensionSpecialEffectsEvent);
		Technologica.MOD_EVENT_BUS.addListener(ClientSetup::onFMLClientSetupEvent);
		Technologica.MOD_EVENT_BUS.addListener(TechnologicaModels::onRegisterAdditional);
		Technologica.MOD_EVENT_BUS.addListener(TechnologicaLayerDefinitions::onRegisterLayerDefinitions);
	}

	private static void addForgeEventBusListeners() {
		Technologica.FORGE_EVENT_BUS.register(new MovementInputUpdateEventListener());
		Technologica.FORGE_EVENT_BUS.register(new RenderGuiOverlayEventListener());
	}
}