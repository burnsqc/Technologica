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
	public static final IntegerProperty AGE = BlockStateProperties.AGE_15;

	public SapLogBlock() {
		super();
		this.registerDefaultState(this.stateDefinition.any().setValue(AGE, 0).setValue(PERSISTENT, false).setValue(AXIS, Direction.Axis.Y));
	}
	
	/*
	 * Minecraft Methods
	 */
	
	@Override
	public void randomTick(BlockState stateIn, ServerWorld worldIn, BlockPos posIn, Random randomIn) {
		worldIn.setBlock(posIn, stateIn.setValue(AGE, stateIn.getValue(AGE) + 1), 7);
	}
	
	@Override
	public boolean isRandomlyTicking(BlockState stateIn) {
		return !stateIn.getValue(PERSISTENT) && stateIn.getValue(AGE) <= 14;
	}
	
	@Override
	public BlockState getStateForPlacement(BlockItemUseContext context) {
		return this.defaultBlockState().setValue(AXIS, context.getClickedFace().getAxis()).setValue(PERSISTENT, true);
	}

	@Override
	protected void createBlockStateDefinition(StateContainer.Builder<Block, BlockState> builder) {
		builder.add(PERSISTENT).add(AGE);
		super.createBlockStateDefinition(builder);
	}
}