package com.technologica.resourcegen.data.advancements;

import javax.annotation.Nullable;

import com.google.gson.JsonObject;

import net.minecraft.advancements.critereon.AbstractCriterionTriggerInstance;
import net.minecraft.advancements.critereon.BlockPredicate;
import net.minecraft.advancements.critereon.ContextAwarePredicate;
import net.minecraft.advancements.critereon.DeserializationContext;
import net.minecraft.advancements.critereon.SerializationContext;
import net.minecraft.advancements.critereon.SimpleCriterionTrigger;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;

public class BlockObservedTrigger extends SimpleCriterionTrigger<BlockObservedTrigger.TriggerInstance> {
	static final ResourceLocation ID = new ResourceLocation("block_observed");

	@Override
	public ResourceLocation getId() {
		return ID;
	}

	@Override
	public BlockObservedTrigger.TriggerInstance createInstance(JsonObject jsonObject, ContextAwarePredicate contextAwarePredicate, DeserializationContext p_286840_) {
		BlockPredicate block = BlockPredicate.fromJson(jsonObject.get("block"));
		return new BlockObservedTrigger.TriggerInstance(contextAwarePredicate, block);
	}

	public void trigger(ServerPlayer serverPlayer, BlockPos blockPos) {
		this.trigger(serverPlayer, (triggerInstance) -> {
			return triggerInstance.matches((ServerLevel) serverPlayer.level(), blockPos);
		});
	}

	public static class TriggerInstance extends AbstractCriterionTriggerInstance {
		@Nullable
		private final BlockPredicate block;

		public TriggerInstance(ContextAwarePredicate contextAwarePredicate, @Nullable BlockPredicate block) {
			super(BlockObservedTrigger.ID, contextAwarePredicate);
			this.block = block;
		}

		public static BlockObservedTrigger.TriggerInstance observedBlock(BlockPredicate block) {
			return new BlockObservedTrigger.TriggerInstance(ContextAwarePredicate.ANY, block);
		}

		public boolean matches(ServerLevel serverLevel, BlockPos blockPos) {
			if (this.block != null && !block.matches(serverLevel, blockPos)) {
				return false;
			}
			return true;
		}

		@Override
		public JsonObject serializeToJson(SerializationContext serializationContext) {
			JsonObject jsonobject = super.serializeToJson(serializationContext);
			jsonobject.add("block", this.block.serializeToJson());
			return jsonobject;
		}
	}
}
