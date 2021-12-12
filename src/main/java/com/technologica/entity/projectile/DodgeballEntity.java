package com.technologica.entity.projectile;

import com.technologica.entity.TechnologicaEntityType;
import com.technologica.item.TechnologicaItems;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.item.ItemEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.entity.projectile.ProjectileItemEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.network.IPacket;
import net.minecraft.particles.IParticleData;
import net.minecraft.particles.ItemParticleData;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.util.DamageSource;
import net.minecraft.util.Util;
import net.minecraft.util.math.EntityRayTraceResult;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.util.text.ChatType;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.world.World;
import net.minecraftforge.fml.network.NetworkHooks;

public class DodgeballEntity extends ProjectileItemEntity {
	private String message = "";
	
	public DodgeballEntity(EntityType<? extends DodgeballEntity> p_i50159_1_, World p_i50159_2_) {
		super(p_i50159_1_, p_i50159_2_);
	}

	public DodgeballEntity(World worldIn, LivingEntity throwerIn) {
		super(TechnologicaEntityType.DODGEBALL.get(), throwerIn, worldIn);
	}

	public DodgeballEntity(World worldIn, double x, double y, double z) {
		super(TechnologicaEntityType.DODGEBALL.get(), x, y, z, worldIn);
	}

	@Override
	protected Item getDefaultItem() {
		return TechnologicaItems.DODGEBALL_ITEM.get();
	}

	private IParticleData makeParticle() {
		ItemStack itemstack = this.func_213882_k();
		return (IParticleData) (itemstack.isEmpty() ? ParticleTypes.NOTE: new ItemParticleData(ParticleTypes.ITEM, itemstack));
	}

	@Override
	public void handleStatusUpdate(byte id) {
		if (id == 3) {
			IParticleData iparticledata = this.makeParticle();

			for (int i = 0; i < 8; ++i) {
				this.world.addParticle(iparticledata, this.getPosX(), this.getPosY(), this.getPosZ(), 0.0D, 0.0D, 0.0D);
			}
		}

	}

	@Override
	protected void onEntityHit(EntityRayTraceResult result) {
		super.onEntityHit(result);
		Entity entity = result.getEntity();
		entity.attackEntityFrom(DamageSource.causeThrownDamage(this, this.getShooter()), 0);
		
		if (entity instanceof ServerPlayerEntity) {
			message = entity.getDisplayName().getString() + " HAS BEEN ELIMINATED!"; 
			this.getServer().getPlayerList().func_232641_a_(new StringTextComponent(this.message), ChatType.SYSTEM, Util.DUMMY_UUID);
		}
		
		
		
	}

	@Override
	protected void onImpact(RayTraceResult result) {
		super.onImpact(result);
		if (!this.world.isRemote) {
			this.world.setEntityState(this, (byte) 3);
			this.remove();
			this.world.addEntity(new ItemEntity(this.world, this.getPosX(), this.getPosY(), this.getPosZ(), this.getItem()));
		}

	}
	
	@Override
	public IPacket<?> createSpawnPacket() {
		return NetworkHooks.getEntitySpawningPacket(this);
	}
}