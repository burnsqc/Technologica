package com.technologica.setup.client;

import com.technologica.registration.deferred.TechnologicaBlocks;

import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.RegisterColorHandlersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;

@Mod.EventBusSubscriber(bus = EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public final class RegisterColorHandlersEventListener {

	@SubscribeEvent
	public static void onRegisterColorHandlersBlock(final RegisterColorHandlersEvent.Block event) {
		event.register((p_92621_, p_92622_, p_92623_, p_92624_) -> {
			return p_92622_ != null && p_92623_ != null ? -10867944 : -1;
		}, TechnologicaBlocks.MAPLE_SYRUP_BASIN.get());
		event.register((p_92621_, p_92622_, p_92623_, p_92624_) -> {
			return p_92622_ != null && p_92623_ != null ? -986928 : -1;
		}, TechnologicaBlocks.RUBBER_RESIN_BASIN.get());
	}
}
