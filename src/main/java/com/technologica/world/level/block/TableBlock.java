package com.technologica.world.level.block;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;

/**
 * Identical in behavior to vanilla Minecraft planks.
 * Created to handle flammability.
 */
public class TableBlock extends Block {

	public TableBlock() {
		super(BlockBehaviour.Properties.of().strength(2.0F, 3.0F).sound(SoundType.WOOD).noOcclusion());
	}

	/*
	 * Forge Methods
	 */

	@Override
	public int getFlammability(BlockState stateIn, BlockGetter worldIn, BlockPos posIn, Direction faceIn) {
		return 5;
	}

	@Override
	public int getFireSpreadSpeed(BlockState stateIn, BlockGetter worldIn, BlockPos posIn, Direction faceIn) {
		return 20;
	}

}
