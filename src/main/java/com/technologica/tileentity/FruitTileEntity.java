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
	private ItemStack stack = ItemStack.EMPTY;
	
	public FruitTileEntity() {
		super(ModTileEntities.FRUIT_CROP.get());
	}

	@Override
	public AxisAlignedBB getRenderBoundingBox() {
		return new AxisAlignedBB(getPos(), getPos().add(1, -1, 1));
	}
	
	public ItemStack getFruitStack() {
        return stack;
    }
	
	public void setFruitStack(ItemStack stackIn) {
        this.stack = stackIn;
        markDirty();
        if (world != null) {
        	world.notifyBlockUpdate(pos, getBlockState(), getBlockState(), 2); 
        }
    }
	
	public void clear() {
        this.setFruitStack(ItemStack.EMPTY);  
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
	    if (nbt.contains("FruitItem")) {
	    	this.setFruitStack(ItemStack.read(nbt.getCompound("FruitItem")));
	    }
	}

	@Override
	public CompoundNBT write(CompoundNBT compound) {
		super.write(compound);
	    if (!this.getFruitStack().isEmpty()) {
	    	compound.put("FruitItem", this.getFruitStack().write(new CompoundNBT()));
	    }	   
	    return compound;	    
	}
}