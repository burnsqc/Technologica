package com.technologica.listeners.forgebus;

import com.mojang.blaze3d.systems.RenderSystem;
import com.technologica.Technologica;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.client.event.RenderGuiOverlayEvent;
import net.minecraftforge.client.gui.overlay.GuiOverlayManager;
import net.minecraftforge.common.ForgeMod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.registries.ForgeRegistries;

public class RenderGuiOverlayEventListener {
	protected static final ResourceLocation AIR_SPRITE = new ResourceLocation("hud/air");
	public static final ResourceLocation GUI_ICONS_LOCATION = new ResourceLocation(Technologica.MODID, "textures/gui/technologica_icons.png");

	@SubscribeEvent
	public void onRenderGameOverlayEventPre(RenderGuiOverlayEvent.Pre event) {
		if (event.getOverlay() == GuiOverlayManager.findOverlay(GUI_ICONS_LOCATION)) {
			Minecraft minecraft = Minecraft.getInstance();
			Player player = (Player) minecraft.getCameraEntity();
			Iterable<ItemStack> armor = player.getArmorSlots();
			boolean fullSnorkelSet = true;
			boolean fullDiveSet = true;
			boolean fullScubaSet = true;
			GuiGraphics guiGraphics = event.getGuiGraphics();

			for (ItemStack piece : armor) {
				if (!ForgeRegistries.ITEMS.getKey(piece.getItem()).getPath().contains("snorkel")) {
					fullSnorkelSet = false;
				}
				if (!ForgeRegistries.ITEMS.getKey(piece.getItem()).getPath().contains("dive")) {
					fullDiveSet = false;
				}
				if (!ForgeRegistries.ITEMS.getKey(piece.getItem()).getPath().contains("scuba")) {
					fullScubaSet = false;
				}
			}

			event.setCanceled(fullSnorkelSet || fullDiveSet);

			if (fullSnorkelSet) {
				minecraft.getProfiler().push("air");
				RenderSystem.enableBlend();
				int left = minecraft.getWindow().getGuiScaledWidth() / 2 + 91;
				int top = minecraft.getWindow().getGuiScaledHeight() - 49;

				int air = player.getAirSupply();

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

			} else if (fullDiveSet) {
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
			} else if (fullScubaSet) {
				minecraft.getProfiler().push("air");
				bind(minecraft, GUI_ICONS_LOCATION);
				RenderSystem.enableBlend();
				int left = minecraft.getWindow().getGuiScaledWidth() / 2 + 91;
				int top = minecraft.getWindow().getGuiScaledHeight() - 49;

				int air = player.getAirSupply();

				if (player.isEyeInFluidType(ForgeMod.WATER_TYPE.get()) || air < 12000) {
					float remaining = air / 12000.0F * 81;
					guiGraphics.blit(GUI_ICONS_LOCATION, left - 81, top, -90, 0, 9, (int) (remaining), 9, 256, 256);
					guiGraphics.blit(GUI_ICONS_LOCATION, left - 81, top, -90, 0, 0, 81, 9, 256, 256);
				}

				RenderSystem.disableBlend();
				minecraft.getProfiler().pop();
			}
		}
	}

	private void bind(Minecraft minecraft, ResourceLocation res) {
		minecraft.getTextureManager().bindForSetup(res);
	}
}