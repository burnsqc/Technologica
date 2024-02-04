package com.technologica.resourcegen.assets.lang;

import java.util.Collection;
import java.util.function.Supplier;

import com.technologica.Technologica;
import com.technologica.registration.deferred.TechnologicaEntityTypes;
import com.technologica.registration.deferred.TechnologicaItems;

import net.minecraft.data.PackOutput;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.item.Item;
import net.minecraftforge.common.data.LanguageProvider;
import net.minecraftforge.registries.RegistryObject;

public class LanguageDataGenerator extends LanguageProvider {

	public LanguageDataGenerator(PackOutput generatorIn) {
		super(generatorIn, Technologica.MOD_ID, "en_us");
	}

	@Override
	protected void addTranslations() {
		addItems(TechnologicaItems.ITEMS.getEntries());
		addEntities(TechnologicaEntityTypes.ENTITY_TYPES.getEntries());

		add("item_group." + Technologica.MOD_ID + ".flora", "Flora");
		add("item_group." + Technologica.MOD_ID + ".fauna", "Fauna");
		add("item_group." + Technologica.MOD_ID + ".mineral", "Mineral");
		add("item_group." + Technologica.MOD_ID + ".food", "Food");
		add("item_group." + Technologica.MOD_ID + ".construction", "Construction");
		add("item_group." + Technologica.MOD_ID + ".machinery", "Machinery");
		add("item_group." + Technologica.MOD_ID + ".decorative", "Decorative");
		add("item_group." + Technologica.MOD_ID + ".armory", "Armory");
		add("item_group." + Technologica.MOD_ID + ".cryptica", "Cryptica");

		add("death.attack.jostled_the_nitro", "%1$s jostled the nitro");
		add("death.attack.jostled_the_nitro.player", "%1$s jostled the nitro whilst fighting %2$s");
		add("death.attack.bled_out", "%1$s bled out");
		add("death.attack.bled_out.player", "%1$s bled out whilst fighting %2$s");

		add("effect.technologica.hallucination", "Hallucination");
		add("effect.technologica.hemorrhage", "Hemorrhage");
		add("effect.technologica.lifesight", "Lifesight");
		add("effect.technologica.necrosis", "Necrosis");
		add("effect.technologica.paralysis", "Paralysis");
		add("effect.technologica.radiation", "Radiation");

		add("advancements.tribulation.root.title", "Tribulation");
		add("advancements.tribulation.root.description", "May you maintain your resolve in the face of great adversity");
		add("advancements.tribulation.a_sign_of_things_to_come.title", "A Sign of Things to Come");
		add("advancements.tribulation.a_sign_of_things_to_come.description", "This first lesson is to set your expectations.");

		add("commands.weather.set.meteor_storm", "Set the weather to meteor storm");
	}

	/**
	 * Iterates through a deferred register, adding each entry to the en_us.json file.
	 * 
	 * @param collection a collection of deferred register entries
	 */

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

	/**
	 * Converts the input string "key" into an output string to be used as the value for the en_us.json file entry. This only works as intended if the registry entry name is an exact snake case version of the name to be displayed in-game.
	 * 
	 * @param key the string
	 * @return the string to be used as the value for the en_us.json file entry.
	 */

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

	@Override
	public String getName() {
		return "Languages - en_us: " + Technologica.MOD_ID;
	}
}