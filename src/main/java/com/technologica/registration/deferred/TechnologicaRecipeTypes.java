package com.technologica.registration.deferred;

import com.technologica.Technologica;
import com.technologica.registration.deferred.util.MasterDeferredRegistrar;
import com.technologica.world.item.crafting.SawmillRecipe;

import net.minecraft.world.item.crafting.RecipeType;
import net.minecraftforge.registries.RegistryObject;

/**
 * <p>
 * This class contains Registry Objects for Recipe Types.
 * The {@link #init} method is called by {@link Technologica#initDeferredRegisters} and returns a head-count to later be checked during registration and other setup activities.
 * </p>
 * 
 * @tl.status GREEN
 */
public final class TechnologicaRecipeTypes extends MasterDeferredRegistrar {
	
	public static int init() {
		RECIPE_TYPES.register(Technologica.MOD_EVENT_BUS);
		return RECIPE_TYPES.getEntries().size();
	}

	public static final RegistryObject<RecipeType<SawmillRecipe>> SAWMILL = RECIPE_TYPES.register("sawmill", () -> new RecipeType<SawmillRecipe>() {
		@Override
		public String toString() {
			return "sawmill";
		}
	});
}