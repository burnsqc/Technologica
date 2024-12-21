package com.technologica.world.item;

import net.minecraft.tags.BlockTags;
import net.minecraft.world.item.DiggerItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Tier;

public class SawItem extends DiggerItem {
	public SawItem(Tier tier, float attackDamage, float attackSpeed, Properties properties) {
		super(attackDamage, attackSpeed, tier, BlockTags.MINEABLE_WITH_AXE, properties);
	}

	@Override
	public boolean hasCraftingRemainingItem(ItemStack itemStack) {
		return true;
	}

	@Override
	public ItemStack getCraftingRemainingItem(ItemStack itemStack) {
		itemStack = itemStack.copy();
		itemStack = itemStack.hurt(1, null, null) ? ItemStack.EMPTY : itemStack;
		return itemStack;
	}
}
