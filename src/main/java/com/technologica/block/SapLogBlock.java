package com.technologica.block;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.state.BooleanProperty;
import net.minecraft.state.IntegerProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.server.ServerWorld;

/**
 * Special one-off class for sap logs.
 * Created to add age and persistent properties similar to leaves.
 */
public class SapLogBlock extends VanillaLogBlock {
	public static final BooleanProperty PERSISTENT = BlockStateProperties.PERSISTENT;
	public static final IntegerProperty AGE = BlockStateProperties.AGE_0_15;

	public SapLogBlock() {
		super();
		this.setDefaultState(this.stateContainer.getBaseState().with(AGE, 0).with(PERSISTENT, false).with(AXIS, Direction.Axis.Y));
	}
	
	/*
	 * Minecraft Methods
	 */
	
	@Override
	public void randomTick(BlockState stateIn, ServerWorld worldIn, BlockPos posIn, Random randomIn) {
		worldIn.setBlockState(posIn, stateIn.with(AGE, stateIn.get(AGE) + 1), 7);
	}
	
	@Override
	public boolean ticksRandomly(BlockState stateIn) {
		return !stateIn.get(PERSISTENT) && stateIn.get(AGE) <= 14;
	}
	
	@Override
	public BlockState getStateForPlacement(BlockItemUseContext context) {
		return this.getDefaultState().with(AXIS, context.getFace().getAxis()).with(PERSISTENT, Boolean.valueOf(true));
	}

	@Override
	protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builder) {
		builder.add(PERSISTENT).add(AGE);
		super.fillStateContainer(builder);
	}
}