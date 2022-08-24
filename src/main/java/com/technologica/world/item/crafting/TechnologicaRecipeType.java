package com.technologica.world.item.crafting;

import static com.technologica.Technologica.LOGGER;

import com.technologica.Technologica;

import net.minecraft.world.item.crafting.RecipeType;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class TechnologicaRecipeType {
	public static final DeferredRegister<RecipeType<?>> RECIPE_TYPES = DeferredRegister.create(ForgeRegistries.Keys.RECIPE_TYPES, Technologica.MODID);

	public static void init() {
		RECIPE_TYPES.register(FMLJavaModLoadingContext.get().getModEventBus());
		LOGGER.info("RECIPE TYPES INITIALIZED: " + RECIPE_TYPES.getEntries().size() + " OF 1");
	}

	public static final RegistryObject<RecipeType<SawmillRecipe>> SAWMILL = RECIPE_TYPES.register("sawmill", () -> new RecipeType<SawmillRecipe>() {
		@Override
		public String toString() {
			return "sawmill";
		}
	});
}
