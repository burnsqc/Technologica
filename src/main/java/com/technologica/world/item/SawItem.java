package com.technologica.world.item;

import net.minecraft.tags.BlockTags;
import net.minecraft.world.item.DiggerItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Tiers;

import net.minecraft.world.item.Item.Properties;

public class SawItem extends DiggerItem {
	public SawItem(Properties properties) {
		super(6.0F, -3.2F, Tiers.WOOD, BlockTags.MINEABLE_WITH_AXE, properties);
	}

	@Override
	public boolean hasCraftingRemainingItem(ItemStack stack) {
		return true;
	}

	@Override
	public ItemStack getCraftingRemainingItem(ItemStack stack) {
		stack = stack.copy();
		stack = stack.hurt(1, null, null) ? ItemStack.EMPTY : stack;
		return stack;
	}

}
