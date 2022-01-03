package com.technologica.particles;

import java.util.Locale;

import com.mojang.brigadier.StringReader;
import com.mojang.brigadier.exceptions.CommandSyntaxException;
import com.mojang.serialization.Codec;
import com.technologica.util.color.ColorHelper;

import net.minecraft.network.PacketBuffer;
import net.minecraft.particles.IParticleData;
import net.minecraft.particles.ParticleType;
import net.minecraft.util.registry.Registry;

public class UniversalLiquidParticleType extends ParticleType<UniversalLiquidParticleType> implements IParticleData {
	private final float red;
	private final float green;
	private final float blue;
	
	@SuppressWarnings("deprecation")
	private static final IDeserializer<UniversalLiquidParticleType> DESERIALIZER = new IParticleData.IDeserializer<UniversalLiquidParticleType>() {
		public UniversalLiquidParticleType deserialize(ParticleType<UniversalLiquidParticleType> particleTypeIn, StringReader reader) throws CommandSyntaxException {
			return (UniversalLiquidParticleType) particleTypeIn;
		}

		public UniversalLiquidParticleType read(ParticleType<UniversalLiquidParticleType> particleTypeIn, PacketBuffer buffer) {
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
	public void write(PacketBuffer buffer) {
		buffer.writeFloat(this.red);
		buffer.writeFloat(this.green);
		buffer.writeFloat(this.blue);
	}

	@SuppressWarnings("deprecation")
	@Override
	public String getParameters() {
		return String.format(Locale.ROOT, "%s %.2f %.2f %.2f", Registry.PARTICLE_TYPE.getKey(this.getType()), this.red, this.green, this.blue);
	}

	@Override
	public Codec<UniversalLiquidParticleType> func_230522_e_() {
		return null;
	}

}
