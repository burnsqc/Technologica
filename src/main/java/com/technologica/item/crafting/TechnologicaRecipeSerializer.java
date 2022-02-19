package com.technologica.item.crafting;

import static com.technologica.Technologica.LOGGER;
import com.technologica.Technologica;

import net.minecraft.item.crafting.IRecipeSerializer;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class TechnologicaRecipeSerializer {
	public static final DeferredRegister<IRecipeSerializer<?>> RECIPE_SERIALIZERS = DeferredRegister.create(ForgeRegistries.RECIPE_SERIALIZERS, Technologica.MODID);
	
	public static void init() {
		LOGGER.info("INITIALIZING RECIPE SERIALIZERS");
		RECIPE_SERIALIZERS.register(FMLJavaModLoadingContext.get().getModEventBus());
		LOGGER.info(RECIPE_SERIALIZERS.getEntries().size() + " RECIPE SERIALIZERS INITIALIZED");
    }
	
	public static final RegistryObject<IRecipeSerializer<SawmillRecipe>> SAWMILL = RECIPE_SERIALIZERS.register("sawmill", SawmillRecipe.Serializer::new);
}
