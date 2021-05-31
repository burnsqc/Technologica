package com.technologica.capabilities;

import javax.annotation.Nonnull;

import net.minecraft.nbt.INBT;
import net.minecraft.util.Direction;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.CapabilityInject;
import net.minecraftforge.common.capabilities.ICapabilitySerializable;
import net.minecraftforge.common.util.LazyOptional;

public class LinkProvider implements ICapabilitySerializable<INBT> {

	@CapabilityInject(ILink.class)
	public static final Capability<ILink> LINK_CAP = null;
	private static final LazyOptional<ILink> instance = LazyOptional.of(LINK_CAP::getDefaultInstance);

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
	public INBT serializeNBT() {
		return LINK_CAP.getStorage().writeNBT(LINK_CAP, instance.orElseThrow(() -> new IllegalArgumentException("at serialize")), null);
	}

	@Override
	public void deserializeNBT(INBT nbt) {
		LINK_CAP.getStorage().readNBT(LINK_CAP, instance.orElseThrow(() -> new IllegalArgumentException("at deserialize")), null, nbt);
	}
}