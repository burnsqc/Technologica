package com.technologica.entity.projectile;

import com.technologica.entity.TechnologicaEntityType;
import com.technologica.item.TechnologicaItems;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.MobEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.AbstractArrowEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.network.IPacket;
import net.minecraft.util.math.EntityRayTraceResult;
import net.minecraft.world.World;
import net.minecraftforge.fml.network.NetworkHooks;

public class HarpoonEntity extends AbstractArrowEntity {

	public HarpoonEntity(EntityType<? extends HarpoonEntity> type, World worldIn) {
		super(type, worldIn);
	}

	public HarpoonEntity(World worldIn, double x, double y, double z) {
		super(TechnologicaEntityType.HARPOON.get(), x, y, z, worldIn);
	}

	public HarpoonEntity(World worldIn, LivingEntity shooter) {
		super(TechnologicaEntityType.HARPOON.get(), shooter, worldIn);
	}

	protected ItemStack getPickupItem() {
		return new ItemStack(TechnologicaItems.HARPOON.get());
	}

	public IPacket<?> getAddEntityPacket() {
		return NetworkHooks.getEntitySpawningPacket(this);
	}

	@Override
	protected void onHitEntity(EntityRayTraceResult result) {
		super.onHitEntity(result);
		
		if (this.getOwner() instanceof PlayerEntity && result.getEntity() instanceof MobEntity) {
			((MobEntity) result.getEntity()).setLeashedTo((PlayerEntity) this.getOwner(), true);	
		}	
	}
	
	@Override
	protected float getWaterInertia() {
		return 1.0F;
	}
}