package com.technologica.world.level.block;

import javax.annotation.Nullable;

import com.technologica.world.level.block.entity.DraftFurnaceBlockEntity;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.stats.Stats;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.BaseEntityBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.level.block.state.properties.DoubleBlockHalf;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.phys.BlockHitResult;

public class DraftFurnaceBlock extends BaseEntityBlock {
	public static final DirectionProperty NESW_FACING = BlockStateProperties.HORIZONTAL_FACING;
	public static final EnumProperty<DoubleBlockHalf> HALF = BlockStateProperties.DOUBLE_BLOCK_HALF;

	public DraftFurnaceBlock(BlockBehaviour.Properties properties) {
		super(properties);
		this.registerDefaultState(this.stateDefinition.any().setValue(NESW_FACING, Direction.NORTH));
	}

	@Override
	public RenderShape getRenderShape(BlockState iBlockState) {
		return RenderShape.MODEL;
	}

	@SuppressWarnings("deprecation")
	@Override
	public BlockState updateShape(BlockState blockState, Direction direction, BlockState neighborBlockState, LevelAccessor levelAccessor, BlockPos blockPos, BlockPos neighborBlockPos) {
		DoubleBlockHalf doubleblockhalf = blockState.getValue(HALF);
		if (direction.getAxis() == Direction.Axis.Y && doubleblockhalf == DoubleBlockHalf.LOWER == (direction == Direction.UP)) {
			return neighborBlockState.is(this) && neighborBlockState.getValue(HALF) != doubleblockhalf ? blockState.setValue(NESW_FACING, neighborBlockState.getValue(NESW_FACING)) : Blocks.AIR.defaultBlockState();
		} else {
			return doubleblockhalf == DoubleBlockHalf.LOWER && direction == Direction.DOWN && !blockState.canSurvive(levelAccessor, blockPos) ? Blocks.AIR.defaultBlockState() : super.updateShape(blockState, direction, neighborBlockState, levelAccessor, blockPos, neighborBlockPos);
		}
	}

	@Override
	public void playerWillDestroy(Level level, BlockPos blockPos, BlockState blockState, Player player) {
		if (!level.isClientSide && player.isCreative()) {
			this.preventCreativeDropFromBottomPart(level, blockPos, blockState, player);
		}
		super.playerWillDestroy(level, blockPos, blockState, player);
	}

	protected void preventCreativeDropFromBottomPart(Level level, BlockPos blockPos, BlockState blockState, Player player) {
		DoubleBlockHalf doubleblockhalf = blockState.getValue(HALF);
		if (doubleblockhalf == DoubleBlockHalf.UPPER) {
			BlockPos blockpos = blockPos.below();
			BlockState blockstate = level.getBlockState(blockpos);
			if (blockstate.is(blockState.getBlock()) && blockstate.getValue(HALF) == DoubleBlockHalf.LOWER) {
				BlockState blockstate1 = blockstate.getFluidState().is(Fluids.WATER) ? Blocks.WATER.defaultBlockState() : Blocks.AIR.defaultBlockState();
				level.setBlock(blockpos, blockstate1, 35);
				level.levelEvent(player, 2001, blockpos, Block.getId(blockstate));
			}
		}
	}

	@Override
	@Nullable
	public BlockState getStateForPlacement(BlockPlaceContext p_52739_) {
		BlockPos blockpos = p_52739_.getClickedPos();
		Level level = p_52739_.getLevel();
		if (blockpos.getY() < level.getMaxBuildHeight() - 1 && level.getBlockState(blockpos.above()).canBeReplaced(p_52739_)) {
			return this.defaultBlockState().setValue(NESW_FACING, p_52739_.getHorizontalDirection().getOpposite()).setValue(HALF, DoubleBlockHalf.LOWER);
		} else {
			return null;
		}
	}

	@Override
	public void setPlacedBy(Level level, BlockPos blockPos, BlockState blockState, LivingEntity livingEntity, ItemStack itemStack) {
		super.setPlacedBy(level, blockPos, blockState, livingEntity, itemStack);
		if (!level.isClientSide) {
			level.setBlock(blockPos.above(), blockState.setValue(HALF, DoubleBlockHalf.UPPER), 3);
			level.blockUpdated(blockPos, Blocks.AIR);
			blockState.updateNeighbourShapes(level, blockPos, 3);
		}
	}

	@Override
	public boolean canSurvive(BlockState p_52783_, LevelReader p_52784_, BlockPos p_52785_) {
		BlockPos blockpos = p_52785_.below();
		BlockState blockstate = p_52784_.getBlockState(blockpos);
		return p_52783_.getValue(HALF) == DoubleBlockHalf.LOWER ? blockstate.isFaceSturdy(p_52784_, blockpos, Direction.UP) : blockstate.is(this);
	}

	@Override
	protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
		super.createBlockStateDefinition(builder);
		builder.add(NESW_FACING);
		builder.add(HALF);
	}

	@Override
	public InteractionResult use(BlockState pState, Level pLevel, BlockPos pPos, Player pPlayer, InteractionHand pHand, BlockHitResult pHit) {
		if (pLevel.isClientSide) {
			return InteractionResult.SUCCESS;
		} else {
			this.openContainer(pLevel, pPos, pPlayer);
			return InteractionResult.CONSUME;
		}
	}

	protected void openContainer(Level pLevel, BlockPos pPos, Player pPlayer) {
		BlockEntity blockentity = pLevel.getBlockEntity(pPos);
		if (blockentity instanceof DraftFurnaceBlockEntity) {
			pPlayer.openMenu((MenuProvider) blockentity);
			pPlayer.awardStat(Stats.INTERACT_WITH_FURNACE);
		}
	}

	@Override
	public BlockEntity newBlockEntity(BlockPos pPos, BlockState pState) {
		return new DraftFurnaceBlockEntity(pPos, pState);
	}
}
