package com.technologica.listeners.forgebus;

import com.technologica.setup.config.TechnologicaConfigCommon;
import com.technologica.setup.listeners.TechnologicaCapabilities;
import com.technologica.world.entity.player.TechnologicaAbilities;

import net.minecraft.tags.BlockTags;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.AxeItem;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraftforge.common.ForgeMod;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class PlayerEventListener {

	/**
	 * This method effectively disables log drops when using any item other than an axe by setting CanHarvest to false if this feature in enabled in the common config.
	 * 
	 * @param event
	 */
	@SubscribeEvent
	public void onHarvestCheck(final PlayerEvent.HarvestCheck event) {
		if (TechnologicaConfigCommon.DISABLE_VANILLA_LOG_HARVESTING.get()) {
			if (event.getTargetBlock().is(BlockTags.LOGS) && !(event.getEntity().getMainHandItem().getItem() instanceof AxeItem)) {
				event.setCanHarvest(false);
			}
		}
	}

	/**
	 * This method negates the tool slow down in {@linkplain Player#getDigSpeed} if you're wearing a full dive suit.
	 * 
	 * @param event
	 */
	@SubscribeEvent
	public void onBreakSpeed(final PlayerEvent.BreakSpeed event) {
		Player player = event.getEntity();
		float speed = event.getOriginalSpeed();
		if (player.isEyeInFluidType(ForgeMod.WATER_TYPE.get()) && !EnchantmentHelper.hasAquaAffinity(player)) {
			TechnologicaAbilities diver = player.getCapability(TechnologicaCapabilities.DIVER_INSTANCE).orElseThrow(NullPointerException::new);
			if (diver.getDiver()) {
				event.setNewSpeed(speed *= 5.0F);
			}
		}
	}
}
