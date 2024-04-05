package com.technologica.api.tlregen.resourcegen.assets;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Stream;

import com.google.common.base.Preconditions;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.technologica.api.tlregen.resourcegen.TLRGMasterResourceGenerator;

import net.minecraft.Util;
import net.minecraft.core.particles.ParticleType;
import net.minecraft.data.CachedOutput;
import net.minecraft.data.DataProvider;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.packs.PackType;
import net.minecraftforge.registries.ForgeRegistries;

public abstract class TLReGenParticles extends TLRGMasterResourceGenerator implements DataProvider {
	private final Map<ResourceLocation, List<String>> data = new HashMap<>();

	protected TLReGenParticles() {
	}

	@Override
	public final CompletableFuture<?> run(CachedOutput cache) {
		populate();

		return CompletableFuture.allOf(data.entrySet().stream().map(entry -> {
			var textures = new JsonArray();
			entry.getValue().forEach(textures::add);
			JsonObject json = Util.make(new JsonObject(), obj -> obj.add("textures", textures));
			return DataProvider.saveStable(cache, json, packOutput.createPathProvider(PackOutput.Target.RESOURCE_PACK, "particles").json(entry.getKey()));
		}).toArray(CompletableFuture[]::new));
	}

	@Override
	public final String getName() {
		return "assets." + modid + ".particles";
	}

	protected abstract void populate();

	/*
	 * HELPER METHODS
	 */

	protected final void sprite(ParticleType<?> type, ResourceLocation texture) {
		this.spriteSet(type, texture);
	}

	protected final void spriteSet(ParticleType<?> type, ResourceLocation baseName, int numOfTextures, boolean reverse) {
		Preconditions.checkArgument(numOfTextures > 0, "The number of textures to generate must be positive");
		this.spriteSet(type, () -> new Iterator<>() {
			private int counter = 0;

			@Override
			public boolean hasNext() {
				return this.counter < numOfTextures;
			}

			@Override
			public ResourceLocation next() {
				var texture = baseName.withSuffix("_" + (reverse ? numOfTextures - this.counter - 1 : this.counter));
				this.counter++;
				return texture;
			}
		});
	}

	protected final void spriteSet(ParticleType<?> type, ResourceLocation texture, ResourceLocation... textures) {
		this.spriteSet(type, Stream.concat(Stream.of(texture), Arrays.stream(textures))::iterator);
	}

	protected final void spriteSet(ParticleType<?> type, Iterable<ResourceLocation> textures) {
		var particle = Preconditions.checkNotNull(ForgeRegistries.PARTICLE_TYPES.getKey(type), "The particle type is not registered");

		List<String> desc = new ArrayList<>();
		for (var texture : textures) {
			Preconditions.checkArgument(helper.exists(texture, PackType.CLIENT_RESOURCES, ".png", "textures/particle"), "Texture '%s' does not exist in any known resource pack", texture);
			desc.add(texture.toString());
		}
		Preconditions.checkArgument(desc.size() > 0, "The particle type '%s' must have one texture", particle);

		if (data.putIfAbsent(particle, desc) != null) {
			throw new IllegalArgumentException(String.format("The particle type '%s' already has a description associated with it", particle));
		}
	}
}
