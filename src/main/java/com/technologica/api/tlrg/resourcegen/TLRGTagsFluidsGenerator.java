package com.technologica.api.tlrg.resourcegen;

import com.technologica.Technologica;

import net.minecraft.data.tags.FluidTagsProvider;

public abstract class TLRGTagsFluidsGenerator extends FluidTagsProvider {
	public TLRGTagsFluidsGenerator() {
		super(TLRGMasterResourceGenerator.packOutput, TLRGMasterResourceGenerator.lookupProvider, Technologica.MOD_ID, TLRGMasterResourceGenerator.helper);
	}

	@Override
	public String getName() {
		return "TLRG - data." + Technologica.MOD_ID + ".tags.fluids";
	}
}
