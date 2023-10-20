package com.technologica.world.level.biome;

import java.util.function.Function;

import com.google.common.collect.ImmutableList;
import com.mojang.datafixers.util.Pair;
import com.technologica.Technologica;

import net.minecraft.core.Holder;
import net.minecraft.core.HolderGetter;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.Biomes;
import net.minecraft.world.level.biome.Climate;
import net.minecraft.world.level.biome.Climate.ParameterList;
import net.minecraft.world.level.biome.MultiNoiseBiomeSource;

public class TechnologicaMultiNoiseBiomeSource {
	public static class Preset extends MultiNoiseBiomeSource.Preset {
		public Preset(ResourceLocation p_187090_, Function<HolderGetter<Biome>, ParameterList<Holder<Biome>>> p_187091_) {
			super(p_187090_, p_187091_);
		}

		public static final MultiNoiseBiomeSource.Preset MOON = new MultiNoiseBiomeSource.Preset(new ResourceLocation(Technologica.MODID, "moon"), (p_255954_) -> {
			return new Climate.ParameterList<>(ImmutableList.of(Pair.of(Climate.parameters(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F), p_255954_.getOrThrow(com.technologica.world.level.biome.TechnologicaBiomes.SILENT_EXPANSES)), Pair.of(Climate.parameters(0.0F, -0.5F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F), p_255954_.getOrThrow(Biomes.SOUL_SAND_VALLEY)), Pair.of(Climate.parameters(0.4F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F), p_255954_.getOrThrow(Biomes.CRIMSON_FOREST)), Pair.of(Climate.parameters(0.0F, 0.5F, 0.0F, 0.0F, 0.0F, 0.0F, 0.375F), p_255954_.getOrThrow(Biomes.WARPED_FOREST)), Pair.of(Climate.parameters(-0.5F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.175F), p_255954_.getOrThrow(Biomes.BASALT_DELTAS))));
		});

		@Override
		public MultiNoiseBiomeSource biomeSource(HolderGetter<Biome> p_255641_) {
			return this.biomeSource(p_255641_, false);
		}
	}
}
