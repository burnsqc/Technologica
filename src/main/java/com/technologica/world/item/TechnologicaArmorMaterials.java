package com.technologica.world.item;

import java.util.EnumMap;
import java.util.function.Supplier;

import com.technologica.Technologica;
import com.technologica.registration.deferred.TechnologicaItems;

import net.minecraft.Util;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.util.LazyLoadedValue;
import net.minecraft.util.StringRepresentable;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.ArmorMaterials;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;

/**
 * <p>
 * This enum contains ArmorMaterials for armor.
 * This is effectively a simple copy of {@link ArmorMaterials}.
 * </p>
 * 
 * @tl.status GREEN
 */
@SuppressWarnings("deprecation")
public enum TechnologicaArmorMaterials implements StringRepresentable, ArmorMaterial {
	BRONZE("bronze", 15, Util.make(new EnumMap<>(ArmorItem.Type.class), (enumMap) -> {
		enumMap.put(ArmorItem.Type.BOOTS, 2);
		enumMap.put(ArmorItem.Type.LEGGINGS, 5);
		enumMap.put(ArmorItem.Type.CHESTPLATE, 6);
		enumMap.put(ArmorItem.Type.HELMET, 2);
	}), 9, SoundEvents.ARMOR_EQUIP_IRON, 0.0F, 0.0F, () -> {
		return Ingredient.of(TechnologicaItems.BRONZE_INGOT.get());
	}),

	BRASS("brass", 15, Util.make(new EnumMap<>(ArmorItem.Type.class), (enumMap) -> {
		enumMap.put(ArmorItem.Type.BOOTS, 2);
		enumMap.put(ArmorItem.Type.LEGGINGS, 5);
		enumMap.put(ArmorItem.Type.CHESTPLATE, 6);
		enumMap.put(ArmorItem.Type.HELMET, 2);
	}), 9, SoundEvents.ARMOR_EQUIP_IRON, 0.0F, 0.0F, () -> {
		return Ingredient.of(TechnologicaItems.BRASS_INGOT.get());
	}),

	SPACE("space", 15, Util.make(new EnumMap<>(ArmorItem.Type.class), (enumMap) -> {
		enumMap.put(ArmorItem.Type.BOOTS, 2);
		enumMap.put(ArmorItem.Type.LEGGINGS, 5);
		enumMap.put(ArmorItem.Type.CHESTPLATE, 6);
		enumMap.put(ArmorItem.Type.HELMET, 2);
	}), 9, SoundEvents.ARMOR_EQUIP_IRON, 0.0F, 0.0F, () -> {
		return Ingredient.of(Items.IRON_INGOT);
	}),

	SNORKEL("snorkel", 15, Util.make(new EnumMap<>(ArmorItem.Type.class), (enumMap) -> {
		enumMap.put(ArmorItem.Type.BOOTS, 2);
		enumMap.put(ArmorItem.Type.LEGGINGS, 5);
		enumMap.put(ArmorItem.Type.CHESTPLATE, 6);
		enumMap.put(ArmorItem.Type.HELMET, 2);
	}), 9, SoundEvents.ARMOR_EQUIP_IRON, 0.0F, 0.0F, () -> {
		return Ingredient.of(TechnologicaItems.RUBBER.get());
	}),

	DIVE("dive", 15, Util.make(new EnumMap<>(ArmorItem.Type.class), (enumMap) -> {
		enumMap.put(ArmorItem.Type.BOOTS, 2);
		enumMap.put(ArmorItem.Type.LEGGINGS, 5);
		enumMap.put(ArmorItem.Type.CHESTPLATE, 6);
		enumMap.put(ArmorItem.Type.HELMET, 2);
	}), 9, SoundEvents.ARMOR_EQUIP_IRON, 0.0F, 0.0F, () -> {
		return Ingredient.of(TechnologicaItems.BRASS_INGOT.get());
	}),

	SCUBA("scuba", 15, Util.make(new EnumMap<>(ArmorItem.Type.class), (enumMap) -> {
		enumMap.put(ArmorItem.Type.BOOTS, 2);
		enumMap.put(ArmorItem.Type.LEGGINGS, 5);
		enumMap.put(ArmorItem.Type.CHESTPLATE, 6);
		enumMap.put(ArmorItem.Type.HELMET, 2);
	}), 9, SoundEvents.ARMOR_EQUIP_IRON, 0.0F, 0.0F, () -> {
		return Ingredient.of(TechnologicaItems.RUBBER.get());
	}),

	HAZMAT("hazmat", 15, Util.make(new EnumMap<>(ArmorItem.Type.class), (enumMap) -> {
		enumMap.put(ArmorItem.Type.BOOTS, 2);
		enumMap.put(ArmorItem.Type.LEGGINGS, 5);
		enumMap.put(ArmorItem.Type.CHESTPLATE, 6);
		enumMap.put(ArmorItem.Type.HELMET, 2);
	}), 9, SoundEvents.ARMOR_EQUIP_IRON, 0.0F, 0.0F, () -> {
		return Ingredient.of(TechnologicaItems.RUBBER.get());
	}), MINING("mining", 15, Util.make(new EnumMap<>(ArmorItem.Type.class), (enumMap) -> {
		enumMap.put(ArmorItem.Type.BOOTS, 2);
		enumMap.put(ArmorItem.Type.LEGGINGS, 5);
		enumMap.put(ArmorItem.Type.CHESTPLATE, 6);
		enumMap.put(ArmorItem.Type.HELMET, 2);
	}), 9, SoundEvents.ARMOR_EQUIP_IRON, 0.0F, 0.0F, () -> {
		return Ingredient.of(TechnologicaItems.RUBBER.get());
	});

	public static final StringRepresentable.EnumCodec<TechnologicaArmorMaterials> CODEC = StringRepresentable.fromEnum(TechnologicaArmorMaterials::values);
	private static final EnumMap<ArmorItem.Type, Integer> HEALTH_FUNCTION_FOR_TYPE = Util.make(new EnumMap<>(ArmorItem.Type.class), (enumMap) -> {
		enumMap.put(ArmorItem.Type.BOOTS, 13);
		enumMap.put(ArmorItem.Type.LEGGINGS, 15);
		enumMap.put(ArmorItem.Type.CHESTPLATE, 16);
		enumMap.put(ArmorItem.Type.HELMET, 11);
	});
	private final String name;
	private final int durabilityMultiplier;
	private final EnumMap<ArmorItem.Type, Integer> protectionFunctionForType;
	private final int enchantmentValue;
	private final SoundEvent sound;
	private final float toughness;
	private final float knockbackResistance;
	private final LazyLoadedValue<Ingredient> repairIngredient;

	private TechnologicaArmorMaterials(String name, int durabilityMultiplier, EnumMap<ArmorItem.Type, Integer> protectionFunctionForType, int enchantmentValue, SoundEvent sound, float toughness, float knockbackResistance, Supplier<Ingredient> repairIngredient) {
		this.name = name;
		this.durabilityMultiplier = durabilityMultiplier;
		this.protectionFunctionForType = protectionFunctionForType;
		this.enchantmentValue = enchantmentValue;
		this.sound = sound;
		this.toughness = toughness;
		this.knockbackResistance = knockbackResistance;
		this.repairIngredient = new LazyLoadedValue<>(repairIngredient);
	}

	@Override
	public int getDurabilityForType(ArmorItem.Type type) {
		return HEALTH_FUNCTION_FOR_TYPE.get(type) * this.durabilityMultiplier;
	}

	@Override
	public int getDefenseForType(ArmorItem.Type type) {
		return this.protectionFunctionForType.get(type);
	}

	@Override
	public int getEnchantmentValue() {
		return this.enchantmentValue;
	}

	@Override
	public SoundEvent getEquipSound() {
		return this.sound;
	}

	@Override
	public Ingredient getRepairIngredient() {
		return this.repairIngredient.get();
	}

	@Override
	public String getName() {
		return Technologica.MOD_ID + ":" + this.name;
	}

	@Override
	public float getToughness() {
		return this.toughness;
	}

	@Override
	public float getKnockbackResistance() {
		return this.knockbackResistance;
	}

	@Override
	public String getSerializedName() {
		return this.name;
	}
}
