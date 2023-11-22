package com.technologica.world.item;

import com.technologica.registration.deferred.TechnologicaBlocks;
import com.technologica.util.MiddleEnd;
import com.technologica.world.level.block.SawmillBlock;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;

public class BlueprintItem extends Item {
	public BlueprintItem(Properties properties) {
		super(properties);
	}

	@Override
	public InteractionResult useOn(UseOnContext context) {
		Boolean success = false;
		Level level = context.getLevel();
		if (!level.isClientSide) {

			BlockPos pos = context.getClickedPos();
			BlockState blockState = level.getBlockState(pos);

			if (blockState.getBlock() instanceof SawmillBlock) {
				success = tryCreateSawmill(level, pos, blockState, context.getClickedFace());
			}

			if (success) {
				if (!context.getPlayer().getAbilities().instabuild) {
					context.getItemInHand().shrink(1);
				}
				return InteractionResult.SUCCESS;
			}
		}
		return InteractionResult.CONSUME;
	}

	public boolean tryCreateSawmill(Level level, BlockPos posIn, BlockState stateIn, Direction direction) {
		switch (direction) {
		case DOWN:
			return false;
		case EAST:
			if (level.getBlockState(posIn.below()).getBlock() instanceof SawmillBlock && level.getBlockState(posIn.south()).getBlock() instanceof SawmillBlock && level.getBlockState(posIn.south().south()).getBlock() instanceof SawmillBlock && level.getBlockState(posIn.north()).getBlock() instanceof SawmillBlock && level.getBlockState(posIn.north().north()).getBlock() instanceof SawmillBlock && level.getBlockState(posIn.below().south()).getBlock() instanceof SawmillBlock && level.getBlockState(posIn.below().south().south()).getBlock() instanceof SawmillBlock && level.getBlockState(posIn.below().north()).getBlock() instanceof SawmillBlock && level.getBlockState(posIn.below().north().north()).getBlock() instanceof SawmillBlock) {
				level.setBlock(posIn, TechnologicaBlocks.SAWMILL_CORE.get().defaultBlockState().setValue(SawmillBlock.BOTTOM, false).setValue(SawmillBlock.MIDDLE_END, MiddleEnd.MIDDLE).setValue(SawmillBlock.NESW_FACING, Direction.NORTH), 3);
				level.setBlock(posIn.north(), stateIn.setValue(SawmillBlock.BOTTOM, false).setValue(SawmillBlock.MIDDLE_END, MiddleEnd.MIDDLE).setValue(SawmillBlock.NESW_FACING, Direction.NORTH), 3);
				level.setBlock(posIn.north().north(), stateIn.setValue(SawmillBlock.BOTTOM, false).setValue(SawmillBlock.MIDDLE_END, MiddleEnd.RIGHT).setValue(SawmillBlock.NESW_FACING, Direction.NORTH), 3);
				level.setBlock(posIn.south(), stateIn.setValue(SawmillBlock.BOTTOM, false).setValue(SawmillBlock.MIDDLE_END, MiddleEnd.MIDDLE).setValue(SawmillBlock.NESW_FACING, Direction.NORTH), 3);
				level.setBlock(posIn.south().south(), stateIn.setValue(SawmillBlock.BOTTOM, false).setValue(SawmillBlock.MIDDLE_END, MiddleEnd.LEFT).setValue(SawmillBlock.NESW_FACING, Direction.NORTH), 3);
				level.setBlock(posIn.below(), stateIn.setValue(SawmillBlock.BOTTOM, true).setValue(SawmillBlock.MIDDLE_END, MiddleEnd.MIDDLE).setValue(SawmillBlock.NESW_FACING, Direction.NORTH), 3);
				level.setBlock(posIn.below().north(), stateIn.setValue(SawmillBlock.BOTTOM, true).setValue(SawmillBlock.MIDDLE_END, MiddleEnd.MIDDLE).setValue(SawmillBlock.NESW_FACING, Direction.NORTH), 3);
				level.setBlock(posIn.below().north().north(), stateIn.setValue(SawmillBlock.BOTTOM, true).setValue(SawmillBlock.MIDDLE_END, MiddleEnd.RIGHT).setValue(SawmillBlock.NESW_FACING, Direction.NORTH), 3);
				level.setBlock(posIn.below().south(), stateIn.setValue(SawmillBlock.BOTTOM, true).setValue(SawmillBlock.MIDDLE_END, MiddleEnd.MIDDLE).setValue(SawmillBlock.NESW_FACING, Direction.NORTH), 3);
				level.setBlock(posIn.below().south().south(), stateIn.setValue(SawmillBlock.BOTTOM, true).setValue(SawmillBlock.MIDDLE_END, MiddleEnd.LEFT).setValue(SawmillBlock.NESW_FACING, Direction.NORTH), 3);
				return true;
			}
			return false;
		case NORTH:
			if (level.getBlockState(posIn.below()).getBlock() instanceof SawmillBlock && level.getBlockState(posIn.west()).getBlock() instanceof SawmillBlock && level.getBlockState(posIn.west().west()).getBlock() instanceof SawmillBlock && level.getBlockState(posIn.east()).getBlock() instanceof SawmillBlock && level.getBlockState(posIn.east().east()).getBlock() instanceof SawmillBlock && level.getBlockState(posIn.below().west()).getBlock() instanceof SawmillBlock && level.getBlockState(posIn.below().west().west()).getBlock() instanceof SawmillBlock && level.getBlockState(posIn.below().east()).getBlock() instanceof SawmillBlock && level.getBlockState(posIn.below().east().east()).getBlock() instanceof SawmillBlock) {
				level.setBlock(posIn, TechnologicaBlocks.SAWMILL_CORE.get().defaultBlockState().setValue(SawmillBlock.BOTTOM, false).setValue(SawmillBlock.MIDDLE_END, MiddleEnd.MIDDLE).setValue(SawmillBlock.NESW_FACING, Direction.WEST), 3);
				level.setBlock(posIn.east(), stateIn.setValue(SawmillBlock.BOTTOM, false).setValue(SawmillBlock.MIDDLE_END, MiddleEnd.MIDDLE).setValue(SawmillBlock.NESW_FACING, Direction.WEST), 3);
				level.setBlock(posIn.east().east(), stateIn.setValue(SawmillBlock.BOTTOM, false).setValue(SawmillBlock.MIDDLE_END, MiddleEnd.LEFT).setValue(SawmillBlock.NESW_FACING, Direction.WEST), 3);
				level.setBlock(posIn.west(), stateIn.setValue(SawmillBlock.BOTTOM, false).setValue(SawmillBlock.MIDDLE_END, MiddleEnd.MIDDLE).setValue(SawmillBlock.NESW_FACING, Direction.WEST), 3);
				level.setBlock(posIn.west().west(), stateIn.setValue(SawmillBlock.BOTTOM, false).setValue(SawmillBlock.MIDDLE_END, MiddleEnd.RIGHT).setValue(SawmillBlock.NESW_FACING, Direction.WEST), 3);
				level.setBlock(posIn.below(), stateIn.setValue(SawmillBlock.BOTTOM, true).setValue(SawmillBlock.MIDDLE_END, MiddleEnd.MIDDLE).setValue(SawmillBlock.NESW_FACING, Direction.WEST), 3);
				level.setBlock(posIn.below().east(), stateIn.setValue(SawmillBlock.BOTTOM, true).setValue(SawmillBlock.MIDDLE_END, MiddleEnd.MIDDLE).setValue(SawmillBlock.NESW_FACING, Direction.WEST), 3);
				level.setBlock(posIn.below().east().east(), stateIn.setValue(SawmillBlock.BOTTOM, true).setValue(SawmillBlock.MIDDLE_END, MiddleEnd.LEFT).setValue(SawmillBlock.NESW_FACING, Direction.WEST), 3);
				level.setBlock(posIn.below().west(), stateIn.setValue(SawmillBlock.BOTTOM, true).setValue(SawmillBlock.MIDDLE_END, MiddleEnd.MIDDLE).setValue(SawmillBlock.NESW_FACING, Direction.WEST), 3);
				level.setBlock(posIn.below().west().west(), stateIn.setValue(SawmillBlock.BOTTOM, true).setValue(SawmillBlock.MIDDLE_END, MiddleEnd.RIGHT).setValue(SawmillBlock.NESW_FACING, Direction.WEST), 3);
				return true;
			}
			return false;
		case SOUTH:
			if (level.getBlockState(posIn.below()).getBlock() instanceof SawmillBlock && level.getBlockState(posIn.west()).getBlock() instanceof SawmillBlock && level.getBlockState(posIn.west().west()).getBlock() instanceof SawmillBlock && level.getBlockState(posIn.east()).getBlock() instanceof SawmillBlock && level.getBlockState(posIn.east().east()).getBlock() instanceof SawmillBlock && level.getBlockState(posIn.below().west()).getBlock() instanceof SawmillBlock && level.getBlockState(posIn.below().west().west()).getBlock() instanceof SawmillBlock && level.getBlockState(posIn.below().east()).getBlock() instanceof SawmillBlock && level.getBlockState(posIn.below().east().east()).getBlock() instanceof SawmillBlock) {
				level.setBlock(posIn, TechnologicaBlocks.SAWMILL_CORE.get().defaultBlockState().setValue(SawmillBlock.BOTTOM, false).setValue(SawmillBlock.MIDDLE_END, MiddleEnd.MIDDLE).setValue(SawmillBlock.NESW_FACING, Direction.EAST), 3);
				level.setBlock(posIn.east(), stateIn.setValue(SawmillBlock.BOTTOM, false).setValue(SawmillBlock.MIDDLE_END, MiddleEnd.MIDDLE).setValue(SawmillBlock.NESW_FACING, Direction.EAST), 3);
				level.setBlock(posIn.east().east(), stateIn.setValue(SawmillBlock.BOTTOM, false).setValue(SawmillBlock.MIDDLE_END, MiddleEnd.RIGHT).setValue(SawmillBlock.NESW_FACING, Direction.EAST), 3);
				level.setBlock(posIn.west(), stateIn.setValue(SawmillBlock.BOTTOM, false).setValue(SawmillBlock.MIDDLE_END, MiddleEnd.MIDDLE).setValue(SawmillBlock.NESW_FACING, Direction.EAST), 3);
				level.setBlock(posIn.west().west(), stateIn.setValue(SawmillBlock.BOTTOM, false).setValue(SawmillBlock.MIDDLE_END, MiddleEnd.LEFT).setValue(SawmillBlock.NESW_FACING, Direction.EAST), 3);
				level.setBlock(posIn.below(), stateIn.setValue(SawmillBlock.BOTTOM, true).setValue(SawmillBlock.MIDDLE_END, MiddleEnd.MIDDLE).setValue(SawmillBlock.NESW_FACING, Direction.EAST), 3);
				level.setBlock(posIn.below().east(), stateIn.setValue(SawmillBlock.BOTTOM, true).setValue(SawmillBlock.MIDDLE_END, MiddleEnd.MIDDLE).setValue(SawmillBlock.NESW_FACING, Direction.EAST), 3);
				level.setBlock(posIn.below().east().east(), stateIn.setValue(SawmillBlock.BOTTOM, true).setValue(SawmillBlock.MIDDLE_END, MiddleEnd.RIGHT).setValue(SawmillBlock.NESW_FACING, Direction.EAST), 3);
				level.setBlock(posIn.below().west(), stateIn.setValue(SawmillBlock.BOTTOM, true).setValue(SawmillBlock.MIDDLE_END, MiddleEnd.MIDDLE).setValue(SawmillBlock.NESW_FACING, Direction.EAST), 3);
				level.setBlock(posIn.below().west().west(), stateIn.setValue(SawmillBlock.BOTTOM, true).setValue(SawmillBlock.MIDDLE_END, MiddleEnd.LEFT).setValue(SawmillBlock.NESW_FACING, Direction.EAST), 3);
				return true;
			}
			return false;
		case UP:
			return false;
		case WEST:
			if (level.getBlockState(posIn.below()).getBlock() instanceof SawmillBlock && level.getBlockState(posIn.south()).getBlock() instanceof SawmillBlock && level.getBlockState(posIn.south().south()).getBlock() instanceof SawmillBlock && level.getBlockState(posIn.north()).getBlock() instanceof SawmillBlock && level.getBlockState(posIn.north().north()).getBlock() instanceof SawmillBlock && level.getBlockState(posIn.below().south()).getBlock() instanceof SawmillBlock && level.getBlockState(posIn.below().south().south()).getBlock() instanceof SawmillBlock && level.getBlockState(posIn.below().north()).getBlock() instanceof SawmillBlock && level.getBlockState(posIn.below().north().north()).getBlock() instanceof SawmillBlock) {
				level.setBlock(posIn, TechnologicaBlocks.SAWMILL_CORE.get().defaultBlockState().setValue(SawmillBlock.BOTTOM, false).setValue(SawmillBlock.MIDDLE_END, MiddleEnd.MIDDLE).setValue(SawmillBlock.NESW_FACING, Direction.SOUTH), 3);
				level.setBlock(posIn.north(), stateIn.setValue(SawmillBlock.BOTTOM, false).setValue(SawmillBlock.MIDDLE_END, MiddleEnd.MIDDLE).setValue(SawmillBlock.NESW_FACING, Direction.SOUTH), 3);
				level.setBlock(posIn.north().north(), stateIn.setValue(SawmillBlock.BOTTOM, false).setValue(SawmillBlock.MIDDLE_END, MiddleEnd.LEFT).setValue(SawmillBlock.NESW_FACING, Direction.SOUTH), 3);
				level.setBlock(posIn.south(), stateIn.setValue(SawmillBlock.BOTTOM, false).setValue(SawmillBlock.MIDDLE_END, MiddleEnd.MIDDLE).setValue(SawmillBlock.NESW_FACING, Direction.SOUTH), 3);
				level.setBlock(posIn.south().south(), stateIn.setValue(SawmillBlock.BOTTOM, false).setValue(SawmillBlock.MIDDLE_END, MiddleEnd.RIGHT).setValue(SawmillBlock.NESW_FACING, Direction.SOUTH), 3);
				level.setBlock(posIn.below(), stateIn.setValue(SawmillBlock.BOTTOM, true).setValue(SawmillBlock.MIDDLE_END, MiddleEnd.MIDDLE).setValue(SawmillBlock.NESW_FACING, Direction.SOUTH), 3);
				level.setBlock(posIn.below().north(), stateIn.setValue(SawmillBlock.BOTTOM, true).setValue(SawmillBlock.MIDDLE_END, MiddleEnd.MIDDLE).setValue(SawmillBlock.NESW_FACING, Direction.SOUTH), 3);
				level.setBlock(posIn.below().north().north(), stateIn.setValue(SawmillBlock.BOTTOM, true).setValue(SawmillBlock.MIDDLE_END, MiddleEnd.LEFT).setValue(SawmillBlock.NESW_FACING, Direction.SOUTH), 3);
				level.setBlock(posIn.below().south(), stateIn.setValue(SawmillBlock.BOTTOM, true).setValue(SawmillBlock.MIDDLE_END, MiddleEnd.MIDDLE).setValue(SawmillBlock.NESW_FACING, Direction.SOUTH), 3);
				level.setBlock(posIn.below().south().south(), stateIn.setValue(SawmillBlock.BOTTOM, true).setValue(SawmillBlock.MIDDLE_END, MiddleEnd.RIGHT).setValue(SawmillBlock.NESW_FACING, Direction.SOUTH), 3);
				return true;
			}
			return false;
		default:
			return false;
		}
	}
}
