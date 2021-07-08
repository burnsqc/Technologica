package com.technologica;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.technologica.block.ModBlocks;
import com.technologica.entity.ModEntities;
import com.technologica.fluid.ModFluids;
import com.technologica.items.ModItems;
import com.technologica.setup.ClientSetup;
import com.technologica.setup.CommonSetup;
import com.technologica.setup.Config;
import com.technologica.setup.GatherData;
import com.technologica.setup.ModBiomeModifier;
import com.technologica.setup.ModEntityModifier;
import com.technologica.tileentity.ModTileEntities;
import com.technologica.world.gen.feature.ModFeatures;
import com.technologica.world.gen.foliageplacer.ModFoliagePlacers;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(Technologica.MODID)
public class Technologica {
	public static final String MODID = "technologica";
	public static final Logger LOGGER = LogManager.getLogger();
	
	public Technologica() 
	{
		ModLoadingContext.get().registerConfig(ModConfig.Type.CLIENT, Config.CLIENT_CONFIG);
		ModLoadingContext.get().registerConfig(ModConfig.Type.SERVER, Config.SERVER_CONFIG);
			
		LOGGER.info("REGISTERING GAME OBJECTS - BLOCKS");
		ModBlocks.register();
		LOGGER.info("REGISTERING GAME OBJECTS - FLUIDS");
		ModFluids.register();
		LOGGER.info("REGISTERING GAME OBJECTS - ITEMS");
		ModItems.register();
		LOGGER.info("REGISTERING GAME OBJECTS - ENTITIES");
		ModEntities.register();
		LOGGER.info("REGISTERING GAME OBJECTS - TILE ENTITIES");
		ModTileEntities.register();
		
		LOGGER.info("REGISTERING WORLDGEN - FEATURES");
		ModFeatures.register();
		LOGGER.info("REGISTERING WORLDGEN - FOLIAGE PLACER TYPES");
		ModFoliagePlacers.register();
		
		FMLJavaModLoadingContext.get().getModEventBus().addListener(CommonSetup::init);	//1st event during mod lifecycle startup
		FMLJavaModLoadingContext.get().getModEventBus().addListener(ClientSetup::init);	//2nd event during mod lifecycle startup
		FMLJavaModLoadingContext.get().getModEventBus().addListener(GatherData::init);
		
		MinecraftForge.EVENT_BUS.addListener(EventPriority.HIGH, ModBiomeModifier::init);	
		MinecraftForge.EVENT_BUS.addListener(EventPriority.HIGH, ModEntityModifier::init);	
	}
}