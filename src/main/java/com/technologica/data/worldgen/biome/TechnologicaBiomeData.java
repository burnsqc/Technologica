package com.technologica.data.worldgen.biome;

import com.technologica.world.level.biome.TechnologicaBiomes;

import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.levelgen.carver.ConfiguredWorldCarver;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;

public class TechnologicaBiomeData {
	public static void bootstrap(BootstapContext<Biome> biomes) {
		HolderGetter<PlacedFeature> placedFeatures = biomes.lookup(Registries.PLACED_FEATURE);
		HolderGetter<ConfiguredWorldCarver<?>> configuredCarvers = biomes.lookup(Registries.CONFIGURED_CARVER);
		biomes.register(TechnologicaBiomes.SILENT_EXPANSES, MoonBiomes.silentExpanses(placedFeatures, configuredCarvers, false));
		biomes.register(TechnologicaBiomes.CRATER_FIELDS, MoonBiomes.craterFields(placedFeatures, configuredCarvers, false));
		biomes.register(TechnologicaBiomes.SHATTERED_CORRIDORS, MoonBiomes.shatteredCorridors(placedFeatures, configuredCarvers, false));
		biomes.register(TechnologicaBiomes.MISTY_MIRE, OvergrowthBiomes.mistyMire(placedFeatures, configuredCarvers, false));
	}
}
