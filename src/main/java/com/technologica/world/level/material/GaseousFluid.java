package com.technologica.world.level.material;

import java.util.Map;

import com.google.common.collect.Maps;
import com.mojang.datafixers.util.Pair;

import it.unimi.dsi.fastutil.objects.Object2ByteLinkedOpenHashMap;
import it.unimi.dsi.fastutil.shorts.Short2BooleanMap;
import it.unimi.dsi.fastutil.shorts.Short2BooleanOpenHashMap;
import it.unimi.dsi.fastutil.shorts.Short2ObjectMap;
import it.unimi.dsi.fastutil.shorts.Short2ObjectOpenHashMap;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.DoorBlock;
import net.minecraft.world.level.block.LiquidBlockContainer;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.FlowingFluid;
import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

public abstract class GaseousFluid extends FlowingFluid {
	private static final ThreadLocal<Object2ByteLinkedOpenHashMap<Block.BlockStatePairKey>> OCCLUSION_CACHE = ThreadLocal.withInitial(() -> {
		Object2ByteLinkedOpenHashMap<Block.BlockStatePairKey> object2bytelinkedopenhashmap = new Object2ByteLinkedOpenHashMap<Block.BlockStatePairKey>(200) {
			@Override
			protected void rehash(int p_76102_) {
			}
		};
		object2bytelinkedopenhashmap.defaultReturnValue((byte) 127);
		return object2bytelinkedopenhashmap;
	});

	@Override
	protected void spread(Level level, BlockPos blockPos, FluidState fluidState) {
		if (!fluidState.isEmpty()) {
			BlockState blockState = level.getBlockState(blockPos);
			BlockPos blockPosAbove = blockPos.above();
			BlockState blockStateAbove = level.getBlockState(blockPosAbove);
			FluidState fluidstate = this.getNewLiquid(level, blockPosAbove, blockStateAbove);

			if (this.canSpreadTo(level, blockPos, blockState, Direction.UP, blockPosAbove, blockStateAbove, level.getFluidState(blockPosAbove), fluidstate.getType())) {
				this.spreadTo(level, blockPosAbove, blockStateAbove, Direction.UP, fluidstate);
				if (this.sourceNeighborCount(level, blockPos) >= 3) {
					this.spreadToSides(level, blockPos, fluidState, blockState);
				}
			} else if (fluidState.isSource() || !this.isWaterHole(level, fluidstate.getType(), blockPos, blockState, blockPosAbove, blockStateAbove)) {
				this.spreadToSides(level, blockPos, fluidState, blockState);
			}

		}
	}

	@Override
	protected FluidState getNewLiquid(Level level, BlockPos blockPos, BlockState blockState) {
		int i = 0;
		int j = 0;

		for (Direction direction : Direction.Plane.HORIZONTAL) {
			BlockPos blockpos = blockPos.relative(direction);
			BlockState blockstate = level.getBlockState(blockpos);
			FluidState fluidstate = blockstate.getFluidState();
			if (fluidstate.getType().isSame(this) && this.canPassThroughWall(direction, level, blockPos, blockState, blockpos, blockstate)) {
				if (fluidstate.isSource() && net.minecraftforge.event.ForgeEventFactory.canCreateFluidSource(level, blockpos, blockstate, fluidstate.canConvertToSource(level, blockpos))) {
					++j;
				}

				i = Math.max(i, fluidstate.getAmount());
			}
		}

		if (j >= 2) {
			BlockState blockstate1 = level.getBlockState(blockPos.below());
			FluidState fluidstate1 = blockstate1.getFluidState();
			if (blockstate1.isSolid() || this.isSourceBlockOfThisType(fluidstate1)) {
				return this.getSource(false);
			}
		}

		BlockPos blockPosBelow = blockPos.below();
		BlockState blockStateBelow = level.getBlockState(blockPosBelow);
		FluidState fluidStateBelow = blockStateBelow.getFluidState();
		if (!fluidStateBelow.isEmpty() && fluidStateBelow.getType().isSame(this) && this.canPassThroughWall(Direction.UP, level, blockPos, blockState, blockPosBelow, blockStateBelow)) {
			int k = fluidStateBelow.getAmount() - this.getDropOff(level);
			return k <= 0 ? Fluids.EMPTY.defaultFluidState() : this.getFlowing(k, true);
		} else {
			int k = i - this.getDropOff(level);
			return k <= 0 ? Fluids.EMPTY.defaultFluidState() : this.getFlowing(k, false);
		}
	}

	private void spreadToSides(Level level, BlockPos blockPos, FluidState fluidState, BlockState blockState) {
		int i = fluidState.getAmount() - this.getDropOff(level);
		if (fluidState.getValue(FALLING)) {
			i = 7;
		}

		if (i > 0) {
			Map<Direction, FluidState> map = this.getSpread(level, blockPos, blockState);

			for (Map.Entry<Direction, FluidState> entry : map.entrySet()) {
				Direction direction = entry.getKey();
				FluidState fluidstate = entry.getValue();
				BlockPos blockpos = blockPos.relative(direction);
				BlockState blockstate = level.getBlockState(blockpos);
				if (this.canSpreadTo(level, blockPos, blockState, direction, blockpos, blockstate, level.getFluidState(blockpos), fluidstate.getType())) {
					this.spreadTo(level, blockpos, blockstate, direction, fluidstate);
				}
			}

		}
	}

	@Override
	protected Map<Direction, FluidState> getSpread(Level level, BlockPos blockPos, BlockState blockState) {
		int i = 1000;
		Map<Direction, FluidState> map = Maps.newEnumMap(Direction.class);
		Short2ObjectMap<Pair<BlockState, FluidState>> short2objectmap = new Short2ObjectOpenHashMap<>();
		Short2BooleanMap short2booleanmap = new Short2BooleanOpenHashMap();

		for (Direction direction : Direction.Plane.HORIZONTAL) {
			BlockPos blockpos = blockPos.relative(direction);
			short short1 = getCacheKey(blockPos, blockpos);
			Pair<BlockState, FluidState> pair = short2objectmap.computeIfAbsent(short1, (p_284929_) -> {
				BlockState blockstate1 = level.getBlockState(blockpos);
				return Pair.of(blockstate1, blockstate1.getFluidState());
			});
			BlockState blockstate = pair.getFirst();
			FluidState fluidstate = pair.getSecond();
			FluidState fluidstate1 = this.getNewLiquid(level, blockpos, blockstate);
			if (this.canPassThrough(level, fluidstate1.getType(), blockPos, blockState, direction, blockpos, blockstate, fluidstate)) {
				BlockPos blockpos1 = blockpos.above();
				boolean flag = short2booleanmap.computeIfAbsent(short1, (p_255612_) -> {
					BlockState blockstate1 = level.getBlockState(blockpos1);
					return this.isWaterHole(level, this.getFlowing(), blockpos, blockstate, blockpos1, blockstate1);
				});
				int j;
				if (flag) {
					j = 0;
				} else {
					j = this.getSlopeDistance(level, blockpos, 1, direction.getOpposite(), blockstate, blockPos, short2objectmap, short2booleanmap);
				}

				if (j < i) {
					map.clear();
				}

				if (j <= i) {
					map.put(direction, fluidstate1);
					i = j;
				}
			}
		}

		return map;
	}

	// Merely required because super class method is private.
	private boolean canPassThroughWall(Direction direction, BlockGetter level, BlockPos p_76064_, BlockState blockState, BlockPos p_76066_, BlockState p_76067_) {
		Object2ByteLinkedOpenHashMap<Block.BlockStatePairKey> object2bytelinkedopenhashmap;
		if (!blockState.getBlock().hasDynamicShape() && !p_76067_.getBlock().hasDynamicShape()) {
			object2bytelinkedopenhashmap = OCCLUSION_CACHE.get();
		} else {
			object2bytelinkedopenhashmap = null;
		}

		Block.BlockStatePairKey block$blockstatepairkey;
		if (object2bytelinkedopenhashmap != null) {
			block$blockstatepairkey = new Block.BlockStatePairKey(blockState, p_76067_, direction);
			byte b0 = object2bytelinkedopenhashmap.getAndMoveToFirst(block$blockstatepairkey);
			if (b0 != 127) {
				return b0 != 0;
			}
		} else {
			block$blockstatepairkey = null;
		}

		VoxelShape voxelshape1 = blockState.getCollisionShape(level, p_76064_);
		VoxelShape voxelshape = p_76067_.getCollisionShape(level, p_76066_);
		boolean flag = !Shapes.mergedFaceOccludes(voxelshape1, voxelshape, direction);
		if (object2bytelinkedopenhashmap != null) {
			if (object2bytelinkedopenhashmap.size() == 200) {
				object2bytelinkedopenhashmap.removeLastByte();
			}

			object2bytelinkedopenhashmap.putAndMoveToFirst(block$blockstatepairkey, (byte) (flag ? 1 : 0));
		}

		return flag;
	}

	// Merely required because super class method is private.
	private static short getCacheKey(BlockPos blockPos, BlockPos p_76060_) {
		int i = p_76060_.getX() - blockPos.getX();
		int j = p_76060_.getZ() - blockPos.getZ();
		return (short) ((i + 128 & 255) << 8 | j + 128 & 255);
	}

	@Override
	protected int getSlopeDistance(LevelReader level, BlockPos p_76028_, int p_76029_, Direction directionIn, BlockState blockState, BlockPos p_76032_, Short2ObjectMap<Pair<BlockState, FluidState>> p_76033_, Short2BooleanMap p_76034_) {
		int i = 1000;

		for (Direction direction : Direction.Plane.HORIZONTAL) {
			if (direction != directionIn) {
				BlockPos blockpos = p_76028_.relative(direction);
				short short1 = getCacheKey(p_76032_, blockpos);
				Pair<BlockState, FluidState> pair = p_76033_.computeIfAbsent(short1, (p_284932_) -> {
					BlockState blockstate1 = level.getBlockState(blockpos);
					return Pair.of(blockstate1, blockstate1.getFluidState());
				});
				BlockState blockstate = pair.getFirst();
				FluidState fluidstate = pair.getSecond();
				if (this.canPassThrough(level, this.getFlowing(), p_76028_, blockState, direction, blockpos, blockstate, fluidstate)) {
					boolean flag = p_76034_.computeIfAbsent(short1, (p_192912_) -> {
						BlockPos blockpos1 = blockpos.above();
						BlockState blockstate1 = level.getBlockState(blockpos1);
						return this.isWaterHole(level, this.getFlowing(), blockpos, blockstate, blockpos1, blockstate1);
					});
					if (flag) {
						return p_76029_;
					}

					if (p_76029_ < this.getSlopeFindDistance(level)) {
						int j = this.getSlopeDistance(level, blockpos, p_76029_ + 1, direction.getOpposite(), blockstate, p_76032_, p_76033_, p_76034_);
						if (j < i) {
							i = j;
						}
					}
				}
			}
		}

		return i;
	}

	// Merely required because super class method is private.
	private boolean isWaterHole(BlockGetter level, Fluid fluid, BlockPos p_75959_, BlockState blockState, BlockPos p_75961_, BlockState p_75962_) {
		if (!this.canPassThroughWall(Direction.DOWN, level, p_75959_, blockState, p_75961_, p_75962_)) {
			return false;
		} else {
			return p_75962_.getFluidState().getType().isSame(this) ? true : this.canHoldFluid(level, p_75961_, p_75962_, fluid);
		}
	}

	// Merely required because super class method is private.
	private boolean canPassThrough(BlockGetter level, Fluid fluid, BlockPos p_75966_, BlockState blockState, Direction p_75968_, BlockPos p_75969_, BlockState p_75970_, FluidState p_75971_) {
		return !this.isSourceBlockOfThisType(p_75971_) && this.canPassThroughWall(p_75968_, level, p_75966_, blockState, p_75969_, p_75970_) && this.canHoldFluid(level, p_75969_, p_75970_, fluid);
	}

	// Merely required because super class method is private.
	private boolean isSourceBlockOfThisType(FluidState fluidState) {
		return fluidState.getType().isSame(this) && fluidState.isSource();
	}

	// Merely required because super class method is private.
	private int sourceNeighborCount(LevelReader level, BlockPos blockPos) {
		int i = 0;

		for (Direction direction : Direction.Plane.HORIZONTAL) {
			BlockPos blockpos = blockPos.relative(direction);
			FluidState fluidstate = level.getFluidState(blockpos);
			if (this.isSourceBlockOfThisType(fluidstate)) {
				++i;
			}
		}

		return i;
	}

	// Merely required because super class method is private.
	private boolean canHoldFluid(BlockGetter level, BlockPos blockPos, BlockState blockState, Fluid fluid) {
		Block block = blockState.getBlock();
		if (block instanceof LiquidBlockContainer) {
			return ((LiquidBlockContainer) block).canPlaceLiquid(level, blockPos, blockState, fluid);
		} else if (!(block instanceof DoorBlock) && !blockState.is(BlockTags.SIGNS) && !blockState.is(Blocks.LADDER) && !blockState.is(Blocks.SUGAR_CANE) && !blockState.is(Blocks.BUBBLE_COLUMN)) {
			if (!blockState.is(Blocks.NETHER_PORTAL) && !blockState.is(Blocks.END_PORTAL) && !blockState.is(Blocks.END_GATEWAY) && !blockState.is(Blocks.STRUCTURE_VOID)) {
				return !blockState.blocksMotion();
			} else {
				return false;
			}
		} else {
			return false;
		}
	}

	protected static int getLegacyLevel(FluidState p_76093_) {
		return p_76093_.isSource() ? 0 : 8 - Math.min(p_76093_.getAmount(), 8) + (p_76093_.getValue(FALLING) ? 0 : 0);
	}
}
