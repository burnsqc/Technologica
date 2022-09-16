package com.technologica.world.level.material;

import java.util.function.Consumer;

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
			private static final ResourceLocation GAS_STILL = new ResourceLocation("block/water_still"), GAS_FLOW = new ResourceLocation("block/water_flow");

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
		});
	}
}