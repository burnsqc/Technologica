package com.technologica.data.registries;

import java.util.Set;
import java.util.concurrent.CompletableFuture;

import com.technologica.Technologica;
import com.technologica.data.worldgen.TechnologicaDimensionTypes;
import com.technologica.data.worldgen.biome.TechnologicaBiomeModifiers;
import com.technologica.data.worldgen.biome.TechnologicaBiomes;
import com.technologica.data.worldgen.features.TechnologicaFeatureUtils;
import com.technologica.data.worldgen.placement.TechnologicaPlacementUtils;
import com.technologica.world.level.biome.TechnologicaMultiNoiseBiomeSource;
import com.technologica.world.level.dimension.TechnologicaBuiltinDimensionTypes;
import com.technologica.world.level.levelgen.TechnologicaNoiseGeneratorSettings;
import com.technologica.world.level.levelgen.presets.TechnologicaWorldPresets;

import net.minecraft.core.Holder;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.HolderLookup.Provider;
import net.minecraft.core.RegistrySetBuilder;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.FixedBiomeSource;
import net.minecraft.world.level.dimension.DimensionType;
import net.minecraft.world.level.dimension.LevelStem;
import net.minecraft.world.level.levelgen.NoiseBasedChunkGenerator;
import net.minecraft.world.level.levelgen.NoiseGeneratorSettings;
import net.minecraftforge.common.data.DatapackBuiltinEntriesProvider;
import net.minecraftforge.registries.ForgeRegistries;

public class TechnologicaDatapackBuiltinEntriesProvider extends DatapackBuiltinEntriesProvider {

	@SuppressWarnings({ "unchecked", "rawtypes" })
	private static final RegistrySetBuilder BUILDER = new RegistrySetBuilder().add(Registries.DIMENSION_TYPE, TechnologicaDimensionTypes::bootstrap).add(Registries.CONFIGURED_FEATURE, (RegistrySetBuilder.RegistryBootstrap) TechnologicaFeatureUtils::bootstrap).add(Registries.PLACED_FEATURE, TechnologicaPlacementUtils::bootstrap).add(Registries.BIOME, TechnologicaBiomes::bootstrap).add(Registries.NOISE_SETTINGS, TechnologicaNoiseGeneratorSettings::bootstrap).add(Registries.WORLD_PRESET, TechnologicaWorldPresets::bootstrap);

	private static final ResourceKey<LevelStem> MOON_STEM = ResourceKey.create(Registries.LEVEL_STEM, new ResourceLocation(Technologica.MODID, "moon"));
	private static final ResourceKey<LevelStem> CHALLENGER_DEEP_STEM = ResourceKey.create(Registries.LEVEL_STEM, new ResourceLocation(Technologica.MODID, "challenger_deep"));

	public TechnologicaDatapackBuiltinEntriesProvider(PackOutput output, CompletableFuture<Provider> registries) {
		super(output, registries, BUILDER.add(ForgeRegistries.Keys.BIOME_MODIFIERS, context -> {
			TechnologicaBiomeModifiers.bootstrap(context);
		}).add(Registries.LEVEL_STEM, context -> {
			final HolderGetter<DimensionType> dimensionType = context.lookup(Registries.DIMENSION_TYPE);
			final HolderGetter<NoiseGeneratorSettings> noiseGeneratorSettings = context.lookup(Registries.NOISE_SETTINGS);
			final HolderGetter<Biome> biomes = context.lookup(Registries.BIOME);

			final Holder<DimensionType> moonDimensionType = dimensionType.getOrThrow(TechnologicaBuiltinDimensionTypes.MOON);
			final Holder<DimensionType> challengerDeepDimensionType = dimensionType.getOrThrow(TechnologicaBuiltinDimensionTypes.CHALLENGER_DEEP);

			final Holder<NoiseGeneratorSettings> moonNoiseGeneratorSettings = noiseGeneratorSettings.getOrThrow(TechnologicaNoiseGeneratorSettings.MOON);
			final Holder<NoiseGeneratorSettings> challengerDeepNoiseGeneratorSettings = noiseGeneratorSettings.getOrThrow(TechnologicaNoiseGeneratorSettings.CHALLENGER_DEEP);

			final Holder.Reference<Biome> reference1 = biomes.getOrThrow(com.technologica.world.level.biome.TechnologicaBiomes.SILENT_EXPANSES);

			context.register(MOON_STEM, new LevelStem(moonDimensionType, new NoiseBasedChunkGenerator(TechnologicaMultiNoiseBiomeSource.Preset.MOON.biomeSource(biomes), moonNoiseGeneratorSettings)));
			context.register(CHALLENGER_DEEP_STEM, new LevelStem(challengerDeepDimensionType, new NoiseBasedChunkGenerator(new FixedBiomeSource(reference1), challengerDeepNoiseGeneratorSettings)));
		}), Set.of(Technologica.MODID));
	}
}