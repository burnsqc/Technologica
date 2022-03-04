package com.technologica.world.item;

import com.technologica.Technologica;
import com.technologica.world.level.block.TechnologicaBlocks;

import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = Technologica.MODID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class TechnologicaItemGroup {
	
	public static final CreativeModeTab FLORA = new CreativeModeTab("flora") {
		@Override
		public ItemStack makeIcon() {
			return new ItemStack(TechnologicaBlocks.BANANA_SAPLING.get());
		}
	}.setBackgroundImage(new ResourceLocation(Technologica.MODID, "textures/gui/container/creative_inventory/tab_flora.png"));
	
	public static final CreativeModeTab FAUNA = new CreativeModeTab("fauna") {
		@Override
		public ItemStack makeIcon() {
			return new ItemStack(TechnologicaItems.BEAVER_SPAWN_EGG.get());
		}
	}.setBackgroundImage(new ResourceLocation(Technologica.MODID, "textures/gui/container/creative_inventory/tab_fauna.png"));
	
	public static final CreativeModeTab MINERAL = new CreativeModeTab("mineral") {
		@Override
		public ItemStack makeIcon() {
			return new ItemStack(TechnologicaBlocks.AQUAMARINE_CRYSTAL.get());
		}
	}.setBackgroundImage(new ResourceLocation(Technologica.MODID, "textures/gui/container/creative_inventory/tab_mineral.png"));
	
	public static final CreativeModeTab FOOD = new CreativeModeTab("food") {
		@Override
		public ItemStack makeIcon() {
			return new ItemStack(TechnologicaItems.BANANA.get());
		}
	}.setBackgroundImage(new ResourceLocation(Technologica.MODID, "textures/gui/container/creative_inventory/tab_food.png"));
	
	public static final CreativeModeTab CONSTRUCTION = new CreativeModeTab("construction") {
		@Override
		public ItemStack makeIcon() {
			return new ItemStack(TechnologicaBlocks.CHERRY_PLANKS.get());
		}
	}.setBackgroundImage(new ResourceLocation(Technologica.MODID, "textures/gui/container/creative_inventory/tab_construction.png"));
	
	public static final CreativeModeTab MACHINERY = new CreativeModeTab("machinery") {
		@Override
		public ItemStack makeIcon() {
			return new ItemStack(TechnologicaItems.WRENCH.get());
		}
	}.setBackgroundImage(new ResourceLocation(Technologica.MODID, "textures/gui/container/creative_inventory/tab_machinery.png"));
	
	public static final CreativeModeTab DECORATIVE = new CreativeModeTab("decorative") {
		@Override
		public ItemStack makeIcon() {
			return new ItemStack(TechnologicaBlocks.DISPLAY_CASE.get());
		}
	}.setBackgroundImage(new ResourceLocation(Technologica.MODID, "textures/gui/container/creative_inventory/tab_decorative.png"));
	
	public static final CreativeModeTab ARMORY = new CreativeModeTab("armory") {
		@Override
		public ItemStack makeIcon() {
			return new ItemStack(TechnologicaItems.COCONUT_BAZOOKA_ITEM.get());
		}
	}.setBackgroundImage(new ResourceLocation(Technologica.MODID, "textures/gui/container/creative_inventory/tab_armory.png"));
	
	public static final CreativeModeTab CRYPTICA = new CreativeModeTab("cryptica") {
		@Override
		public ItemStack makeIcon() {
			return new ItemStack(TechnologicaBlocks.ANCIENT_AMBROSIA_SAPLING.get());
		}
	}.setBackgroundImage(new ResourceLocation(Technologica.MODID, "textures/gui/container/creative_inventory/tab_cryptica.png"));	
}