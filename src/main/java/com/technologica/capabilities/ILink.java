package com.technologica.capabilities;

import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;

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