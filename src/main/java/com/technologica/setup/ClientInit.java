package com.technologica.setup;

import com.technologica.Technologica;
import com.technologica.listeners.forgebus.MovementInputUpdateEventListener;
import com.technologica.listeners.forgebus.RenderGuiOverlayEventListener;
import com.technologica.listeners.modbus.ClientSetup;
import com.technologica.setup.listeners.TechnologicaColorHandlers;
import com.technologica.setup.listeners.TechnologicaDimensionSpecialEffects;
import com.technologica.setup.listeners.TechnologicaEntityRenderers;
import com.technologica.setup.listeners.TechnologicaLayerDefinitions;
import com.technologica.setup.listeners.TechnologicaModels;
import com.technologica.setup.listeners.TechnologicaParticleProviders;

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
		Technologica.FORGE_EVENT_BUS.addListener(RenderGuiOverlayEventListener::onRenderGameOverlayEventPre);
	}
}