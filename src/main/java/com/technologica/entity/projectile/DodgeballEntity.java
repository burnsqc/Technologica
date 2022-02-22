package com.technologica.entity.projectile;

import com.technologica.entity.TechnologicaEntityType;
import com.technologica.item.TechnologicaItems;
import com.technologica.util.TechnologicaSoundEvents;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.item.ItemEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.entity.projectile.ProjectileItemEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.network.IPacket;
import net.minecraft.particles.IParticleData;
import net.minecraft.particles.ItemParticleData;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.util.DamageSource;
import net.minecraft.util.SoundCategory;
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
		ItemStack itemstack = this.getItemRaw();
		return (IParticleData) (itemstack.isEmpty() ? ParticleTypes.NOTE: new ItemParticleData(ParticleTypes.ITEM, itemstack));
	}

	@Override
	public void handleEntityEvent(byte id) {
		if (id == 3) {
			IParticleData iparticledata = this.makeParticle();

			for (int i = 0; i < 8; ++i) {
				this.level.addParticle(iparticledata, this.getX(), this.getY(), this.getZ(), 0.0D, 0.0D, 0.0D);
			}
		}

	}

	@Override
	protected void onHitEntity(EntityRayTraceResult result) {
		super.onHitEntity(result);
		Entity entity = result.getEntity();
		entity.hurt(DamageSource.thrown(this, this.getOwner()), 0);
		
		if (entity instanceof ServerPlayerEntity) {
			message = entity.getDisplayName().getString() + " HAS BEEN ELIMINATED!"; 
			this.getServer().getPlayerList().broadcastMessage(new StringTextComponent(this.message), ChatType.SYSTEM, Util.NIL_UUID);
		}
		
		
		
	}

	@Override
	protected void onHit(RayTraceResult result) {
		super.onHit(result);
		if (!this.level.isClientSide) {
			this.level.broadcastEntityEvent(this, (byte) 3);
			this.remove();
			this.level.addFreshEntity(new ItemEntity(this.level, this.getX(), this.getY(), this.getZ(), this.getItem()));
		}

		this.level.playSound((PlayerEntity) null, this.getX(), this.getY(), this.getZ(), TechnologicaSoundEvents.DODGEBALL.get(), SoundCategory.NEUTRAL, 1.0F, 1.0F);
	}
	
	@Override
	public IPacket<?> getAddEntityPacket() {
		return NetworkHooks.getEntitySpawningPacket(this);
	}
}