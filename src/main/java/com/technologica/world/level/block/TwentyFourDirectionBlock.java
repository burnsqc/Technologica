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
	public BlockState getStateForPlacement(BlockPlaceContext contextIn) {
		LevelAccessor levelaccessor = contextIn.getLevel();
		BlockPos blockpos = contextIn.getClickedPos();
		int i = 0;
		Direction[] adirection = contextIn.getNearestLookingDirections();
		if (adirection[i] == contextIn.getClickedFace().getOpposite()) {
			i++;
		}
		return this.defaultBlockState().setValue(FACING, contextIn.getClickedFace()).setValue(SUB_FACING, adirection[i]).setValue(WATERLOGGED, Boolean.valueOf(levelaccessor.getFluidState(blockpos).getType() == Fluids.WATER));
	}

	@Override
	protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builderIn) {
		builderIn.add(FACING, SUB_FACING, WATERLOGGED);
		super.createBlockStateDefinition(builderIn);
	}

	@SuppressWarnings("deprecation")
	@Override
	public BlockState updateShape(BlockState p_152036_, Direction p_152037_, BlockState p_152038_, LevelAccessor p_152039_, BlockPos p_152040_, BlockPos p_152041_) {
		if (p_152036_.getValue(WATERLOGGED)) {
			p_152039_.scheduleTick(p_152040_, Fluids.WATER, Fluids.WATER.getTickDelay(p_152039_));
		}

		return p_152037_ == p_152036_.getValue(FACING).getOpposite() && !p_152036_.canSurvive(p_152039_, p_152040_) ? Blocks.AIR.defaultBlockState() : super.updateShape(p_152036_, p_152037_, p_152038_, p_152039_, p_152040_, p_152041_);
	}

	@SuppressWarnings("deprecation")
	@Override
	public FluidState getFluidState(BlockState p_152045_) {
		return p_152045_.getValue(WATERLOGGED) ? Fluids.WATER.getSource(false) : super.getFluidState(p_152045_);
	}

}