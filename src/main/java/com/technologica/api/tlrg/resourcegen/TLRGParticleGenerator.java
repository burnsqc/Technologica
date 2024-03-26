package com.technologica.api.tlrg.resourcegen;

import com.technologica.Technologica;

import net.minecraftforge.common.data.ParticleDescriptionProvider;

public abstract class TLRGParticleGenerator extends ParticleDescriptionProvider {
	public TLRGParticleGenerator() {
		super(TLRGMasterResourceGenerator.packOutput, TLRGMasterResourceGenerator.helper);
	}

	@Override
	public String getName() {
		return "TLRG - assets." + Technologica.MOD_ID + ".particles";
	}
}
