package com.technologica.api.tlregen.resourcegen.assets;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

import com.google.gson.JsonObject;
import com.technologica.api.tlregen.resourcegen.TLReGenAssetGenerator;

import net.minecraft.client.renderer.texture.atlas.SpriteSource;
import net.minecraft.client.renderer.texture.atlas.SpriteSources;
import net.minecraft.data.CachedOutput;
import net.minecraft.data.DataProvider;
import net.minecraft.resources.ResourceLocation;

public abstract class TLReGenAtlases extends TLReGenAssetGenerator {
	private final Map<ResourceLocation, SourceList> resources = new HashMap<>();

	@Override
	public final CompletableFuture<?> run(final CachedOutput cache) {
		resources.clear();
		populate();
		if (resources.isEmpty()) {
			return CompletableFuture.allOf();
		} else {
			List<CompletableFuture<?>> list = new ArrayList<CompletableFuture<?>>();
			resources.forEach((key, value) -> {
				JsonObject json = SpriteSources.FILE_CODEC.encodeStart(dynamicOps, value.sources).getOrThrow(false, msg -> LOGGER.error("Failed to encode")).getAsJsonObject();
				list.add(DataProvider.saveStable(cache, json, packOutput.createPathProvider(target, "atlases").json(key)));
			});
			return CompletableFuture.allOf(list.toArray(CompletableFuture[]::new));
		}
	}

	@Override
	public final String getName() {
		return super.getName() + ".atlases";
	}

	/*
	 * HELPER METHODS
	 */

	protected final SourceList atlas(ResourceLocation atlas) {
		return resources.computeIfAbsent(atlas, $ -> new SourceList());
	}

	protected static final class SourceList {
		private final List<SpriteSource> sources = new ArrayList<>();

		public SourceList addSource(SpriteSource source) {
			sources.add(source);
			return this;
		}
	}
}
