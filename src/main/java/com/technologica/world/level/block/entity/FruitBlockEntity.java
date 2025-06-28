package com.technologica.world.level.block.entity;

import com.technologica.registration.deferred.TechnologicaBlockEntityTypes;

import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.protocol.game.ClientboundBlockEntityDataPacket;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.AABB;

public class FruitBlockEntity extends BlockEntity {
	public static final String ITEM_NAME = "FruitItem";
	private ItemStack stack = ItemStack.EMPTY;
	
	public FruitBlockEntity(BlockPos blockPos, BlockState blockState) {
		super(TechnologicaBlockEntityTypes.FRUIT_CROP.get(), blockPos, blockState);
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
	public void handleUpdateTag(CompoundTag compoundTag) {
		this.load(compoundTag);
	}
	
	@Override
	public void load(CompoundTag compoundTag) {
	    if (compoundTag.contains(ITEM_NAME)) {
	    	this.setFruitStack(ItemStack.of(compoundTag.getCompound(ITEM_NAME)));
	    }
	    super.load(compoundTag);
	}

	@Override
	public void saveAdditional(CompoundTag compoundTag) {
	    if (!this.getFruitStack().isEmpty()) {
	    	compoundTag.put(ITEM_NAME, this.getFruitStack().save(new CompoundTag()));
	    }
	    super.saveAdditional(compoundTag);
	}
}
