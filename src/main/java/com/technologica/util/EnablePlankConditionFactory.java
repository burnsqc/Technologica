package com.technologica.util;

import com.google.gson.JsonObject;
import com.technologica.Technologica;
import com.technologica.setup.Config;

import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.common.crafting.conditions.ICondition;
import net.minecraftforge.common.crafting.conditions.IConditionSerializer;

public class EnablePlankConditionFactory implements ICondition {
	private static final ResourceLocation ID = new ResourceLocation(Technologica.MODID, "enable_vanilla_plank_crafting");
	
	@Override
	public ResourceLocation getID() {
		return ID;
	}

	@Override
	public boolean test() {
		return !Config.disable_vanilla_plank_recipes.get();
	}
	
	public static class Serializer implements IConditionSerializer<EnablePlankConditionFactory> {
		public static final Serializer INSTANCE = new Serializer();

		@Override
		public void write(JsonObject json, EnablePlankConditionFactory value) {
		}

		@Override
		public EnablePlankConditionFactory read(JsonObject json) {
			 return new EnablePlankConditionFactory();
		}

		@Override
		public ResourceLocation getID() {
			return EnablePlankConditionFactory.ID;
		}
		
	}
	
}