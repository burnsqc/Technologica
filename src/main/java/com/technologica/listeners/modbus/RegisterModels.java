package com.technologica.listeners.modbus;

import static com.technologica.Technologica.LOGGER;

import com.technologica.Technologica;

import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.client.event.ModelEvent;

public class RegisterModels {

	public static void onRegisterModelsEvent(ModelEvent.RegisterAdditional event) {
		event.register(new ResourceLocation(Technologica.MODID, "item/technetium_ingot_base"));
		event.register(new ResourceLocation(Technologica.MODID, "item/promethium_ingot_base"));
		event.register(new ResourceLocation(Technologica.MODID, "item/polonium_ingot_base"));
		event.register(new ResourceLocation(Technologica.MODID, "item/francium_ingot_base"));
		event.register(new ResourceLocation(Technologica.MODID, "item/radium_ingot_base"));
		event.register(new ResourceLocation(Technologica.MODID, "item/actinium_ingot_base"));
		event.register(new ResourceLocation(Technologica.MODID, "item/thorium_ingot_base"));
		event.register(new ResourceLocation(Technologica.MODID, "item/protactinium_ingot_base"));
		event.register(new ResourceLocation(Technologica.MODID, "item/uranium_ingot_base"));
		event.register(new ResourceLocation(Technologica.MODID, "item/neptunium_ingot_base"));
		event.register(new ResourceLocation(Technologica.MODID, "item/plutonium_ingot_base"));
		event.register(new ResourceLocation(Technologica.MODID, "item/americium_ingot_base"));
		event.register(new ResourceLocation(Technologica.MODID, "item/curium_ingot_base"));
		event.register(new ResourceLocation(Technologica.MODID, "item/berkelium_ingot_base"));
		event.register(new ResourceLocation(Technologica.MODID, "item/californium_ingot_base"));
		event.register(new ResourceLocation(Technologica.MODID, "item/einsteinium_ingot_base"));
		event.register(new ResourceLocation(Technologica.MODID, "item/fermium_ingot_base"));
		event.register(new ResourceLocation(Technologica.MODID, "item/mendelevium_ingot_base"));
		event.register(new ResourceLocation(Technologica.MODID, "item/nobelium_ingot_base"));
		event.register(new ResourceLocation(Technologica.MODID, "item/lawrencium_ingot_base"));
		event.register(new ResourceLocation(Technologica.MODID, "item/rutherfordium_ingot_base"));
		event.register(new ResourceLocation(Technologica.MODID, "item/dubnium_ingot_base"));
		event.register(new ResourceLocation(Technologica.MODID, "item/seaborgium_ingot_base"));
		event.register(new ResourceLocation(Technologica.MODID, "item/bohrium_ingot_base"));
		event.register(new ResourceLocation(Technologica.MODID, "item/hassium_ingot_base"));
		event.register(new ResourceLocation(Technologica.MODID, "item/meitnerium_ingot_base"));
		event.register(new ResourceLocation(Technologica.MODID, "item/darmstadtium_ingot_base"));
		event.register(new ResourceLocation(Technologica.MODID, "item/roentgenium_ingot_base"));
		event.register(new ResourceLocation(Technologica.MODID, "item/copernicium_ingot_base"));
		event.register(new ResourceLocation(Technologica.MODID, "item/nihonium_ingot_base"));
		event.register(new ResourceLocation(Technologica.MODID, "item/flevorium_ingot_base"));
		event.register(new ResourceLocation(Technologica.MODID, "item/moscovium_ingot_base"));
		event.register(new ResourceLocation(Technologica.MODID, "item/livermorium_ingot_base"));
		event.register(new ResourceLocation(Technologica.MODID, "item/tennessine_ingot_base"));
		event.register(new ResourceLocation(Technologica.MODID, "item/oganesson_ingot_base"));
		event.register(new ResourceLocation(Technologica.MODID, "item/astatine_chunk_base"));
		LOGGER.info("MODELS REGISTERED: 1 OF 1");
	}
}