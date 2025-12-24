package com.technologica.world.entity;

import java.util.HashMap;

import com.technologica.registration.deferred.TechnologicaEntityTypes;
import com.technologica.registration.dynamic.TechnologicaDimensions;
import com.tlregen.api.setup.util.TLReGenSpawnPlacements;

import net.minecraft.core.BlockPos;
import net.minecraft.tags.FluidTags;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.SpawnPlacements;
import net.minecraft.world.entity.SpawnPlacements.SpawnPredicate;
import net.minecraft.world.entity.animal.Turtle;
import net.minecraft.world.entity.animal.WaterAnimal;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.TurtleEggBlock;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraftforge.event.entity.SpawnPlacementRegisterEvent.Operation;

public class TechnologicaSpawnPlacements extends TLReGenSpawnPlacements {
	public static final HashMap<EntityType<?>, TLReGenSpawnPlacements.Data> SPAWN_PLACEMENTS = new HashMap<EntityType<?>, TLReGenSpawnPlacements.Data>();

	static {
		register(TechnologicaEntityTypes.FIGURE_EIGHT_PUFFERFISH.get(), SpawnPlacements.Type.IN_WATER, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, TechnologicaSpawnPlacements::checkSurfaceWaterAnimalSpawnRules, Operation.REPLACE);
		register(EntityType.DOLPHIN, null, null, TechnologicaSpawnPlacements::checkSurfaceWaterAnimalSpawnRules, Operation.OR);
		register(EntityType.TURTLE, SpawnPlacements.Type.IN_WATER, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, TechnologicaSpawnPlacements::checkTurtleSpawnRules, Operation.REPLACE);
	}

	public static <T extends Mob> void register(EntityType<T> entity, SpawnPlacements.Type placement, Heightmap.Types heightMap, SpawnPredicate<T> predicate, Operation operation) {
		SPAWN_PLACEMENTS.put(entity, new TLReGenSpawnPlacements.Data(placement, heightMap, predicate, operation));
	}

	public static boolean checkSurfaceWaterAnimalSpawnRules(EntityType<? extends WaterAnimal> entity, LevelAccessor levelAccessor, MobSpawnType mobSpawnType, BlockPos blockPos, RandomSource randomSource) {
		ServerLevelAccessor serverLevelAccessor = (ServerLevelAccessor) levelAccessor;
		int i = serverLevelAccessor.getLevel().getChunkSource().getGenerator().getSeaLevel();
		int j = i - 64;
		return blockPos.getY() >= j && blockPos.getY() <= i && levelAccessor.getFluidState(blockPos.below()).is(FluidTags.WATER) && levelAccessor.getBlockState(blockPos.above()).is(Blocks.WATER);
	}

	public static boolean checkTurtleSpawnRules(EntityType<Turtle> entity, LevelAccessor levelAccessor, MobSpawnType mobSpawnType, BlockPos blockPos, RandomSource randomSource) {
		ServerLevelAccessor serverLevelAccessor = (ServerLevelAccessor) levelAccessor;
		if (serverLevelAccessor.getLevel().dimension().equals(TechnologicaDimensions.ABYSS_STEM)) {
			int i = serverLevelAccessor.getLevel().getChunkSource().getGenerator().getSeaLevel();
			int j = i - 64;
			return blockPos.getY() >= j && blockPos.getY() <= i && levelAccessor.getFluidState(blockPos.below()).is(FluidTags.WATER) && levelAccessor.getBlockState(blockPos.above()).is(Blocks.WATER);
		} else {
			return blockPos.getY() < levelAccessor.getSeaLevel() + 4 && TurtleEggBlock.onSand(levelAccessor, blockPos) && levelAccessor.getRawBrightness(blockPos, 0) > 8;
		}
	}
}
