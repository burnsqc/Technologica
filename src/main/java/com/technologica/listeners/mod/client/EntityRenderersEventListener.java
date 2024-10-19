package com.technologica.listeners.mod.client;

import com.technologica.client.model.geom.TechnologicaLayerDefinitions;
import com.technologica.client.renderer.blockentity.TechnologicaBlockEntityRenderers;
import com.technologica.client.renderer.entity.TechnologicaEntityRenderers;

import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;

@Mod.EventBusSubscriber(bus = EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public final class EntityRenderersEventListener {

	@SubscribeEvent
	public static final void onEntityRenderersEvent$RegisterLayerDefinitions(final EntityRenderersEvent.RegisterLayerDefinitions event) {
		TechnologicaLayerDefinitions.createRoots().forEach((k, v) -> event.registerLayerDefinition(k, () -> v));
	}

	@SubscribeEvent
	public static final void onEntityRenderersEvent$RegisterRenderers(final EntityRenderersEvent.RegisterRenderers event) {
		TechnologicaEntityRenderers.PROVIDERS.forEach((k, v) -> event.registerEntityRenderer(k, v));
		TechnologicaBlockEntityRenderers.PROVIDERS.forEach((k, v) -> event.registerBlockEntityRenderer(k, v));
	}
}
