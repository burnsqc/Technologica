package com.technologica.api.tlrg.resourcegen;

import java.util.Set;

import com.technologica.Technologica;
import com.technologica.resourcegen.data.dimension.TLDimensionGenerator;

import net.minecraft.core.registries.Registries;
import net.minecraftforge.common.data.DatapackBuiltinEntriesProvider;

public abstract class TLRGDimensionGenerator extends DatapackBuiltinEntriesProvider {
	public TLRGDimensionGenerator() {
		super(TLRGMasterResourceGenerator.packOutput, TLRGMasterResourceGenerator.lookupProvider, TLRGMasterResourceGenerator.registrySetBuilder.add(Registries.LEVEL_STEM, TLDimensionGenerator::bootstrap), Set.of(Technologica.MOD_ID));
	}

	@Override
	public final String getName() {
		return "TLRG - data." + Technologica.MOD_ID + ".dimension";
	}
}
