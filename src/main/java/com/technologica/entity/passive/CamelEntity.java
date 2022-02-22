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
		return AttributeModifierMap.builder()
				.add(Attributes.MAX_HEALTH, 10.0D)
				.add(Attributes.MOVEMENT_SPEED, 0.25D)
				.add(Attributes.FOLLOW_RANGE, 16.0D)
				.add(Attributes.ATTACK_KNOCKBACK)
				.add(Attributes.KNOCKBACK_RESISTANCE)
				.add(Attributes.ARMOR)
				.add(Attributes.ARMOR_TOUGHNESS)
				.add(net.minecraftforge.common.ForgeMod.SWIM_SPEED.get())
				.add(net.minecraftforge.common.ForgeMod.NAMETAG_DISTANCE.get())
				.add(net.minecraftforge.common.ForgeMod.ENTITY_GRAVITY.get());
	}

}
