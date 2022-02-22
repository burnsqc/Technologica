package com.technologica.data;

import java.util.Collection;
import java.util.function.Supplier;

import com.technologica.Technologica;
import com.technologica.block.TechnologicaBlocks;
import com.technologica.tags.TechnologicaBlockTags;

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
	protected void addTags() {
		tag(TechnologicaBlockTags.APRICOT_LOGS).add(TechnologicaBlocks.APRICOT_LOG.get(), TechnologicaBlocks.APRICOT_WOOD.get(), TechnologicaBlocks.STRIPPED_APRICOT_LOG.get(), TechnologicaBlocks.STRIPPED_APRICOT_WOOD.get());
		tag(TechnologicaBlockTags.ASPEN_LOGS).add(TechnologicaBlocks.ASPEN_LOG.get(), TechnologicaBlocks.ASPEN_WOOD.get(), TechnologicaBlocks.STRIPPED_ASPEN_LOG.get(), TechnologicaBlocks.STRIPPED_ASPEN_WOOD.get());
		tag(TechnologicaBlockTags.AVOCADO_LOGS).add(TechnologicaBlocks.AVOCADO_LOG.get(), TechnologicaBlocks.AVOCADO_WOOD.get(), TechnologicaBlocks.STRIPPED_AVOCADO_LOG.get(), TechnologicaBlocks.STRIPPED_AVOCADO_WOOD.get());
		tag(TechnologicaBlockTags.BANANA_LOGS).add(TechnologicaBlocks.BANANA_LOG.get(), TechnologicaBlocks.BANANA_WOOD.get(), TechnologicaBlocks.STRIPPED_BANANA_LOG.get(), TechnologicaBlocks.STRIPPED_BANANA_WOOD.get());
		tag(TechnologicaBlockTags.CHERRY_LOGS).add(TechnologicaBlocks.CHERRY_LOG.get(), TechnologicaBlocks.CHERRY_WOOD.get(), TechnologicaBlocks.STRIPPED_CHERRY_LOG.get(), TechnologicaBlocks.STRIPPED_CHERRY_WOOD.get());
		tag(TechnologicaBlockTags.CHESTNUT_LOGS).add(TechnologicaBlocks.CHESTNUT_LOG.get(), TechnologicaBlocks.CHESTNUT_WOOD.get(), TechnologicaBlocks.STRIPPED_CHESTNUT_LOG.get(), TechnologicaBlocks.STRIPPED_CHESTNUT_WOOD.get());
		tag(TechnologicaBlockTags.CINNAMON_LOGS).add(TechnologicaBlocks.CINNAMON_LOG.get(), TechnologicaBlocks.CINNAMON_WOOD.get(), TechnologicaBlocks.STRIPPED_CINNAMON_LOG.get(), TechnologicaBlocks.STRIPPED_CINNAMON_WOOD.get());
		tag(TechnologicaBlockTags.COCONUT_LOGS).add(TechnologicaBlocks.COCONUT_LOG.get(), TechnologicaBlocks.COCONUT_WOOD.get(), TechnologicaBlocks.STRIPPED_COCONUT_LOG.get(), TechnologicaBlocks.STRIPPED_COCONUT_WOOD.get());
		tag(TechnologicaBlockTags.EBONY_LOGS).add(TechnologicaBlocks.EBONY_LOG.get(), TechnologicaBlocks.EBONY_WOOD.get(), TechnologicaBlocks.STRIPPED_EBONY_LOG.get(), TechnologicaBlocks.STRIPPED_EBONY_WOOD.get());
		tag(TechnologicaBlockTags.KIWI_LOGS).add(TechnologicaBlocks.KIWI_LOG.get(), TechnologicaBlocks.KIWI_WOOD.get(), TechnologicaBlocks.STRIPPED_KIWI_LOG.get(), TechnologicaBlocks.STRIPPED_KIWI_WOOD.get());
		tag(TechnologicaBlockTags.LEMON_LOGS).add(TechnologicaBlocks.LEMON_LOG.get(), TechnologicaBlocks.LEMON_WOOD.get(), TechnologicaBlocks.STRIPPED_LEMON_LOG.get(), TechnologicaBlocks.STRIPPED_LEMON_WOOD.get());
		tag(TechnologicaBlockTags.LIME_LOGS).add(TechnologicaBlocks.LIME_LOG.get(), TechnologicaBlocks.LIME_WOOD.get(), TechnologicaBlocks.STRIPPED_LIME_LOG.get(), TechnologicaBlocks.STRIPPED_LIME_WOOD.get());
		tag(TechnologicaBlockTags.MAHOGANY_LOGS).add(TechnologicaBlocks.MAHOGANY_LOG.get(), TechnologicaBlocks.MAHOGANY_WOOD.get(), TechnologicaBlocks.STRIPPED_MAHOGANY_LOG.get(), TechnologicaBlocks.STRIPPED_MAHOGANY_WOOD.get());
		tag(TechnologicaBlockTags.MAPLE_LOGS).add(TechnologicaBlocks.MAPLE_LOG.get(), TechnologicaBlocks.MAPLE_WOOD.get(), TechnologicaBlocks.STRIPPED_MAPLE_LOG.get(), TechnologicaBlocks.STRIPPED_MAPLE_WOOD.get());
		tag(TechnologicaBlockTags.OLIVE_LOGS).add(TechnologicaBlocks.OLIVE_LOG.get(), TechnologicaBlocks.OLIVE_WOOD.get(), TechnologicaBlocks.STRIPPED_OLIVE_LOG.get(), TechnologicaBlocks.STRIPPED_OLIVE_WOOD.get());
		tag(TechnologicaBlockTags.ORANGE_LOGS).add(TechnologicaBlocks.ORANGE_LOG.get(), TechnologicaBlocks.ORANGE_WOOD.get(), TechnologicaBlocks.STRIPPED_ORANGE_LOG.get(), TechnologicaBlocks.STRIPPED_ORANGE_WOOD.get());
		tag(TechnologicaBlockTags.PEACH_LOGS).add(TechnologicaBlocks.PEACH_LOG.get(), TechnologicaBlocks.PEACH_WOOD.get(), TechnologicaBlocks.STRIPPED_PEACH_LOG.get(), TechnologicaBlocks.STRIPPED_PEACH_WOOD.get());
		tag(TechnologicaBlockTags.PEAR_LOGS).add(TechnologicaBlocks.PEAR_LOG.get(), TechnologicaBlocks.PEAR_WOOD.get(), TechnologicaBlocks.STRIPPED_PEAR_LOG.get(), TechnologicaBlocks.STRIPPED_PEAR_WOOD.get());
		tag(TechnologicaBlockTags.PLUM_LOGS).add(TechnologicaBlocks.PLUM_LOG.get(), TechnologicaBlocks.PLUM_WOOD.get(), TechnologicaBlocks.STRIPPED_PLUM_LOG.get(), TechnologicaBlocks.STRIPPED_PLUM_WOOD.get());
		tag(TechnologicaBlockTags.REDWOOD_LOGS).add(TechnologicaBlocks.REDWOOD_LOG.get(), TechnologicaBlocks.REDWOOD_WOOD.get(), TechnologicaBlocks.STRIPPED_REDWOOD_LOG.get(), TechnologicaBlocks.STRIPPED_REDWOOD_WOOD.get());
		tag(TechnologicaBlockTags.ROSEWOOD_LOGS).add(TechnologicaBlocks.ROSEWOOD_LOG.get(), TechnologicaBlocks.ROSEWOOD_WOOD.get(), TechnologicaBlocks.STRIPPED_ROSEWOOD_LOG.get(), TechnologicaBlocks.STRIPPED_ROSEWOOD_WOOD.get());
		tag(TechnologicaBlockTags.RUBBER_LOGS).add(TechnologicaBlocks.RUBBER_LOG.get(), TechnologicaBlocks.RUBBER_WOOD.get(), TechnologicaBlocks.STRIPPED_RUBBER_LOG.get(), TechnologicaBlocks.STRIPPED_RUBBER_WOOD.get());
		tag(TechnologicaBlockTags.TEAK_LOGS).add(TechnologicaBlocks.TEAK_LOG.get(), TechnologicaBlocks.TEAK_WOOD.get(), TechnologicaBlocks.STRIPPED_TEAK_LOG.get(), TechnologicaBlocks.STRIPPED_TEAK_WOOD.get());
		tag(TechnologicaBlockTags.WALNUT_LOGS).add(TechnologicaBlocks.WALNUT_LOG.get(), TechnologicaBlocks.WALNUT_WOOD.get(), TechnologicaBlocks.STRIPPED_WALNUT_LOG.get(), TechnologicaBlocks.STRIPPED_WALNUT_WOOD.get());
		tag(TechnologicaBlockTags.ZEBRAWOOD_LOGS).add(TechnologicaBlocks.ZEBRAWOOD_LOG.get(), TechnologicaBlocks.ZEBRAWOOD_WOOD.get(), TechnologicaBlocks.STRIPPED_ZEBRAWOOD_LOG.get(), TechnologicaBlocks.STRIPPED_ZEBRAWOOD_WOOD.get());
		tag(TechnologicaBlockTags.ALCHEMICAL_LOGS).add(TechnologicaBlocks.ALCHEMICAL_LOG.get(), TechnologicaBlocks.ALCHEMICAL_WOOD.get(), TechnologicaBlocks.STRIPPED_ALCHEMICAL_LOG.get(), TechnologicaBlocks.STRIPPED_ALCHEMICAL_WOOD.get());
		tag(TechnologicaBlockTags.BENEVOLENT_LOGS).add(TechnologicaBlocks.BENEVOLENT_LOG.get(), TechnologicaBlocks.BENEVOLENT_WOOD.get(), TechnologicaBlocks.STRIPPED_BENEVOLENT_LOG.get(), TechnologicaBlocks.STRIPPED_BENEVOLENT_WOOD.get());
		tag(TechnologicaBlockTags.CONDUCTIVE_LOGS).add(TechnologicaBlocks.CONDUCTIVE_LOG.get(), TechnologicaBlocks.CONDUCTIVE_WOOD.get(), TechnologicaBlocks.STRIPPED_CONDUCTIVE_LOG.get(), TechnologicaBlocks.STRIPPED_CONDUCTIVE_WOOD.get());
		tag(TechnologicaBlockTags.FROSTBITTEN_LOGS).add(TechnologicaBlocks.FROSTBITTEN_LOG.get(), TechnologicaBlocks.FROSTBITTEN_WOOD.get(), TechnologicaBlocks.STRIPPED_FROSTBITTEN_LOG.get(), TechnologicaBlocks.STRIPPED_FROSTBITTEN_WOOD.get());
		tag(TechnologicaBlockTags.FRUITFUL_LOGS).add(TechnologicaBlocks.FRUITFUL_LOG.get(), TechnologicaBlocks.FRUITFUL_WOOD.get(), TechnologicaBlocks.STRIPPED_FRUITFUL_LOG.get(), TechnologicaBlocks.STRIPPED_FRUITFUL_WOOD.get());
		tag(TechnologicaBlockTags.INFERNAL_LOGS).add(TechnologicaBlocks.INFERNAL_LOG.get(), TechnologicaBlocks.INFERNAL_WOOD.get(), TechnologicaBlocks.STRIPPED_INFERNAL_LOG.get(), TechnologicaBlocks.STRIPPED_INFERNAL_WOOD.get());
		tag(TechnologicaBlockTags.MALEVOLENT_LOGS).add(TechnologicaBlocks.MALEVOLENT_LOG.get(), TechnologicaBlocks.MALEVOLENT_WOOD.get(), TechnologicaBlocks.STRIPPED_MALEVOLENT_LOG.get(), TechnologicaBlocks.STRIPPED_MALEVOLENT_WOOD.get());
		
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
			
			if (block.getRegistryName().getPath().contains("crop")) tag(BlockTags.CROPS).add(block);
			else if (block.getRegistryName().getPath().contains("clay")) tag(BlockTags.ENDERMAN_HOLDABLE).add(block);
			else if (block.getRegistryName().getPath().contains("fence_gate")) tag(BlockTags.FENCE_GATES).add(block);
			else if (block.getRegistryName().getPath().contains("potted")) tag(BlockTags.FLOWER_POTS).add(block);
			else if (block.getRegistryName().getPath().contains("leaves")) tag(BlockTags.LEAVES).add(block);
			else if (block.getRegistryName().getPath().contains("log")) tag(BlockTags.LOGS_THAT_BURN).add(block);
			else if (block.getRegistryName().getPath().contains("_wood")) tag(BlockTags.LOGS_THAT_BURN).add(block);
//			else if (block.getRegistryName().getPath().contains("clay")) getOrCreateBuilder(BlockTags.LUSH_GROUND_REPLACEABLE).add(block);
			else if (block.getRegistryName().getPath().contains("planks")) tag(BlockTags.PLANKS).add(block);
			else if (block.getRegistryName().getPath().contains("sapling") && !block.getRegistryName().getPath().contains("potted")) tag(BlockTags.SAPLINGS).add(block);
//			else if (block.getRegistryName().getPath().contains("clay")) getOrCreateBuilder(BlockTags.SMALL_DRIPLEAF_PLACEABLE).add(block);
			else if (block.getRegistryName().getPath().contains("sign") && !block.getRegistryName().getPath().contains("wall")) tag(BlockTags.STANDING_SIGNS).add(block);
			else if (block.getRegistryName().getPath().contains("wall_sign")) tag(BlockTags.WALL_SIGNS).add(block);
			else if (block.getRegistryName().getPath().contains("button")) tag(BlockTags.WOODEN_BUTTONS).add(block);
			else if (block.getRegistryName().getPath().contains("door") && !block.getRegistryName().getPath().contains("trap")) tag(BlockTags.WOODEN_DOORS).add(block);
			else if (block.getRegistryName().getPath().contains("fence") && !block.getRegistryName().getPath().contains("gate")) tag(BlockTags.WOODEN_FENCES).add(block);
			else if (block.getRegistryName().getPath().contains("pressure_plate")) tag(BlockTags.WOODEN_PRESSURE_PLATES).add(block);
			else if (block.getRegistryName().getPath().contains("slab")) tag(BlockTags.WOODEN_SLABS).add(block);
			else if (block.getRegistryName().getPath().contains("stairs")) tag(BlockTags.WOODEN_STAIRS).add(block);
			else if (block.getRegistryName().getPath().contains("trapdoor")) tag(BlockTags.WOODEN_TRAPDOORS).add(block);			
		}
	}
}