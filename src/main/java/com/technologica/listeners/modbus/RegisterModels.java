package com.technologica.listeners.modbus;

import static com.technologica.Technologica.LOGGER;

import com.technologica.Technologica;

import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.client.event.ModelEvent;

public class RegisterModels {

	public static void onRegisterModelsEvent(ModelEvent.RegisterAdditional event) {
		event.register(new ResourceLocation(Technologica.MODID, "item/oganesson_ingot"));
		LOGGER.info("MODELS REGISTERED: 1 OF 1");
	}
}