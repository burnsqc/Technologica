package com.technologica.world.level.block.entity;

import com.technologica.registration.deferred.TechnologicaBlockEntityTypes;

import net.minecraft.Util;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.protocol.game.ClientboundBlockEntityDataPacket;
import net.minecraft.world.entity.projectile.ThrownPotion;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.phys.AABB;

public class PotionBlockEntity extends BlockEntity {
	public static final String POTION_ITEM = "PotionItem";
	private ItemStack stack = ItemStack.EMPTY;
	
	public PotionBlockEntity(BlockPos blockPos, BlockState blockState) {
		super(TechnologicaBlockEntityTypes.POTION_CROP.get(), blockPos, blockState);
	}

	@Override
	public AABB getRenderBoundingBox() {
		return new AABB(getBlockPos(), getBlockPos().offset(1, -1, 1));
	}
	
	public ItemStack getPotionStack() {
        return stack;
    }
	
	public void setPotionStack(ItemStack stackIn) {
        this.stack = stackIn;
        setChanged();
        if (level != null) {
        	level.sendBlockUpdated(worldPosition, getBlockState(), getBlockState(), 2); 
        }
    }
	
	public void tick() {
		if (this.getPotionStack() != ItemStack.EMPTY) {
			assert level != null;
			if (level.hasNearbyAlivePlayer(worldPosition.getX() + 0.5D, worldPosition.getY() + 0.5D, worldPosition.getZ() + 0.5D, 5.0D)) {
				this.level.addFreshEntity(Util.make(new ThrownPotion(level, worldPosition.getX(), worldPosition.getY(), worldPosition.getZ()), potion -> potion.setItem(getPotionStack())));
				this.setPotionStack(ItemStack.EMPTY);
				level.setBlock(worldPosition, this.getBlockState().setValue(BlockStateProperties.AGE_7, 0), 4);
			}
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
		super.load(compoundTag);
	    if (compoundTag.contains(POTION_ITEM)) {
	    	this.setPotionStack(ItemStack.of(compoundTag.getCompound(POTION_ITEM)));
	    }
	}

	@Override
	public void saveAdditional(CompoundTag compoundTag) {
		super.saveAdditional(compoundTag);
	    if (!this.getPotionStack().isEmpty()) {
	    	compoundTag.put(POTION_ITEM, this.getPotionStack().save(new CompoundTag()));
	    }	   
	}
}
