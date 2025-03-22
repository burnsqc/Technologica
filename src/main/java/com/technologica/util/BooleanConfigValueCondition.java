package com.technologica.util;

import com.google.gson.JsonObject;
import com.technologica.config.TechnologicaConfigCommon;
import com.technologica.util.text.TechnologicaLocation;

import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.common.crafting.conditions.ICondition;
import net.minecraftforge.common.crafting.conditions.IConditionSerializer;

public class BooleanConfigValueCondition implements ICondition {
	private static final ResourceLocation NAME = new TechnologicaLocation("config_boolean_condition");

	@Override
	public ResourceLocation getID() {
		return NAME;
	}

	@Override
	public boolean test(IContext context) {
		return TechnologicaConfigCommon.DISABLE_VANILLA_PLANK_RECIPES.get();
	}
	
	@Override
    public String toString()
    {
		return "boolean_config_value(" + TechnologicaConfigCommon.DISABLE_VANILLA_PLANK_RECIPES.toString() + ")";
    }

	public static class Serializer implements IConditionSerializer<BooleanConfigValueCondition> {
		public static final Serializer INSTANCE = new Serializer();

		@Override
		public void write(JsonObject json, BooleanConfigValueCondition value) {
		}

		@Override
		public BooleanConfigValueCondition read(JsonObject json) {
			return new BooleanConfigValueCondition();
		}

		@Override
		public ResourceLocation getID() {
			return BooleanConfigValueCondition.NAME;
		}
	}
}
