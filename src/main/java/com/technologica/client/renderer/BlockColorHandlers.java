package com.technologica.client.renderer;

import java.util.Map;

import com.google.common.collect.ImmutableMap;
import com.technologica.registration.deferred.TechnologicaBlocks;

import net.minecraft.world.level.block.Block;

public class BlockColorHandlers {
	public static final Map<Integer, Block> HANDLERS = ImmutableMap.<Integer, Block>builder().put(-10867944, TechnologicaBlocks.MAPLE_SYRUP_BASIN.get()).put(-986928, TechnologicaBlocks.RUBBER_RESIN_BASIN.get()).build();
}
