package com.technologica.listeners;

import com.technologica.world.item.TechnologicaItems;

import net.minecraft.client.Minecraft;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Explosion;
import net.minecraft.world.level.Level;
import net.minecraftforge.event.entity.living.LivingEvent.LivingJumpEvent;
import net.minecraftforge.event.entity.living.LivingFallEvent;
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
					if (testStack.getItem() == TechnologicaItems.NITRO_ITEM.get()) {
						if (level.getRandom().nextBoolean()) {
							level.explode(null, player.getX(), player.getY(), player.getZ(), 4.0F,
									Explosion.BlockInteraction.BREAK);
						}
					}
				}
			}
		}
	}

	@SubscribeEvent
	public void onLivingFallEvent(LivingFallEvent event) {
		if (event.getEntity().level.dimension().toString().contains("technologica:moon")) {
			event.setDamageMultiplier(0F);
		}
	}
}