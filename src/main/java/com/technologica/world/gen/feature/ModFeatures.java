package com.technologica.world.gen.feature;

import static com.technologica.Technologica.MODID;

import net.minecraft.world.gen.feature.BlockStateFeatureConfig;
import net.minecraft.world.gen.feature.Feature;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModFeatures {
	private static final DeferredRegister<Feature<?>> FEATURES = DeferredRegister.create(ForgeRegistries.FEATURES, MODID);

	public static final RegistryObject<Feature<BlockStateFeatureConfig>> LAKE_BRINE = FEATURES.register("lake_brine", () -> new ModLakeFeature(BlockStateFeatureConfig.CODEC));
	public static final RegistryObject<Feature<BlockStateFeatureConfig>> OASIS = FEATURES.register("oasis", () -> new OasisFeature(BlockStateFeatureConfig.CODEC));
	
	public static void register() 
    {
        FEATURES.register(FMLJavaModLoadingContext.get().getModEventBus()); 
    }
}
