package com.technologica.item.crafting;

import com.technologica.Technologica;

import net.minecraft.item.crafting.IRecipeSerializer;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class TechnologicaRecipeSerializer {
	public static final DeferredRegister<IRecipeSerializer<?>> RECIPE_SERIALIZERS = DeferredRegister.create(ForgeRegistries.RECIPE_SERIALIZERS, Technologica.MODID);
	
	public static final RegistryObject<IRecipeSerializer<SawmillRecipe>> SAWMILL = RECIPE_SERIALIZERS.register("sawmill", SawmillRecipe.Serializer::new);
	
	public static void register() 
    {
		RECIPE_SERIALIZERS.register(FMLJavaModLoadingContext.get().getModEventBus());
    }
}
