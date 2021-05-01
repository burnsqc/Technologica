package com.technologica.data;

import com.technologica.MainMod;
import com.technologica.setup.Registration;

import net.minecraft.data.BlockTagsProvider;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.ItemTagsProvider;
import net.minecraft.tags.ItemTags;
import net.minecraftforge.common.data.ExistingFileHelper;

public class ModItemTagsProvider extends ItemTagsProvider {

	public ModItemTagsProvider(DataGenerator generatorIn, BlockTagsProvider blockTagProvider, ExistingFileHelper helperIn) {
		super(generatorIn, blockTagProvider, MainMod.MODID, helperIn);
	}
	
	@Override
	protected void registerTags() {
		getOrCreateBuilder(ItemTags.SAPLINGS).add(
				Registration.BANANA_SAPLING_ITEM.get(),
				Registration.CHERRY_SAPLING_ITEM.get(),
				Registration.COCONUT_SAPLING_ITEM.get(),
				Registration.KIWI_SAPLING_ITEM.get(),
				Registration.LEMON_SAPLING_ITEM.get(),
				Registration.LIME_SAPLING_ITEM.get(),
				Registration.ORANGE_SAPLING_ITEM.get(),
				Registration.PEACH_SAPLING_ITEM.get(),
				Registration.PEAR_SAPLING_ITEM.get());
		getOrCreateBuilder(ItemTags.LOGS_THAT_BURN).add(
				Registration.BANANA_LOG_ITEM.get(),
				Registration.CHERRY_LOG_ITEM.get(),
				Registration.COCONUT_LOG_ITEM.get(),
				Registration.KIWI_LOG_ITEM.get(),
				Registration.LEMON_LOG_ITEM.get(),
				Registration.LIME_LOG_ITEM.get(),
				Registration.ORANGE_LOG_ITEM.get(),
				Registration.PEACH_LOG_ITEM.get(),
				Registration.PEAR_LOG_ITEM.get());
		getOrCreateBuilder(ItemTags.LEAVES).add(
				Registration.BANANA_LEAVES_ITEM.get(), 
				Registration.CHERRY_LEAVES_ITEM.get(), 
				Registration.COCONUT_LEAVES_ITEM.get(), 
				Registration.KIWI_LEAVES_ITEM.get(), 
				Registration.LEMON_LEAVES_ITEM.get(), 
				Registration.LIME_LEAVES_ITEM.get(),
				Registration.ORANGE_LEAVES_ITEM.get(),
				Registration.PEACH_LEAVES_ITEM.get(),
				Registration.PEAR_LEAVES_ITEM.get());
	}
}