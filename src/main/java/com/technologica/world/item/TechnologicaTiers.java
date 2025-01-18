package com.technologica.world.item;

import java.util.function.Supplier;

import com.technologica.registration.deferred.TechnologicaItems;

import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.Tiers;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.Tags;

/**
 * <p>
 * This enum contains Tiers for tools.
 * This is effectively a simple copy of {@link Tiers}.
 * </p>
 * 
 * @tl.status GREEN
 */
public enum TechnologicaTiers implements Tier {
	WOOD(0, 1, 1.0F, 0.0F, 1, () -> Ingredient.of(ItemTags.PLANKS)),
	BONE(1, 8, 1.0F, 0.0F, 1, () -> Ingredient.of(Items.BONE)),
	STONE(2, 16, 1.0F, 0.5F, 4, () -> Ingredient.of(ItemTags.STONE_TOOL_MATERIALS)),
	FLINT(2, 16, 2.0F, 1.0F, 8, () -> Ingredient.of(Items.FLINT)),
	GOLD(3, 32, 12.0F, 0.0F, 12, () -> Ingredient.of(Items.GOLD_INGOT)),
	SILVER(3, 32, 6.0F, 1.0F, 30, () -> Ingredient.of(TechnologicaItems.SILVER_INGOT.get())),
	BRONZE(4, 64, 4.0F, 1.5F, 12, () -> Ingredient.of(TechnologicaItems.BRONZE_INGOT.get())), 
	BRASS(4, 64, 8.0F, 1.0F, 8, () -> Ingredient.of(TechnologicaItems.BRASS_INGOT.get())),
	IRON(5, 256, 6.0F, 2.0F, 14, () -> Ingredient.of(Items.IRON_INGOT)),
	DIAMOND(6, 1024, 8.0F, 3.0F, 15, () -> Ingredient.of(Items.DIAMOND)),
	STEEL(6, 1024, 12.0F, 3.0F, 5, () -> Ingredient.of(TechnologicaItems.STEEL_INGOT.get())),
	NETHERITE(7, 2048, 9.0F, 4.0F, 20, () -> Ingredient.of(Items.NETHERITE_INGOT)),
	TOOL_STEEL(7, 4096, 16.0F, 5.0F, 10, () -> Ingredient.of(Items.NETHERITE_INGOT));

	private final int level;
	private final int uses;
	private final float speed;
	private final float damage;
	private final int enchantmentValue;
	private final Supplier<Ingredient> repairIngredient;

	private TechnologicaTiers(int level, int uses, float speed, float damage, int enchantmentValue, Supplier<Ingredient> repairIngredient) {
		this.level = level;
		this.uses = uses;
		this.speed = speed;
		this.damage = damage;
		this.enchantmentValue = enchantmentValue;
		this.repairIngredient = repairIngredient;
	}

	@Override
	public int getUses() {
		return this.uses;
	}

	@Override
	public float getSpeed() {
		return this.speed;
	}

	@Override
	public float getAttackDamageBonus() {
		return this.damage;
	}

	@Override
	public int getLevel() {
		return this.level;
	}

	@Override
	public int getEnchantmentValue() {
		return this.enchantmentValue;
	}

	@Override
	public Ingredient getRepairIngredient() {
		return this.repairIngredient.get();
	}

	@Override
	public TagKey<Block> getTag() {
		return switch (this) {
		case WOOD -> Tags.Blocks.NEEDS_WOOD_TOOL;
		case BONE -> Tags.Blocks.NEEDS_WOOD_TOOL;
		case STONE -> BlockTags.NEEDS_STONE_TOOL;
		case FLINT -> Tags.Blocks.NEEDS_WOOD_TOOL;
		case GOLD -> Tags.Blocks.NEEDS_GOLD_TOOL;
		case SILVER -> Tags.Blocks.NEEDS_GOLD_TOOL;
		case BRASS -> BlockTags.NEEDS_IRON_TOOL;
		case BRONZE -> BlockTags.NEEDS_IRON_TOOL;
		case IRON -> BlockTags.NEEDS_IRON_TOOL;
		case STEEL -> BlockTags.NEEDS_DIAMOND_TOOL;
		case DIAMOND -> BlockTags.NEEDS_DIAMOND_TOOL;
		case NETHERITE -> Tags.Blocks.NEEDS_NETHERITE_TOOL;
		case TOOL_STEEL -> Tags.Blocks.NEEDS_NETHERITE_TOOL;
		};
	}
}
