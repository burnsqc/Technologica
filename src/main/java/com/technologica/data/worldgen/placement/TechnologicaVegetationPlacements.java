package com.technologica.data.worldgen.placement;

import com.technologica.data.worldgen.features.TechnologicaVegetationFeatures;

import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.data.worldgen.placement.VegetationPlacements;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;

public class TechnologicaVegetationPlacements {
	public static final PlacedFeature TREES_MODIFIED_SAVANNA = PlacementUtils.register("trees_zebrawood", TechnologicaVegetationFeatures.TREES_MODIFIED_SAVANNA.placed(VegetationPlacements.treePlacement(PlacementUtils.countExtra(50, 0.1F, 1))));
	public static final PlacedFeature TREES_MODIFIED_JUNGLE = PlacementUtils.register("trees_modified_jungle", TechnologicaVegetationFeatures.TREES_MODIFIED_JUNGLE.placed(VegetationPlacements.treePlacement(PlacementUtils.countExtra(50, 0.1F, 1))));
	public static final PlacedFeature TREES_MODIFIED_JUNGLE_EDGE = PlacementUtils.register("trees_teak", TechnologicaVegetationFeatures.TREES_MODIFIED_JUNGLE_EDGE.placed(VegetationPlacements.treePlacement(PlacementUtils.countExtra(50, 0.1F, 1))));
	public static final PlacedFeature TREES_MODIFIED_BAMBOO_JUNGLE = PlacementUtils.register("trees_bamboo_jungle", TechnologicaVegetationFeatures.TREES_MODIFIED_BAMBOO_JUNGLE.placed(VegetationPlacements.treePlacement(PlacementUtils.countExtra(25, 0.1F, 1))));
	public static final PlacedFeature TREES_MODIFIED_FOREST = PlacementUtils.register("trees_chestnut", TechnologicaVegetationFeatures.TREES_MODIFIED_FOREST.placed(VegetationPlacements.treePlacement(PlacementUtils.countExtra(50, 0.1F, 1))));
	public static final PlacedFeature TREES_MODIFIED_BIRCH_FOREST = PlacementUtils.register("trees_peach", TechnologicaVegetationFeatures.TREES_MODIFIED_BIRCH_FOREST.placed(VegetationPlacements.treePlacement(PlacementUtils.countExtra(50, 0.1F, 1))));
	public static final PlacedFeature TREES_MODIFIED_WOODED_HILLS = PlacementUtils.register("trees_aspen", TechnologicaVegetationFeatures.TREES_MODIFIED_WOODED_HILLS.placed(VegetationPlacements.treePlacement(PlacementUtils.countExtra(50, 0.1F, 1))));
	public static final PlacedFeature TREES_MODIFIED_BEACH = PlacementUtils.register("trees_coconut", TechnologicaVegetationFeatures.TREES_MODIFIED_BEACH.placed(VegetationPlacements.treePlacement(PlacementUtils.countExtra(100, 0.1F, 1))));
	public static final PlacedFeature TREES_MODIFIED_TAIGA = PlacementUtils.register("trees_modified_taiga", TechnologicaVegetationFeatures.TREES_MODIFIED_TAIGA.placed(VegetationPlacements.treePlacement(PlacementUtils.countExtra(50, 0.1F, 1))));
	public static final PlacedFeature TREES_MODIFIED_SNOWY_TAIGA = PlacementUtils.register("trees_snowy_taiga", TechnologicaVegetationFeatures.TREES_MODIFIED_SNOWY_TAIGA.placed(VegetationPlacements.treePlacement(PlacementUtils.countExtra(50, 0.1F, 1))));
	public static final PlacedFeature TREES_MODIFIED_SWAMP = PlacementUtils.register("trees_orange", TechnologicaVegetationFeatures.TREES_MODIFIED_SWAMP.placed(VegetationPlacements.treePlacement(PlacementUtils.countExtra(50, 0.1F, 1))));
}