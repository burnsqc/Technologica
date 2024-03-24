package com.technologica.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import com.technologica.registration.deferred.TechnologicaMobEffects;

import net.minecraft.client.Minecraft;

@Mixin(Minecraft.class)
public abstract class MixinLifesightOrEntityGlow {
	@Inject(method = "shouldEntityAppearGlowing(Lnet/minecraft/world/entity/Entity;)Z", at = @At("RETURN"), cancellable = true)
	private void technologica_glowOrLifesight(CallbackInfoReturnable<Boolean> cir) {
		cir.setReturnValue(cir.getReturnValue() || ((Minecraft) (Object) this).player.hasEffect(TechnologicaMobEffects.LIFESIGHT.get()));
	}
}
