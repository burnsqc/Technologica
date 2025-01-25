package com.technologica.resourcegen.assets;

import java.util.Collection;
import java.util.function.Supplier;

import com.technologica.Technologica;
import com.technologica.registration.deferred.TechnologicaCreativeModeTabs;
import com.technologica.registration.deferred.TechnologicaMobEffects;
import com.technologica.registration.dynamic.TechnologicaDamageTypes;
import com.tlregen.api.resourcegen.assets.TLReGenLang;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.item.Item;
import net.minecraftforge.registries.RegistryObject;

public class TLLang extends TLReGenLang {
	@Override
	protected void populate() {
		add("advancements.stone_age.root.title", "Stone Age");
		add("advancements.stone_age.root.description", "We're all so glad you could join us");

		add("advancements.stone_age.discover_fire.title", "Ow! Heat was hot!");
		add("advancements.stone_age.discover_fire.description", "Discover fire");
		add("advancements.stone_age.make_fire.title", "Promethean Prodigy");
		add("advancements.stone_age.make_fire.description", "Start a fire with a bow drill");
		add("advancements.stone_age.light_campfire.title", "Camper");
		add("advancements.stone_age.light_campfire.description", "Light a campfire");
		add("advancements.stone_age.cook_meat.title", "Well Done");
		add("advancements.stone_age.cook_meat.description", "Cook food on a campfire");

		add("advancements.stone_age.discover_stick.title", "Sticks and Stone Age");
		add("advancements.stone_age.discover_stick.description", "Break some leaves to get a stick");
		add("advancements.stone_age.crude_saw.title", "I Saw That");
		add("advancements.stone_age.crude_saw.description", "Craft a crude saw from bone and flint");
		add("advancements.stone_age.discover_wood.title", "Logger");
		add("advancements.stone_age.discover_wood.description", "Chop down a tree using a tool");
		add("advancements.stone_age.craft_planks.title", "Carpenter");
		add("advancements.stone_age.craft_planks.description", "Craft planks using a saw");
		add("advancements.stone_age.board_boat.title", "Embark");
		add("advancements.stone_age.board_boat.description", "Board a boat");

		add("advancements.stone_age.discover_flint.title", "Hard Rock");
		add("advancements.stone_age.discover_flint.description", "Discover flint");
		add("advancements.stone_age.dawn_of_man.title", "Dawn of Man");
		add("advancements.stone_age.dawn_of_man.description", "Craft a primitive tool");

		add("advancements.stone_age.discover_clay.title", "Soft Rock");
		add("advancements.stone_age.discover_clay.description", "Discover clay");
		add("advancements.stone_age.make_jar.title", "Download the jar");
		add("advancements.stone_age.make_jar.description", "Fire a clay jar into a cermaic jar");
		add("advancements.stone_age.collect_water.title", "Portable Potables");
		add("advancements.stone_age.collect_water.description", "Collect water in a ceramic jar");

		add("advancements.stone_age.hunter.title", "Hunter");
		add("advancements.stone_age.hunter.description", "Slay an animal");
		add("advancements.stone_age.breed_animal.title", "Reproducible");
		add("advancements.stone_age.breed_animal.description", "Breed an animal");
		add("advancements.stone_age.tame_animal.title", "Domesticator");
		add("advancements.stone_age.tame_animal.description", "Tame an animal");
		add("advancements.stone_age.archery.title", "Archer");
		add("advancements.stone_age.archery.description", "Slay an animal with a bow and arrow");
		add("advancements.stone_age.fishing.title", "Angler");
		add("advancements.stone_age.fishing.description", "Catch a fish with a fishing rod");

		add("advancements.stone_age.gatherer.title", "Gatherer");
		add("advancements.stone_age.gatherer.description", "Harvest naturally growing food");
		add("advancements.stone_age.plant_crops.title", "Replenishable");
		add("advancements.stone_age.plant_crops.description", "Plant crops");
		add("advancements.stone_age.discover_mulch.title", "So Mulch to Do");
		add("advancements.stone_age.discover_mulch.description", "Strip a log to get mulch");
		add("advancements.stone_age.use_mulch.title", "So Mulch to See");
		add("advancements.stone_age.use_mulch.description", "Use mulch to accelerate fruit tree growth");

		add("commands.weather.set.meteor_storm", "Set the weather to meteor storm");

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

	private final void addItems(Collection<RegistryObject<Item>> collection) {
		for (Supplier<? extends Item> item : collection) {
			addItem(item, keyToValue(item.get().getDescriptionId()));
		}
	}

	private final void addEntities(Collection<RegistryObject<EntityType<?>>> collection) {
		for (Supplier<? extends EntityType<?>> entity : collection) {
			addEntityType(entity, keyToValue(entity.get().getDescriptionId()));
		}
	}

	private String keyToValue(String key) {
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
