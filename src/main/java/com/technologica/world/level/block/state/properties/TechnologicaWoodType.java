package com.technologica.world.level.block.state.properties;

import java.util.Set;
import java.util.stream.Stream;

import com.technologica.util.text.TechnologicaLocation;

import it.unimi.dsi.fastutil.objects.ObjectArraySet;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraft.world.level.block.state.properties.WoodType;

/**
 * General class to add mod wood types to the vanilla WoodTypes, which are required for signs.
 */
public class TechnologicaWoodType {
	private static final Set<WoodType> VALUES = new ObjectArraySet<>();
	public static final WoodType APRICOT = register(new WoodType(new TechnologicaLocation("apricot").toString(), BlockSetType.ACACIA));
	public static final WoodType ASPEN = register(new WoodType(new TechnologicaLocation("aspen").toString(), BlockSetType.ACACIA));
	public static final WoodType AVOCADO = register(new WoodType(new TechnologicaLocation("avocado").toString(), BlockSetType.ACACIA));
	public static final WoodType BANANA = register(new WoodType(new TechnologicaLocation("banana").toString(), BlockSetType.ACACIA));
	public static final WoodType CHERRY = register(new WoodType(new TechnologicaLocation("cherry").toString(), BlockSetType.ACACIA));
	public static final WoodType CHESTNUT = register(new WoodType(new TechnologicaLocation("chestnut").toString(), BlockSetType.ACACIA));
	public static final WoodType CINNAMON = register(new WoodType(new TechnologicaLocation("cinnamon").toString(), BlockSetType.ACACIA));
	public static final WoodType COCONUT = register(new WoodType(new TechnologicaLocation("coconut").toString(), BlockSetType.ACACIA));
	public static final WoodType EBONY = register(new WoodType(new TechnologicaLocation("ebony").toString(), BlockSetType.ACACIA));
	public static final WoodType KIWI = register(new WoodType(new TechnologicaLocation("kiwi").toString(), BlockSetType.ACACIA));
	public static final WoodType LEMON = register(new WoodType(new TechnologicaLocation("lemon").toString(), BlockSetType.ACACIA));
	public static final WoodType LIME = register(new WoodType(new TechnologicaLocation("lime").toString(), BlockSetType.ACACIA));
	public static final WoodType MAHOGANY = register(new WoodType(new TechnologicaLocation("mahogany").toString(), BlockSetType.ACACIA));
	public static final WoodType MAPLE = register(new WoodType(new TechnologicaLocation("maple").toString(), BlockSetType.ACACIA));
	public static final WoodType OLIVE = register(new WoodType(new TechnologicaLocation("olive").toString(), BlockSetType.ACACIA));
	public static final WoodType ORANGE = register(new WoodType(new TechnologicaLocation("orange").toString(), BlockSetType.ACACIA));
	public static final WoodType PEACH = register(new WoodType(new TechnologicaLocation("peach").toString(), BlockSetType.ACACIA));
	public static final WoodType PEAR = register(new WoodType(new TechnologicaLocation("pear").toString(), BlockSetType.ACACIA));
	public static final WoodType PLUM = register(new WoodType(new TechnologicaLocation("plum").toString(), BlockSetType.ACACIA));
	public static final WoodType REDWOOD = register(new WoodType(new TechnologicaLocation("redwood").toString(), BlockSetType.ACACIA));
	public static final WoodType ROSEWOOD = register(new WoodType(new TechnologicaLocation("rosewood").toString(), BlockSetType.ACACIA));
	public static final WoodType RUBBER = register(new WoodType(new TechnologicaLocation("rubber").toString(), BlockSetType.ACACIA));
	public static final WoodType TEAK = register(new WoodType(new TechnologicaLocation("teak").toString(), BlockSetType.ACACIA));
	public static final WoodType WALNUT = register(new WoodType(new TechnologicaLocation("walnut").toString(), BlockSetType.ACACIA));
	public static final WoodType ZEBRAWOOD = register(new WoodType(new TechnologicaLocation("zebrawood").toString(), BlockSetType.ACACIA));
	public static final WoodType ALCHEMICAL = register(new WoodType(new TechnologicaLocation("alchemical").toString(), BlockSetType.ACACIA));
	public static final WoodType BENEVOLENT = register(new WoodType(new TechnologicaLocation("benevolent").toString(), BlockSetType.ACACIA));
	public static final WoodType CONDUCTIVE = register(new WoodType(new TechnologicaLocation("conductive").toString(), BlockSetType.ACACIA));
	public static final WoodType FROSTBITTEN = register(new WoodType(new TechnologicaLocation("frostbitten").toString(), BlockSetType.ACACIA));
	public static final WoodType FRUITFUL = register(new WoodType(new TechnologicaLocation("fruitful").toString(), BlockSetType.ACACIA));
	public static final WoodType INFERNAL = register(new WoodType(new TechnologicaLocation("infernal").toString(), BlockSetType.ACACIA));
	public static final WoodType MALEVOLENT = register(new WoodType(new TechnologicaLocation("malevolent").toString(), BlockSetType.ACACIA));
	public static final WoodType NECROTIC = register(new WoodType(new TechnologicaLocation("necrotic").toString(), BlockSetType.ACACIA));

	public static WoodType register(WoodType woodTypeIn) {
		VALUES.add(woodTypeIn);
		WoodType.register(woodTypeIn);
		return woodTypeIn;
	}

	public static Stream<WoodType> values() {
		return VALUES.stream();
	}
}