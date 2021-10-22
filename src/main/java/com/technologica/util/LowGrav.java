package com.technologica.util;

import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.player.ClientPlayerEntity;
import net.minecraftforge.event.entity.living.LivingEvent.LivingJumpEvent;
import net.minecraftforge.event.entity.living.LivingFallEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class LowGrav {
	private ClientPlayerEntity client;
	
	@SubscribeEvent
	public void onLivingJumpEvent(LivingJumpEvent event) {
		if (event.getEntity().world.getDimensionKey().toString().contains("technologica:moon")) {
			if (event.getEntity() instanceof ClientPlayerEntity) {
				client = (ClientPlayerEntity) event.getEntity();
				
				Minecraft mc = Minecraft.getInstance();
				
			    if (mc.gameSettings.keyBindJump.isKeyDown()) {
				    client.addVelocity(0, 1, 0);
				    client.velocityChanged = true;
			    }
		    }
		}
	}
				
	@SubscribeEvent
	public void onLivingFallEvent(LivingFallEvent event) {
		if (event.getEntity().world.getDimensionKey().toString().contains("technologica:moon")) {
			event.setDamageMultiplier(0F);
		}
	}
}