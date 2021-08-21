package com.technologica.block;

import java.util.Random;
import java.util.function.Supplier;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.CropsBlock;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.state.EnumProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.state.properties.DoubleBlockHalf;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Direction;
import net.minecraft.util.IItemProvider;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.IWorldReader;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;

public class TallCropsBlock extends CropsBlock {
	private Supplier<Item> seeds;
	public static final EnumProperty<DoubleBlockHalf> HALF = BlockStateProperties.DOUBLE_BLOCK_HALF;
	private static final VoxelShape[] SHAPE_BY_AGE_LOWER = new VoxelShape[] {
			Block.makeCuboidShape(0.0D, 0.0D, 0.0D, 16.0D, 4.0D, 16.0D),
			Block.makeCuboidShape(0.0D, 0.0D, 0.0D, 16.0D, 8.0D, 16.0D),
			Block.makeCuboidShape(0.0D, 0.0D, 0.0D, 16.0D, 12.0D, 16.0D),
			Block.makeCuboidShape(0.0D, 0.0D, 0.0D, 16.0D, 16.0D, 16.0D),
			Block.makeCuboidShape(0.0D, 0.0D, 0.0D, 16.0D, 16.0D, 16.0D),
			Block.makeCuboidShape(0.0D, 0.0D, 0.0D, 16.0D, 16.0D, 16.0D),
			Block.makeCuboidShape(0.0D, 0.0D, 0.0D, 16.0D, 16.0D, 16.0D),
			Block.makeCuboidShape(0.0D, 0.0D, 0.0D, 16.0D, 16.0D, 16.0D) };
	private static final VoxelShape[] SHAPE_BY_AGE_UPPER = new VoxelShape[] {
			Block.makeCuboidShape(0.0D, 0.0D, 0.0D, 16.0D, 0.0D, 16.0D),
			Block.makeCuboidShape(0.0D, 0.0D, 0.0D, 16.0D, 0.0D, 16.0D),
			Block.makeCuboidShape(0.0D, 0.0D, 0.0D, 16.0D, 0.0D, 16.0D),
			Block.makeCuboidShape(0.0D, 0.0D, 0.0D, 16.0D, 0.0D, 16.0D),
			Block.makeCuboidShape(0.0D, 0.0D, 0.0D, 16.0D, 4.0D, 16.0D),
			Block.makeCuboidShape(0.0D, 0.0D, 0.0D, 16.0D, 8.0D, 16.0D),
			Block.makeCuboidShape(0.0D, 0.0D, 0.0D, 16.0D, 12.0D, 16.0D),
			Block.makeCuboidShape(0.0D, 0.0D, 0.0D, 16.0D, 16.0D, 16.0D) };

	public TallCropsBlock(Supplier<Item> seedsIn) {
		super(AbstractBlock.Properties.create(Material.PLANTS).doesNotBlockMovement().tickRandomly().zeroHardnessAndResistance().sound(SoundType.CROP));
		seeds = seedsIn;
		this.setDefaultState(this.stateContainer.getBaseState().with(HALF, DoubleBlockHalf.LOWER).with(AGE, 0));
	}

	@Override
	public VoxelShape getShape(BlockState stateIn, IBlockReader worldIn, BlockPos posIn, ISelectionContext contextIn) {
		if (stateIn.get(HALF) == DoubleBlockHalf.LOWER) {
			return SHAPE_BY_AGE_LOWER[stateIn.get(this.getAgeProperty())];
		} else {
			return SHAPE_BY_AGE_UPPER[stateIn.get(this.getAgeProperty())];
		}
	}

	@Override
	public boolean isValidPosition(BlockState state, IWorldReader worldIn, BlockPos pos) {
	      BlockPos blockpos = pos.down();
	      if (state.getBlock() == this) {
	         return worldIn.getBlockState(blockpos).canSustainPlant(worldIn, blockpos, Direction.UP, this);
	      }
	      return isValidGround(worldIn.getBlockState(blockpos), worldIn, blockpos);
	   }
	
	@Override
	protected boolean isValidGround(BlockState stateIn, IBlockReader worldIn, BlockPos posIn) {
		if (stateIn.matchesBlock(Blocks.FARMLAND)) {
			return stateIn.matchesBlock(Blocks.FARMLAND) && worldIn.getBlockState(posIn.offset(Direction.UP, 2)).getBlock() == Blocks.AIR;
		} else if (stateIn.matchesBlock(this)) {
			return stateIn.get(HALF) == DoubleBlockHalf.LOWER && stateIn.get(AGE) >= 4;
		} else {
			return false;
		}
	}

	@Override
	public boolean ticksRandomly(BlockState stateIn) {
		return !this.isMaxAge(stateIn) && stateIn.get(HALF) == DoubleBlockHalf.LOWER;
	}
	
	@Override
	public void randomTick(BlockState stateIn, ServerWorld worldIn, BlockPos posIn, Random randomIn) {
		if (!worldIn.isAreaLoaded(posIn, 1)) return;
		if (worldIn.getLightSubtracted(posIn, 0) >= 9) {
			int i = this.getAge(stateIn);
			if (i < this.getMaxAge()) {
				float f = getGrowthChance(this, worldIn, posIn);
				if (net.minecraftforge.common.ForgeHooks.onCropsGrowPre(worldIn, posIn, stateIn, randomIn.nextInt((int) (25.0F / f) + 1) == 0)) {
					worldIn.setBlockState(posIn, this.withAge(i + 1).with(HALF, stateIn.get(HALF)), 2);

					if (stateIn.get(HALF) == DoubleBlockHalf.LOWER && worldIn.isAirBlock(posIn.up()) && i + 1 >= 4) {
						worldIn.setBlockState(posIn.up(), this.withAge(i + 1).with(HALF, DoubleBlockHalf.UPPER), 2);
					}

					if (worldIn.getBlockState(posIn.up()).getBlock() instanceof TallCropsBlock) {
						worldIn.setBlockState(posIn.up(), this.withAge(i + 1).with(HALF, DoubleBlockHalf.UPPER), 2);
					}

					net.minecraftforge.common.ForgeHooks.onCropsGrowPost(worldIn, posIn, stateIn);
				}
			}
		}
	}
	
	@Override
	public void grow(World worldIn, BlockPos posIn, BlockState stateIn) {
		int i = this.getAge(stateIn) + this.getBonemealAgeIncrease(worldIn);
		int j = this.getMaxAge();
		if (i > j) {
			i = j;
		}

		worldIn.setBlockState(posIn, this.withAge(i).with(HALF, stateIn.get(HALF)), 2);

		if (i >= 4 && worldIn.isAirBlock(posIn.up()) && stateIn.get(HALF) == DoubleBlockHalf.LOWER) {
			worldIn.setBlockState(posIn.up(), this.withAge(i).with(HALF, DoubleBlockHalf.UPPER), 2);
		}

		if (worldIn.getBlockState(posIn.up()).matchesBlock(this)) {
			worldIn.setBlockState(posIn.up(), this.withAge(i).with(HALF, DoubleBlockHalf.UPPER), 2);
		}
		
		if (stateIn.get(HALF) == DoubleBlockHalf.UPPER) {
			worldIn.setBlockState(posIn.down(), this.withAge(i).with(HALF, DoubleBlockHalf.LOWER), 2);
		}
	}

	@Override
	public void onBlockHarvested(World worldIn, BlockPos pos, BlockState state, PlayerEntity player) {
		if (!worldIn.isRemote) {
			if (player.isCreative()) {
				removeBottomHalf(worldIn, pos, state, player);
			} else {
				spawnDrops(state, worldIn, pos, (TileEntity) null, player, player.getHeldItemMainhand());
			}
		}

		super.onBlockHarvested(worldIn, pos, state, player);
	}

	protected static void removeBottomHalf(World world, BlockPos pos, BlockState state, PlayerEntity player) {
		DoubleBlockHalf doubleblockhalf = state.get(HALF);
		if (doubleblockhalf == DoubleBlockHalf.UPPER) {
			BlockPos blockpos = pos.down();
			BlockState blockstate = world.getBlockState(blockpos);
			if (blockstate.getBlock() == state.getBlock() && blockstate.get(HALF) == DoubleBlockHalf.LOWER) {
				world.setBlockState(blockpos, Blocks.AIR.getDefaultState(), 35);
				world.playEvent(player, 2001, blockpos, Block.getStateId(blockstate));
			}
		}
	}

	@Override
	protected IItemProvider getSeedsItem() {
	      return seeds.get();
	   }
	
	@Override
	protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builder) {
		builder.add(HALF);
		super.fillStateContainer(builder);
	}
}
