package com.technologica.entity.item;

import com.technologica.entity.TechnologicaEntityType;
import com.technologica.util.EntityUtil;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.IPacket;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.world.World;
import net.minecraftforge.fml.network.NetworkHooks;

public class InvisibleSeatEntity extends Entity {

	public InvisibleSeatEntity(EntityType<?> entityTypeIn, World worldIn) {
		super(entityTypeIn, worldIn);
	}

	public InvisibleSeatEntity(World worldIn, double x, double y, double z) {
		super(TechnologicaEntityType.INVISIBLE_SEAT.get(), worldIn);
		setPos(x, y, z);
		noPhysics = true;
	}

	@Override
	public Vector3d getDismountLocationForPassenger(LivingEntity passenger) {
		if (passenger instanceof PlayerEntity) {
			BlockPos pos = EntityUtil.getPreviousPlayerPosition((PlayerEntity) passenger, this);

			if (pos != null) {
				return new Vector3d(pos.getX(), pos.getY(), pos.getZ());
			}
		}
		remove();
		return super.getDismountLocationForPassenger(passenger);
	}

	@Override
	public void remove() {
		super.remove();
		EntityUtil.removeInvisibleSeatEntity(level, blockPosition());
	}

	@Override
	protected void defineSynchedData() {
	}

	@Override
	protected void readAdditionalSaveData(CompoundNBT compound) {
	}

	@Override
	protected void addAdditionalSaveData(CompoundNBT compound) {
	}

	@Override
	public IPacket<?> getAddEntityPacket() {
		return NetworkHooks.getEntitySpawningPacket(this);
	}
}