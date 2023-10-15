package com.technologica.listeners.modbus;

import static com.technologica.Technologica.LOGGER;

import com.technologica.world.level.block.TechnologicaBlocks;

import net.minecraftforge.client.event.RegisterColorHandlersEvent;

/**
 * <p>
 * This class listens for the RegisterColorHandlersEvent.Block which is fired on the mod-specific event bus.
 * When the event is intercepted, Technologica Block Color Handlers are registered.
 * This is currently the approved way to register Block Color Handlers.
 * </p>
 */

public class RegisterColorHandlers {

	public static void onRegisterColorHandlersBlock(final RegisterColorHandlersEvent.Block event) {
		event.register((p_92621_, p_92622_, p_92623_, p_92624_) -> {
			return p_92622_ != null && p_92623_ != null ? -10867944 : -1;
		}, TechnologicaBlocks.MAPLE_SYRUP_BASIN.get());
		event.register((p_92621_, p_92622_, p_92623_, p_92624_) -> {
			return p_92622_ != null && p_92623_ != null ? -986928 : -1;
		}, TechnologicaBlocks.RUBBER_RESIN_BASIN.get());
		/**
		 * TODO: Determine how to count how many Technologica Block Color Handlers actually got registered and replace the hard-coded value in the logger message.
		 */
		LOGGER.info("BLOCK COLOR HANDLERS REGISTERED: 2 OF 2");
	}
}