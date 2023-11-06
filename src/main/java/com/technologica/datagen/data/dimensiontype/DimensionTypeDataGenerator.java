package com.technologica.datagen.data.dimensiontype;

import java.util.OptionalLong;

import com.technologica.world.level.dimension.TechnologicaBuiltinDimensionTypes;

import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.TagKey;
import net.minecraft.util.valueproviders.IntProvider;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.dimension.BuiltinDimensionTypes;
import net.minecraft.world.level.dimension.DimensionType;

public class DimensionTypeDataGenerator {
	public static void bootstrap(BootstapContext<DimensionType> bootstrapContextIn) {
		bootstrapContextIn.register(TechnologicaBuiltinDimensionTypes.MOON, moon());
		bootstrapContextIn.register(TechnologicaBuiltinDimensionTypes.CHALLENGER_DEEP, challengerDeep());
		bootstrapContextIn.register(TechnologicaBuiltinDimensionTypes.OVERGROWTH, overgrowth());
	}

	private static DimensionType moon() {
		return dimensionType(0.0F, true, 1.0D, TechnologicaBuiltinDimensionTypes.MOON_EFFECTS, OptionalLong.empty(), false, false, true, 384, BlockTags.INFINIBURN_OVERWORLD, 384, -64, 0, monsterSpawnLightLevel("uniform", 7, 0), true, false, false, false);
	}

	private static DimensionType challengerDeep() {
		return dimensionType(0.0F, true, 1.0D, TechnologicaBuiltinDimensionTypes.MOON_EFFECTS, OptionalLong.empty(), true, false, false, 384, BlockTags.INFINIBURN_OVERWORLD, 384, -64, 0, monsterSpawnLightLevel("uniform", 7, 0), true, false, false, false);
	}

	private static DimensionType overgrowth() {
		return dimensionType(0.1F, true, 1.0D, BuiltinDimensionTypes.NETHER_EFFECTS, OptionalLong.of(18000L), true, false, true, 384, BlockTags.INFINIBURN_OVERWORLD, 384, -64, 0, monsterSpawnLightLevel("uniform", 7, 0), true, false, false, false);
	}

	private static DimensionType dimensionType(float ambientLight, boolean bedWorks, double coordinateScale, ResourceLocation effects, OptionalLong fixedTime, boolean hasCeiling, boolean hasRaids, boolean hasSkylight, int height, TagKey<Block> infiniburn, int logicalHeight, int minY, int monsterSpawnBlockLightLimit, IntProvider monsterSpawnLightLevel, boolean natural, boolean piglinSafe, boolean respawnAnchorWorks, boolean ultraWarm) {
		return new DimensionType(fixedTime, hasSkylight, hasCeiling, ultraWarm, natural, coordinateScale, bedWorks, respawnAnchorWorks, minY, height, logicalHeight, infiniburn, effects, ambientLight, new DimensionType.MonsterSettings(piglinSafe, hasRaids, monsterSpawnLightLevel, monsterSpawnBlockLightLimit));
	}

	private static IntProvider monsterSpawnLightLevel(String type, int maxInclusive, int minInclusive) {
		return UniformInt.of(minInclusive, maxInclusive);
	}
}