package com.technologica.registration.key;

import com.technologica.registration.key.util.MasterKeyCreator;
import com.technologica.resourcegen.data.worldgen.placedfeature.PlacedFeatureProvider;

import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;

/**
 * <p>
 * This class contains Resource Keys for Placed Features.
 * The corresponding Placed Features are created in json format during Data Generation in {@link PlacedFeatureProvider}.
 * </p>
 * 
 * @tl.status YELLOW
 */
public final class TechnologicaPlacedFeatures extends MasterKeyCreator {
	
	/*
	 * MISC
	 */
	
	public static final ResourceKey<PlacedFeature> BRINE_POOL_PLACED = placedFeature("brine_pool");
	public static final ResourceKey<PlacedFeature> OASIS_PLACED = placedFeature("oasis");
	
	//TODO: Can't remember why I left these here.  Surely I had a reason for keeping them.
	// public static final ResourceKey<PlacedFeature> PATCH_BLACKBERRY_BUSH_VILLAGE = placedFeature("patch_blackberry_bush");
	// public static final ResourceKey<PlacedFeature> PATCH_BLUEBERRY_BUSH_VILLAGE = placedFeature("patch_blueberry_bush");
	// public static final ResourceKey<PlacedFeature> PATCH_RASPBERRY_BUSH_VILLAGE = placedFeature("patch_raspberry_bush");
	// public static final ResourceKey<PlacedFeature> PATCH_STRAWBERRY_BUSH_VILLAGE = placedFeature("patch_strawberry_bush");
	
	/*
	 * ORE
	 */
	
	public static final ResourceKey<PlacedFeature> ORE_SPODUMENE_PLACED = placedFeature("ore_spodumene");
	public static final ResourceKey<PlacedFeature> ORE_BORAX_PLACED = placedFeature("ore_borax");
	public static final ResourceKey<PlacedFeature> ORE_MAGNESITE_PLACED = placedFeature("ore_magnesite");
	public static final ResourceKey<PlacedFeature> ORE_BAUXITE_PLACED = placedFeature("ore_bauxite");
	public static final ResourceKey<PlacedFeature> ORE_APATITE_PLACED = placedFeature("ore_apatite");
	public static final ResourceKey<PlacedFeature> ORE_PHOSPHORITE_PLACED = placedFeature("ore_phosphorite");
	public static final ResourceKey<PlacedFeature> ORE_GADOLINITE_PLACED = placedFeature("ore_gadolinite");
	public static final ResourceKey<PlacedFeature> ORE_ILMENITE_PLACED = placedFeature("ore_ilmenite");
	public static final ResourceKey<PlacedFeature> ORE_PATRONITE_PLACED = placedFeature("ore_patronite");
	public static final ResourceKey<PlacedFeature> ORE_CHROMITE_PLACED = placedFeature("ore_chromite");
	public static final ResourceKey<PlacedFeature> ORE_PYROLUSITE_PLACED = placedFeature("ore_pyrolusite");
	public static final ResourceKey<PlacedFeature> ORE_COBALTITE_PLACED = placedFeature("ore_cobaltite");
	public static final ResourceKey<PlacedFeature> ORE_GARNIERITE_PLACED = placedFeature("ore_garnierite");
	public static final ResourceKey<PlacedFeature> ORE_ARSENOPYRITE_PLACED = placedFeature("ore_arsenopyrite");
	public static final ResourceKey<PlacedFeature> ORE_CROOKESITE_PLACED = placedFeature("ore_crookesite");
	public static final ResourceKey<PlacedFeature> ORE_LEPIDOLITE_PLACED = placedFeature("ore_lepidolite");
	public static final ResourceKey<PlacedFeature> ORE_BASTNAESITE_PLACED = placedFeature("ore_bastnaesite");
	public static final ResourceKey<PlacedFeature> ORE_TANTALITE_PLACED = placedFeature("ore_tantalite");
	public static final ResourceKey<PlacedFeature> ORE_MOLYBDENITE_PLACED = placedFeature("ore_molybdenite");
	public static final ResourceKey<PlacedFeature> ORE_PENTLANDITE_PLACED = placedFeature("ore_pentlandite");
	public static final ResourceKey<PlacedFeature> ORE_ARGENTITE_PLACED = placedFeature("ore_argentite");
	public static final ResourceKey<PlacedFeature> ORE_GALENA_PLACED = placedFeature("ore_galena");
	public static final ResourceKey<PlacedFeature> ORE_SYLVANITE_PLACED = placedFeature("ore_sylvanite");
	public static final ResourceKey<PlacedFeature> ORE_CASSITERITE_PLACED = placedFeature("ore_cassiterite");
	public static final ResourceKey<PlacedFeature> ORE_WOLFRAMITE_PLACED = placedFeature("ore_wolframite");
	public static final ResourceKey<PlacedFeature> ORE_OSMIRIDIUM_PLACED = placedFeature("ore_osmiridium");
	public static final ResourceKey<PlacedFeature> ORE_PLATINUM_PLACED = placedFeature("ore_platinum");
	public static final ResourceKey<PlacedFeature> ORE_CINNABAR_PLACED = placedFeature("ore_cinnabar");
	public static final ResourceKey<PlacedFeature> ORE_THORIANITE_PLACED = placedFeature("ore_thorianite");
	public static final ResourceKey<PlacedFeature> ORE_URANINITE_PLACED = placedFeature("ore_uraninite");
	public static final ResourceKey<PlacedFeature> ORE_EMERALD_PLACED = placedFeature("ore_emerald");
	public static final ResourceKey<PlacedFeature> ORE_RUBY_PLACED = placedFeature("ore_ruby");
	public static final ResourceKey<PlacedFeature> ORE_SAPPHIRE_PLACED = placedFeature("ore_sapphire");
	public static final ResourceKey<PlacedFeature> ORE_TOPAZ_PLACED = placedFeature("ore_topaz");
	
	/*
	 * TREE
	 */
	
	public static final ResourceKey<PlacedFeature> APRICOT_CHECKED = placedFeature("apricot_checked");
	public static final ResourceKey<PlacedFeature> ASPEN_CHECKED = placedFeature("aspen_checked");
	public static final ResourceKey<PlacedFeature> AVOCADO_CHECKED = placedFeature("avocado_checked");
	public static final ResourceKey<PlacedFeature> BANANA_CHECKED = placedFeature("banana_checked");
	public static final ResourceKey<PlacedFeature> CHERRY_CHECKED = placedFeature("cherry_checked");
	public static final ResourceKey<PlacedFeature> CHESTNUT_CHECKED = placedFeature("chestnut_checked");
	public static final ResourceKey<PlacedFeature> CINNAMON_CHECKED = placedFeature("cinnamon_checked");
	public static final ResourceKey<PlacedFeature> COCONUT_CHECKED = placedFeature("coconut_checked");
	public static final ResourceKey<PlacedFeature> EBONY_CHECKED = placedFeature("ebony_checked");
	public static final ResourceKey<PlacedFeature> KIWI_CHECKED = placedFeature("kiwi_checked");
	public static final ResourceKey<PlacedFeature> LEMON_CHECKED = placedFeature("lemon_checked");
	public static final ResourceKey<PlacedFeature> LIME_CHECKED = placedFeature("lime_checked");
	public static final ResourceKey<PlacedFeature> MAHOGANY_CHECKED = placedFeature("mahogany_checked");
	public static final ResourceKey<PlacedFeature> MAPLE_CHECKED = placedFeature("maple_checked");
	public static final ResourceKey<PlacedFeature> OLIVE_CHECKED = placedFeature("olive_checked");
	public static final ResourceKey<PlacedFeature> ORANGE_CHECKED = placedFeature("orange_checked");
	public static final ResourceKey<PlacedFeature> PEACH_CHECKED = placedFeature("peach_checked");
	public static final ResourceKey<PlacedFeature> PEAR_CHECKED = placedFeature("pear_checked");
	public static final ResourceKey<PlacedFeature> PLUM_CHECKED = placedFeature("pulm_checked");
	public static final ResourceKey<PlacedFeature> REDWOOD_CHECKED = placedFeature("redwood_checked");
	public static final ResourceKey<PlacedFeature> ROSEWOOD_CHECKED = placedFeature("rosewood_checked");
	public static final ResourceKey<PlacedFeature> RUBBER_CHECKED = placedFeature("rubber_checked");
	public static final ResourceKey<PlacedFeature> TEAK_CHECKED = placedFeature("teak_checked");
	public static final ResourceKey<PlacedFeature> WALNUT_CHECKED = placedFeature("walnut_checked");
	public static final ResourceKey<PlacedFeature> ZEBRAWOOD_CHECKED = placedFeature("zebrawood_checked");
	public static final ResourceKey<PlacedFeature> ANCIENT_AMBROSIA_CHECKED = placedFeature("ancient_ambrosia_checked");
	public static final ResourceKey<PlacedFeature> BENEVOLENT_APOTHECARY_CHECKED = placedFeature("benevolent_apothecary_checked");
	public static final ResourceKey<PlacedFeature> CRYOGENIC_SPIRE_CHECKED = placedFeature("cryogenic_spire_checked");
	public static final ResourceKey<PlacedFeature> MALEVOLENT_APOTHECARY_CHECKED = placedFeature("malevolent_apothecary_checked");
	public static final ResourceKey<PlacedFeature> NECROTIC_CHECKED = placedFeature("necrotic_checked");
	public static final ResourceKey<PlacedFeature> SERENDIPITOUS_APOTHECARY_CHECKED = placedFeature("serendipitous_apothecary_checked");
	public static final ResourceKey<PlacedFeature> THUNDEROUS_CONDUCTOR_CHECKED = placedFeature("thunderous_conductor_checked");
	public static final ResourceKey<PlacedFeature> TOWERING_INFERNO_CHECKED = placedFeature("towering_inferno_checked");
	public static final ResourceKey<PlacedFeature> OVERGROWTH_CHECKED = placedFeature("overgrowth_checked");
	
	/*
	 * VEGETATION
	 */
	
	public static final ResourceKey<PlacedFeature> TREES_MODIFIED_SAVANNA_PLACED = placedFeature("trees_zebrawood");
	public static final ResourceKey<PlacedFeature> TREES_MODIFIED_JUNGLE_PLACED = placedFeature("trees_modified_jungle");
	public static final ResourceKey<PlacedFeature> TREES_MODIFIED_JUNGLE_EDGE_PLACED = placedFeature("trees_teak");
	public static final ResourceKey<PlacedFeature> TREES_MODIFIED_BAMBOO_JUNGLE_PLACED = placedFeature("trees_bamboo_jungle");
	public static final ResourceKey<PlacedFeature> TREES_MODIFIED_FOREST_PLACED = placedFeature("trees_chestnut");
	public static final ResourceKey<PlacedFeature> TREES_MODIFIED_BIRCH_FOREST_PLACED = placedFeature("trees_peach");
	public static final ResourceKey<PlacedFeature> TREES_MODIFIED_WOODED_HILLS_PLACED = placedFeature("trees_aspen");
	public static final ResourceKey<PlacedFeature> TREES_MODIFIED_BEACH_PLACED = placedFeature("trees_coconut");
	public static final ResourceKey<PlacedFeature> TREES_MODIFIED_TAIGA_PLACED = placedFeature("trees_modified_taiga");
	public static final ResourceKey<PlacedFeature> TREES_MODIFIED_SNOWY_TAIGA_PLACED = placedFeature("trees_snowy_taiga");
	public static final ResourceKey<PlacedFeature> TREES_MODIFIED_SWAMP_PLACED = placedFeature("trees_orange");
	public static final ResourceKey<PlacedFeature> PATCH_BLACKBERRY_COMMON_PLACED = placedFeature("patch_blackberry_common");
	public static final ResourceKey<PlacedFeature> PATCH_BLACKBERRY_RARE_PLACED = placedFeature("patch_blackberry_rare");
	public static final ResourceKey<PlacedFeature> PATCH_BLUEBERRY_COMMON_PLACED = placedFeature("patch_blueberry_common");
	public static final ResourceKey<PlacedFeature> PATCH_BLUEBERRY_RARE_PLACED = placedFeature("patch_blueberry_rare");
	public static final ResourceKey<PlacedFeature> PATCH_RASPBERRY_COMMON_PLACED = placedFeature("patch_raspberry_common");
	public static final ResourceKey<PlacedFeature> PATCH_RASPBERRY_RARE_PLACED = placedFeature("patch_raspberry_rare");
	public static final ResourceKey<PlacedFeature> PATCH_STRAWBERRY_COMMON_PLACED = placedFeature("patch_strawberry_common");
	public static final ResourceKey<PlacedFeature> PATCH_STRAWBERRY_RARE_PLACED = placedFeature("patch_strawberry_rare");
	public static final ResourceKey<PlacedFeature> PATCH_COTTON_PLACED = placedFeature("patch_cotton");
	public static final ResourceKey<PlacedFeature> PATCH_PEPPERCORNS_PLACED = placedFeature("patch_peppercorns");
	public static final ResourceKey<PlacedFeature> OVERGROWTH_PLACED = placedFeature("overgrowth_placed");
}