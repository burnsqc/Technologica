package com.technologica.entity.passive;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.passive.horse.AbstractChestedHorseEntity;
import net.minecraft.world.World;

public class CamelEntity extends AbstractChestedHorseEntity {

	public CamelEntity(EntityType<? extends CamelEntity> type, World worldIn) {
		super(type, worldIn);
	}

}
