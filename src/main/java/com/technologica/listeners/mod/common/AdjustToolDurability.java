package com.technologica.listeners.mod.common;

import com.technologica.advancements.critereon.ObservedBlockTrigger;
import com.technologica.advancements.critereon.LitCampfireTrigger;
import com.technologica.config.TechnologicaConfigCommon;
import com.technologica.resourcegen.data.advancements.TechnologicaCriterionTriggers;
import com.technologica.world.item.TechnologicaTiers;

import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.world.item.Items;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;

@Mod.EventBusSubscriber(bus = EventBusSubscriber.Bus.MOD)
public final class AdjustToolDurability {

	@SubscribeEvent
	protected static final void onFMLCommonSetupEvent(final FMLCommonSetupEvent event) {
		event.enqueueWork(() -> {
			TechnologicaCriterionTriggers.BLOCK_OBSERVED = CriteriaTriggers.register(new ObservedBlockTrigger());
			TechnologicaCriterionTriggers.LIGHT_CAMPFIRE = CriteriaTriggers.register(new LitCampfireTrigger());
			if (TechnologicaConfigCommon.ADJUST_TOOL_DURABILITY.get()) {
				Items.WOODEN_SWORD.maxDamage = TechnologicaTiers.WOOD.getUses();
				Items.WOODEN_SHOVEL.maxDamage = TechnologicaTiers.WOOD.getUses();
				Items.WOODEN_PICKAXE.maxDamage = TechnologicaTiers.WOOD.getUses();
				Items.WOODEN_AXE.maxDamage = TechnologicaTiers.WOOD.getUses();
				Items.WOODEN_HOE.maxDamage = TechnologicaTiers.WOOD.getUses();
				Items.STONE_SWORD.maxDamage = TechnologicaTiers.STONE.getUses();
				Items.STONE_SHOVEL.maxDamage = TechnologicaTiers.STONE.getUses();
				Items.STONE_PICKAXE.maxDamage = TechnologicaTiers.STONE.getUses();
				Items.STONE_AXE.maxDamage = TechnologicaTiers.STONE.getUses();
				Items.STONE_HOE.maxDamage = TechnologicaTiers.STONE.getUses();
				Items.IRON_SWORD.maxDamage = TechnologicaTiers.IRON.getUses();
				Items.IRON_SHOVEL.maxDamage = TechnologicaTiers.IRON.getUses();
				Items.IRON_PICKAXE.maxDamage = TechnologicaTiers.IRON.getUses();
				Items.IRON_AXE.maxDamage = TechnologicaTiers.IRON.getUses();
				Items.IRON_HOE.maxDamage = TechnologicaTiers.IRON.getUses();
				Items.DIAMOND_SWORD.maxDamage = TechnologicaTiers.DIAMOND.getUses();
				Items.DIAMOND_SHOVEL.maxDamage = TechnologicaTiers.DIAMOND.getUses();
				Items.DIAMOND_PICKAXE.maxDamage = TechnologicaTiers.DIAMOND.getUses();
				Items.DIAMOND_AXE.maxDamage = TechnologicaTiers.DIAMOND.getUses();
				Items.DIAMOND_HOE.maxDamage = TechnologicaTiers.DIAMOND.getUses();
				Items.NETHERITE_SWORD.maxDamage = TechnologicaTiers.NETHERITE.getUses();
				Items.NETHERITE_SHOVEL.maxDamage = TechnologicaTiers.NETHERITE.getUses();
				Items.NETHERITE_PICKAXE.maxDamage = TechnologicaTiers.NETHERITE.getUses();
				Items.NETHERITE_AXE.maxDamage = TechnologicaTiers.NETHERITE.getUses();
				Items.NETHERITE_HOE.maxDamage = TechnologicaTiers.NETHERITE.getUses();
			}
		});
	}
}
