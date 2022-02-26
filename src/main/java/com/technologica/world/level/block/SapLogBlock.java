package com.technologica.world.level.block;

import java.util.Random;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.core.Direction;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;

/**
 * Special one-off class for sap logs.
 * Created to add age and persistent properties similar to leaves.
 */
public class SapLogBlock extends VanillaLogBlock {
	public static final BooleanProperty PERSISTENT = BlockStateProperties.PERSISTENT;
	public static final IntegerProperty AGE = BlockStateProperties.AGE_15;

	public SapLogBlock() {
		super();
		this.registerDefaultState(this.stateDefinition.any().setValue(AGE, 0).setValue(PERSISTENT, false).setValue(AXIS, Direction.Axis.Y));
	}
	
	/*
	 * Minecraft Methods
	 */
	
	@Override
	public void randomTick(BlockState stateIn, ServerLevel worldIn, BlockPos posIn, Random randomIn) {
		worldIn.setBlock(posIn, stateIn.setValue(AGE, stateIn.getValue(AGE) + 1), 7);
	}
	
	@Override
	public boolean isRandomlyTicking(BlockState stateIn) {
		return !stateIn.getValue(PERSISTENT) && stateIn.getValue(AGE) <= 14;
	}
	
	@Override
	public BlockState getStateForPlacement(BlockPlaceContext context) {
		return this.defaultBlockState().setValue(AXIS, context.getClickedFace().getAxis()).setValue(PERSISTENT, true);
	}

	@Override
	protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
		builder.add(PERSISTENT).add(AGE);
		super.createBlockStateDefinition(builder);
	}
}