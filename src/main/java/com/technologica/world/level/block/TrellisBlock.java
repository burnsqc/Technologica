package com.technologica.world.level.block;

import javax.annotation.Nullable;

import com.technologica.world.item.TechnologicaItems;

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
import net.minecraft.world.level.material.Material;
import net.minecraft.world.phys.BlockHitResult;

public class TrellisBlock extends Block {
	public static final EnumProperty<DoubleBlockHalf> HALF = BlockStateProperties.DOUBLE_BLOCK_HALF;

	public TrellisBlock() {
		super(BlockBehaviour.Properties.of(Material.REPLACEABLE_PLANT).noCollission().instabreak().instabreak().sound(SoundType.METAL));
		this.registerDefaultState(this.stateDefinition.any().setValue(HALF, DoubleBlockHalf.LOWER));
	}

	@Override
	public BlockState updateShape(BlockState p_52894_, Direction p_52895_, BlockState p_52896_, LevelAccessor p_52897_, BlockPos p_52898_, BlockPos p_52899_) {
		DoubleBlockHalf doubleblockhalf = p_52894_.getValue(HALF);
		if (p_52895_.getAxis() != Direction.Axis.Y || doubleblockhalf == DoubleBlockHalf.LOWER != (p_52895_ == Direction.UP) || p_52896_.is(this) && p_52896_.getValue(HALF) != doubleblockhalf) {
			return doubleblockhalf == DoubleBlockHalf.LOWER && p_52895_ == Direction.DOWN && !p_52894_.canSurvive(p_52897_, p_52898_) ? Blocks.AIR.defaultBlockState() : p_52894_.updateShape(p_52895_, p_52896_, p_52897_, p_52898_, p_52899_);
		} else {
			if (p_52897_.getBlockState(p_52898_.below()).getBlock() instanceof VineCropBlock) {
				if (p_52897_.getBlockState(p_52898_.below()).getValue(VineCropBlock.TRELLIS)) {
					return p_52894_.updateShape(p_52895_, p_52896_, p_52897_, p_52898_, p_52899_);
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
	public BlockState getStateForPlacement(BlockPlaceContext p_52863_) {
		BlockPos blockpos = p_52863_.getClickedPos();
		Level level = p_52863_.getLevel();
		return blockpos.getY() < level.getMaxBuildHeight() - 1 && level.getBlockState(blockpos.above()).canBeReplaced(p_52863_) ? super.getStateForPlacement(p_52863_) : null;
	}

	@Override
	public void setPlacedBy(Level p_52872_, BlockPos p_52873_, BlockState p_52874_, LivingEntity p_52875_, ItemStack p_52876_) {
		BlockPos blockpos = p_52873_.above();
		p_52872_.setBlock(blockpos, this.defaultBlockState().setValue(HALF, DoubleBlockHalf.UPPER), 3);
	}

	@Override
	public boolean canSurvive(BlockState stateIn, LevelReader worldIn, BlockPos posIn) {
		if (stateIn.getValue(HALF) == DoubleBlockHalf.LOWER) {
			if (worldIn.getBlockState(posIn.below()).getBlock() == Blocks.FARMLAND) {
				return stateIn.canSurvive(worldIn, posIn);
			} else {
				return false;
			}
		} else {
			if (worldIn.getBlockState(posIn.below()).getBlock() == this) {
				return true;
			} else {
				return false;
			}
		}
	}

	@Override
	public void playerWillDestroy(Level p_52878_, BlockPos p_52879_, BlockState p_52880_, Player p_52881_) {
		if (!p_52878_.isClientSide) {
			if (p_52881_.isCreative()) {
				preventCreativeDropFromBottomPart(p_52878_, p_52879_, p_52880_, p_52881_);
			} else {
				dropResources(p_52880_, p_52878_, p_52879_, (BlockEntity) null, p_52881_, p_52881_.getMainHandItem());
			}
		}
		super.playerWillDestroy(p_52878_, p_52879_, p_52880_, p_52881_);
	}

	@Override
	public void playerDestroy(Level p_52865_, Player p_52866_, BlockPos p_52867_, BlockState p_52868_, @Nullable BlockEntity p_52869_, ItemStack p_52870_) {
		super.playerDestroy(p_52865_, p_52866_, p_52867_, Blocks.AIR.defaultBlockState(), p_52869_, p_52870_);
	}

	protected static void preventCreativeDropFromBottomPart(Level p_52904_, BlockPos p_52905_, BlockState p_52906_, Player p_52907_) {
		DoubleBlockHalf doubleblockhalf = p_52906_.getValue(HALF);
		if (doubleblockhalf == DoubleBlockHalf.UPPER) {
			BlockPos blockpos = p_52905_.below();
			BlockState blockstate = p_52904_.getBlockState(blockpos);
			if (blockstate.is(p_52906_.getBlock()) && blockstate.getValue(HALF) == DoubleBlockHalf.LOWER) {
				p_52904_.setBlock(blockpos, Blocks.AIR.defaultBlockState(), 35);
				p_52904_.levelEvent(p_52907_, 2001, blockpos, Block.getId(blockstate));
			}
		}
	}

	@Override
	public InteractionResult use(BlockState p_57275_, Level p_57276_, BlockPos p_57277_, Player p_57278_, InteractionHand p_57279_, BlockHitResult p_57280_) {
		if (p_57275_.getValue(HALF) == DoubleBlockHalf.LOWER) {
			if (p_57278_.getItemInHand(p_57279_).is(TechnologicaItems.GRAPE_SEEDS.get())) {
				p_57276_.setBlock(p_57277_, TechnologicaBlocks.GRAPES.get().defaultBlockState().setValue(VineCropBlock.TRELLIS, true), 3);
				p_57276_.setBlock(p_57277_.above(), TechnologicaBlocks.GRAPES.get().defaultBlockState().setValue(VineCropBlock.HALF, DoubleBlockHalf.UPPER).setValue(VineCropBlock.AGE, 0).setValue(VineCropBlock.TRELLIS, true), 3);
				return InteractionResult.PASS;
			} else if (p_57278_.getItemInHand(p_57279_).is(TechnologicaItems.TOMATO_SEEDS.get())) {
				p_57276_.setBlock(p_57277_, TechnologicaBlocks.TOMATOES.get().defaultBlockState().setValue(VineCropBlock.TRELLIS, true), 3);
				p_57276_.setBlock(p_57277_.above(), TechnologicaBlocks.TOMATOES.get().defaultBlockState().setValue(VineCropBlock.HALF, DoubleBlockHalf.UPPER).setValue(VineCropBlock.AGE, 0).setValue(VineCropBlock.TRELLIS, true), 3);
				return InteractionResult.PASS;
			} else {
				return p_57275_.use(p_57276_, p_57278_, p_57279_, p_57280_);
			}
		} else {
			return p_57275_.use(p_57276_, p_57278_, p_57279_, p_57280_);
		}
	}

	@Override
	protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builderIn) {
		builderIn.add(HALF);
		super.createBlockStateDefinition(builderIn);
	}
}
