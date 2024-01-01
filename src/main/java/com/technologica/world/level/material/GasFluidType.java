package com.technologica.world.level.material;

import java.util.function.Consumer;

import org.jetbrains.annotations.Nullable;
import org.joml.Vector3f;

import com.technologica.util.text.TechnologicaLocation;

import net.minecraft.client.Camera;
import net.minecraft.client.Minecraft;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.client.extensions.common.IClientFluidTypeExtensions;
import net.minecraftforge.fluids.FluidType;

public class GasFluidType extends FluidType {
	private int color;

	public GasFluidType(Properties properties, int colorIn) {
		super(properties);
		color = colorIn;
	}

	@Override
	public void initializeClient(Consumer<IClientFluidTypeExtensions> consumer) {
		consumer.accept(new IClientFluidTypeExtensions() {
			private static final ResourceLocation UNDERWATER_LOCATION = new TechnologicaLocation("textures/misc/under_fluid.png"),
			GAS_STILL = new ResourceLocation("block/water_still"), 
			GAS_FLOW = new ResourceLocation("block/water_flow"),
			GAS_OVERLAY = new ResourceLocation("block/water_overlay");

			@Override
			public int getTintColor() {
				return color;
			}
			
			@Override
			public ResourceLocation getStillTexture() {
				return GAS_STILL;
			}

			@Override
			public ResourceLocation getFlowingTexture() {
				return GAS_FLOW;
			}
			
			@Nullable
            @Override
            public ResourceLocation getOverlayTexture() {
                return GAS_OVERLAY;
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
		});
	}
}