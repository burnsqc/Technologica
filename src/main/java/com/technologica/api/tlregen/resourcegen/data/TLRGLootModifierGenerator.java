package com.technologica.api.tlregen.resourcegen.data;

import com.technologica.Technologica;
import com.technologica.api.tlregen.resourcegen.TLReGenMasterResourceGenerator;

import net.minecraftforge.common.data.GlobalLootModifierProvider;

public abstract class TLRGLootModifierGenerator extends GlobalLootModifierProvider {
	public TLRGLootModifierGenerator() {
		super(TLReGenMasterResourceGenerator.packOutput, Technologica.MOD_ID);
	}

	@Override
	public String getName() {
		return "data." + Technologica.MOD_ID + ".loot_modifier";
	}
}
