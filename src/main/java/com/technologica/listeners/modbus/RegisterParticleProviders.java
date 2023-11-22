package com.technologica.listeners.modbus;

import static com.technologica.Technologica.LOGGER;

import com.technologica.client.particle.RadiationParticle;
import com.technologica.client.particle.TechnologicaDripParticle;
import com.technologica.registration.deferred.TechnologicaParticleTypes;

import net.minecraftforge.client.event.RegisterParticleProvidersEvent;

/**
 * <p>
 * This class listens for RegisterParticleProvidersEvent which is fired on the mod-specific event bus.
 * When the event is intercepted, Technologica Particle Providers are registered.
 * </p>
 * 
 * @tl.status YELLOW
 */

public class RegisterParticleProviders {

	public static void onRegisterParticleProvidersEvent(final RegisterParticleProvidersEvent event) {
		event.registerSpriteSet(TechnologicaParticleTypes.DRIPPING_FLUID.get(), TechnologicaDripParticle.DrippingFactory::new);
		event.registerSpriteSet(TechnologicaParticleTypes.FALLING_FLUID.get(), TechnologicaDripParticle.FallingFactory::new);
		event.registerSpriteSet(TechnologicaParticleTypes.LANDING_FLUID.get(), TechnologicaDripParticle.LandingFactory::new);
		event.registerSpriteSet(TechnologicaParticleTypes.FLYING_RADIATION.get(), RadiationParticle.FlyingFactory::new);
		/**
		 * TODO: Determine how to count how many Technologica Particle Providers actually got registered and replace the hard-coded value in the logger message. Trying to avoid Access Transformers, but could open up private final Map {@link ParticleEngine} providers.
		 */
		LOGGER.info("PARTICLE PROVIDERS REGISTERED: 4 OF 4");
	}
}