package com.technologica.data;

import java.util.function.Consumer;

import com.technologica.items.ModItems;

import net.minecraft.data.DataGenerator;
import net.minecraft.data.IFinishedRecipe;
import net.minecraft.data.RecipeProvider;
import net.minecraft.data.ShapelessRecipeBuilder;

public class ModRecipeProvider extends RecipeProvider {

	public ModRecipeProvider(DataGenerator generatorIn) {
		super(generatorIn);
	}
	
	@Override
	protected void registerRecipes(Consumer<IFinishedRecipe> consumer) {
		ShapelessRecipeBuilder.shapelessRecipe(ModItems.BLUEBERRY_SEEDS.get(), 2).addIngredient(ModItems.BLUEBERRY.get()).addCriterion("has_blueberry", hasItem(ModItems.BLUEBERRY.get())).build(consumer, "blueberry_seeds_from_blueberry");
		ShapelessRecipeBuilder.shapelessRecipe(ModItems.GRAPE_SEEDS.get(), 2).addIngredient(ModItems.GRAPE.get()).addCriterion("has_grape", hasItem(ModItems.GRAPE.get())).build(consumer, "grape_seeds_from_grape");
		ShapelessRecipeBuilder.shapelessRecipe(ModItems.STRAWBERRY_SEEDS.get(), 2).addIngredient(ModItems.STRAWBERRY.get()).addCriterion("has_strawberry", hasItem(ModItems.STRAWBERRY.get())).build(consumer, "strawberry_seeds_from_strawberry");
	}
}
