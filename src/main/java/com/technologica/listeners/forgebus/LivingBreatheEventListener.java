package com.technologica.listeners.forgebus;

import com.technologica.capabilities.TechnologicaCapabilities;
import com.technologica.capabilities.air.IAir;

import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.living.LivingBreatheEvent;
import net.minecraftforge.event.entity.living.LivingDrownEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class LivingBreatheEventListener {

	@SubscribeEvent
	public void onLivingBreatheEvent(LivingBreatheEvent event) {
		if (event.getEntity() instanceof Player) {
			Player player = (Player) event.getEntity();
			IAir airCapability = player.getCapability(TechnologicaCapabilities.INSTANCE).orElseThrow(NullPointerException::new);
			int newMaxAir = airCapability.getNewMaxAir();

			if (newMaxAir == 6000) {

				boolean isAir = player.getEyeInFluidType().isAir() || player.level().getBlockState(BlockPos.containing(player.getX(), player.getEyeY(), player.getZ())).is(Blocks.BUBBLE_COLUMN);

				if (event.canBreathe()) {
					event.setCanBreathe(false);
					if (event.canRefillAir()) {
						player.setAirSupply(Math.min(player.getAirSupply() + event.getRefillAirAmount(), newMaxAir));
					}
				} else {
					player.setAirSupply(player.getAirSupply() - event.getConsumeAirAmount());
				}

				if (player.getAirSupply() <= 0) {
					LivingDrownEvent drownEvent = new LivingDrownEvent(player, player.getAirSupply() <= -20, 2.0F, 8);
					if (!MinecraftForge.EVENT_BUS.post(drownEvent) && drownEvent.isDrowning()) {
						player.setAirSupply(0);
						Vec3 vec3 = player.getDeltaMovement();

						for (int i = 0; i < drownEvent.getBubbleCount(); ++i) {
							double d2 = player.getRandom().nextDouble() - player.getRandom().nextDouble();
							double d3 = player.getRandom().nextDouble() - player.getRandom().nextDouble();
							double d4 = player.getRandom().nextDouble() - player.getRandom().nextDouble();
							player.level().addParticle(ParticleTypes.BUBBLE, player.getX() + d2, player.getY() + d3, player.getZ() + d4, vec3.x, vec3.y, vec3.z);
						}

						if (drownEvent.getDamageAmount() > 0)
							player.hurt(player.damageSources().drown(), drownEvent.getDamageAmount());
					}
				}

				if (!isAir && !player.level().isClientSide && player.isPassenger() && player.getVehicle() != null && !player.getVehicle().canBeRiddenUnderFluidType(player.getEyeInFluidType(), player)) {
					player.stopRiding();
				}
			}
		}
	}
}