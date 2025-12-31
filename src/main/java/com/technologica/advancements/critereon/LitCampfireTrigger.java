package com.technologica.advancements.critereon;

import com.google.common.collect.ImmutableSet;
import com.google.gson.JsonObject;
import com.technologica.util.text.TechnologicaLocation;

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

public class LitCampfireTrigger extends SimpleCriterionTrigger<LitCampfireTrigger.TriggerInstance> {
	private static final ResourceLocation ID = new TechnologicaLocation("lit_campfire");

	@Override
	public ResourceLocation getId() {
		return ID;
	}

	@Override
	public LitCampfireTrigger.TriggerInstance createInstance(JsonObject jsonObject, ContextAwarePredicate contextAwarePredicate, DeserializationContext deserializationContext) {
		ItemPredicate itemPredicate = ItemPredicate.fromJson(jsonObject.get("item"));
		return new LitCampfireTrigger.TriggerInstance(contextAwarePredicate, itemPredicate);
	}

	public void trigger(ServerPlayer serverPlayer, ItemStack itemStack) {
		this.trigger(serverPlayer, (triggerInstance) -> triggerInstance.matches(itemStack));
	}

	public static class TriggerInstance extends AbstractCriterionTriggerInstance {
		private final ItemPredicate itemPredicate;

		public TriggerInstance(ContextAwarePredicate contextAwarePredicate, ItemPredicate itemPredicate) {
			super(LitCampfireTrigger.ID, contextAwarePredicate);
			this.itemPredicate = itemPredicate;
		}

		public static LitCampfireTrigger.TriggerInstance litCampfire(ItemLike itemLike) {
			return new LitCampfireTrigger.TriggerInstance(ContextAwarePredicate.ANY, new ItemPredicate((TagKey<Item>) null, ImmutableSet.of(itemLike.asItem()), MinMaxBounds.Ints.ANY, MinMaxBounds.Ints.ANY, EnchantmentPredicate.NONE, EnchantmentPredicate.NONE, (Potion) null, NbtPredicate.ANY));
		}

		public boolean matches(ItemStack itemStack) {
			return this.itemPredicate.matches(itemStack);
		}

		@Override
		public JsonObject serializeToJson(SerializationContext serializationContext) {
			JsonObject jsonobject = super.serializeToJson(serializationContext);
			jsonobject.add("item", this.itemPredicate.serializeToJson());
			return jsonobject;
		}
	}
}
