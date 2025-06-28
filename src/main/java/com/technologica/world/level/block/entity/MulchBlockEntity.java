package com.technologica.world.level.block.entity;

import com.technologica.registration.deferred.TechnologicaBlockEntityTypes;

import net.minecraft.core.BlockPos;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.NbtUtils;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;

public class MulchBlockEntity extends BlockEntity {
	private BlockState previousBlockState = Blocks.AIR.defaultBlockState();
	
	public MulchBlockEntity(BlockPos blockPos, BlockState blockState) {
		super(TechnologicaBlockEntityTypes.MULCH.get(), blockPos, blockState);
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
	public void load(CompoundTag compoundTag) {
		super.load(compoundTag);
		@SuppressWarnings("deprecation")
		HolderGetter<Block> holdergetter = this.level != null ? this.level.holderLookup(Registries.BLOCK) : BuiltInRegistries.BLOCK.asLookup();
		if (compoundTag.contains("previousState")) {
			this.setPreviousBlockState(NbtUtils.readBlockState(holdergetter, compoundTag.getCompound("previousState")));
	    }
	}

	@Override
	public void saveAdditional(CompoundTag compoundTag) {
		super.saveAdditional(compoundTag);
	    compoundTag.put("previousState", NbtUtils.writeBlockState(getPreviousBlockState())); 			    
	}
}
