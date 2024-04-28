package com.technologica.api.tlregen.resourcegen.assets;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.mojang.serialization.DynamicOps;
import com.mojang.serialization.JsonOps;
import com.technologica.api.tlregen.resourcegen.TLRGMasterResourceGenerator;

import net.minecraft.client.renderer.texture.atlas.SpriteSource;
import net.minecraft.client.renderer.texture.atlas.SpriteSources;
import net.minecraft.data.CachedOutput;
import net.minecraft.data.DataProvider;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;

public abstract class TLReGenAtlases extends TLRGMasterResourceGenerator implements DataProvider {
	private final Map<ResourceLocation, SourceList> atlases = new HashMap<>();
	protected final DynamicOps<JsonElement> dynamicOps = JsonOps.INSTANCE;
	private boolean performValidation = true;

	/**
	 * OVERRIDE ME TO ADD ATLASES
	 */
	protected abstract void populate();

	@Override
	public CompletableFuture<?> run(final CachedOutput cache) {
		CompletableFuture<?> completable = CompletableFuture.allOf();

		atlases.clear();
		populate();
		if (performValidation) {
			// validate();
		}

		if (!atlases.isEmpty()) {
			List<CompletableFuture<?>> list = new ArrayList<CompletableFuture<?>>();
			atlases.forEach((key, value) -> {
				JsonObject json = SpriteSources.FILE_CODEC.encodeStart(dynamicOps, value.sources).getOrThrow(false, msg -> LOGGER.error("")).getAsJsonObject();
				list.add(DataProvider.saveStable(cache, json, packOutput.createPathProvider(PackOutput.Target.RESOURCE_PACK, "atlases").json(key)));
			});
			completable = CompletableFuture.allOf(list.toArray(CompletableFuture[]::new));
		}

		return completable;
	}

	@Override
	public final String getName() {
		return "assets." + modid + ".atlases";
	}

	/*
	 * INTERNAL MECHANICS
	 */

	protected final SourceList atlas(ResourceLocation atlas) {
		return atlases.computeIfAbsent(atlas, $ -> new SourceList());
	}

	protected static final class SourceList {
		private final List<SpriteSource> sources = new ArrayList<>();

		public SourceList addSource(SpriteSource source) {
			sources.add(source);
			return this;
		}
	}
}
