package com.technologica;

import java.util.List;
import java.util.Set;

import javax.annotation.Nullable;

import org.slf4j.Logger;

import com.mojang.logging.LogUtils;
import com.mojang.serialization.Codec;
import com.technologica.capabilities.item.link.Link;
import com.technologica.client.gui.screens.TechnologicaMenuScreens;
import com.technologica.client.model.AdditionalModels;
import com.technologica.client.model.geom.TechnologicaLayerDefinitions;
import com.technologica.client.multiplayer.TechnologicaClientLevel;
import com.technologica.client.particle.TechnologicaParticleProviders;
import com.technologica.client.renderer.BlockColorHandlers;
import com.technologica.client.renderer.TechnologicaDimensionSpecialEffects;
import com.technologica.client.renderer.TechnologicaItemBlockRenderTypes;
import com.technologica.client.renderer.TechnologicaRenderBuffers;
import com.technologica.client.renderer.blockentity.TechnologicaBlockEntityRenderers;
import com.technologica.client.renderer.blockentity.TechnologicaSkullBlockRenderer;
import com.technologica.client.renderer.entity.TechnologicaEntityRenderers;
import com.technologica.config.TechnologicaConfigCommon;
import com.technologica.network.packets.clientbound.SetMeteorStorm;
import com.technologica.network.packets.clientbound.SetMeteorStormLevel;
import com.technologica.network.packets.clientbound.UpdateDiverCapability;
import com.technologica.network.packets.serverbound.UpdateAnnunciator;
import com.technologica.network.packets.serverbound.UpdateMonitor;
import com.technologica.registration.deferred.TechnologicaAttributes;
import com.technologica.registration.deferred.TechnologicaBlockEntityTypes;
import com.technologica.registration.deferred.TechnologicaBlocks;
import com.technologica.registration.deferred.TechnologicaCreativeModeTabs;
import com.technologica.registration.deferred.TechnologicaEntityTypes;
import com.technologica.registration.deferred.TechnologicaFeatures;
import com.technologica.registration.deferred.TechnologicaFluidTypes;
import com.technologica.registration.deferred.TechnologicaFluids;
import com.technologica.registration.deferred.TechnologicaFoliagePlacerTypes;
import com.technologica.registration.deferred.TechnologicaGlobalLootModifierSerializers;
import com.technologica.registration.deferred.TechnologicaItems;
import com.technologica.registration.deferred.TechnologicaMenuTypes;
import com.technologica.registration.deferred.TechnologicaMobEffects;
import com.technologica.registration.deferred.TechnologicaPaintingVariants;
import com.technologica.registration.deferred.TechnologicaParticleTypes;
import com.technologica.registration.deferred.TechnologicaPlacementModifierTypes;
import com.technologica.registration.deferred.TechnologicaPoiTypes;
import com.technologica.registration.deferred.TechnologicaPoisonDartFrogVariant;
import com.technologica.registration.deferred.TechnologicaRecipeSerializers;
import com.technologica.registration.deferred.TechnologicaRecipeTypes;
import com.technologica.registration.deferred.TechnologicaSoundEvents;
import com.technologica.registration.deferred.TechnologicaStructurePieceTypes;
import com.technologica.registration.deferred.TechnologicaStructureTypes;
import com.technologica.registration.deferred.TechnologicaTrunkPlacerTypes;
import com.technologica.registration.dynamic.TechnologicaBiomeModifiers;
import com.technologica.registration.dynamic.TechnologicaBiomes;
import com.technologica.registration.dynamic.TechnologicaConfiguredFeatures;
import com.technologica.registration.dynamic.TechnologicaDamageTypes;
import com.technologica.registration.dynamic.TechnologicaDensityFunctions;
import com.technologica.registration.dynamic.TechnologicaDimensionTypes;
import com.technologica.registration.dynamic.TechnologicaDimensions;
import com.technologica.registration.dynamic.TechnologicaNoise;
import com.technologica.registration.dynamic.TechnologicaNoiseGeneratorSettings;
import com.technologica.registration.dynamic.TechnologicaPaintingVariantsDyn;
import com.technologica.registration.dynamic.TechnologicaPlacedFeatures;
import com.technologica.registration.dynamic.TechnologicaStructureSets;
import com.technologica.registration.dynamic.TechnologicaStructureTemplatePools;
import com.technologica.registration.dynamic.TechnologicaStructures;
import com.technologica.resourcegen.assets.TLAtlases;
import com.technologica.resourcegen.assets.TLBlockstates;
import com.technologica.resourcegen.assets.TLFont;
import com.technologica.resourcegen.assets.TLLang;
import com.technologica.resourcegen.assets.TLModelsBlock;
import com.technologica.resourcegen.assets.TLModelsItem;
import com.technologica.resourcegen.assets.TLParticles;
import com.technologica.resourcegen.assets.TLShadersPost;
import com.technologica.resourcegen.assets.TLSounds;
import com.technologica.resourcegen.data.advancements.TLRGAdvancementGenerator;
import com.technologica.resourcegen.data.lootmodifiers.TLLootModifiersGenerator;
import com.technologica.resourcegen.data.loottables.blocks.TLLootTablesBlocksGenerator;
import com.technologica.resourcegen.data.loottables.entities.EntityLootDataGenerator;
import com.technologica.resourcegen.data.recipes.TLRecipesGenerator;
import com.technologica.resourcegen.data.tags.blocks.TLTagBlocksGenerator;
import com.technologica.resourcegen.data.tags.entity.TLTagEntityTypeGenerator;
import com.technologica.resourcegen.data.tags.fluids.TLTagsFluidsGenerator;
import com.technologica.resourcegen.data.tags.items.TLTagItemsGenerator;
import com.technologica.resourcegen.data.tags.paintingvariant.TLTagsPaintingVariantGenerator;
import com.technologica.resourcegen.data.tags.worldgen.biome.TLTagWorldgenBiomeGenerator;
import com.technologica.server.commands.TechnologicaCommands;
import com.technologica.server.level.TechnologicaServerLevel;
import com.technologica.util.BooleanConfigValueCondition;
import com.technologica.util.text.TechnologicaLocation;
import com.technologica.world.entity.TechnologicaSpawnPlacements;
import com.technologica.world.entity.ai.attributes.TechnologicaDefaultAttributes;
import com.technologica.world.entity.ai.attributes.TechnologicaVillageTrades;
import com.technologica.world.entity.ai.attributes.TechnologicaVillagerWantedItems;
import com.technologica.world.entity.ai.attributes.TechnologicaWanderingTraderTrades;
import com.technologica.world.entity.player.TechnologicaAbilities;
import com.technologica.world.level.block.state.properties.TechnologicaCompostables;
import com.technologica.world.level.block.state.properties.TechnologicaFlowerPotPlants;
import com.tlregen.api.registration.DynamicRegister;
import com.tlregen.api.registration.MasterDeferredRegistrar;
import com.tlregen.api.registration.MasterDynamicRegistrar;
import com.tlregen.api.resourcegen.MasterResourceGenerator;
import com.tlregen.api.resourcegen.data.TLRGLootTablesGenerator;
import com.tlregen.api.setup.MasterSetupExecutor;

import net.minecraft.core.particles.ParticleType;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.loot.LootTableProvider;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.damagesource.DamageType;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.village.poi.PoiType;
import net.minecraft.world.entity.animal.FrogVariant;
import net.minecraft.world.entity.decoration.PaintingVariant;
import net.minecraft.world.inventory.MenuType;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.dimension.DimensionType;
import net.minecraft.world.level.dimension.LevelStem;
import net.minecraft.world.level.levelgen.DensityFunction;
import net.minecraft.world.level.levelgen.NoiseGeneratorSettings;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.foliageplacers.FoliagePlacerType;
import net.minecraft.world.level.levelgen.feature.trunkplacers.TrunkPlacerType;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraft.world.level.levelgen.placement.PlacementModifierType;
import net.minecraft.world.level.levelgen.structure.Structure;
import net.minecraft.world.level.levelgen.structure.StructureSet;
import net.minecraft.world.level.levelgen.structure.StructureType;
import net.minecraft.world.level.levelgen.structure.pieces.StructurePieceType;
import net.minecraft.world.level.levelgen.structure.pools.StructureTemplatePool;
import net.minecraft.world.level.levelgen.synth.NormalNoise.NoiseParameters;
import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;
import net.minecraftforge.common.loot.IGlobalLootModifier;
import net.minecraftforge.common.world.BiomeModifier;
import net.minecraftforge.fluids.FluidType;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig.Type;
import net.minecraftforge.fml.loading.FMLEnvironment;
import net.minecraftforge.network.NetworkRegistry;
import net.minecraftforge.network.simple.SimpleChannel;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

@Mod(Technologica.MOD_ID)
public class Technologica {
	public static Technologica instance;
	public static final String MOD_ID = "technologica";
	public static final Logger LOGGER = LogUtils.getLogger();

	private static final MasterDeferredRegistrar MASTER_DEFERRED_REGISTRAR = new MasterDeferredRegistrar(MOD_ID);
	private static final MasterDynamicRegistrar MASTER_DYNAMIC_REGISTRAR = new MasterDynamicRegistrar(MOD_ID);
	private static final MasterSetupExecutor MASTER_SETUP_EXECUTOR = new MasterSetupExecutor(MOD_ID);
	private static final MasterResourceGenerator MASTER_RESOURCE_GENERATOR = new MasterResourceGenerator(MOD_ID);

	public static final DeferredRegister<Attribute> ATTRIBUTES = MASTER_DEFERRED_REGISTRAR.addRegister(ForgeRegistries.Keys.ATTRIBUTES, TechnologicaAttributes.class);
	public static final DeferredRegister<Block> BLOCKS = MASTER_DEFERRED_REGISTRAR.addRegister(ForgeRegistries.Keys.BLOCKS, TechnologicaBlocks.class);
	public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITY_TYPES = MASTER_DEFERRED_REGISTRAR.addRegister(ForgeRegistries.Keys.BLOCK_ENTITY_TYPES, TechnologicaBlockEntityTypes.class);
	public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS = MASTER_DEFERRED_REGISTRAR.addRegister(Registries.CREATIVE_MODE_TAB, TechnologicaCreativeModeTabs.class);
	public static final DeferredRegister<EntityType<?>> ENTITY_TYPES = MASTER_DEFERRED_REGISTRAR.addRegister(ForgeRegistries.Keys.ENTITY_TYPES, TechnologicaEntityTypes.class);
	public static final DeferredRegister<Feature<?>> FEATURES = MASTER_DEFERRED_REGISTRAR.addRegister(ForgeRegistries.Keys.FEATURES, TechnologicaFeatures.class);
	public static final DeferredRegister<Fluid> FLUIDS = MASTER_DEFERRED_REGISTRAR.addRegister(ForgeRegistries.Keys.FLUIDS, TechnologicaFluids.class);
	public static final DeferredRegister<FluidType> FLUID_TYPES = MASTER_DEFERRED_REGISTRAR.addRegister(ForgeRegistries.Keys.FLUID_TYPES, TechnologicaFluidTypes.class);
	public static final DeferredRegister<FoliagePlacerType<?>> FOLIAGE_PLACER_TYPES = MASTER_DEFERRED_REGISTRAR.addRegister(ForgeRegistries.Keys.FOLIAGE_PLACER_TYPES, TechnologicaFoliagePlacerTypes.class);
	public static final DeferredRegister<Codec<? extends IGlobalLootModifier>> GLOBAL_LOOT_MODIFIER_SERIALIZERS = MASTER_DEFERRED_REGISTRAR.addRegister(ForgeRegistries.Keys.GLOBAL_LOOT_MODIFIER_SERIALIZERS, TechnologicaGlobalLootModifierSerializers.class);
	public static final DeferredRegister<Item> ITEMS = MASTER_DEFERRED_REGISTRAR.addRegister(ForgeRegistries.Keys.ITEMS, TechnologicaItems.class);
	public static final DeferredRegister<MenuType<?>> MENU_TYPES = MASTER_DEFERRED_REGISTRAR.addRegister(ForgeRegistries.Keys.MENU_TYPES, TechnologicaMenuTypes.class);
	public static final DeferredRegister<MobEffect> MOB_EFFECTS = MASTER_DEFERRED_REGISTRAR.addRegister(ForgeRegistries.Keys.MOB_EFFECTS, TechnologicaMobEffects.class);
	public static final DeferredRegister<PaintingVariant> PAINTING_VARIANTS = MASTER_DEFERRED_REGISTRAR.addRegister(ForgeRegistries.Keys.PAINTING_VARIANTS, TechnologicaPaintingVariants.class);
	public static final DeferredRegister<ParticleType<?>> PARTICLE_TYPES = MASTER_DEFERRED_REGISTRAR.addRegister(ForgeRegistries.Keys.PARTICLE_TYPES, TechnologicaParticleTypes.class);
	public static final DeferredRegister<PlacementModifierType<?>> PLACEMENT_MODIFIER_TYPES = MASTER_DEFERRED_REGISTRAR.addRegister(Registries.PLACEMENT_MODIFIER_TYPE, TechnologicaPlacementModifierTypes.class);
	public static final DeferredRegister<PoiType> POI_TYPES = MASTER_DEFERRED_REGISTRAR.addRegister(ForgeRegistries.Keys.POI_TYPES, TechnologicaPoiTypes.class);
	public static final DeferredRegister<FrogVariant> POSION_DART_FROG_VARIANTS = MASTER_DEFERRED_REGISTRAR.addRegister(Registries.FROG_VARIANT, TechnologicaPoisonDartFrogVariant.class);
	public static final DeferredRegister<RecipeSerializer<?>> RECIPE_SERIALIZERS = MASTER_DEFERRED_REGISTRAR.addRegister(ForgeRegistries.Keys.RECIPE_SERIALIZERS, TechnologicaRecipeSerializers.class);
	public static final DeferredRegister<RecipeType<?>> RECIPE_TYPES = MASTER_DEFERRED_REGISTRAR.addRegister(ForgeRegistries.Keys.RECIPE_TYPES, TechnologicaRecipeTypes.class);
	public static final DeferredRegister<SoundEvent> SOUND_EVENTS = MASTER_DEFERRED_REGISTRAR.addRegister(ForgeRegistries.Keys.SOUND_EVENTS, TechnologicaSoundEvents.class);
	public static final DeferredRegister<StructureType<?>> STRUCTURE_TYPES = MASTER_DEFERRED_REGISTRAR.addRegister(Registries.STRUCTURE_TYPE, TechnologicaStructureTypes.class);
	public static final DeferredRegister<StructurePieceType> STRUCTURE_PIECE_TYPES = MASTER_DEFERRED_REGISTRAR.addRegister(Registries.STRUCTURE_PIECE, TechnologicaStructurePieceTypes.class);
	public static final DeferredRegister<TrunkPlacerType<?>> TRUNK_PLACER_TYPES = MASTER_DEFERRED_REGISTRAR.addRegister(Registries.TRUNK_PLACER_TYPE, TechnologicaTrunkPlacerTypes.class);

	public static final DynamicRegister<Biome> BIOMES = MASTER_DYNAMIC_REGISTRAR.addRegister(ForgeRegistries.Keys.BIOMES, TechnologicaBiomes.class);
	public static final DynamicRegister<BiomeModifier> BIOME_MODIFIERS = MASTER_DYNAMIC_REGISTRAR.addRegister(ForgeRegistries.Keys.BIOME_MODIFIERS, TechnologicaBiomeModifiers.class);
	public static final DynamicRegister<ConfiguredFeature<?, ?>> CONFIGURED_FEATURES = MASTER_DYNAMIC_REGISTRAR.addRegister(Registries.CONFIGURED_FEATURE, TechnologicaConfiguredFeatures.class);
	public static final DynamicRegister<DamageType> DAMAGE_TYPES = MASTER_DYNAMIC_REGISTRAR.addRegister(Registries.DAMAGE_TYPE, TechnologicaDamageTypes.class);
	public static final DynamicRegister<DensityFunction> DENSITY_FUNCTIONS = MASTER_DYNAMIC_REGISTRAR.addRegister(Registries.DENSITY_FUNCTION, TechnologicaDensityFunctions.class);
	public static final DynamicRegister<DimensionType> DIMENSION_TYPES = MASTER_DYNAMIC_REGISTRAR.addRegister(Registries.DIMENSION_TYPE, TechnologicaDimensionTypes.class);
	public static final DynamicRegister<LevelStem> DIMENSIONS = MASTER_DYNAMIC_REGISTRAR.addRegister(Registries.LEVEL_STEM, TechnologicaDimensions.class);
	public static final DynamicRegister<NoiseParameters> NOISE = MASTER_DYNAMIC_REGISTRAR.addRegister(Registries.NOISE, TechnologicaNoise.class);
	public static final DynamicRegister<NoiseGeneratorSettings> NOISE_GENERATOR_SETTINGS = MASTER_DYNAMIC_REGISTRAR.addRegister(Registries.NOISE_SETTINGS, TechnologicaNoiseGeneratorSettings.class);
	public static final DynamicRegister<PaintingVariant> PAINTING_VARIANTS_DYN = MASTER_DYNAMIC_REGISTRAR.addRegister(Registries.PAINTING_VARIANT, TechnologicaPaintingVariantsDyn.class);
	public static final DynamicRegister<PlacedFeature> PLACED_FEATURES = MASTER_DYNAMIC_REGISTRAR.addRegister(Registries.PLACED_FEATURE, TechnologicaPlacedFeatures.class);
	public static final DynamicRegister<Structure> STRUCTURES = MASTER_DYNAMIC_REGISTRAR.addRegister(Registries.STRUCTURE, TechnologicaStructures.class);
	public static final DynamicRegister<StructureSet> STRUCTURE_SETS = MASTER_DYNAMIC_REGISTRAR.addRegister(Registries.STRUCTURE_SET, TechnologicaStructureSets.class);
	public static final DynamicRegister<StructureTemplatePool> STRUCTURE_TEMPLATE_POOL = MASTER_DYNAMIC_REGISTRAR.addRegister(Registries.TEMPLATE_POOL, TechnologicaStructureTemplatePools.class);

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
		ModLoadingContext.get().registerConfig(Type.COMMON, TechnologicaConfigCommon.COMMON_SPEC, "technologica-common.toml");

		CHANNEL.registerMessage(PACKET_ID++, UpdateAnnunciator.class, UpdateAnnunciator::encode, UpdateAnnunciator::decode, UpdateAnnunciator::handle);
		CHANNEL.registerMessage(PACKET_ID++, UpdateDiverCapability.class, UpdateDiverCapability::encode, UpdateDiverCapability::decode, UpdateDiverCapability::handle);
		CHANNEL.registerMessage(PACKET_ID++, UpdateMonitor.class, UpdateMonitor::encode, UpdateMonitor::decode, UpdateMonitor::handle);
		CHANNEL.registerMessage(PACKET_ID++, SetMeteorStorm.class, SetMeteorStorm::encode, SetMeteorStorm::decode, SetMeteorStorm::handle);
		CHANNEL.registerMessage(PACKET_ID++, SetMeteorStormLevel.class, SetMeteorStormLevel::encode, SetMeteorStormLevel::decode, SetMeteorStormLevel::handle);

		MASTER_SETUP_EXECUTOR.addEntityAttributes(() -> TechnologicaDefaultAttributes.DEFAULT_ATTRIBUTES);
		MASTER_SETUP_EXECUTOR.addCapabilities(List.of(TechnologicaAbilities.class, Link.class));
		MASTER_SETUP_EXECUTOR.addCommands(() -> TechnologicaCommands.COMMANDS);
		MASTER_SETUP_EXECUTOR.addToCompostables(() -> TechnologicaCompostables.COMPOSTABLES);
		MASTER_SETUP_EXECUTOR.addToFlowerPot(() -> TechnologicaFlowerPotPlants.PLANTS);
		MASTER_SETUP_EXECUTOR.addToVillageButcherTrades(() -> TechnologicaVillageTrades.TRADES_BUTCHER);
		MASTER_SETUP_EXECUTOR.addToVillageFarmerTrades(() -> TechnologicaVillageTrades.TRADES_FARMER);
		MASTER_SETUP_EXECUTOR.addToVillagerWantedItems(() -> TechnologicaVillagerWantedItems.WANTED_ITEMS);
		MASTER_SETUP_EXECUTOR.addToWanderingTraderGenericTrades(() -> TechnologicaWanderingTraderTrades.WANDERING_TRADER_TRADES_GENERIC);
		MASTER_SETUP_EXECUTOR.addSkullModels(() -> TechnologicaSkullBlockRenderer.SKULL_RENDERERS);
		MASTER_SETUP_EXECUTOR.addLayerDefinitions(() -> TechnologicaLayerDefinitions.ROOTS);
		MASTER_SETUP_EXECUTOR.registerEntityRenderers(() -> TechnologicaEntityRenderers.PROVIDERS);
		MASTER_SETUP_EXECUTOR.registerBlockEntityRenderers(() -> TechnologicaBlockEntityRenderers.PROVIDERS);
		MASTER_SETUP_EXECUTOR.registerAdditionalModels(() -> AdditionalModels.MODELS);
		MASTER_SETUP_EXECUTOR.registerColorHandlersBlock(() -> BlockColorHandlers.HANDLERS);
		MASTER_SETUP_EXECUTOR.registerDimensionSpecialEffects(() -> TechnologicaDimensionSpecialEffects.DIMENSION_SPECIAL_EFFECTS);
		MASTER_SETUP_EXECUTOR.registerParticleProvidersSprites(() -> TechnologicaParticleProviders.SPRITES);
		MASTER_SETUP_EXECUTOR.registerParticleProvidersSpriteSets(() -> TechnologicaParticleProviders.SPRITE_SETS);
		MASTER_SETUP_EXECUTOR.registerScreens(() -> TechnologicaMenuScreens.SCREENS);
		MASTER_SETUP_EXECUTOR.registerSkullTextures(() -> TechnologicaSkullBlockRenderer.SKIN_BY_TYPE);
		MASTER_SETUP_EXECUTOR.setFluidRenderTypes(() -> TechnologicaItemBlockRenderTypes.TYPE_BY_FLUID);
		MASTER_SETUP_EXECUTOR.addRenderTypes(() -> TechnologicaRenderBuffers.FIXED_BUFFERS);
		MASTER_SETUP_EXECUTOR.registerSpawnPlacements(() -> TechnologicaSpawnPlacements.SPAWN_PLACEMENTS);
		MASTER_SETUP_EXECUTOR.addConditionSerializers(() -> Set.of(BooleanConfigValueCondition.Serializer.INSTANCE));

		MASTER_RESOURCE_GENERATOR.addAtlases(() -> TLAtlases.ATLASES);
		MASTER_RESOURCE_GENERATOR.addBlockStates(() -> TLBlockstates.BLOCKSTATES);
		MASTER_RESOURCE_GENERATOR.addFonts(() -> TLFont.FONTS);
		MASTER_RESOURCE_GENERATOR.addLang(() -> TLLang.LANG);
		MASTER_RESOURCE_GENERATOR.addBlockModels(() -> TLModelsBlock.MODELS_BLOCK);
		MASTER_RESOURCE_GENERATOR.addItemModels(() -> TLModelsItem.MODELS_ITEM);
		MASTER_RESOURCE_GENERATOR.addParticles(() -> TLParticles.PARTICLES);
		MASTER_RESOURCE_GENERATOR.addPostShaders(() -> TLShadersPost.SHADERS_POST);
		MASTER_RESOURCE_GENERATOR.addSounds(() -> TLSounds.SOUNDS);

		MASTER_RESOURCE_GENERATOR.addDataProvider(() -> new TLRGAdvancementGenerator());
		MASTER_RESOURCE_GENERATOR.addDamageTypes(() -> DAMAGE_TYPES);
		MASTER_RESOURCE_GENERATOR.addDimensions(() -> DIMENSIONS);
		MASTER_RESOURCE_GENERATOR.addDimensionTypes(() -> DIMENSION_TYPES);
		MASTER_RESOURCE_GENERATOR.addBiomeModifiers(() -> BIOME_MODIFIERS);
		MASTER_RESOURCE_GENERATOR.addDataProvider(() -> new TLLootModifiersGenerator());
		MASTER_RESOURCE_GENERATOR.addDataProvider(() -> new TLRGLootTablesGenerator(List.of(new LootTableProvider.SubProviderEntry(TLLootTablesBlocksGenerator::new, LootContextParamSets.BLOCK), new LootTableProvider.SubProviderEntry(EntityLootDataGenerator::new, LootContextParamSets.ENTITY))));
		MASTER_RESOURCE_GENERATOR.addDataProvider(() -> new TLRecipesGenerator());
		MASTER_RESOURCE_GENERATOR.addDataProvider(() -> new TLTagBlocksGenerator());
		MASTER_RESOURCE_GENERATOR.addDataProvider(() -> new TLTagEntityTypeGenerator());
		MASTER_RESOURCE_GENERATOR.addDataProvider(() -> new TLTagsFluidsGenerator());
		MASTER_RESOURCE_GENERATOR.addDataProvider(() -> new TLTagItemsGenerator());
		MASTER_RESOURCE_GENERATOR.addDataProvider(() -> new TLTagsPaintingVariantGenerator());
		MASTER_RESOURCE_GENERATOR.addDataProvider(() -> new TLTagWorldgenBiomeGenerator());
		MASTER_RESOURCE_GENERATOR.addBiomes(() -> BIOMES);
		MASTER_RESOURCE_GENERATOR.addConfiguredFeatures(() -> CONFIGURED_FEATURES);
		MASTER_RESOURCE_GENERATOR.addDensityFunctions(() -> DENSITY_FUNCTIONS);
		MASTER_RESOURCE_GENERATOR.addNoiseParameters(() -> NOISE);
		MASTER_RESOURCE_GENERATOR.addNoiseGeneratorSettings(() -> NOISE_GENERATOR_SETTINGS);
		MASTER_RESOURCE_GENERATOR.addPlacedFeatures(() -> PLACED_FEATURES);
		MASTER_RESOURCE_GENERATOR.addStructures(() -> STRUCTURES);
		MASTER_RESOURCE_GENERATOR.addStructureSets(() -> STRUCTURE_SETS);
		MASTER_RESOURCE_GENERATOR.addStructureTemplatePools(() -> STRUCTURE_TEMPLATE_POOL);
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
