package com.technologica.resourcegen.assets;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

import com.technologica.Technologica;
import com.technologica.registration.deferred.TechnologicaCreativeModeTabs;
import com.technologica.registration.deferred.TechnologicaMobEffects;
import com.technologica.registration.dynamic.TechnologicaDamageTypes;

import net.minecraft.resources.ResourceKey;
import net.minecraft.world.damagesource.DamageType;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraftforge.registries.RegistryObject;

public class TLLang {
	public static final Map<String, String> LANG = new HashMap<>();

	static {
		LANG.put("advancements.stone_age.root.title", "Stone Age");
		LANG.put("advancements.stone_age.root.description", "We're all so glad you could join us");
		LANG.put("advancements.stone_age.discover_fire.title", "Ow! Heat was hot!");
		LANG.put("advancements.stone_age.discover_fire.description", "Discover fire");
		LANG.put("advancements.stone_age.make_fire.title", "Promethean Prodigy");
		LANG.put("advancements.stone_age.make_fire.description", "Start a fire with a bow drill");
		LANG.put("advancements.stone_age.light_campfire.title", "Camper");
		LANG.put("advancements.stone_age.light_campfire.description", "Light a campfire");
		LANG.put("advancements.stone_age.cook_meat.title", "Well Done");
		LANG.put("advancements.stone_age.cook_meat.description", "Cook food on a campfire");
		LANG.put("advancements.stone_age.discover_stick.title", "Sticks and Stone Age");
		LANG.put("advancements.stone_age.discover_stick.description", "Break some leaves to get a stick");
		LANG.put("advancements.stone_age.crude_saw.title", "I Saw That");
		LANG.put("advancements.stone_age.crude_saw.description", "Craft a crude saw from bone and flint");
		LANG.put("advancements.stone_age.discover_wood.title", "Logger");
		LANG.put("advancements.stone_age.discover_wood.description", "Chop down a tree using a tool");
		LANG.put("advancements.stone_age.craft_planks.title", "Carpenter");
		LANG.put("advancements.stone_age.craft_planks.description", "Craft planks using a saw");
		LANG.put("advancements.stone_age.board_boat.title", "Embark");
		LANG.put("advancements.stone_age.board_boat.description", "Board a boat");
		LANG.put("advancements.stone_age.discover_flint.title", "Hard Rock");
		LANG.put("advancements.stone_age.discover_flint.description", "Discover flint");
		LANG.put("advancements.stone_age.dawn_of_man.title", "Dawn of Man");
		LANG.put("advancements.stone_age.dawn_of_man.description", "Craft a primitive tool");
		LANG.put("advancements.stone_age.discover_clay.title", "Soft Rock");
		LANG.put("advancements.stone_age.discover_clay.description", "Discover clay");
		LANG.put("advancements.stone_age.make_jar.title", "Download the jar");
		LANG.put("advancements.stone_age.make_jar.description", "Fire a clay jar into a cermaic jar");
		LANG.put("advancements.stone_age.fill_jar.title", "Portable Potables");
		LANG.put("advancements.stone_age.fill_jar.description", "Collect water in a ceramic jar");
		LANG.put("advancements.stone_age.hunter.title", "Hunter");
		LANG.put("advancements.stone_age.hunter.description", "Slay an animal");
		LANG.put("advancements.stone_age.breed_animal.title", "Reproducible");
		LANG.put("advancements.stone_age.breed_animal.description", "Breed an animal");
		LANG.put("advancements.stone_age.tame_animal.title", "Domesticator");
		LANG.put("advancements.stone_age.tame_animal.description", "Tame an animal");
		LANG.put("advancements.stone_age.archery.title", "Archer");
		LANG.put("advancements.stone_age.archery.description", "Slay an animal with a bow and arrow");
		LANG.put("advancements.stone_age.fishing.title", "Angler");
		LANG.put("advancements.stone_age.fishing.description", "Catch a fish with a fishing rod");
		LANG.put("advancements.stone_age.gatherer.title", "Gatherer");
		LANG.put("advancements.stone_age.gatherer.description", "Harvest naturally growing food");
		LANG.put("advancements.stone_age.plant_crops.title", "Replenishable");
		LANG.put("advancements.stone_age.plant_crops.description", "Plant crops");
		LANG.put("advancements.stone_age.discover_mulch.title", "So Mulch to Do");
		LANG.put("advancements.stone_age.discover_mulch.description", "Strip a log to get mulch");
		LANG.put("advancements.stone_age.use_mulch.title", "So Mulch to See");
		LANG.put("advancements.stone_age.use_mulch.description", "Use mulch to accelerate fruit tree growth");
		LANG.put("commands.weather.set.meteor_storm", "Set the weather to meteor storm");
		addDeath(TechnologicaDamageTypes.BLEED, "bled out");
		addDeath(TechnologicaDamageTypes.NITRO_BLAST, "jostled the nitro");
		addEffect(TechnologicaMobEffects.HALLUCINIATION, "Hallucination");
		addEffect(TechnologicaMobEffects.HEMORRHAGE, "Hemorrhage");
		addEffect(TechnologicaMobEffects.LIFESIGHT, "Lifesight");
		addEffect(TechnologicaMobEffects.NECROSIS, "Necrosis");
		addEffect(TechnologicaMobEffects.NEUROPATHY, "Neuropathy");
		addEffect(TechnologicaMobEffects.PARALYSIS, "Paralysis");
		addEffect(TechnologicaMobEffects.RADIATION, "Radiation");
		addEntities(Technologica.ENTITY_TYPES.getEntries());
		addItems(Technologica.ITEMS.getEntries());
		addItemGroup(TechnologicaCreativeModeTabs.FLORA, "Flora");
		addItemGroup(TechnologicaCreativeModeTabs.FAUNA, "Fauna");
		addItemGroup(TechnologicaCreativeModeTabs.MINERAL, "Mineral");
		addItemGroup(TechnologicaCreativeModeTabs.FOOD, "Food");
		addItemGroup(TechnologicaCreativeModeTabs.CONSTRUCTION, "Construction");
		addItemGroup(TechnologicaCreativeModeTabs.MACHINERY, "Machinery");
		addItemGroup(TechnologicaCreativeModeTabs.DECORATIVE, "Decorative");
		addItemGroup(TechnologicaCreativeModeTabs.ARMORY, "Armory");
		addItemGroup(TechnologicaCreativeModeTabs.CRYPTICA, "Cryptica");
	}

	private final static void addItems(Collection<RegistryObject<Item>> collection) {
		for (Supplier<? extends Item> item : collection) {
			addItem(item, keyToValue(item.get().getDescriptionId()));
		}
	}

	private final static void addEntities(Collection<RegistryObject<EntityType<?>>> collection) {
		for (Supplier<? extends EntityType<?>> entity : collection) {
			addEntityType(entity, keyToValue(entity.get().getDescriptionId()));
		}
	}

	protected final static void addDeath(ResourceKey<DamageType> damageType, String translation) {
		add("death.attack." + damageType.location().getPath(), "%1$s " + translation);
		add("death.attack." + damageType.location().getPath() + ".player", "%1$s " + translation + " whilst fighting %2$s");
	}

	protected final static void addEffect(Supplier<? extends MobEffect> mobEffect, String translation) {
		add(mobEffect.get().getDescriptionId(), translation);
	}

	protected final static void addEntityType(Supplier<? extends EntityType<?>> entity, String translation) {
		add(entity.get().getDescriptionId(), translation);
	}

	protected final static void addItem(Supplier<? extends Item> item, String translation) {
		add(item.get().getDescriptionId(), translation);
	}

	protected final static void addItemGroup(Supplier<? extends CreativeModeTab> itemGroup, String translation) {
		add(itemGroup.get().getDisplayName().getString(), translation);
	}

	protected final static void add(String key, String value) {
		if (LANG.put(key, value) != null) {
			throw new IllegalStateException("Duplicate translation key " + key);
		}
	}

	private static String keyToValue(String key) {
		String words[] = key.replaceAll("item." + Technologica.MOD_ID + ".", "").replaceAll("block." + Technologica.MOD_ID + ".", "").replaceAll("entity." + Technologica.MOD_ID + ".", "").split("_");
		String name = "";
		for (String word : words) {
			String first = word.substring(0, 1);
			String afterFirst = word.substring(1);
			name += first.toUpperCase() + afterFirst + " ";
		}
		return name.trim();
	}
}
