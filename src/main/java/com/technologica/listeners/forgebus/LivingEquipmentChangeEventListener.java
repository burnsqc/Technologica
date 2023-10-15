package com.technologica.listeners.forgebus;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.common.ForgeMod;
import net.minecraftforge.event.entity.living.LivingEquipmentChangeEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.registries.ForgeRegistries;

public class LivingEquipmentChangeEventListener {

	@SubscribeEvent
	public void onLivingEquipmentChangeEvent(LivingEquipmentChangeEvent event) {
		if (event.getEntity() instanceof Player) {
			Player player = (Player) event.getEntity();
			boolean fullDiveSet = true;
			boolean fullScubaSet = true;
			Iterable<ItemStack> armor = player.getArmorSlots();

			for (ItemStack piece : armor) {
				if (!ForgeRegistries.ITEMS.getKey(piece.getItem()).getPath().contains("dive")) {
					fullDiveSet = false;
				}
				if (!ForgeRegistries.ITEMS.getKey(piece.getItem()).getPath().contains("scuba")) {
					fullScubaSet = false;
				}
			}

			if (fullDiveSet) {
				player.getAttribute(ForgeMod.SWIM_SPEED.get()).setBaseValue(2.0F);
			} else if (fullScubaSet) {
				player.getAttribute(ForgeMod.SWIM_SPEED.get()).setBaseValue(3.0F);
			} else {
				player.getAttribute(ForgeMod.SWIM_SPEED.get()).setBaseValue(1.0F);
			}
		}
	}
}