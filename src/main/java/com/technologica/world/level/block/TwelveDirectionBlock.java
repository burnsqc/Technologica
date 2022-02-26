package com.technologica.world.level.block;

import net.minecraft.core.Direction;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.DirectionalBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.EnumProperty;

/**
 * General class for extending, allowing orientation with six facing directions and two sub-facing directions. 
 * Created for ease of use.
 */
public class TwelveDirectionBlock extends DirectionalBlock {
	public static final EnumProperty<Direction.Axis> AXIS = BlockStateProperties.AXIS;
	
	public TwelveDirectionBlock(Properties propertiesIn) {
		super(propertiesIn);
		this.registerDefaultState(this.stateDefinition.any().setValue(FACING, Direction.UP).setValue(AXIS, Direction.Axis.Y));
	}

	/*
	 * Minecraft Methods
	 */
	
	@Override
	public BlockState getStateForPlacement(BlockPlaceContext contextIn) {
		int i = 0;
		Direction[] adirection = contextIn.getNearestLookingDirections();
		if (adirection[i] == contextIn.getClickedFace().getOpposite()) {
			i++;
		}
		return this.defaultBlockState().setValue(FACING, contextIn.getClickedFace()).setValue(AXIS, adirection[i].getAxis());
	}
	
	@Override
	protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builderIn) {
		builderIn.add(FACING, AXIS);
		super.createBlockStateDefinition(builderIn);
	}
}
