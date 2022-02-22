package com.technologica.block;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.state.BooleanProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.util.Direction;

/**
 * Special one-off class for logs which belong to fruiting trees.
 * Created to handle mulch growth acceleration.
 */
public class FruitingLogBlock extends VanillaLogBlock {
	public static final BooleanProperty PERSISTENT = BlockStateProperties.PERSISTENT;

	public FruitingLogBlock() {
		super();
		this.registerDefaultState(this.stateDefinition.any().setValue(PERSISTENT, false).setValue(AXIS, Direction.Axis.Y));
	}
	
	/*
	 * Minecraft Methods
	 */
	
	@Override
	public BlockState getStateForPlacement(BlockItemUseContext context) {
		return this.defaultBlockState().setValue(AXIS, context.getClickedFace().getAxis()).setValue(PERSISTENT, true);
	}

	@Override
	protected void createBlockStateDefinition(StateContainer.Builder<Block, BlockState> builder) {
		builder.add(PERSISTENT);
		super.createBlockStateDefinition(builder);
	}
}