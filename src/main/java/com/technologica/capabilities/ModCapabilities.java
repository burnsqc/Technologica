package com.technologica.capabilities;

import net.minecraftforge.common.capabilities.CapabilityManager;

public class ModCapabilities {

	public static void register() {
		CapabilityManager.INSTANCE.register(ILink.class, new Link.LinkStorage(), new Link.Factory());
	}
}