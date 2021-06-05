package com.technologica.capabilities;

import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public interface ILink {
	boolean getLinking();
	BlockPos getLinkAnchorPos();
	void startLink(World worldIn, BlockPos posIn, BlockState stateIn, PlayerEntity playerIn);
	void stopLink(BlockPos posIn, BlockState stateIn);
	boolean checkAxis();
	boolean checkInlinePos();
	boolean checkPlanarPos();
	boolean checkObstructed();
	boolean checkDistance();
	boolean checkMaterial();
	void createLineShaft();
	void createBelt();
}
