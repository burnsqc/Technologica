package com.technologica.data.worldgen.placement;

import java.util.List;

import com.technologica.Technologica;
import com.technologica.data.worldgen.features.TechnologicaMiscOverworldFeatures;

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
import net.minecraft.world.level.levelgen.placement.HeightRangePlacement;
import net.minecraft.world.level.levelgen.placement.InSquarePlacement;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraft.world.level.levelgen.placement.RarityFilter;

public class TechnologicaMiscOverworldPlacements {
	public static final ResourceKey<PlacedFeature> BRINE_POOL_PLACED = ResourceKey.create(Registries.PLACED_FEATURE, new ResourceLocation(Technologica.MODID, "brine_pool"));
	public static final ResourceKey<PlacedFeature> OASIS_PLACED = ResourceKey.create(Registries.PLACED_FEATURE, new ResourceLocation(Technologica.MODID, "oasis"));
	// private static final ResourceKey<PlacedFeature> PATCH_BLACKBERRY_BUSH_VILLAGE = ResourceKey.create(Registries.PLACED_FEATURE, new ResourceLocation(Technologica.MODID, "patch_blackberry_bush"));
	// private static final ResourceKey<PlacedFeature> PATCH_BLUEBERRY_BUSH_VILLAGE = ResourceKey.create(Registries.PLACED_FEATURE, new ResourceLocation(Technologica.MODID, "patch_blueberry_bush"));
	// private static final ResourceKey<PlacedFeature> PATCH_RASPBERRY_BUSH_VILLAGE = ResourceKey.create(Registries.PLACED_FEATURE, new ResourceLocation(Technologica.MODID, "patch_raspberry_bush"));
	// private static final ResourceKey<PlacedFeature> PATCH_STRAWBERRY_BUSH_VILLAGE = ResourceKey.create(Registries.PLACED_FEATURE, new ResourceLocation(Technologica.MODID, "patch_strawberry_bush"));

	public static void bootstrap(BootstapContext<PlacedFeature> p_255762_) {
		HolderGetter<ConfiguredFeature<?, ?>> holdergetter = p_255762_.lookup(Registries.CONFIGURED_FEATURE);
		Holder<ConfiguredFeature<?, ?>> holder = holdergetter.getOrThrow(TechnologicaMiscOverworldFeatures.BRINE_POOL_CONFIGURED);
		Holder<ConfiguredFeature<?, ?>> holder1 = holdergetter.getOrThrow(TechnologicaMiscOverworldFeatures.OASIS_CONFIGURED);
		PlacementUtils.register(p_255762_, BRINE_POOL_PLACED, holder, List.of(RarityFilter.onAverageOnceEvery(2), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP_WORLD_SURFACE, BiomeFilter.biome()));
		PlacementUtils.register(p_255762_, OASIS_PLACED, holder1, List.of(RarityFilter.onAverageOnceEvery(200), InSquarePlacement.spread(), HeightRangePlacement.uniform(VerticalAnchor.bottom(), VerticalAnchor.absolute(192)), BiomeFilter.biome()));
		// context.register(PATCH_BLACKBERRY_BUSH_VILLAGE, new PlacedFeature(context.lookup(Registries.CONFIGURED_FEATURE).getOrThrow(PATCH_BLACKBERRY_BUSH), null));
		// context.register(PATCH_BLUEBERRY_BUSH_VILLAGE, new PlacedFeature(context.lookup(Registries.CONFIGURED_FEATURE).getOrThrow(PATCH_BLUEBERRY_BUSH)));
		// context.register(PATCH_RASPBERRY_BUSH_VILLAGE, new PlacedFeature(context.lookup(Registries.CONFIGURED_FEATURE).getOrThrow(PATCH_RASPBERRY_BUSH)));
		// context.register(PATCH_STRAWBERRY_BUSH_VILLAGE, new PlacedFeature(context.lookup(Registries.CONFIGURED_FEATURE).getOrThrow(PATCH_STRAWBERRY_BUSH)));
	}
}
