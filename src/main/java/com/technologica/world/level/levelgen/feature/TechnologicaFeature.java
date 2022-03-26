package com.technologica.world.level.levelgen.feature;

import static com.technologica.Technologica.LOGGER;
import static com.technologica.Technologica.MODID;

import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.SpringFeature;
import net.minecraft.world.level.levelgen.feature.configurations.BlockStateConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.SpringConfiguration;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class TechnologicaFeature {
	private static final DeferredRegister<Feature<?>> FEATURES = DeferredRegister.create(ForgeRegistries.FEATURES, MODID);

	public static void init() {
		LOGGER.info("INITIALIZING FEATURES");
		FEATURES.register(FMLJavaModLoadingContext.get().getModEventBus());
		LOGGER.info(FEATURES.getEntries().size() + " FEATURES INITIALIZED");
	}
	
	public static final RegistryObject<Feature<SpringConfiguration>> BRINE_POOL = FEATURES.register("brine_pool", () -> new SpringFeature(SpringConfiguration.CODEC));
	public static final RegistryObject<Feature<BlockStateConfiguration>> OASIS = FEATURES.register("oasis", () -> new OasisFeature(BlockStateConfiguration.CODEC));
	public static final RegistryObject<Feature<BlockStateConfiguration>> CRATER = FEATURES.register("crater", () -> new CraterFeature(BlockStateConfiguration.CODEC));
}
