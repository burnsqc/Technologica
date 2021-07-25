package com.technologica.data;

import java.util.Collection;
import java.util.function.Supplier;

import com.technologica.Technologica;
import com.technologica.block.ModBlocks;

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
		automaticBlockTags(ModBlocks.BLOCKS.getEntries());
	}
	
	private final void automaticBlockTags(Collection<RegistryObject<Block>> collection) {
		for(Supplier<? extends Block> blockSupplier:collection) {
			Block block = blockSupplier.get();
			
			if (block.getRegistryName().getPath().contains("crop")) {
				getOrCreateBuilder(BlockTags.CROPS).add(block);
			} else if (block.getRegistryName().getPath().contains("gate")) {
				getOrCreateBuilder(BlockTags.FENCE_GATES).add(block);
			} else if (block.getRegistryName().getPath().contains("potted")) {
				getOrCreateBuilder(BlockTags.FLOWER_POTS).add(block);
			} else if (block.getRegistryName().getPath().contains("leaves")) {
				getOrCreateBuilder(BlockTags.LEAVES).add(block);
			} else if (block.getRegistryName().getPath().contains("log")) {
				getOrCreateBuilder(BlockTags.LOGS_THAT_BURN).add(block);
			} else if (block.getRegistryName().getPath().contains("planks")) {
				getOrCreateBuilder(BlockTags.PLANKS).add(block);
			} else if (block.getRegistryName().getPath().contains("sapling")) {
				getOrCreateBuilder(BlockTags.SAPLINGS).add(block);
			} else if (block.getRegistryName().getPath().contains("door") && !block.getRegistryName().getPath().contains("trap")) {
				getOrCreateBuilder(BlockTags.WOODEN_DOORS).add(block);
			} else if (block.getRegistryName().getPath().contains("fence") && !block.getRegistryName().getPath().contains("gate")) {
				getOrCreateBuilder(BlockTags.WOODEN_FENCES).add(block);
			} else if (block.getRegistryName().getPath().contains("slab")) {
				getOrCreateBuilder(BlockTags.WOODEN_SLABS).add(block);
			} else if (block.getRegistryName().getPath().contains("stairs")) {
				getOrCreateBuilder(BlockTags.WOODEN_STAIRS).add(block);
			} else if (block.getRegistryName().getPath().contains("trapdoor")) {
				getOrCreateBuilder(BlockTags.WOODEN_TRAPDOORS).add(block);
			} 
		}
	}
}