package com.technologica.listeners;

import com.technologica.Technologica;
import com.technologica.client.renderer.MoonRenderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.client.event.RegisterDimensionSpecialEffectsEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class TechnologicaDimensionSpecialEffects {

	@SubscribeEvent
	public static void onRegisterDimensionSpecialEffectsEvent(final RegisterDimensionSpecialEffectsEvent event) {
		event.register(new ResourceLocation(Technologica.MODID, "moon"), new MoonRenderer());
	}
}