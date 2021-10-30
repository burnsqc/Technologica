package com.technologica.setup;

import com.technologica.client.particle.TechnologicaDripParticle;
import com.technologica.particles.TechnologicaParticleTypes;

import net.minecraft.client.Minecraft;
import net.minecraftforge.client.event.ParticleFactoryRegisterEvent;

public class ParticleSetup {
	@SuppressWarnings("resource")
	public static void init(final ParticleFactoryRegisterEvent event) {
		Minecraft.getInstance().particles.registerFactory(TechnologicaParticleTypes.DRIPPING_FLUID.get(), TechnologicaDripParticle.DrippingFactory::new);
		Minecraft.getInstance().particles.registerFactory(TechnologicaParticleTypes.FALLING_FLUID.get(), TechnologicaDripParticle.FallingFactory::new);
		Minecraft.getInstance().particles.registerFactory(TechnologicaParticleTypes.LANDING_FLUID.get(), TechnologicaDripParticle.LandingFactory::new);
		
		//Minecraft.getInstance().particles.registerFactory(TechnologicaParticleTypes.DRIPPING_OIL.get(), TechnologicaDripParticle.DrippingFactory::new);
	}
}
