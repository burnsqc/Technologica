package com.technologica.world.level.levelgen.presets;

import com.technologica.world.level.biome.TechnologicaMultiNoiseBiomeSource;

import net.minecraft.core.Holder;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.MultiNoiseBiomeSource;
import net.minecraft.world.level.biome.TheEndBiomeSource;
import net.minecraft.world.level.dimension.BuiltinDimensionTypes;
import net.minecraft.world.level.dimension.DimensionType;
import net.minecraft.world.level.dimension.LevelStem;
import net.minecraft.world.level.levelgen.NoiseBasedChunkGenerator;
import net.minecraft.world.level.levelgen.NoiseGeneratorSettings;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraft.world.level.levelgen.presets.WorldPreset;
import net.minecraft.world.level.levelgen.structure.StructureSet;

public class TechnologicaWorldPresets {
	public static void bootstrap(BootstapContext<WorldPreset> p_256172_) {
		(new TechnologicaWorldPresets.Bootstrap(p_256172_)).run();
	}

	static class Bootstrap {
		private final BootstapContext<WorldPreset> context;
		private final HolderGetter<NoiseGeneratorSettings> noiseSettings;
		private final HolderGetter<Biome> biomes;
		private final HolderGetter<PlacedFeature> placedFeatures;
		private final HolderGetter<StructureSet> structureSets;
		private final Holder<DimensionType> overworldDimensionType;
		private final LevelStem moonStem;
		private final LevelStem endStem;

		Bootstrap(BootstapContext<WorldPreset> p_256588_) {
			this.context = p_256588_;
			HolderGetter<DimensionType> holdergetter = p_256588_.lookup(Registries.DIMENSION_TYPE);
			this.noiseSettings = p_256588_.lookup(Registries.NOISE_SETTINGS);
			this.biomes = p_256588_.lookup(Registries.BIOME);
			this.placedFeatures = p_256588_.lookup(Registries.PLACED_FEATURE);
			this.structureSets = p_256588_.lookup(Registries.STRUCTURE_SET);
			this.overworldDimensionType = holdergetter.getOrThrow(BuiltinDimensionTypes.OVERWORLD);
			Holder<DimensionType> holder = holdergetter.getOrThrow(BuiltinDimensionTypes.NETHER);
			Holder<NoiseGeneratorSettings> holder1 = this.noiseSettings.getOrThrow(NoiseGeneratorSettings.NETHER);
			this.moonStem = new LevelStem(holder, new NoiseBasedChunkGenerator(TechnologicaMultiNoiseBiomeSource.Preset.MOON.biomeSource(this.biomes), holder1));
			Holder<DimensionType> holder2 = holdergetter.getOrThrow(BuiltinDimensionTypes.END);
			Holder<NoiseGeneratorSettings> holder3 = this.noiseSettings.getOrThrow(NoiseGeneratorSettings.END);
			this.endStem = new LevelStem(holder2, new NoiseBasedChunkGenerator(TheEndBiomeSource.create(this.biomes), holder3));
		}

		public void run() {
			MultiNoiseBiomeSource multinoisebiomesource = TechnologicaMultiNoiseBiomeSource.Preset.MOON.biomeSource(this.biomes);
			Holder<NoiseGeneratorSettings> holder = this.noiseSettings.getOrThrow(NoiseGeneratorSettings.OVERWORLD);

		}
	}
}
