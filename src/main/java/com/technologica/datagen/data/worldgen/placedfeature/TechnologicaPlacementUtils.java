package com.technologica.datagen.data.worldgen.placedfeature;

import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;

public class TechnologicaPlacementUtils {
	public static void bootstrap(BootstapContext<PlacedFeature> context) {
		TechnologicaMiscOverworldPlacements.bootstrap(context);
		TechnologicaOrePlacements.bootstrap(context);
		TechnologicaTreePlacements.bootstrap(context);
		TechnologicaVegetationPlacements.bootstrap(context);
	}
}