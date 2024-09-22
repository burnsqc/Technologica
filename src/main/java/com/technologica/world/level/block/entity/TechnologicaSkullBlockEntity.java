package com.technologica.world.level.block.entity;

import com.technologica.registration.deferred.TechnologicaBlockEntityTypes;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.entity.SkullBlockEntity;
import net.minecraft.world.level.block.state.BlockState;

public class TechnologicaSkullBlockEntity extends SkullBlockEntity {

	public TechnologicaSkullBlockEntity(BlockPos p_155700_, BlockState p_155701_) {
		super(p_155700_, p_155701_);
	}

	@Override
	public BlockEntityType<?> getType() {
		return TechnologicaBlockEntityTypes.SKULL.get();
	}
}