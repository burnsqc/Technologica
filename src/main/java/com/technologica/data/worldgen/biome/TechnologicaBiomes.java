package com.technologica.data.worldgen.biome;

import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.levelgen.carver.ConfiguredWorldCarver;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;

public class TechnologicaBiomes {
	public static void bootstrap(BootstapContext<Biome> p_256344_) {
		HolderGetter<PlacedFeature> holdergetter = p_256344_.lookup(Registries.PLACED_FEATURE);
		HolderGetter<ConfiguredWorldCarver<?>> holdergetter1 = p_256344_.lookup(Registries.CONFIGURED_CARVER);
		p_256344_.register(com.technologica.world.level.biome.TechnologicaBiomes.SILENT_EXPANSES, MoonBiomes.silentExpanses(holdergetter, holdergetter1, false));
		p_256344_.register(com.technologica.world.level.biome.TechnologicaBiomes.CRATER_FIELDS, MoonBiomes.craterFields(holdergetter, holdergetter1, false));
		p_256344_.register(com.technologica.world.level.biome.TechnologicaBiomes.SHATTERED_CORRIDORS, MoonBiomes.shatteredCorridors(holdergetter, holdergetter1, false));
	}
}