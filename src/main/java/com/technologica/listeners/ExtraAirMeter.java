package com.technologica.listeners;

import com.mojang.blaze3d.systems.RenderSystem;
import com.technologica.Technologica;

import net.minecraft.block.Blocks;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.AbstractGui;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.tags.FluidTags;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.client.event.RenderGameOverlayEvent.ElementType;
import net.minecraftforge.event.TickEvent.Phase;
import net.minecraftforge.event.TickEvent.PlayerTickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class ExtraAirMeter {
	public static final ResourceLocation GUI_ICONS_LOCATION = new ResourceLocation(Technologica.MODID,"textures/gui/technologica_icons.png");

	@SubscribeEvent
	public void onPlayerTickEvent(PlayerTickEvent event) {
		PlayerEntity player = event.player;
		int air = player.getAirSupply();
		int maxAir = 300;
		boolean fullSnorkelSet = true;
		boolean fullDiveSet = true;
		boolean fullScubaSet = true;
		Iterable<ItemStack> armor = player.getArmorSlots();

		for (ItemStack piece : armor) {
			if (!piece.getItem().getRegistryName().getPath().contains("snorkel")) {
				fullSnorkelSet = false;
			}
			if (!piece.getItem().getRegistryName().getPath().contains("dive")) {
				fullDiveSet = false;
			}
			if (!piece.getItem().getRegistryName().getPath().contains("scuba")) {
				fullScubaSet = false;
			}
		}
		
		maxAir = fullSnorkelSet ? 600 : 300;
		maxAir = fullDiveSet ? 6000 : maxAir;
		maxAir = fullScubaSet ? 12000 : maxAir;
		
		
		if (!player.isEyeInFluid(FluidTags.WATER) || player.level.getBlockState(new BlockPos(player.getX(), player.getEyeY(), player.getZ())).is(Blocks.BUBBLE_COLUMN)) {
			if (air >= 300 && air < maxAir && event.phase == Phase.END) {
				player.setAirSupply(Math.min(air + 4, maxAir));
			}
		}
	
		if (air > maxAir) {
			player.setAirSupply(300);
		}
		
	}

	@SubscribeEvent
	public void onRenderGameOverlayEvent(RenderGameOverlayEvent.Pre event) {
		if (event.getType() == ElementType.AIR) {
			Minecraft mc = Minecraft.getInstance();
			PlayerEntity player = (PlayerEntity) mc.getCameraEntity();
			Iterable<ItemStack> armor = player.getArmorSlots();
			boolean fullSnorkelSet = true;
			boolean fullDiveSet = true;
			boolean fullScubaSet = true;

			for (ItemStack piece : armor) {
				if (!piece.getItem().getRegistryName().getPath().contains("snorkel")) {
					fullSnorkelSet = false;
				}
				if (!piece.getItem().getRegistryName().getPath().contains("dive")) {
					fullDiveSet = false;
				}
				if (!piece.getItem().getRegistryName().getPath().contains("scuba")) {
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

				if (player.isEyeInFluid(FluidTags.WATER) || air < 600) {
					int full = MathHelper.ceil((double) (air - 2) * 10.0D / 300.0D);
					int partial = MathHelper.ceil((double) air * 10.0D / 300.0D) - full;

					for (int i = 0; i < full + partial; ++i) {
						int horizontal = i > 9 ? 71 : -9;
						int vertical = i > 9 ? -10 : 0;
						AbstractGui.blit(event.getMatrixStack(), left - i * 8 + horizontal, top + vertical, -90, i < full ? 16.0F : 25.0F, 18.0F, 9, 9, 256, 256);
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

				if (player.isEyeInFluid(FluidTags.WATER) || air < 6000) {
					float remaining = air/6000.0F*81;
					AbstractGui.blit(event.getMatrixStack(), left - 81, top, -90, 0.0F, 9.0F, (int) (remaining), 9, 256, 256);
					AbstractGui.blit(event.getMatrixStack(), left - 81, top, -90, 0.0F, 0.0F, 81, 9, 256, 256);
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

				if (player.isEyeInFluid(FluidTags.WATER) || air < 12000) {
					float remaining = air/12000.0F*81;
					AbstractGui.blit(event.getMatrixStack(), left - 81, top, -90, 0.0F, 9.0F, (int) (remaining), 9, 256, 256);
					AbstractGui.blit(event.getMatrixStack(), left - 81, top, -90, 0.0F, 0.0F, 81, 9, 256, 256);
				}

				RenderSystem.disableBlend();
				mc.getProfiler().pop();
			}
		}
	}
	
	private void bind(Minecraft mc, ResourceLocation res) {
		mc.getTextureManager().bind(res);
	}
}