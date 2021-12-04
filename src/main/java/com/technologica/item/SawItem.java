package com.technologica.item;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class SawItem extends Item {

	public SawItem(Properties properties) {
		super(properties);
	}

	@Override
	public boolean hasContainerItem(ItemStack stack) {
		return true;
	}

	@Override
	public ItemStack getContainerItem(ItemStack stack) {
		return new ItemStack(TechnologicaItems.SAW.get());
	}

}
