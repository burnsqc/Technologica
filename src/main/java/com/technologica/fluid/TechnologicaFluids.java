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
	
	public static final RegistryObject<FlowingFluid> FLOWING_BRINE = FLUIDS.register("flowing_brine", BrineFluid.Flowing::new);
	public static final RegistryObject<FlowingFluid> BRINE = FLUIDS.register("brine", BrineFluid.Source::new);
	
	public static final RegistryObject<FlowingFluid> FLOWING_MERCURY = FLUIDS.register("flowing_mercury", MercuryFluid.Flowing::new);
	public static final RegistryObject<FlowingFluid> MERCURY = FLUIDS.register("mercury", MercuryFluid.Source::new);
	
	public static final RegistryObject<FlowingFluid> FLOWING_HYDROGEN = FLUIDS.register("flowing_hydrogen", HydrogenFluid.Flowing::new);
	public static final RegistryObject<FlowingFluid> HYDROGEN = FLUIDS.register("hydrogen", HydrogenFluid.Source::new);
	
    public static void register() {   
    	FLUIDS.register(FMLJavaModLoadingContext.get().getModEventBus());
    }
}
