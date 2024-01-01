package com.technologica.world.level.block.entity;

import net.minecraft.world.level.block.entity.SignBlockEntity;
import net.minecraft.world.level.block.state.BlockState;

import com.technologica.registration.deferred.TechnologicaBlockEntityTypes;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.entity.BlockEntityType;

public class VanillaSignBlockEntity extends SignBlockEntity {
	
	public VanillaSignBlockEntity(BlockPos p_155700_, BlockState p_155701_) {
		super(p_155700_, p_155701_);
	}

	@Override
	public BlockEntityType<?> getType() {
		return TechnologicaBlockEntityTypes.VANILLA_SIGN.get();
	}
}