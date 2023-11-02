package com.technologica.listeners.forgebus;

import com.technologica.world.effect.TechnologicaMobEffects;

import net.minecraft.client.player.Input;
import net.minecraft.client.player.LocalPlayer;
import net.minecraftforge.client.event.MovementInputUpdateEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class MovementInputUpdateEventListener {

	@SubscribeEvent
	public void onMovementInputUpdateEvent(MovementInputUpdateEvent event) {
		if (event.getEntity().hasEffect(TechnologicaMobEffects.NEUROPATHY.get())) {
			Input originalInput = event.getInput();
			Input invertedInput = event.getInput();
			invertedInput.leftImpulse = -originalInput.leftImpulse;
			invertedInput.forwardImpulse = -originalInput.forwardImpulse;
			LocalPlayer lp = (LocalPlayer) event.getEntity();
			lp.input = invertedInput;
		}
	}
}