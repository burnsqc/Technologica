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
import net.minecraft.client.gui.font.providers.GlyphProviderDefinition;
import net.minecraft.data.CachedOutput;
import net.minecraft.data.DataProvider;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.common.crafting.CraftingHelper;
import net.minecraftforge.common.crafting.conditions.ICondition;

public abstract class TLReGenFont extends TLRGMasterResourceGenerator implements DataProvider {
	private final Map<ResourceLocation, ProviderList> font = new HashMap<>();
	protected final DynamicOps<JsonElement> dynamicOps = JsonOps.INSTANCE;
	protected Map<ResourceLocation, ICondition[]> conditions = Collections.emptyMap();

	public TLReGenFont() {
	}

	@Override
	public CompletableFuture<?> run(final CachedOutput cache) {
		ImmutableList.Builder<CompletableFuture<?>> futuresBuilder = new ImmutableList.Builder<>();

		gather(LamdbaExceptionUtils.rethrowBiConsumer((id, value) -> {
			final Path path = packOutput.getOutputFolder(PackOutput.Target.RESOURCE_PACK).resolve(id.getNamespace()).resolve("font").resolve(id.getPath() + ".json");

			JsonElement encoded = GlyphProviderDefinition.CODEC.listOf().fieldOf("providers").codec().encodeStart(this.dynamicOps, value).getOrThrow(false, msg -> LOGGER.error("Failed to encode {}: {}", path, msg));

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

	protected void gather(BiConsumer<ResourceLocation, List<GlyphProviderDefinition>> consumer) {
		populate();
		font.forEach((font, srcList) -> consumer.accept(font, srcList.sources));
	}

	/**
	 * Override this method to add fonts.
	 * 
	 * For each new font json to generate, use the {@link TLReGenFont.font} method.
	 */
	protected abstract void populate();

	@Override
	public final String getName() {
		return "assets." + modid + ".font";
	}

	protected final ProviderList font(ResourceLocation atlas) {
		return font.computeIfAbsent(atlas, $ -> new ProviderList());
	}

	protected static final class ProviderList {
		private List<GlyphProviderDefinition> sources = new ArrayList<>();

		public ProviderList addProvider(GlyphProviderDefinition source) {
			sources.add(source);
			return this;
		}
	}
}
