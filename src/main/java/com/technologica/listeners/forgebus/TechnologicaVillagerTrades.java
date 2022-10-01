package com.technologica.listeners.forgebus;

import java.util.List;

import com.technologica.world.item.TechnologicaItems;

import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.npc.VillagerTrades;
import net.minecraft.world.entity.npc.VillagerTrades.ItemListing;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.trading.MerchantOffer;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.event.village.WandererTradesEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class TechnologicaVillagerTrades {

	@SubscribeEvent
	public void onVillagerTradesEvent(final WandererTradesEvent event) {
		List<ItemListing> trades = event.getGenericTrades();
		trades.add(new ItemsForEmeralds(TechnologicaItems.BARLEY_SEEDS.get(), 1, 1, 12, 1));
		trades.add(new ItemsForEmeralds(TechnologicaItems.OATS_SEEDS.get(), 1, 1, 12, 1));
		trades.add(new ItemsForEmeralds(TechnologicaItems.RYE_SEEDS.get(), 1, 1, 12, 1));
		trades.add(new ItemsForEmeralds(TechnologicaItems.CORN_SEEDS.get(), 1, 1, 12, 1));
		trades.add(new ItemsForEmeralds(TechnologicaItems.RICE_SEEDS.get(), 1, 1, 12, 1));
		trades.add(new ItemsForEmeralds(TechnologicaItems.RADISH_SEEDS.get(), 1, 1, 12, 1));
		trades.add(new ItemsForEmeralds(TechnologicaItems.TURNIP_SEEDS.get(), 1, 1, 12, 1));
		trades.add(new ItemsForEmeralds(TechnologicaItems.ONION_SEEDS.get(), 1, 1, 12, 1));
		trades.add(new ItemsForEmeralds(TechnologicaItems.BROCCOLI_SEEDS.get(), 1, 1, 12, 1));
		trades.add(new ItemsForEmeralds(TechnologicaItems.CELERY_SEEDS.get(), 1, 1, 12, 1));
		trades.add(new ItemsForEmeralds(TechnologicaItems.LETTUCE_SEEDS.get(), 1, 1, 12, 1));
		trades.add(new ItemsForEmeralds(TechnologicaItems.MUSTARD_SEEDS.get(), 1, 1, 12, 1));
		trades.add(new ItemsForEmeralds(TechnologicaItems.PURPLE_CABBAGE_SEEDS.get(), 1, 1, 12, 1));
		trades.add(new ItemsForEmeralds(TechnologicaItems.PINEAPPLE_SEEDS.get(), 1, 1, 12, 1));
		trades.add(new ItemsForEmeralds(TechnologicaItems.TEA_SEEDS.get(), 1, 1, 12, 1));
		trades.add(new ItemsForEmeralds(TechnologicaItems.CUCUMBER_SEEDS.get(), 1, 1, 12, 1));
		trades.add(new ItemsForEmeralds(TechnologicaItems.SQUASH_SEEDS.get(), 1, 1, 12, 1));
		trades.add(new ItemsForEmeralds(TechnologicaItems.ZUCCHINI_SEEDS.get(), 1, 1, 12, 1));
	}

	static class ItemsForEmeralds implements VillagerTrades.ItemListing {
		private final ItemStack itemStack;
		private final int emeraldCost;
		private final int numberOfItems;
		private final int maxUses;
		private final int villagerXp;
		private final float priceMultiplier;

		public ItemsForEmeralds(Block p_35765_, int p_35766_, int p_35767_, int p_35768_, int p_35769_) {
			this(new ItemStack(p_35765_), p_35766_, p_35767_, p_35768_, p_35769_);
		}

		public ItemsForEmeralds(Item p_35741_, int p_35742_, int p_35743_, int p_35744_) {
			this(new ItemStack(p_35741_), p_35742_, p_35743_, 12, p_35744_);
		}

		public ItemsForEmeralds(Item p_35746_, int p_35747_, int p_35748_, int p_35749_, int p_35750_) {
			this(new ItemStack(p_35746_), p_35747_, p_35748_, p_35749_, p_35750_);
		}

		public ItemsForEmeralds(ItemStack p_35752_, int p_35753_, int p_35754_, int p_35755_, int p_35756_) {
			this(p_35752_, p_35753_, p_35754_, p_35755_, p_35756_, 0.05F);
		}

		public ItemsForEmeralds(ItemStack p_35758_, int p_35759_, int p_35760_, int p_35761_, int p_35762_, float p_35763_) {
			this.itemStack = p_35758_;
			this.emeraldCost = p_35759_;
			this.numberOfItems = p_35760_;
			this.maxUses = p_35761_;
			this.villagerXp = p_35762_;
			this.priceMultiplier = p_35763_;
		}

		@Override
		public MerchantOffer getOffer(Entity p_35771_, RandomSource p_35772_) {
			return new MerchantOffer(new ItemStack(Items.EMERALD, this.emeraldCost), new ItemStack(this.itemStack.getItem(), this.numberOfItems), this.maxUses, this.villagerXp, this.priceMultiplier);
		}
	}
}