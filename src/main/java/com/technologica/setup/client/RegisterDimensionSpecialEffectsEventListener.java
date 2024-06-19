package com.technologica.setup.client;

import com.technologica.client.renderer.TechnologicaDimensionSpecialEffects;

import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.RegisterDimensionSpecialEffectsEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;

@Mod.EventBusSubscriber(bus = EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class RegisterDimensionSpecialEffectsEventListener {

	@SubscribeEvent
	public static void onRegisterDimensionSpecialEffectsEvent(final RegisterDimensionSpecialEffectsEvent event) {
		TechnologicaDimensionSpecialEffects.EFFECTS.forEach((k, v) -> event.register(k, v));
	}
}
