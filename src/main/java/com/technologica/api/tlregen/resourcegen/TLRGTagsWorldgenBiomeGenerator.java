package com.technologica.api.tlregen.resourcegen;

import com.technologica.Technologica;

import net.minecraft.data.tags.BiomeTagsProvider;

public abstract class TLRGTagsWorldgenBiomeGenerator extends BiomeTagsProvider {
	public TLRGTagsWorldgenBiomeGenerator() {
		super(TLRGMasterResourceGenerator.packOutput, TLRGMasterResourceGenerator.lookupProvider, Technologica.MOD_ID, TLRGMasterResourceGenerator.helper);
	}

	@Override
	public String getName() {
		return "TLRG - data." + Technologica.MOD_ID + ".tags.worldgen.biome";
	}
}
