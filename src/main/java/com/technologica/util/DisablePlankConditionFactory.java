package com.technologica.util;

import com.google.gson.JsonObject;
import com.technologica.Technologica;
import com.technologica.setup.Config;

import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.common.crafting.conditions.ICondition;
import net.minecraftforge.common.crafting.conditions.IConditionSerializer;

public class DisablePlankConditionFactory implements ICondition {
	private static final ResourceLocation ID = new ResourceLocation(Technologica.MODID, "disable_vanilla_plank_crafting");
	
	@Override
	public ResourceLocation getID() {
		return ID;
	}

	@Override
	public boolean test() {
		return Config.disable_vanilla_plank_recipes.get();
	}
	
	public static class Serializer implements IConditionSerializer<DisablePlankConditionFactory> {
		public static final Serializer INSTANCE = new Serializer();

		@Override
		public void write(JsonObject json, DisablePlankConditionFactory value) {
		}

		@Override
		public DisablePlankConditionFactory read(JsonObject json) {
			 return new DisablePlankConditionFactory();
		}

		@Override
		public ResourceLocation getID() {
			return DisablePlankConditionFactory.ID;
		}
		
	}
	
}