package com.technologica.registration.key;

import com.technologica.registration.key.util.MasterKeyCreator;
import com.technologica.resourcegen.data.worldgen.configuredfeature.ConfiguredFeatureProvider;

import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;

/**
 * <p>
 * This class contains Resource Keys for Configured Features.
 * The corresponding Configured Features are created in json format during Data Generation in {@link ConfiguredFeatureProvider}.
 * </p>
 * 
 * @tl.status GREEN
 */
public final class TechnologicaConfiguredFeatures extends MasterKeyCreator {
	
	/*
	 * MISC
	 */
	
	public static final ResourceKey<ConfiguredFeature<?, ?>> BRINE_POOL_CONFIGURED = configuredFeature("brine_pool");
	public static final ResourceKey<ConfiguredFeature<?, ?>> OASIS_CONFIGURED = configuredFeature("oasis");
	
	/*
	 * ORE
	 */
	
	public static final ResourceKey<ConfiguredFeature<?, ?>> ORE_SPODUMENE = configuredFeature("ore_spodumene");
	public static final ResourceKey<ConfiguredFeature<?, ?>> ORE_BORAX = configuredFeature("ore_borax");
	public static final ResourceKey<ConfiguredFeature<?, ?>> ORE_MAGNESITE = configuredFeature("ore_magnesite");
	public static final ResourceKey<ConfiguredFeature<?, ?>> ORE_BAUXITE = configuredFeature("ore_bauxite");
	public static final ResourceKey<ConfiguredFeature<?, ?>> ORE_APATITE = configuredFeature("ore_apatite");
	public static final ResourceKey<ConfiguredFeature<?, ?>> ORE_PHOSPHORITE = configuredFeature("ore_phosphorite");
	public static final ResourceKey<ConfiguredFeature<?, ?>> ORE_GADOLINITE = configuredFeature("ore_gadolinite");
	public static final ResourceKey<ConfiguredFeature<?, ?>> ORE_ILMENITE = configuredFeature("ore_ilmenite");
	public static final ResourceKey<ConfiguredFeature<?, ?>> ORE_PATRONITE = configuredFeature("ore_patronite");
	public static final ResourceKey<ConfiguredFeature<?, ?>> ORE_CHROMITE = configuredFeature("ore_chromite");
	public static final ResourceKey<ConfiguredFeature<?, ?>> ORE_PYROLUSITE = configuredFeature("ore_pyrolusite");
	public static final ResourceKey<ConfiguredFeature<?, ?>> ORE_COBALTITE = configuredFeature("ore_cobaltite");
	public static final ResourceKey<ConfiguredFeature<?, ?>> ORE_GARNIERITE = configuredFeature("ore_garnierite");
	public static final ResourceKey<ConfiguredFeature<?, ?>> ORE_ARSENOPYRITE = configuredFeature("ore_arsenopyrite");
	public static final ResourceKey<ConfiguredFeature<?, ?>> ORE_CROOKESITE = configuredFeature("ore_crookesite");
	public static final ResourceKey<ConfiguredFeature<?, ?>> ORE_LEPIDOLITE = configuredFeature("ore_lepidolite");
	public static final ResourceKey<ConfiguredFeature<?, ?>> ORE_BASTNAESITE = configuredFeature("ore_bastnaesite");
	public static final ResourceKey<ConfiguredFeature<?, ?>> ORE_TANTALITE = configuredFeature("ore_tantalite");
	public static final ResourceKey<ConfiguredFeature<?, ?>> ORE_MOLYBDENITE = configuredFeature("ore_molybdenite");
	public static final ResourceKey<ConfiguredFeature<?, ?>> ORE_PENTLANDITE = configuredFeature("ore_pentlandite");
	public static final ResourceKey<ConfiguredFeature<?, ?>> ORE_ARGENTITE = configuredFeature("ore_argentite");
	public static final ResourceKey<ConfiguredFeature<?, ?>> ORE_GALENA = configuredFeature("ore_galena");
	public static final ResourceKey<ConfiguredFeature<?, ?>> ORE_SYLVANITE = configuredFeature("ore_sylvanite");
	public static final ResourceKey<ConfiguredFeature<?, ?>> ORE_CASSITERITE = configuredFeature("ore_cassiterite");
	public static final ResourceKey<ConfiguredFeature<?, ?>> ORE_WOLFRAMITE = configuredFeature("ore_wolframite");
	public static final ResourceKey<ConfiguredFeature<?, ?>> ORE_OSMIRIDIUM = configuredFeature("ore_osmiridium");
	public static final ResourceKey<ConfiguredFeature<?, ?>> ORE_PLATINUM = configuredFeature("ore_platinum");
	public static final ResourceKey<ConfiguredFeature<?, ?>> ORE_CINNABAR = configuredFeature("ore_cinnabar");
	public static final ResourceKey<ConfiguredFeature<?, ?>> ORE_THORIANITE = configuredFeature("ore_thorianite");
	public static final ResourceKey<ConfiguredFeature<?, ?>> ORE_URANINITE = configuredFeature("ore_uraninite");
	public static final ResourceKey<ConfiguredFeature<?, ?>> ORE_EMERALD = configuredFeature("ore_emerald");
	public static final ResourceKey<ConfiguredFeature<?, ?>> ORE_RUBY = configuredFeature("ore_ruby");
	public static final ResourceKey<ConfiguredFeature<?, ?>> ORE_SAPPHIRE = configuredFeature("ore_sapphire");
	public static final ResourceKey<ConfiguredFeature<?, ?>> ORE_TOPAZ = configuredFeature("ore_topaz");
	
	/*
	 * TREE
	 */
	
	public static final ResourceKey<ConfiguredFeature<?, ?>> APRICOT = configuredFeature("apricot");
	public static final ResourceKey<ConfiguredFeature<?, ?>> ASPEN = configuredFeature("aspen");
	public static final ResourceKey<ConfiguredFeature<?, ?>> AVOCADO = configuredFeature("avocado");
	public static final ResourceKey<ConfiguredFeature<?, ?>> BANANA = configuredFeature("banana");
	public static final ResourceKey<ConfiguredFeature<?, ?>> CHERRY = configuredFeature("cherry");
	public static final ResourceKey<ConfiguredFeature<?, ?>> CHESTNUT = configuredFeature("chestnut");
	public static final ResourceKey<ConfiguredFeature<?, ?>> CINNAMON = configuredFeature("cinnamon");
	public static final ResourceKey<ConfiguredFeature<?, ?>> COCONUT = configuredFeature("coconut");
	public static final ResourceKey<ConfiguredFeature<?, ?>> EBONY = configuredFeature("ebony");
	public static final ResourceKey<ConfiguredFeature<?, ?>> KIWI = configuredFeature("kiwi");
	public static final ResourceKey<ConfiguredFeature<?, ?>> LEMON = configuredFeature("lemon");
	public static final ResourceKey<ConfiguredFeature<?, ?>> LIME = configuredFeature("lime");
	public static final ResourceKey<ConfiguredFeature<?, ?>> MAHOGANY = configuredFeature("mahogany");
	public static final ResourceKey<ConfiguredFeature<?, ?>> MAPLE = configuredFeature("maple");
	public static final ResourceKey<ConfiguredFeature<?, ?>> OLIVE = configuredFeature("olive");
	public static final ResourceKey<ConfiguredFeature<?, ?>> ORANGE = configuredFeature("orange");
	public static final ResourceKey<ConfiguredFeature<?, ?>> PEACH = configuredFeature("peach");
	public static final ResourceKey<ConfiguredFeature<?, ?>> PEAR = configuredFeature("pear");
	public static final ResourceKey<ConfiguredFeature<?, ?>> PLUM = configuredFeature("plum");
	public static final ResourceKey<ConfiguredFeature<?, ?>> REDWOOD = configuredFeature("redwood");
	public static final ResourceKey<ConfiguredFeature<?, ?>> ROSEWOOD = configuredFeature("rosewood");
	public static final ResourceKey<ConfiguredFeature<?, ?>> RUBBER = configuredFeature("rubber");
	public static final ResourceKey<ConfiguredFeature<?, ?>> TEAK = configuredFeature("teak");
	public static final ResourceKey<ConfiguredFeature<?, ?>> WALNUT = configuredFeature("walnut");
	public static final ResourceKey<ConfiguredFeature<?, ?>> ZEBRAWOOD = configuredFeature("zebrawood");
	public static final ResourceKey<ConfiguredFeature<?, ?>> ANCIENT_AMBROSIA = configuredFeature("ancient_ambrosia");
	public static final ResourceKey<ConfiguredFeature<?, ?>> BENEVOLENT_APOTHECARY = configuredFeature("benevolent_apothecary");
	public static final ResourceKey<ConfiguredFeature<?, ?>> CRYOGENIC_SPIRE = configuredFeature("cryogenic_spire");
	public static final ResourceKey<ConfiguredFeature<?, ?>> MALEVOLENT_APOTHECARY = configuredFeature("malevolent_apothecary");
	public static final ResourceKey<ConfiguredFeature<?, ?>> NECROTIC = configuredFeature("necrotic");
	public static final ResourceKey<ConfiguredFeature<?, ?>> SERENDIPITOUS_APOTHECARY = configuredFeature("serendipitous_apothecary");
	public static final ResourceKey<ConfiguredFeature<?, ?>> THUNDEROUS_CONDUCTOR = configuredFeature("thunderous_conductor");
	public static final ResourceKey<ConfiguredFeature<?, ?>> TOWERING_INFERNO = configuredFeature("towering_inferno");
	
	/*
	 * VEGETATION
	 */
	
	public static final ResourceKey<ConfiguredFeature<?, ?>> TREES_MODIFIED_JUNGLE = configuredFeature("trees_modified_savanna");
	public static final ResourceKey<ConfiguredFeature<?, ?>> TREES_MODIFIED_SAVANNA = configuredFeature("trees_modified_jungle");
	public static final ResourceKey<ConfiguredFeature<?, ?>> TREES_MODIFIED_JUNGLE_EDGE = configuredFeature("trees_modified_jungle_edge");
	public static final ResourceKey<ConfiguredFeature<?, ?>> TREES_MODIFIED_BAMBOO_JUNGLE = configuredFeature("trees_modified_bamboo_jungle");
	public static final ResourceKey<ConfiguredFeature<?, ?>> TREES_MODIFIED_FOREST = configuredFeature("trees_modified_forest");
	public static final ResourceKey<ConfiguredFeature<?, ?>> TREES_MODIFIED_BIRCH_FOREST = configuredFeature("trees_modified_birch_forest");
	public static final ResourceKey<ConfiguredFeature<?, ?>> TREES_MODIFIED_WOODED_HILLS = configuredFeature("trees_modified_wooded_hills");
	public static final ResourceKey<ConfiguredFeature<?, ?>> TREES_MODIFIED_BEACH = configuredFeature("trees_modified_beach");
	public static final ResourceKey<ConfiguredFeature<?, ?>> TREES_MODIFIED_TAIGA = configuredFeature("trees_modified_taiga");
	public static final ResourceKey<ConfiguredFeature<?, ?>> TREES_MODIFIED_SNOWY_TAIGA = configuredFeature("trees_modified_snowy_taiga");
	public static final ResourceKey<ConfiguredFeature<?, ?>> TREES_MODIFIED_SWAMP = configuredFeature("trees_modified_swamp");
	public static final ResourceKey<ConfiguredFeature<?, ?>> PATCH_BLACKBERRY_BUSH = configuredFeature("patch_blackberry_bush");
	public static final ResourceKey<ConfiguredFeature<?, ?>> PATCH_BLUEBERRY_BUSH = configuredFeature("patch_blueberry_bush");
	public static final ResourceKey<ConfiguredFeature<?, ?>> PATCH_RASPBERRY_BUSH = configuredFeature("patch_raspberry_bush");
	public static final ResourceKey<ConfiguredFeature<?, ?>> PATCH_STRAWBERRY_BUSH = configuredFeature("patch_strawberry_bush");
	public static final ResourceKey<ConfiguredFeature<?, ?>> PATCH_COTTON_BUSH = configuredFeature("patch_cotton_bush");
	public static final ResourceKey<ConfiguredFeature<?, ?>> PATCH_PEPPERCORN_BUSH = configuredFeature("patch_peppercorn_bush");
}