package com.technologica.registration.listener;

import com.technologica.Technologica;
import com.technologica.client.particle.RadiationParticle;
import com.technologica.client.particle.TechnologicaDripParticle;
import com.technologica.client.particle.TechnologicaSplashParticle;
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
public final class TechnologicaParticleProviders {

	public static void onRegisterParticleProvidersEvent(final RegisterParticleProvidersEvent event) {
		event.registerSprite(TechnologicaParticleTypes.DRIPPING_BRINE.get(), TechnologicaDripParticle::createBrineHangParticle);
		event.registerSprite(TechnologicaParticleTypes.FALLING_BRINE.get(), TechnologicaDripParticle::createBrineFallParticle);
		event.registerSpriteSet(TechnologicaParticleTypes.SPLASHING_BRINE.get(), TechnologicaSplashParticle.BrineProvider::new);
		event.registerSprite(TechnologicaParticleTypes.DRIPPING_BROMINE.get(), TechnologicaDripParticle::createBromineHangParticle);
		event.registerSprite(TechnologicaParticleTypes.FALLING_BROMINE.get(), TechnologicaDripParticle::createBromineFallParticle);
		event.registerSpriteSet(TechnologicaParticleTypes.SPLASHING_BROMINE.get(), TechnologicaSplashParticle.BromineProvider::new);
		event.registerSprite(TechnologicaParticleTypes.DRIPPING_COOLANT.get(), TechnologicaDripParticle::createCoolantHangParticle);
		event.registerSprite(TechnologicaParticleTypes.FALLING_COOLANT.get(), TechnologicaDripParticle::createCoolantFallParticle);
		event.registerSpriteSet(TechnologicaParticleTypes.SPLASHING_COOLANT.get(), TechnologicaSplashParticle.CoolantProvider::new);
		event.registerSprite(TechnologicaParticleTypes.DRIPPING_GASOLINE.get(), TechnologicaDripParticle::createGasolineHangParticle);
		event.registerSprite(TechnologicaParticleTypes.FALLING_GASOLINE.get(), TechnologicaDripParticle::createGasolineFallParticle);
		event.registerSpriteSet(TechnologicaParticleTypes.SPLASHING_GASOLINE.get(), TechnologicaSplashParticle.GasolineProvider::new);
		event.registerSprite(TechnologicaParticleTypes.DRIPPING_MACHINE_OIL.get(), TechnologicaDripParticle::createMachineOilHangParticle);
		event.registerSprite(TechnologicaParticleTypes.FALLING_MACHINE_OIL.get(), TechnologicaDripParticle::createMachineOilFallParticle);
		event.registerSpriteSet(TechnologicaParticleTypes.SPLASHING_MACHINE_OIL.get(), TechnologicaSplashParticle.MachineOilProvider::new);
		event.registerSprite(TechnologicaParticleTypes.DRIPPING_MAPLE_SYRUP.get(), TechnologicaDripParticle::createMapleSyrupHangParticle);
		event.registerSprite(TechnologicaParticleTypes.FALLING_MAPLE_SYRUP.get(), TechnologicaDripParticle::createMapleSyrupFallParticle);
		event.registerSprite(TechnologicaParticleTypes.STICKING_MAPLE_SYRUP.get(), TechnologicaDripParticle::createMapleSyrupStickParticle);
		event.registerSprite(TechnologicaParticleTypes.DRIPPING_MERCURY.get(), TechnologicaDripParticle::createMercuryHangParticle);
		event.registerSprite(TechnologicaParticleTypes.FALLING_MERCURY.get(), TechnologicaDripParticle::createMercuryFallParticle);
		event.registerSpriteSet(TechnologicaParticleTypes.SPLASHING_MERCURY.get(), TechnologicaSplashParticle.MercuryProvider::new);
		event.registerSprite(TechnologicaParticleTypes.DRIPPING_OIL.get(), TechnologicaDripParticle::createOilHangParticle);
		event.registerSprite(TechnologicaParticleTypes.FALLING_OIL.get(), TechnologicaDripParticle::createOilFallParticle);
		event.registerSprite(TechnologicaParticleTypes.STICKING_OIL.get(), TechnologicaDripParticle::createOilStickParticle);
		event.registerSprite(TechnologicaParticleTypes.DRIPPING_RUBBER_RESIN.get(), TechnologicaDripParticle::createRubberResinHangParticle);
		event.registerSprite(TechnologicaParticleTypes.FALLING_RUBBER_RESIN.get(), TechnologicaDripParticle::createRubberResinFallParticle);
		event.registerSprite(TechnologicaParticleTypes.STICKING_RUBBER_RESIN.get(), TechnologicaDripParticle::createRubberResinStickParticle);
		event.registerSpriteSet(TechnologicaParticleTypes.FLYING_RADIATION.get(), RadiationParticle.FlyingFactory::new);
		/**
		 * TODO: Determine how to count how many Technologica Particle Providers actually got registered and replace the hard-coded value in the logger message. Trying to avoid Access Transformers, but could open up private final Map {@link ParticleEngine} providers.
		 */
		Technologica.LOGGER.info("PARTICLE PROVIDERS REGISTERED: 4 OF 4");
	}
}