package com.technologica.world.item.crafting;

import static com.technologica.Technologica.LOGGER;

import com.technologica.Technologica;

import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class TechnologicaRecipeSerializer {
	public static final DeferredRegister<RecipeSerializer<?>> RECIPE_SERIALIZERS = DeferredRegister.create(ForgeRegistries.Keys.RECIPE_SERIALIZERS, Technologica.MODID);

	public static void init() {
		LOGGER.info("INITIALIZING RECIPE SERIALIZERS");
		RECIPE_SERIALIZERS.register(FMLJavaModLoadingContext.get().getModEventBus());
		LOGGER.info(RECIPE_SERIALIZERS.getEntries().size() + " RECIPE SERIALIZERS INITIALIZED");
	}

	public static final RegistryObject<RecipeSerializer<SawmillRecipe>> SAWMILL = RECIPE_SERIALIZERS.register("sawmill", SawmillRecipe.Serializer::new);
}