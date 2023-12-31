package com.technologica;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

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
import com.technologica.listeners.forgebus.PlayerChangedDimensionEventListener;
import com.technologica.listeners.forgebus.PlayerTickEventListener;
import com.technologica.listeners.forgebus.RightClickBlockListener;
import com.technologica.listeners.forgebus.ServerAboutToStartListener;
import com.technologica.listeners.forgebus.ServerTickEventListener;
import com.technologica.listeners.forgebus.VillagerTradesEventListener;
import com.technologica.listeners.forgebus.WandererTradesEventListener;
import com.technologica.listeners.modbus.CommonSetup;
import com.technologica.network.packets.ClientboundSetMeteorStorm;
import com.technologica.network.packets.ClientboundSetMeteorStormLevel;
import com.technologica.network.packets.ClientboundTriggerEnvironmentTitleCardPacket;
import com.technologica.network.packets.ClientboundUpdateAirCapabilityPacket;
import com.technologica.network.packets.ServerboundUpdateAnnunciatorPacket;
import com.technologica.network.packets.ServerboundUpdateMonitorPacket;
import com.technologica.registration.deferred.util.MasterDeferredRegistrar;
import com.technologica.setup.SetupClient;
import com.technologica.setup.config.TechnologicaConfigCommon;
import com.technologica.setup.listeners.TechnologicaCapabilities;
import com.technologica.setup.listeners.TechnologicaCommands;
import com.technologica.setup.listeners.TechnologicaEntityAttributes;
import com.technologica.util.DisablePlankConditionFactory;
import com.technologica.util.EnablePlankConditionFactory;
import com.technologica.util.text.TechnologicaLocation;

import net.minecraft.world.entity.Entity;
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
		LOGGER.info("TECHNOLOGICA NOW LOADING FOR DISTRIBUTION - " + FMLEnvironment.dist.toString());

		MasterDeferredRegistrar.initDeferredRegisters();

		LOGGER.info("SETUP - COMMON");
		ModLoadingContext.get().registerConfig(Type.COMMON, TechnologicaConfigCommon.COMMON_SPEC, "technologica-common.toml");

		CHANNEL.registerMessage(PACKET_ID++, ServerboundUpdateAnnunciatorPacket.class, ServerboundUpdateAnnunciatorPacket::encode, ServerboundUpdateAnnunciatorPacket::decode, ServerboundUpdateAnnunciatorPacket::handle);
		CHANNEL.registerMessage(PACKET_ID++, ServerboundUpdateMonitorPacket.class, ServerboundUpdateMonitorPacket::encode, ServerboundUpdateMonitorPacket::decode, ServerboundUpdateMonitorPacket::handle);
		CHANNEL.registerMessage(PACKET_ID++, ClientboundUpdateAirCapabilityPacket.class, ClientboundUpdateAirCapabilityPacket::encode, ClientboundUpdateAirCapabilityPacket::decode, ClientboundUpdateAirCapabilityPacket::handle);
		CHANNEL.registerMessage(PACKET_ID++, ClientboundTriggerEnvironmentTitleCardPacket.class, ClientboundTriggerEnvironmentTitleCardPacket::encode, ClientboundTriggerEnvironmentTitleCardPacket::decode, ClientboundTriggerEnvironmentTitleCardPacket::handle);
		CHANNEL.registerMessage(PACKET_ID++, ClientboundSetMeteorStorm.class, ClientboundSetMeteorStorm::encode, ClientboundSetMeteorStorm::decode, ClientboundSetMeteorStorm::handle);
		CHANNEL.registerMessage(PACKET_ID++, ClientboundSetMeteorStormLevel.class, ClientboundSetMeteorStormLevel::encode, ClientboundSetMeteorStormLevel::decode, ClientboundSetMeteorStormLevel::handle);

		MOD_EVENT_BUS.addListener(MasterDeferredRegistrar::onRegisterEvent);
		MOD_EVENT_BUS.addListener(TechnologicaEntityAttributes::onEntityAttributeCreationEvent);
		MOD_EVENT_BUS.addListener(CommonSetup::onFMLCommonSetupEvent);
		MOD_EVENT_BUS.addListener(TechnologicaCapabilities::register);

		FORGE_EVENT_BUS.addListener(TechnologicaCommands::register);
		FORGE_EVENT_BUS.addGenericListener(Entity.class, AttachCapabilities::onAttachCapabilitiesEvent);
		FORGE_EVENT_BUS.register(new EntityJoinLevelEventListener());
		FORGE_EVENT_BUS.register(new HarvestCheckListener());
		FORGE_EVENT_BUS.register(new ItemFishedEventListener());
		FORGE_EVENT_BUS.register(new LivingAttackEventListener());
		FORGE_EVENT_BUS.register(new LivingBreatheEventListener());
		FORGE_EVENT_BUS.register(new LivingEquipmentChangeEventListener());
		FORGE_EVENT_BUS.register(new LivingFallEventListener());
		FORGE_EVENT_BUS.register(new LivingHealEventListener());
		FORGE_EVENT_BUS.register(new LivingJumpEventListener());
		FORGE_EVENT_BUS.register(new PlayerChangedDimensionEventListener());
		FORGE_EVENT_BUS.register(new PlayerTickEventListener());
		FORGE_EVENT_BUS.register(new RightClickBlockListener());
		FORGE_EVENT_BUS.register(new ServerAboutToStartListener());
		FORGE_EVENT_BUS.addListener(ServerTickEventListener::onServerTickEvent);
		FORGE_EVENT_BUS.register(new VillagerTradesEventListener());
		FORGE_EVENT_BUS.register(new WandererTradesEventListener());

		// TODO: Determine best place for this. Maybe it's right here but that's unconfirmed.
		CraftingHelper.register(DisablePlankConditionFactory.Serializer.INSTANCE);
		CraftingHelper.register(EnablePlankConditionFactory.Serializer.INSTANCE);

		if (FMLEnvironment.dist.isClient()) {
			LOGGER.info("SETUP - CLIENT");
			SetupClient.init();
		}
	}
}