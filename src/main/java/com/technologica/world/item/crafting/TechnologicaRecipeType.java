package com.technologica.world.item.crafting;

import com.technologica.Technologica;

import net.minecraft.world.item.crafting.RecipeType;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class TechnologicaRecipeType {
	public static final DeferredRegister<RecipeType<?>> RECIPE_TYPES = DeferredRegister.create(ForgeRegistries.Keys.RECIPE_TYPES, Technologica.MOD_ID);

	public static int init() {
		RECIPE_TYPES.register(FMLJavaModLoadingContext.get().getModEventBus());
		return RECIPE_TYPES.getEntries().size();
	}

	public static final RegistryObject<RecipeType<SawmillRecipe>> SAWMILL = RECIPE_TYPES.register("sawmill", () -> new RecipeType<SawmillRecipe>() {
		@Override
		public String toString() {
			return "sawmill";
		}
	});
}