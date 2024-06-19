package com.technologica.world.level.levelgen.feature;

import net.minecraft.core.BlockPos;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.KelpBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;

public class DeepKelpFeature extends Feature<NoneFeatureConfiguration> {
	public DeepKelpFeature() {
		super(NoneFeatureConfiguration.CODEC);
	}

	@Override
	public boolean place(FeaturePlaceContext<NoneFeatureConfiguration> p_159956_) {
		int i = 0;
		WorldGenLevel worldgenlevel = p_159956_.level();
		BlockPos blockpos = p_159956_.origin();
		RandomSource randomsource = p_159956_.random();
		if (worldgenlevel.getBlockState(blockpos).is(Blocks.WATER)) {
			BlockState blockstate = Blocks.KELP.defaultBlockState();
			BlockState blockstate1 = Blocks.KELP_PLANT.defaultBlockState();
			int k = 1 + randomsource.nextInt(20);
			for (int l = 0; l <= k; ++l) {
				if (worldgenlevel.getBlockState(blockpos).is(Blocks.WATER) && worldgenlevel.getBlockState(blockpos.above()).is(Blocks.WATER) && blockstate1.canSurvive(worldgenlevel, blockpos)) {
					if (l == k) {
						worldgenlevel.setBlock(blockpos, blockstate.setValue(KelpBlock.AGE, Integer.valueOf(randomsource.nextInt(4) + 20)), 2);
						++i;
					} else {
						worldgenlevel.setBlock(blockpos, blockstate1, 2);
					}
				} else if (l > 0) {
					BlockPos blockpos2 = blockpos.below();
					if (blockstate.canSurvive(worldgenlevel, blockpos2) && !worldgenlevel.getBlockState(blockpos2.below()).is(Blocks.KELP)) {
						worldgenlevel.setBlock(blockpos2, blockstate.setValue(KelpBlock.AGE, Integer.valueOf(randomsource.nextInt(4) + 20)), 2);
						++i;
					}
					break;
				}
				blockpos = blockpos.above();
			}
		}
		return i > 0;
	}
}
