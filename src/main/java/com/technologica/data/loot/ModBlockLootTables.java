package com.technologica.data.loot;

import com.technologica.setup.Registration;

import net.minecraft.block.Block;
import net.minecraft.data.loot.BlockLootTables;
import net.minecraftforge.fml.RegistryObject;

public class ModBlockLootTables extends BlockLootTables {
	@Override
	protected void addTables() {
		registerDropSelfLootTable(Registration.BANANA_LEAVES.get());
		registerDropSelfLootTable(Registration.CHERRY_LEAVES.get());
		registerDropSelfLootTable(Registration.COCONUT_LEAVES.get());
		registerDropSelfLootTable(Registration.KIWI_LEAVES.get());
		registerDropSelfLootTable(Registration.LEMON_LEAVES.get());
		registerDropSelfLootTable(Registration.LIME_LEAVES.get());
		registerDropSelfLootTable(Registration.ORANGE_LEAVES.get());
		registerDropSelfLootTable(Registration.PEACH_LEAVES.get());
		registerDropSelfLootTable(Registration.PEAR_LEAVES.get());
		registerDropSelfLootTable(Registration.FRUITFUL_LEAVES.get());
		registerDropSelfLootTable(Registration.ALCHEMICAL_LEAVES.get());
		registerDropSelfLootTable(Registration.BENEVOLENT_LEAVES.get());
		registerDropSelfLootTable(Registration.MALEVOLENT_LEAVES.get());
		registerDropSelfLootTable(Registration.CONDUCTIVE_LEAVES.get());
		registerDropSelfLootTable(Registration.FROSTBITTEN_LEAVES.get());
		
		registerDropSelfLootTable(Registration.BANANA_LOG.get());
		registerDropSelfLootTable(Registration.CHERRY_LOG.get());
		registerDropSelfLootTable(Registration.COCONUT_LOG.get());
		registerDropSelfLootTable(Registration.KIWI_LOG.get());
		registerDropSelfLootTable(Registration.LEMON_LOG.get());
		registerDropSelfLootTable(Registration.LIME_LOG.get());
		registerDropSelfLootTable(Registration.ORANGE_LOG.get());
		registerDropSelfLootTable(Registration.PEACH_LOG.get());
		registerDropSelfLootTable(Registration.PEAR_LOG.get());
		registerDropSelfLootTable(Registration.FRUITFUL_LOG.get());
		registerDropSelfLootTable(Registration.ALCHEMICAL_LOG.get());
		registerDropSelfLootTable(Registration.BENEVOLENT_LOG.get());
		registerDropSelfLootTable(Registration.MALEVOLENT_LOG.get());
		registerDropSelfLootTable(Registration.CONDUCTIVE_LOG.get());
		registerDropSelfLootTable(Registration.FROSTBITTEN_LOG.get());
		
		registerDropSelfLootTable(Registration.BANANA_SAPLING.get());
		registerDropSelfLootTable(Registration.CHERRY_SAPLING.get());
		registerDropSelfLootTable(Registration.COCONUT_SAPLING.get());
		registerDropSelfLootTable(Registration.KIWI_SAPLING.get());
		registerDropSelfLootTable(Registration.LEMON_SAPLING.get());
		registerDropSelfLootTable(Registration.LIME_SAPLING.get());
		registerDropSelfLootTable(Registration.ORANGE_SAPLING.get());
		registerDropSelfLootTable(Registration.PEACH_SAPLING.get());
		registerDropSelfLootTable(Registration.PEAR_SAPLING.get());
		registerDropSelfLootTable(Registration.ANCIENT_AMBROSIA_SAPLING.get());
		registerDropSelfLootTable(Registration.SERENDIPITOUS_APOTHECARY_SAPLING.get());
		registerDropSelfLootTable(Registration.BENEVOLENT_APOTHECARY_SAPLING.get());
		registerDropSelfLootTable(Registration.MALEVOLENT_APOTHECARY_SAPLING.get());
		registerDropSelfLootTable(Registration.TOWERING_INFERNO_SAPLING.get());
		registerDropSelfLootTable(Registration.THUNDEROUS_CONDUCTOR_SAPLING.get());
		registerDropSelfLootTable(Registration.CRYOGENIC_SPIRE_SAPLING.get());
		
		registerDropSelfLootTable(Registration.POTTED_BANANA_SAPLING.get());
		registerDropSelfLootTable(Registration.POTTED_CHERRY_SAPLING.get());
		registerDropSelfLootTable(Registration.POTTED_COCONUT_SAPLING.get());
		registerDropSelfLootTable(Registration.POTTED_KIWI_SAPLING.get());
		registerDropSelfLootTable(Registration.POTTED_LEMON_SAPLING.get());
		registerDropSelfLootTable(Registration.POTTED_LIME_SAPLING.get());
		registerDropSelfLootTable(Registration.POTTED_ORANGE_SAPLING.get());
		registerDropSelfLootTable(Registration.POTTED_PEACH_SAPLING.get());
		registerDropSelfLootTable(Registration.POTTED_PEAR_SAPLING.get());
		
		registerDropSelfLootTable(Registration.BLUEBERRY_CROP.get());
		registerDropSelfLootTable(Registration.GRAPE_CROP.get());
		registerDropSelfLootTable(Registration.STRAWBERRY_CROP.get());
		
		registerDropSelfLootTable(Registration.LITHIUM_CLAY.get());
		registerDropSelfLootTable(Registration.SALT.get());
		registerDropSelfLootTable(Registration.BAUXITE_ORE.get());
		registerDropSelfLootTable(Registration.CHROMITE_ORE.get());
		registerDropSelfLootTable(Registration.ILMENITE_ORE.get());
		registerDropSelfLootTable(Registration.PYROLUSITE_ORE.get());
		registerDropSelfLootTable(Registration.COBALTITE_ORE.get());
		registerDropSelfLootTable(Registration.GARNIERITE_ORE.get());
		registerDropSelfLootTable(Registration.BORAX_ORE.get());
		registerDropSelfLootTable(Registration.MAGNESITE_ORE.get());
		registerDropSelfLootTable(Registration.SPODUMENE_ORE.get());
		registerDropSelfLootTable(Registration.AQUAMARINE_CRYSTAL.get());
		registerDropSelfLootTable(Registration.DOLOMITE_CRYSTAL.get());
		registerDropSelfLootTable(Registration.FLUORITE_CRYSTAL.get());
		registerDropSelfLootTable(Registration.ULEXITE_CRYSTAL.get());
		
		registerDropSelfLootTable(Registration.DISPLAY_CASE.get());
	}
	
	@Override
	protected Iterable<Block> getKnownBlocks() {
		return Registration.BLOCKS.getEntries().stream().map(RegistryObject::get)::iterator;
	}
}
