package com.technologica.world.level.block.entity;

import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.NbtUtils;
import net.minecraft.world.level.block.entity.BlockEntity;

public class MulchTileEntity extends BlockEntity {
	private BlockState previousBlockState = Blocks.AIR.defaultBlockState();
	
	public MulchTileEntity(BlockPos p_155700_, BlockState p_155701_) {
		super(TechnologicaBlockEntityType.MULCH_TILE.get(), p_155700_, p_155701_);
	}

	public BlockState getPreviousBlockState() {
        return previousBlockState;
    }
	
	public void setPreviousBlockState(BlockState previousBlockStateIn) {
        this.previousBlockState = previousBlockStateIn;
        setChanged();
        if (level != null) {
        	level.sendBlockUpdated(worldPosition, getBlockState(), getBlockState(), 2); 
        }
    }
	
	@Override
	public void load(CompoundTag nbt) {
		super.load(nbt);
	    if (nbt.contains("previousState")) {
	    	this.setPreviousBlockState(NbtUtils.readBlockState(null, nbt.getCompound("previousState")));
	    }
	}

	@Override
	public void saveAdditional(CompoundTag compound) {
		super.saveAdditional(compound);
	    compound.put("previousState", NbtUtils.writeBlockState(getPreviousBlockState())); 			    
	}
}
