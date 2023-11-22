package com.technologica.listeners.modbus;

import static com.technologica.Technologica.LOGGER;

import com.technologica.Technologica;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegisterEvent;

public class Register {
	public static void onRegisterEvent(final RegisterEvent event) {
		if (event.getRegistryKey() == ForgeRegistries.Keys.SOUND_EVENTS) {
			long count = ForgeRegistries.SOUND_EVENTS.getEntries().stream().filter((entry) -> {
				return entry.getKey().location().getNamespace() == Technologica.MOD_ID;
			}).count();
			LOGGER.info("REGISTRATION - SOUND EVENTS - " + count + " OF " + Technologica.soundEvents);

		} else if (event.getRegistryKey() == ForgeRegistries.Keys.FLUIDS) {
			long fluids = ForgeRegistries.FLUIDS.getEntries().stream().filter((entry) -> {
				return entry.getKey().location().getNamespace() == Technologica.MOD_ID;
			}).count();
			LOGGER.info("REGISTRATION - FLUIDS - " + fluids + " OF " + Technologica.fluids);

		} else if (event.getRegistryKey() == ForgeRegistries.Keys.BLOCKS) {
			long blocks = ForgeRegistries.BLOCKS.getEntries().stream().filter((entry) -> {
				return entry.getKey().location().getNamespace() == Technologica.MOD_ID;
			}).count();
			LOGGER.info("REGISTRATION - BLOCKS - " + blocks + " OF " + Technologica.blocks);

		} else if (event.getRegistryKey() == ForgeRegistries.Keys.MOB_EFFECTS) {
			long count = ForgeRegistries.MOB_EFFECTS.getEntries().stream().filter((entry) -> {
				return entry.getKey().location().getNamespace() == Technologica.MOD_ID;
			}).count();
			LOGGER.info("REGISTRATION - MOB EFFECTS - " + count + " OF " + Technologica.mobEffects);

		} else if (event.getRegistryKey() == ForgeRegistries.Keys.PARTICLE_TYPES) {
			long count = ForgeRegistries.PARTICLE_TYPES.getEntries().stream().filter((entry) -> {
				return entry.getKey().location().getNamespace() == Technologica.MOD_ID;
			}).count();
			LOGGER.info("REGISTRATION - PARTICLE TYPES - " + count + " OF " + Technologica.particleTypes);

		} else if (event.getRegistryKey() == ForgeRegistries.Keys.ITEMS) {
			long count = ForgeRegistries.ITEMS.getEntries().stream().filter((entry) -> {
				return entry.getKey().location().getNamespace() == Technologica.MOD_ID;
			}).count();
			LOGGER.info("REGISTRATION - ITEMS - " + count + " OF " + Technologica.items);

		} else if (event.getRegistryKey() == ForgeRegistries.Keys.ENTITY_TYPES) {
			long count = ForgeRegistries.ENTITY_TYPES.getEntries().stream().filter((entry) -> {
				return entry.getKey().location().getNamespace() == Technologica.MOD_ID;
			}).count();
			LOGGER.info("REGISTRATION - ENTITY TYPES - " + count + " OF " + Technologica.entityTypes);

		} else if (event.getRegistryKey() == ForgeRegistries.Keys.BLOCK_ENTITY_TYPES) {
			long count = ForgeRegistries.BLOCK_ENTITY_TYPES.getEntries().stream().filter((entry) -> {
				return entry.getKey().location().getNamespace() == Technologica.MOD_ID;
			}).count();
			LOGGER.info("REGISTRATION - BLOCK ENTITY TYPES - " + count + " OF " + Technologica.blockEntityTypes);

		} else if (event.getRegistryKey() == ForgeRegistries.Keys.MENU_TYPES) {
			long count = ForgeRegistries.MENU_TYPES.getEntries().stream().filter((entry) -> {
				return entry.getKey().location().getNamespace() == Technologica.MOD_ID;
			}).count();
			LOGGER.info("REGISTRATION - MENU TYPES - " + count + " OF " + Technologica.menuTypes);

		} else if (event.getRegistryKey() == ForgeRegistries.Keys.RECIPE_TYPES) {
			long count = ForgeRegistries.RECIPE_TYPES.getEntries().stream().filter((entry) -> {
				return entry.getKey().location().getNamespace() == Technologica.MOD_ID;
			}).count();
			LOGGER.info("REGISTRATION - RECIPE TYPES - " + count + " OF " + Technologica.recipeTypes);

		} else if (event.getRegistryKey() == ForgeRegistries.Keys.RECIPE_SERIALIZERS) {
			long count = ForgeRegistries.RECIPE_SERIALIZERS.getEntries().stream().filter((entry) -> {
				return entry.getKey().location().getNamespace() == Technologica.MOD_ID;
			}).count();
			LOGGER.info("REGISTRATION - RECIPE SERIALIZERS - " + count + " OF " + Technologica.recipeSerializers);

		} else if (event.getRegistryKey() == ForgeRegistries.Keys.FEATURES) {
			long count = ForgeRegistries.FEATURES.getEntries().stream().filter((entry) -> {
				return entry.getKey().location().getNamespace() == Technologica.MOD_ID;
			}).count();
			LOGGER.info("REGISTRATION - FEATURES - " + count + " OF " + Technologica.features);

		} else if (event.getRegistryKey() == ForgeRegistries.Keys.FOLIAGE_PLACER_TYPES) {
			long count = ForgeRegistries.FOLIAGE_PLACER_TYPES.getEntries().stream().filter((entry) -> {
				return entry.getKey().location().getNamespace() == Technologica.MOD_ID;
			}).count();
			LOGGER.info("REGISTRATION - FOLIAGE PLACER TYPES - " + count + " OF " + Technologica.foliagePlacerTypes);

		} else if (event.getRegistryKey() == Registries.TRUNK_PLACER_TYPE) {
			long count = BuiltInRegistries.TRUNK_PLACER_TYPE.entrySet().stream().filter((entry) -> {
				return entry.getKey().location().getNamespace() == Technologica.MOD_ID;
			}).count();
			LOGGER.info("REGISTRATION - TRUNK PLACER TYPES - " + count + " OF " + Technologica.trunkPlacerTypes);

		}else if (event.getRegistryKey() == Registries.CREATIVE_MODE_TAB) {
			long count = BuiltInRegistries.CREATIVE_MODE_TAB.entrySet().stream().filter((entry) -> {
				return entry.getKey().location().getNamespace() == Technologica.MOD_ID;
			}).count();
			LOGGER.info("REGISTRATION - CREATIVE MODE TABS - " + count + " OF " + Technologica.creativeModeTabs);

		} else if (event.getRegistryKey() == ForgeRegistries.Keys.FLUID_TYPES) {
			long fluidTypes = ForgeRegistries.FLUID_TYPES.get().getEntries().stream().filter((entry) -> {
				return entry.getKey().location().getNamespace() == Technologica.MOD_ID;
			}).count();
			LOGGER.info("REGISTRATION - FLUID TYPES - " + fluidTypes + " OF " + Technologica.fluidTypes);

		} else if (event.getRegistryKey() == ForgeRegistries.Keys.GLOBAL_LOOT_MODIFIER_SERIALIZERS) {
			long count = ForgeRegistries.GLOBAL_LOOT_MODIFIER_SERIALIZERS.get().getEntries().stream().filter((entry) -> {
				return entry.getKey().location().getNamespace() == Technologica.MOD_ID;
			}).count();
			LOGGER.info("REGISTRATION - GLOBAL LOOT MODIFIER SERIALIZERS - " + count + " OF " + Technologica.globalLootModifierTypes);

		}
	}
}