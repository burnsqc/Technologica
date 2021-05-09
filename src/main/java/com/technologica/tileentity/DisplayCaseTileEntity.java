package com.technologica.tileentity;

import javax.annotation.Nullable;

import net.minecraft.block.BlockState;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.play.server.SUpdateTileEntityPacket;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.AxisAlignedBB;

public class DisplayCaseTileEntity extends TileEntity {
	private ItemStack stack = ItemStack.EMPTY;
	
	public DisplayCaseTileEntity() {
		super(ModTileEntities.DISPLAY_TILE.get());
	}

	@Override
	public AxisAlignedBB getRenderBoundingBox() {
		return new AxisAlignedBB(getPos(), getPos().add(1, -1, 1));
	}
	
	public ItemStack getDisplayStack() {
        return stack;
    }
	
	public void setDisplayStack(ItemStack stackIn) {
        this.stack = stackIn;
        markDirty();
        if (world != null) {
        	world.notifyBlockUpdate(pos, getBlockState(), getBlockState(), 2); 
        }
    }
	
	public void clear() {
        this.setDisplayStack(ItemStack.EMPTY);  
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
	    	this.setDisplayStack(ItemStack.read(nbt.getCompound("DisplayItem")));
	    }
	}

	@Override
	public CompoundNBT write(CompoundNBT compound) {
		super.write(compound);
	    if (!this.getDisplayStack().isEmpty()) {
	    	compound.put("DisplayItem", this.getDisplayStack().write(new CompoundNBT()));
	    }	   
	    return compound;	    
	}
}