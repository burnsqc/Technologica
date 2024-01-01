package com.technologica.registration.deferred;

import com.technologica.Technologica;
import com.technologica.registration.deferred.util.MasterDeferredRegistrar;
import com.technologica.world.item.crafting.SawmillRecipe;

import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraftforge.registries.RegistryObject;

/**
 * <p>
 * This class contains Registry Objects for Recipe Serializers.
 * The {@link #init} method is called by {@link Technologica#initDeferredRegisters} and returns a head-count to later be checked during registration and other setup activities.
 * </p>
 * 
 * @tl.status GREEN
 */
public final class TechnologicaRecipeSerializers extends MasterDeferredRegistrar {
	
	public static int init() {
		RECIPE_SERIALIZERS.register(Technologica.MOD_EVENT_BUS);
		return RECIPE_SERIALIZERS.getEntries().size();
	}

	public static final RegistryObject<RecipeSerializer<SawmillRecipe>> SAWMILL = RECIPE_SERIALIZERS.register("sawmill", SawmillRecipe.Serializer::new);
}