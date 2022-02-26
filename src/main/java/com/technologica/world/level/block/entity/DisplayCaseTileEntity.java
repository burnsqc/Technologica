package com.technologica.world.level.block.entity;

import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.Connection;
import net.minecraft.network.protocol.game.ClientboundBlockEntityDataPacket;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;

public class DisplayCaseTileEntity extends BlockEntity {
	public static final String ITEM_NAME = "DisplayItem";
	private ItemStack stack = ItemStack.EMPTY;
	
	public DisplayCaseTileEntity(BlockPos p_155700_, BlockState p_155701_) {
		super(TechnologicaBlockEntityType.DISPLAY_TILE.get(), p_155700_, p_155701_);
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
	public ClientboundBlockEntityDataPacket getUpdatePacket() {
		return ClientboundBlockEntityDataPacket.create(this);
	} 
	
	@Override
	public void onDataPacket(Connection net, ClientboundBlockEntityDataPacket pkt) {
		load(pkt.getTag());
	}
	
	@Override
	public CompoundTag getUpdateTag() {
		return this.saveWithoutMetadata();
	}
	
	@Override
	public void handleUpdateTag(CompoundTag parentNBTTagCompound) {
		this.load(parentNBTTagCompound);
	}
	
	@Override
	public void load(CompoundTag p_155716_) {
		super.load(p_155716_);
	    if (p_155716_.contains(ITEM_NAME)) {
	    	this.setDisplayStack(ItemStack.of(p_155716_.getCompound(ITEM_NAME)));
	    }
	}

	@Override
	public void saveAdditional(CompoundTag compound) {
		super.saveAdditional(compound);
	    if (!this.getDisplayStack().isEmpty()) {
	    	compound.put(ITEM_NAME, this.getDisplayStack().save(new CompoundTag()));
	    }	   
	}
}
