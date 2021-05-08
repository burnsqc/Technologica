package com.technologica;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.technologica.fluid.FluidRegistration;
import com.technologica.setup.ClientSetup;
import com.technologica.setup.CommonSetup;
import com.technologica.setup.Config;
import com.technologica.setup.GatherData;
import com.technologica.setup.ModBiomeModifier;
import com.technologica.setup.ModEntityModifier;
import com.technologica.setup.Registration;

import net.minecraft.fluid.Fluid;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(MainMod.MODID)
public class MainMod {
	public static final String MODID = "technologica";
	public static final Logger LOGGER = LogManager.getLogger();
	
	public MainMod() 
	{
		ModLoadingContext.get().registerConfig(ModConfig.Type.CLIENT, Config.CLIENT_CONFIG);
		ModLoadingContext.get().registerConfig(ModConfig.Type.SERVER, Config.SERVER_CONFIG);
			
		Registration.init();
		
		FMLJavaModLoadingContext.get().getModEventBus().addListener(CommonSetup::init);	//1st event during mod lifecycle startup
		FMLJavaModLoadingContext.get().getModEventBus().addListener(ClientSetup::init);	//2nd event during mod lifecycle startup
		FMLJavaModLoadingContext.get().getModEventBus().addListener(GatherData::init);
		
		FMLJavaModLoadingContext.get().getModEventBus().addGenericListener(Fluid.class, FluidRegistration::register);
		
		MinecraftForge.EVENT_BUS.addListener(EventPriority.HIGH, ModBiomeModifier::init);	
		MinecraftForge.EVENT_BUS.addListener(EventPriority.HIGH, ModEntityModifier::init);	
	}
}