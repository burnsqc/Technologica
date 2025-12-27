package com.technologica.listeners.forge;

import com.technologica.registration.dynamic.TechnologicaBiomes;
import com.technologica.registration.dynamic.TechnologicaDimensions;
import com.technologica.world.entity.vehicle.Aircraft;

import net.minecraft.client.Minecraft;
import net.minecraft.util.Mth;
import net.minecraft.world.level.material.FogType;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.ViewportEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;

@Mod.EventBusSubscriber(bus = EventBusSubscriber.Bus.FORGE, value = Dist.CLIENT)
public class ViewportEventListener {
	private static float oRed;
	private static float oGreen;
	private static float oBlue;

	@SubscribeEvent
	public static void onComputeCameraAngles(final ViewportEvent.ComputeCameraAngles event) {
		Minecraft mc = Minecraft.getInstance();
		if (mc.player.getControlledVehicle() instanceof Aircraft sub) {
			event.setRoll(sub.roll);
		}
	}

	@SubscribeEvent
	public static void onComputeFogColor(final ViewportEvent.ComputeFogColor event) {
		if (event.getCamera().getEntity().level().dimension().equals(TechnologicaDimensions.ABYSS_STEM)) {
			if (event.getCamera().getFluidInCamera() == FogType.WATER) {
				if (event.getCamera().getEntity().level().getBiome(event.getCamera().getBlockPosition()).is(TechnologicaBiomes.NAVAL_GRAVEYARD)) {
					event.setRed(Mth.lerp(0.001F, oRed, event.getRed() * 0.05F));
					event.setGreen(Mth.lerp(0.001F, oGreen, event.getGreen() * 0.05F));
					event.setBlue(Mth.lerp(0.001F, oBlue, event.getBlue() * 0.05F));
				} else if (event.getCamera().getEntity().level().getBiome(event.getCamera().getBlockPosition()).is(TechnologicaBiomes.RUSTING_GROUNDS) || event.getCamera().getEntity().level().getBiome(event.getCamera().getBlockPosition()).is(TechnologicaBiomes.HYDROTHERMAL_CAVERN)) {
					event.setRed(Mth.lerp(0.001F, oRed, event.getRed() * 0.15F));
					event.setGreen(Mth.lerp(0.001F, oGreen, event.getGreen() * 0.15F));
					event.setBlue(Mth.lerp(0.001F, oBlue, event.getBlue() * 0.15F));
				} else {
					event.setRed(Mth.lerp(0.001F, oRed, event.getRed() * 0.5F));
					event.setGreen(Mth.lerp(0.001F, oGreen, event.getGreen() * 0.5F));
					event.setBlue(Mth.lerp(0.001F, oBlue, event.getBlue() * 0.5F));
				}
				oRed = event.getRed();
				oGreen = event.getGreen();
				oBlue = event.getBlue();
			}
		}
	}
}
