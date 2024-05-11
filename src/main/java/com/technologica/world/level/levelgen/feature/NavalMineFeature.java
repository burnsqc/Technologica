package com.technologica.world.level.levelgen.feature;

import com.technologica.registration.deferred.TechnologicaBlocks;
import com.technologica.world.entity.item.NavalMine;

import net.minecraft.core.BlockPos;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.LevelWriter;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;

public class NavalMineFeature extends Feature<NoneFeatureConfiguration> {
	public NavalMineFeature() {
		super(NoneFeatureConfiguration.CODEC);
	}

	@Override
	protected void setBlock(LevelWriter levelWriter, BlockPos blockPos, BlockState blockState) {
		levelWriter.setBlock(blockPos, blockState, 19);
	}

	@Override
	public boolean place(FeaturePlaceContext<NoneFeatureConfiguration> featurePlaceContext) {
		WorldGenLevel level = featurePlaceContext.level();
		BlockPos origin = featurePlaceContext.origin();
		RandomSource random = featurePlaceContext.random();
		boolean canPlace = true;

		for (BlockPos blockPos : BlockPos.betweenClosed(origin.offset(-2, 0, -2), origin.offset(2, 5, 2))) {
			if (!level.getBlockState(blockPos).is(Blocks.WATER)) {
				canPlace = false;
			}
		}

		if (canPlace) {
			placeNavalMine(level, origin, random);
		}
		return canPlace;
	}

	private void placeNavalMine(WorldGenLevel level, BlockPos origin, RandomSource random) {
		int heightRand = 0;
		boolean clear = true;

		for (int offset = 6; offset < 33; offset++) {
			for (BlockPos blockPos : BlockPos.betweenClosed(origin.offset(-2, offset, -2), origin.offset(2, offset, 2))) {
				if (!level.getBlockState(blockPos).is(Blocks.WATER)) {
					clear = false;
				}
			}
			if (clear) {
				heightRand = offset - 5;
			} else {
				break;
			}
		}

		int heightAdd = 0;
		if (heightRand > 0) {
			heightAdd = random.nextInt(0, heightRand);
		}

		for (int height = 0; height < 3 + heightAdd; height++) {
			level.setBlock(origin.above(height), TechnologicaBlocks.NAVAL_MINE_CHAIN.get().defaultBlockState(), 3);
		}

		NavalMine navalMine = new NavalMine(level.getLevel(), origin.getX() + 0.5, origin.getY() + 2 + heightAdd, origin.getZ() + 0.5, 0);
		level.addFreshEntity(navalMine);
	}
}
