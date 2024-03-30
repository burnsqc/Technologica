package com.technologica.resourcegen.data.dimension;

import java.util.ArrayList;

import com.mojang.datafixers.util.Pair;
import com.technologica.api.tlregen.resourcegen.TLReGenDimension;
import com.technologica.registration.key.TechnologicaBiomes;
import com.technologica.registration.key.TechnologicaDimensionTypes;
import com.technologica.registration.key.TechnologicaDimensions;
import com.technologica.registration.key.TechnologicaNoiseGeneratorSettings;

import net.minecraft.core.Holder;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.BiomeSource;
import net.minecraft.world.level.biome.Climate;
import net.minecraft.world.level.biome.MultiNoiseBiomeSource;
import net.minecraft.world.level.chunk.ChunkGenerator;
import net.minecraft.world.level.dimension.LevelStem;
import net.minecraft.world.level.levelgen.NoiseBasedChunkGenerator;
import net.minecraft.world.level.levelgen.NoiseGeneratorSettings;

public class TLDimensionGenerator extends TLReGenDimension {
	private static BootstapContext<LevelStem> dimension;

	public static void bootstrap(BootstapContext<LevelStem> bootstrapContextIn) {
		dimension = bootstrapContextIn;
		dimension.register(TechnologicaDimensions.MOON_STEM, Dimension(bootstrapContextIn, TechnologicaDimensionTypes.MOON, chunkGenerator("noise", new BiomeSourceBuilder("multi_noise").add(biome(TechnologicaBiomes.SILENT_EXPANSES, parameters(0.0F, 0.0F, 1.0F, 0.0F, 0.0F, 0.0F, 0.0F))).add(biome(TechnologicaBiomes.CRATER_FIELDS, parameters(-1.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -1.0F))).add(biome(TechnologicaBiomes.SHATTERED_CORRIDORS, parameters(1.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 1.0F))).build(), TechnologicaNoiseGeneratorSettings.MOON)));
		dimension.register(TechnologicaDimensions.CHALLENGER_DEEP_STEM, new LevelStem(dimension.lookup(Registries.DIMENSION_TYPE).getOrThrow(TechnologicaDimensionTypes.CHALLENGER_DEEP), chunkGenerator("noise", new BiomeSourceBuilder("multi_noise").add(biome(TechnologicaBiomes.MISTY_MIRE, parameters(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F))).add(biome(TechnologicaBiomes.CRATER_FIELDS, parameters(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F))).build(), TechnologicaNoiseGeneratorSettings.CHALLENGER_DEEP)));
		dimension.register(TechnologicaDimensions.OVERGROWTH_STEM, new LevelStem(dimension.lookup(Registries.DIMENSION_TYPE).getOrThrow(TechnologicaDimensionTypes.OVERGROWTH), chunkGenerator("noise", new BiomeSourceBuilder("multi_noise").add(biome(TechnologicaBiomes.MISTY_MIRE, parameters(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F))).add(biome(TechnologicaBiomes.BRAMBLE, parameters(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F))).build(), TechnologicaNoiseGeneratorSettings.OVERGROWTH)));
	}

	private static ChunkGenerator chunkGenerator(String type, BiomeSource biomeSource, ResourceKey<NoiseGeneratorSettings> settings) {
		return new NoiseBasedChunkGenerator(biomeSource, dimension.lookup(Registries.NOISE_SETTINGS).getOrThrow(settings));
	}

	private static class BiomeSourceBuilder {
		private String type;
		private ArrayList<Pair<Climate.ParameterPoint, Holder<Biome>>> biomes;

		private BiomeSourceBuilder(String type) {
			biomes = new ArrayList<>();
			this.type = type;
		}

		private BiomeSourceBuilder add(Pair<Climate.ParameterPoint, Holder<Biome>> biomes) {
			this.biomes.add(biomes);
			return this;
		}

		private BiomeSource build() {
			return MultiNoiseBiomeSource.createFromList(new Climate.ParameterList<Holder<Biome>>(biomes));
		}
	}

	private static Pair<Climate.ParameterPoint, Holder<Biome>> biome(ResourceKey<Biome> biome, Climate.ParameterPoint parameters) {
		final HolderGetter<Biome> biomesGetter = dimension.lookup(Registries.BIOME);
		return Pair.of(parameters, biomesGetter.getOrThrow(biome));
	}

	private static Climate.ParameterPoint parameters(float continentalness, float depth, float erosion, float humidity, float offset, float temperature, float weirdness) {
		return Climate.parameters(temperature, humidity, continentalness, erosion, depth, weirdness, offset);
	}
}