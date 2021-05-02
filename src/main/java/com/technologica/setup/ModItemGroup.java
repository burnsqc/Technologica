package com.technologica.setup;

import java.util.function.Supplier;

import com.technologica.MainMod;

import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = MainMod.MODID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class ModItemGroup extends ItemGroup {
	private Supplier<ItemStack> icon;
	public static final ModItemGroup TECHNOLOGICA_FLORA = new ModItemGroup("technologica_flora", () -> new ItemStack(Registration.BANANA_SAPLING.get()));
	public static final ModItemGroup TECHNOLOGICA_FAUNA = new ModItemGroup("technologica_fauna", () -> new ItemStack(Registration.DUCK_SPAWN_EGG.get()));
	public static final ModItemGroup TECHNOLOGICA_MINERAL = new ModItemGroup("technologica_mineral", () -> new ItemStack(Registration.AQUAMARINE_CRYSTAL.get()));
	public static final ModItemGroup TECHNOLOGICA_FOOD = new ModItemGroup("technologica_food", () -> new ItemStack(Registration.BANANA.get()));
	public static final ModItemGroup TECHNOLOGICA_DECORATIVE = new ModItemGroup("technologica_decorative", () -> new ItemStack(Registration.DISPLAY_CASE.get()));
	public static final ModItemGroup TECHNOLOGICA_CRYPTICA = new ModItemGroup("technologica_cryptica", () -> new ItemStack(Registration.ANCIENT_AMBROSIA_SAPLING.get()));
	
	public ModItemGroup(String labelIn, Supplier<ItemStack> iconIn) {
		super(labelIn);
		this.icon = iconIn;
	}

	@Override
	public ItemStack createIcon() {
		return icon.get();
	}
}
