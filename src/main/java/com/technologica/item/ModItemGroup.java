package com.technologica.item;

import java.util.function.Supplier;

import com.technologica.Technologica;
import com.technologica.block.ModBlocks;

import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = Technologica.MODID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class ModItemGroup extends ItemGroup {
	private Supplier<ItemStack> icon;
	public static final ModItemGroup FLORA = new ModItemGroup("flora", () -> new ItemStack(ModBlocks.BANANA_SAPLING.get()));
	public static final ModItemGroup FAUNA = new ModItemGroup("fauna", () -> new ItemStack(ModItems.DUCK_SPAWN_EGG.get()));
	public static final ModItemGroup MINERAL = new ModItemGroup("mineral", () -> new ItemStack(ModBlocks.AQUAMARINE_CRYSTAL.get()));
	public static final ModItemGroup FOOD = new ModItemGroup("food", () -> new ItemStack(ModItems.BANANA.get()));
	public static final ModItemGroup MACHINERY = new ModItemGroup("machinery", () -> new ItemStack(ModItems.WRENCH.get()));
	public static final ModItemGroup DECORATIVE = new ModItemGroup("decorative", () -> new ItemStack(ModBlocks.DISPLAY_CASE.get()));
	public static final ModItemGroup CRYPTICA = new ModItemGroup("cryptica", () -> new ItemStack(ModBlocks.ANCIENT_AMBROSIA_SAPLING.get()));
	
	public ModItemGroup(String labelIn, Supplier<ItemStack> iconIn) {
		super(labelIn);
		this.icon = iconIn;
	}

	@Override
	public ItemStack createIcon() {
		return icon.get();
	}
}
