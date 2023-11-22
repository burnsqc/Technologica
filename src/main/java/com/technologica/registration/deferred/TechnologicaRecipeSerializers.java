package com.technologica.registration.deferred;

import com.technologica.Technologica;
import com.technologica.registration.deferred.util.MasterDeferredRegistrar;
import com.technologica.world.item.crafting.SawmillRecipe;

import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraftforge.registries.RegistryObject;

public final class TechnologicaRecipeSerializers extends MasterDeferredRegistrar {
	
	public static int init() {
		RECIPE_SERIALIZERS.register(Technologica.MOD_EVENT_BUS);
		return RECIPE_SERIALIZERS.getEntries().size();
	}

	public static final RegistryObject<RecipeSerializer<SawmillRecipe>> SAWMILL = RECIPE_SERIALIZERS.register("sawmill", SawmillRecipe.Serializer::new);
}