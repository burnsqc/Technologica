package com.technologica.block;

import com.technologica.state.properties.TechnologicaBlockStateProperties;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.DirectionalBlock;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.state.DirectionProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.util.Direction;

/**
 * General class for extending, allowing orientation with six facing directions and four sub-facing directions. 
 * Created for ease of use.
 */
public class TwentyFourDirectionBlock extends DirectionalBlock {
	public static final DirectionProperty SUB_FACING = TechnologicaBlockStateProperties.SUB_FACING;
	
	public TwentyFourDirectionBlock(Properties propertiesIn) {
		super(propertiesIn);
		this.setDefaultState(this.stateContainer.getBaseState().with(FACING, Direction.UP).with(SUB_FACING, Direction.NORTH));
	}

	/*
	 * Minecraft Methods
	 */
	
	@Override
	public BlockState getStateForPlacement(BlockItemUseContext contextIn) {
		int i = 0;
		Direction[] adirection = contextIn.getNearestLookingDirections();
		if (adirection[i] == contextIn.getFace().getOpposite()) {
			i++;
		}
		return this.getDefaultState().with(FACING, contextIn.getFace()).with(SUB_FACING, adirection[i]);
	}	
	
	@Override
	protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builderIn) {
		builderIn.add(FACING, SUB_FACING);
		super.fillStateContainer(builderIn);
	}
	
}