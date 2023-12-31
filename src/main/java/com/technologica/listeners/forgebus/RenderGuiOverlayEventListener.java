package com.technologica.listeners.forgebus;

import org.joml.Matrix4f;

import com.mojang.blaze3d.systems.RenderSystem;
import com.technologica.capabilities.entity.airMeter.IAir;
import com.technologica.setup.listeners.TechnologicaCapabilities;
import com.technologica.util.text.TechnologicaLocation;
import com.technologica.util.text.TextUtil;

import net.minecraft.ChatFormatting;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Font;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.core.BlockPos;
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
	private static int fadeDimensionTimer;
	private static int fadeBiomeTimer;

	@SubscribeEvent
	public static void onRenderGameOverlayEventPre(RenderGuiOverlayEvent.Pre event) {
		Minecraft minecraft = Minecraft.getInstance();
		Player player = (Player) minecraft.getCameraEntity();

		if (event.getOverlay() == VanillaGuiOverlay.AIR_LEVEL.type()) {
			GuiGraphics guiGraphics = event.getGuiGraphics();

			IAir airCapability = player.getCapability(TechnologicaCapabilities.AIR_METER_INSTANCE).orElseThrow(NullPointerException::new);
			int newMaxAir = airCapability.getNewMaxAir();

			if (newMaxAir == 600) {
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

			} else if (newMaxAir >= 3000) {
				event.setCanceled(true);
				minecraft.getTextureManager().bindForSetup(GUI_ICONS_LOCATION);

				int left = minecraft.getWindow().getGuiScaledWidth() / 2 + 91;
				int top = minecraft.getWindow().getGuiScaledHeight() - 49;
				int air = player.getAirSupply();

				RenderSystem.enableBlend();
				if (player.isEyeInFluidType(ForgeMod.WATER_TYPE.get()) || air < newMaxAir) {
					float remaining = air / (float) newMaxAir * 81;
					guiGraphics.blit(GUI_ICONS_LOCATION, left - 81, top, -90, 0, 9, (int) (remaining), 9, 256, 256);
					guiGraphics.blit(GUI_ICONS_LOCATION, left - 81, top, -90, 0, 0, 81, 9, 256, 256);
				}
				RenderSystem.disableBlend();
			}
		}

		if (event.getOverlay() == VanillaGuiOverlay.CROSSHAIR.type()) {

			MultiBufferSource.BufferSource irendertypebuffer$impl = minecraft.renderBuffers().bufferSource();
			BlockPos blockpos = BlockPos.containing(player.getEyePosition().x, player.getEyePosition().y, player.getEyePosition().z);
			String dimensionName = TextUtil.stringToProperName(TextUtil.getPath(player.level().dimension()));
			String biomeName = TextUtil.stringToCapsName(TextUtil.getPath(player.level().getBiome(blockpos)));
			int dimensionNamePosX = minecraft.getWindow().getGuiScaledWidth() / 6 - minecraft.font.width(dimensionName) / 2;
			int biomeNamePosX = minecraft.getWindow().getGuiScaledWidth() / 4 - minecraft.font.width(biomeName) / 2;

			if (fadeDimensionTimer > 0) {
				fadeDimensionTimer--;
			}

			if (fadeBiomeTimer > 0) {
				fadeBiomeTimer--;
			}

			float dimensionAlpha = Mth.clamp(fadeDimensionTimer > 400 ? -(fadeDimensionTimer - 750) / 200F : (fadeDimensionTimer - 50) / 200F, 0.0F, 1.0F);
			float biomeAlpha = Mth.clamp(fadeBiomeTimer > 400 ? -(fadeBiomeTimer - 650) / 200F : (fadeBiomeTimer - 50) / 200F, 0.0F, 1.0F);

			if (dimensionAlpha > 0.015) {
				event.getGuiGraphics().pose().pushPose();
				Matrix4f matrix4f = event.getGuiGraphics().pose().last().pose();
				matrix4f.scale(3.0F, 3.0F, 3.0F);
				minecraft.font.drawInBatch(ChatFormatting.UNDERLINE + dimensionName, dimensionNamePosX, 8, 0xFFFFFF | (int) (dimensionAlpha * 255.0F) << 24, true, matrix4f, irendertypebuffer$impl, Font.DisplayMode.SEE_THROUGH, 0, 0);
				event.getGuiGraphics().pose().popPose();
			}

			if (biomeAlpha > 0.015) {
				event.getGuiGraphics().pose().pushPose();
				Matrix4f matrix4f = event.getGuiGraphics().pose().last().pose();
				matrix4f.scale(2.0F, 2.0F, 2.0F);
				minecraft.font.drawInBatch(ChatFormatting.UNDERLINE + biomeName, biomeNamePosX, 30, 0xFFFFFF | (int) (biomeAlpha * 255.0F) << 24, true, matrix4f, irendertypebuffer$impl, Font.DisplayMode.SEE_THROUGH, 0, 0);
				event.getGuiGraphics().pose().popPose();
			}
		}
	}

	public static void triggerDimensionTitleCard() {
		fadeDimensionTimer = 800;
	}

	public static void triggerBiomeTitleCard() {
		fadeBiomeTimer = fadeDimensionTimer > 0 ? 800 : 700;
	}
}