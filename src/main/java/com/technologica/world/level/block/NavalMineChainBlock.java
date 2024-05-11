package com.technologica.world.level.block;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.ChainBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;

public class NavalMineChainBlock extends ChainBlock {

	public NavalMineChainBlock(BlockBehaviour.Properties properties) {
		super(properties);
		registerDefaultState(stateDefinition.any().setValue(WATERLOGGED, true).setValue(AXIS, Direction.Axis.Y));
	}

	@Override
	@Deprecated
	public BlockState updateShape(BlockState stateIn, Direction directionIn, BlockState facingStateIn, LevelAccessor worldIn, BlockPos currentPosIn, BlockPos facingPosIn) {
		if (!stateIn.canSurvive(worldIn, currentPosIn)) {
			worldIn.scheduleTick(currentPosIn, this, 1);
		}
		return super.updateShape(stateIn, directionIn, facingStateIn, worldIn, currentPosIn, facingPosIn);
	}

	@Override
	public void tick(BlockState stateIn, ServerLevel worldIn, BlockPos posIn, RandomSource randomIn) {
		if (!stateIn.canSurvive(worldIn, posIn)) {
			worldIn.destroyBlock(posIn, true);
		}
	}

	@Override
	public boolean canSurvive(BlockState stateIn, LevelReader worldIn, BlockPos posIn) {
		if ((worldIn.getBlockState(posIn.below()).getBlock() instanceof NavalMineChainBlock && worldIn.getBlockState(posIn.above()).getBlock() instanceof NavalMineChainBlock) || (worldIn.getBlockState(posIn.below()).canOcclude() && worldIn.getBlockState(posIn.above()).getBlock() instanceof NavalMineChainBlock)) {
			return true;
		} else {
			return false;
		}
	}
}
