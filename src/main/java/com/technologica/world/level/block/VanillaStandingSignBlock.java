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

	public VanillaStandingSignBlock(WoodType woodType) {
		super(BlockBehaviour.Properties.of().noCollission().strength(1.0F).sound(SoundType.WOOD), woodType);
	}

	@Override
	public BlockEntity newBlockEntity(BlockPos blockPos, BlockState blockState) {
		return new VanillaSignBlockEntity(blockPos, blockState);
	}
}
