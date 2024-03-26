package com.technologica.api.tlrg.resourcegen;

import com.technologica.Technologica;

import net.minecraftforge.common.data.GlobalLootModifierProvider;

public abstract class TLRGLootModifierGenerator extends GlobalLootModifierProvider {
	public TLRGLootModifierGenerator() {
		super(TLRGMasterResourceGenerator.packOutput, Technologica.MOD_ID);
	}

	@Override
	public String getName() {
		return "TLRG - data." + Technologica.MOD_ID + ".loot_modifier";
	}
}
