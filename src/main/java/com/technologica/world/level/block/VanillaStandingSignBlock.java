package com.technologica.world.level.block;

import com.technologica.world.level.block.entity.VanillaSignBlockEntity;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.StandingSignBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.WoodType;

public class VanillaStandingSignBlock extends StandingSignBlock {

	public VanillaStandingSignBlock(WoodType p_56991_) {
		super(BlockBehaviour.Properties.of().noCollission().strength(1.0F).sound(SoundType.WOOD), p_56991_);
	}

	@Override
	public BlockEntity newBlockEntity(BlockPos p_154556_, BlockState p_154557_) {
		return new VanillaSignBlockEntity(p_154556_, p_154557_);
	}
}
