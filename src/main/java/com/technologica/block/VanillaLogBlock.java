package com.technologica.block;

import net.minecraft.block.BlockState;
import net.minecraft.block.RotatedPillarBlock;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialColor;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockReader;

/**
 * Identical in behavior to vanilla Minecraft logs.  
 * Created to handle flammability.
 */
public class VanillaLogBlock extends RotatedPillarBlock {

	public VanillaLogBlock() {
		super(Properties.create(Material.WOOD, state -> state.get(RotatedPillarBlock.AXIS) == Direction.Axis.Y ? MaterialColor.WOOD : MaterialColor.OBSIDIAN).hardnessAndResistance(2.0F).harvestLevel(1).sound(SoundType.WOOD));
	}

	/*
	 * Forge Methods
	 */
	
	@Override
	public int getFlammability(BlockState stateIn, IBlockReader worldIn, BlockPos posIn, Direction faceIn) {
		return 5;
	}

	@Override
	public int getFireSpreadSpeed(BlockState stateIn, IBlockReader worldIn, BlockPos posIn, Direction faceIn) {
		return 5;
	}

}
