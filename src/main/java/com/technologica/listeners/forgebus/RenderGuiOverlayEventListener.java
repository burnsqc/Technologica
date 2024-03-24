package com.technologica.listeners.forgebus;

import com.mojang.blaze3d.systems.RenderSystem;
import com.technologica.util.text.TechnologicaLocation;

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
	private static final ResourceLocation GUI_ICONS_LOCATION = new TechnologicaLocation("textures/gui/technologica_icons.png");
	private static final ResourceLocation AIR_SPRITE = new ResourceLocation("textures/gui/icons.png");

	@SubscribeEvent
	public static void onPre(final RenderGuiOverlayEvent.Pre event) {
		Minecraft minecraft = Minecraft.getInstance();
		Player player = (Player) minecraft.getCameraEntity();

		if (event.getOverlay() == VanillaGuiOverlay.AIR_LEVEL.type()) {
			GuiGraphics guiGraphics = event.getGuiGraphics();
			int maxAir = player.getMaxAirSupply();

			if (maxAir == 600) {
				event.setCanceled(true);

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

			} else if (maxAir >= 3000) {
				event.setCanceled(true);
				minecraft.getTextureManager().bindForSetup(GUI_ICONS_LOCATION);

				int left = minecraft.getWindow().getGuiScaledWidth() / 2 + 91;
				int top = minecraft.getWindow().getGuiScaledHeight() - 49;
				int air = player.getAirSupply();

				RenderSystem.enableBlend();
				if (player.isEyeInFluidType(ForgeMod.WATER_TYPE.get()) || air < maxAir) {
					float remaining = air / (float) maxAir * 81;
					guiGraphics.blit(GUI_ICONS_LOCATION, left - 81, top, -90, 0, 9, (int) (remaining), 9, 256, 256);
					guiGraphics.blit(GUI_ICONS_LOCATION, left - 81, top, -90, 0, 0, 81, 9, 256, 256);
				}
				RenderSystem.disableBlend();
			}
		}
	}
}
