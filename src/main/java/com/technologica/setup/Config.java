package com.technologica.setup;

import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber
public final class Config {
	public static final ForgeConfigSpec.Builder BUILDER = new ForgeConfigSpec.Builder();
	public static final ForgeConfigSpec SPEC;

	public static final ForgeConfigSpec.ConfigValue<Boolean> disable_vanilla_log_harvesting;
	public static final ForgeConfigSpec.ConfigValue<Boolean> disable_vanilla_plank_recipes;
	public static final ForgeConfigSpec.ConfigValue<Boolean> naughty_nautical_nanners;

	static {
		BUILDER.push("Technologica Common Config");

		disable_vanilla_log_harvesting = BUILDER.comment("true disables log drops when broken without appropriate tool, false retains vanilla mechanics.").define("Disable Vanilla Log Harvesting", true);
		disable_vanilla_plank_recipes = BUILDER.comment("true replaces all plank recipes with sawmill crafting, false retains vanilla mechanics.").define("Disable Vanilla Plank Recipes", true);
		naughty_nautical_nanners = BUILDER.comment("true yields no fish when fishing if the player has bananas in their inventory.").define("Naughty Nautical Nanners", true);

		BUILDER.pop();
		SPEC = BUILDER.build();
	}
}
