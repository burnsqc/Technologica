package com.technologica.resourcegen.assets;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.technologica.util.text.TechnologicaLocation;
import com.tlregen.api.resourcegen.util.TLReGenPostShader;
import com.tlregen.api.resourcegen.util.TLReGenPostShader.Pass;

import net.minecraft.resources.ResourceLocation;

public class TLShadersPost {
	public static final Map<ResourceLocation, TLReGenPostShader> SHADERS_POST = new HashMap<ResourceLocation, TLReGenPostShader>();

	static {
		SHADERS_POST.put(new TechnologicaLocation("night_vision"), new TLReGenPostShader(List.of("swap"), List.of(new Pass("color_convolve", "minecraft:main", "swap", List.of(new Pass.Uniform("RedMatrix", 1.0F, 1.0F, 1.0F), new Pass.Uniform("GreenMatrix", 1.5F, 1.5F, 1.5F), new Pass.Uniform("BlueMatrix", 1.0F, 1.0F, 1.0F))), new Pass("bits", "swap", "minecraft:main", List.of(new Pass.Uniform("Resolution", 64.0F), new Pass.Uniform("MosaicSize", 2.5F))))));
	}
}
