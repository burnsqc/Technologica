package com.technologica.listeners.modbus;

import static com.technologica.Technologica.LOGGER;

import net.minecraft.core.registries.Registries;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegisterEvent;

public class Register {
	public static void onRegister(final RegisterEvent event) {
		if (event.getRegistryKey() == Registries.BLOCK) {
			int in = ForgeRegistries.BLOCKS.getEntries().size();
			LOGGER.info("BLOCK REGISTRATION STARTING: " + in + " REQUIRED");
		}
	}
}