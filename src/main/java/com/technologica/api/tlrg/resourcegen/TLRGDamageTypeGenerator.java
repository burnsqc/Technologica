package com.technologica.api.tlrg.resourcegen;

import java.util.Set;

import com.technologica.Technologica;

import net.minecraftforge.common.data.DatapackBuiltinEntriesProvider;

public abstract class TLRGDamageTypeGenerator extends DatapackBuiltinEntriesProvider {
	public TLRGDamageTypeGenerator() {
		super(TLRGMasterResourceGenerator.packOutput, TLRGMasterResourceGenerator.lookupProvider, TLRGMasterResourceGenerator.registrySetBuilder, Set.of(Technologica.MOD_ID));
	}

	@Override
	public String getName() {
		return "TLRG - data." + Technologica.MOD_ID + ".damage_type";
	}
}
