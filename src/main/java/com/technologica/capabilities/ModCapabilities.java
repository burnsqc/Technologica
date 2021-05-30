package com.technologica.capabilities;

import java.util.concurrent.Callable;

import com.technologica.items.PipeWrenchItem;

import net.minecraft.item.ItemStack;
import net.minecraft.nbt.INBT;
import net.minecraft.util.Direction;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.Capability.IStorage;
import net.minecraftforge.common.capabilities.CapabilityInject;
import net.minecraftforge.common.capabilities.CapabilityManager;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

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
	
	@SubscribeEvent
	public void attachCapability(AttachCapabilitiesEvent<ItemStack> event)
	{
		final ResourceLocation LINK_CAP = null;
		if (event.getObject().getItem() instanceof PipeWrenchItem) return;
	 		event.addCapability(LINK_CAP, new LinkProvider());
		}

}