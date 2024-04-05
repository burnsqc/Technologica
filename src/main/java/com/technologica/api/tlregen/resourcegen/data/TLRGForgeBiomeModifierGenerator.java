package com.technologica.api.tlregen.resourcegen.data;

import java.util.Set;

import com.technologica.Technologica;
import com.technologica.api.tlregen.resourcegen.TLRGMasterResourceGenerator;
import com.technologica.resourcegen.data.worldgen.biome.TLForgeBiomeModifierGenerator;

import net.minecraftforge.common.data.DatapackBuiltinEntriesProvider;
import net.minecraftforge.registries.ForgeRegistries;

public abstract class TLRGForgeBiomeModifierGenerator extends DatapackBuiltinEntriesProvider {
	public TLRGForgeBiomeModifierGenerator() {
		super(TLRGMasterResourceGenerator.packOutput, TLRGMasterResourceGenerator.lookupProvider, TLRGMasterResourceGenerator.registrySetBuilder.add(ForgeRegistries.Keys.BIOME_MODIFIERS, TLForgeBiomeModifierGenerator::bootstrap), Set.of(Technologica.MOD_ID));
	}

	@Override
	public String getName() {
		return "data." + Technologica.MOD_ID + ".forge.biome_modifier";
	}
}
