package com.technologica.world.level.material;

import static com.technologica.Technologica.MODID;

import net.minecraft.world.level.material.FlowingFluid;
import net.minecraft.world.level.material.Fluid;
import net.minecraftforge.fluids.FluidType;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public final class TechnologicaFluids {
	public static final DeferredRegister<FluidType> FLUID_TYPES = DeferredRegister.create(ForgeRegistries.Keys.FLUID_TYPES, MODID);
	public static final DeferredRegister<Fluid> FLUIDS = DeferredRegister.create(ForgeRegistries.Keys.FLUIDS, MODID);

	public static int init() {
		FLUID_TYPES.register(FMLJavaModLoadingContext.get().getModEventBus());
		return FLUID_TYPES.getEntries().size();
	}

	public static int init2() {
		FLUIDS.register(FMLJavaModLoadingContext.get().getModEventBus());
		return FLUIDS.getEntries().size();
	}

	public static final RegistryObject<FlowingFluid> FLOWING_HYDROGEN = FLUIDS.register("flowing_hydrogen", HydrogenFluid.Flowing::new);
	public static final RegistryObject<FlowingFluid> HYDROGEN = FLUIDS.register("hydrogen", HydrogenFluid.Source::new);
	public static final RegistryObject<FlowingFluid> FLOWING_HELIUM = FLUIDS.register("flowing_helium", HeliumFluid.Flowing::new);
	public static final RegistryObject<FlowingFluid> HELIUM = FLUIDS.register("helium", HeliumFluid.Source::new);
	public static final RegistryObject<FlowingFluid> FLOWING_NITROGEN = FLUIDS.register("flowing_nitrogen", NitrogenFluid.Flowing::new);
	public static final RegistryObject<FlowingFluid> NITROGEN = FLUIDS.register("nitrogen", NitrogenFluid.Source::new);
	public static final RegistryObject<FlowingFluid> FLOWING_OXYGEN = FLUIDS.register("flowing_oxygen", OxygenFluid.Flowing::new);
	public static final RegistryObject<FlowingFluid> OXYGEN = FLUIDS.register("oxygen", OxygenFluid.Source::new);
	public static final RegistryObject<FlowingFluid> FLOWING_FLUORINE = FLUIDS.register("flowing_fluorine", FluorineFluid.Flowing::new);
	public static final RegistryObject<FlowingFluid> FLUORINE = FLUIDS.register("fluorine", FluorineFluid.Source::new);
	public static final RegistryObject<FlowingFluid> FLOWING_NEON = FLUIDS.register("flowing_neon", NeonFluid.Flowing::new);
	public static final RegistryObject<FlowingFluid> NEON = FLUIDS.register("neon", NeonFluid.Source::new);
	public static final RegistryObject<FlowingFluid> FLOWING_CHLORINE = FLUIDS.register("flowing_chlroine", ChlorineFluid.Flowing::new);
	public static final RegistryObject<FlowingFluid> CHLORINE = FLUIDS.register("chlorine", ChlorineFluid.Source::new);
	public static final RegistryObject<FlowingFluid> FLOWING_ARGON = FLUIDS.register("flowing_argon", ArgonFluid.Flowing::new);
	public static final RegistryObject<FlowingFluid> ARGON = FLUIDS.register("argon", ArgonFluid.Source::new);
	public static final RegistryObject<FlowingFluid> FLOWING_KRYPTON = FLUIDS.register("flowing_krypton", KryptonFluid.Flowing::new);
	public static final RegistryObject<FlowingFluid> KRYPTON = FLUIDS.register("krypton", KryptonFluid.Source::new);
	public static final RegistryObject<FlowingFluid> FLOWING_XENON = FLUIDS.register("flowing_xenon", XenonFluid.Flowing::new);
	public static final RegistryObject<FlowingFluid> XENON = FLUIDS.register("xenon", XenonFluid.Source::new);
	public static final RegistryObject<FlowingFluid> FLOWING_RADON = FLUIDS.register("flowing_radon", RadonFluid.Flowing::new);
	public static final RegistryObject<FlowingFluid> RADON = FLUIDS.register("radon", RadonFluid.Source::new);

	public static final RegistryObject<FlowingFluid> FLOWING_BROMINE = FLUIDS.register("flowing_bromine", BromineFluid.Flowing::new);
	public static final RegistryObject<FlowingFluid> BROMINE = FLUIDS.register("bromine", BromineFluid.Source::new);
	public static final RegistryObject<FlowingFluid> FLOWING_MERCURY = FLUIDS.register("flowing_mercury", MercuryFluid.Flowing::new);
	public static final RegistryObject<FlowingFluid> MERCURY = FLUIDS.register("mercury", MercuryFluid.Source::new);

	public static final RegistryObject<FlowingFluid> FLOWING_BRINE = FLUIDS.register("flowing_brine", BrineFluid.Flowing::new);
	public static final RegistryObject<FlowingFluid> BRINE = FLUIDS.register("brine", BrineFluid.Source::new);
	public static final RegistryObject<FlowingFluid> FLOWING_OIL = FLUIDS.register("flowing_oil", OilFluid.Flowing::new);
	public static final RegistryObject<FlowingFluid> OIL = FLUIDS.register("oil", OilFluid.Source::new);
	public static final RegistryObject<FlowingFluid> FLOWING_NATURAL_GAS = FLUIDS.register("flowing_natural_gas", NaturalGasFluid.Flowing::new);
	public static final RegistryObject<FlowingFluid> NATURAL_GAS = FLUIDS.register("natural_gas", NaturalGasFluid.Source::new);

	public static final RegistryObject<FlowingFluid> FLOWING_MAPLE_SYRUP = FLUIDS.register("flowing_maple_syrup", MapleSyrupFluid.Flowing::new);
	public static final RegistryObject<FlowingFluid> MAPLE_SYRUP = FLUIDS.register("maple_syrup", MapleSyrupFluid.Source::new);
	public static final RegistryObject<FlowingFluid> FLOWING_RUBBER_RESIN = FLUIDS.register("flowing_rubber_resin", RubberResinFluid.Flowing::new);
	public static final RegistryObject<FlowingFluid> RUBBER_RESIN = FLUIDS.register("rubber_resin", RubberResinFluid.Source::new);

	public static final RegistryObject<FlowingFluid> FLOWING_GASOLINE = FLUIDS.register("flowing_gasoline", GasolineFluid.Flowing::new);
	public static final RegistryObject<FlowingFluid> GASOLINE = FLUIDS.register("gasoline", GasolineFluid.Source::new);
	public static final RegistryObject<FlowingFluid> FLOWING_MACHINE_OIL = FLUIDS.register("flowing_machine_oil", MachineOilFluid.Flowing::new);
	public static final RegistryObject<FlowingFluid> MACHINE_OIL = FLUIDS.register("machine_oil", MachineOilFluid.Source::new);
	public static final RegistryObject<FlowingFluid> FLOWING_COOLANT = FLUIDS.register("flowing_coolant", CoolantFluid.Flowing::new);
	public static final RegistryObject<FlowingFluid> COOLANT = FLUIDS.register("coolant", CoolantFluid.Source::new);

	public static final RegistryObject<FluidType> HYDROGEN_TYPE = FLUID_TYPES.register("hyrdrogen", () -> new GasFluidType(FluidType.Properties.create().density(-1), 1680343295));
	public static final RegistryObject<FluidType> HELIUM_TYPE = FLUID_TYPES.register("helium", () -> new GasFluidType(FluidType.Properties.create(), 1687570373));
	public static final RegistryObject<FluidType> NITROGEN_TYPE = FLUID_TYPES.register("nitrogen", () -> new GasFluidType(FluidType.Properties.create(), 1692829175));
	public static final RegistryObject<FluidType> OXYGEN_TYPE = FLUID_TYPES.register("oxygen", () -> new GasFluidType(FluidType.Properties.create(), 1687612407));
	public static final RegistryObject<FluidType> FLUORINE_TYPE = FLUID_TYPES.register("fluorine", () -> new GasFluidType(FluidType.Properties.create(), 1692264576));
	public static final RegistryObject<FluidType> NEON_TYPE = FLUID_TYPES.register("neon", () -> new GasFluidType(FluidType.Properties.create(), 1693946630));
	public static final RegistryObject<FluidType> CHLORINE_TYPE = FLUID_TYPES.register("chlorine", () -> new GasFluidType(FluidType.Properties.create(), 1690894208));
	public static final RegistryObject<FluidType> ARGON_TYPE = FLUID_TYPES.register("argon", () -> new GasFluidType(FluidType.Properties.create(), 1692434893));
	public static final RegistryObject<FluidType> KRYPTON_TYPE = FLUID_TYPES.register("krypton", () -> new GasFluidType(FluidType.Properties.create(), 1686484447));
	public static final RegistryObject<FluidType> XENON_TYPE = FLUID_TYPES.register("xenon", () -> new GasFluidType(FluidType.Properties.create(), 1683921300));
	public static final RegistryObject<FluidType> RADON_TYPE = FLUID_TYPES.register("radon", () -> new GasFluidType(FluidType.Properties.create(), 1691357474));

	public static final RegistryObject<FluidType> BROMINE_TYPE = FLUID_TYPES.register("bromine", () -> new GasFluidType(FluidType.Properties.create(), -5621741));
	public static final RegistryObject<FluidType> MERCURY_TYPE = FLUID_TYPES.register("mercury", () -> new MetalFluidType(FluidType.Properties.create(), -1973791));

	public static final RegistryObject<FluidType> BRINE_TYPE = FLUID_TYPES.register("brine", () -> new OpaqueFluidType(FluidType.Properties.create(), -5579521));
	public static final RegistryObject<FluidType> OIL_TYPE = FLUID_TYPES.register("oil", () -> new GasFluidType(FluidType.Properties.create(), 1681011250));
	public static final RegistryObject<FluidType> NATURAL_GAS_TYPE = FLUID_TYPES.register("natural_gas", () -> new GasFluidType(FluidType.Properties.create(), 1684340580));

	public static final RegistryObject<FluidType> MAPLE_SYRUP_TYPE = FLUID_TYPES.register("maple_syrup", () -> new OpaqueFluidType(FluidType.Properties.create(), -10867944));
	public static final RegistryObject<FluidType> RUBBER_RESIN_TYPE = FLUID_TYPES.register("rubber_resin", () -> new OpaqueFluidType(FluidType.Properties.create(), -986928));

	public static final RegistryObject<FluidType> GASOLINE_TYPE = FLUID_TYPES.register("gasoline", () -> new GasFluidType(FluidType.Properties.create(), -2833815));
	public static final RegistryObject<FluidType> MACHINE_OIL_TYPE = FLUID_TYPES.register("machine_oil", () -> new OpaqueFluidType(FluidType.Properties.create(), -106));
	public static final RegistryObject<FluidType> COOLANT_TYPE = FLUID_TYPES.register("coolant", () -> new OpaqueFluidType(FluidType.Properties.create(), -4196524));
}
