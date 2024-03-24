package com.technologica.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import com.technologica.registration.deferred.TechnologicaMobEffects;

import net.minecraft.client.Minecraft;
import net.minecraft.util.FastColor;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.Entity;

@Mixin(Entity.class)
public abstract class MixinLifesightTeamColor {
	@Inject(method = "getTeamColor()I", at = @At(value = "RETURN"), cancellable = true)
	private void technologica_setColorPulse(CallbackInfoReturnable<Integer> cir) {
		if (Minecraft.getInstance().player.hasEffect(TechnologicaMobEffects.LIFESIGHT.get())) {
			int pulse = (int) (255 * (Mth.sin((((Entity) (Object) this).tickCount + Minecraft.getInstance().getPartialTick()) / 5) + 1) / 2);
			cir.setReturnValue(FastColor.ARGB32.color(255, pulse, 0, pulse));
		}
	}
}
