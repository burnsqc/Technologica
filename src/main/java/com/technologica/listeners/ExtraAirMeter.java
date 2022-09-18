package com.technologica.listeners;

import com.mojang.blaze3d.systems.RenderSystem;
import com.technologica.Technologica;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiComponent;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.client.event.RenderGuiOverlayEvent;
import net.minecraftforge.client.gui.overlay.GuiOverlayManager;
import net.minecraftforge.common.ForgeMod;
import net.minecraftforge.event.TickEvent.Phase;
import net.minecraftforge.event.TickEvent.PlayerTickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.registries.ForgeRegistries;

public class ExtraAirMeter {
	public static final ResourceLocation GUI_ICONS_LOCATION = new ResourceLocation(Technologica.MODID, "textures/gui/technologica_icons.png");

	@SubscribeEvent
	public void onPlayerTickEvent(PlayerTickEvent event) {
		Player player = event.player;
		int air = player.getAirSupply();
		int maxAir = 300;
		boolean fullSnorkelSet = true;
		boolean fullDiveSet = true;
		boolean fullScubaSet = true;
		Iterable<ItemStack> armor = player.getArmorSlots();

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

		maxAir = fullSnorkelSet ? 600 : 300;
		maxAir = fullDiveSet ? 6000 : maxAir;
		maxAir = fullScubaSet ? 12000 : maxAir;

		if (!player.isEyeInFluidType(ForgeMod.WATER_TYPE.get()) || player.level.getBlockState(new BlockPos(player.getX(), player.getEyeY(), player.getZ())).is(Blocks.BUBBLE_COLUMN)) {
			if (air >= 300 && air < maxAir && event.phase == Phase.END) {
				player.setAirSupply(Math.min(air + 4, maxAir));
			}
		}

		if (air > maxAir) {
			player.setAirSupply(300);
		}

	}

	@SubscribeEvent
	public void onRenderGameOverlayEvent(RenderGuiOverlayEvent.Pre event) {
		if (event.getOverlay() == GuiOverlayManager.findOverlay(GUI_ICONS_LOCATION)) {
			Minecraft mc = Minecraft.getInstance();
			Player player = (Player) mc.getCameraEntity();
			Iterable<ItemStack> armor = player.getArmorSlots();
			boolean fullSnorkelSet = true;
			boolean fullDiveSet = true;
			boolean fullScubaSet = true;

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
				mc.getProfiler().push("air");
				RenderSystem.enableBlend();
				int left = mc.getWindow().getGuiScaledWidth() / 2 + 91;
				int top = mc.getWindow().getGuiScaledHeight() - 49;

				int air = player.getAirSupply();

				if (player.isEyeInFluidType(ForgeMod.WATER_TYPE.get()) || air < 600) {
					int full = Mth.ceil((air - 2) * 10.0D / 300.0D);
					int partial = Mth.ceil(air * 10.0D / 300.0D) - full;

					for (int i = 0; i < full + partial; ++i) {
						int horizontal = i > 9 ? 71 : -9;
						int vertical = i > 9 ? -10 : 0;
						GuiComponent.blit(event.getPoseStack(), left - i * 8 + horizontal, top + vertical, -90, i < full ? 16.0F : 25.0F, 18.0F, 9, 9, 256, 256);
					}
				}

				RenderSystem.disableBlend();
				mc.getProfiler().pop();

			} else if (fullDiveSet) {
				mc.getProfiler().push("air");
				bind(mc, GUI_ICONS_LOCATION);
				RenderSystem.enableBlend();
				int left = mc.getWindow().getGuiScaledWidth() / 2 + 91;
				int top = mc.getWindow().getGuiScaledHeight() - 49;

				int air = player.getAirSupply();

				if (player.isEyeInFluidType(ForgeMod.WATER_TYPE.get()) || air < 6000) {
					float remaining = air / 6000.0F * 81;
					GuiComponent.blit(event.getPoseStack(), left - 81, top, -90, 0.0F, 9.0F, (int) (remaining), 9, 256, 256);
					GuiComponent.blit(event.getPoseStack(), left - 81, top, -90, 0.0F, 0.0F, 81, 9, 256, 256);
				}

				RenderSystem.disableBlend();
				mc.getProfiler().pop();
			} else if (fullScubaSet) {
				mc.getProfiler().push("air");
				bind(mc, GUI_ICONS_LOCATION);
				RenderSystem.enableBlend();
				int left = mc.getWindow().getGuiScaledWidth() / 2 + 91;
				int top = mc.getWindow().getGuiScaledHeight() - 49;

				int air = player.getAirSupply();

				if (player.isEyeInFluidType(ForgeMod.WATER_TYPE.get()) || air < 12000) {
					float remaining = air / 12000.0F * 81;
					GuiComponent.blit(event.getPoseStack(), left - 81, top, -90, 0.0F, 9.0F, (int) (remaining), 9, 256, 256);
					GuiComponent.blit(event.getPoseStack(), left - 81, top, -90, 0.0F, 0.0F, 81, 9, 256, 256);
				}

				RenderSystem.disableBlend();
				mc.getProfiler().pop();
			}
		}
	}

	private void bind(Minecraft mc, ResourceLocation res) {
		mc.getTextureManager().bindForSetup(res);
	}
}