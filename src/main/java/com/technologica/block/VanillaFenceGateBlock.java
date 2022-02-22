package com.technologica.block;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.BlockState;
import net.minecraft.block.FenceGateBlock;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialColor;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockReader;

/**
 * Identical in behavior to vanilla Minecraft fence gates.  
 * Created to handle flammability.
 */
public class VanillaFenceGateBlock extends FenceGateBlock {

	public VanillaFenceGateBlock() {
		super(AbstractBlock.Properties.of(Material.WOOD, MaterialColor.WOOD).strength(2.0F, 3.0F).sound(SoundType.WOOD));
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
		return 20;
	}

}
