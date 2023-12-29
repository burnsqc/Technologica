package com.technologica.capabilities.entity.airMeter;

import net.minecraft.nbt.CompoundTag;

public class AirMeter implements IAir {
	private int maxAir = 300;

	@Override
	public int getNewMaxAir() {
		return maxAir;
	}

	@Override
	public void setNewMaxAir(int newMaxAir) {
		maxAir = newMaxAir;
	}

	@Override
	public CompoundTag serializeNBT() {
		final CompoundTag compundTag = new CompoundTag();
		compundTag.putInt("maxAir", maxAir);
		return compundTag;
	}

	@Override
	public void deserializeNBT(CompoundTag compundTag) {
		maxAir = compundTag.getInt("maxAir");
	}
}