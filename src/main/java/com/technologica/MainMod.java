package com.technologica;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.technologica.setup.ClientSetup;
import com.technologica.setup.Config;
import com.technologica.setup.ModSetup;
import com.technologica.setup.Registration;
import com.technologica.world.gen.feature.ModFeatures;

import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.GenerationStage;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.world.BiomeLoadingEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(MainMod.MODID)
public class MainMod 
{
	public static final String MODID = "technologica";
	public static final Logger LOGGER = LogManager.getLogger();
	
	public MainMod() 
	{
		ModLoadingContext.get().registerConfig(ModConfig.Type.CLIENT, Config.CLIENT_CONFIG);
		ModLoadingContext.get().registerConfig(ModConfig.Type.SERVER, Config.SERVER_CONFIG);
			
		Registration.init();
		
		FMLJavaModLoadingContext.get().getModEventBus().addListener(ModSetup::init);
		FMLJavaModLoadingContext.get().getModEventBus().addListener(ClientSetup::init);
		
		MinecraftForge.EVENT_BUS.addListener(EventPriority.HIGH, this::biomeModification);
	}
	
	public void biomeModification(BiomeLoadingEvent biome) 
	{
		if (biome.getCategory().equals(Biome.Category.SWAMP)) {
	    	biome.getGeneration().getFeatures(GenerationStage.Decoration.VEGETAL_DECORATION).add(() -> ModFeatures.BANANA_TREE_FEATURE);
	    }
	    else if (biome.getCategory().equals(Biome.Category.FOREST)) {
			biome.getGeneration().getFeatures(GenerationStage.Decoration.VEGETAL_DECORATION).add(() -> ModFeatures.CHERRY_TREE_FEATURE);
		}
		else if (biome.getCategory().equals(Biome.Category.BEACH)) {
			biome.getGeneration().getFeatures(GenerationStage.Decoration.VEGETAL_DECORATION).add(() -> ModFeatures.COCONUT_TREE_FEATURE);
		}
		else if (biome.getCategory().equals(Biome.Category.JUNGLE)) {
			biome.getGeneration().getFeatures(GenerationStage.Decoration.VEGETAL_DECORATION).add(() -> ModFeatures.LEMON_TREE_FEATURE);
		}
		else if (biome.getCategory().equals(Biome.Category.JUNGLE)) {
			biome.getGeneration().getFeatures(GenerationStage.Decoration.VEGETAL_DECORATION).add(() -> ModFeatures.LIME_TREE_FEATURE);
		}
		else if (biome.getCategory().equals(Biome.Category.JUNGLE)) {
			biome.getGeneration().getFeatures(GenerationStage.Decoration.VEGETAL_DECORATION).add(() -> ModFeatures.ORANGE_TREE_FEATURE);
		}
		else if (biome.getCategory().equals(Biome.Category.TAIGA)) {
			biome.getGeneration().getFeatures(GenerationStage.Decoration.VEGETAL_DECORATION).add(() -> ModFeatures.PEAR_TREE_FEATURE);
		}
    }	
}