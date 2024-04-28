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

import net.minecraft.client.gui.font.providers.GlyphProviderDefinition;
import net.minecraft.data.CachedOutput;
import net.minecraft.data.DataProvider;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;

public abstract class TLReGenFont extends TLRGMasterResourceGenerator implements DataProvider {
	private final Map<ResourceLocation, ProviderList> fonts = new HashMap<>();
	protected final DynamicOps<JsonElement> dynamicOps = JsonOps.INSTANCE;
	private boolean performValidation = true;

	/**
	 * Override this method to add fonts.
	 * 
	 * For each new font json to generate, use the {@link TLReGenFont.font} method.
	 */
	protected abstract void populate();

	@Override
	public CompletableFuture<?> run(final CachedOutput cache) {
		CompletableFuture<?> completable = CompletableFuture.allOf();

		fonts.clear();
		populate();
		if (performValidation) {
			// validate();
		}

		if (!fonts.isEmpty()) {
			List<CompletableFuture<?>> list = new ArrayList<CompletableFuture<?>>();
			fonts.forEach((key, value) -> {
				JsonObject json = GlyphProviderDefinition.CODEC.listOf().fieldOf("providers").codec().encodeStart(this.dynamicOps, value.sources).getOrThrow(false, msg -> LOGGER.error("Failed to encode")).getAsJsonObject();
				list.add(DataProvider.saveStable(cache, json, packOutput.createPathProvider(PackOutput.Target.RESOURCE_PACK, "atlases").json(key)));
			});
			completable = CompletableFuture.allOf(list.toArray(CompletableFuture[]::new));
		}

		return completable;
	}

	@Override
	public final String getName() {
		return "assets." + modid + ".font";
	}

	protected final ProviderList font(ResourceLocation font) {
		return fonts.computeIfAbsent(font, $ -> new ProviderList());
	}

	protected static final class ProviderList {
		private List<GlyphProviderDefinition> sources = new ArrayList<>();

		public ProviderList addProvider(GlyphProviderDefinition source) {
			sources.add(source);
			return this;
		}
	}
}
