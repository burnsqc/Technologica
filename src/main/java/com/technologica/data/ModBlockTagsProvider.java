package com.technologica.data;

import com.technologica.Technologica;
import com.technologica.block.ModBlocks;

import net.minecraft.data.BlockTagsProvider;
import net.minecraft.data.DataGenerator;
import net.minecraft.tags.BlockTags;
import net.minecraftforge.common.data.ExistingFileHelper;

public class ModBlockTagsProvider extends BlockTagsProvider {

	public ModBlockTagsProvider(DataGenerator generatorIn, ExistingFileHelper helperIn) {
		super(generatorIn, Technologica.MODID, helperIn);
	}	
	
	@Override
	protected void registerTags() {
		getOrCreateBuilder(BlockTags.SAPLINGS).add(
				ModBlocks.BANANA_SAPLING.get(),
				ModBlocks.CHERRY_SAPLING.get(),
				ModBlocks.COCONUT_SAPLING.get(),
				ModBlocks.KIWI_SAPLING.get(),
				ModBlocks.LEMON_SAPLING.get(),
				ModBlocks.LIME_SAPLING.get(),
				ModBlocks.ORANGE_SAPLING.get(),
				ModBlocks.PEACH_SAPLING.get(),
				ModBlocks.PEAR_SAPLING.get());
		getOrCreateBuilder(BlockTags.LOGS_THAT_BURN).add(
				ModBlocks.BANANA_LOG.get(),
				ModBlocks.CHERRY_LOG.get(),
				ModBlocks.COCONUT_LOG.get(),
				ModBlocks.KIWI_LOG.get(),
				ModBlocks.LEMON_LOG.get(),
				ModBlocks.LIME_LOG.get(),
				ModBlocks.ORANGE_LOG.get(),
				ModBlocks.PEACH_LOG.get(),
				ModBlocks.PEAR_LOG.get());
		getOrCreateBuilder(BlockTags.FLOWER_POTS).add(
				ModBlocks.POTTED_BANANA_SAPLING.get(), 
				ModBlocks.POTTED_CHERRY_SAPLING.get(), 
				ModBlocks.POTTED_COCONUT_SAPLING.get(), 
				ModBlocks.POTTED_KIWI_SAPLING.get(), 
				ModBlocks.POTTED_LEMON_SAPLING.get(), 
				ModBlocks.POTTED_LIME_SAPLING.get(),
				ModBlocks.POTTED_ORANGE_SAPLING.get(),
				ModBlocks.POTTED_PEACH_SAPLING.get(),
				ModBlocks.POTTED_PEAR_SAPLING.get());
		getOrCreateBuilder(BlockTags.LEAVES).add(
				ModBlocks.BANANA_LEAVES.get(), 
				ModBlocks.CHERRY_LEAVES.get(), 
				ModBlocks.COCONUT_LEAVES.get(), 
				ModBlocks.KIWI_LEAVES.get(), 
				ModBlocks.LEMON_LEAVES.get(), 
				ModBlocks.LIME_LEAVES.get(),
				ModBlocks.ORANGE_LEAVES.get(),
				ModBlocks.PEACH_LEAVES.get(),
				ModBlocks.PEAR_LEAVES.get());
	}
}