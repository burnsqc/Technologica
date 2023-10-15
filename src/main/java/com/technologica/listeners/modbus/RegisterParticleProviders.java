package com.technologica.listeners.modbus;

import static com.technologica.Technologica.LOGGER;

import com.technologica.client.particle.RadiationParticle;
import com.technologica.client.particle.TechnologicaDripParticle;
import com.technologica.core.particles.TechnologicaParticleTypes;

import net.minecraftforge.client.event.RegisterParticleProvidersEvent;

/**
 * <p>
 * This class listens for the RegisterParticleProvidersEvent which is fired on the mod-specific event bus.
 * When the event is intercepted, Technologica Particle Providers are registered.
 * This is currently the approved way to register Particle Providers.
 * </p>
 */

public class RegisterParticleProviders {

	public static void onRegisterParticleProvidersEvent(final RegisterParticleProvidersEvent event) {
		event.register(TechnologicaParticleTypes.DRIPPING_FLUID.get(), TechnologicaDripParticle.DrippingFactory::new);
		event.register(TechnologicaParticleTypes.FALLING_FLUID.get(), TechnologicaDripParticle.FallingFactory::new);
		event.register(TechnologicaParticleTypes.LANDING_FLUID.get(), TechnologicaDripParticle.LandingFactory::new);
		event.register(TechnologicaParticleTypes.FLYING_RADIATION.get(), RadiationParticle.FlyingFactory::new);
		/**
		 * TODO: Determine how to count how many Technologica Particle Providers actually got registered and replace the hard-coded value in the logger message. Trying to avoid Access Transformers, but could open up private final Map {@link ParticleEngine} providers.
		 */
		LOGGER.info("PARTICLE PROVIDERS REGISTERED: 4 OF 4");
	}
}