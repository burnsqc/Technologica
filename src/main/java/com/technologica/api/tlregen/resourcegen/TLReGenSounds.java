package com.technologica.api.tlregen.resourcegen;

import com.technologica.Technologica;

import net.minecraftforge.common.data.SoundDefinitionsProvider;

public abstract class TLReGenSounds extends SoundDefinitionsProvider {
	public TLReGenSounds() {
		super(TLRGMasterResourceGenerator.packOutput, Technologica.MOD_ID, TLRGMasterResourceGenerator.helper);
	}

	@Override
	public String getName() {
		return "assets." + Technologica.MOD_ID + ".sounds";
	}
}
