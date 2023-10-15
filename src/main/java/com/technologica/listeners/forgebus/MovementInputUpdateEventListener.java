package com.technologica.listeners.forgebus;

import com.technologica.world.effect.TechnologicaMobEffects;

import net.minecraft.client.player.Input;
import net.minecraft.client.player.LocalPlayer;
import net.minecraftforge.client.event.MovementInputUpdateEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class MovementInputUpdateEventListener {

	@SubscribeEvent
	public void onLivingJumpEvent(MovementInputUpdateEvent event) {
		if (event.getEntity().hasEffect(TechnologicaMobEffects.NEUROPATHY.get())) {
			Input input = event.getInput();
			Input input2 = event.getInput();
			input2.leftImpulse = -input.leftImpulse;
			input2.forwardImpulse = -input.forwardImpulse;
			LocalPlayer lp = (LocalPlayer) event.getEntity();
			lp.input = input2;
		}
	}
}