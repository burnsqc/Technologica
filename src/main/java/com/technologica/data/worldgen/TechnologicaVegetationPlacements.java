package com.technologica.data.worldgen;

import com.technologica.data.worldgen.features.TechnologicaTreeFeatures;

import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.data.worldgen.placement.VegetationPlacements;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;

public class TechnologicaVegetationPlacements {
	public static final PlacedFeature TREES_ZEBRAWOOD = PlacementUtils.register("trees_zebrawood", TechnologicaTreeFeatures.ZEBRAWOOD.placed(VegetationPlacements.treePlacement(PlacementUtils.countExtra(10, 0.1F, 1))));
}