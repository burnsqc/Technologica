package com.technologica.registration.dynamic;

import java.util.ArrayList;

import com.mojang.datafixers.util.Pair;
import com.technologica.Technologica;
import com.technologica.api.tlregen.resourcegen.data.TLReGenDimension;

import net.minecraft.core.Holder;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.BiomeSource;
import net.minecraft.world.level.biome.Climate;
import net.minecraft.world.level.biome.MultiNoiseBiomeSource;
import net.minecraft.world.level.chunk.ChunkGenerator;
import net.minecraft.world.level.dimension.DimensionType;
import net.minecraft.world.level.dimension.LevelStem;
import net.minecraft.world.level.levelgen.NoiseBasedChunkGenerator;
import net.minecraft.world.level.levelgen.NoiseGeneratorSettings;

public final class TechnologicaDimensions {
	public static final ResourceKey<LevelStem> MOON_STEM = Technologica.DIMENSIONS.register("moon", () -> dimension(TechnologicaDimensionTypes.MOON, chunkGenerator("noise", new BiomeSourceBuilder("multi_noise").add(biome(TechnologicaBiomes.SILENT_EXPANSES, parameters(0.0F, 0.0F, 1.0F, 0.0F, 0.0F, 0.0F, 0.0F))).add(biome(TechnologicaBiomes.CRATER_FIELDS, parameters(-1.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -1.0F))).add(biome(TechnologicaBiomes.SHATTERED_CORRIDORS, parameters(1.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 1.0F))).build(), TechnologicaNoiseGeneratorSettings.MOON)));
	public static final ResourceKey<LevelStem> CHALLENGER_DEEP_STEM = Technologica.DIMENSIONS.register("challenger_deep", () -> dimension(TechnologicaDimensionTypes.CHALLENGER_DEEP, chunkGenerator("noise", new BiomeSourceBuilder("multi_noise").add(biome(TechnologicaBiomes.RUSTING_GROUNDS, parameters(0.0F, 1.0F, 0.0F, 0.0F, 0.0F, 0.5F, 0.0F))).add(biome(TechnologicaBiomes.FORGOTTEN_REEF, parameters(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.5F, 0.0F))).add(biome(TechnologicaBiomes.NAVAL_GRAVEYARD, parameters(0.0F, 1.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F))).add(biome(TechnologicaBiomes.SUNKEN_FOREST, parameters(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 1.0F, 0.0F))).add(biome(TechnologicaBiomes.HYDROTHERMAL_CAVERN, parameters(0.0F, 1.0F, 0.0F, 0.0F, 0.0F, 1.0F, 0.0F))).add(biome(TechnologicaBiomes.ABYSSAL_DEPTHS, parameters(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F))).build(), TechnologicaNoiseGeneratorSettings.CHALLENGER_DEEP)));
	public static final ResourceKey<LevelStem> OVERGROWTH_STEM = Technologica.DIMENSIONS.register("overgrowth", () -> dimension(TechnologicaDimensionTypes.OVERGROWTH, chunkGenerator("noise", new BiomeSourceBuilder("multi_noise").add(biome(TechnologicaBiomes.MISTY_MIRE, parameters(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F))).add(biome(TechnologicaBiomes.BRAMBLE, parameters(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F))).build(), TechnologicaNoiseGeneratorSettings.OVERGROWTH)));

	protected static LevelStem dimension(ResourceKey<DimensionType> type, ChunkGenerator generator) {
		return new LevelStem(TLReGenDimension.bootstrapContext.lookup(Registries.DIMENSION_TYPE).getOrThrow(type), generator);
	}

	protected static ChunkGenerator chunkGenerator(String type, BiomeSource biomeSource, ResourceKey<NoiseGeneratorSettings> settings) {
		return new NoiseBasedChunkGenerator(biomeSource, TLReGenDimension.bootstrapContext.lookup(Registries.NOISE_SETTINGS).getOrThrow(settings));
	}

	protected static class BiomeSourceBuilder {
		private ArrayList<Pair<Climate.ParameterPoint, Holder<Biome>>> biomes;

		public BiomeSourceBuilder(String type) {
			biomes = new ArrayList<>();
		}

		public BiomeSourceBuilder add(Pair<Climate.ParameterPoint, Holder<Biome>> biomes) {
			this.biomes.add(biomes);
			return this;
		}

		public BiomeSource build() {
			return MultiNoiseBiomeSource.createFromList(new Climate.ParameterList<Holder<Biome>>(biomes));
		}
	}

	protected static Pair<Climate.ParameterPoint, Holder<Biome>> biome(ResourceKey<Biome> biome, Climate.ParameterPoint parameters) {
		final HolderGetter<Biome> biomesGetter = TLReGenDimension.bootstrapContext.lookup(Registries.BIOME);
		return Pair.of(parameters, biomesGetter.getOrThrow(biome));
	}

	protected static Climate.ParameterPoint parameters(float continentalness, float depth, float erosion, float humidity, float offset, float temperature, float weirdness) {
		return Climate.parameters(temperature, humidity, continentalness, erosion, depth, weirdness, offset);
	}
}
