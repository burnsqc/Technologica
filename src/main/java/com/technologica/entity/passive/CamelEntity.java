package com.technologica.entity.passive;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.ai.attributes.AttributeModifierMap;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.passive.horse.AbstractChestedHorseEntity;
import net.minecraft.world.World;

public class CamelEntity extends AbstractChestedHorseEntity {

	public CamelEntity(EntityType<? extends CamelEntity> type, World worldIn) {
		super(type, worldIn);
	}
	
	public static AttributeModifierMap.MutableAttribute registerAttributes() {
		return AttributeModifierMap.createMutableAttribute()
				.createMutableAttribute(Attributes.MAX_HEALTH, 10.0D)
				.createMutableAttribute(Attributes.MOVEMENT_SPEED, 0.25D)
				.createMutableAttribute(Attributes.FOLLOW_RANGE, 16.0D)
				.createMutableAttribute(Attributes.ATTACK_KNOCKBACK)
				.createMutableAttribute(Attributes.KNOCKBACK_RESISTANCE)
				.createMutableAttribute(Attributes.ARMOR)
				.createMutableAttribute(Attributes.ARMOR_TOUGHNESS)
				.createMutableAttribute(net.minecraftforge.common.ForgeMod.SWIM_SPEED.get())
				.createMutableAttribute(net.minecraftforge.common.ForgeMod.NAMETAG_DISTANCE.get())
				.createMutableAttribute(net.minecraftforge.common.ForgeMod.ENTITY_GRAVITY.get());
	}

}
