package com.technologica.listeners.forgebus;

import com.technologica.world.damagesource.TechnologicaDamageSource;
import com.technologica.world.item.TechnologicaItems;

import net.minecraft.client.Minecraft;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.ExplosionDamageCalculator;
import net.minecraft.world.level.Level;
import net.minecraftforge.event.entity.living.LivingAttackEvent;
import net.minecraftforge.event.entity.living.LivingEvent.LivingJumpEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class NitroPocket {

	@SubscribeEvent
	public void onLivingJumpEvent(LivingJumpEvent event) {
		if (event.getEntity() instanceof ServerPlayer) {
			Minecraft mc = Minecraft.getInstance();
			Player player = (Player) event.getEntity();
			if (mc.options.keyJump.isDown() && !player.getAbilities().instabuild) {
				Level level = player.getLevel();
				for (int i = 0; i < player.getInventory().getContainerSize(); ++i) {
					ItemStack testStack = player.getInventory().getItem(i);
					if (testStack.getItem() == TechnologicaItems.NITROGLYCERIN_ITEM.get()) {
						if (level.getRandom().nextInt(4) == 0) {
							level.explode(null, TechnologicaDamageSource.NITRO_BLAST, (ExplosionDamageCalculator) null, player.getX(), player.getY(), player.getZ(), 4.0F, false, Level.ExplosionInteraction.TNT);
						}
					}
				}
			}
		}
	}

	@SubscribeEvent
	public void onLivingDamageEvent(LivingAttackEvent event) {
		if (event.getEntity() instanceof ServerPlayer) {
			Player player = (Player) event.getEntity();
			Level level = player.getLevel();
			if (!player.getAbilities().instabuild) {
				for (int i = 0; i < player.getInventory().getContainerSize(); ++i) {
					ItemStack testStack = player.getInventory().getItem(i);
					if (testStack.getItem() == TechnologicaItems.NITROGLYCERIN_ITEM.get()) {
						if (event.getSource() == DamageSource.IN_FIRE || event.getSource() == DamageSource.ON_FIRE || event.getSource() == DamageSource.LAVA || event.getSource() == DamageSource.LIGHTNING_BOLT || event.getSource() == DamageSource.HOT_FLOOR || event.getSource().isExplosion()) {
							player.getInventory().removeItem(testStack);
							level.explode(null, TechnologicaDamageSource.NITRO_BLAST, (ExplosionDamageCalculator) null, player.getX(), player.getY(), player.getZ(), 4.0F, false, Level.ExplosionInteraction.TNT);
						} else if (level.getRandom().nextInt(4) == 0 && event.getSource() != DamageSource.DROWN && event.getSource() != DamageSource.FREEZE && event.getSource() != DamageSource.STARVE) {
							player.getInventory().removeItem(testStack);
							level.explode(null, TechnologicaDamageSource.NITRO_BLAST, (ExplosionDamageCalculator) null, player.getX(), player.getY(), player.getZ(), 4.0F, false, Level.ExplosionInteraction.TNT);
						}
					}
				}
			}
		}
	}
}