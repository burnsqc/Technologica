package com.technologica.data.worldgen.placement;

import java.util.List;

import com.technologica.data.worldgen.features.TechnologicaOreFeatures;

import net.minecraft.core.Holder;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.placement.BiomeFilter;
import net.minecraft.world.level.levelgen.placement.CountPlacement;
import net.minecraft.world.level.levelgen.placement.HeightRangePlacement;
import net.minecraft.world.level.levelgen.placement.InSquarePlacement;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraft.world.level.levelgen.placement.PlacementModifier;

public class TechnologicaOrePlacements {
	public static Holder<PlacedFeature> ORE_SPODUMENE;

	public static void register() {
		ORE_SPODUMENE = PlacementUtils.register("ore_spodumene", TechnologicaOreFeatures.ORE_SPODUMENE, commonOrePlacement(30, HeightRangePlacement.uniform(VerticalAnchor.absolute(0), VerticalAnchor.top())));
	}

	private static List<PlacementModifier> orePlacement(PlacementModifier p_195347_, PlacementModifier p_195348_) {
		return List.of(p_195347_, InSquarePlacement.spread(), p_195348_, BiomeFilter.biome());
	}

	private static List<PlacementModifier> commonOrePlacement(int p_195344_, PlacementModifier p_195345_) {
		return orePlacement(CountPlacement.of(p_195344_), p_195345_);
	}
}
