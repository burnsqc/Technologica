package com.technologica.tileentity;

import javax.annotation.Nullable;

import com.technologica.setup.Registration;

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
	private ItemStack stack = ItemStack.EMPTY;
	public static final IntegerProperty AGE = BlockStateProperties.AGE_0_7;
	
	public PotionTileEntity() {
		super(Registration.POTION_CROP.get());
	}

	@Override
	public AxisAlignedBB getRenderBoundingBox() {
		return new AxisAlignedBB(getPos(), getPos().add(1, -1, 1));
	}
	
	public ItemStack getPotionStack() {
        return stack;
    }
	
	public void setPotionStack(ItemStack stackIn) {
        this.stack = stackIn;
        markDirty();
        if (world != null) {
        	world.notifyBlockUpdate(pos, getBlockState(), getBlockState(), 2); 
        }
    }
	
	public void clear() {
        this.setPotionStack(ItemStack.EMPTY);  
    }

	@Override
	public void tick() {
		if (this.getPotionStack() != ItemStack.EMPTY && world.isPlayerWithin((double)pos.getX() + 0.5D, (double)pos.getY() + 0.5D, (double)pos.getZ() + 0.5D, 5.0D)) {
			this.world.addEntity(Util.make(new PotionEntity(world, pos.getX(), pos.getY(), pos.getZ()), (potion) -> {potion.setItem(getPotionStack());}));
			clear();
			world.setBlockState(pos, this.getBlockState().with(AGE, Integer.valueOf(0)), 4);
		}
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
	    if (nbt.contains("PotionItem")) {
	    	this.setPotionStack(ItemStack.read(nbt.getCompound("PotionItem")));
	    }
	}

	@Override
	public CompoundNBT write(CompoundNBT compound) {
		super.write(compound);
	    if (!this.getPotionStack().isEmpty()) {
	    	compound.put("PotionItem", this.getPotionStack().write(new CompoundNBT()));
	    }	   
	    return compound;	    
	}
}