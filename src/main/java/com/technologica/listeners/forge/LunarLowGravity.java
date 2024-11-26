package com.technologica.listeners.forge;

import java.util.UUID;

import com.technologica.registration.dynamic.TechnologicaDimensions;

import net.minecraft.core.registries.Registries;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraftforge.common.ForgeMod;
import net.minecraftforge.event.entity.EntityJoinLevelEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;

@Mod.EventBusSubscriber(bus = EventBusSubscriber.Bus.FORGE)
public class LunarLowGravity {
	private static final UUID LUNAR_GRAVITY_ID = UUID.fromString("297dcaec-6b7d-11ee-b962-0242ac120002");
	private static final AttributeModifier LUNAR_GRAVITY = new AttributeModifier(LUNAR_GRAVITY_ID, "Lunar gravity reduction", -0.07, AttributeModifier.Operation.ADDITION);

	@SubscribeEvent
	public static void onEntityJoinLevelEvent(final EntityJoinLevelEvent event) {
		if (!event.getLevel().isClientSide()) {
			if (event.getEntity() instanceof LivingEntity) {
				LivingEntity livingEntity = (LivingEntity) event.getEntity();
				if (livingEntity.level().dimension().equals(Registries.levelStemToLevel(TechnologicaDimensions.MOON_STEM))) {
					if (!livingEntity.getAttribute(ForgeMod.ENTITY_GRAVITY.get()).hasModifier(LUNAR_GRAVITY)) {
						livingEntity.getAttribute(ForgeMod.ENTITY_GRAVITY.get()).addTransientModifier(LUNAR_GRAVITY);
					}
				} else {
					if (livingEntity.getAttribute(ForgeMod.ENTITY_GRAVITY.get()).hasModifier(LUNAR_GRAVITY)) {
						livingEntity.getAttribute(ForgeMod.ENTITY_GRAVITY.get()).removeModifier(LUNAR_GRAVITY_ID);
					}
				}
			}
		}
	}
}
