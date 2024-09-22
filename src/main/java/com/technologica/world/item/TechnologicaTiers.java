package com.technologica.world.item;

import java.util.function.Supplier;

import com.technologica.registration.deferred.TechnologicaItems;

import net.minecraft.tags.BlockTags;
import net.minecraft.tags.TagKey;
import net.minecraft.util.LazyLoadedValue;
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
@SuppressWarnings("deprecation")
public enum TechnologicaTiers implements Tier {
	FLINT(0, 16, 2.0F, 0.0F, 15, () -> {
		return Ingredient.of(Items.FLINT);
	}),
	BRONZE(2, 64, 5.0F, 1.5F, 15, () -> {
		return Ingredient.of(TechnologicaItems.BRONZE_INGOT.get());
	});

	private final int level;
	private final int uses;
	private final float speed;
	private final float damage;
	private final int enchantmentValue;
	private final LazyLoadedValue<Ingredient> repairIngredient;

	private TechnologicaTiers(int level, int uses, float speed, float damage, int enchantmentValue, Supplier<Ingredient> repairIngredient) {
		this.level = level;
		this.uses = uses;
		this.speed = speed;
		this.damage = damage;
		this.enchantmentValue = enchantmentValue;
		this.repairIngredient = new LazyLoadedValue<>(repairIngredient);
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
		case FLINT -> Tags.Blocks.NEEDS_WOOD_TOOL;
		case BRONZE -> BlockTags.NEEDS_IRON_TOOL;
		};
	}
}
