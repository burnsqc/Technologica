package com.technologica.data.worldgen.placement;

import com.technologica.data.worldgen.features.TechnologicaMiscOverworldFeatures;

import net.minecraft.core.Holder;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.placement.BiomeFilter;
import net.minecraft.world.level.levelgen.placement.HeightRangePlacement;
import net.minecraft.world.level.levelgen.placement.InSquarePlacement;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraft.world.level.levelgen.placement.RarityFilter;

public class TechnologicaMiscOverworldPlacements {
	public static Holder<PlacedFeature> BRINE_POOL;
	public static Holder<PlacedFeature> OASIS;

	public static void register() {
		BRINE_POOL = PlacementUtils.register("brine_pool", TechnologicaMiscOverworldFeatures.BRINE_POOL, RarityFilter.onAverageOnceEvery(2), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP_WORLD_SURFACE, BiomeFilter.biome());
		OASIS = PlacementUtils.register("oasis", TechnologicaMiscOverworldFeatures.OASIS, RarityFilter.onAverageOnceEvery(200), InSquarePlacement.spread(), HeightRangePlacement.uniform(VerticalAnchor.bottom(), VerticalAnchor.absolute(192)), BiomeFilter.biome());
	}
}