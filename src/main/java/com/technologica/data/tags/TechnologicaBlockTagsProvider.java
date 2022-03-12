package com.technologica.data.tags;

import com.technologica.Technologica;
import com.technologica.tags.TechnologicaBlockTags;
import com.technologica.world.level.block.TechnologicaBlocks;

import net.minecraft.data.DataGenerator;
import net.minecraft.data.tags.BlockTagsProvider;
import net.minecraft.tags.BlockTags;
import net.minecraftforge.common.data.ExistingFileHelper;

public class TechnologicaBlockTagsProvider extends BlockTagsProvider {
	
	public TechnologicaBlockTagsProvider(DataGenerator generatorIn, ExistingFileHelper helperIn) {
		super(generatorIn, Technologica.MODID, helperIn);
	}	
	
	@Override
	protected void addTags() {
		
		/*
		 * Minecraft Tags
		 */
		
		tag(BlockTags.CROPS).add(TechnologicaBlocks.ASPARAGUS_CROP.get(), TechnologicaBlocks.BARLEY_CROP.get(), TechnologicaBlocks.BROCCOLI_CROP.get(), TechnologicaBlocks.BLACKBERRY_CROP.get(), TechnologicaBlocks.BLUEBERRY_CROP.get(), TechnologicaBlocks.CELERY_CROP.get(), TechnologicaBlocks.CHILI_PEPPER_CROP.get(), TechnologicaBlocks.CORN_CROP.get(), TechnologicaBlocks.CRANBERRY_CROP.get(), TechnologicaBlocks.CUCUMBER_CROP.get(), TechnologicaBlocks.GARLIC_CROP.get(), TechnologicaBlocks.GINGER_CROP.get(), TechnologicaBlocks.GRAPE_CROP.get(), TechnologicaBlocks.LETTUCE_CROP.get(), TechnologicaBlocks.MUSTARD_GREENS_CROP.get(), TechnologicaBlocks.OATS_CROP.get(), TechnologicaBlocks.ONION_CROP.get(), TechnologicaBlocks.PEA_CROP.get(), TechnologicaBlocks.PEANUT_CROP.get(), TechnologicaBlocks.PEPPERCORN_CROP.get(), TechnologicaBlocks.PINEAPPLE_CROP.get(), TechnologicaBlocks.PURPLE_CABBAGE_CROP.get(), TechnologicaBlocks.RADISH_CROP.get(), TechnologicaBlocks.RASPBERRY_CROP.get(), TechnologicaBlocks.RICE_CROP.get(), TechnologicaBlocks.RYE_CROP.get(), TechnologicaBlocks.SQUASH_CROP.get(), TechnologicaBlocks.SWEET_POTATO_CROP.get(), TechnologicaBlocks.STRAWBERRY_CROP.get(), TechnologicaBlocks.TEA_CROP.get(), TechnologicaBlocks.TOMATO_CROP.get(), TechnologicaBlocks.TURNIP_CROP.get(), TechnologicaBlocks.ZUCCHINI_CROP.get());
		tag(BlockTags.ENDERMAN_HOLDABLE).add(TechnologicaBlocks.LITHIUM_CLAY.get()); //Leave this one alone
		tag(BlockTags.FENCE_GATES).add(TechnologicaBlocks.APRICOT_FENCE_GATE.get()); //Add all fence gates to this tag
		tag(BlockTags.FLOWER_POTS).add(TechnologicaBlocks.POTTED_ANCIENT_AMBROSIA_SAPLING.get()); //Add all potted saplings to this tag
		tag(BlockTags.LEAVES).add(TechnologicaBlocks.ALCHEMICAL_LEAVES.get()); //Add all leaves to this tag
		tag(BlockTags.LOGS_THAT_BURN).addTag(TechnologicaBlockTags.APRICOT_LOGS); //Add all new Technologica log block tags to this tag
		tag(BlockTags.LUSH_GROUND_REPLACEABLE).add(TechnologicaBlocks.LITHIUM_CLAY.get()); //Leave this one alone
		tag(BlockTags.PLANKS).add(TechnologicaBlocks.APRICOT_PLANKS.get()); //Add all planks to this tag
		tag(BlockTags.SAPLINGS).add(TechnologicaBlocks.APRICOT_SAPLING.get()); //Add all non-potted saplings to this tag
		tag(BlockTags.SMALL_DRIPLEAF_PLACEABLE).add(TechnologicaBlocks.LITHIUM_CLAY.get()); //Leave this one alone
		tag(BlockTags.STANDING_SIGNS).add(TechnologicaBlocks.APRICOT_SIGN.get()); //Add all standing signs to this tag
		tag(BlockTags.WALL_SIGNS).add(TechnologicaBlocks.APRICOT_WALL_SIGN.get()); //Add all wall signs to this tag
		tag(BlockTags.WOODEN_BUTTONS).add(TechnologicaBlocks.APRICOT_BUTTON.get()); //Add all buttons to this tag
		tag(BlockTags.WOODEN_DOORS).add(TechnologicaBlocks.APRICOT_DOOR.get()); //Add all doors to this tag
		tag(BlockTags.WOODEN_FENCES).add(TechnologicaBlocks.APRICOT_FENCE_GATE.get()); //Add all fences to this tag
		tag(BlockTags.WOODEN_PRESSURE_PLATES).add(TechnologicaBlocks.APRICOT_PRESSURE_PLATE.get()); //Add all pressure plates to this tag
		tag(BlockTags.WOODEN_SLABS).add(TechnologicaBlocks.APRICOT_SLAB.get()); //Add all slabs to this tag
		tag(BlockTags.WOODEN_STAIRS).add(TechnologicaBlocks.APRICOT_STAIRS.get()); //Add all stairs to this tag
		tag(BlockTags.WOODEN_TRAPDOORS).add(TechnologicaBlocks.APRICOT_TRAPDOOR.get()); //Add all trapdoors to this tag
		
		/*
		 * Technologica Tags
		 */
		
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
	}
}