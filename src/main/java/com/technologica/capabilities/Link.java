package com.technologica.capabilities;

import com.technologica.block.TwelveDirectionBlock;

import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.util.Util;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.StringTextComponent;
import net.minecraftforge.common.util.INBTSerializable;

public class Link implements ILink, INBTSerializable<CompoundNBT> {
	private boolean link;
	private BlockPos linkAnchorPos;
	private BlockState linkAnchorState;
	private String message;
	
	public Link() {
		this.link = true;
		this.linkAnchorPos = null;
		this.linkAnchorState = null;
		this.message = null;
	}
	
	@Override
	public void setLink(BlockPos posIn, BlockState stateIn, PlayerEntity playerIn) {
		if (linkAnchorPos == null) {
			link = false;
			linkAnchorPos = posIn;
			linkAnchorState = stateIn;
			message = "LINK STARTED";
		} else {
			if (posIn == linkAnchorPos) {
				link = false;
				linkAnchorPos = null;
				message = "LINK STOPPED";
			} else if (stateIn.get(TwelveDirectionBlock.AXIS) != linkAnchorState.get(TwelveDirectionBlock.AXIS)) {
				link = false;
				linkAnchorPos = null;
				message = "LINK FAILED: AXIS MISALIGNMENT";
			}
			switch (stateIn.get(TwelveDirectionBlock.AXIS)) {
				case X:
					message = (posIn.getY() == linkAnchorPos.getY() && posIn.getZ() == linkAnchorPos.getZ()) ? null : "LINK FAILED: POSITION MISALIGNMENT";
					break;
				case Y:
					message = (posIn.getX() == linkAnchorPos.getX() && posIn.getZ() == linkAnchorPos.getZ()) ? null : "LINK FAILED: POSITION MISALIGNMENT";
					break;
				case Z:
					message = (posIn.getX() == linkAnchorPos.getX() && posIn.getY() == linkAnchorPos.getY()) ? null : "LINK FAILED: POSITION MISALIGNMENT";
					break;
			}	
		}
		if (link) {	
		}
		playerIn.sendMessage(new StringTextComponent(message), Util.DUMMY_UUID);
		message = null;
	}

	@Override
	public CompoundNBT serializeNBT() {
		return null;
	}

	@Override
	public void deserializeNBT(CompoundNBT nbt) {
	}
}