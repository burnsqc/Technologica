package com.technologica.setup;

import com.technologica.data.worldgen.features.TechnologicaTreeFeatures;
import com.technologica.data.worldgen.placement.TechnologicaVegetationPlacements;
import com.technologica.world.entity.TechnologicaEntityType;

import net.minecraft.data.worldgen.placement.VegetationPlacements;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.MobSpawnSettings;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.levelgen.placement.RarityFilter;
import net.minecraftforge.event.world.BiomeLoadingEvent;

public class VanillaBiomeModifier {

	public static void init(final BiomeLoadingEvent biomeIn) {
		if (biomeIn.getName().getPath().equals("jungle") || biomeIn.getName().getPath().equals("jungle_hills") || biomeIn.getName().getPath().equals("modified_jungle")) {
			biomeIn.getGeneration().getFeatures(GenerationStep.Decoration.VEGETAL_DECORATION).add(() -> TechnologicaTreeFeatures.EBONY.placed(VegetationPlacements.treePlacement(RarityFilter.onAverageOnceEvery(2))));
			biomeIn.getGeneration().getFeatures(GenerationStep.Decoration.VEGETAL_DECORATION).add(() -> TechnologicaTreeFeatures.KIWI.placed(VegetationPlacements.treePlacement(RarityFilter.onAverageOnceEvery(2))));
			biomeIn.getGeneration().getFeatures(GenerationStep.Decoration.VEGETAL_DECORATION).add(() -> TechnologicaTreeFeatures.RUBBER.placed(VegetationPlacements.treePlacement(RarityFilter.onAverageOnceEvery(2))));
			//biomeIn.getSpawns().getSpawner(MobCategory.CREATURE).add(new MobSpawnSettings.SpawnerData(TechnologicaEntityType.GORILLA.get(), 100, 1, 5));
			//biomeIn.getSpawns().getSpawner(MobCategory.CREATURE).add(new MobSpawnSettings.SpawnerData(TechnologicaEntityType.SLOTH.get(), 100, 1, 13));
		} 
		
		else if (biomeIn.getName().getPath().equals("jungle_edge") || biomeIn.getName().getPath().equals("modified_jungle_edge")) {
			biomeIn.getGeneration().getFeatures(GenerationStep.Decoration.VEGETAL_DECORATION).add(() -> TechnologicaTreeFeatures.TEAK.placed(VegetationPlacements.treePlacement(RarityFilter.onAverageOnceEvery(2))));
	    }
		
		else if (biomeIn.getName().getPath().equals("bamboo_jungle") || biomeIn.getName().getPath().equals("bamboo_jungle_hills")) {
			biomeIn.getGeneration().getFeatures(GenerationStep.Decoration.VEGETAL_DECORATION).add(() -> TechnologicaTreeFeatures.CHERRY.placed(VegetationPlacements.treePlacement(RarityFilter.onAverageOnceEvery(2))));
			biomeIn.getGeneration().getFeatures(GenerationStep.Decoration.VEGETAL_DECORATION).add(() -> TechnologicaTreeFeatures.PLUM.placed(VegetationPlacements.treePlacement(RarityFilter.onAverageOnceEvery(2))));
	    }
		
		else if (biomeIn.getName().getPath().equals("forest")) {
	    	//biomeIn.getGeneration().getFeatures(GenerationStep.Decoration.VEGETAL_DECORATION).add(() -> TechnologicaTreeFeatures.CHESTNUT.placed(VegetationPlacements.treePlacement(RarityFilter.onAverageOnceEvery(100))));
	    	biomeIn.getSpawns().getSpawner(MobCategory.CREATURE).add(new MobSpawnSettings.SpawnerData(TechnologicaEntityType.BEAVER.get(), 100, 1, 3));
	    	//biomeIn.getSpawns().getSpawner(MobCategory.CREATURE).add(new MobSpawnSettings.SpawnerData(TechnologicaEntityType.DEER.get(), 100, 1, 5));
	    	//biomeIn.getSpawns().getSpawner(MobCategory.CREATURE).add(new MobSpawnSettings.SpawnerData(TechnologicaEntityType.GRIZZLY_BEAR.get(), 100, 1, 3));
	    	//biomeIn.getSpawns().getSpawner(MobCategory.CREATURE).add(new MobSpawnSettings.SpawnerData(TechnologicaEntityType.OWL.get(), 100, 1, 3));
	    	//biomeIn.getSpawns().getSpawner(MobCategory.CREATURE).add(new MobSpawnSettings.SpawnerData(TechnologicaEntityType.RACCOON.get(), 100, 1, 3));
		}
	    	
		else if (biomeIn.getName().getPath().equals("birch_forest") || biomeIn.getName().getPath().equals("birch_forest_hills")) {
	    	biomeIn.getGeneration().getFeatures(GenerationStep.Decoration.VEGETAL_DECORATION).add(() -> TechnologicaTreeFeatures.PEACH.placed(VegetationPlacements.treePlacement(RarityFilter.onAverageOnceEvery(2))));
	    	//biomeIn.getSpawns().getSpawner(MobCategory.CREATURE).add(new MobSpawnSettings.SpawnerData(TechnologicaEntityType.DEER.get(), 100, 1, 5));
	    	//biomeIn.getSpawns().getSpawner(MobCategory.CREATURE).add(new MobSpawnSettings.SpawnerData(TechnologicaEntityType.RACCOON.get(), 100, 1, 3));
	    	//biomeIn.getSpawns().getSpawner(MobCategory.CREATURE).add(new MobSpawnSettings.SpawnerData(TechnologicaEntityType.TURKEY.get(), 100, 1, 3));
		}
		
		else if (biomeIn.getName().getPath().equals("wooded_hills") || biomeIn.getName().getPath().equals("wooded_mountains")) {
	    	biomeIn.getGeneration().getFeatures(GenerationStep.Decoration.VEGETAL_DECORATION).add(() -> TechnologicaTreeFeatures.ASPEN.placed(VegetationPlacements.treePlacement(RarityFilter.onAverageOnceEvery(2))));
	    	biomeIn.getSpawns().getSpawner(MobCategory.CREATURE).add(new MobSpawnSettings.SpawnerData(TechnologicaEntityType.BEAVER.get(), 100, 1, 3));
	    	//biomeIn.getSpawns().getSpawner(MobCategory.CREATURE).add(new MobSpawnSettings.SpawnerData(TechnologicaEntityType.DEER.get(), 100, 1, 5));
	    	//biomeIn.getSpawns().getSpawner(MobCategory.CREATURE).add(new MobSpawnSettings.SpawnerData(TechnologicaEntityType.GRIZZLY_BEAR.get(), 100, 1, 3));
	    	//biomeIn.getSpawns().getSpawner(MobCategory.CREATURE).add(new MobSpawnSettings.SpawnerData(TechnologicaEntityType.OWL.get(), 100, 1, 3));
	    	//biomeIn.getSpawns().getSpawner(MobCategory.CREATURE).add(new MobSpawnSettings.SpawnerData(TechnologicaEntityType.TURKEY.get(), 100, 1, 3));
		}
	    
		else if (biomeIn.getName().getPath().equals("beach")) {
			biomeIn.getGeneration().getFeatures(GenerationStep.Decoration.VEGETAL_DECORATION).add(() -> TechnologicaTreeFeatures.COCONUT.placed(VegetationPlacements.treePlacement(RarityFilter.onAverageOnceEvery(2))));
			//biomeIn.getSpawns().getSpawner(MobCategory.CREATURE).add(new MobSpawnSettings.SpawnerData(TechnologicaEntityType.CRAB.get(), 100, 1, 5));
		} 
	    
		else if (biomeIn.getName().getPath().equals("taiga") || biomeIn.getName().getPath().equals("taiga hills")) {
			biomeIn.getGeneration().getFeatures(GenerationStep.Decoration.VEGETAL_DECORATION).add(() -> TechnologicaTreeFeatures.APRICOT.placed(VegetationPlacements.treePlacement(RarityFilter.onAverageOnceEvery(2))));		
			biomeIn.getGeneration().getFeatures(GenerationStep.Decoration.VEGETAL_DECORATION).add(() -> TechnologicaTreeFeatures.PEAR.placed(VegetationPlacements.treePlacement(RarityFilter.onAverageOnceEvery(2))));		
			biomeIn.getSpawns().getSpawner(MobCategory.CREATURE).add(new MobSpawnSettings.SpawnerData(TechnologicaEntityType.BEAVER.get(), 100, 1, 3));
			//biomeIn.getSpawns().getSpawner(MobCategory.CREATURE).add(new MobSpawnSettings.SpawnerData(TechnologicaEntityType.GRIZZLY_BEAR.get(), 100, 1, 3));
			//biomeIn.getSpawns().getSpawner(MobCategory.CREATURE).add(new MobSpawnSettings.SpawnerData(TechnologicaEntityType.OWL.get(), 100, 1, 3));
		}
		
		else if (biomeIn.getName().getPath().equals("snowy_taiga") || biomeIn.getName().getPath().equals("snowy_taiga hills")) {
			biomeIn.getGeneration().getFeatures(GenerationStep.Decoration.VEGETAL_DECORATION).add(() -> TechnologicaTreeFeatures.MAPLE.placed(VegetationPlacements.treePlacement(RarityFilter.onAverageOnceEvery(2))));
			biomeIn.getGeneration().getFeatures(GenerationStep.Decoration.VEGETAL_DECORATION).add(() -> TechnologicaTreeFeatures.WALNUT.placed(VegetationPlacements.treePlacement(RarityFilter.onAverageOnceEvery(2))));		
			//biomeIn.getSpawns().getSpawner(MobCategory.CREATURE).add(new MobSpawnSettings.SpawnerData(TechnologicaEntityType.MOOSE.get(), 100, 1, 3));
			//biomeIn.getSpawns().getSpawner(MobCategory.CREATURE).add(new MobSpawnSettings.SpawnerData(TechnologicaEntityType.OWL.get(), 100, 1, 3));
		}
		
		else if (biomeIn.getName().getPath().equals("swamp") || biomeIn.getName().getPath().equals("swamp hills")) {
			biomeIn.getGeneration().getFeatures(GenerationStep.Decoration.VEGETAL_DECORATION).add(() -> TechnologicaTreeFeatures.ORANGE.placed(VegetationPlacements.treePlacement(RarityFilter.onAverageOnceEvery(2))));		
			//biomeIn.getSpawns().getSpawner(MobCategory.CREATURE).add(new MobSpawnSettings.SpawnerData(TechnologicaEntityType.ALLIGATOR.get(), 100, 1, 3));
			//biomeIn.getSpawns().getSpawner(MobCategory.CREATURE).add(new MobSpawnSettings.SpawnerData(TechnologicaEntityType.COTTONMOUTH.get(), 100, 1, 1));
			//biomeIn.getSpawns().getSpawner(MobCategory.CREATURE).add(new MobSpawnSettings.SpawnerData(TechnologicaEntityType.FLAMINGO.get(), 100, 1, 3));
			//biomeIn.getSpawns().getSpawner(MobCategory.CREATURE).add(new MobSpawnSettings.SpawnerData(TechnologicaEntityType.FROG.get(), 100, 1, 3));
			//biomeIn.getSpawns().getSpawner(MobCategory.CREATURE).add(new MobSpawnSettings.SpawnerData(TechnologicaEntityType.STINGRAY.get(), 100, 1, 3));
		} 
	    
		else if (biomeIn.getCategory().equals(Biome.BiomeCategory.SAVANNA)) {
			biomeIn.getGeneration().getFeatures(GenerationStep.Decoration.VEGETAL_DECORATION).add(() -> TechnologicaVegetationPlacements.TREES_MODIFIED_SAVANNA);
			//biomeIn.getSpawns().getSpawner(MobCategory.CREATURE).add(new MobSpawnSettings.SpawnerData(TechnologicaEntityType.ELEPHANT.get(), 100, 1, 3));
			//biomeIn.getSpawns().getSpawner(MobCategory.CREATURE).add(new MobSpawnSettings.SpawnerData(TechnologicaEntityType.GIRAFFE.get(), 100, 1, 3));
			//biomeIn.getSpawns().getSpawner(MobCategory.CREATURE).add(new MobSpawnSettings.SpawnerData(TechnologicaEntityType.LION.get(), 100, 1, 3));
			//biomeIn.getSpawns().getSpawner(MobCategory.CREATURE).add(new MobSpawnSettings.SpawnerData(TechnologicaEntityType.OSTRICH.get(), 100, 1, 3));
			//biomeIn.getSpawns().getSpawner(MobCategory.CREATURE).add(new MobSpawnSettings.SpawnerData(TechnologicaEntityType.ZEBRA.get(), 100, 1, 3));
		} 
		
		else if (biomeIn.getName().getPath().equals("plains")) {
			//biomeIn.getSpawns().getSpawner(MobCategory.CREATURE).add(new MobSpawnSettings.SpawnerData(TechnologicaEntityType.BUFFALO.get(), 100, 3, 10));
		} 
		
		else if (biomeIn.getCategory().equals(Biome.BiomeCategory.MESA)) {
			//biomeIn.getSpawns().getSpawner(MobCategory.CREATURE).add(new MobSpawnSettings.SpawnerData(TechnologicaEntityType.COYOTE.get(), 100, 3, 10));
			//biomeIn.getSpawns().getSpawner(MobCategory.CREATURE).add(new MobSpawnSettings.SpawnerData(TechnologicaEntityType.LIZARD.get(), 100, 1, 3));
			//biomeIn.getSpawns().getSpawner(MobCategory.MONSTER).add(new MobSpawnSettings.SpawnerData(TechnologicaEntityType.SCORPION.get(), 100, 1, 1));
			//biomeIn.getSpawns().getSpawner(MobCategory.AMBIENT).add(new MobSpawnSettings.SpawnerData(TechnologicaEntityType.VULTURE.get(), 1, 1, 3));
		} 
	    
		else if (biomeIn.getCategory().equals(Biome.BiomeCategory.RIVER)) {
			biomeIn.getSpawns().getSpawner(MobCategory.CREATURE).add(new MobSpawnSettings.SpawnerData(TechnologicaEntityType.BEAVER.get(), 100, 1, 3));
			//biomeIn.getSpawns().getSpawner(MobCategory.CREATURE).add(new MobSpawnSettings.SpawnerData(TechnologicaEntityType.DUCK.get(), 100, 1, 5));
			//biomeIn.getSpawns().getSpawner(MobCategory.WATER_AMBIENT).add(new MobSpawnSettings.SpawnerData(TechnologicaEntityType.PIRANHA.get(), 100, 5, 10));
		} 
		
		else if (biomeIn.getName().getPath().equals("ocean") || biomeIn.getName().getPath().equals("deep_ocean")) {
			//biomeIn.getSpawns().getSpawner(MobCategory.CREATURE).add(new MobSpawnSettings.SpawnerData(TechnologicaEntityType.SHARK.get(), 100, 5, 10));
			//biomeIn.getSpawns().getSpawner(MobCategory.CREATURE).add(new MobSpawnSettings.SpawnerData(TechnologicaEntityType.OCTOPUS.get(), 100, 5, 10));
		} 
		
		else if (biomeIn.getName().getPath().equals("frozen_ocean") || biomeIn.getName().getPath().equals("deep_frozen_ocean")) {
			//biomeIn.getSpawns().getSpawner(MobCategory.CREATURE).add(new MobSpawnSettings.SpawnerData(TechnologicaEntityType.KING_CRAB.get(), 100, 5, 10));
			//biomeIn.getSpawns().getSpawner(MobCategory.CREATURE).add(new MobSpawnSettings.SpawnerData(TechnologicaEntityType.LEOPARD_SEAL.get(), 100, 1, 5));
			//biomeIn.getSpawns().getSpawner(MobCategory.CREATURE).add(new MobSpawnSettings.SpawnerData(TechnologicaEntityType.NARWHAL.get(), 100, 1, 5));
			//biomeIn.getSpawns().getSpawner(MobCategory.CREATURE).add(new MobSpawnSettings.SpawnerData(TechnologicaEntityType.PENGUIN.get(), 100, 5, 10));
			//biomeIn.getSpawns().getSpawner(MobCategory.CREATURE).add(new MobSpawnSettings.SpawnerData(TechnologicaEntityType.WALRUS.get(), 100, 1, 5));
		} 
		
		else if (biomeIn.getName().getPath().equals("ice_spikes")) {
			//biomeIn.getSpawns().getSpawner(MobCategory.CREATURE).add(new MobSpawnSettings.SpawnerData(TechnologicaEntityType.PENGUIN.get(), 100, 5, 10));
		} 
		
		else if (biomeIn.getCategory().equals(Biome.BiomeCategory.DESERT)) {
			//biomeIn.getGeneration().getFeatures(GenerationStep.Decoration.LAKES).add(() -> TechnologicaConfiguredFeatures.OASIS_FEATURE.placed(RarityFilter.onAverageOnceEvery(200)));
			//biomeIn.getSpawns().getSpawner(MobCategory.CREATURE).add(new MobSpawnSettings.SpawnerData(TechnologicaEntityType.CAMEL.get(), 100, 1, 5));
			//biomeIn.getSpawns().getSpawner(MobCategory.CREATURE).add(new MobSpawnSettings.SpawnerData(TechnologicaEntityType.COBRA.get(), 100, 1, 1));
		}
    }	
}
