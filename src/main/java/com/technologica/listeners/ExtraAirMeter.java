package com.technologica.listeners;

import com.mojang.blaze3d.systems.RenderSystem;

import net.minecraft.block.Blocks;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.AbstractGui;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.tags.FluidTags;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.client.event.RenderGameOverlayEvent.ElementType;
import net.minecraftforge.event.TickEvent.Phase;
import net.minecraftforge.event.TickEvent.PlayerTickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class ExtraAirMeter {

	@SubscribeEvent
	public void onPlayerTickEvent(PlayerTickEvent event) {
		PlayerEntity player = (PlayerEntity) event.player;
		boolean fullSet = true;
		Iterable<ItemStack> armor = player.getArmorInventoryList();

		for (ItemStack piece : armor) {
			if (!piece.getItem().getRegistryName().getPath().contains("snorkel")) {
				fullSet = false;
			}
		}
		
		if (fullSet) {
			if (!player.areEyesInFluid(FluidTags.WATER) || player.world.getBlockState(new BlockPos(player.getPosX(), player.getPosYEye(), player.getPosZ())).matchesBlock(Blocks.BUBBLE_COLUMN)) {
				if (player.getAir() >= 300 && player.getAir() < 600 && event.phase == Phase.END) {
  					player.setAir(Math.min(player.getAir() + 4, 600));
				}
			}
		} else {
			if (player.getAir() > 300) {
				player.setAir(300);
			}
		}
	}

	@SubscribeEvent
	public void onRenderGameOverlayEvent(RenderGameOverlayEvent.Pre event) {
		if (event.getType() == ElementType.AIR) {

			Minecraft mc = Minecraft.getInstance();
			PlayerEntity player = (PlayerEntity) mc.getRenderViewEntity();
			Iterable<ItemStack> armor = player.getArmorInventoryList();
			boolean fullSet = true;

			for (ItemStack piece : armor) {
				if (!piece.getItem().getRegistryName().getPath().contains("snorkel")) {
					fullSet = false;
				}
			}

			event.setCanceled(fullSet);

			if (fullSet) {
				mc.getProfiler().startSection("air");
				RenderSystem.enableBlend();
				int left = mc.getMainWindow().getScaledWidth() / 2 + 91;
				int top = mc.getMainWindow().getScaledHeight() - 49;

				int air = player.getAir();

				if (player.areEyesInFluid(FluidTags.WATER) || air < 600) {
					int full = MathHelper.ceil((double) (air - 2) * 10.0D / 300.0D);
					int partial = MathHelper.ceil((double) air * 10.0D / 300.0D) - full;

					for (int i = 0; i < full + partial; ++i) {
						int horizontal = i > 9 ? 71 : -9;
						int vertical = i > 9 ? -10 : 0;
						AbstractGui.blit(event.getMatrixStack(), left - i * 8 + horizontal, top + vertical, -90, i < full ? 16.0F : 25.0F, 18.0F, 9, 9, 256, 256);
					}
				}

				RenderSystem.disableBlend();
				mc.getProfiler().endSection();
			}
		}
	}
}