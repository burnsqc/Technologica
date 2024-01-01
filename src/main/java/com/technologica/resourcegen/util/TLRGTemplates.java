package com.technologica.resourcegen.util;

import java.util.OptionalLong;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.util.valueproviders.IntProvider;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.level.block.Block;

public class TLRGTemplates {

	public record TLRGDimensionType(float ambientLight, boolean bedWorks, double coordinateScale, ResourceLocation effects, OptionalLong fixedTime, boolean hasCeiling, boolean hasRaids, boolean hasSkylight, int height, TagKey<Block> infiniburn, int logicalHeight, int minY, int monsterSpawnBlockLightLimit, IntProvider monsterSpawnLightLevel, boolean natural, boolean piglinSafe, boolean respawnAnchorWorks, boolean ultraWarm) {
	}
	
	/**
	 * Template for monster_spawn_light_level nested json element.
	 * @param type:
	 * @param maxInclusive:
	 * @param minInclusive:
	 */
	public static IntProvider TLRGMonsterSpawnLightLevel(Class<UniformInt> type, int maxInclusive, int minInclusive) {
		return UniformInt.of(minInclusive, maxInclusive);
	}
	
	
}
