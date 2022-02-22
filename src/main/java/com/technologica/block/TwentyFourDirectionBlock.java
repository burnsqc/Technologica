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
		this.registerDefaultState(this.stateDefinition.any().setValue(FACING, Direction.UP).setValue(SUB_FACING, Direction.NORTH));
	}

	/*
	 * Minecraft Methods
	 */
	
	@Override
	public BlockState getStateForPlacement(BlockItemUseContext contextIn) {
		int i = 0;
		Direction[] adirection = contextIn.getNearestLookingDirections();
		if (adirection[i] == contextIn.getClickedFace().getOpposite()) {
			i++;
		}
		return this.defaultBlockState().setValue(FACING, contextIn.getClickedFace()).setValue(SUB_FACING, adirection[i]);
	}	
	
	@Override
	protected void createBlockStateDefinition(StateContainer.Builder<Block, BlockState> builderIn) {
		builderIn.add(FACING, SUB_FACING);
		super.createBlockStateDefinition(builderIn);
	}
	
}