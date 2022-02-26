package com.technologica.world.entity.projectile;

import com.technologica.world.entity.TechnologicaEntityType;
import com.technologica.world.item.TechnologicaItems;

import net.minecraft.network.protocol.Packet;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.EntityHitResult;
import net.minecraftforge.network.NetworkHooks;

public class HarpoonEntity extends AbstractArrow {

	public HarpoonEntity(EntityType<? extends HarpoonEntity> type, Level worldIn) {
		super(type, worldIn);
	}

	public HarpoonEntity(Level worldIn, double x, double y, double z) {
		super(TechnologicaEntityType.HARPOON.get(), x, y, z, worldIn);
	}

	public HarpoonEntity(Level worldIn, LivingEntity shooter) {
		super(TechnologicaEntityType.HARPOON.get(), shooter, worldIn);
	}

	protected ItemStack getPickupItem() {
		return new ItemStack(TechnologicaItems.HARPOON.get());
	}

	public Packet<?> getAddEntityPacket() {
		return NetworkHooks.getEntitySpawningPacket(this);
	}

	@Override
	protected void onHitEntity(EntityHitResult result) {
		super.onHitEntity(result);
		
		if (this.getOwner() instanceof Player && result.getEntity() instanceof Mob) {
			((Mob) result.getEntity()).setLeashedTo((Player) this.getOwner(), true);	
		}	
	}
	
	@Override
	protected float getWaterInertia() {
		return 1.0F;
	}
}