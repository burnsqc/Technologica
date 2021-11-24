package com.technologica.entity.passive.fish;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.passive.fish.AbstractGroupFishEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.SoundEvent;
import net.minecraft.world.World;

public class PiranhaEntity extends AbstractGroupFishEntity {

	public PiranhaEntity(EntityType<? extends PiranhaEntity> type, World worldIn) {
		super(type, worldIn);
	}

	@Override
	protected ItemStack getFishBucket() {
		return null;
	}

	@Override
	protected SoundEvent getFlopSound() {
		return null;
	}

}
