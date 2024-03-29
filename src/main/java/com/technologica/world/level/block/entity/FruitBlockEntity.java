package com.technologica.world.level.block.entity;

import com.technologica.registration.deferred.TechnologicaBlockEntityTypes;

import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.protocol.game.ClientboundBlockEntityDataPacket;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.AABB;

public class FruitBlockEntity extends BlockEntity {
	public static final String ITEM_NAME = "FruitItem";
	private ItemStack stack = ItemStack.EMPTY;
	
	public FruitBlockEntity(BlockPos p_155700_, BlockState p_155701_) {
		super(TechnologicaBlockEntityTypes.FRUIT_CROP.get(), p_155700_, p_155701_);
	}
	
	@Override
	public BlockEntityType<?> getType() {
		return TechnologicaBlockEntityTypes.FRUIT_CROP.get();
	}

	@Override
	public AABB getRenderBoundingBox() {
		return new AABB(getBlockPos(), getBlockPos().offset(1, -1, 1));
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
	
	@Override
	public ClientboundBlockEntityDataPacket getUpdatePacket() {
		return ClientboundBlockEntityDataPacket.create(this);
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
	public void load(CompoundTag nbt) {
	    if (nbt.contains(ITEM_NAME)) {
	    	this.setFruitStack(ItemStack.of(nbt.getCompound(ITEM_NAME)));
	    }
	    super.load(nbt);
	}

	@Override
	public void saveAdditional(CompoundTag compound) {
	    if (!this.getFruitStack().isEmpty()) {
	    	compound.put(ITEM_NAME, this.getFruitStack().save(new CompoundTag()));
	    }
	    super.saveAdditional(compound);
	}
}
