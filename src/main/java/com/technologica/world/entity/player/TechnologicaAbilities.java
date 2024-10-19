package com.technologica.world.entity.player;

import net.minecraft.nbt.CompoundTag;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.CapabilityManager;
import net.minecraftforge.common.capabilities.CapabilityToken;
import net.minecraftforge.common.util.INBTSerializable;

public class TechnologicaAbilities implements INBTSerializable<CompoundTag> {
	private boolean diver;
	private boolean doubleJump;
	public static final Capability<TechnologicaAbilities> DIVER_INSTANCE = CapabilityManager.get(new CapabilityToken<>() {
	});

	public boolean getDiver() {
		return this.diver;
	}

	public void setDiver(boolean diver) {
		this.diver = diver;
	}

	public boolean getDoubleJump() {
		return this.doubleJump;
	}

	public void setDoubleJump(boolean doubleJump) {
		this.doubleJump = doubleJump;
	}

	@Override
	public CompoundTag serializeNBT() {
		final CompoundTag compundTag = new CompoundTag();
		compundTag.putBoolean("diver", diver);
		compundTag.putBoolean("doubleJump", doubleJump);
		return compundTag;
	}

	@Override
	public void deserializeNBT(CompoundTag compoundTag) {
		diver = compoundTag.getBoolean("diver");
		doubleJump = compoundTag.getBoolean("doubleJump");
	}
}
