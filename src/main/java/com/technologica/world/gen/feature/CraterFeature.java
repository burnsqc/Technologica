package com.technologica.world.gen.feature;

import java.util.Random;

import com.mojang.serialization.Codec;

import net.minecraft.block.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.SectionPos;
import net.minecraft.world.ISeedReader;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.feature.BlockStateFeatureConfig;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.structure.Structure;

public class CraterFeature extends Feature<BlockStateFeatureConfig> {

	public CraterFeature(Codec<BlockStateFeatureConfig> codec) {
		super(codec);
	}

	public boolean generate(ISeedReader reader, ChunkGenerator generator, Random rand, BlockPos pos, BlockStateFeatureConfig config) {
		pos = pos.up(80);
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
								reader.setBlockState(pos.add(relativeX, relativeY, relativeZ), relativeY >= 5 ? Blocks.AIR.getDefaultState() : Blocks.AIR.getDefaultState(), 2);
								if ((relativeX-8) * (relativeX-8) + (relativeZ-8) * (relativeZ-8) <= 18) {
									reader.setBlockState(pos.add(relativeX, relativeY, relativeZ), relativeY >= 5 ? Blocks.AIR.getDefaultState() : Blocks.AIR.getDefaultState(), 2);
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
