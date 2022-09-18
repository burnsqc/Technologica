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
	public static Holder<PlacedFeature> ORE_BORAX;
	public static Holder<PlacedFeature> ORE_MAGNESITE;
	public static Holder<PlacedFeature> ORE_BAUXITE;
	public static Holder<PlacedFeature> ORE_APATITE;
	public static Holder<PlacedFeature> ORE_PHOSPHORITE;
	public static Holder<PlacedFeature> ORE_GADOLINITE;
	public static Holder<PlacedFeature> ORE_ILMENITE;
	public static Holder<PlacedFeature> ORE_CHROMITE;
	public static Holder<PlacedFeature> ORE_PYROLUSITE;
	public static Holder<PlacedFeature> ORE_COBALTITE;
	public static Holder<PlacedFeature> ORE_GARNIERITE;
	public static Holder<PlacedFeature> ORE_PATRONITE;

	public static void register() {
		ORE_SPODUMENE = PlacementUtils.register("ore_spodumene", TechnologicaOreFeatures.ORE_SPODUMENE, commonOrePlacement(30, HeightRangePlacement.uniform(VerticalAnchor.absolute(0), VerticalAnchor.top())));
		ORE_BORAX = PlacementUtils.register("ore_borax", TechnologicaOreFeatures.ORE_BORAX, commonOrePlacement(30, HeightRangePlacement.uniform(VerticalAnchor.absolute(0), VerticalAnchor.top())));
		ORE_MAGNESITE = PlacementUtils.register("ore_magnesite", TechnologicaOreFeatures.ORE_MAGNESITE, commonOrePlacement(30, HeightRangePlacement.uniform(VerticalAnchor.absolute(0), VerticalAnchor.top())));
		ORE_BAUXITE = PlacementUtils.register("ore_bauxite", TechnologicaOreFeatures.ORE_BAUXITE, commonOrePlacement(30, HeightRangePlacement.uniform(VerticalAnchor.absolute(0), VerticalAnchor.top())));
		ORE_APATITE = PlacementUtils.register("ore_apatite", TechnologicaOreFeatures.ORE_APATITE, commonOrePlacement(30, HeightRangePlacement.uniform(VerticalAnchor.absolute(0), VerticalAnchor.top())));
		ORE_PHOSPHORITE = PlacementUtils.register("ore_phosphorite", TechnologicaOreFeatures.ORE_PHOSPHORITE, commonOrePlacement(30, HeightRangePlacement.uniform(VerticalAnchor.absolute(0), VerticalAnchor.top())));
		ORE_GADOLINITE = PlacementUtils.register("ore_gadolinite", TechnologicaOreFeatures.ORE_GADOLINITE, commonOrePlacement(30, HeightRangePlacement.uniform(VerticalAnchor.absolute(0), VerticalAnchor.top())));
		ORE_ILMENITE = PlacementUtils.register("ore_ilmenite", TechnologicaOreFeatures.ORE_ILMENITE, commonOrePlacement(30, HeightRangePlacement.uniform(VerticalAnchor.absolute(0), VerticalAnchor.top())));
		ORE_CHROMITE = PlacementUtils.register("ore_chromite", TechnologicaOreFeatures.ORE_CHROMITE, commonOrePlacement(30, HeightRangePlacement.uniform(VerticalAnchor.absolute(0), VerticalAnchor.top())));
		ORE_PYROLUSITE = PlacementUtils.register("ore_pyrolusite", TechnologicaOreFeatures.ORE_PYROLUSITE, commonOrePlacement(30, HeightRangePlacement.uniform(VerticalAnchor.absolute(0), VerticalAnchor.top())));
		ORE_COBALTITE = PlacementUtils.register("ore_cobaltite", TechnologicaOreFeatures.ORE_COBALTITE, commonOrePlacement(30, HeightRangePlacement.uniform(VerticalAnchor.absolute(0), VerticalAnchor.top())));
		ORE_GARNIERITE = PlacementUtils.register("ore_garnierite", TechnologicaOreFeatures.ORE_GARNIERITE, commonOrePlacement(30, HeightRangePlacement.uniform(VerticalAnchor.absolute(0), VerticalAnchor.top())));
		ORE_PATRONITE = PlacementUtils.register("ore_patronite", TechnologicaOreFeatures.ORE_PATRONITE, commonOrePlacement(30, HeightRangePlacement.uniform(VerticalAnchor.absolute(0), VerticalAnchor.top())));
	}

	private static List<PlacementModifier> orePlacement(PlacementModifier p_195347_, PlacementModifier p_195348_) {
		return List.of(p_195347_, InSquarePlacement.spread(), p_195348_, BiomeFilter.biome());
	}

	private static List<PlacementModifier> commonOrePlacement(int p_195344_, PlacementModifier p_195345_) {
		return orePlacement(CountPlacement.of(p_195344_), p_195345_);
	}
}
