package com.technologica.setup;

import com.technologica.Technologica;
import com.technologica.listeners.forgebus.MovementInputUpdateEventListener;
import com.technologica.listeners.forgebus.RenderGuiOverlayEventListener;
import com.technologica.listeners.modbus.ClientSetup;
import com.technologica.setup.config.TechnologicaConfigClient;
import com.technologica.setup.listeners.TechnologicaColorHandlers;
import com.technologica.setup.listeners.TechnologicaDimensionSpecialEffects;
import com.technologica.setup.listeners.TechnologicaEntityRenderers;
import com.technologica.setup.listeners.TechnologicaLayerDefinitions;
import com.technologica.setup.listeners.TechnologicaModels;
import com.technologica.setup.listeners.TechnologicaParticleProviders;

import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.config.ModConfig.Type;

public class SetupClient {
	public static void init() {
		ModLoadingContext.get().registerConfig(Type.CLIENT, TechnologicaConfigClient.CLIENT_SPEC, "technologica-client.toml");
		Technologica.MOD_EVENT_BUS.addListener(TechnologicaColorHandlers::onRegisterColorHandlersBlock);
		Technologica.MOD_EVENT_BUS.addListener(TechnologicaParticleProviders::onRegisterParticleProvidersEvent);
		Technologica.MOD_EVENT_BUS.addListener(TechnologicaEntityRenderers::onRegisterRenderers);
		Technologica.MOD_EVENT_BUS.addListener(TechnologicaDimensionSpecialEffects::onRegisterDimensionSpecialEffectsEvent);
		Technologica.MOD_EVENT_BUS.addListener(ClientSetup::onFMLClientSetupEvent);
		Technologica.MOD_EVENT_BUS.addListener(TechnologicaModels::onRegisterAdditional);
		Technologica.MOD_EVENT_BUS.addListener(TechnologicaLayerDefinitions::onRegisterLayerDefinitions);
		Technologica.FORGE_EVENT_BUS.register(new MovementInputUpdateEventListener());
		Technologica.FORGE_EVENT_BUS.addListener(RenderGuiOverlayEventListener::onRenderGameOverlayEventPre);
	}
}