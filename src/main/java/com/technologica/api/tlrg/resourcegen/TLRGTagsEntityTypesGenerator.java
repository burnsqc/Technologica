package com.technologica.api.tlrg.resourcegen;

import com.technologica.Technologica;

import net.minecraft.data.tags.EntityTypeTagsProvider;

public abstract class TLRGTagsEntityTypesGenerator extends EntityTypeTagsProvider {
	public TLRGTagsEntityTypesGenerator() {
		super(TLRGMasterResourceGenerator.packOutput, TLRGMasterResourceGenerator.lookupProvider, Technologica.MOD_ID, TLRGMasterResourceGenerator.helper);
	}

	@Override
	public String getName() {
		return "TLRG - data." + Technologica.MOD_ID + ".tags.entity_types";
	}
}
