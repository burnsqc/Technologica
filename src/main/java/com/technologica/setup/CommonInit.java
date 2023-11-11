package com.technologica.setup;

import static com.technologica.Technologica.CHANNEL;
import static com.technologica.Technologica.FORGE_EVENT_BUS;
import static com.technologica.Technologica.LOGGER;
import static com.technologica.Technologica.MOD_EVENT_BUS;
import static com.technologica.Technologica.PACKET_ID;

import com.technologica.capabilities.TechnologicaCapabilities;
import com.technologica.datagen.GatherData;
import com.technologica.listeners.forgebus.AttachCapabilities;
import com.technologica.listeners.forgebus.EntityJoinLevelEventListener;
import com.technologica.listeners.forgebus.HarvestCheckListener;
import com.technologica.listeners.forgebus.ItemFishedEventListener;
import com.technologica.listeners.forgebus.LivingAttackEventListener;
import com.technologica.listeners.forgebus.LivingBreatheEventListener;
import com.technologica.listeners.forgebus.LivingEquipmentChangeEventListener;
import com.technologica.listeners.forgebus.LivingFallEventListener;
import com.technologica.listeners.forgebus.LivingHealEventListener;
import com.technologica.listeners.forgebus.LivingJumpEventListener;
import com.technologica.listeners.forgebus.PlayerTickEventListener;
import com.technologica.listeners.forgebus.RegisterCapabilitiesEventListener;
import com.technologica.listeners.forgebus.RightClickBlockListener;
import com.technologica.listeners.forgebus.ServerAboutToStartListener;
import com.technologica.listeners.forgebus.VillagerTradesEventListener;
import com.technologica.listeners.forgebus.WandererTradesEventListener;
import com.technologica.listeners.modbus.CommonSetup;
import com.technologica.listeners.modbus.CreateEntityAttributes;
import com.technologica.listeners.modbus.Register;
import com.technologica.network.play.client.CUpdateAnnunciatorPacket;
import com.technologica.network.play.client.CUpdateMonitorPacket;

public class CommonInit {
	public static void init() {
		LOGGER.info("INIT - COMMON");
		registerPackets();
		addModEventBusListeners();
		addForgeEventBusListeners();
	}
	
	private static void registerPackets() {
		CHANNEL.registerMessage(PACKET_ID++, CUpdateAnnunciatorPacket.class, CUpdateAnnunciatorPacket::encode, CUpdateAnnunciatorPacket::decode, CUpdateAnnunciatorPacket::handle);
		CHANNEL.registerMessage(PACKET_ID++, CUpdateMonitorPacket.class, CUpdateMonitorPacket::encode, CUpdateMonitorPacket::decode, CUpdateMonitorPacket::handle);
	}
	
	private static void addModEventBusListeners() {
		MOD_EVENT_BUS.addListener(Register::onRegisterEvent);
		MOD_EVENT_BUS.addListener(CreateEntityAttributes::onEntityAttributeCreationEvent);
		MOD_EVENT_BUS.addListener(CommonSetup::onFMLCommonSetupEvent);
		MOD_EVENT_BUS.addListener(TechnologicaCapabilities::register);
		MOD_EVENT_BUS.addListener(GatherData::onGatherDataEvent);
	}
	
	private static void addForgeEventBusListeners() {
		FORGE_EVENT_BUS.register(new AttachCapabilities());
		FORGE_EVENT_BUS.register(new EntityJoinLevelEventListener());
		FORGE_EVENT_BUS.register(new HarvestCheckListener());
		FORGE_EVENT_BUS.register(new ItemFishedEventListener());
		FORGE_EVENT_BUS.register(new LivingAttackEventListener());
		FORGE_EVENT_BUS.register(new LivingBreatheEventListener());
		FORGE_EVENT_BUS.register(new LivingEquipmentChangeEventListener());
		FORGE_EVENT_BUS.register(new LivingFallEventListener());
		FORGE_EVENT_BUS.register(new LivingHealEventListener());
		FORGE_EVENT_BUS.register(new LivingJumpEventListener());
		FORGE_EVENT_BUS.register(new PlayerTickEventListener());
		FORGE_EVENT_BUS.register(new RegisterCapabilitiesEventListener());
		FORGE_EVENT_BUS.register(new RightClickBlockListener());
		FORGE_EVENT_BUS.register(new ServerAboutToStartListener());
		FORGE_EVENT_BUS.register(new VillagerTradesEventListener());
		FORGE_EVENT_BUS.register(new WandererTradesEventListener());
	}
}