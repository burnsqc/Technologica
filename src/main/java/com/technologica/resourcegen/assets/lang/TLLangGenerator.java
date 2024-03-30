package com.technologica.resourcegen.assets.lang;

import java.util.Collection;
import java.util.function.Supplier;

import com.technologica.Technologica;
import com.technologica.api.tlregen.resourcegen.TLReGenAssetsLang;
import com.technologica.registration.deferred.TechnologicaCreativeModeTabs;
import com.technologica.registration.deferred.TechnologicaEntityTypes;
import com.technologica.registration.deferred.TechnologicaItems;
import com.technologica.registration.deferred.TechnologicaMobEffects;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.item.Item;
import net.minecraftforge.registries.RegistryObject;

public class TLLangGenerator extends TLReGenAssetsLang {
	@Override
	protected void populate() {
		addItems(TechnologicaItems.ITEMS.getEntries());
		addEntities(TechnologicaEntityTypes.ENTITY_TYPES.getEntries());

		add("ddeath.attack.jostled_the_nitro", "%1$s jostled the nitro");
		add("death.attack.jostled_the_nitro.player", "%1$s jostled the nitro whilst fighting %2$s");
		add("death.attack.bled_out", "%1$s bled out");
		add("death.attack.bled_out.player", "%1$s bled out whilst fighting %2$s");

		addEffect(TechnologicaMobEffects.HALLUCINIATION, "Hallucination");
		addEffect(TechnologicaMobEffects.HEMORRHAGE, "Hemorrhage");
		addEffect(TechnologicaMobEffects.LIFESIGHT, "Lifesight");
		addEffect(TechnologicaMobEffects.NECROSIS, "Necrosis");
		addEffect(TechnologicaMobEffects.NEUROPATHY, "Neuropathy");
		addEffect(TechnologicaMobEffects.PARALYSIS, "Paralysis");
		addEffect(TechnologicaMobEffects.RADIATION, "Radiation");

		addItemGroup(TechnologicaCreativeModeTabs.FLORA, "Flora");
		addItemGroup(TechnologicaCreativeModeTabs.FAUNA, "Fauna");
		addItemGroup(TechnologicaCreativeModeTabs.MINERAL, "Mineral");
		addItemGroup(TechnologicaCreativeModeTabs.FOOD, "Food");
		addItemGroup(TechnologicaCreativeModeTabs.CONSTRUCTION, "Construction");
		addItemGroup(TechnologicaCreativeModeTabs.MACHINERY, "Machinery");
		addItemGroup(TechnologicaCreativeModeTabs.DECORATIVE, "Decorative");
		addItemGroup(TechnologicaCreativeModeTabs.ARMORY, "Armory");
		addItemGroup(TechnologicaCreativeModeTabs.CRYPTICA, "Cryptica");

		add("advancements.tribulation.root.title", "Tribulation");
		add("advancements.tribulation.root.description", "May you maintain your resolve in the face of great adversity");
		add("advancements.tribulation.a_sign_of_things_to_come.title", "A Sign of Things to Come");
		add("advancements.tribulation.a_sign_of_things_to_come.description", "This first lesson is to set your expectations.");

		add("commands.weather.set.meteor_storm", "Set the weather to meteor storm");
	}

	private final void addItems(Collection<RegistryObject<Item>> collection) {
		for (Supplier<? extends Item> item : collection) {
			String key = item.get().getDescriptionId();
			add(key, keyToValue(key));
		}
	}

	private final void addEntities(Collection<RegistryObject<EntityType<?>>> collection) {
		for (Supplier<? extends EntityType<?>> item : collection) {
			String key = item.get().getDescriptionId();
			add(key, keyToValue(key));
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
