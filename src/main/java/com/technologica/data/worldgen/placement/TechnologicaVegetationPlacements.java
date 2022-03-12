package com.technologica.data.worldgen.placement;

import com.technologica.data.worldgen.features.TechnologicaVegetationFeatures;

import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.data.worldgen.placement.VegetationPlacements;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;

public class TechnologicaVegetationPlacements {
	public static final PlacedFeature TREES_MODIFIED_SAVANNA = PlacementUtils.register("trees_zebrawood", TechnologicaVegetationFeatures.TREES__MODIFIED_SAVANNA.placed(VegetationPlacements.treePlacement(PlacementUtils.countExtra(0, 0.1F, 1))));
}