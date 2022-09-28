package com.technologica;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.technologica.capabilities.TechnologicaCapabilities;
import com.technologica.core.particles.TechnologicaParticleTypes;
import com.technologica.data.GatherData;
import com.technologica.listeners.BadLuckBananaWhenFishing;
import com.technologica.listeners.DisableLogDrops;
import com.technologica.listeners.DropBarkOnLogStrip;
import com.technologica.listeners.ExtraAirMeter;
import com.technologica.listeners.LunarLowGrav;
import com.technologica.listeners.NitroPocket;
import com.technologica.listeners.RegisterEntityAttributes;
import com.technologica.listeners.RegisterEntityRenderers;
import com.technologica.listeners.RegisterFarmerBrain;
import com.technologica.listeners.RegisterLayerDefinitons;
import com.technologica.listeners.TechnologicaDimensionSpecialEffects;
import com.technologica.listeners.TechnologicaVillagerTrades;
import com.technologica.listeners.TechnologicaWanderingTraderTrades;
import com.technologica.listeners.WaterWalk;
import com.technologica.listeners.lootmodifiers.LootModifierListener;
import com.technologica.setup.ClientSetup;
import com.technologica.setup.CommonSetup;
import com.technologica.setup.Config;
import com.technologica.setup.ParticleSetup;
import com.technologica.setup.VanillaEntityModifier;
import com.technologica.util.DisablePlankConditionFactory;
import com.technologica.util.EnablePlankConditionFactory;
import com.technologica.util.TechnologicaSoundEvents;
import com.technologica.world.entity.TechnologicaEntityType;
import com.technologica.world.inventory.TechnologicaContainerType;
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
import net.minecraftforge.eventbus.api.EventPriority;
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
		TechnologicaContainerType.init();
		TechnologicaBlockEntityType.init();
		TechnologicaRecipeType.init();
		TechnologicaRecipeSerializer.init();
		TechnologicaFeature.init();
		TechnologicaFoliagePlacers.init();
		LootModifierListener.init();

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

		FMLJavaModLoadingContext.get().getModEventBus().addListener(CommonSetup::init); // 1st event during mod lifecycle startup
		FMLJavaModLoadingContext.get().getModEventBus().addListener(ClientSetup::init); // 2nd event during mod lifecycle startup
		FMLJavaModLoadingContext.get().getModEventBus().addListener(GatherData::init);
		FMLJavaModLoadingContext.get().getModEventBus().addListener(ClientSetup::stitch);
		FMLJavaModLoadingContext.get().getModEventBus().addListener(ParticleSetup::init);
		FMLJavaModLoadingContext.get().getModEventBus().addListener(RegisterEntityAttributes::onEntityAttributeCreationEvent);
		FMLJavaModLoadingContext.get().getModEventBus().addListener(RegisterEntityRenderers::onRegisterEntityRenderers);
		FMLJavaModLoadingContext.get().getModEventBus().addListener(RegisterLayerDefinitons::onRegisterLayerDefinitions);
		FMLJavaModLoadingContext.get().getModEventBus().addListener(TechnologicaDimensionSpecialEffects::onRegisterDimensionSpecialEffectsEvent);

		MinecraftForge.EVENT_BUS.addListener(EventPriority.HIGH, VanillaEntityModifier::init);

		MinecraftForge.EVENT_BUS.register(new BadLuckBananaWhenFishing());
		MinecraftForge.EVENT_BUS.register(new LunarLowGrav());
		MinecraftForge.EVENT_BUS.register(new DropBarkOnLogStrip());
		MinecraftForge.EVENT_BUS.register(new DisableLogDrops());
		MinecraftForge.EVENT_BUS.register(new ExtraAirMeter());
		MinecraftForge.EVENT_BUS.register(new RegisterFarmerBrain());
		MinecraftForge.EVENT_BUS.register(new WaterWalk());
		MinecraftForge.EVENT_BUS.register(new NitroPocket());
		MinecraftForge.EVENT_BUS.register(new TechnologicaVillagerTrades());
		MinecraftForge.EVENT_BUS.register(new TechnologicaWanderingTraderTrades());

		MinecraftForge.EVENT_BUS.register(new TechnologicaCapabilities());
	}
}
