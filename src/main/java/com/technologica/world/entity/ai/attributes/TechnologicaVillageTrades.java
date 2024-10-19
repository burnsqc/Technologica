package com.technologica.world.entity.ai.attributes;

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
import net.minecraft.world.level.ItemLike;

public class TechnologicaVillageTrades {
	public static final List<ItemListing> TRADES_FARMER = List.of(new EmeraldForItems(TechnologicaItems.BARLEY.get(), 20, 16, 2), new EmeraldForItems(TechnologicaItems.OATS.get(), 20, 16, 2), new EmeraldForItems(TechnologicaItems.RYE.get(), 20, 16, 2), new EmeraldForItems(TechnologicaItems.CORN.get(), 20, 16, 2), new EmeraldForItems(TechnologicaItems.RICE.get(), 20, 16, 2), new EmeraldForItems(TechnologicaItems.SWEET_POTATO.get(), 26, 16, 2), new EmeraldForItems(TechnologicaItems.GINGER.get(), 26, 16, 2), new EmeraldForItems(TechnologicaItems.PEANUT.get(), 26, 16, 2), new EmeraldForItems(TechnologicaItems.GARLIC.get(), 22, 16, 2), new EmeraldForItems(TechnologicaItems.ASPARAGUS.get(), 22, 16, 2), new EmeraldForItems(TechnologicaItems.COFFEE_BEANS.get(), 22, 16, 2), new EmeraldForItems(TechnologicaItems.RED_BEANS.get(), 22, 16, 2), new EmeraldForItems(TechnologicaItems.SOY_BEANS.get(), 22, 16, 2), new EmeraldForItems(TechnologicaItems.CHILI_PEPPER.get(), 22, 16, 2), new EmeraldForItems(TechnologicaItems.PEAS.get(), 22, 16, 2), new EmeraldForItems(TechnologicaItems.RADISH.get(), 15, 16, 2), new EmeraldForItems(TechnologicaItems.TURNIP.get(), 15, 16, 2), new EmeraldForItems(TechnologicaItems.ONION.get(), 15, 16, 2), new EmeraldForItems(TechnologicaItems.BROCCOLI.get(), 15, 16, 2), new EmeraldForItems(TechnologicaItems.CELERY.get(), 15, 16, 2), new EmeraldForItems(TechnologicaItems.LETTUCE.get(), 15, 16, 2), new EmeraldForItems(TechnologicaItems.MUSTARD_GREENS.get(), 15, 16, 2), new EmeraldForItems(TechnologicaItems.PURPLE_CABBAGE.get(), 15, 16, 2), new EmeraldForItems(TechnologicaItems.PINEAPPLE.get(), 15, 16, 2), new EmeraldForItems(TechnologicaItems.TEA_LEAF.get(), 15, 16, 2), new EmeraldForItems(TechnologicaItems.CUCUMBER.get(), 6, 12, 10), new EmeraldForItems(TechnologicaItems.SQUASH.get(), 6, 12, 10), new EmeraldForItems(TechnologicaItems.ZUCCHINI.get(), 6, 12, 10));
	public static final List<ItemListing> TRADES_BUTCHER = List.of(new EmeraldForItems(TechnologicaItems.BLACKBERRY.get(), 10, 2, 30), new EmeraldForItems(TechnologicaItems.BLUEBERRY.get(), 10, 2, 30), new EmeraldForItems(TechnologicaItems.RASPBERRY.get(), 10, 2, 30), new EmeraldForItems(TechnologicaItems.STRAWBERRY.get(), 10, 2, 30));

	static class EmeraldForItems implements VillagerTrades.ItemListing {
		private final List<Item> gems = List.of(Items.EMERALD, TechnologicaItems.RUBY.get(), TechnologicaItems.SAPPHIRE.get(), TechnologicaItems.TOPAZ.get());
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
		public MerchantOffer getOffer(Entity p_35662_, RandomSource randomSource) {
			ItemStack itemstack = new ItemStack(this.item, this.cost);
			return new MerchantOffer(itemstack, new ItemStack(gems.get(randomSource.nextInt(gems.size()))), this.maxUses, this.villagerXp, this.priceMultiplier);
		}
	}
}
