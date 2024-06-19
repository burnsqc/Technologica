package com.technologica.listeners.forgebus;

import com.technologica.registration.deferred.TechnologicaMobEffects;

import net.minecraft.client.player.Input;
import net.minecraft.client.player.LocalPlayer;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.MovementInputUpdateEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;

@Mod.EventBusSubscriber(bus = EventBusSubscriber.Bus.FORGE, value = Dist.CLIENT)
public class MovementInputUpdateEventListener {

	@SubscribeEvent
	public static void onMovementInputUpdateEvent(final MovementInputUpdateEvent event) {
		if (event.getEntity().hasEffect(TechnologicaMobEffects.NEUROPATHY.get())) {
			Input originalInput = event.getInput();
			Input invertedInput = originalInput;
			invertedInput.leftImpulse = -originalInput.leftImpulse;
			invertedInput.forwardImpulse = -originalInput.forwardImpulse;
			LocalPlayer lp = (LocalPlayer) event.getEntity();
			lp.input = invertedInput;
		}
	}
}
