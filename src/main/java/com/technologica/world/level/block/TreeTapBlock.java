package com.technologica.world.level.block;

import java.util.Map;
import java.util.Optional;
import java.util.function.BiPredicate;
import java.util.function.Predicate;

import javax.annotation.Nullable;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Maps;
import com.technologica.core.particles.DrippingLiquidParticleData;
import com.technologica.registration.deferred.TechnologicaFluids;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.phys.shapes.BooleanOp;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.minecraftforge.registries.ForgeRegistries;

/**
 * Special one-off class for tree taps. Created to handle voxel shape and animation.
 */
public class TreeTapBlock extends FourDirectionBlock {
	private boolean dripping;
	private static final Map<Direction, VoxelShape> SHAPES = Maps.newEnumMap(ImmutableMap.of(Direction.NORTH, Block.box(6.0D, 6.0D, 11.0D, 10.0D, 11.0D, 16.0D), Direction.SOUTH, Block.box(6.0D, 6.0D, 0.0D, 10.0D, 11.0D, 5.0D), Direction.WEST, Block.box(11.0D, 6.0D, 6.0D, 16.0D, 11.0D, 10.0D), Direction.EAST, Block.box(0.0D, 6.0D, 6.0D, 5.0D, 11.0D, 10.0D)));
	private static final VoxelShape REQUIRED_SPACE_TO_DRIP_THROUGH_NON_SOLID_BLOCK = Block.box(6.0D, 0.0D, 6.0D, 10.0D, 16.0D, 10.0D);

	public TreeTapBlock() {
		super(BlockBehaviour.Properties.of().requiresCorrectToolForDrops().strength(5.0F).sound(SoundType.WOOD).noOcclusion());
		dripping = false;
	}

	/*
	 * Minecraft Methods
	 */

	@Override
	public VoxelShape getShape(BlockState stateIn, BlockGetter worldIn, BlockPos posIn, CollisionContext contextIn) {
		return SHAPES.get(stateIn.getValue(FourDirectionBlock.NESW_FACING));
	}

	@Override
	public void randomTick(BlockState stateIn, ServerLevel worldIn, BlockPos posIn, RandomSource randomIn) {
		if (worldIn.getBlockState(posIn.relative(stateIn.getValue(FourDirectionBlock.NESW_FACING).getOpposite())).getBlock() instanceof SapLogBlock) {

			Direction facing = stateIn.getValue(FourDirectionBlock.NESW_FACING);
			BlockState logState = worldIn.getBlockState(posIn.relative(facing.getOpposite()));

			if (logState.getValue(SapLogBlock.AGE) > 0) {
				if (ForgeRegistries.BLOCKS.getKey(logState.getBlock()).getPath().contains("maple")) {
					BlockPos basinBlockPos = findFillableEmptyBasinBelowTreeTapTip(worldIn, posIn, TechnologicaFluids.MAPLE_SYRUP.get());
					BlockPos basinBlockPos2 = findFillableBasinBelowTreeTapTip(worldIn, posIn, TechnologicaFluids.MAPLE_SYRUP.get());
					if (basinBlockPos != null) {
						BasinEmptyBlock basin = (BasinEmptyBlock) worldIn.getBlockState(basinBlockPos).getBlock();
						basin.receiveTreeTapDrip(worldIn.getBlockState(basinBlockPos), worldIn, basinBlockPos, TechnologicaFluids.MAPLE_SYRUP.get());
					}
					if (basinBlockPos2 != null) {
						BasinFilledBlock basin = (BasinFilledBlock) worldIn.getBlockState(basinBlockPos2).getBlock();
						basin.receiveTreeTapDrip(worldIn.getBlockState(basinBlockPos2), worldIn, basinBlockPos2, TechnologicaFluids.MAPLE_SYRUP.get());
					}
				} else {
					BlockPos basinBlockPos = findFillableEmptyBasinBelowTreeTapTip(worldIn, posIn, TechnologicaFluids.RUBBER_RESIN.get());
					BlockPos basinBlockPos2 = findFillableBasinBelowTreeTapTip(worldIn, posIn, TechnologicaFluids.RUBBER_RESIN.get());
					if (basinBlockPos != null) {
						BasinEmptyBlock basin = (BasinEmptyBlock) worldIn.getBlockState(basinBlockPos).getBlock();
						basin.receiveTreeTapDrip(worldIn.getBlockState(basinBlockPos), worldIn, basinBlockPos, TechnologicaFluids.RUBBER_RESIN.get());
					}
					if (basinBlockPos2 != null) {
						BasinFilledBlock basin = (BasinFilledBlock) worldIn.getBlockState(basinBlockPos2).getBlock();
						basin.receiveTreeTapDrip(worldIn.getBlockState(basinBlockPos2), worldIn, basinBlockPos2, TechnologicaFluids.RUBBER_RESIN.get());
					}
				}
				worldIn.setBlock(posIn.relative(stateIn.getValue(FourDirectionBlock.NESW_FACING).getOpposite()), logState.setValue(SapLogBlock.AGE, logState.getValue(SapLogBlock.AGE) - 1), 7);
				dripping = true;
			}
		}
	}

	@Override
	public boolean isRandomlyTicking(BlockState stateIn) {
		return true;
	}

	@Override
	public void animateTick(BlockState stateIn, Level levelIn, BlockPos posIn, RandomSource randomIn) {
		if (dripping) {
			double d0 = 0;
			double d1 = 0;
			double d2 = 0;

			Direction facing = stateIn.getValue(FourDirectionBlock.NESW_FACING);
			BlockState logState = levelIn.getBlockState(posIn.relative(facing.getOpposite()));

			switch (facing) {
			case EAST:
				d0 = posIn.getX() + 0.28D;
				d1 = posIn.getY() + 0.3D;
				d2 = posIn.getZ() + 0.5D;
				break;
			case NORTH:
				d0 = posIn.getX() + 0.5D;
				d1 = posIn.getY() + 0.3D;
				d2 = posIn.getZ() + 0.72D;
				break;
			case SOUTH:
				d0 = posIn.getX() + 0.5D;
				d1 = posIn.getY() + 0.3D;
				d2 = posIn.getZ() + 0.28D;
				break;
			case WEST:
				d0 = posIn.getX() + 0.72D;
				d1 = posIn.getY() + 0.3D;
				d2 = posIn.getZ() + 0.5D;
				break;
			default:
				break;
			}

			if (ForgeRegistries.BLOCKS.getKey(logState.getBlock()).getPath().contains("maple")) {
				levelIn.addParticle(DrippingLiquidParticleData.MAPLE_SYRUP, d0, d1, d2, 0.0D, 0.0D, 0.0D);
			} else {
				levelIn.addParticle(DrippingLiquidParticleData.RUBBER_RESIN, d0, d1, d2, 0.0D, 0.0D, 0.0D);
			}

			dripping = false;
		}
	}

	@Nullable
	private static BlockPos findFillableEmptyBasinBelowTreeTapTip(Level levelIn, BlockPos blockPosIn, Fluid fluidIn) {
		Predicate<BlockState> predicate = (p_154162_) -> {
			return p_154162_.getBlock() instanceof BasinEmptyBlock && ((BasinEmptyBlock) p_154162_.getBlock()).canReceiveTreeTapDrip(fluidIn);
		};
		BiPredicate<BlockPos, BlockState> bipredicate = (p_202034_, p_202035_) -> {
			return canDripThrough(levelIn, p_202034_, p_202035_);
		};
		return findBlockVertical(levelIn, blockPosIn, Direction.DOWN.getAxisDirection(), bipredicate, predicate, 11).orElse((BlockPos) null);
	}

	@Nullable
	private static BlockPos findFillableBasinBelowTreeTapTip(Level levelIn, BlockPos blockPosIn, Fluid fluidIn) {
		Predicate<BlockState> predicate = (p_154162_) -> {
			return p_154162_.getBlock() instanceof BasinFilledBlock && ((BasinFilledBlock) p_154162_.getBlock()).canReceiveTreeTapDrip(fluidIn);
		};
		BiPredicate<BlockPos, BlockState> bipredicate = (p_202034_, p_202035_) -> {
			return canDripThrough(levelIn, p_202034_, p_202035_);
		};
		return findBlockVertical(levelIn, blockPosIn, Direction.DOWN.getAxisDirection(), bipredicate, predicate, 11).orElse((BlockPos) null);
	}

	private static boolean canDripThrough(BlockGetter p_202018_, BlockPos p_202019_, BlockState p_202020_) {
		if (p_202020_.isAir()) {
			return true;
		} else if (p_202020_.isSolidRender(p_202018_, p_202019_)) {
			return false;
		} else if (!p_202020_.getFluidState().isEmpty()) {
			return false;
		} else {
			VoxelShape voxelshape = p_202020_.getCollisionShape(p_202018_, p_202019_);
			return !Shapes.joinIsNotEmpty(REQUIRED_SPACE_TO_DRIP_THROUGH_NON_SOLID_BLOCK, voxelshape, BooleanOp.AND);
		}
	}

	private static Optional<BlockPos> findBlockVertical(LevelAccessor p_202007_, BlockPos p_202008_, Direction.AxisDirection p_202009_, BiPredicate<BlockPos, BlockState> p_202010_, Predicate<BlockState> p_202011_, int p_202012_) {
		Direction direction = Direction.get(p_202009_, Direction.Axis.Y);
		BlockPos.MutableBlockPos blockpos$mutableblockpos = p_202008_.mutable();

		for (int i = 1; i < p_202012_; ++i) {
			blockpos$mutableblockpos.move(direction);
			BlockState blockstate = p_202007_.getBlockState(blockpos$mutableblockpos);
			if (p_202011_.test(blockstate)) {
				return Optional.of(blockpos$mutableblockpos.immutable());
			}

			if (p_202007_.isOutsideBuildHeight(blockpos$mutableblockpos.getY()) || !p_202010_.test(blockpos$mutableblockpos, blockstate)) {
				return Optional.empty();
			}
		}

		return Optional.empty();
	}
}