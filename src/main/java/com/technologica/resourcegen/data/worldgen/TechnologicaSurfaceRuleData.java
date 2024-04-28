package com.technologica.resourcegen.data.worldgen;

import com.google.common.collect.ImmutableList;
import com.technologica.api.tlregen.resourcegen.data.worldgen.TLReGenWorldgenNoiseSettings;
import com.technologica.registration.deferred.TechnologicaBlocks;
import com.technologica.registration.key.TechnologicaNoiseGeneratorSettings;

import net.minecraft.world.level.biome.Biomes;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.Noises;
import net.minecraft.world.level.levelgen.SurfaceRules;
import net.minecraft.world.level.levelgen.VerticalAnchor;

/**
 * <p>
 * This class contains Surface Rules.
 * The corresponding Surface Rules are created in json format during Data Generation via bootstrap in {@link TechnologicaNoiseGeneratorSettings}.
 * </p>
 * 
 * @tl.status ORANGE
 */
public class TechnologicaSurfaceRuleData {
	private static final SurfaceRules.RuleSource COARSE_DIRT = makeStateRule(TechnologicaBlocks.MOON_DUST.get());
	private static final SurfaceRules.RuleSource DIRT = makeStateRule(TechnologicaBlocks.MOON_DUST.get());
	private static final SurfaceRules.RuleSource GRASS_BLOCK = makeStateRule(Blocks.GRASS_BLOCK);
	private static final SurfaceRules.RuleSource SAND = makeStateRule(TechnologicaBlocks.MOON_DUST.get());
	private static final SurfaceRules.RuleSource SANDSTONE = makeStateRule(TechnologicaBlocks.MOON_DUST.get());
	private static final SurfaceRules.RuleSource STONE = makeStateRule(TechnologicaBlocks.MOON_DUST.get());
	private static final SurfaceRules.RuleSource GRAVEL = makeStateRule(TechnologicaBlocks.MOON_DUST.get());
	private static final SurfaceRules.RuleSource POWDER_SNOW = makeStateRule(TechnologicaBlocks.MOON_DUST.get());
	private static final SurfaceRules.RuleSource BEDROCK = makeStateRule(Blocks.BEDROCK);
	private static final SurfaceRules.RuleSource CALCITE = makeStateRule(Blocks.CALCITE);
	private static final SurfaceRules.RuleSource SNOW_BLOCK = makeStateRule(Blocks.SNOW_BLOCK);
	private static final SurfaceRules.RuleSource AIR = makeStateRule(Blocks.AIR);
	private static final SurfaceRules.RuleSource WHITE_TERRACOTTA = makeStateRule(Blocks.WHITE_TERRACOTTA);
	private static final SurfaceRules.RuleSource ORANGE_TERRACOTTA = makeStateRule(Blocks.ORANGE_TERRACOTTA);
	private static final SurfaceRules.RuleSource TERRACOTTA = makeStateRule(Blocks.TERRACOTTA);
	private static final SurfaceRules.RuleSource RED_SAND = makeStateRule(Blocks.RED_SAND);
	private static final SurfaceRules.RuleSource RED_SANDSTONE = makeStateRule(Blocks.RED_SANDSTONE);
	private static final SurfaceRules.RuleSource DEEPSLATE = makeStateRule(Blocks.DEEPSLATE);
	private static final SurfaceRules.RuleSource PODZOL = makeStateRule(Blocks.PODZOL);
	private static final SurfaceRules.RuleSource MYCELIUM = makeStateRule(Blocks.MYCELIUM);
	private static final SurfaceRules.RuleSource PACKED_ICE = makeStateRule(Blocks.PACKED_ICE);
	private static final SurfaceRules.RuleSource MUD = makeStateRule(Blocks.MUD);
	private static final SurfaceRules.RuleSource ICE = makeStateRule(Blocks.ICE);
	private static final SurfaceRules.RuleSource WATER = makeStateRule(Blocks.WATER);
	private static final SurfaceRules.RuleSource LAVA = makeStateRule(Blocks.WATER);
	private static final SurfaceRules.RuleSource NETHERRACK = makeStateRule(Blocks.GRASS_BLOCK);
	private static final SurfaceRules.RuleSource SOUL_SAND = makeStateRule(Blocks.MUD);
	private static final SurfaceRules.RuleSource SOUL_SOIL = makeStateRule(Blocks.MUD);
	private static final SurfaceRules.RuleSource BASALT = makeStateRule(Blocks.BASALT);
	private static final SurfaceRules.RuleSource BLACKSTONE = makeStateRule(Blocks.BLACKSTONE);
	private static final SurfaceRules.RuleSource WARPED_WART_BLOCK = makeStateRule(Blocks.WARPED_WART_BLOCK);
	private static final SurfaceRules.RuleSource WARPED_NYLIUM = makeStateRule(Blocks.WARPED_NYLIUM);
	private static final SurfaceRules.RuleSource NETHER_WART_BLOCK = makeStateRule(Blocks.NETHER_WART_BLOCK);
	private static final SurfaceRules.RuleSource CRIMSON_NYLIUM = makeStateRule(Blocks.CRIMSON_NYLIUM);
	private static final SurfaceRules.RuleSource MOON_DUST = makeStateRule(TechnologicaBlocks.MOON_DUST.get());

	private static SurfaceRules.RuleSource makeStateRule(Block blockIn) {
		return SurfaceRules.state(blockIn.defaultBlockState());
	}

	public static SurfaceRules.RuleSource moon() {
		SurfaceRules.ConditionSource surfacerules$conditionsource = SurfaceRules.yBlockCheck(VerticalAnchor.absolute(97), 2);
		SurfaceRules.ConditionSource surfacerules$conditionsource1 = SurfaceRules.yBlockCheck(VerticalAnchor.absolute(256), 0);
		SurfaceRules.ConditionSource surfacerules$conditionsource2 = SurfaceRules.yStartCheck(VerticalAnchor.absolute(63), -1);
		SurfaceRules.ConditionSource surfacerules$conditionsource3 = SurfaceRules.yStartCheck(VerticalAnchor.absolute(74), 1);
		SurfaceRules.ConditionSource surfacerules$conditionsource4 = SurfaceRules.yBlockCheck(VerticalAnchor.absolute(60), 0);
		SurfaceRules.ConditionSource surfacerules$conditionsource5 = SurfaceRules.yBlockCheck(VerticalAnchor.absolute(62), 0);
		SurfaceRules.ConditionSource surfacerules$conditionsource6 = SurfaceRules.yBlockCheck(VerticalAnchor.absolute(63), 0);
		SurfaceRules.ConditionSource surfacerules$conditionsource7 = SurfaceRules.waterBlockCheck(-1, 0);
		SurfaceRules.ConditionSource surfacerules$conditionsource8 = SurfaceRules.waterBlockCheck(0, 0);
		SurfaceRules.ConditionSource surfacerules$conditionsource9 = SurfaceRules.waterStartCheck(-6, -1);
		SurfaceRules.ConditionSource surfacerules$conditionsource10 = SurfaceRules.hole();
		SurfaceRules.ConditionSource surfacerules$conditionsource11 = SurfaceRules.isBiome(Biomes.FROZEN_OCEAN, Biomes.DEEP_FROZEN_OCEAN);
		SurfaceRules.ConditionSource surfacerules$conditionsource12 = SurfaceRules.steep();
		SurfaceRules.ConditionSource surfacerules$conditionsource13 = SurfaceRules.isBiome(Biomes.WARM_OCEAN, Biomes.BEACH, Biomes.SNOWY_BEACH);
		SurfaceRules.ConditionSource surfacerules$conditionsource14 = SurfaceRules.isBiome(Biomes.DESERT);
		SurfaceRules.ConditionSource surfacerules$conditionsource15 = SurfaceRules.noiseCondition(Noises.SURFACE, -0.909D, -0.5454D);
		SurfaceRules.ConditionSource surfacerules$conditionsource16 = SurfaceRules.noiseCondition(Noises.SURFACE, -0.1818D, 0.1818D);
		SurfaceRules.ConditionSource surfacerules$conditionsource17 = SurfaceRules.noiseCondition(Noises.SURFACE, 0.5454D, 0.909D);

		SurfaceRules.RuleSource surfacerules$rulesource = SurfaceRules.sequence(SurfaceRules.ifTrue(surfacerules$conditionsource8, MOON_DUST), DIRT);
		SurfaceRules.RuleSource surfacerules$rulesource1 = SurfaceRules.sequence(SurfaceRules.ifTrue(SurfaceRules.ON_CEILING, SANDSTONE), SAND);
		SurfaceRules.RuleSource surfacerules$rulesource2 = SurfaceRules.sequence(SurfaceRules.ifTrue(SurfaceRules.ON_CEILING, STONE), GRAVEL);
		SurfaceRules.RuleSource surfacerules$rulesource3 = SurfaceRules.sequence(SurfaceRules.ifTrue(SurfaceRules.isBiome(Biomes.STONY_PEAKS), SurfaceRules.sequence(SurfaceRules.ifTrue(SurfaceRules.noiseCondition(Noises.CALCITE, -0.0125D, 0.0125D), CALCITE), STONE)), SurfaceRules.ifTrue(SurfaceRules.isBiome(Biomes.STONY_SHORE), SurfaceRules.sequence(SurfaceRules.ifTrue(SurfaceRules.noiseCondition(Noises.GRAVEL, -0.05D, 0.05D), surfacerules$rulesource2), STONE)), SurfaceRules.ifTrue(SurfaceRules.isBiome(Biomes.WINDSWEPT_HILLS), SurfaceRules.ifTrue(surfaceNoiseAbove(1.0D), STONE)), SurfaceRules.ifTrue(surfacerules$conditionsource13, surfacerules$rulesource1), SurfaceRules.ifTrue(surfacerules$conditionsource14, surfacerules$rulesource1), SurfaceRules.ifTrue(SurfaceRules.isBiome(Biomes.DRIPSTONE_CAVES), STONE));
		SurfaceRules.RuleSource surfacerules$rulesource4 = SurfaceRules.ifTrue(SurfaceRules.noiseCondition(Noises.POWDER_SNOW, 0.45D, 0.58D), SurfaceRules.ifTrue(surfacerules$conditionsource8, POWDER_SNOW));
		SurfaceRules.RuleSource surfacerules$rulesource5 = SurfaceRules.ifTrue(SurfaceRules.noiseCondition(Noises.POWDER_SNOW, 0.35D, 0.6D), SurfaceRules.ifTrue(surfacerules$conditionsource8, POWDER_SNOW));
		SurfaceRules.RuleSource surfacerules$rulesource6 = SurfaceRules.sequence(SurfaceRules.ifTrue(SurfaceRules.isBiome(Biomes.FROZEN_PEAKS), SurfaceRules.sequence(SurfaceRules.ifTrue(surfacerules$conditionsource12, PACKED_ICE), SurfaceRules.ifTrue(SurfaceRules.noiseCondition(Noises.PACKED_ICE, -0.5D, 0.2D), PACKED_ICE), SurfaceRules.ifTrue(SurfaceRules.noiseCondition(Noises.ICE, -0.0625D, 0.025D), ICE), SurfaceRules.ifTrue(surfacerules$conditionsource8, SNOW_BLOCK))), SurfaceRules.ifTrue(SurfaceRules.isBiome(Biomes.SNOWY_SLOPES), SurfaceRules.sequence(SurfaceRules.ifTrue(surfacerules$conditionsource12, STONE), surfacerules$rulesource4, SurfaceRules.ifTrue(surfacerules$conditionsource8, SNOW_BLOCK))), SurfaceRules.ifTrue(SurfaceRules.isBiome(Biomes.JAGGED_PEAKS), STONE), SurfaceRules.ifTrue(SurfaceRules.isBiome(Biomes.GROVE), SurfaceRules.sequence(surfacerules$rulesource4, DIRT)), surfacerules$rulesource3, SurfaceRules.ifTrue(SurfaceRules.isBiome(Biomes.WINDSWEPT_SAVANNA), SurfaceRules.ifTrue(surfaceNoiseAbove(1.75D), STONE)), SurfaceRules.ifTrue(SurfaceRules.isBiome(Biomes.WINDSWEPT_GRAVELLY_HILLS), SurfaceRules.sequence(SurfaceRules.ifTrue(surfaceNoiseAbove(2.0D), surfacerules$rulesource2), SurfaceRules.ifTrue(surfaceNoiseAbove(1.0D), STONE), SurfaceRules.ifTrue(surfaceNoiseAbove(-1.0D), DIRT), surfacerules$rulesource2)), SurfaceRules.ifTrue(SurfaceRules.isBiome(Biomes.MANGROVE_SWAMP), MUD), DIRT);
		SurfaceRules.RuleSource surfacerules$rulesource7 = SurfaceRules.sequence(SurfaceRules.ifTrue(SurfaceRules.isBiome(Biomes.FROZEN_PEAKS), SurfaceRules.sequence(SurfaceRules.ifTrue(surfacerules$conditionsource12, PACKED_ICE), SurfaceRules.ifTrue(SurfaceRules.noiseCondition(Noises.PACKED_ICE, 0.0D, 0.2D), PACKED_ICE), SurfaceRules.ifTrue(SurfaceRules.noiseCondition(Noises.ICE, 0.0D, 0.025D), ICE), SurfaceRules.ifTrue(surfacerules$conditionsource8, SNOW_BLOCK))), SurfaceRules.ifTrue(SurfaceRules.isBiome(Biomes.SNOWY_SLOPES), SurfaceRules.sequence(SurfaceRules.ifTrue(surfacerules$conditionsource12, STONE), surfacerules$rulesource5, SurfaceRules.ifTrue(surfacerules$conditionsource8, SNOW_BLOCK))), SurfaceRules.ifTrue(SurfaceRules.isBiome(Biomes.JAGGED_PEAKS), SurfaceRules.sequence(SurfaceRules.ifTrue(surfacerules$conditionsource12, STONE), SurfaceRules.ifTrue(surfacerules$conditionsource8, SNOW_BLOCK))), SurfaceRules.ifTrue(SurfaceRules.isBiome(Biomes.GROVE), SurfaceRules.sequence(surfacerules$rulesource5, SurfaceRules.ifTrue(surfacerules$conditionsource8, SNOW_BLOCK))), surfacerules$rulesource3, SurfaceRules.ifTrue(SurfaceRules.isBiome(Biomes.WINDSWEPT_SAVANNA), SurfaceRules.sequence(SurfaceRules.ifTrue(surfaceNoiseAbove(1.75D), STONE), SurfaceRules.ifTrue(surfaceNoiseAbove(-0.5D), COARSE_DIRT))), SurfaceRules.ifTrue(SurfaceRules.isBiome(Biomes.WINDSWEPT_GRAVELLY_HILLS), SurfaceRules.sequence(SurfaceRules.ifTrue(surfaceNoiseAbove(2.0D), surfacerules$rulesource2), SurfaceRules.ifTrue(surfaceNoiseAbove(1.0D), STONE), SurfaceRules.ifTrue(surfaceNoiseAbove(-1.0D), surfacerules$rulesource), surfacerules$rulesource2)), SurfaceRules.ifTrue(SurfaceRules.isBiome(Biomes.OLD_GROWTH_PINE_TAIGA, Biomes.OLD_GROWTH_SPRUCE_TAIGA), SurfaceRules.sequence(SurfaceRules.ifTrue(surfaceNoiseAbove(1.75D), COARSE_DIRT), SurfaceRules.ifTrue(surfaceNoiseAbove(-0.95D), PODZOL))), SurfaceRules.ifTrue(SurfaceRules.isBiome(Biomes.ICE_SPIKES), SurfaceRules.ifTrue(surfacerules$conditionsource8, SNOW_BLOCK)), SurfaceRules.ifTrue(SurfaceRules.isBiome(Biomes.MANGROVE_SWAMP), MUD), SurfaceRules.ifTrue(SurfaceRules.isBiome(Biomes.MUSHROOM_FIELDS), MYCELIUM), surfacerules$rulesource);

		return SurfaceRules.sequence(
			SurfaceRules.ifTrue(
				TLReGenWorldgenNoiseSettings.verticalGradient(
					VerticalAnchor.aboveBottom(5),
					"bedrock_floor", 
					VerticalAnchor.bottom() 
				), SurfaceRules.state(Blocks.BEDROCK.defaultBlockState())),
			SurfaceRules.ifTrue(SurfaceRules.abovePreliminarySurface(), SurfaceRules.sequence(SurfaceRules.ifTrue(SurfaceRules.ON_FLOOR, SurfaceRules.sequence(SurfaceRules.ifTrue(SurfaceRules.isBiome(Biomes.WOODED_BADLANDS), SurfaceRules.ifTrue(surfacerules$conditionsource, SurfaceRules.sequence(SurfaceRules.ifTrue(surfacerules$conditionsource15, COARSE_DIRT), SurfaceRules.ifTrue(surfacerules$conditionsource16, COARSE_DIRT), SurfaceRules.ifTrue(surfacerules$conditionsource17, COARSE_DIRT), surfacerules$rulesource))), SurfaceRules.ifTrue(SurfaceRules.isBiome(Biomes.SWAMP), SurfaceRules.ifTrue(surfacerules$conditionsource5, SurfaceRules.ifTrue(SurfaceRules.not(surfacerules$conditionsource6), SurfaceRules.ifTrue(SurfaceRules.noiseCondition(Noises.SWAMP, 0.0D), WATER)))), SurfaceRules.ifTrue(SurfaceRules.isBiome(Biomes.MANGROVE_SWAMP), SurfaceRules.ifTrue(surfacerules$conditionsource4, SurfaceRules.ifTrue(SurfaceRules.not(surfacerules$conditionsource6), SurfaceRules.ifTrue(SurfaceRules.noiseCondition(Noises.SWAMP, 0.0D), WATER)))))), SurfaceRules.ifTrue(SurfaceRules.isBiome(Biomes.BADLANDS, Biomes.ERODED_BADLANDS, Biomes.WOODED_BADLANDS), SurfaceRules.sequence(SurfaceRules.ifTrue(SurfaceRules.ON_FLOOR, SurfaceRules.sequence(SurfaceRules.ifTrue(surfacerules$conditionsource1, ORANGE_TERRACOTTA), SurfaceRules.ifTrue(surfacerules$conditionsource3, SurfaceRules.sequence(SurfaceRules.ifTrue(surfacerules$conditionsource15, TERRACOTTA), SurfaceRules.ifTrue(surfacerules$conditionsource16, TERRACOTTA), SurfaceRules.ifTrue(surfacerules$conditionsource17, TERRACOTTA), SurfaceRules.bandlands())), SurfaceRules.ifTrue(surfacerules$conditionsource7, SurfaceRules.sequence(SurfaceRules.ifTrue(SurfaceRules.ON_CEILING, RED_SANDSTONE), RED_SAND)), SurfaceRules.ifTrue(SurfaceRules.not(surfacerules$conditionsource10), ORANGE_TERRACOTTA), SurfaceRules.ifTrue(surfacerules$conditionsource9, WHITE_TERRACOTTA), surfacerules$rulesource2)), SurfaceRules.ifTrue(surfacerules$conditionsource2, SurfaceRules.sequence(SurfaceRules.ifTrue(surfacerules$conditionsource6, SurfaceRules.ifTrue(SurfaceRules.not(surfacerules$conditionsource3), ORANGE_TERRACOTTA)), SurfaceRules.bandlands())), SurfaceRules.ifTrue(SurfaceRules.UNDER_FLOOR, SurfaceRules.ifTrue(surfacerules$conditionsource9, WHITE_TERRACOTTA)))), SurfaceRules.ifTrue(SurfaceRules.ON_FLOOR, SurfaceRules.ifTrue(surfacerules$conditionsource7, SurfaceRules.sequence(SurfaceRules.ifTrue(surfacerules$conditionsource11, SurfaceRules.ifTrue(surfacerules$conditionsource10, SurfaceRules.sequence(SurfaceRules.ifTrue(surfacerules$conditionsource8, AIR), SurfaceRules.ifTrue(SurfaceRules.temperature(), ICE), WATER))), surfacerules$rulesource7))), SurfaceRules.ifTrue(surfacerules$conditionsource9, SurfaceRules.sequence(SurfaceRules.ifTrue(SurfaceRules.ON_FLOOR, SurfaceRules.ifTrue(surfacerules$conditionsource11, SurfaceRules.ifTrue(surfacerules$conditionsource10, WATER))), SurfaceRules.ifTrue(SurfaceRules.UNDER_FLOOR, surfacerules$rulesource6), SurfaceRules.ifTrue(surfacerules$conditionsource13, SurfaceRules.ifTrue(SurfaceRules.DEEP_UNDER_FLOOR, SANDSTONE)), SurfaceRules.ifTrue(surfacerules$conditionsource14, SurfaceRules.ifTrue(SurfaceRules.VERY_DEEP_UNDER_FLOOR, SANDSTONE)))), SurfaceRules.ifTrue(SurfaceRules.ON_FLOOR, SurfaceRules.sequence(SurfaceRules.ifTrue(SurfaceRules.isBiome(Biomes.FROZEN_PEAKS, Biomes.JAGGED_PEAKS), STONE), SurfaceRules.ifTrue(SurfaceRules.isBiome(Biomes.WARM_OCEAN, Biomes.LUKEWARM_OCEAN, Biomes.DEEP_LUKEWARM_OCEAN), surfacerules$rulesource1), surfacerules$rulesource2)))),
			SurfaceRules.ifTrue(SurfaceRules.verticalGradient("deepslate", VerticalAnchor.absolute(0), VerticalAnchor.absolute(8)), SurfaceRules.state(Blocks.DEEPSLATE.defaultBlockState()))
		);
	}

	public static SurfaceRules.RuleSource challengerDeep() {
		SurfaceRules.ConditionSource surfacerules$conditionsource = SurfaceRules.yBlockCheck(VerticalAnchor.absolute(31), 0);
		SurfaceRules.ConditionSource surfacerules$conditionsource1 = SurfaceRules.yBlockCheck(VerticalAnchor.absolute(32), 0);
		SurfaceRules.ConditionSource surfacerules$conditionsource2 = SurfaceRules.yStartCheck(VerticalAnchor.absolute(30), 0);
		SurfaceRules.ConditionSource surfacerules$conditionsource3 = SurfaceRules.not(SurfaceRules.yStartCheck(VerticalAnchor.absolute(35), 0));
		SurfaceRules.ConditionSource surfacerules$conditionsource4 = SurfaceRules.yBlockCheck(VerticalAnchor.belowTop(5), 0);
		SurfaceRules.ConditionSource surfacerules$conditionsource5 = SurfaceRules.hole();
		SurfaceRules.ConditionSource surfacerules$conditionsource6 = SurfaceRules.noiseCondition(Noises.SOUL_SAND_LAYER, -0.012D);
		SurfaceRules.ConditionSource surfacerules$conditionsource7 = SurfaceRules.noiseCondition(Noises.GRAVEL_LAYER, -0.012D);
		SurfaceRules.ConditionSource surfacerules$conditionsource8 = SurfaceRules.noiseCondition(Noises.PATCH, -0.012D);
		SurfaceRules.ConditionSource surfacerules$conditionsource9 = SurfaceRules.noiseCondition(Noises.NETHERRACK, 0.54D);
		SurfaceRules.ConditionSource surfacerules$conditionsource10 = SurfaceRules.noiseCondition(Noises.NETHER_WART, 1.17D);
		SurfaceRules.ConditionSource surfacerules$conditionsource11 = SurfaceRules.noiseCondition(Noises.NETHER_STATE_SELECTOR, 0.0D);
		SurfaceRules.RuleSource surfacerules$rulesource = SurfaceRules.ifTrue(surfacerules$conditionsource8, SurfaceRules.ifTrue(surfacerules$conditionsource2, SurfaceRules.ifTrue(surfacerules$conditionsource3, GRAVEL)));
		return SurfaceRules.sequence(SurfaceRules.ifTrue(SurfaceRules.verticalGradient("bedrock_floor", VerticalAnchor.bottom(), VerticalAnchor.aboveBottom(5)), BEDROCK), SurfaceRules.ifTrue(SurfaceRules.not(SurfaceRules.verticalGradient("bedrock_roof", VerticalAnchor.belowTop(5), VerticalAnchor.top())), BEDROCK), SurfaceRules.ifTrue(surfacerules$conditionsource4, NETHERRACK), SurfaceRules.ifTrue(SurfaceRules.isBiome(Biomes.BASALT_DELTAS), SurfaceRules.sequence(SurfaceRules.ifTrue(SurfaceRules.UNDER_CEILING, BASALT), SurfaceRules.ifTrue(SurfaceRules.UNDER_FLOOR, SurfaceRules.sequence(surfacerules$rulesource, SurfaceRules.ifTrue(surfacerules$conditionsource11, BASALT), BLACKSTONE)))), SurfaceRules.ifTrue(SurfaceRules.isBiome(Biomes.SOUL_SAND_VALLEY), SurfaceRules.sequence(SurfaceRules.ifTrue(SurfaceRules.UNDER_CEILING, SurfaceRules.sequence(SurfaceRules.ifTrue(surfacerules$conditionsource11, SOUL_SAND), SOUL_SOIL)), SurfaceRules.ifTrue(SurfaceRules.UNDER_FLOOR, SurfaceRules.sequence(surfacerules$rulesource, SurfaceRules.ifTrue(surfacerules$conditionsource11, SOUL_SAND), SOUL_SOIL)))), SurfaceRules.ifTrue(SurfaceRules.ON_FLOOR, SurfaceRules.sequence(SurfaceRules.ifTrue(SurfaceRules.not(surfacerules$conditionsource1), SurfaceRules.ifTrue(surfacerules$conditionsource5, LAVA)), SurfaceRules.ifTrue(SurfaceRules.isBiome(Biomes.WARPED_FOREST), SurfaceRules.ifTrue(SurfaceRules.not(surfacerules$conditionsource9), SurfaceRules.ifTrue(surfacerules$conditionsource, SurfaceRules.sequence(SurfaceRules.ifTrue(surfacerules$conditionsource10, WARPED_WART_BLOCK), WARPED_NYLIUM)))), SurfaceRules.ifTrue(SurfaceRules.isBiome(Biomes.CRIMSON_FOREST), SurfaceRules.ifTrue(SurfaceRules.not(surfacerules$conditionsource9), SurfaceRules.ifTrue(surfacerules$conditionsource, SurfaceRules.sequence(SurfaceRules.ifTrue(surfacerules$conditionsource10, NETHER_WART_BLOCK), CRIMSON_NYLIUM)))))), SurfaceRules.ifTrue(SurfaceRules.isBiome(Biomes.NETHER_WASTES), SurfaceRules.sequence(SurfaceRules.ifTrue(SurfaceRules.UNDER_FLOOR, SurfaceRules.ifTrue(surfacerules$conditionsource6, SurfaceRules.sequence(SurfaceRules.ifTrue(SurfaceRules.not(surfacerules$conditionsource5), SurfaceRules.ifTrue(surfacerules$conditionsource2, SurfaceRules.ifTrue(surfacerules$conditionsource3, SOUL_SAND))), NETHERRACK))), SurfaceRules.ifTrue(SurfaceRules.ON_FLOOR, SurfaceRules.ifTrue(surfacerules$conditionsource, SurfaceRules.ifTrue(surfacerules$conditionsource3, SurfaceRules.ifTrue(surfacerules$conditionsource7, SurfaceRules.sequence(SurfaceRules.ifTrue(surfacerules$conditionsource1, GRAVEL), SurfaceRules.ifTrue(SurfaceRules.not(surfacerules$conditionsource5), GRAVEL)))))))), NETHERRACK);
	}

	public static SurfaceRules.RuleSource overgrowth() {
		SurfaceRules.ConditionSource surfacerules$conditionsource = SurfaceRules.yBlockCheck(VerticalAnchor.absolute(97), 2);
		SurfaceRules.ConditionSource surfacerules$conditionsource1 = SurfaceRules.yBlockCheck(VerticalAnchor.absolute(256), 0);
		SurfaceRules.ConditionSource surfacerules$conditionsource2 = SurfaceRules.yStartCheck(VerticalAnchor.absolute(63), -1);
		SurfaceRules.ConditionSource surfacerules$conditionsource3 = SurfaceRules.yStartCheck(VerticalAnchor.absolute(74), 1);
		SurfaceRules.ConditionSource surfacerules$conditionsource4 = SurfaceRules.yBlockCheck(VerticalAnchor.absolute(60), 0);
		SurfaceRules.ConditionSource surfacerules$conditionsource5 = SurfaceRules.yBlockCheck(VerticalAnchor.absolute(62), 0);
		SurfaceRules.ConditionSource surfacerules$conditionsource6 = SurfaceRules.yBlockCheck(VerticalAnchor.absolute(63), 0);
		SurfaceRules.ConditionSource surfacerules$conditionsource7 = SurfaceRules.waterBlockCheck(-1, 0);
		SurfaceRules.ConditionSource surfacerules$conditionsource8 = SurfaceRules.waterBlockCheck(0, 0);
		SurfaceRules.ConditionSource surfacerules$conditionsource9 = SurfaceRules.waterStartCheck(-6, -1);
		SurfaceRules.ConditionSource surfacerules$conditionsource10 = SurfaceRules.hole();
		SurfaceRules.ConditionSource surfacerules$conditionsource11 = SurfaceRules.isBiome(Biomes.FROZEN_OCEAN, Biomes.DEEP_FROZEN_OCEAN);
		SurfaceRules.ConditionSource surfacerules$conditionsource12 = SurfaceRules.steep();
		SurfaceRules.ConditionSource surfacerules$conditionsource13 = SurfaceRules.isBiome(Biomes.WARM_OCEAN, Biomes.BEACH, Biomes.SNOWY_BEACH);
		SurfaceRules.ConditionSource surfacerules$conditionsource14 = SurfaceRules.isBiome(Biomes.DESERT);
		SurfaceRules.ConditionSource surfacerules$conditionsource15 = SurfaceRules.noiseCondition(Noises.SURFACE, -0.909D, -0.5454D);
		SurfaceRules.ConditionSource surfacerules$conditionsource16 = SurfaceRules.noiseCondition(Noises.SURFACE, -0.1818D, 0.1818D);
		SurfaceRules.ConditionSource surfacerules$conditionsource17 = SurfaceRules.noiseCondition(Noises.SURFACE, 0.5454D, 0.909D);

		SurfaceRules.RuleSource surfacerules$rulesource = SurfaceRules.sequence(SurfaceRules.ifTrue(surfacerules$conditionsource8, GRASS_BLOCK), DIRT);

		SurfaceRules.RuleSource surfacerules$rulesource1 = SurfaceRules.sequence(SurfaceRules.ifTrue(SurfaceRules.ON_CEILING, DIRT), DIRT);

		SurfaceRules.RuleSource surfacerules$rulesource2 = SurfaceRules.sequence(SurfaceRules.ifTrue(SurfaceRules.ON_CEILING, DIRT), DIRT);

		SurfaceRules.RuleSource surfacerules$rulesource3 = SurfaceRules.sequence(SurfaceRules.ifTrue(SurfaceRules.isBiome(Biomes.STONY_PEAKS), SurfaceRules.sequence(SurfaceRules.ifTrue(SurfaceRules.noiseCondition(Noises.CALCITE, -0.0125D, 0.0125D), CALCITE), DIRT)), SurfaceRules.ifTrue(SurfaceRules.isBiome(Biomes.STONY_SHORE), SurfaceRules.sequence(SurfaceRules.ifTrue(SurfaceRules.noiseCondition(Noises.GRAVEL, -0.05D, 0.05D), surfacerules$rulesource2), DIRT)), SurfaceRules.ifTrue(SurfaceRules.isBiome(Biomes.WINDSWEPT_HILLS), SurfaceRules.ifTrue(surfaceNoiseAbove(1.0D), DIRT)), SurfaceRules.ifTrue(surfacerules$conditionsource13, surfacerules$rulesource1), SurfaceRules.ifTrue(surfacerules$conditionsource14, surfacerules$rulesource1), SurfaceRules.ifTrue(SurfaceRules.isBiome(Biomes.DRIPSTONE_CAVES), STONE));

		SurfaceRules.RuleSource surfacerules$rulesource4 = SurfaceRules.ifTrue(SurfaceRules.noiseCondition(Noises.POWDER_SNOW, 0.45D, 0.58D), SurfaceRules.ifTrue(surfacerules$conditionsource8, DIRT));

		SurfaceRules.RuleSource surfacerules$rulesource5 = SurfaceRules.ifTrue(SurfaceRules.noiseCondition(Noises.POWDER_SNOW, 0.35D, 0.6D), SurfaceRules.ifTrue(surfacerules$conditionsource8, DIRT));

		SurfaceRules.RuleSource surfacerules$rulesource6 = SurfaceRules.sequence(SurfaceRules.ifTrue(SurfaceRules.isBiome(Biomes.FROZEN_PEAKS), SurfaceRules.sequence(SurfaceRules.ifTrue(surfacerules$conditionsource12, PACKED_ICE), SurfaceRules.ifTrue(SurfaceRules.noiseCondition(Noises.PACKED_ICE, -0.5D, 0.2D), PACKED_ICE), SurfaceRules.ifTrue(SurfaceRules.noiseCondition(Noises.ICE, -0.0625D, 0.025D), ICE), SurfaceRules.ifTrue(surfacerules$conditionsource8, DIRT))), SurfaceRules.ifTrue(SurfaceRules.isBiome(Biomes.SNOWY_SLOPES), SurfaceRules.sequence(SurfaceRules.ifTrue(surfacerules$conditionsource12, DIRT), surfacerules$rulesource4, SurfaceRules.ifTrue(surfacerules$conditionsource8, SNOW_BLOCK))), SurfaceRules.ifTrue(SurfaceRules.isBiome(Biomes.JAGGED_PEAKS), STONE), SurfaceRules.ifTrue(SurfaceRules.isBiome(Biomes.GROVE), SurfaceRules.sequence(surfacerules$rulesource4, DIRT)), surfacerules$rulesource3, SurfaceRules.ifTrue(SurfaceRules.isBiome(Biomes.WINDSWEPT_SAVANNA), SurfaceRules.ifTrue(surfaceNoiseAbove(1.75D), STONE)), SurfaceRules.ifTrue(SurfaceRules.isBiome(Biomes.WINDSWEPT_GRAVELLY_HILLS), SurfaceRules.sequence(SurfaceRules.ifTrue(surfaceNoiseAbove(2.0D), surfacerules$rulesource2), SurfaceRules.ifTrue(surfaceNoiseAbove(1.0D), STONE), SurfaceRules.ifTrue(surfaceNoiseAbove(-1.0D), DIRT), surfacerules$rulesource2)), SurfaceRules.ifTrue(SurfaceRules.isBiome(Biomes.MANGROVE_SWAMP), MUD), DIRT);

		SurfaceRules.RuleSource surfacerules$rulesource7 = SurfaceRules.sequence(SurfaceRules.ifTrue(SurfaceRules.isBiome(Biomes.FROZEN_PEAKS), SurfaceRules.sequence(SurfaceRules.ifTrue(surfacerules$conditionsource12, PACKED_ICE), SurfaceRules.ifTrue(SurfaceRules.noiseCondition(Noises.PACKED_ICE, 0.0D, 0.2D), PACKED_ICE), SurfaceRules.ifTrue(SurfaceRules.noiseCondition(Noises.ICE, 0.0D, 0.025D), ICE), SurfaceRules.ifTrue(surfacerules$conditionsource8, DIRT))), SurfaceRules.ifTrue(SurfaceRules.isBiome(Biomes.SNOWY_SLOPES), SurfaceRules.sequence(SurfaceRules.ifTrue(surfacerules$conditionsource12, DIRT), surfacerules$rulesource5, SurfaceRules.ifTrue(surfacerules$conditionsource8, SNOW_BLOCK))), SurfaceRules.ifTrue(SurfaceRules.isBiome(Biomes.JAGGED_PEAKS), SurfaceRules.sequence(SurfaceRules.ifTrue(surfacerules$conditionsource12, STONE), SurfaceRules.ifTrue(surfacerules$conditionsource8, SNOW_BLOCK))), SurfaceRules.ifTrue(SurfaceRules.isBiome(Biomes.GROVE), SurfaceRules.sequence(surfacerules$rulesource5, SurfaceRules.ifTrue(surfacerules$conditionsource8, SNOW_BLOCK))), surfacerules$rulesource3, SurfaceRules.ifTrue(SurfaceRules.isBiome(Biomes.WINDSWEPT_SAVANNA), SurfaceRules.sequence(SurfaceRules.ifTrue(surfaceNoiseAbove(1.75D), STONE), SurfaceRules.ifTrue(surfaceNoiseAbove(-0.5D), COARSE_DIRT))), SurfaceRules.ifTrue(SurfaceRules.isBiome(Biomes.WINDSWEPT_GRAVELLY_HILLS), SurfaceRules.sequence(SurfaceRules.ifTrue(surfaceNoiseAbove(2.0D), surfacerules$rulesource2), SurfaceRules.ifTrue(surfaceNoiseAbove(1.0D), STONE), SurfaceRules.ifTrue(surfaceNoiseAbove(-1.0D), surfacerules$rulesource), surfacerules$rulesource2)), SurfaceRules.ifTrue(SurfaceRules.isBiome(Biomes.OLD_GROWTH_PINE_TAIGA, Biomes.OLD_GROWTH_SPRUCE_TAIGA), SurfaceRules.sequence(SurfaceRules.ifTrue(surfaceNoiseAbove(1.75D), COARSE_DIRT), SurfaceRules.ifTrue(surfaceNoiseAbove(-0.95D), PODZOL))), SurfaceRules.ifTrue(SurfaceRules.isBiome(Biomes.ICE_SPIKES), SurfaceRules.ifTrue(surfacerules$conditionsource8, SNOW_BLOCK)), SurfaceRules.ifTrue(SurfaceRules.isBiome(Biomes.MANGROVE_SWAMP), MUD), SurfaceRules.ifTrue(SurfaceRules.isBiome(Biomes.MUSHROOM_FIELDS), MYCELIUM), surfacerules$rulesource);

		SurfaceRules.RuleSource surfacerules$rulesource8 = SurfaceRules.sequence(SurfaceRules.ifTrue(SurfaceRules.ON_FLOOR, SurfaceRules.sequence(SurfaceRules.ifTrue(SurfaceRules.isBiome(Biomes.WOODED_BADLANDS), SurfaceRules.ifTrue(surfacerules$conditionsource, SurfaceRules.sequence(SurfaceRules.ifTrue(surfacerules$conditionsource15, COARSE_DIRT), SurfaceRules.ifTrue(surfacerules$conditionsource16, COARSE_DIRT), SurfaceRules.ifTrue(surfacerules$conditionsource17, COARSE_DIRT), surfacerules$rulesource))), SurfaceRules.ifTrue(SurfaceRules.isBiome(Biomes.SWAMP), SurfaceRules.ifTrue(surfacerules$conditionsource5, SurfaceRules.ifTrue(SurfaceRules.not(surfacerules$conditionsource6), SurfaceRules.ifTrue(SurfaceRules.noiseCondition(Noises.SWAMP, 0.0D), WATER)))), SurfaceRules.ifTrue(SurfaceRules.isBiome(Biomes.MANGROVE_SWAMP), SurfaceRules.ifTrue(surfacerules$conditionsource4, SurfaceRules.ifTrue(SurfaceRules.not(surfacerules$conditionsource6), SurfaceRules.ifTrue(SurfaceRules.noiseCondition(Noises.SWAMP, 0.0D), WATER)))))), SurfaceRules.ifTrue(SurfaceRules.isBiome(Biomes.BADLANDS, Biomes.ERODED_BADLANDS, Biomes.WOODED_BADLANDS), SurfaceRules.sequence(SurfaceRules.ifTrue(SurfaceRules.ON_FLOOR, SurfaceRules.sequence(SurfaceRules.ifTrue(surfacerules$conditionsource1, ORANGE_TERRACOTTA), SurfaceRules.ifTrue(surfacerules$conditionsource3, SurfaceRules.sequence(SurfaceRules.ifTrue(surfacerules$conditionsource15, TERRACOTTA), SurfaceRules.ifTrue(surfacerules$conditionsource16, TERRACOTTA), SurfaceRules.ifTrue(surfacerules$conditionsource17, TERRACOTTA), SurfaceRules.bandlands())), SurfaceRules.ifTrue(surfacerules$conditionsource7, SurfaceRules.sequence(SurfaceRules.ifTrue(SurfaceRules.ON_CEILING, RED_SANDSTONE), RED_SAND)), SurfaceRules.ifTrue(SurfaceRules.not(surfacerules$conditionsource10), ORANGE_TERRACOTTA), SurfaceRules.ifTrue(surfacerules$conditionsource9, WHITE_TERRACOTTA), surfacerules$rulesource2)), SurfaceRules.ifTrue(surfacerules$conditionsource2, SurfaceRules.sequence(SurfaceRules.ifTrue(surfacerules$conditionsource6, SurfaceRules.ifTrue(SurfaceRules.not(surfacerules$conditionsource3), ORANGE_TERRACOTTA)), SurfaceRules.bandlands())), SurfaceRules.ifTrue(SurfaceRules.UNDER_FLOOR, SurfaceRules.ifTrue(surfacerules$conditionsource9, WHITE_TERRACOTTA)))), SurfaceRules.ifTrue(SurfaceRules.ON_FLOOR, SurfaceRules.ifTrue(surfacerules$conditionsource7, SurfaceRules.sequence(SurfaceRules.ifTrue(surfacerules$conditionsource11, SurfaceRules.ifTrue(surfacerules$conditionsource10, SurfaceRules.sequence(SurfaceRules.ifTrue(surfacerules$conditionsource8, AIR), SurfaceRules.ifTrue(SurfaceRules.temperature(), ICE), WATER))), surfacerules$rulesource7))), SurfaceRules.ifTrue(surfacerules$conditionsource9, SurfaceRules.sequence(SurfaceRules.ifTrue(SurfaceRules.ON_FLOOR, SurfaceRules.ifTrue(surfacerules$conditionsource11, SurfaceRules.ifTrue(surfacerules$conditionsource10, WATER))), SurfaceRules.ifTrue(SurfaceRules.UNDER_FLOOR, surfacerules$rulesource6), SurfaceRules.ifTrue(surfacerules$conditionsource13, SurfaceRules.ifTrue(SurfaceRules.DEEP_UNDER_FLOOR, SANDSTONE)), SurfaceRules.ifTrue(surfacerules$conditionsource14, SurfaceRules.ifTrue(SurfaceRules.VERY_DEEP_UNDER_FLOOR, SANDSTONE)))), SurfaceRules.ifTrue(SurfaceRules.ON_FLOOR, SurfaceRules.sequence(SurfaceRules.ifTrue(SurfaceRules.isBiome(Biomes.FROZEN_PEAKS, Biomes.JAGGED_PEAKS), STONE), SurfaceRules.ifTrue(SurfaceRules.isBiome(Biomes.WARM_OCEAN, Biomes.LUKEWARM_OCEAN, Biomes.DEEP_LUKEWARM_OCEAN), surfacerules$rulesource1), surfacerules$rulesource2)));
		ImmutableList.Builder<SurfaceRules.RuleSource> builder = ImmutableList.builder();

		builder.add(surfacerules$rulesource8);
		builder.add(SurfaceRules.ifTrue(SurfaceRules.verticalGradient("deepslate", VerticalAnchor.absolute(0), VerticalAnchor.absolute(8)), DEEPSLATE));

		return SurfaceRules.sequence(builder.build().toArray((p_198379_) -> {
			return new SurfaceRules.RuleSource[p_198379_];
		}));
	}

	private static SurfaceRules.ConditionSource surfaceNoiseAbove(double p_194809_) {
		return SurfaceRules.noiseCondition(Noises.SURFACE, p_194809_ / 8.25D, Double.MAX_VALUE);
	}
}
