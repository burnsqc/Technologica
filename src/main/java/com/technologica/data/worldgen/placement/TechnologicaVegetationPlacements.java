package com.technologica.data.worldgen.placement;

import java.util.List;

import com.google.common.collect.ImmutableList;
import com.technologica.Technologica;
import com.technologica.data.worldgen.features.TechnologicaVegetationFeatures;

import net.minecraft.core.Holder;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.data.worldgen.features.VegetationFeatures;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.placement.BiomeFilter;
import net.minecraft.world.level.levelgen.placement.CountOnEveryLayerPlacement;
import net.minecraft.world.level.levelgen.placement.InSquarePlacement;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraft.world.level.levelgen.placement.PlacementModifier;
import net.minecraft.world.level.levelgen.placement.RarityFilter;
import net.minecraft.world.level.levelgen.placement.SurfaceWaterDepthFilter;

public class TechnologicaVegetationPlacements {
	public static final ResourceKey<PlacedFeature> TREES_MODIFIED_SAVANNA_PLACED = ResourceKey.create(Registries.PLACED_FEATURE, new ResourceLocation(Technologica.MODID, "trees_zebrawood"));
	public static final ResourceKey<PlacedFeature> TREES_MODIFIED_JUNGLE_PLACED = ResourceKey.create(Registries.PLACED_FEATURE, new ResourceLocation(Technologica.MODID, "trees_modified_jungle"));
	public static final ResourceKey<PlacedFeature> TREES_MODIFIED_JUNGLE_EDGE_PLACED = ResourceKey.create(Registries.PLACED_FEATURE, new ResourceLocation(Technologica.MODID, "trees_teak"));
	public static final ResourceKey<PlacedFeature> TREES_MODIFIED_BAMBOO_JUNGLE_PLACED = ResourceKey.create(Registries.PLACED_FEATURE, new ResourceLocation(Technologica.MODID, "trees_bamboo_jungle"));
	public static final ResourceKey<PlacedFeature> TREES_MODIFIED_FOREST_PLACED = ResourceKey.create(Registries.PLACED_FEATURE, new ResourceLocation(Technologica.MODID, "trees_chestnut"));
	public static final ResourceKey<PlacedFeature> TREES_MODIFIED_BIRCH_FOREST_PLACED = ResourceKey.create(Registries.PLACED_FEATURE, new ResourceLocation(Technologica.MODID, "trees_peach"));
	public static final ResourceKey<PlacedFeature> TREES_MODIFIED_WOODED_HILLS_PLACED = ResourceKey.create(Registries.PLACED_FEATURE, new ResourceLocation(Technologica.MODID, "trees_aspen"));
	public static final ResourceKey<PlacedFeature> TREES_MODIFIED_BEACH_PLACED = ResourceKey.create(Registries.PLACED_FEATURE, new ResourceLocation(Technologica.MODID, "trees_coconut"));
	public static final ResourceKey<PlacedFeature> TREES_MODIFIED_TAIGA_PLACED = ResourceKey.create(Registries.PLACED_FEATURE, new ResourceLocation(Technologica.MODID, "trees_modified_taiga"));
	public static final ResourceKey<PlacedFeature> TREES_MODIFIED_SNOWY_TAIGA_PLACED = ResourceKey.create(Registries.PLACED_FEATURE, new ResourceLocation(Technologica.MODID, "trees_snowy_taiga"));
	public static final ResourceKey<PlacedFeature> TREES_MODIFIED_SWAMP_PLACED = ResourceKey.create(Registries.PLACED_FEATURE, new ResourceLocation(Technologica.MODID, "trees_orange"));
	public static final ResourceKey<PlacedFeature> PATCH_BLACKBERRY_COMMON_PLACED = ResourceKey.create(Registries.PLACED_FEATURE, new ResourceLocation(Technologica.MODID, "patch_blackberry_common"));
	public static final ResourceKey<PlacedFeature> PATCH_BLACKBERRY_RARE_PLACED = ResourceKey.create(Registries.PLACED_FEATURE, new ResourceLocation(Technologica.MODID, "patch_blackberry_rare"));
	public static final ResourceKey<PlacedFeature> PATCH_BLUEBERRY_COMMON_PLACED = ResourceKey.create(Registries.PLACED_FEATURE, new ResourceLocation(Technologica.MODID, "patch_blueberry_common"));
	public static final ResourceKey<PlacedFeature> PATCH_BLUEBERRY_RARE_PLACED = ResourceKey.create(Registries.PLACED_FEATURE, new ResourceLocation(Technologica.MODID, "patch_blueberry_rare"));
	public static final ResourceKey<PlacedFeature> PATCH_RASPBERRY_COMMON_PLACED = ResourceKey.create(Registries.PLACED_FEATURE, new ResourceLocation(Technologica.MODID, "patch_raspberry_common"));
	public static final ResourceKey<PlacedFeature> PATCH_RASPBERRY_RARE_PLACED = ResourceKey.create(Registries.PLACED_FEATURE, new ResourceLocation(Technologica.MODID, "patch_raspberry_rare"));
	public static final ResourceKey<PlacedFeature> PATCH_STRAWBERRY_COMMON_PLACED = ResourceKey.create(Registries.PLACED_FEATURE, new ResourceLocation(Technologica.MODID, "patch_strawberry_common"));
	public static final ResourceKey<PlacedFeature> PATCH_STRAWBERRY_RARE_PLACED = ResourceKey.create(Registries.PLACED_FEATURE, new ResourceLocation(Technologica.MODID, "patch_strawberry_rare"));
	public static final ResourceKey<PlacedFeature> PATCH_COTTON_PLACED = ResourceKey.create(Registries.PLACED_FEATURE, new ResourceLocation(Technologica.MODID, "patch_cotton"));
	public static final ResourceKey<PlacedFeature> PATCH_PEPPERCORNS_PLACED = ResourceKey.create(Registries.PLACED_FEATURE, new ResourceLocation(Technologica.MODID, "patch_peppercorns"));
	public static final ResourceKey<PlacedFeature> OVERGROWTH_PLACED = ResourceKey.create(Registries.PLACED_FEATURE, new ResourceLocation(Technologica.MODID, "overgrowth_placed"));
	public static final PlacementModifier TREE_THRESHOLD = SurfaceWaterDepthFilter.forMaxDepth(0);

	private static ImmutableList.Builder<PlacementModifier> treePlacementBase(PlacementModifier p_195485_) {
		return ImmutableList.<PlacementModifier>builder().add(p_195485_).add(InSquarePlacement.spread()).add(TREE_THRESHOLD).add(PlacementUtils.HEIGHTMAP_OCEAN_FLOOR).add(BiomeFilter.biome());
	}

	public static List<PlacementModifier> treePlacement(PlacementModifier p_195480_) {
		return treePlacementBase(p_195480_).build();
	}

	public static void bootstrap(BootstapContext<PlacedFeature> p_255657_) {
		HolderGetter<ConfiguredFeature<?, ?>> holdergetter = p_255657_.lookup(Registries.CONFIGURED_FEATURE);
		Holder<ConfiguredFeature<?, ?>> holder = holdergetter.getOrThrow(TechnologicaVegetationFeatures.TREES_MODIFIED_SAVANNA);
		Holder<ConfiguredFeature<?, ?>> holder1 = holdergetter.getOrThrow(TechnologicaVegetationFeatures.TREES_MODIFIED_JUNGLE);
		Holder<ConfiguredFeature<?, ?>> holder2 = holdergetter.getOrThrow(TechnologicaVegetationFeatures.TREES_MODIFIED_JUNGLE_EDGE);
		Holder<ConfiguredFeature<?, ?>> holder3 = holdergetter.getOrThrow(TechnologicaVegetationFeatures.TREES_MODIFIED_BAMBOO_JUNGLE);
		Holder<ConfiguredFeature<?, ?>> holder4 = holdergetter.getOrThrow(TechnologicaVegetationFeatures.TREES_MODIFIED_FOREST);
		Holder<ConfiguredFeature<?, ?>> holder5 = holdergetter.getOrThrow(TechnologicaVegetationFeatures.TREES_MODIFIED_BIRCH_FOREST);
		Holder<ConfiguredFeature<?, ?>> holder6 = holdergetter.getOrThrow(TechnologicaVegetationFeatures.TREES_MODIFIED_WOODED_HILLS);
		Holder<ConfiguredFeature<?, ?>> holder7 = holdergetter.getOrThrow(TechnologicaVegetationFeatures.TREES_MODIFIED_BEACH);
		Holder<ConfiguredFeature<?, ?>> holder8 = holdergetter.getOrThrow(TechnologicaVegetationFeatures.TREES_MODIFIED_TAIGA);
		Holder<ConfiguredFeature<?, ?>> holder9 = holdergetter.getOrThrow(TechnologicaVegetationFeatures.TREES_MODIFIED_SNOWY_TAIGA);
		Holder<ConfiguredFeature<?, ?>> holder10 = holdergetter.getOrThrow(TechnologicaVegetationFeatures.TREES_MODIFIED_SWAMP);
		Holder<ConfiguredFeature<?, ?>> holder11 = holdergetter.getOrThrow(TechnologicaVegetationFeatures.PATCH_BLACKBERRY_BUSH);
		Holder<ConfiguredFeature<?, ?>> holder12 = holdergetter.getOrThrow(TechnologicaVegetationFeatures.PATCH_BLUEBERRY_BUSH);
		Holder<ConfiguredFeature<?, ?>> holder13 = holdergetter.getOrThrow(TechnologicaVegetationFeatures.PATCH_RASPBERRY_BUSH);
		Holder<ConfiguredFeature<?, ?>> holder14 = holdergetter.getOrThrow(TechnologicaVegetationFeatures.PATCH_STRAWBERRY_BUSH);
		Holder<ConfiguredFeature<?, ?>> holder15 = holdergetter.getOrThrow(TechnologicaVegetationFeatures.PATCH_COTTON_BUSH);
		Holder<ConfiguredFeature<?, ?>> holder16 = holdergetter.getOrThrow(TechnologicaVegetationFeatures.PATCH_PEPPERCORN_BUSH);
		Holder<ConfiguredFeature<?, ?>> holder17 = holdergetter.getOrThrow(VegetationFeatures.MANGROVE_VEGETATION);
		PlacementUtils.register(p_255657_, TREES_MODIFIED_SAVANNA_PLACED, holder, treePlacement(PlacementUtils.countExtra(1, 0.1F, 1)));
		PlacementUtils.register(p_255657_, TREES_MODIFIED_JUNGLE_PLACED, holder1, treePlacement(PlacementUtils.countExtra(1, 0.1F, 1)));
		PlacementUtils.register(p_255657_, TREES_MODIFIED_JUNGLE_EDGE_PLACED, holder2, treePlacement(PlacementUtils.countExtra(1, 0.1F, 1)));
		PlacementUtils.register(p_255657_, TREES_MODIFIED_BAMBOO_JUNGLE_PLACED, holder3, treePlacement(PlacementUtils.countExtra(1, 0.1F, 1)));
		PlacementUtils.register(p_255657_, TREES_MODIFIED_FOREST_PLACED, holder4, treePlacement(PlacementUtils.countExtra(1, 0.1F, 1)));
		PlacementUtils.register(p_255657_, TREES_MODIFIED_BIRCH_FOREST_PLACED, holder5, treePlacement(PlacementUtils.countExtra(1, 0.1F, 1)));
		PlacementUtils.register(p_255657_, TREES_MODIFIED_WOODED_HILLS_PLACED, holder6, treePlacement(PlacementUtils.countExtra(1, 0.1F, 1)));
		PlacementUtils.register(p_255657_, TREES_MODIFIED_BEACH_PLACED, holder7, treePlacement(PlacementUtils.countExtra(1, 0.1F, 1)));
		PlacementUtils.register(p_255657_, TREES_MODIFIED_TAIGA_PLACED, holder8, treePlacement(PlacementUtils.countExtra(1, 0.1F, 1)));
		PlacementUtils.register(p_255657_, TREES_MODIFIED_SNOWY_TAIGA_PLACED, holder9, treePlacement(PlacementUtils.countExtra(1, 0.1F, 1)));
		PlacementUtils.register(p_255657_, TREES_MODIFIED_SWAMP_PLACED, holder10, treePlacement(PlacementUtils.countExtra(1, 0.1F, 1)));
		PlacementUtils.register(p_255657_, PATCH_BLACKBERRY_COMMON_PLACED, holder11, List.of(RarityFilter.onAverageOnceEvery(32), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP_WORLD_SURFACE, BiomeFilter.biome()));
		PlacementUtils.register(p_255657_, PATCH_BLACKBERRY_RARE_PLACED, holder11, List.of(RarityFilter.onAverageOnceEvery(384), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP_WORLD_SURFACE, BiomeFilter.biome()));
		PlacementUtils.register(p_255657_, PATCH_BLUEBERRY_COMMON_PLACED, holder12, List.of(RarityFilter.onAverageOnceEvery(32), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP_WORLD_SURFACE, BiomeFilter.biome()));
		PlacementUtils.register(p_255657_, PATCH_BLUEBERRY_RARE_PLACED, holder12, List.of(RarityFilter.onAverageOnceEvery(384), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP_WORLD_SURFACE, BiomeFilter.biome()));
		PlacementUtils.register(p_255657_, PATCH_RASPBERRY_COMMON_PLACED, holder13, List.of(RarityFilter.onAverageOnceEvery(32), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP_WORLD_SURFACE, BiomeFilter.biome()));
		PlacementUtils.register(p_255657_, PATCH_RASPBERRY_RARE_PLACED, holder13, List.of(RarityFilter.onAverageOnceEvery(384), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP_WORLD_SURFACE, BiomeFilter.biome()));
		PlacementUtils.register(p_255657_, PATCH_STRAWBERRY_COMMON_PLACED, holder14, List.of(RarityFilter.onAverageOnceEvery(32), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP_WORLD_SURFACE, BiomeFilter.biome()));
		PlacementUtils.register(p_255657_, PATCH_STRAWBERRY_RARE_PLACED, holder14, List.of(RarityFilter.onAverageOnceEvery(384), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP_WORLD_SURFACE, BiomeFilter.biome()));
		PlacementUtils.register(p_255657_, PATCH_COTTON_PLACED, holder15, List.of(RarityFilter.onAverageOnceEvery(32), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP_WORLD_SURFACE, BiomeFilter.biome()));
		PlacementUtils.register(p_255657_, PATCH_PEPPERCORNS_PLACED, holder16, List.of(RarityFilter.onAverageOnceEvery(5), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP_WORLD_SURFACE, BiomeFilter.biome()));
		PlacementUtils.register(p_255657_, OVERGROWTH_PLACED, holder17, CountOnEveryLayerPlacement.of(6), BiomeFilter.biome());
	}
}