package com.technologica.entity.passive;

import net.minecraft.entity.AgeableEntity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;

public class AlligatorEntity extends AnimalEntity {

	public AlligatorEntity(EntityType<? extends AlligatorEntity> typeIn, World worldIn) {
		super(typeIn, worldIn);
	}

	@Override
	public AgeableEntity createChild(ServerWorld world, AgeableEntity mate) {
		return null;
	}

}
