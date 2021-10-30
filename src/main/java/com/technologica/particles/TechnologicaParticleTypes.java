package com.technologica.particles;

import static com.technologica.Technologica.MODID;

import java.util.function.Function;

import com.mojang.serialization.Codec;

import net.minecraft.particles.IParticleData;
import net.minecraft.particles.ParticleType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class TechnologicaParticleTypes {
	public static final DeferredRegister<ParticleType<?>> PARTICLE_TYPES = DeferredRegister.create(ForgeRegistries.PARTICLE_TYPES, MODID);

	public static final RegistryObject<ParticleType<DrippingLiquidParticleData>> DRIPPING_FLUID = PARTICLE_TYPES.register("dripping_fluid", () -> create(DrippingLiquidParticleData.DESERIALIZER, (p_239822_0_) -> {
	      return DrippingLiquidParticleData.field_239802_b_;
	   }));
					
	public static final RegistryObject<ParticleType<FallingLiquidParticleData>> FALLING_FLUID = PARTICLE_TYPES.register("falling_fluid", () -> create(FallingLiquidParticleData.DESERIALIZER, (p_239822_0_) -> {
	      return FallingLiquidParticleData.field_239802_b_;
	   }));
	
	public static final RegistryObject<ParticleType<LandingLiquidParticleData>> LANDING_FLUID = PARTICLE_TYPES.register("landing_fluid", () -> create(LandingLiquidParticleData.DESERIALIZER, (p_239822_0_) -> {
	      return LandingLiquidParticleData.field_239802_b_;
	   }));

	
	
	//public static final RegistryObject<ParticleType<UniversalLiquidParticleType>> DRIPPING_OIL = PARTICLE_TYPES.register("dripping_oil", () -> new UniversalLiquidParticleType(false, TechnologicaFluids.OIL.get().getAttributes().getColor()));
	
	
	
	
	public static void register() {
		PARTICLE_TYPES.register(FMLJavaModLoadingContext.get().getModEventBus());
	}

	@SuppressWarnings("deprecation")
	private static <T extends IParticleData> ParticleType<T> create(IParticleData.IDeserializer<T> deserializer, final Function<ParticleType<T>, Codec<T>> p_218416_2_) {
		return new ParticleType<T>(false, deserializer) {
			public Codec<T> func_230522_e_() {
				return p_218416_2_.apply(this);
			}
		};	
	}
}