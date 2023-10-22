package com.technologica.capabilities.air;

import net.minecraft.nbt.CompoundTag;

public class Air implements IAir {
	private int newMaxAir = 300;

	@Override
	public int getNewMaxAir() {
		return this.newMaxAir;
	}

	@Override
	public void setNewMaxAir(int newMaxAir) {
		this.newMaxAir = newMaxAir;
	}

	@Override
	public CompoundTag serializeNBT() {
		final CompoundTag tag = new CompoundTag();
		tag.putInt("newMaxAir", this.newMaxAir);
		return tag;
	}

	@Override
	public void deserializeNBT(CompoundTag nbt) {
		this.newMaxAir = nbt.getInt("newMaxAir");
	}
}