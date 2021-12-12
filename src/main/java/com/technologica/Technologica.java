package com.technologica;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.technologica.block.TechnologicaBlocks;
import com.technologica.entity.TechnologicaEntityType;
import com.technologica.fluid.TechnologicaFluids;
import com.technologica.item.TechnologicaItems;
import com.technologica.item.crafting.TechnologicaRecipeSerializer;
import com.technologica.listeners.DisableLogDrops;
import com.technologica.listeners.DropBarkOnLogStrip;
import com.technologica.listeners.LunarLowGrav;
import com.technologica.listeners.RegisterEntityAttributes;
import com.technologica.particles.TechnologicaParticleTypes;
import com.technologica.setup.ClientSetup;
import com.technologica.setup.CommonSetup;
import com.technologica.setup.Config;
import com.technologica.setup.GatherData;
import com.technologica.setup.ParticleSetup;
import com.technologica.setup.VanillaBiomeModifier;
import com.technologica.setup.VanillaEntityModifier;
import com.technologica.tileentity.TechnologicaTileEntities;
import com.technologica.util.DisablePlankConditionFactory;
import com.technologica.util.EnablePlankConditionFactory;
import com.technologica.util.TechnologicaSoundEvents;
import com.technologica.world.biome.TechnologicaBiomes;
import com.technologica.world.gen.feature.TechnologicaFeatures;
import com.technologica.world.gen.foliageplacer.TechnologicaFoliagePlacers;
import com.technologica.world.gen.surfacebuilders.TechnologicaSurfaceBuilders;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.crafting.CraftingHelper;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig.Type;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(Technologica.MODID)
public class Technologica {
	public static final String MODID = "technologica";
	public static final Logger LOGGER = LogManager.getLogger();
	
	public Technologica() 
	{
		ModLoadingContext.get().registerConfig(Type.COMMON, Config.SPEC, "technologica-common.toml");
			
		LOGGER.info("REGISTERING GAME OBJECTS - BLOCKS");
		TechnologicaBlocks.register();
		LOGGER.info("REGISTERING GAME OBJECTS - FLUIDS");
		TechnologicaFluids.register();
		LOGGER.info("REGISTERING GAME OBJECTS - ITEMS");
		TechnologicaItems.register();
		LOGGER.info("REGISTERING GAME OBJECTS - ENTITIES");
		TechnologicaEntityType.register();
		LOGGER.info("REGISTERING GAME OBJECTS - TILE ENTITIES");
		TechnologicaTileEntities.register();
		
		LOGGER.info("REGISTERING OTHER - RECIPE SERIALIZERS");
		TechnologicaRecipeSerializer.register();
		
		LOGGER.info("REGISTERING OTHER - SOUND EVENTS");
		TechnologicaSoundEvents.register();
		
		LOGGER.info("REGISTERING EFFECTS - PARTICLES");
		TechnologicaParticleTypes.register();
		
		LOGGER.info("REGISTERING WORLDGEN - FEATURES");
		TechnologicaFeatures.register();
		LOGGER.info("REGISTERING WORLDGEN - FOLIAGE PLACER TYPES");
		TechnologicaFoliagePlacers.register();
		LOGGER.info("REGISTERING WORLDGEN - SURFACE BUILDERS");
		TechnologicaSurfaceBuilders.register();
		LOGGER.info("REGISTERING WORLDGEN - BIOMES");
		TechnologicaBiomes.register();
		
		CraftingHelper.register(DisablePlankConditionFactory.Serializer.INSTANCE);
		CraftingHelper.register(EnablePlankConditionFactory.Serializer.INSTANCE);
		
		FMLJavaModLoadingContext.get().getModEventBus().addListener(CommonSetup::init);	//1st event during mod lifecycle startup
		FMLJavaModLoadingContext.get().getModEventBus().addListener(ClientSetup::init);	//2nd event during mod lifecycle startup
		FMLJavaModLoadingContext.get().getModEventBus().addListener(GatherData::init);
		FMLJavaModLoadingContext.get().getModEventBus().addListener(ClientSetup::stitch);
		FMLJavaModLoadingContext.get().getModEventBus().addListener(ParticleSetup::init);
		FMLJavaModLoadingContext.get().getModEventBus().addListener(RegisterEntityAttributes::onEntityAttributeCreationEvent);
		
		MinecraftForge.EVENT_BUS.addListener(EventPriority.HIGH, VanillaBiomeModifier::init);	
		MinecraftForge.EVENT_BUS.addListener(EventPriority.HIGH, VanillaEntityModifier::init);	
		
		MinecraftForge.EVENT_BUS.register(new LunarLowGrav());
		MinecraftForge.EVENT_BUS.register(new DropBarkOnLogStrip());
		MinecraftForge.EVENT_BUS.register(new DisableLogDrops());
	}
}
