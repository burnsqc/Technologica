package com.technologica.block;

import java.util.Set;

import it.unimi.dsi.fastutil.objects.ObjectArraySet;
import net.minecraft.block.WoodType;

public class ModWoodType extends WoodType {
	private static final Set<WoodType> VALUES = new ObjectArraySet<>();
	public static final WoodType APRICOT = register(new ModWoodType("apricot"));
	public static final WoodType ASPEN = register(new ModWoodType("aspen"));
	public static final WoodType AVOCADO = register(new ModWoodType("avocado"));
   	public static final WoodType BANANA = register(new ModWoodType("banana"));
   	public static final WoodType CHERRY = register(new ModWoodType("cherry"));
   	public static final WoodType CHESTNUT = register(new ModWoodType("chestnut"));
   	public static final WoodType COCONUT = register(new ModWoodType("coconut"));
   	public static final WoodType EBONY = register(new ModWoodType("ebony"));
   	public static final WoodType KIWI = register(new ModWoodType("kiwi"));
   	public static final WoodType LEMON = register(new ModWoodType("lemon"));
   	public static final WoodType LIME = register(new ModWoodType("lime"));
   	public static final WoodType MAHOGANY = register(new ModWoodType("mahogany"));
   	public static final WoodType MAPLE = register(new ModWoodType("maple"));
   	public static final WoodType ORANGE = register(new ModWoodType("orange"));
   	public static final WoodType PEACH = register(new ModWoodType("peach"));
   	public static final WoodType PEAR = register(new ModWoodType("pear"));
   	public static final WoodType PLUM = register(new ModWoodType("plum"));
   	public static final WoodType REDWOOD = register(new ModWoodType("redwood"));
   	public static final WoodType ROSEWOOD = register(new ModWoodType("rosewood"));
   	public static final WoodType RUBBER = register(new ModWoodType("rubber"));
   	public static final WoodType TEAK = register(new ModWoodType("teak"));
   	public static final WoodType WALNUT = register(new ModWoodType("walnut"));
   	public static final WoodType ZEBRAWOOD = register(new ModWoodType("zebrawood"));
   	public static final WoodType ALCHEMICAL = register(new ModWoodType("alchemical"));
   	public static final WoodType BENEVOLENT = register(new ModWoodType("benevolent"));
   	public static final WoodType CONDUCTIVE = register(new ModWoodType("conductive"));
   	public static final WoodType FROSTBITTEN = register(new ModWoodType("frostbitten"));
   	public static final WoodType FRUITFUL = register(new ModWoodType("fruitful"));
   	public static final WoodType INFERNAL = register(new ModWoodType("infernal"));
   	public static final WoodType MALEVOLENT = register(new ModWoodType("malevolent"));
   	private final String name;

   	protected ModWoodType(String nameIn) {
   		super(nameIn);
   		this.name = nameIn;
   	}
	
	private static ModWoodType register(ModWoodType woodTypeIn) {
		VALUES.add(woodTypeIn);
		return woodTypeIn;
	}
		
	public String getName() {
		return this.name;
	}
}