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
			BlockState blockstate = level.getBlockState(blockPos);
			BlockPos blockpos = blockPos.above();
			BlockState blockstate1 = level.getBlockState(blockpos);
			FluidState fluidstate = this.getNewLiquid(level, blockpos, blockstate1);
			if (this.canSpreadTo(level, blockPos, blockstate, Direction.UP, blockpos, blockstate1, level.getFluidState(blockpos), fluidstate.getType())) {
				this.spreadTo(level, blockpos, blockstate1, Direction.UP, fluidstate);
				if (this.sourceNeighborCount(level, blockPos) >= 3) {
					this.spreadToSides(level, blockPos, fluidState, blockstate);
				}
			} else if (fluidState.isSource() || !this.isWaterHole(level, fluidstate.getType(), blockPos, blockstate, blockpos, blockstate1)) {
				this.spreadToSides(level, blockPos, fluidState, blockstate);
			}

		}
	}

	@Override
	protected FluidState getNewLiquid(Level p_256464_, BlockPos p_76037_, BlockState p_76038_) {
		int i = 0;
		int j = 0;

		for (Direction direction : Direction.Plane.HORIZONTAL) {
			BlockPos blockpos = p_76037_.relative(direction);
			BlockState blockstate = p_256464_.getBlockState(blockpos);
			FluidState fluidstate = blockstate.getFluidState();
			if (fluidstate.getType().isSame(this) && this.canPassThroughWall(direction, p_256464_, p_76037_, p_76038_, blockpos, blockstate)) {
				if (fluidstate.isSource() && net.minecraftforge.event.ForgeEventFactory.canCreateFluidSource(p_256464_, blockpos, blockstate, fluidstate.canConvertToSource(p_256464_, blockpos))) {
					++j;
				}

				i = Math.max(i, fluidstate.getAmount());
			}
		}

		if (j >= 2) {
			BlockState blockstate1 = p_256464_.getBlockState(p_76037_.below());
			FluidState fluidstate1 = blockstate1.getFluidState();
			if (blockstate1.isSolid() || this.isSourceBlockOfThisType(fluidstate1)) {
				return this.getSource(false);
			}
		}

		BlockPos blockpos1 = p_76037_.below();
		BlockState blockstate2 = p_256464_.getBlockState(blockpos1);
		FluidState fluidstate2 = blockstate2.getFluidState();
		if (!fluidstate2.isEmpty() && fluidstate2.getType().isSame(this) && this.canPassThroughWall(Direction.UP, p_256464_, p_76037_, p_76038_, blockpos1, blockstate2)) {
			return this.getFlowing(8, true);
		} else {
			int k = i - this.getDropOff(p_256464_);
			return k <= 0 ? Fluids.EMPTY.defaultFluidState() : this.getFlowing(k, false);
		}
	}

	private void spreadToSides(Level p_256644_, BlockPos p_76016_, FluidState p_76017_, BlockState p_76018_) {
		int i = p_76017_.getAmount() - this.getDropOff(p_256644_);
		if (p_76017_.getValue(FALLING)) {
			i = 7;
		}

		if (i > 0) {
			Map<Direction, FluidState> map = this.getSpread(p_256644_, p_76016_, p_76018_);

			for (Map.Entry<Direction, FluidState> entry : map.entrySet()) {
				Direction direction = entry.getKey();
				FluidState fluidstate = entry.getValue();
				BlockPos blockpos = p_76016_.relative(direction);
				BlockState blockstate = p_256644_.getBlockState(blockpos);
				if (this.canSpreadTo(p_256644_, p_76016_, p_76018_, direction, blockpos, blockstate, p_256644_.getFluidState(blockpos), fluidstate.getType())) {
					this.spreadTo(p_256644_, blockpos, blockstate, direction, fluidstate);
				}
			}

		}
	}

	@Override
	protected Map<Direction, FluidState> getSpread(Level p_256191_, BlockPos p_76081_, BlockState p_76082_) {
		int i = 1000;
		Map<Direction, FluidState> map = Maps.newEnumMap(Direction.class);
		Short2ObjectMap<Pair<BlockState, FluidState>> short2objectmap = new Short2ObjectOpenHashMap<>();
		Short2BooleanMap short2booleanmap = new Short2BooleanOpenHashMap();

		for (Direction direction : Direction.Plane.HORIZONTAL) {
			BlockPos blockpos = p_76081_.relative(direction);
			short short1 = getCacheKey(p_76081_, blockpos);
			Pair<BlockState, FluidState> pair = short2objectmap.computeIfAbsent(short1, (p_284929_) -> {
				BlockState blockstate1 = p_256191_.getBlockState(blockpos);
				return Pair.of(blockstate1, blockstate1.getFluidState());
			});
			BlockState blockstate = pair.getFirst();
			FluidState fluidstate = pair.getSecond();
			FluidState fluidstate1 = this.getNewLiquid(p_256191_, blockpos, blockstate);
			if (this.canPassThrough(p_256191_, fluidstate1.getType(), p_76081_, p_76082_, direction, blockpos, blockstate, fluidstate)) {
				BlockPos blockpos1 = blockpos.above();
				boolean flag = short2booleanmap.computeIfAbsent(short1, (p_255612_) -> {
					BlockState blockstate1 = p_256191_.getBlockState(blockpos1);
					return this.isWaterHole(p_256191_, this.getFlowing(), blockpos, blockstate, blockpos1, blockstate1);
				});
				int j;
				if (flag) {
					j = 0;
				} else {
					j = this.getSlopeDistance(p_256191_, blockpos, 1, direction.getOpposite(), blockstate, p_76081_, short2objectmap, short2booleanmap);
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

	@Override
	protected int getSlopeDistance(LevelReader p_76027_, BlockPos p_76028_, int p_76029_, Direction p_76030_, BlockState p_76031_, BlockPos p_76032_, Short2ObjectMap<Pair<BlockState, FluidState>> p_76033_, Short2BooleanMap p_76034_) {
		int i = 1000;

		for (Direction direction : Direction.Plane.HORIZONTAL) {
			if (direction != p_76030_) {
				BlockPos blockpos = p_76028_.relative(direction);
				short short1 = getCacheKey(p_76032_, blockpos);
				Pair<BlockState, FluidState> pair = p_76033_.computeIfAbsent(short1, (p_284932_) -> {
					BlockState blockstate1 = p_76027_.getBlockState(blockpos);
					return Pair.of(blockstate1, blockstate1.getFluidState());
				});
				BlockState blockstate = pair.getFirst();
				FluidState fluidstate = pair.getSecond();
				if (this.canPassThrough(p_76027_, this.getFlowing(), p_76028_, p_76031_, direction, blockpos, blockstate, fluidstate)) {
					boolean flag = p_76034_.computeIfAbsent(short1, (p_192912_) -> {
						BlockPos blockpos1 = blockpos.above();
						BlockState blockstate1 = p_76027_.getBlockState(blockpos1);
						return this.isWaterHole(p_76027_, this.getFlowing(), blockpos, blockstate, blockpos1, blockstate1);
					});
					if (flag) {
						return p_76029_;
					}

					if (p_76029_ < this.getSlopeFindDistance(p_76027_)) {
						int j = this.getSlopeDistance(p_76027_, blockpos, p_76029_ + 1, direction.getOpposite(), blockstate, p_76032_, p_76033_, p_76034_);
						if (j < i) {
							i = j;
						}
					}
				}
			}
		}

		return i;
	}

	private boolean canPassThrough(BlockGetter p_75964_, Fluid p_75965_, BlockPos p_75966_, BlockState p_75967_, Direction p_75968_, BlockPos p_75969_, BlockState p_75970_, FluidState p_75971_) {
		return !this.isSourceBlockOfThisType(p_75971_) && this.canPassThroughWall(p_75968_, p_75964_, p_75966_, p_75967_, p_75969_, p_75970_) && this.canHoldFluid(p_75964_, p_75969_, p_75970_, p_75965_);
	}

	private static short getCacheKey(BlockPos p_76059_, BlockPos p_76060_) {
		int i = p_76060_.getX() - p_76059_.getX();
		int j = p_76060_.getZ() - p_76059_.getZ();
		return (short) ((i + 128 & 255) << 8 | j + 128 & 255);
	}

	private int sourceNeighborCount(LevelReader p_76020_, BlockPos p_76021_) {
		int i = 0;

		for (Direction direction : Direction.Plane.HORIZONTAL) {
			BlockPos blockpos = p_76021_.relative(direction);
			FluidState fluidstate = p_76020_.getFluidState(blockpos);
			if (this.isSourceBlockOfThisType(fluidstate)) {
				++i;
			}
		}

		return i;
	}

	private boolean isWaterHole(BlockGetter p_75957_, Fluid p_75958_, BlockPos p_75959_, BlockState p_75960_, BlockPos p_75961_, BlockState p_75962_) {
		if (!this.canPassThroughWall(Direction.DOWN, p_75957_, p_75959_, p_75960_, p_75961_, p_75962_)) {
			return false;
		} else {
			return p_75962_.getFluidState().getType().isSame(this) ? true : this.canHoldFluid(p_75957_, p_75961_, p_75962_, p_75958_);
		}
	}

	private boolean canPassThroughWall(Direction p_76062_, BlockGetter p_76063_, BlockPos p_76064_, BlockState p_76065_, BlockPos p_76066_, BlockState p_76067_) {
		Object2ByteLinkedOpenHashMap<Block.BlockStatePairKey> object2bytelinkedopenhashmap;
		if (!p_76065_.getBlock().hasDynamicShape() && !p_76067_.getBlock().hasDynamicShape()) {
			object2bytelinkedopenhashmap = OCCLUSION_CACHE.get();
		} else {
			object2bytelinkedopenhashmap = null;
		}

		Block.BlockStatePairKey block$blockstatepairkey;
		if (object2bytelinkedopenhashmap != null) {
			block$blockstatepairkey = new Block.BlockStatePairKey(p_76065_, p_76067_, p_76062_);
			byte b0 = object2bytelinkedopenhashmap.getAndMoveToFirst(block$blockstatepairkey);
			if (b0 != 127) {
				return b0 != 0;
			}
		} else {
			block$blockstatepairkey = null;
		}

		VoxelShape voxelshape1 = p_76065_.getCollisionShape(p_76063_, p_76064_);
		VoxelShape voxelshape = p_76067_.getCollisionShape(p_76063_, p_76066_);
		boolean flag = !Shapes.mergedFaceOccludes(voxelshape1, voxelshape, p_76062_);
		if (object2bytelinkedopenhashmap != null) {
			if (object2bytelinkedopenhashmap.size() == 200) {
				object2bytelinkedopenhashmap.removeLastByte();
			}

			object2bytelinkedopenhashmap.putAndMoveToFirst(block$blockstatepairkey, (byte) (flag ? 1 : 0));
		}

		return flag;
	}

	private boolean canHoldFluid(BlockGetter p_75973_, BlockPos p_75974_, BlockState p_75975_, Fluid p_75976_) {
		Block block = p_75975_.getBlock();
		if (block instanceof LiquidBlockContainer) {
			return ((LiquidBlockContainer) block).canPlaceLiquid(p_75973_, p_75974_, p_75975_, p_75976_);
		} else if (!(block instanceof DoorBlock) && !p_75975_.is(BlockTags.SIGNS) && !p_75975_.is(Blocks.LADDER) && !p_75975_.is(Blocks.SUGAR_CANE) && !p_75975_.is(Blocks.BUBBLE_COLUMN)) {
			if (!p_75975_.is(Blocks.NETHER_PORTAL) && !p_75975_.is(Blocks.END_PORTAL) && !p_75975_.is(Blocks.END_GATEWAY) && !p_75975_.is(Blocks.STRUCTURE_VOID)) {
				return !p_75975_.blocksMotion();
			} else {
				return false;
			}
		} else {
			return false;
		}
	}

	private boolean isSourceBlockOfThisType(FluidState p_76097_) {
		return p_76097_.getType().isSame(this) && p_76097_.isSource();
	}
}