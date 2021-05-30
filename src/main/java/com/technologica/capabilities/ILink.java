package com.technologica.capabilities;

import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.math.BlockPos;

public interface ILink {
	void setLink(BlockPos posIn, BlockState stateIn, PlayerEntity playerIn);
}
