package com.technologica.mixin;

import java.util.function.Consumer;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import com.mojang.datafixers.util.Pair;
import com.technologica.Technologica;
import com.technologica.registration.dynamic.TechnologicaBiomes;
import com.technologica.util.InitializationWorkaround;

import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.Climate;
import net.minecraft.world.level.biome.OverworldBiomeBuilder;

@Mixin(OverworldBiomeBuilder.class)
public class MixinOverworldBiomeBuilder {

	@Inject(method = "addHighSlice(Ljava/util/function/Consumer;Lnet/minecraft/world/level/biome/Climate/Parameter;)V", at = @At("TAIL"))
	private void technologicaAddMidSlice(Consumer<Pair<Climate.ParameterPoint, ResourceKey<Biome>>> consumer, Climate.Parameter parameter, CallbackInfo ci) {
		this.addSurfaceBiome(consumer, 
				InitializationWorkaround.temperatures[3], 
				InitializationWorkaround.FULL_RANGE, 
				InitializationWorkaround.midInlandContinentalness, 
				InitializationWorkaround.erosions[4], 
				InitializationWorkaround.FULL_RANGE, 
				0.0F, 
				TechnologicaBiomes.REDWOOD_FOREST);
		Technologica.LOGGER.info("TECHNOLOGICA BIOMES ADDED TO OVERWORLD");
	}

	private void addSurfaceBiome(Consumer<Pair<Climate.ParameterPoint, ResourceKey<Biome>>> consumer, Climate.Parameter temperature, Climate.Parameter humidity, Climate.Parameter continentalness, Climate.Parameter erosion, Climate.Parameter weirdness, float offset, ResourceKey<Biome> biome) {
		consumer.accept(Pair.of(Climate.parameters(temperature, humidity, continentalness, erosion, Climate.Parameter.point(0.0F), weirdness, offset), biome));
		consumer.accept(Pair.of(Climate.parameters(temperature, humidity, continentalness, erosion, Climate.Parameter.point(1.0F), weirdness, offset), biome));
	}
}
