package com.technologica.entity.passive;

import net.minecraft.entity.AgeableEntity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ai.attributes.AttributeModifierMap;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;

public class OwlEntity extends AnimalEntity {

	public OwlEntity(EntityType<? extends OwlEntity> type, World worldIn) {
		super(type, worldIn);
	}

	@Override
	public AgeableEntity createChild(ServerWorld world, AgeableEntity mate) {
		return null;
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
