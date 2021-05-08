package com.technologica.setup;

import com.technologica.client.renderer.DisplayCaseRenderer;
import com.technologica.client.renderer.FruitRenderer;
import com.technologica.client.renderer.PotionRenderer;
import com.technologica.client.renderer.entity.DuckRenderer;
import com.technologica.client.renderer.entity.GrizzlyBearRenderer;
import com.technologica.client.renderer.entity.SharkRenderer;
import com.technologica.client.renderer.entity.ZebraRenderer;
import com.technologica.fluid.FluidRegistration;

import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.RenderTypeLookup;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

public class ClientSetup {

	public static void init(final FMLClientSetupEvent event) {
		RenderingRegistry.registerEntityRenderingHandler(Registration.DUCK.get(), DuckRenderer::new);
		RenderingRegistry.registerEntityRenderingHandler(Registration.GRIZZLY_BEAR.get(), GrizzlyBearRenderer::new);
		RenderingRegistry.registerEntityRenderingHandler(Registration.SHARK.get(), SharkRenderer::new);
		RenderingRegistry.registerEntityRenderingHandler(Registration.ZEBRA.get(), ZebraRenderer::new);
		
		event.enqueueWork(() -> {
			RenderTypeLookup.setRenderLayer(Registration.BANANA_SAPLING.get(), RenderType.getCutoutMipped());
			RenderTypeLookup.setRenderLayer(Registration.CHERRY_SAPLING.get(), RenderType.getCutoutMipped());
			RenderTypeLookup.setRenderLayer(Registration.COCONUT_SAPLING.get(), RenderType.getCutoutMipped());
			RenderTypeLookup.setRenderLayer(Registration.KIWI_SAPLING.get(), RenderType.getCutoutMipped());
			RenderTypeLookup.setRenderLayer(Registration.LEMON_SAPLING.get(), RenderType.getCutoutMipped());
			RenderTypeLookup.setRenderLayer(Registration.LIME_SAPLING.get(), RenderType.getCutoutMipped());
			RenderTypeLookup.setRenderLayer(Registration.ORANGE_SAPLING.get(), RenderType.getCutoutMipped());
			RenderTypeLookup.setRenderLayer(Registration.PEACH_SAPLING.get(), RenderType.getCutoutMipped());
			RenderTypeLookup.setRenderLayer(Registration.PEAR_SAPLING.get(), RenderType.getCutoutMipped());
			
			RenderTypeLookup.setRenderLayer(Registration.ANCIENT_AMBROSIA_SAPLING.get(), RenderType.getCutoutMipped());
			RenderTypeLookup.setRenderLayer(Registration.BENEVOLENT_APOTHECARY_SAPLING.get(), RenderType.getCutoutMipped());
			
			RenderTypeLookup.setRenderLayer(Registration.POTTED_BANANA_SAPLING.get(), RenderType.getCutoutMipped());
			RenderTypeLookup.setRenderLayer(Registration.POTTED_CHERRY_SAPLING.get(), RenderType.getCutoutMipped());
			RenderTypeLookup.setRenderLayer(Registration.POTTED_COCONUT_SAPLING.get(), RenderType.getCutoutMipped());
			RenderTypeLookup.setRenderLayer(Registration.POTTED_KIWI_SAPLING.get(), RenderType.getCutoutMipped());
			RenderTypeLookup.setRenderLayer(Registration.POTTED_LEMON_SAPLING.get(), RenderType.getCutoutMipped());
			RenderTypeLookup.setRenderLayer(Registration.POTTED_LIME_SAPLING.get(), RenderType.getCutoutMipped());
			RenderTypeLookup.setRenderLayer(Registration.POTTED_ORANGE_SAPLING.get(), RenderType.getCutoutMipped());
			RenderTypeLookup.setRenderLayer(Registration.POTTED_PEACH_SAPLING.get(), RenderType.getCutoutMipped());
			RenderTypeLookup.setRenderLayer(Registration.POTTED_PEAR_SAPLING.get(), RenderType.getCutoutMipped());
			
			RenderTypeLookup.setRenderLayer(Registration.BLUEBERRY_CROP.get(), RenderType.getCutoutMipped());
			RenderTypeLookup.setRenderLayer(Registration.GRAPE_CROP.get(), RenderType.getCutoutMipped());
			RenderTypeLookup.setRenderLayer(Registration.STRAWBERRY_CROP.get(), RenderType.getCutoutMipped());
			
			RenderTypeLookup.setRenderLayer(Registration.DISPLAY_CASE.get(), RenderType.getTranslucent());
			RenderTypeLookup.setRenderLayer(Registration.AQUAMARINE_CRYSTAL.get(), RenderType.getTranslucent());
			RenderTypeLookup.setRenderLayer(Registration.FLUORITE_CRYSTAL.get(), RenderType.getTranslucent());
			RenderTypeLookup.setRenderLayer(Registration.ULEXITE_CRYSTAL.get(), RenderType.getTranslucent());
			
			RenderTypeLookup.setRenderLayer(Registration.DOLOMITE_CRYSTAL.get(), RenderType.getTranslucent());
			
			RenderTypeLookup.setRenderLayer(FluidRegistration.BRINE_SOURCE.get(), RenderType.getTranslucent());
			RenderTypeLookup.setRenderLayer(FluidRegistration.BRINE_FLOWING.get(), RenderType.getTranslucent());
			
			ClientRegistry.bindTileEntityRenderer(Registration.FRUIT_CROP.get(), FruitRenderer::new);
			ClientRegistry.bindTileEntityRenderer(Registration.POTION_CROP.get(), PotionRenderer::new);
			ClientRegistry.bindTileEntityRenderer(Registration.DISPLAY_TILE.get(), DisplayCaseRenderer::new);
		});
	}
}