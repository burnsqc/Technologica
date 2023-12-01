package com.technologica.world.level.levelgen.feature;

import java.util.List;
import java.util.function.Predicate;

import com.google.common.collect.Lists;
import com.mojang.datafixers.util.Pair;
import com.mojang.serialization.Codec;
import com.technologica.registration.deferred.TechnologicaBlocks;
import com.technologica.world.level.block.OilyBlock;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.GeodeBlockSettings;
import net.minecraft.world.level.levelgen.GeodeCrackSettings;
import net.minecraft.world.level.levelgen.GeodeLayerSettings;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraft.world.level.levelgen.LegacyRandomSource;
import net.minecraft.world.level.levelgen.WorldgenRandom;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import net.minecraft.world.level.levelgen.feature.configurations.GeodeConfiguration;
import net.minecraft.world.level.levelgen.synth.NormalNoise;
import net.minecraft.world.level.material.FluidState;

public class OilWellFeature extends Feature<GeodeConfiguration> {
	private static final Direction[] DIRECTIONS = Direction.values();

	public OilWellFeature(Codec<GeodeConfiguration> codec) {
		super(codec);
	}

	@Override
	public boolean place(FeaturePlaceContext<GeodeConfiguration> p_159836_) {
		GeodeConfiguration geodeconfiguration = p_159836_.config();
		RandomSource randomsource = p_159836_.random();
		BlockPos blockpos = p_159836_.origin();
		WorldGenLevel worldgenlevel = p_159836_.level();
		int i = geodeconfiguration.minGenOffset;
		int j = geodeconfiguration.maxGenOffset;
		List<Pair<BlockPos, Integer>> list = Lists.newLinkedList();
		int k = geodeconfiguration.distributionPoints.sample(randomsource);
		WorldgenRandom worldgenrandom = new WorldgenRandom(new LegacyRandomSource(worldgenlevel.getSeed()));
		NormalNoise normalnoise = NormalNoise.create(worldgenrandom, -4, 1.0D);
		List<BlockPos> list1 = Lists.newLinkedList();
		double d0 = (double) k / (double) geodeconfiguration.outerWallDistance.getMaxValue();
		GeodeLayerSettings geodelayersettings = geodeconfiguration.geodeLayerSettings;
		GeodeBlockSettings geodeblocksettings = geodeconfiguration.geodeBlockSettings;
		GeodeCrackSettings geodecracksettings = geodeconfiguration.geodeCrackSettings;
		double d1 = 1.0D / Math.sqrt(geodelayersettings.filling);
		double d2 = 1.0D / Math.sqrt(geodelayersettings.innerLayer + d0);
		double d3 = 1.0D / Math.sqrt(geodelayersettings.middleLayer + d0);
		double d4 = 1.0D / Math.sqrt(geodelayersettings.outerLayer + d0);
		double d5 = 1.0D / Math.sqrt(geodecracksettings.baseCrackSize + randomsource.nextDouble() / 2.0D + (k > 3 ? d0 : 0.0D));
		boolean flag = randomsource.nextFloat() < geodecracksettings.generateCrackChance;
		int l = 0;

		for (int i1 = 0; i1 < k; ++i1) {
			int j1 = geodeconfiguration.outerWallDistance.sample(randomsource);
			int k1 = geodeconfiguration.outerWallDistance.sample(randomsource);
			int l1 = geodeconfiguration.outerWallDistance.sample(randomsource);
			BlockPos blockpos1 = blockpos.offset(j1, k1, l1);
			BlockState blockstate = worldgenlevel.getBlockState(blockpos1);
			if (blockstate.isAir() || blockstate.is(BlockTags.GEODE_INVALID_BLOCKS)) {
				++l;
				if (l > geodeconfiguration.invalidBlocksThreshold) {
					return false;
				}
			}

			list.add(Pair.of(blockpos1, geodeconfiguration.pointOffset.sample(randomsource)));
		}

		if (flag) {
			int i2 = randomsource.nextInt(4);
			int j2 = k * 2 + 1;
			if (i2 == 0) {
				list1.add(blockpos.offset(j2, 7, 0));
				list1.add(blockpos.offset(j2, 5, 0));
				list1.add(blockpos.offset(j2, 1, 0));
			} else if (i2 == 1) {
				list1.add(blockpos.offset(0, 7, j2));
				list1.add(blockpos.offset(0, 5, j2));
				list1.add(blockpos.offset(0, 1, j2));
			} else if (i2 == 2) {
				list1.add(blockpos.offset(j2, 7, j2));
				list1.add(blockpos.offset(j2, 5, j2));
				list1.add(blockpos.offset(j2, 1, j2));
			} else {
				list1.add(blockpos.offset(0, 7, 0));
				list1.add(blockpos.offset(0, 5, 0));
				list1.add(blockpos.offset(0, 1, 0));
			}
		}

		List<BlockPos> list2 = Lists.newArrayList();
		Predicate<BlockState> predicate = isReplaceable(geodeconfiguration.geodeBlockSettings.cannotReplace);

		for (BlockPos blockpos3 : BlockPos.betweenClosed(blockpos.offset(i, i, i), blockpos.offset(j, j, j))) {
			double d8 = normalnoise.getValue(blockpos3.getX(), blockpos3.getY(), blockpos3.getZ()) * geodeconfiguration.noiseMultiplier;
			double d6 = 0.0D;
			double d7 = 0.0D;

			for (Pair<BlockPos, Integer> pair : list) {
				d6 += Mth.invSqrt(blockpos3.distSqr(pair.getFirst()) + pair.getSecond().intValue()) + d8;
			}

			for (BlockPos blockpos6 : list1) {
				d7 += Mth.invSqrt(blockpos3.distSqr(blockpos6) + geodecracksettings.crackPointOffset) + d8;
			}

			if (!(d6 < d4)) {
				if (flag && d7 >= d5 && d6 < d1) {
					this.safeSetBlock(worldgenlevel, blockpos3, Blocks.AIR.defaultBlockState(), predicate);

					for (Direction direction1 : DIRECTIONS) {
						BlockPos blockpos2 = blockpos3.relative(direction1);
						FluidState fluidstate = worldgenlevel.getFluidState(blockpos2);
						if (!fluidstate.isEmpty()) {
							worldgenlevel.scheduleTick(blockpos2, fluidstate.getType(), 0);
						}
					}
				} else if (d6 >= d1) {
					this.safeSetBlock(worldgenlevel, blockpos3, geodeblocksettings.fillingProvider.getState(randomsource, blockpos3), predicate);
				} else if (d6 >= d2) {
					boolean flag1 = randomsource.nextFloat() < geodeconfiguration.useAlternateLayer0Chance;
					if (flag1) {
						this.safeSetBlock(worldgenlevel, blockpos3, geodeblocksettings.alternateInnerLayerProvider.getState(randomsource, blockpos3), predicate);
					} else {
						this.safeSetBlock(worldgenlevel, blockpos3, geodeblocksettings.innerLayerProvider.getState(randomsource, blockpos3), predicate);
					}

					if ((!geodeconfiguration.placementsRequireLayer0Alternate || flag1) && randomsource.nextFloat() < geodeconfiguration.usePotentialPlacementsChance) {
						list2.add(blockpos3.immutable());
					}
				} else if (d6 >= d3) {
					this.safeSetBlock(worldgenlevel, blockpos3, geodeblocksettings.middleLayerProvider.getState(randomsource, blockpos3), predicate);
				} else if (d6 >= d4) {
					this.safeSetBlock(worldgenlevel, blockpos3, geodeblocksettings.outerLayerProvider.getState(randomsource, blockpos3), predicate);
				}
			}
		}

		BlockPos surfacePos = worldgenlevel.getHeightmapPos(Heightmap.Types.MOTION_BLOCKING, blockpos);
		int pressure = Math.min((surfacePos.getY() - blockpos.getY() - 40)/4 + 1, 25);

		for (int stem = 0; stem < surfacePos.getY() - blockpos.getY() - 5; ++stem) {
			this.safeSetBlock(worldgenlevel, blockpos.offset(0, stem, 0), TechnologicaBlocks.OIL.get().defaultBlockState(), predicate);
		}

		for (int stem = -1; stem > -6; stem--) {
			for (int relativeX = -4; relativeX <= 4; relativeX++) {
				for (int relativeZ = -4; relativeZ <= 4; relativeZ++) {
					if (stem == -5) {
						if (worldgenlevel.getBlockState(surfacePos.offset(relativeX, stem, relativeZ)).is(BlockTags.DIRT)) {
							this.safeSetBlock(worldgenlevel, surfacePos.offset(relativeX, stem, relativeZ), TechnologicaBlocks.OILY_COARSE_DIRT.get().defaultBlockState().setValue(OilyBlock.PRESSURE, pressure), predicate);
						} else if (worldgenlevel.getBlockState(surfacePos.offset(relativeX, stem, relativeZ)).is(Blocks.GRAVEL) || worldgenlevel.getBlockState(surfacePos.offset(relativeX, stem, relativeZ)).is(Blocks.STONE)) {
							this.safeSetBlock(worldgenlevel, surfacePos.offset(relativeX, stem, relativeZ), TechnologicaBlocks.OILY_GRAVEL.get().defaultBlockState().setValue(OilyBlock.PRESSURE, pressure), predicate);
						} else if (worldgenlevel.getBlockState(surfacePos.offset(relativeX, stem, relativeZ)).is(Blocks.RED_SAND) || worldgenlevel.getBlockState(surfacePos.offset(relativeX, stem, relativeZ)).is(BlockTags.TERRACOTTA)) {
							this.safeSetBlock(worldgenlevel, surfacePos.offset(relativeX, stem, relativeZ), TechnologicaBlocks.OILY_RED_SAND.get().defaultBlockState().setValue(OilyBlock.PRESSURE, pressure), predicate);
						} else if (worldgenlevel.getBlockState(surfacePos.offset(relativeX, stem, relativeZ)).is(Blocks.SAND) || worldgenlevel.getBlockState(surfacePos.offset(relativeX, stem, relativeZ)).is(Blocks.SANDSTONE)) {
							this.safeSetBlock(worldgenlevel, surfacePos.offset(relativeX, stem, relativeZ), TechnologicaBlocks.OILY_SAND.get().defaultBlockState().setValue(OilyBlock.PRESSURE, pressure), predicate);
						}
					} else if (stem == -4 && (relativeX * relativeX + relativeZ * relativeZ) <= 1) {
						if (worldgenlevel.getRandom().nextInt(2) > 0) {
							if (worldgenlevel.getBlockState(surfacePos.offset(relativeX, stem, relativeZ)).is(BlockTags.DIRT)) {
								this.safeSetBlock(worldgenlevel, surfacePos.offset(relativeX, stem, relativeZ), TechnologicaBlocks.OILY_COARSE_DIRT.get().defaultBlockState(), predicate);
							} else if (worldgenlevel.getBlockState(surfacePos.offset(relativeX, stem, relativeZ)).is(Blocks.GRAVEL) || worldgenlevel.getBlockState(surfacePos.offset(relativeX, stem, relativeZ)).is(Blocks.STONE)) {
								this.safeSetBlock(worldgenlevel, surfacePos.offset(relativeX, stem, relativeZ), TechnologicaBlocks.OILY_GRAVEL.get().defaultBlockState(), predicate);
							} else if (worldgenlevel.getBlockState(surfacePos.offset(relativeX, stem, relativeZ)).is(Blocks.RED_SAND) || worldgenlevel.getBlockState(surfacePos.offset(relativeX, stem, relativeZ)).is(BlockTags.TERRACOTTA)) {
								this.safeSetBlock(worldgenlevel, surfacePos.offset(relativeX, stem, relativeZ), TechnologicaBlocks.OILY_RED_SAND.get().defaultBlockState(), predicate);
							} else if (worldgenlevel.getBlockState(surfacePos.offset(relativeX, stem, relativeZ)).is(Blocks.SAND) || worldgenlevel.getBlockState(surfacePos.offset(relativeX, stem, relativeZ)).is(Blocks.SANDSTONE)) {
								this.safeSetBlock(worldgenlevel, surfacePos.offset(relativeX, stem, relativeZ), TechnologicaBlocks.OILY_SAND.get().defaultBlockState(), predicate);
							}
						}
					} else if (stem == -3 && (relativeX * relativeX + relativeZ * relativeZ) <= 3) {
						if (worldgenlevel.getRandom().nextInt(2) > 0) {
							if (worldgenlevel.getBlockState(surfacePos.offset(relativeX, stem, relativeZ)).is(BlockTags.DIRT)) {
								this.safeSetBlock(worldgenlevel, surfacePos.offset(relativeX, stem, relativeZ), TechnologicaBlocks.OILY_COARSE_DIRT.get().defaultBlockState(), predicate);
							} else if (worldgenlevel.getBlockState(surfacePos.offset(relativeX, stem, relativeZ)).is(Blocks.GRAVEL) || worldgenlevel.getBlockState(surfacePos.offset(relativeX, stem, relativeZ)).is(Blocks.STONE)) {
								this.safeSetBlock(worldgenlevel, surfacePos.offset(relativeX, stem, relativeZ), TechnologicaBlocks.OILY_GRAVEL.get().defaultBlockState(), predicate);
							} else if (worldgenlevel.getBlockState(surfacePos.offset(relativeX, stem, relativeZ)).is(Blocks.RED_SAND) || worldgenlevel.getBlockState(surfacePos.offset(relativeX, stem, relativeZ)).is(BlockTags.TERRACOTTA)) {
								this.safeSetBlock(worldgenlevel, surfacePos.offset(relativeX, stem, relativeZ), TechnologicaBlocks.OILY_RED_SAND.get().defaultBlockState(), predicate);
							} else if (worldgenlevel.getBlockState(surfacePos.offset(relativeX, stem, relativeZ)).is(Blocks.SAND) || worldgenlevel.getBlockState(surfacePos.offset(relativeX, stem, relativeZ)).is(Blocks.SANDSTONE)) {
								this.safeSetBlock(worldgenlevel, surfacePos.offset(relativeX, stem, relativeZ), TechnologicaBlocks.OILY_SAND.get().defaultBlockState(), predicate);
							}
						}
					} else if (stem == -2 && (relativeX * relativeX + relativeZ * relativeZ) <= 5) {
						if (worldgenlevel.getRandom().nextInt(2) > 0) {
							if (worldgenlevel.getBlockState(surfacePos.offset(relativeX, stem, relativeZ)).is(BlockTags.DIRT)) {
								this.safeSetBlock(worldgenlevel, surfacePos.offset(relativeX, stem, relativeZ), TechnologicaBlocks.OILY_COARSE_DIRT.get().defaultBlockState(), predicate);
							} else if (worldgenlevel.getBlockState(surfacePos.offset(relativeX, stem, relativeZ)).is(Blocks.GRAVEL) || worldgenlevel.getBlockState(surfacePos.offset(relativeX, stem, relativeZ)).is(Blocks.STONE)) {
								this.safeSetBlock(worldgenlevel, surfacePos.offset(relativeX, stem, relativeZ), TechnologicaBlocks.OILY_GRAVEL.get().defaultBlockState(), predicate);
							} else if (worldgenlevel.getBlockState(surfacePos.offset(relativeX, stem, relativeZ)).is(Blocks.RED_SAND) || worldgenlevel.getBlockState(surfacePos.offset(relativeX, stem, relativeZ)).is(BlockTags.TERRACOTTA)) {
								this.safeSetBlock(worldgenlevel, surfacePos.offset(relativeX, stem, relativeZ), TechnologicaBlocks.OILY_RED_SAND.get().defaultBlockState(), predicate);
							} else if (worldgenlevel.getBlockState(surfacePos.offset(relativeX, stem, relativeZ)).is(Blocks.SAND) || worldgenlevel.getBlockState(surfacePos.offset(relativeX, stem, relativeZ)).is(Blocks.SANDSTONE)) {
								this.safeSetBlock(worldgenlevel, surfacePos.offset(relativeX, stem, relativeZ), TechnologicaBlocks.OILY_SAND.get().defaultBlockState(), predicate);
							}
						}
					} else if (stem == -1 && (relativeX * relativeX + relativeZ * relativeZ) <= 10) {
						if (worldgenlevel.getRandom().nextInt(2) > 0) {
							if (worldgenlevel.getBlockState(surfacePos.offset(relativeX, stem, relativeZ)).is(BlockTags.DIRT)) {
								this.safeSetBlock(worldgenlevel, surfacePos.offset(relativeX, stem, relativeZ), TechnologicaBlocks.OILY_COARSE_DIRT.get().defaultBlockState(), predicate);
							} else if (worldgenlevel.getBlockState(surfacePos.offset(relativeX, stem, relativeZ)).is(Blocks.GRAVEL) || worldgenlevel.getBlockState(surfacePos.offset(relativeX, stem, relativeZ)).is(Blocks.STONE)) {
								this.safeSetBlock(worldgenlevel, surfacePos.offset(relativeX, stem, relativeZ), TechnologicaBlocks.OILY_GRAVEL.get().defaultBlockState(), predicate);
							} else if (worldgenlevel.getBlockState(surfacePos.offset(relativeX, stem, relativeZ)).is(Blocks.RED_SAND) || worldgenlevel.getBlockState(surfacePos.offset(relativeX, stem, relativeZ)).is(BlockTags.TERRACOTTA)) {
								this.safeSetBlock(worldgenlevel, surfacePos.offset(relativeX, stem, relativeZ), TechnologicaBlocks.OILY_RED_SAND.get().defaultBlockState(), predicate);
							} else if (worldgenlevel.getBlockState(surfacePos.offset(relativeX, stem, relativeZ)).is(Blocks.SAND) || worldgenlevel.getBlockState(surfacePos.offset(relativeX, stem, relativeZ)).is(Blocks.SANDSTONE)) {
								this.safeSetBlock(worldgenlevel, surfacePos.offset(relativeX, stem, relativeZ), TechnologicaBlocks.OILY_SAND.get().defaultBlockState(), predicate);
							}
						}
					}
				}
			}
		}
		return true;
	}
}