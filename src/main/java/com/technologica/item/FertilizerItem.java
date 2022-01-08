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
	public ActionResultType onItemUse(ItemUseContext context) {
		World world = context.getWorld();
		BlockPos blockpos = context.getPos();
		BlockPos blockpos1 = blockpos.offset(context.getFace());
		if (applyFertilizer(context.getItem(), world, blockpos, context.getPlayer())) {
			if (!world.isRemote) {
				world.playEvent(2005, blockpos, 0);
			}

			return ActionResultType.func_233537_a_(world.isRemote);
		} else {
			BlockState blockstate = world.getBlockState(blockpos);
			boolean flag = blockstate.isSolidSide(world, blockpos, context.getFace());
			if (flag && growSeagrass(context.getItem(), world, blockpos1, context.getFace())) {
				if (!world.isRemote) {
					world.playEvent(2005, blockpos1, 0);
				}

				return ActionResultType.func_233537_a_(world.isRemote);
			} else {
				return ActionResultType.PASS;
			}
		}
	}

	public static boolean applyFertilizer(ItemStack stack, World worldIn, BlockPos pos, PlayerEntity player) {
		BlockState blockstate = worldIn.getBlockState(pos);

		if (blockstate.getBlock() instanceof IGrowable) {
			for (int i = -9; i < 10; ++i) {
				for (int j = -9; j < 10; ++j) {
					BlockState toGrow = worldIn.getBlockState(pos.add(i, 0, j));

					if (toGrow.getBlock() instanceof IGrowable) {
						IGrowable igrowable = (IGrowable) toGrow.getBlock();
						if (igrowable.canGrow(worldIn, pos.add(i, 0, j), toGrow, worldIn.isRemote)) {
							if (worldIn instanceof ServerWorld) {
								if (igrowable.canUseBonemeal(worldIn, worldIn.rand, pos.add(i, 0, j), toGrow)) {
									igrowable.grow((ServerWorld) worldIn, worldIn.rand, pos.add(i, 0, j), toGrow);
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
