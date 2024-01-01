package com.technologica.capabilities.entity.airMeter;

import org.jetbrains.annotations.Nullable;

import com.technologica.setup.listeners.TechnologicaCapabilities;

import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.ICapabilitySerializable;
import net.minecraftforge.common.util.LazyOptional;

public class AirMeterProvider implements ICapabilitySerializable<CompoundTag> {
	private final AirMeter airMeter = new AirMeter();
	private final LazyOptional<AirMeter> optionalData = LazyOptional.of(() -> airMeter);

	@Override
	public <T> LazyOptional<T> getCapability(Capability<T> capability, @Nullable Direction direction) {
		return TechnologicaCapabilities.AIR_METER_INSTANCE.orEmpty(capability, optionalData);
	}

	@Override
	public CompoundTag serializeNBT() {
		return airMeter.serializeNBT();
	}

	@Override
	public void deserializeNBT(CompoundTag compundTag) {
		airMeter.deserializeNBT(compundTag);
	}
}