package com.technologica.particles;

import java.util.Locale;

import com.mojang.brigadier.StringReader;
import com.mojang.brigadier.exceptions.CommandSyntaxException;
import com.mojang.serialization.Codec;
import com.technologica.util.color.ColorHelper;

import net.minecraft.core.Registry;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.core.particles.ParticleType;
import net.minecraft.network.FriendlyByteBuf;

public class UniversalLiquidParticleType extends ParticleType<UniversalLiquidParticleType> implements ParticleOptions {
	private final float red;
	private final float green;
	private final float blue;
	
	@SuppressWarnings("deprecation")
	private static final Deserializer<UniversalLiquidParticleType> DESERIALIZER = new ParticleOptions.Deserializer<UniversalLiquidParticleType>() {
		public UniversalLiquidParticleType fromCommand(ParticleType<UniversalLiquidParticleType> particleTypeIn, StringReader reader) throws CommandSyntaxException {
			return (UniversalLiquidParticleType) particleTypeIn;
		}

		public UniversalLiquidParticleType fromNetwork(ParticleType<UniversalLiquidParticleType> particleTypeIn, FriendlyByteBuf buffer) {
			return (UniversalLiquidParticleType) particleTypeIn;
		}
	};

	public UniversalLiquidParticleType(boolean alwaysShowIn, int fluidColorIn) {
		super(alwaysShowIn, DESERIALIZER);
		red = ColorHelper.intToRed(fluidColorIn);
		green = ColorHelper.intToGreen(fluidColorIn);
		blue = ColorHelper.intToBlue(fluidColorIn);
	}

	@Override
	public ParticleType<?> getType() {
		return this;
	}

	public float getRed() {
		return red;
	}
	
	public float getGreen() {
		return green;
	}
	
	public float getBlue() {
		return blue;
	}
	
	@Override
	public void writeToNetwork(FriendlyByteBuf buffer) {
		buffer.writeFloat(this.red);
		buffer.writeFloat(this.green);
		buffer.writeFloat(this.blue);
	}

	@SuppressWarnings("deprecation")
	@Override
	public String writeToString() {
		return String.format(Locale.ROOT, "%s %.2f %.2f %.2f", Registry.PARTICLE_TYPE.getKey(this.getType()), this.red, this.green, this.blue);
	}

	@Override
	public Codec<UniversalLiquidParticleType> codec() {
		return null;
	}

}
