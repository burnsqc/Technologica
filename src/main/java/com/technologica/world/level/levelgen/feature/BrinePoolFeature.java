package com.technologica.world.level.levelgen.feature;

import java.util.Random;

import com.mojang.serialization.Codec;

import net.minecraft.core.BlockPos;
import net.minecraft.core.SectionPos;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import net.minecraft.world.level.levelgen.feature.LakeFeature;
import net.minecraft.world.level.levelgen.feature.StructureFeature;
import net.minecraft.world.level.material.Material;

@SuppressWarnings("deprecation")
public class BrinePoolFeature extends Feature<LakeFeature.Configuration> {
	private static final BlockState AIR = Blocks.CAVE_AIR.defaultBlockState();

	public BrinePoolFeature(Codec<LakeFeature.Configuration> codec) {
		super(codec);
	}

	public boolean place(FeaturePlaceContext<LakeFeature.Configuration> p_159958_) {
		BlockPos pos = p_159958_.origin();
		WorldGenLevel reader = p_159958_.level();
		Random rand = p_159958_.random();
		LakeFeature.Configuration config = p_159958_.config();
		while (pos.getY() > 5 && reader.isEmptyBlock(pos)) {
			pos = pos.below();
		}

		if (pos.getY() <= 4) {
			return false;
		} else {
			pos = pos.below(4);
			if (!reader.startsForFeature(SectionPos.of(pos), StructureFeature.VILLAGE).isEmpty()) {
				return false;
			} else {
				boolean[] aboolean = new boolean[2048];
				int i = rand.nextInt(4) + 4;

				for (int j = 0; j < i; ++j) {
					double d0 = rand.nextDouble() * 6.0D + 3.0D;
					double d1 = rand.nextDouble() * 4.0D + 2.0D;
					double d2 = rand.nextDouble() * 6.0D + 3.0D;
					double d3 = rand.nextDouble() * (16.0D - d0 - 2.0D) + 1.0D + d0 / 2.0D;
					double d4 = rand.nextDouble() * (8.0D - d1 - 4.0D) + 2.0D + d1 / 2.0D;
					double d5 = rand.nextDouble() * (16.0D - d2 - 2.0D) + 1.0D + d2 / 2.0D;

					for (int l = 1; l < 15; ++l) {
						for (int i1 = 1; i1 < 15; ++i1) {
							for (int j1 = 1; j1 < 7; ++j1) {
								double d6 = ((double) l - d3) / (d0 / 2.0D);
								double d7 = ((double) j1 - d4) / (d1 / 2.0D);
								double d8 = ((double) i1 - d5) / (d2 / 2.0D);
								double d9 = d6 * d6 + d7 * d7 + d8 * d8;
								if (d9 < 1.0D) {
									aboolean[(l * 16 + i1) * 8 + j1] = true;
								}
							}
						}
					}
				}

				BlockState blockstate1 = config.fluid().getState(rand, pos);

				for (int k1 = 0; k1 < 16; ++k1) {
					for (int l2 = 0; l2 < 16; ++l2) {
						for (int k = 0; k < 8; ++k) {
							boolean flag = !aboolean[(k1 * 16 + l2) * 8 + k]
									&& (k1 < 15 && aboolean[((k1 + 1) * 16 + l2) * 8 + k]
											|| k1 > 0 && aboolean[((k1 - 1) * 16 + l2) * 8 + k]
											|| l2 < 15 && aboolean[(k1 * 16 + l2 + 1) * 8 + k]
											|| l2 > 0 && aboolean[(k1 * 16 + (l2 - 1)) * 8 + k]
											|| k < 7 && aboolean[(k1 * 16 + l2) * 8 + k + 1]
											|| k > 0 && aboolean[(k1 * 16 + l2) * 8 + (k - 1)]);
							if (flag) {
								Material material = reader.getBlockState(pos.offset(k1, k, l2)).getMaterial();
								if (k >= 4 && material.isLiquid()) {
									return false;
								}

								if (k < 4 && !material.isSolid()
										&& reader.getBlockState(pos.offset(k1, k, l2)) != blockstate1) {
									return false;
								}
							}
						}
					}
				}

				for (int l1 = 0; l1 < 16; ++l1) {
					for (int i3 = 0; i3 < 16; ++i3) {
						for (int i4 = 0; i4 < 8; ++i4) {
							if (aboolean[(l1 * 16 + i3) * 8 + i4]) {
								reader.setBlock(pos.offset(l1, i4, i3), i4 >= 4 ? AIR : blockstate1, 2);
							}
						}
					}
				}

				for (int i2 = 0; i2 < 16; ++i2) {
					for (int j3 = 0; j3 < 16; ++j3) {
						for (int j4 = 4; j4 < 8; ++j4) {
							if (aboolean[(i2 * 16 + j3) * 8 + j4]) {
								BlockPos blockpos1 = pos.offset(i2, j4 - 1, j3);
								if (this.canReplaceBlock(reader.getBlockState(blockpos1))) {
									boolean flag1 = j4 >= 4;
									reader.setBlock(blockpos1, flag1 ? AIR : blockstate1, 2);
									if (flag1) {
										reader.scheduleTick(blockpos1, AIR.getBlock(), 0);
										this.markAboveForPostProcessing(reader, blockpos1);
									}
								}
							}
						}
					}
				}

				if (blockstate1.getMaterial() == Material.LAVA) {
					for (int j2 = 0; j2 < 16; ++j2) {
						for (int k3 = 0; k3 < 16; ++k3) {
							for (int k4 = 0; k4 < 8; ++k4) {
								boolean flag1 = !aboolean[(j2 * 16 + k3) * 8 + k4]
										&& (j2 < 15 && aboolean[((j2 + 1) * 16 + k3) * 8 + k4]
												|| j2 > 0 && aboolean[((j2 - 1) * 16 + k3) * 8 + k4]
												|| k3 < 15 && aboolean[(j2 * 16 + k3 + 1) * 8 + k4]
												|| k3 > 0 && aboolean[(j2 * 16 + (k3 - 1)) * 8 + k4]
												|| k4 < 7 && aboolean[(j2 * 16 + k3) * 8 + k4 + 1]
												|| k4 > 0 && aboolean[(j2 * 16 + k3) * 8 + (k4 - 1)]);
								if (flag1 && (k4 < 4 || rand.nextInt(2) != 0)
										&& reader.getBlockState(pos.offset(j2, k4, k3)).getMaterial().isSolid()) {
									reader.setBlock(pos.offset(j2, k4, k3), Blocks.STONE.defaultBlockState(), 2);
								}
							}
						}
					}
				}

				return true;
			}
		}
	}

	private boolean canReplaceBlock(BlockState p_190952_) {
		return !p_190952_.is(BlockTags.FEATURES_CANNOT_REPLACE);
	}
}