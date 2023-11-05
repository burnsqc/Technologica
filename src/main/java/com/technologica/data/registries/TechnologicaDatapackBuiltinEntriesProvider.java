package com.technologica.data.registries;

import java.util.Set;
import java.util.concurrent.CompletableFuture;

import com.google.common.collect.ImmutableList;
import com.mojang.datafixers.util.Pair;
import com.technologica.Technologica;
import com.technologica.data.worldgen.TechnologicaDimensionTypes;
import com.technologica.data.worldgen.TechnologicaStructureSets;
import com.technologica.data.worldgen.TechnologicaStructures;
import com.technologica.data.worldgen.biome.TechnologicaBiomeData;
import com.technologica.data.worldgen.biome.TechnologicaBiomeModifiers;
import com.technologica.data.worldgen.features.TechnologicaFeatureUtils;
import com.technologica.data.worldgen.placement.TechnologicaPlacementUtils;
import com.technologica.world.damagesource.TechnologicaDamageTypes;
import com.technologica.world.level.biome.TechnologicaBiomes;
import com.technologica.world.level.dimension.TechnologicaBuiltinDimensionTypes;
import com.technologica.world.level.dimension.TechnologicaLevelStem;
import com.technologica.world.level.levelgen.TechnologicaNoiseGeneratorSettings;

import net.minecraft.core.Holder;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.HolderLookup.Provider;
import net.minecraft.core.RegistrySetBuilder;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.PackOutput;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.Climate;
import net.minecraft.world.level.biome.FixedBiomeSource;
import net.minecraft.world.level.biome.MultiNoiseBiomeSource;
import net.minecraft.world.level.dimension.DimensionType;
import net.minecraft.world.level.dimension.LevelStem;
import net.minecraft.world.level.levelgen.NoiseBasedChunkGenerator;
import net.minecraft.world.level.levelgen.NoiseGeneratorSettings;
import net.minecraftforge.common.data.DatapackBuiltinEntriesProvider;
import net.minecraftforge.registries.ForgeRegistries;

public class TechnologicaDatapackBuiltinEntriesProvider extends DatapackBuiltinEntriesProvider {

	@SuppressWarnings({ "unchecked", "rawtypes" })
	private static final RegistrySetBuilder BUILDER = new RegistrySetBuilder().add(Registries.DIMENSION_TYPE, TechnologicaDimensionTypes::bootstrap).add(Registries.CONFIGURED_FEATURE, (RegistrySetBuilder.RegistryBootstrap) TechnologicaFeatureUtils::bootstrap).add(Registries.PLACED_FEATURE, TechnologicaPlacementUtils::bootstrap).add(Registries.STRUCTURE, TechnologicaStructures::bootstrap).add(Registries.STRUCTURE_SET, TechnologicaStructureSets::bootstrap).add(Registries.BIOME, TechnologicaBiomeData::bootstrap).add(Registries.NOISE_SETTINGS, TechnologicaNoiseGeneratorSettings::bootstrap).add(Registries.DAMAGE_TYPE, TechnologicaDamageTypes::bootstrap);

	public TechnologicaDatapackBuiltinEntriesProvider(PackOutput output, CompletableFuture<Provider> registries) {
		super(output, registries, BUILDER.add(ForgeRegistries.Keys.BIOME_MODIFIERS, context -> {
			TechnologicaBiomeModifiers.bootstrap(context);
		}).add(Registries.LEVEL_STEM, context -> {

			final HolderGetter<DimensionType> dimensionType = context.lookup(Registries.DIMENSION_TYPE);
			final HolderGetter<NoiseGeneratorSettings> noiseGeneratorSettings = context.lookup(Registries.NOISE_SETTINGS);
			final HolderGetter<Biome> biomes = context.lookup(Registries.BIOME);

			final Holder<DimensionType> moonDimensionType = dimensionType.getOrThrow(TechnologicaBuiltinDimensionTypes.MOON);
			final Holder<DimensionType> challengerDeepDimensionType = dimensionType.getOrThrow(TechnologicaBuiltinDimensionTypes.CHALLENGER_DEEP);
			final Holder<DimensionType> overgrowthDimensionType = dimensionType.getOrThrow(TechnologicaBuiltinDimensionTypes.OVERGROWTH);

			final Holder<NoiseGeneratorSettings> moonNoiseGeneratorSettings = noiseGeneratorSettings.getOrThrow(TechnologicaNoiseGeneratorSettings.MOON);
			final Holder<NoiseGeneratorSettings> challengerDeepNoiseGeneratorSettings = noiseGeneratorSettings.getOrThrow(TechnologicaNoiseGeneratorSettings.CHALLENGER_DEEP);
			final Holder<NoiseGeneratorSettings> overgrowthNoiseGeneratorSettings = noiseGeneratorSettings.getOrThrow(TechnologicaNoiseGeneratorSettings.OVERGROWTH);

			final Holder.Reference<Biome> reference1 = biomes.getOrThrow(TechnologicaBiomes.MISTY_MIRE);

			context.register(TechnologicaLevelStem.MOON_STEM, new LevelStem(moonDimensionType, new NoiseBasedChunkGenerator(MultiNoiseBiomeSource.createFromList(new Climate.ParameterList<Holder<Biome>>(ImmutableList.of(Pair.of(Climate.parameters(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F), biomes.getOrThrow(com.technologica.world.level.biome.TechnologicaBiomes.SILENT_EXPANSES)), Pair.of(Climate.parameters(0.0F, -0.5F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F), biomes.getOrThrow(com.technologica.world.level.biome.TechnologicaBiomes.CRATER_FIELDS)), Pair.of(Climate.parameters(0.4F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F), biomes.getOrThrow(com.technologica.world.level.biome.TechnologicaBiomes.SHATTERED_CORRIDORS))))), moonNoiseGeneratorSettings)));
			context.register(TechnologicaLevelStem.CHALLENGER_DEEP_STEM, new LevelStem(challengerDeepDimensionType, new NoiseBasedChunkGenerator(new FixedBiomeSource(reference1), challengerDeepNoiseGeneratorSettings)));
			context.register(TechnologicaLevelStem.OVERGROWTH_STEM, new LevelStem(overgrowthDimensionType, new NoiseBasedChunkGenerator(new FixedBiomeSource(reference1), overgrowthNoiseGeneratorSettings)));

		}), Set.of(Technologica.MODID));
	}
}