package com.technologica.entity.passive;

import net.minecraft.entity.AgeableEntity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ai.attributes.AttributeModifierMap;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.passive.horse.AbstractHorseEntity;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;

public class DeerEntity extends AbstractHorseEntity {

	public DeerEntity(EntityType<? extends DeerEntity> type, World worldIn) {
		super(type, worldIn);
	}

	@Override
	public AgeableEntity getBreedOffspring(ServerWorld world, AgeableEntity mate) {
		return null;
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
