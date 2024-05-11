package com.technologica.listeners.forgebus;

import com.technologica.world.entity.vehicle.Submersible;

import net.minecraft.client.Minecraft;
import net.minecraft.util.Mth;
import net.minecraftforge.client.event.ViewportEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class ViewportEventListener {

	@SubscribeEvent
	public void onComputeCameraAngles(final ViewportEvent.ComputeCameraAngles event) {
		Minecraft mc = Minecraft.getInstance();
		if (mc.player.getControlledVehicle() instanceof Submersible sub) {
			event.setRoll(Mth.lerp(0.01F, sub.rollO, sub.roll));
		}
	}
}
