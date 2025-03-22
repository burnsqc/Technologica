package com.technologica.mixin;

import javax.annotation.Nullable;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import net.minecraft.world.level.block.CampfireBlock;
import net.minecraft.world.level.block.state.BlockState;

@Mixin(CampfireBlock.class)
public abstract class MixinUnlightCampfires {
	@Nullable
	@Inject(method = "getStateForPlacement(Lnet/minecraft/world/item/context/BlockPlaceContext;)Lnet/minecraft/world/level/block/state/BlockState;", at = @At(value = "RETURN"), cancellable = true)
	private void technologica_unlightBonfire(CallbackInfoReturnable<BlockState> cir) {
		cir.setReturnValue(cir.getReturnValue().setValue(CampfireBlock.LIT, false));
	}
}
