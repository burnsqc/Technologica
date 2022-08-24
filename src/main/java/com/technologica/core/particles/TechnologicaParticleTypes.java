package com.technologica.core.particles;

import static com.technologica.Technologica.LOGGER;
import static com.technologica.Technologica.MODID;

import java.util.function.Function;

import com.mojang.serialization.Codec;

import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.core.particles.ParticleType;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class TechnologicaParticleTypes {
	public static final DeferredRegister<ParticleType<?>> PARTICLE_TYPES = DeferredRegister.create(ForgeRegistries.Keys.PARTICLE_TYPES, MODID);

	public static void init() {
		PARTICLE_TYPES.register(FMLJavaModLoadingContext.get().getModEventBus());
		LOGGER.info("PARTICLE TYPES INITIALIZED: " + PARTICLE_TYPES.getEntries().size() + " OF 3");
	}

	public static final RegistryObject<ParticleType<DrippingLiquidParticleData>> DRIPPING_FLUID = PARTICLE_TYPES.register("dripping_fluid", () -> create(DrippingLiquidParticleData.DESERIALIZER, (p_239822_0_) -> {
		return DrippingLiquidParticleData.CODEC;
	}));

	public static final RegistryObject<ParticleType<FallingLiquidParticleData>> FALLING_FLUID = PARTICLE_TYPES.register("falling_fluid", () -> create(FallingLiquidParticleData.DESERIALIZER, (p_239822_0_) -> {
		return FallingLiquidParticleData.CODEC;
	}));

	public static final RegistryObject<ParticleType<LandingLiquidParticleData>> LANDING_FLUID = PARTICLE_TYPES.register("landing_fluid", () -> create(LandingLiquidParticleData.DESERIALIZER, (p_239822_0_) -> {
		return LandingLiquidParticleData.CODEC;
	}));

	private static <T extends ParticleOptions> ParticleType<T> create(@SuppressWarnings("deprecation") ParticleOptions.Deserializer<T> deserializer, final Function<ParticleType<T>, Codec<T>> p_218416_2_) {
		return new ParticleType<T>(false, deserializer) {
			@Override
			public Codec<T> codec() {
				return p_218416_2_.apply(this);
			}
		};
	}
}
