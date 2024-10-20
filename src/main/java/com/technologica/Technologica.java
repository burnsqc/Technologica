package com.technologica;

import java.util.List;

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
import com.technologica.server.commands.TechnologicaCommands;
import com.technologica.server.level.TechnologicaServerLevel;
import com.technologica.setup.common.TechnologicaConfigCommon;
import com.technologica.util.DisablePlankConditionFactory;
import com.technologica.util.EnablePlankConditionFactory;
import com.technologica.util.text.TechnologicaLocation;
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
import com.tlregen.api.setup.MasterSetupExecutor;

import net.minecraft.core.particles.ParticleType;
import net.minecraft.core.registries.Registries;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.damagesource.DamageType;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.ai.attributes.Attribute;
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
import net.minecraftforge.common.crafting.CraftingHelper;
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

	public static final DeferredRegister<Attribute> ATTRIBUTES = MASTER_DEFERRED_REGISTRAR.addRegister(ForgeRegistries.Keys.ATTRIBUTES, () -> TechnologicaAttributes.DIVER);
	public static final DeferredRegister<Block> BLOCKS = MASTER_DEFERRED_REGISTRAR.addRegister(ForgeRegistries.Keys.BLOCKS, () -> TechnologicaBlocks.ACACIA_BOOKSHELF);
	public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITY_TYPES = MASTER_DEFERRED_REGISTRAR.addRegister(ForgeRegistries.Keys.BLOCK_ENTITY_TYPES, () -> TechnologicaBlockEntityTypes.ANNUNCIATOR_TILE);
	public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS = MASTER_DEFERRED_REGISTRAR.addRegister(Registries.CREATIVE_MODE_TAB, () -> TechnologicaCreativeModeTabs.ARMORY);
	public static final DeferredRegister<EntityType<?>> ENTITY_TYPES = MASTER_DEFERRED_REGISTRAR.addRegister(ForgeRegistries.Keys.ENTITY_TYPES, () -> TechnologicaEntityTypes.ALLIGATOR);
	public static final DeferredRegister<Feature<?>> FEATURES = MASTER_DEFERRED_REGISTRAR.addRegister(ForgeRegistries.Keys.FEATURES, () -> TechnologicaFeatures.AQUAMARINE_DECORATED_ORE);
	public static final DeferredRegister<Fluid> FLUIDS = MASTER_DEFERRED_REGISTRAR.addRegister(ForgeRegistries.Keys.FLUIDS, () -> TechnologicaFluids.ARGON);
	public static final DeferredRegister<FluidType> FLUID_TYPES = MASTER_DEFERRED_REGISTRAR.addRegister(ForgeRegistries.Keys.FLUID_TYPES, () -> TechnologicaFluidTypes.ARGON_TYPE);
	public static final DeferredRegister<FoliagePlacerType<?>> FOLIAGE_PLACER_TYPES = MASTER_DEFERRED_REGISTRAR.addRegister(ForgeRegistries.Keys.FOLIAGE_PLACER_TYPES, () -> TechnologicaFoliagePlacerTypes.CONICAL);
	public static final DeferredRegister<Codec<? extends IGlobalLootModifier>> GLOBAL_LOOT_MODIFIER_SERIALIZERS = MASTER_DEFERRED_REGISTRAR.addRegister(ForgeRegistries.Keys.GLOBAL_LOOT_MODIFIER_SERIALIZERS, () -> TechnologicaGlobalLootModifierSerializers.FERN_LOOT_MODIFIER);
	public static final DeferredRegister<Item> ITEMS = MASTER_DEFERRED_REGISTRAR.addRegister(ForgeRegistries.Keys.ITEMS, () -> TechnologicaItems.ACACIA_BOOKSHELF_ITEM);
	public static final DeferredRegister<MenuType<?>> MENU_TYPES = MASTER_DEFERRED_REGISTRAR.addRegister(ForgeRegistries.Keys.MENU_TYPES, () -> TechnologicaMenuTypes.ANNUNCIATOR);
	public static final DeferredRegister<MobEffect> MOB_EFFECTS = MASTER_DEFERRED_REGISTRAR.addRegister(ForgeRegistries.Keys.MOB_EFFECTS, () -> TechnologicaMobEffects.HALLUCINIATION);
	public static final DeferredRegister<PaintingVariant> PAINTING_VARIANTS = MASTER_DEFERRED_REGISTRAR.addRegister(ForgeRegistries.Keys.PAINTING_VARIANTS, () -> TechnologicaPaintingVariants.AMNESIA);
	public static final DeferredRegister<ParticleType<?>> PARTICLE_TYPES = MASTER_DEFERRED_REGISTRAR.addRegister(ForgeRegistries.Keys.PARTICLE_TYPES, () -> TechnologicaParticleTypes.DRIPPING_BRINE);
	public static final DeferredRegister<PlacementModifierType<?>> PLACEMENT_MODIFIER_TYPES = MASTER_DEFERRED_REGISTRAR.addRegister(Registries.PLACEMENT_MODIFIER_TYPE, () -> TechnologicaPlacementModifierTypes.BOUNDED_HEIGHTMAP);
	public static final DeferredRegister<FrogVariant> POSION_DART_FROG_VARIANTS = MASTER_DEFERRED_REGISTRAR.addRegister(Registries.FROG_VARIANT, () -> TechnologicaPoisonDartFrogVariant.BLUE);
	public static final DeferredRegister<RecipeSerializer<?>> RECIPE_SERIALIZERS = MASTER_DEFERRED_REGISTRAR.addRegister(ForgeRegistries.Keys.RECIPE_SERIALIZERS, () -> TechnologicaRecipeSerializers.SAWMILL);
	public static final DeferredRegister<RecipeType<?>> RECIPE_TYPES = MASTER_DEFERRED_REGISTRAR.addRegister(ForgeRegistries.Keys.RECIPE_TYPES, () -> TechnologicaRecipeTypes.SAWMILL);
	public static final DeferredRegister<SoundEvent> SOUND_EVENTS = MASTER_DEFERRED_REGISTRAR.addRegister(ForgeRegistries.Keys.SOUND_EVENTS, () -> TechnologicaSoundEvents.BUFFALO_AMBIENT);
	public static final DeferredRegister<StructureType<?>> STRUCTURE_TYPES = MASTER_DEFERRED_REGISTRAR.addRegister(Registries.STRUCTURE_TYPE, () -> TechnologicaStructureTypes.DEEP_SEA);
	public static final DeferredRegister<StructurePieceType> STRUCTURE_PIECE_TYPES = MASTER_DEFERRED_REGISTRAR.addRegister(Registries.STRUCTURE_PIECE, () -> TechnologicaStructurePieceTypes.WHALE_CARCASS);
	public static final DeferredRegister<TrunkPlacerType<?>> TRUNK_PLACER_TYPES = MASTER_DEFERRED_REGISTRAR.addRegister(Registries.TRUNK_PLACER_TYPE, () -> TechnologicaTrunkPlacerTypes.HUGE_TRUNK_PLACER);

	public static final DynamicRegister<BiomeModifier> BIOME_MODIFIERS = MASTER_DYNAMIC_REGISTRAR.addRegister(ForgeRegistries.Keys.BIOME_MODIFIERS, () -> TechnologicaBiomeModifiers.BADLANDS_UNDERGROUND_ORES);
	public static final DynamicRegister<Biome> BIOMES = MASTER_DYNAMIC_REGISTRAR.addRegister(ForgeRegistries.Keys.BIOMES, () -> TechnologicaBiomes.SILENT_EXPANSES);
	public static final DynamicRegister<ConfiguredFeature<?, ?>> CONFIGURED_FEATURES = MASTER_DYNAMIC_REGISTRAR.addRegister(Registries.CONFIGURED_FEATURE, () -> TechnologicaConfiguredFeatures.BRINE_POOL_CONFIGURED);
	public static final DynamicRegister<DamageType> DAMAGE_TYPES = MASTER_DYNAMIC_REGISTRAR.addRegister(Registries.DAMAGE_TYPE, () -> TechnologicaDamageTypes.BLEED);
	public static final DynamicRegister<DensityFunction> DENSITY_FUNCTIONS = MASTER_DYNAMIC_REGISTRAR.addRegister(Registries.DENSITY_FUNCTION, () -> TechnologicaDensityFunctions.CHALLENGER_DEEP_DEPTH);
	public static final DynamicRegister<DimensionType> DIMENSION_TYPES = MASTER_DYNAMIC_REGISTRAR.addRegister(Registries.DIMENSION_TYPE, () -> TechnologicaDimensionTypes.MOON);
	public static final DynamicRegister<LevelStem> DIMENSIONS = MASTER_DYNAMIC_REGISTRAR.addRegister(Registries.LEVEL_STEM, () -> TechnologicaDimensions.MOON_STEM);
	public static final DynamicRegister<NoiseParameters> NOISE = MASTER_DYNAMIC_REGISTRAR.addRegister(Registries.NOISE, () -> TechnologicaNoise.TEST);
	public static final DynamicRegister<NoiseGeneratorSettings> NOISE_GENERATOR_SETTINGS = MASTER_DYNAMIC_REGISTRAR.addRegister(Registries.NOISE_SETTINGS, () -> TechnologicaNoiseGeneratorSettings.MOON);
	public static final DynamicRegister<PaintingVariant> PAINTING_VARIANTS_DYN = MASTER_DYNAMIC_REGISTRAR.addRegister(Registries.PAINTING_VARIANT, () -> TechnologicaPaintingVariantsDyn.AMNESIA);
	public static final DynamicRegister<PlacedFeature> PLACED_FEATURES = MASTER_DYNAMIC_REGISTRAR.addRegister(Registries.PLACED_FEATURE, () -> TechnologicaPlacedFeatures.BRINE_POOL_PLACED);
	public static final DynamicRegister<StructureSet> STRUCTURE_SETS = MASTER_DYNAMIC_REGISTRAR.addRegister(Registries.STRUCTURE_SET, () -> TechnologicaStructureSets.EL_DORADO);
	public static final DynamicRegister<StructureTemplatePool> STRUCTURE_TEMPLATE_POOL = MASTER_DYNAMIC_REGISTRAR.addRegister(Registries.TEMPLATE_POOL, () -> TechnologicaStructureTemplatePools.DOME);
	public static final DynamicRegister<Structure> STRUCTURES = MASTER_DYNAMIC_REGISTRAR.addRegister(Registries.STRUCTURE, () -> TechnologicaStructures.EL_DORADO);

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

		// TODO: Determine best place for this. Maybe it's right here but that's unconfirmed.
		CraftingHelper.register(DisablePlankConditionFactory.Serializer.INSTANCE);
		CraftingHelper.register(EnablePlankConditionFactory.Serializer.INSTANCE);

		MASTER_SETUP_EXECUTOR.addEntityAttributes(() -> TechnologicaDefaultAttributes.SUPPLIERS);
		MASTER_SETUP_EXECUTOR.addCapabilities(List.of(TechnologicaAbilities.class, Link.class));
		MASTER_SETUP_EXECUTOR.addCommands(() -> TechnologicaCommands.COMMANDS);
		MASTER_SETUP_EXECUTOR.addToCompostables(() -> TechnologicaCompostables.COMPOSTABLES);
		MASTER_SETUP_EXECUTOR.addToFlowerPot(() -> TechnologicaFlowerPotPlants.PLANTS);
		MASTER_SETUP_EXECUTOR.addToVillageButcherTrades(() -> TechnologicaVillageTrades.TRADES_BUTCHER);
		MASTER_SETUP_EXECUTOR.addToVillageFarmerTrades(() -> TechnologicaVillageTrades.TRADES_FARMER);
		MASTER_SETUP_EXECUTOR.addToVillagerWantedItems(() -> TechnologicaVillagerWantedItems.WANTED_ITEMS);
		MASTER_SETUP_EXECUTOR.addToWanderingTraderGenericTrades(() -> TechnologicaWanderingTraderTrades.WANDERING_TRADER_TRADES_GENERIC);

		MASTER_SETUP_EXECUTOR.addSkullModels(() -> TechnologicaSkullBlockRenderer.createSkullRenderers());
		MASTER_SETUP_EXECUTOR.addLayerDefinitions(() -> TechnologicaLayerDefinitions.createRoots());
		MASTER_SETUP_EXECUTOR.registerEntityRenderers(() -> TechnologicaEntityRenderers.PROVIDERS);
		MASTER_SETUP_EXECUTOR.registerBlockEntityRenderers(() -> TechnologicaBlockEntityRenderers.PROVIDERS);
		MASTER_SETUP_EXECUTOR.registerAdditionalModels(() -> AdditionalModels.MODELS);
		MASTER_SETUP_EXECUTOR.registerColorHandlersBlock(() -> BlockColorHandlers.HANDLERS);
		MASTER_SETUP_EXECUTOR.registerDimensionSpecialEffects(() -> TechnologicaDimensionSpecialEffects.EFFECTS);
		MASTER_SETUP_EXECUTOR.registerParticleProvidersSprites(() -> TechnologicaParticleProviders.SPRITES);
		MASTER_SETUP_EXECUTOR.registerParticleProvidersSpriteSets(() -> TechnologicaParticleProviders.SPRITE_SETS);
		MASTER_SETUP_EXECUTOR.registerScreens(() -> TechnologicaMenuScreens.SCREENS);
		MASTER_SETUP_EXECUTOR.registerSkullTextures(() -> TechnologicaSkullBlockRenderer.SKIN_BY_TYPE);
		MASTER_SETUP_EXECUTOR.setFluidRenderTypes(() -> TechnologicaItemBlockRenderTypes.FLUID_RENDER_TYPES);
		MASTER_SETUP_EXECUTOR.addRenderTypes(() -> TechnologicaRenderBuffers.FIXED_BUFFERS);
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
