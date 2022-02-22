package com.technologica.setup;

import com.technologica.client.particle.TechnologicaDripParticle;
import com.technologica.particles.TechnologicaParticleTypes;

import net.minecraft.client.Minecraft;
import net.minecraftforge.client.event.ParticleFactoryRegisterEvent;

public class ParticleSetup {
	@SuppressWarnings("resource")
	public static void init(final ParticleFactoryRegisterEvent event) {
		Minecraft.getInstance().particleEngine.register(TechnologicaParticleTypes.DRIPPING_FLUID.get(), TechnologicaDripParticle.DrippingFactory::new);
		Minecraft.getInstance().particleEngine.register(TechnologicaParticleTypes.FALLING_FLUID.get(), TechnologicaDripParticle.FallingFactory::new);
		Minecraft.getInstance().particleEngine.register(TechnologicaParticleTypes.LANDING_FLUID.get(), TechnologicaDripParticle.LandingFactory::new);
	}
}
