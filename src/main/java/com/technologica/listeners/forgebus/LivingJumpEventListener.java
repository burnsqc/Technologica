package com.technologica.listeners.forgebus;

import com.technologica.world.damagesource.TechnologicaDamageSource;
import com.technologica.world.item.TechnologicaItems;

import net.minecraft.client.Minecraft;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.ExplosionDamageCalculator;
import net.minecraft.world.level.Level;
import net.minecraftforge.event.entity.living.LivingEvent.LivingJumpEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class LivingJumpEventListener {

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
}