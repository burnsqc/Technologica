package com.technologica.block;

import java.util.Random;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.BlockState;
import net.minecraft.block.ChainBlock;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialColor;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IWorld;
import net.minecraft.world.IWorldReader;
import net.minecraft.world.server.ServerWorld;

public class NavalMineChainBlock extends ChainBlock {

	public NavalMineChainBlock() {
		super(AbstractBlock.Properties.create(Material.IRON, MaterialColor.AIR).setRequiresTool().hardnessAndResistance(5.0F, 6.0F).sound(SoundType.CHAIN).notSolid());
		this.setDefaultState(this.stateContainer.getBaseState().with(WATERLOGGED, true).with(AXIS, Direction.Axis.Y));
	}
	
	@Override
	@Deprecated
	public BlockState updatePostPlacement(BlockState stateIn, Direction directionIn, BlockState facingStateIn, IWorld worldIn, BlockPos currentPosIn, BlockPos facingPosIn) {
		worldIn.getPendingBlockTicks().scheduleTick(currentPosIn, this, 0);
	    return super.updatePostPlacement(stateIn, directionIn, facingStateIn, worldIn, currentPosIn, facingPosIn);
	}
	
	@Override
	public void tick(BlockState stateIn, ServerWorld worldIn, BlockPos posIn, Random randomIn) {
	    if (!isValidPosition(stateIn, worldIn, posIn)) {
	    	worldIn.destroyBlock(posIn, true);
	    }
	}
	
	@Override
	public boolean isValidPosition(BlockState stateIn, IWorldReader worldIn, BlockPos posIn) {
		if ((worldIn.getBlockState(posIn.down()).getBlock() instanceof NavalMineChainBlock && worldIn.getBlockState(posIn.up()).getBlock() instanceof NavalMineChainBlock) || (worldIn.getBlockState(posIn.down()).isSolid() && worldIn.getBlockState(posIn.up()).getBlock() instanceof NavalMineChainBlock)) {
			return true;
		} else {
			return false;
		}
	}
}
