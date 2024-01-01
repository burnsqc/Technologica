package com.technologica.world.level.block;

import com.technologica.util.MiddleEnd;
import com.technologica.world.level.block.state.properties.TechnologicaBlockStateProperties;

import net.minecraft.core.Direction;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.EnumProperty;

/**
 * Special one-off class for the sawmill. Created to handle player interaction and associated tile entity.
 */
public class SawmillBlock extends FourDirectionBlock {
	public static final BooleanProperty BOTTOM = BlockStateProperties.BOTTOM;
	public static final EnumProperty<MiddleEnd> MIDDLE_END = TechnologicaBlockStateProperties.MIDDLE_END;

	public SawmillBlock() {
		super(BlockBehaviour.Properties.of().requiresCorrectToolForDrops().strength(5.0F).sound(SoundType.ANVIL).noOcclusion());
		this.registerDefaultState(this.stateDefinition.any().setValue(NESW_FACING, Direction.NORTH).setValue(BOTTOM, false).setValue(MIDDLE_END, MiddleEnd.MIDDLE));
	}

	@Override
	protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builderIn) {
		builderIn.add(BOTTOM);
		builderIn.add(MIDDLE_END);
		super.createBlockStateDefinition(builderIn);
	}
}