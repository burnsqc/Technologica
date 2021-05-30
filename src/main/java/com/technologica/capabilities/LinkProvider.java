package com.technologica.capabilities;

import javax.annotation.Nonnull;

import net.minecraft.nbt.FloatNBT;
import net.minecraft.util.Direction;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.CapabilityInject;
import net.minecraftforge.common.capabilities.ICapabilitySerializable;
import net.minecraftforge.common.util.LazyOptional;

public class LinkProvider implements ICapabilitySerializable<FloatNBT> {
	  @CapabilityInject(ILink.class)
	  public static final Capability<ILink> LINK_CAP = null;

	  private LazyOptional<ILink> instance = LazyOptional.of(LINK_CAP::getDefaultInstance);

	  @Nonnull
	  @Override
	  public <T> LazyOptional<T> getCapability(@Nonnull Capability<T> cap, Direction side) {
	    return LINK_CAP.orEmpty(cap, instance);
	  }

	  @Override
	  public FloatNBT serializeNBT() {
	    return (FloatNBT) LINK_CAP.getStorage().writeNBT(LINK_CAP, instance.orElseThrow(() -> new IllegalArgumentException("at serialize")), null);
	  }

	  @Override
	  public void deserializeNBT(FloatNBT nbt) {
	    LINK_CAP.getStorage().readNBT(LINK_CAP, instance.orElseThrow(() -> new IllegalArgumentException("at deserialize")), null, nbt);
	  }

	
}