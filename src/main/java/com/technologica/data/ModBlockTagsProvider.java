package com.technologica.data;

import java.util.Collection;
import java.util.function.Supplier;

import com.technologica.Technologica;
import com.technologica.block.TechnologicaBlocks;

import net.minecraft.block.Block;
import net.minecraft.data.BlockTagsProvider;
import net.minecraft.data.DataGenerator;
import net.minecraft.tags.BlockTags;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.fml.RegistryObject;

public class ModBlockTagsProvider extends BlockTagsProvider {

	public ModBlockTagsProvider(DataGenerator generatorIn, ExistingFileHelper helperIn) {
		super(generatorIn, Technologica.MODID, helperIn);
	}	
	
	@Override
	protected void registerTags() {
		automaticBlockTags(TechnologicaBlocks.BLOCKS.getEntries());
	}
	
	/**
	 * Iterates through a deferred register of blocks, adding entries to tag files based upon translation key content.
	 * This only works if the translation keys are consistent.  This is really only intended to work for mod blocks which are similar to vanilla.
	 * This saves a lot of time when adding one new tree which leads to logs, leaves, planks, stairs, doors, etc. 
	 * @param collection a collection of deferred register block entries
	 */
	
	private final void automaticBlockTags(Collection<RegistryObject<Block>> collection) {
		for(Supplier<? extends Block> blockSupplier:collection) {
			Block block = blockSupplier.get();
			
			if (block.getRegistryName().getPath().contains("crop")) getOrCreateBuilder(BlockTags.CROPS).add(block);
			else if (block.getRegistryName().getPath().contains("clay")) getOrCreateBuilder(BlockTags.ENDERMAN_HOLDABLE).add(block);
			else if (block.getRegistryName().getPath().contains("fence_gate")) getOrCreateBuilder(BlockTags.FENCE_GATES).add(block);
			else if (block.getRegistryName().getPath().contains("potted")) getOrCreateBuilder(BlockTags.FLOWER_POTS).add(block);
			else if (block.getRegistryName().getPath().contains("leaves")) getOrCreateBuilder(BlockTags.LEAVES).add(block);
			else if (block.getRegistryName().getPath().contains("log")) getOrCreateBuilder(BlockTags.LOGS_THAT_BURN).add(block);
//			else if (block.getRegistryName().getPath().contains("clay")) getOrCreateBuilder(BlockTags.LUSH_GROUND_REPLACEABLE).add(block);
			else if (block.getRegistryName().getPath().contains("planks")) getOrCreateBuilder(BlockTags.PLANKS).add(block);
			else if (block.getRegistryName().getPath().contains("sapling") && !block.getRegistryName().getPath().contains("potted")) getOrCreateBuilder(BlockTags.SAPLINGS).add(block);
//			else if (block.getRegistryName().getPath().contains("clay")) getOrCreateBuilder(BlockTags.SMALL_DRIPLEAF_PLACEABLE).add(block);
			else if (block.getRegistryName().getPath().contains("sign") && !block.getRegistryName().getPath().contains("wall")) getOrCreateBuilder(BlockTags.STANDING_SIGNS).add(block);
			else if (block.getRegistryName().getPath().contains("wall_sign")) getOrCreateBuilder(BlockTags.WALL_SIGNS).add(block);
			else if (block.getRegistryName().getPath().contains("button")) getOrCreateBuilder(BlockTags.WOODEN_BUTTONS).add(block);
			else if (block.getRegistryName().getPath().contains("door") && !block.getRegistryName().getPath().contains("trap")) getOrCreateBuilder(BlockTags.WOODEN_DOORS).add(block);
			else if (block.getRegistryName().getPath().contains("fence") && !block.getRegistryName().getPath().contains("gate")) getOrCreateBuilder(BlockTags.WOODEN_FENCES).add(block);
			else if (block.getRegistryName().getPath().contains("pressure_plate")) getOrCreateBuilder(BlockTags.WOODEN_PRESSURE_PLATES).add(block);
			else if (block.getRegistryName().getPath().contains("slab")) getOrCreateBuilder(BlockTags.WOODEN_SLABS).add(block);
			else if (block.getRegistryName().getPath().contains("stairs")) getOrCreateBuilder(BlockTags.WOODEN_STAIRS).add(block);
			else if (block.getRegistryName().getPath().contains("trapdoor")) getOrCreateBuilder(BlockTags.WOODEN_TRAPDOORS).add(block);			
		}
	}
}