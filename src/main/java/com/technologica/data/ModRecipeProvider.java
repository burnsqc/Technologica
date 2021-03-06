package com.technologica.data;

import java.util.function.Consumer;

import com.technologica.Technologica;
import com.technologica.block.TechnologicaBlocks;
import com.technologica.item.TechnologicaItems;
import com.technologica.tags.TechnologicaItemTags;
import com.technologica.util.DisablePlankConditionFactory;
import com.technologica.util.EnablePlankConditionFactory;

import net.minecraft.block.Blocks;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.IFinishedRecipe;
import net.minecraft.data.RecipeProvider;
import net.minecraft.data.ShapedRecipeBuilder;
import net.minecraft.data.ShapelessRecipeBuilder;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.tags.ITag;
import net.minecraft.tags.ItemTags;
import net.minecraft.util.IItemProvider;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.crafting.ConditionalRecipe;

public class ModRecipeProvider extends RecipeProvider {

	public ModRecipeProvider(DataGenerator generatorIn) {
		super(generatorIn);
	}
	
	@Override
	protected void registerRecipes(Consumer<IFinishedRecipe> consumer) {
		vanillaPlanks(consumer, Blocks.OAK_PLANKS, ItemTags.OAK_LOGS);
		vanillaPlanks(consumer, Blocks.SPRUCE_PLANKS, ItemTags.SPRUCE_LOGS);
		vanillaPlanks(consumer, Blocks.BIRCH_PLANKS, ItemTags.BIRCH_LOGS);
		vanillaPlanks(consumer, Blocks.JUNGLE_PLANKS, ItemTags.JUNGLE_LOGS);
		vanillaPlanks(consumer, Blocks.ACACIA_PLANKS, ItemTags.ACACIA_LOGS);
		vanillaPlanks(consumer, Blocks.DARK_OAK_PLANKS, ItemTags.DARK_OAK_LOGS);
		vanillaPlanks(consumer, Blocks.CRIMSON_PLANKS, ItemTags.CRIMSON_STEMS);
		vanillaPlanks(consumer, Blocks.WARPED_PLANKS, ItemTags.WARPED_STEMS);
		
		vanillaSlabs(consumer, Blocks.OAK_SLAB, Blocks.OAK_PLANKS);
		vanillaSlabs(consumer, Blocks.SPRUCE_SLAB, Blocks.SPRUCE_PLANKS);
		vanillaSlabs(consumer, Blocks.BIRCH_SLAB, Blocks.BIRCH_PLANKS);
		vanillaSlabs(consumer, Blocks.JUNGLE_SLAB, Blocks.JUNGLE_PLANKS);
		vanillaSlabs(consumer, Blocks.ACACIA_SLAB, Blocks.ACACIA_PLANKS);
		vanillaSlabs(consumer, Blocks.DARK_OAK_SLAB, Blocks.DARK_OAK_PLANKS);
		vanillaSlabs(consumer, Blocks.CRIMSON_SLAB, Blocks.CRIMSON_PLANKS);
		vanillaSlabs(consumer, Blocks.WARPED_SLAB, Blocks.WARPED_PLANKS);
		
		vanillaStairs(consumer, Blocks.OAK_STAIRS, Blocks.OAK_PLANKS);
		vanillaStairs(consumer, Blocks.SPRUCE_STAIRS, Blocks.SPRUCE_PLANKS);
		vanillaStairs(consumer, Blocks.BIRCH_STAIRS, Blocks.BIRCH_PLANKS);
		vanillaStairs(consumer, Blocks.JUNGLE_STAIRS, Blocks.JUNGLE_PLANKS);
		vanillaStairs(consumer, Blocks.ACACIA_STAIRS, Blocks.ACACIA_PLANKS);
		vanillaStairs(consumer, Blocks.DARK_OAK_STAIRS, Blocks.DARK_OAK_PLANKS);
		vanillaStairs(consumer, Blocks.CRIMSON_STAIRS, Blocks.CRIMSON_PLANKS);
		vanillaStairs(consumer, Blocks.WARPED_STAIRS, Blocks.WARPED_PLANKS);
		
		vanillaLikePlanks(consumer, TechnologicaBlocks.APRICOT_PLANKS.get(), TechnologicaItemTags.APRICOT_LOGS);
		vanillaLikePlanks(consumer, TechnologicaBlocks.ASPEN_PLANKS.get(), TechnologicaItemTags.ASPEN_LOGS);
		vanillaLikePlanks(consumer, TechnologicaBlocks.AVOCADO_PLANKS.get(), TechnologicaItemTags.AVOCADO_LOGS);
		vanillaLikePlanks(consumer, TechnologicaBlocks.BANANA_PLANKS.get(), TechnologicaItemTags.BANANA_LOGS);
		vanillaLikePlanks(consumer, TechnologicaBlocks.CHERRY_PLANKS.get(), TechnologicaItemTags.CHERRY_LOGS);
		vanillaLikePlanks(consumer, TechnologicaBlocks.CHESTNUT_PLANKS.get(), TechnologicaItemTags.CHESTNUT_LOGS);
		vanillaLikePlanks(consumer, TechnologicaBlocks.CINNAMON_PLANKS.get(), TechnologicaItemTags.CINNAMON_LOGS);
		vanillaLikePlanks(consumer, TechnologicaBlocks.COCONUT_PLANKS.get(), TechnologicaItemTags.COCONUT_LOGS);
		vanillaLikePlanks(consumer, TechnologicaBlocks.EBONY_PLANKS.get(), TechnologicaItemTags.EBONY_LOGS);
		vanillaLikePlanks(consumer, TechnologicaBlocks.KIWI_PLANKS.get(), TechnologicaItemTags.KIWI_LOGS);
		vanillaLikePlanks(consumer, TechnologicaBlocks.LEMON_PLANKS.get(), TechnologicaItemTags.LEMON_LOGS);
		vanillaLikePlanks(consumer, TechnologicaBlocks.LIME_PLANKS.get(), TechnologicaItemTags.LIME_LOGS);
		vanillaLikePlanks(consumer, TechnologicaBlocks.MAHOGANY_PLANKS.get(), TechnologicaItemTags.MAHOGANY_LOGS);
		vanillaLikePlanks(consumer, TechnologicaBlocks.MAPLE_PLANKS.get(), TechnologicaItemTags.MAPLE_LOGS);
		vanillaLikePlanks(consumer, TechnologicaBlocks.OLIVE_PLANKS.get(), TechnologicaItemTags.OLIVE_LOGS);
		vanillaLikePlanks(consumer, TechnologicaBlocks.ORANGE_PLANKS.get(), TechnologicaItemTags.ORANGE_LOGS);
		vanillaLikePlanks(consumer, TechnologicaBlocks.PEACH_PLANKS.get(), TechnologicaItemTags.PEACH_LOGS);
		vanillaLikePlanks(consumer, TechnologicaBlocks.PEAR_PLANKS.get(), TechnologicaItemTags.PEAR_LOGS);
		vanillaLikePlanks(consumer, TechnologicaBlocks.PLUM_PLANKS.get(), TechnologicaItemTags.PLUM_LOGS);
		vanillaLikePlanks(consumer, TechnologicaBlocks.REDWOOD_PLANKS.get(), TechnologicaItemTags.REDWOOD_LOGS);
		vanillaLikePlanks(consumer, TechnologicaBlocks.ROSEWOOD_PLANKS.get(), TechnologicaItemTags.ROSEWOOD_LOGS);
		vanillaLikePlanks(consumer, TechnologicaBlocks.RUBBER_PLANKS.get(), TechnologicaItemTags.RUBBER_LOGS);
		vanillaLikePlanks(consumer, TechnologicaBlocks.TEAK_PLANKS.get(), TechnologicaItemTags.TEAK_LOGS);
		vanillaLikePlanks(consumer, TechnologicaBlocks.WALNUT_PLANKS.get(), TechnologicaItemTags.WALNUT_LOGS);
		vanillaLikePlanks(consumer, TechnologicaBlocks.ZEBRAWOOD_PLANKS.get(), TechnologicaItemTags.ZEBRAWOOD_LOGS);
		vanillaLikePlanks(consumer, TechnologicaBlocks.ALCHEMICAL_PLANKS.get(), TechnologicaItemTags.ALCHEMICAL_LOGS);
		vanillaLikePlanks(consumer, TechnologicaBlocks.BENEVOLENT_PLANKS.get(), TechnologicaItemTags.BENEVOLENT_LOGS);
		vanillaLikePlanks(consumer, TechnologicaBlocks.CONDUCTIVE_PLANKS.get(), TechnologicaItemTags.CONDUCTIVE_LOGS);
		vanillaLikePlanks(consumer, TechnologicaBlocks.FROSTBITTEN_PLANKS.get(), TechnologicaItemTags.FROSTBITTEN_LOGS);
		vanillaLikePlanks(consumer, TechnologicaBlocks.FRUITFUL_PLANKS.get(), TechnologicaItemTags.FRUITFUL_LOGS);
		vanillaLikePlanks(consumer, TechnologicaBlocks.INFERNAL_PLANKS.get(), TechnologicaItemTags.INFERNAL_LOGS);
		vanillaLikePlanks(consumer, TechnologicaBlocks.MALEVOLENT_PLANKS.get(), TechnologicaItemTags.MALEVOLENT_LOGS);
		
		vanillaLikeSlabs(consumer, TechnologicaBlocks.APRICOT_SLAB.get(), TechnologicaBlocks.APRICOT_PLANKS.get());
		vanillaLikeSlabs(consumer, TechnologicaBlocks.ASPEN_SLAB.get(), TechnologicaBlocks.ASPEN_PLANKS.get());
		vanillaLikeSlabs(consumer, TechnologicaBlocks.AVOCADO_SLAB.get(), TechnologicaBlocks.AVOCADO_PLANKS.get());
		vanillaLikeSlabs(consumer, TechnologicaBlocks.BANANA_SLAB.get(), TechnologicaBlocks.BANANA_PLANKS.get());
		vanillaLikeSlabs(consumer, TechnologicaBlocks.CHERRY_SLAB.get(), TechnologicaBlocks.CHERRY_PLANKS.get());
		vanillaLikeSlabs(consumer, TechnologicaBlocks.CHESTNUT_SLAB.get(), TechnologicaBlocks.CHESTNUT_PLANKS.get());
		vanillaLikeSlabs(consumer, TechnologicaBlocks.CINNAMON_SLAB.get(), TechnologicaBlocks.CINNAMON_PLANKS.get());
		vanillaLikeSlabs(consumer, TechnologicaBlocks.COCONUT_SLAB.get(), TechnologicaBlocks.COCONUT_PLANKS.get());
		vanillaLikeSlabs(consumer, TechnologicaBlocks.EBONY_SLAB.get(), TechnologicaBlocks.EBONY_PLANKS.get());
		vanillaLikeSlabs(consumer, TechnologicaBlocks.KIWI_SLAB.get(), TechnologicaBlocks.KIWI_PLANKS.get());
		vanillaLikeSlabs(consumer, TechnologicaBlocks.LEMON_SLAB.get(), TechnologicaBlocks.LEMON_PLANKS.get());
		vanillaLikeSlabs(consumer, TechnologicaBlocks.LIME_SLAB.get(), TechnologicaBlocks.LIME_PLANKS.get());
		vanillaLikeSlabs(consumer, TechnologicaBlocks.MAHOGANY_SLAB.get(), TechnologicaBlocks.MAHOGANY_PLANKS.get());
		vanillaLikeSlabs(consumer, TechnologicaBlocks.MAPLE_SLAB.get(), TechnologicaBlocks.MAPLE_PLANKS.get());
		vanillaLikeSlabs(consumer, TechnologicaBlocks.OLIVE_SLAB.get(), TechnologicaBlocks.OLIVE_PLANKS.get());
		vanillaLikeSlabs(consumer, TechnologicaBlocks.ORANGE_SLAB.get(), TechnologicaBlocks.ORANGE_PLANKS.get());
		vanillaLikeSlabs(consumer, TechnologicaBlocks.PEACH_SLAB.get(), TechnologicaBlocks.PEACH_PLANKS.get());
		vanillaLikeSlabs(consumer, TechnologicaBlocks.PEAR_SLAB.get(), TechnologicaBlocks.PEAR_PLANKS.get());
		vanillaLikeSlabs(consumer, TechnologicaBlocks.PLUM_SLAB.get(), TechnologicaBlocks.PLUM_PLANKS.get());
		vanillaLikeSlabs(consumer, TechnologicaBlocks.REDWOOD_SLAB.get(), TechnologicaBlocks.REDWOOD_PLANKS.get());
		vanillaLikeSlabs(consumer, TechnologicaBlocks.ROSEWOOD_SLAB.get(), TechnologicaBlocks.ROSEWOOD_PLANKS.get());
		vanillaLikeSlabs(consumer, TechnologicaBlocks.RUBBER_SLAB.get(), TechnologicaBlocks.RUBBER_PLANKS.get());
		vanillaLikeSlabs(consumer, TechnologicaBlocks.TEAK_SLAB.get(), TechnologicaBlocks.TEAK_PLANKS.get());
		vanillaLikeSlabs(consumer, TechnologicaBlocks.WALNUT_SLAB.get(), TechnologicaBlocks.WALNUT_PLANKS.get());
		vanillaLikeSlabs(consumer, TechnologicaBlocks.ZEBRAWOOD_SLAB.get(), TechnologicaBlocks.ZEBRAWOOD_PLANKS.get());
		vanillaLikeSlabs(consumer, TechnologicaBlocks.ALCHEMICAL_SLAB.get(), TechnologicaBlocks.ALCHEMICAL_PLANKS.get());
		vanillaLikeSlabs(consumer, TechnologicaBlocks.BENEVOLENT_SLAB.get(), TechnologicaBlocks.BENEVOLENT_PLANKS.get());
		vanillaLikeSlabs(consumer, TechnologicaBlocks.CONDUCTIVE_SLAB.get(), TechnologicaBlocks.CONDUCTIVE_PLANKS.get());
		vanillaLikeSlabs(consumer, TechnologicaBlocks.FROSTBITTEN_SLAB.get(), TechnologicaBlocks.FROSTBITTEN_PLANKS.get());
		vanillaLikeSlabs(consumer, TechnologicaBlocks.FRUITFUL_SLAB.get(), TechnologicaBlocks.FRUITFUL_PLANKS.get());
		vanillaLikeSlabs(consumer, TechnologicaBlocks.INFERNAL_SLAB.get(), TechnologicaBlocks.INFERNAL_PLANKS.get());
		vanillaLikeSlabs(consumer, TechnologicaBlocks.MALEVOLENT_SLAB.get(), TechnologicaBlocks.MALEVOLENT_PLANKS.get());
		
		vanillaLikeStairs(consumer, TechnologicaBlocks.APRICOT_STAIRS.get(), TechnologicaBlocks.APRICOT_PLANKS.get());
		vanillaLikeStairs(consumer, TechnologicaBlocks.ASPEN_STAIRS.get(), TechnologicaBlocks.ASPEN_PLANKS.get());
		vanillaLikeStairs(consumer, TechnologicaBlocks.AVOCADO_STAIRS.get(), TechnologicaBlocks.AVOCADO_PLANKS.get());
		vanillaLikeStairs(consumer, TechnologicaBlocks.BANANA_STAIRS.get(), TechnologicaBlocks.BANANA_PLANKS.get());
		vanillaLikeStairs(consumer, TechnologicaBlocks.CHERRY_STAIRS.get(), TechnologicaBlocks.CHERRY_PLANKS.get());
		vanillaLikeStairs(consumer, TechnologicaBlocks.CHESTNUT_STAIRS.get(), TechnologicaBlocks.CHESTNUT_PLANKS.get());
		vanillaLikeStairs(consumer, TechnologicaBlocks.CINNAMON_STAIRS.get(), TechnologicaBlocks.CINNAMON_PLANKS.get());
		vanillaLikeStairs(consumer, TechnologicaBlocks.COCONUT_STAIRS.get(), TechnologicaBlocks.COCONUT_PLANKS.get());
		vanillaLikeStairs(consumer, TechnologicaBlocks.EBONY_STAIRS.get(), TechnologicaBlocks.EBONY_PLANKS.get());
		vanillaLikeStairs(consumer, TechnologicaBlocks.KIWI_STAIRS.get(), TechnologicaBlocks.KIWI_PLANKS.get());
		vanillaLikeStairs(consumer, TechnologicaBlocks.LEMON_STAIRS.get(), TechnologicaBlocks.LEMON_PLANKS.get());
		vanillaLikeStairs(consumer, TechnologicaBlocks.LIME_STAIRS.get(), TechnologicaBlocks.LIME_PLANKS.get());
		vanillaLikeStairs(consumer, TechnologicaBlocks.MAHOGANY_STAIRS.get(), TechnologicaBlocks.MAHOGANY_PLANKS.get());
		vanillaLikeStairs(consumer, TechnologicaBlocks.MAPLE_STAIRS.get(), TechnologicaBlocks.MAPLE_PLANKS.get());
		vanillaLikeStairs(consumer, TechnologicaBlocks.OLIVE_STAIRS.get(), TechnologicaBlocks.OLIVE_PLANKS.get());
		vanillaLikeStairs(consumer, TechnologicaBlocks.ORANGE_STAIRS.get(), TechnologicaBlocks.ORANGE_PLANKS.get());
		vanillaLikeStairs(consumer, TechnologicaBlocks.PEACH_STAIRS.get(), TechnologicaBlocks.PEACH_PLANKS.get());
		vanillaLikeStairs(consumer, TechnologicaBlocks.PEAR_STAIRS.get(), TechnologicaBlocks.PEAR_PLANKS.get());
		vanillaLikeStairs(consumer, TechnologicaBlocks.PLUM_STAIRS.get(), TechnologicaBlocks.PLUM_PLANKS.get());
		vanillaLikeStairs(consumer, TechnologicaBlocks.REDWOOD_STAIRS.get(), TechnologicaBlocks.REDWOOD_PLANKS.get());
		vanillaLikeStairs(consumer, TechnologicaBlocks.ROSEWOOD_STAIRS.get(), TechnologicaBlocks.ROSEWOOD_PLANKS.get());
		vanillaLikeStairs(consumer, TechnologicaBlocks.RUBBER_STAIRS.get(), TechnologicaBlocks.RUBBER_PLANKS.get());
		vanillaLikeStairs(consumer, TechnologicaBlocks.TEAK_STAIRS.get(), TechnologicaBlocks.TEAK_PLANKS.get());
		vanillaLikeStairs(consumer, TechnologicaBlocks.WALNUT_STAIRS.get(), TechnologicaBlocks.WALNUT_PLANKS.get());
		vanillaLikeStairs(consumer, TechnologicaBlocks.ZEBRAWOOD_STAIRS.get(), TechnologicaBlocks.ZEBRAWOOD_PLANKS.get());
		vanillaLikeStairs(consumer, TechnologicaBlocks.ALCHEMICAL_STAIRS.get(), TechnologicaBlocks.ALCHEMICAL_PLANKS.get());
		vanillaLikeStairs(consumer, TechnologicaBlocks.BENEVOLENT_STAIRS.get(), TechnologicaBlocks.BENEVOLENT_PLANKS.get());
		vanillaLikeStairs(consumer, TechnologicaBlocks.CONDUCTIVE_STAIRS.get(), TechnologicaBlocks.CONDUCTIVE_PLANKS.get());
		vanillaLikeStairs(consumer, TechnologicaBlocks.FROSTBITTEN_STAIRS.get(), TechnologicaBlocks.FROSTBITTEN_PLANKS.get());
		vanillaLikeStairs(consumer, TechnologicaBlocks.FRUITFUL_STAIRS.get(), TechnologicaBlocks.FRUITFUL_PLANKS.get());
		vanillaLikeStairs(consumer, TechnologicaBlocks.INFERNAL_STAIRS.get(), TechnologicaBlocks.INFERNAL_PLANKS.get());
		vanillaLikeStairs(consumer, TechnologicaBlocks.MALEVOLENT_STAIRS.get(), TechnologicaBlocks.MALEVOLENT_PLANKS.get());
		
		proPlanks(consumer, Blocks.OAK_PLANKS, ItemTags.OAK_LOGS);
		proPlanks(consumer, Blocks.SPRUCE_PLANKS, ItemTags.SPRUCE_LOGS);
		proPlanks(consumer, Blocks.BIRCH_PLANKS, ItemTags.BIRCH_LOGS);
		proPlanks(consumer, Blocks.JUNGLE_PLANKS, ItemTags.JUNGLE_LOGS);
		proPlanks(consumer, Blocks.ACACIA_PLANKS, ItemTags.ACACIA_LOGS);
		proPlanks(consumer, Blocks.DARK_OAK_PLANKS, ItemTags.DARK_OAK_LOGS);
		proPlanks(consumer, Blocks.CRIMSON_PLANKS, ItemTags.CRIMSON_STEMS);
		proPlanks(consumer, Blocks.WARPED_PLANKS, ItemTags.WARPED_STEMS);
		proPlanks(consumer, TechnologicaBlocks.APRICOT_PLANKS.get(), TechnologicaItemTags.APRICOT_LOGS);
		proPlanks(consumer, TechnologicaBlocks.ASPEN_PLANKS.get(), TechnologicaItemTags.ASPEN_LOGS);
		proPlanks(consumer, TechnologicaBlocks.AVOCADO_PLANKS.get(), TechnologicaItemTags.AVOCADO_LOGS);
		proPlanks(consumer, TechnologicaBlocks.BANANA_PLANKS.get(), TechnologicaItemTags.BANANA_LOGS);
		proPlanks(consumer, TechnologicaBlocks.CHERRY_PLANKS.get(), TechnologicaItemTags.CHERRY_LOGS);
		proPlanks(consumer, TechnologicaBlocks.CHESTNUT_PLANKS.get(), TechnologicaItemTags.CHESTNUT_LOGS);
		proPlanks(consumer, TechnologicaBlocks.CINNAMON_PLANKS.get(), TechnologicaItemTags.CINNAMON_LOGS);
		proPlanks(consumer, TechnologicaBlocks.COCONUT_PLANKS.get(), TechnologicaItemTags.COCONUT_LOGS);
		proPlanks(consumer, TechnologicaBlocks.EBONY_PLANKS.get(), TechnologicaItemTags.EBONY_LOGS);
		proPlanks(consumer, TechnologicaBlocks.KIWI_PLANKS.get(), TechnologicaItemTags.KIWI_LOGS);
		proPlanks(consumer, TechnologicaBlocks.LEMON_PLANKS.get(), TechnologicaItemTags.LEMON_LOGS);
		proPlanks(consumer, TechnologicaBlocks.LIME_PLANKS.get(), TechnologicaItemTags.LIME_LOGS);
		proPlanks(consumer, TechnologicaBlocks.MAHOGANY_PLANKS.get(), TechnologicaItemTags.MAHOGANY_LOGS);
		proPlanks(consumer, TechnologicaBlocks.MAPLE_PLANKS.get(), TechnologicaItemTags.MAPLE_LOGS);
		proPlanks(consumer, TechnologicaBlocks.OLIVE_PLANKS.get(), TechnologicaItemTags.OLIVE_LOGS);
		proPlanks(consumer, TechnologicaBlocks.ORANGE_PLANKS.get(), TechnologicaItemTags.ORANGE_LOGS);
		proPlanks(consumer, TechnologicaBlocks.PEACH_PLANKS.get(), TechnologicaItemTags.PEACH_LOGS);
		proPlanks(consumer, TechnologicaBlocks.PEAR_PLANKS.get(), TechnologicaItemTags.PEAR_LOGS);
		proPlanks(consumer, TechnologicaBlocks.PLUM_PLANKS.get(), TechnologicaItemTags.PLUM_LOGS);
		proPlanks(consumer, TechnologicaBlocks.REDWOOD_PLANKS.get(), TechnologicaItemTags.REDWOOD_LOGS);
		proPlanks(consumer, TechnologicaBlocks.ROSEWOOD_PLANKS.get(), TechnologicaItemTags.ROSEWOOD_LOGS);
		proPlanks(consumer, TechnologicaBlocks.RUBBER_PLANKS.get(), TechnologicaItemTags.RUBBER_LOGS);
		proPlanks(consumer, TechnologicaBlocks.TEAK_PLANKS.get(), TechnologicaItemTags.TEAK_LOGS);
		proPlanks(consumer, TechnologicaBlocks.WALNUT_PLANKS.get(), TechnologicaItemTags.WALNUT_LOGS);
		proPlanks(consumer, TechnologicaBlocks.ZEBRAWOOD_PLANKS.get(), TechnologicaItemTags.ZEBRAWOOD_LOGS);
		proPlanks(consumer, TechnologicaBlocks.ALCHEMICAL_PLANKS.get(), TechnologicaItemTags.ALCHEMICAL_LOGS);
		proPlanks(consumer, TechnologicaBlocks.BENEVOLENT_PLANKS.get(), TechnologicaItemTags.BENEVOLENT_LOGS);
		proPlanks(consumer, TechnologicaBlocks.CONDUCTIVE_PLANKS.get(), TechnologicaItemTags.CONDUCTIVE_LOGS);
		proPlanks(consumer, TechnologicaBlocks.FROSTBITTEN_PLANKS.get(), TechnologicaItemTags.FROSTBITTEN_LOGS);
		proPlanks(consumer, TechnologicaBlocks.FRUITFUL_PLANKS.get(), TechnologicaItemTags.FRUITFUL_LOGS);
		proPlanks(consumer, TechnologicaBlocks.INFERNAL_PLANKS.get(), TechnologicaItemTags.INFERNAL_LOGS);
		proPlanks(consumer, TechnologicaBlocks.MALEVOLENT_PLANKS.get(), TechnologicaItemTags.MALEVOLENT_LOGS);

		proSlabs(consumer, Blocks.OAK_SLAB, Blocks.OAK_PLANKS);
		proSlabs(consumer, Blocks.SPRUCE_SLAB, Blocks.SPRUCE_PLANKS);
		proSlabs(consumer, Blocks.BIRCH_SLAB, Blocks.BIRCH_PLANKS);
		proSlabs(consumer, Blocks.JUNGLE_SLAB, Blocks.JUNGLE_PLANKS);
		proSlabs(consumer, Blocks.ACACIA_SLAB, Blocks.ACACIA_PLANKS);
		proSlabs(consumer, Blocks.DARK_OAK_SLAB, Blocks.DARK_OAK_PLANKS);
		proSlabs(consumer, Blocks.CRIMSON_SLAB, Blocks.CRIMSON_PLANKS);
		proSlabs(consumer, Blocks.WARPED_SLAB, Blocks.WARPED_PLANKS);
		proSlabs(consumer, TechnologicaBlocks.APRICOT_SLAB.get(), TechnologicaBlocks.APRICOT_PLANKS.get());
		proSlabs(consumer, TechnologicaBlocks.ASPEN_SLAB.get(), TechnologicaBlocks.ASPEN_PLANKS.get());
		proSlabs(consumer, TechnologicaBlocks.AVOCADO_SLAB.get(), TechnologicaBlocks.AVOCADO_PLANKS.get());
		proSlabs(consumer, TechnologicaBlocks.BANANA_SLAB.get(), TechnologicaBlocks.BANANA_PLANKS.get());
		proSlabs(consumer, TechnologicaBlocks.CHERRY_SLAB.get(), TechnologicaBlocks.CHERRY_PLANKS.get());
		proSlabs(consumer, TechnologicaBlocks.CHESTNUT_SLAB.get(), TechnologicaBlocks.CHESTNUT_PLANKS.get());
		proSlabs(consumer, TechnologicaBlocks.CINNAMON_SLAB.get(), TechnologicaBlocks.CINNAMON_PLANKS.get());
		proSlabs(consumer, TechnologicaBlocks.COCONUT_SLAB.get(), TechnologicaBlocks.COCONUT_PLANKS.get());
		proSlabs(consumer, TechnologicaBlocks.EBONY_SLAB.get(), TechnologicaBlocks.EBONY_PLANKS.get());
		proSlabs(consumer, TechnologicaBlocks.KIWI_SLAB.get(), TechnologicaBlocks.KIWI_PLANKS.get());
		proSlabs(consumer, TechnologicaBlocks.LEMON_SLAB.get(), TechnologicaBlocks.LEMON_PLANKS.get());
		proSlabs(consumer, TechnologicaBlocks.LIME_SLAB.get(), TechnologicaBlocks.LIME_PLANKS.get());
		proSlabs(consumer, TechnologicaBlocks.MAHOGANY_SLAB.get(), TechnologicaBlocks.MAHOGANY_PLANKS.get());
		proSlabs(consumer, TechnologicaBlocks.MAPLE_SLAB.get(), TechnologicaBlocks.MAPLE_PLANKS.get());
		proSlabs(consumer, TechnologicaBlocks.OLIVE_SLAB.get(), TechnologicaBlocks.OLIVE_PLANKS.get());
		proSlabs(consumer, TechnologicaBlocks.ORANGE_SLAB.get(), TechnologicaBlocks.ORANGE_PLANKS.get());
		proSlabs(consumer, TechnologicaBlocks.PEACH_SLAB.get(), TechnologicaBlocks.PEACH_PLANKS.get());
		proSlabs(consumer, TechnologicaBlocks.PEAR_SLAB.get(), TechnologicaBlocks.PEAR_PLANKS.get());
		proSlabs(consumer, TechnologicaBlocks.PLUM_SLAB.get(), TechnologicaBlocks.PLUM_PLANKS.get());
		proSlabs(consumer, TechnologicaBlocks.REDWOOD_SLAB.get(), TechnologicaBlocks.REDWOOD_PLANKS.get());
		proSlabs(consumer, TechnologicaBlocks.ROSEWOOD_SLAB.get(), TechnologicaBlocks.ROSEWOOD_PLANKS.get());
		proSlabs(consumer, TechnologicaBlocks.RUBBER_SLAB.get(), TechnologicaBlocks.RUBBER_PLANKS.get());
		proSlabs(consumer, TechnologicaBlocks.TEAK_SLAB.get(), TechnologicaBlocks.TEAK_PLANKS.get());
		proSlabs(consumer, TechnologicaBlocks.WALNUT_SLAB.get(), TechnologicaBlocks.WALNUT_PLANKS.get());
		proSlabs(consumer, TechnologicaBlocks.ZEBRAWOOD_SLAB.get(), TechnologicaBlocks.ZEBRAWOOD_PLANKS.get());
		proSlabs(consumer, TechnologicaBlocks.ALCHEMICAL_SLAB.get(), TechnologicaBlocks.ALCHEMICAL_PLANKS.get());
		proSlabs(consumer, TechnologicaBlocks.BENEVOLENT_SLAB.get(), TechnologicaBlocks.BENEVOLENT_PLANKS.get());
		proSlabs(consumer, TechnologicaBlocks.CONDUCTIVE_SLAB.get(), TechnologicaBlocks.CONDUCTIVE_PLANKS.get());
		proSlabs(consumer, TechnologicaBlocks.FROSTBITTEN_SLAB.get(), TechnologicaBlocks.FROSTBITTEN_PLANKS.get());
		proSlabs(consumer, TechnologicaBlocks.FRUITFUL_SLAB.get(), TechnologicaBlocks.FRUITFUL_PLANKS.get());
		proSlabs(consumer, TechnologicaBlocks.INFERNAL_SLAB.get(), TechnologicaBlocks.INFERNAL_PLANKS.get());
		proSlabs(consumer, TechnologicaBlocks.MALEVOLENT_SLAB.get(), TechnologicaBlocks.MALEVOLENT_PLANKS.get());
		
		proStairs(consumer, Blocks.OAK_STAIRS, Blocks.OAK_PLANKS);
		proStairs(consumer, Blocks.SPRUCE_STAIRS, Blocks.SPRUCE_PLANKS);
		proStairs(consumer, Blocks.BIRCH_STAIRS, Blocks.BIRCH_PLANKS);
		proStairs(consumer, Blocks.JUNGLE_STAIRS, Blocks.JUNGLE_PLANKS);
		proStairs(consumer, Blocks.ACACIA_STAIRS, Blocks.ACACIA_PLANKS);
		proStairs(consumer, Blocks.DARK_OAK_STAIRS, Blocks.DARK_OAK_PLANKS);
		proStairs(consumer, Blocks.CRIMSON_STAIRS, Blocks.CRIMSON_PLANKS);
		proStairs(consumer, Blocks.WARPED_STAIRS, Blocks.WARPED_PLANKS);
		proStairs(consumer, TechnologicaBlocks.APRICOT_STAIRS.get(), TechnologicaBlocks.APRICOT_PLANKS.get());
		proStairs(consumer, TechnologicaBlocks.ASPEN_STAIRS.get(), TechnologicaBlocks.ASPEN_PLANKS.get());
		proStairs(consumer, TechnologicaBlocks.AVOCADO_STAIRS.get(), TechnologicaBlocks.AVOCADO_PLANKS.get());
		proStairs(consumer, TechnologicaBlocks.BANANA_STAIRS.get(), TechnologicaBlocks.BANANA_PLANKS.get());
		proStairs(consumer, TechnologicaBlocks.CHERRY_STAIRS.get(), TechnologicaBlocks.CHERRY_PLANKS.get());
		proStairs(consumer, TechnologicaBlocks.CHESTNUT_STAIRS.get(), TechnologicaBlocks.CHESTNUT_PLANKS.get());
		proStairs(consumer, TechnologicaBlocks.CINNAMON_STAIRS.get(), TechnologicaBlocks.CINNAMON_PLANKS.get());
		proStairs(consumer, TechnologicaBlocks.COCONUT_STAIRS.get(), TechnologicaBlocks.COCONUT_PLANKS.get());
		proStairs(consumer, TechnologicaBlocks.EBONY_STAIRS.get(), TechnologicaBlocks.EBONY_PLANKS.get());
		proStairs(consumer, TechnologicaBlocks.KIWI_STAIRS.get(), TechnologicaBlocks.KIWI_PLANKS.get());
		proStairs(consumer, TechnologicaBlocks.LEMON_STAIRS.get(), TechnologicaBlocks.LEMON_PLANKS.get());
		proStairs(consumer, TechnologicaBlocks.LIME_STAIRS.get(), TechnologicaBlocks.LIME_PLANKS.get());
		proStairs(consumer, TechnologicaBlocks.MAHOGANY_STAIRS.get(), TechnologicaBlocks.MAHOGANY_PLANKS.get());
		proStairs(consumer, TechnologicaBlocks.MAPLE_STAIRS.get(), TechnologicaBlocks.MAPLE_PLANKS.get());
		proStairs(consumer, TechnologicaBlocks.OLIVE_STAIRS.get(), TechnologicaBlocks.OLIVE_PLANKS.get());
		proStairs(consumer, TechnologicaBlocks.ORANGE_STAIRS.get(), TechnologicaBlocks.ORANGE_PLANKS.get());
		proStairs(consumer, TechnologicaBlocks.PEACH_STAIRS.get(), TechnologicaBlocks.PEACH_PLANKS.get());
		proStairs(consumer, TechnologicaBlocks.PEAR_STAIRS.get(), TechnologicaBlocks.PEAR_PLANKS.get());
		proStairs(consumer, TechnologicaBlocks.PLUM_STAIRS.get(), TechnologicaBlocks.PLUM_PLANKS.get());
		proStairs(consumer, TechnologicaBlocks.REDWOOD_STAIRS.get(), TechnologicaBlocks.REDWOOD_PLANKS.get());
		proStairs(consumer, TechnologicaBlocks.ROSEWOOD_STAIRS.get(), TechnologicaBlocks.ROSEWOOD_PLANKS.get());
		proStairs(consumer, TechnologicaBlocks.RUBBER_STAIRS.get(), TechnologicaBlocks.RUBBER_PLANKS.get());
		proStairs(consumer, TechnologicaBlocks.TEAK_STAIRS.get(), TechnologicaBlocks.TEAK_PLANKS.get());
		proStairs(consumer, TechnologicaBlocks.WALNUT_STAIRS.get(), TechnologicaBlocks.WALNUT_PLANKS.get());
		proStairs(consumer, TechnologicaBlocks.ZEBRAWOOD_STAIRS.get(), TechnologicaBlocks.ZEBRAWOOD_PLANKS.get());
		proStairs(consumer, TechnologicaBlocks.ALCHEMICAL_STAIRS.get(), TechnologicaBlocks.ALCHEMICAL_PLANKS.get());
		proStairs(consumer, TechnologicaBlocks.BENEVOLENT_STAIRS.get(), TechnologicaBlocks.BENEVOLENT_PLANKS.get());
		proStairs(consumer, TechnologicaBlocks.CONDUCTIVE_STAIRS.get(), TechnologicaBlocks.CONDUCTIVE_PLANKS.get());
		proStairs(consumer, TechnologicaBlocks.FROSTBITTEN_STAIRS.get(), TechnologicaBlocks.FROSTBITTEN_PLANKS.get());
		proStairs(consumer, TechnologicaBlocks.FRUITFUL_STAIRS.get(), TechnologicaBlocks.FRUITFUL_PLANKS.get());
		proStairs(consumer, TechnologicaBlocks.INFERNAL_STAIRS.get(), TechnologicaBlocks.INFERNAL_PLANKS.get());
		proStairs(consumer, TechnologicaBlocks.MALEVOLENT_STAIRS.get(), TechnologicaBlocks.MALEVOLENT_PLANKS.get());
		
		ShapelessRecipeBuilder.shapelessRecipe(TechnologicaItems.BANANAS_FOSTER.get(), 1).addIngredient(TechnologicaItems.BANANA.get()).addIngredient(Items.ICE).addIngredient(Items.MILK_BUCKET).addIngredient(Items.SUGAR).addCriterion("has_banana", hasItem(TechnologicaItems.BANANA.get())).build(consumer, new ResourceLocation(Technologica.MODID, "bananas_foster"));
		ShapelessRecipeBuilder.shapelessRecipe(TechnologicaItems.BLACK_FOREST_CAKE.get(), 1).addIngredient(TechnologicaItems.CHERRY.get()).addIngredient(Items.EGG).addIngredient(Items.MILK_BUCKET).addIngredient(Items.SUGAR).addIngredient(Items.COCOA_BEANS).addCriterion("has_cherry", hasItem(TechnologicaItems.CHERRY.get())).build(consumer, new ResourceLocation(Technologica.MODID, "black_forest_cake"));
		ShapelessRecipeBuilder.shapelessRecipe(TechnologicaItems.BLUEBERRY_CHEESECAKE.get(), 1).addIngredient(TechnologicaItems.BLUEBERRY.get()).addIngredient(Items.COOKIE).addIngredient(Items.MILK_BUCKET).addIngredient(Items.SUGAR).addCriterion("has_blueberry", hasItem(TechnologicaItems.BLUEBERRY.get())).build(consumer, new ResourceLocation(Technologica.MODID, "blueberry_cheesecake"));
		ShapelessRecipeBuilder.shapelessRecipe(TechnologicaItems.COCONUT_CREAM_PIE.get(), 1).addIngredient(TechnologicaItems.COCONUT.get()).addIngredient(Items.EGG).addIngredient(Items.MILK_BUCKET).addIngredient(Items.SUGAR).addCriterion("has_coconut", hasItem(TechnologicaItems.COCONUT.get())).build(consumer, new ResourceLocation(Technologica.MODID, "coconut_cream_pie"));
		ShapelessRecipeBuilder.shapelessRecipe(TechnologicaItems.GRAPE_SHAVED_ICE.get(), 1).addIngredient(TechnologicaItems.GRAPE.get()).addIngredient(Items.SNOWBALL).addCriterion("has_grape", hasItem(TechnologicaItems.GRAPE.get())).build(consumer, new ResourceLocation(Technologica.MODID, "grape_shaved_ice"));
		ShapelessRecipeBuilder.shapelessRecipe(TechnologicaItems.KEY_LIME_MOUSSE.get(), 1).addIngredient(TechnologicaItems.LIME.get()).addIngredient(Items.MILK_BUCKET).addIngredient(Items.SUGAR).addCriterion("has_lime", hasItem(TechnologicaItems.LIME.get())).build(consumer, new ResourceLocation(Technologica.MODID, "key_lime_mousse"));
		ShapelessRecipeBuilder.shapelessRecipe(TechnologicaItems.KIWI_SORBET.get(), 1).addIngredient(TechnologicaItems.KIWI.get()).addIngredient(Items.SNOWBALL).addIngredient(Items.MILK_BUCKET).addIngredient(Items.SUGAR).addCriterion("has_kiwi", hasItem(TechnologicaItems.KIWI.get())).build(consumer, new ResourceLocation(Technologica.MODID, "kiwi_sorbet"));
		ShapelessRecipeBuilder.shapelessRecipe(TechnologicaItems.LEMON_BAR.get(), 1).addIngredient(TechnologicaItems.LEMON.get()).addIngredient(Items.EGG).addIngredient(Items.SUGAR).addCriterion("has_lemon", hasItem(TechnologicaItems.LEMON.get())).build(consumer, new ResourceLocation(Technologica.MODID, "lemon_bar"));
		ShapelessRecipeBuilder.shapelessRecipe(TechnologicaItems.ORANGE_DREAMSICLE.get(), 1).addIngredient(TechnologicaItems.ORANGE.get()).addIngredient(Items.ICE).addIngredient(Items.MILK_BUCKET).addIngredient(Items.SUGAR).addCriterion("has_orange", hasItem(TechnologicaItems.ORANGE.get())).build(consumer, new ResourceLocation(Technologica.MODID, "orange_dreamsicle"));
		ShapelessRecipeBuilder.shapelessRecipe(TechnologicaItems.PEACH_COBBLER.get(), 1).addIngredient(TechnologicaItems.PEACH.get()).addIngredient(Items.WHEAT).addIngredient(Items.SUGAR).addCriterion("has_peach", hasItem(TechnologicaItems.PEACH.get())).build(consumer, new ResourceLocation(Technologica.MODID, "peach_cobbler"));
		ShapelessRecipeBuilder.shapelessRecipe(TechnologicaItems.PEAR_TART.get(), 1).addIngredient(TechnologicaItems.PEAR.get()).addIngredient(Items.WHEAT).addIngredient(Items.SUGAR).addCriterion("has_pear", hasItem(TechnologicaItems.PEAR.get())).build(consumer, new ResourceLocation(Technologica.MODID, "pear_tart"));
		ShapelessRecipeBuilder.shapelessRecipe(TechnologicaItems.STRAWBERRY_SHORTCAKE.get(), 1).addIngredient(TechnologicaItems.STRAWBERRY.get()).addIngredient(Items.EGG).addIngredient(Items.MILK_BUCKET).addIngredient(Items.SUGAR).addIngredient(Items.WHEAT).addCriterion("has_strawberry", hasItem(TechnologicaItems.STRAWBERRY.get())).build(consumer, new ResourceLocation(Technologica.MODID, "strawberry_shortcake"));
		ShapelessRecipeBuilder.shapelessRecipe(TechnologicaItems.TAPENADE.get(), 1).addIngredient(TechnologicaItems.OLIVE.get()).addIngredient(TechnologicaItems.GARLIC.get()).addCriterion("has_olive", hasItem(TechnologicaItems.OLIVE.get())).build(consumer, new ResourceLocation(Technologica.MODID, "tapenade"));
		ShapelessRecipeBuilder.shapelessRecipe(TechnologicaItems.CINNAMON_ROLL.get(), 1).addIngredient(TechnologicaItems.CINNAMON.get()).addIngredient(Items.EGG).addIngredient(Items.SUGAR).addIngredient(Items.MILK_BUCKET).addCriterion("has_cinnamon", hasItem(TechnologicaItems.CINNAMON.get())).build(consumer, new ResourceLocation(Technologica.MODID, "cinnamon_roll"));
		
//		sawmillRecipe(Ingredient.fromTag(TechnologicaItemTags.APRICOT_LOGS), TechnologicaItems.APRICOT_PLANKS_ITEM.get(), 1).build(consumer, new ResourceLocation(Technologica.MODID, "apricot_planks_from_apricot_logs_sawmill"));
//		sawmillRecipe(Ingredient.fromTag(TechnologicaItemTags.ASPEN_LOGS), TechnologicaItems.ASPEN_PLANKS_ITEM.get(), 1).build(consumer, new ResourceLocation(Technologica.MODID, "aspen_planks_from_aspen_logs_sawmill"));
	}	
	
	private static void vanillaPlanks(Consumer<IFinishedRecipe> recipeConsumer, IItemProvider output, ITag<Item> input) {
		ConditionalRecipe.builder().addCondition(new EnablePlankConditionFactory()).addRecipe((consumer2) -> ShapelessRecipeBuilder.shapelessRecipe(output, 4).addIngredient(input).setGroup("planks").addCriterion("has_log", hasItem(input)).build(consumer2)).build(recipeConsumer, new ResourceLocation(output.asItem().getRegistryName().getPath()));
	}
	
	private static void vanillaLikePlanks(Consumer<IFinishedRecipe> recipeConsumer, IItemProvider output, ITag<Item> input) {
		ConditionalRecipe.builder().addCondition(new EnablePlankConditionFactory()).addRecipe((consumer2) -> ShapelessRecipeBuilder.shapelessRecipe(output, 4).addIngredient(input).setGroup("planks").addCriterion("has_log", hasItem(input)).build(consumer2)).build(recipeConsumer, new ResourceLocation(Technologica.MODID, output.asItem().getRegistryName().getPath()));
	}
	
	private static void proPlanks(Consumer<IFinishedRecipe> recipeConsumer, IItemProvider output, ITag<Item> input) {
		ConditionalRecipe.builder().addCondition(new DisablePlankConditionFactory()).addRecipe((consumer2) -> ShapelessRecipeBuilder.shapelessRecipe(output, 1).addIngredient(input).addIngredient(TechnologicaItems.SAW.get()).setGroup("planks").addCriterion("has_saw", hasItem(TechnologicaItems.SAW.get())).build(consumer2)).build(recipeConsumer, new ResourceLocation(Technologica.MODID, output.asItem().getRegistryName().getPath() + "_pro"));
	}
	
	private static void vanillaSlabs(Consumer<IFinishedRecipe> recipeConsumer, IItemProvider output, IItemProvider input) {
		ConditionalRecipe.builder().addCondition(new EnablePlankConditionFactory()).addRecipe((consumer2) -> ShapedRecipeBuilder.shapedRecipe(output, 6).key('#', input).patternLine("###").setGroup("wooden_slab").addCriterion("has_planks", hasItem(input)).build(consumer2)).build(recipeConsumer, new ResourceLocation(output.asItem().getRegistryName().getPath()));
	}
	
	private static void vanillaLikeSlabs(Consumer<IFinishedRecipe> recipeConsumer, IItemProvider output, IItemProvider input) {
		ConditionalRecipe.builder().addCondition(new EnablePlankConditionFactory()).addRecipe((consumer2) -> ShapedRecipeBuilder.shapedRecipe(output, 6).key('#', input).patternLine("###").setGroup("wooden_slab").addCriterion("has_planks", hasItem(input)).build(consumer2)).build(recipeConsumer, new ResourceLocation(Technologica.MODID, output.asItem().getRegistryName().getPath()));
	}
	
	private static void proSlabs(Consumer<IFinishedRecipe> recipeConsumer, IItemProvider output, IItemProvider input) {
		ConditionalRecipe.builder().addCondition(new DisablePlankConditionFactory()).addRecipe((consumer2) -> ShapelessRecipeBuilder.shapelessRecipe(output, 2).addIngredient(input).addIngredient(TechnologicaItems.SAW.get()).setGroup("wooden_slab").addCriterion("has_saw", hasItem(TechnologicaItems.SAW.get())).build(consumer2)).build(recipeConsumer, new ResourceLocation(Technologica.MODID, output.asItem().getRegistryName().getPath() + "_pro"));
	}
	
	private static void vanillaStairs(Consumer<IFinishedRecipe> recipeConsumer, IItemProvider output, IItemProvider input) {
		ConditionalRecipe.builder().addCondition(new EnablePlankConditionFactory()).addRecipe((consumer2) -> ShapedRecipeBuilder.shapedRecipe(output, 4).key('#', input).patternLine("#  ").patternLine("## ").patternLine("###").setGroup("wooden_stairs").addCriterion("has_planks", hasItem(input)).build(consumer2)).build(recipeConsumer, new ResourceLocation(output.asItem().getRegistryName().getPath()));
	}
	
	private static void vanillaLikeStairs(Consumer<IFinishedRecipe> recipeConsumer, IItemProvider output, IItemProvider input) {
		ConditionalRecipe.builder().addCondition(new EnablePlankConditionFactory()).addRecipe((consumer2) -> ShapedRecipeBuilder.shapedRecipe(output, 4).key('#', input).patternLine("#  ").patternLine("## ").patternLine("###").setGroup("wooden_stairs").addCriterion("has_planks", hasItem(input)).build(consumer2)).build(recipeConsumer, new ResourceLocation(Technologica.MODID, output.asItem().getRegistryName().getPath()));
	}
	
	private static void proStairs(Consumer<IFinishedRecipe> recipeConsumer, IItemProvider output, IItemProvider input) {
		ConditionalRecipe.builder().addCondition(new DisablePlankConditionFactory()).addRecipe((consumer2) -> ShapelessRecipeBuilder.shapelessRecipe(output, 1).addIngredient(input).addIngredient(TechnologicaItems.CHISEL.get()).setGroup("wooden_slab").addCriterion("has_chisel", hasItem(TechnologicaItems.CHISEL.get())).build(consumer2)).build(recipeConsumer, new ResourceLocation(Technologica.MODID, output.asItem().getRegistryName().getPath() + "_pro"));
	}
	
//	public static SingleItemRecipeBuilder sawmillRecipe(Ingredient ingredientIn, IItemProvider resultIn, int countIn) {
//		return new SingleItemRecipeBuilder(TechnologicaRecipeSerializer.SAWMILL.get(), ingredientIn, resultIn, countIn).addCriterion("has_logs", hasItem(TechnologicaItemTags.APRICOT_LOGS));
//	}
}
