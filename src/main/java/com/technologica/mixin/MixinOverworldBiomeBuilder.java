package com.technologica.mixin;

import java.util.function.Consumer;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import com.mojang.datafixers.util.Pair;
import com.technologica.Technologica;

import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.Climate;
import net.minecraft.world.level.biome.OverworldBiomeBuilder;

@Mixin(OverworldBiomeBuilder.class)
public class MixinOverworldBiomeBuilder {

	@Inject(method = "addBiomes(Ljava/util/function/Consumer;)V", at = @At("TAIL"))
	private void technologicaAddBiomes(Consumer<Pair<Climate.ParameterPoint, ResourceKey<Biome>>> consumer, CallbackInfo ci) {
		// this.addSurfaceBiome(consumer, Climate.Parameter.span(InitializationWorkaround.temperatures[3], InitializationWorkaround.temperatures[4]), InitializationWorkaround.FULL_RANGE, InitializationWorkaround.midInlandContinentalness, InitializationWorkaround.erosions[6], Climate.Parameter.span(0.26666668F, 0.4F), 0.0F, TechnologicaBiomes.REDWOOD_FOREST);
		Technologica.LOGGER.info("TECHNOLOGICA BIOMES ADDED TO OVERWORLD");
	}

	private void addSurfaceBiome(Consumer<Pair<Climate.ParameterPoint, ResourceKey<Biome>>> consumer, Climate.Parameter temperature, Climate.Parameter humidity, Climate.Parameter continentalness, Climate.Parameter erosion, Climate.Parameter weirdness, float offset, ResourceKey<Biome> biome) {
		consumer.accept(Pair.of(Climate.parameters(temperature, humidity, continentalness, erosion, Climate.Parameter.point(0.0F), weirdness, offset), biome));
		consumer.accept(Pair.of(Climate.parameters(temperature, humidity, continentalness, erosion, Climate.Parameter.point(1.0F), weirdness, offset), biome));
	}
}
