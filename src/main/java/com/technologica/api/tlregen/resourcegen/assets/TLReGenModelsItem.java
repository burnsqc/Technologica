package com.technologica.api.tlregen.resourcegen.assets;

import com.technologica.api.tlregen.resourcegen.TLRGMasterResourceGenerator;
import com.technologica.api.tlregen.resourcegen.util.TLReGenModelProvider;

import net.minecraftforge.client.model.generators.ItemModelBuilder;

public abstract class TLReGenModelsItem extends TLReGenModelProvider<ItemModelBuilder> {
	public TLReGenModelsItem() {
		super(TLRGMasterResourceGenerator.packOutput, TLRGMasterResourceGenerator.modid, ITEM_FOLDER, ItemModelBuilder::new, TLRGMasterResourceGenerator.helper);
	}

	@Override
	public String getName() {
		return "assets." + TLRGMasterResourceGenerator.modid + ".models.item";
	}
}
