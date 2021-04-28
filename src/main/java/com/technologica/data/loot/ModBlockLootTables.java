package com.technologica.data.loot;

import com.technologica.setup.Registration;

import net.minecraft.block.Block;
import net.minecraft.data.loot.BlockLootTables;
import net.minecraftforge.fml.RegistryObject;

public class ModBlockLootTables extends BlockLootTables {
	@Override
	protected void addTables() {
		registerDropSelfLootTable(Registration.DISPLAY_CASE.get());
	}
	
	@Override
	protected Iterable<Block> getKnownBlocks() {
		return Registration.BLOCKS.getEntries().stream().map(RegistryObject::get)::iterator;
	}
}
