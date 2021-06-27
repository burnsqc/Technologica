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
		getOrCreateBuilder(BlockTags.PLANKS).add(
				ModBlocks.BANANA_PLANKS.get(),
				ModBlocks.CHERRY_PLANKS.get(),
				ModBlocks.COCONUT_PLANKS.get(),
				ModBlocks.KIWI_PLANKS.get(),
				ModBlocks.LEMON_PLANKS.get(),
				ModBlocks.LIME_PLANKS.get(),
				ModBlocks.ORANGE_PLANKS.get(),
				ModBlocks.PEACH_PLANKS.get(),
				ModBlocks.PEAR_PLANKS.get());
		getOrCreateBuilder(BlockTags.WOODEN_TRAPDOORS).add(
				ModBlocks.BANANA_TRAPDOOR.get(),
	 			ModBlocks.CHERRY_TRAPDOOR.get(),
	 			ModBlocks.COCONUT_TRAPDOOR.get(),
	 			ModBlocks.KIWI_TRAPDOOR.get(),
	 			ModBlocks.LEMON_TRAPDOOR.get(),
	 			ModBlocks.LIME_TRAPDOOR.get(),
	 			ModBlocks.ORANGE_TRAPDOOR.get(),
	 			ModBlocks.PEACH_TRAPDOOR.get(),
	 			ModBlocks.PEAR_TRAPDOOR.get());
		getOrCreateBuilder(BlockTags.WOODEN_DOORS).add(
				ModBlocks.BANANA_DOOR.get(),
	 			ModBlocks.CHERRY_DOOR.get(),
	 			ModBlocks.COCONUT_DOOR.get(),
	 			ModBlocks.KIWI_DOOR.get(),
	 			ModBlocks.LEMON_DOOR.get(),
	 			ModBlocks.LIME_DOOR.get(),
	 			ModBlocks.ORANGE_DOOR.get(),
	 			ModBlocks.PEACH_DOOR.get(),
	 			ModBlocks.PEAR_DOOR.get());
		getOrCreateBuilder(BlockTags.WOODEN_FENCES).add(
				ModBlocks.BANANA_FENCE.get(),
	 			ModBlocks.CHERRY_FENCE.get(),
	 			ModBlocks.COCONUT_FENCE.get(),
	 			ModBlocks.KIWI_FENCE.get(),
	 			ModBlocks.LEMON_FENCE.get(),
	 			ModBlocks.LIME_FENCE.get(),
	 			ModBlocks.ORANGE_FENCE.get(),
	 			ModBlocks.PEACH_FENCE.get(),
	 			ModBlocks.PEAR_FENCE.get());
		getOrCreateBuilder(BlockTags.FENCE_GATES).add(
				ModBlocks.BANANA_FENCE_GATE.get(),
	 			ModBlocks.CHERRY_FENCE_GATE.get(),
	 			ModBlocks.COCONUT_FENCE_GATE.get(),
	 			ModBlocks.KIWI_FENCE_GATE.get(),
	 			ModBlocks.LEMON_FENCE_GATE.get(),
	 			ModBlocks.LIME_FENCE_GATE.get(),
	 			ModBlocks.ORANGE_FENCE_GATE.get(),
	 			ModBlocks.PEACH_FENCE_GATE.get(),
	 			ModBlocks.PEAR_FENCE_GATE.get());
	}
}