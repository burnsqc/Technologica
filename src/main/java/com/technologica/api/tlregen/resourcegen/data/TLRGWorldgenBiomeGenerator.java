package com.technologica.api.tlregen.resourcegen.data;

import java.util.Set;

import com.technologica.Technologica;
import com.technologica.api.tlregen.resourcegen.TLRGMasterResourceGenerator;
import com.technologica.resourcegen.data.worldgen.biome.TLWorldgenBiomeGenerator;

import net.minecraft.core.registries.Registries;
import net.minecraftforge.common.data.DatapackBuiltinEntriesProvider;

public abstract class TLRGWorldgenBiomeGenerator extends DatapackBuiltinEntriesProvider {
	public TLRGWorldgenBiomeGenerator() {
		super(TLRGMasterResourceGenerator.packOutput, TLRGMasterResourceGenerator.lookupProvider, TLRGMasterResourceGenerator.registrySetBuilder.add(Registries.BIOME, TLWorldgenBiomeGenerator::bootstrap), Set.of(Technologica.MOD_ID));
	}

	@Override
	public String getName() {
		return "TLRG - data." + Technologica.MOD_ID + ".worldgen.biome";
	}
}
