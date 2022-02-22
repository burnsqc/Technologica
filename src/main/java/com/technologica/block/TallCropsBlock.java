package com.technologica.block;

import java.util.Random;
import java.util.function.Supplier;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.item.Item;
import net.minecraft.state.EnumProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.state.properties.DoubleBlockHalf;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.IWorldReader;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;

/**
 * Special one-off class for tall crops.
 * Created to handle crops which grow upwards beyond a single block.
 */
public class TallCropsBlock extends VanillaCropsBlock {
	public static final EnumProperty<DoubleBlockHalf> HALF = BlockStateProperties.DOUBLE_BLOCK_HALF;
	private static final VoxelShape[] SHAPE_BY_AGE_LOWER = new VoxelShape[] {
			Block.box(0.0D, 0.0D, 0.0D, 16.0D, 4.0D, 16.0D),
			Block.box(0.0D, 0.0D, 0.0D, 16.0D, 8.0D, 16.0D),
			Block.box(0.0D, 0.0D, 0.0D, 16.0D, 12.0D, 16.0D),
			Block.box(0.0D, 0.0D, 0.0D, 16.0D, 16.0D, 16.0D),
			Block.box(0.0D, 0.0D, 0.0D, 16.0D, 16.0D, 16.0D),
			Block.box(0.0D, 0.0D, 0.0D, 16.0D, 16.0D, 16.0D),
			Block.box(0.0D, 0.0D, 0.0D, 16.0D, 16.0D, 16.0D),
			Block.box(0.0D, 0.0D, 0.0D, 16.0D, 16.0D, 16.0D) };
	private static final VoxelShape[] SHAPE_BY_AGE_UPPER = new VoxelShape[] {
			Block.box(0.0D, 0.0D, 0.0D, 16.0D, 0.0D, 16.0D),
			Block.box(0.0D, 0.0D, 0.0D, 16.0D, 0.0D, 16.0D),
			Block.box(0.0D, 0.0D, 0.0D, 16.0D, 0.0D, 16.0D),
			Block.box(0.0D, 0.0D, 0.0D, 16.0D, 0.0D, 16.0D),
			Block.box(0.0D, 0.0D, 0.0D, 16.0D, 4.0D, 16.0D),
			Block.box(0.0D, 0.0D, 0.0D, 16.0D, 8.0D, 16.0D),
			Block.box(0.0D, 0.0D, 0.0D, 16.0D, 12.0D, 16.0D),
			Block.box(0.0D, 0.0D, 0.0D, 16.0D, 16.0D, 16.0D) };

	public TallCropsBlock(Supplier<Item> seedsIn) {
		super(seedsIn);
		this.registerDefaultState(this.stateDefinition.any().setValue(HALF, DoubleBlockHalf.LOWER).setValue(AGE, 0));
	}

	/*
	 * Minecraft Methods
	 */
	
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
			return worldIn.getBlockState(ground).canSustainPlant(worldIn, ground, Direction.UP, this) && unobstructed;
		} else {
			if (worldIn.getBlockState(ground).getBlock() == this) {
				return worldIn.getBlockState(ground).getValue(HALF) == DoubleBlockHalf.LOWER && worldIn.getBlockState(ground).getValue(AGE) >= 4;
			} else {
				return false;
			}
		}
	}
	
	@Override
	public VoxelShape getShape(BlockState stateIn, IBlockReader worldIn, BlockPos posIn, ISelectionContext contextIn) {
		if (stateIn.getValue(HALF) == DoubleBlockHalf.LOWER) {
			return SHAPE_BY_AGE_LOWER[stateIn.getValue(this.getAgeProperty())];
		} else {
			return SHAPE_BY_AGE_UPPER[stateIn.getValue(this.getAgeProperty())];
		}
	}

	@Override
	public void randomTick(BlockState stateIn, ServerWorld worldIn, BlockPos posIn, Random randomIn) {
		if (!worldIn.isAreaLoaded(posIn, 1))
			return;
		if (worldIn.getRawBrightness(posIn, 0) >= 9) {
			int i = this.getAge(stateIn);
			if (i < this.getMaxAge()) {
				float f = getGrowthSpeed(this, worldIn, posIn);
				if (net.minecraftforge.common.ForgeHooks.onCropsGrowPre(worldIn, posIn, stateIn,
						randomIn.nextInt((int) (25.0F / f) + 1) == 0)) {
					worldIn.setBlock(posIn, this.getStateForAge(i + 1).setValue(HALF, stateIn.getValue(HALF)), 2);

					if (stateIn.getValue(HALF) == DoubleBlockHalf.LOWER && worldIn.isEmptyBlock(posIn.above()) && i + 1 >= 4) {
						worldIn.setBlock(posIn.above(), this.getStateForAge(i + 1).setValue(HALF, DoubleBlockHalf.UPPER), 2);
					}

					if (worldIn.getBlockState(posIn.above()).getBlock() instanceof TallCropsBlock) {
						worldIn.setBlock(posIn.above(), this.getStateForAge(i + 1).setValue(HALF, DoubleBlockHalf.UPPER), 2);
					}

					net.minecraftforge.common.ForgeHooks.onCropsGrowPost(worldIn, posIn, stateIn);
				}
			}
		}
	}
	
	@Override
	public boolean isRandomlyTicking(BlockState stateIn) {
		return !this.isMaxAge(stateIn) && stateIn.getValue(HALF) == DoubleBlockHalf.LOWER;
	}

	@Override
	protected void createBlockStateDefinition(StateContainer.Builder<Block, BlockState> builderIn) {
		builderIn.add(HALF);
		super.createBlockStateDefinition(builderIn);
	}
	
	@Override
	public void growCrops(World worldIn, BlockPos posIn, BlockState stateIn) {
		int i = this.getAge(stateIn) + this.getBonemealAgeIncrease(worldIn);
		int j = this.getMaxAge();
		if (i > j) {
			i = j;
		}

		worldIn.setBlock(posIn, this.getStateForAge(i).setValue(HALF, stateIn.getValue(HALF)), 2);

		if (i >= 4 && worldIn.isEmptyBlock(posIn.above()) && stateIn.getValue(HALF) == DoubleBlockHalf.LOWER) {
			worldIn.setBlock(posIn.above(), this.getStateForAge(i).setValue(HALF, DoubleBlockHalf.UPPER), 2);
		}

		if (worldIn.getBlockState(posIn.above()).is(this)) {
			worldIn.setBlock(posIn.above(), this.getStateForAge(i).setValue(HALF, DoubleBlockHalf.UPPER), 2);
		}

		if (stateIn.getValue(HALF) == DoubleBlockHalf.UPPER) {
			worldIn.setBlock(posIn.below(), this.getStateForAge(i).setValue(HALF, DoubleBlockHalf.LOWER), 2);
		}
	}
}
