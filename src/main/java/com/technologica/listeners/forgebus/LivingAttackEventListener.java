package com.technologica.listeners.forgebus;

import com.technologica.world.item.TechnologicaItems;

import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraftforge.event.entity.living.LivingAttackEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class LivingAttackEventListener {

	@SubscribeEvent
	public void onLivingDamageEvent(LivingAttackEvent event) {
		if (event.getEntity() instanceof ServerPlayer) {
			Player player = (Player) event.getEntity();
			Level level = player.level();
			if (!player.getAbilities().instabuild) {
				for (int i = 0; i < player.getInventory().getContainerSize(); ++i) {
					ItemStack testStack = player.getInventory().getItem(i);
					if (testStack.getItem() == TechnologicaItems.NITROGLYCERIN_ITEM.get()) {
						if (event.getSource() == level.damageSources().inFire() || event.getSource() == level.damageSources().onFire() || event.getSource() == level.damageSources().lava() || event.getSource() == level.damageSources().lightningBolt() || event.getSource() == level.damageSources().hotFloor() || event.getSource() == level.damageSources().explosion(null)) {
							player.getInventory().removeItem(testStack);
							// level.explode(null, TechnologicaDamageSource.NITRO_BLAST, (ExplosionDamageCalculator) null, player.getX(), player.getY(), player.getZ(), 4.0F, false, Level.ExplosionInteraction.TNT);
						} else if (level.getRandom().nextInt(4) == 0 && event.getSource() != level.damageSources().drown() && event.getSource() != level.damageSources().freeze() && event.getSource() != level.damageSources().starve()) {
							player.getInventory().removeItem(testStack);
							// level.explode(null, TechnologicaDamageSource.NITRO_BLAST, (ExplosionDamageCalculator) null, player.getX(), player.getY(), player.getZ(), 4.0F, false, Level.ExplosionInteraction.TNT);
						}
					}
				}
			}
		}
	}
}