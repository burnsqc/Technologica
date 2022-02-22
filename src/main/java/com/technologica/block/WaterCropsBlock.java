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

/**
 * Special one-off class for water crops.
 * Created to handle crops which grow upwards beyond a single block and the lower block must be in water.
 */
public class WaterCropsBlock extends TallCropsBlock implements ILiquidContainer {

	public WaterCropsBlock(Supplier<Item> seedsIn) {
		super(seedsIn);
	}
	
	/*
	 * Minecraft Methods
	 */
	
	@Override
	public FluidState getFluidState(BlockState stateIn) {
		if (stateIn.getValue(HALF) == DoubleBlockHalf.LOWER) {
			return Fluids.WATER.getSource(false);
		} else {
			return Fluids.EMPTY.defaultFluidState();
		}
	}
	
	@Override
	public boolean canSurvive(BlockState stateIn, IWorldReader worldIn, BlockPos posIn) {
		Boolean unobstructed;
		BlockPos ground = posIn.below();
		
		if (stateIn.getValue(HALF) == DoubleBlockHalf.LOWER) {
			if (stateIn.getValue(AGE) <= 3) {
				unobstructed = isAir(worldIn.getBlockState(posIn.above()));
			} else {
				if (worldIn.getBlockState(posIn.above()).getBlock() == this) {
					unobstructed = worldIn.getBlockState(posIn.above()).getValue(HALF) == DoubleBlockHalf.UPPER;
				} else {
					unobstructed = false;
				}
			}
			return mayPlaceOn(worldIn.getBlockState(ground), worldIn, ground) && unobstructed;
		} else {
			if (worldIn.getBlockState(ground).getBlock() == this) {
				return worldIn.getBlockState(ground).getValue(HALF) == DoubleBlockHalf.LOWER && worldIn.getBlockState(ground).getValue(AGE) >= 4;
			} else {
				return false;
			}
		}
	}
	
	@Override
	protected boolean mayPlaceOn(BlockState stateIn, IBlockReader worldIn, BlockPos posIn) {
		FluidState fluidstate = worldIn.getFluidState(posIn.above());
		if (fluidstate.getType() == Fluids.WATER) {
			return ((stateIn.is(Blocks.GRASS_BLOCK) || stateIn.is(Blocks.DIRT)
					|| stateIn.is(Blocks.COARSE_DIRT) || stateIn.is(Blocks.PODZOL)));
		} else if (stateIn.is(this)) {
			return stateIn.getValue(HALF) == DoubleBlockHalf.LOWER && stateIn.getValue(AGE) >= 4;
		} else {
			return false;
		}
	}
	
	@Override
	public boolean canPlaceLiquid(IBlockReader worldIn, BlockPos posIn, BlockState stateIn, Fluid fluidIn) {
		return false;
	}

	@Override
	public boolean placeLiquid(IWorld worldIn, BlockPos posIn, BlockState stateIn, FluidState fluidStateIn) {
		return false;
	}
}