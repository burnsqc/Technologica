package com.technologica.setup;

import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber
public final class Config {
	public static final ForgeConfigSpec.Builder BUILDER = new ForgeConfigSpec.Builder();
	public static final ForgeConfigSpec SPEC;
	
	public static final ForgeConfigSpec.ConfigValue<Boolean> disable_vanilla_log_harvesting;
	
	static {
		BUILDER.push("Technologica Common Config");
		
		disable_vanilla_log_harvesting = BUILDER.comment("true disables log drops when broken without appropriate tool, false retains vanilla mechanics.").define("Disable Vanilla Log Harvesting", true);
		
		BUILDER.pop();
		SPEC = BUILDER.build();
	}
}