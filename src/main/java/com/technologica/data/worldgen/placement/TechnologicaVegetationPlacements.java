package com.technologica.data.worldgen.placement;

import com.technologica.data.worldgen.features.TechnologicaVegetationFeatures;

import net.minecraft.core.Holder;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.data.worldgen.placement.VegetationPlacements;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;

public class TechnologicaVegetationPlacements {
	public static final Holder<PlacedFeature> TREES_MODIFIED_SAVANNA = PlacementUtils.register("trees_zebrawood", TechnologicaVegetationFeatures.TREES_MODIFIED_SAVANNA, VegetationPlacements.treePlacement(PlacementUtils.countExtra(1, 0.1F, 1)));
	public static final Holder<PlacedFeature> TREES_MODIFIED_JUNGLE = PlacementUtils.register("trees_modified_jungle", TechnologicaVegetationFeatures.TREES_MODIFIED_JUNGLE, VegetationPlacements.treePlacement(PlacementUtils.countExtra(1, 0.1F, 1)));
	public static final Holder<PlacedFeature> TREES_MODIFIED_JUNGLE_EDGE = PlacementUtils.register("trees_teak", TechnologicaVegetationFeatures.TREES_MODIFIED_JUNGLE_EDGE, VegetationPlacements.treePlacement(PlacementUtils.countExtra(1, 0.1F, 1)));
	public static final Holder<PlacedFeature> TREES_MODIFIED_BAMBOO_JUNGLE = PlacementUtils.register("trees_bamboo_jungle", TechnologicaVegetationFeatures.TREES_MODIFIED_BAMBOO_JUNGLE, VegetationPlacements.treePlacement(PlacementUtils.countExtra(1, 0.1F, 1)));
	public static final Holder<PlacedFeature> TREES_MODIFIED_FOREST = PlacementUtils.register("trees_chestnut", TechnologicaVegetationFeatures.TREES_MODIFIED_FOREST, VegetationPlacements.treePlacement(PlacementUtils.countExtra(1, 0.1F, 1)));
	public static final Holder<PlacedFeature> TREES_MODIFIED_BIRCH_FOREST = PlacementUtils.register("trees_peach", TechnologicaVegetationFeatures.TREES_MODIFIED_BIRCH_FOREST, VegetationPlacements.treePlacement(PlacementUtils.countExtra(1, 0.1F, 1)));
	public static final Holder<PlacedFeature> TREES_MODIFIED_WOODED_HILLS = PlacementUtils.register("trees_aspen", TechnologicaVegetationFeatures.TREES_MODIFIED_WOODED_HILLS, VegetationPlacements.treePlacement(PlacementUtils.countExtra(1, 0.1F, 1)));
	public static final Holder<PlacedFeature> TREES_MODIFIED_BEACH = PlacementUtils.register("trees_coconut", TechnologicaVegetationFeatures.TREES_MODIFIED_BEACH, VegetationPlacements.treePlacement(PlacementUtils.countExtra(1, 0.1F, 1)));
	public static final Holder<PlacedFeature> TREES_MODIFIED_TAIGA = PlacementUtils.register("trees_modified_taiga", TechnologicaVegetationFeatures.TREES_MODIFIED_TAIGA, VegetationPlacements.treePlacement(PlacementUtils.countExtra(1, 0.1F, 1)));
	public static final Holder<PlacedFeature> TREES_MODIFIED_SNOWY_TAIGA = PlacementUtils.register("trees_snowy_taiga", TechnologicaVegetationFeatures.TREES_MODIFIED_SNOWY_TAIGA, VegetationPlacements.treePlacement(PlacementUtils.countExtra(1, 0.1F, 1)));
	public static final Holder<PlacedFeature> TREES_MODIFIED_SWAMP = PlacementUtils.register("trees_orange", TechnologicaVegetationFeatures.TREES_MODIFIED_SWAMP, VegetationPlacements.treePlacement(PlacementUtils.countExtra(1, 0.1F, 1)));
}