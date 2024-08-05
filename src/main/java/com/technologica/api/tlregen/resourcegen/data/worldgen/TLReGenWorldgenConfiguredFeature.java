package com.technologica.api.tlregen.resourcegen.data.worldgen;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

import com.google.gson.JsonObject;
import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import com.technologica.api.tlregen.resourcegen.TLReGenDataGenerator;
import com.technologica.api.tlregen.resourcegen.util.DynamicRegistryObject;

import net.minecraft.data.CachedOutput;
import net.minecraft.data.DataProvider;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;

public abstract class TLReGenWorldgenConfiguredFeature extends TLReGenDataGenerator implements DataProvider {
	private final Map<ResourceKey<ConfiguredFeature<?, ?>>, ConfiguredFeature<?, ?>> configuredFeatures = new LinkedHashMap<>();

	@Override
	public CompletableFuture<?> run(final CachedOutput cache) {
		configuredFeatures.clear();
		populate();
		if (configuredFeatures.isEmpty()) {
			return CompletableFuture.allOf();
		} else {
			List<CompletableFuture<?>> list = new ArrayList<CompletableFuture<?>>();
			configuredFeatures.forEach((key, value) -> {
				JsonObject json = ConfiguredFeature.DIRECT_CODEC.encodeStart(dynamicOps, value).getOrThrow(false, msg -> LOGGER.error("Failed to encode")).getAsJsonObject();
				list.add(DataProvider.saveStable(cache, json, packOutput.createPathProvider(target, "worldgen/configured_feature").json(key.location())));
			});
			return CompletableFuture.allOf(list.toArray(CompletableFuture[]::new));
		}
	}

	@Override
	public final String getName() {
		return super.getName() + ".worldgen/configured_feature";
	}

	protected final void configuredFeature(DynamicRegistryObject<ConfiguredFeature<?, ?>> dro) {
		configuredFeatures.put(dro.key(), dro.value());
	}

	public record TLWeightedPlacedFeature(String feature, float chance) {
		public static final Codec<TLWeightedPlacedFeature> CODEC = RecordCodecBuilder.create((instance) -> {
			return instance.group(Codec.STRING.fieldOf("feature").forGetter((weightedPlacedFeature) -> {
				return weightedPlacedFeature.feature;
			}), Codec.floatRange(0.0F, 1.0F).fieldOf("chance").forGetter((weightedPlacedFeature) -> {
				return weightedPlacedFeature.chance;
			})).apply(instance, TLWeightedPlacedFeature::new);
		});
	}

	public static class TLRandomFeatureConfiguration implements FeatureConfiguration {
		public static final Codec<TLRandomFeatureConfiguration> CODEC = RecordCodecBuilder.create((instance) -> {
			return instance.apply2(TLRandomFeatureConfiguration::new, TLWeightedPlacedFeature.CODEC.listOf().fieldOf("features").forGetter((randomFeatureConfiguration) -> {
				return randomFeatureConfiguration.features;
			}), Codec.STRING.fieldOf("default").forGetter((randomFeatureConfiguration) -> {
				return randomFeatureConfiguration.defaultFeature;
			}));
		});
		public final List<TLWeightedPlacedFeature> features;
		public final String defaultFeature;

		public TLRandomFeatureConfiguration(List<TLWeightedPlacedFeature> features, String defaultFeature) {
			this.features = features;
			this.defaultFeature = defaultFeature;
		}
	}
}