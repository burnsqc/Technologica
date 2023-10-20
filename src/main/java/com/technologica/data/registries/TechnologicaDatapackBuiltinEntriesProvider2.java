package com.technologica.data.registries;

import java.util.concurrent.CompletableFuture;

import com.mojang.serialization.Codec;
import com.technologica.Technologica;

import net.minecraft.core.HolderLookup.Provider;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.PackOutput;
import net.minecraft.data.info.BiomeParametersDumpReport;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.biome.BiomeSource;

public class TechnologicaDatapackBuiltinEntriesProvider2 extends BiomeParametersDumpReport {
	private static final ResourceKey<Codec<? extends BiomeSource>> MOON_STEM = ResourceKey.create(Registries.BIOME_SOURCE, new ResourceLocation(Technologica.MODID, "moon"));

	public TechnologicaDatapackBuiltinEntriesProvider2(PackOutput packOutput, CompletableFuture<Provider> p_256222_) {
		super(packOutput, p_256222_);
		// MultiNoiseBiomeSource.Preset MOON = new MultiNoiseBiomeSource.Preset(new ResourceLocation(Technologica.MODID, "moon"), (p_255954_) -> {
		// return new Climate.ParameterList<>(ImmutableList.of(Pair.of(Climate.parameters(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F), p_255954_.getOrThrow(com.technologica.world.level.biome.TechnologicaBiomes.SILENT_EXPANSES)), Pair.of(Climate.parameters(0.0F, -0.5F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F), p_255954_.getOrThrow(com.technologica.world.level.biome.TechnologicaBiomes.SILENT_EXPANSES)), Pair.of(Climate.parameters(0.4F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F), p_255954_.getOrThrow(com.technologica.world.level.biome.TechnologicaBiomes.SILENT_EXPANSES))));
		// });
	}
}