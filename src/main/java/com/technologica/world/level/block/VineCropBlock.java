package com.technologica.world.level.block;

import java.util.function.Supplier;

import com.technologica.world.item.TechnologicaItems;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
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
import net.minecraft.world.level.material.Material;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

/**
 * Special one-off class for vine crops. Created to handle crops which grow upwards beyond a single block.
 */
public class VineCropBlock extends CropBlock {
	private Supplier<Item> seeds;
	public static final BooleanProperty TRELLIS = BlockStateProperties.ATTACHED;
	public static final EnumProperty<DoubleBlockHalf> HALF = BlockStateProperties.DOUBLE_BLOCK_HALF;
	private static final VoxelShape[] SHAPE_BY_AGE_LOWER = new VoxelShape[] { Block.box(0.0D, 0.0D, 0.0D, 16.0D, 4.0D, 16.0D), Block.box(0.0D, 0.0D, 0.0D, 16.0D, 8.0D, 16.0D), Block.box(0.0D, 0.0D, 0.0D, 16.0D, 12.0D, 16.0D), Block.box(0.0D, 0.0D, 0.0D, 16.0D, 16.0D, 16.0D), Block.box(0.0D, 0.0D, 0.0D, 16.0D, 16.0D, 16.0D), Block.box(0.0D, 0.0D, 0.0D, 16.0D, 16.0D, 16.0D), Block.box(0.0D, 0.0D, 0.0D, 16.0D, 16.0D, 16.0D), Block.box(0.0D, 0.0D, 0.0D, 16.0D, 16.0D, 16.0D) };
	private static final VoxelShape[] SHAPE_BY_AGE_UPPER = new VoxelShape[] { Block.box(0.0D, 0.0D, 0.0D, 16.0D, 0.0D, 16.0D), Block.box(0.0D, 0.0D, 0.0D, 16.0D, 0.0D, 16.0D), Block.box(0.0D, 0.0D, 0.0D, 16.0D, 0.0D, 16.0D), Block.box(0.0D, 0.0D, 0.0D, 16.0D, 0.0D, 16.0D), Block.box(0.0D, 0.0D, 0.0D, 16.0D, 4.0D, 16.0D), Block.box(0.0D, 0.0D, 0.0D, 16.0D, 8.0D, 16.0D), Block.box(0.0D, 0.0D, 0.0D, 16.0D, 12.0D, 16.0D), Block.box(0.0D, 0.0D, 0.0D, 16.0D, 16.0D, 16.0D) };

	public VineCropBlock(Supplier<Item> seedsIn) {
		super(BlockBehaviour.Properties.of(Material.PLANT).noCollission().randomTicks().instabreak().sound(SoundType.CROP));
		this.registerDefaultState(this.stateDefinition.any().setValue(HALF, DoubleBlockHalf.LOWER).setValue(AGE, 0).setValue(TRELLIS, false));
		seeds = seedsIn;
	}

	/*
	 * Minecraft Methods
	 */

	@Override
	public boolean canSurvive(BlockState stateIn, LevelReader worldIn, BlockPos posIn) {
		Boolean unobstructed;
		BlockPos ground = posIn.below();

		if (!worldIn.getBlockState(posIn.north()).isFaceSturdy(worldIn, posIn.north(), Direction.SOUTH) && !worldIn.getBlockState(posIn.east()).isFaceSturdy(worldIn, posIn.east(), Direction.WEST) && !worldIn.getBlockState(posIn.south()).isFaceSturdy(worldIn, posIn.south(), Direction.NORTH) && !worldIn.getBlockState(posIn.west()).isFaceSturdy(worldIn, posIn.west(), Direction.EAST) && !stateIn.getValue(TRELLIS)) {
			return false;
		}

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
	protected boolean mayPlaceOn(BlockState p_51042_, BlockGetter p_51043_, BlockPos p_51044_) {
		return p_51042_.is(BlockTags.DIRT) || p_51042_.is(Blocks.FARMLAND);
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
		if (p_57273_ instanceof LivingEntity && p_57273_.getType() != EntityType.FOX && p_57273_.getType() != EntityType.BEE) {
			p_57273_.makeStuckInBlock(p_57270_, new Vec3(0.8F, 0.75D, 0.8F));
			if (!p_57271_.isClientSide && p_57270_.getValue(AGE) > 0 && (p_57273_.xOld != p_57273_.getX() || p_57273_.zOld != p_57273_.getZ())) {
				double d0 = Math.abs(p_57273_.getX() - p_57273_.xOld);
				double d1 = Math.abs(p_57273_.getZ() - p_57273_.zOld);
				if (d0 >= 0.003F || d1 >= 0.003F) {
					p_57273_.hurt(DamageSource.SWEET_BERRY_BUSH, 1.0F);
				}
			}

		}
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
			popResource(p_57276_, p_57277_, new ItemStack(seeds.get(), j + (flag ? 1 : 0)));
			p_57276_.playSound((Player) null, p_57277_, SoundEvents.SWEET_BERRY_BUSH_PICK_BERRIES, SoundSource.BLOCKS, 1.0F, 0.8F + p_57276_.random.nextFloat() * 0.4F);
			BlockState blockstate = p_57275_.setValue(AGE, Integer.valueOf(6));
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
