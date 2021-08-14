package com.technologica.block;

import java.util.Set;

import it.unimi.dsi.fastutil.objects.ObjectArraySet;
import net.minecraft.block.WoodType;

public class ModWoodType extends WoodType {
	private static final Set<WoodType> VALUES = new ObjectArraySet<>();
   	public static final WoodType BANANA = register(new ModWoodType("banana"));
   	public static final WoodType CHERRY = register(new ModWoodType("cherry"));
   	public static final WoodType COCONUT = register(new ModWoodType("coconut"));
   	public static final WoodType KIWI = register(new ModWoodType("kiwi"));
   	public static final WoodType LEMON = register(new ModWoodType("lemon"));
   	public static final WoodType LIME = register(new ModWoodType("lime"));
   	public static final WoodType ORANGE = register(new ModWoodType("orange"));
   	public static final WoodType PEACH = register(new ModWoodType("peach"));
   	public static final WoodType PEAR = register(new ModWoodType("pear"));
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