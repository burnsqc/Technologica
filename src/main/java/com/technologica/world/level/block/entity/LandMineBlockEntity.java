package com.technologica.world.level.block.entity;

import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.NbtUtils;
import net.minecraft.world.level.Explosion;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;

public class LandMineBlockEntity extends BlockEntity {
	private BlockState previousBlockState = Blocks.AIR.defaultBlockState();
	private boolean isArmed = false;
	
	public LandMineBlockEntity(BlockPos p_155700_, BlockState p_155701_) {
		super(TechnologicaBlockEntityType.LAND_MINE_TILE.get(), p_155700_, p_155701_);
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
	
	public Boolean getArmed() {
        return isArmed;
    }
	
	public void setArmed() {
       isArmed = true;
    }
	
	public void tick() {
		if (isArmed) {
			assert level != null;
			if (!level.hasNearbyAlivePlayer((double)worldPosition.getX() + 0.5D, (double)worldPosition.getY() + 0.5D, (double)worldPosition.getZ() + 0.5D, 1.0D)) {
				level.explode(null, worldPosition.getX(), worldPosition.getY(), worldPosition.getZ(), 4.0F, Explosion.BlockInteraction.BREAK);
			}	
		}
		
	}
	@Override
	public void load(CompoundTag nbt) {
		super.load(nbt);
	    if (nbt.contains("previousState")) {
	    	this.setPreviousBlockState(NbtUtils.readBlockState(nbt.getCompound("previousState")));
	    }
	}

	@Override
	public void saveAdditional(CompoundTag compound) {
		super.saveAdditional(compound);
	    compound.put("previousState", NbtUtils.writeBlockState(getPreviousBlockState())); 			    
	}
}
