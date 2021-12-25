package com.technologica.entity.passive.fish;

import com.technologica.item.TechnologicaItems;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.passive.fish.AbstractGroupFishEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.SoundEvents;
import net.minecraft.world.World;

public class PiranhaEntity extends AbstractGroupFishEntity {

	public PiranhaEntity(EntityType<? extends PiranhaEntity> typeIn, World worldIn) {
		super(typeIn, worldIn);
	}

	public int getMaxGroupSize() {
		return 10;
	}

	protected ItemStack getFishBucket() {
		return new ItemStack(TechnologicaItems.PIRANHA_BUCKET.get());
	}

	protected SoundEvent getAmbientSound() {
		return SoundEvents.ENTITY_SALMON_AMBIENT;
	}

	protected SoundEvent getDeathSound() {
		return SoundEvents.ENTITY_SALMON_DEATH;
	}

	protected SoundEvent getHurtSound(DamageSource damageSourceIn) {
		return SoundEvents.ENTITY_SALMON_HURT;
	}

	protected SoundEvent getFlopSound() {
		return SoundEvents.ENTITY_SALMON_FLOP;
	}

}
