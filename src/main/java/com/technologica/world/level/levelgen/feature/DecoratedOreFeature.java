package com.technologica.world.level.levelgen.feature;

import java.util.BitSet;
import java.util.Collection;
import java.util.Iterator;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

import com.mojang.serialization.Codec;
import com.technologica.world.level.block.TwentyFourDirectionBlock;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.SectionPos;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.DirectionalBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.chunk.BulkSectionAccess;
import net.minecraft.world.level.chunk.LevelChunkSection;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration;
import net.minecraft.world.level.material.Fluids;

public class DecoratedOreFeature extends Feature<OreConfiguration> {
	private Supplier<Block> crystal;

	public DecoratedOreFeature(Codec<OreConfiguration> p_66531_, Supplier<Block> crystalIn) {
		super(p_66531_);
		this.crystal = crystalIn;
	}

	@Override
	public boolean place(FeaturePlaceContext<OreConfiguration> p_160177_) {
		RandomSource randomsource = p_160177_.random();
		BlockPos blockpos = p_160177_.origin();
		WorldGenLevel worldgenlevel = p_160177_.level();
		OreConfiguration oreconfiguration = p_160177_.config();
		float f = randomsource.nextFloat() * (float) Math.PI;
		float f1 = oreconfiguration.size / 8.0F;
		int i = Mth.ceil((oreconfiguration.size / 16.0F * 2.0F + 1.0F) / 2.0F);
		double d0 = blockpos.getX() + Math.sin(f) * f1;
		double d1 = blockpos.getX() - Math.sin(f) * f1;
		double d2 = blockpos.getZ() + Math.cos(f) * f1;
		double d3 = blockpos.getZ() - Math.cos(f) * f1;
		double d4 = blockpos.getY() + randomsource.nextInt(3) - 2;
		double d5 = blockpos.getY() + randomsource.nextInt(3) - 2;
		int k = blockpos.getX() - Mth.ceil(f1) - i;
		int l = blockpos.getY() - 2 - i;
		int i1 = blockpos.getZ() - Mth.ceil(f1) - i;
		int j1 = 2 * (Mth.ceil(f1) + i);
		int k1 = 2 * (2 + i);

		for (int l1 = k; l1 <= k + j1; ++l1) {
			for (int i2 = i1; i2 <= i1 + j1; ++i2) {
				if (l <= worldgenlevel.getHeight(Heightmap.Types.OCEAN_FLOOR_WG, l1, i2)) {
					return this.doPlace(worldgenlevel, randomsource, oreconfiguration, d0, d1, d2, d3, d4, d5, k, l, i1, j1, k1);
				}
			}
		}

		return false;
	}

	protected boolean doPlace(WorldGenLevel p_225172_, RandomSource p_225173_, OreConfiguration p_225174_, double p_225175_, double p_225176_, double p_225177_, double p_225178_, double p_225179_, double p_225180_, int p_225181_, int p_225182_, int p_225183_, int p_225184_, int p_225185_) {
		int i = 0;
		BitSet bitset = new BitSet(p_225184_ * p_225185_ * p_225184_);
		BlockPos.MutableBlockPos blockpos$mutableblockpos = new BlockPos.MutableBlockPos();
		int j = p_225174_.size;
		double[] adouble = new double[j * 4];

		for (int k = 0; k < j; ++k) {
			float f = (float) k / (float) j;
			double d0 = Mth.lerp(f, p_225175_, p_225176_);
			double d1 = Mth.lerp(f, p_225179_, p_225180_);
			double d2 = Mth.lerp(f, p_225177_, p_225178_);
			double d3 = p_225173_.nextDouble() * j / 16.0D;
			double d4 = ((Mth.sin((float) Math.PI * f) + 1.0F) * d3 + 1.0D) / 2.0D;
			adouble[k * 4 + 0] = d0;
			adouble[k * 4 + 1] = d1;
			adouble[k * 4 + 2] = d2;
			adouble[k * 4 + 3] = d4;
		}

		for (int l3 = 0; l3 < j - 1; ++l3) {
			if (!(adouble[l3 * 4 + 3] <= 0.0D)) {
				for (int i4 = l3 + 1; i4 < j; ++i4) {
					if (!(adouble[i4 * 4 + 3] <= 0.0D)) {
						double d8 = adouble[l3 * 4 + 0] - adouble[i4 * 4 + 0];
						double d10 = adouble[l3 * 4 + 1] - adouble[i4 * 4 + 1];
						double d12 = adouble[l3 * 4 + 2] - adouble[i4 * 4 + 2];
						double d14 = adouble[l3 * 4 + 3] - adouble[i4 * 4 + 3];
						if (d14 * d14 > d8 * d8 + d10 * d10 + d12 * d12) {
							if (d14 > 0.0D) {
								adouble[i4 * 4 + 3] = -1.0D;
							} else {
								adouble[l3 * 4 + 3] = -1.0D;
							}
						}
					}
				}
			}
		}

		BulkSectionAccess bulksectionaccess = new BulkSectionAccess(p_225172_);

		try {
			for (int j4 = 0; j4 < j; ++j4) {
				double d9 = adouble[j4 * 4 + 3];
				if (!(d9 < 0.0D)) {
					double d11 = adouble[j4 * 4 + 0];
					double d13 = adouble[j4 * 4 + 1];
					double d15 = adouble[j4 * 4 + 2];
					int k4 = Math.max(Mth.floor(d11 - d9), p_225181_);
					int l = Math.max(Mth.floor(d13 - d9), p_225182_);
					int i1 = Math.max(Mth.floor(d15 - d9), p_225183_);
					int j1 = Math.max(Mth.floor(d11 + d9), k4);
					int k1 = Math.max(Mth.floor(d13 + d9), l);
					int l1 = Math.max(Mth.floor(d15 + d9), i1);

					for (int i2 = k4; i2 <= j1; ++i2) {
						double d5 = (i2 + 0.5D - d11) / d9;
						if (d5 * d5 < 1.0D) {
							for (int j2 = l; j2 <= k1; ++j2) {
								double d6 = (j2 + 0.5D - d13) / d9;
								if (d5 * d5 + d6 * d6 < 1.0D) {
									for (int k2 = i1; k2 <= l1; ++k2) {
										double d7 = (k2 + 0.5D - d15) / d9;
										if (d5 * d5 + d6 * d6 + d7 * d7 < 1.0D && !p_225172_.isOutsideBuildHeight(j2)) {
											int l2 = i2 - p_225181_ + (j2 - p_225182_) * p_225184_ + (k2 - p_225183_) * p_225184_ * p_225185_;
											if (!bitset.get(l2)) {
												bitset.set(l2);
												blockpos$mutableblockpos.set(i2, j2, k2);
												if (p_225172_.ensureCanWrite(blockpos$mutableblockpos)) {
													LevelChunkSection levelchunksection = bulksectionaccess.getSection(blockpos$mutableblockpos);
													if (levelchunksection != null) {
														int i3 = SectionPos.sectionRelative(i2);
														int j3 = SectionPos.sectionRelative(j2);
														int k3 = SectionPos.sectionRelative(k2);
														BlockState blockstate = levelchunksection.getBlockState(i3, j3, k3);

														for (OreConfiguration.TargetBlockState oreconfiguration$targetblockstate : p_225174_.targetStates) {
															if (canPlaceOre(blockstate, bulksectionaccess::getBlockState, p_225173_, p_225174_, oreconfiguration$targetblockstate, blockpos$mutableblockpos)) {
																levelchunksection.setBlockState(i3, j3, k3, oreconfiguration$targetblockstate.state, false);

																BlockPos.MutableBlockPos blockpos$mutableblockpos2 = new BlockPos.MutableBlockPos();
																Predicate<BlockState> airPredicate = BlockBehaviour.BlockStateBase::isAir;

																Function<BlockPos, BlockState> fun = bulksectionaccess::getBlockState;
																for (Direction direction : Direction.values()) {
																	blockpos$mutableblockpos2.setWithOffset(blockpos$mutableblockpos, direction);
																	if (airPredicate.test(fun.apply(blockpos$mutableblockpos2))) {
																		if (isAdjacentToAir(fun, blockpos$mutableblockpos2)) {
																			levelchunksection.setBlockState(SectionPos.sectionRelative(blockpos$mutableblockpos2.getX()), SectionPos.sectionRelative(blockpos$mutableblockpos2.getY()), SectionPos.sectionRelative(blockpos$mutableblockpos2.getZ()), crystal.get().defaultBlockState().setValue(DirectionalBlock.FACING, direction).setValue(TwentyFourDirectionBlock.SUB_FACING, (Direction) this.selectRandom(TwentyFourDirectionBlock.SUB_FACING.getPossibleValues())), false);
																		}
																	} else if (levelchunksection.getBlockState(SectionPos.sectionRelative(blockpos$mutableblockpos2.getX()), SectionPos.sectionRelative(blockpos$mutableblockpos2.getY()), SectionPos.sectionRelative(blockpos$mutableblockpos2.getZ())).getFluidState().is(Fluids.WATER)) {
																		levelchunksection.setBlockState(SectionPos.sectionRelative(blockpos$mutableblockpos2.getX()), SectionPos.sectionRelative(blockpos$mutableblockpos2.getY()), SectionPos.sectionRelative(blockpos$mutableblockpos2.getZ()), crystal.get().defaultBlockState().setValue(DirectionalBlock.FACING, direction).setValue(TwentyFourDirectionBlock.SUB_FACING, (Direction) this.selectRandom(TwentyFourDirectionBlock.SUB_FACING.getPossibleValues())).setValue(TwentyFourDirectionBlock.WATERLOGGED, true), false);
																	}
																}

																++i;
																break;
															}
														}
													}
												}
											}
										}
									}
								}
							}
						}
					}
				}
			}
		} catch (Throwable throwable1) {
			try {
				bulksectionaccess.close();
			} catch (Throwable throwable) {
				throwable1.addSuppressed(throwable);
			}

			throw throwable1;
		}

		bulksectionaccess.close();
		return i > 0;
	}

	public static boolean canPlaceOre(BlockState p_225187_, Function<BlockPos, BlockState> p_225188_, RandomSource p_225189_, OreConfiguration p_225190_, OreConfiguration.TargetBlockState p_225191_, BlockPos.MutableBlockPos p_225192_) {
		if (!p_225191_.target.test(p_225187_, p_225189_)) {
			return false;
		} else if (shouldSkipAirCheck(p_225189_, p_225190_.discardChanceOnAirExposure)) {
			return true;
		} else {
			return !isAdjacentToAir(p_225188_, p_225192_);
		}
	}

	protected static boolean shouldSkipAirCheck(RandomSource p_225169_, float p_225170_) {
		if (p_225170_ <= 0.0F) {
			return true;
		} else if (p_225170_ >= 1.0F) {
			return false;
		} else {
			return p_225169_.nextFloat() >= p_225170_;
		}
	}

	public Object selectRandom(Collection<?> set) {
		int random = (int) (Math.random() * set.size());
		Iterator<?> iterator = set.iterator();
		Object randomNode = null;
		for (int i = 0; i <= random && iterator.hasNext(); i++) {
			randomNode = iterator.next();
		}
		return randomNode;
	}
}