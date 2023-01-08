package com.technologica.listeners.modbus;

import java.util.List;

import com.technologica.Technologica;
import com.technologica.world.item.TechnologicaItems;

import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.event.CreativeModeTabEvent;

public class TechnologicaCreativeModeTabs {
	public static CreativeModeTab FLORA;
	public static CreativeModeTab FAUNA;
	public static CreativeModeTab MINERAL;
	public static CreativeModeTab FOOD;
	public static CreativeModeTab CONSTRUCTION;
	public static CreativeModeTab MACHINERY;
	public static CreativeModeTab DECORATIVE;
	public static CreativeModeTab ARMORY;
	public static CreativeModeTab CRYPTICA;
	
	public static void onRegisterCreativeModeTabs(final CreativeModeTabEvent.Register event) {
		FLORA = event.registerCreativeModeTab(new ResourceLocation(Technologica.MODID, "flora"), List.of(), List.of(CreativeModeTabs.SPAWN_EGGS), builder -> builder
					.title(Component.translatable("item_group." + Technologica.MODID + ".flora"))
					.icon(() -> new ItemStack(TechnologicaItems.COCONUT_SAPLING_ITEM.get()))
					.withBackgroundLocation(new ResourceLocation(Technologica.MODID, "textures/gui/container/creative_inventory/tab_flora.png"))
					.withTabsImage(new ResourceLocation(Technologica.MODID, "textures/gui/container/creative_inventory/technologica_tabs.png"))
					.withLabelColor(0)
					.displayItems((enabledFlags, populator, hasPermissions) -> {
						populator.accept(TechnologicaItems.BARLEY_SEEDS.get());
					})
				);
		
		FAUNA = event.registerCreativeModeTab(new ResourceLocation(Technologica.MODID, "fauna"), List.of(), List.of(FLORA), builder -> builder
					.title(Component.translatable("item_group." + Technologica.MODID + ".fauna"))
					.icon(() -> new ItemStack(TechnologicaItems.PIRANHA_BUCKET.get()))
					.withBackgroundLocation(new ResourceLocation(Technologica.MODID, "textures/gui/container/creative_inventory/tab_fauna.png"))
					.withTabsImage(new ResourceLocation(Technologica.MODID, "textures/gui/container/creative_inventory/technologica_tabs.png"))
					.withLabelColor(0)
					.displayItems((enabledFlags, populator, hasPermissions) -> {
						populator.accept(TechnologicaItems.ALLIGATOR_SPAWN_EGG.get());
					})	
				);
		
		MINERAL = event.registerCreativeModeTab(new ResourceLocation(Technologica.MODID, "mineral"), List.of(), List.of(FAUNA), builder -> builder
					.title(Component.translatable("item_group." + Technologica.MODID + ".mineral"))
					.icon(() -> new ItemStack(TechnologicaItems.GERMANIUM_CHUNK.get()))
					.withBackgroundLocation(new ResourceLocation(Technologica.MODID, "textures/gui/container/creative_inventory/tab_mineral.png"))
					.withTabsImage(new ResourceLocation(Technologica.MODID, "textures/gui/container/creative_inventory/technologica_tabs.png"))
					.withLabelColor(0)
					.displayItems((enabledFlags, populator, hasPermissions) -> {
						populator.accept(TechnologicaItems.SALT_ITEM.get());
					})	
				);
		
		FOOD = event.registerCreativeModeTab(new ResourceLocation(Technologica.MODID, "food"), List.of(), List.of(MINERAL), builder -> builder
					.title(Component.translatable("item_group." + Technologica.MODID + ".food"))
					.icon(() -> new ItemStack(TechnologicaItems.BANANA.get()))
					.withBackgroundLocation(new ResourceLocation(Technologica.MODID, "textures/gui/container/creative_inventory/tab_food.png"))
					.withTabsImage(new ResourceLocation(Technologica.MODID, "textures/gui/container/creative_inventory/technologica_tabs.png"))
					.withLabelColor(0)
					.displayItems((enabledFlags, populator, hasPermissions) -> {
						populator.accept(TechnologicaItems.BARLEY.get());
					})	
				);
		
		CONSTRUCTION = event.registerCreativeModeTab(new ResourceLocation(Technologica.MODID, "construction"), List.of(), List.of(FOOD), builder -> builder
					.title(Component.translatable("item_group." + Technologica.MODID + ".construction"))
					.icon(() -> new ItemStack(TechnologicaItems.GLUE_BOTTLE.get()))
					.withBackgroundLocation(new ResourceLocation(Technologica.MODID, "textures/gui/container/creative_inventory/tab_construction.png"))
					.withTabsImage(new ResourceLocation(Technologica.MODID, "textures/gui/container/creative_inventory/technologica_tabs.png"))
					.withLabelColor(0)
					.displayItems((enabledFlags, populator, hasPermissions) -> {
						populator.accept(TechnologicaItems.APRICOT_LOG_ITEM.get());
					})	
				);
		
		MACHINERY = event.registerCreativeModeTab(new ResourceLocation(Technologica.MODID, "machinery"), List.of(), List.of(CONSTRUCTION), builder -> builder
					.title(Component.translatable("item_group." + Technologica.MODID + ".machinery"))
					.icon(() -> new ItemStack(TechnologicaItems.PIPE_WRENCH.get()))
					.withBackgroundLocation(new ResourceLocation(Technologica.MODID, "textures/gui/container/creative_inventory/tab_machinery.png"))
					.withTabsImage(new ResourceLocation(Technologica.MODID, "textures/gui/container/creative_inventory/technologica_tabs.png"))
					.withLabelColor(0)
					.displayItems((enabledFlags, populator, hasPermissions) -> {
						populator.accept(TechnologicaItems.LINE_SHAFT_HANGER_ITEM.get());
						populator.accept(TechnologicaItems.MOTOR_1HP_ITEM.get());
						populator.accept(TechnologicaItems.MOTOR_5HP_ITEM.get());
						populator.accept(TechnologicaItems.MOTOR_20HP_ITEM.get());
						populator.accept(TechnologicaItems.SAWMILL_ITEM.get());
						populator.accept(TechnologicaItems.ANNUNCIATOR_ITEM.get());
						populator.accept(TechnologicaItems.STEEL_SHAFT.get());
						populator.accept(TechnologicaItems.SMALL_PULLEY_ITEM.get());
						populator.accept(TechnologicaItems.MEDIUM_PULLEY_ITEM.get());
						populator.accept(TechnologicaItems.LARGE_PULLEY_ITEM.get());
						populator.accept(TechnologicaItems.PULLEY_BELT.get());
						populator.accept(TechnologicaItems.SAWBLADE.get());
						populator.accept(TechnologicaItems.OVERLAY_PASS_ITEM.get());
						populator.accept(TechnologicaItems.OVERLAY_WARN_ITEM.get());
						populator.accept(TechnologicaItems.OVERLAY_FAIL_ITEM.get());
						populator.accept(TechnologicaItems.SAWMILL_BLUEPRINT.get());
						populator.accept(TechnologicaItems.CHISEL.get());
						populator.accept(TechnologicaItems.HAMMER.get());
						populator.accept(TechnologicaItems.SAW.get());
						populator.accept(TechnologicaItems.PIPE_WRENCH.get());
						populator.accept(TechnologicaItems.WRENCH.get());
					})	
				);
		
		DECORATIVE = event.registerCreativeModeTab(new ResourceLocation(Technologica.MODID, "decorative"), List.of(), List.of(MACHINERY), builder -> builder
					.title(Component.translatable("item_group." + Technologica.MODID + ".decorative"))
					.icon(() -> new ItemStack(TechnologicaItems.DISPLAY_CASE_ITEM.get()))
					.withBackgroundLocation(new ResourceLocation(Technologica.MODID, "textures/gui/container/creative_inventory/tab_decorative.png"))
					.withTabsImage(new ResourceLocation(Technologica.MODID, "textures/gui/container/creative_inventory/technologica_tabs.png"))
					.withLabelColor(0)
					.displayItems((enabledFlags, populator, hasPermissions) -> {
						populator.accept(TechnologicaItems.DISPLAY_CASE_ITEM.get());
						populator.accept(TechnologicaItems.ACACIA_CHAIR_ITEM.get());
						populator.accept(TechnologicaItems.APRICOT_CHAIR_ITEM.get());
						populator.accept(TechnologicaItems.ASPEN_CHAIR_ITEM.get());
						populator.accept(TechnologicaItems.AVOCADO_CHAIR_ITEM .get());
						populator.accept(TechnologicaItems.BANANA_CHAIR_ITEM.get());
						populator.accept(TechnologicaItems.BIRCH_CHAIR_ITEM.get());
						populator.accept(TechnologicaItems.CHERRY_CHAIR_ITEM.get());
						populator.accept(TechnologicaItems.CHESTNUT_CHAIR_ITEM.get());
						populator.accept(TechnologicaItems.CINNAMON_CHAIR_ITEM.get());
						populator.accept(TechnologicaItems.COCONUT_CHAIR_ITEM.get());
						populator.accept(TechnologicaItems.CRIMSON_CHAIR_ITEM.get());
						populator.accept(TechnologicaItems.DARK_OAK_CHAIR_ITEM.get());
						populator.accept(TechnologicaItems.EBONY_CHAIR_ITEM.get());
						populator.accept(TechnologicaItems.JUNGLE_CHAIR_ITEM.get());
						populator.accept(TechnologicaItems.KIWI_CHAIR_ITEM.get());
						populator.accept(TechnologicaItems.LEMON_CHAIR_ITEM.get());
						populator.accept(TechnologicaItems.LIME_CHAIR_ITEM.get());
						populator.accept(TechnologicaItems.MAHOGANY_CHAIR_ITEM.get());
						populator.accept(TechnologicaItems.MAPLE_CHAIR_ITEM.get());
						populator.accept(TechnologicaItems.OAK_CHAIR_ITEM.get());
						populator.accept(TechnologicaItems.OLIVE_CHAIR_ITEM.get());
						populator.accept(TechnologicaItems.ORANGE_CHAIR_ITEM.get());
						populator.accept(TechnologicaItems.PEACH_CHAIR_ITEM.get());
						populator.accept(TechnologicaItems.PEAR_CHAIR_ITEM.get());
						populator.accept(TechnologicaItems.PLUM_CHAIR_ITEM.get());
						populator.accept(TechnologicaItems.REDWOOD_CHAIR_ITEM.get());
						populator.accept(TechnologicaItems.ROSEWOOD_CHAIR_ITEM.get());
						populator.accept(TechnologicaItems.RUBBER_CHAIR_ITEM.get());
						populator.accept(TechnologicaItems.SPRUCE_CHAIR_ITEM.get());
						populator.accept(TechnologicaItems.TEAK_CHAIR_ITEM.get());
						populator.accept(TechnologicaItems.WALNUT_CHAIR_ITEM.get());
						populator.accept(TechnologicaItems.WARPED_CHAIR_ITEM.get());
						populator.accept(TechnologicaItems.ZEBRAWOOD_CHAIR_ITEM.get());
						populator.accept(TechnologicaItems.FROSTBITTEN_CHAIR_ITEM.get());
						populator.accept(TechnologicaItems.ACACIA_TABLE_ITEM.get());
						populator.accept(TechnologicaItems.APRICOT_TABLE_ITEM.get());
						populator.accept(TechnologicaItems.ASPEN_TABLE_ITEM.get());
						populator.accept(TechnologicaItems.AVOCADO_TABLE_ITEM.get());
						populator.accept(TechnologicaItems.BANANA_TABLE_ITEM.get());
						populator.accept(TechnologicaItems.BIRCH_TABLE_ITEM.get());
						populator.accept(TechnologicaItems.CHERRY_TABLE_ITEM.get());
						populator.accept(TechnologicaItems.CHESTNUT_TABLE_ITEM.get());
						populator.accept(TechnologicaItems.CINNAMON_TABLE_ITEM.get());
						populator.accept(TechnologicaItems.COCONUT_TABLE_ITEM.get());
						populator.accept(TechnologicaItems.CRIMSON_TABLE_ITEM.get());
						populator.accept(TechnologicaItems.DARK_OAK_TABLE_ITEM.get());
						populator.accept(TechnologicaItems.EBONY_TABLE_ITEM.get());
						populator.accept(TechnologicaItems.JUNGLE_TABLE_ITEM.get());
						populator.accept(TechnologicaItems.KIWI_TABLE_ITEM.get());
						populator.accept(TechnologicaItems.LEMON_TABLE_ITEM.get());
						populator.accept(TechnologicaItems.LIME_TABLE_ITEM.get());
						populator.accept(TechnologicaItems.MAHOGANY_TABLE_ITEM.get());
						populator.accept(TechnologicaItems.MAPLE_TABLE_ITEM.get());
						populator.accept(TechnologicaItems.OAK_TABLE_ITEM.get());
						populator.accept(TechnologicaItems.OLIVE_TABLE_ITEM.get());
						populator.accept(TechnologicaItems.ORANGE_TABLE_ITEM.get());
						populator.accept(TechnologicaItems.PEACH_TABLE_ITEM.get());
						populator.accept(TechnologicaItems.PEAR_TABLE_ITEM.get());
						populator.accept(TechnologicaItems.PLUM_TABLE_ITEM.get());
						populator.accept(TechnologicaItems.REDWOOD_TABLE_ITEM.get());
						populator.accept(TechnologicaItems.ROSEWOOD_TABLE_ITEM.get());
						populator.accept(TechnologicaItems.RUBBER_TABLE_ITEM.get());
						populator.accept(TechnologicaItems.SPRUCE_TABLE_ITEM.get());
						populator.accept(TechnologicaItems.TEAK_TABLE_ITEM.get());
						populator.accept(TechnologicaItems.WALNUT_TABLE_ITEM.get());
						populator.accept(TechnologicaItems.WARPED_TABLE_ITEM.get());
						populator.accept(TechnologicaItems.ZEBRAWOOD_TABLE_ITEM.get());
						populator.accept(TechnologicaItems.FROSTBITTEN_TABLE_ITEM.get());
					})	
				);
			
		ARMORY = event.registerCreativeModeTab(new ResourceLocation(Technologica.MODID, "armory"), List.of(), List.of(DECORATIVE), builder -> builder
					.title(Component.translatable("item_group." + Technologica.MODID + ".armory"))
					.icon(() -> new ItemStack(TechnologicaItems.NAVAL_MINE.get()))
					.withBackgroundLocation(new ResourceLocation(Technologica.MODID, "textures/gui/container/creative_inventory/tab_armory.png"))
					.withTabsImage(new ResourceLocation(Technologica.MODID, "textures/gui/container/creative_inventory/technologica_tabs.png"))
					.withLabelColor(0)
					.displayItems((enabledFlags, populator, hasPermissions) -> {
						populator.accept(TechnologicaItems.PRIMITIVE_DAGGER.get());
						populator.accept(TechnologicaItems.PRIMITIVE_PICKAXE.get());
						populator.accept(TechnologicaItems.PRIMITIVE_HOE.get());
						populator.accept(TechnologicaItems.PRIMITIVE_SHOVEL.get());
						populator.accept(TechnologicaItems.PRIMITIVE_HATCHET.get());
						populator.accept(TechnologicaItems.COCONUT_BAZOOKA_ITEM.get());
						populator.accept(TechnologicaItems.SPEAR_GUN_ITEM.get());
						populator.accept(TechnologicaItems.HARPOON.get());
						populator.accept(TechnologicaItems.DODGEBALL_ITEM.get());
						populator.accept(TechnologicaItems.NITROGLYCERIN_ITEM.get());
						populator.accept(TechnologicaItems.LAND_MINE.get());
						populator.accept(TechnologicaItems.NAVAL_MINE.get());
						populator.accept(TechnologicaItems.ROCKET.get());
						populator.accept(TechnologicaItems.SNORKEL_HELMET.get());
						populator.accept(TechnologicaItems.SNORKEL_SUIT.get());
						populator.accept(TechnologicaItems.SNORKEL_PANTS.get());
						populator.accept(TechnologicaItems.SNORKEL_BOOTS.get());
						populator.accept(TechnologicaItems.DIVE_HELMET.get());
						populator.accept(TechnologicaItems.DIVE_SUIT.get());
						populator.accept(TechnologicaItems.DIVE_PANTS.get());
						populator.accept(TechnologicaItems.DIVE_BOOTS.get());
						populator.accept(TechnologicaItems.SCUBA_HELMET.get());
						populator.accept(TechnologicaItems.SCUBA_SUIT.get());
						populator.accept(TechnologicaItems.SCUBA_PANTS.get());
						populator.accept(TechnologicaItems.SCUBA_BOOTS.get());
						populator.accept(TechnologicaItems.HAZMAT_HOOD.get());
						populator.accept(TechnologicaItems.HAZMAT_SUIT.get());
						populator.accept(TechnologicaItems.HAZMAT_PANTS.get());
						populator.accept(TechnologicaItems.HAZMAT_BOOTS.get());
						populator.accept(TechnologicaItems.SPACE_HELMET.get());
						populator.accept(TechnologicaItems.SPACE_SUIT.get());
						populator.accept(TechnologicaItems.SPACE_PANTS.get());
						populator.accept(TechnologicaItems.SPACE_BOOTS.get());
					})	
				);
		
		CRYPTICA = event.registerCreativeModeTab(new ResourceLocation(Technologica.MODID, "cryptica"), List.of(), List.of(ARMORY), builder -> builder
					.title(Component.translatable("item_group." + Technologica.MODID + ".cryptica"))
					.icon(() -> new ItemStack(TechnologicaItems.PERSISTENT_GLARE.get()))
					.withBackgroundLocation(new ResourceLocation(Technologica.MODID, "textures/gui/container/creative_inventory/tab_cryptica.png"))
					.withTabsImage(new ResourceLocation(Technologica.MODID, "textures/gui/container/creative_inventory/technologica_tabs.png"))
					.withLabelColor(0)
					.displayItems((enabledFlags, populator, hasPermissions) -> {
						populator.accept(TechnologicaItems.PERSISTENT_GLARE.get());
						populator.accept(TechnologicaItems.SINGULARITY_GRANULE.get());
					})
				);	
	}
}
