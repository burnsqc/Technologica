package com.technologica.api.tlregen.resourcegen;

import java.util.Set;

import com.technologica.Technologica;
import com.technologica.resourcegen.data.worldgen.structuresets.TLWorldgenStructureSetGenerator;

import net.minecraft.core.registries.Registries;
import net.minecraftforge.common.data.DatapackBuiltinEntriesProvider;

public abstract class TLRGWorldgenStructureSetGenerator extends DatapackBuiltinEntriesProvider {
	public TLRGWorldgenStructureSetGenerator() {
		super(TLRGMasterResourceGenerator.packOutput, TLRGMasterResourceGenerator.lookupProvider, TLRGMasterResourceGenerator.registrySetBuilder.add(Registries.STRUCTURE_SET, TLWorldgenStructureSetGenerator::bootstrap), Set.of(Technologica.MOD_ID));
	}

	@Override
	public String getName() {
		return "TLRG - data." + Technologica.MOD_ID + ".worldgen.structure_set";
	}
}
