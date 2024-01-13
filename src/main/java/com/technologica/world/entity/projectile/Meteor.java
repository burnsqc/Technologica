package com.technologica.world.entity.projectile;

import com.technologica.registration.deferred.TechnologicaEntityTypes;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.Fireball;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.EntityHitResult;
import net.minecraft.world.phys.HitResult;

public class Meteor extends Fireball {
	private int explosionPower = 5;

	public Meteor(EntityType<? extends Meteor> meteor, Level level) {
		super(meteor, level);
	}

	public Meteor(Level level, double p_181153_, double p_181154_, double p_181155_) {
		super(TechnologicaEntityTypes.METEOR.get(), p_181153_, p_181154_, p_181155_, 0, -100, 0, level);
	}

	@Override
	public ItemStack getItem() {
		return new ItemStack(Items.FIRE_CHARGE);
	}

	@Override
	protected void onHit(HitResult result) {
		super.onHit(result);
		if (!this.level().isClientSide) {
			this.level().explode(this, this.getX(), this.getY(), this.getZ(), this.explosionPower, false, Level.ExplosionInteraction.NONE);
			this.discard();
		}
	}

	@Override
	protected void onHitEntity(EntityHitResult result) {
		super.onHitEntity(result);
		if (!this.level().isClientSide) {
			Entity entity = result.getEntity();
			Entity entity1 = this.getOwner();
			entity.hurt(this.damageSources().fireball(this, entity1), 6.0F);
			if (entity1 instanceof LivingEntity) {
				this.doEnchantDamageEffects((LivingEntity) entity1, entity);
			}
		}
	}
}