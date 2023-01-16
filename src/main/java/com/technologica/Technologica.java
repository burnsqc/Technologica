package com.technologica;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.technologica.client.model.geom.TechnologicaLayerDefinitions;
import com.technologica.core.particles.TechnologicaParticleTypes;
import com.technologica.listeners.forgebus.BadLuckBananaWhenFishing;
import com.technologica.listeners.forgebus.DisableLogDrops;
import com.technologica.listeners.forgebus.DropBarkOnLogStrip;
import com.technologica.listeners.forgebus.ExtraAirMeter;
import com.technologica.listeners.forgebus.LunarLowGrav;
import com.technologica.listeners.forgebus.MiningLight;
import com.technologica.listeners.forgebus.NitroPocket;
import com.technologica.listeners.forgebus.RegisterCapabilities;
import com.technologica.listeners.forgebus.ReplaceFarmerBrain;
import com.technologica.listeners.forgebus.TechnologicaVillagerTrades;
import com.technologica.listeners.forgebus.TechnologicaWanderingTraderTrades;
import com.technologica.listeners.forgebus.VanillaEntityModifier;
import com.technologica.listeners.forgebus.WaterWalk;
import com.technologica.listeners.lootmodifiers.TechnologicaLootModifiers;
import com.technologica.listeners.modbus.ClientSetup;
import com.technologica.listeners.modbus.CommonSetup;
import com.technologica.listeners.modbus.GatherData;
import com.technologica.listeners.modbus.RegisterDimensionSpecialEffects;
import com.technologica.listeners.modbus.RegisterEntityAttributes;
import com.technologica.listeners.modbus.RegisterEntityRenderers;
import com.technologica.listeners.modbus.RegisterModels;
import com.technologica.listeners.modbus.RegisterParticleProviders;
import com.technologica.listeners.modbus.TechnologicaCreativeModeTabs;
import com.technologica.setup.Config;
import com.technologica.util.DisablePlankConditionFactory;
import com.technologica.util.EnablePlankConditionFactory;
import com.technologica.util.TechnologicaSoundEvents;
import com.technologica.world.effect.TechnologicaMobEffects;
import com.technologica.world.entity.TechnologicaEntityType;
import com.technologica.world.inventory.TechnologicaMenuType;
import com.technologica.world.item.TechnologicaItems;
import com.technologica.world.item.crafting.TechnologicaRecipeSerializer;
import com.technologica.world.item.crafting.TechnologicaRecipeType;
import com.technologica.world.level.block.TechnologicaBlocks;
import com.technologica.world.level.block.entity.TechnologicaBlockEntityType;
import com.technologica.world.level.levelgen.feature.TechnologicaFeature;
import com.technologica.world.level.levelgen.feature.foliageplacers.TechnologicaFoliagePlacers;
import com.technologica.world.level.material.TechnologicaFluids;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.crafting.CraftingHelper;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig.Type;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(Technologica.MODID)
public class Technologica {
	public static final String MODID = "technologica";
	public static final Logger LOGGER = LogManager.getLogger();

	public Technologica() {
		ModLoadingContext.get().registerConfig(Type.COMMON, Config.SPEC, "technologica-common.toml");

		TechnologicaBlocks.init();
		TechnologicaFluids.init();
		TechnologicaFluids.init2();
		TechnologicaItems.init();
		TechnologicaSoundEvents.init();
		TechnologicaEntityType.init();
		TechnologicaParticleTypes.init();
		TechnologicaMenuType.init();
		TechnologicaBlockEntityType.init();
		TechnologicaRecipeType.init();
		TechnologicaRecipeSerializer.init();
		TechnologicaFeature.init();
		TechnologicaFoliagePlacers.init();
		TechnologicaLootModifiers.init();
		TechnologicaMobEffects.init();

		// FMLJavaModLoadingContext.get().getModEventBus().addGenericListener(Block.class, RegistrationListener::onRegisterBlocks);
		// FMLJavaModLoadingContext.get().getModEventBus().addGenericListener(Item.class, RegistrationListener::onRegisterItems);
		// FMLJavaModLoadingContext.get().getModEventBus().addGenericListener(BlockEntityType.class, RegistrationListener::onRegisterTileEntities);
		// FMLJavaModLoadingContext.get().getModEventBus().addGenericListener(EntityType.class, RegistrationListener::onRegisterEntities);
		// FMLJavaModLoadingContext.get().getModEventBus().addGenericListener(Fluid.class, RegistrationListener::onRegisterFluids);
		// FMLJavaModLoadingContext.get().getModEventBus().addGenericListener(MenuType.class, RegistrationListener::onRegisterContainers);
		// FMLJavaModLoadingContext.get().getModEventBus().addGenericListener(ParticleType.class, RegistrationListener::onRegisterParticles);
		// FMLJavaModLoadingContext.get().getModEventBus().addGenericListener(RecipeSerializer.class, RegistrationListener::onRegisterRecipeSerializers);
		// FMLJavaModLoadingContext.get().getModEventBus().addGenericListener(SoundEvent.class, RegistrationListener::onRegisterSoundEvents);
		// FMLJavaModLoadingContext.get().getModEventBus().addGenericListener(Biome.class, RegistrationListener::onRegisterBiomes);
		// FMLJavaModLoadingContext.get().getModEventBus().addGenericListener(Feature.class, RegistrationListener::onRegisterFeatures);
		// FMLJavaModLoadingContext.get().getModEventBus().addGenericListener(FoliagePlacerType.class, RegistrationListener::onRegisterFoliagePlacers);

		CraftingHelper.register(DisablePlankConditionFactory.Serializer.INSTANCE);
		CraftingHelper.register(EnablePlankConditionFactory.Serializer.INSTANCE);

		FMLJavaModLoadingContext.get().getModEventBus().addListener(RegisterEntityAttributes::onEntityAttributeCreationEvent); // Called after registration, but before common setup

		FMLJavaModLoadingContext.get().getModEventBus().addListener(CommonSetup::onFMLCommonSetupEvent); // 1st event during mod lifecycle startup
		FMLJavaModLoadingContext.get().getModEventBus().addListener(ClientSetup::onFMLClientSetupEvent); // 2nd event during mod lifecycle startup
		FMLJavaModLoadingContext.get().getModEventBus().addListener(TechnologicaCreativeModeTabs::onRegisterCreativeModeTabs);
		FMLJavaModLoadingContext.get().getModEventBus().addListener(RegisterEntityRenderers::onRegisterEntityRenderers);
		FMLJavaModLoadingContext.get().getModEventBus().addListener(TechnologicaLayerDefinitions::onRegisterLayerDefinitions);
		FMLJavaModLoadingContext.get().getModEventBus().addListener(RegisterModels::onRegisterModelsEvent);
		FMLJavaModLoadingContext.get().getModEventBus().addListener(RegisterParticleProviders::onRegisterParticleProvidersEvent);
		FMLJavaModLoadingContext.get().getModEventBus().addListener(RegisterDimensionSpecialEffects::onRegisterDimensionSpecialEffectsEvent);
		// FMLJavaModLoadingContext.get().getModEventBus().addListener(TextureStitchPre::onTextureStitchPre);

		FMLJavaModLoadingContext.get().getModEventBus().addListener(GatherData::onGatherDataEvent);

		MinecraftForge.EVENT_BUS.register(new BadLuckBananaWhenFishing());
		MinecraftForge.EVENT_BUS.register(new DisableLogDrops());
		MinecraftForge.EVENT_BUS.register(new DropBarkOnLogStrip());
		MinecraftForge.EVENT_BUS.register(new ExtraAirMeter());
		MinecraftForge.EVENT_BUS.register(new LunarLowGrav());
		MinecraftForge.EVENT_BUS.register(new MiningLight());
		MinecraftForge.EVENT_BUS.register(new NitroPocket());
		MinecraftForge.EVENT_BUS.register(new RegisterCapabilities());
		// MinecraftForge.EVENT_BUS.register(new RegisterModels());
		MinecraftForge.EVENT_BUS.register(new ReplaceFarmerBrain());
		MinecraftForge.EVENT_BUS.register(new TechnologicaVillagerTrades());
		MinecraftForge.EVENT_BUS.register(new TechnologicaWanderingTraderTrades());
		MinecraftForge.EVENT_BUS.register(new VanillaEntityModifier());
		MinecraftForge.EVENT_BUS.register(new WaterWalk());
	}
}
