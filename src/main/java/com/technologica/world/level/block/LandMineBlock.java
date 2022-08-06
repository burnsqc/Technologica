package com.technologica.world.level.block;

import javax.annotation.Nullable;

import com.technologica.world.level.block.entity.LandMineBlockEntity;

import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.BaseEntityBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.Material;

public class LandMineBlock extends BaseEntityBlock {
	public LandMineBlock() {
		super(BlockBehaviour.Properties.of(Material.GRASS).randomTicks().strength(0.6F).sound(SoundType.GRASS));
	}

	/*
	 * Technologica Methods
	 */

	public LandMineBlockEntity getTileEntity(Level worldIn, BlockPos posIn) {
		return (LandMineBlockEntity) worldIn.getBlockEntity(posIn);
	}

	@Override
	public void stepOn(Level p_153777_, BlockPos p_153778_, BlockState p_153779_, Entity p_153780_) {
		LandMineBlockEntity landMineBlockEntity = getTileEntity(p_153777_, p_153778_);
		if (!landMineBlockEntity.getArmed()) {
			landMineBlockEntity.setArmed();
			p_153777_.playSound((Player) null, p_153778_, SoundEvents.ANVIL_HIT, SoundSource.BLOCKS, 1.0F, 0.8F + p_153777_.random.nextFloat() * 0.4F);
		}
		super.stepOn(p_153777_, p_153778_, p_153779_, p_153780_);
	}

	/*
	 * Forge Methods
	 */

	@Override
	public BlockEntity newBlockEntity(BlockPos p_153215_, BlockState p_153216_) {
		return new LandMineBlockEntity(p_153215_, p_153216_);
	}

	@Override
	@Nullable
	public <T extends BlockEntity> BlockEntityTicker<T> getTicker(Level level, BlockState blockState, BlockEntityType<T> type) {
		if (level.isClientSide()) {
			return null;
		}
		return (lvl, pos, blockState2, t) -> {
			if (t instanceof LandMineBlockEntity tile) {
				tile.serverTick();
			}
		};
	}
}
