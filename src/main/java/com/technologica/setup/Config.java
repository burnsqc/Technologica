package com.technologica.setup;

import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber
public final class Config {
	public static final ForgeConfigSpec.Builder BUILDER = new ForgeConfigSpec.Builder();
	public static final ForgeConfigSpec SPEC;
	
	public static final ForgeConfigSpec.ConfigValue<Boolean> disable_vanilla_plank_recipes;

	static {
		BUILDER.push("Technologica Common Config");
		
		disable_vanilla_plank_recipes = BUILDER.comment("true replaces all plank recipes with sawmill crafting, false allows vanilla plank recipes for all vanilla and technologica planks.").define("Disable Vanilla Plank Recipes", true);
		
		BUILDER.pop();
		SPEC = BUILDER.build();
	}
}