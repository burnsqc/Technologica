package com.technologica.data;

import java.util.List;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Supplier;

import com.google.common.collect.ImmutableList;
import com.mojang.datafixers.util.Pair;
import com.technologica.data.loot.ModBlockLootTables;

import net.minecraft.data.DataGenerator;
import net.minecraft.data.LootTableProvider;
import net.minecraft.loot.LootParameterSet;
import net.minecraft.loot.LootParameterSets;
import net.minecraft.loot.LootTable;
import net.minecraft.loot.LootTable.Builder;
import net.minecraft.loot.ValidationTracker;
import net.minecraft.util.ResourceLocation;

public class ModLootTableProvider extends LootTableProvider {
	private final List<Pair<Supplier<Consumer<BiConsumer<ResourceLocation, LootTable.Builder>>>, LootParameterSet>> loot_tables = ImmutableList.of(Pair.of(ModBlockLootTables::new, LootParameterSets.BLOCK));
	
	public ModLootTableProvider (DataGenerator generatorIn) {
		super(generatorIn);
	}
	
	@Override
	protected List<Pair<Supplier<Consumer<BiConsumer<ResourceLocation, Builder>>>, LootParameterSet>> getTables() {
		return loot_tables;
	}
	
	@Override
	protected void validate(Map<ResourceLocation, LootTable> map, ValidationTracker validationtracker) {
		// nothing to see here
	}
}