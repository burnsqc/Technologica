package com.technologica.registration.deferred;

import com.technologica.Technologica;
import com.technologica.world.level.material.GasFluidType;
import com.technologica.world.level.material.MetalFluidType;
import com.technologica.world.level.material.MoltenFluidType;
import com.technologica.world.level.material.OpaqueFluidType;

import net.minecraftforge.fluids.FluidType;
import net.minecraftforge.registries.RegistryObject;

public final class TechnologicaFluidTypes {
	public static final RegistryObject<FluidType> HYDROGEN_TYPE = Technologica.FLUID_TYPES.register("hyrdrogen", () -> new GasFluidType(FluidType.Properties.create().density(0), 1680343295));
	public static final RegistryObject<FluidType> HELIUM_TYPE = Technologica.FLUID_TYPES.register("helium", () -> new GasFluidType(FluidType.Properties.create().density(0), 1687570373));
	public static final RegistryObject<FluidType> NITROGEN_TYPE = Technologica.FLUID_TYPES.register("nitrogen", () -> new GasFluidType(FluidType.Properties.create().density(0), 1692829175));
	public static final RegistryObject<FluidType> OXYGEN_TYPE = Technologica.FLUID_TYPES.register("oxygen", () -> new GasFluidType(FluidType.Properties.create(), 1687612407));
	public static final RegistryObject<FluidType> FLUORINE_TYPE = Technologica.FLUID_TYPES.register("fluorine", () -> new GasFluidType(FluidType.Properties.create(), 1692264576));
	public static final RegistryObject<FluidType> NEON_TYPE = Technologica.FLUID_TYPES.register("neon", () -> new GasFluidType(FluidType.Properties.create(), 1693946630));
	public static final RegistryObject<FluidType> CHLORINE_TYPE = Technologica.FLUID_TYPES.register("chlorine", () -> new GasFluidType(FluidType.Properties.create(), 1690894208));
	public static final RegistryObject<FluidType> ARGON_TYPE = Technologica.FLUID_TYPES.register("argon", () -> new GasFluidType(FluidType.Properties.create(), 1692434893));
	public static final RegistryObject<FluidType> KRYPTON_TYPE = Technologica.FLUID_TYPES.register("krypton", () -> new GasFluidType(FluidType.Properties.create(), 1686484447));
	public static final RegistryObject<FluidType> XENON_TYPE = Technologica.FLUID_TYPES.register("xenon", () -> new GasFluidType(FluidType.Properties.create(), 1683921300));
	public static final RegistryObject<FluidType> RADON_TYPE = Technologica.FLUID_TYPES.register("radon", () -> new GasFluidType(FluidType.Properties.create(), 1691357474));
	public static final RegistryObject<FluidType> BROMINE_TYPE = Technologica.FLUID_TYPES.register("bromine", () -> new GasFluidType(FluidType.Properties.create(), -5621741));
	public static final RegistryObject<FluidType> MERCURY_TYPE = Technologica.FLUID_TYPES.register("mercury", () -> new MetalFluidType(FluidType.Properties.create(), -1973791));
	public static final RegistryObject<FluidType> BRINE_TYPE = Technologica.FLUID_TYPES.register("brine", () -> new OpaqueFluidType(FluidType.Properties.create(), -5579521));
	public static final RegistryObject<FluidType> OIL_TYPE = Technologica.FLUID_TYPES.register("oil", () -> new OpaqueFluidType(FluidType.Properties.create().canExtinguish(false), 1681011250));
	public static final RegistryObject<FluidType> NATURAL_GAS_TYPE = Technologica.FLUID_TYPES.register("natural_gas", () -> new GasFluidType(FluidType.Properties.create().density(0), 1684340580));
	public static final RegistryObject<FluidType> MAPLE_SYRUP_TYPE = Technologica.FLUID_TYPES.register("maple_syrup", () -> new OpaqueFluidType(FluidType.Properties.create(), -10867944));
	public static final RegistryObject<FluidType> RUBBER_RESIN_TYPE = Technologica.FLUID_TYPES.register("rubber_resin", () -> new OpaqueFluidType(FluidType.Properties.create(), -986928));
	public static final RegistryObject<FluidType> GASOLINE_TYPE = Technologica.FLUID_TYPES.register("gasoline", () -> new GasFluidType(FluidType.Properties.create(), -2833815));
	public static final RegistryObject<FluidType> MACHINE_OIL_TYPE = Technologica.FLUID_TYPES.register("machine_oil", () -> new OpaqueFluidType(FluidType.Properties.create(), -106));
	public static final RegistryObject<FluidType> COOLANT_TYPE = Technologica.FLUID_TYPES.register("coolant", () -> new OpaqueFluidType(FluidType.Properties.create(), -4196524));
	public static final RegistryObject<FluidType> MOLTEN_CORE = Technologica.FLUID_TYPES.register("molten_core", () -> new MoltenFluidType());
}
