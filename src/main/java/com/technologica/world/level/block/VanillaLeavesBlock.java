package com.technologica.world.level.block;

import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.LeavesBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.material.Material;
import net.minecraft.core.Direction;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.BlockGetter;

/**
 * Identical in behavior to vanilla Minecraft leaves.  
 * Created to handle flammability.
 */
public class VanillaLeavesBlock extends LeavesBlock {

	public VanillaLeavesBlock() {
		super(BlockBehaviour.Properties.of(Material.LEAVES).strength(0.2F).randomTicks().sound(SoundType.GRASS).noOcclusion());
	}

	/*
	 * Forge Methods
	 */
	
	@Override
	public int getFlammability(BlockState stateIn, BlockGetter worldIn, BlockPos posIn, Direction faceIn) {
		return 30;
	}

	@Override
	public int getFireSpreadSpeed(BlockState stateIn, BlockGetter worldIn, BlockPos posIn, Direction faceIn) {
		return 60;
	}
	
}
