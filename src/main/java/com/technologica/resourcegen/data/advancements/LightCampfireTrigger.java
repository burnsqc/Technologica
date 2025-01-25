package com.technologica.resourcegen.data.advancements;

import com.google.common.collect.ImmutableSet;
import com.google.gson.JsonObject;

import net.minecraft.advancements.critereon.AbstractCriterionTriggerInstance;
import net.minecraft.advancements.critereon.ContextAwarePredicate;
import net.minecraft.advancements.critereon.DeserializationContext;
import net.minecraft.advancements.critereon.EnchantmentPredicate;
import net.minecraft.advancements.critereon.ItemPredicate;
import net.minecraft.advancements.critereon.MinMaxBounds;
import net.minecraft.advancements.critereon.NbtPredicate;
import net.minecraft.advancements.critereon.SerializationContext;
import net.minecraft.advancements.critereon.SimpleCriterionTrigger;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.alchemy.Potion;
import net.minecraft.world.level.ItemLike;

public class LightCampfireTrigger extends SimpleCriterionTrigger<LightCampfireTrigger.TriggerInstance> {
	static final ResourceLocation ID = new ResourceLocation("lit_campfire");

	@Override
	public ResourceLocation getId() {
		return ID;
	}

	@Override
	public LightCampfireTrigger.TriggerInstance createInstance(JsonObject pJson, ContextAwarePredicate pPredicate, DeserializationContext pDeserializationContext) {
		return new LightCampfireTrigger.TriggerInstance(pPredicate, ItemPredicate.fromJson(pJson.get("item")));
	}

	public void trigger(ServerPlayer pPlayer, ItemStack pItem) {
		this.trigger(pPlayer, (p_23687_) -> {
			return p_23687_.matches(pItem);
		});
	}

	public static class TriggerInstance extends AbstractCriterionTriggerInstance {
		private final ItemPredicate item;

		public TriggerInstance(ContextAwarePredicate pPlayer, ItemPredicate pItem) {
			super(LightCampfireTrigger.ID, pPlayer);
			this.item = pItem;
		}

		public static LightCampfireTrigger.TriggerInstance usedItem(ItemPredicate pItem) {
			return new LightCampfireTrigger.TriggerInstance(ContextAwarePredicate.ANY, pItem);
		}

		public static LightCampfireTrigger.TriggerInstance usedItem(ItemLike pItem) {
			return new LightCampfireTrigger.TriggerInstance(ContextAwarePredicate.ANY, new ItemPredicate((TagKey<Item>) null, ImmutableSet.of(pItem.asItem()), MinMaxBounds.Ints.ANY, MinMaxBounds.Ints.ANY, EnchantmentPredicate.NONE, EnchantmentPredicate.NONE, (Potion) null, NbtPredicate.ANY));
		}

		public boolean matches(ItemStack pItem) {
			return this.item.matches(pItem);
		}

		@Override
		public JsonObject serializeToJson(SerializationContext pConditions) {
			JsonObject jsonobject = super.serializeToJson(pConditions);
			jsonobject.add("item", this.item.serializeToJson());
			return jsonobject;
		}
	}
}