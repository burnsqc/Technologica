package com.technologica.fluid;

import static com.technologica.Technologica.MODID;

import net.minecraft.fluid.FlowingFluid;
import net.minecraft.fluid.Fluid;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public final class TechnologicaFluids {

	private TechnologicaFluids() {
		// use private constructor to hide default constructor
	}

	public static final DeferredRegister<Fluid> FLUIDS = DeferredRegister.create(ForgeRegistries.FLUIDS, MODID);
	
	public static final RegistryObject<FlowingFluid> BRINE_SOURCE = FLUIDS.register("brine_source", BrineFluid.Source::new);
	public static final RegistryObject<FlowingFluid> BRINE_FLOWING = FLUIDS.register("brine_flowing", BrineFluid.Flowing::new);
	
	public static final RegistryObject<FlowingFluid> MERCURY_SOURCE = FLUIDS.register("mercury_source", MercuryFluid.Source::new);
	public static final RegistryObject<FlowingFluid> MERCURY_FLOWING = FLUIDS.register("mercury_flowing", MercuryFluid.Flowing::new);
    
	public static final RegistryObject<FlowingFluid> HYDROGEN_SOURCE = FLUIDS.register("hydrogen_source", HydrogenFluid.Source::new);
	public static final RegistryObject<FlowingFluid> HYDROGEN_FLOWING = FLUIDS.register("hydrogen_flowing", HydrogenFluid.Flowing::new);
	
    public static void register() {   
    	FLUIDS.register(FMLJavaModLoadingContext.get().getModEventBus());
    }
}
