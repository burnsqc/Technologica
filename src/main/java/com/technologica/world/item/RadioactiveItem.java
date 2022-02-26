package com.technologica.world.item;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;

public class RadioactiveItem extends Item {

	public RadioactiveItem(Properties properties) {
		super(properties);
	}

	@Override
	public boolean isFoil(ItemStack stack) {
		return true;
	}

}
