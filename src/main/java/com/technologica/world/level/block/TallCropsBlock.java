package com.technologica.world.level.block;

import java.util.function.Supplier;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.CropBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.DoubleBlockHalf;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

/**
 * Special one-off class for tall crops. Created to handle crops which grow upwards beyond a single block.
 */
public class TallCropsBlock extends CropBlock {
	private Supplier<Item> seeds;
	public static final EnumProperty<DoubleBlockHalf> HALF = BlockStateProperties.DOUBLE_BLOCK_HALF;
	private static final VoxelShape[] SHAPE_BY_AGE_LOWER = new VoxelShape[] { Block.box(0.0D, 0.0D, 0.0D, 16.0D, 4.0D, 16.0D), Block.box(0.0D, 0.0D, 0.0D, 16.0D, 8.0D, 16.0D), Block.box(0.0D, 0.0D, 0.0D, 16.0D, 12.0D, 16.0D), Block.box(0.0D, 0.0D, 0.0D, 16.0D, 16.0D, 16.0D), Block.box(0.0D, 0.0D, 0.0D, 16.0D, 16.0D, 16.0D), Block.box(0.0D, 0.0D, 0.0D, 16.0D, 16.0D, 16.0D), Block.box(0.0D, 0.0D, 0.0D, 16.0D, 16.0D, 16.0D), Block.box(0.0D, 0.0D, 0.0D, 16.0D, 16.0D, 16.0D) };
	private static final VoxelShape[] SHAPE_BY_AGE_UPPER = new VoxelShape[] { Block.box(0.0D, 0.0D, 0.0D, 16.0D, 0.0D, 16.0D), Block.box(0.0D, 0.0D, 0.0D, 16.0D, 0.0D, 16.0D), Block.box(0.0D, 0.0D, 0.0D, 16.0D, 0.0D, 16.0D), Block.box(0.0D, 0.0D, 0.0D, 16.0D, 0.0D, 16.0D), Block.box(0.0D, 0.0D, 0.0D, 16.0D, 4.0D, 16.0D), Block.box(0.0D, 0.0D, 0.0D, 16.0D, 8.0D, 16.0D), Block.box(0.0D, 0.0D, 0.0D, 16.0D, 12.0D, 16.0D), Block.box(0.0D, 0.0D, 0.0D, 16.0D, 16.0D, 16.0D) };

	public TallCropsBlock(Supplier<Item> seedsIn) {
		super(BlockBehaviour.Properties.of(Material.PLANT).noCollission().randomTicks().instabreak().sound(SoundType.CROP));
		this.registerDefaultState(this.stateDefinition.any().setValue(HALF, DoubleBlockHalf.LOWER).setValue(AGE, 0));
		seeds = seedsIn;
	}

	/*
	 * Minecraft Methods
	 */

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
	public VoxelShape getShape(BlockState stateIn, BlockGetter worldIn, BlockPos posIn, CollisionContext contextIn) {
		if (stateIn.getValue(HALF) == DoubleBlockHalf.LOWER) {
			return SHAPE_BY_AGE_LOWER[stateIn.getValue(this.getAgeProperty())];
		} else {
			return SHAPE_BY_AGE_UPPER[stateIn.getValue(this.getAgeProperty())];
		}
	}

	@SuppressWarnings("deprecation")
	@Override
	public void randomTick(BlockState stateIn, ServerLevel worldIn, BlockPos posIn, RandomSource randomIn) {
		if (!worldIn.isAreaLoaded(posIn, 1))
			return;
		if (worldIn.getRawBrightness(posIn, 0) >= 9) {
			int i = this.getAge(stateIn);
			if (i < this.getMaxAge()) {
				float f = getGrowthSpeed(this, worldIn, posIn);
				if (net.minecraftforge.common.ForgeHooks.onCropsGrowPre(worldIn, posIn, stateIn, randomIn.nextInt((int) (25.0F / f) + 1) == 0)) {
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
	protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builderIn) {
		builderIn.add(HALF);
		super.createBlockStateDefinition(builderIn);
	}

	@Override
	public void growCrops(Level worldIn, BlockPos posIn, BlockState stateIn) {
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

	@Override
	protected ItemLike getBaseSeedId() {
		return seeds.get();
	}
}
