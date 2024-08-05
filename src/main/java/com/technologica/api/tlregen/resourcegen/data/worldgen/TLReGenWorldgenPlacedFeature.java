package com.technologica.api.tlregen.resourcegen.data.worldgen;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

import com.google.common.collect.ImmutableList;
import com.google.gson.JsonObject;
import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import com.technologica.api.tlregen.resourcegen.TLReGenDataGenerator;
import com.technologica.api.tlregen.resourcegen.util.DynamicRegistryObject;

import net.minecraft.core.Holder;
import net.minecraft.data.CachedOutput;
import net.minecraft.data.DataProvider;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.placement.BiomeFilter;
import net.minecraft.world.level.levelgen.placement.CountPlacement;
import net.minecraft.world.level.levelgen.placement.InSquarePlacement;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraft.world.level.levelgen.placement.PlacementModifier;
import net.minecraft.world.level.levelgen.placement.SurfaceWaterDepthFilter;

public abstract class TLReGenWorldgenPlacedFeature extends TLReGenDataGenerator implements DataProvider {
	private final Map<ResourceKey<PlacedFeature>, PlacedFeature> placedFeatures = new LinkedHashMap<>();
	protected static final PlacementModifier TREE_THRESHOLD = SurfaceWaterDepthFilter.forMaxDepth(0);

	@Override
	public CompletableFuture<?> run(final CachedOutput cache) {
		placedFeatures.clear();
		populate();
		if (placedFeatures.isEmpty()) {
			return CompletableFuture.allOf();
		} else {
			List<CompletableFuture<?>> list = new ArrayList<CompletableFuture<?>>();
			placedFeatures.forEach((key, value) -> {
				JsonObject json = PlacedFeature.DIRECT_CODEC.encodeStart(dynamicOps, value).getOrThrow(false, msg -> LOGGER.error("Failed to encode")).getAsJsonObject();
				list.add(DataProvider.saveStable(cache, json, packOutput.createPathProvider(target, "worldgen/placed_feature").json(key.location())));
			});
			return CompletableFuture.allOf(list.toArray(CompletableFuture[]::new));
		}
	}

	@Override
	public final String getName() {
		return super.getName() + ".worldgen/placed_feature";
	}

	protected final void placedFeature(ResourceKey<PlacedFeature> name, PlacedFeature type) {
		placedFeatures.put(name, type);
		Holder.Reference.createStandAlone(ho, name).bindValue(type);
	}

	protected static PlacedFeature placedFeature(DynamicRegistryObject<ConfiguredFeature<?, ?>> cf, List<PlacementModifier> placement) {
		Holder<ConfiguredFeature<?, ?>> holder = Holder.Reference.createStandAlone(ho2, cf.key());
		return new PlacedFeature(holder, placement);
	}

	protected static PlacedFeature placedFeature(ResourceKey<ConfiguredFeature<?, ?>> cf, List<PlacementModifier> placement) {
		Holder<ConfiguredFeature<?, ?>> holder = Holder.Reference.createStandAlone(ho2, cf);
		return new PlacedFeature(holder, placement);
	}

	public record TLPlacedFeature(String feature, List<PlacementModifier> placement) {
		public static final Codec<TLPlacedFeature> DIRECT_CODEC = RecordCodecBuilder.create((instance) -> {
			return instance.group(Codec.STRING.fieldOf("feature").forGetter((placedFeature) -> {
				return placedFeature.feature;
			}), PlacementModifier.CODEC.listOf().fieldOf("placement").forGetter((placedFeature) -> {
				return placedFeature.placement;
			})).apply(instance, TLPlacedFeature::new);
		});
	}

	protected static List<PlacementModifier> commonOrePlacement(int p_195344_, PlacementModifier p_195345_) {
		return orePlacement(CountPlacement.of(p_195344_), p_195345_);
	}

	private static List<PlacementModifier> orePlacement(PlacementModifier p_195347_, PlacementModifier p_195348_) {
		return List.of(p_195347_, InSquarePlacement.spread(), p_195348_, BiomeFilter.biome());
	}

	protected static List<PlacementModifier> treePlacement(PlacementModifier p_195345_) {
		return List.of(p_195345_);
	}

	private static ImmutableList.Builder<PlacementModifier> treePlacementBase(PlacementModifier p_195485_) {
		return ImmutableList.<PlacementModifier>builder().add(p_195485_).add(InSquarePlacement.spread()).add(TREE_THRESHOLD).add(PlacementUtils.HEIGHTMAP_OCEAN_FLOOR).add(BiomeFilter.biome());
	}

	public static List<PlacementModifier> vegetationPlacement(PlacementModifier p_195480_) {
		return treePlacementBase(p_195480_).build();
	}
}
