package com.technologica.capabilities.entity.environmentTracker;

import org.jetbrains.annotations.Nullable;

import com.technologica.setup.listeners.TechnologicaCapabilities;

import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.ICapabilitySerializable;
import net.minecraftforge.common.util.LazyOptional;

public class EnvironmentTrackerProvider implements ICapabilitySerializable<CompoundTag> {
	private final EnvironmentTracker environmentTracker = new EnvironmentTracker();
	private final LazyOptional<EnvironmentTracker> optionalData = LazyOptional.of(() -> environmentTracker);

	@Override
	public <T> LazyOptional<T> getCapability(Capability<T> capability, @Nullable Direction direction) {
		return TechnologicaCapabilities.ENVIRONMENT_TRACKER_INSTANCE.orEmpty(capability, optionalData);
	}

	@Override
	public CompoundTag serializeNBT() {
		return environmentTracker.serializeNBT();
	}

	@Override
	public void deserializeNBT(CompoundTag compundTag) {
		environmentTracker.deserializeNBT(compundTag);
	}
}