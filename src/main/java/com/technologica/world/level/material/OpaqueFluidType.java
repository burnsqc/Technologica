package com.technologica.world.level.material;

import java.util.function.Consumer;

import org.jetbrains.annotations.Nullable;
import org.joml.Vector3f;

import com.mojang.blaze3d.shaders.FogShape;
import com.mojang.blaze3d.systems.RenderSystem;
import com.technologica.util.text.TechnologicaLocation;

import net.minecraft.client.Camera;
import net.minecraft.client.Minecraft;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.renderer.FogRenderer;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.client.extensions.common.IClientFluidTypeExtensions;
import net.minecraftforge.fluids.FluidType;

public class OpaqueFluidType extends FluidType {
	private int color;

	public OpaqueFluidType(Properties properties, int colorIn) {
		super(properties);
		color = colorIn;
	}

	@Override
	public void initializeClient(Consumer<IClientFluidTypeExtensions> consumer) {
		consumer.accept(new IClientFluidTypeExtensions() {
			private static final ResourceLocation UNDERWATER_LOCATION = new TechnologicaLocation("textures/misc/under_opaque_fluid.png"),
			OPAQUE_STILL = new TechnologicaLocation("block/opaque_fluid_still"), 
			OPAQUE_FLOW = new TechnologicaLocation("block/opaque_fluid_flow"),
			OPAQUE_OVERLAY = new TechnologicaLocation("block/opaque_fluid_overlay");

			@Override
			public int getTintColor() {
				return color;
			}
			
			@Override
			public ResourceLocation getStillTexture() {
				return OPAQUE_STILL;
			}

			@Override
			public ResourceLocation getFlowingTexture() {
				return OPAQUE_FLOW;
			}
			
			@Nullable
            @Override
            public ResourceLocation getOverlayTexture() {
                return OPAQUE_OVERLAY;
            }
			
			@Override
            public ResourceLocation getRenderOverlayTexture(Minecraft mc) {
                return UNDERWATER_LOCATION;
            }
			
			@Override
			public Vector3f modifyFogColor(Camera camera, float partialTick, ClientLevel level, int renderDistance, float darkenWorldAmount, Vector3f fluidFogColor) {
				Vector3f newFluidFogColor = new Vector3f(((color >> 16) & 0xFF) / 1000f, ((color >> 8) & 0xFF) / 1000f, ((color >> 0) & 0xFF) / 1000f);
				return newFluidFogColor;
		    }	
			
			@Override
			public void modifyFogRender(Camera camera, FogRenderer.FogMode mode, float renderDistance, float partialTick, float nearDistance, float farDistance, FogShape shape) {
				RenderSystem.setShaderFogStart(-64.0F);
		    }
			
		});
	}
}