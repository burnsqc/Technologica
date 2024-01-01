package com.technologica.world.level.block;

import java.util.function.Supplier;

import com.technologica.registration.deferred.TechnologicaBlocks;
import com.technologica.registration.deferred.TechnologicaItems;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
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
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.DoubleBlockHalf;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

/**
 * Special one-off class for vine crops. Created to handle crops which grow upwards beyond a single block.
 */
public class VineCropBlock extends CropBlock {
	private Supplier<Item> seeds;
	private Supplier<Item> yield;
	public static final BooleanProperty TRELLIS = BlockStateProperties.ATTACHED;
	public static final EnumProperty<DoubleBlockHalf> HALF = BlockStateProperties.DOUBLE_BLOCK_HALF;
	private static final VoxelShape[] SHAPE_BY_AGE_LOWER = new VoxelShape[] { Block.box(0.0D, 0.0D, 0.0D, 16.0D, 4.0D, 16.0D), Block.box(0.0D, 0.0D, 0.0D, 16.0D, 8.0D, 16.0D), Block.box(0.0D, 0.0D, 0.0D, 16.0D, 12.0D, 16.0D), Block.box(0.0D, 0.0D, 0.0D, 16.0D, 16.0D, 16.0D), Block.box(0.0D, 0.0D, 0.0D, 16.0D, 16.0D, 16.0D), Block.box(0.0D, 0.0D, 0.0D, 16.0D, 16.0D, 16.0D), Block.box(0.0D, 0.0D, 0.0D, 16.0D, 16.0D, 16.0D), Block.box(0.0D, 0.0D, 0.0D, 16.0D, 16.0D, 16.0D) };
	private static final VoxelShape[] SHAPE_BY_AGE_UPPER = new VoxelShape[] { Block.box(0.0D, 0.0D, 0.0D, 16.0D, 0.0D, 16.0D), Block.box(0.0D, 0.0D, 0.0D, 16.0D, 0.0D, 16.0D), Block.box(0.0D, 0.0D, 0.0D, 16.0D, 0.0D, 16.0D), Block.box(0.0D, 0.0D, 0.0D, 16.0D, 0.0D, 16.0D), Block.box(0.0D, 0.0D, 0.0D, 16.0D, 4.0D, 16.0D), Block.box(0.0D, 0.0D, 0.0D, 16.0D, 8.0D, 16.0D), Block.box(0.0D, 0.0D, 0.0D, 16.0D, 12.0D, 16.0D), Block.box(0.0D, 0.0D, 0.0D, 16.0D, 16.0D, 16.0D) };

	public VineCropBlock(Supplier<Item> seedsIn, Supplier<Item> yieldIn) {
		super(BlockBehaviour.Properties.of().noCollission().randomTicks().instabreak().sound(SoundType.CROP));
		this.registerDefaultState(this.stateDefinition.any().setValue(HALF, DoubleBlockHalf.LOWER).setValue(AGE, 0).setValue(TRELLIS, false));
		this.seeds = seedsIn;
		this.yield = yieldIn;
	}

	/*
	 * Minecraft Methods
	 */

	@Override
	public boolean canSurvive(BlockState stateIn, LevelReader worldIn, BlockPos posIn) {
		Boolean isContinuous = false;
		if (!worldIn.isClientSide()) {
			if (!stateIn.getValue(TRELLIS)) {
				return false;
			}

			if (stateIn.getValue(HALF) == DoubleBlockHalf.LOWER) {
				if (worldIn.getBlockState(posIn.above()).getBlock() == this) {
					isContinuous = worldIn.getBlockState(posIn.above()).getValue(HALF) == DoubleBlockHalf.UPPER;
				}
				return worldIn.getBlockState(posIn.below()).canSustainPlant(worldIn, posIn.below(), Direction.UP, this) && isContinuous;
			} else {
				if (worldIn.getBlockState(posIn.below()).getBlock() == this) {
					isContinuous = worldIn.getBlockState(posIn.below()).getValue(HALF) == DoubleBlockHalf.LOWER;
					return worldIn.getBlockState(posIn.below()).getValue(AGE) >= 4 && isContinuous || worldIn.getBlockState(posIn.below()).getValue(TRELLIS);
				}
				return false;
			}
		} else {
			return false;
		}
	}

	@Override
	public VoxelShape getShape(BlockState stateIn, BlockGetter worldIn, BlockPos posIn, CollisionContext contextIn) {
		if (stateIn.getValue(TRELLIS)) {
			return SHAPE_BY_AGE_LOWER[7];
		}
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
					worldIn.setBlock(posIn, this.getStateForAge(i + 1).setValue(HALF, stateIn.getValue(HALF)).setValue(TRELLIS, stateIn.getValue(TRELLIS)), 2);

					if (stateIn.getValue(HALF) == DoubleBlockHalf.LOWER && (worldIn.isEmptyBlock(posIn.above()) || worldIn.getBlockState(posIn.above()).is(TechnologicaBlocks.TRELLIS.get())) && i + 1 >= 4) {
						worldIn.setBlock(posIn.above(), this.getStateForAge(i + 1).setValue(HALF, DoubleBlockHalf.UPPER).setValue(TRELLIS, stateIn.getValue(TRELLIS)), 2);
					}

					if (worldIn.getBlockState(posIn.above()).getBlock() instanceof VineCropBlock) {
						worldIn.setBlock(posIn.above(), this.getStateForAge(i + 1).setValue(HALF, DoubleBlockHalf.UPPER).setValue(TRELLIS, stateIn.getValue(TRELLIS)), 2);
					}

					net.minecraftforge.common.ForgeHooks.onCropsGrowPost(worldIn, posIn, stateIn);
				}
			}
		}
	}

	@Override
	public void entityInside(BlockState p_57270_, Level p_57271_, BlockPos p_57272_, Entity p_57273_) {
		p_57273_.makeStuckInBlock(p_57270_, new Vec3(0.8F, 0.75D, 0.8F));
	}

	@SuppressWarnings("deprecation")
	@Override
	public InteractionResult use(BlockState p_57275_, Level p_57276_, BlockPos p_57277_, Player p_57278_, InteractionHand p_57279_, BlockHitResult p_57280_) {
		int i = p_57275_.getValue(AGE);
		boolean flag = i == 7;
		if (!flag && p_57278_.getItemInHand(p_57279_).is(Items.BONE_MEAL)) {
			return InteractionResult.PASS;
		} else if (p_57278_.getItemInHand(p_57279_).is(TechnologicaItems.TRELLIS.get()) && !p_57275_.getValue(TRELLIS)) {
			p_57276_.setBlock(p_57277_, p_57275_.setValue(TRELLIS, true), 3);
			return InteractionResult.sidedSuccess(p_57276_.isClientSide);
		} else if (i > 6) {
			int j = 1 + p_57276_.random.nextInt(2);
			popResource(p_57276_, p_57277_, new ItemStack(yield.get(), j + (flag ? 1 : 0)));
			p_57276_.playSound((Player) null, p_57277_, SoundEvents.SWEET_BERRY_BUSH_PICK_BERRIES, SoundSource.BLOCKS, 1.0F, 0.8F + p_57276_.random.nextFloat() * 0.4F);
			BlockState blockstate = p_57275_.setValue(AGE, 5);

			if (p_57275_.getValue(HALF) == DoubleBlockHalf.LOWER) {
				p_57276_.setBlock(p_57277_.above(), blockstate.setValue(HALF, DoubleBlockHalf.UPPER), 2);
			} else {
				p_57276_.setBlock(p_57277_.below(), blockstate.setValue(HALF, DoubleBlockHalf.LOWER), 2);
			}

			p_57276_.setBlock(p_57277_, blockstate, 2);
			p_57276_.gameEvent(GameEvent.BLOCK_CHANGE, p_57277_, GameEvent.Context.of(p_57278_, blockstate));
			return InteractionResult.sidedSuccess(p_57276_.isClientSide);
		} else {
			return super.use(p_57275_, p_57276_, p_57277_, p_57278_, p_57279_, p_57280_);
		}
	}

	@Override
	public boolean isRandomlyTicking(BlockState stateIn) {
		return !this.isMaxAge(stateIn) && stateIn.getValue(HALF) == DoubleBlockHalf.LOWER;
	}

	@Override
	protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builderIn) {
		builderIn.add(HALF).add(TRELLIS);
		super.createBlockStateDefinition(builderIn);
	}

	@Override
	public void growCrops(Level worldIn, BlockPos posIn, BlockState stateIn) {
		int i = this.getAge(stateIn) + this.getBonemealAgeIncrease(worldIn);
		int j = this.getMaxAge();
		if (i > j) {
			i = j;
		}

		worldIn.setBlock(posIn, this.getStateForAge(i).setValue(HALF, stateIn.getValue(HALF)).setValue(TRELLIS, stateIn.getValue(TRELLIS)), 2);

		if (stateIn.getValue(HALF) == DoubleBlockHalf.LOWER && (worldIn.isEmptyBlock(posIn.above()) || worldIn.getBlockState(posIn.above()).is(TechnologicaBlocks.TRELLIS.get())) && i + 1 >= 4) {
			worldIn.setBlock(posIn.above(), this.getStateForAge(i).setValue(HALF, DoubleBlockHalf.UPPER).setValue(TRELLIS, stateIn.getValue(TRELLIS)), 2);
		}

		if (worldIn.getBlockState(posIn.above()).getBlock() instanceof VineCropBlock) {
			worldIn.setBlock(posIn.above(), this.getStateForAge(i).setValue(HALF, DoubleBlockHalf.UPPER).setValue(TRELLIS, stateIn.getValue(TRELLIS)), 2);
		}

		if (stateIn.getValue(HALF) == DoubleBlockHalf.UPPER) {
			worldIn.setBlock(posIn.below(), this.getStateForAge(i).setValue(HALF, DoubleBlockHalf.LOWER).setValue(TRELLIS, stateIn.getValue(TRELLIS)), 2);
		}
	}

	@Override
	protected ItemLike getBaseSeedId() {
		return seeds.get();
	}
}
