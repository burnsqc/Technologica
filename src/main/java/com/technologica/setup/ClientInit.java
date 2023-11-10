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
import com.technologica.network.play.server.Packets;
import com.technologica.network.play.server.SUpdateAirCapabilityPacket;

public class ClientInit {
	public static void init() {
		Technologica.MOD_EVENT_BUS.addListener(RegisterColorHandlers::onRegisterColorHandlersBlock);
		Technologica.MOD_EVENT_BUS.addListener(RegisterParticleProviders::onRegisterParticleProvidersEvent);
		Technologica.MOD_EVENT_BUS.addListener(RegisterEntityRenderers::onRegisterRenderers);
		Technologica.MOD_EVENT_BUS.addListener(RegisterDimensionSpecialEffects::onRegisterDimensionSpecialEffectsEvent);
		Technologica.MOD_EVENT_BUS.addListener(ClientSetup::onFMLClientSetupEvent);
		Technologica.MOD_EVENT_BUS.addListener(RegisterModels::onRegisterAdditional);
		Technologica.MOD_EVENT_BUS.addListener(TechnologicaLayerDefinitions::onRegisterLayerDefinitions);
		
		Technologica.FORGE_EVENT_BUS.register(new MovementInputUpdateEventListener());
		Technologica.FORGE_EVENT_BUS.register(new RenderGuiOverlayEventListener());
		
		Packets.INSTANCE.registerMessage(Packets.nextID(), SUpdateAirCapabilityPacket.class, SUpdateAirCapabilityPacket::encode, SUpdateAirCapabilityPacket::decode, SUpdateAirCapabilityPacket::handle);
	}
}