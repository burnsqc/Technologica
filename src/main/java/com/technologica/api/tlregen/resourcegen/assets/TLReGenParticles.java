package com.technologica.api.tlregen.resourcegen.assets;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.function.Supplier;
import java.util.stream.Stream;

import com.google.common.base.Preconditions;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.technologica.api.tlregen.resourcegen.TLRGMasterResourceGenerator;

import net.minecraft.core.particles.ParticleType;
import net.minecraft.data.CachedOutput;
import net.minecraft.data.DataProvider;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.packs.PackType;
import net.minecraftforge.registries.ForgeRegistries;

public abstract class TLReGenParticles extends TLRGMasterResourceGenerator implements DataProvider {
	private final Map<ResourceLocation, List<String>> particles = new HashMap<>();
	private boolean performValidation = true;

	/**
	 * OVERRIDE ME TO ADD PARTICLES
	 */
	protected abstract void populate();

	@Override
	public final CompletableFuture<?> run(final CachedOutput cache) {
		CompletableFuture<?> completable = CompletableFuture.allOf();

		particles.clear();
		populate();
		if (performValidation) {
			// validate();
		}

		if (!particles.isEmpty()) {
			List<CompletableFuture<?>> list = new ArrayList<CompletableFuture<?>>();
			particles.forEach((key, value) -> {
				JsonObject json = new JsonObject();
				JsonArray textures = new JsonArray();
				value.forEach(textures::add);
				json.add("textures", textures);
				list.add(DataProvider.saveStable(cache, json, packOutput.createPathProvider(PackOutput.Target.RESOURCE_PACK, "particles").json(key)));
			});
			completable = CompletableFuture.allOf(list.toArray(CompletableFuture[]::new));
		}

		return completable;
	}

	@Override
	public final String getName() {
		return "assets." + modid + ".particles";
	}

	/*
	 * HELPER METHODS
	 */

	protected final void sprite(Supplier<? extends ParticleType<?>> type, ResourceLocation texture) {
		spriteSet(type.get(), texture);
	}

	protected final void spriteSet(Supplier<? extends ParticleType<?>> type, ResourceLocation baseName, int numOfTextures, boolean reverse) {
		Preconditions.checkArgument(numOfTextures > 0, "The number of textures to generate must be positive");
		spriteSet(type.get(), () -> new Iterator<>() {
			private int counter = 0;

			@Override
			public boolean hasNext() {
				return counter < numOfTextures;
			}

			@Override
			public ResourceLocation next() {
				var texture = baseName.withSuffix("_" + (reverse ? numOfTextures - counter - 1 : counter));
				counter++;
				return texture;
			}
		});
	}

	protected final void spriteSet(ParticleType<?> type, ResourceLocation texture, ResourceLocation... textures) {
		spriteSet(type, Stream.concat(Stream.of(texture), Arrays.stream(textures))::iterator);
	}

	protected final void spriteSet(ParticleType<?> type, Iterable<ResourceLocation> textures) {
		var particle = Preconditions.checkNotNull(ForgeRegistries.PARTICLE_TYPES.getKey(type), "The particle type is not registered");

		List<String> desc = new ArrayList<>();
		for (var texture : textures) {
			Preconditions.checkArgument(helper.exists(texture, PackType.CLIENT_RESOURCES, ".png", "textures/particle"), "Texture '%s' does not exist in any known resource pack", texture);
			desc.add(texture.toString());
		}
		Preconditions.checkArgument(desc.size() > 0, "The particle type '%s' must have one texture", particle);

		if (particles.putIfAbsent(particle, desc) != null) {
			throw new IllegalArgumentException(String.format("The particle type '%s' already has a description associated with it", particle));
		}
	}
}
