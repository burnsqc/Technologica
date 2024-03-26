package com.technologica.api.tlrg.resourcegen;

import com.technologica.Technologica;

import net.minecraft.data.tags.ItemTagsProvider;

public abstract class TLRGTagsItemsGenerator extends ItemTagsProvider {
	public TLRGTagsItemsGenerator() {
		super(TLRGMasterResourceGenerator.packOutput, TLRGMasterResourceGenerator.lookupProvider, TLRGMasterResourceGenerator.TagBlocks.contentsGetter(), Technologica.MOD_ID, TLRGMasterResourceGenerator.helper);
	}

	@Override
	public String getName() {
		return "TLRG - data." + Technologica.MOD_ID + ".tags.items";
	}
}
