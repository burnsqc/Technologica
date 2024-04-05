package com.technologica.api.tlregen.resourcegen.assets;

import com.technologica.Technologica;
import com.technologica.api.tlregen.resourcegen.TLRGMasterResourceGenerator;

import net.minecraftforge.client.model.generators.ItemModelProvider;

public abstract class TLReGenModelsItem extends ItemModelProvider {
	public TLReGenModelsItem() {
		super(TLRGMasterResourceGenerator.packOutput, Technologica.MOD_ID, TLRGMasterResourceGenerator.helper);
	}

	@Override
	public String getName() {
		return "assets." + Technologica.MOD_ID + ".models.item";
	}
}
