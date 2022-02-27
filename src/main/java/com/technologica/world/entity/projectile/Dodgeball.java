package com.technologica.world.entity.projectile;

import com.technologica.util.TechnologicaSoundEvents;
import com.technologica.world.entity.TechnologicaEntityType;
import com.technologica.world.item.TechnologicaItems;

import net.minecraft.Util;
import net.minecraft.core.particles.ItemParticleOption;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.network.chat.ChatType;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.network.protocol.Packet;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.ThrowableItemProjectile;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.EntityHitResult;
import net.minecraft.world.phys.HitResult;
import net.minecraftforge.network.NetworkHooks;

public class Dodgeball extends ThrowableItemProjectile {
	private String message = "";
	
	public Dodgeball(EntityType<? extends Dodgeball> p_i50159_1_, Level p_i50159_2_) {
		super(p_i50159_1_, p_i50159_2_);
	}

	public Dodgeball(Level worldIn, LivingEntity throwerIn) {
		super(TechnologicaEntityType.DODGEBALL.get(), throwerIn, worldIn);
	}

	public Dodgeball(Level worldIn, double x, double y, double z) {
		super(TechnologicaEntityType.DODGEBALL.get(), x, y, z, worldIn);
	}

	@Override
	protected Item getDefaultItem() {
		return TechnologicaItems.DODGEBALL_ITEM.get();
	}

	private ParticleOptions makeParticle() {
		ItemStack itemstack = this.getItemRaw();
		return (ParticleOptions) (itemstack.isEmpty() ? ParticleTypes.NOTE: new ItemParticleOption(ParticleTypes.ITEM, itemstack));
	}

	@Override
	public void handleEntityEvent(byte id) {
		if (id == 3) {
			ParticleOptions iparticledata = this.makeParticle();

			for (int i = 0; i < 8; ++i) {
				this.level.addParticle(iparticledata, this.getX(), this.getY(), this.getZ(), 0.0D, 0.0D, 0.0D);
			}
		}

	}

	@Override
	protected void onHitEntity(EntityHitResult result) {
		super.onHitEntity(result);
		Entity entity = result.getEntity();
		entity.hurt(DamageSource.thrown(this, this.getOwner()), 0);
		
		if (entity instanceof ServerPlayer) {
			message = entity.getDisplayName().getString() + " HAS BEEN ELIMINATED!"; 
			this.getServer().getPlayerList().broadcastMessage(new TextComponent(this.message), ChatType.SYSTEM, Util.NIL_UUID);
		}
		
		
		
	}

	@Override
	protected void onHit(HitResult result) {
		super.onHit(result);
		if (!this.level.isClientSide) {
			this.level.broadcastEntityEvent(this, (byte) 3);
			this.discard();
			this.level.addFreshEntity(new ItemEntity(this.level, this.getX(), this.getY(), this.getZ(), this.getItem()));
		}

		this.level.playSound((Player) null, this.getX(), this.getY(), this.getZ(), TechnologicaSoundEvents.DODGEBALL.get(), SoundSource.NEUTRAL, 1.0F, 1.0F);
	}
	
	@Override
	public Packet<?> getAddEntityPacket() {
		return NetworkHooks.getEntitySpawningPacket(this);
	}
}