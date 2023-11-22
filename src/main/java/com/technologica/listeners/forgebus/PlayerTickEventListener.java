package com.technologica.listeners.forgebus;

import com.technologica.capabilities.TechnologicaCapabilities;
import com.technologica.capabilities.air.IAir;
import com.technologica.registration.deferred.TechnologicaBlocks;
import com.technologica.registration.deferred.TechnologicaItems;

import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.AirBlock;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.event.TickEvent.PlayerTickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class PlayerTickEventListener {

	@SubscribeEvent
	public void onPlayerTickEvent(PlayerTickEvent event) {
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

		IAir airCapability = player.getCapability(TechnologicaCapabilities.INSTANCE).orElse(null);
		if (airCapability == null) {

		} else {
			int newMaxAir = airCapability.getNewMaxAir();
			if (newMaxAir == 3000) {
				if (!player.getAbilities().flying) {
					if (event.phase == TickEvent.Phase.END) {
						player.addDeltaMovement(new Vec3(0.0, 0.005, 0.0));
					}
				}
			}
		}
	}
}