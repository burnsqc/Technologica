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
	// todo: LINK_CAP needs to not be null for this class to not always throw NPEs
	public static final Capability<ILink> LINK_CAP = null;
	private static final LazyOptional<ILink> instance = LazyOptional.of(Link::new);

	@Nonnull
	@Override
	public <T> LazyOptional<T> getCapability(@Nonnull Capability<T> cap, Direction side) {
		// todo: this param is non nullable, but LINK_CAP is always null
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
