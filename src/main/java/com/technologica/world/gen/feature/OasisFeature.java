package com.technologica.world.gen.feature;

import java.util.Random;

import com.mojang.serialization.Codec;

import net.minecraft.block.Blocks;
import net.minecraft.block.material.Material;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.SectionPos;
import net.minecraft.world.ISeedReader;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.feature.BlockStateFeatureConfig;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.Features;
import net.minecraft.world.gen.feature.structure.Structure;

public class OasisFeature extends Feature<BlockStateFeatureConfig> {

	public OasisFeature(Codec<BlockStateFeatureConfig> p_i231968_1_) {
		super(p_i231968_1_);
	}

	public boolean generate(ISeedReader reader, ChunkGenerator generator, Random rand, BlockPos pos, BlockStateFeatureConfig config) {
		while (pos.getY() > 5 && reader.isAirBlock(pos)) {
			pos = pos.down();
		}

		if (pos.getY() <= 4) {
			return false;
		} else {
			pos = pos.down(4);
			if (reader.func_241827_a(SectionPos.from(pos), Structure.VILLAGE).findAny().isPresent()) {
				return false;
			} else {
				boolean[] aboolean = new boolean[2048];
				int i = rand.nextInt(4) + 4;
				for (int j = 0; j < i; ++j) {
					for (int relativeX = 1; relativeX < 15; ++relativeX) {
						for (int relativeZ = 1; relativeZ < 15; ++relativeZ) {
							for (int relativeY = 1; relativeY < 15; ++relativeY) {
								double d6 = ((double) relativeX - 10.5D) / 4.5D;
								double d7 = ((double) relativeY - 3.5D) / 4.5D;
								double d8 = ((double) relativeZ - 10.5D) / 4.5D;
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
							boolean flag = !aboolean[(k1 * 16 + l2) * 8 + k]
									&& (k1 < 15 && aboolean[((k1 + 1) * 16 + l2) * 8 + k]
											|| k1 > 0 && aboolean[((k1 - 1) * 16 + l2) * 8 + k]
											|| l2 < 15 && aboolean[(k1 * 16 + l2 + 1) * 8 + k]
											|| l2 > 0 && aboolean[(k1 * 16 + (l2 - 1)) * 8 + k]
											|| k < 7 && aboolean[(k1 * 16 + l2) * 8 + k + 1]
											|| k > 0 && aboolean[(k1 * 16 + l2) * 8 + (k - 1)]);
							if (flag) {
								Material material = reader.getBlockState(pos.add(k1, k, l2)).getMaterial();
								if (k >= 4 && material.isLiquid()) {
									return false;
								}
								if (k < 4 && !material.isSolid() && reader.getBlockState(pos.add(k1, k, l2)) != config.state) {
									return false;
								}
							}
						}
					}
				}

				for (int relativeX = 0; relativeX < 16; ++relativeX) {
					for (int relativeZ = 0; relativeZ < 16; ++relativeZ) {
						for (int relativeY = 3; relativeY < 16; ++relativeY) {
							if (relativeY == 3 && (relativeX-8) * (relativeX-8) + (relativeZ-8) * (relativeZ-8) <= 36) {
								reader.setBlockState(pos.add(relativeX, relativeY, relativeZ), Blocks.DIRT.getDefaultState(), 2);
							} else if (relativeY >= 4 && (relativeX-8) * (relativeX-8) + (relativeZ-8) * (relativeZ-8) <= 50) {
								reader.setBlockState(pos.add(relativeX, relativeY, relativeZ), relativeY >= 5 ? Blocks.AIR.getDefaultState() : Blocks.GRASS_BLOCK.getDefaultState(), 2);
								if ((relativeX-8) * (relativeX-8) + (relativeZ-8) * (relativeZ-8) <= 18) {
									reader.setBlockState(pos.add(relativeX, relativeY, relativeZ), relativeY >= 5 ? Blocks.AIR.getDefaultState() : Blocks.WATER.getDefaultState(), 2);
								}
							} 
							
						}
					}
				}	
				
				for (int relativeX = 0; relativeX < 16; ++relativeX) {
					for (int relativeZ = 0; relativeZ < 16; ++relativeZ) {
						if (reader.getBlockState(pos.add(relativeX, 4, relativeZ)).isIn(Blocks.GRASS_BLOCK)) {
							if (rand.nextInt(30) == 0) {
								if (rand.nextBoolean() == true) {
									ModFeatures.LEMON_TREE_FEATURE.generate(reader, generator, rand, pos.add(relativeX, 5, relativeZ)); 
								} else {
									ModFeatures.LIME_TREE_FEATURE.generate(reader, generator, rand, pos.add(relativeX, 5, relativeZ));
								}
							} else if (reader.getBlockState(pos.add(relativeX + 1, 4, relativeZ)).isIn(Blocks.WATER) 
									|| reader.getBlockState(pos.add(relativeX - 1, 4, relativeZ)).isIn(Blocks.WATER) 
									|| reader.getBlockState(pos.add(relativeX, 4, relativeZ + 1)).isIn(Blocks.WATER)
									|| reader.getBlockState(pos.add(relativeX, 4, relativeZ - 1)).isIn(Blocks.WATER)) {
								Features.PATCH_SUGAR_CANE_DESERT.generate(reader, generator, rand, pos.add(relativeX, 5, relativeZ));
							} else if (reader.getBlockState(pos.add(relativeX + 1, 5, relativeZ)).isIn(Blocks.AIR)) {						
								if (rand.nextInt(4) == 0) {
									reader.setBlockState(pos.add(relativeX, 5, relativeZ), Blocks.GRASS.getDefaultState(), 2);
								} else if (rand.nextInt(4) == 1) {
									reader.setBlockState(pos.add(relativeX, 5, relativeZ), Blocks.POPPY.getDefaultState(), 2);
								} else if (rand.nextInt(4) == 2) {
									reader.setBlockState(pos.add(relativeX, 5, relativeZ), Blocks.BLUE_ORCHID.getDefaultState(), 2);
								} else {
									reader.setBlockState(pos.add(relativeX, 5, relativeZ), Blocks.POPPY.getDefaultState(), 2);
								}
							}
						}
					}
				}	
				return true;
			}
		}
	}
}
