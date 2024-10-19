package com.technologica.capabilities.item.link;

import javax.annotation.Nonnull;

import org.jetbrains.annotations.Nullable;

import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.ICapabilitySerializable;
import net.minecraftforge.common.util.LazyOptional;

public class LinkProvider implements ICapabilitySerializable<CompoundTag> {
	private final Link link = new Link();
	private final LazyOptional<Link> optionalData = LazyOptional.of(() -> link);

	@Nonnull
	@Override
	public <T> LazyOptional<T> getCapability(Capability<T> capability, @Nullable Direction direction) {
		return Link.LINK_INSTANCE.orEmpty(capability, optionalData);
	}

	@Override
	public CompoundTag serializeNBT() {
		return link.serializeNBT();
	}

	@Override
	public void deserializeNBT(CompoundTag compoundTag) {
		link.deserializeNBT(compoundTag);
	}
}
