package com.technologica.listeners.modbus;

import static com.technologica.Technologica.LOGGER;

import com.technologica.client.particle.RadiationParticle;
import com.technologica.client.particle.TechnologicaDripParticle;
import com.technologica.core.particles.TechnologicaParticleTypes;

import net.minecraftforge.client.event.RegisterParticleProvidersEvent;

public class RegisterParticleProviders {

	public static void onRegisterParticleProvidersEvent(RegisterParticleProvidersEvent event) {
		event.register(TechnologicaParticleTypes.DRIPPING_FLUID.get(), TechnologicaDripParticle.DrippingFactory::new);
		event.register(TechnologicaParticleTypes.FALLING_FLUID.get(), TechnologicaDripParticle.FallingFactory::new);
		event.register(TechnologicaParticleTypes.LANDING_FLUID.get(), TechnologicaDripParticle.LandingFactory::new);
		event.register(TechnologicaParticleTypes.FLYING_RADIATION.get(), RadiationParticle.FlyingFactory::new);
		LOGGER.info("PARTICLE PROVIDERS REGISTERED: 4 OF 4");
	}
}