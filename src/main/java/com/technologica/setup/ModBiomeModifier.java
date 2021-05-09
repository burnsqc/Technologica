package com.technologica.setup;

import com.google.common.collect.ImmutableList;
import com.technologica.world.gen.feature.ModConfiguredFeatures;

import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.Features;
import net.minecraft.world.gen.feature.MultipleRandomFeatureConfig;
import net.minecraft.world.gen.placement.AtSurfaceWithExtraConfig;
import net.minecraft.world.gen.placement.Placement;
import net.minecraftforge.event.world.BiomeLoadingEvent;

public class ModBiomeModifier {

	public static void init(final BiomeLoadingEvent biome) 
	{
		if (biome.getCategory().equals(Biome.Category.JUNGLE)) {
	    	biome.getGeneration().getFeatures(GenerationStage.Decoration.VEGETAL_DECORATION).add(() -> 
	    	Feature.RANDOM_SELECTOR.withConfiguration(new MultipleRandomFeatureConfig(ImmutableList.of(
	    			ModConfiguredFeatures.BANANA_TREE_FEATURE.withChance(0.5F)), 	    			 
	    			ModConfiguredFeatures.ORANGE_TREE_FEATURE))
	    	.withPlacement(Features.Placements.HEIGHTMAP_PLACEMENT)
	    	.withPlacement(Placement.COUNT_EXTRA.configure(new AtSurfaceWithExtraConfig(2, 0.1F, 1))));
	    }
	    else if (biome.getCategory().equals(Biome.Category.FOREST)) {
	    	biome.getGeneration().getFeatures(GenerationStage.Decoration.VEGETAL_DECORATION).add(() -> 
	    	Feature.RANDOM_SELECTOR.withConfiguration(new MultipleRandomFeatureConfig(ImmutableList.of(
	    			ModConfiguredFeatures.CHERRY_TREE_FEATURE.withChance(0.5F)),
	    			ModConfiguredFeatures.PEACH_TREE_FEATURE))
	    	.withPlacement(Features.Placements.HEIGHTMAP_PLACEMENT)
	    	.withPlacement(Placement.COUNT_EXTRA.configure(new AtSurfaceWithExtraConfig(1, 0.1F, 1))));
		}
		else if (biome.getCategory().equals(Biome.Category.BEACH)) {
			biome.getGeneration().getFeatures(GenerationStage.Decoration.VEGETAL_DECORATION).add(() -> 
	    	Feature.RANDOM_SELECTOR.withConfiguration(new MultipleRandomFeatureConfig(ImmutableList.of(
	    			ModConfiguredFeatures.COCONUT_TREE_FEATURE.withChance(1.0F)), 
	    			ModConfiguredFeatures.COCONUT_TREE_FEATURE))
	    	.withPlacement(Features.Placements.HEIGHTMAP_PLACEMENT)
	    	.withPlacement(Placement.COUNT_EXTRA.configure(new AtSurfaceWithExtraConfig(5, 0.1F, 1))));
		}
		else if (biome.getCategory().equals(Biome.Category.TAIGA)) {
			biome.getGeneration().getFeatures(GenerationStage.Decoration.VEGETAL_DECORATION).add(() -> 
	    	Feature.RANDOM_SELECTOR.withConfiguration(new MultipleRandomFeatureConfig(ImmutableList.of(
	    			ModConfiguredFeatures.PEAR_TREE_FEATURE.withChance(1.0F)), 
	    			Features.SPRUCE))
	    	.withPlacement(Features.Placements.HEIGHTMAP_PLACEMENT)
	    	.withPlacement(Placement.COUNT_EXTRA.configure(new AtSurfaceWithExtraConfig(1, 0.1F, 1))));			
		}
		else if (biome.getCategory().equals(Biome.Category.SWAMP)) {
			biome.getGeneration().getFeatures(GenerationStage.Decoration.VEGETAL_DECORATION).add(() -> 
	    	Feature.RANDOM_SELECTOR.withConfiguration(new MultipleRandomFeatureConfig(ImmutableList.of(
	    			ModConfiguredFeatures.KIWI_TREE_FEATURE.withChance(1.0F)), 
	    			Features.SPRUCE))
	    	.withPlacement(Features.Placements.HEIGHTMAP_PLACEMENT)
	    	.withPlacement(Placement.COUNT_EXTRA.configure(new AtSurfaceWithExtraConfig(1, 0.1F, 1))));			
		}
		else if (biome.getCategory().equals(Biome.Category.DESERT)) {
			biome.getGeneration().getFeatures(GenerationStage.Decoration.LAKES).add(() -> ModConfiguredFeatures.OASIS_FEATURE);
		}
    }	
}
