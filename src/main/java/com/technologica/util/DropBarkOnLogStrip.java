package com.technologica.util;

import com.technologica.item.TechnologicaItems;

import net.minecraft.entity.item.ItemEntity;
import net.minecraft.item.AxeItem;
import net.minecraft.item.ItemStack;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.math.BlockPos;
import net.minecraftforge.event.entity.player.PlayerInteractEvent.RightClickBlock;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class DropBarkOnLogStrip {

	@SubscribeEvent
	public void onRightClickBlock(RightClickBlock event) {
		if (event.getItemStack().getItem() instanceof AxeItem & event.getWorld().getBlockState(event.getPos()).getBlock().isIn(BlockTags.LOGS) & !event.getWorld().getBlockState(event.getPos()).getBlock().getRegistryName().getPath().contains("stripped")) {
			ItemStack bark;
			
			if (!event.getWorld().getBlockState(event.getPos()).getBlock().getRegistryName().getPath().contains("cinnamon")) {
				bark = new ItemStack(TechnologicaItems.MULCH.get());
			} else {
				bark = new ItemStack(TechnologicaItems.CINNAMON.get());
			}
			
			BlockPos freePos = event.getPos().offset(event.getFace());
			ItemEntity drop = new ItemEntity(event.getWorld(), freePos.getX() + 0.5f, freePos.getY() + 0.5f, freePos.getZ() + 0.5f, bark);
			event.getWorld().addEntity(drop);
		}
	}
}