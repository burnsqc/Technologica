package com.technologica;

import javax.annotation.Nullable;

import org.slf4j.Logger;

import com.mojang.logging.LogUtils;
import com.technologica.api.tlregen.registration.MasterDeferredRegistrar;
import com.technologica.client.multiplayer.TechnologicaClientLevel;
import com.technologica.listeners.forgebus.AttachCapabilities;
import com.technologica.listeners.forgebus.EntityJoinLevelEventListener;
import com.technologica.listeners.forgebus.ItemFishedEventListener;
import com.technologica.listeners.forgebus.LevelEventListener;
import com.technologica.listeners.forgebus.LivingAttackEventListener;
import com.technologica.listeners.forgebus.LivingBreatheEventListener;
import com.technologica.listeners.forgebus.LivingEquipmentChange;
import com.technologica.listeners.forgebus.LivingFallEventListener;
import com.technologica.listeners.forgebus.LivingHealEventListener;
import com.technologica.listeners.forgebus.LivingJumpEventListener;
import com.technologica.listeners.forgebus.PlayerEventListener;
import com.technologica.listeners.forgebus.PlayerTickEventListener;
import com.technologica.listeners.forgebus.RightClickBlockListener;
import com.technologica.listeners.forgebus.ServerAboutToStartListener;
import com.technologica.listeners.forgebus.TickEventListener;
import com.technologica.listeners.forgebus.VillagerTradesEventListener;
import com.technologica.listeners.forgebus.WandererTradesEventListener;
import com.technologica.listeners.modbus.CommonSetup;
import com.technologica.network.packets.clientbound.SetMeteorStorm;
import com.technologica.network.packets.clientbound.SetMeteorStormLevel;
import com.technologica.network.packets.clientbound.UpdateDiverCapability;
import com.technologica.network.packets.serverbound.UpdateAnnunciator;
import com.technologica.network.packets.serverbound.UpdateMonitor;
import com.technologica.server.level.TechnologicaServerLevel;
import com.technologica.setup.SetupClient;
import com.technologica.setup.config.TechnologicaConfigCommon;
import com.technologica.setup.listeners.RegisterCommands;
import com.technologica.setup.listeners.TechnologicaCapabilities;
import com.technologica.setup.listeners.TechnologicaEntityAttributes;
import com.technologica.util.DisablePlankConditionFactory;
import com.technologica.util.EnablePlankConditionFactory;
import com.technologica.util.text.TechnologicaLocation;
import com.technologica.world.entity.TechnologicaMobCategory;

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
	public static Technologica instance;
	public static final String MOD_ID = "technologica";
	public static final Logger LOGGER = LogUtils.getLogger();
	public static final IEventBus MOD_EVENT_BUS = FMLJavaModLoadingContext.get().getModEventBus();
	public static final IEventBus FORGE_EVENT_BUS = MinecraftForge.EVENT_BUS;
	public static final String PROTOCOL_VERSION = "1";
	public static final SimpleChannel CHANNEL = NetworkRegistry.newSimpleChannel(new TechnologicaLocation("main"), () -> PROTOCOL_VERSION, PROTOCOL_VERSION::equals, PROTOCOL_VERSION::equals);
	public static int PACKET_ID = 0;
	@Nullable
	public TechnologicaServerLevel serverLevel;
	@Nullable
	public TechnologicaClientLevel clientLevel;

	public Technologica() {
		LOGGER.info("TECHNOLOGICA NOW LOADING FOR DISTRIBUTION - " + FMLEnvironment.dist.toString());
		instance = this;
		MasterDeferredRegistrar.initDeferredRegisters();
		/*
		 * TLRGMasterResourceGenerator.setGenerators(
		 * () -> new TLBlockStateGenerator(),
		 * () -> new TLLanguageGenerator(),
		 * () -> new TLModelItemGenerator(),
		 * () -> new TLParticleGenerator(),
		 * () -> new TLSoundsGenerator(),
		 * () -> new TLRGAdvancementGenerator(),
		 * () -> new TLDamageTypeGenerator(),
		 * () -> new TLDimensionGenerator(),
		 * () -> new TLDimensionTypeGenerator(),
		 * () -> new TLRecipeGenerator(),
		 * () -> new TLTagBlocksGenerator(),
		 * () -> new TLTagEntityTypeGenerator(),
		 * () -> new TLTagItemsGenerator()
		 * );
		 */

		LOGGER.info("SETUP - COMMON");
		ModLoadingContext.get().registerConfig(Type.COMMON, TechnologicaConfigCommon.COMMON_SPEC, "technologica-common.toml");

		CHANNEL.registerMessage(PACKET_ID++, UpdateAnnunciator.class, UpdateAnnunciator::encode, UpdateAnnunciator::decode, UpdateAnnunciator::handle);
		CHANNEL.registerMessage(PACKET_ID++, UpdateDiverCapability.class, UpdateDiverCapability::encode, UpdateDiverCapability::decode, UpdateDiverCapability::handle);
		CHANNEL.registerMessage(PACKET_ID++, UpdateMonitor.class, UpdateMonitor::encode, UpdateMonitor::decode, UpdateMonitor::handle);
		CHANNEL.registerMessage(PACKET_ID++, SetMeteorStorm.class, SetMeteorStorm::encode, SetMeteorStorm::decode, SetMeteorStorm::handle);
		CHANNEL.registerMessage(PACKET_ID++, SetMeteorStormLevel.class, SetMeteorStormLevel::encode, SetMeteorStormLevel::decode, SetMeteorStormLevel::handle);

		MOD_EVENT_BUS.addListener(MasterDeferredRegistrar::onRegisterEvent);
		MOD_EVENT_BUS.addListener(TechnologicaEntityAttributes::onEntityAttributeCreationEvent);
		MOD_EVENT_BUS.addListener(CommonSetup::onFMLCommonSetupEvent);
		MOD_EVENT_BUS.addListener(TechnologicaCapabilities::onRegisterCapabilitiesEvent);

		FORGE_EVENT_BUS.addGenericListener(Entity.class, AttachCapabilities::onAttachCapabilitiesEvent);
		FORGE_EVENT_BUS.addListener(RegisterCommands::onRegisterCommandsEvent);
		FORGE_EVENT_BUS.register(new EntityJoinLevelEventListener());
		FORGE_EVENT_BUS.register(new ItemFishedEventListener());
		FORGE_EVENT_BUS.register(new LivingAttackEventListener());
		FORGE_EVENT_BUS.register(new LivingBreatheEventListener());
		FORGE_EVENT_BUS.register(new LivingEquipmentChange());
		FORGE_EVENT_BUS.register(new LivingFallEventListener());
		FORGE_EVENT_BUS.register(new LivingHealEventListener());
		FORGE_EVENT_BUS.register(new LivingJumpEventListener());
		FORGE_EVENT_BUS.register(new PlayerEventListener());
		FORGE_EVENT_BUS.register(new PlayerTickEventListener());
		FORGE_EVENT_BUS.register(new RightClickBlockListener());
		FORGE_EVENT_BUS.register(new ServerAboutToStartListener());
		FORGE_EVENT_BUS.register(new LevelEventListener());
		FORGE_EVENT_BUS.register(new TickEventListener());
		FORGE_EVENT_BUS.register(new VillagerTradesEventListener());
		FORGE_EVENT_BUS.register(new WandererTradesEventListener());

		// TODO: Determine best place for this. Maybe it's right here but that's unconfirmed.
		CraftingHelper.register(DisablePlankConditionFactory.Serializer.INSTANCE);
		CraftingHelper.register(EnablePlankConditionFactory.Serializer.INSTANCE);
		TechnologicaMobCategory.bootstrap();

		if (FMLEnvironment.dist.isClient()) {
			LOGGER.info("SETUP - CLIENT");
			SetupClient.init();
		}
	}

	public static Technologica getInstance() {
		return instance;
	}

	public void setServerLevel(TechnologicaServerLevel level) {
		this.serverLevel = level;
	}

	public void setClientLevel(TechnologicaClientLevel level) {
		this.clientLevel = level;
	}
}