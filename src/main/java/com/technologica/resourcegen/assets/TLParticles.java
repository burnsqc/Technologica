package com.technologica.resourcegen.assets;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.function.Supplier;
import java.util.stream.Stream;

import com.google.common.base.Preconditions;
import com.technologica.registration.deferred.TechnologicaParticleTypes;
import com.technologica.util.text.TechnologicaLocation;

import net.minecraft.core.particles.ParticleType;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.registries.ForgeRegistries;

public class TLParticles {
	public static final Map<ResourceLocation, List<String>> PARTICLES = new HashMap<>();

	static {
		sprite(TechnologicaParticleTypes.DRIPPING_BRINE, new ResourceLocation("drip_hang"));
		sprite(TechnologicaParticleTypes.FALLING_BRINE, new ResourceLocation("drip_fall"));
		spriteSet(TechnologicaParticleTypes.SPLASHING_BRINE, new TechnologicaLocation("splash"), 4, false);
		sprite(TechnologicaParticleTypes.SUBMERGED_BRINE, new ResourceLocation("generic_0"));
		sprite(TechnologicaParticleTypes.DRIPPING_BROMINE, new ResourceLocation("drip_hang"));
		sprite(TechnologicaParticleTypes.FALLING_BROMINE, new ResourceLocation("drip_fall"));
		spriteSet(TechnologicaParticleTypes.SPLASHING_BROMINE, new TechnologicaLocation("splash"), 4, false);
		sprite(TechnologicaParticleTypes.SUBMERGED_BROMINE, new ResourceLocation("generic_0"));
		sprite(TechnologicaParticleTypes.DRIPPING_COOLANT, new ResourceLocation("drip_hang"));
		sprite(TechnologicaParticleTypes.FALLING_COOLANT, new ResourceLocation("drip_fall"));
		spriteSet(TechnologicaParticleTypes.SPLASHING_COOLANT, new TechnologicaLocation("splash"), 4, false);
		sprite(TechnologicaParticleTypes.SUBMERGED_COOLANT, new ResourceLocation("generic_0"));
		sprite(TechnologicaParticleTypes.DRIPPING_GASOLINE, new ResourceLocation("drip_hang"));
		sprite(TechnologicaParticleTypes.FALLING_GASOLINE, new ResourceLocation("drip_fall"));
		spriteSet(TechnologicaParticleTypes.SPLASHING_GASOLINE, new TechnologicaLocation("splash"), 4, false);
		sprite(TechnologicaParticleTypes.SUBMERGED_GASOLINE, new ResourceLocation("generic_0"));
		sprite(TechnologicaParticleTypes.DRIPPING_MACHINE_OIL, new ResourceLocation("drip_hang"));
		sprite(TechnologicaParticleTypes.FALLING_MACHINE_OIL, new ResourceLocation("drip_fall"));
		spriteSet(TechnologicaParticleTypes.SPLASHING_MACHINE_OIL, new TechnologicaLocation("splash"), 4, false);
		sprite(TechnologicaParticleTypes.SUBMERGED_MACHINE_OIL, new ResourceLocation("generic_0"));
		sprite(TechnologicaParticleTypes.DRIPPING_MAPLE_SYRUP, new ResourceLocation("drip_hang"));
		sprite(TechnologicaParticleTypes.FALLING_MAPLE_SYRUP, new ResourceLocation("drip_fall"));
		sprite(TechnologicaParticleTypes.STICKING_MAPLE_SYRUP, new ResourceLocation("drip_land"));
		sprite(TechnologicaParticleTypes.SUBMERGED_MAPLE_SYRUP, new ResourceLocation("generic_0"));
		sprite(TechnologicaParticleTypes.DRIPPING_MERCURY, new ResourceLocation("drip_hang"));
		sprite(TechnologicaParticleTypes.FALLING_MERCURY, new ResourceLocation("drip_fall"));
		spriteSet(TechnologicaParticleTypes.SPLASHING_MERCURY, new TechnologicaLocation("splash"), 4, false);
		sprite(TechnologicaParticleTypes.SUBMERGED_MERCURY, new ResourceLocation("generic_0"));
		sprite(TechnologicaParticleTypes.DRIPPING_OIL, new ResourceLocation("drip_hang"));
		sprite(TechnologicaParticleTypes.FALLING_OIL, new ResourceLocation("drip_fall"));
		sprite(TechnologicaParticleTypes.STICKING_OIL, new ResourceLocation("drip_land"));
		sprite(TechnologicaParticleTypes.SUBMERGED_OIL, new ResourceLocation("generic_0"));
		sprite(TechnologicaParticleTypes.DRIPPING_RUBBER_RESIN, new ResourceLocation("drip_hang"));
		sprite(TechnologicaParticleTypes.FALLING_RUBBER_RESIN, new ResourceLocation("drip_fall"));
		sprite(TechnologicaParticleTypes.STICKING_RUBBER_RESIN, new ResourceLocation("drip_land"));
		sprite(TechnologicaParticleTypes.SUBMERGED_RUBBER_RESIN, new ResourceLocation("generic_0"));
		sprite(TechnologicaParticleTypes.FLYING_RADIATION, new ResourceLocation("drip_fall"));
		spriteSet(TechnologicaParticleTypes.SMOKE_COLUMN_UP, new ResourceLocation("generic"), 8, false);
	}

	protected final static void sprite(Supplier<? extends ParticleType<?>> type, ResourceLocation texture) {
		spriteSet(type.get(), texture);
	}

	protected final static void spriteSet(Supplier<? extends ParticleType<?>> type, ResourceLocation baseName, int numOfTextures, boolean reverse) {
		Preconditions.checkArgument(numOfTextures > 0, "The number of textures to generate must be positive");
		spriteSet(type.get(), () -> new Iterator<>() {
			private int counter = 0;

			@Override
			public boolean hasNext() {
				return counter < numOfTextures;
			}

			@Override
			public ResourceLocation next() {
				var texture = baseName.withSuffix("_" + (reverse ? numOfTextures - counter - 1 : counter));
				counter++;
				return texture;
			}
		});
	}

	private final static void spriteSet(ParticleType<?> type, ResourceLocation texture, ResourceLocation... textures) {
		spriteSet(type, Stream.concat(Stream.of(texture), Arrays.stream(textures))::iterator);
	}

	private final static void spriteSet(ParticleType<?> type, Iterable<ResourceLocation> textures) {
		var particle = Preconditions.checkNotNull(ForgeRegistries.PARTICLE_TYPES.getKey(type), "The particle type is not registered");

		List<String> desc = new ArrayList<>();
		for (var texture : textures) {
			desc.add(texture.toString());
		}
		Preconditions.checkArgument(desc.size() > 0, "The particle type '%s' must have one texture", particle);

		if (PARTICLES.putIfAbsent(particle, desc) != null) {
			throw new IllegalArgumentException(String.format("The particle type '%s' already has a description associated with it", particle));
		}
	}
}
