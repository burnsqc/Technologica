package com.technologica.world.level.block;

import java.util.Random;
import java.util.function.Supplier;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.HorizontalDirectionalBlock;
import net.minecraft.world.level.block.StemBlock;
import net.minecraft.world.level.block.StemGrownBlock;
import net.minecraft.world.level.block.state.BlockState;

public class GourdStemBlock extends StemBlock {
	private final StemGrownBlock fruit;

	public GourdStemBlock(StemGrownBlock p_154728_, Supplier<Item> p_154729_, Properties p_154730_) {
		super(p_154728_, p_154729_, p_154730_);
		this.fruit = p_154728_;
	}

	@SuppressWarnings("deprecation")
	@Override
	public void randomTick(BlockState p_57042_, ServerLevel p_57043_, BlockPos p_57044_, Random p_57045_) {
		if (!p_57043_.isAreaLoaded(p_57044_, 1))
			return;
		if (p_57043_.getRawBrightness(p_57044_, 0) >= 9) {
			float f = getGrowthSpeed(this, p_57043_, p_57044_);
			if (net.minecraftforge.common.ForgeHooks.onCropsGrowPre(p_57043_, p_57044_, p_57042_, p_57045_.nextInt((int) (25.0F / f) + 1) == 0)) {
				int i = p_57042_.getValue(AGE);
				if (i < 7) {
					p_57043_.setBlock(p_57044_, p_57042_.setValue(AGE, Integer.valueOf(i + 1)), 2);
				} else {
					Direction direction = Direction.Plane.HORIZONTAL.getRandomDirection(p_57045_);
					BlockPos blockpos = p_57044_.relative(direction);
					BlockState blockstate = p_57043_.getBlockState(blockpos.below());
					Block block = blockstate.getBlock();
					if (p_57043_.isEmptyBlock(blockpos) && (blockstate.canSustainPlant(p_57043_, blockpos.below(), Direction.UP, this) || block == Blocks.FARMLAND || block == Blocks.DIRT || block == Blocks.COARSE_DIRT || block == Blocks.PODZOL || block == Blocks.GRASS_BLOCK)) {
						p_57043_.setBlockAndUpdate(blockpos, this.fruit.defaultBlockState().setValue(GourdCropBlock.NESW_FACING, direction));
						p_57043_.setBlockAndUpdate(p_57044_, this.fruit.getAttachedStem().defaultBlockState().setValue(HorizontalDirectionalBlock.FACING, direction));
					}
				}
				net.minecraftforge.common.ForgeHooks.onCropsGrowPost(p_57043_, p_57044_, p_57042_);
			}

		}
	}

	protected static float getGrowthSpeed(Block p_52273_, BlockGetter p_52274_, BlockPos p_52275_) {
		float f = 1.0F;
		BlockPos blockpos = p_52275_.below();

		for (int i = -1; i <= 1; ++i) {
			for (int j = -1; j <= 1; ++j) {
				float f1 = 0.0F;
				BlockState blockstate = p_52274_.getBlockState(blockpos.offset(i, 0, j));
				if (blockstate.canSustainPlant(p_52274_, blockpos.offset(i, 0, j), net.minecraft.core.Direction.UP, (net.minecraftforge.common.IPlantable) p_52273_)) {
					f1 = 1.0F;
					if (blockstate.isFertile(p_52274_, p_52275_.offset(i, 0, j))) {
						f1 = 3.0F;
					}
				}

				if (i != 0 || j != 0) {
					f1 /= 4.0F;
				}

				f += f1;
			}
		}

		BlockPos blockpos1 = p_52275_.north();
		BlockPos blockpos2 = p_52275_.south();
		BlockPos blockpos3 = p_52275_.west();
		BlockPos blockpos4 = p_52275_.east();
		boolean flag = p_52274_.getBlockState(blockpos3).is(p_52273_) || p_52274_.getBlockState(blockpos4).is(p_52273_);
		boolean flag1 = p_52274_.getBlockState(blockpos1).is(p_52273_) || p_52274_.getBlockState(blockpos2).is(p_52273_);
		if (flag && flag1) {
			f /= 2.0F;
		} else {
			boolean flag2 = p_52274_.getBlockState(blockpos3.north()).is(p_52273_) || p_52274_.getBlockState(blockpos4.north()).is(p_52273_) || p_52274_.getBlockState(blockpos4.south()).is(p_52273_) || p_52274_.getBlockState(blockpos3.south()).is(p_52273_);
			if (flag2) {
				f /= 2.0F;
			}
		}

		return f;
	}

}
