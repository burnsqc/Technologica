package com.technologica.setup;

import com.technologica.world.gen.feature.TechnologicaConfiguredFeatures;

import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.feature.Features;
import net.minecraft.world.gen.placement.AtSurfaceWithExtraConfig;
import net.minecraft.world.gen.placement.Placement;
import net.minecraftforge.event.world.BiomeLoadingEvent;

public class VanillaBiomeModifier {

	public static void init(final BiomeLoadingEvent biomeIn) {
		if (biomeIn.getName().getPath().equals("jungle") || biomeIn.getName().getPath().equals("jungle_hills") || biomeIn.getName().getPath().equals("modified_jungle")) {
			biomeIn.getGeneration().getFeatures(GenerationStage.Decoration.VEGETAL_DECORATION).add(() -> TechnologicaConfiguredFeatures.EBONY_TREE_FEATURE.withPlacement(Features.Placements.HEIGHTMAP_PLACEMENT).withPlacement(Placement.COUNT_EXTRA.configure(new AtSurfaceWithExtraConfig(3, 0.5F, 2))));
			biomeIn.getGeneration().getFeatures(GenerationStage.Decoration.VEGETAL_DECORATION).add(() -> TechnologicaConfiguredFeatures.KIWI_TREE_FEATURE.withPlacement(Features.Placements.HEIGHTMAP_PLACEMENT).withPlacement(Placement.COUNT_EXTRA.configure(new AtSurfaceWithExtraConfig(3, 0.5F, 2))));
			biomeIn.getGeneration().getFeatures(GenerationStage.Decoration.VEGETAL_DECORATION).add(() -> TechnologicaConfiguredFeatures.RUBBER_TREE_FEATURE.withPlacement(Features.Placements.HEIGHTMAP_PLACEMENT).withPlacement(Placement.COUNT_EXTRA.configure(new AtSurfaceWithExtraConfig(3, 0.5F, 2))));
	    } 
		
		else if (biomeIn.getName().getPath().equals("jungle_edge") || biomeIn.getName().getPath().equals("modified_jungle_edge")) {
			biomeIn.getGeneration().getFeatures(GenerationStage.Decoration.VEGETAL_DECORATION).add(() -> TechnologicaConfiguredFeatures.TEAK_TREE_FEATURE.withPlacement(Features.Placements.HEIGHTMAP_PLACEMENT).withPlacement(Placement.COUNT_EXTRA.configure(new AtSurfaceWithExtraConfig(3, 0.5F, 2))));
	    }
		
		else if (biomeIn.getName().getPath().equals("bamboo_jungle") || biomeIn.getName().getPath().equals("bamboo_jungle_hills")) {
			biomeIn.getGeneration().getFeatures(GenerationStage.Decoration.VEGETAL_DECORATION).add(() -> TechnologicaConfiguredFeatures.CHERRY_TREE_FEATURE.withPlacement(Features.Placements.HEIGHTMAP_PLACEMENT).withPlacement(Placement.COUNT_EXTRA.configure(new AtSurfaceWithExtraConfig(3, 0.5F, 2))));
			biomeIn.getGeneration().getFeatures(GenerationStage.Decoration.VEGETAL_DECORATION).add(() -> TechnologicaConfiguredFeatures.PLUM_TREE_FEATURE.withPlacement(Features.Placements.HEIGHTMAP_PLACEMENT).withPlacement(Placement.COUNT_EXTRA.configure(new AtSurfaceWithExtraConfig(3, 0.5F, 2))));
	    }
		
		else if (biomeIn.getName().getPath().equals("forest")) {
	    	biomeIn.getGeneration().getFeatures(GenerationStage.Decoration.VEGETAL_DECORATION).add(() -> TechnologicaConfiguredFeatures.CHESTNUT_TREE_FEATURE.withPlacement(Features.Placements.HEIGHTMAP_PLACEMENT).withPlacement(Placement.COUNT_EXTRA.configure(new AtSurfaceWithExtraConfig(3, 0.1F, 2))));
	    }
	    	
		else if (biomeIn.getName().getPath().equals("birch_forest") || biomeIn.getName().getPath().equals("birch_forest_hills")) {
	    	biomeIn.getGeneration().getFeatures(GenerationStage.Decoration.VEGETAL_DECORATION).add(() -> TechnologicaConfiguredFeatures.PEACH_TREE_FEATURE.withPlacement(Features.Placements.HEIGHTMAP_PLACEMENT).withPlacement(Placement.COUNT_EXTRA.configure(new AtSurfaceWithExtraConfig(3, 0.1F, 2))));
	    }
		
		else if (biomeIn.getName().getPath().equals("wooded_hills") || biomeIn.getName().getPath().equals("wooded_mountains")) {
	    	biomeIn.getGeneration().getFeatures(GenerationStage.Decoration.VEGETAL_DECORATION).add(() -> TechnologicaConfiguredFeatures.ASPEN_TREE_FEATURE.withPlacement(Features.Placements.HEIGHTMAP_PLACEMENT).withPlacement(Placement.COUNT_EXTRA.configure(new AtSurfaceWithExtraConfig(3, 0.5F, 2))));
	    }
	    
		else if (biomeIn.getName().getPath().equals("beach")) {
			biomeIn.getGeneration().getFeatures(GenerationStage.Decoration.VEGETAL_DECORATION).add(() -> TechnologicaConfiguredFeatures.COCONUT_TREE_FEATURE.withPlacement(Features.Placements.HEIGHTMAP_PLACEMENT).withPlacement(Placement.COUNT_EXTRA.configure(new AtSurfaceWithExtraConfig(1, 0.1F, 1))));
		} 
	    
		else if (biomeIn.getName().getPath().equals("taiga") || biomeIn.getName().getPath().equals("taiga hills")) {
			biomeIn.getGeneration().getFeatures(GenerationStage.Decoration.VEGETAL_DECORATION).add(() -> TechnologicaConfiguredFeatures.APRICOT_TREE_FEATURE.withPlacement(Features.Placements.HEIGHTMAP_PLACEMENT).withPlacement(Placement.COUNT_EXTRA.configure(new AtSurfaceWithExtraConfig(1, 0.2F, 5))));		
			biomeIn.getGeneration().getFeatures(GenerationStage.Decoration.VEGETAL_DECORATION).add(() -> TechnologicaConfiguredFeatures.PEAR_TREE_FEATURE.withPlacement(Features.Placements.HEIGHTMAP_PLACEMENT).withPlacement(Placement.COUNT_EXTRA.configure(new AtSurfaceWithExtraConfig(1, 0.2F, 5))));		
		}
		
		else if (biomeIn.getName().getPath().equals("snowy_taiga") || biomeIn.getName().getPath().equals("snowy_taiga hills")) {
			biomeIn.getGeneration().getFeatures(GenerationStage.Decoration.VEGETAL_DECORATION).add(() -> TechnologicaConfiguredFeatures.MAPLE_TREE_FEATURE.withPlacement(Features.Placements.HEIGHTMAP_PLACEMENT).withPlacement(Placement.COUNT_EXTRA.configure(new AtSurfaceWithExtraConfig(1, 0.2F, 5))));
			biomeIn.getGeneration().getFeatures(GenerationStage.Decoration.VEGETAL_DECORATION).add(() -> TechnologicaConfiguredFeatures.WALNUT_TREE_FEATURE.withPlacement(Features.Placements.HEIGHTMAP_PLACEMENT).withPlacement(Placement.COUNT_EXTRA.configure(new AtSurfaceWithExtraConfig(1, 0.2F, 5))));		
		}
		
		else if (biomeIn.getName().getPath().equals("swamp") || biomeIn.getName().getPath().equals("swamp hills")) {
			biomeIn.getGeneration().getFeatures(GenerationStage.Decoration.VEGETAL_DECORATION).add(() -> TechnologicaConfiguredFeatures.ORANGE_TREE_FEATURE.withPlacement(Features.Placements.HEIGHTMAP_PLACEMENT).withPlacement(Placement.COUNT_EXTRA.configure(new AtSurfaceWithExtraConfig(3, 0.2F, 2))));		
		} 
	    
		else if (biomeIn.getCategory().equals(Biome.Category.SAVANNA)) {
			biomeIn.getGeneration().getFeatures(GenerationStage.Decoration.VEGETAL_DECORATION).add(() -> TechnologicaConfiguredFeatures.ZEBRAWOOD_TREE_FEATURE.withPlacement(Features.Placements.HEIGHTMAP_PLACEMENT).withPlacement(Placement.COUNT_EXTRA.configure(new AtSurfaceWithExtraConfig(1, 0.1F, 1))));
		} 
	    
		else if (biomeIn.getCategory().equals(Biome.Category.DESERT)) {
			biomeIn.getGeneration().getFeatures(GenerationStage.Decoration.LAKES).add(() -> TechnologicaConfiguredFeatures.OASIS_FEATURE);
		}
    }	
}
