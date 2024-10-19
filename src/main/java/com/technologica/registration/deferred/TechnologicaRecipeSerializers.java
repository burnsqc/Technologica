package com.technologica.registration.deferred;

import com.technologica.Technologica;
import com.technologica.world.item.crafting.SawmillRecipe;

import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraftforge.registries.RegistryObject;

public final class TechnologicaRecipeSerializers {
	public static final RegistryObject<RecipeSerializer<SawmillRecipe>> SAWMILL = Technologica.RECIPE_SERIALIZERS.register("sawmill", SawmillRecipe.Serializer::new);
}
