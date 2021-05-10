package com.technologica.fluid;

import static com.technologica.Technologica.MODID;

import net.minecraft.fluid.FlowingFluid;
import net.minecraft.fluid.Fluid;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public final class ModFluids {
	public static final DeferredRegister<Fluid> FLUIDS = DeferredRegister.create(ForgeRegistries.FLUIDS, MODID);
	
	public static final RegistryObject<FlowingFluid> BRINE_SOURCE = FLUIDS.register("brine_source", () -> new BrineFluid.Source());
	public static final RegistryObject<FlowingFluid> BRINE_FLOWING = FLUIDS.register("brine_flowing", () -> new BrineFluid.Flowing());
	
	public static final RegistryObject<FlowingFluid> MERCURY_SOURCE = FLUIDS.register("mercury_source", () -> new MercuryFluid.Source());
	public static final RegistryObject<FlowingFluid> MERCURY_FLOWING = FLUIDS.register("mercury_flowing", () -> new MercuryFluid.Flowing());
    
	public static final RegistryObject<FlowingFluid> HYDROGEN_SOURCE = FLUIDS.register("hydrogen_source", () -> new HydrogenFluid.Source());
	public static final RegistryObject<FlowingFluid> HYDROGEN_FLOWING = FLUIDS.register("hydrogen_flowing", () -> new HydrogenFluid.Flowing());
	
    public static void register() {   
    	FLUIDS.register(FMLJavaModLoadingContext.get().getModEventBus());
    }
}