package com.technologica.block;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.state.DirectionProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.util.Direction;

/**
 * General class for extending, similar to vanilla Minecraft HorizontalBlock. 
 * The difference between the two is that this class fills the state container and handles placement, removing the need to classes which extend this one to do so.   
 * Created for ease of use.
 */
public class FourDirectionBlock extends Block {
	public static final DirectionProperty NESW_FACING = BlockStateProperties.HORIZONTAL_FACING;

	public FourDirectionBlock(Properties propertiesIn) {
		super(propertiesIn);
		this.setDefaultState(this.stateContainer.getBaseState().with(NESW_FACING, Direction.NORTH));
	}

	/*
	 * Minecraft Methods
	 */
	
	@Override
	public BlockState getStateForPlacement(BlockItemUseContext contextIn) {
		return this.getDefaultState().with(NESW_FACING, contextIn.getPlacementHorizontalFacing().getOpposite());
	}
	
	@Override
	protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builderIn) {
		builderIn.add(NESW_FACING);
		super.fillStateContainer(builderIn);
	}

}
