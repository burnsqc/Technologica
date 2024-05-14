package com.technologica.resourcegen.data.worldgen.biome;

import java.util.List;

import com.mojang.datafixers.util.Pair;
import com.technologica.api.tlregen.resourcegen.data.worldgen.TLReGenWorldgenBiome;
import com.technologica.registration.deferred.TechnologicaEntityTypes;
import com.technologica.registration.key.TechnologicaBiomes;
import com.technologica.registration.key.TechnologicaPlacedFeatures;
import com.technologica.world.entity.TechnologicaMobCategory;

import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.biome.AmbientMoodSettings;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.BiomeSpecialEffects;
import net.minecraft.world.level.biome.MobSpawnSettings;

public final class TLBiomes extends TLReGenWorldgenBiome {

	public static void bootstrap(BootstapContext<Biome> biome) {
		placedFeature = biome.lookup(Registries.PLACED_FEATURE);
		configuredWorldCarver = biome.lookup(Registries.CONFIGURED_CARVER);
		biome.register(TechnologicaBiomes.SILENT_EXPANSES, biome(new TLReGenCarvers(List.of(), List.of()), 0.0F, new TLReGenEffects(0, 10387789, 9470285, AmbientMoodSettings.LEGACY_CAVE_SETTINGS, 0, 4159204, 329011), new TLReGenFeatures(List.of(), List.of(), List.of(), List.of(), List.of(), List.of(), List.of(), List.of(), List.of(), List.of(), List.of()), false, new TLReGenSpawners(
			List.of(),
			List.of(),
			List.of(),
			List.of(),
			List.of(new MobSpawnSettings.SpawnerData(TechnologicaEntityTypes.SWEEPER.get(), 1, 1, 1)),
			List.of(),
			List.of(),
			List.of(),
			List.of()), 2.0F));
		biome.register(TechnologicaBiomes.CRATER_FIELDS, biome(new TLReGenCarvers(List.of(), List.of()), 0.6F, new TLReGenEffects(0, 10387789, 9470285, AmbientMoodSettings.LEGACY_CAVE_SETTINGS, 0, 4159204, 329011), new TLReGenFeatures(List.of(), List.of(), List.of(), List.of(), List.of(), List.of(), List.of(), List.of(), List.of(), List.of(), List.of()), true, new TLReGenSpawners(
			List.of(),
			List.of(),
			List.of(),
			List.of(),
			List.of(new MobSpawnSettings.SpawnerData(EntityType.CREEPER, 1, 1, 1)),
			List.of(),
			List.of(),
			List.of(),
			List.of()), 0.6F));
		biome.register(TechnologicaBiomes.SHATTERED_CORRIDORS, biome(new TLReGenCarvers(List.of(), List.of()), 0.0F, new TLReGenEffects(0, 10387789, 9470285, AmbientMoodSettings.LEGACY_CAVE_SETTINGS, 0, 4159204, 329011), new TLReGenFeatures(List.of(), List.of(), List.of(), List.of(), List.of(), List.of(), List.of(), List.of(), List.of(), List.of(), List.of()), false, new TLReGenSpawners(
			List.of(),
			List.of(),
			List.of(),
			List.of(),
			List.of(new MobSpawnSettings.SpawnerData(TechnologicaEntityTypes.PEEPER.get(), 1, 1, 1)),
			List.of(),
			List.of(),
			List.of(),
			List.of()), 2.0F));
		biome.register(TechnologicaBiomes.MISTY_MIRE, biome(new TLReGenCarvers(List.of(), List.of()), 0.5F, new TLReGenEffects(12638463, 9285927, BiomeSpecialEffects.GrassColorModifier.SWAMP, AmbientMoodSettings.LEGACY_CAVE_SETTINGS, 8103167, 4445678, 270131), new TLReGenFeatures(List.of(), List.of(), List.of(), List.of(), List.of(), List.of(), List.of(), List.of(), List.of(), List.of(TechnologicaPlacedFeatures.OVERGROWTH_PLACED), List.of()), true, new TLReGenSpawners(
			List.of(),
			List.of(),
			List.of(),
			List.of(),
			List.of(new MobSpawnSettings.SpawnerData(EntityType.HUSK, 1, 1, 1), new MobSpawnSettings.SpawnerData(EntityType.SLIME, 1, 1, 1)),
			List.of(),
			List.of(),
			List.of(),
			List.of()), 0.5F));
		biome.register(TechnologicaBiomes.BRAMBLE, biome(new TLReGenCarvers(List.of(), List.of()), 0.5F, new TLReGenEffects(12638463, 9285927, BiomeSpecialEffects.GrassColorModifier.SWAMP, AmbientMoodSettings.LEGACY_CAVE_SETTINGS, 8103167, 4445678, 270131), new TLReGenFeatures(List.of(), List.of(), List.of(), List.of(), List.of(), List.of(), List.of(), List.of(), List.of(), List.of(TechnologicaPlacedFeatures.OVERGROWTH_PLACED), List.of()), true, new TLReGenSpawners(
			List.of(),
			List.of(),
			List.of(),
			List.of(),
			List.of(new MobSpawnSettings.SpawnerData(EntityType.HUSK, 1, 1, 1), new MobSpawnSettings.SpawnerData(EntityType.SLIME, 1, 1, 1)),
			List.of(),
			List.of(),
			List.of(),
			List.of()), 0.5F));
		biome.register(TechnologicaBiomes.RUSTING_GROUNDS, biome(
			new TLReGenCarvers(List.of(), List.of()), 
			0.0F, 
			new TLReGenEffects(12638463, 9285927, BiomeSpecialEffects.GrassColorModifier.SWAMP, AmbientMoodSettings.LEGACY_CAVE_SETTINGS, 8103167, -15787726, -15787726), 
			new TLReGenFeatures(List.of(), List.of(), List.of(), List.of(), List.of(), List.of(), List.of(), List.of(TechnologicaPlacedFeatures.NAVAL_MINE), List.of(), List.of(), List.of()), 
			true, 
			new TLReGenSpawners(List.of(), List.of(), List.of(), List.of(), List.of(), List.of(), List.of(), List.of(), List.of(Pair.of(TechnologicaMobCategory.SHARK, List.of(new MobSpawnSettings.SpawnerData(TechnologicaEntityTypes.SHARK.get(), 1, 1, 1))))), 
			0.5F));
	}
}
