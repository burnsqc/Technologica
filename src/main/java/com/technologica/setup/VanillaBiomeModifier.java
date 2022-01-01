package com.technologica.setup;

import com.technologica.entity.TechnologicaEntityType;
import com.technologica.world.gen.feature.TechnologicaConfiguredFeatures;

import net.minecraft.entity.EntityClassification;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.MobSpawnInfo;
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
			biomeIn.getSpawns().getSpawner(EntityClassification.CREATURE).add(new MobSpawnInfo.Spawners(TechnologicaEntityType.GORILLA.get(), 100, 1, 5));
			biomeIn.getSpawns().getSpawner(EntityClassification.CREATURE).add(new MobSpawnInfo.Spawners(TechnologicaEntityType.SLOTH.get(), 100, 1, 13));
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
	    	biomeIn.getSpawns().getSpawner(EntityClassification.CREATURE).add(new MobSpawnInfo.Spawners(TechnologicaEntityType.BEAVER.get(), 100, 1, 3));
	    	biomeIn.getSpawns().getSpawner(EntityClassification.CREATURE).add(new MobSpawnInfo.Spawners(TechnologicaEntityType.DEER.get(), 100, 1, 5));
	    	biomeIn.getSpawns().getSpawner(EntityClassification.CREATURE).add(new MobSpawnInfo.Spawners(TechnologicaEntityType.GRIZZLY_BEAR.get(), 100, 1, 3));
	    	biomeIn.getSpawns().getSpawner(EntityClassification.CREATURE).add(new MobSpawnInfo.Spawners(TechnologicaEntityType.OWL.get(), 100, 1, 3));
	    	biomeIn.getSpawns().getSpawner(EntityClassification.CREATURE).add(new MobSpawnInfo.Spawners(TechnologicaEntityType.RACCOON.get(), 100, 1, 3));
		}
	    	
		else if (biomeIn.getName().getPath().equals("birch_forest") || biomeIn.getName().getPath().equals("birch_forest_hills")) {
	    	biomeIn.getGeneration().getFeatures(GenerationStage.Decoration.VEGETAL_DECORATION).add(() -> TechnologicaConfiguredFeatures.PEACH_TREE_FEATURE.withPlacement(Features.Placements.HEIGHTMAP_PLACEMENT).withPlacement(Placement.COUNT_EXTRA.configure(new AtSurfaceWithExtraConfig(3, 0.1F, 2))));
	    	biomeIn.getSpawns().getSpawner(EntityClassification.CREATURE).add(new MobSpawnInfo.Spawners(TechnologicaEntityType.DEER.get(), 100, 1, 5));
	    	biomeIn.getSpawns().getSpawner(EntityClassification.CREATURE).add(new MobSpawnInfo.Spawners(TechnologicaEntityType.RACCOON.get(), 100, 1, 3));
	    	biomeIn.getSpawns().getSpawner(EntityClassification.CREATURE).add(new MobSpawnInfo.Spawners(TechnologicaEntityType.TURKEY.get(), 100, 1, 3));
		}
		
		else if (biomeIn.getName().getPath().equals("wooded_hills") || biomeIn.getName().getPath().equals("wooded_mountains")) {
	    	biomeIn.getGeneration().getFeatures(GenerationStage.Decoration.VEGETAL_DECORATION).add(() -> TechnologicaConfiguredFeatures.ASPEN_TREE_FEATURE.withPlacement(Features.Placements.HEIGHTMAP_PLACEMENT).withPlacement(Placement.COUNT_EXTRA.configure(new AtSurfaceWithExtraConfig(3, 0.5F, 2))));
	    	biomeIn.getSpawns().getSpawner(EntityClassification.CREATURE).add(new MobSpawnInfo.Spawners(TechnologicaEntityType.BEAVER.get(), 100, 1, 3));
	    	biomeIn.getSpawns().getSpawner(EntityClassification.CREATURE).add(new MobSpawnInfo.Spawners(TechnologicaEntityType.DEER.get(), 100, 1, 5));
	    	biomeIn.getSpawns().getSpawner(EntityClassification.CREATURE).add(new MobSpawnInfo.Spawners(TechnologicaEntityType.GRIZZLY_BEAR.get(), 100, 1, 3));
	    	biomeIn.getSpawns().getSpawner(EntityClassification.CREATURE).add(new MobSpawnInfo.Spawners(TechnologicaEntityType.OWL.get(), 100, 1, 3));
	    	biomeIn.getSpawns().getSpawner(EntityClassification.CREATURE).add(new MobSpawnInfo.Spawners(TechnologicaEntityType.TURKEY.get(), 100, 1, 3));
		}
	    
		else if (biomeIn.getName().getPath().equals("beach")) {
			biomeIn.getGeneration().getFeatures(GenerationStage.Decoration.VEGETAL_DECORATION).add(() -> TechnologicaConfiguredFeatures.COCONUT_TREE_FEATURE.withPlacement(Features.Placements.HEIGHTMAP_PLACEMENT).withPlacement(Placement.COUNT_EXTRA.configure(new AtSurfaceWithExtraConfig(1, 0.1F, 1))));
			biomeIn.getSpawns().getSpawner(EntityClassification.CREATURE).add(new MobSpawnInfo.Spawners(TechnologicaEntityType.CRAB.get(), 100, 1, 5));
		} 
	    
		else if (biomeIn.getName().getPath().equals("taiga") || biomeIn.getName().getPath().equals("taiga hills")) {
			biomeIn.getGeneration().getFeatures(GenerationStage.Decoration.VEGETAL_DECORATION).add(() -> TechnologicaConfiguredFeatures.APRICOT_TREE_FEATURE.withPlacement(Features.Placements.HEIGHTMAP_PLACEMENT).withPlacement(Placement.COUNT_EXTRA.configure(new AtSurfaceWithExtraConfig(1, 0.2F, 5))));		
			biomeIn.getGeneration().getFeatures(GenerationStage.Decoration.VEGETAL_DECORATION).add(() -> TechnologicaConfiguredFeatures.PEAR_TREE_FEATURE.withPlacement(Features.Placements.HEIGHTMAP_PLACEMENT).withPlacement(Placement.COUNT_EXTRA.configure(new AtSurfaceWithExtraConfig(1, 0.2F, 5))));		
			biomeIn.getSpawns().getSpawner(EntityClassification.CREATURE).add(new MobSpawnInfo.Spawners(TechnologicaEntityType.BEAVER.get(), 100, 1, 3));
			biomeIn.getSpawns().getSpawner(EntityClassification.CREATURE).add(new MobSpawnInfo.Spawners(TechnologicaEntityType.GRIZZLY_BEAR.get(), 100, 1, 3));
			biomeIn.getSpawns().getSpawner(EntityClassification.CREATURE).add(new MobSpawnInfo.Spawners(TechnologicaEntityType.OWL.get(), 100, 1, 3));
		}
		
		else if (biomeIn.getName().getPath().equals("snowy_taiga") || biomeIn.getName().getPath().equals("snowy_taiga hills")) {
			biomeIn.getGeneration().getFeatures(GenerationStage.Decoration.VEGETAL_DECORATION).add(() -> TechnologicaConfiguredFeatures.MAPLE_TREE_FEATURE.withPlacement(Features.Placements.HEIGHTMAP_PLACEMENT).withPlacement(Placement.COUNT_EXTRA.configure(new AtSurfaceWithExtraConfig(1, 0.2F, 5))));
			biomeIn.getGeneration().getFeatures(GenerationStage.Decoration.VEGETAL_DECORATION).add(() -> TechnologicaConfiguredFeatures.WALNUT_TREE_FEATURE.withPlacement(Features.Placements.HEIGHTMAP_PLACEMENT).withPlacement(Placement.COUNT_EXTRA.configure(new AtSurfaceWithExtraConfig(1, 0.2F, 5))));		
			biomeIn.getSpawns().getSpawner(EntityClassification.CREATURE).add(new MobSpawnInfo.Spawners(TechnologicaEntityType.MOOSE.get(), 100, 1, 3));
			biomeIn.getSpawns().getSpawner(EntityClassification.CREATURE).add(new MobSpawnInfo.Spawners(TechnologicaEntityType.OWL.get(), 100, 1, 3));
		}
		
		else if (biomeIn.getName().getPath().equals("swamp") || biomeIn.getName().getPath().equals("swamp hills")) {
			biomeIn.getGeneration().getFeatures(GenerationStage.Decoration.VEGETAL_DECORATION).add(() -> TechnologicaConfiguredFeatures.ORANGE_TREE_FEATURE.withPlacement(Features.Placements.HEIGHTMAP_PLACEMENT).withPlacement(Placement.COUNT_EXTRA.configure(new AtSurfaceWithExtraConfig(3, 0.2F, 2))));		
			biomeIn.getSpawns().getSpawner(EntityClassification.CREATURE).add(new MobSpawnInfo.Spawners(TechnologicaEntityType.ALLIGATOR.get(), 100, 1, 3));
			biomeIn.getSpawns().getSpawner(EntityClassification.CREATURE).add(new MobSpawnInfo.Spawners(TechnologicaEntityType.COTTONMOUTH.get(), 100, 1, 1));
			biomeIn.getSpawns().getSpawner(EntityClassification.CREATURE).add(new MobSpawnInfo.Spawners(TechnologicaEntityType.FLAMINGO.get(), 100, 1, 3));
			biomeIn.getSpawns().getSpawner(EntityClassification.CREATURE).add(new MobSpawnInfo.Spawners(TechnologicaEntityType.FROG.get(), 100, 1, 3));
			biomeIn.getSpawns().getSpawner(EntityClassification.CREATURE).add(new MobSpawnInfo.Spawners(TechnologicaEntityType.STINGRAY.get(), 100, 1, 3));
		} 
	    
		else if (biomeIn.getCategory().equals(Biome.Category.SAVANNA)) {
			biomeIn.getGeneration().getFeatures(GenerationStage.Decoration.VEGETAL_DECORATION).add(() -> TechnologicaConfiguredFeatures.ZEBRAWOOD_TREE_FEATURE.withPlacement(Features.Placements.HEIGHTMAP_PLACEMENT).withPlacement(Placement.COUNT_EXTRA.configure(new AtSurfaceWithExtraConfig(1, 0.1F, 1))));
			biomeIn.getSpawns().getSpawner(EntityClassification.CREATURE).add(new MobSpawnInfo.Spawners(TechnologicaEntityType.ELEPHANT.get(), 100, 1, 3));
			biomeIn.getSpawns().getSpawner(EntityClassification.CREATURE).add(new MobSpawnInfo.Spawners(TechnologicaEntityType.GIRAFFE.get(), 100, 1, 3));
			biomeIn.getSpawns().getSpawner(EntityClassification.CREATURE).add(new MobSpawnInfo.Spawners(TechnologicaEntityType.LION.get(), 100, 1, 3));
			biomeIn.getSpawns().getSpawner(EntityClassification.CREATURE).add(new MobSpawnInfo.Spawners(TechnologicaEntityType.OSTRICH.get(), 100, 1, 3));
			biomeIn.getSpawns().getSpawner(EntityClassification.CREATURE).add(new MobSpawnInfo.Spawners(TechnologicaEntityType.ZEBRA.get(), 100, 1, 3));
		} 
		
		else if (biomeIn.getName().getPath().equals("plains")) {
			biomeIn.getSpawns().getSpawner(EntityClassification.CREATURE).add(new MobSpawnInfo.Spawners(TechnologicaEntityType.BUFFALO.get(), 100, 3, 10));
		} 
		
		else if (biomeIn.getCategory().equals(Biome.Category.MESA)) {
			biomeIn.getSpawns().getSpawner(EntityClassification.CREATURE).add(new MobSpawnInfo.Spawners(TechnologicaEntityType.COYOTE.get(), 100, 3, 10));
			biomeIn.getSpawns().getSpawner(EntityClassification.CREATURE).add(new MobSpawnInfo.Spawners(TechnologicaEntityType.LIZARD.get(), 100, 1, 3));
			biomeIn.getSpawns().getSpawner(EntityClassification.MONSTER).add(new MobSpawnInfo.Spawners(TechnologicaEntityType.SCORPION.get(), 100, 1, 1));
			biomeIn.getSpawns().getSpawner(EntityClassification.AMBIENT).add(new MobSpawnInfo.Spawners(TechnologicaEntityType.VULTURE.get(), 1, 1, 3));
		} 
	    
		else if (biomeIn.getCategory().equals(Biome.Category.RIVER)) {
			biomeIn.getSpawns().getSpawner(EntityClassification.CREATURE).add(new MobSpawnInfo.Spawners(TechnologicaEntityType.BEAVER.get(), 100, 1, 3));
			biomeIn.getSpawns().getSpawner(EntityClassification.CREATURE).add(new MobSpawnInfo.Spawners(TechnologicaEntityType.DUCK.get(), 100, 1, 5));
			biomeIn.getSpawns().getSpawner(EntityClassification.WATER_AMBIENT).add(new MobSpawnInfo.Spawners(TechnologicaEntityType.PIRANHA.get(), 100, 5, 10));
		} 
		
		else if (biomeIn.getName().getPath().equals("ocean") || biomeIn.getName().getPath().equals("deep_ocean")) {
			biomeIn.getSpawns().getSpawner(EntityClassification.CREATURE).add(new MobSpawnInfo.Spawners(TechnologicaEntityType.SHARK.get(), 100, 5, 10));
			biomeIn.getSpawns().getSpawner(EntityClassification.CREATURE).add(new MobSpawnInfo.Spawners(TechnologicaEntityType.OCTOPUS.get(), 100, 5, 10));
		} 
		
		else if (biomeIn.getName().getPath().equals("frozen_ocean") || biomeIn.getName().getPath().equals("deep_frozen_ocean")) {
			biomeIn.getSpawns().getSpawner(EntityClassification.CREATURE).add(new MobSpawnInfo.Spawners(TechnologicaEntityType.KING_CRAB.get(), 100, 5, 10));
			biomeIn.getSpawns().getSpawner(EntityClassification.CREATURE).add(new MobSpawnInfo.Spawners(TechnologicaEntityType.LEOPARD_SEAL.get(), 100, 1, 5));
			biomeIn.getSpawns().getSpawner(EntityClassification.CREATURE).add(new MobSpawnInfo.Spawners(TechnologicaEntityType.NARWHAL.get(), 100, 1, 5));
			biomeIn.getSpawns().getSpawner(EntityClassification.CREATURE).add(new MobSpawnInfo.Spawners(TechnologicaEntityType.PENGUIN.get(), 100, 5, 10));
			biomeIn.getSpawns().getSpawner(EntityClassification.CREATURE).add(new MobSpawnInfo.Spawners(TechnologicaEntityType.WALRUS.get(), 100, 1, 5));
		} 
		
		else if (biomeIn.getName().getPath().equals("ice_spikes")) {
			biomeIn.getSpawns().getSpawner(EntityClassification.CREATURE).add(new MobSpawnInfo.Spawners(TechnologicaEntityType.PENGUIN.get(), 100, 5, 10));
		} 
		
		else if (biomeIn.getCategory().equals(Biome.Category.DESERT)) {
			biomeIn.getGeneration().getFeatures(GenerationStage.Decoration.LAKES).add(() -> TechnologicaConfiguredFeatures.OASIS_FEATURE);
			biomeIn.getSpawns().getSpawner(EntityClassification.CREATURE).add(new MobSpawnInfo.Spawners(TechnologicaEntityType.CAMEL.get(), 100, 1, 5));
			biomeIn.getSpawns().getSpawner(EntityClassification.CREATURE).add(new MobSpawnInfo.Spawners(TechnologicaEntityType.COBRA.get(), 100, 1, 1));
		}
    }	
}
