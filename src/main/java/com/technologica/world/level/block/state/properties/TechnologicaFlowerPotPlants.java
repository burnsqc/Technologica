package com.technologica.world.level.block.state.properties;

import java.util.Map;

import com.google.common.collect.Maps;
import com.technologica.registration.deferred.TechnologicaBlocks;

import net.minecraft.world.level.block.Block;

public class TechnologicaFlowerPotPlants {
	public static final Map<Block, Block> PLANTS = Maps.newHashMap();

	static {
		register(TechnologicaBlocks.APRICOT_SAPLING.get(), TechnologicaBlocks.POTTED_APRICOT_SAPLING.get());
		register(TechnologicaBlocks.ASPEN_SAPLING.get(), TechnologicaBlocks.POTTED_ASPEN_SAPLING.get());
		register(TechnologicaBlocks.AVOCADO_SAPLING.get(), TechnologicaBlocks.POTTED_AVOCADO_SAPLING.get());
		register(TechnologicaBlocks.BANANA_SAPLING.get(), TechnologicaBlocks.POTTED_BANANA_SAPLING.get());
		register(TechnologicaBlocks.CHERRY_SAPLING.get(), TechnologicaBlocks.POTTED_CHERRY_SAPLING.get());
		register(TechnologicaBlocks.CHESTNUT_SAPLING.get(), TechnologicaBlocks.POTTED_CHESTNUT_SAPLING.get());
		register(TechnologicaBlocks.CINNAMON_SAPLING.get(), TechnologicaBlocks.POTTED_CINNAMON_SAPLING.get());
		register(TechnologicaBlocks.COCONUT_SAPLING.get(), TechnologicaBlocks.POTTED_COCONUT_SAPLING.get());
		register(TechnologicaBlocks.EBONY_SAPLING.get(), TechnologicaBlocks.POTTED_EBONY_SAPLING.get());
		register(TechnologicaBlocks.KIWI_SAPLING.get(), TechnologicaBlocks.POTTED_KIWI_SAPLING.get());
		register(TechnologicaBlocks.LEMON_SAPLING.get(), TechnologicaBlocks.POTTED_LEMON_SAPLING.get());
		register(TechnologicaBlocks.LIME_SAPLING.get(), TechnologicaBlocks.POTTED_LIME_SAPLING.get());
		register(TechnologicaBlocks.MAHOGANY_SAPLING.get(), TechnologicaBlocks.POTTED_MAHOGANY_SAPLING.get());
		register(TechnologicaBlocks.MAPLE_SAPLING.get(), TechnologicaBlocks.POTTED_MAPLE_SAPLING.get());
		register(TechnologicaBlocks.OLIVE_SAPLING.get(), TechnologicaBlocks.POTTED_OLIVE_SAPLING.get());
		register(TechnologicaBlocks.ORANGE_SAPLING.get(), TechnologicaBlocks.POTTED_ORANGE_SAPLING.get());
		register(TechnologicaBlocks.PEACH_SAPLING.get(), TechnologicaBlocks.POTTED_PEACH_SAPLING.get());
		register(TechnologicaBlocks.PEAR_SAPLING.get(), TechnologicaBlocks.POTTED_PEAR_SAPLING.get());
		register(TechnologicaBlocks.PLUM_SAPLING.get(), TechnologicaBlocks.POTTED_PLUM_SAPLING.get());
		register(TechnologicaBlocks.REDWOOD_SAPLING.get(), TechnologicaBlocks.POTTED_REDWOOD_SAPLING.get());
		register(TechnologicaBlocks.ROSEWOOD_SAPLING.get(), TechnologicaBlocks.POTTED_ROSEWOOD_SAPLING.get());
		register(TechnologicaBlocks.RUBBER_SAPLING.get(), TechnologicaBlocks.POTTED_RUBBER_SAPLING.get());
		register(TechnologicaBlocks.TEAK_SAPLING.get(), TechnologicaBlocks.POTTED_TEAK_SAPLING.get());
		register(TechnologicaBlocks.WALNUT_SAPLING.get(), TechnologicaBlocks.POTTED_WALNUT_SAPLING.get());
		register(TechnologicaBlocks.ZEBRAWOOD_SAPLING.get(), TechnologicaBlocks.POTTED_ZEBRAWOOD_SAPLING.get());
		register(TechnologicaBlocks.ANCIENT_AMBROSIA_SAPLING.get(), TechnologicaBlocks.POTTED_ANCIENT_AMBROSIA_SAPLING.get());
		register(TechnologicaBlocks.BENEVOLENT_APOTHECARY_SAPLING.get(), TechnologicaBlocks.POTTED_BENEVOLENT_APOTHECARY_SAPLING.get());
		register(TechnologicaBlocks.CRYOGENIC_SPIRE_SAPLING.get(), TechnologicaBlocks.POTTED_CRYOGENIC_SPIRE_SAPLING.get());
		register(TechnologicaBlocks.MALEVOLENT_APOTHECARY_SAPLING.get(), TechnologicaBlocks.POTTED_MALEVOLENT_APOTHECARY_SAPLING.get());
		register(TechnologicaBlocks.NECROTIC_SAPLING.get(), TechnologicaBlocks.POTTED_NECROTIC_SAPLING.get());
		register(TechnologicaBlocks.SERENDIPITOUS_APOTHECARY_SAPLING.get(), TechnologicaBlocks.POTTED_SERENDIPITOUS_APOTHECARY_SAPLING.get());
		register(TechnologicaBlocks.THUNDEROUS_CONDUCTOR_SAPLING.get(), TechnologicaBlocks.POTTED_THUNDEROUS_CONDUCTOR_SAPLING.get());
		register(TechnologicaBlocks.TOWERING_INFERNO_SAPLING.get(), TechnologicaBlocks.POTTED_TOWERING_INFERNO_SAPLING.get());
	}

	private static void register(Block plant, Block pottedPlant) {
		PLANTS.put(plant, pottedPlant);
	}
}
