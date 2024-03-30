package com.technologica.api.tlregen.resourcegen;

import java.util.Set;

import com.technologica.Technologica;
import com.technologica.resourcegen.data.worldgen.configuredfeature.TLWorldgenConfiguredFeatureGenerator;

import net.minecraft.core.RegistrySetBuilder;
import net.minecraft.core.registries.Registries;
import net.minecraftforge.common.data.DatapackBuiltinEntriesProvider;

public abstract class TLRGWorldgenConfiguredFeatureGenerator extends DatapackBuiltinEntriesProvider {
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public TLRGWorldgenConfiguredFeatureGenerator() {
		super(TLRGMasterResourceGenerator.packOutput, TLRGMasterResourceGenerator.lookupProvider, TLRGMasterResourceGenerator.registrySetBuilder.add(Registries.CONFIGURED_FEATURE, (RegistrySetBuilder.RegistryBootstrap) TLWorldgenConfiguredFeatureGenerator::bootstrap), Set.of(Technologica.MOD_ID));
	}

	@Override
	public String getName() {
		return "TLRG - data." + Technologica.MOD_ID + ".worldgen.configured_feature";
	}
}
