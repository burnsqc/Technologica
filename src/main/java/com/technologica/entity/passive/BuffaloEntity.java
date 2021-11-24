package com.technologica.entity.passive;

import net.minecraft.entity.AgeableEntity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;

public class BuffaloEntity extends AnimalEntity {

	public BuffaloEntity(EntityType<? extends BuffaloEntity> type, World worldIn) {
		super(type, worldIn);
	}

	@Override
	public AgeableEntity createChild(ServerWorld world, AgeableEntity mate) {
		// TODO Auto-generated method stub
		return null;
	}

}
