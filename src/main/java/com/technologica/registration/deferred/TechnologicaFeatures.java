package com.technologica.registration.deferred;

import com.technologica.Technologica;
import com.technologica.registration.deferred.util.MasterDeferredRegistrar;
import com.technologica.world.level.levelgen.feature.CraterFeature;
import com.technologica.world.level.levelgen.feature.DecoratedOreFeature;
import com.technologica.world.level.levelgen.feature.OasisFeature;

import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.LakeFeature;
import net.minecraft.world.level.levelgen.feature.configurations.BlockStateConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration;
import net.minecraftforge.registries.RegistryObject;

@SuppressWarnings("deprecation")
public class TechnologicaFeatures extends MasterDeferredRegistrar {
	
	public static int init() {
		FEATURES.register(Technologica.MOD_EVENT_BUS);
		return FEATURES.getEntries().size();
	}

	public static final RegistryObject<Feature<LakeFeature.Configuration>> BRINE_POOL = FEATURES.register("brine_pool", () -> new LakeFeature(LakeFeature.Configuration.CODEC));
	public static final RegistryObject<Feature<BlockStateConfiguration>> OASIS = FEATURES.register("oasis", () -> new OasisFeature(BlockStateConfiguration.CODEC));
	public static final RegistryObject<Feature<BlockStateConfiguration>> CRATER = FEATURES.register("crater", () -> new CraterFeature(BlockStateConfiguration.CODEC));

	public static final RegistryObject<Feature<OreConfiguration>> AQUAMARINE_DECORATED_ORE = FEATURES.register("aquamarine_decorated_ore", () -> new DecoratedOreFeature(OreConfiguration.CODEC, TechnologicaBlocks.AQUAMARINE_CRYSTAL));
	public static final RegistryObject<Feature<OreConfiguration>> CELESTINE_DECORATED_ORE = FEATURES.register("celestine_decorated_ore", () -> new DecoratedOreFeature(OreConfiguration.CODEC, TechnologicaBlocks.CELESTINE_CRYSTAL));
	public static final RegistryObject<Feature<OreConfiguration>> FLUORITE_DECORATED_ORE = FEATURES.register("fluorite_decorated_ore", () -> new DecoratedOreFeature(OreConfiguration.CODEC, TechnologicaBlocks.FLUORITE_CRYSTAL));
	public static final RegistryObject<Feature<OreConfiguration>> TELLURITE_DECORATED_ORE = FEATURES.register("tellurite_decorated_ore", () -> new DecoratedOreFeature(OreConfiguration.CODEC, TechnologicaBlocks.TELLURITE_CRYSTAL));
	public static final RegistryObject<Feature<OreConfiguration>> ULEXITE_DECORATED_ORE = FEATURES.register("ulexite_decorated_ore", () -> new DecoratedOreFeature(OreConfiguration.CODEC, TechnologicaBlocks.ULEXITE_CRYSTAL));
	public static final RegistryObject<Feature<OreConfiguration>> VANADANITE_DECORATED_ORE = FEATURES.register("vanadanite_decorated_ore", () -> new DecoratedOreFeature(OreConfiguration.CODEC, TechnologicaBlocks.VANADINITE_CRYSTAL));

	public static final RegistryObject<Feature<OreConfiguration>> COLUMBITE_DECORATED_ORE = FEATURES.register("columbite_decorated_ore", () -> new DecoratedOreFeature(OreConfiguration.CODEC, TechnologicaBlocks.COLUMBITE_CRYSTAL));
	public static final RegistryObject<Feature<OreConfiguration>> DOLOMITE_DECORATED_ORE = FEATURES.register("dolomite_decorated_ore", () -> new DecoratedOreFeature(OreConfiguration.CODEC, TechnologicaBlocks.DOLOMITE_CRYSTAL));
	public static final RegistryObject<Feature<OreConfiguration>> SCHEELITE_DECORATED_ORE = FEATURES.register("scheelite_decorated_ore", () -> new DecoratedOreFeature(OreConfiguration.CODEC, TechnologicaBlocks.SCHEELITE_CRYSTAL));
	public static final RegistryObject<Feature<OreConfiguration>> SPHALERITE_DECORATED_ORE = FEATURES.register("sphalerite_decorated_ore", () -> new DecoratedOreFeature(OreConfiguration.CODEC, TechnologicaBlocks.SPHALERITE_CRYSTAL));
	public static final RegistryObject<Feature<OreConfiguration>> XENOTIME_DECORATED_ORE = FEATURES.register("xenotime_decorated_ore", () -> new DecoratedOreFeature(OreConfiguration.CODEC, TechnologicaBlocks.XENOTIME_CRYSTAL));
	public static final RegistryObject<Feature<OreConfiguration>> ZIRCON_DECORATED_ORE = FEATURES.register("zircon_decorated_ore", () -> new DecoratedOreFeature(OreConfiguration.CODEC, TechnologicaBlocks.ZIRCON_CRYSTAL));

	public static final RegistryObject<Feature<OreConfiguration>> BISMITHUNITE_DECORATED_ORE = FEATURES.register("bismithunite_decorated_ore", () -> new DecoratedOreFeature(OreConfiguration.CODEC, TechnologicaBlocks.BISMITHUNITE_CRYSTAL));
	public static final RegistryObject<Feature<OreConfiguration>> HUTCHINSONITE_DECORATED_ORE = FEATURES.register("hutchinsonite_decorated_ore", () -> new DecoratedOreFeature(OreConfiguration.CODEC, TechnologicaBlocks.HUTCHINSONITE_CRYSTAL));
	public static final RegistryObject<Feature<OreConfiguration>> MONAZITE_DECORATED_ORE = FEATURES.register("monazite_decorated_ore", () -> new DecoratedOreFeature(OreConfiguration.CODEC, TechnologicaBlocks.MONAZITE_CRYSTAL));
	public static final RegistryObject<Feature<OreConfiguration>> STIBNITE_DECORATED_ORE = FEATURES.register("stibnite_decorated_ore", () -> new DecoratedOreFeature(OreConfiguration.CODEC, TechnologicaBlocks.STIBNITE_CRYSTAL));
	public static final RegistryObject<Feature<OreConfiguration>> STRONTIANITE_DECORATED_ORE = FEATURES.register("strontianite_decorated_ore", () -> new DecoratedOreFeature(OreConfiguration.CODEC, TechnologicaBlocks.STRONTIANITE_CRYSTAL));
	public static final RegistryObject<Feature<OreConfiguration>> RUTILE_DECORATED_ORE = FEATURES.register("rutile_decorated_ore", () -> new DecoratedOreFeature(OreConfiguration.CODEC, TechnologicaBlocks.RUTILE_CRYSTAL));

	public static final RegistryObject<Feature<OreConfiguration>> AUTUNITE_DECORATED_ORE = FEATURES.register("autunite_decorated_ore", () -> new DecoratedOreFeature(OreConfiguration.CODEC, TechnologicaBlocks.AUTUNITE_CRYSTAL));
	public static final RegistryObject<Feature<OreConfiguration>> BARYTE_DECORATED_ORE = FEATURES.register("baryte_decorated_ore", () -> new DecoratedOreFeature(OreConfiguration.CODEC, TechnologicaBlocks.BARYTE_CRYSTAL));
	public static final RegistryObject<Feature<OreConfiguration>> POLLUCITE_DECORATED_ORE = FEATURES.register("pollucite_decorated_ore", () -> new DecoratedOreFeature(OreConfiguration.CODEC, TechnologicaBlocks.POLLUCITE_CRYSTAL));
	public static final RegistryObject<Feature<OreConfiguration>> WULFENITE_DECORATED_ORE = FEATURES.register("wulfenite_decorated_ore", () -> new DecoratedOreFeature(OreConfiguration.CODEC, TechnologicaBlocks.WULFENITE_CRYSTAL));
}