package com.technologica.listeners.forgebus;

import com.technologica.world.item.TechnologicaItems;

import net.minecraft.core.BlockPos;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.item.AxeItem;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.event.entity.player.PlayerInteractEvent.RightClickBlock;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.registries.ForgeRegistries;

public class RightClickBlockListener {

	@SubscribeEvent
	public void onRightClickBlock(RightClickBlock event) { // NO_UCD (unused code)
		if (event.getItemStack().getItem() instanceof AxeItem && event.getLevel().getBlockState(event.getPos()).is(BlockTags.LOGS) && !ForgeRegistries.BLOCKS.getKey(event.getLevel().getBlockState(event.getPos()).getBlock()).getPath().contains("stripped")) {
			ItemStack bark;

			if (!ForgeRegistries.BLOCKS.getKey(event.getLevel().getBlockState(event.getPos()).getBlock()).getPath().contains("cinnamon")) {
				bark = new ItemStack(TechnologicaItems.MULCH.get());
			} else {
				bark = new ItemStack(TechnologicaItems.CINNAMON.get());
			}

			BlockPos freePos = event.getPos().relative(event.getFace());
			ItemEntity drop = new ItemEntity(event.getLevel(), freePos.getX() + 0.5f, freePos.getY() + 0.5f, freePos.getZ() + 0.5f, bark);
			event.getLevel().addFreshEntity(drop);
		}
	}
}