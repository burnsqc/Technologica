package com.technologica.core.particles;

import java.util.Locale;

import com.mojang.brigadier.StringReader;
import com.mojang.brigadier.exceptions.CommandSyntaxException;
import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;

import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.core.particles.ParticleType;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.FriendlyByteBuf;

public class FlyingRadiationParticleData implements ParticleOptions {
	public static final FlyingRadiationParticleData RADIATION = new FlyingRadiationParticleData(0.0F, 0.75F, 1.0F);

	public static final Codec<FlyingRadiationParticleData> CODEC = RecordCodecBuilder.create((p_239803_0_) -> {
		return p_239803_0_.group(Codec.FLOAT.fieldOf("r").forGetter((p_239807_0_) -> {
			return p_239807_0_.red;
		}), Codec.FLOAT.fieldOf("g").forGetter((p_239806_0_) -> {
			return p_239806_0_.green;
		}), Codec.FLOAT.fieldOf("b").forGetter((p_239805_0_) -> {
			return p_239805_0_.blue;
		})).apply(p_239803_0_, FlyingRadiationParticleData::new);
	});

	private final float red;
	private final float green;
	private final float blue;

	public FlyingRadiationParticleData(float red, float green, float blue) {
		this.red = red;
		this.green = green;
		this.blue = blue;
	}

	@SuppressWarnings("deprecation")
	public static final ParticleOptions.Deserializer<FlyingRadiationParticleData> DESERIALIZER = new ParticleOptions.Deserializer<FlyingRadiationParticleData>() {
		@Override
		public FlyingRadiationParticleData fromCommand(ParticleType<FlyingRadiationParticleData> particleTypeIn, StringReader reader) throws CommandSyntaxException {
			reader.expect(' ');
			float f = (float) reader.readDouble();
			reader.expect(' ');
			float f1 = (float) reader.readDouble();
			reader.expect(' ');
			float f2 = (float) reader.readDouble();
			reader.expect(' ');
			return new FlyingRadiationParticleData(f, f1, f2);
		}

		@Override
		public FlyingRadiationParticleData fromNetwork(ParticleType<FlyingRadiationParticleData> particleTypeIn, FriendlyByteBuf buffer) {
			return new FlyingRadiationParticleData(buffer.readFloat(), buffer.readFloat(), buffer.readFloat());
		}
	};

	@Override
	public ParticleType<?> getType() {
		return TechnologicaParticleTypes.FLYING_RADIATION.get();
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
		return String.format(Locale.ROOT, "%s %.2f %.2f %.2f", BuiltInRegistries.PARTICLE_TYPE.getKey(this.getType()), this.red, this.green, this.blue);
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
