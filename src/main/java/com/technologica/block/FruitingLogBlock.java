package com.technologica.block;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.state.BooleanProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.util.Direction;

/**
 * Special one-off class for sap logs.
 * Created to add age and persistent properties similar to leaves.
 */
public class FruitingLogBlock extends VanillaLogBlock {
	public static final BooleanProperty PERSISTENT = BlockStateProperties.PERSISTENT;

	public FruitingLogBlock() {
		super();
		this.setDefaultState(this.stateContainer.getBaseState().with(PERSISTENT, false).with(AXIS, Direction.Axis.Y));
	}
	
	/*
	 * Minecraft Methods
	 */
	
	@Override
	public BlockState getStateForPlacement(BlockItemUseContext context) {
		return this.getDefaultState().with(AXIS, context.getFace().getAxis()).with(PERSISTENT, Boolean.valueOf(true));
	}

	@Override
	protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builder) {
		builder.add(PERSISTENT);
		super.fillStateContainer(builder);
	}
}