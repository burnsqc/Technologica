package com.technologica.capabilities.entity.environmentTracker;

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
		CompoundTag compundTag = new CompoundTag();
		for (String string : biomes) {
			compundTag.putString(string, string);
		}
		return compundTag;
	}

	@Override
	public void deserializeNBT(CompoundTag compundTag) {
		biomes = compundTag.getAllKeys();
	}
}