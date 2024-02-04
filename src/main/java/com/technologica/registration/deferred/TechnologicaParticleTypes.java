package com.technologica.registration.deferred;

import com.technologica.Technologica;
import com.technologica.registration.deferred.util.MasterDeferredRegistrar;

import net.minecraft.core.particles.SimpleParticleType;
import net.minecraftforge.registries.RegistryObject;

/**
 * <p>
 * This class contains Registry Objects for Particle Types.
 * The {@link #init} method is called by {@link Technologica#initDeferredRegisters} and returns a head-count to later be checked during registration and other setup activities.
 * </p>
 * 
 * @tl.status GREEN
 */
public final class TechnologicaParticleTypes extends MasterDeferredRegistrar {

	public static int init() {
		return PARTICLE_TYPES.getEntries().size();
	}

	public static final RegistryObject<SimpleParticleType> DRIPPING_BRINE = PARTICLE_TYPES.register("dripping_brine", () -> new SimpleParticleType(false));
	public static final RegistryObject<SimpleParticleType> FALLING_BRINE = PARTICLE_TYPES.register("falling_brine", () -> new SimpleParticleType(false));
	public static final RegistryObject<SimpleParticleType> SPLASHING_BRINE = PARTICLE_TYPES.register("splashing_brine", () -> new SimpleParticleType(false));
	public static final RegistryObject<SimpleParticleType> SUBMERGED_BRINE = PARTICLE_TYPES.register("submerged_brine", () -> new SimpleParticleType(false));
	public static final RegistryObject<SimpleParticleType> DRIPPING_BROMINE = PARTICLE_TYPES.register("dripping_bromine", () -> new SimpleParticleType(false));
	public static final RegistryObject<SimpleParticleType> FALLING_BROMINE = PARTICLE_TYPES.register("falling_bromine", () -> new SimpleParticleType(false));
	public static final RegistryObject<SimpleParticleType> SPLASHING_BROMINE = PARTICLE_TYPES.register("splashing_bromine", () -> new SimpleParticleType(false));
	public static final RegistryObject<SimpleParticleType> SUBMERGED_BROMINE = PARTICLE_TYPES.register("submerged_bromine", () -> new SimpleParticleType(false));
	public static final RegistryObject<SimpleParticleType> DRIPPING_COOLANT = PARTICLE_TYPES.register("dripping_coolant", () -> new SimpleParticleType(false));
	public static final RegistryObject<SimpleParticleType> FALLING_COOLANT = PARTICLE_TYPES.register("falling_coolant", () -> new SimpleParticleType(false));
	public static final RegistryObject<SimpleParticleType> SPLASHING_COOLANT = PARTICLE_TYPES.register("splashing_coolant", () -> new SimpleParticleType(false));
	public static final RegistryObject<SimpleParticleType> SUBMERGED_COOLANT = PARTICLE_TYPES.register("submerged_coolant", () -> new SimpleParticleType(false));
	public static final RegistryObject<SimpleParticleType> DRIPPING_GASOLINE = PARTICLE_TYPES.register("dripping_gasoline", () -> new SimpleParticleType(false));
	public static final RegistryObject<SimpleParticleType> FALLING_GASOLINE = PARTICLE_TYPES.register("falling_gasoline", () -> new SimpleParticleType(false));
	public static final RegistryObject<SimpleParticleType> SPLASHING_GASOLINE = PARTICLE_TYPES.register("splashing_gasoline", () -> new SimpleParticleType(false));
	public static final RegistryObject<SimpleParticleType> SUBMERGED_GASOLINE = PARTICLE_TYPES.register("submerged_gasoline", () -> new SimpleParticleType(false));
	public static final RegistryObject<SimpleParticleType> DRIPPING_MACHINE_OIL = PARTICLE_TYPES.register("dripping_machine_oil", () -> new SimpleParticleType(false));
	public static final RegistryObject<SimpleParticleType> FALLING_MACHINE_OIL = PARTICLE_TYPES.register("falling_machine_oil", () -> new SimpleParticleType(false));
	public static final RegistryObject<SimpleParticleType> SPLASHING_MACHINE_OIL = PARTICLE_TYPES.register("splashing_machine_oil", () -> new SimpleParticleType(false));
	public static final RegistryObject<SimpleParticleType> SUBMERGED_MACHINE_OIL = PARTICLE_TYPES.register("submerged_machine_oil", () -> new SimpleParticleType(false));
	public static final RegistryObject<SimpleParticleType> DRIPPING_MAPLE_SYRUP = PARTICLE_TYPES.register("dripping_maple_syrup", () -> new SimpleParticleType(false));
	public static final RegistryObject<SimpleParticleType> FALLING_MAPLE_SYRUP = PARTICLE_TYPES.register("falling_maple_syrup", () -> new SimpleParticleType(false));
	public static final RegistryObject<SimpleParticleType> STICKING_MAPLE_SYRUP = PARTICLE_TYPES.register("sticking_maple_syrup", () -> new SimpleParticleType(false));
	public static final RegistryObject<SimpleParticleType> SUBMERGED_MAPLE_SYRUP = PARTICLE_TYPES.register("submerged_maple_syrup", () -> new SimpleParticleType(false));
	public static final RegistryObject<SimpleParticleType> DRIPPING_MERCURY = PARTICLE_TYPES.register("dripping_mercury", () -> new SimpleParticleType(false));
	public static final RegistryObject<SimpleParticleType> FALLING_MERCURY = PARTICLE_TYPES.register("falling_mercury", () -> new SimpleParticleType(false));
	public static final RegistryObject<SimpleParticleType> SPLASHING_MERCURY = PARTICLE_TYPES.register("splashing_mercury", () -> new SimpleParticleType(false));
	public static final RegistryObject<SimpleParticleType> SUBMERGED_MERCURY = PARTICLE_TYPES.register("submerged_mercury", () -> new SimpleParticleType(false));
	public static final RegistryObject<SimpleParticleType> DRIPPING_OIL = PARTICLE_TYPES.register("dripping_oil", () -> new SimpleParticleType(false));
	public static final RegistryObject<SimpleParticleType> FALLING_OIL = PARTICLE_TYPES.register("falling_oil", () -> new SimpleParticleType(false));
	public static final RegistryObject<SimpleParticleType> STICKING_OIL = PARTICLE_TYPES.register("sticking_oil", () -> new SimpleParticleType(false));
	public static final RegistryObject<SimpleParticleType> SUBMERGED_OIL = PARTICLE_TYPES.register("submerged_oil", () -> new SimpleParticleType(false));
	public static final RegistryObject<SimpleParticleType> DRIPPING_RUBBER_RESIN = PARTICLE_TYPES.register("dripping_rubber_resin", () -> new SimpleParticleType(false));
	public static final RegistryObject<SimpleParticleType> FALLING_RUBBER_RESIN = PARTICLE_TYPES.register("falling_rubber_resin", () -> new SimpleParticleType(false));
	public static final RegistryObject<SimpleParticleType> STICKING_RUBBER_RESIN = PARTICLE_TYPES.register("sticking_rubber_resin", () -> new SimpleParticleType(false));
	public static final RegistryObject<SimpleParticleType> SUBMERGED_RUBBER_RESIN = PARTICLE_TYPES.register("submerged_rubber_resin", () -> new SimpleParticleType(false));
	public static final RegistryObject<SimpleParticleType> FLYING_RADIATION = PARTICLE_TYPES.register("flying_radiation", () -> new SimpleParticleType(false));
}