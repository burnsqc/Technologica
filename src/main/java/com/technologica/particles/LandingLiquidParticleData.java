package com.technologica.particles;

import java.util.Locale;

import com.mojang.brigadier.StringReader;
import com.mojang.brigadier.exceptions.CommandSyntaxException;
import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;

import net.minecraft.network.PacketBuffer;
import net.minecraft.particles.IParticleData;
import net.minecraft.particles.ParticleType;
import net.minecraft.util.registry.Registry;

public class LandingLiquidParticleData implements IParticleData {

	public static final Codec<LandingLiquidParticleData> CODEC = RecordCodecBuilder.create((p_239803_0_) -> {
		return p_239803_0_.group(Codec.FLOAT.fieldOf("r").forGetter((p_239807_0_) -> {
			return p_239807_0_.red;
		}), Codec.FLOAT.fieldOf("g").forGetter((p_239806_0_) -> {
			return p_239806_0_.green;
		}), Codec.FLOAT.fieldOf("b").forGetter((p_239805_0_) -> {
			return p_239805_0_.blue;
		})).apply(p_239803_0_, LandingLiquidParticleData::new);
	});

	private final float red;
	private final float green;
	private final float blue;

	public LandingLiquidParticleData(float red, float green, float blue) {
		this.red = red;
		this.green = green;
		this.blue = blue;
	}

	public static final IParticleData.IDeserializer<LandingLiquidParticleData> DESERIALIZER = new IParticleData.IDeserializer<LandingLiquidParticleData>() {
		public LandingLiquidParticleData fromCommand(ParticleType<LandingLiquidParticleData> particleTypeIn, StringReader reader) throws CommandSyntaxException {
			reader.expect(' ');
			float f = (float) reader.readDouble();
			reader.expect(' ');
			float f1 = (float) reader.readDouble();
			reader.expect(' ');
			float f2 = (float) reader.readDouble();
			reader.expect(' ');
			return new LandingLiquidParticleData(f, f1, f2);
		}

		public LandingLiquidParticleData fromNetwork(ParticleType<LandingLiquidParticleData> particleTypeIn, PacketBuffer buffer) {
			return new LandingLiquidParticleData(buffer.readFloat(), buffer.readFloat(), buffer.readFloat());
		}
	};

	@Override
	public ParticleType<?> getType() {
		return TechnologicaParticleTypes.LANDING_FLUID.get();
	}

	@Override
	public void writeToNetwork(PacketBuffer buffer) {
		buffer.writeFloat(this.red);
		buffer.writeFloat(this.green);
		buffer.writeFloat(this.blue);
	}

	@SuppressWarnings("deprecation")
	@Override
	public String writeToString() {
		return String.format(Locale.ROOT, "%s %.2f %.2f %.2f", Registry.PARTICLE_TYPE.getKey(this.getType()), this.red, this.green, this.blue);
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

}
