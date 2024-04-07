package com.technologica.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import com.technologica.world.entity.vehicle.Submersible;

import net.minecraft.client.Minecraft;
import net.minecraft.client.MouseHandler;

@Mixin(MouseHandler.class)
public abstract class MixinMouseHandler {
	@Shadow
	double accumulatedDX;
	@Shadow
	double accumulatedDY;

	@Inject(method = "turnPlayer()V", at = @At("HEAD"))
	private void technologica_accountForRoll(CallbackInfo ci) {
		Minecraft mc = Minecraft.getInstance();
		if (mc.player != null) {
			if (mc.player.getControlledVehicle() instanceof Submersible sub) {
				double xorig = accumulatedDX;
				double yorig = accumulatedDY;
				double angle = sub.roll * Math.PI / 180;
				accumulatedDX = xorig * Math.cos(angle) - yorig * Math.sin(angle);
				accumulatedDY = yorig * Math.cos(angle) + xorig * Math.sin(angle);
			}
		}
	}
}
