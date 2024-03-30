package com.technologica.api.tlregen.resourcegen;

import com.technologica.Technologica;

import net.minecraft.data.tags.PaintingVariantTagsProvider;

public abstract class TLRGTagsPaintingVariantGenerator extends PaintingVariantTagsProvider {
	public TLRGTagsPaintingVariantGenerator() {
		super(TLRGMasterResourceGenerator.packOutput, TLRGMasterResourceGenerator.lookupProvider, Technologica.MOD_ID, TLRGMasterResourceGenerator.helper);
	}

	@Override
	public String getName() {
		return "TLRG - data." + Technologica.MOD_ID + ".tags.painting_variant";
	}
}
