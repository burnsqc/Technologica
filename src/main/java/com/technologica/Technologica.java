package com.technologica;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.technologica.capabilities.TechnologicaCapabilities;
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
import com.technologica.listeners.forgebus.ServerTickEventListener;
import com.technologica.listeners.forgebus.VillagerTradesEventListener;
import com.technologica.listeners.forgebus.WandererTradesEventListener;
import com.technologica.listeners.modbus.CommonSetup;
import com.technologica.network.packets.ClientboundUpdateAirCapabilityPacket;
import com.technologica.network.packets.ServerboundUpdateAnnunciatorPacket;
import com.technologica.network.packets.ServerboundUpdateMonitorPacket;
import com.technologica.registration.deferred.util.MasterDeferredRegistrar;
import com.technologica.setup.ClientInit;
import com.technologica.setup.Config;
import com.technologica.setup.listeners.TechnologicaEntityAttributes;
import com.technologica.util.DisablePlankConditionFactory;
import com.technologica.util.EnablePlankConditionFactory;
import com.technologica.util.text.TechnologicaLocation;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.crafting.CraftingHelper;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig.Type;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.fml.loading.FMLEnvironment;
import net.minecraftforge.network.NetworkRegistry;
import net.minecraftforge.network.simple.SimpleChannel;

@Mod(Technologica.MOD_ID)
public class Technologica {
	public static final String MOD_ID = "technologica";
	public static final Logger LOGGER = LogManager.getLogger();

	public static final IEventBus MOD_EVENT_BUS = FMLJavaModLoadingContext.get().getModEventBus();
	public static final IEventBus FORGE_EVENT_BUS = MinecraftForge.EVENT_BUS;

	public static final String PROTOCOL_VERSION = "1";
	public static final SimpleChannel CHANNEL = NetworkRegistry.newSimpleChannel(new TechnologicaLocation("main"), () -> PROTOCOL_VERSION, PROTOCOL_VERSION::equals, PROTOCOL_VERSION::equals);
	public static int PACKET_ID = 0;

	public Technologica() {
		LOGGER.info("TECHNOLOGICA NOW LOADING FOR DIST " + FMLEnvironment.dist.toString());

		LOGGER.info("INIT - COMMON");
		MasterDeferredRegistrar.initDeferredRegisters();
		registerPackets();
		addModEventBusListeners();
		addForgeEventBusListeners();

		if (FMLEnvironment.dist.isClient()) {
			LOGGER.info("INIT - CLIENT");
			ClientInit.init();
		}

		// TODO: Determine best place for this. Maybe it's right here but that's unconfirmed.
		ModLoadingContext.get().registerConfig(Type.COMMON, Config.SPEC, "technologica-common.toml");
		CraftingHelper.register(DisablePlankConditionFactory.Serializer.INSTANCE);
		CraftingHelper.register(EnablePlankConditionFactory.Serializer.INSTANCE);
	}

	private static void registerPackets() {
		CHANNEL.registerMessage(Technologica.PACKET_ID++, ServerboundUpdateAnnunciatorPacket.class, ServerboundUpdateAnnunciatorPacket::encode, ServerboundUpdateAnnunciatorPacket::decode, ServerboundUpdateAnnunciatorPacket::handle);
		CHANNEL.registerMessage(Technologica.PACKET_ID++, ServerboundUpdateMonitorPacket.class, ServerboundUpdateMonitorPacket::encode, ServerboundUpdateMonitorPacket::decode, ServerboundUpdateMonitorPacket::handle);
		CHANNEL.registerMessage(Technologica.PACKET_ID++, ClientboundUpdateAirCapabilityPacket.class, ClientboundUpdateAirCapabilityPacket::encode, ClientboundUpdateAirCapabilityPacket::decode, ClientboundUpdateAirCapabilityPacket::handle);
	}

	private static void addModEventBusListeners() {
		Technologica.MOD_EVENT_BUS.addListener(MasterDeferredRegistrar::onRegisterEvent);
		Technologica.MOD_EVENT_BUS.addListener(TechnologicaEntityAttributes::onEntityAttributeCreationEvent);
		Technologica.MOD_EVENT_BUS.addListener(CommonSetup::onFMLCommonSetupEvent);
		Technologica.MOD_EVENT_BUS.addListener(TechnologicaCapabilities::register);
	}

	private static void addForgeEventBusListeners() {
		Technologica.FORGE_EVENT_BUS.register(new AttachCapabilities());
		Technologica.FORGE_EVENT_BUS.register(new EntityJoinLevelEventListener());
		Technologica.FORGE_EVENT_BUS.register(new HarvestCheckListener());
		Technologica.FORGE_EVENT_BUS.register(new ItemFishedEventListener());
		Technologica.FORGE_EVENT_BUS.register(new LivingAttackEventListener());
		Technologica.FORGE_EVENT_BUS.register(new LivingBreatheEventListener());
		Technologica.FORGE_EVENT_BUS.register(new LivingEquipmentChangeEventListener());
		Technologica.FORGE_EVENT_BUS.register(new LivingFallEventListener());
		Technologica.FORGE_EVENT_BUS.register(new LivingHealEventListener());
		Technologica.FORGE_EVENT_BUS.register(new LivingJumpEventListener());
		Technologica.FORGE_EVENT_BUS.register(new PlayerTickEventListener());
		Technologica.FORGE_EVENT_BUS.register(new RegisterCapabilitiesEventListener());
		Technologica.FORGE_EVENT_BUS.register(new RightClickBlockListener());
		Technologica.FORGE_EVENT_BUS.register(new ServerAboutToStartListener());
		Technologica.FORGE_EVENT_BUS.addListener(ServerTickEventListener::onServerTickEvent);
		Technologica.FORGE_EVENT_BUS.register(new VillagerTradesEventListener());
		Technologica.FORGE_EVENT_BUS.register(new WandererTradesEventListener());
	}
}