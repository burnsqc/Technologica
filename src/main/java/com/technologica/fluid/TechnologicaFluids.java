package com.technologica.fluid;

import static com.technologica.Technologica.MODID;

import net.minecraft.fluid.FlowingFluid;
import net.minecraft.fluid.Fluid;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public final class TechnologicaFluids {
	public static final DeferredRegister<Fluid> FLUIDS = DeferredRegister.create(ForgeRegistries.FLUIDS, MODID);
	
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
	
    public static void register() {   
    	FLUIDS.register(FMLJavaModLoadingContext.get().getModEventBus());
    }
}
