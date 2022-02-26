package com.technologica.capabilities;

import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.entity.player.Player;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;

public interface ILink {
	boolean getLinking();
	BlockPos getLinkAnchorPos();
	void startLink(Level worldIn, BlockPos posIn, BlockState stateIn, Player playerIn);
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
