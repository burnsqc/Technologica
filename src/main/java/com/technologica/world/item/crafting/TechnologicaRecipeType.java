package com.technologica.world.item.crafting;

import com.technologica.Technologica;

import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.item.crafting.RecipeType;

public class TechnologicaRecipeType {

	public static RecipeType<SawmillRecipe> SAWMILL;

	public static void register() {
		SAWMILL = RecipeType.register("sawmill");
	}

	static <T extends Recipe<?>> RecipeType<T> register(final String p_44120_) {
		return Registry.register(Registry.RECIPE_TYPE, new ResourceLocation(Technologica.MODID, p_44120_), new RecipeType<T>() {
			@Override
			public String toString() {
				return p_44120_;
			}
		});
	}
}
