package com.technologica.setup;

import com.google.common.collect.ImmutableList;
import com.technologica.world.gen.feature.TechnologicaConfiguredFeatures;

import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.Features;
import net.minecraft.world.gen.feature.MultipleRandomFeatureConfig;
import net.minecraft.world.gen.placement.AtSurfaceWithExtraConfig;
import net.minecraft.world.gen.placement.Placement;
import net.minecraftforge.event.world.BiomeLoadingEvent;

public class VanillaBiomeModifier {

	private VanillaBiomeModifier() {
		// hide constructor for class with only static members
	}

	public static void init(final BiomeLoadingEvent biome)
	{
		if (biome.getCategory().equals(Biome.Category.JUNGLE)) {
	    	biome.getGeneration().getFeatures(GenerationStage.Decoration.VEGETAL_DECORATION).add(() -> 
	    	Feature.RANDOM_SELECTOR.withConfiguration(new MultipleRandomFeatureConfig(ImmutableList.of(
	    			TechnologicaConfiguredFeatures.BANANA_TREE_FEATURE.withChance(0.5F)), 	    			 
	    			TechnologicaConfiguredFeatures.ORANGE_TREE_FEATURE))
	    	.withPlacement(Features.Placements.HEIGHTMAP_PLACEMENT)
	    	.withPlacement(Placement.COUNT_EXTRA.configure(new AtSurfaceWithExtraConfig(2, 0.1F, 1))));
	    }
	    else if (biome.getCategory().equals(Biome.Category.FOREST)) {
	    	biome.getGeneration().getFeatures(GenerationStage.Decoration.VEGETAL_DECORATION).add(() -> 
	    	Feature.RANDOM_SELECTOR.withConfiguration(new MultipleRandomFeatureConfig(ImmutableList.of(
	    			TechnologicaConfiguredFeatures.CHERRY_TREE_FEATURE.withChance(0.5F)),
	    			TechnologicaConfiguredFeatures.PEACH_TREE_FEATURE))
	    	.withPlacement(Features.Placements.HEIGHTMAP_PLACEMENT)
	    	.withPlacement(Placement.COUNT_EXTRA.configure(new AtSurfaceWithExtraConfig(1, 0.1F, 1))));
		}
		else if (biome.getCategory().equals(Biome.Category.BEACH)) {
			biome.getGeneration().getFeatures(GenerationStage.Decoration.VEGETAL_DECORATION).add(() -> 
	    	Feature.RANDOM_SELECTOR.withConfiguration(new MultipleRandomFeatureConfig(ImmutableList.of(
	    			TechnologicaConfiguredFeatures.COCONUT_TREE_FEATURE.withChance(1.0F)), 
	    			TechnologicaConfiguredFeatures.COCONUT_TREE_FEATURE))
	    	.withPlacement(Features.Placements.HEIGHTMAP_PLACEMENT)
	    	.withPlacement(Placement.COUNT_EXTRA.configure(new AtSurfaceWithExtraConfig(5, 0.1F, 1))));
		}
		else if (biome.getCategory().equals(Biome.Category.TAIGA)) {
			biome.getGeneration().getFeatures(GenerationStage.Decoration.VEGETAL_DECORATION).add(() -> 
	    	Feature.RANDOM_SELECTOR.withConfiguration(new MultipleRandomFeatureConfig(ImmutableList.of(
	    			TechnologicaConfiguredFeatures.PEAR_TREE_FEATURE.withChance(1.0F)), 
	    			Features.SPRUCE))
	    	.withPlacement(Features.Placements.HEIGHTMAP_PLACEMENT)
	    	.withPlacement(Placement.COUNT_EXTRA.configure(new AtSurfaceWithExtraConfig(1, 0.1F, 1))));			
		}
		else if (biome.getCategory().equals(Biome.Category.SWAMP)) {
			biome.getGeneration().getFeatures(GenerationStage.Decoration.VEGETAL_DECORATION).add(() -> 
	    	Feature.RANDOM_SELECTOR.withConfiguration(new MultipleRandomFeatureConfig(ImmutableList.of(
	    			TechnologicaConfiguredFeatures.KIWI_TREE_FEATURE.withChance(1.0F)), 
	    			Features.SPRUCE))
	    	.withPlacement(Features.Placements.HEIGHTMAP_PLACEMENT)
	    	.withPlacement(Placement.COUNT_EXTRA.configure(new AtSurfaceWithExtraConfig(1, 0.1F, 1))));			
		}
		else if (biome.getCategory().equals(Biome.Category.DESERT)) {
			biome.getGeneration().getFeatures(GenerationStage.Decoration.LAKES).add(() -> TechnologicaConfiguredFeatures.OASIS_FEATURE);
		}
    }	
}
