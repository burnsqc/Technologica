package com.technologica.data.worldgen.placement;

import com.technologica.data.worldgen.features.TechnologicaVegetationFeatures;

import net.minecraft.core.Holder;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;

public class TechnologicaVillagePlacements {
	public static Holder<PlacedFeature> PATCH_BLACKBERRY_BUSH_VILLAGE;
	public static Holder<PlacedFeature> PATCH_BLUEBERRY_BUSH_VILLAGE;
	public static Holder<PlacedFeature> PATCH_RASPBERRY_BUSH_VILLAGE;
	public static Holder<PlacedFeature> PATCH_STRAWBERRY_BUSH_VILLAGE;

	public static void register() {
		PATCH_BLACKBERRY_BUSH_VILLAGE = PlacementUtils.register("patch_blackberry_bush", TechnologicaVegetationFeatures.PATCH_BLACKBERRY_BUSH);
		PATCH_BLUEBERRY_BUSH_VILLAGE = PlacementUtils.register("patch_blueberry_bush", TechnologicaVegetationFeatures.PATCH_BLUEBERRY_BUSH);
		PATCH_RASPBERRY_BUSH_VILLAGE = PlacementUtils.register("patch_raspberry_bush", TechnologicaVegetationFeatures.PATCH_RASPBERRY_BUSH);
		PATCH_STRAWBERRY_BUSH_VILLAGE = PlacementUtils.register("patch_strawberry_bush", TechnologicaVegetationFeatures.PATCH_STRAWBERRY_BUSH);
	}
}