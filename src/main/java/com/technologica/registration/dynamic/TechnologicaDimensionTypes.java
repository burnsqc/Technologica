package com.technologica.registration.dynamic;

import java.util.OptionalLong;

import com.technologica.Technologica;
import com.technologica.util.text.TechnologicaLocation;

import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.TagKey;
import net.minecraft.util.valueproviders.IntProvider;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.dimension.BuiltinDimensionTypes;
import net.minecraft.world.level.dimension.DimensionType;

public final class TechnologicaDimensionTypes {
	public static final ResourceKey<DimensionType> MOON = Technologica.DIMENSION_TYPES.register("moon", () -> dimensionType(0.0F, true, 1.0D, TechnologicaDimensionTypes.MOON_EFFECTS, OptionalLong.empty(), false, false, true, 384, BlockTags.INFINIBURN_OVERWORLD, 384, -64, 0, UniformInt.of(0, 7), true, false, false, false));
	public static final ResourceKey<DimensionType> ABYSS = Technologica.DIMENSION_TYPES.register("abyss", () -> dimensionType(0.0F, true, 1.0D, TechnologicaDimensionTypes.ABYSS_EFFECTS, OptionalLong.empty(), true, false, false, 256, BlockTags.INFINIBURN_OVERWORLD, 256, 0, 0, UniformInt.of(0, 7), true, false, false, false));
	public static final ResourceKey<DimensionType> OVERGROWTH = Technologica.DIMENSION_TYPES.register("overgrowth", () -> dimensionType(0.1F, true, 1.0D, BuiltinDimensionTypes.NETHER_EFFECTS, OptionalLong.of(18000L), true, false, true, 384, BlockTags.INFINIBURN_OVERWORLD, 384, -64, 0, UniformInt.of(0, 7), true, false, false, false));

	// TODO: Never really liked that ResourceLocations for effects are here. Determine where to move them.
	public static final ResourceLocation MOON_EFFECTS = new TechnologicaLocation("moon");
	public static final ResourceLocation ABYSS_EFFECTS = new TechnologicaLocation("abyss");
	public static final ResourceLocation OVERGROWTH_EFFECTS = new TechnologicaLocation("overgrowth");

	protected static DimensionType dimensionType(float ambientLight, boolean bedWorks, double coordinateScale, ResourceLocation effects, OptionalLong fixedTime, boolean hasCeiling, boolean hasRaids, boolean hasSkylight, int height, TagKey<Block> infiniburn, int logicalHeight, int minY, int monsterSpawnBlockLightLimit, IntProvider monsterSpawnLightLevel, boolean natural, boolean piglinSafe, boolean respawnAnchorWorks, boolean ultraWarm) {
		return new DimensionType(fixedTime, hasSkylight, hasCeiling, ultraWarm, natural, coordinateScale, bedWorks, respawnAnchorWorks, minY, height, logicalHeight, infiniburn, effects, ambientLight, new DimensionType.MonsterSettings(piglinSafe, hasRaids, monsterSpawnLightLevel, monsterSpawnBlockLightLimit));
	}
}
