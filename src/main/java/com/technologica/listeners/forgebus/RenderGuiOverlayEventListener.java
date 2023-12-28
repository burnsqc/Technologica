package com.technologica.listeners.forgebus;

import org.joml.Matrix4f;
import org.lwjgl.opengl.GL11;

import com.mojang.blaze3d.systems.RenderSystem;
import com.technologica.capabilities.TechnologicaCapabilities;
import com.technologica.capabilities.air.IAir;
import com.technologica.util.text.TechnologicaLocation;

import net.minecraft.client.Minecraft;
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
		String dimension = keyToValue(player.level().dimension().location().getPath().toString());

		Biome newBiome = player.level().getBiome(blockpos).get();

		if (fade > 0) {
			fade--;
		}

		if (biome != newBiome) {
			biome = newBiome;
			fade = 5000;
		}

		String biomeName = keyToValue(player.level().getBiome(blockpos).unwrapKey().get().location().getPath().toString());
		float dimensionNameX = minecraft.getWindow().getGuiScaledWidth() - minecraft.font.width(dimension) - 10;
		int biomeNameX = minecraft.getWindow().getGuiScaledWidth() - minecraft.font.width(biomeName) - 10;

		RenderSystem.enableBlend();
		RenderSystem.blendFuncSeparate(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA, 1, 0);

		double d0 = minecraft.options.chatOpacity().get() * 0.9F + 0.1F;
		double d3 = false ? 1.0D : getTimeFactor(500 - fade);
		int j3 = (int) (255.0D * d3 * d0);
		if (j3 > 3) {
			GuiGraphics guiGraphics = event.getGuiGraphics();
			guiGraphics.fill(-4, j3, -2, j3, j3 << 24);
			guiGraphics.drawString(minecraft.font, biomeName, biomeNameX, 20, 16777215 + (j3 << 24));
		}
		// minecraft.font.drawInBatch(dimension, dimensionNameX, 10.0F, 0xFFFFFF, true, matrix4f, irendertypebuffer$impl, Font.DisplayMode.SEE_THROUGH, 0, 0, false);

		// minecraft.font.drawInBatch(dimension, dimensionNameX, 10.0F, 0xFFFFFFFF, true, matrix4f, irendertypebuffer$impl, Font.DisplayMode.SEE_THROUGH, 0, 15728880, false);
		// minecraft.font.drawInBatch(biomeName, biomeNameX, 20.0F, 0x01FFFFFF, true, matrix4f, irendertypebuffer$impl, Font.DisplayMode.SEE_THROUGH, 0, 15728880, false);
	}

	private static String keyToValue(String key) {
		String words[] = key.split("_");
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

	private static double getTimeFactor(int p_93776_) {
		double d0 = p_93776_ / 200.0D;
		d0 = 1.0D - d0;
		d0 *= 10.0D;
		d0 = Mth.clamp(d0, 0.0D, 1.0D);
		return d0 * d0;
	}
}