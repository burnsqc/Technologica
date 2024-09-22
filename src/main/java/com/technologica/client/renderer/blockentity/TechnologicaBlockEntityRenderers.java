package com.technologica.client.renderer.blockentity;

import java.util.Map;

import com.google.common.collect.Maps;
import com.technologica.registration.deferred.TechnologicaBlockEntityTypes;

import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.client.renderer.blockentity.SignRenderer;
import net.minecraft.client.renderer.blockentity.SkullBlockRenderer;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;

public class TechnologicaBlockEntityRenderers {
	public static final Map<BlockEntityType<? extends BlockEntity>, BlockEntityRendererProvider<BlockEntity>> PROVIDERS = Maps.newHashMap();

	public static <T extends BlockEntity> void register(BlockEntityType<? extends T> entity, BlockEntityRendererProvider<T> renderer) {
		PROVIDERS.put((BlockEntityType<? extends T>) entity, (BlockEntityRendererProvider<BlockEntity>) renderer);
	}

	static {
		register(TechnologicaBlockEntityTypes.ANNUNCIATOR_TILE.get(), AnnunciatorRenderer::new);
		register(TechnologicaBlockEntityTypes.MONITOR_TILE.get(), MonitorRenderer::new);
		register(TechnologicaBlockEntityTypes.VANILLA_SIGN.get(), SignRenderer::new);
		register(TechnologicaBlockEntityTypes.TECHNOLOGICA_SIGN.get(), TechnologicaSignRenderer::new);
		register(TechnologicaBlockEntityTypes.FRUIT_CROP.get(), FruitRenderer::new);
		register(TechnologicaBlockEntityTypes.POTION_CROP.get(), PotionRenderer::new);
		register(TechnologicaBlockEntityTypes.DISPLAY_TILE.get(), DisplayCaseRenderer::new);
		register(TechnologicaBlockEntityTypes.LINE_SHAFT_TILE.get(), LineShaftRenderer::new);
		register(TechnologicaBlockEntityTypes.LINE_SHAFT_HANGER_TILE.get(), LineShaftHangerRenderer::new);
		register(TechnologicaBlockEntityTypes.SAWMILL_TILE.get(), SawmillRenderer::new);
		register(TechnologicaBlockEntityTypes.WINDMILL.get(), WindmillRenderer::new);
		register(TechnologicaBlockEntityTypes.LAND_MINE_TILE.get(), LandMineRenderer::new);
		register(TechnologicaBlockEntityTypes.SKULL.get(), SkullBlockRenderer::new);
	}
}
