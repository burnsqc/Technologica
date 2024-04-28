package com.technologica.api.tlregen.resourcegen.assets;

import com.technologica.api.tlregen.resourcegen.TLRGMasterResourceGenerator;
import com.technologica.api.tlregen.resourcegen.util.TLReGenModelProvider;

import net.minecraftforge.client.model.generators.BlockModelBuilder;

public abstract class TLReGenModelsBlock extends TLReGenModelProvider<BlockModelBuilder> {

	public TLReGenModelsBlock() {
		super(TLRGMasterResourceGenerator.packOutput, TLRGMasterResourceGenerator.modid, BLOCK_FOLDER, BlockModelBuilder::new, TLRGMasterResourceGenerator.helper);
	}

	@Override
	public String getName() {
		return "assets." + TLRGMasterResourceGenerator.modid + ".models.block";
	}
}
