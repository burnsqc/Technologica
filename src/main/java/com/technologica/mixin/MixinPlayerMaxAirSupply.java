package com.technologica.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import com.technologica.util.mixininterfaces.IMixinMaxAir;

import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;

/**
 * This Mixin contains 4 components to allow for dynamic maximum air supply values:
 * <p>
 * 1. A new DATA_MAX_AIR_SUPPLY_ID EntityDataAccessor.
 * <p>
 * 2. An injection at the tail of {@linkplain Player#defineSynchedData()} to define a new DATA_MAX_AIR_SUPPLY_ID entityData.
 * <p>
 * 3. An override of {@linkplain Entity#getMaxAirSupply()} to return the value stored by the DATA_MAX_AIR_SUPPLY_ID EntityDataAccessor.
 * Since getMaxAirSupply() is called by {@linkplain Entity#Entity(net.minecraft.world.entity.EntityType, net.minecraft.world.level.Level)} before the new DATA_MAX_AIR_SUPPLY_ID EntityDataAccessor is defined,
 * we will check for its presence and return the originally hard-coded value of 300 if it does not exist yet.
 * This should only occur on Player construction.
 * <p>
 * 4. A new setter method to update the value of the DATA_MAX_AIR_SUPPLY_ID EntityDataAccessor.
 */
@Mixin(Player.class)
public abstract class MixinPlayerMaxAirSupply implements IMixinMaxAir {
	@Unique
	private static final EntityDataAccessor<Integer> DATA_MAX_AIR_SUPPLY_ID = SynchedEntityData.defineId(Player.class, EntityDataSerializers.INT);

	@Inject(method = "defineSynchedData()V", at = @At("TAIL"))
	private void defineMaxAirEntityData(CallbackInfo info) {
		((Player) (Object) this).getEntityData().define(DATA_MAX_AIR_SUPPLY_ID, 300);
	}

	@Override
	public int getMaxAirSupply() {
		if (((Player) (Object) this).getEntityData().hasItem(DATA_MAX_AIR_SUPPLY_ID)) {
			return ((Player) (Object) this).getEntityData().get(DATA_MAX_AIR_SUPPLY_ID);
		}
		return 300;
	}

	@Override
	public void setMaxAirSupply(int maxAirSupply) {
		((Player) (Object) this).getEntityData().set(DATA_MAX_AIR_SUPPLY_ID, maxAirSupply);
	}
}
