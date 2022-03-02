package com.technologica.data.tags;

import java.util.Collection;
import java.util.function.Supplier;

import com.technologica.Technologica;
import com.technologica.tags.TechnologicaBlockTags;
import com.technologica.tags.TechnologicaItemTags;
import com.technologica.world.item.TechnologicaItems;

import net.minecraft.data.DataGenerator;
import net.minecraft.data.tags.BlockTagsProvider;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.Item;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;

public class TechnologicaItemTagsProvider extends ItemTagsProvider {

	public TechnologicaItemTagsProvider(DataGenerator generatorIn, BlockTagsProvider blockTagProvider, ExistingFileHelper helperIn) {
		super(generatorIn, blockTagProvider, Technologica.MODID, helperIn);
	}
	
	@Override
	protected void addTags() {
		this.copy(BlockTags.PLANKS, ItemTags.PLANKS);
		copy(TechnologicaBlockTags.APRICOT_LOGS, TechnologicaItemTags.APRICOT_LOGS);
		copy(TechnologicaBlockTags.ASPEN_LOGS, TechnologicaItemTags.ASPEN_LOGS);
		copy(TechnologicaBlockTags.AVOCADO_LOGS, TechnologicaItemTags.AVOCADO_LOGS);
		copy(TechnologicaBlockTags.BANANA_LOGS, TechnologicaItemTags.BANANA_LOGS);
		copy(TechnologicaBlockTags.CHERRY_LOGS, TechnologicaItemTags.CHERRY_LOGS);
		copy(TechnologicaBlockTags.CHESTNUT_LOGS, TechnologicaItemTags.CHESTNUT_LOGS);
		copy(TechnologicaBlockTags.CINNAMON_LOGS, TechnologicaItemTags.CINNAMON_LOGS);
		copy(TechnologicaBlockTags.COCONUT_LOGS, TechnologicaItemTags.COCONUT_LOGS);
		copy(TechnologicaBlockTags.EBONY_LOGS, TechnologicaItemTags.EBONY_LOGS);
		copy(TechnologicaBlockTags.KIWI_LOGS, TechnologicaItemTags.KIWI_LOGS);
		copy(TechnologicaBlockTags.LEMON_LOGS, TechnologicaItemTags.LEMON_LOGS);
		copy(TechnologicaBlockTags.LIME_LOGS, TechnologicaItemTags.LIME_LOGS);
		copy(TechnologicaBlockTags.MAHOGANY_LOGS, TechnologicaItemTags.MAHOGANY_LOGS);
		copy(TechnologicaBlockTags.MAPLE_LOGS, TechnologicaItemTags.MAPLE_LOGS);
		copy(TechnologicaBlockTags.OLIVE_LOGS, TechnologicaItemTags.OLIVE_LOGS);
		copy(TechnologicaBlockTags.ORANGE_LOGS, TechnologicaItemTags.ORANGE_LOGS);
		copy(TechnologicaBlockTags.PEACH_LOGS, TechnologicaItemTags.PEACH_LOGS);
		copy(TechnologicaBlockTags.PEAR_LOGS, TechnologicaItemTags.PEAR_LOGS);
		copy(TechnologicaBlockTags.PLUM_LOGS, TechnologicaItemTags.PLUM_LOGS);
		copy(TechnologicaBlockTags.REDWOOD_LOGS, TechnologicaItemTags.REDWOOD_LOGS);
		copy(TechnologicaBlockTags.ROSEWOOD_LOGS, TechnologicaItemTags.ROSEWOOD_LOGS);
		copy(TechnologicaBlockTags.RUBBER_LOGS, TechnologicaItemTags.RUBBER_LOGS);
		copy(TechnologicaBlockTags.TEAK_LOGS, TechnologicaItemTags.TEAK_LOGS);
		copy(TechnologicaBlockTags.WALNUT_LOGS, TechnologicaItemTags.WALNUT_LOGS);
		copy(TechnologicaBlockTags.ZEBRAWOOD_LOGS, TechnologicaItemTags.ZEBRAWOOD_LOGS);
		copy(TechnologicaBlockTags.ALCHEMICAL_LOGS, TechnologicaItemTags.ALCHEMICAL_LOGS);
		copy(TechnologicaBlockTags.BENEVOLENT_LOGS, TechnologicaItemTags.BENEVOLENT_LOGS);
		copy(TechnologicaBlockTags.CONDUCTIVE_LOGS, TechnologicaItemTags.CONDUCTIVE_LOGS);
		copy(TechnologicaBlockTags.FROSTBITTEN_LOGS, TechnologicaItemTags.FROSTBITTEN_LOGS);
		copy(TechnologicaBlockTags.FRUITFUL_LOGS, TechnologicaItemTags.FRUITFUL_LOGS);
		copy(TechnologicaBlockTags.INFERNAL_LOGS, TechnologicaItemTags.INFERNAL_LOGS);
		copy(TechnologicaBlockTags.MALEVOLENT_LOGS, TechnologicaItemTags.MALEVOLENT_LOGS);
		
		automaticItemTags(TechnologicaItems.ITEMS.getEntries());
	}
	
	/**
	 * Iterates through a deferred register of items, adding entries to tag files based upon translation key content.
	 * This only works if the translation keys are consistent.  This is really only intended to work for mod items which are similar to vanilla.
	 * This saves a lot of time when adding one new tree which leads to logs, leaves, planks, stairs, doors, etc. 
	 * @param collection a collection of deferred register item entries
	 */
	
	private final void automaticItemTags(Collection<RegistryObject<Item>> collection) {
		for(Supplier<? extends Item> itemSupplier:collection) {
			Item item = itemSupplier.get();
			
			if (item.getRegistryName().getPath().contains("boat")) tag(ItemTags.BOATS).add(item);
			else if (item.getRegistryName().getPath().contains("leaves")) tag(ItemTags.LEAVES).add(item);
			else if (item.getRegistryName().getPath().contains("log")) tag(ItemTags.LOGS_THAT_BURN).add(item);
			
			else if (item.getRegistryName().getPath().contains("sapling")) tag(ItemTags.SAPLINGS).add(item);
			else if (item.getRegistryName().getPath().contains("sign")) tag(ItemTags.SIGNS).add(item);
			else if (item.getRegistryName().getPath().contains("button")) tag(ItemTags.WOODEN_BUTTONS).add(item);
			else if (item.getRegistryName().getPath().contains("door") && !item.getRegistryName().getPath().contains("trap")) tag(ItemTags.WOODEN_DOORS).add(item);
			else if (item.getRegistryName().getPath().contains("fence") && !item.getRegistryName().getPath().contains("gate")) tag(ItemTags.WOODEN_FENCES).add(item);
			else if (item.getRegistryName().getPath().contains("pressure_plate")) tag(ItemTags.WOODEN_PRESSURE_PLATES).add(item);
			else if (item.getRegistryName().getPath().contains("slab")) tag(ItemTags.WOODEN_SLABS).add(item);
			else if (item.getRegistryName().getPath().contains("stairs")) tag(ItemTags.WOODEN_STAIRS).add(item);
			else if (item.getRegistryName().getPath().contains("trapdoor")) tag(ItemTags.WOODEN_TRAPDOORS).add(item); 
		}
	}
}