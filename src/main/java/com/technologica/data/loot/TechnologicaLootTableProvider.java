package com.technologica.data.loot;

import java.util.List;
import java.util.Map;
import java.util.Set;

import net.minecraft.data.PackOutput;
import net.minecraft.data.loot.LootTableProvider;
import net.minecraft.data.loot.packs.VanillaLootTableProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.ValidationContext;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;

public class TechnologicaLootTableProvider extends LootTableProvider {
	private final List<SubProviderEntry> subProviders = List.of(new LootTableProvider.SubProviderEntry(TechnologicaBlockLoot::new, LootContextParamSets.BLOCK), new LootTableProvider.SubProviderEntry(TechnologicaEntityLoot::new, LootContextParamSets.ENTITY));
	
	public TechnologicaLootTableProvider (PackOutput packOutput) {
		super(packOutput, Set.of(), VanillaLootTableProvider.create(packOutput).getTables());
	}
	
	@Override
	public List<LootTableProvider.SubProviderEntry> getTables() {
		return subProviders;
	}
	
	@Override
	protected void validate(Map<ResourceLocation, LootTable> map, ValidationContext validationtracker) {
	}
}