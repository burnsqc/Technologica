package com.technologica.block;

import com.technologica.state.properties.ModBlockStateProperties;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.DirectionalBlock;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.state.DirectionProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.util.Direction;

public class TwentyFourDirectionBlock extends DirectionalBlock{
	public static final DirectionProperty SUB_FACING = ModBlockStateProperties.SUB_FACING;
	
	protected TwentyFourDirectionBlock(Properties propertiesIn) {
		super(propertiesIn);
	}

	@Override
	protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builder) {
		builder.add(FACING, SUB_FACING);
		super.fillStateContainer(builder);
	}
	
	@Override
	public BlockState getStateForPlacement(BlockItemUseContext context) {
		int i = 0;
		Direction[] adirection = context.getNearestLookingDirections();
		if (adirection[i] == context.getFace().getOpposite()) {
			i++;
		}
		return this.getDefaultState().with(FACING, context.getFace()).with(SUB_FACING, adirection[i]);
	}	
}