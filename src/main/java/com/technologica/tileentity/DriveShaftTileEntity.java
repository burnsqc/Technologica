package com.technologica.tileentity;

import javax.annotation.Nullable;

import net.minecraft.block.BlockState;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.play.server.SUpdateTileEntityPacket;
import net.minecraft.tileentity.TileEntity;

public class DriveShaftTileEntity extends TileEntity {
	private int rpm = 0;
	private int torque = 0;
	private Boolean pulley = false;
	
	public DriveShaftTileEntity() {
		super(ModTileEntities.DRIVE_SHAFT_TILE.get());
	}
	
	public void setRPM(int rpmIn) {
		rpm = rpmIn;
	}
	
	public int getRPM() {
		return rpm;
	}
	
	public void setTorque(int torqueIn) {
		torque = torqueIn;
	}
	
	public int getTorque() {
		return torque;
	}
	
	public void setPulley(Boolean pulleyIn) {
		pulley = pulleyIn;
        markDirty();
        if (world != null) {
        	world.notifyBlockUpdate(pos, getBlockState(), getBlockState(), 2); 
        }
    }
	
	public Boolean getPulley() {
        return pulley;
    }
	
	@Nullable
	public SUpdateTileEntityPacket getUpdatePacket() {
		return new SUpdateTileEntityPacket(this.pos, 10, this.getUpdateTag());
	}   
	
	@Override
	public void onDataPacket(NetworkManager net, SUpdateTileEntityPacket pkt) {
		BlockState blockState = world.getBlockState(pos);
		read(blockState, pkt.getNbtCompound());
	}
	
	@Override
	public CompoundNBT getUpdateTag() {
		return this.write(new CompoundNBT());
	}
	
	@Override
	public void handleUpdateTag(BlockState blockState, CompoundNBT parentNBTTagCompound)
	{
		this.read(blockState, parentNBTTagCompound);
	}
	
	@Override
	public void read(BlockState state, CompoundNBT nbt) {
		super.read(state, nbt);
	    if (nbt.contains("DisplayItem")) {
//	    	this.setDisplayStack(ItemStack.read(nbt.getCompound("DisplayItem")));
	    }
	}

	@Override
	public CompoundNBT write(CompoundNBT compound) {
		super.write(compound);
//	    if (!this.getDisplayStack().isEmpty()) {
//	    	compound.put("DisplayItem", this.getDisplayStack().write(new CompoundNBT()));
//	    }	   
	    return compound;	    
	}
}