package com.technologica.resourcegen.assets.particles;

import com.technologica.Technologica;
import com.technologica.registration.deferred.TechnologicaParticleTypes;

import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.common.data.ParticleDescriptionProvider;

public class ParticleDataGenerator extends ParticleDescriptionProvider {

	public ParticleDataGenerator(PackOutput output, ExistingFileHelper fileHelper) {
		super(output, fileHelper);
	}

	@Override
	protected void addDescriptions() {
		sprite(TechnologicaParticleTypes.DRIPPING_FLUID.get(), new ResourceLocation("drip_hang"));
		sprite(TechnologicaParticleTypes.FALLING_FLUID.get(), new ResourceLocation("drip_fall"));
		sprite(TechnologicaParticleTypes.LANDING_FLUID.get(), new ResourceLocation("drip_land"));
		sprite(TechnologicaParticleTypes.FLYING_RADIATION.get(), new ResourceLocation("drip_fall"));
	}
	
	@Override
    public String getName() {
        return "Particles: " + Technologica.MOD_ID;
    }
}