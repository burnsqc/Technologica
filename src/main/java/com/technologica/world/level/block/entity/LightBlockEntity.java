package com.technologica.world.level.block.entity;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;

public class LightBlockEntity extends BlockEntity {
	
	public LightBlockEntity(BlockPos p_155700_, BlockState p_155701_) {
		super(TechnologicaBlockEntityType.LIGHT_BLOCK_ENTITY.get(), p_155700_, p_155701_);
	}

	public void serverTick() {
		level.setBlockAndUpdate(worldPosition, Blocks.AIR.defaultBlockState());
	}
}
