package com.technologica.api.tlrg.resourcegen;

import com.technologica.Technologica;

import net.minecraftforge.common.data.LanguageProvider;

public abstract class TLRGLanguageGenerator extends LanguageProvider {
	public TLRGLanguageGenerator() {
		super(TLRGMasterResourceGenerator.packOutput, Technologica.MOD_ID, "en_us");
	}

	@Override
	public String getName() {
		return "TLRG - assets." + Technologica.MOD_ID + ".lang";
	}
}
