package com.technologica.data.worldgen.placement;

import java.util.List;

import com.technologica.Technologica;
import com.technologica.data.worldgen.features.TechnologicaTreeFeatures;
import com.technologica.world.level.block.TechnologicaBlocks;

import net.minecraft.core.Holder;
import net.minecraft.data.BuiltinRegistries;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraft.world.level.levelgen.placement.PlacementModifier;

public class TechnologicaTreePlacements {
	
	public static Holder<PlacedFeature> APRICOT_CHECKED;
	public static Holder<PlacedFeature> ASPEN_CHECKED;
	public static Holder<PlacedFeature> AVOCADO_CHECKED;
	public static Holder<PlacedFeature> BANANA_CHECKED;
	public static Holder<PlacedFeature> CHERRY_CHECKED;	
	public static Holder<PlacedFeature> CHESTNUT_CHECKED;
	public static Holder<PlacedFeature> CINNAMON_CHECKED;
	public static Holder<PlacedFeature> COCONUT_CHECKED;
	public static Holder<PlacedFeature> EBONY_CHECKED;
	public static Holder<PlacedFeature> KIWI_CHECKED;
	public static Holder<PlacedFeature> LEMON_CHECKED;
	public static Holder<PlacedFeature> LIME_CHECKED;
	public static Holder<PlacedFeature> MAHOGANY_CHECKED;
	public static Holder<PlacedFeature> MAPLE_CHECKED;
	public static Holder<PlacedFeature> OLIVE_CHECKED;
	public static Holder<PlacedFeature> ORANGE_CHECKED;
	public static Holder<PlacedFeature> PEACH_CHECKED;
	public static Holder<PlacedFeature> PEAR_CHECKED;
	public static Holder<PlacedFeature> PLUM_CHECKED;
	public static Holder<PlacedFeature> REDWOOD_CHECKED;
	public static Holder<PlacedFeature> ROSEWOOD_CHECKED;
	public static Holder<PlacedFeature> RUBBER_CHECKED;
	public static Holder<PlacedFeature> TEAK_CHECKED;
	public static Holder<PlacedFeature> WALNUT_CHECKED;
	public static Holder<PlacedFeature> ZEBRAWOOD_CHECKED;
	
	public static Holder<PlacedFeature> ANCIENT_AMBROSIA_CHECKED;
	public static Holder<PlacedFeature> BENEVOLENT_APOTHECARY_CHECKED;
	public static Holder<PlacedFeature> CRYOGENIC_SPIRE_CHECKED;
	public static Holder<PlacedFeature> MALEVOLENT_APOTHECARY_CHECKED;
	public static Holder<PlacedFeature> NECROTIC_CHECKED;
	public static Holder<PlacedFeature> SERENDIPITOUS_APOTHECARY_CHECKED;
	public static Holder<PlacedFeature> THUNDEROUS_CONDUCTOR_CHECKED;
	public static Holder<PlacedFeature> TOWERING_INFERNO_CHECKED;
	
	public static void register() {
		APRICOT_CHECKED = register("apricot_checked", TechnologicaTreeFeatures.APRICOT, PlacementUtils.filteredByBlockSurvival(TechnologicaBlocks.APRICOT_SAPLING.get()));
		ASPEN_CHECKED = register("aspen_checked", TechnologicaTreeFeatures.ASPEN, PlacementUtils.filteredByBlockSurvival(TechnologicaBlocks.ASPEN_SAPLING.get()));
		AVOCADO_CHECKED = register("avocado_checked", TechnologicaTreeFeatures.AVOCADO, PlacementUtils.filteredByBlockSurvival(TechnologicaBlocks.AVOCADO_SAPLING.get()));
		BANANA_CHECKED = register("banana_checked", TechnologicaTreeFeatures.BANANA, PlacementUtils.filteredByBlockSurvival(TechnologicaBlocks.BANANA_SAPLING.get()));
		CHERRY_CHECKED = register("cherry_checked", TechnologicaTreeFeatures.CHERRY, PlacementUtils.filteredByBlockSurvival(TechnologicaBlocks.CHERRY_SAPLING.get()));
		CHESTNUT_CHECKED = register("chestnut_checked", TechnologicaTreeFeatures.CHESTNUT, PlacementUtils.filteredByBlockSurvival(TechnologicaBlocks.CHESTNUT_SAPLING.get()));
		CINNAMON_CHECKED = register("cinnamon_checked", TechnologicaTreeFeatures.CINNAMON, PlacementUtils.filteredByBlockSurvival(TechnologicaBlocks.CINNAMON_SAPLING.get()));
		COCONUT_CHECKED = register("coconut_checked", TechnologicaTreeFeatures.COCONUT, PlacementUtils.filteredByBlockSurvival(TechnologicaBlocks.COCONUT_SAPLING.get()));
		EBONY_CHECKED = register("ebony_checked", TechnologicaTreeFeatures.EBONY, PlacementUtils.filteredByBlockSurvival(TechnologicaBlocks.EBONY_SAPLING.get()));
		KIWI_CHECKED = register("kiwi_checked", TechnologicaTreeFeatures.KIWI, PlacementUtils.filteredByBlockSurvival(TechnologicaBlocks.KIWI_SAPLING.get()));
		LEMON_CHECKED = register("lemon_checked", TechnologicaTreeFeatures.LEMON, PlacementUtils.filteredByBlockSurvival(TechnologicaBlocks.LEMON_SAPLING.get()));
		LIME_CHECKED = register("lime_checked", TechnologicaTreeFeatures.LIME, PlacementUtils.filteredByBlockSurvival(TechnologicaBlocks.LIME_SAPLING.get()));
		MAHOGANY_CHECKED = register("mahogany_checked", TechnologicaTreeFeatures.MAHOGANY, PlacementUtils.filteredByBlockSurvival(TechnologicaBlocks.MAHOGANY_SAPLING.get()));
		MAPLE_CHECKED = register("maple_checked", TechnologicaTreeFeatures.MAPLE, PlacementUtils.filteredByBlockSurvival(TechnologicaBlocks.MAPLE_SAPLING.get()));
		OLIVE_CHECKED = register("olive_checked", TechnologicaTreeFeatures.OLIVE, PlacementUtils.filteredByBlockSurvival(TechnologicaBlocks.OLIVE_SAPLING.get()));
		ORANGE_CHECKED = register("orange_checked", TechnologicaTreeFeatures.ORANGE, PlacementUtils.filteredByBlockSurvival(TechnologicaBlocks.ORANGE_SAPLING.get()));
		PEACH_CHECKED = register("peach_checked", TechnologicaTreeFeatures.PEACH, PlacementUtils.filteredByBlockSurvival(TechnologicaBlocks.PEACH_SAPLING.get()));
		PEAR_CHECKED = register("pear_checked", TechnologicaTreeFeatures.PEAR, PlacementUtils.filteredByBlockSurvival(TechnologicaBlocks.PEAR_SAPLING.get()));
		PLUM_CHECKED = register("pulm_checked", TechnologicaTreeFeatures.PLUM, PlacementUtils.filteredByBlockSurvival(TechnologicaBlocks.PLUM_SAPLING.get()));
		REDWOOD_CHECKED = register("redwood_checked", TechnologicaTreeFeatures.REDWOOD, PlacementUtils.filteredByBlockSurvival(TechnologicaBlocks.REDWOOD_SAPLING.get()));
		ROSEWOOD_CHECKED = register("rosewood_checked", TechnologicaTreeFeatures.ROSEWOOD, PlacementUtils.filteredByBlockSurvival(TechnologicaBlocks.ROSEWOOD_SAPLING.get()));
		RUBBER_CHECKED = register("rubber_checked", TechnologicaTreeFeatures.RUBBER, PlacementUtils.filteredByBlockSurvival(TechnologicaBlocks.RUBBER_SAPLING.get()));
		TEAK_CHECKED = register("teak_checked", TechnologicaTreeFeatures.TEAK, PlacementUtils.filteredByBlockSurvival(TechnologicaBlocks.TEAK_SAPLING.get()));
		WALNUT_CHECKED = register("walnut_checked", TechnologicaTreeFeatures.WALNUT, PlacementUtils.filteredByBlockSurvival(TechnologicaBlocks.WALNUT_SAPLING.get()));
		ZEBRAWOOD_CHECKED = register("zebrawood_checked", TechnologicaTreeFeatures.ZEBRAWOOD, PlacementUtils.filteredByBlockSurvival(TechnologicaBlocks.ZEBRAWOOD_SAPLING.get()));
		
		ANCIENT_AMBROSIA_CHECKED = register("ancient_ambrosia_checked", TechnologicaTreeFeatures.ANCIENT_AMBROSIA, PlacementUtils.filteredByBlockSurvival(TechnologicaBlocks.ANCIENT_AMBROSIA_SAPLING.get()));
		BENEVOLENT_APOTHECARY_CHECKED = register("benevolent_apothecary_checked", TechnologicaTreeFeatures.BENEVOLENT_APOTHECARY, PlacementUtils.filteredByBlockSurvival(TechnologicaBlocks.BENEVOLENT_APOTHECARY_SAPLING.get()));
		CRYOGENIC_SPIRE_CHECKED = register("cryogenic_spire_checked", TechnologicaTreeFeatures.CRYOGENIC_SPIRE, PlacementUtils.filteredByBlockSurvival(TechnologicaBlocks.CRYOGENIC_SPIRE_SAPLING.get()));
		MALEVOLENT_APOTHECARY_CHECKED = register("malevolent_apothecary_checked", TechnologicaTreeFeatures.MALEVOLENT_APOTHECARY, PlacementUtils.filteredByBlockSurvival(TechnologicaBlocks.MALEVOLENT_APOTHECARY_SAPLING.get()));
		NECROTIC_CHECKED = register("necrotic_checked", TechnologicaTreeFeatures.NECROTIC, PlacementUtils.filteredByBlockSurvival(TechnologicaBlocks.NECROTIC_SAPLING.get()));
		SERENDIPITOUS_APOTHECARY_CHECKED = register("serendipitous_apothecary_checked", TechnologicaTreeFeatures.SERENDIPITOUS_APOTHECARY, PlacementUtils.filteredByBlockSurvival(TechnologicaBlocks.SERENDIPITOUS_APOTHECARY_SAPLING.get()));
		THUNDEROUS_CONDUCTOR_CHECKED = register("thunderous_conductor_checked", TechnologicaTreeFeatures.THUNDEROUS_CONDUCTOR, PlacementUtils.filteredByBlockSurvival(TechnologicaBlocks.THUNDEROUS_CONDUCTOR_SAPLING.get()));
		TOWERING_INFERNO_CHECKED = register("towering_inferno_checked", TechnologicaTreeFeatures.TOWERING_INFERNO, PlacementUtils.filteredByBlockSurvival(TechnologicaBlocks.TOWERING_INFERNO_SAPLING.get()));
	}
	
	public static Holder<PlacedFeature> register(String stringIn, Holder<? extends ConfiguredFeature<?, ?>> configuredFeatureIn, PlacementModifier... placementModifiersIn) {
		return BuiltinRegistries.register(BuiltinRegistries.PLACED_FEATURE, new ResourceLocation(Technologica.MODID, stringIn), new PlacedFeature(Holder.hackyErase(configuredFeatureIn), List.of(placementModifiersIn)));
	}
}