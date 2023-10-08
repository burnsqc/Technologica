package com.technologica.world.level.block;

import javax.annotation.Nullable;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
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
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.DoubleBlockHalf;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.level.material.Material;

public class TapeDriveBlock extends FourDirectionBlock {
	public static final EnumProperty<DoubleBlockHalf> HALF = BlockStateProperties.DOUBLE_BLOCK_HALF;

	protected TapeDriveBlock() {
		super(BlockBehaviour.Properties.of(Material.METAL).strength(2.0F).sound(SoundType.ANVIL).noOcclusion());
	}

	@SuppressWarnings("deprecation")
	@Override
	public BlockState updateShape(BlockState p_52796_, Direction p_52797_, BlockState p_52798_, LevelAccessor p_52799_, BlockPos p_52800_, BlockPos p_52801_) {
		DoubleBlockHalf doubleblockhalf = p_52796_.getValue(HALF);
		if (p_52797_.getAxis() == Direction.Axis.Y && doubleblockhalf == DoubleBlockHalf.LOWER == (p_52797_ == Direction.UP)) {
			return p_52798_.is(this) && p_52798_.getValue(HALF) != doubleblockhalf ? p_52796_.setValue(NESW_FACING, p_52798_.getValue(NESW_FACING)) : Blocks.AIR.defaultBlockState();
		} else {
			return doubleblockhalf == DoubleBlockHalf.LOWER && p_52797_ == Direction.DOWN && !p_52796_.canSurvive(p_52799_, p_52800_) ? Blocks.AIR.defaultBlockState() : super.updateShape(p_52796_, p_52797_, p_52798_, p_52799_, p_52800_, p_52801_);
		}
	}

	@Override
	public void playerWillDestroy(Level p_52755_, BlockPos p_52756_, BlockState p_52757_, Player p_52758_) {
		if (!p_52755_.isClientSide && p_52758_.isCreative()) {
			this.preventCreativeDropFromBottomPart(p_52755_, p_52756_, p_52757_, p_52758_);
		}
		super.playerWillDestroy(p_52755_, p_52756_, p_52757_, p_52758_);
	}

	protected void preventCreativeDropFromBottomPart(Level p_52904_, BlockPos p_52905_, BlockState p_52906_, Player p_52907_) {
		DoubleBlockHalf doubleblockhalf = p_52906_.getValue(HALF);
		if (doubleblockhalf == DoubleBlockHalf.UPPER) {
			BlockPos blockpos = p_52905_.below();
			BlockState blockstate = p_52904_.getBlockState(blockpos);
			if (blockstate.is(p_52906_.getBlock()) && blockstate.getValue(HALF) == DoubleBlockHalf.LOWER) {
				BlockState blockstate1 = blockstate.getFluidState().is(Fluids.WATER) ? Blocks.WATER.defaultBlockState() : Blocks.AIR.defaultBlockState();
				p_52904_.setBlock(blockpos, blockstate1, 35);
				p_52904_.levelEvent(p_52907_, 2001, blockpos, Block.getId(blockstate));
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
	public void setPlacedBy(Level p_52749_, BlockPos p_52750_, BlockState p_52751_, LivingEntity p_52752_, ItemStack p_52753_) {
		p_52749_.setBlock(p_52750_.above(), p_52751_.setValue(HALF, DoubleBlockHalf.UPPER), 3);
	}

	@Override
	public boolean canSurvive(BlockState p_52783_, LevelReader p_52784_, BlockPos p_52785_) {
		BlockPos blockpos = p_52785_.below();
		BlockState blockstate = p_52784_.getBlockState(blockpos);
		return p_52783_.getValue(HALF) == DoubleBlockHalf.LOWER ? blockstate.isFaceSturdy(p_52784_, blockpos, Direction.UP) : blockstate.is(this);
	}

	@Override
	protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> p_52803_) {
		super.createBlockStateDefinition(p_52803_);
		p_52803_.add(HALF);
	}

}
