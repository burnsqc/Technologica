package com.technologica.api.tlregen.resourcegen.assets;

import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.function.BiConsumer;

import com.google.common.collect.ImmutableList;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.mojang.serialization.DynamicOps;
import com.mojang.serialization.JsonOps;
import com.technologica.api.tlregen.resourcegen.TLRGMasterResourceGenerator;

import cpw.mods.modlauncher.api.LamdbaExceptionUtils;
import net.minecraft.client.renderer.texture.atlas.SpriteSource;
import net.minecraft.client.renderer.texture.atlas.SpriteSources;
import net.minecraft.data.CachedOutput;
import net.minecraft.data.DataProvider;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.common.crafting.CraftingHelper;
import net.minecraftforge.common.crafting.conditions.ICondition;

public abstract class TLReGenAtlases extends TLRGMasterResourceGenerator implements DataProvider {
	private final Map<ResourceLocation, SourceList> atlases = new HashMap<>();
	protected final DynamicOps<JsonElement> dynamicOps = JsonOps.INSTANCE;
	protected Map<ResourceLocation, ICondition[]> conditions = Collections.emptyMap();

	public TLReGenAtlases() {
	}

	@Override
	public CompletableFuture<?> run(final CachedOutput cache) {
		ImmutableList.Builder<CompletableFuture<?>> futuresBuilder = new ImmutableList.Builder<>();

		gather(LamdbaExceptionUtils.rethrowBiConsumer((id, value) -> {
			final Path path = packOutput.getOutputFolder(PackOutput.Target.RESOURCE_PACK).resolve(id.getNamespace()).resolve("atlases").resolve(id.getPath() + ".json");

			JsonElement encoded = SpriteSources.FILE_CODEC.encodeStart(this.dynamicOps, value).getOrThrow(false, msg -> LOGGER.error("Failed to encode {}: {}", path, msg));

			ICondition[] conditions = this.conditions.get(id);
			if (conditions != null && conditions.length > 0) {
				if (encoded instanceof JsonObject obj) {
					obj.add("forge:conditions", CraftingHelper.serialize(conditions));
				} else {
					LOGGER.error("Attempted to apply conditions to a type that is not a JsonObject! - Path: {}", path);
				}
			}
			futuresBuilder.add(DataProvider.saveStable(cache, encoded, path));
		}));

		return CompletableFuture.allOf(futuresBuilder.build().toArray(CompletableFuture[]::new));
	}

	protected void gather(BiConsumer<ResourceLocation, List<SpriteSource>> consumer) {
		populate();
		atlases.forEach((atlas, srcList) -> consumer.accept(atlas, srcList.sources));
	}

	protected abstract void populate();

	@Override
	public final String getName() {
		return "assets." + modid + ".atlases";
	}

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
