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
		
		this.tag(BlockTags.BEE_GROWABLES).add(TechnologicaBlocks.BLACKBERRY_BUSH.get(), TechnologicaBlocks.BLUEBERRY_BUSH.get(), TechnologicaBlocks.RASPBERRY_BUSH.get(), TechnologicaBlocks.STRAWBERRY_BUSH.get());
		this.tag(BlockTags.CROPS).add(TechnologicaBlocks.ASPARAGUS_CROP.get(), TechnologicaBlocks.BARLEY.get(), TechnologicaBlocks.BROCCOLI_CROP.get(), TechnologicaBlocks.CELERY_CROP.get(), TechnologicaBlocks.CHILI_PEPPER_CROP.get(), TechnologicaBlocks.CORN.get(), TechnologicaBlocks.CRANBERRY_CROP.get(), TechnologicaBlocks.CUCUMBER_CROP.get(), TechnologicaBlocks.GARLIC.get(), TechnologicaBlocks.GINGER.get(), TechnologicaBlocks.GRAPE_CROP.get(), TechnologicaBlocks.LETTUCE_CROP.get(), TechnologicaBlocks.MUSTARD_GREENS_CROP.get(), TechnologicaBlocks.OATS.get(), TechnologicaBlocks.ONIONS.get(), TechnologicaBlocks.PEA_CROP.get(), TechnologicaBlocks.PEANUTS.get(), TechnologicaBlocks.PEPPERCORN_CROP.get(), TechnologicaBlocks.PINEAPPLE_CROP.get(), TechnologicaBlocks.PURPLE_CABBAGE_CROP.get(), TechnologicaBlocks.RADISHES.get(), TechnologicaBlocks.RICE.get(), TechnologicaBlocks.RYE.get(), TechnologicaBlocks.SQUASH_CROP.get(), TechnologicaBlocks.SWEET_POTATOES.get(), TechnologicaBlocks.TEA_CROP.get(), TechnologicaBlocks.TOMATO_CROP.get(), TechnologicaBlocks.TURNIPS.get(), TechnologicaBlocks.ZUCCHINI_CROP.get());
		tag(BlockTags.ENDERMAN_HOLDABLE).add(TechnologicaBlocks.LITHIUM_CLAY.get());
		this.tag(BlockTags.FALL_DAMAGE_RESETTING).add(TechnologicaBlocks.BLACKBERRY_BUSH.get(), TechnologicaBlocks.BLUEBERRY_BUSH.get(), TechnologicaBlocks.RASPBERRY_BUSH.get(), TechnologicaBlocks.STRAWBERRY_BUSH.get());
		tag(BlockTags.FENCE_GATES).add(TechnologicaBlocks.APRICOT_FENCE_GATE.get(), TechnologicaBlocks.ASPEN_FENCE_GATE.get(), TechnologicaBlocks.AVOCADO_FENCE_GATE.get(), TechnologicaBlocks.BANANA_FENCE_GATE.get(), TechnologicaBlocks.CHERRY_FENCE_GATE.get(), TechnologicaBlocks.CHESTNUT_FENCE_GATE.get(),TechnologicaBlocks.CINNAMON_FENCE_GATE.get(), TechnologicaBlocks.COCONUT_FENCE_GATE.get(), TechnologicaBlocks.EBONY_FENCE_GATE.get(), TechnologicaBlocks.KIWI_FENCE_GATE.get(), TechnologicaBlocks.LEMON_FENCE_GATE.get(), TechnologicaBlocks.LIME_FENCE_GATE.get(), TechnologicaBlocks.MAHOGANY_FENCE_GATE.get(), TechnologicaBlocks.MAPLE_FENCE_GATE.get(), TechnologicaBlocks.OLIVE_FENCE_GATE.get(), TechnologicaBlocks.ORANGE_FENCE_GATE.get(), TechnologicaBlocks.PEACH_FENCE_GATE.get(), TechnologicaBlocks.PEAR_FENCE_GATE.get(), TechnologicaBlocks.PLUM_FENCE_GATE.get(), TechnologicaBlocks.REDWOOD_FENCE_GATE.get(), TechnologicaBlocks.ROSEWOOD_FENCE_GATE.get(), TechnologicaBlocks.RUBBER_FENCE_GATE.get(), TechnologicaBlocks.TEAK_FENCE_GATE.get(), TechnologicaBlocks.WALNUT_FENCE_GATE.get(), TechnologicaBlocks.ZEBRAWOOD_FENCE_GATE.get(), TechnologicaBlocks.ALCHEMICAL_FENCE_GATE.get(), TechnologicaBlocks.BENEVOLENT_FENCE_GATE.get(), TechnologicaBlocks.CONDUCTIVE_FENCE_GATE.get(), TechnologicaBlocks.FROSTBITTEN_FENCE_GATE.get(), TechnologicaBlocks.FRUITFUL_FENCE_GATE.get(), TechnologicaBlocks.INFERNAL_FENCE_GATE.get(), TechnologicaBlocks.MALEVOLENT_FENCE_GATE.get()); 
		tag(BlockTags.FLOWER_POTS).add(TechnologicaBlocks.POTTED_ANCIENT_AMBROSIA_SAPLING.get(), TechnologicaBlocks.POTTED_APRICOT_SAPLING.get(), TechnologicaBlocks.POTTED_ASPEN_SAPLING.get(), TechnologicaBlocks.POTTED_AVOCADO_SAPLING.get(), TechnologicaBlocks.POTTED_BANANA_SAPLING.get(), TechnologicaBlocks.POTTED_CHERRY_SAPLING.get(), TechnologicaBlocks.POTTED_CHESTNUT_SAPLING.get(), TechnologicaBlocks.POTTED_CINNAMON_SAPLING.get(), TechnologicaBlocks.POTTED_COCONUT_SAPLING.get(), TechnologicaBlocks.POTTED_EBONY_SAPLING.get(), TechnologicaBlocks.POTTED_KIWI_SAPLING.get(), TechnologicaBlocks.POTTED_LEMON_SAPLING.get(), TechnologicaBlocks.POTTED_LIME_SAPLING.get(), TechnologicaBlocks.POTTED_MAHOGANY_SAPLING.get(), TechnologicaBlocks.POTTED_MAPLE_SAPLING.get(), TechnologicaBlocks.POTTED_OLIVE_SAPLING.get(), TechnologicaBlocks.POTTED_ORANGE_SAPLING.get(), TechnologicaBlocks.POTTED_PEACH_SAPLING.get(), TechnologicaBlocks.POTTED_PEAR_SAPLING.get(), TechnologicaBlocks.POTTED_PLUM_SAPLING.get(), TechnologicaBlocks.POTTED_REDWOOD_SAPLING.get(), TechnologicaBlocks.POTTED_ROSEWOOD_SAPLING.get(), TechnologicaBlocks.POTTED_RUBBER_SAPLING.get(), TechnologicaBlocks.POTTED_TEAK_SAPLING.get(), TechnologicaBlocks.POTTED_WALNUT_SAPLING.get(), TechnologicaBlocks.POTTED_ZEBRAWOOD_SAPLING.get(), TechnologicaBlocks.POTTED_SERENDIPITOUS_APOTHECARY_SAPLING.get(), TechnologicaBlocks.POTTED_BENEVOLENT_APOTHECARY_SAPLING.get(), TechnologicaBlocks.POTTED_MALEVOLENT_APOTHECARY_SAPLING.get(), TechnologicaBlocks.POTTED_NECROTIC_SAPLING.get(), TechnologicaBlocks.POTTED_TOWERING_INFERNO_SAPLING.get(), TechnologicaBlocks.POTTED_THUNDEROUS_CONDUCTOR_SAPLING.get(), TechnologicaBlocks.POTTED_CRYOGENIC_SPIRE_SAPLING.get());
		tag(BlockTags.LEAVES).add(TechnologicaBlocks.ALCHEMICAL_LEAVES.get(), TechnologicaBlocks.APRICOT_LEAVES.get(), TechnologicaBlocks.ASPEN_LEAVES.get(), TechnologicaBlocks.AVOCADO_LEAVES.get(), TechnologicaBlocks.BANANA_LEAVES.get(), TechnologicaBlocks.CHERRY_LEAVES.get(), TechnologicaBlocks.CHESTNUT_LEAVES.get(), TechnologicaBlocks.CINNAMON_LEAVES.get(), TechnologicaBlocks.COCONUT_LEAVES.get(), TechnologicaBlocks.EBONY_LEAVES.get(), TechnologicaBlocks.KIWI_LEAVES.get(), TechnologicaBlocks.LEMON_LEAVES.get(), TechnologicaBlocks.LIME_LEAVES.get(), TechnologicaBlocks.MAHOGANY_LEAVES.get(), TechnologicaBlocks.MAPLE_LEAVES.get(), TechnologicaBlocks.OLIVE_LEAVES.get(), TechnologicaBlocks.ORANGE_LEAVES.get(), TechnologicaBlocks.PEACH_LEAVES.get(), TechnologicaBlocks.PEAR_LEAVES.get(), TechnologicaBlocks.PLUM_LEAVES.get(), TechnologicaBlocks.REDWOOD_LEAVES.get(), TechnologicaBlocks.ROSEWOOD_LEAVES.get(), TechnologicaBlocks.RUBBER_LEAVES.get(), TechnologicaBlocks.TEAK_LEAVES.get(), TechnologicaBlocks.WALNUT_LEAVES.get(), TechnologicaBlocks.ZEBRAWOOD_LEAVES.get(), TechnologicaBlocks.FRUITFUL_LEAVES.get(), TechnologicaBlocks.BENEVOLENT_LEAVES.get(), TechnologicaBlocks.CURSED_LEAVES.get(), TechnologicaBlocks.MALEVOLENT_LEAVES.get(), TechnologicaBlocks.CONDUCTIVE_LEAVES.get(), TechnologicaBlocks.FROSTBITTEN_LEAVES.get()); 
		tag(BlockTags.LOGS_THAT_BURN).addTag(TechnologicaBlockTags.APRICOT_LOGS).addTag(TechnologicaBlockTags.ASPEN_LOGS).addTag(TechnologicaBlockTags.AVOCADO_LOGS).addTag(TechnologicaBlockTags.BANANA_LOGS).addTag(TechnologicaBlockTags.CHERRY_LOGS).addTag(TechnologicaBlockTags.CHESTNUT_LOGS).addTag(TechnologicaBlockTags.CINNAMON_LOGS).addTag(TechnologicaBlockTags.COCONUT_LOGS).addTag(TechnologicaBlockTags.EBONY_LOGS).addTag(TechnologicaBlockTags.KIWI_LOGS).addTag(TechnologicaBlockTags.LEMON_LOGS).addTag(TechnologicaBlockTags.LIME_LOGS).addTag(TechnologicaBlockTags.MAHOGANY_LOGS).addTag(TechnologicaBlockTags.MAPLE_LOGS).addTag(TechnologicaBlockTags.OLIVE_LOGS).addTag(TechnologicaBlockTags.ORANGE_LOGS).addTag(TechnologicaBlockTags.PEACH_LOGS).addTag(TechnologicaBlockTags.PEAR_LOGS).addTag(TechnologicaBlockTags.PLUM_LOGS).addTag(TechnologicaBlockTags.REDWOOD_LOGS).addTag(TechnologicaBlockTags.ROSEWOOD_LOGS).addTag(TechnologicaBlockTags.RUBBER_LOGS).addTag(TechnologicaBlockTags.TEAK_LOGS).addTag(TechnologicaBlockTags.WALNUT_LOGS).addTag(TechnologicaBlockTags.ZEBRAWOOD_LOGS).addTag(TechnologicaBlockTags.ALCHEMICAL_LOGS).addTag(TechnologicaBlockTags.BENEVOLENT_LOGS).addTag(TechnologicaBlockTags.CONDUCTIVE_LOGS).addTag(TechnologicaBlockTags.FROSTBITTEN_LOGS).addTag(TechnologicaBlockTags.FRUITFUL_LOGS).addTag(TechnologicaBlockTags.INFERNAL_LOGS).addTag(TechnologicaBlockTags.MALEVOLENT_LOGS); 
		tag(BlockTags.LUSH_GROUND_REPLACEABLE).add(TechnologicaBlocks.LITHIUM_CLAY.get()); 
		this.tag(BlockTags.MINEABLE_WITH_AXE).add(TechnologicaBlocks.BLACKBERRY_BUSH.get(), TechnologicaBlocks.BLUEBERRY_BUSH.get(), TechnologicaBlocks.RASPBERRY_BUSH.get(), TechnologicaBlocks.STRAWBERRY_BUSH.get());
		tag(BlockTags.PLANKS).add(TechnologicaBlocks.APRICOT_PLANKS.get(), TechnologicaBlocks.ASPEN_PLANKS.get(), TechnologicaBlocks.AVOCADO_PLANKS.get(), TechnologicaBlocks.BANANA_PLANKS.get(), TechnologicaBlocks.CHERRY_PLANKS.get(), TechnologicaBlocks.CHESTNUT_PLANKS.get(), TechnologicaBlocks.CINNAMON_PLANKS.get(), TechnologicaBlocks.COCONUT_PLANKS.get(), TechnologicaBlocks.EBONY_PLANKS.get(), TechnologicaBlocks.KIWI_PLANKS.get(), TechnologicaBlocks.LEMON_PLANKS.get(), TechnologicaBlocks.LIME_PLANKS.get(), TechnologicaBlocks.MAHOGANY_PLANKS.get(), TechnologicaBlocks.MAPLE_PLANKS.get(), TechnologicaBlocks.OLIVE_PLANKS.get(), TechnologicaBlocks.ORANGE_PLANKS.get(), TechnologicaBlocks.PEACH_PLANKS.get(), TechnologicaBlocks.PEAR_PLANKS.get(), TechnologicaBlocks.PLUM_PLANKS.get(), TechnologicaBlocks.REDWOOD_PLANKS.get(), TechnologicaBlocks.ROSEWOOD_PLANKS.get(), TechnologicaBlocks.RUBBER_PLANKS.get(), TechnologicaBlocks.TEAK_PLANKS.get(), TechnologicaBlocks.WALNUT_PLANKS.get(), TechnologicaBlocks.ZEBRAWOOD_PLANKS.get(), TechnologicaBlocks.ALCHEMICAL_PLANKS.get(), TechnologicaBlocks.BENEVOLENT_PLANKS.get(), TechnologicaBlocks.CONDUCTIVE_PLANKS.get(), TechnologicaBlocks.FROSTBITTEN_PLANKS.get(), TechnologicaBlocks.FRUITFUL_PLANKS.get(), TechnologicaBlocks.INFERNAL_PLANKS.get(), TechnologicaBlocks.MALEVOLENT_PLANKS.get(), TechnologicaBlocks.NECROTIC_PLANKS.get()); 
		tag(BlockTags.SAPLINGS).add(TechnologicaBlocks.APRICOT_SAPLING.get(), TechnologicaBlocks.ASPEN_SAPLING.get(), TechnologicaBlocks.AVOCADO_SAPLING.get(), TechnologicaBlocks.BANANA_SAPLING.get(), TechnologicaBlocks.CHERRY_SAPLING.get(), TechnologicaBlocks.CHESTNUT_SAPLING.get(), TechnologicaBlocks.CINNAMON_SAPLING.get(), TechnologicaBlocks.COCONUT_SAPLING.get(), TechnologicaBlocks.EBONY_SAPLING.get(), TechnologicaBlocks.KIWI_SAPLING.get(), TechnologicaBlocks.LEMON_SAPLING.get(), TechnologicaBlocks.LIME_SAPLING.get(), TechnologicaBlocks.MAHOGANY_SAPLING.get(), TechnologicaBlocks.MAPLE_SAPLING.get(), TechnologicaBlocks.OLIVE_SAPLING.get(), TechnologicaBlocks.ORANGE_SAPLING.get(), TechnologicaBlocks.PEACH_SAPLING.get(), TechnologicaBlocks.PEAR_SAPLING.get(), TechnologicaBlocks.PLUM_SAPLING.get(), TechnologicaBlocks.REDWOOD_SAPLING.get(), TechnologicaBlocks.ROSEWOOD_SAPLING.get(), TechnologicaBlocks.RUBBER_SAPLING.get(), TechnologicaBlocks.TEAK_SAPLING.get(), TechnologicaBlocks.WALNUT_SAPLING.get(), TechnologicaBlocks.ZEBRAWOOD_SAPLING.get(), TechnologicaBlocks.ANCIENT_AMBROSIA_SAPLING.get(), TechnologicaBlocks.SERENDIPITOUS_APOTHECARY_SAPLING.get(), TechnologicaBlocks.BENEVOLENT_APOTHECARY_SAPLING.get(), TechnologicaBlocks.MALEVOLENT_APOTHECARY_SAPLING.get(), TechnologicaBlocks.NECROTIC_SAPLING.get(), TechnologicaBlocks.TOWERING_INFERNO_SAPLING.get(), TechnologicaBlocks.THUNDEROUS_CONDUCTOR_SAPLING.get(), TechnologicaBlocks.CRYOGENIC_SPIRE_SAPLING.get()); 
		tag(BlockTags.SMALL_DRIPLEAF_PLACEABLE).add(TechnologicaBlocks.LITHIUM_CLAY.get());
		tag(BlockTags.STANDING_SIGNS).add(TechnologicaBlocks.APRICOT_SIGN.get(), TechnologicaBlocks.ASPEN_SIGN.get(), TechnologicaBlocks.AVOCADO_SIGN.get(), TechnologicaBlocks.BANANA_SIGN.get(), TechnologicaBlocks.CHERRY_SIGN.get(), TechnologicaBlocks.CHESTNUT_SIGN.get(), TechnologicaBlocks.CINNAMON_SIGN.get(), TechnologicaBlocks.COCONUT_SIGN.get(), TechnologicaBlocks.EBONY_SIGN.get(), TechnologicaBlocks.KIWI_SIGN.get(), TechnologicaBlocks.LEMON_SIGN.get(), TechnologicaBlocks.LIME_SIGN.get(), TechnologicaBlocks.MAHOGANY_SIGN.get(), TechnologicaBlocks.MAPLE_SIGN.get(), TechnologicaBlocks.OLIVE_SIGN.get(), TechnologicaBlocks.ORANGE_SIGN.get(), TechnologicaBlocks.PEACH_SIGN.get(), TechnologicaBlocks.PEAR_SIGN.get(), TechnologicaBlocks.PLUM_SIGN.get(), TechnologicaBlocks.REDWOOD_SIGN.get(), TechnologicaBlocks.ROSEWOOD_SIGN.get(), TechnologicaBlocks.RUBBER_SIGN.get(), TechnologicaBlocks.TEAK_SIGN.get(), TechnologicaBlocks.WALNUT_SIGN.get(), TechnologicaBlocks.ZEBRAWOOD_SIGN.get(), TechnologicaBlocks.ALCHEMICAL_SIGN.get(), TechnologicaBlocks.BENEVOLENT_SIGN.get(), TechnologicaBlocks.CONDUCTIVE_SIGN.get(), TechnologicaBlocks.FROSTBITTEN_SIGN.get(), TechnologicaBlocks.FRUITFUL_SIGN.get(), TechnologicaBlocks.INFERNAL_SIGN.get(), TechnologicaBlocks.MALEVOLENT_SIGN.get(), TechnologicaBlocks.NECROTIC_SIGN.get());
		tag(BlockTags.WALL_SIGNS).add(TechnologicaBlocks.APRICOT_WALL_SIGN.get(), TechnologicaBlocks.ASPEN_WALL_SIGN.get(), TechnologicaBlocks.AVOCADO_WALL_SIGN.get(), TechnologicaBlocks.BANANA_WALL_SIGN.get(), TechnologicaBlocks.CHERRY_WALL_SIGN.get(), TechnologicaBlocks.CHESTNUT_WALL_SIGN.get(), TechnologicaBlocks.CINNAMON_WALL_SIGN.get(), TechnologicaBlocks.COCONUT_WALL_SIGN.get(), TechnologicaBlocks.EBONY_WALL_SIGN.get(), TechnologicaBlocks.KIWI_WALL_SIGN.get(), TechnologicaBlocks.LEMON_WALL_SIGN.get(), TechnologicaBlocks.LIME_WALL_SIGN.get(), TechnologicaBlocks.MAHOGANY_WALL_SIGN.get(), TechnologicaBlocks.MAPLE_WALL_SIGN.get(), TechnologicaBlocks.OLIVE_WALL_SIGN.get(), TechnologicaBlocks.ORANGE_WALL_SIGN.get(), TechnologicaBlocks.PEACH_WALL_SIGN.get(), TechnologicaBlocks.PEAR_WALL_SIGN.get(), TechnologicaBlocks.PLUM_WALL_SIGN.get(), TechnologicaBlocks.REDWOOD_WALL_SIGN.get(), TechnologicaBlocks.ROSEWOOD_WALL_SIGN.get(), TechnologicaBlocks.RUBBER_WALL_SIGN.get(), TechnologicaBlocks.TEAK_WALL_SIGN.get(), TechnologicaBlocks.WALNUT_WALL_SIGN.get(), TechnologicaBlocks.ZEBRAWOOD_WALL_SIGN.get(), TechnologicaBlocks.ALCHEMICAL_WALL_SIGN.get(), TechnologicaBlocks.BENEVOLENT_WALL_SIGN.get(), TechnologicaBlocks.CONDUCTIVE_WALL_SIGN.get(), TechnologicaBlocks.FROSTBITTEN_WALL_SIGN.get(), TechnologicaBlocks.FRUITFUL_WALL_SIGN.get(), TechnologicaBlocks.INFERNAL_WALL_SIGN.get(), TechnologicaBlocks.MALEVOLENT_WALL_SIGN.get(), TechnologicaBlocks.NECROTIC_WALL_SIGN.get());
		tag(BlockTags.WOODEN_BUTTONS).add(TechnologicaBlocks.APRICOT_BUTTON.get(), TechnologicaBlocks.ASPEN_BUTTON.get(), TechnologicaBlocks.AVOCADO_BUTTON.get(), TechnologicaBlocks.BANANA_BUTTON.get(), TechnologicaBlocks.CHERRY_BUTTON.get(), TechnologicaBlocks.CHESTNUT_BUTTON.get(), TechnologicaBlocks.CINNAMON_BUTTON.get(), TechnologicaBlocks.COCONUT_BUTTON.get(), TechnologicaBlocks.EBONY_BUTTON.get(), TechnologicaBlocks.KIWI_BUTTON.get(), TechnologicaBlocks.LEMON_BUTTON.get(), TechnologicaBlocks.LIME_BUTTON.get(), TechnologicaBlocks.MAHOGANY_BUTTON.get(), TechnologicaBlocks.MAPLE_BUTTON.get(), TechnologicaBlocks.OLIVE_BUTTON.get(), TechnologicaBlocks.ORANGE_BUTTON.get(), TechnologicaBlocks.PEACH_BUTTON.get(), TechnologicaBlocks.PEAR_BUTTON.get(), TechnologicaBlocks.PLUM_BUTTON.get(), TechnologicaBlocks.REDWOOD_BUTTON.get(), TechnologicaBlocks.ROSEWOOD_BUTTON.get(), TechnologicaBlocks.RUBBER_BUTTON.get(), TechnologicaBlocks.TEAK_BUTTON.get(), TechnologicaBlocks.WALNUT_BUTTON.get(), TechnologicaBlocks.ZEBRAWOOD_BUTTON.get(), TechnologicaBlocks.ALCHEMICAL_BUTTON.get(), TechnologicaBlocks.BENEVOLENT_BUTTON.get(), TechnologicaBlocks.CONDUCTIVE_BUTTON.get(), TechnologicaBlocks.FROSTBITTEN_BUTTON.get(), TechnologicaBlocks.FRUITFUL_BUTTON.get(), TechnologicaBlocks.INFERNAL_BUTTON.get(), TechnologicaBlocks.MALEVOLENT_BUTTON.get(), TechnologicaBlocks.NECROTIC_BUTTON.get());
		tag(BlockTags.WOODEN_DOORS).add(TechnologicaBlocks.APRICOT_DOOR.get(), TechnologicaBlocks.ASPEN_DOOR.get(), TechnologicaBlocks.AVOCADO_DOOR.get(), TechnologicaBlocks.BANANA_DOOR.get(), TechnologicaBlocks.CHERRY_DOOR.get(), TechnologicaBlocks.CHESTNUT_DOOR.get(), TechnologicaBlocks.CINNAMON_DOOR.get(), TechnologicaBlocks.COCONUT_DOOR.get(), TechnologicaBlocks.EBONY_DOOR.get(), TechnologicaBlocks.KIWI_DOOR.get(), TechnologicaBlocks.LEMON_DOOR.get(), TechnologicaBlocks.LIME_DOOR.get(), TechnologicaBlocks.MAHOGANY_DOOR.get(), TechnologicaBlocks.MAPLE_DOOR.get(), TechnologicaBlocks.OLIVE_DOOR.get(), TechnologicaBlocks.ORANGE_DOOR.get(), TechnologicaBlocks.PEACH_DOOR.get(), TechnologicaBlocks.PEAR_DOOR.get(), TechnologicaBlocks.PLUM_DOOR.get(), TechnologicaBlocks.REDWOOD_DOOR.get(), TechnologicaBlocks.ROSEWOOD_DOOR.get(), TechnologicaBlocks.RUBBER_DOOR.get(), TechnologicaBlocks.TEAK_DOOR.get(), TechnologicaBlocks.WALNUT_DOOR.get(), TechnologicaBlocks.ZEBRAWOOD_DOOR.get(), TechnologicaBlocks.ALCHEMICAL_DOOR.get(), TechnologicaBlocks.BENEVOLENT_DOOR.get(), TechnologicaBlocks.CONDUCTIVE_DOOR.get(), TechnologicaBlocks.FROSTBITTEN_DOOR.get(), TechnologicaBlocks.FRUITFUL_DOOR.get(), TechnologicaBlocks.INFERNAL_DOOR.get(), TechnologicaBlocks.MALEVOLENT_DOOR.get(), TechnologicaBlocks.NECROTIC_DOOR.get());
		tag(BlockTags.WOODEN_FENCES).add(TechnologicaBlocks.APRICOT_FENCE_GATE.get(), TechnologicaBlocks.ASPEN_FENCE_GATE.get(), TechnologicaBlocks.AVOCADO_FENCE_GATE.get(), TechnologicaBlocks.BANANA_FENCE_GATE.get(), TechnologicaBlocks.CHERRY_FENCE_GATE.get(), TechnologicaBlocks.CHESTNUT_FENCE_GATE.get(), TechnologicaBlocks.CINNAMON_FENCE_GATE.get(), TechnologicaBlocks.COCONUT_FENCE_GATE.get(), TechnologicaBlocks.EBONY_FENCE_GATE.get(), TechnologicaBlocks.KIWI_FENCE_GATE.get(), TechnologicaBlocks.LEMON_FENCE_GATE.get(), TechnologicaBlocks.LIME_FENCE_GATE.get(), TechnologicaBlocks.MAHOGANY_FENCE_GATE.get(), TechnologicaBlocks.MAPLE_FENCE_GATE.get(), TechnologicaBlocks.OLIVE_FENCE_GATE.get(), TechnologicaBlocks.ORANGE_FENCE_GATE.get(), TechnologicaBlocks.PEACH_FENCE_GATE.get(), TechnologicaBlocks.PEAR_FENCE_GATE.get(), TechnologicaBlocks.PLUM_FENCE_GATE.get(), TechnologicaBlocks.REDWOOD_FENCE_GATE.get(), TechnologicaBlocks.ROSEWOOD_FENCE_GATE.get(), TechnologicaBlocks.RUBBER_FENCE_GATE.get(), TechnologicaBlocks.TEAK_FENCE_GATE.get(), TechnologicaBlocks.WALNUT_FENCE_GATE.get(), TechnologicaBlocks.ZEBRAWOOD_FENCE_GATE.get(), TechnologicaBlocks.ALCHEMICAL_FENCE_GATE.get(), TechnologicaBlocks.BENEVOLENT_FENCE_GATE.get(), TechnologicaBlocks.CONDUCTIVE_FENCE_GATE.get(), TechnologicaBlocks.FROSTBITTEN_FENCE_GATE.get(), TechnologicaBlocks.FRUITFUL_FENCE_GATE.get(), TechnologicaBlocks.INFERNAL_FENCE_GATE.get(), TechnologicaBlocks.MALEVOLENT_FENCE_GATE.get(), TechnologicaBlocks.NECROTIC_FENCE_GATE.get());
		tag(BlockTags.WOODEN_PRESSURE_PLATES).add(TechnologicaBlocks.APRICOT_PRESSURE_PLATE.get(), TechnologicaBlocks.ASPEN_PRESSURE_PLATE.get(), TechnologicaBlocks.AVOCADO_PRESSURE_PLATE.get(), TechnologicaBlocks.BANANA_PRESSURE_PLATE.get(), TechnologicaBlocks.CHERRY_PRESSURE_PLATE.get(), TechnologicaBlocks.CHESTNUT_PRESSURE_PLATE.get(), TechnologicaBlocks.CINNAMON_PRESSURE_PLATE.get(), TechnologicaBlocks.COCONUT_PRESSURE_PLATE.get(), TechnologicaBlocks.EBONY_PRESSURE_PLATE.get(), TechnologicaBlocks.KIWI_PRESSURE_PLATE.get(), TechnologicaBlocks.LEMON_PRESSURE_PLATE.get(), TechnologicaBlocks.LIME_PRESSURE_PLATE.get(), TechnologicaBlocks.MAHOGANY_PRESSURE_PLATE.get(), TechnologicaBlocks.MAPLE_PRESSURE_PLATE.get(), TechnologicaBlocks.OLIVE_PRESSURE_PLATE.get(), TechnologicaBlocks.ORANGE_PRESSURE_PLATE.get(), TechnologicaBlocks.PEACH_PRESSURE_PLATE.get(), TechnologicaBlocks.PEAR_PRESSURE_PLATE.get(), TechnologicaBlocks.PLUM_PRESSURE_PLATE.get(), TechnologicaBlocks.REDWOOD_PRESSURE_PLATE.get(), TechnologicaBlocks.ROSEWOOD_PRESSURE_PLATE.get(), TechnologicaBlocks.RUBBER_PRESSURE_PLATE.get(), TechnologicaBlocks.TEAK_PRESSURE_PLATE.get(), TechnologicaBlocks.WALNUT_PRESSURE_PLATE.get(), TechnologicaBlocks.ZEBRAWOOD_PRESSURE_PLATE.get(), TechnologicaBlocks.ALCHEMICAL_PRESSURE_PLATE.get(), TechnologicaBlocks.BENEVOLENT_PRESSURE_PLATE.get(), TechnologicaBlocks.CONDUCTIVE_PRESSURE_PLATE.get(), TechnologicaBlocks.FROSTBITTEN_PRESSURE_PLATE.get(), TechnologicaBlocks.FRUITFUL_PRESSURE_PLATE.get(), TechnologicaBlocks.INFERNAL_PRESSURE_PLATE.get(), TechnologicaBlocks.MALEVOLENT_PRESSURE_PLATE.get(), TechnologicaBlocks.NECROTIC_PRESSURE_PLATE.get());
		tag(BlockTags.WOODEN_SLABS).add(TechnologicaBlocks.APRICOT_SLAB.get(), TechnologicaBlocks.ASPEN_SLAB.get(), TechnologicaBlocks.AVOCADO_SLAB.get(), TechnologicaBlocks.BANANA_SLAB.get(), TechnologicaBlocks.CHERRY_SLAB.get(), TechnologicaBlocks.CHESTNUT_SLAB.get(), TechnologicaBlocks.CINNAMON_SLAB.get(), TechnologicaBlocks.COCONUT_SLAB.get(), TechnologicaBlocks.EBONY_SLAB.get(), TechnologicaBlocks.KIWI_SLAB.get(), TechnologicaBlocks.LEMON_SLAB.get(), TechnologicaBlocks.LIME_SLAB.get(), TechnologicaBlocks.MAHOGANY_SLAB.get(), TechnologicaBlocks.MAPLE_SLAB.get(), TechnologicaBlocks.OLIVE_SLAB.get(), TechnologicaBlocks.ORANGE_SLAB.get(), TechnologicaBlocks.PEACH_SLAB.get(), TechnologicaBlocks.PEAR_SLAB.get(), TechnologicaBlocks.PLUM_SLAB.get(), TechnologicaBlocks.REDWOOD_SLAB.get(), TechnologicaBlocks.ROSEWOOD_SLAB.get(), TechnologicaBlocks.RUBBER_SLAB.get(), TechnologicaBlocks.TEAK_SLAB.get(), TechnologicaBlocks.WALNUT_SLAB.get(), TechnologicaBlocks.ZEBRAWOOD_SLAB.get(), TechnologicaBlocks.ALCHEMICAL_SLAB.get(), TechnologicaBlocks.BENEVOLENT_SLAB.get(), TechnologicaBlocks.CONDUCTIVE_SLAB.get(), TechnologicaBlocks.FROSTBITTEN_SLAB.get(), TechnologicaBlocks.FRUITFUL_SLAB.get(), TechnologicaBlocks.INFERNAL_SLAB.get(), TechnologicaBlocks.MALEVOLENT_SLAB.get(), TechnologicaBlocks.NECROTIC_SLAB.get());
		tag(BlockTags.WOODEN_STAIRS).add(TechnologicaBlocks.APRICOT_STAIRS.get(), TechnologicaBlocks.ASPEN_STAIRS.get(), TechnologicaBlocks.AVOCADO_STAIRS.get(), TechnologicaBlocks.BANANA_STAIRS.get(), TechnologicaBlocks.CHERRY_STAIRS.get(), TechnologicaBlocks.CHESTNUT_STAIRS.get(), TechnologicaBlocks.CINNAMON_STAIRS.get(), TechnologicaBlocks.COCONUT_STAIRS.get(), TechnologicaBlocks.EBONY_STAIRS.get(), TechnologicaBlocks.KIWI_STAIRS.get(), TechnologicaBlocks.LEMON_STAIRS.get(), TechnologicaBlocks.LIME_STAIRS.get(), TechnologicaBlocks.MAHOGANY_STAIRS.get(), TechnologicaBlocks.MAPLE_STAIRS.get(), TechnologicaBlocks.OLIVE_STAIRS.get(), TechnologicaBlocks.ORANGE_STAIRS.get(), TechnologicaBlocks.PEACH_STAIRS.get(), TechnologicaBlocks.PEAR_STAIRS.get(), TechnologicaBlocks.PLUM_STAIRS.get(), TechnologicaBlocks.REDWOOD_STAIRS.get(), TechnologicaBlocks.ROSEWOOD_STAIRS.get(), TechnologicaBlocks.RUBBER_STAIRS.get(), TechnologicaBlocks.TEAK_STAIRS.get(), TechnologicaBlocks.WALNUT_STAIRS.get(), TechnologicaBlocks.ZEBRAWOOD_STAIRS.get(), TechnologicaBlocks.ALCHEMICAL_STAIRS.get(), TechnologicaBlocks.BENEVOLENT_STAIRS.get(), TechnologicaBlocks.CONDUCTIVE_STAIRS.get(), TechnologicaBlocks.FROSTBITTEN_STAIRS.get(), TechnologicaBlocks.FRUITFUL_STAIRS.get(), TechnologicaBlocks.INFERNAL_STAIRS.get(), TechnologicaBlocks.MALEVOLENT_STAIRS.get(), TechnologicaBlocks.NECROTIC_STAIRS.get());
		tag(BlockTags.WOODEN_TRAPDOORS).add(TechnologicaBlocks.APRICOT_TRAPDOOR.get(), TechnologicaBlocks.ASPEN_TRAPDOOR.get(), TechnologicaBlocks.AVOCADO_TRAPDOOR.get(), TechnologicaBlocks.BANANA_TRAPDOOR.get(), TechnologicaBlocks.CHERRY_TRAPDOOR.get(), TechnologicaBlocks.CHESTNUT_TRAPDOOR.get(), TechnologicaBlocks.CINNAMON_TRAPDOOR.get(), TechnologicaBlocks.COCONUT_TRAPDOOR.get(), TechnologicaBlocks.EBONY_TRAPDOOR.get(), TechnologicaBlocks.KIWI_TRAPDOOR.get(), TechnologicaBlocks.LEMON_TRAPDOOR.get(), TechnologicaBlocks.LIME_TRAPDOOR.get(), TechnologicaBlocks.MAHOGANY_TRAPDOOR.get(), TechnologicaBlocks.MAPLE_TRAPDOOR.get(), TechnologicaBlocks.OLIVE_TRAPDOOR.get(), TechnologicaBlocks.ORANGE_TRAPDOOR.get(), TechnologicaBlocks.PEACH_TRAPDOOR.get(), TechnologicaBlocks.PEAR_TRAPDOOR.get(), TechnologicaBlocks.PLUM_TRAPDOOR.get(), TechnologicaBlocks.REDWOOD_TRAPDOOR.get(), TechnologicaBlocks.ROSEWOOD_TRAPDOOR.get(), TechnologicaBlocks.RUBBER_TRAPDOOR.get(), TechnologicaBlocks.TEAK_TRAPDOOR.get(), TechnologicaBlocks.WALNUT_TRAPDOOR.get(), TechnologicaBlocks.ZEBRAWOOD_TRAPDOOR.get(), TechnologicaBlocks.ALCHEMICAL_TRAPDOOR.get(), TechnologicaBlocks.BENEVOLENT_TRAPDOOR.get(), TechnologicaBlocks.CONDUCTIVE_TRAPDOOR.get(), TechnologicaBlocks.FROSTBITTEN_TRAPDOOR.get(), TechnologicaBlocks.FRUITFUL_TRAPDOOR.get(), TechnologicaBlocks.INFERNAL_TRAPDOOR.get(), TechnologicaBlocks.MALEVOLENT_TRAPDOOR.get(), TechnologicaBlocks.NECROTIC_TRAPDOOR.get());
		
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