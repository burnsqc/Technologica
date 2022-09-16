package com.technologica.world.level.material;

import static com.technologica.Technologica.MODID;

import java.util.function.Consumer;

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
			private static final ResourceLocation OPAQUE_STILL = new ResourceLocation(MODID, "block/opaque_fluid_still"), OPAQUE_FLOW = new ResourceLocation(MODID, "block/opaque_fluid_flow");

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
		});
	}
}