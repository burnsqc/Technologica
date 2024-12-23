package com.technologica.resourcegen.data.advancements;

import javax.annotation.Nullable;

import com.google.gson.JsonObject;
import com.google.gson.JsonSyntaxException;
import com.technologica.world.item.SawItem;

import net.minecraft.advancements.critereon.AbstractCriterionTriggerInstance;
import net.minecraft.advancements.critereon.BlockPredicate;
import net.minecraft.advancements.critereon.ContextAwarePredicate;
import net.minecraft.advancements.critereon.DeserializationContext;
import net.minecraft.advancements.critereon.SerializationContext;
import net.minecraft.advancements.critereon.SimpleCriterionTrigger;
import net.minecraft.core.BlockPos;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.util.GsonHelper;
import net.minecraft.world.item.AxeItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.state.BlockState;

public class AttemptedHarvestTrigger extends SimpleCriterionTrigger<AttemptedHarvestTrigger.TriggerInstance> {
	static final ResourceLocation ID = new ResourceLocation("attempted_harvest");

	@Override
	public ResourceLocation getId() {
		return ID;
	}

	@Override
	public AttemptedHarvestTrigger.TriggerInstance createInstance(JsonObject jsonObject, ContextAwarePredicate contextAwarePredicate, DeserializationContext p_286840_) {
		BlockPredicate block = BlockPredicate.fromJson(jsonObject);
		Item item = deserializeItem(jsonObject);
		return new AttemptedHarvestTrigger.TriggerInstance(contextAwarePredicate, block, item);
	}

	@SuppressWarnings("deprecation")
	@Nullable
	private static Item deserializeItem(JsonObject jsonObject) {
		if (jsonObject.has("item")) {
			ResourceLocation resourcelocation = new ResourceLocation(GsonHelper.getAsString(jsonObject, "item"));
			return BuiltInRegistries.ITEM.getOptional(resourcelocation).orElseThrow(() -> {
				return new JsonSyntaxException("Unknown item type '" + resourcelocation + "'");
			});
		} else {
			return null;
		}
	}

	public void trigger(ServerPlayer serverPlayer, BlockState blockState, ItemStack itemStack) {
		this.trigger(serverPlayer, (triggerInstance) -> {
			return triggerInstance.matches((ServerLevel) serverPlayer.level(), serverPlayer.blockPosition());
		});
	}

	public static class TriggerInstance extends AbstractCriterionTriggerInstance {
		@Nullable
		private final BlockPredicate block;
		private final Item item;

		public TriggerInstance(ContextAwarePredicate contextAwarePredicate, @Nullable BlockPredicate logs, Item itemPredicate) {
			super(AttemptedHarvestTrigger.ID, contextAwarePredicate);
			this.block = logs;
			this.item = itemPredicate;
		}

		public static AttemptedHarvestTrigger.TriggerInstance destroyedBlock(BlockPredicate logs, Item item) {
			return new AttemptedHarvestTrigger.TriggerInstance(ContextAwarePredicate.ANY, logs, item);
		}

		public boolean matches(ServerLevel serverLevel, BlockPos blockPos) {
			if (this.block != null && !block.matches(serverLevel, blockPos)) {
				return false;
			} else {
				return (this.item instanceof AxeItem || this.item instanceof SawItem) ? false : true;
			}
		}

		@SuppressWarnings("deprecation")
		@Override
		public JsonObject serializeToJson(SerializationContext serializationContext) {
			JsonObject jsonobject = super.serializeToJson(serializationContext);
			jsonobject.add("block", this.block.serializeToJson());
			jsonobject.addProperty("item", BuiltInRegistries.ITEM.getKey(this.item).toString());
			return jsonobject;
		}
	}
}
