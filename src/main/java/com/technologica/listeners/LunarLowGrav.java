package com.technologica.listeners;

import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.player.ClientPlayerEntity;
import net.minecraftforge.event.entity.living.LivingEvent.LivingJumpEvent;
import net.minecraftforge.event.entity.living.LivingFallEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class LunarLowGrav {
	
	@SubscribeEvent
	public void onLivingJumpEvent(LivingJumpEvent event) {
		if (event.getEntity().level.dimension().toString().contains("technologica:moon") && event.getEntity().level.isClientSide) {
			if (event.getEntity() instanceof ClientPlayerEntity) {
				Minecraft mc = Minecraft.getInstance();
				
			    if (mc.options.keyJump.isDown()) {
			    	event.getEntity().push(0, 1, 0);
			    	event.getEntity().hurtMarked = true;
			    }
			}
		}
	}
				
	@SubscribeEvent
	public void onLivingFallEvent(LivingFallEvent event) {
 		if (event.getEntity().level.dimension().toString().contains("technologica:moon")) {
			event.setDamageMultiplier(0F);
		}
	}
}