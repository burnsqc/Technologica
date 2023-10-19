package com.technologica.world.level.biome;

import com.google.common.collect.ImmutableList;
import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;

import net.minecraft.core.Holder;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.QuartPos;
import net.minecraft.core.SectionPos;
import net.minecraft.resources.RegistryOps;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.BiomeSource;
import net.minecraft.world.level.biome.Climate;
import net.minecraft.world.level.levelgen.DensityFunction;

public class MoonBiomeSource extends BiomeSource {
	public static final Codec<MoonBiomeSource> CODEC = RecordCodecBuilder.create((p_255555_) -> {
		return p_255555_.group(RegistryOps.retrieveElement(com.technologica.world.level.biome.TechnologicaBiomes.CRATER_FIELDS), RegistryOps.retrieveElement(com.technologica.world.level.biome.TechnologicaBiomes.SILENT_EXPANSES), RegistryOps.retrieveElement(com.technologica.world.level.biome.TechnologicaBiomes.SHATTERED_CORRIDORS)).apply(p_255555_, p_255555_.stable(MoonBiomeSource::new));
	});

	private final Holder<Biome> end;
	private final Holder<Biome> highlands;
	private final Holder<Biome> midlands;

	public static MoonBiomeSource create(HolderGetter<Biome> p_256561_) {
		return new MoonBiomeSource(p_256561_.getOrThrow(com.technologica.world.level.biome.TechnologicaBiomes.CRATER_FIELDS), p_256561_.getOrThrow(com.technologica.world.level.biome.TechnologicaBiomes.SILENT_EXPANSES), p_256561_.getOrThrow(com.technologica.world.level.biome.TechnologicaBiomes.SHATTERED_CORRIDORS));
	}

	private MoonBiomeSource(Holder<Biome> p_220678_, Holder<Biome> p_220679_, Holder<Biome> p_220680_) {
		super(ImmutableList.of(p_220678_, p_220679_, p_220680_));
		this.end = p_220678_;
		this.highlands = p_220679_;
		this.midlands = p_220680_;
	}

	@Override
	protected Codec<? extends BiomeSource> codec() {
		return CODEC;
	}

	@Override
	public Holder<Biome> getNoiseBiome(int p_204292_, int p_204293_, int p_204294_, Climate.Sampler p_204295_) {
		int i = QuartPos.toBlock(p_204292_);
		int j = QuartPos.toBlock(p_204293_);
		int k = QuartPos.toBlock(p_204294_);
		int l = SectionPos.blockToSectionCoord(i);
		int i1 = SectionPos.blockToSectionCoord(k);
		if ((long) l * (long) l + (long) i1 * (long) i1 <= 4096L) {
			return this.end;
		} else {
			int j1 = (SectionPos.blockToSectionCoord(i) * 2 + 1) * 8;
			int k1 = (SectionPos.blockToSectionCoord(k) * 2 + 1) * 8;
			double d0 = p_204295_.erosion().compute(new DensityFunction.SinglePointContext(j1, j, k1));
			if (d0 > 0.25D) {
				return this.highlands;
			} else if (d0 >= -0.0625D) {
				return this.midlands;
			} else {
				return this.midlands;
			}
		}
	}
}