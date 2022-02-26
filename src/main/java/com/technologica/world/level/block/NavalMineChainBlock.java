package com.technologica.world.level.block;

import java.util.Random;

import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.ChainBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.material.MaterialColor;
import net.minecraft.core.Direction;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.LevelReader;
import net.minecraft.server.level.ServerLevel;

public class NavalMineChainBlock extends ChainBlock {

	public NavalMineChainBlock() {
		super(BlockBehaviour.Properties.of(Material.METAL, MaterialColor.NONE).requiresCorrectToolForDrops().strength(5.0F, 6.0F).sound(SoundType.CHAIN).noOcclusion());
		this.registerDefaultState(this.stateDefinition.any().setValue(WATERLOGGED, true).setValue(AXIS, Direction.Axis.Y));
	}
	
	@Override
	@Deprecated
	public BlockState updateShape(BlockState stateIn, Direction directionIn, BlockState facingStateIn, LevelAccessor worldIn, BlockPos currentPosIn, BlockPos facingPosIn) {
		worldIn.getBlockTicks().willTickThisTick(currentPosIn, this);
	    return super.updateShape(stateIn, directionIn, facingStateIn, worldIn, currentPosIn, facingPosIn);
	}
	
	@Override
	public void tick(BlockState stateIn, ServerLevel worldIn, BlockPos posIn, Random randomIn) {
	    if (!canSurvive(stateIn, worldIn, posIn)) {
	    	worldIn.destroyBlock(posIn, true);
	    }
	}
	
	@Override
	public boolean canSurvive(BlockState stateIn, LevelReader worldIn, BlockPos posIn) {
		if ((worldIn.getBlockState(posIn.below()).getBlock() instanceof NavalMineChainBlock && worldIn.getBlockState(posIn.above()).getBlock() instanceof NavalMineChainBlock) || (worldIn.getBlockState(posIn.below()).canOcclude() && worldIn.getBlockState(posIn.above()).getBlock() instanceof NavalMineChainBlock)) {
			return true;
		} else {
			return false;
		}
	}
}
