package com.technologica;

import net.minecraftforge.fml.config.ModConfig.Type;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.technologica.block.ModBlocks;
import com.technologica.entity.ModEntities;
import com.technologica.fluid.ModFluids;
import com.technologica.item.ModItems;
import com.technologica.setup.ClientSetup;
import com.technologica.setup.CommonSetup;
import com.technologica.setup.Config;
import com.technologica.setup.GatherData;
import com.technologica.setup.VanillaBiomeModifier;
import com.technologica.setup.VanillaEntityModifier;
import com.technologica.tileentity.ModTileEntities;
import com.technologica.world.biome.ModBiomes;
import com.technologica.world.gen.feature.ModFeatures;
import com.technologica.world.gen.foliageplacer.ModFoliagePlacers;
import com.technologica.world.gen.surfacebuilders.ModSurfaceBuilders;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(Technologica.MODID)
public class Technologica {
	public static final String MODID = "technologica";
	public static final Logger LOGGER = LogManager.getLogger();
	
	public Technologica() 
	{
		ModLoadingContext.get().registerConfig(Type.COMMON, Config.SPEC, "technologica-common.toml");
			
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
		LOGGER.info("REGISTERING WORLDGEN - SURFACE BUILDERS");
		ModSurfaceBuilders.register();
		LOGGER.info("REGISTERING WORLDGEN - BIOMES");
		ModBiomes.register();
		
		FMLJavaModLoadingContext.get().getModEventBus().addListener(CommonSetup::init);	//1st event during mod lifecycle startup
		FMLJavaModLoadingContext.get().getModEventBus().addListener(ClientSetup::init);	//2nd event during mod lifecycle startup
		FMLJavaModLoadingContext.get().getModEventBus().addListener(GatherData::init);
		FMLJavaModLoadingContext.get().getModEventBus().addListener(ClientSetup::stitch);
		
		MinecraftForge.EVENT_BUS.addListener(EventPriority.HIGH, VanillaBiomeModifier::init);	
		MinecraftForge.EVENT_BUS.addListener(EventPriority.HIGH, VanillaEntityModifier::init);	
	}
}