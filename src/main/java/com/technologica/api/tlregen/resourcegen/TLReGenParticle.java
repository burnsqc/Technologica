package com.technologica.api.tlregen.resourcegen;

import com.technologica.Technologica;

import net.minecraftforge.common.data.ParticleDescriptionProvider;

public abstract class TLReGenParticle extends ParticleDescriptionProvider {
	public TLReGenParticle() {
		super(TLRGMasterResourceGenerator.packOutput, TLRGMasterResourceGenerator.helper);
	}

	@Override
	public String getName() {
		return "assets." + Technologica.MOD_ID + ".particles";
	}
}
