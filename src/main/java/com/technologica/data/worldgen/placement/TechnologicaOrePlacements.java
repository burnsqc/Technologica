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
import net.minecraft.world.level.levelgen.placement.RarityFilter;

public class TechnologicaOrePlacements {
	public static Holder<PlacedFeature> ORE_SPODUMENE;
	public static Holder<PlacedFeature> ORE_BORAX;
	public static Holder<PlacedFeature> ORE_MAGNESITE;
	public static Holder<PlacedFeature> ORE_BAUXITE;
	public static Holder<PlacedFeature> ORE_APATITE;
	public static Holder<PlacedFeature> ORE_PHOSPHORITE;
	public static Holder<PlacedFeature> ORE_GADOLINITE;
	public static Holder<PlacedFeature> ORE_ILMENITE;
	public static Holder<PlacedFeature> ORE_PATRONITE;
	public static Holder<PlacedFeature> ORE_CHROMITE;
	public static Holder<PlacedFeature> ORE_PYROLUSITE;
	public static Holder<PlacedFeature> ORE_COBALTITE;
	public static Holder<PlacedFeature> ORE_GARNIERITE;
	public static Holder<PlacedFeature> ORE_ARSENOPYRITE;
	public static Holder<PlacedFeature> ORE_CROOKESITE;
	public static Holder<PlacedFeature> ORE_LEPIDOLITE;
	public static Holder<PlacedFeature> ORE_BASTNAESITE;
	public static Holder<PlacedFeature> ORE_TANTALITE;
	public static Holder<PlacedFeature> ORE_MOLYBDENITE;
	public static Holder<PlacedFeature> ORE_PENTLANDITE;
	public static Holder<PlacedFeature> ORE_ARGENTITE;
	public static Holder<PlacedFeature> ORE_GALENA;
	public static Holder<PlacedFeature> ORE_SYLVANITE;
	public static Holder<PlacedFeature> ORE_CASSITERITE;
	public static Holder<PlacedFeature> ORE_WOLFRAMITE;
	public static Holder<PlacedFeature> ORE_OSMIRIDIUM;
	public static Holder<PlacedFeature> ORE_PLATINUM;
	public static Holder<PlacedFeature> ORE_CINNABAR;
	public static Holder<PlacedFeature> ORE_THORIANITE;
	public static Holder<PlacedFeature> ORE_URANINITE;
	public static Holder<PlacedFeature> ORE_EMERALD;
	public static Holder<PlacedFeature> ORE_RUBY;
	public static Holder<PlacedFeature> ORE_SAPPHIRE;
	public static Holder<PlacedFeature> ORE_TOPAZ;
	
	public static void register() {
		ORE_SPODUMENE = PlacementUtils.register("ore_spodumene", TechnologicaOreFeatures.ORE_SPODUMENE, commonOrePlacement(10, HeightRangePlacement.uniform(VerticalAnchor.absolute(48), VerticalAnchor.top())));
		ORE_BORAX = PlacementUtils.register("ore_borax", TechnologicaOreFeatures.ORE_BORAX, commonOrePlacement(10, HeightRangePlacement.uniform(VerticalAnchor.absolute(48), VerticalAnchor.absolute(64))));
		ORE_MAGNESITE = PlacementUtils.register("ore_magnesite", TechnologicaOreFeatures.ORE_MAGNESITE, commonOrePlacement(10, HeightRangePlacement.uniform(VerticalAnchor.absolute(0), VerticalAnchor.top())));
		ORE_BAUXITE = PlacementUtils.register("ore_bauxite", TechnologicaOreFeatures.ORE_BAUXITE, commonOrePlacement(10, HeightRangePlacement.triangle(VerticalAnchor.absolute(-24), VerticalAnchor.absolute(56))));
		ORE_APATITE = PlacementUtils.register("ore_apatite", TechnologicaOreFeatures.ORE_APATITE, commonOrePlacement(10, HeightRangePlacement.uniform(VerticalAnchor.absolute(48), VerticalAnchor.absolute(64))));
		ORE_PHOSPHORITE = PlacementUtils.register("ore_phosphorite", TechnologicaOreFeatures.ORE_PHOSPHORITE, commonOrePlacement(10, HeightRangePlacement.uniform(VerticalAnchor.absolute(32), VerticalAnchor.absolute(48))));
		ORE_GADOLINITE = PlacementUtils.register("ore_gadolinite", TechnologicaOreFeatures.ORE_GADOLINITE, commonOrePlacement(10, HeightRangePlacement.triangle(VerticalAnchor.absolute(-24), VerticalAnchor.absolute(56))));
		ORE_ILMENITE = PlacementUtils.register("ore_ilmenite", TechnologicaOreFeatures.ORE_ILMENITE, commonOrePlacement(10, HeightRangePlacement.uniform(VerticalAnchor.bottom(), VerticalAnchor.top())));
		ORE_PATRONITE = PlacementUtils.register("ore_patronite", TechnologicaOreFeatures.ORE_PATRONITE, commonOrePlacement(10, HeightRangePlacement.triangle(VerticalAnchor.absolute(-24), VerticalAnchor.absolute(56))));
		ORE_CHROMITE = PlacementUtils.register("ore_chromite", TechnologicaOreFeatures.ORE_CHROMITE, commonOrePlacement(10, HeightRangePlacement.triangle(VerticalAnchor.absolute(-24), VerticalAnchor.absolute(56))));
		ORE_PYROLUSITE = PlacementUtils.register("ore_pyrolusite", TechnologicaOreFeatures.ORE_PYROLUSITE, commonOrePlacement(10, HeightRangePlacement.triangle(VerticalAnchor.absolute(-24), VerticalAnchor.absolute(56))));
		ORE_COBALTITE = PlacementUtils.register("ore_cobaltite", TechnologicaOreFeatures.ORE_COBALTITE, commonOrePlacement(10, HeightRangePlacement.triangle(VerticalAnchor.absolute(-24), VerticalAnchor.absolute(56))));
		ORE_GARNIERITE = PlacementUtils.register("ore_garnierite", TechnologicaOreFeatures.ORE_GARNIERITE, commonOrePlacement(10, HeightRangePlacement.triangle(VerticalAnchor.absolute(-24), VerticalAnchor.absolute(56))));
		ORE_ARSENOPYRITE = PlacementUtils.register("ore_arsenopyrite", TechnologicaOreFeatures.ORE_ARSENOPYRITE, commonOrePlacement(10, HeightRangePlacement.uniform(VerticalAnchor.absolute(0), VerticalAnchor.top())));
		ORE_CROOKESITE = PlacementUtils.register("ore_crookesite", TechnologicaOreFeatures.ORE_CROOKESITE, commonOrePlacement(10, HeightRangePlacement.uniform(VerticalAnchor.absolute(0), VerticalAnchor.top())));
		ORE_LEPIDOLITE = PlacementUtils.register("ore_lepidolite", TechnologicaOreFeatures.ORE_LEPIDOLITE, commonOrePlacement(10, HeightRangePlacement.uniform(VerticalAnchor.absolute(0), VerticalAnchor.top())));
		ORE_BASTNAESITE = PlacementUtils.register("ore_bastnaesite", TechnologicaOreFeatures.ORE_BASTNAESITE, commonOrePlacement(10, HeightRangePlacement.triangle(VerticalAnchor.absolute(-24), VerticalAnchor.absolute(56))));
		ORE_TANTALITE = PlacementUtils.register("ore_tantalite", TechnologicaOreFeatures.ORE_TANTALITE, commonOrePlacement(16, HeightRangePlacement.triangle(VerticalAnchor.absolute(-16), VerticalAnchor.absolute(112))));
		ORE_MOLYBDENITE = PlacementUtils.register("ore_molybdenite", TechnologicaOreFeatures.ORE_MOLYBDENITE, commonOrePlacement(16, HeightRangePlacement.triangle(VerticalAnchor.absolute(-16), VerticalAnchor.absolute(112))));
		ORE_PENTLANDITE = PlacementUtils.register("ore_pentlandite", TechnologicaOreFeatures.ORE_PENTLANDITE, commonOrePlacement(10, HeightRangePlacement.triangle(VerticalAnchor.absolute(-24), VerticalAnchor.absolute(56))));
		ORE_ARGENTITE = PlacementUtils.register("ore_argentite", TechnologicaOreFeatures.ORE_ARGENTITE, commonOrePlacement(10, HeightRangePlacement.uniform(VerticalAnchor.absolute(-64), VerticalAnchor.absolute(32))));
		ORE_GALENA = PlacementUtils.register("ore_galena", TechnologicaOreFeatures.ORE_GALENA, commonOrePlacement(16, HeightRangePlacement.triangle(VerticalAnchor.absolute(-16), VerticalAnchor.absolute(112))));
		ORE_SYLVANITE = PlacementUtils.register("ore_sylvanite", TechnologicaOreFeatures.ORE_SYLVANITE, commonOrePlacement(10, HeightRangePlacement.uniform(VerticalAnchor.absolute(-64), VerticalAnchor.absolute(32))));
		ORE_CASSITERITE = PlacementUtils.register("ore_cassiterite", TechnologicaOreFeatures.ORE_CASSITERITE, commonOrePlacement(10, HeightRangePlacement.uniform(VerticalAnchor.absolute(0), VerticalAnchor.top())));
		ORE_WOLFRAMITE = PlacementUtils.register("ore_wolframite", TechnologicaOreFeatures.ORE_WOLFRAMITE, commonOrePlacement(16, HeightRangePlacement.triangle(VerticalAnchor.absolute(-16), VerticalAnchor.absolute(112))));
		ORE_OSMIRIDIUM = PlacementUtils.register("ore_osmiridium", TechnologicaOreFeatures.ORE_OSMIRIDIUM, commonOrePlacement(10, HeightRangePlacement.uniform(VerticalAnchor.absolute(-64), VerticalAnchor.absolute(32))));
		ORE_PLATINUM = PlacementUtils.register("ore_platinum", TechnologicaOreFeatures.ORE_PLATINUM, commonOrePlacement(4, HeightRangePlacement.triangle(VerticalAnchor.absolute(-64), VerticalAnchor.absolute(32))));
		ORE_CINNABAR = PlacementUtils.register("ore_cinnabar", TechnologicaOreFeatures.ORE_CINNABAR, commonOrePlacement(4, HeightRangePlacement.uniform(VerticalAnchor.bottom(), VerticalAnchor.absolute(15))));
		ORE_THORIANITE = PlacementUtils.register("ore_thorianite", TechnologicaOreFeatures.ORE_THORIANITE, commonOrePlacement(4, HeightRangePlacement.uniform(VerticalAnchor.bottom(), VerticalAnchor.absolute(15))));
		ORE_URANINITE = PlacementUtils.register("ore_uraninite", TechnologicaOreFeatures.ORE_URANINITE, commonOrePlacement(4, HeightRangePlacement.uniform(VerticalAnchor.bottom(), VerticalAnchor.absolute(15))));
		ORE_EMERALD = PlacementUtils.register("ore_emerald", TechnologicaOreFeatures.ORE_EMERALD, commonOrePlacement(100, HeightRangePlacement.triangle(VerticalAnchor.absolute(-16), VerticalAnchor.absolute(480))));
		ORE_RUBY = PlacementUtils.register("ore_ruby", TechnologicaOreFeatures.ORE_RUBY, commonOrePlacement(100, HeightRangePlacement.triangle(VerticalAnchor.absolute(-16), VerticalAnchor.absolute(480))));
		ORE_SAPPHIRE = PlacementUtils.register("ore_sapphire", TechnologicaOreFeatures.ORE_SAPPHIRE, commonOrePlacement(100, HeightRangePlacement.triangle(VerticalAnchor.absolute(-16), VerticalAnchor.absolute(480))));
		ORE_TOPAZ = PlacementUtils.register("ore_topaz", TechnologicaOreFeatures.ORE_TOPAZ, commonOrePlacement(100, HeightRangePlacement.triangle(VerticalAnchor.absolute(-16), VerticalAnchor.absolute(480))));
	}

	private static List<PlacementModifier> orePlacement(PlacementModifier p_195347_, PlacementModifier p_195348_) {
		return List.of(p_195347_, InSquarePlacement.spread(), p_195348_, BiomeFilter.biome());
	}

	private static List<PlacementModifier> commonOrePlacement(int p_195344_, PlacementModifier p_195345_) {
		return orePlacement(CountPlacement.of(p_195344_), p_195345_);
	}
	
	private static List<PlacementModifier> rareOrePlacement(int p_195350_, PlacementModifier p_195351_) {
		return orePlacement(RarityFilter.onAverageOnceEvery(p_195350_), p_195351_);
	}
}