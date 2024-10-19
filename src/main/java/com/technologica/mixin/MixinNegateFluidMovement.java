package com.technologica.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import com.technologica.world.entity.player.TechnologicaAbilities;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraftforge.common.ForgeMod;
import net.minecraftforge.common.extensions.IForgeLivingEntity;
import net.minecraftforge.fluids.FluidType;

@Mixin(Player.class)
public abstract class MixinNegateFluidMovement extends LivingEntity implements IForgeLivingEntity {
	protected MixinNegateFluidMovement(EntityType<? extends LivingEntity> p_20966_, Level p_20967_) {
		super(p_20966_, p_20967_);
	}

	@Unique
	private boolean flag = false;

	/**
	 * STOP FLUID PUSHING
	 * 
	 * @author burnsqc
	 * 
	 * @reason cuz
	 * 
	 * @return
	 */
	@Override
	@Overwrite
	public boolean isPushedByFluid() {
		TechnologicaAbilities diver = ((Player) (Object) this).getCapability(TechnologicaAbilities.DIVER_INSTANCE).orElse(null);
		boolean divercap = true;
		if (diver != null) {
			divercap = diver.getDiver();
		}
		return !((Player) (Object) this).getAbilities().flying && !divercap;
	}

	/**
	 * STOP FLUID PUSHING
	 * 
	 * @author burnsqc
	 * 
	 * @reason cuz
	 * 
	 * @return
	 */
	@Override
	@Overwrite
	public boolean isAffectedByFluids() {
		return !((Player) (Object) this).getAbilities().flying && flag;
	}

	@Inject(method = "travel(Lnet/minecraft/world/phys/Vec3;)V", at = @At("HEAD"))
	private void negateFluidMovement(CallbackInfo info) {
		TechnologicaAbilities diver = ((Player) (Object) this).getCapability(TechnologicaAbilities.DIVER_INSTANCE).orElseThrow(NullPointerException::new);
		flag = !diver.getDiver();
	}

	@Inject(method = "travel(Lnet/minecraft/world/phys/Vec3;)V", at = @At("TAIL"))
	private void resetFluidMovement(CallbackInfo info) {
		flag = true;
	}

	@Override
	public void jumpInFluid(FluidType type) {
		TechnologicaAbilities diver = ((Player) (Object) this).getCapability(TechnologicaAbilities.DIVER_INSTANCE).orElseThrow(NullPointerException::new);
		if (diver.getDiver()) {
			if (((Player) (Object) this).onGround() && ((Player) (Object) this).noJumpDelay == 0) {
				((Player) (Object) this).jumpFromGround();
				((Player) (Object) this).noJumpDelay = 10;
			}
		} else {
			self().setDeltaMovement(self().getDeltaMovement().add(0.0D, 0.04F * self().getAttributeValue(ForgeMod.SWIM_SPEED.get()), 0.0D));
		}
	}

	@Override
	public void sinkInFluid(FluidType type) {
		TechnologicaAbilities diver = ((Player) (Object) this).getCapability(TechnologicaAbilities.DIVER_INSTANCE).orElseThrow(NullPointerException::new);
		if (diver.getDiver()) {
			return;
		}
		self().setDeltaMovement(self().getDeltaMovement().add(0.0D, -0.04F * self().getAttributeValue(ForgeMod.SWIM_SPEED.get()), 0.0D));
	}

	/**
	 * STOP FLUID PUSHING
	 * 
	 * @author burnsqc
	 * 
	 * @reason cuz
	 * 
	 * @return
	 */
	@Override
	@Overwrite
	public boolean isSwimming() {
		TechnologicaAbilities diver = ((Player) (Object) this).getCapability(TechnologicaAbilities.DIVER_INSTANCE).orElse(null);
		boolean divercap = true;
		if (diver != null) {
			divercap = diver.getDiver();
		}
		return !((Player) (Object) this).getAbilities().flying && !((Player) (Object) this).isSpectator() && divercap && super.isSwimming();
	}
}
