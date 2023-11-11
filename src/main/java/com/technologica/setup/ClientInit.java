package com.technologica.setup;

import static com.technologica.Technologica.CHANNEL;
import static com.technologica.Technologica.FORGE_EVENT_BUS;
import static com.technologica.Technologica.LOGGER;
import static com.technologica.Technologica.MOD_EVENT_BUS;
import static com.technologica.Technologica.PACKET_ID;

import com.technologica.client.model.geom.TechnologicaLayerDefinitions;
import com.technologica.listeners.forgebus.MovementInputUpdateEventListener;
import com.technologica.listeners.forgebus.RenderGuiOverlayEventListener;
import com.technologica.listeners.modbus.ClientSetup;
import com.technologica.listeners.modbus.RegisterColorHandlers;
import com.technologica.listeners.modbus.RegisterDimensionSpecialEffects;
import com.technologica.listeners.modbus.RegisterEntityRenderers;
import com.technologica.listeners.modbus.RegisterModels;
import com.technologica.listeners.modbus.RegisterParticleProviders;
import com.technologica.network.play.server.SUpdateAirCapabilityPacket;

public class ClientInit {
	public static void init() {
		LOGGER.info("INIT - CLIENT");
		registerPackets();
		addModEventBusListeners();
		addForgeEventBusListeners();
	}
	
	private static void registerPackets() {
		CHANNEL.registerMessage(PACKET_ID++, SUpdateAirCapabilityPacket.class, SUpdateAirCapabilityPacket::encode, SUpdateAirCapabilityPacket::decode, SUpdateAirCapabilityPacket::handle);
	}
	
	private static void addModEventBusListeners() {
		MOD_EVENT_BUS.addListener(RegisterColorHandlers::onRegisterColorHandlersBlock);
		MOD_EVENT_BUS.addListener(RegisterParticleProviders::onRegisterParticleProvidersEvent);
		MOD_EVENT_BUS.addListener(RegisterEntityRenderers::onRegisterRenderers);
		MOD_EVENT_BUS.addListener(RegisterDimensionSpecialEffects::onRegisterDimensionSpecialEffectsEvent);
		MOD_EVENT_BUS.addListener(ClientSetup::onFMLClientSetupEvent);
		MOD_EVENT_BUS.addListener(RegisterModels::onRegisterAdditional);
		MOD_EVENT_BUS.addListener(TechnologicaLayerDefinitions::onRegisterLayerDefinitions);
	}
	
	private static void addForgeEventBusListeners() {
		FORGE_EVENT_BUS.register(new MovementInputUpdateEventListener());
		FORGE_EVENT_BUS.register(new RenderGuiOverlayEventListener());
	}
}