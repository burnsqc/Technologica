package com.technologica.world.level.block;

import com.technologica.world.level.block.entity.TechnologicaSkullBlockEntity;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.SkullBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;

public class TechnologicaSkullBlock extends SkullBlock {

	public TechnologicaSkullBlock(Type type, Properties properties) {
		super(type, properties);
	}

	@Override
	public BlockEntity newBlockEntity(BlockPos p_151996_, BlockState p_151997_) {
		return new TechnologicaSkullBlockEntity(p_151996_, p_151997_);
	}

	public static enum Types implements SkullBlock.Type {
		BEEPER,
		PEEPER,
		SLEEPER,
		SWEEPER,
		WEEPER;
	}
}
