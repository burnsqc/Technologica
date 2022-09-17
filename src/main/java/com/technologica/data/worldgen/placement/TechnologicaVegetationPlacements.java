package com.technologica.data.worldgen.placement;

import com.technologica.data.worldgen.features.TechnologicaVegetationFeatures;

import net.minecraft.core.Holder;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.data.worldgen.placement.VegetationPlacements;
import net.minecraft.world.level.levelgen.placement.BiomeFilter;
import net.minecraft.world.level.levelgen.placement.InSquarePlacement;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraft.world.level.levelgen.placement.RarityFilter;

public class TechnologicaVegetationPlacements {
	public static Holder<PlacedFeature> TREES_MODIFIED_SAVANNA;
	public static Holder<PlacedFeature> TREES_MODIFIED_JUNGLE;
	public static Holder<PlacedFeature> TREES_MODIFIED_JUNGLE_EDGE;
	public static Holder<PlacedFeature> TREES_MODIFIED_BAMBOO_JUNGLE;
	public static Holder<PlacedFeature> TREES_MODIFIED_FOREST;
	public static Holder<PlacedFeature> TREES_MODIFIED_BIRCH_FOREST;
	public static Holder<PlacedFeature> TREES_MODIFIED_WOODED_HILLS;
	public static Holder<PlacedFeature> TREES_MODIFIED_BEACH;
	public static Holder<PlacedFeature> TREES_MODIFIED_TAIGA;
	public static Holder<PlacedFeature> TREES_MODIFIED_SNOWY_TAIGA;
	public static Holder<PlacedFeature> TREES_MODIFIED_SWAMP;
	public static Holder<PlacedFeature> PATCH_BLACKBERRY_COMMON;
	public static Holder<PlacedFeature> PATCH_BLACKBERRY_RARE;
	public static Holder<PlacedFeature> PATCH_BLUEBERRY_COMMON;
	public static Holder<PlacedFeature> PATCH_BLUEBERRY_RARE;
	public static Holder<PlacedFeature> PATCH_RASPBERRY_COMMON;
	public static Holder<PlacedFeature> PATCH_RASPBERRY_RARE;
	public static Holder<PlacedFeature> PATCH_STRAWBERRY_COMMON;
	public static Holder<PlacedFeature> PATCH_STRAWBERRY_RARE;

	public static void register() {
		TREES_MODIFIED_SAVANNA = PlacementUtils.register("trees_zebrawood", TechnologicaVegetationFeatures.TREES_MODIFIED_SAVANNA, VegetationPlacements.treePlacement(PlacementUtils.countExtra(1, 0.1F, 1)));
		TREES_MODIFIED_JUNGLE = PlacementUtils.register("trees_modified_jungle", TechnologicaVegetationFeatures.TREES_MODIFIED_JUNGLE, VegetationPlacements.treePlacement(PlacementUtils.countExtra(1, 0.1F, 1)));
		TREES_MODIFIED_JUNGLE_EDGE = PlacementUtils.register("trees_teak", TechnologicaVegetationFeatures.TREES_MODIFIED_JUNGLE_EDGE, VegetationPlacements.treePlacement(PlacementUtils.countExtra(1, 0.1F, 1)));
		TREES_MODIFIED_BAMBOO_JUNGLE = PlacementUtils.register("trees_bamboo_jungle", TechnologicaVegetationFeatures.TREES_MODIFIED_BAMBOO_JUNGLE, VegetationPlacements.treePlacement(PlacementUtils.countExtra(1, 0.1F, 1)));
		TREES_MODIFIED_FOREST = PlacementUtils.register("trees_chestnut", TechnologicaVegetationFeatures.TREES_MODIFIED_FOREST, VegetationPlacements.treePlacement(PlacementUtils.countExtra(1, 0.1F, 1)));
		TREES_MODIFIED_BIRCH_FOREST = PlacementUtils.register("trees_peach", TechnologicaVegetationFeatures.TREES_MODIFIED_BIRCH_FOREST, VegetationPlacements.treePlacement(PlacementUtils.countExtra(1, 0.1F, 1)));
		TREES_MODIFIED_WOODED_HILLS = PlacementUtils.register("trees_aspen", TechnologicaVegetationFeatures.TREES_MODIFIED_WOODED_HILLS, VegetationPlacements.treePlacement(PlacementUtils.countExtra(1, 0.1F, 1)));
		TREES_MODIFIED_BEACH = PlacementUtils.register("trees_coconut", TechnologicaVegetationFeatures.TREES_MODIFIED_BEACH, VegetationPlacements.treePlacement(PlacementUtils.countExtra(1, 0.1F, 1)));
		TREES_MODIFIED_TAIGA = PlacementUtils.register("trees_modified_taiga", TechnologicaVegetationFeatures.TREES_MODIFIED_TAIGA, VegetationPlacements.treePlacement(PlacementUtils.countExtra(1, 0.1F, 1)));
		TREES_MODIFIED_SNOWY_TAIGA = PlacementUtils.register("trees_snowy_taiga", TechnologicaVegetationFeatures.TREES_MODIFIED_SNOWY_TAIGA, VegetationPlacements.treePlacement(PlacementUtils.countExtra(1, 0.1F, 1)));
		TREES_MODIFIED_SWAMP = PlacementUtils.register("trees_orange", TechnologicaVegetationFeatures.TREES_MODIFIED_SWAMP, VegetationPlacements.treePlacement(PlacementUtils.countExtra(1, 0.1F, 1)));
		PATCH_BLACKBERRY_COMMON = PlacementUtils.register("patch_blackberry_common", TechnologicaVegetationFeatures.PATCH_BLACKBERRY_BUSH, RarityFilter.onAverageOnceEvery(32), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP_WORLD_SURFACE, BiomeFilter.biome());
		PATCH_BLACKBERRY_RARE = PlacementUtils.register("patch_blackberry_rare", TechnologicaVegetationFeatures.PATCH_BLACKBERRY_BUSH, RarityFilter.onAverageOnceEvery(384), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP_WORLD_SURFACE, BiomeFilter.biome());
		PATCH_BLUEBERRY_COMMON = PlacementUtils.register("patch_blueberry_common", TechnologicaVegetationFeatures.PATCH_BLUEBERRY_BUSH, RarityFilter.onAverageOnceEvery(32), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP_WORLD_SURFACE, BiomeFilter.biome());
		PATCH_BLUEBERRY_RARE = PlacementUtils.register("patch_blueberry_rare", TechnologicaVegetationFeatures.PATCH_BLUEBERRY_BUSH, RarityFilter.onAverageOnceEvery(384), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP_WORLD_SURFACE, BiomeFilter.biome());
		PATCH_RASPBERRY_COMMON = PlacementUtils.register("patch_raspberry_common", TechnologicaVegetationFeatures.PATCH_RASPBERRY_BUSH, RarityFilter.onAverageOnceEvery(32), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP_WORLD_SURFACE, BiomeFilter.biome());
		PATCH_RASPBERRY_RARE = PlacementUtils.register("patch_raspberry_rare", TechnologicaVegetationFeatures.PATCH_RASPBERRY_BUSH, RarityFilter.onAverageOnceEvery(384), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP_WORLD_SURFACE, BiomeFilter.biome());
		PATCH_STRAWBERRY_COMMON = PlacementUtils.register("patch_strawberry_common", TechnologicaVegetationFeatures.PATCH_STRAWBERRY_BUSH, RarityFilter.onAverageOnceEvery(32), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP_WORLD_SURFACE, BiomeFilter.biome());
		PATCH_STRAWBERRY_RARE = PlacementUtils.register("patch_strawberry_rare", TechnologicaVegetationFeatures.PATCH_STRAWBERRY_BUSH, RarityFilter.onAverageOnceEvery(384), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP_WORLD_SURFACE, BiomeFilter.biome());
	}
}