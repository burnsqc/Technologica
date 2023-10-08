package com.technologica.listeners.modbus;

import com.technologica.world.level.block.TechnologicaBlocks;

import net.minecraftforge.client.event.RegisterColorHandlersEvent;

public class RegisterColorHandlers {

	public static void onRegisterColorHandlers(final RegisterColorHandlersEvent.Block event) {
		event.register((p_92621_, p_92622_, p_92623_, p_92624_) -> {
			return p_92622_ != null && p_92623_ != null ? -10867944 : -1;
		}, TechnologicaBlocks.MAPLE_SYRUP_BASIN.get());
		event.register((p_92621_, p_92622_, p_92623_, p_92624_) -> {
			return p_92622_ != null && p_92623_ != null ? -986928 : -1;
		}, TechnologicaBlocks.RUBBER_RESIN_BASIN.get());
	}
}