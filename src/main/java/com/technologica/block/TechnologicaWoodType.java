package com.technologica.block;

import java.util.Set;

import it.unimi.dsi.fastutil.objects.ObjectArraySet;
import net.minecraft.block.WoodType;

/**
 * General class to add mod wood types to the vanilla WoodTypes. 
 * Created to fully integrate mod wood types, which are required for signs.  
 */
public class TechnologicaWoodType extends WoodType {
	private static final Set<WoodType> VALUES = new ObjectArraySet<>();
	public static final WoodType APRICOT = register(new TechnologicaWoodType("apricot"));
	public static final WoodType ASPEN = register(new TechnologicaWoodType("aspen"));
	public static final WoodType AVOCADO = register(new TechnologicaWoodType("avocado"));
   	public static final WoodType BANANA = register(new TechnologicaWoodType("banana"));
   	public static final WoodType CHERRY = register(new TechnologicaWoodType("cherry"));
   	public static final WoodType CHESTNUT = register(new TechnologicaWoodType("chestnut"));
   	public static final WoodType COCONUT = register(new TechnologicaWoodType("coconut"));
   	public static final WoodType EBONY = register(new TechnologicaWoodType("ebony"));
   	public static final WoodType KIWI = register(new TechnologicaWoodType("kiwi"));
   	public static final WoodType LEMON = register(new TechnologicaWoodType("lemon"));
   	public static final WoodType LIME = register(new TechnologicaWoodType("lime"));
   	public static final WoodType MAHOGANY = register(new TechnologicaWoodType("mahogany"));
   	public static final WoodType MAPLE = register(new TechnologicaWoodType("maple"));
   	public static final WoodType ORANGE = register(new TechnologicaWoodType("orange"));
   	public static final WoodType PEACH = register(new TechnologicaWoodType("peach"));
   	public static final WoodType PEAR = register(new TechnologicaWoodType("pear"));
   	public static final WoodType PLUM = register(new TechnologicaWoodType("plum"));
   	public static final WoodType REDWOOD = register(new TechnologicaWoodType("redwood"));
   	public static final WoodType ROSEWOOD = register(new TechnologicaWoodType("rosewood"));
   	public static final WoodType RUBBER = register(new TechnologicaWoodType("rubber"));
   	public static final WoodType TEAK = register(new TechnologicaWoodType("teak"));
   	public static final WoodType WALNUT = register(new TechnologicaWoodType("walnut"));
   	public static final WoodType ZEBRAWOOD = register(new TechnologicaWoodType("zebrawood"));
   	public static final WoodType ALCHEMICAL = register(new TechnologicaWoodType("alchemical"));
   	public static final WoodType BENEVOLENT = register(new TechnologicaWoodType("benevolent"));
   	public static final WoodType CONDUCTIVE = register(new TechnologicaWoodType("conductive"));
   	public static final WoodType FROSTBITTEN = register(new TechnologicaWoodType("frostbitten"));
   	public static final WoodType FRUITFUL = register(new TechnologicaWoodType("fruitful"));
   	public static final WoodType INFERNAL = register(new TechnologicaWoodType("infernal"));
   	public static final WoodType MALEVOLENT = register(new TechnologicaWoodType("malevolent"));
   	private final String name;

   	protected TechnologicaWoodType(String nameIn) {
   		super(nameIn);
   		this.name = nameIn;
   	}
	
	private static TechnologicaWoodType register(TechnologicaWoodType woodTypeIn) {
		VALUES.add(woodTypeIn);
		return woodTypeIn;
	}
		
	public String getName() {
		return this.name;
	}
}