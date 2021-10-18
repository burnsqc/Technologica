package com.technologica.entity.item;

import com.technologica.entity.TechnologicaEntities;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.IPacket;
import net.minecraft.world.World;
import net.minecraftforge.fml.network.NetworkHooks;

public class InvisibleSeatEntity extends Entity {

	public InvisibleSeatEntity(EntityType<?> entityTypeIn, World worldIn) {
		super(entityTypeIn, worldIn);	
	}
	
	public InvisibleSeatEntity(World worldIn, double x, double y, double z) {
		super(TechnologicaEntities.INVISIBLE_SEAT.get(), worldIn);
		this.setPosition(x, y, z);
		
	}

	@Override
	protected void registerData() {		
	}

	@Override
	protected void readAdditional(CompoundNBT compound) {		
	}

	@Override
	protected void writeAdditional(CompoundNBT compound) {		
	}

	@Override
	public IPacket<?> createSpawnPacket() {
		return NetworkHooks.getEntitySpawningPacket(this);
	}
}