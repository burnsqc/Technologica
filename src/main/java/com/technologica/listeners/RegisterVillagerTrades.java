package com.technologica.listeners;

import java.util.List;
import java.util.Random;

import com.technologica.world.item.TechnologicaItems;

import it.unimi.dsi.fastutil.ints.Int2ObjectMap;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.npc.VillagerProfession;
import net.minecraft.world.entity.npc.VillagerTrades;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.trading.MerchantOffer;
import net.minecraft.world.level.ItemLike;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class RegisterVillagerTrades {

	@SubscribeEvent
	public static void onVillagerTradesEvent(final net.minecraftforge.event.village.VillagerTradesEvent event) {
		if (event.getType() == VillagerProfession.FARMER) {
			Int2ObjectMap<List<VillagerTrades.ItemListing>> trades = event.getTrades();
			ItemStack stack = new ItemStack(TechnologicaItems.BARLEY.get(), 12);
			trades.get(1).add((trader, rand) -> new MerchantOffer(new ItemStack(Items.EMERALD, 20), stack, 20, 16, 0.02F));
			// trades.get(1).add(new EmeraldForItems(TechnologicaItems.BARLEY.get(), 20, 16, 2));
		}
	}

	static class EmeraldForItems implements VillagerTrades.ItemListing {
		private final Item item;
		private final int cost;
		private final int maxUses;
		private final int villagerXp;
		private final float priceMultiplier;

		public EmeraldForItems(ItemLike p_35657_, int p_35658_, int p_35659_, int p_35660_) {
			this.item = p_35657_.asItem();
			this.cost = p_35658_;
			this.maxUses = p_35659_;
			this.villagerXp = p_35660_;
			this.priceMultiplier = 0.05F;
		}

		@Override
		public MerchantOffer getOffer(Entity p_35662_, Random p_35663_) {
			ItemStack itemstack = new ItemStack(this.item, this.cost);
			return new MerchantOffer(itemstack, new ItemStack(Items.EMERALD), this.maxUses, this.villagerXp, this.priceMultiplier);
		}
	}
}