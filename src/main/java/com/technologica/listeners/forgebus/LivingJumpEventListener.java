package com.technologica.listeners.forgebus;

import com.technologica.registration.deferred.TechnologicaItems;
import com.technologica.registration.key.TechnologicaDamageTypes;
import com.technologica.setup.common.TechnologicaConfigCommon;
import com.technologica.util.InventoryUtil;

import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.ExplosionDamageCalculator;
import net.minecraft.world.level.Level;
import net.minecraftforge.event.entity.living.LivingEvent.LivingJumpEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;

@Mod.EventBusSubscriber(bus = EventBusSubscriber.Bus.FORGE)
public class LivingJumpEventListener {

	/**
	 * <p>
	 * With a 25% chance, explode when jumping if this feature is enabled in the common config.
	 * </p>
	 * 
	 * @param event LivingJumpEvent
	 */
	@SubscribeEvent
	public static void onLivingJumpEvent(final LivingJumpEvent event) {
		if (TechnologicaConfigCommon.NITRO_JOSTLE.get()) {
			if (event.getEntity() instanceof ServerPlayer) {
				Player player = (Player) event.getEntity();
				if (!player.getAbilities().instabuild) {
					// TODO There's got to be a better way. This throws error left, right, and center. It doesn't crash anything but it sure doesn't work as intended.
					// Minecraft minecraft = Minecraft.getInstance();
					// if (minecraft.options.keyJump.isDown()) {
					Level level = player.level();
					if (InventoryUtil.playerHas(player, TechnologicaItems.NITROGLYCERIN_ITEM.get())) {
						if (level.getRandom().nextInt(4) == 0) {
							InventoryUtil.shrinkStack(player, TechnologicaItems.NITROGLYCERIN_ITEM.get());
							level.explode(null, level.damageSources().source(TechnologicaDamageTypes.NITRO_BLAST), (ExplosionDamageCalculator) null, player.getX(), player.getY(), player.getZ(), 4.0F, false, Level.ExplosionInteraction.TNT);
						}
					}
					// }
				}
			}
		}
	}
}
