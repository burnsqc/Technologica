package com.technologica.registration.deferred.util;

import java.lang.reflect.Array;
import java.util.HashMap;
import java.util.Map;

import com.mojang.serialization.Codec;
import com.technologica.Technologica;
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
import com.technologica.registration.deferred.TechnologicaPaintingVariant;
import com.technologica.registration.deferred.TechnologicaParticleTypes;
import com.technologica.registration.deferred.TechnologicaRecipeSerializers;
import com.technologica.registration.deferred.TechnologicaRecipeTypes;
import com.technologica.registration.deferred.TechnologicaSoundEvents;
import com.technologica.registration.deferred.TechnologicaStructureTypes;
import com.technologica.registration.deferred.TechnologicaTrunkPlacerTypes;

import net.minecraft.core.particles.ParticleType;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.decoration.PaintingVariant;
import net.minecraft.world.inventory.MenuType;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.foliageplacers.FoliagePlacerType;
import net.minecraft.world.level.levelgen.feature.trunkplacers.TrunkPlacerType;
import net.minecraft.world.level.levelgen.structure.StructureType;
import net.minecraft.world.level.material.Fluid;
import net.minecraftforge.common.loot.IGlobalLootModifier;
import net.minecraftforge.fluids.FluidType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegisterEvent;

/**
 * <p>
 * This class contains definitions of Deferred Registers.
 * This class is to be extended by any subclasses that solely define Registry Objects.
 * </p>
 * 
 * @tl.status GREEN
 */
public abstract class MasterDeferredRegistrar {

	private static Map<String, Integer[]> counts = new HashMap<>();

	private static int soundEvents;
	private static int fluids;
	private static int blocks;
	private static int mobEffects;
	private static int particleTypes;
	private static int items;
	private static int entityTypes;
	private static int blockEntityTypes;
	private static int menuTypes;
	private static int recipeTypes;
	private static int recipeSerializers;
	private static int features;
	private static int foliagePlacerTypes;
	private static int creativeModeTabs;
	private static int fluidTypes;
	private static int globalLootModifierTypes;
	private static int structureTypes;
	private static int trunkPlacerTypes;
	private static int attributes;
	private static int paintingVariants;

	public static final DeferredRegister<Attribute> ATTRIBUTES = DeferredRegister.create(ForgeRegistries.Keys.ATTRIBUTES, Technologica.MOD_ID);
	public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITY_TYPES = DeferredRegister.create(ForgeRegistries.Keys.BLOCK_ENTITY_TYPES, Technologica.MOD_ID);
	public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.Keys.BLOCKS, Technologica.MOD_ID);
	public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, Technologica.MOD_ID);
	public static final DeferredRegister<EntityType<?>> ENTITY_TYPES = DeferredRegister.create(ForgeRegistries.Keys.ENTITY_TYPES, Technologica.MOD_ID);
	public static final DeferredRegister<Feature<?>> FEATURES = DeferredRegister.create(ForgeRegistries.Keys.FEATURES, Technologica.MOD_ID);
	public static final DeferredRegister<Fluid> FLUIDS = DeferredRegister.create(ForgeRegistries.Keys.FLUIDS, Technologica.MOD_ID);
	public static final DeferredRegister<FluidType> FLUID_TYPES = DeferredRegister.create(ForgeRegistries.Keys.FLUID_TYPES, Technologica.MOD_ID);
	public static final DeferredRegister<FoliagePlacerType<?>> FOLIAGE_PLACER_TYPES = DeferredRegister.create(ForgeRegistries.Keys.FOLIAGE_PLACER_TYPES, Technologica.MOD_ID);
	public static final DeferredRegister<Codec<? extends IGlobalLootModifier>> GLOBAL_LOOT_MODIFIER_SERIALIZERS = DeferredRegister.create(ForgeRegistries.Keys.GLOBAL_LOOT_MODIFIER_SERIALIZERS, Technologica.MOD_ID);
	public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.Keys.ITEMS, Technologica.MOD_ID);
	public static final DeferredRegister<MenuType<?>> MENU_TYPES = DeferredRegister.create(ForgeRegistries.MENU_TYPES, Technologica.MOD_ID);
	public static final DeferredRegister<MobEffect> MOB_EFFECTS = DeferredRegister.create(ForgeRegistries.Keys.MOB_EFFECTS, Technologica.MOD_ID);
	public static final DeferredRegister<ParticleType<?>> PARTICLE_TYPES = DeferredRegister.create(ForgeRegistries.Keys.PARTICLE_TYPES, Technologica.MOD_ID);
	public static final DeferredRegister<RecipeSerializer<?>> RECIPE_SERIALIZERS = DeferredRegister.create(ForgeRegistries.Keys.RECIPE_SERIALIZERS, Technologica.MOD_ID);
	public static final DeferredRegister<RecipeType<?>> RECIPE_TYPES = DeferredRegister.create(ForgeRegistries.Keys.RECIPE_TYPES, Technologica.MOD_ID);
	public static final DeferredRegister<SoundEvent> SOUND_EVENTS = DeferredRegister.create(ForgeRegistries.Keys.SOUND_EVENTS, Technologica.MOD_ID);
	public static final DeferredRegister<StructureType<?>> STRUCTURE_TYPES = DeferredRegister.create(Registries.STRUCTURE_TYPE, Technologica.MOD_ID);
	public static final DeferredRegister<TrunkPlacerType<?>> TRUNK_PLACER_TYPES = DeferredRegister.create(Registries.TRUNK_PLACER_TYPE, Technologica.MOD_ID);
	public static final DeferredRegister<PaintingVariant> PAINTING_VARIANTS = DeferredRegister.create(ForgeRegistries.Keys.PAINTING_VARIANTS, Technologica.MOD_ID);

	public static void initDeferredRegisters() {

		counts.put(SOUND_EVENTS.getRegistryName().getPath(), new Integer[] { TechnologicaSoundEvents.init(), 0 });
		// soundEvents = TechnologicaSoundEvents.init();
		Technologica.LOGGER.info("INITIALIZATION - " + SOUND_EVENTS.getRegistryName().getPath() + " - " + Array.get(counts.get(SOUND_EVENTS.getRegistryName().getPath()), 0));

		fluids = TechnologicaFluids.init();
		Technologica.LOGGER.info("INITIALIZATION - FLUIDS - " + fluids);

		blocks = TechnologicaBlocks.init();
		Technologica.LOGGER.info("INITIALIZATION - BLOCKS - " + blocks);

		mobEffects = TechnologicaMobEffects.init();
		Technologica.LOGGER.info("INITIALIZATION - MOB EFFECTS - " + mobEffects);

		particleTypes = TechnologicaParticleTypes.init();
		Technologica.LOGGER.info("INITIALIZATION - PARTICLE TYPES - " + particleTypes);

		items = TechnologicaItems.init();
		Technologica.LOGGER.info("INITIALIZATION - ITEMS - " + items);

		entityTypes = TechnologicaEntityTypes.init();
		Technologica.LOGGER.info("INITIALIZATION - ENTITY TYPES - " + entityTypes);

		blockEntityTypes = TechnologicaBlockEntityTypes.init();
		Technologica.LOGGER.info("INITIALIZATION - BLOCK ENTITY TYPES - " + blockEntityTypes);

		menuTypes = TechnologicaMenuTypes.init();
		Technologica.LOGGER.info("INITIALIZATION - MENU TYPES - " + menuTypes);

		recipeTypes = TechnologicaRecipeTypes.init();
		Technologica.LOGGER.info("INITIALIZATION - RECIPE TYPES - " + recipeTypes);

		recipeSerializers = TechnologicaRecipeSerializers.init();
		Technologica.LOGGER.info("INITIALIZATION - RECIPE SERIALIZERS - " + recipeSerializers);

		features = TechnologicaFeatures.init();
		Technologica.LOGGER.info("INITIALIZATION - FEATURES - " + features);

		foliagePlacerTypes = TechnologicaFoliagePlacerTypes.init();
		Technologica.LOGGER.info("INITIALIZATION - FOLIAGE PLACER TYPES - " + foliagePlacerTypes);

		trunkPlacerTypes = TechnologicaTrunkPlacerTypes.init();
		Technologica.LOGGER.info("INITIALIZATION - TRUNK PLACER TYPES - " + trunkPlacerTypes);

		creativeModeTabs = TechnologicaCreativeModeTabs.init();
		Technologica.LOGGER.info("INITIALIZATION - CREATIVE MODE TABS - " + creativeModeTabs);

		fluidTypes = TechnologicaFluidTypes.init();
		Technologica.LOGGER.info("INITIALIZATION - FLUID TYPES - " + fluidTypes);

		globalLootModifierTypes = TechnologicaGlobalLootModifierSerializers.init();
		Technologica.LOGGER.info("INITIALIZATION - LOOT MODIFIERS - " + globalLootModifierTypes);

		structureTypes = TechnologicaStructureTypes.init();
		Technologica.LOGGER.info("INITIALIZATION - STRUCTURE TYPES - " + structureTypes);

		attributes = TechnologicaAttributes.init();
		Technologica.LOGGER.info("INITIALIZATION - ATTRIBUTES - " + attributes);

		paintingVariants = TechnologicaPaintingVariant.init();
		Technologica.LOGGER.info("INITIALIZATION - PAINTING VARIANTS - " + paintingVariants);
	}

	public static void onRegisterEvent(final RegisterEvent event) {
		if (event.getRegistryKey() == ForgeRegistries.Keys.SOUND_EVENTS) {
			long count = ForgeRegistries.SOUND_EVENTS.getEntries().stream().filter((entry) -> {
				return entry.getKey().location().getNamespace() == Technologica.MOD_ID;
			}).count();
			Technologica.LOGGER.info("REGISTRATION - SOUND EVENTS - " + count + " OF " + soundEvents);

		} else if (event.getRegistryKey() == ForgeRegistries.Keys.FLUIDS) {
			long fluids = ForgeRegistries.FLUIDS.getEntries().stream().filter((entry) -> {
				return entry.getKey().location().getNamespace() == Technologica.MOD_ID;
			}).count();
			Technologica.LOGGER.info("REGISTRATION - FLUIDS - " + fluids + " OF " + fluids);

		} else if (event.getRegistryKey() == ForgeRegistries.Keys.BLOCKS) {
			long blocks = ForgeRegistries.BLOCKS.getEntries().stream().filter((entry) -> {
				return entry.getKey().location().getNamespace() == Technologica.MOD_ID;
			}).count();
			Technologica.LOGGER.info("REGISTRATION - BLOCKS - " + blocks + " OF " + blocks);

		} else if (event.getRegistryKey() == ForgeRegistries.Keys.MOB_EFFECTS) {
			long count = ForgeRegistries.MOB_EFFECTS.getEntries().stream().filter((entry) -> {
				return entry.getKey().location().getNamespace() == Technologica.MOD_ID;
			}).count();
			Technologica.LOGGER.info("REGISTRATION - MOB EFFECTS - " + count + " OF " + mobEffects);

		} else if (event.getRegistryKey() == ForgeRegistries.Keys.PARTICLE_TYPES) {
			long count = ForgeRegistries.PARTICLE_TYPES.getEntries().stream().filter((entry) -> {
				return entry.getKey().location().getNamespace() == Technologica.MOD_ID;
			}).count();
			Technologica.LOGGER.info("REGISTRATION - PARTICLE TYPES - " + count + " OF " + particleTypes);

		} else if (event.getRegistryKey() == ForgeRegistries.Keys.ITEMS) {
			long count = ForgeRegistries.ITEMS.getEntries().stream().filter((entry) -> {
				return entry.getKey().location().getNamespace() == Technologica.MOD_ID;
			}).count();
			Technologica.LOGGER.info("REGISTRATION - ITEMS - " + count + " OF " + items);

		} else if (event.getRegistryKey() == ForgeRegistries.Keys.ENTITY_TYPES) {
			long count = ForgeRegistries.ENTITY_TYPES.getEntries().stream().filter((entry) -> {
				return entry.getKey().location().getNamespace() == Technologica.MOD_ID;
			}).count();
			Technologica.LOGGER.info("REGISTRATION - ENTITY TYPES - " + count + " OF " + entityTypes);

		} else if (event.getRegistryKey() == ForgeRegistries.Keys.BLOCK_ENTITY_TYPES) {
			long count = ForgeRegistries.BLOCK_ENTITY_TYPES.getEntries().stream().filter((entry) -> {
				return entry.getKey().location().getNamespace() == Technologica.MOD_ID;
			}).count();
			Technologica.LOGGER.info("REGISTRATION - BLOCK ENTITY TYPES - " + count + " OF " + blockEntityTypes);

		} else if (event.getRegistryKey() == ForgeRegistries.Keys.MENU_TYPES) {
			long count = ForgeRegistries.MENU_TYPES.getEntries().stream().filter((entry) -> {
				return entry.getKey().location().getNamespace() == Technologica.MOD_ID;
			}).count();
			Technologica.LOGGER.info("REGISTRATION - MENU TYPES - " + count + " OF " + menuTypes);

		} else if (event.getRegistryKey() == ForgeRegistries.Keys.RECIPE_TYPES) {
			long count = ForgeRegistries.RECIPE_TYPES.getEntries().stream().filter((entry) -> {
				return entry.getKey().location().getNamespace() == Technologica.MOD_ID;
			}).count();
			Technologica.LOGGER.info("REGISTRATION - RECIPE TYPES - " + count + " OF " + recipeTypes);

		} else if (event.getRegistryKey() == ForgeRegistries.Keys.RECIPE_SERIALIZERS) {
			long count = ForgeRegistries.RECIPE_SERIALIZERS.getEntries().stream().filter((entry) -> {
				return entry.getKey().location().getNamespace() == Technologica.MOD_ID;
			}).count();
			Technologica.LOGGER.info("REGISTRATION - RECIPE SERIALIZERS - " + count + " OF " + recipeSerializers);

		} else if (event.getRegistryKey() == ForgeRegistries.Keys.FEATURES) {
			long count = ForgeRegistries.FEATURES.getEntries().stream().filter((entry) -> {
				return entry.getKey().location().getNamespace() == Technologica.MOD_ID;
			}).count();
			Technologica.LOGGER.info("REGISTRATION - FEATURES - " + count + " OF " + features);

		} else if (event.getRegistryKey() == ForgeRegistries.Keys.FOLIAGE_PLACER_TYPES) {
			long count = ForgeRegistries.FOLIAGE_PLACER_TYPES.getEntries().stream().filter((entry) -> {
				return entry.getKey().location().getNamespace() == Technologica.MOD_ID;
			}).count();
			Technologica.LOGGER.info("REGISTRATION - FOLIAGE PLACER TYPES - " + count + " OF " + foliagePlacerTypes);

		} else if (event.getRegistryKey() == Registries.TRUNK_PLACER_TYPE) {
			long count = BuiltInRegistries.TRUNK_PLACER_TYPE.entrySet().stream().filter((entry) -> {
				return entry.getKey().location().getNamespace() == Technologica.MOD_ID;
			}).count();
			Technologica.LOGGER.info("REGISTRATION - TRUNK PLACER TYPES - " + count + " OF " + trunkPlacerTypes);

		} else if (event.getRegistryKey() == Registries.CREATIVE_MODE_TAB) {
			long count = BuiltInRegistries.CREATIVE_MODE_TAB.entrySet().stream().filter((entry) -> {
				return entry.getKey().location().getNamespace() == Technologica.MOD_ID;
			}).count();
			Technologica.LOGGER.info("REGISTRATION - CREATIVE MODE TABS - " + count + " OF " + creativeModeTabs);

		} else if (event.getRegistryKey() == ForgeRegistries.Keys.FLUID_TYPES) {
			long fluidTypes = ForgeRegistries.FLUID_TYPES.get().getEntries().stream().filter((entry) -> {
				return entry.getKey().location().getNamespace() == Technologica.MOD_ID;
			}).count();
			Technologica.LOGGER.info("REGISTRATION - FLUID TYPES - " + fluidTypes + " OF " + fluidTypes);

		} else if (event.getRegistryKey() == ForgeRegistries.Keys.GLOBAL_LOOT_MODIFIER_SERIALIZERS) {
			long count = ForgeRegistries.GLOBAL_LOOT_MODIFIER_SERIALIZERS.get().getEntries().stream().filter((entry) -> {
				return entry.getKey().location().getNamespace() == Technologica.MOD_ID;
			}).count();
			Technologica.LOGGER.info("REGISTRATION - GLOBAL LOOT MODIFIER SERIALIZERS - " + count + " OF " + globalLootModifierTypes);

		}
	}
}