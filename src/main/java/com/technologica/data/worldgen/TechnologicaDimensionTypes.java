package com.technologica.data.worldgen;

import java.util.OptionalLong;

import com.technologica.Technologica;

import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.TagKey;
import net.minecraft.util.valueproviders.IntProvider;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.dimension.BuiltinDimensionTypes;
import net.minecraft.world.level.dimension.DimensionType;

public class TechnologicaDimensionTypes {
	public static final ResourceKey<DimensionType> MOON = ResourceKey.create(Registries.DIMENSION_TYPE, new ResourceLocation(Technologica.MODID, "moon"));
	public static final ResourceKey<DimensionType> CHALLENGER_DEEP = ResourceKey.create(Registries.DIMENSION_TYPE, new ResourceLocation(Technologica.MODID, "challenger_deep"));
	public static final ResourceKey<DimensionType> OVERGROWTH = ResourceKey.create(Registries.DIMENSION_TYPE, new ResourceLocation(Technologica.MODID, "overgrowth"));

	public static final ResourceLocation MOON_EFFECTS = new ResourceLocation(Technologica.MODID, "moon");
	public static final ResourceLocation CHALLENGER_DEEP_EFFECTS = new ResourceLocation(Technologica.MODID, "challenger_deep");
	public static final ResourceLocation OVERGROWTH_EFFECTS = new ResourceLocation(Technologica.MODID, "overgrowth");

	public static void bootstrap(BootstapContext<DimensionType> bootstrapContextIn) {
		bootstrapContextIn.register(MOON, moon());
		bootstrapContextIn.register(CHALLENGER_DEEP, challengerDeep());
		bootstrapContextIn.register(OVERGROWTH, overgrowth());
	}

	private static DimensionType moon() {
		float ambientLight = 0.0F;
		boolean bedWorks = true;
		double coordinateScale = 1.0D;
		ResourceLocation effects = MOON_EFFECTS;
		boolean hasCeiling = false;
		boolean hasRaids = false;
		boolean hasSkylight = true;
		int height = 384;
		TagKey<Block> infiniburn = BlockTags.INFINIBURN_OVERWORLD;
		int logicalHeight = 384;
		int minY = -64;
		int monsterSpawnBlockLightLimit = 0;
		IntProvider monsterSpawnLightLevel = UniformInt.of(0, 7);
		boolean natural = true;
		boolean piglinSafe = false;
		boolean respawnAnchorWorks = false;
		boolean ultraWarm = false;

		return new DimensionType(OptionalLong.empty(), hasSkylight, hasCeiling, ultraWarm, natural, coordinateScale, bedWorks, respawnAnchorWorks, minY, height, logicalHeight, infiniburn, effects, ambientLight, new DimensionType.MonsterSettings(piglinSafe, hasRaids, monsterSpawnLightLevel, monsterSpawnBlockLightLimit));
	}

	private static DimensionType challengerDeep() {
		float ambientLight = 0.0F;
		boolean bedWorks = true;
		double coordinateScale = 1.0D;
		ResourceLocation effects = MOON_EFFECTS;
		boolean hasCeiling = true;
		boolean hasRaids = false;
		boolean hasSkylight = false;
		int height = 384;
		TagKey<Block> infiniburn = BlockTags.INFINIBURN_OVERWORLD;
		int logicalHeight = 384;
		int minY = -64;
		int monsterSpawnBlockLightLimit = 0;
		IntProvider monsterSpawnLightLevel = UniformInt.of(0, 7);
		boolean natural = true;
		boolean piglinSafe = false;
		boolean respawnAnchorWorks = false;
		boolean ultraWarm = false;

		return new DimensionType(OptionalLong.empty(), hasSkylight, hasCeiling, ultraWarm, natural, coordinateScale, bedWorks, respawnAnchorWorks, minY, height, logicalHeight, infiniburn, effects, ambientLight, new DimensionType.MonsterSettings(piglinSafe, hasRaids, monsterSpawnLightLevel, monsterSpawnBlockLightLimit));
	}

	private static DimensionType overgrowth() {
		float ambientLight = 0.1F;
		boolean bedWorks = true;
		double coordinateScale = 1.0D;
		ResourceLocation effects = BuiltinDimensionTypes.NETHER_EFFECTS;
		boolean hasCeiling = true;
		boolean hasRaids = false;
		boolean hasSkylight = true;
		int height = 384;
		TagKey<Block> infiniburn = BlockTags.INFINIBURN_OVERWORLD;
		int logicalHeight = 384;
		int minY = -64;
		int monsterSpawnBlockLightLimit = 0;
		IntProvider monsterSpawnLightLevel = UniformInt.of(0, 7);
		boolean natural = true;
		boolean piglinSafe = false;
		boolean respawnAnchorWorks = false;
		boolean ultraWarm = false;

		return new DimensionType(OptionalLong.of(18000L), hasSkylight, hasCeiling, ultraWarm, natural, coordinateScale, bedWorks, respawnAnchorWorks, minY, height, logicalHeight, infiniburn, effects, ambientLight, new DimensionType.MonsterSettings(piglinSafe, hasRaids, monsterSpawnLightLevel, monsterSpawnBlockLightLimit));
	}
}
