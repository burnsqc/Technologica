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
		super(AbstractBlock.Properties.of(Material.METAL, MaterialColor.NONE).requiresCorrectToolForDrops().strength(5.0F, 6.0F).sound(SoundType.CHAIN).noOcclusion());
		this.registerDefaultState(this.stateDefinition.any().setValue(WATERLOGGED, true).setValue(AXIS, Direction.Axis.Y));
	}
	
	@Override
	@Deprecated
	public BlockState updateShape(BlockState stateIn, Direction directionIn, BlockState facingStateIn, IWorld worldIn, BlockPos currentPosIn, BlockPos facingPosIn) {
		worldIn.getBlockTicks().scheduleTick(currentPosIn, this, 0);
	    return super.updateShape(stateIn, directionIn, facingStateIn, worldIn, currentPosIn, facingPosIn);
	}
	
	@Override
	public void tick(BlockState stateIn, ServerWorld worldIn, BlockPos posIn, Random randomIn) {
	    if (!canSurvive(stateIn, worldIn, posIn)) {
	    	worldIn.destroyBlock(posIn, true);
	    }
	}
	
	@Override
	public boolean canSurvive(BlockState stateIn, IWorldReader worldIn, BlockPos posIn) {
		if ((worldIn.getBlockState(posIn.below()).getBlock() instanceof NavalMineChainBlock && worldIn.getBlockState(posIn.above()).getBlock() instanceof NavalMineChainBlock) || (worldIn.getBlockState(posIn.below()).canOcclude() && worldIn.getBlockState(posIn.above()).getBlock() instanceof NavalMineChainBlock)) {
			return true;
		} else {
			return false;
		}
	}
}
