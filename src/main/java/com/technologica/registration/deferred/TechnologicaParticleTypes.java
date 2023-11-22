package com.technologica.registration.deferred;

import java.util.function.Function;

import com.mojang.serialization.Codec;
import com.technologica.Technologica;
import com.technologica.core.particles.DrippingLiquidParticleData;
import com.technologica.core.particles.FallingLiquidParticleData;
import com.technologica.core.particles.FlyingRadiationParticleData;
import com.technologica.core.particles.LandingLiquidParticleData;
import com.technologica.registration.deferred.util.MasterDeferredRegistrar;

import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.core.particles.ParticleType;
import net.minecraftforge.registries.RegistryObject;

/**
 * <p>
 * This class contains Registry Objects for Particle Types.
 * The {@link #init} method is called by {@link Technologica#initDeferredRegisters} and returns a head-count to later be checked during registration and other setup activities.
 * </p>
 * 
 * @tl.status YELLOW
 */
public final class TechnologicaParticleTypes extends MasterDeferredRegistrar {
	
	public static int init() {
		PARTICLE_TYPES.register(Technologica.MOD_EVENT_BUS);
		return PARTICLE_TYPES.getEntries().size();
	}

	public static final RegistryObject<ParticleType<DrippingLiquidParticleData>> DRIPPING_FLUID = PARTICLE_TYPES.register("dripping_fluid", () -> create(DrippingLiquidParticleData.DESERIALIZER, (drippingLiquidParticleData) -> {
		return DrippingLiquidParticleData.CODEC;
	}));
	public static final RegistryObject<ParticleType<FallingLiquidParticleData>> FALLING_FLUID = PARTICLE_TYPES.register("falling_fluid", () -> create(FallingLiquidParticleData.DESERIALIZER, (fallingLiquidParticleData) -> {
		return FallingLiquidParticleData.CODEC;
	}));
	public static final RegistryObject<ParticleType<LandingLiquidParticleData>> LANDING_FLUID = PARTICLE_TYPES.register("landing_fluid", () -> create(LandingLiquidParticleData.DESERIALIZER, (landingLiquidParticleData) -> {
		return LandingLiquidParticleData.CODEC;
	}));
	public static final RegistryObject<ParticleType<FlyingRadiationParticleData>> FLYING_RADIATION = PARTICLE_TYPES.register("flying_radiation", () -> create(FlyingRadiationParticleData.DESERIALIZER, (flyingRadiationParticleData) -> {
		return FlyingRadiationParticleData.CODEC;
	}));
	//TODO: Really need to get rid of the call to {@link ParticleOptions.Deserializer} before the rug gets pulled out from under me.  Maybe just clone it to my own interface.
	@SuppressWarnings("deprecation")
	private static <T extends ParticleOptions> ParticleType<T> create(ParticleOptions.Deserializer<T> deserializer, final Function<ParticleType<T>, Codec<T>> p_218416_2_) {
		return new ParticleType<T>(false, deserializer) {
			@Override
			public Codec<T> codec() {
				return p_218416_2_.apply(this);
			}
		};
	}
}