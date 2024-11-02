package com.technologica.client.renderer.blockentity;

import java.util.Map;

import com.google.common.collect.Maps;
import com.technologica.client.model.geom.TechnologicaModelLayers;
import com.technologica.util.text.TechnologicaLocation;
import com.technologica.world.level.block.TechnologicaSkullBlock;

import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.SkullBlock;

public class TechnologicaSkullBlockRenderer {
	public static final Map<SkullBlock.Type, ResourceLocation> SKIN_BY_TYPE = Maps.newHashMap();
	public static final Map<SkullBlock.Type, ModelLayerLocation> SKULL_RENDERERS = Maps.newHashMap();

	static {
		register(TechnologicaSkullBlock.Types.BEEPER, new TechnologicaLocation("textures/entity/beeper.png"));
		register(TechnologicaSkullBlock.Types.PEEPER, new TechnologicaLocation("textures/entity/peeper.png"));
		register(TechnologicaSkullBlock.Types.SLEEPER, new TechnologicaLocation("textures/entity/sleeper.png"));
		register(TechnologicaSkullBlock.Types.SWEEPER, new TechnologicaLocation("textures/entity/sweeper.png"));
		register(TechnologicaSkullBlock.Types.WEEPER, new TechnologicaLocation("textures/entity/weeper.png"));
	}

	static {
		register(TechnologicaSkullBlock.Types.BEEPER, TechnologicaModelLayers.BEEPER_HEAD);
		register(TechnologicaSkullBlock.Types.PEEPER, TechnologicaModelLayers.PEEPER_HEAD);
		register(TechnologicaSkullBlock.Types.SLEEPER, TechnologicaModelLayers.SLEEPER_HEAD);
		register(TechnologicaSkullBlock.Types.SWEEPER, TechnologicaModelLayers.SWEEPER_HEAD);
		register(TechnologicaSkullBlock.Types.WEEPER, TechnologicaModelLayers.WEEPER_HEAD);
	}

	private static void register(SkullBlock.Type skull, ResourceLocation texture) {
		SKIN_BY_TYPE.put(skull, texture);
	}

	private static void register(SkullBlock.Type skull, ModelLayerLocation modelLayer) {
		SKULL_RENDERERS.put(skull, modelLayer);
	}
}
