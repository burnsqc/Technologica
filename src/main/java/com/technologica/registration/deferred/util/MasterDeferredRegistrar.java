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
import com.technologica.registration.deferred.TechnologicaPoisonDartFrogVariant;
import com.technologica.registration.deferred.TechnologicaRecipeSerializers;
import com.technologica.registration.deferred.TechnologicaRecipeTypes;
import com.technologica.registration.deferred.TechnologicaSoundEvents;
import com.technologica.registration.deferred.TechnologicaStructureTypes;
import com.technologica.registration.deferred.TechnologicaTrunkPlacerTypes;
import com.technologica.util.text.TextUtil;

import net.minecraft.core.Registry;
import net.minecraft.core.particles.ParticleType;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.sounds.SoundEvent;
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

	private static Map<ResourceKey<? extends Registry<?>>, long[]> registries = new HashMap<>();
	protected static Item.Properties emptyProperties = new Item.Properties();

	public static final DeferredRegister<Attribute> ATTRIBUTES = addRegister(ForgeRegistries.Keys.ATTRIBUTES, Technologica.MOD_ID);
	public static final DeferredRegister<Block> BLOCKS = addRegister(ForgeRegistries.Keys.BLOCKS, Technologica.MOD_ID);
	public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITY_TYPES = addRegister(ForgeRegistries.Keys.BLOCK_ENTITY_TYPES, Technologica.MOD_ID);
	public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS = addRegister(Registries.CREATIVE_MODE_TAB, Technologica.MOD_ID);
	public static final DeferredRegister<EntityType<?>> ENTITY_TYPES = addRegister(ForgeRegistries.Keys.ENTITY_TYPES, Technologica.MOD_ID);
	public static final DeferredRegister<Feature<?>> FEATURES = addRegister(ForgeRegistries.Keys.FEATURES, Technologica.MOD_ID);
	public static final DeferredRegister<Fluid> FLUIDS = addRegister(ForgeRegistries.Keys.FLUIDS, Technologica.MOD_ID);
	public static final DeferredRegister<FluidType> FLUID_TYPES = addRegister(ForgeRegistries.Keys.FLUID_TYPES, Technologica.MOD_ID);
	public static final DeferredRegister<FoliagePlacerType<?>> FOLIAGE_PLACER_TYPES = addRegister(ForgeRegistries.Keys.FOLIAGE_PLACER_TYPES, Technologica.MOD_ID);
	public static final DeferredRegister<Codec<? extends IGlobalLootModifier>> GLOBAL_LOOT_MODIFIER_SERIALIZERS = addRegister(ForgeRegistries.Keys.GLOBAL_LOOT_MODIFIER_SERIALIZERS, Technologica.MOD_ID);
	public static final DeferredRegister<Item> ITEMS = addRegister(ForgeRegistries.Keys.ITEMS, Technologica.MOD_ID);
	public static final DeferredRegister<MenuType<?>> MENU_TYPES = addRegister(ForgeRegistries.Keys.MENU_TYPES, Technologica.MOD_ID);
	public static final DeferredRegister<MobEffect> MOB_EFFECTS = addRegister(ForgeRegistries.Keys.MOB_EFFECTS, Technologica.MOD_ID);
	public static final DeferredRegister<PaintingVariant> PAINTING_VARIANTS = addRegister(ForgeRegistries.Keys.PAINTING_VARIANTS, Technologica.MOD_ID);
	public static final DeferredRegister<ParticleType<?>> PARTICLE_TYPES = addRegister(ForgeRegistries.Keys.PARTICLE_TYPES, Technologica.MOD_ID);
	public static final DeferredRegister<FrogVariant> POSION_DART_FROG_VARIANTS = addRegister(Registries.FROG_VARIANT, Technologica.MOD_ID);
	public static final DeferredRegister<RecipeSerializer<?>> RECIPE_SERIALIZERS = addRegister(ForgeRegistries.Keys.RECIPE_SERIALIZERS, Technologica.MOD_ID);
	public static final DeferredRegister<RecipeType<?>> RECIPE_TYPES = addRegister(ForgeRegistries.Keys.RECIPE_TYPES, Technologica.MOD_ID);
	public static final DeferredRegister<SoundEvent> SOUND_EVENTS = addRegister(ForgeRegistries.Keys.SOUND_EVENTS, Technologica.MOD_ID);
	public static final DeferredRegister<StructureType<?>> STRUCTURE_TYPES = addRegister(Registries.STRUCTURE_TYPE, Technologica.MOD_ID);
	public static final DeferredRegister<TrunkPlacerType<?>> TRUNK_PLACER_TYPES = addRegister(Registries.TRUNK_PLACER_TYPE, Technologica.MOD_ID);

	public static <B> DeferredRegister<B> addRegister(ResourceKey<? extends Registry<B>> key, String modid) {
		DeferredRegister<B> deferredRegister = DeferredRegister.create(key, modid);
		registries.put(key, new long[] { 0, 0 });
		deferredRegister.register(Technologica.MOD_EVENT_BUS);
		return deferredRegister;
	}

	public static void initDeferredRegisters() {
		registries.computeIfPresent(ATTRIBUTES.getRegistryKey(), (k, t) -> new long[] { TechnologicaAttributes.init(), 0 });
		Technologica.LOGGER.info("INITIALIZATION - " + TextUtil.stringToAllCapsName(ATTRIBUTES.getRegistryName().getPath()) + " - " + Array.get(registries.get(ATTRIBUTES.getRegistryKey()), 0));
		registries.computeIfPresent(BLOCKS.getRegistryKey(), (k, t) -> new long[] { TechnologicaBlocks.init(), 0 });
		Technologica.LOGGER.info("INITIALIZATION - " + TextUtil.stringToAllCapsName(BLOCKS.getRegistryName().getPath()) + " - " + Array.get(registries.get(BLOCKS.getRegistryKey()), 0));
		registries.computeIfPresent(BLOCK_ENTITY_TYPES.getRegistryKey(), (k, t) -> new long[] { TechnologicaBlockEntityTypes.init(), 0 });
		Technologica.LOGGER.info("INITIALIZATION - " + TextUtil.stringToAllCapsName(BLOCK_ENTITY_TYPES.getRegistryName().getPath()) + " - " + Array.get(registries.get(BLOCK_ENTITY_TYPES.getRegistryKey()), 0));
		registries.computeIfPresent(CREATIVE_MODE_TABS.getRegistryKey(), (k, t) -> new long[] { TechnologicaCreativeModeTabs.init(), 0 });
		Technologica.LOGGER.info("INITIALIZATION - " + TextUtil.stringToAllCapsName(CREATIVE_MODE_TABS.getRegistryName().getPath()) + " - " + Array.get(registries.get(CREATIVE_MODE_TABS.getRegistryKey()), 0));
		registries.computeIfPresent(ENTITY_TYPES.getRegistryKey(), (k, t) -> new long[] { TechnologicaEntityTypes.init(), 0 });
		Technologica.LOGGER.info("INITIALIZATION - " + TextUtil.stringToAllCapsName(ENTITY_TYPES.getRegistryName().getPath()) + " - " + Array.get(registries.get(ENTITY_TYPES.getRegistryKey()), 0));
		registries.computeIfPresent(FEATURES.getRegistryKey(), (k, t) -> new long[] { TechnologicaFeatures.init(), 0 });
		Technologica.LOGGER.info("INITIALIZATION - " + TextUtil.stringToAllCapsName(FEATURES.getRegistryName().getPath()) + " - " + Array.get(registries.get(FEATURES.getRegistryKey()), 0));
		registries.computeIfPresent(FLUIDS.getRegistryKey(), (k, t) -> new long[] { TechnologicaFluids.init(), 0 });
		Technologica.LOGGER.info("INITIALIZATION - " + TextUtil.stringToAllCapsName(FLUIDS.getRegistryName().getPath()) + " - " + Array.get(registries.get(FLUIDS.getRegistryKey()), 0));
		registries.computeIfPresent(FLUID_TYPES.getRegistryKey(), (k, t) -> new long[] { TechnologicaFluidTypes.init(), 0 });
		Technologica.LOGGER.info("INITIALIZATION - " + TextUtil.stringToAllCapsName(FLUID_TYPES.getRegistryName().getPath()) + " - " + Array.get(registries.get(FLUID_TYPES.getRegistryKey()), 0));
		registries.computeIfPresent(FOLIAGE_PLACER_TYPES.getRegistryKey(), (k, t) -> new long[] { TechnologicaFoliagePlacerTypes.init(), 0 });
		Technologica.LOGGER.info("INITIALIZATION - " + TextUtil.stringToAllCapsName(FOLIAGE_PLACER_TYPES.getRegistryName().getPath()) + " - " + Array.get(registries.get(FOLIAGE_PLACER_TYPES.getRegistryKey()), 0));
		registries.computeIfPresent(GLOBAL_LOOT_MODIFIER_SERIALIZERS.getRegistryKey(), (k, t) -> new long[] { TechnologicaGlobalLootModifierSerializers.init(), 0 });
		Technologica.LOGGER.info("INITIALIZATION - " + TextUtil.stringToAllCapsName(GLOBAL_LOOT_MODIFIER_SERIALIZERS.getRegistryName().getPath()) + " - " + Array.get(registries.get(GLOBAL_LOOT_MODIFIER_SERIALIZERS.getRegistryKey()), 0));
		registries.computeIfPresent(ITEMS.getRegistryKey(), (k, t) -> new long[] { TechnologicaItems.init(), 0 });
		Technologica.LOGGER.info("INITIALIZATION - " + TextUtil.stringToAllCapsName(ITEMS.getRegistryName().getPath()) + " - " + Array.get(registries.get(ITEMS.getRegistryKey()), 0));
		registries.computeIfPresent(MENU_TYPES.getRegistryKey(), (k, t) -> new long[] { TechnologicaMenuTypes.init(), 0 });
		Technologica.LOGGER.info("INITIALIZATION - " + TextUtil.stringToAllCapsName(MENU_TYPES.getRegistryName().getPath()) + " - " + Array.get(registries.get(MENU_TYPES.getRegistryKey()), 0));
		registries.computeIfPresent(MOB_EFFECTS.getRegistryKey(), (k, t) -> new long[] { TechnologicaMobEffects.init(), 0 });
		Technologica.LOGGER.info("INITIALIZATION - " + TextUtil.stringToAllCapsName(MOB_EFFECTS.getRegistryName().getPath()) + " - " + Array.get(registries.get(MOB_EFFECTS.getRegistryKey()), 0));
		registries.computeIfPresent(PAINTING_VARIANTS.getRegistryKey(), (k, t) -> new long[] { TechnologicaPaintingVariant.init(), 0 });
		Technologica.LOGGER.info("INITIALIZATION - " + TextUtil.stringToAllCapsName(PAINTING_VARIANTS.getRegistryName().getPath()) + " - " + Array.get(registries.get(PAINTING_VARIANTS.getRegistryKey()), 0));
		registries.computeIfPresent(PARTICLE_TYPES.getRegistryKey(), (k, t) -> new long[] { TechnologicaParticleTypes.init(), 0 });
		Technologica.LOGGER.info("INITIALIZATION - " + TextUtil.stringToAllCapsName(PARTICLE_TYPES.getRegistryName().getPath()) + " - " + Array.get(registries.get(PARTICLE_TYPES.getRegistryKey()), 0));
		registries.computeIfPresent(POSION_DART_FROG_VARIANTS.getRegistryKey(), (k, t) -> new long[] { TechnologicaPoisonDartFrogVariant.init(), 0 });
		Technologica.LOGGER.info("INITIALIZATION - " + TextUtil.stringToAllCapsName(POSION_DART_FROG_VARIANTS.getRegistryName().getPath()) + " - " + Array.get(registries.get(POSION_DART_FROG_VARIANTS.getRegistryKey()), 0));
		registries.computeIfPresent(RECIPE_SERIALIZERS.getRegistryKey(), (k, t) -> new long[] { TechnologicaRecipeSerializers.init(), 0 });
		Technologica.LOGGER.info("INITIALIZATION - " + TextUtil.stringToAllCapsName(RECIPE_SERIALIZERS.getRegistryName().getPath()) + " - " + Array.get(registries.get(RECIPE_SERIALIZERS.getRegistryKey()), 0));
		registries.computeIfPresent(RECIPE_TYPES.getRegistryKey(), (k, t) -> new long[] { TechnologicaRecipeTypes.init(), 0 });
		Technologica.LOGGER.info("INITIALIZATION - " + TextUtil.stringToAllCapsName(RECIPE_TYPES.getRegistryName().getPath()) + " - " + Array.get(registries.get(RECIPE_TYPES.getRegistryKey()), 0));
		registries.computeIfPresent(SOUND_EVENTS.getRegistryKey(), (k, t) -> new long[] { TechnologicaSoundEvents.init(), 0 });
		Technologica.LOGGER.info("INITIALIZATION - " + TextUtil.stringToAllCapsName(SOUND_EVENTS.getRegistryName().getPath()) + " - " + Array.get(registries.get(SOUND_EVENTS.getRegistryKey()), 0));
		registries.computeIfPresent(STRUCTURE_TYPES.getRegistryKey(), (k, t) -> new long[] { TechnologicaStructureTypes.init(), 0 });
		Technologica.LOGGER.info("INITIALIZATION - " + TextUtil.stringToAllCapsName(STRUCTURE_TYPES.getRegistryName().getPath()) + " - " + Array.get(registries.get(STRUCTURE_TYPES.getRegistryKey()), 0));
		registries.computeIfPresent(TRUNK_PLACER_TYPES.getRegistryKey(), (k, t) -> new long[] { TechnologicaTrunkPlacerTypes.init(), 0 });
		Technologica.LOGGER.info("INITIALIZATION - " + TextUtil.stringToAllCapsName(TRUNK_PLACER_TYPES.getRegistryName().getPath()) + " - " + Array.get(registries.get(TRUNK_PLACER_TYPES.getRegistryKey()), 0));
	}

	public static void onRegisterEvent(final RegisterEvent event) {
		long initialized = 0;
		long registered = 0;

		if (registries.containsKey(event.getRegistryKey())) {
			initialized = (long) Array.get(registries.get(event.getRegistryKey()), 0);
		}

		if (event.getForgeRegistry() != null) {
			registered = event.getForgeRegistry().getEntries().stream().filter((entry) -> {
				return entry.getKey().location().getNamespace() == Technologica.MOD_ID;
			}).count();
		} else if (event.getVanillaRegistry() != null) {
			registered = event.getVanillaRegistry().entrySet().stream().filter((entry) -> {
				return entry.getKey().location().getNamespace() == Technologica.MOD_ID;
			}).count();

		}

		Technologica.LOGGER.info("REGISTRATION - " + TextUtil.stringToAllCapsName(TextUtil.getPath(event.getRegistryKey())) + " - " + registered + " OF " + initialized);
		if (registered != initialized) {
			Technologica.LOGGER.error("REGISTRATION ERROR - " + TextUtil.stringToAllCapsName(TextUtil.getPath(event.getRegistryKey())) + " - MISSING " + (initialized - registered));
		}

	}
}
