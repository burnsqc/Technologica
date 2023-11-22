package com.technologica.resourcegen.data.lootmodifiers.entities;

import com.technologica.Technologica;
import com.technologica.listeners.lootmodifiers.entities.HuskLootModifier;
import com.technologica.listeners.lootmodifiers.entities.ZombieLootModifier;
import com.technologica.listeners.lootmodifiers.entities.ZombieVillagerLootModifier;

import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraftforge.common.data.GlobalLootModifierProvider;
import net.minecraftforge.common.loot.LootTableIdCondition;

public class EntityLootModifierDataGenerator extends GlobalLootModifierProvider {

	public EntityLootModifierDataGenerator(PackOutput output) {
		super(output, Technologica.MOD_ID);
	}

	@Override
	protected void start() {
		add("entities/husk", new HuskLootModifier(new LootItemCondition[] { LootTableIdCondition.builder(new ResourceLocation("entities/husk")).build() }));
		add("entities/zombie", new ZombieLootModifier(new LootItemCondition[] { LootTableIdCondition.builder(new ResourceLocation("entities/zombie")).build() }));
		add("entities/zombie_villager", new ZombieVillagerLootModifier(new LootItemCondition[] { LootTableIdCondition.builder(new ResourceLocation("entities/zombie_villager")).build() }));
	}
	
	@Override
    public String getName()
    {
        return "Global Loot Modifiers - Entities : " + Technologica.MOD_ID;
    }
}