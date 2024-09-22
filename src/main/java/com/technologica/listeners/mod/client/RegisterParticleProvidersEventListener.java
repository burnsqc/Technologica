package com.technologica.listeners.mod.client;

import com.technologica.client.particle.RadiationParticle;
import com.technologica.client.particle.SmokeColumnUpParticle;
import com.technologica.client.particle.TechnologicaDripParticle;
import com.technologica.client.particle.TechnologicaSplashParticle;
import com.technologica.client.particle.TechnologicaSuspendParticle;
import com.technologica.registration.deferred.TechnologicaParticleTypes;

import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.RegisterParticleProvidersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;

@Mod.EventBusSubscriber(bus = EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public final class RegisterParticleProvidersEventListener {

	@SubscribeEvent
	public static final void onRegisterParticleProvidersEvent(final RegisterParticleProvidersEvent event) {
		event.registerSprite(TechnologicaParticleTypes.DRIPPING_BRINE.get(), TechnologicaDripParticle::createBrineHangParticle);
		event.registerSprite(TechnologicaParticleTypes.FALLING_BRINE.get(), TechnologicaDripParticle::createBrineFallParticle);
		event.registerSpriteSet(TechnologicaParticleTypes.SPLASHING_BRINE.get(), TechnologicaSplashParticle.BrineProvider::new);
		event.registerSpriteSet(TechnologicaParticleTypes.SUBMERGED_BRINE.get(), TechnologicaSuspendParticle.BrineProvider::new);
		event.registerSprite(TechnologicaParticleTypes.DRIPPING_BROMINE.get(), TechnologicaDripParticle::createBromineHangParticle);
		event.registerSprite(TechnologicaParticleTypes.FALLING_BROMINE.get(), TechnologicaDripParticle::createBromineFallParticle);
		event.registerSpriteSet(TechnologicaParticleTypes.SPLASHING_BROMINE.get(), TechnologicaSplashParticle.BromineProvider::new);
		event.registerSpriteSet(TechnologicaParticleTypes.SUBMERGED_BROMINE.get(), TechnologicaSuspendParticle.BromineProvider::new);
		event.registerSprite(TechnologicaParticleTypes.DRIPPING_COOLANT.get(), TechnologicaDripParticle::createCoolantHangParticle);
		event.registerSprite(TechnologicaParticleTypes.FALLING_COOLANT.get(), TechnologicaDripParticle::createCoolantFallParticle);
		event.registerSpriteSet(TechnologicaParticleTypes.SPLASHING_COOLANT.get(), TechnologicaSplashParticle.CoolantProvider::new);
		event.registerSpriteSet(TechnologicaParticleTypes.SUBMERGED_COOLANT.get(), TechnologicaSuspendParticle.CoolantProvider::new);
		event.registerSprite(TechnologicaParticleTypes.DRIPPING_GASOLINE.get(), TechnologicaDripParticle::createGasolineHangParticle);
		event.registerSprite(TechnologicaParticleTypes.FALLING_GASOLINE.get(), TechnologicaDripParticle::createGasolineFallParticle);
		event.registerSpriteSet(TechnologicaParticleTypes.SPLASHING_GASOLINE.get(), TechnologicaSplashParticle.GasolineProvider::new);
		event.registerSpriteSet(TechnologicaParticleTypes.SUBMERGED_GASOLINE.get(), TechnologicaSuspendParticle.GasolineProvider::new);
		event.registerSprite(TechnologicaParticleTypes.DRIPPING_MACHINE_OIL.get(), TechnologicaDripParticle::createMachineOilHangParticle);
		event.registerSprite(TechnologicaParticleTypes.FALLING_MACHINE_OIL.get(), TechnologicaDripParticle::createMachineOilFallParticle);
		event.registerSpriteSet(TechnologicaParticleTypes.SPLASHING_MACHINE_OIL.get(), TechnologicaSplashParticle.MachineOilProvider::new);
		event.registerSpriteSet(TechnologicaParticleTypes.SUBMERGED_MACHINE_OIL.get(), TechnologicaSuspendParticle.MachineOilProvider::new);
		event.registerSprite(TechnologicaParticleTypes.DRIPPING_MAPLE_SYRUP.get(), TechnologicaDripParticle::createMapleSyrupHangParticle);
		event.registerSprite(TechnologicaParticleTypes.FALLING_MAPLE_SYRUP.get(), TechnologicaDripParticle::createMapleSyrupFallParticle);
		event.registerSprite(TechnologicaParticleTypes.STICKING_MAPLE_SYRUP.get(), TechnologicaDripParticle::createMapleSyrupStickParticle);
		event.registerSpriteSet(TechnologicaParticleTypes.SUBMERGED_MAPLE_SYRUP.get(), TechnologicaSuspendParticle.MapleSyrupProvider::new);
		event.registerSprite(TechnologicaParticleTypes.DRIPPING_MERCURY.get(), TechnologicaDripParticle::createMercuryHangParticle);
		event.registerSprite(TechnologicaParticleTypes.FALLING_MERCURY.get(), TechnologicaDripParticle::createMercuryFallParticle);
		event.registerSpriteSet(TechnologicaParticleTypes.SPLASHING_MERCURY.get(), TechnologicaSplashParticle.MercuryProvider::new);
		event.registerSpriteSet(TechnologicaParticleTypes.SUBMERGED_MERCURY.get(), TechnologicaSuspendParticle.MercuryProvider::new);
		event.registerSprite(TechnologicaParticleTypes.DRIPPING_OIL.get(), TechnologicaDripParticle::createOilHangParticle);
		event.registerSprite(TechnologicaParticleTypes.FALLING_OIL.get(), TechnologicaDripParticle::createOilFallParticle);
		event.registerSprite(TechnologicaParticleTypes.STICKING_OIL.get(), TechnologicaDripParticle::createOilStickParticle);
		event.registerSpriteSet(TechnologicaParticleTypes.SUBMERGED_OIL.get(), TechnologicaSuspendParticle.OilProvider::new);
		event.registerSprite(TechnologicaParticleTypes.DRIPPING_RUBBER_RESIN.get(), TechnologicaDripParticle::createRubberResinHangParticle);
		event.registerSprite(TechnologicaParticleTypes.FALLING_RUBBER_RESIN.get(), TechnologicaDripParticle::createRubberResinFallParticle);
		event.registerSprite(TechnologicaParticleTypes.STICKING_RUBBER_RESIN.get(), TechnologicaDripParticle::createRubberResinStickParticle);
		event.registerSpriteSet(TechnologicaParticleTypes.SUBMERGED_RUBBER_RESIN.get(), TechnologicaSuspendParticle.RubberResinProvider::new);
		event.registerSpriteSet(TechnologicaParticleTypes.FLYING_RADIATION.get(), RadiationParticle.FlyingFactory::new);
		event.registerSpriteSet(TechnologicaParticleTypes.SMOKE_COLUMN_UP.get(), SmokeColumnUpParticle.Provider::new);
	}
}
