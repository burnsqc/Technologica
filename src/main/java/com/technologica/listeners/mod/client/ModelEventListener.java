package com.technologica.listeners.mod.client;

import com.technologica.util.text.TechnologicaLocation;

import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.ModelEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;

@Mod.EventBusSubscriber(bus = EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public final class ModelEventListener {

	@SubscribeEvent
	public static final void onModelEvent$RegisterAdditional(final ModelEvent.RegisterAdditional event) {
		event.register(new TechnologicaLocation("item/technetium_ingot_base"));
		event.register(new TechnologicaLocation("item/promethium_ingot_base"));
		event.register(new TechnologicaLocation("item/polonium_ingot_base"));
		event.register(new TechnologicaLocation("item/francium_ingot_base"));
		event.register(new TechnologicaLocation("item/radium_ingot_base"));
		event.register(new TechnologicaLocation("item/actinium_ingot_base"));
		event.register(new TechnologicaLocation("item/thorium_ingot_base"));
		event.register(new TechnologicaLocation("item/protactinium_ingot_base"));
		event.register(new TechnologicaLocation("item/uranium_ingot_base"));
		event.register(new TechnologicaLocation("item/neptunium_ingot_base"));
		event.register(new TechnologicaLocation("item/plutonium_ingot_base"));
		event.register(new TechnologicaLocation("item/americium_ingot_base"));
		event.register(new TechnologicaLocation("item/curium_ingot_base"));
		event.register(new TechnologicaLocation("item/berkelium_ingot_base"));
		event.register(new TechnologicaLocation("item/californium_ingot_base"));
		event.register(new TechnologicaLocation("item/einsteinium_ingot_base"));
		event.register(new TechnologicaLocation("item/fermium_ingot_base"));
		event.register(new TechnologicaLocation("item/mendelevium_ingot_base"));
		event.register(new TechnologicaLocation("item/nobelium_ingot_base"));
		event.register(new TechnologicaLocation("item/lawrencium_ingot_base"));
		event.register(new TechnologicaLocation("item/rutherfordium_ingot_base"));
		event.register(new TechnologicaLocation("item/dubnium_ingot_base"));
		event.register(new TechnologicaLocation("item/seaborgium_ingot_base"));
		event.register(new TechnologicaLocation("item/bohrium_ingot_base"));
		event.register(new TechnologicaLocation("item/hassium_ingot_base"));
		event.register(new TechnologicaLocation("item/meitnerium_ingot_base"));
		event.register(new TechnologicaLocation("item/darmstadtium_ingot_base"));
		event.register(new TechnologicaLocation("item/roentgenium_ingot_base"));
		event.register(new TechnologicaLocation("item/copernicium_ingot_base"));
		event.register(new TechnologicaLocation("item/nihonium_ingot_base"));
		event.register(new TechnologicaLocation("item/flevorium_ingot_base"));
		event.register(new TechnologicaLocation("item/moscovium_ingot_base"));
		event.register(new TechnologicaLocation("item/livermorium_ingot_base"));
		event.register(new TechnologicaLocation("item/tennessine_ingot_base"));
		event.register(new TechnologicaLocation("item/oganesson_ingot_base"));
		event.register(new TechnologicaLocation("item/astatine_chunk_base"));
		event.register(new TechnologicaLocation("item/excitation_of_strike_base"));
		event.register(new TechnologicaLocation("item/ignition_of_combustion_base"));
		event.register(new TechnologicaLocation("item/submersion_of_suppression_base"));
	}
}
