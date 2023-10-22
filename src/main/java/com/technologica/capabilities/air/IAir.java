package com.technologica.capabilities.air;

import net.minecraft.nbt.CompoundTag;
import net.minecraftforge.common.util.INBTSerializable;

public interface IAir extends INBTSerializable<CompoundTag> {
	int getNewMaxAir();

	void setNewMaxAir(int newMaxAir);
}
