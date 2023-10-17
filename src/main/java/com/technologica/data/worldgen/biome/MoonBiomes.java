package com.technologica.data.worldgen.biome;

import com.technologica.world.entity.TechnologicaEntityType;

import net.minecraft.core.HolderGetter;
import net.minecraft.data.worldgen.BiomeDefaultFeatures;
import net.minecraft.data.worldgen.Carvers;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.level.biome.AmbientMoodSettings;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.BiomeGenerationSettings;
import net.minecraft.world.level.biome.BiomeSpecialEffects;
import net.minecraft.world.level.biome.MobSpawnSettings;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.levelgen.carver.ConfiguredWorldCarver;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;

public class MoonBiomes {

	private static void globalOverworldGeneration(BiomeGenerationSettings.Builder p_194870_) {
		p_194870_.addCarver(GenerationStep.Carving.AIR, Carvers.CAVE);
		BiomeDefaultFeatures.addSurfaceFreezing(p_194870_);
	}

	public static Biome silentExpanse(HolderGetter<PlacedFeature> p_256309_, HolderGetter<ConfiguredWorldCarver<?>> p_256430_, boolean p_194897_) {
		MobSpawnSettings.Builder mobspawnsettings$builder = new MobSpawnSettings.Builder();
		moonSpawns(mobspawnsettings$builder);
		BiomeGenerationSettings.Builder biomegenerationsettings$builder = new BiomeGenerationSettings.Builder(p_256309_, p_256430_);
		globalOverworldGeneration(biomegenerationsettings$builder);
		return (new Biome.BiomeBuilder()).precipitation(Biome.Precipitation.NONE).temperature(2.0F).downfall(0.0F).specialEffects((new BiomeSpecialEffects.Builder()).waterColor(4159204).waterFogColor(329011).fogColor(0).skyColor(0).foliageColorOverride(10387789).grassColorOverride(9470285).ambientMoodSound(AmbientMoodSettings.LEGACY_CAVE_SETTINGS).build()).mobSpawnSettings(mobspawnsettings$builder.build()).generationSettings(biomegenerationsettings$builder.build()).build();
	}

	public static void moonSpawns(MobSpawnSettings.Builder p_126789_) {
		sweepers(p_126789_, 95, 5, 100, false);
	}

	public static void sweepers(MobSpawnSettings.Builder p_194726_, int p_194727_, int p_194728_, int p_194729_, boolean p_194730_) {
		p_194726_.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(TechnologicaEntityType.SWEEPER.get(), 1, 0, 1));
	}
}