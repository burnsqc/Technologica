package com.technologica.client.renderer;

import com.mojang.blaze3d.vertex.DefaultVertexFormat;
import com.mojang.blaze3d.vertex.VertexFormat;
import com.mojang.blaze3d.vertex.VertexFormat.Mode;
import com.technologica.util.text.TechnologicaLocation;

import net.minecraft.client.renderer.RenderStateShard;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.resources.ResourceLocation;

public abstract class TechnologicaRenderType extends RenderType {
	private static final ResourceLocation EXCITATION_TEXTURE_LOCATION = new TechnologicaLocation("textures/misc/excitation_item_glint.png");
	private static final ResourceLocation IGNITION_TEXTURE_LOCATION = new TechnologicaLocation("textures/misc/ignition_item_glint.png");
	private static final ResourceLocation RADIATION_TEXTURE_LOCATION = new TechnologicaLocation("textures/misc/radioactive_item_glint.png");
	private static final ResourceLocation SUBMERSION_TEXTURE_LOCATION = new TechnologicaLocation("textures/misc/submersion_item_glint.png");
	private static final RenderType EXCITATION = RenderType.create("excitation", DefaultVertexFormat.POSITION_TEX, VertexFormat.Mode.QUADS, 256, false, false, RenderType.CompositeState.builder().setShaderState(RENDERTYPE_GLINT_DIRECT_SHADER).setTextureState(new RenderStateShard.TextureStateShard(EXCITATION_TEXTURE_LOCATION, true, false)).setWriteMaskState(COLOR_WRITE).setCullState(NO_CULL).setDepthTestState(EQUAL_DEPTH_TEST).setTransparencyState(TRANSLUCENT_TRANSPARENCY).setTexturingState(GLINT_TEXTURING).createCompositeState(false));
	private static final RenderType IGNITION = RenderType.create("ignition", DefaultVertexFormat.POSITION_TEX, VertexFormat.Mode.QUADS, 256, false, false, RenderType.CompositeState.builder().setShaderState(RENDERTYPE_GLINT_DIRECT_SHADER).setTextureState(new RenderStateShard.TextureStateShard(IGNITION_TEXTURE_LOCATION, true, false)).setWriteMaskState(COLOR_WRITE).setCullState(NO_CULL).setDepthTestState(EQUAL_DEPTH_TEST).setTransparencyState(TRANSLUCENT_TRANSPARENCY).setTexturingState(GLINT_TEXTURING).createCompositeState(false));
	private static final RenderType RADIATION = RenderType.create("radiation", DefaultVertexFormat.POSITION_TEX, VertexFormat.Mode.QUADS, 256, false, false, RenderType.CompositeState.builder().setShaderState(RENDERTYPE_GLINT_DIRECT_SHADER).setTextureState(new RenderStateShard.TextureStateShard(RADIATION_TEXTURE_LOCATION, true, false)).setWriteMaskState(COLOR_WRITE).setCullState(NO_CULL).setDepthTestState(EQUAL_DEPTH_TEST).setTransparencyState(TRANSLUCENT_TRANSPARENCY).setTexturingState(GLINT_TEXTURING).createCompositeState(false));
	private static final RenderType SUBMERSION = RenderType.create("submersion", DefaultVertexFormat.POSITION_TEX, VertexFormat.Mode.QUADS, 256, false, false, RenderType.CompositeState.builder().setShaderState(RENDERTYPE_GLINT_DIRECT_SHADER).setTextureState(new RenderStateShard.TextureStateShard(SUBMERSION_TEXTURE_LOCATION, true, false)).setWriteMaskState(COLOR_WRITE).setCullState(NO_CULL).setDepthTestState(EQUAL_DEPTH_TEST).setTransparencyState(TRANSLUCENT_TRANSPARENCY).setTexturingState(GLINT_TEXTURING).createCompositeState(false));

	public TechnologicaRenderType(String p_173178_, VertexFormat p_173179_, Mode p_173180_, int p_173181_, boolean p_173182_, boolean p_173183_, Runnable p_173184_, Runnable p_173185_) {
		super(p_173178_, p_173179_, p_173180_, p_173181_, p_173182_, p_173183_, p_173184_, p_173185_);
	}

	public static RenderType excitation() {
		return EXCITATION;
	}

	public static RenderType ignition() {
		return IGNITION;
	}

	public static RenderType radiation() {
		return RADIATION;
	}

	public static RenderType submersion() {
		return SUBMERSION;
	}
}
