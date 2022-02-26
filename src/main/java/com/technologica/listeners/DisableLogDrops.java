package com.technologica.listeners;

import com.technologica.setup.Config;

import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.AxeItem;
import net.minecraft.tags.BlockTags;
import net.minecraftforge.event.entity.player.PlayerEvent.HarvestCheck;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class DisableLogDrops {

	@SubscribeEvent
	public void onHarvestCheck(HarvestCheck event) {
		BlockState blockState = event.getTargetBlock();
		Player player = event.getPlayer();
		
		if (Config.disable_vanilla_log_harvesting.get()) {
			if (blockState.is(BlockTags.LOGS) && !(player.getMainHandItem().getItem() instanceof AxeItem)) {
				event.setCanHarvest(false);
			}
		}
	}
}
