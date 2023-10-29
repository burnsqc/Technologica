package com.technologica.listeners.forgebus;

import java.util.UUID;

import com.technologica.capabilities.TechnologicaCapabilities;
import com.technologica.capabilities.air.IAir;
import com.technologica.world.item.TechnologicaItems;
import com.technologica.world.level.block.TechnologicaBlocks;

import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.ai.attributes.AttributeInstance;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.AirBlock;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.event.TickEvent.PlayerTickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class PlayerTickEventListener {
	private static final UUID SLOW_FALLING_ID = UUID.fromString("A5B6CF2A-2F7C-31EF-9022-7C3E7D5E6ABA");
	private static final AttributeModifier SLOW_FALLING = new AttributeModifier(SLOW_FALLING_ID, "Slow falling acceleration reduction", -0.07, AttributeModifier.Operation.ADDITION);

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
			if (newMaxAir == 6000) {
				if (!player.getAbilities().flying) {
					if (event.phase == TickEvent.Phase.START) {
						// BEGIN WATER UNDO
						Vec3 vec3 = new Vec3(player.xxa, player.yya, player.zza);

						double d0 = 0.08D;
						AttributeInstance gravity = player.getAttribute(net.minecraftforge.common.ForgeMod.ENTITY_GRAVITY.get());
						boolean flag = player.getDeltaMovement().y <= 0.0D;
						if (flag && player.hasEffect(MobEffects.SLOW_FALLING)) {
							if (!gravity.hasModifier(SLOW_FALLING))
								gravity.addTransientModifier(SLOW_FALLING);
						} else if (gravity.hasModifier(SLOW_FALLING)) {
							gravity.removeModifier(SLOW_FALLING);
						}
						d0 = gravity.getValue();

						FluidState fluidstate = player.level().getFluidState(player.blockPosition());
						if ((player.isInWater() || (player.isInFluidType(fluidstate) && fluidstate.getFluidType() != net.minecraftforge.common.ForgeMod.LAVA_TYPE.get())) && player.isAffectedByFluids() && !player.canStandOnFluid(fluidstate)) {
							if (player.isInWater() || (player.isInFluidType(fluidstate) && !player.moveInFluid(fluidstate, vec3, d0))) {

								BlockPos blockpos = player.getOnPos();
								float f2 = player.level().getBlockState(player.getOnPos()).getFriction(player.level(), player.getOnPos(), player);
								float f3 = player.onGround() ? f2 * 0.91F : 0.91F;
								Vec3 vec35 = player.handleRelativeFrictionAndCalculateMovement(vec3, f2);
								double d2 = vec35.y;
								if (player.hasEffect(MobEffects.LEVITATION)) {
									d2 += (0.05D * (player.getEffect(MobEffects.LEVITATION).getAmplifier() + 1) - vec35.y) * 0.2D;
								} else if (player.level().isClientSide && !player.level().hasChunkAt(blockpos)) {
									if (player.getY() > player.level().getMinBuildHeight()) {
										d2 = -0.1D;
									} else {
										d2 = 0.0D;
									}
								} else if (!player.isNoGravity()) {
									d2 -= d0;
								}

								if (player.shouldDiscardFriction()) {
									player.setDeltaMovement(vec35.x, d2, vec35.z);
								} else {
									player.setDeltaMovement(vec35.x * f3, d2 * 0.98F, vec35.z * f3);
								}
							}
						}
					}
				}
			}
		}
	}
}