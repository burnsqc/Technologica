package com.technologica.capabilities.item.link;

import javax.annotation.Nonnull;

import org.jetbrains.annotations.Nullable;

import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.ICapabilitySerializable;
import net.minecraftforge.common.util.LazyOptional;

public class PortalHookProvider implements ICapabilitySerializable<CompoundTag> {
	private final PortalHook portalHook = new PortalHook();
	private final LazyOptional<PortalHook> optionalData = LazyOptional.of(() -> portalHook);

	@Nonnull
	@Override
	public <T> LazyOptional<T> getCapability(Capability<T> capability, @Nullable Direction direction) {
		return PortalHook.PORTAL_HOOK_INSTANCE.orEmpty(capability, optionalData);
	}

	@Override
	public CompoundTag serializeNBT() {
		return portalHook.serializeNBT();
	}

	@Override
	public void deserializeNBT(CompoundTag compoundTag) {
		portalHook.deserializeNBT(compoundTag);
	}
}
