package com.technologica.world.level.block;

import java.util.Optional;

import com.technologica.registration.deferred.TechnologicaBlocks;
import com.technologica.registration.deferred.TechnologicaFeatures;
import com.technologica.registration.deferred.TechnologicaParticleTypes;
import com.technologica.registration.dynamic.TechnologicaBiomes;
import com.technologica.registration.dynamic.TechnologicaDimensions;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.BubbleColumnBlock;
import net.minecraft.world.level.block.BucketPickup;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

/**
 * This class is effectively a clone of {@link BubbleColumnBlock} with the following changes:
 * <ul>
 * Removed the {@link BubbleColumnBlock#DRAG_DOWN} BlockStateProperty because this block will always push entities up.
 * <p>
 * Changed all instances of {@link Blocks#BUBBLE_COLUMN} to {@link TechnologicaBlocks#SMOKE_COLUMN} because this block has no interaction with BUBBLE_COLUMN.
 * <p>
 * Changed all instances of {@link Blocks#MAGMA_BLOCK} to {@link TechnologicaBlocks#MOLTEN_CORE} because this block spawns on MOLTEN_CORE when under water, not MAGMA_BLOCK.
 * <p>
 * Removed all instances of {@link Blocks#SOUL_SAND} because this block has no interaction with SOUL_SAND.
 * <p>
 * Changed {@link SmokeColumnBlock#animateTick} to spawn {@link TechnologicaParticleTypes#SMOKE_COLUMN_UP} and use sound event {@link SoundEvents#CANDLE_EXTINGUISH}.
 * </ul>
 * This class was created to add functionality to the {@link TechnologicaBlocks#MOLTEN_CORE} block primarily when it spawns as part of the {@link TechnologicaFeatures#HYDROTHERMAL_VENT} feature in the {@link TechnologicaBiomes#HYDROTHERMAL_CAVERN} biome of the {@link TechnologicaDimensions#CHALLENGER_DEEP_STEM} dimension.
 * 
 * @tl.status BLUE
 */
public class SmokeColumnBlock extends Block implements BucketPickup {

	public SmokeColumnBlock(BlockBehaviour.Properties properties) {
		super(properties);
		this.registerDefaultState(this.stateDefinition.any());
	}

	@Override
	public void entityInside(BlockState blockState, Level level, BlockPos blockPos, Entity entity) {
		BlockState blockStateAbove = level.getBlockState(blockPos.above());
		if (blockStateAbove.isAir()) {
			entity.onAboveBubbleCol(false);
			if (!level.isClientSide) {
				ServerLevel serverlevel = (ServerLevel) level;
				for (int i = 0; i < 2; ++i) {
					serverlevel.sendParticles(ParticleTypes.SPLASH, blockPos.getX() + level.random.nextDouble(), (double) (blockPos.getY() + 1), blockPos.getZ() + level.random.nextDouble(), 1, 0.0D, 0.0D, 0.0D, 1.0D);
					serverlevel.sendParticles(ParticleTypes.BUBBLE, blockPos.getX() + level.random.nextDouble(), (double) (blockPos.getY() + 1), blockPos.getZ() + level.random.nextDouble(), 1, 0.0D, 0.01D, 0.0D, 0.2D);
				}
			}
		} else {
			entity.onInsideBubbleColumn(false);
		}
	}

	@Override
	public void tick(BlockState blockState, ServerLevel level, BlockPos blockPos, RandomSource random) {
		updateColumn(level, blockPos, blockState, level.getBlockState(blockPos.below()));
	}

	@Override
	public FluidState getFluidState(BlockState blockState) {
		return Fluids.WATER.getSource(false);
	}

	public static void updateColumn(LevelAccessor levelAccessor, BlockPos blockPos, BlockState blockStateBelow) {
		updateColumn(levelAccessor, blockPos, levelAccessor.getBlockState(blockPos), blockStateBelow);
	}

	public static void updateColumn(LevelAccessor levelAccessor, BlockPos blockPos, BlockState blockState, BlockState blockStateBelow) {
		if (canExistIn(blockState)) {
			BlockState blockstate = getColumnState(blockStateBelow);
			levelAccessor.setBlock(blockPos, blockstate, 2);
			BlockPos.MutableBlockPos blockpos$mutableblockpos = blockPos.mutable().move(Direction.UP);
			while (canExistIn(levelAccessor.getBlockState(blockpos$mutableblockpos))) {
				if (!levelAccessor.setBlock(blockpos$mutableblockpos, blockstate, 2)) {
					return;
				}
				blockpos$mutableblockpos.move(Direction.UP);
			}
		}
	}

	private static boolean canExistIn(BlockState blockState) {
		return blockState.is(TechnologicaBlocks.SMOKE_COLUMN.get()) || blockState.is(Blocks.WATER) && blockState.getFluidState().getAmount() >= 8 && blockState.getFluidState().isSource();
	}

	private static BlockState getColumnState(BlockState blockStateBelow) {
		if (blockStateBelow.is(TechnologicaBlocks.SMOKE_COLUMN.get())) {
			return blockStateBelow;
		} else {
			return blockStateBelow.is(TechnologicaBlocks.MOLTEN_CORE.get()) ? TechnologicaBlocks.SMOKE_COLUMN.get().defaultBlockState() : Blocks.WATER.defaultBlockState();
		}
	}

	@Override
	public void animateTick(BlockState blockState, Level level, BlockPos blockPos, RandomSource randomSource) {
		double d0 = blockPos.getX();
		double d1 = blockPos.getY();
		double d2 = blockPos.getZ();
		level.addAlwaysVisibleParticle(TechnologicaParticleTypes.SMOKE_COLUMN_UP.get(), d0 + 0.5D, d1, d2 + 0.5D, 0.0D, 0.04D, 0.0D);
		level.addAlwaysVisibleParticle(TechnologicaParticleTypes.SMOKE_COLUMN_UP.get(), d0 + randomSource.nextFloat(), d1 + randomSource.nextFloat(), d2 + randomSource.nextFloat(), 0.0D, 0.04D, 0.0D);
		if (randomSource.nextInt(200) == 0) {
			level.playLocalSound(d0, d1, d2, SoundEvents.CANDLE_EXTINGUISH, SoundSource.BLOCKS, 10.0F + randomSource.nextFloat() * 0.2F, 0.1F + randomSource.nextFloat() * 0.15F, false);
		}
	}

	@SuppressWarnings("deprecation")
	@Override
	public BlockState updateShape(BlockState blockState, Direction direction, BlockState blockStateCausedUpdate, LevelAccessor levelAccessor, BlockPos blockPos, BlockPos blockPosCausedUpdate) {
		levelAccessor.scheduleTick(blockPos, Fluids.WATER, Fluids.WATER.getTickDelay(levelAccessor));
		if (!blockState.canSurvive(levelAccessor, blockPos) || direction == Direction.DOWN || direction == Direction.UP && !blockStateCausedUpdate.is(TechnologicaBlocks.SMOKE_COLUMN.get()) && canExistIn(blockStateCausedUpdate)) {
			levelAccessor.scheduleTick(blockPos, this, 5);
		}
		return super.updateShape(blockState, direction, blockStateCausedUpdate, levelAccessor, blockPos, blockPosCausedUpdate);
	}

	@Override
	public boolean canSurvive(BlockState blockState, LevelReader levelReader, BlockPos blockPos) {
		BlockState blockStateBelow = levelReader.getBlockState(blockPos.below());
		return blockStateBelow.is(TechnologicaBlocks.SMOKE_COLUMN.get()) || blockStateBelow.is(TechnologicaBlocks.MOLTEN_CORE.get());
	}

	@Override
	public VoxelShape getShape(BlockState blockState, BlockGetter blockGetter, BlockPos blockPos, CollisionContext collisionContext) {
		return Shapes.empty();
	}

	@Override
	public RenderShape getRenderShape(BlockState blockState) {
		return RenderShape.INVISIBLE;
	}

	@Override
	public ItemStack pickupBlock(LevelAccessor levelAccessor, BlockPos blockPos, BlockState blockState) {
		levelAccessor.setBlock(blockPos, Blocks.AIR.defaultBlockState(), 11);
		return new ItemStack(Items.WATER_BUCKET);
	}

	@Override
	public Optional<SoundEvent> getPickupSound() {
		return Fluids.WATER.getPickupSound();
	}
}
