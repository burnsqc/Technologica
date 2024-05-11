package com.technologica.resourcegen.data.worldgen.biome;

import com.technologica.api.tlregen.resourcegen.data.worldgen.TLReGenWorldgenBiome;
import com.technologica.registration.deferred.TechnologicaEntityTypes;
import com.technologica.registration.key.TechnologicaBiomes;
import com.technologica.registration.key.TechnologicaPlacedFeatures;
import com.technologica.world.entity.TechnologicaMobCategory;

import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.data.worldgen.Carvers;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.level.biome.AmbientMoodSettings;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.BiomeGenerationSettings;
import net.minecraft.world.level.biome.BiomeSpecialEffects;
import net.minecraft.world.level.biome.BiomeSpecialEffects.GrassColorModifier;
import net.minecraft.world.level.biome.MobSpawnSettings;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.levelgen.carver.ConfiguredWorldCarver;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;

public final class TLBiomes extends TLReGenWorldgenBiome {
	private static HolderGetter<PlacedFeature> placedFeature;
	private static HolderGetter<ConfiguredWorldCarver<?>> configuredWorldCarver;;

	public static void bootstrap(BootstapContext<Biome> biome) {
		placedFeature = biome.lookup(Registries.PLACED_FEATURE);
		configuredWorldCarver = biome.lookup(Registries.CONFIGURED_CARVER);
		biome.register(TechnologicaBiomes.SILENT_EXPANSES, silentExpanses());
		biome.register(TechnologicaBiomes.CRATER_FIELDS, craterFields());
		biome.register(TechnologicaBiomes.SHATTERED_CORRIDORS, shatteredCorridors());
		biome.register(TechnologicaBiomes.MISTY_MIRE, mistyMire());
		biome.register(TechnologicaBiomes.BRAMBLE, bramble());
		biome.register(TechnologicaBiomes.RUSTING_GROUNDS, biome(Carvers.CAVE, 0.0F, effects(12638463, 9285927, BiomeSpecialEffects.GrassColorModifier.SWAMP, AmbientMoodSettings.LEGACY_CAVE_SETTINGS, 8103167, -15787726, -15787726), new FeatureBuilder().localModifications(TechnologicaPlacedFeatures.NAVAL_MINE).build(), true, new SpawnerBuilder().waterCreature(TechnologicaEntityTypes.SHARK.get(), 1, 1, 1).build(), 0.5F));
	}

	private static Biome silentExpanses() {
		return biome(Carvers.CAVE, 0.0F, effects(0, 10387789, 9470285, AmbientMoodSettings.LEGACY_CAVE_SETTINGS, 0, 4159204, 329011), new FeatureBuilder().build(), false, new SpawnerBuilder().monster(TechnologicaEntityTypes.SWEEPER.get(), 1, 1, 1).build(), 2.0F);
	}

	private static Biome craterFields() {
		return biome(Carvers.CAVE, 0.6F, effects(0, 10387789, 9470285, AmbientMoodSettings.LEGACY_CAVE_SETTINGS, 0, 4159204, 329011), new FeatureBuilder().build(), true, new SpawnerBuilder().monster(EntityType.CREEPER, 1, 1, 1).build(), 0.6F);
	}

	private static Biome shatteredCorridors() {
		return biome(Carvers.CAVE, 0.0F, effects(0, 10387789, 9470285, AmbientMoodSettings.LEGACY_CAVE_SETTINGS, 0, 4159204, 329011), new FeatureBuilder().build(), false, new SpawnerBuilder().monster(TechnologicaEntityTypes.PEEPER.get(), 1, 1, 1).build(), 2.0F);
	}

	private static Biome mistyMire() {
		return biome(Carvers.CAVE, 0.5F, effects(12638463, 9285927, BiomeSpecialEffects.GrassColorModifier.SWAMP, AmbientMoodSettings.LEGACY_CAVE_SETTINGS, 8103167, 4445678, 270131), new FeatureBuilder().vegetal(TechnologicaPlacedFeatures.OVERGROWTH_PLACED).build(), true, new SpawnerBuilder().monster(EntityType.HUSK, 1, 1, 1).monster(EntityType.SLIME, 1, 1, 1).build(), 0.5F);
	}

	private static Biome bramble() {
		return biome(Carvers.CAVE, 0.5F, effects(12638463, 9285927, BiomeSpecialEffects.GrassColorModifier.SWAMP, AmbientMoodSettings.LEGACY_CAVE_SETTINGS, 8103167, 4445678, 270131), new FeatureBuilder().vegetal(TechnologicaPlacedFeatures.OVERGROWTH_PLACED).build(), true, new SpawnerBuilder().monster(EntityType.HUSK, 1, 1, 1).monster(EntityType.SLIME, 1, 1, 1).build(), 0.5F);
	}

	private static Biome biome(ResourceKey<ConfiguredWorldCarver<?>> carvers, float downfall, BiomeSpecialEffects effects, BiomeGenerationSettings.Builder settings, boolean hasPrecipitation, MobSpawnSettings spawners, float temperature) {
		return new Biome.BiomeBuilder().downfall(downfall).specialEffects(effects).generationSettings(settings.addCarver(GenerationStep.Carving.AIR, carvers).build()).hasPrecipitation(hasPrecipitation).mobSpawnSettings(spawners).temperature(temperature).build();
	}

	private static BiomeSpecialEffects effects(int fogColor, int foliageColor, GrassColorModifier grassColorModifier, AmbientMoodSettings moodSound, int skyColor, int waterColor, int waterFogColor) {
		return new BiomeSpecialEffects.Builder().fogColor(fogColor).foliageColorOverride(foliageColor).grassColorModifier(grassColorModifier).ambientMoodSound(moodSound).skyColor(skyColor).waterColor(waterColor).waterFogColor(waterFogColor).build();
	}

	private static BiomeSpecialEffects effects(int fogColor, int foliageColor, int grassColor, AmbientMoodSettings moodSound, int skyColor, int waterColor, int waterFogColor) {
		return new BiomeSpecialEffects.Builder().fogColor(fogColor).foliageColorOverride(foliageColor).grassColorOverride(grassColor).ambientMoodSound(moodSound).skyColor(skyColor).waterColor(waterColor).waterFogColor(waterFogColor).build();
	}

	private static class FeatureBuilder {
		private BiomeGenerationSettings.Builder builder;

		private FeatureBuilder() {
			this.builder = new BiomeGenerationSettings.Builder(placedFeature, configuredWorldCarver);
		}

		private FeatureBuilder vegetal(ResourceKey<PlacedFeature> feature) {
			this.builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, feature);
			return this;
		}

		private FeatureBuilder localModifications(ResourceKey<PlacedFeature> feature) {
			this.builder.addFeature(GenerationStep.Decoration.LOCAL_MODIFICATIONS, feature);
			return this;
		}

		private BiomeGenerationSettings.Builder build() {
			return this.builder;
		}
	}

	private static class SpawnerBuilder {
		private MobSpawnSettings.Builder builder;

		private SpawnerBuilder() {
			this.builder = new MobSpawnSettings.Builder();
		}

		private SpawnerBuilder monster(EntityType<?> entity, int weight, int maxCount, int minCount) {
			this.builder.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(entity, weight, maxCount, minCount));
			return this;
		}

		private SpawnerBuilder waterCreature(EntityType<?> entity, int weight, int maxCount, int minCount) {
			this.builder.addSpawn(TechnologicaMobCategory.SHARK, new MobSpawnSettings.SpawnerData(entity, weight, maxCount, minCount));
			return this;
		}

		private MobSpawnSettings build() {
			return this.builder.build();
		}
	}
}
