package com.technologica.listeners.forge;

import com.technologica.registration.deferred.TechnologicaBlocks;
import com.technologica.registration.deferred.TechnologicaItems;

import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.AirBlock;
import net.minecraftforge.event.TickEvent.PlayerTickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;

@Mod.EventBusSubscriber(bus = EventBusSubscriber.Bus.FORGE)
public class PlayerTickEventListener {

	@SubscribeEvent
	public static void onPlayerTickEvent(PlayerTickEvent event) {
		Player player = event.player;
		Level level = player.level();
		BlockPos pos = BlockPos.containing(player.getEyePosition());

		if (level.getBlockState(pos).getBlock() instanceof AirBlock && level instanceof ServerLevel) {
			Iterable<ItemStack> armor = player.getArmorSlots();
			for (ItemStack piece : armor) {
				if (piece.is(TechnologicaItems.MINING_HELMET.get())) {
					level.setBlockAndUpdate(pos, TechnologicaBlocks.LIGHT.get().defaultBlockState());
				}
			}
		}
	}
}
