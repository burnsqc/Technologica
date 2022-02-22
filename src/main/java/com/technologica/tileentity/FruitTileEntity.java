package com.technologica.tileentity;

import javax.annotation.Nullable;

import net.minecraft.block.BlockState;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.play.server.SUpdateTileEntityPacket;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.AxisAlignedBB;

public class FruitTileEntity extends TileEntity {
	public static final String ITEM_NAME = "FruitItem";
	private ItemStack stack = ItemStack.EMPTY;
	
	public FruitTileEntity() {
		super(TechnologicaTileEntities.FRUIT_CROP.get());
	}

	@Override
	public AxisAlignedBB getRenderBoundingBox() {
		return new AxisAlignedBB(getBlockPos(), getBlockPos().offset(1, -1, 1));
	}
	
	public ItemStack getFruitStack() {
        return stack;
    }
	
	public void setFruitStack(ItemStack stackIn) {
        this.stack = stackIn;
        setChanged();
        if (level != null) {
        	level.sendBlockUpdated(worldPosition, getBlockState(), getBlockState(), 2); 
        }
    }
	
	public void clear() {
        this.setFruitStack(ItemStack.EMPTY);  
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
	    	this.setFruitStack(ItemStack.of(nbt.getCompound(ITEM_NAME)));
	    }
	}

	@Override
	public CompoundNBT save(CompoundNBT compound) {
		super.save(compound);
	    if (!this.getFruitStack().isEmpty()) {
	    	compound.put(ITEM_NAME, this.getFruitStack().save(new CompoundNBT()));
	    }	   
	    return compound;	    
	}
}
