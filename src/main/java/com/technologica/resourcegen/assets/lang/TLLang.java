package com.technologica.resourcegen.assets.lang;

import java.util.Collection;
import java.util.function.Supplier;

import com.technologica.Technologica;
import com.technologica.api.tlregen.resourcegen.assets.TLReGenLang;
import com.technologica.registration.deferred.TechnologicaCreativeModeTabs;
import com.technologica.registration.deferred.TechnologicaEntityTypes;
import com.technologica.registration.deferred.TechnologicaItems;
import com.technologica.registration.deferred.TechnologicaMobEffects;
import com.technologica.registration.key.TechnologicaDamageTypes;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.item.Item;
import net.minecraftforge.registries.RegistryObject;

public class TLLang extends TLReGenLang {
	@Override
	protected void populate() {
		add("advancements.tribulation.root.title", "Tribulation");
		add("advancements.tribulation.root.description", "May you maintain your resolve in the face of great adversity");
		add("advancements.tribulation.a_sign_of_things_to_come.title", "A Sign of Things to Come");
		add("advancements.tribulation.a_sign_of_things_to_come.description", "This first lesson is to set your expectations.");

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

		addEntities(TechnologicaEntityTypes.ENTITY_TYPES.getEntries());

		addItems(TechnologicaItems.ITEMS.getEntries());

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
