package com.technologica.world.level.block;

import net.minecraft.core.Direction;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.DirectionProperty;

/**
 * General class for extending, similar to vanilla Minecraft HorizontalBlock. The difference between the two is that this class fills the state container and handles placement, removing the need to for classes which extend this one to do so. Created for ease of use.
 */
public class FourDirectionBlock extends Block {
	public static final DirectionProperty NESW_FACING = BlockStateProperties.HORIZONTAL_FACING;

	public FourDirectionBlock(Properties propertiesIn) {
		super(propertiesIn);
		this.registerDefaultState(this.stateDefinition.any().setValue(NESW_FACING, Direction.NORTH));
	}

	/*
	 * Minecraft Methods
	 */

	@Override
	public BlockState getStateForPlacement(BlockPlaceContext contextIn) {
		return this.defaultBlockState().setValue(NESW_FACING, contextIn.getHorizontalDirection().getOpposite());
	}

	@Override
	protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builderIn) {
		builderIn.add(NESW_FACING);
		super.createBlockStateDefinition(builderIn);
	}
}
