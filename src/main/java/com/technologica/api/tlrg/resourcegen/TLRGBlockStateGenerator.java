package com.technologica.api.tlrg.resourcegen;

import com.technologica.Technologica;

import net.minecraftforge.client.model.generators.BlockStateProvider;

public abstract class TLRGBlockStateGenerator extends BlockStateProvider {
	public TLRGBlockStateGenerator() {
		super(TLRGMasterResourceGenerator.packOutput, Technologica.MOD_ID, TLRGMasterResourceGenerator.helper);
	}

	@Override
	public String getName() {
		return "TLRG - assets." + Technologica.MOD_ID + ".blockstates";
	}
}
