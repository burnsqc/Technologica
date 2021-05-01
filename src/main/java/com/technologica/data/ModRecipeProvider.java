package com.technologica.data;

import java.util.function.Consumer;

import com.technologica.setup.Registration;

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
		ShapelessRecipeBuilder.shapelessRecipe(Registration.BLUEBERRY_SEEDS.get(), 2).addIngredient(Registration.BLUEBERRY.get()).addCriterion("has_blueberry", hasItem(Registration.BLUEBERRY.get())).build(consumer, "blueberry_seeds_from_blueberry");
		ShapelessRecipeBuilder.shapelessRecipe(Registration.GRAPE_SEEDS.get(), 2).addIngredient(Registration.GRAPE.get()).addCriterion("has_grape", hasItem(Registration.GRAPE.get())).build(consumer, "grape_seeds_from_grape");
		ShapelessRecipeBuilder.shapelessRecipe(Registration.STRAWBERRY_SEEDS.get(), 2).addIngredient(Registration.STRAWBERRY.get()).addCriterion("has_strawberry", hasItem(Registration.STRAWBERRY.get())).build(consumer, "strawberry_seeds_from_strawberry");
	}
}
