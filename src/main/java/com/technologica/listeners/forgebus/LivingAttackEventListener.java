package com.technologica.listeners.forgebus;

import com.technologica.registration.deferred.TechnologicaItems;
import com.technologica.registration.key.TechnologicaDamageTypes;
import com.technologica.setup.Config;
import com.technologica.util.InventoryUtil;

import net.minecraft.server.level.ServerPlayer;
import net.minecraft.tags.DamageTypeTags;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.ExplosionDamageCalculator;
import net.minecraft.world.level.Level;
import net.minecraftforge.event.entity.living.LivingAttackEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

/**
 * <p>
 * This class listens for LivingAttackEvent which is fired on the Forge event bus.
 * When the event is intercepted, the Nitro Jostle feature is invoked.
 * </p>
 * 
 * @tl.status GREEN
 */
public class LivingAttackEventListener {

	/**
	 * <p>
	 * Explode if the player takes damage from anything fire related, lightning, or an explosion.
	 * With a 25% chance, explode from any damage source that is not drowning, freezing, or starving.
	 * </p>
	 * 
	 * @param event LivingAttackEvent
	 */
	@SubscribeEvent
	public void onLivingDamageEvent(final LivingAttackEvent event) {
		if (Config.NITRO_JOSTLE.get()) {
			if (event.getEntity() instanceof ServerPlayer) {
				Player player = (Player) event.getEntity();
				if (!player.getAbilities().instabuild) {
					Level level = player.level();
					if (InventoryUtil.playerHas(player, TechnologicaItems.NITROGLYCERIN_ITEM.get())) {
						if (event.getSource().is(DamageTypeTags.IS_FIRE) || event.getSource().is(DamageTypeTags.IS_LIGHTNING) || event.getSource().is(DamageTypeTags.IS_EXPLOSION)) {
							InventoryUtil.shrinkStack(player, TechnologicaItems.NITROGLYCERIN_ITEM.get());
							level.explode(null, level.damageSources().source(TechnologicaDamageTypes.NITRO_BLAST), (ExplosionDamageCalculator) null, player.getX(), player.getY(), player.getZ(), 4.0F, false, Level.ExplosionInteraction.TNT);
						} else if (level.getRandom().nextInt(4) == 0 && event.getSource() != level.damageSources().drown() && event.getSource() != level.damageSources().freeze() && event.getSource() != level.damageSources().starve()) {
							InventoryUtil.shrinkStack(player, TechnologicaItems.NITROGLYCERIN_ITEM.get());
							level.explode(null, level.damageSources().source(TechnologicaDamageTypes.NITRO_BLAST), (ExplosionDamageCalculator) null, player.getX(), player.getY(), player.getZ(), 4.0F, false, Level.ExplosionInteraction.TNT);
						}
					}
				}
			}
		}
	}
}