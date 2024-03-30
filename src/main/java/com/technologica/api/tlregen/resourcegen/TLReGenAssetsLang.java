package com.technologica.api.tlregen.resourcegen;

import java.nio.file.Path;
import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.CompletableFuture;
import java.util.function.Supplier;

import com.google.gson.JsonObject;

import net.minecraft.data.CachedOutput;
import net.minecraft.data.DataProvider;
import net.minecraft.data.PackOutput;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.item.CreativeModeTab;

public abstract class TLReGenAssetsLang extends TLRGMasterResourceGenerator implements DataProvider {
	private final Map<String, String> data = new TreeMap<>();

	public TLReGenAssetsLang() {
	}

	@Override
	public CompletableFuture<?> run(CachedOutput cache) {
		populate();

		if (!data.isEmpty())
			return save(cache, packOutput.getOutputFolder(PackOutput.Target.RESOURCE_PACK).resolve(modid).resolve("lang").resolve("en_us.json"));

		return CompletableFuture.allOf();
	}

	protected abstract void populate();

	private CompletableFuture<?> save(CachedOutput cache, Path target) {
		JsonObject json = new JsonObject();
		this.data.forEach(json::addProperty);
		return DataProvider.saveStable(cache, json, target);
	}

	@Override
	public String getName() {
		return "assets." + modid + ".lang";
	}

	/*
	 * HELPER METHODS
	 */

	protected void addCommand(Supplier<? extends MobEffect> key, String name) {
		add(key.get().getDescriptionId(), name);
	}

	protected void addDeath(Supplier<? extends MobEffect> key, String name) {
		add(key.get().getDescriptionId(), name);
	}

	protected void addEffect(Supplier<? extends MobEffect> key, String name) {
		add(key.get().getDescriptionId(), name);
	}

	protected void addItemGroup(Supplier<? extends CreativeModeTab> key, String name) {
		add(key.get().getDisplayName().getString(), name);
	}

	protected void add(String key, String value) {
		if (data.put(key, value) != null) {
			throw new IllegalStateException("Duplicate translation key " + key);
		}
	}
}
