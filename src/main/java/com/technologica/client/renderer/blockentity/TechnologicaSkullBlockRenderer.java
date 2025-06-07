package com.technologica.client.renderer.blockentity;

import java.util.HashMap;

import com.technologica.client.model.geom.TechnologicaModelLayers;
import com.technologica.util.text.TechnologicaLocation;
import com.technologica.world.level.block.TechnologicaSkullBlock;

import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.SkullBlock;

public class TechnologicaSkullBlockRenderer {
	public static final HashMap<SkullBlock.Type, ResourceLocation> SKIN_BY_TYPE = new HashMap<SkullBlock.Type, ResourceLocation>();
	public static final HashMap<SkullBlock.Type, ModelLayerLocation> SKULL_RENDERERS = new HashMap<SkullBlock.Type, ModelLayerLocation>();

	static {
		SKIN_BY_TYPE.put(TechnologicaSkullBlock.Types.BEEPER, new TechnologicaLocation("textures/entity/beeper.png"));
		SKIN_BY_TYPE.put(TechnologicaSkullBlock.Types.PEEPER, new TechnologicaLocation("textures/entity/peeper.png"));
		SKIN_BY_TYPE.put(TechnologicaSkullBlock.Types.SLEEPER, new TechnologicaLocation("textures/entity/sleeper.png"));
		SKIN_BY_TYPE.put(TechnologicaSkullBlock.Types.SWEEPER, new TechnologicaLocation("textures/entity/sweeper.png"));
		SKIN_BY_TYPE.put(TechnologicaSkullBlock.Types.WEEPER, new TechnologicaLocation("textures/entity/weeper.png"));
		SKULL_RENDERERS.put(TechnologicaSkullBlock.Types.BEEPER, TechnologicaModelLayers.BEEPER_HEAD);
		SKULL_RENDERERS.put(TechnologicaSkullBlock.Types.PEEPER, TechnologicaModelLayers.PEEPER_HEAD);
		SKULL_RENDERERS.put(TechnologicaSkullBlock.Types.SLEEPER, TechnologicaModelLayers.SLEEPER_HEAD);
		SKULL_RENDERERS.put(TechnologicaSkullBlock.Types.SWEEPER, TechnologicaModelLayers.SWEEPER_HEAD);
		SKULL_RENDERERS.put(TechnologicaSkullBlock.Types.WEEPER, TechnologicaModelLayers.WEEPER_HEAD);
	}
}
