package com.technologica.data;

import java.util.Collection;
import java.util.function.Supplier;

import com.technologica.Technologica;
import com.technologica.item.ModItems;

import net.minecraft.data.BlockTagsProvider;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.ItemTagsProvider;
import net.minecraft.item.Item;
import net.minecraft.tags.ItemTags;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.fml.RegistryObject;

public class ModItemTagsProvider extends ItemTagsProvider {

	public ModItemTagsProvider(DataGenerator generatorIn, BlockTagsProvider blockTagProvider, ExistingFileHelper helperIn) {
		super(generatorIn, blockTagProvider, Technologica.MODID, helperIn);
	}
	
	@Override
	protected void registerTags() {
		automaticItemTags(ModItems.ITEMS.getEntries());
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
			
			if (item.getRegistryName().getPath().contains("boat")) getOrCreateBuilder(ItemTags.BOATS).add(item);
			else if (item.getRegistryName().getPath().contains("leaves")) getOrCreateBuilder(ItemTags.LEAVES).add(item);
			else if (item.getRegistryName().getPath().contains("log")) getOrCreateBuilder(ItemTags.LOGS_THAT_BURN).add(item);
			else if (item.getRegistryName().getPath().contains("planks")) getOrCreateBuilder(ItemTags.PLANKS).add(item);
			else if (item.getRegistryName().getPath().contains("sapling")) getOrCreateBuilder(ItemTags.SAPLINGS).add(item);
			else if (item.getRegistryName().getPath().contains("sign")) getOrCreateBuilder(ItemTags.SIGNS).add(item);
			else if (item.getRegistryName().getPath().contains("button")) getOrCreateBuilder(ItemTags.WOODEN_BUTTONS).add(item);
			else if (item.getRegistryName().getPath().contains("door") && !item.getRegistryName().getPath().contains("trap")) getOrCreateBuilder(ItemTags.WOODEN_DOORS).add(item);
			else if (item.getRegistryName().getPath().contains("fence") && !item.getRegistryName().getPath().contains("gate")) getOrCreateBuilder(ItemTags.WOODEN_FENCES).add(item);
			else if (item.getRegistryName().getPath().contains("pressure_plate")) getOrCreateBuilder(ItemTags.WOODEN_PRESSURE_PLATES).add(item);
			else if (item.getRegistryName().getPath().contains("slab")) getOrCreateBuilder(ItemTags.WOODEN_SLABS).add(item);
			else if (item.getRegistryName().getPath().contains("stairs")) getOrCreateBuilder(ItemTags.WOODEN_STAIRS).add(item);
			else if (item.getRegistryName().getPath().contains("trapdoor")) getOrCreateBuilder(ItemTags.WOODEN_TRAPDOORS).add(item); 
		}
	}
}