package com.technologica.data;

import com.technologica.Technologica;
import com.technologica.items.ModItems;

import net.minecraft.data.BlockTagsProvider;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.ItemTagsProvider;
import net.minecraft.tags.ItemTags;
import net.minecraftforge.common.data.ExistingFileHelper;

public class ModItemTagsProvider extends ItemTagsProvider {

	public ModItemTagsProvider(DataGenerator generatorIn, BlockTagsProvider blockTagProvider, ExistingFileHelper helperIn) {
		super(generatorIn, blockTagProvider, Technologica.MODID, helperIn);
	}
	
	@Override
	protected void registerTags() {
		getOrCreateBuilder(ItemTags.SAPLINGS).add(
				ModItems.BANANA_SAPLING_ITEM.get(),
				ModItems.CHERRY_SAPLING_ITEM.get(),
				ModItems.COCONUT_SAPLING_ITEM.get(),
				ModItems.KIWI_SAPLING_ITEM.get(),
				ModItems.LEMON_SAPLING_ITEM.get(),
				ModItems.LIME_SAPLING_ITEM.get(),
				ModItems.ORANGE_SAPLING_ITEM.get(),
				ModItems.PEACH_SAPLING_ITEM.get(),
				ModItems.PEAR_SAPLING_ITEM.get());
		getOrCreateBuilder(ItemTags.LOGS_THAT_BURN).add(
				ModItems.BANANA_LOG_ITEM.get(),
				ModItems.CHERRY_LOG_ITEM.get(),
				ModItems.COCONUT_LOG_ITEM.get(),
				ModItems.KIWI_LOG_ITEM.get(),
				ModItems.LEMON_LOG_ITEM.get(),
				ModItems.LIME_LOG_ITEM.get(),
				ModItems.ORANGE_LOG_ITEM.get(),
				ModItems.PEACH_LOG_ITEM.get(),
				ModItems.PEAR_LOG_ITEM.get());
		getOrCreateBuilder(ItemTags.LEAVES).add(
				ModItems.BANANA_LEAVES_ITEM.get(), 
				ModItems.CHERRY_LEAVES_ITEM.get(), 
				ModItems.COCONUT_LEAVES_ITEM.get(), 
				ModItems.KIWI_LEAVES_ITEM.get(), 
				ModItems.LEMON_LEAVES_ITEM.get(), 
				ModItems.LIME_LEAVES_ITEM.get(),
				ModItems.ORANGE_LEAVES_ITEM.get(),
				ModItems.PEACH_LEAVES_ITEM.get(),
				ModItems.PEAR_LEAVES_ITEM.get());
	}
}