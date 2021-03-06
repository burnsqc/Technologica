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

public class DrippingLiquidParticleData implements IParticleData {
	public static final DrippingLiquidParticleData BROMINE = new DrippingLiquidParticleData(0.66667F, 0.21960F, 0.07450F);
	public static final DrippingLiquidParticleData MERCURY = new DrippingLiquidParticleData(0.88235F, 0.88235F, 0.88235F);
	public static final DrippingLiquidParticleData BRINE = new DrippingLiquidParticleData(0.66667F, 0.86275F, 1.00000F);
	public static final DrippingLiquidParticleData OIL = new DrippingLiquidParticleData(0.19607F, 0.19607F, 0.19607F);
	public static final DrippingLiquidParticleData MAPLE_SYRUP = new DrippingLiquidParticleData(0.35294F, 0.16863F, 0.09412F);
	public static final DrippingLiquidParticleData RUBBER_RESIN = new DrippingLiquidParticleData(0.94118F, 0.94118F, 0.81569F);
	public static final DrippingLiquidParticleData GASOLINE = new DrippingLiquidParticleData(0.83137F, 0.76078F, 0.41176F);
	public static final DrippingLiquidParticleData MACHINE_OIL = new DrippingLiquidParticleData(1.00000F, 1.00000F, 0.58823F);
	public static final DrippingLiquidParticleData COOLANT = new DrippingLiquidParticleData(0.74901F, 0.96862F, 0.32941F);

	public static final Codec<DrippingLiquidParticleData> field_239802_b_ = RecordCodecBuilder.create((p_239803_0_) -> {
		return p_239803_0_.group(Codec.FLOAT.fieldOf("r").forGetter((p_239807_0_) -> {
			return p_239807_0_.red;
		}), Codec.FLOAT.fieldOf("g").forGetter((p_239806_0_) -> {
			return p_239806_0_.green;
		}), Codec.FLOAT.fieldOf("b").forGetter((p_239805_0_) -> {
			return p_239805_0_.blue;
		})).apply(p_239803_0_, DrippingLiquidParticleData::new);
	});

	private final float red;
	private final float green;
	private final float blue;

	public DrippingLiquidParticleData(float red, float green, float blue) {
		this.red = red;
		this.green = green;
		this.blue = blue;
	}

	@SuppressWarnings("deprecation")
	public static final IParticleData.IDeserializer<DrippingLiquidParticleData> DESERIALIZER = new IParticleData.IDeserializer<DrippingLiquidParticleData>() {
		public DrippingLiquidParticleData deserialize(ParticleType<DrippingLiquidParticleData> particleTypeIn, StringReader reader) throws CommandSyntaxException {
			reader.expect(' ');
			float f = (float) reader.readDouble();
			reader.expect(' ');
			float f1 = (float) reader.readDouble();
			reader.expect(' ');
			float f2 = (float) reader.readDouble();
			reader.expect(' ');
			return new DrippingLiquidParticleData(f, f1, f2);
		}

		public DrippingLiquidParticleData read(ParticleType<DrippingLiquidParticleData> particleTypeIn, PacketBuffer buffer) {
			return new DrippingLiquidParticleData(buffer.readFloat(), buffer.readFloat(), buffer.readFloat());
		}
	};

	@Override
	public ParticleType<?> getType() {
		return TechnologicaParticleTypes.DRIPPING_FLUID.get();
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
