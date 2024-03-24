package com.technologica.listeners.forgebus;

import com.technologica.registration.deferred.TechnologicaMobEffects;

import net.minecraft.client.Minecraft;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.client.event.RenderLevelStageEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class RenderLevelStageEventListener {
	@SubscribeEvent
	public void onRenderLevelStageEvent(final RenderLevelStageEvent event) {
		Minecraft minecraft = Minecraft.getInstance();
		LocalPlayer localPlayer = minecraft.player;

		if (localPlayer.hasEffect(TechnologicaMobEffects.HALLUCINIATION.get())) {
			if (minecraft.gameRenderer.currentEffect() == null) {
				minecraft.gameRenderer.loadEffect(new ResourceLocation("shaders/post/invert.json"));
			}
		} else {
			if (minecraft.gameRenderer.currentEffect() != null) {
				if (minecraft.gameRenderer.currentEffect().getName().equals(new ResourceLocation("shaders/post/invert.json").toString())) {
					minecraft.gameRenderer.shutdownEffect();
				}
			}
		}
	}
}
