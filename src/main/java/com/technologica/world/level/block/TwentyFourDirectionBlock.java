package com.technologica.world.level.block;

import com.technologica.world.level.block.state.properties.TechnologicaBlockStateProperties;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.DirectionalBlock;
import net.minecraft.world.level.block.SimpleWaterloggedBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluids;

/**
 * General class for extending, allowing orientation with six facing directions and four sub-facing directions. Created for ease of use.
 */
public class TwentyFourDirectionBlock extends DirectionalBlock implements SimpleWaterloggedBlock {
	public static final DirectionProperty SUB_FACING = TechnologicaBlockStateProperties.SUB_FACING;
	public static final BooleanProperty WATERLOGGED = BlockStateProperties.WATERLOGGED;

	public TwentyFourDirectionBlock(Properties propertiesIn) {
		super(propertiesIn);
		this.registerDefaultState(this.stateDefinition.any().setValue(FACING, Direction.UP).setValue(SUB_FACING, Direction.NORTH).setValue(WATERLOGGED, false));
	}

	/*
	 * Minecraft Methods
	 */

	@Override
	public BlockState getStateForPlacement(BlockPlaceContext blockPlaceContext) {
		LevelAccessor levelaccessor = blockPlaceContext.getLevel();
		BlockPos blockpos = blockPlaceContext.getClickedPos();
		int i = 0;
		Direction[] adirection = blockPlaceContext.getNearestLookingDirections();
		if (adirection[i] == blockPlaceContext.getClickedFace().getOpposite()) {
			i++;
		}
		return this.defaultBlockState().setValue(FACING, blockPlaceContext.getClickedFace()).setValue(SUB_FACING, adirection[i]).setValue(WATERLOGGED, Boolean.valueOf(levelaccessor.getFluidState(blockpos).getType() == Fluids.WATER));
	}

	@Override
	protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builderIn) {
		builderIn.add(FACING, SUB_FACING, WATERLOGGED);
		super.createBlockStateDefinition(builderIn);
	}

	@SuppressWarnings("deprecation")
	@Override
	public BlockState updateShape(BlockState blockState, Direction direction, BlockState blockStateNeighbor, LevelAccessor levelAccessor, BlockPos blockPos, BlockPos blockPosNeighbor) {
		if (blockState.getValue(WATERLOGGED)) {
			levelAccessor.scheduleTick(blockPos, Fluids.WATER, Fluids.WATER.getTickDelay(levelAccessor));
		}

		return direction == blockState.getValue(FACING).getOpposite() && !blockState.canSurvive(levelAccessor, blockPos) ? Blocks.AIR.defaultBlockState() : super.updateShape(blockState, direction, blockStateNeighbor, levelAccessor, blockPos, blockPosNeighbor);
	}

	@SuppressWarnings("deprecation")
	@Override
	public FluidState getFluidState(BlockState blockState) {
		return blockState.getValue(WATERLOGGED) ? Fluids.WATER.getSource(false) : super.getFluidState(blockState);
	}
}