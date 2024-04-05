package com.technologica.api.tlregen.resourcegen.data;

import java.util.Set;

import com.technologica.Technologica;
import com.technologica.api.tlregen.resourcegen.TLRGMasterResourceGenerator;
import com.technologica.resourcegen.data.damagetype.TLDamageTypeGenerator;

import net.minecraft.core.registries.Registries;
import net.minecraftforge.common.data.DatapackBuiltinEntriesProvider;

public abstract class TLReGenDamageType extends DatapackBuiltinEntriesProvider {
	public TLReGenDamageType() {
		super(TLRGMasterResourceGenerator.packOutput, TLRGMasterResourceGenerator.lookupProvider, TLRGMasterResourceGenerator.registrySetBuilder.add(Registries.DAMAGE_TYPE, TLDamageTypeGenerator::bootstrap), Set.of(Technologica.MOD_ID));
	}

	@Override
	public String getName() {
		return "data." + Technologica.MOD_ID + ".damage_type";
	}
}