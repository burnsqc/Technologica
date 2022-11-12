package com.technologica.listeners.forgebus;

import static com.technologica.Technologica.LOGGER;

import com.technologica.Technologica;

import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.client.event.ModelEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class RegisterModels {

	@SubscribeEvent
	public void init(ModelEvent.RegisterAdditional event) {
		event.register(new ResourceLocation(Technologica.MODID, "item/oganesson_ingot.json"));
		LOGGER.info("MODELS REGISTERED: 1 OF 1");
	}
}