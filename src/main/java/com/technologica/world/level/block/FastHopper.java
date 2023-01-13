package com.technologica.world.level.block;

import javax.annotation.Nullable;

import com.technologica.world.level.block.entity.FastHopperBlockEntity;
import com.technologica.world.level.block.entity.TechnologicaBlockEntityType;

import net.minecraft.core.BlockPos;
import net.minecraft.stats.Stats;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.HopperBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;

public class FastHopper extends HopperBlock {

	public FastHopper(Properties propertiesIn) {
		super(propertiesIn);
	}
	
	@Override
	public BlockEntity newBlockEntity(BlockPos p_153382_, BlockState p_153383_) {
		return new FastHopperBlockEntity(p_153382_, p_153383_);
	}
	
	@Override
	public InteractionResult use(BlockState p_54071_, Level p_54072_, BlockPos p_54073_, Player p_54074_, InteractionHand p_54075_, BlockHitResult p_54076_) {
	      if (p_54072_.isClientSide) {
	         return InteractionResult.SUCCESS;
	      } else {
	         BlockEntity blockentity = p_54072_.getBlockEntity(p_54073_);
	         if (blockentity instanceof FastHopperBlockEntity) {
	            p_54074_.openMenu((FastHopperBlockEntity)blockentity);
	            p_54074_.awardStat(Stats.INSPECT_HOPPER);
	         }

	         return InteractionResult.CONSUME;
	      }
	   }
	
	@Nullable
	@Override
	public <T extends BlockEntity> BlockEntityTicker<T> getTicker(Level p_153378_, BlockState p_153379_, BlockEntityType<T> p_153380_) {
		return p_153378_.isClientSide ? null : createTickerHelper(p_153380_, TechnologicaBlockEntityType.FAST_HOPPER_BLOCK_ENTITY.get(), FastHopperBlockEntity::pushItemsTick);
	}
}
