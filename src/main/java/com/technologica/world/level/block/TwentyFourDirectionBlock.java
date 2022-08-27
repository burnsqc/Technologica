package com.technologica.world.level.block;

import com.technologica.world.level.block.state.properties.TechnologicaBlockStateProperties;

import net.minecraft.core.Direction;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.DirectionalBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.DirectionProperty;

/**
 * General class for extending, allowing orientation with six facing directions and four sub-facing directions. Created for ease of use.
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
	public BlockState getStateForPlacement(BlockPlaceContext contextIn) {
		int i = 0;
		Direction[] adirection = contextIn.getNearestLookingDirections();
		if (adirection[i] == contextIn.getClickedFace().getOpposite()) {
			i++;
		}
		return this.defaultBlockState().setValue(FACING, contextIn.getClickedFace()).setValue(SUB_FACING, adirection[i]);
	}

	@Override
	protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builderIn) {
		builderIn.add(FACING, SUB_FACING);
		super.createBlockStateDefinition(builderIn);
	}

}