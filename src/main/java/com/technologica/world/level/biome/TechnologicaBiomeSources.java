package com.technologica.world.level.biome;

import com.mojang.serialization.Codec;

import net.minecraft.core.Registry;
import net.minecraft.world.level.biome.BiomeSource;

public class TechnologicaBiomeSources {
	public static void bootstrap(Registry<Codec<? extends BiomeSource>> p_220587_) {
		Registry.register(p_220587_, "moon", MoonBiomeSource.CODEC);
	}
}
