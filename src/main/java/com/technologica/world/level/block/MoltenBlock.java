package com.technologica.world.level.block;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.LiquidBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.FlowingFluid;

public class MoltenBlock extends LiquidBlock {

	public MoltenBlock(java.util.function.Supplier<? extends FlowingFluid> flowingFluid, BlockBehaviour.Properties properties) {
		super(flowingFluid, properties);
	}

	@Override
	public void tick(BlockState blockState, ServerLevel serverLevel, BlockPos blockPos, RandomSource randomSource) {
		SmokeColumnBlock.updateColumn(serverLevel, blockPos.above(), blockState);
	}

	@Override
	public BlockState updateShape(BlockState blockState, Direction direction, BlockState blockStateCausedUpdate, LevelAccessor levelAccessor, BlockPos blockPos, BlockPos blockPosCausedUpdate) {
		if (direction == Direction.UP && blockStateCausedUpdate.is(Blocks.WATER)) {
			levelAccessor.scheduleTick(blockPos, this, 20);
		}
		return super.updateShape(blockState, direction, blockStateCausedUpdate, levelAccessor, blockPos, blockPosCausedUpdate);
	}

	@Override
	public void onPlace(BlockState blockState, Level level, BlockPos blockPos, BlockState blockStatePrevious, boolean isBlockBeingPushed) {
		level.scheduleTick(blockPos, this, 20);
	}
}
