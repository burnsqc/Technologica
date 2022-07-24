package com.technologica.listeners;

import com.technologica.world.item.TechnologicaItems;

import net.minecraft.client.Minecraft;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Explosion;
import net.minecraft.world.level.Level;
import net.minecraftforge.event.entity.living.LivingDamageEvent;
import net.minecraftforge.event.entity.living.LivingEvent.LivingJumpEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class NitroPocket {

	@SubscribeEvent
	public void onLivingJumpEvent(LivingJumpEvent event) {
		if (event.getEntity() instanceof ServerPlayer) {
			Minecraft mc = Minecraft.getInstance();

			if (mc.options.keyJump.isDown()) {
				Player player = (Player) event.getEntity();
				Level level = player.getLevel();
				for (int i = 0; i < player.getInventory().getContainerSize(); ++i) {
					ItemStack testStack = player.getInventory().getItem(i);
					if (testStack.getItem() == TechnologicaItems.NITROGLYCERIN_ITEM.get()) {
						if (level.getRandom().nextBoolean()) {
							level.explode(null, player.getX(), player.getY(), player.getZ(), 4.0F, Explosion.BlockInteraction.BREAK);
						}
					}
				}
			}
		}
	}

	@SubscribeEvent
	public void onLivingDamageEvent(LivingDamageEvent event) {
		if (event.getEntity() instanceof Player) {
			Player player = (Player) event.getEntity();
			Level level = player.getLevel();
			for (int i = 0; i < player.getInventory().getContainerSize(); ++i) {
				ItemStack testStack = player.getInventory().getItem(i);
				if (testStack.getItem() == TechnologicaItems.NITROGLYCERIN_ITEM.get()) {
					if (event.getSource() == DamageSource.IN_FIRE || event.getSource() == DamageSource.ON_FIRE || event.getSource() == DamageSource.LAVA || event.getSource() == DamageSource.LIGHTNING_BOLT || event.getSource() == DamageSource.HOT_FLOOR || event.getSource().isExplosion()) {
						player.getInventory().removeItem(testStack);
						level.explode(null, player.getX(), player.getY(), player.getZ(), 4.0F, Explosion.BlockInteraction.BREAK);
					} else if (level.getRandom().nextBoolean()) {
						player.getInventory().removeItem(testStack);
						level.explode(null, player.getX(), player.getY(), player.getZ(), 4.0F, Explosion.BlockInteraction.BREAK);
					}
				}
			}
		}
	}
}