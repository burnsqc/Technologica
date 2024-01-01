package com.technologica.world.level.material;

import java.util.function.Consumer;

import com.technologica.util.text.TechnologicaLocation;

import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.client.extensions.common.IClientFluidTypeExtensions;
import net.minecraftforge.fluids.FluidType;

public class MetalFluidType extends FluidType {
	private int color;

	public MetalFluidType(Properties properties, int colorIn) {
		super(properties);
		color = colorIn;
	}

	@Override
	public void initializeClient(Consumer<IClientFluidTypeExtensions> consumer) {
		consumer.accept(new IClientFluidTypeExtensions() {
			private static final ResourceLocation METAL_STILL = new TechnologicaLocation("block/metal_still"), METAL_FLOW = new TechnologicaLocation("block/metal_flow");

			@Override
			public int getTintColor() {
				return color;
			}

			@Override
			public ResourceLocation getStillTexture() {
				return METAL_STILL;
			}

			@Override
			public ResourceLocation getFlowingTexture() {
				return METAL_FLOW;
			}
		});
	}
}