package com.technologica.listeners.lootmodifiers;

import javax.annotation.Nonnull;

import com.technologica.Technologica;

import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.common.loot.GlobalLootModifierSerializer;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = Technologica.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class LootModifierListener {

	@SubscribeEvent
	public static void registerModifierSerializers(@Nonnull final RegistryEvent.Register<GlobalLootModifierSerializer<?>> event) {
		event.getRegistry().registerAll(
			new GrassLootModifier.Serializer().setRegistryName(new ResourceLocation(Technologica.MODID, "technologica_seeds_from_grass")),
			new TallGrassLootModifier.Serializer().setRegistryName(new ResourceLocation(Technologica.MODID, "technologica_seeds_from_tall_grass")),
			new LargeFernLootModifier.Serializer().setRegistryName(new ResourceLocation(Technologica.MODID, "technologica_seeds_from_large_fern"))
		);
	}
}