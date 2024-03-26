package com.technologica.api.tlrg.resourcegen;

import com.technologica.Technologica;

import net.minecraftforge.client.model.generators.ItemModelProvider;

public abstract class TLRGModelItemGenerator extends ItemModelProvider {
	public TLRGModelItemGenerator() {
		super(TLRGMasterResourceGenerator.packOutput, Technologica.MOD_ID, TLRGMasterResourceGenerator.helper);
	}

	@Override
	public String getName() {
		return "TLRG - assets." + Technologica.MOD_ID + ".models.item";
	}
}
