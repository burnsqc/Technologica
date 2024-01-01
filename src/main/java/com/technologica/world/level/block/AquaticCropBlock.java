package com.technologica.world.level.block;

import java.util.function.Supplier;

import net.minecraft.core.BlockPos;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.LiquidBlockContainer;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.DoubleBlockHalf;
import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluids;

/**
 * Special one-off class for water crops. Created to handle crops which grow upwards beyond a single block and the lower block must be in water.
 */
public class AquaticCropBlock extends TallCropBlock implements LiquidBlockContainer {

	public AquaticCropBlock(Supplier<Item> seedsIn) {
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
	public boolean canSurvive(BlockState stateIn, LevelReader worldIn, BlockPos posIn) {
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
	protected boolean mayPlaceOn(BlockState stateIn, BlockGetter worldIn, BlockPos posIn) {
		FluidState fluidstate = worldIn.getFluidState(posIn.above());
		if (fluidstate.getType() == Fluids.WATER) {
			return stateIn.is(BlockTags.DIRT) || stateIn.is(Blocks.FARMLAND);
		} else if (stateIn.is(this)) {
			return stateIn.getValue(HALF) == DoubleBlockHalf.LOWER && stateIn.getValue(AGE) >= 4;
		} else {
			return false;
		}
	}

	@Override
	public boolean canPlaceLiquid(BlockGetter worldIn, BlockPos posIn, BlockState stateIn, Fluid fluidIn) {
		return false;
	}

	@Override
	public boolean placeLiquid(LevelAccessor worldIn, BlockPos posIn, BlockState stateIn, FluidState fluidStateIn) {
		return false;
	}
}