package com.technologica;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.technologica.client.model.geom.TechnologicaLayerDefinitions;
import com.technologica.core.particles.TechnologicaParticleTypes;
import com.technologica.listeners.forgebus.EntityJoinLevelEventListener;
import com.technologica.listeners.forgebus.HarvestCheckListener;
import com.technologica.listeners.forgebus.ItemFishedEventListener;
import com.technologica.listeners.forgebus.LivingAttackEventListener;
import com.technologica.listeners.forgebus.LivingEquipmentChangeEventListener;
import com.technologica.listeners.forgebus.LivingFallEventListener;
import com.technologica.listeners.forgebus.LivingHealEventListener;
import com.technologica.listeners.forgebus.LivingJumpEventListener;
import com.technologica.listeners.forgebus.MovementInputUpdateEventListener;
import com.technologica.listeners.forgebus.PlayerTickEventListener;
import com.technologica.listeners.forgebus.RegisterCapabilitiesEventListener;
import com.technologica.listeners.forgebus.RenderGuiOverlayEventListener;
import com.technologica.listeners.forgebus.RightClickBlockListener;
import com.technologica.listeners.forgebus.VillagerTradesEventListener;
import com.technologica.listeners.forgebus.WandererTradesEventListener;
import com.technologica.listeners.lootmodifiers.TechnologicaLootModifiers;
import com.technologica.listeners.modbus.ClientSetup;
import com.technologica.listeners.modbus.CommonSetup;
import com.technologica.listeners.modbus.GatherData;
import com.technologica.listeners.modbus.RegisterColorHandlers;
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
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig.Type;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(Technologica.MODID)
public class Technologica {
	public static final String MODID = "technologica";
	public static final Logger LOGGER = LogManager.getLogger();
	private static final IEventBus MOD_EVENT_BUS = FMLJavaModLoadingContext.get().getModEventBus();

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

		addModEventBusListeners();
		addForgeEventBusListeners();
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

	}

	private void addModEventBusListeners() {
		MOD_EVENT_BUS.addListener(RegisterEntityAttributes::onEntityAttributeCreationEvent);
		MOD_EVENT_BUS.addListener(TechnologicaCreativeModeTabs::onRegisterCreativeModeTabs);
		MOD_EVENT_BUS.addListener(RegisterColorHandlers::onRegisterColorHandlersBlock);
		MOD_EVENT_BUS.addListener(RegisterParticleProviders::onRegisterParticleProvidersEvent);
		MOD_EVENT_BUS.addListener(TechnologicaLayerDefinitions::onRegisterLayerDefinitions);
		MOD_EVENT_BUS.addListener(RegisterEntityRenderers::onRegisterRenderers);
		MOD_EVENT_BUS.addListener(RegisterDimensionSpecialEffects::onRegisterDimensionSpecialEffectsEvent);
		MOD_EVENT_BUS.addListener(CommonSetup::onFMLCommonSetupEvent);
		MOD_EVENT_BUS.addListener(ClientSetup::onFMLClientSetupEvent);
		MOD_EVENT_BUS.addListener(RegisterModels::onRegisterAdditional);

		MOD_EVENT_BUS.addListener(GatherData::onGatherDataEvent);
	}

	private void addForgeEventBusListeners() {
		MinecraftForge.EVENT_BUS.register(new EntityJoinLevelEventListener());
		MinecraftForge.EVENT_BUS.register(new HarvestCheckListener());
		MinecraftForge.EVENT_BUS.register(new ItemFishedEventListener());
		MinecraftForge.EVENT_BUS.register(new LivingAttackEventListener());
		MinecraftForge.EVENT_BUS.register(new LivingEquipmentChangeEventListener());
		MinecraftForge.EVENT_BUS.register(new LivingFallEventListener());
		MinecraftForge.EVENT_BUS.register(new LivingHealEventListener());
		MinecraftForge.EVENT_BUS.register(new LivingJumpEventListener());
		MinecraftForge.EVENT_BUS.register(new MovementInputUpdateEventListener());
		MinecraftForge.EVENT_BUS.register(new PlayerTickEventListener());
		MinecraftForge.EVENT_BUS.register(new RegisterCapabilitiesEventListener());
		MinecraftForge.EVENT_BUS.register(new RenderGuiOverlayEventListener());
		MinecraftForge.EVENT_BUS.register(new RightClickBlockListener());
		MinecraftForge.EVENT_BUS.register(new VillagerTradesEventListener());
		MinecraftForge.EVENT_BUS.register(new WandererTradesEventListener());
	}
}
