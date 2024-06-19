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
import net.minecraft.data.worldgen.placement.CavePlacements;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.biome.AmbientMoodSettings;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.BiomeSpecialEffects;
import net.minecraft.world.level.biome.MobSpawnSettings;

public final class TLWorldgenBiomes extends TLReGenWorldgenBiome {

	public static void bootstrap(BootstapContext<Biome> biome) {
		placedFeature = biome.lookup(Registries.PLACED_FEATURE);
		configuredWorldCarver = biome.lookup(Registries.CONFIGURED_CARVER);

		biome.register(TechnologicaBiomes.CRATER_FIELDS, biome(new TLReGenCarvers(List.of(), List.of()), 0.6F, new TLReGenEffects(0, 10387789, 9470285, AmbientMoodSettings.LEGACY_CAVE_SETTINGS, 0, 4159204, 329011), new TLReGenFeatures(List.of(), List.of(), List.of(), List.of(), List.of(), List.of(), List.of(), List.of(), List.of(), List.of(), List.of()), true, new TLReGenSpawners(List.of(), List.of(), List.of(), List.of(), List.of(new MobSpawnSettings.SpawnerData(EntityType.CREEPER, 1, 1, 1)), List.of(), List.of(), List.of(), List.of()), 0.6F));
		biome.register(TechnologicaBiomes.SHATTERED_CORRIDORS, biome(new TLReGenCarvers(List.of(), List.of()), 0.0F, new TLReGenEffects(0, 10387789, 9470285, AmbientMoodSettings.LEGACY_CAVE_SETTINGS, 0, 4159204, 329011), new TLReGenFeatures(List.of(), List.of(), List.of(), List.of(), List.of(), List.of(), List.of(), List.of(), List.of(), List.of(), List.of()), false, new TLReGenSpawners(List.of(), List.of(), List.of(), List.of(), List.of(new MobSpawnSettings.SpawnerData(TechnologicaEntityTypes.PEEPER.get(), 1, 1, 1)), List.of(), List.of(), List.of(), List.of()), 2.0F));
		biome.register(TechnologicaBiomes.SILENT_EXPANSES, biome(new TLReGenCarvers(List.of(), List.of()), 0.0F, new TLReGenEffects(0, 10387789, 9470285, AmbientMoodSettings.LEGACY_CAVE_SETTINGS, 0, 4159204, 329011), new TLReGenFeatures(List.of(), List.of(), List.of(), List.of(), List.of(), List.of(), List.of(), List.of(), List.of(), List.of(), List.of()), false, new TLReGenSpawners(List.of(), List.of(), List.of(), List.of(), List.of(new MobSpawnSettings.SpawnerData(TechnologicaEntityTypes.SWEEPER.get(), 1, 1, 1)), List.of(), List.of(), List.of(), List.of()), 2.0F));

		biome.register(TechnologicaBiomes.ABYSSAL_DEPTHS, biome(new TLReGenCarvers(List.of(), List.of()), 1.0F, new TLReGenEffects(12638463, 9285927, BiomeSpecialEffects.GrassColorModifier.SWAMP, AmbientMoodSettings.LEGACY_CAVE_SETTINGS, 8103167, 0x3D57D6, 0x050533), new TLReGenFeatures(List.of(), List.of(), List.of(), List.of(), List.of(), List.of(), List.of(), List.of(), List.of(), List.of(), List.of()), false, new TLReGenSpawners(List.of(), List.of(), List.of(), List.of(), List.of(), List.of(), List.of(), List.of(), List.of()), 0.5F));
		biome.register(TechnologicaBiomes.FORGOTTEN_REEF, biome(new TLReGenCarvers(List.of(), List.of()), 1.0F, new TLReGenEffects(12638463, 9285927, BiomeSpecialEffects.GrassColorModifier.SWAMP, AmbientMoodSettings.LEGACY_CAVE_SETTINGS, 8103167, 0x43D5EE, 0x41F33), new TLReGenFeatures(List.of(), List.of(), List.of(), List.of(), List.of(), List.of(), List.of(), List.of(), List.of(), List.of(TechnologicaPlacedFeatures.DEEP_CORALS), List.of()), false, new TLReGenSpawners(List.of(), List.of(), List.of(), List.of(), List.of(), List.of(), List.of(new MobSpawnSettings.SpawnerData(EntityType.TROPICAL_FISH, 1, 1, 15), new MobSpawnSettings.SpawnerData(EntityType.PUFFERFISH, 1, 1, 3)), List.of(new MobSpawnSettings.SpawnerData(EntityType.SQUID, 1, 1, 1)), List.of()), 0.5F));
		biome.register(TechnologicaBiomes.HYDROTHERMAL_CAVERN, biome(new TLReGenCarvers(List.of(), List.of()), 1.0F, new TLReGenEffects(12638463, 9285927, BiomeSpecialEffects.GrassColorModifier.SWAMP, AmbientMoodSettings.LEGACY_CAVE_SETTINGS, 8103167, 0x905957, 0x905957), new TLReGenFeatures(List.of(), List.of(), List.of(), List.of(), List.of(TechnologicaPlacedFeatures.DEEP_BASALT_PILLAR, TechnologicaPlacedFeatures.HYDROTHERMAL_VENT), List.of(), List.of(CavePlacements.UNDERWATER_MAGMA), List.of(TechnologicaPlacedFeatures.DEEP_BASALT_BLOB), List.of(), List.of(), List.of()), false, new TLReGenSpawners(List.of(), List.of(), List.of(), List.of(), List.of(), List.of(), List.of(), List.of(), List.of()), 0.5F));
		biome.register(TechnologicaBiomes.NAVAL_GRAVEYARD, biome(new TLReGenCarvers(List.of(), List.of()), 1.0F, new TLReGenEffects(0x00010101, 9285927, BiomeSpecialEffects.GrassColorModifier.SWAMP, AmbientMoodSettings.LEGACY_CAVE_SETTINGS, 0, 0x00010101, 0x00010101), new TLReGenFeatures(List.of(), List.of(), List.of(CavePlacements.LARGE_DRIPSTONE, CavePlacements.POINTED_DRIPSTONE), List.of(), List.of(), List.of(), List.of(), List.of(), List.of(), List.of(), List.of()), false, new TLReGenSpawners(List.of(), List.of(), List.of(), List.of(), List.of(), List.of(), List.of(), List.of(), List.of()), 0.5F));
		biome.register(TechnologicaBiomes.RUSTING_GROUNDS, biome(new TLReGenCarvers(List.of(), List.of()), 1.0F, new TLReGenEffects(12638463, 9285927, BiomeSpecialEffects.GrassColorModifier.SWAMP, AmbientMoodSettings.LEGACY_CAVE_SETTINGS, 8103167, -15787726, -15787726), new TLReGenFeatures(List.of(), List.of(), List.of(), List.of(), List.of(), List.of(), List.of(), List.of(TechnologicaPlacedFeatures.NAVAL_MINE), List.of(), List.of(), List.of()), false, new TLReGenSpawners(List.of(), List.of(), List.of(), List.of(), List.of(), List.of(), List.of(), List.of(), List.of(Pair.of(TechnologicaMobCategory.SHARK, List.of(new MobSpawnSettings.SpawnerData(TechnologicaEntityTypes.SHARK.get(), 1, 1, 1))))), 0.5F));
		biome.register(TechnologicaBiomes.SUNKEN_FOREST, biome(new TLReGenCarvers(List.of(), List.of()), 1.0F, new TLReGenEffects(12638463, 9285927, BiomeSpecialEffects.GrassColorModifier.SWAMP, AmbientMoodSettings.LEGACY_CAVE_SETTINGS, 0, 0x3A7A6A, 0x4D7A60), new TLReGenFeatures(List.of(), List.of(), List.of(), List.of(), List.of(), List.of(), List.of(), List.of(), List.of(), List.of(TechnologicaPlacedFeatures.DEEP_KELP, TechnologicaPlacedFeatures.DEEP_SEAGRASS), List.of()), false, new TLReGenSpawners(List.of(), List.of(), List.of(), List.of(), List.of(), List.of(), List.of(), List.of(new MobSpawnSettings.SpawnerData(EntityType.TURTLE, 1, 1, 1)), List.of()), 0.5F));

		biome.register(TechnologicaBiomes.BRAMBLE, biome(new TLReGenCarvers(List.of(), List.of()), 0.5F, new TLReGenEffects(12638463, 9285927, BiomeSpecialEffects.GrassColorModifier.SWAMP, AmbientMoodSettings.LEGACY_CAVE_SETTINGS, 8103167, 4445678, 270131), new TLReGenFeatures(List.of(), List.of(), List.of(), List.of(), List.of(), List.of(), List.of(), List.of(), List.of(), List.of(TechnologicaPlacedFeatures.OVERGROWTH_PLACED), List.of()), true, new TLReGenSpawners(List.of(), List.of(), List.of(), List.of(), List.of(new MobSpawnSettings.SpawnerData(EntityType.HUSK, 1, 1, 1), new MobSpawnSettings.SpawnerData(EntityType.SLIME, 1, 1, 1)), List.of(), List.of(), List.of(), List.of()), 0.5F));
		biome.register(TechnologicaBiomes.MISTY_MIRE, biome(new TLReGenCarvers(List.of(), List.of()), 0.5F, new TLReGenEffects(12638463, 9285927, BiomeSpecialEffects.GrassColorModifier.SWAMP, AmbientMoodSettings.LEGACY_CAVE_SETTINGS, 8103167, 4445678, 270131), new TLReGenFeatures(List.of(), List.of(), List.of(), List.of(), List.of(), List.of(), List.of(), List.of(), List.of(), List.of(TechnologicaPlacedFeatures.OVERGROWTH_PLACED), List.of()), true, new TLReGenSpawners(List.of(), List.of(), List.of(), List.of(), List.of(new MobSpawnSettings.SpawnerData(EntityType.HUSK, 1, 1, 1), new MobSpawnSettings.SpawnerData(EntityType.SLIME, 1, 1, 1)), List.of(), List.of(), List.of(), List.of()), 0.5F));
	}

	@Override
	protected void populate() {
		// TODO Auto-generated method stub
	}
}
