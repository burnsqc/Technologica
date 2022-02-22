package com.technologica.tileentity;

import javax.annotation.Nullable;

import net.minecraft.block.BlockState;
import net.minecraft.entity.projectile.PotionEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.play.server.SUpdateTileEntityPacket;
import net.minecraft.state.IntegerProperty;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.tileentity.ITickableTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Util;
import net.minecraft.util.math.AxisAlignedBB;

public class PotionTileEntity extends TileEntity implements ITickableTileEntity {
	public static final String POTION_ITEM = "PotionItem";
	private ItemStack stack = ItemStack.EMPTY;
	public static final IntegerProperty AGE = BlockStateProperties.AGE_7;
	
	public PotionTileEntity() {
		super(TechnologicaTileEntities.POTION_CROP.get());
	}

	@Override
	public AxisAlignedBB getRenderBoundingBox() {
		return new AxisAlignedBB(getBlockPos(), getBlockPos().offset(1, -1, 1));
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

	@Override
	public void tick() {
		if (this.getPotionStack() != ItemStack.EMPTY) {
			assert level != null;
			if (level.hasNearbyAlivePlayer((double)worldPosition.getX() + 0.5D, (double)worldPosition.getY() + 0.5D, (double)worldPosition.getZ() + 0.5D, 5.0D)) {
				this.level.addFreshEntity(Util.make(new PotionEntity(level, worldPosition.getX(), worldPosition.getY(), worldPosition.getZ()), potion -> potion.setItem(getPotionStack())));
				clear();
				level.setBlock(worldPosition, this.getBlockState().setValue(AGE, 0), 4);
			}
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
	    if (nbt.contains(POTION_ITEM)) {
	    	this.setPotionStack(ItemStack.of(nbt.getCompound(POTION_ITEM)));
	    }
	}

	@Override
	public CompoundNBT save(CompoundNBT compound) {
		super.save(compound);
	    if (!this.getPotionStack().isEmpty()) {
	    	compound.put(POTION_ITEM, this.getPotionStack().save(new CompoundNBT()));
	    }	   
	    return compound;	    
	}
}
