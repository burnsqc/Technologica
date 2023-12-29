package com.technologica.listeners.forgebus;

import org.joml.Matrix4f;

import com.mojang.blaze3d.systems.RenderSystem;
import com.technologica.capabilities.entity.airMeter.IAir;
import com.technologica.capabilities.entity.environmentTracker.EnvironmentTracker;
import com.technologica.setup.config.TechnologicaConfigClient;
import com.technologica.setup.listeners.TechnologicaCapabilities;
import com.technologica.util.text.TechnologicaLocation;
import com.technologica.util.text.TextUtil;

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

		if (event.getOverlay() == VanillaGuiOverlay.VIGNETTE.type()) {
			Matrix4f matrix4f = event.getGuiGraphics().pose().last().pose();
			MultiBufferSource.BufferSource irendertypebuffer$impl = minecraft.renderBuffers().bufferSource();

			if (!TechnologicaConfigClient.BIOME_TITLE_CARDS.get().equals("never")) {
				if (fade > 0) {
					fade--;
				}

				// if (biome != newBiome) {
				// biome = newBiome;
				// fade = 600;
				// }

				String dimensionName = TextUtil.stringToProperName(player.level().dimension().location().getPath().toString());
				int dimensionNamePosX = minecraft.getWindow().getGuiScaledWidth() - minecraft.font.width(dimensionName) - 10;
				float f1 = minecraft.options.getBackgroundOpacity(-(fade / 300F - 1) * (fade / 300F - 1) + 1);
				int j = (int) (f1 * 255.0F) << 24;

				if (TechnologicaConfigClient.BIOME_TITLE_CARDS.get().equals("first")) {
					if (f1 > 0.015) {
						matrix4f.scale(2.0F, 2.0F, 2.0F);
						minecraft.font.drawInBatch(dimensionName, dimensionNamePosX, 10, 0xAAFFAA + j, true, matrix4f, irendertypebuffer$impl, Font.DisplayMode.SEE_THROUGH, 0, 0);
						matrix4f.scale(0.5F, 0.5F, 0.5F);
					}
				}
			}

			if (!TechnologicaConfigClient.BIOME_TITLE_CARDS.get().equals("never")) {
				BlockPos blockpos = BlockPos.containing(player.getEyePosition().x, player.getEyePosition().y, player.getEyePosition().z);
				Biome newBiome = player.level().getBiome(blockpos).get();
				String biomeName = TextUtil.stringToCapsName(player.level().getBiome(blockpos).unwrapKey().get().location().getPath().toString());
				EnvironmentTracker environmentTracker = player.getCapability(TechnologicaCapabilities.ENVIRONMENT_TRACKER_INSTANCE).orElseThrow(NullPointerException::new);

				if (fade > 0) {
					fade--;
				}

				if (biome != newBiome) {
					biome = newBiome;
					if (!environmentTracker.getBiomes().contains(biomeName) && TechnologicaConfigClient.BIOME_TITLE_CARDS.get().equals("first")) {
						environmentTracker.addBiome(biomeName);
						fade = 600;
					} else if (TechnologicaConfigClient.BIOME_TITLE_CARDS.get().equals("always")) {
						fade = 600;
					}

				}

				int biomeNameCenterPosX = minecraft.getWindow().getGuiScaledWidth() / 4 - minecraft.font.width(biomeName) / 2;
				float f1 = minecraft.options.getBackgroundOpacity(-(fade / 300F - 1) * (fade / 300F - 1) + 1);
				int j = (int) (f1 * 255.0F) << 24;

				if (f1 > 0.015) {
					matrix4f.scale(2.0F, 2.0F, 2.0F);
					minecraft.font.drawInBatch(biomeName, biomeNameCenterPosX, 20, 0xAAFFAA + j, true, matrix4f, irendertypebuffer$impl, Font.DisplayMode.SEE_THROUGH, 0, 0);
					matrix4f.scale(0.5F, 0.5F, 0.5F);
				}

			}
		}
	}
}