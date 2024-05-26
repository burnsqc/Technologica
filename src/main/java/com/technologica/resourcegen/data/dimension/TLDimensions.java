package com.technologica.resourcegen.data.dimension;

import com.technologica.api.tlregen.resourcegen.data.TLReGenDimension;
import com.technologica.registration.key.TechnologicaBiomes;
import com.technologica.registration.key.TechnologicaDimensionTypes;
import com.technologica.registration.key.TechnologicaDimensions;
import com.technologica.registration.key.TechnologicaNoiseGeneratorSettings;

import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.world.level.dimension.LevelStem;

public final class TLDimensions extends TLReGenDimension {
	public static void bootstrap(final BootstapContext<LevelStem> dimension) {
		TLReGenDimension.setBootstrapContext(dimension);
		dimension.register(TechnologicaDimensions.MOON_STEM, dimension(TechnologicaDimensionTypes.MOON, chunkGenerator("noise", new BiomeSourceBuilder("multi_noise").add(biome(TechnologicaBiomes.SILENT_EXPANSES, parameters(0.0F, 0.0F, 1.0F, 0.0F, 0.0F, 0.0F, 0.0F))).add(biome(TechnologicaBiomes.CRATER_FIELDS, parameters(-1.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -1.0F))).add(biome(TechnologicaBiomes.SHATTERED_CORRIDORS, parameters(1.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 1.0F))).build(), TechnologicaNoiseGeneratorSettings.MOON)));
		dimension.register(TechnologicaDimensions.CHALLENGER_DEEP_STEM, dimension(TechnologicaDimensionTypes.CHALLENGER_DEEP, chunkGenerator("noise", new BiomeSourceBuilder("multi_noise").add(biome(TechnologicaBiomes.RUSTING_GROUNDS, parameters(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F))).build(), TechnologicaNoiseGeneratorSettings.CHALLENGER_DEEP)));
		dimension.register(TechnologicaDimensions.OVERGROWTH_STEM, dimension(TechnologicaDimensionTypes.OVERGROWTH, chunkGenerator("noise", new BiomeSourceBuilder("multi_noise").add(biome(TechnologicaBiomes.MISTY_MIRE, parameters(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F))).add(biome(TechnologicaBiomes.BRAMBLE, parameters(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F))).build(), TechnologicaNoiseGeneratorSettings.OVERGROWTH)));
	}

	@Override
	protected void populate() {
		// TODO Auto-generated method stub

	}
}
