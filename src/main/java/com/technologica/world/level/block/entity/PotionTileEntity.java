package com.technologica.world.level.block.entity;

import com.technologica.registration.deferred.TechnologicaBlockEntityTypes;

import net.minecraft.Util;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.Connection;
import net.minecraft.network.protocol.game.ClientboundBlockEntityDataPacket;
import net.minecraft.world.entity.projectile.ThrownPotion;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.phys.AABB;

public class PotionTileEntity extends BlockEntity {
	public static final String POTION_ITEM = "PotionItem";
	private ItemStack stack = ItemStack.EMPTY;
	public static final IntegerProperty AGE = BlockStateProperties.AGE_7;
	
	public PotionTileEntity(BlockPos p_155700_, BlockState p_155701_) {
		super(TechnologicaBlockEntityTypes.POTION_CROP.get(), p_155700_, p_155701_);
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
	
	public void clear() {
        this.setPotionStack(ItemStack.EMPTY);  
    }

	public void tick() {
		if (this.getPotionStack() != ItemStack.EMPTY) {
			assert level != null;
			if (level.hasNearbyAlivePlayer((double)worldPosition.getX() + 0.5D, (double)worldPosition.getY() + 0.5D, (double)worldPosition.getZ() + 0.5D, 5.0D)) {
				this.level.addFreshEntity(Util.make(new ThrownPotion(level, worldPosition.getX(), worldPosition.getY(), worldPosition.getZ()), potion -> potion.setItem(getPotionStack())));
				clear();
				level.setBlock(worldPosition, this.getBlockState().setValue(AGE, 0), 4);
			}
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
	public void load(CompoundTag nbt) {
		super.load(nbt);
	    if (nbt.contains(POTION_ITEM)) {
	    	this.setPotionStack(ItemStack.of(nbt.getCompound(POTION_ITEM)));
	    }
	}

	@Override
	public void saveAdditional(CompoundTag compound) {
		super.saveAdditional(compound);
	    if (!this.getPotionStack().isEmpty()) {
	    	compound.put(POTION_ITEM, this.getPotionStack().save(new CompoundTag()));
	    }	   
	}
}
