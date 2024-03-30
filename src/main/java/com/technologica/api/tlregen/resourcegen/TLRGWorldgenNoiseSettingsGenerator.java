package com.technologica.api.tlregen.resourcegen;

import java.util.Set;

import com.technologica.Technologica;
import com.technologica.resourcegen.data.worldgen.noisesettings.TLWorldgenNoiseSettingsGenerator;

import net.minecraft.core.registries.Registries;
import net.minecraftforge.common.data.DatapackBuiltinEntriesProvider;

public abstract class TLRGWorldgenNoiseSettingsGenerator extends DatapackBuiltinEntriesProvider {
	public TLRGWorldgenNoiseSettingsGenerator() {
		super(TLRGMasterResourceGenerator.packOutput, TLRGMasterResourceGenerator.lookupProvider, TLRGMasterResourceGenerator.registrySetBuilder.add(Registries.NOISE_SETTINGS, TLWorldgenNoiseSettingsGenerator::bootstrap), Set.of(Technologica.MOD_ID));
	}

	@Override
	public String getName() {
		return "TLRG - data." + Technologica.MOD_ID + ".worldgen.noise_settings";
	}
}
