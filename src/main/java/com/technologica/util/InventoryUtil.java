package com.technologica.util;

import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;

public class InventoryUtil {

	public static boolean playerHas(Player player, Item item) {
		Inventory inventory = player.getInventory();
		for (int i = 0; i < inventory.getContainerSize(); ++i) {
			if (inventory.getItem(i).getItem() == item) {
				return true;
			}
		}
		return false;
	}

	public static boolean fullArmorSet(Player player, ArmorMaterial armorMaterial) {
		Iterable<ItemStack> armorPieces = player.getArmorSlots();
		for (ItemStack armorPiece : armorPieces) {
			if (armorPiece.getItem() instanceof ArmorItem) {
				ArmorItem armor = (ArmorItem) armorPiece.getItem();
				if (!(armor.getMaterial() == armorMaterial)) {
					return false;
				}
			} else {
				return false;
			}
		}
		return true;
	}
}