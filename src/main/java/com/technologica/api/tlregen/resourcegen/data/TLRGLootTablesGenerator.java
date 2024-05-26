package com.technologica.api.tlregen.resourcegen.data;

import java.util.List;
import java.util.Map;
import java.util.Set;

import com.technologica.api.tlregen.resourcegen.TLReGenMasterResourceGenerator;
import com.technologica.resourcegen.data.loottables.blocks.TLLootTablesBlocksGenerator;
import com.technologica.resourcegen.data.loottables.entities.EntityLootDataGenerator;

import net.minecraft.data.loot.LootTableProvider;
import net.minecraft.data.loot.packs.VanillaLootTableProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.ValidationContext;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;

public class TLRGLootTablesGenerator extends LootTableProvider {
	private final List<SubProviderEntry> subProviders = List.of(new LootTableProvider.SubProviderEntry(TLLootTablesBlocksGenerator::new, LootContextParamSets.BLOCK), new LootTableProvider.SubProviderEntry(EntityLootDataGenerator::new, LootContextParamSets.ENTITY));

	public TLRGLootTablesGenerator() {
		super(TLReGenMasterResourceGenerator.packOutput, Set.of(), VanillaLootTableProvider.create(TLReGenMasterResourceGenerator.packOutput).getTables());
	}

	@Override
	public List<LootTableProvider.SubProviderEntry> getTables() {
		return subProviders;
	}

	@Override
	protected void validate(Map<ResourceLocation, LootTable> map, ValidationContext validationtracker) {
	}
}
