package com.technologica.data.worldgen.placement;

import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;

public class TechnologicaPlacementUtils {
	public static void bootstrap(BootstapContext<PlacedFeature> p_255779_) {
		TechnologicaMiscOverworldPlacements.bootstrap(p_255779_);
		TechnologicaOrePlacements.bootstrap(p_255779_);
		TechnologicaTreePlacements.bootstrap(p_255779_);
		TechnologicaVegetationPlacements.bootstrap(p_255779_);
	}
}