package com.technologica.api.tlrg.resourcegen;

import com.technologica.Technologica;

import net.minecraftforge.common.data.BlockTagsProvider;

public abstract class TLRGTagsBlocksGenerator extends BlockTagsProvider {
	public TLRGTagsBlocksGenerator() {
		super(TLRGMasterResourceGenerator.packOutput, TLRGMasterResourceGenerator.lookupProvider, Technologica.MOD_ID, TLRGMasterResourceGenerator.helper);
	}

	@Override
	public String getName() {
		return "TLRG - data." + Technologica.MOD_ID + ".tags.blocks";
	}
}
