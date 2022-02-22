package com.technologica.item;

import net.minecraft.block.BlockState;
import net.minecraft.block.IGrowable;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.BoneMealItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUseContext;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;

public class FertilizerItem extends BoneMealItem {
	public FertilizerItem(Item.Properties builder) {
		super(builder);
	}

	@Override
	public ActionResultType useOn(ItemUseContext context) {
		World world = context.getLevel();
		BlockPos blockpos = context.getClickedPos();
		BlockPos blockpos1 = blockpos.relative(context.getClickedFace());
		if (applyFertilizer(context.getItemInHand(), world, blockpos, context.getPlayer())) {
			if (!world.isClientSide) {
				world.levelEvent(2005, blockpos, 0);
			}

			return ActionResultType.sidedSuccess(world.isClientSide);
		} else {
			BlockState blockstate = world.getBlockState(blockpos);
			boolean flag = blockstate.isFaceSturdy(world, blockpos, context.getClickedFace());
			if (flag && growWaterPlant(context.getItemInHand(), world, blockpos1, context.getClickedFace())) {
				if (!world.isClientSide) {
					world.levelEvent(2005, blockpos1, 0);
				}

				return ActionResultType.sidedSuccess(world.isClientSide);
			} else {
				return ActionResultType.PASS;
			}
		}
	}

	public static boolean applyFertilizer(ItemStack stack, World worldIn, BlockPos pos, PlayerEntity player) {
		BlockState blockstate = worldIn.getBlockState(pos);

		if (blockstate.getBlock() instanceof IGrowable) {
			for (int i = -4; i < 5; ++i) {
				for (int j = -4; j < 5; ++j) {
					BlockState toGrow = worldIn.getBlockState(pos.offset(i, 0, j));

					if (toGrow.getBlock() instanceof IGrowable) {
						IGrowable igrowable = (IGrowable) toGrow.getBlock();
						if (igrowable.isValidBonemealTarget(worldIn, pos.offset(i, 0, j), toGrow, worldIn.isClientSide)) {
							if (worldIn instanceof ServerWorld) {
								if (igrowable.isBonemealSuccess(worldIn, worldIn.random, pos.offset(i, 0, j), toGrow)) {
									igrowable.performBonemeal((ServerWorld) worldIn, worldIn.random, pos.offset(i, 0, j), toGrow);
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
