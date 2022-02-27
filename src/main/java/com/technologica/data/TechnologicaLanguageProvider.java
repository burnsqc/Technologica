package com.technologica.data;

import java.util.Collection;
import java.util.function.Supplier;

import com.technologica.Technologica;
import com.technologica.world.entity.TechnologicaEntityType;
import com.technologica.world.item.TechnologicaItemGroup;
import com.technologica.world.item.TechnologicaItems;

import net.minecraft.data.DataGenerator;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraftforge.common.data.LanguageProvider;
import net.minecraftforge.registries.RegistryObject;

public class TechnologicaLanguageProvider extends LanguageProvider {
	
	public TechnologicaLanguageProvider(DataGenerator generatorIn) {
		super(generatorIn, Technologica.MODID, "en_us");
	}

	@Override
	protected void addTranslations() {
		addItems(TechnologicaItems.ITEMS.getEntries());
		addEntities(TechnologicaEntityType.ENTITIES.getEntries());
		
		addItemGroups(
			TechnologicaItemGroup.FLORA,
			TechnologicaItemGroup.FAUNA,
			TechnologicaItemGroup.MINERAL,
			TechnologicaItemGroup.FOOD,
			TechnologicaItemGroup.CONSTRUCTION,
			TechnologicaItemGroup.MACHINERY,
			TechnologicaItemGroup.DECORATIVE,
			TechnologicaItemGroup.ARMORY,
			TechnologicaItemGroup.CRYPTICA
		);
	}
	
	/**
	 * Iterates through a deferred register, adding each entry to the en_us.json file.
	 * @param collection a collection of deferred register entries
	 */
	
	private final void addItems(Collection<RegistryObject<Item>> collection) {
		for(Supplier<? extends Item> item:collection) {
			String key = item.get().getDescriptionId();
			add(key, keyToValue(key));
		}
	}
	
	private final void addEntities(Collection<RegistryObject<EntityType<?>>> collection) {
		for(Supplier<? extends EntityType<?>> item:collection) {
			String key = item.get().getDescriptionId();
			add(key, keyToValue(key));
		}
	}
	
	/**
	 * Iterates through vararg item groups, adding each entry to the en_us.json file.
	 * @param itemGroups varargs list of item groups
	 */
	
	private final void addItemGroups(CreativeModeTab... itemGroups) {
		for(CreativeModeTab itemGroup:itemGroups) {
			String key = itemGroup.getRecipeFolderName();
			add("itemGroup." + key, keyToValue(key));
		}
    }
	
	/**
	 * Converts the input string "key" into an output string to be used as the value for the en_us.json file entry.
	 * This only works as intended if the registry entry name is an exact snake case version of the name to be displayed in-game.   
	 * @param key the string
	 * @return the string to be used as the value for the en_us.json file entry.
	 */
	
	private String keyToValue(String key) {
		String words[] = key.replaceAll("item." + Technologica.MODID + ".", "").replaceAll("block." + Technologica.MODID + ".", "").replaceAll("entity." + Technologica.MODID + ".", "").split("_");
		String name = "";
		for(String word:words ) {
			String first = word.substring(0,1);
			String afterFirst = word.substring(1);
			name+=first.toUpperCase()+afterFirst+" ";
		}
		return name.trim();
	}
}