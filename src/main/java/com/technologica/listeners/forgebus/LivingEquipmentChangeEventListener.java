package com.technologica.listeners.forgebus;

import java.util.UUID;

import com.technologica.Technologica;
import com.technologica.capabilities.TechnologicaCapabilities;
import com.technologica.capabilities.air.IAir;
import com.technologica.network.play.server.SUpdateAirCapabilityPacket;
import com.technologica.util.InventoryUtil;
import com.technologica.world.item.TechnologicaArmorMaterial;

import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraftforge.event.entity.living.LivingEquipmentChangeEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.network.PacketDistributor;

public class LivingEquipmentChangeEventListener {
	private static final UUID SNORKEL_SPEED_ID = UUID.fromString("182972b2-769c-11ee-b962-0242ac120002");
	private static final UUID SCUBA_SPEED_ID = UUID.fromString("9abfda52-769e-11ee-b962-0242ac120002");
	private static final AttributeModifier SNORKEL_SPEED = new AttributeModifier(SNORKEL_SPEED_ID, "Snorkel speed multiplier", 1.5, AttributeModifier.Operation.MULTIPLY_TOTAL);
	private static final AttributeModifier SCUBA_SPEED = new AttributeModifier(SCUBA_SPEED_ID, "Snorkel speed multiplier", 2.0, AttributeModifier.Operation.MULTIPLY_TOTAL);

	@SubscribeEvent
	public void onLivingEquipmentChangeEvent(LivingEquipmentChangeEvent event) {
		if (event.getEntity() instanceof ServerPlayer) {
			ServerPlayer serverPlayer = (ServerPlayer) event.getEntity();

			if (serverPlayer.getAttribute(net.minecraftforge.common.ForgeMod.SWIM_SPEED.get()).hasModifier(SNORKEL_SPEED)) {
				serverPlayer.getAttribute(net.minecraftforge.common.ForgeMod.SWIM_SPEED.get()).removeModifier(SNORKEL_SPEED);
			}
			if (serverPlayer.getAttribute(net.minecraftforge.common.ForgeMod.SWIM_SPEED.get()).hasModifier(SCUBA_SPEED)) {
				serverPlayer.getAttribute(net.minecraftforge.common.ForgeMod.SWIM_SPEED.get()).removeModifier(SCUBA_SPEED);
			}

			// Full snorkel grants 2x air, 1.5x swim speed, and 2x air refill speed. Refill handled in LivingBreathEvent.
			// Full dive grants 20x air, rest is work in progress.
			// Full scuba grants 10x air, 2.0x swim speed, and neutral buoyancy. Buoyancy is handled in PlayerTickEvent.
			if (InventoryUtil.fullArmorSet(serverPlayer, TechnologicaArmorMaterial.SNORKEL)) {
				IAir airCapability = serverPlayer.getCapability(TechnologicaCapabilities.INSTANCE).orElseThrow(NullPointerException::new);
				airCapability.setNewMaxAir(600);
				Technologica.CHANNEL.send(PacketDistributor.PLAYER.with(() -> serverPlayer), new SUpdateAirCapabilityPacket(600));
				if (!serverPlayer.getAttribute(net.minecraftforge.common.ForgeMod.SWIM_SPEED.get()).hasModifier(SNORKEL_SPEED)) {
					serverPlayer.getAttribute(net.minecraftforge.common.ForgeMod.SWIM_SPEED.get()).addPermanentModifier(SNORKEL_SPEED);
				}
			} else if (InventoryUtil.fullArmorSet(serverPlayer, TechnologicaArmorMaterial.DIVE)) {
				IAir airCapability = serverPlayer.getCapability(TechnologicaCapabilities.INSTANCE).orElseThrow(NullPointerException::new);
				airCapability.setNewMaxAir(6000);
				Technologica.CHANNEL.send(PacketDistributor.PLAYER.with(() -> serverPlayer), new SUpdateAirCapabilityPacket(6000));
			} else if (InventoryUtil.fullArmorSet(serverPlayer, TechnologicaArmorMaterial.SCUBA)) {
				IAir airCapability = serverPlayer.getCapability(TechnologicaCapabilities.INSTANCE).orElseThrow(NullPointerException::new);
				airCapability.setNewMaxAir(3000);
				Technologica.CHANNEL.send(PacketDistributor.PLAYER.with(() -> serverPlayer), new SUpdateAirCapabilityPacket(3000));
				if (!serverPlayer.getAttribute(net.minecraftforge.common.ForgeMod.SWIM_SPEED.get()).hasModifier(SCUBA_SPEED)) {
					serverPlayer.getAttribute(net.minecraftforge.common.ForgeMod.SWIM_SPEED.get()).addPermanentModifier(SCUBA_SPEED);
				}
			} else {
				IAir airCapability = serverPlayer.getCapability(TechnologicaCapabilities.INSTANCE).orElseThrow(NullPointerException::new);
				airCapability.setNewMaxAir(300);
				Technologica.CHANNEL.send(PacketDistributor.PLAYER.with(() -> serverPlayer), new SUpdateAirCapabilityPacket(300));
			}
		}
	}
}