package com.technologica.item;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class RadioactiveItem extends Item {

	public RadioactiveItem(Properties properties) {
		super(properties);
	}

	@Override
	public boolean isFoil(ItemStack stack) {
		return true;
	}

}
