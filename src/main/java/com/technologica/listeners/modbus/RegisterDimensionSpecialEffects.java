package com.technologica.listeners.modbus;

import static com.technologica.Technologica.LOGGER;

import com.technologica.Technologica;
import com.technologica.client.renderer.MoonRenderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.client.event.RegisterDimensionSpecialEffectsEvent;

public class RegisterDimensionSpecialEffects {

	public static void onRegisterDimensionSpecialEffectsEvent(final RegisterDimensionSpecialEffectsEvent event) {
		event.register(new ResourceLocation(Technologica.MODID, "moon"), new MoonRenderer());
		LOGGER.info("DIMENSION SPECIAL EFFECTS REGISTERED: 1 OF 1");
	}
}