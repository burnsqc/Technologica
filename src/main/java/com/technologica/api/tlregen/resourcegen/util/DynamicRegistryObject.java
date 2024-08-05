package com.technologica.api.tlregen.resourcegen.util;

import java.util.Optional;
import java.util.function.Supplier;
import java.util.stream.Stream;

import com.mojang.serialization.Lifecycle;

import net.minecraft.core.Holder;
import net.minecraft.core.Holder.Reference;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.HolderOwner;
import net.minecraft.core.HolderSet.Named;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceKey;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;

public class DynamicRegistryObject<T> {
	private ResourceKey<ConfiguredFeature<?, ?>> key;
	private Supplier<ConfiguredFeature<?, ?>> value;
	private Holder.Reference<ConfiguredFeature<?, ?>> holder;
	private ResourceKey<PlacedFeature> key2;
	private Supplier<PlacedFeature> value2;
	private Holder.Reference<PlacedFeature> holder2;

	public DynamicRegistryObject(ResourceKey<ConfiguredFeature<?, ?>> resourceKey, Supplier<ConfiguredFeature<?, ?>> type) {
		this.key = resourceKey;
		this.value = type;
		this.holder = Holder.Reference.createStandAlone(ho, this.key);
		holder.bindValue(this.value.get());
	}

	public DynamicRegistryObject(ResourceKey<PlacedFeature> resourceKey, Supplier<PlacedFeature> type, int intt) {
		this.key2 = resourceKey;
		this.value2 = type;
		this.holder2 = Holder.Reference.createStandAlone(ho2, this.key2);
		holder2.bindValue(this.value2.get());
	}

	public ResourceKey<ConfiguredFeature<?, ?>> key() {
		return this.key;
	}

	public ResourceKey<PlacedFeature> key2() {
		return this.key2;
	}

	public ConfiguredFeature<?, ?> value() {
		return this.value.get();
	}

	public PlacedFeature value2() {
		return this.value2.get();
	}

	public Holder.Reference<ConfiguredFeature<?, ?>> holder() {
		return this.holder;
	}

	public Holder.Reference<PlacedFeature> holder2() {
		return this.holder2;
	}

	public static HolderOwner<ConfiguredFeature<?, ?>> ho = new HolderLookup.RegistryLookup<ConfiguredFeature<?, ?>>() {

		@Override
		public Stream<Reference<ConfiguredFeature<?, ?>>> listElements() {
			return null;
		}

		@Override
		public Stream<Named<ConfiguredFeature<?, ?>>> listTags() {
			return null;
		}

		@Override
		public Optional<Reference<ConfiguredFeature<?, ?>>> get(ResourceKey<ConfiguredFeature<?, ?>> p_255645_) {
			return Optional.empty();
		}

		@Override
		public Optional<Named<ConfiguredFeature<?, ?>>> get(TagKey<ConfiguredFeature<?, ?>> p_256283_) {
			return Optional.empty();
		}

		@Override
		public ResourceKey<? extends Registry<? extends ConfiguredFeature<?, ?>>> key() {
			return null;
		}

		@Override
		public Lifecycle registryLifecycle() {
			return null;
		}
	};

	public static HolderOwner<PlacedFeature> ho2 = new HolderLookup.RegistryLookup<PlacedFeature>() {

		@Override
		public Stream<Reference<PlacedFeature>> listElements() {
			return null;
		}

		@Override
		public Stream<Named<PlacedFeature>> listTags() {
			return null;
		}

		@Override
		public Optional<Reference<PlacedFeature>> get(ResourceKey<PlacedFeature> p_255645_) {
			return Optional.empty();
		}

		@Override
		public Optional<Named<PlacedFeature>> get(TagKey<PlacedFeature> p_256283_) {
			return Optional.empty();
		}

		@Override
		public ResourceKey<? extends Registry<? extends PlacedFeature>> key() {
			return null;
		}

		@Override
		public Lifecycle registryLifecycle() {
			return null;
		}
	};
}
