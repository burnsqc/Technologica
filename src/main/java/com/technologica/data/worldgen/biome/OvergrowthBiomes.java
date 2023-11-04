package com.technologica.data.worldgen.biome;

import com.technologica.data.worldgen.placement.TechnologicaVegetationPlacements;

import net.minecraft.core.HolderGetter;
import net.minecraft.data.worldgen.Carvers;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.level.biome.AmbientMoodSettings;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.BiomeGenerationSettings;
import net.minecraft.world.level.biome.BiomeSpecialEffects;
import net.minecraft.world.level.biome.MobSpawnSettings;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.levelgen.carver.ConfiguredWorldCarver;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;

public class OvergrowthBiomes {
	public static Biome mistyMire(HolderGetter<PlacedFeature> p_256309_, HolderGetter<ConfiguredWorldCarver<?>> p_256430_, boolean p_194897_) {
		return new Biome.BiomeBuilder()
				.downfall(0.5F)
				.specialEffects(new BiomeSpecialEffects.Builder()
						.fogColor(12638463)
						.foliageColorOverride(9285927)
						.grassColorModifier(BiomeSpecialEffects.GrassColorModifier.SWAMP)
						.ambientMoodSound(AmbientMoodSettings.LEGACY_CAVE_SETTINGS)
						.skyColor(8103167)
						.waterColor(4445678)
						.waterFogColor(270131).build())
				.generationSettings(new BiomeGenerationSettings.Builder(p_256309_, p_256430_)
						.addCarver(GenerationStep.Carving.AIR, Carvers.CAVE)
						.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, TechnologicaVegetationPlacements.OVERGROWTH_PLACED)
						.build())
				.hasPrecipitation(true)
				.mobSpawnSettings(new MobSpawnSettings.Builder()
						.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(
								EntityType.HUSK, 
								1, 
								1, 
								1))
						.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(
								EntityType.SLIME, 
								1, 
								1, 
								1)).build())
				.temperature(0.5F).build();
	}
}