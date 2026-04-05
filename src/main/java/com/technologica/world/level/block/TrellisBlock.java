package com.technologica.world.level.block;

import javax.annotation.Nullable;

import com.technologica.registration.deferred.TechnologicaBlocks;
import com.technologica.registration.deferred.TechnologicaItems;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.DoubleBlockHalf;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.phys.BlockHitResult;

public class TrellisBlock extends Block {
	public static final EnumProperty<DoubleBlockHalf> HALF = BlockStateProperties.DOUBLE_BLOCK_HALF;

	public TrellisBlock() {
		super(BlockBehaviour.Properties.of().noCollission().instabreak().instabreak().sound(SoundType.METAL));
		this.registerDefaultState(this.stateDefinition.any().setValue(HALF, DoubleBlockHalf.LOWER));
	}

	@SuppressWarnings("deprecation")
	@Override
	public BlockState updateShape(BlockState blockState, Direction direction, BlockState blockStateNeighbor, LevelAccessor levelAccessor, BlockPos blockPos, BlockPos blockPosNeighbor) {
		DoubleBlockHalf doubleblockhalf = blockState.getValue(HALF);
		if (direction.getAxis() != Direction.Axis.Y || doubleblockhalf == DoubleBlockHalf.LOWER != (direction == Direction.UP) || blockStateNeighbor.is(this) && blockStateNeighbor.getValue(HALF) != doubleblockhalf) {
			return doubleblockhalf == DoubleBlockHalf.LOWER && direction == Direction.DOWN && !blockState.canSurvive(levelAccessor, blockPos) ? Blocks.AIR.defaultBlockState() : super.updateShape(blockState, direction, blockStateNeighbor, levelAccessor, blockPos, blockPosNeighbor);
		} else {
			if (levelAccessor.getBlockState(blockPos.below()).getBlock() instanceof VineCropBlock) {
				if (levelAccessor.getBlockState(blockPos.below()).getValue(VineCropBlock.TRELLIS)) {
					return super.updateShape(blockState, direction, blockStateNeighbor, levelAccessor, blockPos, blockPosNeighbor);
				} else {
					return Blocks.AIR.defaultBlockState();
				}
			} else {
				return Blocks.AIR.defaultBlockState();
			}

		}
	}

	@Override
	@Nullable
	public BlockState getStateForPlacement(BlockPlaceContext blockPlaceContext) {
		BlockPos blockpos = blockPlaceContext.getClickedPos();
		Level level = blockPlaceContext.getLevel();
		return blockpos.getY() < level.getMaxBuildHeight() - 1 && level.getBlockState(blockpos.above()).canBeReplaced(blockPlaceContext) ? super.getStateForPlacement(blockPlaceContext) : null;
	}

	@Override
	public void setPlacedBy(Level level, BlockPos blockPos, BlockState blockState, LivingEntity livingEntity, ItemStack itemStack) {
		BlockPos blockpos = blockPos.above();
		level.setBlock(blockpos, this.defaultBlockState().setValue(HALF, DoubleBlockHalf.UPPER), 3);
	}

	@Override
	public boolean canSurvive(BlockState blockState, LevelReader levelReader, BlockPos blockPos) {
		if (blockState.getValue(HALF) == DoubleBlockHalf.LOWER) {
			if (levelReader.getBlockState(blockPos.below()).getBlock() == Blocks.FARMLAND) {
				return true;
			} else {
				return false;
			}
		} else {
			if (levelReader.getBlockState(blockPos.below()).getBlock() == this) {
				return true;
			} else {
				return false;
			}
		}
	}

	@Override
	public void playerWillDestroy(Level level, BlockPos blockPos, BlockState blockState, Player player) {
		if (!level.isClientSide) {
			if (player.isCreative()) {
				preventCreativeDropFromBottomPart(level, blockPos, blockState, player);
			} else {
				dropResources(blockState, level, blockPos, (BlockEntity) null, player, player.getMainHandItem());
			}
		}
		super.playerWillDestroy(level, blockPos, blockState, player);
	}

	@Override
	public void playerDestroy(Level level, Player player, BlockPos blockPos, BlockState blockState, @Nullable BlockEntity blockEntity, ItemStack itemStack) {
		super.playerDestroy(level, player, blockPos, Blocks.AIR.defaultBlockState(), blockEntity, itemStack);
	}

	protected static void preventCreativeDropFromBottomPart(Level level, BlockPos blockPos, BlockState blockState, Player player) {
		DoubleBlockHalf doubleblockhalf = blockState.getValue(HALF);
		if (doubleblockhalf == DoubleBlockHalf.UPPER) {
			BlockPos blockpos = blockPos.below();
			BlockState blockstate = level.getBlockState(blockpos);
			if (blockstate.is(blockState.getBlock()) && blockstate.getValue(HALF) == DoubleBlockHalf.LOWER) {
				level.setBlock(blockpos, Blocks.AIR.defaultBlockState(), 35);
				level.levelEvent(player, 2001, blockpos, Block.getId(blockstate));
			}
		}
	}

	@SuppressWarnings("deprecation")
	@Override
	public InteractionResult use(BlockState blockState, Level level, BlockPos blockPos, Player player, InteractionHand interactionHand, BlockHitResult blockHitResult) {
		if (blockState.getValue(HALF) == DoubleBlockHalf.LOWER) {
			if (player.getItemInHand(interactionHand).is(TechnologicaItems.GRAPE_SEEDS.get())) {
				level.setBlock(blockPos, TechnologicaBlocks.GRAPES.get().defaultBlockState().setValue(VineCropBlock.TRELLIS, true), 3);
				level.setBlock(blockPos.above(), TechnologicaBlocks.GRAPES.get().defaultBlockState().setValue(VineCropBlock.HALF, DoubleBlockHalf.UPPER).setValue(VineCropBlock.AGE, 0).setValue(VineCropBlock.TRELLIS, true), 3);
				return InteractionResult.PASS;
			} else if (player.getItemInHand(interactionHand).is(TechnologicaItems.TOMATO_SEEDS.get())) {
				level.setBlock(blockPos, TechnologicaBlocks.TOMATOES.get().defaultBlockState().setValue(VineCropBlock.TRELLIS, true), 3);
				level.setBlock(blockPos.above(), TechnologicaBlocks.TOMATOES.get().defaultBlockState().setValue(VineCropBlock.HALF, DoubleBlockHalf.UPPER).setValue(VineCropBlock.AGE, 0).setValue(VineCropBlock.TRELLIS, true), 3);
				return InteractionResult.PASS;
			} else {
				return super.use(blockState, level, blockPos, player, interactionHand, blockHitResult);
			}
		} else {
			return super.use(blockState, level, blockPos, player, interactionHand, blockHitResult);
		}
	}

	@Override
	protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
		builder.add(HALF);
		super.createBlockStateDefinition(builder);
	}
}
