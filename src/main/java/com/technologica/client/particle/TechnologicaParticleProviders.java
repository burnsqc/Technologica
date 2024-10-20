package com.technologica.client.particle;

import java.util.Map;

import com.google.common.collect.Maps;
import com.technologica.registration.deferred.TechnologicaParticleTypes;

import net.minecraft.client.particle.ParticleEngine;
import net.minecraft.client.particle.ParticleEngine.SpriteParticleRegistration;
import net.minecraft.client.particle.ParticleProvider.Sprite;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.core.particles.ParticleType;

public class TechnologicaParticleProviders {
	public static final Map<ParticleType<ParticleOptions>, Sprite<ParticleOptions>> SPRITES = Maps.newHashMap();
	public static final Map<ParticleType<ParticleOptions>, ParticleEngine.SpriteParticleRegistration<ParticleOptions>> SPRITE_SETS = Maps.newHashMap();

	@SuppressWarnings("unchecked")
	public static <T extends ParticleOptions> void register(ParticleType<T> particle, Sprite<T> provider) {
		SPRITES.put((ParticleType<ParticleOptions>) particle, (Sprite<ParticleOptions>) provider);
	}

	@SuppressWarnings("unchecked")
	public static <T extends ParticleOptions> void registerSet(ParticleType<T> particle, ParticleEngine.SpriteParticleRegistration<T> provider) {
		SPRITE_SETS.put((ParticleType<ParticleOptions>) particle, (SpriteParticleRegistration<ParticleOptions>) provider);
	}

	static {
		register(TechnologicaParticleTypes.DRIPPING_BRINE.get(), TechnologicaDripParticle::createBrineHangParticle);
		register(TechnologicaParticleTypes.FALLING_BRINE.get(), TechnologicaDripParticle::createBrineFallParticle);
		register(TechnologicaParticleTypes.DRIPPING_BROMINE.get(), TechnologicaDripParticle::createBromineHangParticle);
		register(TechnologicaParticleTypes.FALLING_BROMINE.get(), TechnologicaDripParticle::createBromineFallParticle);
		register(TechnologicaParticleTypes.DRIPPING_COOLANT.get(), TechnologicaDripParticle::createCoolantHangParticle);
		register(TechnologicaParticleTypes.FALLING_COOLANT.get(), TechnologicaDripParticle::createCoolantFallParticle);
		register(TechnologicaParticleTypes.DRIPPING_GASOLINE.get(), TechnologicaDripParticle::createGasolineHangParticle);
		register(TechnologicaParticleTypes.FALLING_GASOLINE.get(), TechnologicaDripParticle::createGasolineFallParticle);
		register(TechnologicaParticleTypes.DRIPPING_MACHINE_OIL.get(), TechnologicaDripParticle::createMachineOilHangParticle);
		register(TechnologicaParticleTypes.FALLING_MACHINE_OIL.get(), TechnologicaDripParticle::createMachineOilFallParticle);
		register(TechnologicaParticleTypes.DRIPPING_MAPLE_SYRUP.get(), TechnologicaDripParticle::createMapleSyrupHangParticle);
		register(TechnologicaParticleTypes.FALLING_MAPLE_SYRUP.get(), TechnologicaDripParticle::createMapleSyrupFallParticle);
		register(TechnologicaParticleTypes.STICKING_MAPLE_SYRUP.get(), TechnologicaDripParticle::createMapleSyrupStickParticle);
		register(TechnologicaParticleTypes.DRIPPING_MERCURY.get(), TechnologicaDripParticle::createMercuryHangParticle);
		register(TechnologicaParticleTypes.FALLING_MERCURY.get(), TechnologicaDripParticle::createMercuryFallParticle);
		register(TechnologicaParticleTypes.DRIPPING_OIL.get(), TechnologicaDripParticle::createOilHangParticle);
		register(TechnologicaParticleTypes.FALLING_OIL.get(), TechnologicaDripParticle::createOilFallParticle);
		register(TechnologicaParticleTypes.STICKING_OIL.get(), TechnologicaDripParticle::createOilStickParticle);
		register(TechnologicaParticleTypes.DRIPPING_RUBBER_RESIN.get(), TechnologicaDripParticle::createRubberResinHangParticle);
		register(TechnologicaParticleTypes.FALLING_RUBBER_RESIN.get(), TechnologicaDripParticle::createRubberResinFallParticle);
		register(TechnologicaParticleTypes.STICKING_RUBBER_RESIN.get(), TechnologicaDripParticle::createRubberResinStickParticle);
		registerSet(TechnologicaParticleTypes.SPLASHING_BRINE.get(), TechnologicaSplashParticle.BrineProvider::new);
		registerSet(TechnologicaParticleTypes.SUBMERGED_BRINE.get(), TechnologicaSuspendParticle.BrineProvider::new);
		registerSet(TechnologicaParticleTypes.SPLASHING_BROMINE.get(), TechnologicaSplashParticle.BromineProvider::new);
		registerSet(TechnologicaParticleTypes.SUBMERGED_BROMINE.get(), TechnologicaSuspendParticle.BromineProvider::new);
		registerSet(TechnologicaParticleTypes.SPLASHING_COOLANT.get(), TechnologicaSplashParticle.CoolantProvider::new);
		registerSet(TechnologicaParticleTypes.SUBMERGED_COOLANT.get(), TechnologicaSuspendParticle.CoolantProvider::new);
		registerSet(TechnologicaParticleTypes.SPLASHING_GASOLINE.get(), TechnologicaSplashParticle.GasolineProvider::new);
		registerSet(TechnologicaParticleTypes.SUBMERGED_GASOLINE.get(), TechnologicaSuspendParticle.GasolineProvider::new);
		registerSet(TechnologicaParticleTypes.SPLASHING_MACHINE_OIL.get(), TechnologicaSplashParticle.MachineOilProvider::new);
		registerSet(TechnologicaParticleTypes.SUBMERGED_MACHINE_OIL.get(), TechnologicaSuspendParticle.MachineOilProvider::new);
		registerSet(TechnologicaParticleTypes.SUBMERGED_MAPLE_SYRUP.get(), TechnologicaSuspendParticle.MapleSyrupProvider::new);
		registerSet(TechnologicaParticleTypes.SPLASHING_MERCURY.get(), TechnologicaSplashParticle.MercuryProvider::new);
		registerSet(TechnologicaParticleTypes.SUBMERGED_MERCURY.get(), TechnologicaSuspendParticle.MercuryProvider::new);
		registerSet(TechnologicaParticleTypes.SUBMERGED_OIL.get(), TechnologicaSuspendParticle.OilProvider::new);
		registerSet(TechnologicaParticleTypes.SUBMERGED_RUBBER_RESIN.get(), TechnologicaSuspendParticle.RubberResinProvider::new);
		registerSet(TechnologicaParticleTypes.FLYING_RADIATION.get(), RadiationParticle.FlyingFactory::new);
		registerSet(TechnologicaParticleTypes.SMOKE_COLUMN_UP.get(), SmokeColumnUpParticle.Provider::new);
	}
}
