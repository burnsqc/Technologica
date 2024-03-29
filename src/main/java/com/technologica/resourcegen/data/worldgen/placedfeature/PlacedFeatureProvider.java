package com.technologica.resourcegen.data.worldgen.placedfeature;

import java.util.List;

import com.google.common.collect.ImmutableList;
import com.technologica.registration.deferred.TechnologicaBlocks;
import com.technologica.registration.key.TechnologicaConfiguredFeatures;
import com.technologica.registration.key.TechnologicaPlacedFeatures;

import net.minecraft.core.Holder;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.data.worldgen.features.TreeFeatures;
import net.minecraft.data.worldgen.features.VegetationFeatures;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.placement.BiomeFilter;
import net.minecraft.world.level.levelgen.placement.CountOnEveryLayerPlacement;
import net.minecraft.world.level.levelgen.placement.CountPlacement;
import net.minecraft.world.level.levelgen.placement.HeightRangePlacement;
import net.minecraft.world.level.levelgen.placement.InSquarePlacement;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraft.world.level.levelgen.placement.PlacementModifier;
import net.minecraft.world.level.levelgen.placement.RarityFilter;
import net.minecraft.world.level.levelgen.placement.SurfaceWaterDepthFilter;

@SuppressWarnings("deprecation")
public class PlacedFeatureProvider {
	public static final PlacementModifier TREE_THRESHOLD = SurfaceWaterDepthFilter.forMaxDepth(0);

	public static void bootstrap(BootstapContext<PlacedFeature> bootstrapContextIn) {
		HolderGetter<ConfiguredFeature<?, ?>> configuredFeatures = bootstrapContextIn.lookup(Registries.CONFIGURED_FEATURE);
		
		Holder<ConfiguredFeature<?, ?>> brinePool = configuredFeatures.getOrThrow(TechnologicaConfiguredFeatures.BRINE_POOL_CONFIGURED);
		Holder<ConfiguredFeature<?, ?>> oasis = configuredFeatures.getOrThrow(TechnologicaConfiguredFeatures.OASIS_CONFIGURED);
		Holder<ConfiguredFeature<?, ?>> oil_well = configuredFeatures.getOrThrow(TechnologicaConfiguredFeatures.OIL_WELL_CONFIGURED);
		
		Holder<ConfiguredFeature<?, ?>> oreSpodumene = configuredFeatures.getOrThrow(TechnologicaConfiguredFeatures.ORE_SPODUMENE);
		Holder<ConfiguredFeature<?, ?>> oreBorax = configuredFeatures.getOrThrow(TechnologicaConfiguredFeatures.ORE_BORAX);
		Holder<ConfiguredFeature<?, ?>> oreMagnesite = configuredFeatures.getOrThrow(TechnologicaConfiguredFeatures.ORE_MAGNESITE);
		Holder<ConfiguredFeature<?, ?>> oreBauxite = configuredFeatures.getOrThrow(TechnologicaConfiguredFeatures.ORE_BAUXITE);
		Holder<ConfiguredFeature<?, ?>> oreApatite = configuredFeatures.getOrThrow(TechnologicaConfiguredFeatures.ORE_APATITE);
		Holder<ConfiguredFeature<?, ?>> orePhosphorite = configuredFeatures.getOrThrow(TechnologicaConfiguredFeatures.ORE_PHOSPHORITE);
		Holder<ConfiguredFeature<?, ?>> oreGadolinite = configuredFeatures.getOrThrow(TechnologicaConfiguredFeatures.ORE_GADOLINITE);
		Holder<ConfiguredFeature<?, ?>> oreIlmenite = configuredFeatures.getOrThrow(TechnologicaConfiguredFeatures.ORE_ILMENITE);
		Holder<ConfiguredFeature<?, ?>> orePatronite = configuredFeatures.getOrThrow(TechnologicaConfiguredFeatures.ORE_PATRONITE);
		Holder<ConfiguredFeature<?, ?>> oreChromite = configuredFeatures.getOrThrow(TechnologicaConfiguredFeatures.ORE_CHROMITE);
		Holder<ConfiguredFeature<?, ?>> orePyrolusite = configuredFeatures.getOrThrow(TechnologicaConfiguredFeatures.ORE_PYROLUSITE);
		Holder<ConfiguredFeature<?, ?>> oreCobaltite = configuredFeatures.getOrThrow(TechnologicaConfiguredFeatures.ORE_COBALTITE);
		Holder<ConfiguredFeature<?, ?>> oreGarnierite = configuredFeatures.getOrThrow(TechnologicaConfiguredFeatures.ORE_GARNIERITE);
		Holder<ConfiguredFeature<?, ?>> oreArsenopyrite = configuredFeatures.getOrThrow(TechnologicaConfiguredFeatures.ORE_ARSENOPYRITE);
		Holder<ConfiguredFeature<?, ?>> oreCrookesite = configuredFeatures.getOrThrow(TechnologicaConfiguredFeatures.ORE_CROOKESITE);
		Holder<ConfiguredFeature<?, ?>> oreLepidolite = configuredFeatures.getOrThrow(TechnologicaConfiguredFeatures.ORE_LEPIDOLITE);
		Holder<ConfiguredFeature<?, ?>> oreBastnaesite = configuredFeatures.getOrThrow(TechnologicaConfiguredFeatures.ORE_BASTNAESITE);
		Holder<ConfiguredFeature<?, ?>> oreTantalite = configuredFeatures.getOrThrow(TechnologicaConfiguredFeatures.ORE_TANTALITE);
		Holder<ConfiguredFeature<?, ?>> oreMolybdenite = configuredFeatures.getOrThrow(TechnologicaConfiguredFeatures.ORE_MOLYBDENITE);
		Holder<ConfiguredFeature<?, ?>> orePentlandite = configuredFeatures.getOrThrow(TechnologicaConfiguredFeatures.ORE_PENTLANDITE);
		Holder<ConfiguredFeature<?, ?>> oreArgentite = configuredFeatures.getOrThrow(TechnologicaConfiguredFeatures.ORE_ARGENTITE);
		Holder<ConfiguredFeature<?, ?>> oreGalena = configuredFeatures.getOrThrow(TechnologicaConfiguredFeatures.ORE_GALENA);
		Holder<ConfiguredFeature<?, ?>> oreSylvanite = configuredFeatures.getOrThrow(TechnologicaConfiguredFeatures.ORE_SYLVANITE);
		Holder<ConfiguredFeature<?, ?>> oreCassiterite = configuredFeatures.getOrThrow(TechnologicaConfiguredFeatures.ORE_CASSITERITE);
		Holder<ConfiguredFeature<?, ?>> oreWolframite = configuredFeatures.getOrThrow(TechnologicaConfiguredFeatures.ORE_WOLFRAMITE);
		Holder<ConfiguredFeature<?, ?>> oreOsmiridium = configuredFeatures.getOrThrow(TechnologicaConfiguredFeatures.ORE_OSMIRIDIUM);
		Holder<ConfiguredFeature<?, ?>> orePlatinum = configuredFeatures.getOrThrow(TechnologicaConfiguredFeatures.ORE_PLATINUM);
		Holder<ConfiguredFeature<?, ?>> oreCinnabar = configuredFeatures.getOrThrow(TechnologicaConfiguredFeatures.ORE_CINNABAR);
		Holder<ConfiguredFeature<?, ?>> oreThorianite = configuredFeatures.getOrThrow(TechnologicaConfiguredFeatures.ORE_THORIANITE);
		Holder<ConfiguredFeature<?, ?>> oreUraninite = configuredFeatures.getOrThrow(TechnologicaConfiguredFeatures.ORE_URANINITE);
		Holder<ConfiguredFeature<?, ?>> oreEmerald = configuredFeatures.getOrThrow(TechnologicaConfiguredFeatures.ORE_EMERALD);
		Holder<ConfiguredFeature<?, ?>> oreRuby = configuredFeatures.getOrThrow(TechnologicaConfiguredFeatures.ORE_RUBY);
		Holder<ConfiguredFeature<?, ?>> oreSapphire = configuredFeatures.getOrThrow(TechnologicaConfiguredFeatures.ORE_SAPPHIRE);
		Holder<ConfiguredFeature<?, ?>> oreTopaz = configuredFeatures.getOrThrow(TechnologicaConfiguredFeatures.ORE_TOPAZ);
		
		Holder<ConfiguredFeature<?, ?>> holder = configuredFeatures.getOrThrow(TechnologicaConfiguredFeatures.APRICOT);
		Holder<ConfiguredFeature<?, ?>> holder1 = configuredFeatures.getOrThrow(TechnologicaConfiguredFeatures.ASPEN);
		Holder<ConfiguredFeature<?, ?>> holder2 = configuredFeatures.getOrThrow(TechnologicaConfiguredFeatures.AVOCADO);
		Holder<ConfiguredFeature<?, ?>> holder3 = configuredFeatures.getOrThrow(TechnologicaConfiguredFeatures.BANANA);
		Holder<ConfiguredFeature<?, ?>> holder4 = configuredFeatures.getOrThrow(TechnologicaConfiguredFeatures.CHERRY);
		Holder<ConfiguredFeature<?, ?>> holder5 = configuredFeatures.getOrThrow(TechnologicaConfiguredFeatures.CHESTNUT);
		Holder<ConfiguredFeature<?, ?>> holder6 = configuredFeatures.getOrThrow(TechnologicaConfiguredFeatures.CINNAMON);
		Holder<ConfiguredFeature<?, ?>> holder7 = configuredFeatures.getOrThrow(TechnologicaConfiguredFeatures.COCONUT);
		Holder<ConfiguredFeature<?, ?>> holder8 = configuredFeatures.getOrThrow(TechnologicaConfiguredFeatures.EBONY);
		Holder<ConfiguredFeature<?, ?>> holder9 = configuredFeatures.getOrThrow(TechnologicaConfiguredFeatures.KIWI);
		Holder<ConfiguredFeature<?, ?>> holder10 = configuredFeatures.getOrThrow(TechnologicaConfiguredFeatures.LEMON);
		Holder<ConfiguredFeature<?, ?>> holder11 = configuredFeatures.getOrThrow(TechnologicaConfiguredFeatures.LIME);
		Holder<ConfiguredFeature<?, ?>> holder12 = configuredFeatures.getOrThrow(TechnologicaConfiguredFeatures.MAHOGANY);
		Holder<ConfiguredFeature<?, ?>> holder13 = configuredFeatures.getOrThrow(TechnologicaConfiguredFeatures.MAPLE);
		Holder<ConfiguredFeature<?, ?>> holder14 = configuredFeatures.getOrThrow(TechnologicaConfiguredFeatures.OLIVE);
		Holder<ConfiguredFeature<?, ?>> holder15 = configuredFeatures.getOrThrow(TechnologicaConfiguredFeatures.ORANGE);
		Holder<ConfiguredFeature<?, ?>> holder16 = configuredFeatures.getOrThrow(TechnologicaConfiguredFeatures.PEACH);
		Holder<ConfiguredFeature<?, ?>> holder17 = configuredFeatures.getOrThrow(TechnologicaConfiguredFeatures.PEAR);
		Holder<ConfiguredFeature<?, ?>> holder18 = configuredFeatures.getOrThrow(TechnologicaConfiguredFeatures.PLUM);
		// Holder<ConfiguredFeature<?, ?>> holder19 = holdergetter.getOrThrow(TechnologicaConfiguredFeatures.REDWOOD);
		Holder<ConfiguredFeature<?, ?>> holder20 = configuredFeatures.getOrThrow(TechnologicaConfiguredFeatures.ROSEWOOD);
		Holder<ConfiguredFeature<?, ?>> holder21 = configuredFeatures.getOrThrow(TechnologicaConfiguredFeatures.RUBBER);
		Holder<ConfiguredFeature<?, ?>> holder22 = configuredFeatures.getOrThrow(TechnologicaConfiguredFeatures.TEAK);
		Holder<ConfiguredFeature<?, ?>> holder23 = configuredFeatures.getOrThrow(TechnologicaConfiguredFeatures.WALNUT);
		Holder<ConfiguredFeature<?, ?>> holder24 = configuredFeatures.getOrThrow(TechnologicaConfiguredFeatures.ZEBRAWOOD);
		Holder<ConfiguredFeature<?, ?>> holder25 = configuredFeatures.getOrThrow(TechnologicaConfiguredFeatures.ANCIENT_AMBROSIA);
		Holder<ConfiguredFeature<?, ?>> holder26 = configuredFeatures.getOrThrow(TechnologicaConfiguredFeatures.BENEVOLENT_APOTHECARY);
		Holder<ConfiguredFeature<?, ?>> holder27 = configuredFeatures.getOrThrow(TechnologicaConfiguredFeatures.CRYOGENIC_SPIRE);
		Holder<ConfiguredFeature<?, ?>> holder28 = configuredFeatures.getOrThrow(TechnologicaConfiguredFeatures.MALEVOLENT_APOTHECARY);
		Holder<ConfiguredFeature<?, ?>> holder29 = configuredFeatures.getOrThrow(TechnologicaConfiguredFeatures.NECROTIC);
		Holder<ConfiguredFeature<?, ?>> holder30 = configuredFeatures.getOrThrow(TechnologicaConfiguredFeatures.SERENDIPITOUS_APOTHECARY);
		Holder<ConfiguredFeature<?, ?>> holder31 = configuredFeatures.getOrThrow(TechnologicaConfiguredFeatures.THUNDEROUS_CONDUCTOR);
		Holder<ConfiguredFeature<?, ?>> holder32 = configuredFeatures.getOrThrow(TechnologicaConfiguredFeatures.TOWERING_INFERNO);
		Holder<ConfiguredFeature<?, ?>> holder33 = configuredFeatures.getOrThrow(TreeFeatures.TALL_MANGROVE);
		
		Holder<ConfiguredFeature<?, ?>> treesModifiedSavanna = configuredFeatures.getOrThrow(TechnologicaConfiguredFeatures.TREES_MODIFIED_SAVANNA);
		Holder<ConfiguredFeature<?, ?>> treesModifiedJungle = configuredFeatures.getOrThrow(TechnologicaConfiguredFeatures.TREES_MODIFIED_JUNGLE);
		Holder<ConfiguredFeature<?, ?>> treesModifiedJungleEdge = configuredFeatures.getOrThrow(TechnologicaConfiguredFeatures.TREES_MODIFIED_JUNGLE_EDGE);
		Holder<ConfiguredFeature<?, ?>> treesModifiedBambooJungle = configuredFeatures.getOrThrow(TechnologicaConfiguredFeatures.TREES_MODIFIED_BAMBOO_JUNGLE);
		Holder<ConfiguredFeature<?, ?>> treesModifiedForest = configuredFeatures.getOrThrow(TechnologicaConfiguredFeatures.TREES_MODIFIED_FOREST);
		Holder<ConfiguredFeature<?, ?>> treesModifiedBirchForest = configuredFeatures.getOrThrow(TechnologicaConfiguredFeatures.TREES_MODIFIED_BIRCH_FOREST);
		Holder<ConfiguredFeature<?, ?>> treesModifiedWoodedHills = configuredFeatures.getOrThrow(TechnologicaConfiguredFeatures.TREES_MODIFIED_WOODED_HILLS);
		Holder<ConfiguredFeature<?, ?>> treesModifiedBeach = configuredFeatures.getOrThrow(TechnologicaConfiguredFeatures.TREES_MODIFIED_BEACH);
		Holder<ConfiguredFeature<?, ?>> treesModifiedTaiga = configuredFeatures.getOrThrow(TechnologicaConfiguredFeatures.TREES_MODIFIED_TAIGA);
		Holder<ConfiguredFeature<?, ?>> treesModifiedSnowyTaiga = configuredFeatures.getOrThrow(TechnologicaConfiguredFeatures.TREES_MODIFIED_SNOWY_TAIGA);
		Holder<ConfiguredFeature<?, ?>> treesModifiedSwamp = configuredFeatures.getOrThrow(TechnologicaConfiguredFeatures.TREES_MODIFIED_SWAMP);
		Holder<ConfiguredFeature<?, ?>> patchBlackberryBush = configuredFeatures.getOrThrow(TechnologicaConfiguredFeatures.PATCH_BLACKBERRY_BUSH);
		Holder<ConfiguredFeature<?, ?>> patchBlueberryBush = configuredFeatures.getOrThrow(TechnologicaConfiguredFeatures.PATCH_BLUEBERRY_BUSH);
		Holder<ConfiguredFeature<?, ?>> patchRaspberryBush = configuredFeatures.getOrThrow(TechnologicaConfiguredFeatures.PATCH_RASPBERRY_BUSH);
		Holder<ConfiguredFeature<?, ?>> patchStrawberryBush = configuredFeatures.getOrThrow(TechnologicaConfiguredFeatures.PATCH_STRAWBERRY_BUSH);
		Holder<ConfiguredFeature<?, ?>> patchCottonBush = configuredFeatures.getOrThrow(TechnologicaConfiguredFeatures.PATCH_COTTON_BUSH);
		Holder<ConfiguredFeature<?, ?>> patchPeppercornBush = configuredFeatures.getOrThrow(TechnologicaConfiguredFeatures.PATCH_PEPPERCORN_BUSH);
		Holder<ConfiguredFeature<?, ?>> mangroveVegetation = configuredFeatures.getOrThrow(VegetationFeatures.MANGROVE_VEGETATION);
		
		/*
		 * MISC
		 */
		
		bootstrapContextIn.register(TechnologicaPlacedFeatures.BRINE_POOL_PLACED, new PlacedFeature(brinePool, List.of(RarityFilter.onAverageOnceEvery(2), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP_WORLD_SURFACE, BiomeFilter.biome())));
		bootstrapContextIn.register(TechnologicaPlacedFeatures.OASIS_PLACED, new PlacedFeature(oasis, List.of(RarityFilter.onAverageOnceEvery(200), InSquarePlacement.spread(), HeightRangePlacement.uniform(VerticalAnchor.bottom(), VerticalAnchor.absolute(192)), BiomeFilter.biome())));
		bootstrapContextIn.register(TechnologicaPlacedFeatures.OIL_WELL_PLACED, new PlacedFeature(oil_well, List.of(RarityFilter.onAverageOnceEvery(50), InSquarePlacement.spread(), HeightRangePlacement.uniform(VerticalAnchor.aboveBottom(6), VerticalAnchor.absolute(30)), BiomeFilter.biome())));
		// bootstrapContextIn.register(PATCH_BLACKBERRY_BUSH_VILLAGE, new PlacedFeature(context.lookup(Registries.CONFIGURED_FEATURE).getOrThrow(PATCH_BLACKBERRY_BUSH), null));
		// bootstrapContextIn.register(PATCH_BLUEBERRY_BUSH_VILLAGE, new PlacedFeature(context.lookup(Registries.CONFIGURED_FEATURE).getOrThrow(PATCH_BLUEBERRY_BUSH)));
		// bootstrapContextIn.register(PATCH_RASPBERRY_BUSH_VILLAGE, new PlacedFeature(context.lookup(Registries.CONFIGURED_FEATURE).getOrThrow(PATCH_RASPBERRY_BUSH)));
		// bootstrapContextIn.register(PATCH_STRAWBERRY_BUSH_VILLAGE, new PlacedFeature(context.lookup(Registries.CONFIGURED_FEATURE).getOrThrow(PATCH_STRAWBERRY_BUSH)));
		
		/*
		 * ORE
		 */
		
		bootstrapContextIn.register(TechnologicaPlacedFeatures.ORE_SPODUMENE_PLACED, new PlacedFeature(oreSpodumene, commonOrePlacement(10, HeightRangePlacement.uniform(VerticalAnchor.absolute(48), VerticalAnchor.top()))));
		bootstrapContextIn.register(TechnologicaPlacedFeatures.ORE_BORAX_PLACED, new PlacedFeature(oreBorax, commonOrePlacement(10, HeightRangePlacement.uniform(VerticalAnchor.absolute(48), VerticalAnchor.absolute(64)))));
		bootstrapContextIn.register(TechnologicaPlacedFeatures.ORE_MAGNESITE_PLACED, new PlacedFeature(oreMagnesite, commonOrePlacement(10, HeightRangePlacement.uniform(VerticalAnchor.absolute(0), VerticalAnchor.top()))));
		bootstrapContextIn.register(TechnologicaPlacedFeatures.ORE_BAUXITE_PLACED, new PlacedFeature(oreBauxite, commonOrePlacement(10, HeightRangePlacement.triangle(VerticalAnchor.absolute(-24), VerticalAnchor.absolute(56)))));
		bootstrapContextIn.register(TechnologicaPlacedFeatures.ORE_APATITE_PLACED, new PlacedFeature(oreApatite, commonOrePlacement(10, HeightRangePlacement.uniform(VerticalAnchor.absolute(48), VerticalAnchor.absolute(64)))));
		bootstrapContextIn.register(TechnologicaPlacedFeatures.ORE_PHOSPHORITE_PLACED, new PlacedFeature(orePhosphorite, commonOrePlacement(10, HeightRangePlacement.uniform(VerticalAnchor.absolute(32), VerticalAnchor.absolute(48)))));
		bootstrapContextIn.register(TechnologicaPlacedFeatures.ORE_GADOLINITE_PLACED, new PlacedFeature(oreGadolinite, commonOrePlacement(10, HeightRangePlacement.triangle(VerticalAnchor.absolute(-24), VerticalAnchor.absolute(56)))));
		bootstrapContextIn.register(TechnologicaPlacedFeatures.ORE_ILMENITE_PLACED, new PlacedFeature(oreIlmenite, commonOrePlacement(10, HeightRangePlacement.uniform(VerticalAnchor.bottom(), VerticalAnchor.top()))));
		bootstrapContextIn.register(TechnologicaPlacedFeatures.ORE_PATRONITE_PLACED, new PlacedFeature(orePatronite, commonOrePlacement(10, HeightRangePlacement.triangle(VerticalAnchor.absolute(-24), VerticalAnchor.absolute(56)))));
		bootstrapContextIn.register(TechnologicaPlacedFeatures.ORE_CHROMITE_PLACED, new PlacedFeature(oreChromite, commonOrePlacement(10, HeightRangePlacement.triangle(VerticalAnchor.absolute(-24), VerticalAnchor.absolute(56)))));
		bootstrapContextIn.register(TechnologicaPlacedFeatures.ORE_PYROLUSITE_PLACED, new PlacedFeature(orePyrolusite, commonOrePlacement(10, HeightRangePlacement.triangle(VerticalAnchor.absolute(-24), VerticalAnchor.absolute(56)))));
		bootstrapContextIn.register(TechnologicaPlacedFeatures.ORE_COBALTITE_PLACED, new PlacedFeature(oreCobaltite, commonOrePlacement(10, HeightRangePlacement.triangle(VerticalAnchor.absolute(-24), VerticalAnchor.absolute(56)))));
		bootstrapContextIn.register(TechnologicaPlacedFeatures.ORE_GARNIERITE_PLACED, new PlacedFeature(oreGarnierite, commonOrePlacement(10, HeightRangePlacement.triangle(VerticalAnchor.absolute(-24), VerticalAnchor.absolute(56)))));
		bootstrapContextIn.register(TechnologicaPlacedFeatures.ORE_ARSENOPYRITE_PLACED, new PlacedFeature(oreArsenopyrite, commonOrePlacement(10, HeightRangePlacement.uniform(VerticalAnchor.absolute(0), VerticalAnchor.top()))));
		bootstrapContextIn.register(TechnologicaPlacedFeatures.ORE_CROOKESITE_PLACED, new PlacedFeature(oreCrookesite, commonOrePlacement(10, HeightRangePlacement.uniform(VerticalAnchor.absolute(0), VerticalAnchor.top()))));
		bootstrapContextIn.register(TechnologicaPlacedFeatures.ORE_LEPIDOLITE_PLACED, new PlacedFeature(oreLepidolite, commonOrePlacement(10, HeightRangePlacement.uniform(VerticalAnchor.absolute(0), VerticalAnchor.top()))));
		bootstrapContextIn.register(TechnologicaPlacedFeatures.ORE_BASTNAESITE_PLACED, new PlacedFeature(oreBastnaesite, commonOrePlacement(10, HeightRangePlacement.triangle(VerticalAnchor.absolute(-24), VerticalAnchor.absolute(56)))));
		bootstrapContextIn.register(TechnologicaPlacedFeatures.ORE_TANTALITE_PLACED, new PlacedFeature(oreTantalite, commonOrePlacement(16, HeightRangePlacement.triangle(VerticalAnchor.absolute(-16), VerticalAnchor.absolute(112)))));
		bootstrapContextIn.register(TechnologicaPlacedFeatures.ORE_MOLYBDENITE_PLACED, new PlacedFeature(oreMolybdenite, commonOrePlacement(16, HeightRangePlacement.triangle(VerticalAnchor.absolute(-16), VerticalAnchor.absolute(112)))));
		bootstrapContextIn.register(TechnologicaPlacedFeatures.ORE_PENTLANDITE_PLACED, new PlacedFeature(orePentlandite, commonOrePlacement(10, HeightRangePlacement.triangle(VerticalAnchor.absolute(-24), VerticalAnchor.absolute(56)))));
		bootstrapContextIn.register(TechnologicaPlacedFeatures.ORE_ARGENTITE_PLACED, new PlacedFeature(oreArgentite, commonOrePlacement(10, HeightRangePlacement.uniform(VerticalAnchor.absolute(-64), VerticalAnchor.absolute(32)))));
		bootstrapContextIn.register(TechnologicaPlacedFeatures.ORE_GALENA_PLACED, new PlacedFeature(oreGalena, commonOrePlacement(16, HeightRangePlacement.triangle(VerticalAnchor.absolute(-16), VerticalAnchor.absolute(112)))));
		bootstrapContextIn.register(TechnologicaPlacedFeatures.ORE_SYLVANITE_PLACED, new PlacedFeature(oreSylvanite, commonOrePlacement(10, HeightRangePlacement.uniform(VerticalAnchor.absolute(-64), VerticalAnchor.absolute(32)))));
		bootstrapContextIn.register(TechnologicaPlacedFeatures.ORE_CASSITERITE_PLACED, new PlacedFeature(oreCassiterite, commonOrePlacement(10, HeightRangePlacement.uniform(VerticalAnchor.absolute(0), VerticalAnchor.top()))));
		bootstrapContextIn.register(TechnologicaPlacedFeatures.ORE_WOLFRAMITE_PLACED, new PlacedFeature(oreWolframite, commonOrePlacement(16, HeightRangePlacement.triangle(VerticalAnchor.absolute(-16), VerticalAnchor.absolute(112)))));
		bootstrapContextIn.register(TechnologicaPlacedFeatures.ORE_OSMIRIDIUM_PLACED, new PlacedFeature(oreOsmiridium, commonOrePlacement(10, HeightRangePlacement.uniform(VerticalAnchor.absolute(-64), VerticalAnchor.absolute(32)))));
		bootstrapContextIn.register(TechnologicaPlacedFeatures.ORE_PLATINUM_PLACED, new PlacedFeature(orePlatinum, commonOrePlacement(4, HeightRangePlacement.triangle(VerticalAnchor.absolute(-64), VerticalAnchor.absolute(32)))));
		bootstrapContextIn.register(TechnologicaPlacedFeatures.ORE_CINNABAR_PLACED, new PlacedFeature(oreCinnabar, commonOrePlacement(4, HeightRangePlacement.uniform(VerticalAnchor.bottom(), VerticalAnchor.absolute(15)))));
		bootstrapContextIn.register(TechnologicaPlacedFeatures.ORE_THORIANITE_PLACED, new PlacedFeature(oreThorianite, commonOrePlacement(4, HeightRangePlacement.uniform(VerticalAnchor.bottom(), VerticalAnchor.absolute(15)))));
		bootstrapContextIn.register(TechnologicaPlacedFeatures.ORE_URANINITE_PLACED, new PlacedFeature(oreUraninite, commonOrePlacement(4, HeightRangePlacement.uniform(VerticalAnchor.bottom(), VerticalAnchor.absolute(15)))));
		bootstrapContextIn.register(TechnologicaPlacedFeatures.ORE_EMERALD_PLACED, new PlacedFeature(oreEmerald, commonOrePlacement(100, HeightRangePlacement.triangle(VerticalAnchor.absolute(-16), VerticalAnchor.absolute(480)))));
		bootstrapContextIn.register(TechnologicaPlacedFeatures.ORE_RUBY_PLACED, new PlacedFeature(oreRuby, commonOrePlacement(100, HeightRangePlacement.triangle(VerticalAnchor.absolute(-16), VerticalAnchor.absolute(480)))));
		bootstrapContextIn.register(TechnologicaPlacedFeatures.ORE_SAPPHIRE_PLACED, new PlacedFeature(oreSapphire, commonOrePlacement(100, HeightRangePlacement.triangle(VerticalAnchor.absolute(-16), VerticalAnchor.absolute(480)))));
		bootstrapContextIn.register(TechnologicaPlacedFeatures.ORE_TOPAZ_PLACED, new PlacedFeature(oreTopaz, commonOrePlacement(100, HeightRangePlacement.triangle(VerticalAnchor.absolute(-16), VerticalAnchor.absolute(480)))));
		
		/*
		 * TREE
		 */
		
		bootstrapContextIn.register(TechnologicaPlacedFeatures.APRICOT_CHECKED, new PlacedFeature(holder, treePlacement(PlacementUtils.filteredByBlockSurvival(TechnologicaBlocks.APRICOT_SAPLING.get()))));
		bootstrapContextIn.register(TechnologicaPlacedFeatures.ASPEN_CHECKED, new PlacedFeature(holder1, treePlacement(PlacementUtils.filteredByBlockSurvival(TechnologicaBlocks.ASPEN_SAPLING.get()))));
		bootstrapContextIn.register(TechnologicaPlacedFeatures.AVOCADO_CHECKED, new PlacedFeature(holder2, treePlacement(PlacementUtils.filteredByBlockSurvival(TechnologicaBlocks.AVOCADO_SAPLING.get()))));
		bootstrapContextIn.register(TechnologicaPlacedFeatures.BANANA_CHECKED, new PlacedFeature(holder3, treePlacement(PlacementUtils.filteredByBlockSurvival(TechnologicaBlocks.BANANA_SAPLING.get()))));
		bootstrapContextIn.register(TechnologicaPlacedFeatures.CHERRY_CHECKED, new PlacedFeature(holder4, treePlacement(PlacementUtils.filteredByBlockSurvival(TechnologicaBlocks.CHERRY_SAPLING.get()))));
		bootstrapContextIn.register(TechnologicaPlacedFeatures.CHESTNUT_CHECKED, new PlacedFeature(holder5, treePlacement(PlacementUtils.filteredByBlockSurvival(TechnologicaBlocks.CHESTNUT_SAPLING.get()))));
		bootstrapContextIn.register(TechnologicaPlacedFeatures.CINNAMON_CHECKED, new PlacedFeature(holder6, treePlacement(PlacementUtils.filteredByBlockSurvival(TechnologicaBlocks.CINNAMON_SAPLING.get()))));
		bootstrapContextIn.register(TechnologicaPlacedFeatures.COCONUT_CHECKED, new PlacedFeature(holder7, treePlacement(PlacementUtils.filteredByBlockSurvival(TechnologicaBlocks.COCONUT_SAPLING.get()))));
		bootstrapContextIn.register(TechnologicaPlacedFeatures.EBONY_CHECKED, new PlacedFeature(holder8, treePlacement(PlacementUtils.filteredByBlockSurvival(TechnologicaBlocks.EBONY_SAPLING.get()))));
		bootstrapContextIn.register(TechnologicaPlacedFeatures.KIWI_CHECKED, new PlacedFeature(holder9, treePlacement(PlacementUtils.filteredByBlockSurvival(TechnologicaBlocks.KIWI_SAPLING.get()))));
		bootstrapContextIn.register(TechnologicaPlacedFeatures.LEMON_CHECKED, new PlacedFeature(holder10, treePlacement(PlacementUtils.filteredByBlockSurvival(TechnologicaBlocks.LEMON_SAPLING.get()))));
		bootstrapContextIn.register(TechnologicaPlacedFeatures.LIME_CHECKED, new PlacedFeature(holder11, treePlacement(PlacementUtils.filteredByBlockSurvival(TechnologicaBlocks.LIME_SAPLING.get()))));
		bootstrapContextIn.register(TechnologicaPlacedFeatures.MAHOGANY_CHECKED, new PlacedFeature(holder12, treePlacement(PlacementUtils.filteredByBlockSurvival(TechnologicaBlocks.MAHOGANY_SAPLING.get()))));
		bootstrapContextIn.register(TechnologicaPlacedFeatures.MAPLE_CHECKED, new PlacedFeature(holder13, treePlacement(PlacementUtils.filteredByBlockSurvival(TechnologicaBlocks.MAPLE_SAPLING.get()))));
		bootstrapContextIn.register(TechnologicaPlacedFeatures.OLIVE_CHECKED, new PlacedFeature(holder14, treePlacement(PlacementUtils.filteredByBlockSurvival(TechnologicaBlocks.OLIVE_SAPLING.get()))));
		bootstrapContextIn.register(TechnologicaPlacedFeatures.ORANGE_CHECKED, new PlacedFeature(holder15, treePlacement(PlacementUtils.filteredByBlockSurvival(TechnologicaBlocks.ORANGE_SAPLING.get()))));
		bootstrapContextIn.register(TechnologicaPlacedFeatures.PEACH_CHECKED, new PlacedFeature(holder16, treePlacement(PlacementUtils.filteredByBlockSurvival(TechnologicaBlocks.PEACH_SAPLING.get()))));
		bootstrapContextIn.register(TechnologicaPlacedFeatures.PEAR_CHECKED, new PlacedFeature(holder17, treePlacement(PlacementUtils.filteredByBlockSurvival(TechnologicaBlocks.PEAR_SAPLING.get()))));
		bootstrapContextIn.register(TechnologicaPlacedFeatures.PLUM_CHECKED, new PlacedFeature(holder18, treePlacement(PlacementUtils.filteredByBlockSurvival(TechnologicaBlocks.PLUM_SAPLING.get()))));
		// bootstrapContextIn.register(TechnologicaPlacedFeatures.REDWOOD_CHECKED, new PlacedFeature(holder19, treePlacement(PlacementUtils.filteredByBlockSurvival(TechnologicaBlocks.REDWOOD_SAPLING.get()))));
		bootstrapContextIn.register(TechnologicaPlacedFeatures.ROSEWOOD_CHECKED, new PlacedFeature(holder20, treePlacement(PlacementUtils.filteredByBlockSurvival(TechnologicaBlocks.ROSEWOOD_SAPLING.get()))));
		bootstrapContextIn.register(TechnologicaPlacedFeatures.RUBBER_CHECKED, new PlacedFeature(holder21, treePlacement(PlacementUtils.filteredByBlockSurvival(TechnologicaBlocks.RUBBER_SAPLING.get()))));
		bootstrapContextIn.register(TechnologicaPlacedFeatures.TEAK_CHECKED, new PlacedFeature(holder22, treePlacement(PlacementUtils.filteredByBlockSurvival(TechnologicaBlocks.TEAK_SAPLING.get()))));
		bootstrapContextIn.register(TechnologicaPlacedFeatures.WALNUT_CHECKED, new PlacedFeature(holder23, treePlacement(PlacementUtils.filteredByBlockSurvival(TechnologicaBlocks.WALNUT_SAPLING.get()))));
		bootstrapContextIn.register(TechnologicaPlacedFeatures.ZEBRAWOOD_CHECKED, new PlacedFeature(holder24, treePlacement(PlacementUtils.filteredByBlockSurvival(TechnologicaBlocks.ZEBRAWOOD_SAPLING.get()))));
		bootstrapContextIn.register(TechnologicaPlacedFeatures.ANCIENT_AMBROSIA_CHECKED, new PlacedFeature(holder25, treePlacement(PlacementUtils.filteredByBlockSurvival(TechnologicaBlocks.ANCIENT_AMBROSIA_SAPLING.get()))));
		bootstrapContextIn.register(TechnologicaPlacedFeatures.BENEVOLENT_APOTHECARY_CHECKED, new PlacedFeature(holder26, treePlacement(PlacementUtils.filteredByBlockSurvival(TechnologicaBlocks.BENEVOLENT_APOTHECARY_SAPLING.get()))));
		bootstrapContextIn.register(TechnologicaPlacedFeatures.CRYOGENIC_SPIRE_CHECKED, new PlacedFeature(holder27, treePlacement(PlacementUtils.filteredByBlockSurvival(TechnologicaBlocks.CRYOGENIC_SPIRE_SAPLING.get()))));
		bootstrapContextIn.register(TechnologicaPlacedFeatures.MALEVOLENT_APOTHECARY_CHECKED, new PlacedFeature(holder28, treePlacement(PlacementUtils.filteredByBlockSurvival(TechnologicaBlocks.MALEVOLENT_APOTHECARY_SAPLING.get()))));
		bootstrapContextIn.register(TechnologicaPlacedFeatures.NECROTIC_CHECKED, new PlacedFeature(holder29, treePlacement(PlacementUtils.filteredByBlockSurvival(TechnologicaBlocks.NECROTIC_SAPLING.get()))));
		bootstrapContextIn.register(TechnologicaPlacedFeatures.SERENDIPITOUS_APOTHECARY_CHECKED, new PlacedFeature(holder30, treePlacement(PlacementUtils.filteredByBlockSurvival(TechnologicaBlocks.SERENDIPITOUS_APOTHECARY_SAPLING.get()))));
		bootstrapContextIn.register(TechnologicaPlacedFeatures.THUNDEROUS_CONDUCTOR_CHECKED, new PlacedFeature(holder31, treePlacement(PlacementUtils.filteredByBlockSurvival(TechnologicaBlocks.THUNDEROUS_CONDUCTOR_SAPLING.get()))));
		bootstrapContextIn.register(TechnologicaPlacedFeatures.TOWERING_INFERNO_CHECKED, new PlacedFeature(holder32, treePlacement(PlacementUtils.filteredByBlockSurvival(TechnologicaBlocks.TOWERING_INFERNO_SAPLING.get()))));
		bootstrapContextIn.register(TechnologicaPlacedFeatures.OVERGROWTH_CHECKED, new PlacedFeature(holder33, List.of()));
		
		/*
		 * VEGETATION
		 */
		
		bootstrapContextIn.register(TechnologicaPlacedFeatures.TREES_MODIFIED_SAVANNA_PLACED, new PlacedFeature(treesModifiedSavanna, vegetationPlacement(PlacementUtils.countExtra(1, 0.1F, 1))));
		bootstrapContextIn.register(TechnologicaPlacedFeatures.TREES_MODIFIED_JUNGLE_PLACED, new PlacedFeature(treesModifiedJungle, vegetationPlacement(PlacementUtils.countExtra(1, 0.1F, 1))));
		bootstrapContextIn.register(TechnologicaPlacedFeatures.TREES_MODIFIED_JUNGLE_EDGE_PLACED, new PlacedFeature(treesModifiedJungleEdge, vegetationPlacement(PlacementUtils.countExtra(1, 0.1F, 1))));
		bootstrapContextIn.register(TechnologicaPlacedFeatures.TREES_MODIFIED_BAMBOO_JUNGLE_PLACED, new PlacedFeature(treesModifiedBambooJungle, vegetationPlacement(PlacementUtils.countExtra(1, 0.1F, 1))));
		bootstrapContextIn.register(TechnologicaPlacedFeatures.TREES_MODIFIED_FOREST_PLACED, new PlacedFeature(treesModifiedForest, vegetationPlacement(PlacementUtils.countExtra(1, 0.1F, 1))));
		bootstrapContextIn.register(TechnologicaPlacedFeatures.TREES_MODIFIED_BIRCH_FOREST_PLACED, new PlacedFeature(treesModifiedBirchForest, vegetationPlacement(PlacementUtils.countExtra(1, 0.1F, 1))));
		bootstrapContextIn.register(TechnologicaPlacedFeatures.TREES_MODIFIED_WOODED_HILLS_PLACED, new PlacedFeature(treesModifiedWoodedHills, vegetationPlacement(PlacementUtils.countExtra(1, 0.1F, 1))));
		bootstrapContextIn.register(TechnologicaPlacedFeatures.TREES_MODIFIED_BEACH_PLACED, new PlacedFeature(treesModifiedBeach, vegetationPlacement(PlacementUtils.countExtra(1, 0.1F, 1))));
		bootstrapContextIn.register(TechnologicaPlacedFeatures.TREES_MODIFIED_TAIGA_PLACED, new PlacedFeature(treesModifiedTaiga, vegetationPlacement(PlacementUtils.countExtra(1, 0.1F, 1))));
		bootstrapContextIn.register(TechnologicaPlacedFeatures.TREES_MODIFIED_SNOWY_TAIGA_PLACED, new PlacedFeature(treesModifiedSnowyTaiga, vegetationPlacement(PlacementUtils.countExtra(1, 0.1F, 1))));
		bootstrapContextIn.register(TechnologicaPlacedFeatures.TREES_MODIFIED_SWAMP_PLACED, new PlacedFeature(treesModifiedSwamp, vegetationPlacement(PlacementUtils.countExtra(1, 0.1F, 1))));
		bootstrapContextIn.register(TechnologicaPlacedFeatures.PATCH_BLACKBERRY_COMMON_PLACED, new PlacedFeature(patchBlackberryBush, List.of(RarityFilter.onAverageOnceEvery(32), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP_WORLD_SURFACE, BiomeFilter.biome())));
		bootstrapContextIn.register(TechnologicaPlacedFeatures.PATCH_BLACKBERRY_RARE_PLACED, new PlacedFeature(patchBlackberryBush, List.of(RarityFilter.onAverageOnceEvery(384), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP_WORLD_SURFACE, BiomeFilter.biome())));
		bootstrapContextIn.register(TechnologicaPlacedFeatures.PATCH_BLUEBERRY_COMMON_PLACED, new PlacedFeature(patchBlueberryBush, List.of(RarityFilter.onAverageOnceEvery(32), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP_WORLD_SURFACE, BiomeFilter.biome())));
		bootstrapContextIn.register(TechnologicaPlacedFeatures.PATCH_BLUEBERRY_RARE_PLACED, new PlacedFeature(patchBlueberryBush, List.of(RarityFilter.onAverageOnceEvery(384), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP_WORLD_SURFACE, BiomeFilter.biome())));
		bootstrapContextIn.register(TechnologicaPlacedFeatures.PATCH_RASPBERRY_COMMON_PLACED, new PlacedFeature(patchRaspberryBush, List.of(RarityFilter.onAverageOnceEvery(32), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP_WORLD_SURFACE, BiomeFilter.biome())));
		bootstrapContextIn.register(TechnologicaPlacedFeatures.PATCH_RASPBERRY_RARE_PLACED, new PlacedFeature(patchRaspberryBush, List.of(RarityFilter.onAverageOnceEvery(384), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP_WORLD_SURFACE, BiomeFilter.biome())));
		bootstrapContextIn.register(TechnologicaPlacedFeatures.PATCH_STRAWBERRY_COMMON_PLACED, new PlacedFeature(patchStrawberryBush, List.of(RarityFilter.onAverageOnceEvery(32), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP_WORLD_SURFACE, BiomeFilter.biome())));
		bootstrapContextIn.register(TechnologicaPlacedFeatures.PATCH_STRAWBERRY_RARE_PLACED, new PlacedFeature(patchStrawberryBush, List.of(RarityFilter.onAverageOnceEvery(384), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP_WORLD_SURFACE, BiomeFilter.biome())));
		bootstrapContextIn.register(TechnologicaPlacedFeatures.PATCH_COTTON_PLACED, new PlacedFeature(patchCottonBush, List.of(RarityFilter.onAverageOnceEvery(32), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP_WORLD_SURFACE, BiomeFilter.biome())));
		bootstrapContextIn.register(TechnologicaPlacedFeatures.PATCH_PEPPERCORNS_PLACED, new PlacedFeature(patchPeppercornBush, List.of(RarityFilter.onAverageOnceEvery(5), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP_WORLD_SURFACE, BiomeFilter.biome())));
		bootstrapContextIn.register(TechnologicaPlacedFeatures.OVERGROWTH_PLACED, new PlacedFeature(mangroveVegetation, List.of(CountOnEveryLayerPlacement.of(6), BiomeFilter.biome())));
	}
	
	private static List<PlacementModifier> commonOrePlacement(int p_195344_, PlacementModifier p_195345_) {
		return orePlacement(CountPlacement.of(p_195344_), p_195345_);
	}
	
	private static List<PlacementModifier> orePlacement(PlacementModifier p_195347_, PlacementModifier p_195348_) {
		return List.of(p_195347_, InSquarePlacement.spread(), p_195348_, BiomeFilter.biome());
	}

	private static List<PlacementModifier> treePlacement(PlacementModifier p_195345_) {
		return List.of(p_195345_);
	}
	
	private static ImmutableList.Builder<PlacementModifier> treePlacementBase(PlacementModifier p_195485_) {
		return ImmutableList.<PlacementModifier>builder().add(p_195485_).add(InSquarePlacement.spread()).add(TREE_THRESHOLD).add(PlacementUtils.HEIGHTMAP_OCEAN_FLOOR).add(BiomeFilter.biome());
	}

	public static List<PlacementModifier> vegetationPlacement(PlacementModifier p_195480_) {
		return treePlacementBase(p_195480_).build();
	}
}
