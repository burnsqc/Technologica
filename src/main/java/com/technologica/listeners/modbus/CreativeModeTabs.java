package com.technologica.listeners.modbus;

import com.technologica.Technologica;
import com.technologica.world.item.TechnologicaItems;

import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.event.CreativeModeTabEvent;

public class CreativeModeTabs {
	public static void onRegisterCreativeModeTabs(final CreativeModeTabEvent.Register event) {
		event.registerCreativeModeTab(new ResourceLocation(Technologica.MODID, "flora"), builder -> builder
				.title(Component.translatable("item_group." + Technologica.MODID + ".flora"))
				.icon(() -> new ItemStack(TechnologicaItems.COCONUT_SAPLING_ITEM.get()))
				.withBackgroundLocation(new ResourceLocation(Technologica.MODID, "textures/gui/container/creative_inventory/tab_flora.png"))
				.withLabelColor(0)
				.displayItems((enabledFlags, populator, hasPermissions) -> {
					populator.accept(TechnologicaItems.BARLEY_SEEDS.get());
				})	
		);
		
		event.registerCreativeModeTab(new ResourceLocation(Technologica.MODID, "fauna"), builder -> builder
				.title(Component.translatable("item_group." + Technologica.MODID + ".fauna"))
				.icon(() -> new ItemStack(TechnologicaItems.PIRANHA_BUCKET.get()))
				.withBackgroundLocation(new ResourceLocation(Technologica.MODID, "textures/gui/container/creative_inventory/tab_fauna.png"))
				.withLabelColor(0)
				.displayItems((enabledFlags, populator, hasPermissions) -> {
					populator.accept(TechnologicaItems.ALLIGATOR_SPAWN_EGG.get());
				})	
		);
		
		event.registerCreativeModeTab(new ResourceLocation(Technologica.MODID, "mineral"), builder -> builder
				.title(Component.translatable("item_group." + Technologica.MODID + ".mineral"))
				.icon(() -> new ItemStack(TechnologicaItems.GERMANIUM_CHUNK.get()))
				.withBackgroundLocation(new ResourceLocation(Technologica.MODID, "textures/gui/container/creative_inventory/tab_mineral.png"))
				.withLabelColor(0)
				.displayItems((enabledFlags, populator, hasPermissions) -> {
					populator.accept(TechnologicaItems.SALT_ITEM.get());
				})	
		);
		
		event.registerCreativeModeTab(new ResourceLocation(Technologica.MODID, "food"), builder -> builder
				.title(Component.translatable("item_group." + Technologica.MODID + ".food"))
				.icon(() -> new ItemStack(TechnologicaItems.BANANA.get()))
				.withBackgroundLocation(new ResourceLocation(Technologica.MODID, "textures/gui/container/creative_inventory/tab_food.png"))
				.withLabelColor(0)
				.displayItems((enabledFlags, populator, hasPermissions) -> {
					populator.accept(TechnologicaItems.BARLEY.get());
				})	
		);
		
		event.registerCreativeModeTab(new ResourceLocation(Technologica.MODID, "construction"), builder -> builder
				.title(Component.translatable("item_group." + Technologica.MODID + ".construction"))
				.icon(() -> new ItemStack(TechnologicaItems.GLUE_BOTTLE.get()))
				.withBackgroundLocation(new ResourceLocation(Technologica.MODID, "textures/gui/container/creative_inventory/tab_construction.png"))
				.withLabelColor(0)
				.displayItems((enabledFlags, populator, hasPermissions) -> {
					populator.accept(TechnologicaItems.APRICOT_LOG_ITEM.get());
				})	
		);
		
		event.registerCreativeModeTab(new ResourceLocation(Technologica.MODID, "machinery"), builder -> builder
				.title(Component.translatable("item_group." + Technologica.MODID + ".machinery"))
				.icon(() -> new ItemStack(TechnologicaItems.LARGE_PULLEY_ITEM.get()))
				.withBackgroundLocation(new ResourceLocation(Technologica.MODID, "textures/gui/container/creative_inventory/tab_machinery.png"))
				.withLabelColor(0)
				.displayItems((enabledFlags, populator, hasPermissions) -> {
					populator.accept(TechnologicaItems.LINE_SHAFT_HANGER_ITEM.get());
				})	
		);
		
		event.registerCreativeModeTab(new ResourceLocation(Technologica.MODID, "decorative"), builder -> builder
				.title(Component.translatable("item_group." + Technologica.MODID + ".decorative"))
				.icon(() -> new ItemStack(TechnologicaItems.DISPLAY_CASE_ITEM.get()))
				.withBackgroundLocation(new ResourceLocation(Technologica.MODID, "textures/gui/container/creative_inventory/tab_decorative.png"))
				.withLabelColor(0)
				.displayItems((enabledFlags, populator, hasPermissions) -> {
					populator.accept(TechnologicaItems.DISPLAY_CASE_ITEM.get());
				})	
		);
		
		event.registerCreativeModeTab(new ResourceLocation(Technologica.MODID, "armory"), builder -> builder
				.title(Component.translatable("item_group." + Technologica.MODID + ".armory"))
				.icon(() -> new ItemStack(TechnologicaItems.NAVAL_MINE.get()))
				.withBackgroundLocation(new ResourceLocation(Technologica.MODID, "textures/gui/container/creative_inventory/tab_armory.png"))
				.withLabelColor(0)
				.displayItems((enabledFlags, populator, hasPermissions) -> {
					populator.accept(TechnologicaItems.PRIMITIVE_DAGGER.get());
				})	
		);
		
		event.registerCreativeModeTab(new ResourceLocation(Technologica.MODID, "cryptica"), builder -> builder
				.title(Component.translatable("item_group." + Technologica.MODID + ".cryptica"))
				.icon(() -> new ItemStack(TechnologicaItems.ANCIENT_AMBROSIA_SAPLING_ITEM.get()))
				.withBackgroundLocation(new ResourceLocation(Technologica.MODID, "textures/gui/container/creative_inventory/tab_cryptica.png"))
				.withLabelColor(0)
				.displayItems((enabledFlags, populator, hasPermissions) -> {
					populator.accept(TechnologicaItems.PERSISTENT_GLARE.get());
				})	
		);
	}
}