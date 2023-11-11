package com.technologica.world.item;

import java.util.EnumMap;
import java.util.function.Supplier;

import com.technologica.Technologica;

import net.minecraft.Util;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.util.LazyLoadedValue;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;

@SuppressWarnings("deprecation")
public enum TechnologicaArmorMaterial implements ArmorMaterial {
	BRONZE("bronze", 15, Util.make(new EnumMap<>(ArmorItem.Type.class), (p_266654_) -> {
		p_266654_.put(ArmorItem.Type.BOOTS, 2);
		p_266654_.put(ArmorItem.Type.LEGGINGS, 5);
		p_266654_.put(ArmorItem.Type.CHESTPLATE, 6);
		p_266654_.put(ArmorItem.Type.HELMET, 2);
	}), 9, SoundEvents.ARMOR_EQUIP_IRON, 0.0F, 0.0F, () -> {
		return Ingredient.of(TechnologicaItems.BRONZE_INGOT.get());
	}),

	BRASS("brass", 15, Util.make(new EnumMap<>(ArmorItem.Type.class), (p_266654_) -> {
		p_266654_.put(ArmorItem.Type.BOOTS, 2);
		p_266654_.put(ArmorItem.Type.LEGGINGS, 5);
		p_266654_.put(ArmorItem.Type.CHESTPLATE, 6);
		p_266654_.put(ArmorItem.Type.HELMET, 2);
	}), 9, SoundEvents.ARMOR_EQUIP_IRON, 0.0F, 0.0F, () -> {
		return Ingredient.of(TechnologicaItems.BRASS_INGOT.get());
	}),

	SPACE("space", 15, Util.make(new EnumMap<>(ArmorItem.Type.class), (p_266654_) -> {
		p_266654_.put(ArmorItem.Type.BOOTS, 2);
		p_266654_.put(ArmorItem.Type.LEGGINGS, 5);
		p_266654_.put(ArmorItem.Type.CHESTPLATE, 6);
		p_266654_.put(ArmorItem.Type.HELMET, 2);
	}), 9, SoundEvents.ARMOR_EQUIP_IRON, 0.0F, 0.0F, () -> {
		return Ingredient.of(Items.IRON_INGOT);
	}),

	SNORKEL("snorkel", 15, Util.make(new EnumMap<>(ArmorItem.Type.class), (p_266654_) -> {
		p_266654_.put(ArmorItem.Type.BOOTS, 2);
		p_266654_.put(ArmorItem.Type.LEGGINGS, 5);
		p_266654_.put(ArmorItem.Type.CHESTPLATE, 6);
		p_266654_.put(ArmorItem.Type.HELMET, 2);
	}), 9, SoundEvents.ARMOR_EQUIP_IRON, 0.0F, 0.0F, () -> {
		return Ingredient.of(TechnologicaItems.RUBBER.get());
	}),

	DIVE("dive", 15, Util.make(new EnumMap<>(ArmorItem.Type.class), (p_266654_) -> {
		p_266654_.put(ArmorItem.Type.BOOTS, 2);
		p_266654_.put(ArmorItem.Type.LEGGINGS, 5);
		p_266654_.put(ArmorItem.Type.CHESTPLATE, 6);
		p_266654_.put(ArmorItem.Type.HELMET, 2);
	}), 9, SoundEvents.ARMOR_EQUIP_IRON, 0.0F, 0.0F, () -> {
		return Ingredient.of(TechnologicaItems.COPPER_INGOT.get());
	}),

	SCUBA("scuba", 15, Util.make(new EnumMap<>(ArmorItem.Type.class), (p_266654_) -> {
		p_266654_.put(ArmorItem.Type.BOOTS, 2);
		p_266654_.put(ArmorItem.Type.LEGGINGS, 5);
		p_266654_.put(ArmorItem.Type.CHESTPLATE, 6);
		p_266654_.put(ArmorItem.Type.HELMET, 2);
	}), 9, SoundEvents.ARMOR_EQUIP_IRON, 0.0F, 0.0F, () -> {
		return Ingredient.of(TechnologicaItems.RUBBER.get());
	}),

	HAZMAT("hazmat", 15, Util.make(new EnumMap<>(ArmorItem.Type.class), (p_266654_) -> {
		p_266654_.put(ArmorItem.Type.BOOTS, 2);
		p_266654_.put(ArmorItem.Type.LEGGINGS, 5);
		p_266654_.put(ArmorItem.Type.CHESTPLATE, 6);
		p_266654_.put(ArmorItem.Type.HELMET, 2);
	}), 9, SoundEvents.ARMOR_EQUIP_IRON, 0.0F, 0.0F, () -> {
		return Ingredient.of(TechnologicaItems.RUBBER.get());
	}), MINING("mining", 15, Util.make(new EnumMap<>(ArmorItem.Type.class), (p_266654_) -> {
		p_266654_.put(ArmorItem.Type.BOOTS, 2);
		p_266654_.put(ArmorItem.Type.LEGGINGS, 5);
		p_266654_.put(ArmorItem.Type.CHESTPLATE, 6);
		p_266654_.put(ArmorItem.Type.HELMET, 2);
	}), 9, SoundEvents.ARMOR_EQUIP_IRON, 0.0F, 0.0F, () -> {
		return Ingredient.of(TechnologicaItems.RUBBER.get());
	});

	private static final EnumMap<ArmorItem.Type, Integer> HEALTH_FUNCTION_FOR_TYPE = Util.make(new EnumMap<>(ArmorItem.Type.class), (p_266653_) -> {
		p_266653_.put(ArmorItem.Type.BOOTS, 13);
		p_266653_.put(ArmorItem.Type.LEGGINGS, 15);
		p_266653_.put(ArmorItem.Type.CHESTPLATE, 16);
		p_266653_.put(ArmorItem.Type.HELMET, 11);
	});
	private final String name;
	private final int durabilityMultiplier;
	private final EnumMap<ArmorItem.Type, Integer> protectionFunctionForType;
	private final int enchantmentValue;
	private final SoundEvent sound;
	private final float toughness;
	private final float knockbackResistance;
	private final LazyLoadedValue<Ingredient> repairMaterial;

	private TechnologicaArmorMaterial(String nameIn, int durabilityMultiplierIn, EnumMap<ArmorItem.Type, Integer> protectionFunctionForTypeIn, int enchantabilityIn, SoundEvent soundIn, float toughnessIn, float knockbackResistanceIn, Supplier<Ingredient> repairMaterialIn) {
		this.name = nameIn;
		this.durabilityMultiplier = durabilityMultiplierIn;
		this.protectionFunctionForType = protectionFunctionForTypeIn;
		this.enchantmentValue = enchantabilityIn;
		this.sound = soundIn;
		this.toughness = toughnessIn;
		this.knockbackResistance = knockbackResistanceIn;
		this.repairMaterial = new LazyLoadedValue<>(repairMaterialIn);
	}

	@Override
	public int getDurabilityForType(ArmorItem.Type slotIn) {
		return HEALTH_FUNCTION_FOR_TYPE.get(slotIn) * this.durabilityMultiplier;
	}

	@Override
	public int getDefenseForType(ArmorItem.Type slotIn) {
		return this.protectionFunctionForType.get(slotIn);
	}

	@Override
	public int getEnchantmentValue() {
		return enchantmentValue;
	}

	@Override
	public SoundEvent getEquipSound() {
		return sound;
	}

	@Override
	public Ingredient getRepairIngredient() {
		return repairMaterial.get();
	}

	@Override
	public String getName() {
		return Technologica.MOD_ID + ":" + name;
	}

	@Override
	public float getToughness() {
		return toughness;
	}

	@Override
	public float getKnockbackResistance() {
		return knockbackResistance;
	}

}
