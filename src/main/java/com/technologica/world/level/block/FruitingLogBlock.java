package com.technologica.world.level.block;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.core.Direction;

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
	public BlockState getStateForPlacement(BlockPlaceContext context) {
		return this.defaultBlockState().setValue(AXIS, context.getClickedFace().getAxis()).setValue(PERSISTENT, true);
	}

	@Override
	protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
		builder.add(PERSISTENT);
		super.createBlockStateDefinition(builder);
	}
}