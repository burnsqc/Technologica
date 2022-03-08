package com.technologica.item;

import com.technologica.Technologica;
import com.technologica.block.TechnologicaBlocks;

import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = Technologica.MODID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class TechnologicaItemGroup {
	
	public static final ItemGroup FLORA = new ItemGroup("flora") {
		@Override
		public ItemStack createIcon() {
			return new ItemStack(TechnologicaBlocks.BANANA_SAPLING.get());
		}
	}.setBackgroundImage(new ResourceLocation(Technologica.MODID, "textures/gui/container/creative_inventory/tab_flora.png"));
	
	public static final ItemGroup FAUNA = new ItemGroup("fauna") {
		@Override
		public ItemStack createIcon() {
			return new ItemStack(TechnologicaItems.BEAVER_SPAWN_EGG.get());
		}
	}.setBackgroundImage(new ResourceLocation(Technologica.MODID, "textures/gui/container/creative_inventory/tab_fauna.png"));
	
	public static final ItemGroup MINERAL = new ItemGroup("mineral") {
		@Override
		public ItemStack createIcon() {
			return new ItemStack(TechnologicaBlocks.AQUAMARINE_CRYSTAL.get());
		}
	}.setBackgroundImage(new ResourceLocation(Technologica.MODID, "textures/gui/container/creative_inventory/tab_mineral.png"));
	
	public static final ItemGroup FOOD = new ItemGroup("food") {
		@Override
		public ItemStack createIcon() {
			return new ItemStack(TechnologicaItems.BANANA.get());
		}
	}.setBackgroundImage(new ResourceLocation(Technologica.MODID, "textures/gui/container/creative_inventory/tab_food.png"));
	
	public static final ItemGroup CONSTRUCTION = new ItemGroup("construction") {
		@Override
		public ItemStack createIcon() {
			return new ItemStack(TechnologicaBlocks.CHERRY_PLANKS.get());
		}
	}.setBackgroundImage(new ResourceLocation(Technologica.MODID, "textures/gui/container/creative_inventory/tab_construction.png"));
	
	public static final ItemGroup MACHINERY = new ItemGroup("machinery") {
		@Override
		public ItemStack createIcon() {
			return new ItemStack(TechnologicaItems.WRENCH.get());
		}
	}.setBackgroundImage(new ResourceLocation(Technologica.MODID, "textures/gui/container/creative_inventory/tab_machinery.png"));
	
	public static final ItemGroup DECORATIVE = new ItemGroup("decorative") {
		@Override
		public ItemStack createIcon() {
			return new ItemStack(TechnologicaBlocks.DISPLAY_CASE.get());
		}
	}.setBackgroundImage(new ResourceLocation(Technologica.MODID, "textures/gui/container/creative_inventory/tab_decorative.png"));
	
	public static final ItemGroup ARMORY = new ItemGroup("armory") {
		@Override
		public ItemStack createIcon() {
			return new ItemStack(TechnologicaItems.COCONUT_BAZOOKA_ITEM.get());
		}
	}.setBackgroundImage(new ResourceLocation(Technologica.MODID, "textures/gui/container/creative_inventory/tab_armory.png"));
	
	public static final ItemGroup CRYPTICA = new ItemGroup("cryptica") {
		@Override
		public ItemStack createIcon() {
			return new ItemStack(TechnologicaBlocks.ANCIENT_AMBROSIA_SAPLING.get());
		}
	}.setBackgroundImage(new ResourceLocation(Technologica.MODID, "textures/gui/container/creative_inventory/tab_cryptica.png"));	
}
