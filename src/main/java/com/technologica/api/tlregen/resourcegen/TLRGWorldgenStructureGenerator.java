package com.technologica.api.tlregen.resourcegen;

import java.util.Set;

import com.technologica.Technologica;
import com.technologica.resourcegen.data.worldgen.structure.TLWorldgenStructureGenerator;

import net.minecraft.core.registries.Registries;
import net.minecraftforge.common.data.DatapackBuiltinEntriesProvider;

public abstract class TLRGWorldgenStructureGenerator extends DatapackBuiltinEntriesProvider {
	public TLRGWorldgenStructureGenerator() {
		super(TLRGMasterResourceGenerator.packOutput, TLRGMasterResourceGenerator.lookupProvider, TLRGMasterResourceGenerator.registrySetBuilder.add(Registries.STRUCTURE, TLWorldgenStructureGenerator::bootstrap), Set.of(Technologica.MOD_ID));
	}

	@Override
	public String getName() {
		return "TLRG - data." + Technologica.MOD_ID + ".worldgen.structure";
	}
}
