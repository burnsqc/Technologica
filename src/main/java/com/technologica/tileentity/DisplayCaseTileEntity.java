package com.technologica.tileentity;

import javax.annotation.Nullable;

import net.minecraft.block.BlockState;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.play.server.SUpdateTileEntityPacket;
import net.minecraft.tileentity.TileEntity;

public class DisplayCaseTileEntity extends TileEntity {
	public static final String ITEM_NAME = "DisplayItem";
	private ItemStack stack = ItemStack.EMPTY;
	
	public DisplayCaseTileEntity() {
		super(TechnologicaTileEntities.DISPLAY_TILE.get());
	}
	
	public ItemStack getDisplayStack() {
        return stack;
    }
	
	public void setDisplayStack(ItemStack stackIn) {
        this.stack = stackIn;
        setChanged();
        if (level != null) {
        	level.sendBlockUpdated(worldPosition, getBlockState(), getBlockState(), 2); 
        }
    }
	
	@Override
	@Nullable
	public SUpdateTileEntityPacket getUpdatePacket() {
		return new SUpdateTileEntityPacket(this.worldPosition, 10, this.getUpdateTag());
	}   
	
	@Override
	public void onDataPacket(NetworkManager net, SUpdateTileEntityPacket pkt) {
		BlockState blockState = level.getBlockState(worldPosition);
		load(blockState, pkt.getTag());
	}
	
	@Override
	public CompoundNBT getUpdateTag() {
		return this.save(new CompoundNBT());
	}
	
	@Override
	public void handleUpdateTag(BlockState blockState, CompoundNBT parentNBTTagCompound)
	{
		this.load(blockState, parentNBTTagCompound);
	}
	
	@Override
	public void load(BlockState state, CompoundNBT nbt) {
		super.load(state, nbt);
	    if (nbt.contains(ITEM_NAME)) {
	    	this.setDisplayStack(ItemStack.of(nbt.getCompound(ITEM_NAME)));
	    }
	}

	@Override
	public CompoundNBT save(CompoundNBT compound) {
		super.save(compound);
	    if (!this.getDisplayStack().isEmpty()) {
	    	compound.put(ITEM_NAME, this.getDisplayStack().save(new CompoundNBT()));
	    }	   
	    return compound;	    
	}
}
