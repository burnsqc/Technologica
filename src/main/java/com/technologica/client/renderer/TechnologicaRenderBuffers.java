package com.technologica.client.renderer;

import java.util.HashMap;
import java.util.Map;

import com.mojang.blaze3d.vertex.BufferBuilder;

import net.minecraft.client.renderer.RenderType;

public class TechnologicaRenderBuffers {
	public static final Map<RenderType, BufferBuilder> RENDER_BUFFERS = new HashMap<RenderType, BufferBuilder>();

	static {
		RENDER_BUFFERS.put(TechnologicaRenderType.EXCITATION, new BufferBuilder(TechnologicaRenderType.EXCITATION.bufferSize()));
		RENDER_BUFFERS.put(TechnologicaRenderType.IGNITION, new BufferBuilder(TechnologicaRenderType.IGNITION.bufferSize()));
		RENDER_BUFFERS.put(TechnologicaRenderType.RADIATION, new BufferBuilder(TechnologicaRenderType.RADIATION.bufferSize()));
		RENDER_BUFFERS.put(TechnologicaRenderType.SUBMERSION, new BufferBuilder(TechnologicaRenderType.SUBMERSION.bufferSize()));
	}
}
