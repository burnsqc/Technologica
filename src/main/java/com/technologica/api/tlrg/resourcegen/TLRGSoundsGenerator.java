package com.technologica.api.tlrg.resourcegen;

import com.technologica.Technologica;

import net.minecraftforge.common.data.SoundDefinitionsProvider;

public abstract class TLRGSoundsGenerator extends SoundDefinitionsProvider {
	public TLRGSoundsGenerator() {
		super(TLRGMasterResourceGenerator.packOutput, Technologica.MOD_ID, TLRGMasterResourceGenerator.helper);
	}

	@Override
	public String getName() {
		return "TLRG - assets." + Technologica.MOD_ID + ".sounds";
	}
}
