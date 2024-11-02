package com.technologica.world.level.block;

import com.technologica.world.level.block.entity.TechnologicaSkullBlockEntity;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.SkullBlock.Type;
import net.minecraft.world.level.block.WallSkullBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;

public class TechnologicaWallSkullBlock extends WallSkullBlock {

	public TechnologicaWallSkullBlock(Type type, Properties properties) {
		super(type, properties);
	}

	@Override
	public BlockEntity newBlockEntity(BlockPos blockPos, BlockState blockState) {
		return new TechnologicaSkullBlockEntity(blockPos, blockState);
	}
}
