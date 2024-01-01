package com.technologica.capabilities.item.link;

import javax.annotation.Nonnull;

import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.Tag;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.ICapabilitySerializable;
import net.minecraftforge.common.util.LazyOptional;

public class LinkProvider implements ICapabilitySerializable<Tag> {
	public static final Capability<ILink> LINK_CAP = null;
	private static final LazyOptional<ILink> instance = LazyOptional.of(Link::new);

	@Nonnull
	@Override
	public <T> LazyOptional<T> getCapability(@Nonnull Capability<T> cap, Direction side) {
		return cap == LINK_CAP ? instance.cast() : LazyOptional.empty();
	}

	@Nonnull
	@Override
	public <T> LazyOptional<T> getCapability(@Nonnull Capability<T> cap) {
		return getCapability(cap, null);
	}

	@Override
	public Tag serializeNBT() {
		CompoundTag nbt = new CompoundTag();
		return nbt;
	}

	@Override
	public void deserializeNBT(Tag nbt) {

	}
}