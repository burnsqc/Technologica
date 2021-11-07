package com.technologica.data;

import java.util.function.Consumer;

import com.technologica.Technologica;
import com.technologica.block.TechnologicaBlocks;
import com.technologica.item.TechnologicaItems;
import com.technologica.item.crafting.TechnologicaRecipeSerializer;
import com.technologica.tags.TechnologicaItemTags;

import net.minecraft.data.DataGenerator;
import net.minecraft.data.IFinishedRecipe;
import net.minecraft.data.RecipeProvider;
import net.minecraft.data.ShapelessRecipeBuilder;
import net.minecraft.data.SingleItemRecipeBuilder;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.tags.ITag;
import net.minecraft.util.IItemProvider;
import net.minecraft.util.ResourceLocation;

public class ModRecipeProvider extends RecipeProvider {

	public ModRecipeProvider(DataGenerator generatorIn) {
		super(generatorIn);
	}
	
	@Override
	protected void registerRecipes(Consumer<IFinishedRecipe> consumer) {
		shapelessPlanks(consumer, TechnologicaBlocks.APRICOT_PLANKS.get(), TechnologicaItemTags.APRICOT_LOGS);
		shapelessPlanks(consumer, TechnologicaBlocks.ASPEN_PLANKS.get(), TechnologicaItemTags.ASPEN_LOGS);
		shapelessPlanks(consumer, TechnologicaBlocks.AVOCADO_PLANKS.get(), TechnologicaItemTags.AVOCADO_LOGS);
		shapelessPlanks(consumer, TechnologicaBlocks.BANANA_PLANKS.get(), TechnologicaItemTags.BANANA_LOGS);
		shapelessPlanks(consumer, TechnologicaBlocks.CHERRY_PLANKS.get(), TechnologicaItemTags.CHERRY_LOGS);
		shapelessPlanks(consumer, TechnologicaBlocks.CHESTNUT_PLANKS.get(), TechnologicaItemTags.CHESTNUT_LOGS);
		shapelessPlanks(consumer, TechnologicaBlocks.CINNAMON_PLANKS.get(), TechnologicaItemTags.CINNAMON_LOGS);
		shapelessPlanks(consumer, TechnologicaBlocks.COCONUT_PLANKS.get(), TechnologicaItemTags.COCONUT_LOGS);
		shapelessPlanks(consumer, TechnologicaBlocks.EBONY_PLANKS.get(), TechnologicaItemTags.EBONY_LOGS);
		shapelessPlanks(consumer, TechnologicaBlocks.KIWI_PLANKS.get(), TechnologicaItemTags.KIWI_LOGS);
		shapelessPlanks(consumer, TechnologicaBlocks.LEMON_PLANKS.get(), TechnologicaItemTags.LEMON_LOGS);
		shapelessPlanks(consumer, TechnologicaBlocks.LIME_PLANKS.get(), TechnologicaItemTags.LIME_LOGS);
		shapelessPlanks(consumer, TechnologicaBlocks.MAHOGANY_PLANKS.get(), TechnologicaItemTags.MAHOGANY_LOGS);
		shapelessPlanks(consumer, TechnologicaBlocks.MAPLE_PLANKS.get(), TechnologicaItemTags.MAPLE_LOGS);
		shapelessPlanks(consumer, TechnologicaBlocks.OLIVE_PLANKS.get(), TechnologicaItemTags.OLIVE_LOGS);
		shapelessPlanks(consumer, TechnologicaBlocks.ORANGE_PLANKS.get(), TechnologicaItemTags.ORANGE_LOGS);
		shapelessPlanks(consumer, TechnologicaBlocks.PEACH_PLANKS.get(), TechnologicaItemTags.PEACH_LOGS);
		shapelessPlanks(consumer, TechnologicaBlocks.PEAR_PLANKS.get(), TechnologicaItemTags.PEAR_LOGS);
		shapelessPlanks(consumer, TechnologicaBlocks.PLUM_PLANKS.get(), TechnologicaItemTags.PLUM_LOGS);
		shapelessPlanks(consumer, TechnologicaBlocks.REDWOOD_PLANKS.get(), TechnologicaItemTags.REDWOOD_LOGS);
		shapelessPlanks(consumer, TechnologicaBlocks.ROSEWOOD_PLANKS.get(), TechnologicaItemTags.ROSEWOOD_LOGS);
		shapelessPlanks(consumer, TechnologicaBlocks.RUBBER_PLANKS.get(), TechnologicaItemTags.RUBBER_LOGS);
		shapelessPlanks(consumer, TechnologicaBlocks.TEAK_PLANKS.get(), TechnologicaItemTags.TEAK_LOGS);
		shapelessPlanks(consumer, TechnologicaBlocks.WALNUT_PLANKS.get(), TechnologicaItemTags.WALNUT_LOGS);
		shapelessPlanks(consumer, TechnologicaBlocks.ZEBRAWOOD_PLANKS.get(), TechnologicaItemTags.ZEBRAWOOD_LOGS);
		shapelessPlanks(consumer, TechnologicaBlocks.ALCHEMICAL_PLANKS.get(), TechnologicaItemTags.ALCHEMICAL_LOGS);
		shapelessPlanks(consumer, TechnologicaBlocks.BENEVOLENT_PLANKS.get(), TechnologicaItemTags.BENEVOLENT_LOGS);
		shapelessPlanks(consumer, TechnologicaBlocks.CONDUCTIVE_PLANKS.get(), TechnologicaItemTags.CONDUCTIVE_LOGS);
		shapelessPlanks(consumer, TechnologicaBlocks.FROSTBITTEN_PLANKS.get(), TechnologicaItemTags.FROSTBITTEN_LOGS);
		shapelessPlanks(consumer, TechnologicaBlocks.FRUITFUL_PLANKS.get(), TechnologicaItemTags.FRUITFUL_LOGS);
		shapelessPlanks(consumer, TechnologicaBlocks.INFERNAL_PLANKS.get(), TechnologicaItemTags.INFERNAL_LOGS);
		shapelessPlanks(consumer, TechnologicaBlocks.MALEVOLENT_PLANKS.get(), TechnologicaItemTags.MALEVOLENT_LOGS);
		
		ShapelessRecipeBuilder.shapelessRecipe(TechnologicaItems.BANANAS_FOSTER.get(), 1).addIngredient(TechnologicaItems.BANANA.get()).addIngredient(Items.ICE).addIngredient(Items.MILK_BUCKET).addIngredient(Items.SUGAR).addCriterion("has_banana", hasItem(TechnologicaItems.BANANA.get())).build(consumer, "bananas_foster_from_banana");
		ShapelessRecipeBuilder.shapelessRecipe(TechnologicaItems.BLACK_FOREST_CAKE.get(), 1).addIngredient(TechnologicaItems.CHERRY.get()).addIngredient(Items.EGG).addIngredient(Items.MILK_BUCKET).addIngredient(Items.SUGAR).addIngredient(Items.COCOA_BEANS).addCriterion("has_cherry", hasItem(TechnologicaItems.CHERRY.get())).build(consumer, "black_forest_cake_from_cherry");
		ShapelessRecipeBuilder.shapelessRecipe(TechnologicaItems.BLUEBERRY_CHEESECAKE.get(), 1).addIngredient(TechnologicaItems.BLUEBERRY.get()).addIngredient(Items.COOKIE).addIngredient(Items.MILK_BUCKET).addIngredient(Items.SUGAR).addCriterion("has_blueberry", hasItem(TechnologicaItems.BLUEBERRY.get())).build(consumer, "blueberry_cheesecake_from_blueberry");
		ShapelessRecipeBuilder.shapelessRecipe(TechnologicaItems.COCONUT_CREAM_PIE.get(), 1).addIngredient(TechnologicaItems.COCONUT.get()).addIngredient(Items.EGG).addIngredient(Items.MILK_BUCKET).addIngredient(Items.SUGAR).addCriterion("has_coconut", hasItem(TechnologicaItems.COCONUT.get())).build(consumer, "coconut_cream_pie_from_coconut");
		ShapelessRecipeBuilder.shapelessRecipe(TechnologicaItems.GRAPE_SHAVED_ICE.get(), 1).addIngredient(TechnologicaItems.GRAPE.get()).addIngredient(Items.SNOWBALL).addCriterion("has_grape", hasItem(TechnologicaItems.GRAPE.get())).build(consumer, "grape_shaved_ice_from_grape");
		ShapelessRecipeBuilder.shapelessRecipe(TechnologicaItems.KEY_LIME_MOUSSE.get(), 1).addIngredient(TechnologicaItems.LIME.get()).addIngredient(Items.MILK_BUCKET).addIngredient(Items.SUGAR).addCriterion("has_lime", hasItem(TechnologicaItems.LIME.get())).build(consumer, "key_lime_mousse_from_lime");
		ShapelessRecipeBuilder.shapelessRecipe(TechnologicaItems.KIWI_SORBET.get(), 1).addIngredient(TechnologicaItems.KIWI.get()).addIngredient(Items.SNOWBALL).addIngredient(Items.MILK_BUCKET).addIngredient(Items.SUGAR).addCriterion("has_kiwi", hasItem(TechnologicaItems.KIWI.get())).build(consumer, "kiwi_sorbet_from_kiwi");
		ShapelessRecipeBuilder.shapelessRecipe(TechnologicaItems.LEMON_BAR.get(), 1).addIngredient(TechnologicaItems.LEMON.get()).addIngredient(Items.EGG).addIngredient(Items.SUGAR).addCriterion("has_lemon", hasItem(TechnologicaItems.LEMON.get())).build(consumer, "lemon_bar_from_lemon");
		ShapelessRecipeBuilder.shapelessRecipe(TechnologicaItems.ORANGE_DREAMSICLE.get(), 1).addIngredient(TechnologicaItems.ORANGE.get()).addIngredient(Items.ICE).addIngredient(Items.MILK_BUCKET).addIngredient(Items.SUGAR).addCriterion("has_orange", hasItem(TechnologicaItems.ORANGE.get())).build(consumer, "orange_dreamsicle_from_orange");
		ShapelessRecipeBuilder.shapelessRecipe(TechnologicaItems.PEACH_COBBLER.get(), 1).addIngredient(TechnologicaItems.PEACH.get()).addIngredient(Items.WHEAT).addIngredient(Items.SUGAR).addCriterion("has_peach", hasItem(TechnologicaItems.PEACH.get())).build(consumer, "peach_cobbler_from_peach");
		ShapelessRecipeBuilder.shapelessRecipe(TechnologicaItems.PEAR_TART.get(), 1).addIngredient(TechnologicaItems.PEAR.get()).addIngredient(Items.WHEAT).addIngredient(Items.SUGAR).addCriterion("has_pear", hasItem(TechnologicaItems.PEAR.get())).build(consumer, "pear_tart_from_pear");
		ShapelessRecipeBuilder.shapelessRecipe(TechnologicaItems.STRAWBERRY_SHORTCAKE.get(), 1).addIngredient(TechnologicaItems.STRAWBERRY.get()).addIngredient(Items.EGG).addIngredient(Items.MILK_BUCKET).addIngredient(Items.SUGAR).addIngredient(Items.WHEAT).addCriterion("has_strawberry", hasItem(TechnologicaItems.STRAWBERRY.get())).build(consumer, "strawberry_shortcake_from_strawberry");
		
		sawmillRecipe(Ingredient.fromTag(TechnologicaItemTags.APRICOT_LOGS), TechnologicaItems.APRICOT_PLANKS_ITEM.get(), 1).build(consumer, new ResourceLocation(Technologica.MODID, "apricot_planks_from_apricot_logs_sawmill"));
		sawmillRecipe(Ingredient.fromTag(TechnologicaItemTags.ASPEN_LOGS), TechnologicaItems.ASPEN_PLANKS_ITEM.get(), 1).build(consumer, new ResourceLocation(Technologica.MODID, "aspen_planks_from_aspen_logs_sawmill"));
	}	
	
	private static void shapelessPlanks(Consumer<IFinishedRecipe> recipeConsumer, IItemProvider planks, ITag<Item> input) {
		ShapelessRecipeBuilder.shapelessRecipe(planks, 4).addIngredient(input).setGroup("planks").addCriterion("has_logs", hasItem(input)).build(recipeConsumer);
	}
	
	public static SingleItemRecipeBuilder sawmillRecipe(Ingredient ingredientIn, IItemProvider resultIn, int countIn) {
		return new SingleItemRecipeBuilder(TechnologicaRecipeSerializer.SAWMILL.get(), ingredientIn, resultIn, countIn).addCriterion("has_logs", hasItem(TechnologicaItemTags.APRICOT_LOGS));
	}
}
