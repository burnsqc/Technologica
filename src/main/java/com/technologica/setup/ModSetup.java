package com.technologica.setup;

import com.technologica.MainMod;

import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraftforge.event.RegisterCommandsEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;

@Mod.EventBusSubscriber(modid = MainMod.MODID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class ModSetup {

	public static final ItemGroup TECHNOLOGICA_FOOD = new ItemGroup("technologica_food") {
		@Override
		public ItemStack createIcon() {
			return new ItemStack(Registration.COCONUT.get());
		}
	};

	public static final ItemGroup TECHNOLOGICA_FLORA = new ItemGroup("technologica_flora") {
		@Override
		public ItemStack createIcon() {
			return new ItemStack(Registration.CHERRY_LOG.get());
		}
	};

	public static final ItemGroup TECHNOLOGICA_MINERAL = new ItemGroup("technologica_mineral") {
		@Override
		public ItemStack createIcon() {
			return new ItemStack(Registration.LITHIUM_INGOT.get());
		}
	};

	public static void init(final FMLCommonSetupEvent event) {
	}

	@SubscribeEvent
	public static void serverLoad(RegisterCommandsEvent event) {
	}
}
