package com.technologica.capabilities.environmentTracker;

import java.util.HashSet;
import java.util.Set;

import net.minecraft.nbt.CompoundTag;
import net.minecraftforge.common.util.INBTSerializable;

public class EnvironmentTracker implements INBTSerializable<CompoundTag> {
	private Set<String> biomes = new HashSet<String>();

	public Set<String> getBiomes() {
		return biomes;
	}

	public void addBiome(String biome) {
		biomes.add(biome);
	}

	@Override
	public CompoundTag serializeNBT() {
		CompoundTag nbt = new CompoundTag();

		for (String string : biomes) {
			nbt.putString(string, string);
		}

		return nbt;
	}

	@Override
	public void deserializeNBT(CompoundTag nbt) {
		this.biomes = nbt.getAllKeys();
	}
}