package com.technologica.world.level.levelgen.feature;

import com.mojang.serialization.Codec;
import com.technologica.data.worldgen.features.TechnologicaTreeFeatures;

import net.minecraft.core.BlockPos;
import net.minecraft.data.worldgen.features.VegetationFeatures;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import net.minecraft.world.level.levelgen.feature.configurations.BlockStateConfiguration;
import net.minecraft.world.level.material.Material;

public class OasisFeature extends Feature<BlockStateConfiguration> {

	public OasisFeature(Codec<BlockStateConfiguration> codec) {
		super(codec);
	}

	@Override
	public boolean place(FeaturePlaceContext<BlockStateConfiguration> p_159958_) {
		BlockPos blockpos = p_159958_.origin();
		WorldGenLevel worldgenlevel = p_159958_.level();
		RandomSource RandomSource = p_159958_.random();
		BlockStateConfiguration lakefeature$configuration = p_159958_.config();
		while (blockpos.getY() > 5 && worldgenlevel.isEmptyBlock(blockpos)) {
			blockpos = blockpos.below();
		}

		if (blockpos.getY() <= 4) {
			return false;
		} else {
			blockpos = blockpos.below(4);
			boolean[] aboolean = new boolean[2048];
			int i = RandomSource.nextInt(4) + 4;
			for (int j = 0; j < i; ++j) {
				for (int relativeX = 1; relativeX < 15; ++relativeX) {
					for (int relativeZ = 1; relativeZ < 15; ++relativeZ) {
						for (int relativeY = 1; relativeY < 15; ++relativeY) {
							double d6 = (relativeX - 10.5D) / 4.5D;
							double d7 = (relativeY - 3.5D) / 4.5D;
							double d8 = (relativeZ - 10.5D) / 4.5D;
							double d9 = d6 * d6 + d7 * d7 + d8 * d8;
							if (d9 < 1.0D) {
								aboolean[(relativeX * 16 + relativeZ) * 8 + relativeY] = true;
							}
						}
					}
				}
			}

			for (int k1 = 0; k1 < 16; ++k1) {
				for (int l2 = 0; l2 < 16; ++l2) {
					for (int k = 0; k < 8; ++k) {
						boolean flag = !aboolean[(k1 * 16 + l2) * 8 + k] && (k1 < 15 && aboolean[((k1 + 1) * 16 + l2) * 8 + k] || k1 > 0 && aboolean[((k1 - 1) * 16 + l2) * 8 + k] || l2 < 15 && aboolean[(k1 * 16 + l2 + 1) * 8 + k] || l2 > 0 && aboolean[(k1 * 16 + (l2 - 1)) * 8 + k] || k < 7 && aboolean[(k1 * 16 + l2) * 8 + k + 1] || k > 0 && aboolean[(k1 * 16 + l2) * 8 + (k - 1)]);
						if (flag) {
							Material material = worldgenlevel.getBlockState(blockpos.offset(k1, k, l2)).getMaterial();
							if (k >= 4 && material.isLiquid()) {
								return false;
							}
							if (k < 4 && !material.isSolid() && worldgenlevel.getBlockState(blockpos.offset(k1, k, l2)) != lakefeature$configuration.state) {
								return false;
							}
						}
					}
				}
			}

			for (int relativeX = 0; relativeX < 16; ++relativeX) {
				for (int relativeZ = 0; relativeZ < 16; ++relativeZ) {
					for (int relativeY = 3; relativeY < 16; ++relativeY) {
						if (relativeY == 3 && (relativeX - 8) * (relativeX - 8) + (relativeZ - 8) * (relativeZ - 8) <= 36) {
							worldgenlevel.setBlock(blockpos.offset(relativeX, relativeY, relativeZ), Blocks.DIRT.defaultBlockState(), 2);
						} else if (relativeY >= 4 && (relativeX - 8) * (relativeX - 8) + (relativeZ - 8) * (relativeZ - 8) <= 50) {
							worldgenlevel.setBlock(blockpos.offset(relativeX, relativeY, relativeZ), relativeY >= 5 ? Blocks.AIR.defaultBlockState() : Blocks.GRASS_BLOCK.defaultBlockState(), 2);
							if ((relativeX - 8) * (relativeX - 8) + (relativeZ - 8) * (relativeZ - 8) <= 18) {
								worldgenlevel.setBlock(blockpos.offset(relativeX, relativeY, relativeZ), relativeY >= 5 ? Blocks.AIR.defaultBlockState() : Blocks.WATER.defaultBlockState(), 2);
							}
						}

					}
				}
			}

			for (int relativeX = 0; relativeX < 16; ++relativeX) {
				for (int relativeZ = 0; relativeZ < 16; ++relativeZ) {
					if (worldgenlevel.getBlockState(blockpos.offset(relativeX, 4, relativeZ)).is(Blocks.GRASS_BLOCK)) {
						if (RandomSource.nextInt(30) == 0) {
							if (RandomSource.nextBoolean()) {
								TechnologicaTreeFeatures.LEMON.value().place(worldgenlevel, p_159958_.chunkGenerator(), RandomSource, blockpos.offset(relativeX, 5, relativeZ));
							} else {
								TechnologicaTreeFeatures.LIME.value().place(worldgenlevel, p_159958_.chunkGenerator(), RandomSource, blockpos.offset(relativeX, 5, relativeZ));
							}
						} else if (worldgenlevel.getBlockState(blockpos.offset(relativeX + 1, 4, relativeZ)).is(Blocks.WATER) || worldgenlevel.getBlockState(blockpos.offset(relativeX - 1, 4, relativeZ)).is(Blocks.WATER) || worldgenlevel.getBlockState(blockpos.offset(relativeX, 4, relativeZ + 1)).is(Blocks.WATER) || worldgenlevel.getBlockState(blockpos.offset(relativeX, 4, relativeZ - 1)).is(Blocks.WATER)) {
							VegetationFeatures.PATCH_SUGAR_CANE.value().place(worldgenlevel, p_159958_.chunkGenerator(), RandomSource, blockpos.offset(relativeX, 5, relativeZ));
						} else if (worldgenlevel.getBlockState(blockpos.offset(relativeX + 1, 5, relativeZ)).is(Blocks.AIR)) {
							if (RandomSource.nextInt(4) == 0) {
								worldgenlevel.setBlock(blockpos.offset(relativeX, 5, relativeZ), Blocks.GRASS.defaultBlockState(), 2);
							} else if (RandomSource.nextInt(4) == 1) {
								worldgenlevel.setBlock(blockpos.offset(relativeX, 5, relativeZ), Blocks.POPPY.defaultBlockState(), 2);
							} else if (RandomSource.nextInt(4) == 2) {
								worldgenlevel.setBlock(blockpos.offset(relativeX, 5, relativeZ), Blocks.BLUE_ORCHID.defaultBlockState(), 2);
							} else {
								worldgenlevel.setBlock(blockpos.offset(relativeX, 5, relativeZ), Blocks.POPPY.defaultBlockState(), 2);
							}
						}
					}
				}
			}
			return true;
		}
	}
}
