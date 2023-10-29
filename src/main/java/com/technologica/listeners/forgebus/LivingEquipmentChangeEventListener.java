package com.technologica.listeners.forgebus;

import java.util.UUID;

import com.technologica.capabilities.TechnologicaCapabilities;
import com.technologica.capabilities.air.IAir;
import com.technologica.network.play.server.Packets;
import com.technologica.network.play.server.SUpdateAirCapabilityPacket;

import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.event.entity.living.LivingEquipmentChangeEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.network.PacketDistributor;
import net.minecraftforge.registries.ForgeRegistries;

public class LivingEquipmentChangeEventListener {
	private static final UUID SNORKEL_SPEED_ID = UUID.fromString("182972b2-769c-11ee-b962-0242ac120002");
	private static final AttributeModifier SNORKEL_SPEED = new AttributeModifier(SNORKEL_SPEED_ID, "Snorkel speed multiplier", 1.5, AttributeModifier.Operation.MULTIPLY_TOTAL);
	private static final UUID SCUBA_SPEED_ID = UUID.fromString("9abfda52-769e-11ee-b962-0242ac120002");
	private static final AttributeModifier SCUBA_SPEED = new AttributeModifier(SCUBA_SPEED_ID, "Snorkel speed multiplier", 2.0, AttributeModifier.Operation.MULTIPLY_TOTAL);

	@SubscribeEvent
	public void onLivingEquipmentChangeEvent(LivingEquipmentChangeEvent event) {
		if (event.getEntity() instanceof Player) {
			ServerPlayer player = (ServerPlayer) event.getEntity();
			boolean fullSnorkelSet = true;
			boolean fullDiveSet = true;
			boolean fullScubaSet = true;
			Iterable<ItemStack> armor = player.getArmorSlots();

			for (ItemStack piece : armor) {
				if (!ForgeRegistries.ITEMS.getKey(piece.getItem()).getPath().contains("dive")) {
					fullDiveSet = false;
				}
				if (!ForgeRegistries.ITEMS.getKey(piece.getItem()).getPath().contains("snorkel")) {
					fullSnorkelSet = false;
				}
				if (!ForgeRegistries.ITEMS.getKey(piece.getItem()).getPath().contains("scuba")) {
					fullScubaSet = false;
				}
			}

			if (player.getAttribute(net.minecraftforge.common.ForgeMod.SWIM_SPEED.get()).hasModifier(SNORKEL_SPEED)) {
				player.getAttribute(net.minecraftforge.common.ForgeMod.SWIM_SPEED.get()).removeModifier(SNORKEL_SPEED);
			}
			if (player.getAttribute(net.minecraftforge.common.ForgeMod.SWIM_SPEED.get()).hasModifier(SCUBA_SPEED)) {
				player.getAttribute(net.minecraftforge.common.ForgeMod.SWIM_SPEED.get()).removeModifier(SCUBA_SPEED);
			}

			if (fullSnorkelSet) {
				IAir airCapability = player.getCapability(TechnologicaCapabilities.INSTANCE).orElseThrow(NullPointerException::new);
				airCapability.setNewMaxAir(600);
				Packets.INSTANCE.send(PacketDistributor.PLAYER.with(() -> player), new SUpdateAirCapabilityPacket(600));
				if (!player.getAttribute(net.minecraftforge.common.ForgeMod.SWIM_SPEED.get()).hasModifier(SNORKEL_SPEED)) {
					player.getAttribute(net.minecraftforge.common.ForgeMod.SWIM_SPEED.get()).addTransientModifier(SNORKEL_SPEED);
				}
			} else if (fullDiveSet) {
				IAir airCapability = player.getCapability(TechnologicaCapabilities.INSTANCE).orElseThrow(NullPointerException::new);
				airCapability.setNewMaxAir(6000);
				Packets.INSTANCE.send(PacketDistributor.PLAYER.with(() -> player), new SUpdateAirCapabilityPacket(6000));
			} else if (fullScubaSet) {
				IAir airCapability = player.getCapability(TechnologicaCapabilities.INSTANCE).orElseThrow(NullPointerException::new);
				airCapability.setNewMaxAir(6000);
				Packets.INSTANCE.send(PacketDistributor.PLAYER.with(() -> player), new SUpdateAirCapabilityPacket(6000));
				if (player.getAttribute(net.minecraftforge.common.ForgeMod.SWIM_SPEED.get()).hasModifier(SCUBA_SPEED)) {
					player.getAttribute(net.minecraftforge.common.ForgeMod.SWIM_SPEED.get()).removeModifier(SCUBA_SPEED);
				}
			} else {
				IAir airCapability = player.getCapability(TechnologicaCapabilities.INSTANCE).orElseThrow(NullPointerException::new);
				airCapability.setNewMaxAir(300);
				Packets.INSTANCE.send(PacketDistributor.PLAYER.with(() -> player), new SUpdateAirCapabilityPacket(300));
			}
		}

		/*
		 * if (fullDiveSet) {
		 * player.getAttribute(ForgeMod.SWIM_SPEED.get()).setBaseValue(2.0F);
		 * } else if (fullScubaSet) {
		 * player.getAttribute(ForgeMod.SWIM_SPEED.get()).setBaseValue(3.0F);
		 * } else {
		 * player.getAttribute(ForgeMod.SWIM_SPEED.get()).setBaseValue(1.0F);
		 * }
		 * }
		 */
	}
}