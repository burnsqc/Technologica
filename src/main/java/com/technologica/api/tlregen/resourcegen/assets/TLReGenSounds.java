package com.technologica.api.tlregen.resourcegen.assets;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.function.Supplier;

import com.google.gson.JsonObject;
import com.technologica.api.tlregen.resourcegen.TLRGMasterResourceGenerator;
import com.technologica.api.tlregen.resourcegen.mirrors.TLReGenSoundDefinition;
import com.technologica.api.tlregen.resourcegen.util.helpers.TLReGenSoundHelper;

import net.minecraft.data.CachedOutput;
import net.minecraft.data.DataProvider;
import net.minecraft.data.PackOutput;
import net.minecraft.server.packs.PackType;
import net.minecraft.sounds.SoundEvent;
import net.minecraftforge.registries.ForgeRegistries;

public abstract class TLReGenSounds extends TLRGMasterResourceGenerator implements DataProvider, TLReGenSoundHelper {
	private final Map<String, TLReGenSoundDefinition> sounds = new LinkedHashMap<>();
	private boolean performValidation = true;

	/**
	 * OVERRIDE ME TO ADD SOUNDS
	 */
	protected abstract void populate();

	@Override
	public final CompletableFuture<?> run(CachedOutput cache) {
		CompletableFuture<?> completable = CompletableFuture.allOf();

		sounds.clear();
		populate();
		if (performValidation) {
			validate();
		}

		if (!sounds.isEmpty()) {
			JsonObject json = new JsonObject();
			sounds.forEach((key, value) -> json.add(key, value.serialize()));
			completable = DataProvider.saveStable(cache, json, packOutput.getOutputFolder(PackOutput.Target.RESOURCE_PACK).resolve(modid).resolve("sounds.json"));
		}

		return completable;
	}

	@Override
	public final String getName() {
		return "assets." + modid + ".sounds";
	}

	/*
	 * INTERNAL MECHANICS
	 */

	protected void add(final Supplier<SoundEvent> soundEventSupplier, final TLReGenSoundDefinition definition) {
		addSounds(soundEventSupplier.get().getLocation().getPath(), definition);
	}

	private void addSounds(final String soundEvent, final TLReGenSoundDefinition definition) {
		if (sounds.put(soundEvent, definition) != null) {
			throw new IllegalStateException("Sound '" + modid + ":" + soundEvent + "' already exists");
		}
	}

	private void validate() {
		final List<String> notValid = sounds.entrySet().stream().filter(entry -> !entry.getValue().soundList().stream().allMatch(sound -> {
			switch (sound.type()) {
			case SOUND:
				final boolean validSound = helper.exists(sound.name(), PackType.CLIENT_RESOURCES, ".ogg", "sounds");
				if (!validSound) {
					final String path = sound.name().getNamespace() + ":sounds/" + sound.name().getPath() + ".ogg";
					LOGGER.error("MISSING FILE: {} REFERENCED BY: {} IN ENTRY: {}", path, sound.name(), entry.getKey());
				}
				return validSound;
			case EVENT:
				final boolean validSoundEvent = sounds.containsKey(entry.getKey()) || ForgeRegistries.SOUND_EVENTS.containsKey(sound.name());
				if (!validSoundEvent) {
					LOGGER.error("Unable to find event '{}' referenced from '{}'", sound.name(), entry.getKey());
				}
				return validSoundEvent;
			}
			throw new IllegalArgumentException("The given sound '" + sound.name() + "' does not have a valid type: expected either SOUND or EVENT, but found " + sound.type());
		})).map(Map.Entry::getKey).map(string -> modid + ":" + string).toList();

		if (!notValid.isEmpty()) {
			throw new IllegalStateException("Found invalid sound events: " + notValid);
		}
	}
}
