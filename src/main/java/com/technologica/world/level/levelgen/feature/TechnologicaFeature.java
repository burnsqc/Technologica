package com.technologica.world.level.levelgen.feature;

import static com.technologica.Technologica.LOGGER;
import static com.technologica.Technologica.MODID;

import com.technologica.world.level.block.TechnologicaBlocks;

import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.LakeFeature;
import net.minecraft.world.level.levelgen.feature.configurations.BlockStateConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

@SuppressWarnings("deprecation")
public class TechnologicaFeature {
	private static final DeferredRegister<Feature<?>> FEATURES = DeferredRegister.create(ForgeRegistries.Keys.FEATURES, MODID);

	public static void init() {
		FEATURES.register(FMLJavaModLoadingContext.get().getModEventBus());
		LOGGER.info("FEATURES INITIALIZED: " + FEATURES.getEntries().size() + " OF 4");
	}

	public static final RegistryObject<Feature<LakeFeature.Configuration>> BRINE_POOL = FEATURES.register("brine_pool", () -> new LakeFeature(LakeFeature.Configuration.CODEC));
	public static final RegistryObject<Feature<BlockStateConfiguration>> OASIS = FEATURES.register("oasis", () -> new OasisFeature(BlockStateConfiguration.CODEC));
	public static final RegistryObject<Feature<BlockStateConfiguration>> CRATER = FEATURES.register("crater", () -> new CraterFeature(BlockStateConfiguration.CODEC));
	public static final RegistryObject<Feature<OreConfiguration>> AQUAMARINE_DECORATED_ORE = FEATURES.register("aquamarine_decorated_ore", () -> new DecoratedOreFeature(OreConfiguration.CODEC, TechnologicaBlocks.AQUAMARINE_CRYSTAL));
	public static final RegistryObject<Feature<OreConfiguration>> DOLOMITE_DECORATED_ORE = FEATURES.register("dolomite_decorated_ore", () -> new DecoratedOreFeature(OreConfiguration.CODEC, TechnologicaBlocks.DOLOMITE_CRYSTAL));
	public static final RegistryObject<Feature<OreConfiguration>> FLUORITE_DECORATED_ORE = FEATURES.register("fluorite_decorated_ore", () -> new DecoratedOreFeature(OreConfiguration.CODEC, TechnologicaBlocks.FLUORITE_CRYSTAL));
	public static final RegistryObject<Feature<OreConfiguration>> SPHALERITE_DECORATED_ORE = FEATURES.register("sphalerite_decorated_ore", () -> new DecoratedOreFeature(OreConfiguration.CODEC, TechnologicaBlocks.SPHALERITE_CRYSTAL));
	public static final RegistryObject<Feature<OreConfiguration>> ULEXITE_DECORATED_ORE = FEATURES.register("ulexite_decorated_ore", () -> new DecoratedOreFeature(OreConfiguration.CODEC, TechnologicaBlocks.ULEXITE_CRYSTAL));
	public static final RegistryObject<Feature<OreConfiguration>> VANADANITE_DECORATED_ORE = FEATURES.register("vanadanite_decorated_ore", () -> new DecoratedOreFeature(OreConfiguration.CODEC, TechnologicaBlocks.VANADINITE_CRYSTAL));
}