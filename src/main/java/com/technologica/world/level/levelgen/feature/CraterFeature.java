package com.technologica.world.level.levelgen.feature;

import java.util.Random;

import com.mojang.serialization.Codec;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.chunk.ChunkGenerator;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import net.minecraft.world.level.levelgen.feature.configurations.BlockStateConfiguration;

public class CraterFeature extends Feature<BlockStateConfiguration> {

	public CraterFeature(Codec<BlockStateConfiguration> codec) {
		super(codec);
	}

	public boolean place(WorldGenLevel reader, ChunkGenerator generator, Random rand, BlockPos pos, BlockStateConfiguration config) {
		pos = pos.above(80);
		while (pos.getY() > 5 && reader.isEmptyBlock(pos)) {
			pos = pos.below();
		}

		if (pos.getY() <= 4) {
			return false;
		} else {
			pos = pos.below(4);
			boolean[] aboolean = new boolean[2048];
			int i = rand.nextInt(4) + 4;
			for (int j = 0; j < i; ++j) {
				for (int relativeX = 1; relativeX < 15; ++relativeX) {
					for (int relativeZ = 1; relativeZ < 15; ++relativeZ) {
						for (int relativeY = 1; relativeY < 15; ++relativeY) {
							double d6 = ((double) relativeX - 10.5D) / 4.5D;
							double d7 = ((double) relativeY - 10.5D) / 4.5D;
							double d8 = ((double) relativeZ - 10.5D) / 4.5D;
							double d9 = d6 * d6 + d7 * d7 + d8 * d8;
							if (d9 < 1.0D) {
								aboolean[(relativeX * 16 + relativeZ) * 8 + relativeY] = true;
							}
						}
					}
				}
			}

			for (int relativeX = 0; relativeX < 16; ++relativeX) {
				for (int relativeZ = 0; relativeZ < 16; ++relativeZ) {
					for (int relativeY = 0; relativeY < 16; ++relativeY) {
						
						if ((relativeY-8) * (relativeY-8) + (relativeX-8) * (relativeX-8) + (relativeZ-8) * (relativeZ-8) <= 50) {
							reader.setBlock(pos.offset(relativeX, relativeY, relativeZ), relativeY >= 5 ? Blocks.AIR.defaultBlockState() : Blocks.AIR.defaultBlockState(), 2);
							if ((relativeX-8) * (relativeX-8) + (relativeZ-8) * (relativeZ-8) <= 18) {
								reader.setBlock(pos.offset(relativeX, relativeY, relativeZ), relativeY >= 5 ? Blocks.AIR.defaultBlockState() : Blocks.AIR.defaultBlockState(), 2);
							}
						} 
						
					}
				}
			}	
			
			return true;
		}
	}

	@Override
	public boolean place(FeaturePlaceContext<BlockStateConfiguration> p_159749_) {
		// TODO Auto-generated method stub
		return false;
	}
}
