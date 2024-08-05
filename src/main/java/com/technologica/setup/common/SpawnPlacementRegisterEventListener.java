package com.technologica.setup.common;

import com.technologica.registration.deferred.TechnologicaEntityTypes;
import com.technologica.registration.key.TechnologicaBiomeTags;
import com.technologica.world.entity.animal.FigureEightPufferfish;

import net.minecraft.core.BlockPos;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.SpawnPlacements;
import net.minecraft.world.entity.animal.Pufferfish;
import net.minecraft.world.entity.animal.Squid;
import net.minecraft.world.entity.animal.Turtle;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraftforge.event.entity.SpawnPlacementRegisterEvent;
import net.minecraftforge.event.entity.SpawnPlacementRegisterEvent.Operation;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;

@Mod.EventBusSubscriber(bus = EventBusSubscriber.Bus.MOD)
public final class SpawnPlacementRegisterEventListener {

	@SubscribeEvent
	public static void onEntityAttributeCreationEvent(final SpawnPlacementRegisterEvent event) {
		event.register(EntityType.PUFFERFISH, SpawnPlacementRegisterEventListener::checkPufferfishSpawnRules);
		event.register(TechnologicaEntityTypes.FIGURE_EIGHT_PUFFERFISH.get(), SpawnPlacements.Type.IN_WATER, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, FigureEightPufferfish::checkFigureEightPufferfishSpawnRules, Operation.REPLACE);
		event.register(EntityType.SQUID, SpawnPlacementRegisterEventListener::checkSquidSpawnRules);
		event.register(EntityType.TURTLE, SpawnPlacements.Type.NO_RESTRICTIONS, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, SpawnPlacementRegisterEventListener::checkTurtleSpawnRules, Operation.REPLACE);
	}

	public static boolean checkPufferfishSpawnRules(EntityType<Pufferfish> pufferfish, LevelAccessor levelAccessor, MobSpawnType mobSpawnType, BlockPos blockPos, RandomSource randomSource) {
		return levelAccessor.getBiome(blockPos).is(TechnologicaBiomeTags.ALLOWS_PUFFERFISH_SPAWNS_AT_ANY_HEIGHT);
	}

	public static boolean checkFigureEightPufferfishSpawnRules(EntityType<FigureEightPufferfish> figureEightPufferfish, LevelAccessor levelAccessor, MobSpawnType mobSpawnType, BlockPos blockPos, RandomSource randomSource) {
		return levelAccessor.getBiome(blockPos).is(TechnologicaBiomeTags.ALLOWS_PUFFERFISH_SPAWNS_AT_ANY_HEIGHT);
	}

	public static boolean checkSquidSpawnRules(EntityType<Squid> squid, LevelAccessor levelAccessor, MobSpawnType mobSpawnType, BlockPos blockPos, RandomSource randomSource) {
		return levelAccessor.getBiome(blockPos).is(TechnologicaBiomeTags.ALLOWS_SQUID_SPAWNS_AT_ANY_HEIGHT);
	}

	public static boolean checkTurtleSpawnRules(EntityType<Turtle> turtle, LevelAccessor levelAccessor, MobSpawnType mobSpawnType, BlockPos blockPos, RandomSource randomSource) {
		return levelAccessor.getBiome(blockPos).is(TechnologicaBiomeTags.ALLOWS_TURTLE_SPAWNS_AT_ANY_HEIGHT);
	}
}
