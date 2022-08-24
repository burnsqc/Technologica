package com.technologica.world.level.levelgen.feature;

import static com.technologica.Technologica.LOGGER;
import static com.technologica.Technologica.MODID;

import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.LakeFeature;
import net.minecraft.world.level.levelgen.feature.configurations.BlockStateConfiguration;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

@SuppressWarnings("deprecation")
public class TechnologicaFeature {
	private static final DeferredRegister<Feature<?>> FEATURES = DeferredRegister.create(ForgeRegistries.Keys.FEATURES, MODID);

	public static void init() {
		FEATURES.register(FMLJavaModLoadingContext.get().getModEventBus());
		LOGGER.info("FEATURES INITIALIZED: " + FEATURES.getEntries().size() + " OF 3");
	}

	public static final RegistryObject<Feature<LakeFeature.Configuration>> BRINE_POOL = FEATURES.register("brine_pool", () -> new LakeFeature(LakeFeature.Configuration.CODEC));
	public static final RegistryObject<Feature<BlockStateConfiguration>> OASIS = FEATURES.register("oasis", () -> new OasisFeature(BlockStateConfiguration.CODEC));
	public static final RegistryObject<Feature<BlockStateConfiguration>> CRATER = FEATURES.register("crater", () -> new CraterFeature(BlockStateConfiguration.CODEC));
}
