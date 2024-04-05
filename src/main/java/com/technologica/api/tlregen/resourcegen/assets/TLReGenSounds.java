package com.technologica.api.tlregen.resourcegen.assets;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.function.Supplier;

import com.google.gson.JsonObject;
import com.technologica.Technologica;
import com.technologica.api.tlregen.resourcegen.TLRGMasterResourceGenerator;

import net.minecraft.data.CachedOutput;
import net.minecraft.data.DataProvider;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.packs.PackType;
import net.minecraft.sounds.SoundEvent;
import net.minecraftforge.common.data.SoundDefinition;
import net.minecraftforge.registries.ForgeRegistries;

public abstract class TLReGenSounds extends TLRGMasterResourceGenerator implements DataProvider {
	private final Map<String, SoundDefinition> data = new LinkedHashMap<>();

	protected TLReGenSounds() {
	}

	@Override
	public CompletableFuture<?> run(CachedOutput cache) {
		data.clear();
		populate();

		this.validate();

		if (!this.data.isEmpty()) {
			JsonObject obj = new JsonObject();
			data.forEach((k, v) -> obj.add(k, v.serialize()));
			return DataProvider.saveStable(cache, obj, packOutput.getOutputFolder(PackOutput.Target.RESOURCE_PACK).resolve(modid).resolve("sounds.json"));
		}

		return CompletableFuture.allOf();
	}

	private void validate() {
		final List<String> notValid = data.entrySet().stream().filter(it -> !this.validate(it.getKey(), it.getValue())).map(Map.Entry::getKey).map(it -> modid + ":" + it).toList();
		if (!notValid.isEmpty()) {
			throw new IllegalStateException("Found invalid sound events: " + notValid);
		}
	}

	private boolean validate(final String name, final SoundDefinition def) {
		return def.soundList().stream().allMatch(it -> this.validate(name, it));
	}

	private boolean validate(final String name, final SoundDefinition.Sound sound) {
		switch (sound.type()) {
		case SOUND:
			return this.validateSound(name, sound.name());
		case EVENT:
			return this.validateEvent(name, sound.name());
		}
		throw new IllegalArgumentException("The given sound '" + sound.name() + "' does not have a valid type: expected either SOUND or EVENT, but found " + sound.type());
	}

	private boolean validateSound(final String soundName, final ResourceLocation name) {
		final boolean valid = helper.exists(name, PackType.CLIENT_RESOURCES, ".ogg", "sounds");
		if (!valid) {
			final String path = name.getNamespace() + ":sounds/" + name.getPath() + ".ogg";
			LOGGER.warn("Unable to find corresponding OGG file '{}' for sound event '{}'", path, soundName);
		}
		return valid;
	}

	private boolean validateEvent(final String soundName, final ResourceLocation name) {
		final boolean valid = data.containsKey(soundName) || ForgeRegistries.SOUND_EVENTS.containsKey(name);
		if (!valid) {
			LOGGER.warn("Unable to find event '{}' referenced from '{}'", name, soundName);
		}
		return valid;
	}

	@Override
	public String getName() {
		return "assets." + Technologica.MOD_ID + ".sounds";
	}

	protected abstract void populate();

	/*
	 * HELPER METHODS
	 */

	protected void add(final Supplier<SoundEvent> soundEvent, final SoundDefinition definition) {
		add(soundEvent.get(), definition);
	}

	protected void add(final SoundEvent soundEvent, final SoundDefinition definition) {
		add(soundEvent.getLocation(), definition);
	}

	protected void add(final ResourceLocation soundEvent, final SoundDefinition definition) {
		addSounds(soundEvent.getPath(), definition);
	}

	private void addSounds(final String soundEvent, final SoundDefinition definition) {
		if (data.put(soundEvent, definition) != null) {
			throw new IllegalStateException("Sound event '" + modid + ":" + soundEvent + "' already exists");
		}
	}

	protected static SoundDefinition definition() {
		return SoundDefinition.definition();
	}

	protected static SoundDefinition.Sound sound(final ResourceLocation name) {
		return sound(name, SoundDefinition.SoundType.SOUND);
	}

	protected static SoundDefinition.Sound sound(final ResourceLocation name, final SoundDefinition.SoundType type) {
		return SoundDefinition.Sound.sound(name, type);
	}
}
