package com.technologica.listeners.forge;

import com.technologica.listeners.mod.common.RegisterCapabilitiesEventListener;
import com.technologica.setup.common.TechnologicaConfigCommon;
import com.technologica.world.entity.player.TechnologicaAbilities;

import net.minecraft.tags.BlockTags;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.AxeItem;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraftforge.common.ForgeMod;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;

@Mod.EventBusSubscriber(bus = EventBusSubscriber.Bus.FORGE)
public class PlayerEventListener {

	/**
	 * This method effectively disables log drops when using any item other than an axe by setting CanHarvest to false if this feature in enabled in the common config.
	 * 
	 * @param event
	 */
	@SubscribeEvent
	public static void onHarvestCheck(final PlayerEvent.HarvestCheck event) {
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
	public static void onBreakSpeed(final PlayerEvent.BreakSpeed event) {
		Player player = event.getEntity();
		float speed = event.getOriginalSpeed();
		if (player.isEyeInFluidType(ForgeMod.WATER_TYPE.get()) && !EnchantmentHelper.hasAquaAffinity(player)) {
			TechnologicaAbilities diver = player.getCapability(RegisterCapabilitiesEventListener.DIVER_INSTANCE).orElseThrow(NullPointerException::new);
			if (diver.getDiver()) {
				event.setNewSpeed(speed *= 5.0F);
			}
		}
	}

	@SubscribeEvent
	public static void onClone(final PlayerEvent.Clone event) {
		if (event.isWasDeath()) {
			event.getOriginal().reviveCaps();
			TechnologicaAbilities diverOld = event.getOriginal().getCapability(RegisterCapabilitiesEventListener.DIVER_INSTANCE).orElseThrow(NullPointerException::new);
			TechnologicaAbilities diverNew = event.getEntity().getCapability(RegisterCapabilitiesEventListener.DIVER_INSTANCE).orElseThrow(NullPointerException::new);
			diverNew.setDiver(diverOld.getDiver());
			event.getOriginal().invalidateCaps();
		}
	}
}
