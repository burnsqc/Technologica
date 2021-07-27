package com.technologica.data;

import java.util.Collection;
import java.util.function.Supplier;

import com.technologica.Technologica;
import com.technologica.item.ModItemGroup;
import com.technologica.item.ModItems;

import net.minecraft.data.DataGenerator;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraftforge.common.data.LanguageProvider;
import net.minecraftforge.fml.RegistryObject;

public class ModLanguageProvider extends LanguageProvider {
	
	public ModLanguageProvider(DataGenerator generatorIn) {
		super(generatorIn, Technologica.MODID, "en_us");
	}

	@Override
	protected void addTranslations() {
		addItems(ModItems.ITEMS.getEntries());
		
		addItemGroups(
			ModItemGroup.FLORA,
			ModItemGroup.FAUNA,
			ModItemGroup.MINERAL,
			ModItemGroup.FOOD,
			ModItemGroup.CONSTRUCTION,
			ModItemGroup.MACHINERY,
			ModItemGroup.DECORATIVE,
			ModItemGroup.CRYPTICA
		);
	}
	
	/**
	 * Iterates through a deferred register, adding each entry to the en_us.json file.
	 * @param collection a collection of deferred register entries
	 */
	
	private final void addItems(Collection<RegistryObject<Item>> collection) {
		for(Supplier<? extends Item> item:collection) {
			String key = item.get().getTranslationKey();
			add(key, keyToValue(key));
		}
	}
	
	/**
	 * Iterates through vararg item groups, adding each entry to the en_us.json file.
	 * @param itemGroups varargs list of item groups
	 */
	
	private final void addItemGroups(ItemGroup... itemGroups) {
		for(ItemGroup itemGroup:itemGroups) {
			String key = itemGroup.getPath();
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
		String words[] = key.replaceAll("item." + Technologica.MODID + ".", "").replaceAll("block." + Technologica.MODID + ".", "").split("_");
		String name = "";
		for(String word:words ) {
			String first = word.substring(0,1);
			String afterFirst = word.substring(1);
			name+=first.toUpperCase()+afterFirst+" ";
		}
		return name.trim();
	}
}