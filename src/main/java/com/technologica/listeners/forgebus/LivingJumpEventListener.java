package com.technologica.listeners.forgebus;

import com.technologica.setup.Config;
import com.technologica.util.InventoryUtil;
import com.technologica.world.damagesource.TechnologicaDamageTypes;
import com.technologica.world.item.TechnologicaItems;

import net.minecraft.client.Minecraft;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.ExplosionDamageCalculator;
import net.minecraft.world.level.Level;
import net.minecraftforge.event.entity.living.LivingEvent.LivingJumpEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

/**
 * <p>
 * This class listens for LivingJumpEvent which is fired on the Forge event bus.
 * When the event is intercepted, the Nitro Jostle feature is invoked.
 * </p>
 * 
 * @tl.status GREEN
 */
public class LivingJumpEventListener {

	/**
	 * <p>
	 * With a 25% chance, explode when jumping if this feature is enabled in the common config.
	 * </p>
	 * 
	 * @param event LivingJumpEvent
	 */
	@SubscribeEvent
	public void onLivingJumpEvent(final LivingJumpEvent event) {
		if (Config.NITRO_JOSTLE.get()) {
			if (event.getEntity() instanceof ServerPlayer) {
				Player player = (Player) event.getEntity();
				if (!player.getAbilities().instabuild) {
					Minecraft minecraft = Minecraft.getInstance();
					if (minecraft.options.keyJump.isDown()) {
						Level level = player.level();
						if (InventoryUtil.playerHas(player, TechnologicaItems.NITROGLYCERIN_ITEM.get())) {
							if (level.getRandom().nextInt(4) == 0) {
								InventoryUtil.shrinkStack(player, TechnologicaItems.NITROGLYCERIN_ITEM.get());
								level.explode(null, level.damageSources().source(TechnologicaDamageTypes.NITRO_BLAST), (ExplosionDamageCalculator) null, player.getX(), player.getY(), player.getZ(), 4.0F, false, Level.ExplosionInteraction.TNT);
							}
						}
					}
				}
			}
		}
	}
}