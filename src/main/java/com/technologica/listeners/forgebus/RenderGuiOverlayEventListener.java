package com.technologica.listeners.forgebus;

import com.mojang.blaze3d.systems.RenderSystem;
import com.technologica.Technologica;
import com.technologica.capabilities.TechnologicaCapabilities;
import com.technologica.capabilities.air.IAir;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.client.event.RenderGuiOverlayEvent;
import net.minecraftforge.client.gui.overlay.VanillaGuiOverlay;
import net.minecraftforge.common.ForgeMod;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class RenderGuiOverlayEventListener {
	public static final ResourceLocation GUI_ICONS_LOCATION = new ResourceLocation(Technologica.MODID, "textures/gui/technologica_icons.png");
	protected static final ResourceLocation AIR_SPRITE = new ResourceLocation("textures/gui/icons.png");

	@SubscribeEvent
	public void onRenderGameOverlayEventPre(RenderGuiOverlayEvent.Pre event) {
		if (event.getOverlay() == VanillaGuiOverlay.AIR_LEVEL.type()) {
			Minecraft minecraft = Minecraft.getInstance();
			Player player = (Player) minecraft.getCameraEntity();

			IAir airCapability = player.getCapability(TechnologicaCapabilities.INSTANCE).orElseThrow(NullPointerException::new);
			int newMaxAir = airCapability.getNewMaxAir();

			if (newMaxAir == 600) {
				event.setCanceled(true);
				GuiGraphics guiGraphics = event.getGuiGraphics();
				minecraft.getProfiler().push("air");
				int left = minecraft.getWindow().getGuiScaledWidth() / 2 + 91;
				int top = minecraft.getWindow().getGuiScaledHeight() - 49;
				int air = player.getAirSupply();
				RenderSystem.enableBlend();
				if (player.isEyeInFluidType(ForgeMod.WATER_TYPE.get()) || air < 600) {
					int full = Mth.ceil((air - 2) * 10.0D / 300.0D);
					int partial = Mth.ceil(air * 10.0D / 300.0D) - full;

					for (int i = 0; i < full + partial; ++i) {
						int horizontal = i > 9 ? 71 : -9;
						int vertical = i > 9 ? -10 : 0;
						guiGraphics.blit(AIR_SPRITE, left - i * 8 + horizontal, top + vertical, -90, i < full ? 16 : 25, 18, 9, 9, 256, 256);
					}
				}
				RenderSystem.disableBlend();
				minecraft.getProfiler().pop();

			} else if (newMaxAir == 6000) {
				event.setCanceled(true);
				GuiGraphics guiGraphics = event.getGuiGraphics();
				minecraft.getProfiler().push("air");
				bind(minecraft, GUI_ICONS_LOCATION);
				RenderSystem.enableBlend();
				int left = minecraft.getWindow().getGuiScaledWidth() / 2 + 91;
				int top = minecraft.getWindow().getGuiScaledHeight() - 49;
				int air = player.getAirSupply();
				if (player.isEyeInFluidType(ForgeMod.WATER_TYPE.get()) || air < 6000) {
					float remaining = air / 6000.0F * 81;
					guiGraphics.blit(GUI_ICONS_LOCATION, left - 81, top, -90, 0, 9, (int) (remaining), 9, 256, 256);
					guiGraphics.blit(GUI_ICONS_LOCATION, left - 81, top, -90, 0, 0, 81, 9, 256, 256);
				}
				RenderSystem.disableBlend();
				minecraft.getProfiler().pop();

			}

			/*
			 * else if (fullScubaSet) {
			 * minecraft.getProfiler().push("air");
			 * bind(minecraft, GUI_ICONS_LOCATION);
			 * RenderSystem.enableBlend();
			 * int left = minecraft.getWindow().getGuiScaledWidth() / 2 + 91;
			 * int top = minecraft.getWindow().getGuiScaledHeight() - 49;
			 * 
			 * int air = player.getAirSupply();
			 * 
			 * if (player.isEyeInFluidType(ForgeMod.WATER_TYPE.get()) || air < 12000) {
			 * float remaining = air / 12000.0F * 81;
			 * guiGraphics.blit(GUI_ICONS_LOCATION, left - 81, top, -90, 0, 9, (int) (remaining), 9, 256, 256);
			 * guiGraphics.blit(GUI_ICONS_LOCATION, left - 81, top, -90, 0, 0, 81, 9, 256, 256);
			 * }
			 * 
			 * RenderSystem.disableBlend();
			 * minecraft.getProfiler().pop();
			 */
		}
	}

	private void bind(Minecraft minecraft, ResourceLocation res) {
		minecraft.getTextureManager().bindForSetup(res);
	}
}