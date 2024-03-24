package com.technologica.world.entity.player;

import org.jetbrains.annotations.Nullable;

import com.technologica.setup.listeners.TechnologicaCapabilities;

import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.ICapabilitySerializable;
import net.minecraftforge.common.util.LazyOptional;

public class TechnologicaAbilityProvider implements ICapabilitySerializable<CompoundTag> {
	private final TechnologicaAbilities diver = new TechnologicaAbilities();
	private final LazyOptional<TechnologicaAbilities> optionalData = LazyOptional.of(() -> diver);

	@Override
	public <T> LazyOptional<T> getCapability(Capability<T> capability, @Nullable Direction direction) {
		return TechnologicaCapabilities.DIVER_INSTANCE.orEmpty(capability, optionalData);
	}

	@Override
	public CompoundTag serializeNBT() {
		return diver.serializeNBT();
	}

	@Override
	public void deserializeNBT(CompoundTag compoundTag) {
		diver.deserializeNBT(compoundTag);
	}
}
