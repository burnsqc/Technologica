package com.technologica.api.tlregen.resourcegen.assets;

import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.CompletableFuture;
import java.util.function.Supplier;

import com.google.gson.JsonObject;
import com.technologica.api.tlregen.resourcegen.TLRGMasterResourceGenerator;

import net.minecraft.data.CachedOutput;
import net.minecraft.data.DataProvider;
import net.minecraft.data.PackOutput;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.item.CreativeModeTab;

public abstract class TLReGenLang extends TLRGMasterResourceGenerator implements DataProvider {
	private final Map<String, String> data = new TreeMap<>();

	protected TLReGenLang() {
	}

	@Override
	public final CompletableFuture<?> run(CachedOutput cache) {
		populate();

		if (!data.isEmpty()) {
			JsonObject json = new JsonObject();
			data.forEach(json::addProperty);
			return DataProvider.saveStable(cache, json, packOutput.getOutputFolder(PackOutput.Target.RESOURCE_PACK).resolve(modid).resolve("lang").resolve("en_us.json"));
		}

		return CompletableFuture.allOf();
	}

	@Override
	public final String getName() {
		return "assets." + modid + ".lang";
	}

	protected abstract void populate();

	/*
	 * HELPER METHODS
	 */

	protected final void addCommand(Supplier<? extends MobEffect> key, String name) {
		add(key.get().getDescriptionId(), name);
	}

	protected final void addDeath(Supplier<? extends MobEffect> key, String name) {
		add(key.get().getDescriptionId(), name);
	}

	protected final void addEffect(Supplier<? extends MobEffect> key, String name) {
		add(key.get().getDescriptionId(), name);
	}

	protected final void addItemGroup(Supplier<? extends CreativeModeTab> key, String name) {
		add(key.get().getDisplayName().getString(), name);
	}

	protected final void add(String key, String value) {
		if (data.put(key, value) != null) {
			throw new IllegalStateException("Duplicate translation key " + key);
		}
	}
}
