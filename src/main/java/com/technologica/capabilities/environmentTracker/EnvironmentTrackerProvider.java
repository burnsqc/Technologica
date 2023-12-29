package com.technologica.capabilities.environmentTracker;

import javax.annotation.Nonnull;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import com.technologica.capabilities.TechnologicaCapabilities;
import com.technologica.util.text.TechnologicaLocation;

import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.ICapabilityProvider;
import net.minecraftforge.common.util.INBTSerializable;
import net.minecraftforge.common.util.LazyOptional;

public class EnvironmentTrackerProvider implements ICapabilityProvider, INBTSerializable<CompoundTag> {
	public static final ResourceLocation IDENTIFIER = new TechnologicaLocation("environment_tracker");
	private final EnvironmentTracker backend = new EnvironmentTracker();
	private final LazyOptional<EnvironmentTracker> optionalData = LazyOptional.of(() -> backend);

	@Nonnull
	@Override
	public <T> @NotNull LazyOptional<T> getCapability(@NotNull Capability<T> cap, @Nullable Direction side) {
		return TechnologicaCapabilities.ENVIRONMENT_TRACKER_INSTANCE.orEmpty(cap, this.optionalData);
	}

	@Override
	public CompoundTag serializeNBT() {
		return this.backend.serializeNBT();
	}

	@Override
	public void deserializeNBT(CompoundTag nbt) {
		this.backend.deserializeNBT(nbt);
	}
}