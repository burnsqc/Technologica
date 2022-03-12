package com.technologica.data.worldgen.placement;

import com.technologica.data.worldgen.features.TechnologicaTreeFeatures;
import com.technologica.world.level.block.TechnologicaBlocks;

import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;

public class TechnologicaTreePlacements {
	public static final PlacedFeature ZEBRAWOOD_CHECKED = PlacementUtils.register("zebrawood_checked", TechnologicaTreeFeatures.ZEBRAWOOD.filteredByBlockSurvival(TechnologicaBlocks.ZEBRAWOOD_SAPLING.get()));
}
