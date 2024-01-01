package com.technologica.resourcegen.data.lootmodifiers.blocks;

import com.technologica.Technologica;
import com.technologica.listeners.lootmodifiers.blocks.FernLootModifier;
import com.technologica.listeners.lootmodifiers.blocks.GrassLootModifier;
import com.technologica.listeners.lootmodifiers.blocks.LargeFernLootModifier;
import com.technologica.listeners.lootmodifiers.blocks.TallGrassLootModifier;

import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraftforge.common.data.GlobalLootModifierProvider;
import net.minecraftforge.common.loot.LootTableIdCondition;

public class BlockLootModifierDataGenerator extends GlobalLootModifierProvider {

	public BlockLootModifierDataGenerator(PackOutput output) {
		super(output, Technologica.MOD_ID);
	}

	@Override
	protected void start() {
		add("blocks/fern", new FernLootModifier(new LootItemCondition[] { LootTableIdCondition.builder(new ResourceLocation("blocks/fern")).build() }));
		add("blocks/grass", new GrassLootModifier(new LootItemCondition[] { LootTableIdCondition.builder(new ResourceLocation("blocks/grass")).build() }));
		add("blocks/large_fern", new LargeFernLootModifier(new LootItemCondition[] { LootTableIdCondition.builder(new ResourceLocation("blocks/large_fern")).build() }));
		add("blocks/tall_grass", new TallGrassLootModifier(new LootItemCondition[] { LootTableIdCondition.builder(new ResourceLocation("blocks/tall_grass")).build() }));
	}
	
	@Override
    public String getName() {
        return "Global Loot Modifiers - Blocks: " + Technologica.MOD_ID;
    }
}