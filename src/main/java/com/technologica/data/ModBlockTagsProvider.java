package com.technologica.data;

import com.technologica.MainMod;
import com.technologica.setup.Registration;

import net.minecraft.data.BlockTagsProvider;
import net.minecraft.data.DataGenerator;
import net.minecraft.tags.BlockTags;
import net.minecraftforge.common.data.ExistingFileHelper;

public class ModBlockTagsProvider extends BlockTagsProvider {

	public ModBlockTagsProvider(DataGenerator generatorIn, ExistingFileHelper helperIn) {
		super(generatorIn, MainMod.MODID, helperIn);
	}	
	
	@Override
	protected void registerTags() {
		getOrCreateBuilder(BlockTags.SAPLINGS).add(
				Registration.BANANA_SAPLING.get(),
				Registration.CHERRY_SAPLING.get(),
				Registration.COCONUT_SAPLING.get(),
				Registration.KIWI_SAPLING.get(),
				Registration.LEMON_SAPLING.get(),
				Registration.LIME_SAPLING.get(),
				Registration.ORANGE_SAPLING.get(),
				Registration.PEACH_SAPLING.get(),
				Registration.PEAR_SAPLING.get());
		getOrCreateBuilder(BlockTags.LOGS_THAT_BURN).add(
				Registration.BANANA_LOG.get(),
				Registration.CHERRY_LOG.get(),
				Registration.COCONUT_LOG.get(),
				Registration.KIWI_LOG.get(),
				Registration.LEMON_LOG.get(),
				Registration.LIME_LOG.get(),
				Registration.ORANGE_LOG.get(),
				Registration.PEACH_LOG.get(),
				Registration.PEAR_LOG.get());
		getOrCreateBuilder(BlockTags.FLOWER_POTS).add(
				Registration.POTTED_BANANA_SAPLING.get(), 
				Registration.POTTED_CHERRY_SAPLING.get(), 
				Registration.POTTED_COCONUT_SAPLING.get(), 
				Registration.POTTED_KIWI_SAPLING.get(), 
				Registration.POTTED_LEMON_SAPLING.get(), 
				Registration.POTTED_LIME_SAPLING.get(),
				Registration.POTTED_ORANGE_SAPLING.get(),
				Registration.POTTED_PEACH_SAPLING.get(),
				Registration.POTTED_PEAR_SAPLING.get());
		getOrCreateBuilder(BlockTags.LEAVES).add(
				Registration.BANANA_LEAVES.get(), 
				Registration.CHERRY_LEAVES.get(), 
				Registration.COCONUT_LEAVES.get(), 
				Registration.KIWI_LEAVES.get(), 
				Registration.LEMON_LEAVES.get(), 
				Registration.LIME_LEAVES.get(),
				Registration.ORANGE_LEAVES.get(),
				Registration.PEACH_LEAVES.get(),
				Registration.PEAR_LEAVES.get());
	}
}