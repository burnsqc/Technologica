package com.technologica.capabilities;

import java.util.concurrent.Callable;

import net.minecraft.nbt.INBT;
import net.minecraft.util.Direction;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.Capability.IStorage;
import net.minecraftforge.common.capabilities.CapabilityInject;
import net.minecraftforge.common.capabilities.CapabilityManager;

public class ModCapabilities {

	@CapabilityInject(ILink.class)
	public static Capability<ILink> LINK_CAPABILITY = null;

	public static void register() {
		CapabilityManager.INSTANCE.register(ILink.class, new LinkCapability(), new Factory());
	}

	public static class LinkCapability implements IStorage<ILink> {
		@Override
		public INBT writeNBT(Capability<ILink> capability, ILink instance, Direction side) {
			return null;
		}

		@Override
		public void readNBT(Capability<ILink> capability, ILink instance, Direction side, INBT nbt) {
		}
	}

	private static class Factory implements Callable<ILink> {
		@Override
		public ILink call() throws Exception {
			return new Link();
		}
	}
}