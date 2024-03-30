package com.technologica.setup;

import com.technologica.Technologica;
import com.technologica.listeners.forgebus.ClientPlayerNetwork;
import com.technologica.listeners.forgebus.MovementInputUpdateEventListener;
import com.technologica.listeners.forgebus.RenderGuiOverlayEventListener;
import com.technologica.listeners.forgebus.RenderLevelStageEventListener;
import com.technologica.listeners.modbus.ClientSetup;
import com.technologica.setup.listeners.EntityRenderersEventListener;
import com.technologica.setup.listeners.TechnologicaColorHandlers;
import com.technologica.setup.listeners.TechnologicaDimensionSpecialEffects;
import com.technologica.setup.listeners.TechnologicaModels;
import com.technologica.setup.listeners.TechnologicaParticleProviders;

public class SetupClient {
	public static void init() {
		Technologica.MOD_EVENT_BUS.addListener(TechnologicaColorHandlers::onRegisterColorHandlersBlock);
		Technologica.MOD_EVENT_BUS.addListener(TechnologicaParticleProviders::onRegisterParticleProvidersEvent);
		Technologica.MOD_EVENT_BUS.addListener(EntityRenderersEventListener::onRegisterRenderers);
		Technologica.MOD_EVENT_BUS.addListener(TechnologicaDimensionSpecialEffects::onRegisterDimensionSpecialEffectsEvent);
		Technologica.MOD_EVENT_BUS.addListener(ClientSetup::onFMLClientSetupEvent);
		Technologica.MOD_EVENT_BUS.addListener(TechnologicaModels::onRegisterAdditional);
		Technologica.MOD_EVENT_BUS.addListener(EntityRenderersEventListener::onRegisterLayerDefinitions);
		Technologica.FORGE_EVENT_BUS.register(new MovementInputUpdateEventListener());
		Technologica.FORGE_EVENT_BUS.addListener(RenderGuiOverlayEventListener::onPre);
		Technologica.FORGE_EVENT_BUS.register(new RenderLevelStageEventListener());
		Technologica.FORGE_EVENT_BUS.register(new ClientPlayerNetwork());
	}
}