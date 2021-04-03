package com.technologica.setup;

import com.technologica.MainMod;

import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.RenderTypeLookup;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.ColorHandlerEvent;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.event.RenderTooltipEvent;
import net.minecraftforge.client.event.TextureStitchEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

@Mod.EventBusSubscriber(modid = MainMod.MODID, value = Dist.CLIENT, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ClientSetup {

	public static void init(final FMLClientSetupEvent event) {
		event.enqueueWork(() -> {
			RenderTypeLookup.setRenderLayer(Registration.BLUEBERRY_CROP.get(), RenderType.getCutoutMipped());
			RenderTypeLookup.setRenderLayer(Registration.BANANA_SAPLING.get(), RenderType.getCutoutMipped());
			RenderTypeLookup.setRenderLayer(Registration.CHERRY_SAPLING.get(), RenderType.getCutoutMipped());
			RenderTypeLookup.setRenderLayer(Registration.COCONUT_SAPLING.get(), RenderType.getCutoutMipped());
			RenderTypeLookup.setRenderLayer(Registration.LEMON_SAPLING.get(), RenderType.getCutoutMipped());
			RenderTypeLookup.setRenderLayer(Registration.LIME_SAPLING.get(), RenderType.getCutoutMipped());
			RenderTypeLookup.setRenderLayer(Registration.ORANGE_SAPLING.get(), RenderType.getCutoutMipped());
			RenderTypeLookup.setRenderLayer(Registration.PEACH_SAPLING.get(), RenderType.getCutoutMipped());
			RenderTypeLookup.setRenderLayer(Registration.PEAR_SAPLING.get(), RenderType.getCutoutMipped());
		});
	}

	@SubscribeEvent
	public static void onItemColor(ColorHandlerEvent.Item event) {
	}

	@SubscribeEvent
	public static void onModelRegistryEvent(ModelRegistryEvent event) {
	}

	@SubscribeEvent
	public static void onTextureStitch(TextureStitchEvent.Pre event) {
	}

	@SubscribeEvent
	public void onTooltipPre(RenderTooltipEvent.Pre event) {
	}

}