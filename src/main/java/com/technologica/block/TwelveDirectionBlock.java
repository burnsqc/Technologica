package com.technologica.block;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.DirectionalBlock;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.state.EnumProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.util.Direction;

/**
 * General class for extending, allowing orientation with six facing directions and two sub-facing directions. 
 * Created for ease of use.
 */
public class TwelveDirectionBlock extends DirectionalBlock {
	public static final EnumProperty<Direction.Axis> AXIS = BlockStateProperties.AXIS;
	
	public TwelveDirectionBlock(Properties propertiesIn) {
		super(propertiesIn);
		this.setDefaultState(this.stateContainer.getBaseState().with(FACING, Direction.UP).with(AXIS, Direction.Axis.Y));
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
		return this.getDefaultState().with(FACING, contextIn.getFace()).with(AXIS, adirection[i].getAxis());
	}
	
	@Override
	protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builderIn) {
		builderIn.add(FACING, AXIS);
		super.fillStateContainer(builderIn);
	}
}
