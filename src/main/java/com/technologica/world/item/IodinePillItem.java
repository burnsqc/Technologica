package com.technologica.world.item;

import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.stats.Stats;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class IodinePillItem extends Item {
	public IodinePillItem(Item.Properties p_42921_) {
		super(p_42921_);
	}

	@Override
	public ItemStack finishUsingItem(ItemStack p_42923_, Level p_42924_, LivingEntity p_42925_) {
		if (!p_42924_.isClientSide) {
			if (!p_42925_.curePotionEffects(p_42923_)) {
				p_42925_.addEffect(new MobEffectInstance(MobEffects.HUNGER, 300, 2));
				p_42925_.addEffect(new MobEffectInstance(MobEffects.CONFUSION, 300, 2));
			}
		}
		if (p_42925_ instanceof ServerPlayer serverplayer) {
			CriteriaTriggers.CONSUME_ITEM.trigger(serverplayer, p_42923_);
			serverplayer.awardStat(Stats.ITEM_USED.get(this));
		}

		if (p_42925_ instanceof Player && !((Player) p_42925_).getAbilities().instabuild) {
			p_42923_.shrink(1);
		}

		return p_42923_.isEmpty() ? ItemStack.EMPTY : p_42923_;
	}
}