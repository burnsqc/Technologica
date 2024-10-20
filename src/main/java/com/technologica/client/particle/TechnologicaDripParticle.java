package com.technologica.client.particle;

import com.technologica.registration.deferred.TechnologicaFluids;
import com.technologica.registration.deferred.TechnologicaParticleTypes;

import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.particle.DripParticle;
import net.minecraft.client.particle.ParticleRenderType;
import net.minecraft.client.particle.TextureSheetParticle;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluids;

/**
 * <p>This class contains the necessary logic to effectively extend {@link DripParticle} for additional fluids.</p>
 * 
 * @tl.status GREEN
 */
public class TechnologicaDripParticle extends TextureSheetParticle {
	private final Fluid fluid;
	protected boolean isGlowing;

	TechnologicaDripParticle(ClientLevel clientLevel, double posX, double posY, double posZ, Fluid fluid) {
		super(clientLevel, posX, posY, posZ);
		this.setSize(0.01F, 0.01F);
		this.gravity = 0.06F;
		this.fluid = fluid;
	}

	protected Fluid getType() {
		return this.fluid;
	}

	@Override
	public ParticleRenderType getRenderType() {
		return ParticleRenderType.PARTICLE_SHEET_OPAQUE;
	}

	@Override
	public int getLightColor(float partialTick) {
		return this.isGlowing ? 240 : super.getLightColor(partialTick);
	}

	@Override
	public void tick() {
		this.xo = this.x;
		this.yo = this.y;
		this.zo = this.z;
		this.preMoveUpdate();
		if (!this.removed) {
			this.yd -= this.gravity;
			this.move(this.xd, this.yd, this.zd);
			this.postMoveUpdate();
			if (!this.removed) {
				this.xd *= 0.98F;
				this.yd *= 0.98F;
				this.zd *= 0.98F;
				if (this.fluid != Fluids.EMPTY) {
					BlockPos blockpos = BlockPos.containing(this.x, this.y, this.z);
					FluidState fluidstate = this.level.getFluidState(blockpos);
					if (fluidstate.getType() == this.fluid && this.y < blockpos.getY() + fluidstate.getHeight(this.level, blockpos)) {
						this.remove();
					}

				}
			}
		}
	}

	protected void preMoveUpdate() {
		if (this.lifetime-- <= 0) {
			this.remove();
		}

	}

	protected void postMoveUpdate() {
	}

	public static TextureSheetParticle createBrineHangParticle(SimpleParticleType simpleParticleType, ClientLevel clientLevel, double posX, double posY, double posZ, double p_272880_, double p_273725_, double p_273051_) {
		TechnologicaDripParticle dripparticle = new TechnologicaDripParticle.HangThenFallParticle(clientLevel, posX, posY, posZ, TechnologicaFluids.BRINE.get(), TechnologicaParticleTypes.FALLING_BRINE.get());
		dripparticle.setColor(0.66667F, 0.86275F, 1.00000F);
		return dripparticle;
	}

	public static TextureSheetParticle createBromineHangParticle(SimpleParticleType simpleParticleType, ClientLevel clientLevel, double posX, double posY, double posZ, double p_272880_, double p_273725_, double p_273051_) {
		TechnologicaDripParticle dripparticle = new TechnologicaDripParticle.HangThenFallParticle(clientLevel, posX, posY, posZ, TechnologicaFluids.BROMINE.get(), TechnologicaParticleTypes.FALLING_BROMINE.get());
		dripparticle.setColor(0.66667F, 0.21960F, 0.07450F);
		return dripparticle;
	}

	public static TextureSheetParticle createCoolantHangParticle(SimpleParticleType simpleParticleType, ClientLevel clientLevel, double posX, double posY, double posZ, double p_272880_, double p_273725_, double p_273051_) {
		TechnologicaDripParticle dripparticle = new TechnologicaDripParticle.HangThenFallParticle(clientLevel, posX, posY, posZ, TechnologicaFluids.COOLANT.get(), TechnologicaParticleTypes.FALLING_COOLANT.get());
		dripparticle.setColor(0.74901F, 0.96862F, 0.32941F);
		return dripparticle;
	}

	public static TextureSheetParticle createGasolineHangParticle(SimpleParticleType simpleParticleType, ClientLevel clientLevel, double posX, double posY, double posZ, double p_272880_, double p_273725_, double p_273051_) {
		TechnologicaDripParticle dripparticle = new TechnologicaDripParticle.HangThenFallParticle(clientLevel, posX, posY, posZ, TechnologicaFluids.GASOLINE.get(), TechnologicaParticleTypes.FALLING_GASOLINE.get());
		dripparticle.setColor(0.83137F, 0.76078F, 0.41176F);
		return dripparticle;
	}

	public static TextureSheetParticle createMachineOilHangParticle(SimpleParticleType simpleParticleType, ClientLevel clientLevel, double posX, double posY, double posZ, double p_272880_, double p_273725_, double p_273051_) {
		TechnologicaDripParticle dripparticle = new TechnologicaDripParticle.HangThenFallParticle(clientLevel, posX, posY, posZ, TechnologicaFluids.MACHINE_OIL.get(), TechnologicaParticleTypes.FALLING_MACHINE_OIL.get());
		dripparticle.setColor(1.00000F, 1.00000F, 0.58823F);
		return dripparticle;
	}

	public static TextureSheetParticle createMapleSyrupHangParticle(SimpleParticleType simpleParticleType, ClientLevel clientLevel, double posX, double posY, double posZ, double p_272880_, double p_273725_, double p_273051_) {
		TechnologicaDripParticle dripparticle = new TechnologicaDripParticle.HangThenFallParticle(clientLevel, posX, posY, posZ, TechnologicaFluids.MAPLE_SYRUP.get(), TechnologicaParticleTypes.FALLING_MAPLE_SYRUP.get());
		dripparticle.setColor(0.35294F, 0.16863F, 0.09412F);
		return dripparticle;
	}

	public static TextureSheetParticle createMercuryHangParticle(SimpleParticleType simpleParticleType, ClientLevel clientLevel, double posX, double posY, double posZ, double p_272880_, double p_273725_, double p_273051_) {
		TechnologicaDripParticle dripparticle = new TechnologicaDripParticle.HangThenFallParticle(clientLevel, posX, posY, posZ, TechnologicaFluids.MERCURY.get(), TechnologicaParticleTypes.FALLING_MERCURY.get());
		dripparticle.setColor(0.88235F, 0.88235F, 0.88235F);
		return dripparticle;
	}

	public static TextureSheetParticle createOilHangParticle(SimpleParticleType simpleParticleType, ClientLevel clientLevel, double posX, double posY, double posZ, double p_272880_, double p_273725_, double p_273051_) {
		TechnologicaDripParticle dripparticle = new TechnologicaDripParticle.HangThenFallParticle(clientLevel, posX, posY, posZ, TechnologicaFluids.OIL.get(), TechnologicaParticleTypes.FALLING_OIL.get());
		dripparticle.setColor(0.19607F, 0.19607F, 0.19607F);
		return dripparticle;
	}

	public static TextureSheetParticle createRubberResinHangParticle(SimpleParticleType simpleParticleType, ClientLevel clientLevel, double posX, double posY, double posZ, double p_272880_, double p_273725_, double p_273051_) {
		TechnologicaDripParticle dripparticle = new TechnologicaDripParticle.HangThenFallParticle(clientLevel, posX, posY, posZ, TechnologicaFluids.RUBBER_RESIN.get(), TechnologicaParticleTypes.FALLING_RUBBER_RESIN.get());
		dripparticle.setColor(0.94118F, 0.94118F, 0.81569F);
		return dripparticle;
	}

	public static TextureSheetParticle createBrineFallParticle(SimpleParticleType simpleParticleType, ClientLevel clientLevel, double posX, double posY, double posZ, double p_273177_, double p_273537_, double p_272846_) {
		TechnologicaDripParticle dripparticle = new TechnologicaDripParticle.FallThenLandParticle(clientLevel, posX, posY, posZ, TechnologicaFluids.BRINE.get(), TechnologicaParticleTypes.SPLASHING_BRINE.get());
		dripparticle.setColor(0.66667F, 0.86275F, 1.00000F);
		return dripparticle;
	}

	public static TextureSheetParticle createBromineFallParticle(SimpleParticleType simpleParticleType, ClientLevel clientLevel, double posX, double posY, double posZ, double p_273177_, double p_273537_, double p_272846_) {
		TechnologicaDripParticle dripparticle = new TechnologicaDripParticle.FallThenLandParticle(clientLevel, posX, posY, posZ, TechnologicaFluids.BROMINE.get(), TechnologicaParticleTypes.SPLASHING_BROMINE.get());
		dripparticle.setColor(0.66667F, 0.21960F, 0.07450F);
		return dripparticle;
	}

	public static TextureSheetParticle createCoolantFallParticle(SimpleParticleType simpleParticleType, ClientLevel clientLevel, double posX, double posY, double posZ, double p_273177_, double p_273537_, double p_272846_) {
		TechnologicaDripParticle dripparticle = new TechnologicaDripParticle.FallThenLandParticle(clientLevel, posX, posY, posZ, TechnologicaFluids.COOLANT.get(), TechnologicaParticleTypes.SPLASHING_COOLANT.get());
		dripparticle.setColor(0.74901F, 0.96862F, 0.32941F);
		return dripparticle;
	}

	public static TextureSheetParticle createGasolineFallParticle(SimpleParticleType simpleParticleType, ClientLevel clientLevel, double posX, double posY, double posZ, double p_273177_, double p_273537_, double p_272846_) {
		TechnologicaDripParticle dripparticle = new TechnologicaDripParticle.FallThenLandParticle(clientLevel, posX, posY, posZ, TechnologicaFluids.GASOLINE.get(), TechnologicaParticleTypes.SPLASHING_GASOLINE.get());
		dripparticle.setColor(0.83137F, 0.76078F, 0.41176F);
		return dripparticle;
	}

	public static TextureSheetParticle createMachineOilFallParticle(SimpleParticleType simpleParticleType, ClientLevel clientLevel, double posX, double posY, double posZ, double p_273177_, double p_273537_, double p_272846_) {
		TechnologicaDripParticle dripparticle = new TechnologicaDripParticle.FallThenLandParticle(clientLevel, posX, posY, posZ, TechnologicaFluids.MACHINE_OIL.get(), TechnologicaParticleTypes.SPLASHING_MACHINE_OIL.get());
		dripparticle.setColor(1.00000F, 1.00000F, 0.58823F);
		return dripparticle;
	}

	public static TextureSheetParticle createMapleSyrupFallParticle(SimpleParticleType simpleParticleType, ClientLevel clientLevel, double posX, double posY, double posZ, double p_273177_, double p_273537_, double p_272846_) {
		TechnologicaDripParticle dripparticle = new TechnologicaDripParticle.FallThenLandParticle(clientLevel, posX, posY, posZ, TechnologicaFluids.MAPLE_SYRUP.get(), TechnologicaParticleTypes.STICKING_MAPLE_SYRUP.get());
		dripparticle.setColor(0.35294F, 0.16863F, 0.09412F);
		return dripparticle;
	}

	public static TextureSheetParticle createMercuryFallParticle(SimpleParticleType simpleParticleType, ClientLevel clientLevel, double posX, double posY, double posZ, double p_273177_, double p_273537_, double p_272846_) {
		TechnologicaDripParticle dripparticle = new TechnologicaDripParticle.FallThenLandParticle(clientLevel, posX, posY, posZ, TechnologicaFluids.MERCURY.get(), TechnologicaParticleTypes.SPLASHING_MERCURY.get());
		dripparticle.setColor(0.88235F, 0.88235F, 0.88235F);
		return dripparticle;
	}

	public static TextureSheetParticle createOilFallParticle(SimpleParticleType simpleParticleType, ClientLevel clientLevel, double posX, double posY, double posZ, double p_273177_, double p_273537_, double p_272846_) {
		TechnologicaDripParticle dripparticle = new TechnologicaDripParticle.FallThenLandParticle(clientLevel, posX, posY, posZ, TechnologicaFluids.OIL.get(), TechnologicaParticleTypes.STICKING_OIL.get());
		dripparticle.setColor(0.19607F, 0.19607F, 0.19607F);
		return dripparticle;
	}

	public static TextureSheetParticle createRubberResinFallParticle(SimpleParticleType simpleParticleType, ClientLevel clientLevel, double posX, double posY, double posZ, double p_273177_, double p_273537_, double p_272846_) {
		TechnologicaDripParticle dripparticle = new TechnologicaDripParticle.FallThenLandParticle(clientLevel, posX, posY, posZ, TechnologicaFluids.RUBBER_RESIN.get(), TechnologicaParticleTypes.STICKING_RUBBER_RESIN.get());
		dripparticle.setColor(0.94118F, 0.94118F, 0.81569F);
		return dripparticle;
	}

	public static TextureSheetParticle createMapleSyrupStickParticle(SimpleParticleType simpleParticleType, ClientLevel clientLevel, double posX, double posY, double posZ, double p_273614_, double p_273085_, double p_273097_) {
		TechnologicaDripParticle dripparticle = new TechnologicaDripParticle.StickingParticle(clientLevel, posX, posY, posZ, TechnologicaFluids.MAPLE_SYRUP.get());
		dripparticle.lifetime = (int) (128.0D / (Math.random() * 0.8D + 0.2D));
		dripparticle.setColor(0.35294F, 0.16863F, 0.09412F);
		return dripparticle;
	}

	public static TextureSheetParticle createOilStickParticle(SimpleParticleType simpleParticleType, ClientLevel clientLevel, double posX, double posY, double posZ, double p_273614_, double p_273085_, double p_273097_) {
		TechnologicaDripParticle dripparticle = new TechnologicaDripParticle.StickingParticle(clientLevel, posX, posY, posZ, TechnologicaFluids.OIL.get());
		dripparticle.lifetime = (int) (128.0D / (Math.random() * 0.8D + 0.2D));
		dripparticle.setColor(0.19607F, 0.19607F, 0.19607F);
		return dripparticle;
	}

	public static TextureSheetParticle createRubberResinStickParticle(SimpleParticleType simpleParticleType, ClientLevel clientLevel, double posX, double posY, double posZ, double p_273614_, double p_273085_, double p_273097_) {
		TechnologicaDripParticle dripparticle = new TechnologicaDripParticle.StickingParticle(clientLevel, posX, posY, posZ, TechnologicaFluids.RUBBER_RESIN.get());
		dripparticle.lifetime = (int) (128.0D / (Math.random() * 0.8D + 0.2D));
		dripparticle.setColor(0.94118F, 0.94118F, 0.81569F);
		return dripparticle;
	}

	static class HangThenFallParticle extends TechnologicaDripParticle {
		private final ParticleOptions fallingParticle;

		HangThenFallParticle(ClientLevel clientLevel, double posX, double posY, double posZ, Fluid fluid, ParticleOptions particleOptions) {
			super(clientLevel, posX, posY, posZ, fluid);
			this.fallingParticle = particleOptions;
			this.gravity *= 0.02F;
			this.lifetime = 40;
		}

		@Override
		protected void preMoveUpdate() {
			if (this.lifetime-- <= 0) {
				this.remove();
				this.level.addParticle(this.fallingParticle, this.x, this.y, this.z, this.xd, this.yd, this.zd);
			}
		}

		@Override
		protected void postMoveUpdate() {
			this.xd *= 0.02D;
			this.yd *= 0.02D;
			this.zd *= 0.02D;
		}
	}

	static class FallThenLandParticle extends TechnologicaDripParticle.FallingParticle {
		protected final ParticleOptions landingParticle;

		FallThenLandParticle(ClientLevel clientLevel, double posX, double posY, double posZ, Fluid fluid, ParticleOptions landParticle) {
			super(clientLevel, posX, posY, posZ, fluid);
			this.landingParticle = landParticle;
		}

		@Override
		protected void postMoveUpdate() {
			if (this.onGround) {
				this.remove();
				this.level.addParticle(this.landingParticle, this.x, this.y, this.z, 0.0D, 0.0D, 0.0D);
			}

		}
	}

	static class FallingParticle extends TechnologicaDripParticle {
		FallingParticle(ClientLevel clientLevel, double posX, double posY, double posZ, Fluid fluid) {
			this(clientLevel, posX, posY, posZ, fluid, (int) (64.0D / (Math.random() * 0.8D + 0.2D)));
		}

		FallingParticle(ClientLevel clientLevel, double posX, double posY, double posZ, Fluid fluid, int lifetime) {
			super(clientLevel, posX, posY, posZ, fluid);
			this.lifetime = lifetime;
		}

		@Override
		protected void postMoveUpdate() {
			if (this.onGround) {
				this.remove();
			}
		}
	}

	static class StickingParticle extends TechnologicaDripParticle {
		StickingParticle(ClientLevel clientLevel, double posX, double posY, double posZ, Fluid fluid) {
			super(clientLevel, posX, posY, posZ, fluid);
			this.lifetime = (int) (16.0D / (Math.random() * 0.8D + 0.2D));
		}
	}
}