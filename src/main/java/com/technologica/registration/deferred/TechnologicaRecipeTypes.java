package com.technologica.registration.deferred;

import com.technologica.Technologica;
import com.technologica.world.item.crafting.SawmillRecipe;

import net.minecraft.world.item.crafting.RecipeType;
import net.minecraftforge.registries.RegistryObject;

public final class TechnologicaRecipeTypes {
	public static final RegistryObject<RecipeType<SawmillRecipe>> SAWMILL = Technologica.RECIPE_TYPES.register("sawmill", () -> new RecipeType<SawmillRecipe>() {
	});
}
