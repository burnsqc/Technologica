package com.technologica.listeners.forgebus;

import java.util.List;

import com.technologica.registration.deferred.TechnologicaItems;

import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.npc.VillagerTrades;
import net.minecraft.world.entity.npc.VillagerTrades.ItemListing;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.trading.MerchantOffer;
import net.minecraftforge.event.village.WandererTradesEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class WandererTradesEventListener {

	@SubscribeEvent
	public void onVillagerTradesEvent(WandererTradesEvent event) { // NO_UCD (unused code)
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
		private final List<Item> gems = List.of(Items.EMERALD, TechnologicaItems.RUBY.get(), TechnologicaItems.SAPPHIRE.get(), TechnologicaItems.TOPAZ.get());
		private final ItemStack itemStack;
		private final int gemCost;
		private final int numberOfItems;
		private final int maxUses;
		private final int villagerXp;
		private final float priceMultiplier;

		public ItemsForEmeralds(Item p_35746_, int p_35747_, int p_35748_, int p_35749_, int p_35750_) {
			this(new ItemStack(p_35746_), p_35747_, p_35748_, p_35749_, p_35750_);
		}

		public ItemsForEmeralds(ItemStack p_35752_, int p_35753_, int p_35754_, int p_35755_, int p_35756_) {
			this(p_35752_, p_35753_, p_35754_, p_35755_, p_35756_, 0.05F);
		}

		public ItemsForEmeralds(ItemStack p_35758_, int p_35759_, int p_35760_, int p_35761_, int p_35762_, float p_35763_) {
			this.itemStack = p_35758_;
			this.gemCost = p_35759_;
			this.numberOfItems = p_35760_;
			this.maxUses = p_35761_;
			this.villagerXp = p_35762_;
			this.priceMultiplier = p_35763_;
		}

		@Override
		public MerchantOffer getOffer(Entity p_35771_, RandomSource randomSource) {
			return new MerchantOffer(new ItemStack(gems.get(randomSource.nextInt(gems.size())), this.gemCost), new ItemStack(this.itemStack.getItem(), this.numberOfItems), this.maxUses, this.villagerXp, this.priceMultiplier);
		}
	}
}