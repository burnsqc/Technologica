package com.technologica.data;

import com.technologica.Technologica;
import com.technologica.item.ModItems;

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
		getOrCreateBuilder(ItemTags.PLANKS).add(
				ModItems.BANANA_PLANKS_ITEM.get(),
				ModItems.CHERRY_PLANKS_ITEM.get(),
		        ModItems.COCONUT_PLANKS_ITEM.get(),
		        ModItems.KIWI_PLANKS_ITEM.get(),
		        ModItems.LEMON_PLANKS_ITEM.get(),
		        ModItems.LIME_PLANKS_ITEM.get(),
		        ModItems.ORANGE_PLANKS_ITEM.get(),
		        ModItems.PEACH_PLANKS_ITEM.get(),
		        ModItems.PEAR_PLANKS_ITEM.get());
		getOrCreateBuilder(ItemTags.WOODEN_TRAPDOORS).add(
				ModItems.BANANA_TRAPDOOR_ITEM.get(),
	 			ModItems.CHERRY_TRAPDOOR_ITEM.get(),
	 			ModItems.COCONUT_TRAPDOOR_ITEM.get(),
	 			ModItems.KIWI_TRAPDOOR_ITEM.get(),
	 			ModItems.LEMON_TRAPDOOR_ITEM.get(),
	 			ModItems.LIME_TRAPDOOR_ITEM.get(),
	 			ModItems.ORANGE_TRAPDOOR_ITEM.get(),
	 			ModItems.PEACH_TRAPDOOR_ITEM.get(),
	 			ModItems.PEAR_TRAPDOOR_ITEM.get());
		getOrCreateBuilder(ItemTags.WOODEN_DOORS).add(
				ModItems.BANANA_DOOR_ITEM.get(),
	 			ModItems.CHERRY_DOOR_ITEM.get(),
	 			ModItems.COCONUT_DOOR_ITEM.get(),
	 			ModItems.KIWI_DOOR_ITEM.get(),
	 			ModItems.LEMON_DOOR_ITEM.get(),
	 			ModItems.LIME_DOOR_ITEM.get(),
	 			ModItems.ORANGE_DOOR_ITEM.get(),
	 			ModItems.PEACH_DOOR_ITEM.get(),
	 			ModItems.PEAR_DOOR_ITEM.get());
		getOrCreateBuilder(ItemTags.WOODEN_FENCES).add(
				ModItems.BANANA_FENCE_ITEM.get(),
	 			ModItems.CHERRY_FENCE_ITEM.get(),
	 			ModItems.COCONUT_FENCE_ITEM.get(),
	 			ModItems.KIWI_FENCE_ITEM.get(),
	 			ModItems.LEMON_FENCE_ITEM.get(),
	 			ModItems.LIME_FENCE_ITEM.get(),
	 			ModItems.ORANGE_FENCE_ITEM.get(),
	 			ModItems.PEACH_FENCE_ITEM.get(),
	 			ModItems.PEAR_FENCE_ITEM.get());
	 			
	}
}