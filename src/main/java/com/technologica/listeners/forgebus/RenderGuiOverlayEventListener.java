package com.technologica.listeners.forgebus;

import org.joml.Matrix4f;

import com.mojang.blaze3d.systems.RenderSystem;
import com.technologica.capabilities.TechnologicaCapabilities;
import com.technologica.capabilities.air.IAir;
import com.technologica.util.text.TechnologicaLocation;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Font;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.biome.Biome;
import net.minecraftforge.client.event.RenderGuiOverlayEvent;
import net.minecraftforge.client.gui.overlay.VanillaGuiOverlay;
import net.minecraftforge.common.ForgeMod;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class RenderGuiOverlayEventListener {
	private static final ResourceLocation GUI_ICONS_LOCATION = new TechnologicaLocation("textures/gui/technologica_icons.png");
	private static final ResourceLocation AIR_SPRITE = new ResourceLocation("textures/gui/icons.png");
	private static Biome biome;
	private static int fade;

	@SubscribeEvent
	public static void onRenderGameOverlayEventPre(RenderGuiOverlayEvent.Pre event) {
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

			} else if (newMaxAir >= 3000) {
				event.setCanceled(true);
				GuiGraphics guiGraphics = event.getGuiGraphics();
				minecraft.getProfiler().push("air");
				bind(minecraft, GUI_ICONS_LOCATION);
				RenderSystem.enableBlend();
				int left = minecraft.getWindow().getGuiScaledWidth() / 2 + 91;
				int top = minecraft.getWindow().getGuiScaledHeight() - 49;
				int air = player.getAirSupply();
				if (player.isEyeInFluidType(ForgeMod.WATER_TYPE.get()) || air < newMaxAir) {
					float remaining = air / (float) newMaxAir * 81;
					guiGraphics.blit(GUI_ICONS_LOCATION, left - 81, top, -90, 0, 9, (int) (remaining), 9, 256, 256);
					guiGraphics.blit(GUI_ICONS_LOCATION, left - 81, top, -90, 0, 0, 81, 9, 256, 256);
				}
				RenderSystem.disableBlend();
				minecraft.getProfiler().pop();

			}
		}

		// TESTING OVERLAY FOR BIOMES
		Minecraft minecraft = Minecraft.getInstance();
		Matrix4f matrix4f = event.getGuiGraphics().pose().last().pose();
		MultiBufferSource.BufferSource irendertypebuffer$impl = minecraft.renderBuffers().bufferSource();
		Player player = (Player) minecraft.getCameraEntity();
		BlockPos blockpos = BlockPos.containing(player.getEyePosition().x, player.getEyePosition().y, player.getEyePosition().z);

		Biome newBiome = player.level().getBiome(blockpos).get();

		if (fade > 0) {
			fade--;
		}

		if (biome != newBiome) {
			biome = newBiome;
			fade = 5000;
		}

		String dimensionName = stringToProperName(player.level().dimension().location().getPath().toString());
		String biomeName = stringToProperName(player.level().getBiome(blockpos).unwrapKey().get().location().getPath().toString());

		int dimensionNamePosX = minecraft.getWindow().getGuiScaledWidth() - minecraft.font.width(dimensionName) - 10;
		int biomeNamePosX = minecraft.getWindow().getGuiScaledWidth() - minecraft.font.width(biomeName) - 10;

		// ATTEMPTING TO RIP OFF NAMETAG RENDERING FOR THIS
		float f1 = minecraft.options.getBackgroundOpacity(0.25F);
		int j = (int) (f1 * 255.0F) << 24;

		minecraft.font.drawInBatch(dimensionName, dimensionNamePosX, 10, 553648127, false, matrix4f, irendertypebuffer$impl, Font.DisplayMode.SEE_THROUGH, j, 553648127);
	}

	private static String stringToProperName(String string) {
		String words[] = string.split("_");
		String name = "";
		for (String word : words) {
			String first = word.substring(0, 1);
			String afterFirst = word.substring(1);
			name += first.toUpperCase() + afterFirst + " ";
		}
		return name.trim();
	}

	private static void bind(Minecraft minecraft, ResourceLocation res) {
		minecraft.getTextureManager().bindForSetup(res);
	}
}