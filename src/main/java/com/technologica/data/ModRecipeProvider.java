package com.technologica.data;

import java.util.function.Consumer;

import com.technologica.items.ModItems;

import net.minecraft.data.DataGenerator;
import net.minecraft.data.IFinishedRecipe;
import net.minecraft.data.RecipeProvider;
import net.minecraft.data.ShapelessRecipeBuilder;
import net.minecraft.item.Items;

public class ModRecipeProvider extends RecipeProvider {

	public ModRecipeProvider(DataGenerator generatorIn) {
		super(generatorIn);
	}
	
	@Override
	protected void registerRecipes(Consumer<IFinishedRecipe> consumer) {
		ShapelessRecipeBuilder.shapelessRecipe(ModItems.BANANAS_FOSTER.get(), 1).addIngredient(ModItems.BANANA.get()).addIngredient(Items.ICE).addIngredient(Items.MILK_BUCKET).addIngredient(Items.SUGAR).addCriterion("has_banana", hasItem(ModItems.BANANA.get())).build(consumer, "bananas_foster_from_banana");
		ShapelessRecipeBuilder.shapelessRecipe(ModItems.BLACK_FOREST_CAKE.get(), 1).addIngredient(ModItems.CHERRY.get()).addIngredient(Items.EGG).addIngredient(Items.MILK_BUCKET).addIngredient(Items.SUGAR).addIngredient(Items.COCOA_BEANS).addCriterion("has_cherry", hasItem(ModItems.CHERRY.get())).build(consumer, "black_forest_cake_from_cherry");
		ShapelessRecipeBuilder.shapelessRecipe(ModItems.BLUEBERRY_SEEDS.get(), 2).addIngredient(ModItems.BLUEBERRY.get()).addCriterion("has_blueberry", hasItem(ModItems.BLUEBERRY.get())).build(consumer, "blueberry_seeds_from_blueberry");
		ShapelessRecipeBuilder.shapelessRecipe(ModItems.BLUEBERRY_CHEESECAKE.get(), 1).addIngredient(ModItems.BLUEBERRY.get()).addIngredient(Items.COOKIE).addIngredient(Items.MILK_BUCKET).addIngredient(Items.SUGAR).addCriterion("has_blueberry", hasItem(ModItems.BLUEBERRY.get())).build(consumer, "blueberry_cheesecake_from_blueberry");
		ShapelessRecipeBuilder.shapelessRecipe(ModItems.COCONUT_CREAM_PIE.get(), 1).addIngredient(ModItems.COCONUT.get()).addIngredient(Items.EGG).addIngredient(Items.MILK_BUCKET).addIngredient(Items.SUGAR).addCriterion("has_coconut", hasItem(ModItems.COCONUT.get())).build(consumer, "coconut_cream_pie_from_coconut");
		ShapelessRecipeBuilder.shapelessRecipe(ModItems.GRAPE_SEEDS.get(), 2).addIngredient(ModItems.GRAPE.get()).addCriterion("has_grape", hasItem(ModItems.GRAPE.get())).build(consumer, "grape_seeds_from_grape");
		ShapelessRecipeBuilder.shapelessRecipe(ModItems.GRAPE_SHAVED_ICE.get(), 1).addIngredient(ModItems.GRAPE.get()).addIngredient(Items.SNOWBALL).addCriterion("has_grape", hasItem(ModItems.GRAPE.get())).build(consumer, "grape_shaved_ice_from_grape");
		ShapelessRecipeBuilder.shapelessRecipe(ModItems.KEY_LIME_MOUSSE.get(), 1).addIngredient(ModItems.LIME.get()).addIngredient(Items.MILK_BUCKET).addIngredient(Items.SUGAR).addCriterion("has_lime", hasItem(ModItems.LIME.get())).build(consumer, "key_lime_mousse_from_lime");
		ShapelessRecipeBuilder.shapelessRecipe(ModItems.KIWI_SORBET.get(), 1).addIngredient(ModItems.KIWI.get()).addIngredient(Items.SNOWBALL).addIngredient(Items.MILK_BUCKET).addIngredient(Items.SUGAR).addCriterion("has_kiwi", hasItem(ModItems.KIWI.get())).build(consumer, "kiwi_sorbet_from_kiwi");
		ShapelessRecipeBuilder.shapelessRecipe(ModItems.LEMON_BAR.get(), 1).addIngredient(ModItems.LEMON.get()).addIngredient(Items.EGG).addIngredient(Items.SUGAR).addCriterion("has_lemon", hasItem(ModItems.LEMON.get())).build(consumer, "lemon_bar_from_lemon");
		ShapelessRecipeBuilder.shapelessRecipe(ModItems.ORANGE_DREAMSICLE.get(), 1).addIngredient(ModItems.ORANGE.get()).addIngredient(Items.ICE).addIngredient(Items.MILK_BUCKET).addIngredient(Items.SUGAR).addCriterion("has_orange", hasItem(ModItems.ORANGE.get())).build(consumer, "orange_dreamsicle_from_orange");
		ShapelessRecipeBuilder.shapelessRecipe(ModItems.PEACH_COBBLER.get(), 1).addIngredient(ModItems.PEACH.get()).addIngredient(Items.WHEAT).addIngredient(Items.SUGAR).addCriterion("has_peach", hasItem(ModItems.PEACH.get())).build(consumer, "peach_cobbler_from_peach");
		ShapelessRecipeBuilder.shapelessRecipe(ModItems.PEAR_TART.get(), 1).addIngredient(ModItems.PEAR.get()).addIngredient(Items.WHEAT).addIngredient(Items.SUGAR).addCriterion("has_pear", hasItem(ModItems.PEAR.get())).build(consumer, "pear_tart_from_pear");
		ShapelessRecipeBuilder.shapelessRecipe(ModItems.STRAWBERRY_SEEDS.get(), 2).addIngredient(ModItems.STRAWBERRY.get()).addCriterion("has_strawberry", hasItem(ModItems.STRAWBERRY.get())).build(consumer, "strawberry_seeds_from_strawberry");
		ShapelessRecipeBuilder.shapelessRecipe(ModItems.STRAWBERRY_SHORTCAKE.get(), 1).addIngredient(ModItems.STRAWBERRY.get()).addIngredient(Items.EGG).addIngredient(Items.MILK_BUCKET).addIngredient(Items.SUGAR).addIngredient(Items.WHEAT).addCriterion("has_strawberry", hasItem(ModItems.STRAWBERRY.get())).build(consumer, "strawberry_shortcake_from_strawberry");
	}
}
