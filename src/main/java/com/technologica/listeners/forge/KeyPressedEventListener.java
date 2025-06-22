package com.technologica.listeners.forge;

import com.mojang.blaze3d.platform.InputConstants;
import com.mojang.blaze3d.vertex.PoseStack;

import net.minecraft.client.Minecraft;
import net.minecraft.client.Screenshot;
import net.minecraft.network.chat.Component;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.InputEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;

@Mod.EventBusSubscriber(bus = EventBusSubscriber.Bus.FORGE, value = Dist.CLIENT)
public class KeyPressedEventListener {
	private static int resolution = 1024;

	@SubscribeEvent
	public static void onMovementInputUpdateEvent(final InputEvent.Key event) {
		if (event.getKey() == InputConstants.KEY_F4 && event.getAction() == InputConstants.PRESS) {
			Minecraft minecraft = Minecraft.getInstance();
			int widthOriginal = minecraft.getWindow().getWidth();
			int heightOriginal = minecraft.getWindow().getHeight();
			float xRotOriginal = minecraft.player.getXRot();
			float yRotOriginal = minecraft.player.getYRot();
			float xRotOOriginal = minecraft.player.xRotO;
			float yRotOOriginal = minecraft.player.yRotO;

			try {
				minecraft.getWindow().setWidth(resolution);
				minecraft.getWindow().setHeight(resolution);
				minecraft.getMainRenderTarget().resize(resolution, resolution, Minecraft.ON_OSX);
				if (minecraft.gameRenderer.currentEffect() != null) {
					minecraft.gameRenderer.currentEffect().resize(resolution, resolution);
				}

				minecraft.gameRenderer.setPanoramicMode(true);
				minecraft.gameRenderer.setRenderBlockOutline(false);
				minecraft.levelRenderer.graphicsChanged();


				for (int k = 0; k < 6; ++k) {
					switch (k) {
					case 0:
						minecraft.player.setYRot(0.0F);
						minecraft.player.setXRot(0.0F);
						break;
					case 1:
						minecraft.player.setYRot(90.0F);
						minecraft.player.setXRot(0.0F);
						break;
					case 2:
						minecraft.player.setYRot(180.0F);
						minecraft.player.setXRot(0.0F);
						break;
					case 3:
						minecraft.player.setYRot(270.0F);
						minecraft.player.setXRot(0.0F);
						break;
					case 4:
						minecraft.player.setYRot(0.0F);
						minecraft.player.setXRot(-90.0F);
						break;
					case 5:
					default:
						minecraft.player.setYRot(0.0F);
						minecraft.player.setXRot(90.0F);
					}

					minecraft.player.yRotO = minecraft.player.getYRot();
					minecraft.player.xRotO = minecraft.player.getXRot();

					minecraft.getMainRenderTarget().bindWrite(true);
					minecraft.gameRenderer.renderLevel(1.0F, 0L, new PoseStack());
					if (minecraft.gameRenderer.currentEffect() != null) {
						minecraft.gameRenderer.currentEffect().process(0);
					}

					try {
						Thread.sleep(10L);
					} catch (InterruptedException interruptedexception) {
					}

					Screenshot.grab(minecraft.gameDirectory, "panorama_" + k + ".png", minecraft.getMainRenderTarget(), (component) -> {
					});
				}
			} catch (Exception exception) {

			} finally {
				minecraft.player.setXRot(xRotOriginal);
				minecraft.player.setYRot(yRotOriginal);
				minecraft.player.xRotO = xRotOOriginal;
				minecraft.player.yRotO = yRotOOriginal;
				minecraft.gameRenderer.setRenderBlockOutline(true);


				minecraft.getMainRenderTarget().resize(widthOriginal, heightOriginal, Minecraft.ON_OSX);
				minecraft.getWindow().setWidth(widthOriginal);
				minecraft.getWindow().setHeight(heightOriginal);
				if (minecraft.gameRenderer.currentEffect() != null) {
					minecraft.gameRenderer.currentEffect().resize(widthOriginal, heightOriginal);
				}
				
				minecraft.gameRenderer.setPanoramicMode(false);
				minecraft.levelRenderer.graphicsChanged();
				minecraft.getMainRenderTarget().bindWrite(true);
				minecraft.execute(() -> {
					minecraft.gui.getChat().addMessage(Component.literal("Panorama created"));
				});
			}
		}
	}
}
