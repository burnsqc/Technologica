package com.technologica.data;

import java.util.Collection;
import java.util.function.Supplier;

import com.technologica.Technologica;
import com.technologica.items.ModItems;
import com.technologica.setup.ModItemGroup;

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
		addItem(ModItems.ITEMS.getEntries());
		
		addItemGroup(
			ModItemGroup.TECHNOLOGICA_FLORA,
			ModItemGroup.TECHNOLOGICA_FAUNA,
			ModItemGroup.TECHNOLOGICA_MINERAL,
			ModItemGroup.TECHNOLOGICA_FOOD,
			ModItemGroup.TECHNOLOGICA_MACHINERY,
			ModItemGroup.TECHNOLOGICA_DECORATIVE,
			ModItemGroup.TECHNOLOGICA_CRYPTICA
		);
	}
	
	private final void addItem(Collection<RegistryObject<Item>> collection) {
		for(Supplier<? extends Item> key:collection) {
			add(key.get().getTranslationKey(), pathToName(key.get().getTranslationKey()));
		}
	}
	
	private final void addItemGroup(ItemGroup... keys) {
		for(ItemGroup key:keys) {
			add("itemGroup." + key.getPath(), pathToName(key.getPath()));
		}
    }
	
	private String pathToName(String path) {
		String words[] = path.replaceAll("item." + Technologica.MODID + ".", "").replaceAll("block." + Technologica.MODID + ".", "").split("_");
		String name = "";
		for(String word:words ) {
			String first = word.substring(0,1);
			String afterFirst = word.substring(1);
			name+=first.toUpperCase()+afterFirst+" ";
		}
		return name.trim();
	}
}