package com.technologica.listeners.forge;

import java.util.UUID;

import com.technologica.Technologica;
import com.technologica.listeners.mod.common.RegisterCapabilitiesEventListener;
import com.technologica.network.packets.clientbound.UpdateDiverCapability;
import com.technologica.util.InventoryUtil;
import com.technologica.util.mixininterfaces.IMixinMaxAir;
import com.technologica.world.entity.player.TechnologicaAbilities;
import com.technologica.world.item.TechnologicaArmorMaterials;

import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraftforge.event.entity.living.LivingEquipmentChangeEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.network.PacketDistributor;

@Mod.EventBusSubscriber(bus = EventBusSubscriber.Bus.FORGE)
public class LivingEquipmentChange {
	private static final UUID SNORKEL_SPEED_ID = UUID.fromString("182972b2-769c-11ee-b962-0242ac120002");
	private static final UUID SCUBA_SPEED_ID = UUID.fromString("9abfda52-769e-11ee-b962-0242ac120002");
	private static final AttributeModifier SNORKEL_SPEED = new AttributeModifier(SNORKEL_SPEED_ID, "Snorkel speed multiplier", 1.5, AttributeModifier.Operation.MULTIPLY_TOTAL);
	private static final AttributeModifier SCUBA_SPEED = new AttributeModifier(SCUBA_SPEED_ID, "Snorkel speed multiplier", 2.0, AttributeModifier.Operation.MULTIPLY_TOTAL);

	@SubscribeEvent
	public static void onLivingEquipmentChangeEvent(final LivingEquipmentChangeEvent event) {
		if (event.getEntity() instanceof ServerPlayer serverPlayer) {
			// Full snorkel grants 2x air, 1.5x swim speed, and 2x air refill speed. Refill handled in LivingBreathEvent.
			// Full dive grants 20x air, rest is work in progress.
			// Full scuba grants 10x air, 2.0x swim speed, and neutral buoyancy. Buoyancy is handled in PlayerTickEvent.
			if (InventoryUtil.fullArmorSet(serverPlayer, TechnologicaArmorMaterials.SNORKEL)) {
				((IMixinMaxAir) serverPlayer).setMaxAirSupply(600);
				if (!serverPlayer.getAttribute(net.minecraftforge.common.ForgeMod.SWIM_SPEED.get()).hasModifier(SNORKEL_SPEED)) {
					serverPlayer.getAttribute(net.minecraftforge.common.ForgeMod.SWIM_SPEED.get()).addPermanentModifier(SNORKEL_SPEED);
				}
				return;
			}

			if (InventoryUtil.fullArmorSet(serverPlayer, TechnologicaArmorMaterials.DIVE)) {
				((IMixinMaxAir) serverPlayer).setMaxAirSupply(6000);
				TechnologicaAbilities diver = serverPlayer.getCapability(RegisterCapabilitiesEventListener.DIVER_INSTANCE).orElseThrow(NullPointerException::new);
				diver.setDiver(true);
				Technologica.CHANNEL.send(PacketDistributor.PLAYER.with(() -> serverPlayer), new UpdateDiverCapability(true));
				return;
			}

			if (InventoryUtil.fullArmorSet(serverPlayer, TechnologicaArmorMaterials.SCUBA)) {
				((IMixinMaxAir) serverPlayer).setMaxAirSupply(3000);
				if (!serverPlayer.getAttribute(net.minecraftforge.common.ForgeMod.SWIM_SPEED.get()).hasModifier(SCUBA_SPEED)) {
					serverPlayer.getAttribute(net.minecraftforge.common.ForgeMod.SWIM_SPEED.get()).addPermanentModifier(SCUBA_SPEED);
				}
				return;
			}

			((IMixinMaxAir) serverPlayer).setMaxAirSupply(300);
			if (serverPlayer.getAttribute(net.minecraftforge.common.ForgeMod.SWIM_SPEED.get()).hasModifier(SNORKEL_SPEED)) {
				serverPlayer.getAttribute(net.minecraftforge.common.ForgeMod.SWIM_SPEED.get()).removeModifier(SNORKEL_SPEED);
			}
			if (serverPlayer.getAttribute(net.minecraftforge.common.ForgeMod.SWIM_SPEED.get()).hasModifier(SCUBA_SPEED)) {
				serverPlayer.getAttribute(net.minecraftforge.common.ForgeMod.SWIM_SPEED.get()).removeModifier(SCUBA_SPEED);
			}
			TechnologicaAbilities diver = serverPlayer.getCapability(RegisterCapabilitiesEventListener.DIVER_INSTANCE).orElseThrow(NullPointerException::new);
			diver.setDiver(false);
			Technologica.CHANNEL.send(PacketDistributor.PLAYER.with(() -> serverPlayer), new UpdateDiverCapability(false));
		}
	}
}
