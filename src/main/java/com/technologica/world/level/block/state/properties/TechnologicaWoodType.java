package com.technologica.world.level.block.state.properties;

import java.util.Set;
import java.util.stream.Stream;

import com.technologica.Technologica;

import it.unimi.dsi.fastutil.objects.ObjectArraySet;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraft.world.level.block.state.properties.WoodType;

/**
 * General class to add mod wood types to the vanilla WoodTypes, which are required for signs.
 */
public class TechnologicaWoodType {
	private static final Set<WoodType> VALUES = new ObjectArraySet<>();
	public static final WoodType APRICOT = register(new WoodType(new ResourceLocation(Technologica.MODID, "apricot").toString(), BlockSetType.ACACIA));
	public static final WoodType ASPEN = register(new WoodType(new ResourceLocation(Technologica.MODID, "aspen").toString(), BlockSetType.ACACIA));
	public static final WoodType AVOCADO = register(new WoodType(new ResourceLocation(Technologica.MODID, "avocado").toString(), BlockSetType.ACACIA));
	public static final WoodType BANANA = register(new WoodType(new ResourceLocation(Technologica.MODID, "banana").toString(), BlockSetType.ACACIA));
	public static final WoodType CHERRY = register(new WoodType(new ResourceLocation(Technologica.MODID, "cherry").toString(), BlockSetType.ACACIA));
	public static final WoodType CHESTNUT = register(new WoodType(new ResourceLocation(Technologica.MODID, "chestnut").toString(), BlockSetType.ACACIA));
	public static final WoodType CINNAMON = register(new WoodType(new ResourceLocation(Technologica.MODID, "cinnamon").toString(), BlockSetType.ACACIA));
	public static final WoodType COCONUT = register(new WoodType(new ResourceLocation(Technologica.MODID, "coconut").toString(), BlockSetType.ACACIA));
	public static final WoodType EBONY = register(new WoodType(new ResourceLocation(Technologica.MODID, "ebony").toString(), BlockSetType.ACACIA));
	public static final WoodType KIWI = register(new WoodType(new ResourceLocation(Technologica.MODID, "kiwi").toString(), BlockSetType.ACACIA));
	public static final WoodType LEMON = register(new WoodType(new ResourceLocation(Technologica.MODID, "lemon").toString(), BlockSetType.ACACIA));
	public static final WoodType LIME = register(new WoodType(new ResourceLocation(Technologica.MODID, "lime").toString(), BlockSetType.ACACIA));
	public static final WoodType MAHOGANY = register(new WoodType(new ResourceLocation(Technologica.MODID, "mahogany").toString(), BlockSetType.ACACIA));
	public static final WoodType MAPLE = register(new WoodType(new ResourceLocation(Technologica.MODID, "maple").toString(), BlockSetType.ACACIA));
	public static final WoodType OLIVE = register(new WoodType(new ResourceLocation(Technologica.MODID, "olive").toString(), BlockSetType.ACACIA));
	public static final WoodType ORANGE = register(new WoodType(new ResourceLocation(Technologica.MODID, "orange").toString(), BlockSetType.ACACIA));
	public static final WoodType PEACH = register(new WoodType(new ResourceLocation(Technologica.MODID, "peach").toString(), BlockSetType.ACACIA));
	public static final WoodType PEAR = register(new WoodType(new ResourceLocation(Technologica.MODID, "pear").toString(), BlockSetType.ACACIA));
	public static final WoodType PLUM = register(new WoodType(new ResourceLocation(Technologica.MODID, "plum").toString(), BlockSetType.ACACIA));
	public static final WoodType REDWOOD = register(new WoodType(new ResourceLocation(Technologica.MODID, "redwood").toString(), BlockSetType.ACACIA));
	public static final WoodType ROSEWOOD = register(new WoodType(new ResourceLocation(Technologica.MODID, "rosewood").toString(), BlockSetType.ACACIA));
	public static final WoodType RUBBER = register(new WoodType(new ResourceLocation(Technologica.MODID, "rubber").toString(), BlockSetType.ACACIA));
	public static final WoodType TEAK = register(new WoodType(new ResourceLocation(Technologica.MODID, "teak").toString(), BlockSetType.ACACIA));
	public static final WoodType WALNUT = register(new WoodType(new ResourceLocation(Technologica.MODID, "walnut").toString(), BlockSetType.ACACIA));
	public static final WoodType ZEBRAWOOD = register(new WoodType(new ResourceLocation(Technologica.MODID, "zebrawood").toString(), BlockSetType.ACACIA));
	public static final WoodType ALCHEMICAL = register(new WoodType(new ResourceLocation(Technologica.MODID, "alchemical").toString(), BlockSetType.ACACIA));
	public static final WoodType BENEVOLENT = register(new WoodType(new ResourceLocation(Technologica.MODID, "benevolent").toString(), BlockSetType.ACACIA));
	public static final WoodType CONDUCTIVE = register(new WoodType(new ResourceLocation(Technologica.MODID, "conductive").toString(), BlockSetType.ACACIA));
	public static final WoodType FROSTBITTEN = register(new WoodType(new ResourceLocation(Technologica.MODID, "frostbitten").toString(), BlockSetType.ACACIA));
	public static final WoodType FRUITFUL = register(new WoodType(new ResourceLocation(Technologica.MODID, "fruitful").toString(), BlockSetType.ACACIA));
	public static final WoodType INFERNAL = register(new WoodType(new ResourceLocation(Technologica.MODID, "infernal").toString(), BlockSetType.ACACIA));
	public static final WoodType MALEVOLENT = register(new WoodType(new ResourceLocation(Technologica.MODID, "malevolent").toString(), BlockSetType.ACACIA));
	public static final WoodType NECROTIC = register(new WoodType(new ResourceLocation(Technologica.MODID, "necrotic").toString(), BlockSetType.ACACIA));

	public static WoodType register(WoodType woodTypeIn) {
		VALUES.add(woodTypeIn);
		WoodType.register(woodTypeIn);
		return woodTypeIn;
	}

	public static Stream<WoodType> values() {
		return VALUES.stream();
	}
}