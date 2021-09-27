package com.technologica.block;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.state.DirectionProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.util.Direction;

public class FourDirectionBlock extends Block {
	public static final DirectionProperty HORIZONTAL_FACING = BlockStateProperties.HORIZONTAL_FACING;

	public FourDirectionBlock(Properties propertiesIn) {
		super(propertiesIn);
		this.setDefaultState(this.stateContainer.getBaseState().with(HORIZONTAL_FACING, Direction.NORTH));
	}
	
	@Override
	protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builderIn) {
		builderIn.add(HORIZONTAL_FACING);
		super.fillStateContainer(builderIn);
	}
	
	@Override
	public BlockState getStateForPlacement(BlockItemUseContext contextIn) {
		return this.getDefaultState().with(HORIZONTAL_FACING, contextIn.getPlacementHorizontalFacing().getOpposite());
	}

}
