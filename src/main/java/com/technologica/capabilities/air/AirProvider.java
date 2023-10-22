package com.technologica.capabilities.air;

import javax.annotation.Nonnull;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import com.technologica.Technologica;
import com.technologica.capabilities.TechnologicaCapabilities;

import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.ICapabilityProvider;
import net.minecraftforge.common.util.INBTSerializable;
import net.minecraftforge.common.util.LazyOptional;

public class AirProvider implements ICapabilityProvider, INBTSerializable<CompoundTag> {
	public static final ResourceLocation IDENTIFIER = new ResourceLocation(Technologica.MODID, "air");
	private final IAir backend = new Air();
	private final LazyOptional<IAir> optionalData = LazyOptional.of(() -> backend);

	@Nonnull
	@Override
	public <T> @NotNull LazyOptional<T> getCapability(@NotNull Capability<T> cap, @Nullable Direction side) {
		return TechnologicaCapabilities.INSTANCE.orEmpty(cap, this.optionalData);
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