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
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.damagesource.DamageType;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;

public abstract class TLReGenLang extends TLRGMasterResourceGenerator implements DataProvider {
	private final Map<String, String> entries = new TreeMap<>();

	/**
	 * OVERRIDE ME TO ADD TRANSLATIONS
	 */
	protected abstract void populate();

	@Override
	public final CompletableFuture<?> run(CachedOutput cache) {
		entries.clear();
		populate();

		if (!entries.isEmpty()) {
			JsonObject json = new JsonObject();
			entries.forEach(json::addProperty);
			return DataProvider.saveStable(cache, json, packOutput.getOutputFolder(PackOutput.Target.RESOURCE_PACK).resolve(modid).resolve("lang").resolve("en_us.json"));
		}

		return CompletableFuture.allOf();
	}

	@Override
	public final String getName() {
		return "assets." + modid + ".lang";
	}

	/*
	 * HELPER METHODS
	 */

	protected final void addCommand(Supplier<? extends MobEffect> key, String name) {
		add(key.get().getDescriptionId(), name);
	}

	protected final void addDeath(ResourceKey<DamageType> damageType, String translation) {
		add("death.attack." + damageType.location().getPath(), "%1$s " + translation);
		add("death.attack." + damageType.location().getPath() + ".player", "%1$s " + translation + " whilst fighting %2$s");
	}

	protected final void addEffect(Supplier<? extends MobEffect> mobEffect, String translation) {
		add(mobEffect.get().getDescriptionId(), translation);
	}

	protected final void addEntityType(Supplier<? extends EntityType<?>> entity, String translation) {
		add(entity.get().getDescriptionId(), translation);
	}

	protected final void addItem(Supplier<? extends Item> item, String translation) {
		add(item.get().getDescriptionId(), translation);
	}

	protected final void addItemGroup(Supplier<? extends CreativeModeTab> itemGroup, String translation) {
		add(itemGroup.get().getDisplayName().getString(), translation);
	}

	protected final void add(String key, String value) {
		if (entries.put(key, value) != null) {
			throw new IllegalStateException("Duplicate translation key " + key);
		}
	}
}
