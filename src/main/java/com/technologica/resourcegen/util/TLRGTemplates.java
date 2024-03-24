package com.technologica.resourcegen.util;

import java.util.OptionalLong;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.util.valueproviders.IntProvider;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.dimension.DimensionType;

public class TLRGTemplates {

	// public static LevelStem TLRGLevelStem() {
	// return new LevelStem(bootstrapContext.lookup(Registries.DIMENSION_TYPE).getOrThrow();
	// }

	public static DimensionType TLRGDimensionType(float ambientLight, boolean bedWorks, double coordinateScale, ResourceLocation effects, OptionalLong fixedTime, boolean hasCeiling, boolean hasRaids, boolean hasSkylight, int height, TagKey<Block> infiniburn, int logicalHeight, int minY, int monsterSpawnBlockLightLimit, IntProvider monsterSpawnLightLevel, boolean natural, boolean piglinSafe, boolean respawnAnchorWorks, boolean ultraWarm) {
		return new DimensionType(fixedTime, hasSkylight, hasCeiling, ultraWarm, natural, coordinateScale, bedWorks, respawnAnchorWorks, minY, height, logicalHeight, infiniburn, effects, ambientLight, new DimensionType.MonsterSettings(piglinSafe, hasRaids, monsterSpawnLightLevel, monsterSpawnBlockLightLimit));
	}

	/**
	 * Template for monster_spawn_light_level nested json element.
	 * 
	 * @param type:
	 * @param maxInclusive:
	 * @param minInclusive:
	 */
	public static IntProvider TLRGMonsterSpawnLightLevel(Class<UniformInt> type, int maxInclusive, int minInclusive) {
		return UniformInt.of(minInclusive, maxInclusive);
	}

}
