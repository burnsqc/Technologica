package com.technologica.world.entity.decoration;

import com.technologica.registration.deferred.TechnologicaEntityTypes;
import com.technologica.util.EntityUtil;

import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.ClientGamePacketListener;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.network.NetworkHooks;

public class InvisibleSeat extends Entity {

	public InvisibleSeat(EntityType<?> entityTypeIn, Level worldIn) {
		super(entityTypeIn, worldIn);
	}

	public InvisibleSeat(Level worldIn, double x, double y, double z) {
		super(TechnologicaEntityTypes.INVISIBLE_SEAT.get(), worldIn);
		setPos(x, y, z);
		noPhysics = true;
	}

	@Override
	public Vec3 getDismountLocationForPassenger(LivingEntity passenger) {
		if (passenger instanceof Player) {
			BlockPos pos = EntityUtil.getPreviousPlayerPosition((Player) passenger, this);

			if (pos != null) {
				return new Vec3(pos.getX(), pos.getY(), pos.getZ());
			}
		}
		this.remove();
		return super.getDismountLocationForPassenger(passenger);
	}

	public void remove() {
		super.discard();
		EntityUtil.removeInvisibleSeatEntity(level(), blockPosition());
	}

	@Override
	protected void defineSynchedData() {
	}

	@Override
	protected void readAdditionalSaveData(CompoundTag compound) {
	}

	@Override
	protected void addAdditionalSaveData(CompoundTag compound) {
	}

	@Override
	public Packet<ClientGamePacketListener> getAddEntityPacket() {
		return NetworkHooks.getEntitySpawningPacket(this);
	}
}