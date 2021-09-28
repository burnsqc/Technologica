package com.technologica.item;

import java.util.function.Supplier;

import com.technologica.Technologica;
import com.technologica.block.TechnologicaBlocks;

import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = Technologica.MODID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class TechnologicaItemGroup extends ItemGroup {
	private Supplier<ItemStack> icon;
	public static final TechnologicaItemGroup FLORA = new TechnologicaItemGroup("flora", () -> new ItemStack(TechnologicaBlocks.BANANA_SAPLING.get()));
	public static final TechnologicaItemGroup FAUNA = new TechnologicaItemGroup("fauna", () -> new ItemStack(TechnologicaItems.DUCK_SPAWN_EGG.get()));
	public static final TechnologicaItemGroup MINERAL = new TechnologicaItemGroup("mineral", () -> new ItemStack(TechnologicaBlocks.AQUAMARINE_CRYSTAL.get()));
	public static final TechnologicaItemGroup FOOD = new TechnologicaItemGroup("food", () -> new ItemStack(TechnologicaItems.BANANA.get()));
	public static final TechnologicaItemGroup CONSTRUCTION = new TechnologicaItemGroup("construction", () -> new ItemStack(TechnologicaBlocks.CHERRY_PLANKS.get()));
	public static final TechnologicaItemGroup MACHINERY = new TechnologicaItemGroup("machinery", () -> new ItemStack(TechnologicaItems.WRENCH.get()));
	public static final TechnologicaItemGroup DECORATIVE = new TechnologicaItemGroup("decorative", () -> new ItemStack(TechnologicaBlocks.DISPLAY_CASE.get()));
	public static final TechnologicaItemGroup CRYPTICA = new TechnologicaItemGroup("cryptica", () -> new ItemStack(TechnologicaBlocks.ANCIENT_AMBROSIA_SAPLING.get()));
	
	public TechnologicaItemGroup(String labelIn, Supplier<ItemStack> iconIn) {
		super(labelIn);
		this.icon = iconIn;
	}

	@Override
	public ItemStack createIcon() {
		return icon.get();
	}
}
