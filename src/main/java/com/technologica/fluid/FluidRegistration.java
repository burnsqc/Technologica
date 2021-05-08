package com.technologica.fluid;

import static com.technologica.MainMod.MODID;

import com.technologica.setup.Registration;

import net.minecraft.fluid.FlowingFluid;
import net.minecraft.fluid.Fluid;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fluids.FluidAttributes;
import net.minecraftforge.fluids.ForgeFlowingFluid;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;

public final class FluidRegistration {
  
    public static final RegistryObject<FlowingFluid> BRINE_SOURCE = RegistryObject.of(new ResourceLocation(MODID, "brine_source"), ForgeRegistries.FLUIDS);
    public static final RegistryObject<FlowingFluid> BRINE_FLOWING = RegistryObject.of(new ResourceLocation(MODID, "brine_flowing"), ForgeRegistries.FLUIDS);
    
//FLUIDS  
    
    public static void register(RegistryEvent.Register<Fluid> event){   
    	event.getRegistry().register(new ForgeFlowingFluid.Source(new ForgeFlowingFluid.Properties(BRINE_SOURCE, BRINE_FLOWING, FluidAttributes.builder(new ResourceLocation(MODID, "block/brine_still"), new ResourceLocation(MODID, "block/brine_flow"))).block(Registration.BRINE).bucket(Registration.BRINE_BUCKET)).setRegistryName(BRINE_SOURCE.getId()));
    	event.getRegistry().register(new ForgeFlowingFluid.Flowing(new ForgeFlowingFluid.Properties(BRINE_SOURCE, BRINE_FLOWING, FluidAttributes.builder(new ResourceLocation(MODID, "block/brine_still"), new ResourceLocation(MODID, "block/brine_flow"))).block(Registration.BRINE).bucket(Registration.BRINE_BUCKET)).setRegistryName(BRINE_FLOWING.getId()));
    }
}