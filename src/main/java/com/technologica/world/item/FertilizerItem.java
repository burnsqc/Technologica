package com.technologica.world.item;

import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.BoneMealItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.BonemealableBlock;
import net.minecraft.world.level.block.state.BlockState;

public class FertilizerItem extends BoneMealItem {
	public FertilizerItem(Item.Properties builder) {
		super(builder);
	}

	@Override
	public InteractionResult useOn(UseOnContext context) {
		Level world = context.getLevel();
		BlockPos blockpos = context.getClickedPos();
		BlockPos blockpos1 = blockpos.relative(context.getClickedFace());
		if (applyFertilizer(context.getItemInHand(), world, blockpos, context.getPlayer())) {
			if (!world.isClientSide) {
				world.levelEvent(2005, blockpos, 0);
			}

			return InteractionResult.sidedSuccess(world.isClientSide);
		} else {
			BlockState blockstate = world.getBlockState(blockpos);
			boolean flag = blockstate.isFaceSturdy(world, blockpos, context.getClickedFace());
			if (flag && growWaterPlant(context.getItemInHand(), world, blockpos1, context.getClickedFace())) {
				if (!world.isClientSide) {
					world.levelEvent(2005, blockpos1, 0);
				}

				return InteractionResult.sidedSuccess(world.isClientSide);
			} else {
				return InteractionResult.PASS;
			}
		}
	}

	public static boolean applyFertilizer(ItemStack stack, Level worldIn, BlockPos pos, Player player) {
		BlockState blockstate = worldIn.getBlockState(pos);

		if (blockstate.getBlock() instanceof BonemealableBlock) {
			for (int i = -4; i < 5; ++i) {
				for (int j = -4; j < 5; ++j) {
					BlockState toGrow = worldIn.getBlockState(pos.offset(i, 0, j));

					if (toGrow.getBlock() instanceof BonemealableBlock) {
						BonemealableBlock igrowable = (BonemealableBlock) toGrow.getBlock();
						if (igrowable.isValidBonemealTarget(worldIn, pos.offset(i, 0, j), toGrow, worldIn.isClientSide)) {
							if (worldIn instanceof ServerLevel) {
								if (igrowable.isBonemealSuccess(worldIn, worldIn.random, pos.offset(i, 0, j), toGrow)) {
									igrowable.performBonemeal((ServerLevel) worldIn, worldIn.random, pos.offset(i, 0, j), toGrow);
								}

							}
						}
					}
				}
			}
			stack.shrink(1);
			return true;
		}
		return false;
	}
}
