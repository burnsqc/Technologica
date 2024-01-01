package com.technologica.listeners.forgebus;

import com.technologica.Technologica;
import com.technologica.capabilities.entity.airMeter.IAir;
import com.technologica.capabilities.entity.environmentTracker.EnvironmentTracker;
import com.technologica.network.packets.ClientboundTriggerEnvironmentTitleCardPacket;
import com.technologica.registration.deferred.TechnologicaBlocks;
import com.technologica.registration.deferred.TechnologicaItems;
import com.technologica.setup.config.TechnologicaConfigClient;
import com.technologica.setup.listeners.TechnologicaCapabilities;
import com.technologica.util.text.TextUtil;

import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.AirBlock;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.event.TickEvent.PlayerTickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.network.PacketDistributor;

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

		IAir airCapability = player.getCapability(TechnologicaCapabilities.AIR_METER_INSTANCE).orElse(null);
		if (airCapability != null) {
			int newMaxAir = airCapability.getNewMaxAir();
			if (newMaxAir == 3000) {
				if (!player.getAbilities().flying) {
					if (event.phase == TickEvent.Phase.END) {
						player.addDeltaMovement(new Vec3(0.0, 0.005, 0.0));
					}
				}
			}
		}

		if (player instanceof ServerPlayer) {
			EnvironmentTracker environmentTrackerCapability = player.getCapability(TechnologicaCapabilities.ENVIRONMENT_TRACKER_INSTANCE).orElse(null);
			if (environmentTrackerCapability != null) {
				String biomeName = TextUtil.stringToCapsName(TextUtil.getPath(player.level().getBiome(pos)));

				if (!biomeName.equals(environmentTrackerCapability.getMostRecentBiome())) {
					if (environmentTrackerCapability.addBiome(biomeName) || TechnologicaConfigClient.BIOME_TITLE_CARDS.get().equals("always")) {
						if (!TechnologicaConfigClient.BIOME_TITLE_CARDS.get().equals("never")) {
							Technologica.CHANNEL.send(PacketDistributor.PLAYER.with(() -> (ServerPlayer) player), new ClientboundTriggerEnvironmentTitleCardPacket(true));
						}
					}
				}
			}
		}
	}
}