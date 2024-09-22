package com.technologica.listeners.forge;

import com.technologica.world.entity.vehicle.Submersible;

import net.minecraft.client.Minecraft;
import net.minecraft.util.Mth;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.ViewportEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;

@Mod.EventBusSubscriber(bus = EventBusSubscriber.Bus.FORGE, value = Dist.CLIENT)
public class ViewportEventListener {

	@SubscribeEvent
	public static void onComputeCameraAngles(final ViewportEvent.ComputeCameraAngles event) {
		Minecraft mc = Minecraft.getInstance();
		if (mc.player.getControlledVehicle() instanceof Submersible sub) {
			event.setRoll(Mth.lerp(0.01F, sub.rollO, sub.roll));
		}
	}
}
