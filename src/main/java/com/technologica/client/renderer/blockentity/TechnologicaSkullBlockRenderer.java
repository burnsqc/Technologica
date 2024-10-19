package com.technologica.client.renderer.blockentity;

import java.util.Map;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Maps;
import com.technologica.client.model.geom.TechnologicaModelLayers;
import com.technologica.listeners.mod.client.EntityRenderersEventListener;
import com.technologica.listeners.mod.client.FMLClientSetupEventListener;
import com.technologica.util.text.TechnologicaLocation;
import com.technologica.world.level.block.TechnologicaSkullBlock;

import net.minecraft.Util;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.renderer.blockentity.SkullBlockRenderer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.SkullBlock;

/**
 * A sort of fake copy of {@link SkullBlockRenderer}. {@link #createSkullRenderers} gets called by {@link EntityRenderersEventListener#onEntityRenderersEvent$CreateSkullModels} with the intent of keeping the listener method itself concise and providing a higher fidelity mirror of vanilla code. {@link #SKIN_BY_TYPE} gets called by {@link FMLClientSetupEventListener#onFMLClientSetupEvent}.
 */
public class TechnologicaSkullBlockRenderer {
	public static final Map<SkullBlock.Type, ResourceLocation> SKIN_BY_TYPE = Util.make(Maps.newHashMap(), (hashMap) -> {
		hashMap.put(TechnologicaSkullBlock.Types.BEEPER, new TechnologicaLocation("textures/entity/beeper.png"));
		hashMap.put(TechnologicaSkullBlock.Types.PEEPER, new TechnologicaLocation("textures/entity/peeper.png"));
		hashMap.put(TechnologicaSkullBlock.Types.SLEEPER, new TechnologicaLocation("textures/entity/sleeper.png"));
		hashMap.put(TechnologicaSkullBlock.Types.SWEEPER, new TechnologicaLocation("textures/entity/sweeper.png"));
		hashMap.put(TechnologicaSkullBlock.Types.WEEPER, new TechnologicaLocation("textures/entity/weeper.png"));
	});

	public static Map<SkullBlock.Type, ModelLayerLocation> createSkullRenderers() {
		ImmutableMap.Builder<SkullBlock.Type, ModelLayerLocation> builder = ImmutableMap.builder();
		builder.put(TechnologicaSkullBlock.Types.BEEPER, TechnologicaModelLayers.BEEPER_HEAD);
		builder.put(TechnologicaSkullBlock.Types.PEEPER, TechnologicaModelLayers.PEEPER_HEAD);
		builder.put(TechnologicaSkullBlock.Types.SLEEPER, TechnologicaModelLayers.SLEEPER_HEAD);
		builder.put(TechnologicaSkullBlock.Types.SWEEPER, TechnologicaModelLayers.SWEEPER_HEAD);
		builder.put(TechnologicaSkullBlock.Types.WEEPER, TechnologicaModelLayers.WEEPER_HEAD);
		return builder.build();
	}
}
