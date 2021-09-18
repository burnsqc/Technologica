package com.technologica.block;

import java.util.function.Supplier;

import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.ILiquidContainer;
import net.minecraft.fluid.Fluid;
import net.minecraft.fluid.FluidState;
import net.minecraft.fluid.Fluids;
import net.minecraft.item.Item;
import net.minecraft.state.properties.DoubleBlockHalf;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.IWorld;
import net.minecraft.world.IWorldReader;

public class WaterCropsBlock extends TallCropsBlock implements ILiquidContainer {

	public WaterCropsBlock(Supplier<Item> seedsIn) {
		super(seedsIn);
	}
	
	@Override
	public boolean isValidPosition(BlockState stateIn, IWorldReader worldIn, BlockPos posIn) {
		Boolean unobstructed;
		BlockPos ground = posIn.down();
		
		if (stateIn.get(HALF) == DoubleBlockHalf.LOWER) {
			if (stateIn.get(AGE) <= 3) {
				unobstructed = isAir(worldIn.getBlockState(posIn.up()));
			} else {
				if (worldIn.getBlockState(posIn.up()).getBlock() == this) {
					unobstructed = worldIn.getBlockState(posIn.up()).get(HALF) == DoubleBlockHalf.UPPER;
				} else {
					unobstructed = false;
				}
			}
			return isValidGround(worldIn.getBlockState(ground), worldIn, ground) && unobstructed;
		} else {
			if (worldIn.getBlockState(ground).getBlock() == this) {
				return worldIn.getBlockState(ground).get(HALF) == DoubleBlockHalf.LOWER && worldIn.getBlockState(ground).get(AGE) >= 4;
			} else {
				return false;
			}
		}
	}
	
	@Override
	protected boolean isValidGround(BlockState stateIn, IBlockReader worldIn, BlockPos posIn) {
		FluidState fluidstate = worldIn.getFluidState(posIn.up());
		if (fluidstate.getFluid() == Fluids.WATER) {
			return ((stateIn.matchesBlock(Blocks.GRASS_BLOCK) || stateIn.matchesBlock(Blocks.DIRT)
					|| stateIn.matchesBlock(Blocks.COARSE_DIRT) || stateIn.matchesBlock(Blocks.PODZOL)));
		} else if (stateIn.matchesBlock(this)) {
			return stateIn.get(HALF) == DoubleBlockHalf.LOWER && stateIn.get(AGE) >= 4;
		} else {
			return false;
		}
	}
	
	@Override
	public FluidState getFluidState(BlockState state) {
		if (state.get(HALF) == DoubleBlockHalf.LOWER) {
			return Fluids.WATER.getStillFluidState(false);
		} else {
			return Fluids.EMPTY.getDefaultState();
		}
	}

	@Override
	public boolean canContainFluid(IBlockReader worldIn, BlockPos pos, BlockState state, Fluid fluidIn) {
		return false;
	}

	@Override
	public boolean receiveFluid(IWorld worldIn, BlockPos pos, BlockState state, FluidState fluidStateIn) {
		return false;
	}
}