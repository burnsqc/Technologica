package com.technologica.listeners.mod.client;

import com.technologica.registration.deferred.TechnologicaBlocks;

import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.RegisterColorHandlersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;

@Mod.EventBusSubscriber(bus = EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public final class RegisterColorHandlersEventListener {

	@SubscribeEvent
	public static final void onRegisterColorHandlersEvent$Block(final RegisterColorHandlersEvent.Block event) {
		event.register((blockState, blockAndTintGetter, blockPos, tintIndex) -> blockAndTintGetter != null && blockPos != null ? -10867944 : -1, TechnologicaBlocks.MAPLE_SYRUP_BASIN.get());
		event.register((blockState, blockAndTintGetter, blockPos, tintIndex) -> blockAndTintGetter != null && blockPos != null ? -986928 : -1, TechnologicaBlocks.RUBBER_RESIN_BASIN.get());
	}
}
