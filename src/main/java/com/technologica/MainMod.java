package com.technologica;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.google.common.collect.ImmutableList;
import com.technologica.data.ModBlockStateProvider;
import com.technologica.data.ModBlockTagsProvider;
import com.technologica.data.ModItemModelProvider;
import com.technologica.data.ModItemTagsProvider;
import com.technologica.data.ModLanguageProvider;
import com.technologica.data.ModLootTableProvider;
import com.technologica.data.ModRecipeProvider;
import com.technologica.entity.passive.DuckEntity;
import com.technologica.setup.ClientSetup;
import com.technologica.setup.Config;
import com.technologica.setup.ModSetup;
import com.technologica.setup.Registration;
import com.technologica.world.gen.feature.ModFeatures;

import net.minecraft.data.DataGenerator;
import net.minecraft.entity.ai.attributes.GlobalEntityTypeAttributes;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.Features;
import net.minecraft.world.gen.feature.MultipleRandomFeatureConfig;
import net.minecraft.world.gen.placement.AtSurfaceWithExtraConfig;
import net.minecraft.world.gen.placement.Placement;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.event.world.BiomeLoadingEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.lifecycle.GatherDataEvent;
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
		FMLJavaModLoadingContext.get().getModEventBus().addListener(this::gatherData);
		FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
	}
	
	private void gatherData(final GatherDataEvent event) {
		DataGenerator generator = event.getGenerator();
		ExistingFileHelper helper = event.getExistingFileHelper();
		if(event.includeClient()) {
			generator.addProvider(new ModLanguageProvider(generator));
			generator.addProvider(new ModBlockStateProvider(generator, helper));
			generator.addProvider(new ModItemModelProvider(generator, helper));
		}
		if(event.includeServer()) {
			ModBlockTagsProvider modBlockTagsProvider = new ModBlockTagsProvider(generator, helper);
			generator.addProvider(modBlockTagsProvider);
			generator.addProvider(new ModItemTagsProvider(generator, modBlockTagsProvider, helper));
			generator.addProvider(new ModRecipeProvider(generator));
			generator.addProvider(new ModLootTableProvider(generator));
		}
	}
	
	private void setup(final FMLCommonSetupEvent event)
    {
        
            GlobalEntityTypeAttributes.put(Registration.DUCK.get(), DuckEntity.registerAttributes().create());
     
    }
	
	public void biomeModification(BiomeLoadingEvent biome) 
	{
		if (biome.getCategory().equals(Biome.Category.JUNGLE)) {
	    	biome.getGeneration().getFeatures(GenerationStage.Decoration.VEGETAL_DECORATION).add(() -> 
	    	Feature.RANDOM_SELECTOR.withConfiguration(new MultipleRandomFeatureConfig(ImmutableList.of(
	    			ModFeatures.BANANA_TREE_FEATURE.withChance(0.5F)), 	    			 
	    			ModFeatures.ORANGE_TREE_FEATURE))
	    	.withPlacement(Features.Placements.HEIGHTMAP_PLACEMENT)
	    	.withPlacement(Placement.COUNT_EXTRA.configure(new AtSurfaceWithExtraConfig(2, 0.1F, 1))));
	    }
	    else if (biome.getCategory().equals(Biome.Category.FOREST)) {
	    	biome.getGeneration().getFeatures(GenerationStage.Decoration.VEGETAL_DECORATION).add(() -> 
	    	Feature.RANDOM_SELECTOR.withConfiguration(new MultipleRandomFeatureConfig(ImmutableList.of(
	    			ModFeatures.CHERRY_TREE_FEATURE.withChance(0.5F)),
	    			ModFeatures.PEACH_TREE_FEATURE))
	    	.withPlacement(Features.Placements.HEIGHTMAP_PLACEMENT)
	    	.withPlacement(Placement.COUNT_EXTRA.configure(new AtSurfaceWithExtraConfig(1, 0.1F, 1))));
		}
		else if (biome.getCategory().equals(Biome.Category.BEACH)) {
			biome.getGeneration().getFeatures(GenerationStage.Decoration.VEGETAL_DECORATION).add(() -> 
	    	Feature.RANDOM_SELECTOR.withConfiguration(new MultipleRandomFeatureConfig(ImmutableList.of(
	    			ModFeatures.COCONUT_TREE_FEATURE.withChance(1.0F)), 
	    			ModFeatures.COCONUT_TREE_FEATURE))
	    	.withPlacement(Features.Placements.HEIGHTMAP_PLACEMENT)
	    	.withPlacement(Placement.COUNT_EXTRA.configure(new AtSurfaceWithExtraConfig(5, 0.1F, 1))));
		}
		else if (biome.getCategory().equals(Biome.Category.TAIGA)) {
			biome.getGeneration().getFeatures(GenerationStage.Decoration.VEGETAL_DECORATION).add(() -> 
	    	Feature.RANDOM_SELECTOR.withConfiguration(new MultipleRandomFeatureConfig(ImmutableList.of(
	    			ModFeatures.PEAR_TREE_FEATURE.withChance(1.0F)), 
	    			Features.SPRUCE))
	    	.withPlacement(Features.Placements.HEIGHTMAP_PLACEMENT)
	    	.withPlacement(Placement.COUNT_EXTRA.configure(new AtSurfaceWithExtraConfig(1, 0.1F, 1))));			
		}
		else if (biome.getCategory().equals(Biome.Category.SWAMP)) {
			biome.getGeneration().getFeatures(GenerationStage.Decoration.VEGETAL_DECORATION).add(() -> 
	    	Feature.RANDOM_SELECTOR.withConfiguration(new MultipleRandomFeatureConfig(ImmutableList.of(
	    			ModFeatures.KIWI_TREE_FEATURE.withChance(1.0F)), 
	    			Features.SPRUCE))
	    	.withPlacement(Features.Placements.HEIGHTMAP_PLACEMENT)
	    	.withPlacement(Placement.COUNT_EXTRA.configure(new AtSurfaceWithExtraConfig(1, 0.1F, 1))));			
		}
		else if (biome.getCategory().equals(Biome.Category.DESERT)) {
			biome.getGeneration().getFeatures(GenerationStage.Decoration.LAKES).add(() -> ModFeatures.OASIS_FEATURE);
		}
    }	
}