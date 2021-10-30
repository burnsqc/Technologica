package com.technologica.util;

import com.technologica.item.TechnologicaItems;

import net.minecraft.entity.item.ItemEntity;
import net.minecraft.item.AxeItem;
import net.minecraft.item.ItemStack;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.math.BlockPos;
import net.minecraftforge.event.entity.player.PlayerInteractEvent.RightClickBlock;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class BarkProvider {

	@SubscribeEvent
	public void onRightClickBlock(RightClickBlock event) {
		if (event.getItemStack().getItem() instanceof AxeItem & event.getWorld().getBlockState(event.getPos()).getBlock().isIn(BlockTags.LOGS)) {
			ItemStack bark = new ItemStack(TechnologicaItems.MULCH.get());
			BlockPos freePos = event.getPos().offset(event.getFace());
			ItemEntity mulch = new ItemEntity(event.getWorld(), freePos.getX() + 0.5f, freePos.getY() + 0.5f, freePos.getZ() + 0.5f, bark);
			event.getWorld().addEntity(mulch);
		}
	}
}