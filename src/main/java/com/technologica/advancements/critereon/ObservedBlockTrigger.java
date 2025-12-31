package com.technologica.advancements.critereon;

import com.google.gson.JsonObject;
import com.technologica.util.text.TechnologicaLocation;

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

public class ObservedBlockTrigger extends SimpleCriterionTrigger<ObservedBlockTrigger.TriggerInstance> {
	private static final ResourceLocation ID = new TechnologicaLocation("observed_block");

	@Override
	public ResourceLocation getId() {
		return ID;
	}

	@Override
	public ObservedBlockTrigger.TriggerInstance createInstance(JsonObject jsonObject, ContextAwarePredicate contextAwarePredicate, DeserializationContext deserializationContext) {
		BlockPredicate blockPredicate = BlockPredicate.fromJson(jsonObject.get("block"));
		return new ObservedBlockTrigger.TriggerInstance(contextAwarePredicate, blockPredicate);
	}

	public void trigger(ServerPlayer serverPlayer, BlockPos blockPos) {
		this.trigger(serverPlayer, (triggerInstance) -> triggerInstance.matches((ServerLevel) serverPlayer.level(), blockPos));
	}

	public static class TriggerInstance extends AbstractCriterionTriggerInstance {
		private final BlockPredicate blockPredicate;

		public TriggerInstance(ContextAwarePredicate contextAwarePredicate, BlockPredicate blockPredicate) {
			super(ObservedBlockTrigger.ID, contextAwarePredicate);
			this.blockPredicate = blockPredicate;
		}

		public static ObservedBlockTrigger.TriggerInstance observedBlock(BlockPredicate blockPredicate) {
			return new ObservedBlockTrigger.TriggerInstance(ContextAwarePredicate.ANY, blockPredicate);
		}

		public boolean matches(ServerLevel serverLevel, BlockPos blockPos) {
			return this.blockPredicate.matches(serverLevel, blockPos);
		}

		@Override
		public JsonObject serializeToJson(SerializationContext serializationContext) {
			JsonObject jsonobject = super.serializeToJson(serializationContext);
			jsonobject.add("block", this.blockPredicate.serializeToJson());
			return jsonobject;
		}
	}
}
