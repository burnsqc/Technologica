package com.technologica.data.worldgen.placement;

import java.util.List;

import com.technologica.Technologica;
import com.technologica.data.worldgen.features.TechnologicaOreFeatures;

import net.minecraft.core.Holder;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.placement.BiomeFilter;
import net.minecraft.world.level.levelgen.placement.CountPlacement;
import net.minecraft.world.level.levelgen.placement.HeightRangePlacement;
import net.minecraft.world.level.levelgen.placement.InSquarePlacement;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraft.world.level.levelgen.placement.PlacementModifier;

public class TechnologicaOrePlacements {
	public static final ResourceKey<PlacedFeature> ORE_SPODUMENE_PLACED = ResourceKey.create(Registries.PLACED_FEATURE, new ResourceLocation(Technologica.MODID, "ore_spodumene"));
	public static final ResourceKey<PlacedFeature> ORE_BORAX_PLACED = ResourceKey.create(Registries.PLACED_FEATURE, new ResourceLocation(Technologica.MODID, "ore_borax"));
	public static final ResourceKey<PlacedFeature> ORE_MAGNESITE_PLACED = ResourceKey.create(Registries.PLACED_FEATURE, new ResourceLocation(Technologica.MODID, "ore_magnesite"));
	public static final ResourceKey<PlacedFeature> ORE_BAUXITE_PLACED = ResourceKey.create(Registries.PLACED_FEATURE, new ResourceLocation(Technologica.MODID, "ore_bauxite"));
	public static final ResourceKey<PlacedFeature> ORE_APATITE_PLACED = ResourceKey.create(Registries.PLACED_FEATURE, new ResourceLocation(Technologica.MODID, "ore_apatite"));
	public static final ResourceKey<PlacedFeature> ORE_PHOSPHORITE_PLACED = ResourceKey.create(Registries.PLACED_FEATURE, new ResourceLocation(Technologica.MODID, "ore_phosphorite"));
	public static final ResourceKey<PlacedFeature> ORE_GADOLINITE_PLACED = ResourceKey.create(Registries.PLACED_FEATURE, new ResourceLocation(Technologica.MODID, "ore_gadolinite"));
	public static final ResourceKey<PlacedFeature> ORE_ILMENITE_PLACED = ResourceKey.create(Registries.PLACED_FEATURE, new ResourceLocation(Technologica.MODID, "ore_ilmenite"));
	public static final ResourceKey<PlacedFeature> ORE_PATRONITE_PLACED = ResourceKey.create(Registries.PLACED_FEATURE, new ResourceLocation(Technologica.MODID, "ore_patronite"));
	public static final ResourceKey<PlacedFeature> ORE_CHROMITE_PLACED = ResourceKey.create(Registries.PLACED_FEATURE, new ResourceLocation(Technologica.MODID, "ore_chromite"));
	public static final ResourceKey<PlacedFeature> ORE_PYROLUSITE_PLACED = ResourceKey.create(Registries.PLACED_FEATURE, new ResourceLocation(Technologica.MODID, "ore_pyrolusite"));
	public static final ResourceKey<PlacedFeature> ORE_COBALTITE_PLACED = ResourceKey.create(Registries.PLACED_FEATURE, new ResourceLocation(Technologica.MODID, "ore_cobaltite"));
	public static final ResourceKey<PlacedFeature> ORE_GARNIERITE_PLACED = ResourceKey.create(Registries.PLACED_FEATURE, new ResourceLocation(Technologica.MODID, "ore_garnierite"));
	public static final ResourceKey<PlacedFeature> ORE_ARSENOPYRITE_PLACED = ResourceKey.create(Registries.PLACED_FEATURE, new ResourceLocation(Technologica.MODID, "ore_arsenopyrite"));
	public static final ResourceKey<PlacedFeature> ORE_CROOKESITE_PLACED = ResourceKey.create(Registries.PLACED_FEATURE, new ResourceLocation(Technologica.MODID, "ore_crookesite"));
	public static final ResourceKey<PlacedFeature> ORE_LEPIDOLITE_PLACED = ResourceKey.create(Registries.PLACED_FEATURE, new ResourceLocation(Technologica.MODID, "ore_lepidolite"));
	public static final ResourceKey<PlacedFeature> ORE_BASTNAESITE_PLACED = ResourceKey.create(Registries.PLACED_FEATURE, new ResourceLocation(Technologica.MODID, "ore_bastnaesite"));
	public static final ResourceKey<PlacedFeature> ORE_TANTALITE_PLACED = ResourceKey.create(Registries.PLACED_FEATURE, new ResourceLocation(Technologica.MODID, "ore_tantalite"));
	public static final ResourceKey<PlacedFeature> ORE_MOLYBDENITE_PLACED = ResourceKey.create(Registries.PLACED_FEATURE, new ResourceLocation(Technologica.MODID, "ore_molybdenite"));
	public static final ResourceKey<PlacedFeature> ORE_PENTLANDITE_PLACED = ResourceKey.create(Registries.PLACED_FEATURE, new ResourceLocation(Technologica.MODID, "ore_pentlandite"));
	public static final ResourceKey<PlacedFeature> ORE_ARGENTITE_PLACED = ResourceKey.create(Registries.PLACED_FEATURE, new ResourceLocation(Technologica.MODID, "ore_argentite"));
	public static final ResourceKey<PlacedFeature> ORE_GALENA_PLACED = ResourceKey.create(Registries.PLACED_FEATURE, new ResourceLocation(Technologica.MODID, "ore_galena"));
	public static final ResourceKey<PlacedFeature> ORE_SYLVANITE_PLACED = ResourceKey.create(Registries.PLACED_FEATURE, new ResourceLocation(Technologica.MODID, "ore_sylvanite"));
	public static final ResourceKey<PlacedFeature> ORE_CASSITERITE_PLACED = ResourceKey.create(Registries.PLACED_FEATURE, new ResourceLocation(Technologica.MODID, "ore_cassiterite"));
	public static final ResourceKey<PlacedFeature> ORE_WOLFRAMITE_PLACED = ResourceKey.create(Registries.PLACED_FEATURE, new ResourceLocation(Technologica.MODID, "ore_wolframite"));
	public static final ResourceKey<PlacedFeature> ORE_OSMIRIDIUM_PLACED = ResourceKey.create(Registries.PLACED_FEATURE, new ResourceLocation(Technologica.MODID, "ore_osmiridium"));
	public static final ResourceKey<PlacedFeature> ORE_PLATINUM_PLACED = ResourceKey.create(Registries.PLACED_FEATURE, new ResourceLocation(Technologica.MODID, "ore_platinum"));
	public static final ResourceKey<PlacedFeature> ORE_CINNABAR_PLACED = ResourceKey.create(Registries.PLACED_FEATURE, new ResourceLocation(Technologica.MODID, "ore_cinnabar"));
	public static final ResourceKey<PlacedFeature> ORE_THORIANITE_PLACED = ResourceKey.create(Registries.PLACED_FEATURE, new ResourceLocation(Technologica.MODID, "ore_thorianite"));
	public static final ResourceKey<PlacedFeature> ORE_URANINITE_PLACED = ResourceKey.create(Registries.PLACED_FEATURE, new ResourceLocation(Technologica.MODID, "ore_uraninite"));
	public static final ResourceKey<PlacedFeature> ORE_EMERALD_PLACED = ResourceKey.create(Registries.PLACED_FEATURE, new ResourceLocation(Technologica.MODID, "ore_emerald"));
	public static final ResourceKey<PlacedFeature> ORE_RUBY_PLACED = ResourceKey.create(Registries.PLACED_FEATURE, new ResourceLocation(Technologica.MODID, "ore_ruby"));
	public static final ResourceKey<PlacedFeature> ORE_SAPPHIRE_PLACED = ResourceKey.create(Registries.PLACED_FEATURE, new ResourceLocation(Technologica.MODID, "ore_sapphire"));
	public static final ResourceKey<PlacedFeature> ORE_TOPAZ_PLACED = ResourceKey.create(Registries.PLACED_FEATURE, new ResourceLocation(Technologica.MODID, "ore_topaz"));

	private static List<PlacementModifier> orePlacement(PlacementModifier p_195347_, PlacementModifier p_195348_) {
		return List.of(p_195347_, InSquarePlacement.spread(), p_195348_, BiomeFilter.biome());
	}

	private static List<PlacementModifier> commonOrePlacement(int p_195344_, PlacementModifier p_195345_) {
		return orePlacement(CountPlacement.of(p_195344_), p_195345_);
	}

	public static void bootstrap(BootstapContext<PlacedFeature> p_256238_) {
		HolderGetter<ConfiguredFeature<?, ?>> holdergetter = p_256238_.lookup(Registries.CONFIGURED_FEATURE);
		Holder<ConfiguredFeature<?, ?>> holder = holdergetter.getOrThrow(TechnologicaOreFeatures.ORE_SPODUMENE);
		Holder<ConfiguredFeature<?, ?>> holder1 = holdergetter.getOrThrow(TechnologicaOreFeatures.ORE_BORAX);
		Holder<ConfiguredFeature<?, ?>> holder2 = holdergetter.getOrThrow(TechnologicaOreFeatures.ORE_MAGNESITE);
		Holder<ConfiguredFeature<?, ?>> holder3 = holdergetter.getOrThrow(TechnologicaOreFeatures.ORE_BAUXITE);
		Holder<ConfiguredFeature<?, ?>> holder4 = holdergetter.getOrThrow(TechnologicaOreFeatures.ORE_APATITE);
		Holder<ConfiguredFeature<?, ?>> holder5 = holdergetter.getOrThrow(TechnologicaOreFeatures.ORE_PHOSPHORITE);
		Holder<ConfiguredFeature<?, ?>> holder6 = holdergetter.getOrThrow(TechnologicaOreFeatures.ORE_GADOLINITE);
		Holder<ConfiguredFeature<?, ?>> holder7 = holdergetter.getOrThrow(TechnologicaOreFeatures.ORE_ILMENITE);
		Holder<ConfiguredFeature<?, ?>> holder8 = holdergetter.getOrThrow(TechnologicaOreFeatures.ORE_PATRONITE);
		Holder<ConfiguredFeature<?, ?>> holder9 = holdergetter.getOrThrow(TechnologicaOreFeatures.ORE_CHROMITE);
		Holder<ConfiguredFeature<?, ?>> holder10 = holdergetter.getOrThrow(TechnologicaOreFeatures.ORE_PYROLUSITE);
		Holder<ConfiguredFeature<?, ?>> holder11 = holdergetter.getOrThrow(TechnologicaOreFeatures.ORE_COBALTITE);
		Holder<ConfiguredFeature<?, ?>> holder12 = holdergetter.getOrThrow(TechnologicaOreFeatures.ORE_GARNIERITE);
		Holder<ConfiguredFeature<?, ?>> holder13 = holdergetter.getOrThrow(TechnologicaOreFeatures.ORE_ARSENOPYRITE);
		Holder<ConfiguredFeature<?, ?>> holder14 = holdergetter.getOrThrow(TechnologicaOreFeatures.ORE_CROOKESITE);
		Holder<ConfiguredFeature<?, ?>> holder15 = holdergetter.getOrThrow(TechnologicaOreFeatures.ORE_LEPIDOLITE);
		Holder<ConfiguredFeature<?, ?>> holder16 = holdergetter.getOrThrow(TechnologicaOreFeatures.ORE_BASTNAESITE);
		Holder<ConfiguredFeature<?, ?>> holder17 = holdergetter.getOrThrow(TechnologicaOreFeatures.ORE_TANTALITE);
		Holder<ConfiguredFeature<?, ?>> holder18 = holdergetter.getOrThrow(TechnologicaOreFeatures.ORE_MOLYBDENITE);
		Holder<ConfiguredFeature<?, ?>> holder19 = holdergetter.getOrThrow(TechnologicaOreFeatures.ORE_PENTLANDITE);
		Holder<ConfiguredFeature<?, ?>> holder20 = holdergetter.getOrThrow(TechnologicaOreFeatures.ORE_ARGENTITE);
		Holder<ConfiguredFeature<?, ?>> holder21 = holdergetter.getOrThrow(TechnologicaOreFeatures.ORE_GALENA);
		Holder<ConfiguredFeature<?, ?>> holder22 = holdergetter.getOrThrow(TechnologicaOreFeatures.ORE_SYLVANITE);
		Holder<ConfiguredFeature<?, ?>> holder23 = holdergetter.getOrThrow(TechnologicaOreFeatures.ORE_CASSITERITE);
		Holder<ConfiguredFeature<?, ?>> holder24 = holdergetter.getOrThrow(TechnologicaOreFeatures.ORE_WOLFRAMITE);
		Holder<ConfiguredFeature<?, ?>> holder25 = holdergetter.getOrThrow(TechnologicaOreFeatures.ORE_OSMIRIDIUM);
		Holder<ConfiguredFeature<?, ?>> holder26 = holdergetter.getOrThrow(TechnologicaOreFeatures.ORE_PLATINUM);
		Holder<ConfiguredFeature<?, ?>> holder27 = holdergetter.getOrThrow(TechnologicaOreFeatures.ORE_CINNABAR);
		Holder<ConfiguredFeature<?, ?>> holder28 = holdergetter.getOrThrow(TechnologicaOreFeatures.ORE_THORIANITE);
		Holder<ConfiguredFeature<?, ?>> holder29 = holdergetter.getOrThrow(TechnologicaOreFeatures.ORE_URANINITE);
		Holder<ConfiguredFeature<?, ?>> holder30 = holdergetter.getOrThrow(TechnologicaOreFeatures.ORE_EMERALD);
		Holder<ConfiguredFeature<?, ?>> holder31 = holdergetter.getOrThrow(TechnologicaOreFeatures.ORE_RUBY);
		Holder<ConfiguredFeature<?, ?>> holder32 = holdergetter.getOrThrow(TechnologicaOreFeatures.ORE_SAPPHIRE);
		Holder<ConfiguredFeature<?, ?>> holder33 = holdergetter.getOrThrow(TechnologicaOreFeatures.ORE_TOPAZ);
		PlacementUtils.register(p_256238_, ORE_SPODUMENE_PLACED, holder, commonOrePlacement(10, HeightRangePlacement.uniform(VerticalAnchor.absolute(48), VerticalAnchor.top())));
		PlacementUtils.register(p_256238_, ORE_BORAX_PLACED, holder1, commonOrePlacement(10, HeightRangePlacement.uniform(VerticalAnchor.absolute(48), VerticalAnchor.absolute(64))));
		PlacementUtils.register(p_256238_, ORE_MAGNESITE_PLACED, holder2, commonOrePlacement(10, HeightRangePlacement.uniform(VerticalAnchor.absolute(0), VerticalAnchor.top())));
		PlacementUtils.register(p_256238_, ORE_BAUXITE_PLACED, holder3, commonOrePlacement(10, HeightRangePlacement.triangle(VerticalAnchor.absolute(-24), VerticalAnchor.absolute(56))));
		PlacementUtils.register(p_256238_, ORE_APATITE_PLACED, holder4, commonOrePlacement(10, HeightRangePlacement.uniform(VerticalAnchor.absolute(48), VerticalAnchor.absolute(64))));
		PlacementUtils.register(p_256238_, ORE_PHOSPHORITE_PLACED, holder5, commonOrePlacement(10, HeightRangePlacement.uniform(VerticalAnchor.absolute(32), VerticalAnchor.absolute(48))));
		PlacementUtils.register(p_256238_, ORE_GADOLINITE_PLACED, holder6, commonOrePlacement(10, HeightRangePlacement.triangle(VerticalAnchor.absolute(-24), VerticalAnchor.absolute(56))));
		PlacementUtils.register(p_256238_, ORE_ILMENITE_PLACED, holder7, commonOrePlacement(10, HeightRangePlacement.uniform(VerticalAnchor.bottom(), VerticalAnchor.top())));
		PlacementUtils.register(p_256238_, ORE_PATRONITE_PLACED, holder8, commonOrePlacement(10, HeightRangePlacement.triangle(VerticalAnchor.absolute(-24), VerticalAnchor.absolute(56))));
		PlacementUtils.register(p_256238_, ORE_CHROMITE_PLACED, holder9, commonOrePlacement(10, HeightRangePlacement.triangle(VerticalAnchor.absolute(-24), VerticalAnchor.absolute(56))));
		PlacementUtils.register(p_256238_, ORE_PYROLUSITE_PLACED, holder10, commonOrePlacement(10, HeightRangePlacement.triangle(VerticalAnchor.absolute(-24), VerticalAnchor.absolute(56))));
		PlacementUtils.register(p_256238_, ORE_COBALTITE_PLACED, holder11, commonOrePlacement(10, HeightRangePlacement.triangle(VerticalAnchor.absolute(-24), VerticalAnchor.absolute(56))));
		PlacementUtils.register(p_256238_, ORE_GARNIERITE_PLACED, holder12, commonOrePlacement(10, HeightRangePlacement.triangle(VerticalAnchor.absolute(-24), VerticalAnchor.absolute(56))));
		PlacementUtils.register(p_256238_, ORE_ARSENOPYRITE_PLACED, holder13, commonOrePlacement(10, HeightRangePlacement.uniform(VerticalAnchor.absolute(0), VerticalAnchor.top())));
		PlacementUtils.register(p_256238_, ORE_CROOKESITE_PLACED, holder14, commonOrePlacement(10, HeightRangePlacement.uniform(VerticalAnchor.absolute(0), VerticalAnchor.top())));
		PlacementUtils.register(p_256238_, ORE_LEPIDOLITE_PLACED, holder15, commonOrePlacement(10, HeightRangePlacement.uniform(VerticalAnchor.absolute(0), VerticalAnchor.top())));
		PlacementUtils.register(p_256238_, ORE_BASTNAESITE_PLACED, holder16, commonOrePlacement(10, HeightRangePlacement.triangle(VerticalAnchor.absolute(-24), VerticalAnchor.absolute(56))));
		PlacementUtils.register(p_256238_, ORE_TANTALITE_PLACED, holder17, commonOrePlacement(16, HeightRangePlacement.triangle(VerticalAnchor.absolute(-16), VerticalAnchor.absolute(112))));
		PlacementUtils.register(p_256238_, ORE_MOLYBDENITE_PLACED, holder18, commonOrePlacement(16, HeightRangePlacement.triangle(VerticalAnchor.absolute(-16), VerticalAnchor.absolute(112))));
		PlacementUtils.register(p_256238_, ORE_PENTLANDITE_PLACED, holder19, commonOrePlacement(10, HeightRangePlacement.triangle(VerticalAnchor.absolute(-24), VerticalAnchor.absolute(56))));
		PlacementUtils.register(p_256238_, ORE_ARGENTITE_PLACED, holder20, commonOrePlacement(10, HeightRangePlacement.uniform(VerticalAnchor.absolute(-64), VerticalAnchor.absolute(32))));
		PlacementUtils.register(p_256238_, ORE_GALENA_PLACED, holder21, commonOrePlacement(16, HeightRangePlacement.triangle(VerticalAnchor.absolute(-16), VerticalAnchor.absolute(112))));
		PlacementUtils.register(p_256238_, ORE_SYLVANITE_PLACED, holder22, commonOrePlacement(10, HeightRangePlacement.uniform(VerticalAnchor.absolute(-64), VerticalAnchor.absolute(32))));
		PlacementUtils.register(p_256238_, ORE_CASSITERITE_PLACED, holder23, commonOrePlacement(10, HeightRangePlacement.uniform(VerticalAnchor.absolute(0), VerticalAnchor.top())));
		PlacementUtils.register(p_256238_, ORE_WOLFRAMITE_PLACED, holder24, commonOrePlacement(16, HeightRangePlacement.triangle(VerticalAnchor.absolute(-16), VerticalAnchor.absolute(112))));
		PlacementUtils.register(p_256238_, ORE_OSMIRIDIUM_PLACED, holder25, commonOrePlacement(10, HeightRangePlacement.uniform(VerticalAnchor.absolute(-64), VerticalAnchor.absolute(32))));
		PlacementUtils.register(p_256238_, ORE_PLATINUM_PLACED, holder26, commonOrePlacement(4, HeightRangePlacement.triangle(VerticalAnchor.absolute(-64), VerticalAnchor.absolute(32))));
		PlacementUtils.register(p_256238_, ORE_CINNABAR_PLACED, holder27, commonOrePlacement(4, HeightRangePlacement.uniform(VerticalAnchor.bottom(), VerticalAnchor.absolute(15))));
		PlacementUtils.register(p_256238_, ORE_THORIANITE_PLACED, holder28, commonOrePlacement(4, HeightRangePlacement.uniform(VerticalAnchor.bottom(), VerticalAnchor.absolute(15))));
		PlacementUtils.register(p_256238_, ORE_URANINITE_PLACED, holder29, commonOrePlacement(4, HeightRangePlacement.uniform(VerticalAnchor.bottom(), VerticalAnchor.absolute(15))));
		PlacementUtils.register(p_256238_, ORE_EMERALD_PLACED, holder30, commonOrePlacement(100, HeightRangePlacement.triangle(VerticalAnchor.absolute(-16), VerticalAnchor.absolute(480))));
		PlacementUtils.register(p_256238_, ORE_RUBY_PLACED, holder31, commonOrePlacement(100, HeightRangePlacement.triangle(VerticalAnchor.absolute(-16), VerticalAnchor.absolute(480))));
		PlacementUtils.register(p_256238_, ORE_SAPPHIRE_PLACED, holder32, commonOrePlacement(100, HeightRangePlacement.triangle(VerticalAnchor.absolute(-16), VerticalAnchor.absolute(480))));
		PlacementUtils.register(p_256238_, ORE_TOPAZ_PLACED, holder33, commonOrePlacement(100, HeightRangePlacement.triangle(VerticalAnchor.absolute(-16), VerticalAnchor.absolute(480))));
	}
}