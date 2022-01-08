package com.technologica.tileentity;

import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.nbt.NBTUtil;
import net.minecraft.tileentity.TileEntity;

public class MulchTileEntity extends TileEntity {
	private BlockState previousBlockState = Blocks.AIR.getDefaultState();
	
	public MulchTileEntity() {
		super(TechnologicaTileEntities.MULCH_TILE.get());
	}

	public BlockState getPreviousBlockState() {
        return previousBlockState;
    }
	
	public void setPreviousBlockState(BlockState previousBlockStateIn) {
        this.previousBlockState = previousBlockStateIn;
        markDirty();
        if (world != null) {
        	world.notifyBlockUpdate(pos, getBlockState(), getBlockState(), 2); 
        }
    }
	
	@Override
	public void read(BlockState state, CompoundNBT nbt) {
		super.read(state, nbt);
	    if (nbt.contains("previousState")) {
	    	this.setPreviousBlockState(NBTUtil.readBlockState(nbt.getCompound("previousState")));
	    }
	}

	@Override
	public CompoundNBT write(CompoundNBT compound) {
		super.write(compound);
	    compound.put("previousState", NBTUtil.writeBlockState(getPreviousBlockState())); 		
	    return compound;	    
	}
}
