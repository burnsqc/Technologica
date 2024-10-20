package com.technologica.client.renderer;

import java.util.SortedMap;

import com.mojang.blaze3d.vertex.BufferBuilder;

import it.unimi.dsi.fastutil.objects.Object2ObjectLinkedOpenHashMap;
import net.minecraft.Util;
import net.minecraft.client.renderer.RenderType;

public class TechnologicaRenderBuffers {
	public static final SortedMap<RenderType, BufferBuilder> FIXED_BUFFERS = Util.make(new Object2ObjectLinkedOpenHashMap<>(), (p_269658_) -> {
		p_269658_.put(TechnologicaRenderType.excitation(), new BufferBuilder(TechnologicaRenderType.excitation().bufferSize()));
		p_269658_.put(TechnologicaRenderType.ignition(), new BufferBuilder(TechnologicaRenderType.ignition().bufferSize()));
		p_269658_.put(TechnologicaRenderType.radiation(), new BufferBuilder(TechnologicaRenderType.radiation().bufferSize()));
		p_269658_.put(TechnologicaRenderType.submersion(), new BufferBuilder(TechnologicaRenderType.submersion().bufferSize()));
	});
}
