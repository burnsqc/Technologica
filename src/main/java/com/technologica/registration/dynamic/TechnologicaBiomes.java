package com.technologica.registration.dynamic;

import java.util.List;
import java.util.OptionalInt;

import com.mojang.datafixers.util.Pair;
import com.technologica.Technologica;
import com.technologica.api.tlregen.resourcegen.data.worldgen.TLReGenWorldgenBiome;
import com.technologica.registration.deferred.TechnologicaEntityTypes;
import com.technologica.world.entity.TechnologicaMobCategory;

import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.placement.CavePlacements;
import net.minecraft.resources.ResourceKey;
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

public final class TechnologicaBiomes {
	public static final ResourceKey<Biome> SILENT_EXPANSES = Technologica.BIOMES.register("silent_expanses", () -> biome(new TLReGenCarvers(List.of(), List.of()), 0.0F, new TLReGenEffects(0, 10387789, 9470285, AmbientMoodSettings.LEGACY_CAVE_SETTINGS, 0, 4159204, 329011), new TLReGenFeatures(List.of(), List.of(), List.of(), List.of(), List.of(), List.of(), List.of(), List.of(), List.of(), List.of(), List.of()), false, new TLReGenSpawners(List.of(), List.of(), List.of(), List.of(), List.of(new MobSpawnSettings.SpawnerData(TechnologicaEntityTypes.SWEEPER.get(), 1, 1, 1)), List.of(), List.of(), List.of(), List.of()), 2.0F));
	public static final ResourceKey<Biome> CRATER_FIELDS = Technologica.BIOMES.register("crater_fields", () -> biome(new TLReGenCarvers(List.of(), List.of()), 0.6F, new TLReGenEffects(0, 10387789, 9470285, AmbientMoodSettings.LEGACY_CAVE_SETTINGS, 0, 4159204, 329011), new TLReGenFeatures(List.of(), List.of(), List.of(), List.of(), List.of(), List.of(), List.of(), List.of(), List.of(), List.of(), List.of()), true, new TLReGenSpawners(List.of(), List.of(), List.of(), List.of(), List.of(new MobSpawnSettings.SpawnerData(EntityType.CREEPER, 1, 1, 1)), List.of(), List.of(), List.of(), List.of()), 0.6F));
	public static final ResourceKey<Biome> SHATTERED_CORRIDORS = Technologica.BIOMES.register("shattered_corridors", () -> biome(new TLReGenCarvers(List.of(), List.of()), 0.0F, new TLReGenEffects(0, 10387789, 9470285, AmbientMoodSettings.LEGACY_CAVE_SETTINGS, 0, 4159204, 329011), new TLReGenFeatures(List.of(), List.of(), List.of(), List.of(), List.of(), List.of(), List.of(), List.of(), List.of(), List.of(), List.of()), false, new TLReGenSpawners(List.of(), List.of(), List.of(), List.of(), List.of(new MobSpawnSettings.SpawnerData(TechnologicaEntityTypes.PEEPER.get(), 1, 1, 1)), List.of(), List.of(), List.of(), List.of()), 2.0F));
	public static final ResourceKey<Biome> MISTY_MIRE = Technologica.BIOMES.register("misty_mire", () -> biome(new TLReGenCarvers(List.of(), List.of()), 0.5F, new TLReGenEffects(12638463, 9285927, BiomeSpecialEffects.GrassColorModifier.SWAMP, AmbientMoodSettings.LEGACY_CAVE_SETTINGS, 8103167, 4445678, 270131), new TLReGenFeatures(List.of(), List.of(), List.of(), List.of(), List.of(), List.of(), List.of(), List.of(), List.of(), List.of(TechnologicaPlacedFeatures.OVERGROWTH_PLACED), List.of()), true, new TLReGenSpawners(List.of(), List.of(), List.of(), List.of(), List.of(new MobSpawnSettings.SpawnerData(EntityType.HUSK, 1, 1, 1), new MobSpawnSettings.SpawnerData(EntityType.SLIME, 1, 1, 1)), List.of(), List.of(), List.of(), List.of()), 0.5F));
	public static final ResourceKey<Biome> BRAMBLE = Technologica.BIOMES.register("bramble", () -> biome(new TLReGenCarvers(List.of(), List.of()), 0.5F, new TLReGenEffects(12638463, 9285927, BiomeSpecialEffects.GrassColorModifier.SWAMP, AmbientMoodSettings.LEGACY_CAVE_SETTINGS, 8103167, 4445678, 270131), new TLReGenFeatures(List.of(), List.of(), List.of(), List.of(), List.of(), List.of(), List.of(), List.of(), List.of(), List.of(TechnologicaPlacedFeatures.OVERGROWTH_PLACED), List.of()), true, new TLReGenSpawners(List.of(), List.of(), List.of(), List.of(), List.of(new MobSpawnSettings.SpawnerData(EntityType.HUSK, 1, 1, 1), new MobSpawnSettings.SpawnerData(EntityType.SLIME, 1, 1, 1)), List.of(), List.of(), List.of(), List.of()), 0.5F));
	public static final ResourceKey<Biome> RUSTING_GROUNDS = Technologica.BIOMES.register("rusting_grounds", () -> biome(new TLReGenCarvers(List.of(), List.of()), 1.0F, new TLReGenEffects(12638463, 9285927, BiomeSpecialEffects.GrassColorModifier.SWAMP, AmbientMoodSettings.LEGACY_CAVE_SETTINGS, 8103167, -15787726, -15787726), new TLReGenFeatures(List.of(), List.of(), List.of(), List.of(), List.of(), List.of(), List.of(), List.of(TechnologicaPlacedFeatures.NAVAL_MINE), List.of(), List.of(), List.of()), false, new TLReGenSpawners(List.of(), List.of(), List.of(), List.of(), List.of(), List.of(), List.of(), List.of(), List.of(Pair.of(TechnologicaMobCategory.SHARK, List.of(new MobSpawnSettings.SpawnerData(TechnologicaEntityTypes.SHARK.get(), 1, 1, 1))))), 0.5F));
	public static final ResourceKey<Biome> FORGOTTEN_REEF = Technologica.BIOMES.register("forgotten_reef", () -> biome(new TLReGenCarvers(List.of(), List.of()), 1.0F, new TLReGenEffects(12638463, 9285927, BiomeSpecialEffects.GrassColorModifier.SWAMP, AmbientMoodSettings.LEGACY_CAVE_SETTINGS, 8103167, 0x43D5EE, 0x41F33), new TLReGenFeatures(List.of(), List.of(), List.of(), List.of(), List.of(), List.of(), List.of(), List.of(), List.of(), List.of(TechnologicaPlacedFeatures.DEEP_CORALS), List.of()), false, new TLReGenSpawners(List.of(), List.of(), List.of(), List.of(), List.of(), List.of(), List.of(new MobSpawnSettings.SpawnerData(EntityType.TROPICAL_FISH, 1, 1, 15), new MobSpawnSettings.SpawnerData(EntityType.PUFFERFISH, 1, 1, 3)), List.of(new MobSpawnSettings.SpawnerData(EntityType.SQUID, 1, 1, 1)), List.of()), 0.5F));
	public static final ResourceKey<Biome> NAVAL_GRAVEYARD = Technologica.BIOMES.register("naval_graveyard", () -> biome(new TLReGenCarvers(List.of(), List.of()), 1.0F, new TLReGenEffects(0x00010101, 9285927, BiomeSpecialEffects.GrassColorModifier.SWAMP, AmbientMoodSettings.LEGACY_CAVE_SETTINGS, 0, 0x00010101, 0x00010101), new TLReGenFeatures(List.of(), List.of(), List.of(CavePlacements.LARGE_DRIPSTONE, CavePlacements.POINTED_DRIPSTONE), List.of(), List.of(), List.of(), List.of(), List.of(), List.of(), List.of(), List.of()), false, new TLReGenSpawners(List.of(), List.of(), List.of(), List.of(), List.of(), List.of(), List.of(), List.of(), List.of()), 0.5F));
	public static final ResourceKey<Biome> SUNKEN_FOREST = Technologica.BIOMES.register("sunken_forest", () -> biome(new TLReGenCarvers(List.of(), List.of()), 1.0F, new TLReGenEffects(12638463, 9285927, BiomeSpecialEffects.GrassColorModifier.SWAMP, AmbientMoodSettings.LEGACY_CAVE_SETTINGS, 0, 0x3A7A6A, 0x4D7A60), new TLReGenFeatures(List.of(), List.of(), List.of(), List.of(), List.of(), List.of(), List.of(), List.of(), List.of(), List.of(TechnologicaPlacedFeatures.DEEP_KELP, TechnologicaPlacedFeatures.DEEP_SEAGRASS), List.of()), false, new TLReGenSpawners(List.of(), List.of(), List.of(), List.of(), List.of(), List.of(), List.of(), List.of(new MobSpawnSettings.SpawnerData(EntityType.TURTLE, 1, 1, 1)), List.of()), 0.5F));
	public static final ResourceKey<Biome> HYDROTHERMAL_CAVERN = Technologica.BIOMES.register("hydrothermal_cavern", () -> biome(new TLReGenCarvers(List.of(), List.of()), 1.0F, new TLReGenEffects(12638463, 9285927, BiomeSpecialEffects.GrassColorModifier.SWAMP, AmbientMoodSettings.LEGACY_CAVE_SETTINGS, 8103167, 0x905957, 0x905957), new TLReGenFeatures(List.of(), List.of(), List.of(), List.of(), List.of(TechnologicaPlacedFeatures.DEEP_BASALT_PILLAR, TechnologicaPlacedFeatures.HYDROTHERMAL_VENT), List.of(), List.of(CavePlacements.UNDERWATER_MAGMA), List.of(TechnologicaPlacedFeatures.DEEP_BASALT_BLOB), List.of(), List.of(), List.of()), false, new TLReGenSpawners(List.of(), List.of(), List.of(), List.of(), List.of(), List.of(), List.of(), List.of(), List.of()), 0.5F));
	public static final ResourceKey<Biome> ABYSSAL_DEPTHS = Technologica.BIOMES.register("abyssal_depths", () -> biome(new TLReGenCarvers(List.of(), List.of()), 1.0F, new TLReGenEffects(12638463, 9285927, BiomeSpecialEffects.GrassColorModifier.SWAMP, AmbientMoodSettings.LEGACY_CAVE_SETTINGS, 8103167, 0x3D57D6, 0x050533), new TLReGenFeatures(List.of(), List.of(), List.of(), List.of(), List.of(), List.of(), List.of(), List.of(), List.of(), List.of(), List.of()), false, new TLReGenSpawners(List.of(), List.of(), List.of(), List.of(), List.of(), List.of(), List.of(), List.of(), List.of()), 0.5F));

	public static Biome biome(TLReGenCarvers carvers, float downfall, TLReGenEffects effects, TLReGenFeatures features, boolean hasPrecipitation, TLReGenSpawners spawners, float temperature) {
		BiomeGenerationSettings.Builder settings = new BiomeGenerationSettings.Builder(TLReGenWorldgenBiome.bootstrapContext.lookup(Registries.PLACED_FEATURE), TLReGenWorldgenBiome.bootstrapContext.lookup(Registries.CONFIGURED_CARVER));
		BiomeSpecialEffects.Builder effects2 = new BiomeSpecialEffects.Builder().fogColor(effects.fogColor).foliageColorOverride(effects.foliageColor).grassColorModifier(effects.grassColorModifier).ambientMoodSound(effects.moodSound).skyColor(effects.skyColor).waterColor(effects.waterColor).waterFogColor(effects.waterFogColor);
		MobSpawnSettings.Builder spawners2 = new MobSpawnSettings.Builder();

		if (effects.grassColorOverride.isPresent()) {
			effects2.grassColorOverride(effects.grassColorOverride.getAsInt());
		}

		for (ResourceKey<ConfiguredWorldCarver<?>> carver : carvers.air) {
			settings.addCarver(GenerationStep.Carving.AIR, carver);
		}
		for (ResourceKey<ConfiguredWorldCarver<?>> carver : carvers.liquid) {
			settings.addCarver(GenerationStep.Carving.LIQUID, carver);
		}

		for (ResourceKey<PlacedFeature> feature : features.rawGeneration) {
			settings.addFeature(GenerationStep.Decoration.RAW_GENERATION, feature);
		}
		for (ResourceKey<PlacedFeature> feature : features.lakes) {
			settings.addFeature(GenerationStep.Decoration.LAKES, feature);
		}
		for (ResourceKey<PlacedFeature> feature : features.localModifications) {
			settings.addFeature(GenerationStep.Decoration.LOCAL_MODIFICATIONS, feature);
		}
		for (ResourceKey<PlacedFeature> feature : features.undergroundStructures) {
			settings.addFeature(GenerationStep.Decoration.UNDERGROUND_STRUCTURES, feature);
		}
		for (ResourceKey<PlacedFeature> feature : features.surfaceStructures) {
			settings.addFeature(GenerationStep.Decoration.SURFACE_STRUCTURES, feature);
		}
		for (ResourceKey<PlacedFeature> feature : features.strongholds) {
			settings.addFeature(GenerationStep.Decoration.STRONGHOLDS, feature);
		}
		for (ResourceKey<PlacedFeature> feature : features.undergroundOres) {
			settings.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, feature);
		}
		for (ResourceKey<PlacedFeature> feature : features.undergroundDecoration) {
			settings.addFeature(GenerationStep.Decoration.UNDERGROUND_DECORATION, feature);
		}
		for (ResourceKey<PlacedFeature> feature : features.vegetalDecoration) {
			settings.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, feature);
		}
		for (ResourceKey<PlacedFeature> feature : features.fluidSprings) {
			settings.addFeature(GenerationStep.Decoration.FLUID_SPRINGS, feature);
		}
		for (ResourceKey<PlacedFeature> feature : features.topLayerModification) {
			settings.addFeature(GenerationStep.Decoration.TOP_LAYER_MODIFICATION, feature);
		}

		for (MobSpawnSettings.SpawnerData spawner : spawners.ambient) {
			spawners2.addSpawn(MobCategory.AMBIENT, spawner);
		}
		for (MobSpawnSettings.SpawnerData spawner : spawners.axolotls) {
			spawners2.addSpawn(MobCategory.AXOLOTLS, spawner);
		}
		for (MobSpawnSettings.SpawnerData spawner : spawners.creature) {
			spawners2.addSpawn(MobCategory.CREATURE, spawner);
		}
		for (MobSpawnSettings.SpawnerData spawner : spawners.misc) {
			spawners2.addSpawn(MobCategory.MISC, spawner);
		}
		for (MobSpawnSettings.SpawnerData spawner : spawners.monster) {
			spawners2.addSpawn(MobCategory.MONSTER, spawner);
		}
		for (MobSpawnSettings.SpawnerData spawner : spawners.undergroundWaterCreature) {
			spawners2.addSpawn(MobCategory.UNDERGROUND_WATER_CREATURE, spawner);
		}
		for (MobSpawnSettings.SpawnerData spawner : spawners.waterAmbient) {
			spawners2.addSpawn(MobCategory.WATER_AMBIENT, spawner);
		}
		for (MobSpawnSettings.SpawnerData spawner : spawners.waterCreature) {
			spawners2.addSpawn(MobCategory.WATER_CREATURE, spawner);
		}
		for (Pair<MobCategory, List<MobSpawnSettings.SpawnerData>> custom : spawners.custom) {
			for (MobSpawnSettings.SpawnerData spawner : custom.getSecond()) {
				spawners2.addSpawn(custom.getFirst(), spawner);
			}
		}

		return new Biome.BiomeBuilder().downfall(downfall).specialEffects(effects2.build()).generationSettings(settings.build()).hasPrecipitation(hasPrecipitation).mobSpawnSettings(spawners2.build()).temperature(temperature).build();
	}

	/*
	 * TEMPLATES
	 */

	/**
	 * @param air
	 * @param liquid
	 */
	public record TLReGenCarvers(List<ResourceKey<ConfiguredWorldCarver<?>>> air, List<ResourceKey<ConfiguredWorldCarver<?>>> liquid) {
		/**
		 * @param air
		 */
		public TLReGenCarvers(List<ResourceKey<ConfiguredWorldCarver<?>>> air) {
			this(air, List.of());
		}
	}

	/**
	 * @param fogColor
	 * @param foliageColor
	 * @param grassColorOverride
	 * @param grassColorModifier
	 * @param moodSound
	 * @param skyColor
	 * @param waterColor
	 * @param waterFogColor
	 */
	public record TLReGenEffects(int fogColor, int foliageColor, OptionalInt grassColorOverride, BiomeSpecialEffects.GrassColorModifier grassColorModifier, AmbientMoodSettings moodSound, int skyColor, int waterColor, int waterFogColor) {
		/**
		 * @param fogColor
		 * @param foliageColor
		 * @param grassColorOverride
		 * @param moodSound
		 * @param skyColor
		 * @param waterColor
		 * @param waterFogColor
		 */
		public TLReGenEffects(int fogColor, int foliageColor, int grassColorOverride, AmbientMoodSettings moodSound, int skyColor, int waterColor, int waterFogColor) {
			this(fogColor, foliageColor, OptionalInt.of(grassColorOverride), BiomeSpecialEffects.GrassColorModifier.NONE, moodSound, skyColor, waterColor, waterFogColor);
		}

		/**
		 * @param fogColor
		 * @param foliageColor
		 * @param grassColorModifier
		 * @param moodSound
		 * @param skyColor
		 * @param waterColor
		 * @param waterFogColor
		 */
		public TLReGenEffects(int fogColor, int foliageColor, BiomeSpecialEffects.GrassColorModifier grassColorModifier, AmbientMoodSettings moodSound, int skyColor, int waterColor, int waterFogColor) {
			this(fogColor, foliageColor, OptionalInt.empty(), grassColorModifier, moodSound, skyColor, waterColor, waterFogColor);
		}
	}

	/**
	 * @param rawGeneration
	 * @param lakes
	 * @param localModifications
	 * @param undergroundStructures
	 * @param surfaceStructures
	 * @param strongholds
	 * @param undergroundOres
	 * @param undergroundDecoration
	 * @param fluidSprings
	 * @param vegetalDecoration
	 * @param topLayerModification
	 */
	public record TLReGenFeatures(List<ResourceKey<PlacedFeature>> rawGeneration, List<ResourceKey<PlacedFeature>> lakes, List<ResourceKey<PlacedFeature>> localModifications, List<ResourceKey<PlacedFeature>> undergroundStructures, List<ResourceKey<PlacedFeature>> surfaceStructures, List<ResourceKey<PlacedFeature>> strongholds, List<ResourceKey<PlacedFeature>> undergroundOres, List<ResourceKey<PlacedFeature>> undergroundDecoration, List<ResourceKey<PlacedFeature>> fluidSprings, List<ResourceKey<PlacedFeature>> vegetalDecoration, List<ResourceKey<PlacedFeature>> topLayerModification) {
	}

	/**
	 * @param ambient
	 * @param axolotls
	 * @param creature
	 * @param misc
	 * @param monster
	 * @param undergroundWaterCreature
	 * @param waterAmbient
	 * @param waterCreature
	 * @param custom
	 */
	public record TLReGenSpawners(List<MobSpawnSettings.SpawnerData> ambient, List<MobSpawnSettings.SpawnerData> axolotls, List<MobSpawnSettings.SpawnerData> creature, List<MobSpawnSettings.SpawnerData> misc, List<MobSpawnSettings.SpawnerData> monster, List<MobSpawnSettings.SpawnerData> undergroundWaterCreature, List<MobSpawnSettings.SpawnerData> waterAmbient, List<MobSpawnSettings.SpawnerData> waterCreature, List<Pair<MobCategory, List<MobSpawnSettings.SpawnerData>>> custom) {
	}
}
